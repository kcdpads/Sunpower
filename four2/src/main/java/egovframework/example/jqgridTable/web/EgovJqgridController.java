/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.jqgridTable.web;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.cmmn.JsonUtil;
import egovframework.example.jqgridTable.service.JqgridService;
import egovframework.example.jqgridTable.service.JqgridVO;
import egovframework.rte.psl.dataaccess.util.EgovMap;

// 메소드들을 포함하는 블럭
@Controller
public class EgovJqgridController {

	@Resource(name = "jqgridService")
	private JqgridService jqgridService;
	
	/**
	 * 메인화면으로 이동한다.
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/main.do")
	public String selectSampleList() throws Exception {

		//어떤 작업을 처리하는 실행문들을 모아놓은 블럭
		return "main/main.tiles";
	}
	
	/**
	 * jqgrid 화면 호출하면서 jstl로 조회
	 * @param jqgridVO
	 * @param model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/jqgridP.do")
	public String jqgridP(JqgridVO jqgridVO, ModelMap model, HttpServletRequest request) throws Exception {
		
		System.out.println(jqgridVO.getParam1());
		
		System.out.println(request.getParameter("param1"));
		
		System.out.println("11");
		
		List<?> jstlList = jqgridService.selectJstlList(jqgridVO);
		
		model.addAttribute("jstlList", 	jstlList);
		
		return "jqgridTable/jqgridTable";
	}
	
	public void aaa() {
		
		System.out.println("sssss");
	}
	
	/**
	 * 
	 * @param jqgridVO
	 * @param model
	 * @return ModelAndView
	 * @throws Exception
	 */
	@RequestMapping(value = "/jqgridPZero.do")
	public ModelAndView jqgridPZero(JqgridVO jqgridVO) throws Exception {
		
		ModelAndView mav = new ModelAndView("jqgridTable/jqgridTable");
		
		List<?> jstlList = jqgridService.selectJstlList(jqgridVO);
		
		mav.addObject("jstlList", jstlList);
		
		return mav;
	}
	
	/**
	 * tiles jqgrid 화면 호출하면서 jstl로 조회
	 * @param jqgridVO
	 * @param model
	 * @return String
	 * @throws Exception
	 */
	@RequestMapping(value = "/jqgridP2.do")
	public String jqgridP2(JqgridVO jqgridVO, ModelMap model) throws Exception {
		
		List<?> jstlList = jqgridService.selectJstlList(jqgridVO);

		model.addAttribute("jstlList", 	jstlList);
		
		return "jqgridTable/jqgridTable2.tiles";
	}

	/**
	 * jqgird 조회
	 * @param jqgridVO
	 * @param request
	 * @param response
	 * @param model
	 * @throws Exception
	 */
	@RequestMapping(value = "/jqgridTable.do")
	public void jqgridTable(JqgridVO jqgridVO, HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute ModelMap model) throws Exception {

		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");

		List<?> jqGridList = jqgridService.selectJqgridList(jqgridVO);
		
		EgovMap jqGridListCnt = jqgridService.selectJqgridListCnt(jqgridVO);

		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("records", jqGridListCnt.get("totalTotCnt"));            
        resMap.put("rows",    jqGridList);
        resMap.put("page",    request.getParameter("page"));
        resMap.put("total",   jqGridListCnt.get("totalPage"));
		
		out = response.getWriter();

		out.write(JsonUtil.HashMapToJson(resMap).toString());
	}
	
	@RequestMapping(value = "/jqgridTable2.do")
	public void jqgridTable2(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute JqgridVO jqgridVO, ModelMap model) throws Exception {

		PrintWriter out = null;
		response.setCharacterEncoding("UTF-8");

		String quotZero = request.getParameter("param");
		
		quotZero = quotZero.replaceAll("&quot;", "\"");
		
		Map<String, Object> castMap = new HashMap<String, Object>();
		
		castMap = JsonUtil.JsonToMap(quotZero);
		
		jqgridVO.setServiceImplYn((String) castMap.get("serviceImplYn"));

		List<?> jqGridList = jqgridService.selectJqgridList(jqgridVO);
		
		EgovMap jqGridListCnt = jqgridService.selectJqgridListCnt(jqgridVO);

		HashMap<String, Object> resMap = new HashMap<String, Object>();
		
		resMap.put("records", jqGridListCnt.get("totalTotCnt"));            
        resMap.put("rows",    jqGridList);
        resMap.put("page",    request.getParameter("page"));
        resMap.put("total",   jqGridListCnt.get("totalPage"));
		
		out = response.getWriter();

		out.write(JsonUtil.HashMapToJson(resMap).toString());
	}
	
	@RequestMapping(value = "/jqgridEdit.do")
	public @ResponseBody String jqgridEdit(@ModelAttribute JqgridVO jqgridVO) {
		
		try {
			
			jqgridService.updateJqgridTx(jqgridVO);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return "SUCCESS";
	}
	
}
