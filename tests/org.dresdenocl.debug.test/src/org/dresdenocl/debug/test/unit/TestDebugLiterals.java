package org.dresdenocl.debug.test.unit;

import java.io.File;

import org.dresdenocl.debug.OclDebugger;
import org.dresdenocl.debug.test.AbstractDebuggerTest;
import org.dresdenocl.debug.test.CallStackConstants;
import org.dresdenocl.debug.test.DebugTestPlugin;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Contains test cases testing the debugging of operations defined on the String
 * type.
 * 
 * @author Claas Wilke
 */
public class TestDebugLiterals extends AbstractDebuggerTest {

	@BeforeClass
	public static void setUp() throws Exception {

		AbstractDebuggerTest.setUp();
	}

	@Test
	public void testBooleanLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/boolean01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at boolean literal 'true'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.BOOLEAN_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after boolean literal 'true'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.BOOLEAN_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Ignore
	@Test
	public void testBooleanLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/boolean01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at boolean literal 'true'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.BOOLEAN_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after boolean literal 'true'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.BOOLEAN_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Ignore
	@Test
	public void testBooleanLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/boolean01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at boolean literal 'true'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.BOOLEAN_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after boolean literal 'true'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.BOOLEAN_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testEnumerationLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/enumeration01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at enumeration literal 'literal1'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.ENUMERATION_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after enumeration literal 'literal1'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.ENUMERATION_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testEnumerationLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/enumeration01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at enumeration literal 'literal1'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.ENUMERATION_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after enumeration literal 'literal1'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.ENUMERATION_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testEnumerationLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/enumeration01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at enumeration literal 'literal1'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.ENUMERATION_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after enumeration literal 'literal1'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.ENUMERATION_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testIntegerLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/integer01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at integer literal '42'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INTEGER_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after integer literal '42'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INTEGER_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testIntegerLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/integer01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at integer literal '42'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INTEGER_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after integer literal '42'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INTEGER_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testIntegerLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/integer01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at integer literal '42'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INTEGER_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after integer literal '42'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INTEGER_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testInvalidLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/invalid01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at invalid literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INVALID_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after invalid literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INVALID_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testInvalidLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/invalid01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at invalid literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INVALID_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after invalid literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INVALID_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testInvalidLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/invalid01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at invalid literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INVALID_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after invalid literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.INVALID_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testRealLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/real01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at real literal '42.7'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.REAL_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after real literal '42.7'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.REAL_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testRealLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/real01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at real literal '42.7'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.REAL_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after real literal '42.7'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.REAL_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testRealLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/real01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at real literal '42.7'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.REAL_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after real literal '42.7'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.REAL_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testStringLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/string01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.STRING_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.STRING_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testStringLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/string01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.STRING_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.STRING_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testStringLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/string01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.STRING_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.STRING_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testTupleLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/tuple01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at tuple literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TUPLE_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after string literal 'some'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TUPLE_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testTypeLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/type01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at type literal 'TestClass'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TYPE_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after type literal 'TestClass'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TYPE_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testTypeLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/type01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at type literal 'TestClass'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TYPE_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after type literal 'TestClass'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TYPE_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	@Ignore
	public void testTypeLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/type01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at type literal 'TestClass'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TYPE_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after type literal 'TestClass'. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.TYPE_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Test
	public void testUndefinedLiteralStepInto01() throws Exception {

		String oclResource = "resources/expressions/literals/undefined01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at undefined literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.UNDEFINED_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO, DebugEvent.SUSPENDED, debugger);

		/* Debugger after undefined literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.UNDEFINED_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_INTO,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Ignore
	@Test
	public void testUndefinedLiteralStepOver01() throws Exception {

		String oclResource = "resources/expressions/literals/undefined01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at undefined literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.UNDEFINED_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER, DebugEvent.SUSPENDED, debugger);

		/* Debugger after undefined literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.UNDEFINED_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_OVER,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}

	@Ignore
	@Test
	public void testUndefinedLiteralStepReturn01() throws Exception {

		String oclResource = "resources/expressions/literals/undefined01.ocl";
		OclDebugger debugger = generateDebugger(oclResource);
		waitForEvent(DebugEvent.STARTED);
		waitForEvent(DebugEvent.SUSPENDED);

		/* Start debugging. */
		File resourceFile = getFile(oclResource, DebugTestPlugin.PLUGIN_ID);
		debugger.addLineBreakPoint(resourceFile.getAbsolutePath(), 5);
		debugStepAndWaitFor(DebugStep.RESUME, DebugEvent.SUSPENDED, debugger);

		/* Debugger at undefined literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.UNDEFINED_LITERAL, debugger);
		assertVariableNumber(1, debugger);
		assertVariableExist("self", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN, DebugEvent.SUSPENDED,
				debugger);

		/* Debugger after undefined literal. */
		assertCurrentLine(5, debugger);
		assertStackSize(1, debugger);
		assertStackName(CallStackConstants.UNDEFINED_LITERAL, debugger);
		/* 'result' should be on the stack. */
		assertVariableNumber(2, debugger);
		assertVariableExist("self", debugger);
		assertVariableExist("result", debugger);

		debugStepAndWaitFor(DebugStep.STEP_RETURN,
				DebugEvent.CONSTRAINT_INTERPRETED, debugger);
	}
}
