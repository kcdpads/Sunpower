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
package egovframework.example.jqgridTable.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.antlr.grammar.v3.ANTLRParser.throwsSpec_return;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egovframework.example.jqgridTable.service.JqgridService;
import egovframework.example.jqgridTable.service.JqgridVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.psl.dataaccess.util.EgovMap;

@Service("jqgridService")
public class JqgridServiceImpl extends EgovAbstractServiceImpl implements JqgridService {

	private static final Logger LOGGER = LoggerFactory.getLogger(JqgridServiceImpl.class);

	@Resource(name="jqgridMapper")
	private JqgridMapper jqgridDAO;
	
	@Override
	public List<?> selectJqgridList(JqgridVO jqgridVO) throws Exception {

		return jqgridDAO.selectJqgridList(jqgridVO);
	}

	@Override
	public List<?> selectJstlList(JqgridVO jqgridVO) throws Exception {
	
		return jqgridDAO.selectJstlList(jqgridVO);
	}

	@Override
	public EgovMap selectJqgridListCnt(JqgridVO jqgridVO) throws Exception {

		return jqgridDAO.selectJqgridListCnt(jqgridVO);
	}

	@Override
	public void updateJqgridTx(JqgridVO jqgridVO) throws Exception {

		jqgridDAO.updateJqgrid(jqgridVO);
		jqgridDAO.updateJqgrid2(jqgridVO);
		
		
	}
}