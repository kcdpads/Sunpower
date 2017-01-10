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
package egovframework.example.jqgridTable.service;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;

public interface JqgridService {

	List<?> selectJqgridList(JqgridVO jqgridVO) throws Exception;

	List<?> selectJstlList(JqgridVO jqgridVO) throws Exception;

	EgovMap selectJqgridListCnt(JqgridVO jqgridVO) throws Exception;

	void updateJqgridTx(JqgridVO jqgridVO) throws Exception;

}
