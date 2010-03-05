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

package tudresden.ocl20.pivot.ocl22java.test.aspectj.standardlibrary;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import testpackage.Class1;
import tudresden.ocl20.pivot.ocl2java.types.OclSequence;

/**
 * <p>
 * Tests generated code for boolean operations of the OCL Standard Library.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestSequence {

	/**
	 * <p>
	 * Tests the generated code for the method <code>Sequence.reverse()</code> .
	 * </p>
	 */
	@Test
	public void testReverse01() {

		Class1 class1;
		class1 = new Class1();

		OclSequence<Object> oclSequence01;
		oclSequence01 = new OclSequence<Object>();
		oclSequence01.add("1");
		oclSequence01.add("2");
		oclSequence01.add("3");

		OclSequence<Object> oclSequence02;
		oclSequence02 = new OclSequence<Object>();
		oclSequence02.add("3");
		oclSequence02.add("2");
		oclSequence02.add("1");

		assertEquals(oclSequence02, class1.testSequenceReverse(oclSequence01));
	}
}