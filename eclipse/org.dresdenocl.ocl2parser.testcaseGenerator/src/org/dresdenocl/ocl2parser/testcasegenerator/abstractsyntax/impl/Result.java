/*
    Copyright (C) 2008  Nils (s0006383@inf.tu-dresden.de)

    This file is part of the testcase generator for OCL parser of the Dresden OCL2 for Eclipse.

    The testcase generator is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The testcase generator is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with the testcase generator.  If not, see <http://www.gnu.org/licenses/>.
.
*/
package org.dresdenocl.ocl2parser.testcasegenerator.abstractsyntax.impl;

import org.dresdenocl.ocl2parser.testcasegenerator.abstractsyntax.IModelNode;
import org.dresdenocl.ocl2parser.testcasegenerator.abstractsyntax.IResult;
import org.dresdenocl.ocl2parser.testcasegenerator.abstractsyntax.ITokenAS;
import org.dresdenocl.ocl2parser.testcasegenerator.util.BuildingASMException;
import org.dresdenocl.ocl2parser.testcasegenerator.util.Environment;

public abstract class Result implements IResult {
	private ITokenAS token;
	
	public Result(ITokenAS token) {
		this.token = token;
	}
	
	public Result() {
		
	}
	
	//abstract public void computeVariables(Environment env) throws BuildingASMException;
	
	public ITokenAS getToken() {
		return token;
	}
	
	public void setToken(ITokenAS token) {
		this.token = token;
	}
}
