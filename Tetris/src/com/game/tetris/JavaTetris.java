package com.game.tetris;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

class Square			
{
	int x, y, c;

	Square(int x, int y, int c)			// 피스생성의 최소단위인 사각형 생성
	{
		this.x = x;
		this.y = y;
		this.c = c;
	}
		
	boolean InBounds()					// 경계값 체크
	{
		return ( x >= 0 && x < JavaTetris.cols && y >= 0 && y < JavaTetris.rows );
	}

	boolean IsEqual(Square s)			// 쌓여있는 피스의 경계값 체크
	{
		return x == s.x && y == s.y && c == s.c;
	}
}

public class JavaTetris extends Frame implements Runnable, ActionListener
{
	MenuBar mb;
	Menu game, help;
	MenuItem start, end, helpItem;
	Image logo;

	Dialog di, helpDi;
	Label diLabel1, diLabel2;
	TextField field;
	String name;
	Button btn;
	
	static int sqlength = 17;			// 피스 최소단위 조각의 크기							
	static final int xoffset = 120;		// 검은색으로 채워지는 배경의 시작점				
	static int cols = 10;				// 배경의 가로범위				
	static int rows = 20;				// 배경의 세로범위
	int f[][];											
	int what = (int) (Math.random()*7);	// 피스를 만드는 경우의 수
	int what2;							// 미리보기 피스의 경우의 수
	static Square curpiece[] = new Square[4];	
	static Square newpiece[] = new Square[4];
	boolean lost;									
	boolean neednewpiece = true;							
	Thread killme = null;								
	Color colors[];										
	int curval, score = 0;				// 피스당 점수와 총점을 초기화				
	int level;							
	int removeline;							
	
	public JavaTetris()                                              
	{
		super("막강 2팀 테트리스 v1.0");
		Toolkit tk = Toolkit.getDefaultToolkit();
		logo = tk.getImage("tetris_icon.gif");
		setIconImage(logo);
		setLayout(null);
		 
		mb = new MenuBar();
		setMenuBar(mb);

		game = new Menu("게임");
		mb.add(game);

		help = new Menu("Help");
		mb.setHelpMenu(help);

		start = new MenuItem("시작");
		start.addActionListener(this);
		game.add(start);

		end = new MenuItem("종료");
		end.addActionListener(this);
		game.add(end);

		helpItem = new MenuItem("도움말");
		helpItem.addActionListener(this);
		help.add(helpItem);

		helpDi = new Dialog(this,"help", true);			// 도움말 다이얼로그
		helpDi.setLayout(new FlowLayout());
		helpDi.addWindowListener(new WinDiaHandler());	
		helpDi.resize(400, 100);

		diLabel1=new Label("방향키 ( →:오른족, ←:왼쪽, ↑:회전, ↓:아래쪽 )");
		helpDi.add(diLabel1);
		diLabel2=new Label("점수는 한조각당10~20점이며 라인을 한줄없앨때마다 50점씩 추가된다 ");
		helpDi.add(diLabel2);

		addKeyListener(new KeyHandler());
		addWindowListener(new WindowHandler());
			 
		setVisible(true);
				
		f = new int[cols][rows + 4];					

		setSize(xoffset+sqlength*cols+30, sqlength*(rows+4));		// 구현되는 프레임의 사이즈 설정
																
		colors = new Color[8];					// 색설정 부분
		colors[0] = new Color(40,40,40);		// 검은색

		colors[1] = new Color(255,0,0);			// 빨간색
		colors[2] = new Color(0,255,0);			// 초록색
		colors[3] = new Color(0,200,255);		// 노란색
		colors[4] = new Color(255,255,0);		// 하늘색
		colors[5] = new Color(255,150,0);		// 황토색
		colors[6] = new Color(210,0,240);		// 보라색
		colors[7] = new Color(40,0,240);		// 파란색	
	}
	
		public void start()
		{
			for(int i=0; i< cols; i++)
			{
				for(int j=0; j< rows+4; j++)
				{
					f[i][j] = 0;			// 초기배경을 검은색으로 설정
				}
			}

			level = 3;						// 각 변수초기화		
			score = 0;								
			removeline = 0;							
			curval = -1;							
			neednewpiece = true;					
			lost= false;							
			repaint();
			(killme = new Thread(this)).start();	// 쓰레드 호출
			requestFocus();							// 마우스 포커스 요청하여 시작상태를 알림
		}
	
		public synchronized void stop()	
		{
			if(killme != null)
			killme.stop();
			killme = null;
		}
	
		public void run()
		{
			while (!lost)
			{
				int tim=level;
				try
				{
					if(neednewpiece)
					{
						tim=100;
						Thread.sleep(tim);
					}
					Thread.sleep(1000/tim);	// 쓰레드를 이용한 속도 조절
				}
				catch (InterruptedException e){	}

				if (neednewpiece)					
				{
					if (curval > 0)					
					{
						level = 3 + removeline/10;	// 레벨 상승 조절(삭제되는 라인기준)
					}
					removelines();				
					newpiece();	
					score += curval;
					what = (int) (Math.random()*7);
					neednewpiece = false;		
				}
				else
				{				
					neednewpiece = !movecurpiece(0,-1,false);	// 실제로 쓰레드를 아래로 이동
				}
			repaint();							
		}
		killme = null;				// 쓰레드 생성을 종료

		di = new Dialog(this,"축하합니다.", true);		// 점수등록 다이얼로그 생성
		di.setLayout(new FlowLayout());
		di.add(new Label("이름:"));
		field = new TextField("", 10);
		field.addActionListener(this);
		btn = new Button("등록");
		btn.addActionListener(this);
		di.add(field);
		di.add(new Label(Integer.toString(score))); 
		di.add(btn);
		di.addWindowListener(new WinDiaHandler());
		di.resize(300, 100);
		di.show();
	}

	private void newpiece()			// 새피스 생성 부분
	{
		Square old[] = new Square[4];	// 피스를 생성을 위한 디폴트 조각 구성
		old[0]  = old[1] = old[2] = old[3] = new Square(-1, -1, 0);

		int m = cols/2;
		
		what2 = what;				// 미리보기에서 보여준 피스를 게임에 이용되는 피스에 적용
		switch (what2)
		{
		case 0:
			//  ㅁㅁmㅁ
			curval = 10;			// 피스당 점수
			curpiece[0] = new Square(m  , rows-1, 1);		// 0번 배열은 기준 조각
			curpiece[1] = new Square(m-1, rows-1, 1);
			curpiece[2] = new Square(m+1, rows-1, 1);
			curpiece[3] = new Square(m+2, rows-1, 1);
			break;
		case 1:
			//   ㅁmㅁ
			//     m
			curval = 15;
			curpiece[0] = new Square(m  , rows-1, 2);
			curpiece[1] = new Square(m-1, rows-1, 2);
			curpiece[2] = new Square(m  , rows-2, 2);
			curpiece[3] = new Square(m+1, rows-1, 2); 
			break;
		case 2:
			//    mㅁ
			//  ㅁm
			curval = 20;
			curpiece[0] = new Square(m  , rows-2, 3 );
			curpiece[1] = new Square(m-1, rows-2, 3);
			curpiece[2] = new Square(m  , rows-1, 3);
			curpiece[3] = new Square(m+1, rows-1, 3);
			break;
		case 3:
			// ㅁm
			//   mㅁ
			curval = 20;
			curpiece[0] = new Square( m  , rows-2, 4);
			curpiece[1] = new Square( m+1, rows-2, 4);
			curpiece[2] = new Square( m-1, rows-1, 4);
			curpiece[3] = new Square( m  , rows-1, 4);
			break;
		case 4:
			//  ㅁm
			//  ㅁm
			curval = 10;
			curpiece[0] = new Square( m-1, rows-2, 5);
			curpiece[1] = new Square( m  , rows-2, 5);
			curpiece[2] = new Square( m-1, rows-1, 5);
			curpiece[3] = new Square( m  , rows-1, 5);
			break;
		case 5:
			//    ㅁ
			// ㅁmㅁ
			curval = 15;
			curpiece[0] = new Square( m  , rows-2, 6);
			curpiece[1] = new Square( m-1, rows-2, 6);
			curpiece[2] = new Square( m+1, rows-2, 6);
			curpiece[3] = new Square( m+1, rows-1, 6);
			break;
		case 6:
			// ㅁ
			// ㅁmㅁ
			curval = 15;
			curpiece[0] = new Square( m  , rows-2, 7);
			curpiece[1] = new Square( m-1, rows-2, 7);
			curpiece[2] = new Square( m+1, rows-2, 7);
			curpiece[3] = new Square( m-1, rows-1, 7);
			break;
		}
		lost = !movepiece(old, curpiece);		// 피스가 다쌓여서 움직일 수 없으면 게임을 종료되게 함	
	}

	public synchronized void paint(Graphics g)
	{
		try{
		g.setFont(new java.awt.Font("impact",10, 16));		// 게임의 상태를 보여주는 글자들을 생성하는 부분
		int gx = sqlength;							     	
		int gy = sqlength*rows/4;						
		
		g.clearRect(gx, gy-25, xoffset-20, 200);			// 게임정보를 변경하기 위해서 지워주는 부분
					
		g.drawString("Score: " + score, gx, gy);			
		g.drawString("Removeline: " + removeline, gx, gy+30);
		g.drawString("Level: " + level, gx, gy + 60);
		g.drawString("Next: ", gx, gy + 90);


		switch (what)			// 미리보기 피스
		{
		case 0:
			//  ㅁㅁmㅁ
			g.setColor(colors[1]);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*3, gy+120 + sqlength*1, sqlength, sqlength, true);
			
			break;
		case 1:
			//   ㅁmㅁ4
			//      m
			g.setColor(colors[2]);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			break;
		case 2:
			//    mㅁ
			//  ㅁm
			g.setColor(colors[3]);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*0, sqlength, sqlength, true);
			break;
		case 3:
			// ㅁm
			//   mㅁ
			g.setColor(colors[4]);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*0, sqlength, sqlength, true);
			break;
		case 4:
			//  mㅁ
			//  mㅁ
			g.setColor(colors[5]);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			break;
		case 5:
			//    ㅁ
			// ㅁmㅁ
			g.setColor(colors[6]);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*1, sqlength, sqlength, true);
			break;
		case 6:
			// ㅁ
			// ㅁmㅁ
			g.setColor(colors[7]);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*0, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*0, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*1, gy+120 + sqlength*1, sqlength, sqlength, true);
			g.fill3DRect(gx+sqlength*2, gy+120 + sqlength*1, sqlength, sqlength, true);
			break;
		}

		for(int i =0; i<cols; i++)			// 배경에 피스모양대로 색을 페인팅
		{
			for (int j = 0; j<rows; j++)				  
			{
				g.setColor(colors[f[i][rows-1-j]]);    
				g.fill3DRect(xoffset+sqlength*i, 3*sqlength + sqlength*j, sqlength, sqlength, true);
			}
		}
		}catch(Exception e)	{ repaint(); }
	}

	public synchronized void update(Graphics g)
	{
		paint(g);										
	}
		
	private synchronized boolean movecurpiece(int byx, int byy, boolean rotate)		
	{
		Square newpos[] = new Square[4]; 
		
		for(int i =0; i<4; i++)
		{
			if (rotate)		// 피스의 회전 부분
			{
				if(what2!=0)		
				{
					int dx = curpiece[i].x - curpiece[0].x;
					int dy = curpiece[i].y - curpiece[0].y;
					newpos[i] = new Square(curpiece[0].x - dy, curpiece[0].y + dx, curpiece[i].c);
				}
				else
				{
					int dx = curpiece[i].x - curpiece[0].x;
					int dy = curpiece[i].y - curpiece[0].y;
					newpos[i] = new Square(curpiece[0].x + dy,curpiece[0].y - dx, curpiece[i].c);
				}
			}
			else		// 회전없이 바로 아래로 이동
			{
				newpos[i] = new Square(curpiece[i].x + byx, curpiece[i].y + byy, curpiece[i].c);
			}
		}	
		
		if(!movepiece(curpiece, newpos))			// 현재 피스와 다음 피스의 이동 가능성을 체크
			return false;											
		
		curpiece = newpos;	// 현재 피스를 이동된 피스로 변경								
		return true;
	}
	
	private boolean movepiece(Square  from[], Square to[])
	{
		outerlabel:
		for(int i=0; i < to.length; i++)				
		{
			if (!to[i].InBounds())			// 경계값 체크
			{
				return false;
			}
			
			if (f[to[i].x][to[i].y] != 0 )		// 쌓인 블록과 겹치는가를 체크
			{
				for(int j=0; j<from.length; j++)
				{
					if (to[i].IsEqual(from[j]))
					{
						continue outerlabel;
					}
				}
				return false;
			}
		}
		
		for (int i=0; i<from.length; i++)			// 이동전의 블록을 지움
		{
			if (from[i].InBounds())					
			{
				f[from[i].x][from[i].y] = 0;
			}												
		}	
		
		for(int i=0; i<to.length; i++)		// 이동한 블록의 색을 필드에 채움
		{
			f[to[i].x][to[i].y] = to[i].c;
		}
		return true;											
	}	
			
	private void removelines()
	{
		outerlabel:
			for(int j=0; j<rows; j++)
			{
				for(int i=0; i<cols; i++)
				{
					if(f[i][j] == 0)		// 쌓여진 블록중에 비워진 부분이 있으면
					{
						continue outerlabel;
					}
				}
				for(int k=j; k< rows-1; k++)	// 쌓여진 블록에서 라인이 다 채워져 있을 경우
				{
					for(int i=0; i<cols; i++)
					{
						f[i][k] = f[i][k + 1];
					}
				}
				j--;			// 실질적인 라인 삭제
				removeline++;
				score += 50;
			}
	}
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource() == end)		// 메뉴의 선택을 통한 종료 
		{
			setVisible(false);
			dispose();
			System.exit(0);
		}
		else if(e.getSource() == start)		// 메뉴의 선택을 통한 시작
		{
			start();
		}
		else if((e.getSource() == btn) || (e.getSource() == field))		// 다이얼로그창에서 버튼 클릭 및 엔터키 입력
		{
			di.hide();
			name = field.getText();
			FileMake.fileWrite(name, score);
			FileMake.fileRead();
		}
		else if(e.getSource() == helpItem)		// 메뉴에서 도움말을 선택해서 보여주는 부분
		{
			helpDi.show();
		}
	}
	
	class KeyHandler extends KeyAdapter
	{
		public void keyPressed(KeyEvent e)
		{
			switch (e.getKeyCode())	
			{
			case  37:								// <-  
				movecurpiece(-1, 0, false);			//x 좌표를 왼쪽으로 -1 만큼 움직임.
				neednewpiece = false;				//새 피스는 필요업고,
				repaint();							//update 요청
				break;
			
		
			case 39:								//->
				movecurpiece(1, 0, false);			//x 좌표를 오른쪽으로 +1 이동
				neednewpiece = false;
				repaint();
				break;
			
		
			case 38:								//rotate
				if(!neednewpiece && what2 != 4)
				{									//현좌표를 유지한 상태에서 rotate
					movecurpiece(0,0,true);
					repaint();
					neednewpiece = false;
				}
				break;
			case 32:	//스페이스바
			case 40:   	// ↓  
				while(movecurpiece(0,-1,false));
				repaint();
				break;
			}
		}
	}
	 
	class WindowHandler extends WindowAdapter		// 프로그램 닫기 버튼 이벤트핸들러
	{
		public void windowClosing(WindowEvent e)
		{
			Window w = e.getWindow();
			w.setVisible(false);
			w.dispose();
			System.exit(0);
		}
	}
		
	class WinDiaHandler extends WindowAdapter		// 다이얼로그 닫기 버튼 이벤트 핸들러
	{
		public void windowClosing(WindowEvent e)
		{
			Window w = e.getWindow();
			w.setVisible(false);
			w.dispose();
		}
	};

	public static void main(String args[])
	{
		new JavaTetris();
	}
} 	

class FileMake 
{
	public static void fileWrite(String name, int score)		// 파일저장 
	{
		try
		{		
			DataOutputStream out = new DataOutputStream(new FileOutputStream("input.txt", true));	

			out.writeBytes(name+score+"\n");
            out.flush();
			out.close();
		}catch(Exception e){ }
	}

	public static void fileRead()			// 파일에서 데이터를 읽어오는 부분
	{
		try
		{		
			BufferedReader in = new BufferedReader (new InputStreamReader(new FileInputStream("input.txt")));
			String s;
			
			do
			{
				s = in.readLine();
				System.out.println(s);
			}while(s!=null);
			in.close();
		}catch(Exception e){ }
	}
};

