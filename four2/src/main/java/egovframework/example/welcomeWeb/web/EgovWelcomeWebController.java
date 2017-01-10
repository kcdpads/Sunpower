package egovframework.example.welcomeWeb.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.example.jqgridTable.web.EgovJqgridController;
import egovframework.example.welcomeWeb.service.WelcomeWebService;

//메소드들을 포함하는 블럭
@Controller
public class EgovWelcomeWebController {

	@Resource(name = "welcomeWebService")
	private WelcomeWebService welcomeWebService;
	
	@Resource(name = "egovJqgridController")
	private EgovJqgridController egovJqgridController;
	
	/**
	 * 웰컴 웰컴 이동한다.
	 * @return String
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/welcomeWeb.do")
	public String welcomeWeb(ModelMap model) throws Exception {
		//modelMap은 view페이지로 값을 전달하기 위한 역할
		//어떤 작업을 처리하는 실행문들을 모아놓은 블럭
		
		/*Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("signTrgNo", request.getParameter("signTrgNo"));*/
		
//		EgovJqgridController egocontroll = new EgovJqgridController();
		
		egovJqgridController.aaa();
		
		List<Map> welcomeWebList = welcomeWebService.selectWelcomeWebServiceList();
		
		System.out.println(welcomeWebList);
		
		List<Map> pieChartList = welcomeWebService.selectPieChartList();
		
		System.out.println(pieChartList);
		
		model.addAttribute("welcomeWebList", 	welcomeWebList);
		model.addAttribute("pieChartList", 		pieChartList);
		
		return "welcomeWeb/welcomeWeb.tiles";
	}

}
