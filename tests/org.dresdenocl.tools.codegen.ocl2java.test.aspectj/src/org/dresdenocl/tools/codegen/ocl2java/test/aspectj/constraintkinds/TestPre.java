/*
Copyright (C) 2010 by Claas Wilke (claaswilke@gmx.net)

This file is part of the OCL 2 Java Code Generator of Dresden OCL2 for Eclipse.

Dresden OCL2 for Eclipse is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL2 for Eclipse is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL2 for Eclipse. If not, see <http://www.gnu.org/licenses/>.
 */

package org.dresdenocl.tools.codegen.ocl2java.test.aspectj.constraintkinds;

import org.junit.Test;

import testpackage.Class1;

/**
 * <p>
 * Tests the generated code for a <code>Constraint</code> of the
 * <code>ConstraintKind.PRECONDITION</code>.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestPre {

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.PRECONDITION</code>.
	 * </p>
	 */
	@Test
	public void testPre01_01() {

		Class1 class1;
		class1 = new Class1();

		/* Should be accepted. */
		class1.preOperation01(42);
	}

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.PRECONDITION</code>.
	 * </p>
	 */
	@Test(expected = RuntimeException.class)
	public void testPre01_02() {

		Class1 class1;
		class1 = new Class1();

		/* Should be rejected. */
		class1.preOperation01(null);
	}

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.PRECONDITION</code>.
	 * </p>
	 */
	@Test
	public void testPre02_01() {

		/* Should be accepted. */
		new Class1(42);
	}

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.PRECONDITION</code>.
	 * </p>
	 */
	@Test(expected = RuntimeException.class)
	public void testPre02_02() {

		/* Should be rejected. */
		new Class1(null);
	}
	
	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.PRECONDITION</code>.
	 * </p>
	 */
	@Test
	public void testStaticPre01_01() {

		/* Should be accepted. */
		Class1.staticPreOperation01(42);
	}

	/**
	 * <p>
	 * Tests the generated code for a <code>Constraint</code> of the
	 * <code>ConstraintKind.PRECONDITION</code>.
	 * </p>
	 */
	@Test(expected = RuntimeException.class)
	public void testStaticPre01_02() {

		/* Should be rejected. */
		Class1.staticPreOperation01(null);
	}
}