/*
 * Copyright (C) 2008-2010 by Claas Wilke (claas.wilke@tu-dresden.de)
 *
 * This file is part of the OCL2Java Code Generator of Dresden OCL.
 *
 * Dresden OCL is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation, either version 3 of the License, or (at your option)
 * any later version.
 *
 * Dresden OCL is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along 
 * with Dresden OCL. If not, see <http://www.gnu.org/licenses/>.
 */
package org.dresdenocl.tools.codegen.ocl2java;

import org.dresdenocl.model.IModel;
import org.dresdenocl.tools.codegen.code.ITransformedCode;
import org.dresdenocl.tools.codegen.code.impl.TransformedCodeImpl;
import org.dresdenocl.tools.codegen.exception.Ocl2CodeException;
import org.dresdenocl.tools.codegen.ocl2java.internal.Ocl2Java;
import org.dresdenocl.tools.codegen.ocl2java.internal.Ocl2JavaSettings;

/**
 * <p>
 * This class provides methods to create Java code generators for code
 * generation from loaded {@link IModel}s.
 * </p>
 * 
 * @author Claas Wilke
 */
public class Ocl2JavaFactory {

	private static Ocl2JavaFactory myInstance;

	/**
	 * @return The only instance of {@link Ocl2JavaFactory}.
	 */
	public static Ocl2JavaFactory getInstance() {

		if (myInstance == null) {
			myInstance = new Ocl2JavaFactory();
		}
		// no else.

		return myInstance;
	}

	/**
	 * <p>
	 * A private constructor to enforce the Singleton.
	 * </p>
	 */
	private Ocl2JavaFactory() {
	
		/* Remains empty. */
	}

	/**
	 * <p>
	 * Creates an {@link IOcl2Java} code generator.
	 * </p>
	 * 
	 * @return A code generator which generates Java code for loaded OCL
	 *         expressions.
	 * @throws Ocl22CodeException
	 *           Thrown if the initialization of a new Java code generator fails.
	 */
	public IOcl2Java createJavaCodeGenerator() throws Ocl2CodeException {

		IOcl2Java result;

		result = new Ocl2Java();

		return result;
	}

	/**
	 * <p>
	 * Creates an {@link IOcl2Java} code generator with given
	 * {@link IOcl22CodeSettings}.
	 * </p>
	 * 
	 * @return A code generator which generates Java code for loaded OCL
	 *         expressions.
	 * @throws Ocl22CodeException
	 *           Thrown if the initialization of a new Java code generator fails.
	 */
	public IOcl2Java createJavaCodeGenerator(IOcl2JavaSettings settings)
			throws Ocl2CodeException {

		IOcl2Java result;

		result = new Ocl2Java();
		result.setSettings(settings);

		return result;
	}

	/**
	 * <p>
	 * Creates {@link IOcl22CodeSettings} that can be used to configure a Java
	 * code generator.
	 * </p>
	 * 
	 * @return {@link IOcl22CodeSettings} that can be used to configure a Java
	 *         code generator.
	 */
	public IOcl2JavaSettings createJavaCodeGeneratorSettings() {

		IOcl2JavaSettings result;

		result = new Ocl2JavaSettings();

		return result;
	}

	/**
	 * @return An {@link ITransformedCode} which does not contain any code.
	 */
	public ITransformedCode createTransformedCode() {

		ITransformedCode result;

		result = new TransformedCodeImpl();

		return result;
	}
}