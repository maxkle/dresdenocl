/*
Copyright (C) 2008-2010 by Claas Wilke (claaswilke@gmx.net)

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

package tudresden.ocl20.pivot.tools.codegen.ocl2java.test.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import tudresden.ocl20.pivot.facade.Ocl2ForEclipseFacade;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.tools.codegen.ocl2java.IOcl2JavaSettings;
import tudresden.ocl20.pivot.tools.codegen.ocl2java.test.Ocl2JavaTestPlugin;

/**
 * <p>
 * Abstract implementation for test class to test code generation of standard
 * library operations.
 * </p>
 * 
 * @author Claas Wilke
 */
public abstract class AbstractDiffTest {

	/** The location of the {@link IModel} used for testing. */
	private static final String MODEL_NAME = "resources/models/model01.uml";

	/** The {@link IModel} used for testing. */
	private static IModel testModel;

	/**
	 * <p>
	 * Initializes the test cases.
	 * </p>
	 * 
	 * @throws Exception
	 */
	protected static void setUp() throws Exception {

		File modelFile;
		modelFile = AbstractDiffTest.getFile(MODEL_NAME);

		testModel =
				Ocl2ForEclipseFacade.getModel(modelFile,
						Ocl2ForEclipseFacade.UML2_MetaModel);
	}

	/**
	 * <p>
	 * Tears down the test cases.
	 * </p>
	 * 
	 * @throws ModelAccessException
	 * @throws IllegalArgumentException
	 */
	protected static void tearDown() throws IllegalArgumentException,
			ModelAccessException {

		Ocl2ForEclipseFacade.removeModel(testModel);
	}

	/**
	 * <p>
	 * Returns the file object for a given path relative to the plug-in's
	 * directory.
	 * </p>
	 * 
	 * @param path
	 *          The path of the resource.
	 * @return The found {@link File} object.
	 * @throws Exception
	 *           Thrown, if the opening fails.
	 */
	private static File getFile(String path) throws Exception {

		URL fileLocation;
		fileLocation =
				Ocl2JavaTestPlugin.getDefault().getBundle().getResource(path);
		fileLocation = FileLocator.resolve(fileLocation);

		File file;
		file = new File(fileLocation.getFile());

		assertTrue(file.exists());

		return file;
	}

	/**
	 * <p>
	 * Compares fragment code generated by a given constraints file's name with
	 * its expected result.
	 * </p>
	 * 
	 * @param directory
	 *          the directory of the file relative to <code>resources/</code>
	 * @param fileName
	 *          The name of the file that shall be checked.
	 * @throws Exception
	 */
	protected void compareFragmentCodeGeneration(String directory, String fileName)
			throws Exception {

		/* Remove existing constraints from the model to avoid side effects. */
		testModel.removeAllConstraints();

		/* Parse the constraint. */
		File constraintFile;
		constraintFile =
				AbstractDiffTest.getFile("resources/" + directory + "/" + fileName
						+ ".ocl");

		List<Constraint> parsedConstraints;
		parsedConstraints =
				Ocl2ForEclipseFacade.parseConstraints(constraintFile, testModel, true);

		assertNotNull(parsedConstraints);
		assertEquals(1, parsedConstraints.size());

		String generatedCode;
		generatedCode =
				Ocl2ForEclipseFacade.generateJavaFragmentCode(parsedConstraints
						.iterator().next(), Ocl2ForEclipseFacade
						.getJavaCodeGeneratorSettings());

		assertNotNull(generatedCode);

		CodegenTestPerformer.getInstance().compareStringAndFile(
				"resources/" + directory + "/" + fileName + ".txt", generatedCode);
	}

	/**
	 * <p>
	 * Compares instrumentation code generated by a given constraints file's name
	 * with its expected result.
	 * </p>
	 * 
	 * @param directory
	 *          the directory of the file relative to <code>resources/</code>
	 * @param fileName
	 *          The name of the file that shall be checked.
	 * @throws Exception
	 */
	protected void compareInstrumentationCodeGeneration(String directory,
			String fileName) throws Exception {

		/* Remove existing constraints from the model to avoid side effects. */
		testModel.removeAllConstraints();

		/* Parse the constraint. */
		File constraintFile;
		constraintFile =
				AbstractDiffTest.getFile("resources/" + directory + "/" + fileName
						+ ".ocl");

		List<Constraint> parsedConstraints;
		parsedConstraints =
				Ocl2ForEclipseFacade.parseConstraints(constraintFile, testModel, true);

		assertNotNull(parsedConstraints);
		assertEquals(1, parsedConstraints.size());

		String generatedCode;
		generatedCode =
				Ocl2ForEclipseFacade.generateAspectJCode(parsedConstraints.iterator()
						.next(), Ocl2ForEclipseFacade.getJavaCodeGeneratorSettings());

		assertNotNull(generatedCode);

		CodegenTestPerformer.getInstance().compareStringAndFile(
				"resources/" + directory + "/instrumented/" + fileName + ".txt",
				generatedCode);
	}

	/**
	 * <p>
	 * Creates instrumentation code for a given constraints file's name.
	 * </p>
	 * 
	 * @param targetBundleId
	 *          The ID of the {@link Bundle}, whose source directory to save the
	 *          instrumentation code.
	 * @param directory
	 *          the directory of the file relative to <code>resources/</code>
	 * @param fileNames
	 *          The the directories of the files relative to
	 *          <code>resources/</code> and the names of the files for that code
	 *          shall be generated as a {@link List} containing {@link String}
	 *          arrays.
	 * @throws Exception
	 */
	protected void createInstrumentationCode(String targetBundleId,
			List<String[]> fileNames) throws Exception {

		/* Get the bundle location for the model files. */
		String sourceDirectory;
		sourceDirectory = Platform.getBundle(targetBundleId).getLocation();

		/* Remove the 'reference:file:' from the beginning. */
		sourceDirectory = sourceDirectory.substring(15);
		sourceDirectory += "src/";

		IOcl2JavaSettings settings;
		settings = Ocl2ForEclipseFacade.getJavaCodeGeneratorSettings();
		settings.setSourceDirectory(sourceDirectory);
		settings.setSaveCode(true);

		List<Constraint> parsedConstraints;
		parsedConstraints = new ArrayList<Constraint>();

		/* Parse the constraint. */
		for (String[] constraintFilePair : fileNames) {

			File constraintFile;
			constraintFile =
					AbstractDiffTest.getFile("resources/" + constraintFilePair[0] + "/"
							+ constraintFilePair[1] + ".ocl");

			parsedConstraints.addAll(Ocl2ForEclipseFacade.parseConstraints(
					constraintFile, testModel, true));
		}
		// end for.

		/* Generate and save the code. */
		Ocl2ForEclipseFacade.generateAspectJCode(parsedConstraints, settings);
	}
}