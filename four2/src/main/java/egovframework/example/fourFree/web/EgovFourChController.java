package egovframework.example.fourFree.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EgovFourChController {

	@RequestMapping(value = "/fourCh.do")
	public String samJuInit(ModelMap model) throws Exception {
		
		return "four/fourCh.tiles2";
	}
	
	@RequestMapping(value = "/fourCh2.do")
	public String samJuInit2(ModelMap model) throws Exception {
		
		return "four/fourCh2.tiles";
	}
	
	@RequestMapping(value = "/fourCh2Start.do")
	public void fourCh2Start(HttpServletRequest request, ModelMap model) throws Exception {
		
		System.out.println(request.getServerName());
		System.out.println(request.getServerPort());
		System.out.println(request.getRequestURI());
	}
	
	@RequestMapping(value = "/requestParamTest.do")
	public void requestParamTest(HttpServletRequest request, ModelMap model) throws Exception {
		
		System.out.println(request.getParameter("name"));
		String[] arr = request.getParameterValues("hanq");
		
		for(int i = 0; i < arr.length; i++) {
			
			System.out.println(arr[i]);
		};
	}
}



