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

package org.dresdenocl.model;

import org.dresdenocl.model.metamodel.IMetamodel;

/**
 * <p>
 * This is a general exception that may be thrown when an error occurs while
 * loading, saving, retrieving or otherwise accessing a {@link IMetamodel},
 * {@link IModel} or {@link IModelInstance}.
 * </p>
 * 
 * @author Matthias Braeuer
 */
public class ModelAccessException extends Exception {

	/** generated serial version id. */
	private static final long serialVersionUID = 6921256999901133096L;

	/**
	 * <p>
	 * Creates a new {@link ModelAccessException} with an error message.
	 * </p>
	 * 
	 * @param message
	 *          The message.
	 */
	public ModelAccessException(String message) {

		super(message);
	}

	/**
	 * <p>
	 * Creates a new {@link ModelAccessException} with an error message and a
	 * {@link Throwable} that is the root cause of this exception.
	 * </p>
	 * 
	 * @param message
	 *          The message.
	 * @param cause
	 *          The cause of this exception.
	 */
	public ModelAccessException(String message, Throwable cause) {

		super(message, cause);
	}
}