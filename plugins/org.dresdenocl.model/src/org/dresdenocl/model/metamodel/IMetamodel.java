/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package org.dresdenocl.model.metamodel;

import org.dresdenocl.model.IModel;
import org.dresdenocl.model.IModelProvider;

/**
 * <p>
 * Represents meta-models that can be used to load {@link IModel}s.
 * </p>
 * 
 * @author Matthias Braeuer
 */
public interface IMetamodel {

	/**
	 * <p>
	 * Returns a unique identifier for this {@link IMetamodel} under which it can
	 * be registered in an {@link IMetamodelRegistry}.
	 * </p>
	 * 
	 * @return A {@link String} identifier.
	 */
	String getId();

	/**
	 * <p>
	 * Returns the {@link IModelProvider} that can be used to load instances of
	 * this {@link IMetamodel}.
	 * </p>
	 * 
	 * @return An {@link IModelProvider} instance.
	 */
	IModelProvider getModelProvider();

	/**
	 * <p>
	 * Returns a human-readable and possibly translatable name of this
	 * {@link IMetamodel} that may be used to display it in a user interface.
	 * </p>
	 * 
	 * @return A {@link String} representing the name of the {@link IMetamodel}.
	 */
	String getName();
}