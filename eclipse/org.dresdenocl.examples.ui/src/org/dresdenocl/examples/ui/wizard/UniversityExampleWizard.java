package org.dresdenocl.examples.ui.wizard;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Wizard used to create the simple example project within the current Eclipse
 * workspace.
 * 
 * @author Claas Wilke
 */
public class UniversityExampleWizard extends AbstractExampleWizard {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.dresdenocl.examples.ui.wizard.AbstractExampleWizard#
	 * getExamplePlugins()
	 */
	protected Collection<String[]> getExamplePlugins() {

		Collection<String[]> result = new ArrayList<String[]>(1);
		result.add(new String[] { "org.dresdenocl.examples.university",
				"Dresden OCL - University UML Example" });
		
		return result;
	}
}
