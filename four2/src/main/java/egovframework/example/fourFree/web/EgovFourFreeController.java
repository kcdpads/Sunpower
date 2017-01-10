package egovframework.example.fourFree.web;

import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.cmmn.JsonUtil;

@Controller
public class EgovFourFreeController {

	@RequestMapping(value = "/fourFree.do")
	public String samJuInit(ModelMap model) throws Exception {
		
		return "four/fourFree.tiles";
	}
	
	@RequestMapping(value = "/extendFour.do")
	public void extendFour(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		PrintWriter out = null;
		
		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		//한글 깨짐방지
		response.setCharacterEncoding("UTF-8");
		
		try {

			resMap.put("result",    true);
			
			out = response.getWriter();
			
			out.write(JsonUtil.HashMapToJson(resMap).toString());
		} catch (Exception e) {

			System.out.println(e);
		}
	}
}
