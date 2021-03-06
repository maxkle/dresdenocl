/*
Copyright (C) 2007-2009 by Claas Wilke (claaswilke@gmx.net)

This file is part of the Ecore Meta Model of Dresden OCL2 for Eclipse.

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
package org.dresdenocl.modelinstancetype.ecore.internal.modelinstance;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.UniqueEList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.osgi.util.NLS;

import org.dresdenocl.modelinstance.base.AbstractModelInstance;
import org.dresdenocl.modelinstancetype.ecore.EcoreModelInstanceTypePlugin;
import org.dresdenocl.modelinstancetype.ecore.internal.msg.EcoreModelInstanceTypeMessages;
import org.dresdenocl.modelinstancetype.ecore.internal.provider.EcoreModelInstanceProvider;
import org.dresdenocl.modelinstancetype.ecore.internal.util.EcoreModelInstanceTypeUtility;
import org.dresdenocl.modelinstancetype.exception.AsTypeCastException;
import org.dresdenocl.modelinstancetype.exception.CopyForAtPreException;
import org.dresdenocl.modelinstancetype.exception.OperationAccessException;
import org.dresdenocl.modelinstancetype.exception.OperationNotFoundException;
import org.dresdenocl.modelinstancetype.exception.PropertyAccessException;
import org.dresdenocl.modelinstancetype.exception.PropertyNotFoundException;
import org.dresdenocl.modelinstancetype.exception.TypeNotFoundInModelException;
import org.dresdenocl.modelinstancetype.types.IModelInstanceBoolean;
import org.dresdenocl.modelinstancetype.types.IModelInstanceCollection;
import org.dresdenocl.modelinstancetype.types.IModelInstanceElement;
import org.dresdenocl.modelinstancetype.types.IModelInstanceEnumerationLiteral;
import org.dresdenocl.modelinstancetype.types.IModelInstanceInteger;
import org.dresdenocl.modelinstancetype.types.IModelInstanceObject;
import org.dresdenocl.modelinstancetype.types.IModelInstancePrimitiveType;
import org.dresdenocl.modelinstancetype.types.IModelInstanceReal;
import org.dresdenocl.modelinstancetype.types.IModelInstanceString;
import org.dresdenocl.modelinstancetype.types.base.AbstractModelInstanceObject;
import org.dresdenocl.pivotmodel.Operation;
import org.dresdenocl.pivotmodel.Parameter;
import org.dresdenocl.pivotmodel.Property;
import org.dresdenocl.pivotmodel.Type;

/**
 * <p>
 * Implements the interface {@link IModelInstanceObject} for EMF Ecore
 * {@link EObject}s.
 * </p>
 * 
 * @author Claas Wilke
 */
public class EcoreModelInstanceObject extends AbstractModelInstanceObject
		implements IModelInstanceObject {

	/** The {@link Logger} for this class. */
	private static final Logger LOGGER = EcoreModelInstanceTypePlugin
			.getLogger(EcoreModelInstanceProvider.class);

	/** The {@link EObject} adapted by this {@link EcoreModelInstanceObject}. */
	private EObject myEObject;

	/**
	 * The Java {@link Class} this {@link AbstractModelInstanceObject} is casted
	 * to. This is required to access the right {@link Property}s and
	 * {@link Operation}s.
	 */
	private Class<?> myAdaptedType;

	/**
	 * The {@link EcoreModelInstanceFactory} of this
	 * {@link EcoreModelInstanceObject}. Required to adapt results of
	 * {@link Property} and {@link Operation} invocations.
	 */
	private EcoreModelInstanceFactory myFactory;

	/**
	 * <p>
	 * Creates a new {@link EcoreModelInstanceObject} for a given
	 * {@link EObject} and a given {@link Set} of {@link Type}s.
	 * </p>
	 * 
	 * @param object
	 *            The {@link EObject} that shall be adapted by this
	 *            {@link EcoreModelInstanceObject}.
	 * @param type
	 *            The {@link Type} the adapted {@link EObject} implements.
	 * @param originalType
	 *            The original {@link Type} the adapted {@link EObject}
	 *            implements (as after the object has been casted to another
	 *            {@link Type}.)
	 * @param factory
	 *            The {@link EcoreModelInstanceFactory} of this
	 *            {@link EcoreModelInstanceObject}. Required to adapt results of
	 *            {@link Property} and {@link Operation} invocations.
	 */
	protected EcoreModelInstanceObject(EObject eObject, Type type,
			Type originalType, EcoreModelInstanceFactory factory) {

		super(type, originalType);

		/* Probably debug the entry of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "EcoreModelInstanceObject("; //$NON-NLS-1$
			msg += "eObject = " + eObject; //$NON-NLS-1$
			msg += ", type = " + type; //$NON-NLS-1$
			msg += ", originalType = " + originalType; //$NON-NLS-1$
			msg += ", factory = " + factory; //$NON-NLS-1$
			msg += ")"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.

		this.myEObject = eObject;

		if (this.myEObject != null) {
			this.myAdaptedType = eObject.getClass();
		}
		// no else.

		this.myType = type;
		this.myFactory = factory;

		/* Probably debug the exit of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "EcoreModelInstanceObject(EObject, Type, IModelInstanceFactory) - exit"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.
	}

	/**
	 * <p>
	 * Creates a new {@link EcoreModelInstanceObject} for a given
	 * {@link EObject} and a given {@link Set} of {@link Type}s.
	 * </p>
	 * 
	 * @param object
	 *            The {@link EObject} that shall be adapted by this
	 *            {@link EcoreModelInstanceObject}.
	 * @param clazz
	 *            The {@link Class} the adapted {@link EObject} shall be casted
	 *            to.
	 * @param type
	 *            The {@link Type} the adapted {@link EObject} implements.
	 * @param originalType
	 *            The original {@link Type} the adapted {@link EObject}
	 *            implements (as after the object has been casted to another
	 *            {@link Type}.)
	 * @param factory
	 *            The {@link EcoreModelInstanceFactory} of this
	 *            {@link EcoreModelInstanceObject}. Required to adapt results of
	 *            {@link Property} and {@link Operation} invocations.
	 */
	protected EcoreModelInstanceObject(EObject eObject, Class<?> clazz,
			Type type, Type originalType, EcoreModelInstanceFactory factory) {

		super(type, originalType);

		/* Probably debug the entry of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "EcoreModelInstanceObject("; //$NON-NLS-1$
			msg += "eObject = " + eObject; //$NON-NLS-1$
			msg += ", clazz = " + clazz; //$NON-NLS-1$
			msg += ", type = " + type; //$NON-NLS-1$
			msg += ", originalType = " + originalType; //$NON-NLS-1$
			msg += ", factory = " + factory; //$NON-NLS-1$
			msg += ")"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.

		this.myEObject = eObject;
		this.myAdaptedType = clazz;
		this.myType = type;
		this.myFactory = factory;

		/* Probably debug the exit of this method. */
		if (LOGGER.isDebugEnabled()) {
			String msg;

			msg = "EcoreModelInstanceObject(EObject, Class, Type, IModelInstanceFactory) - exit"; //$NON-NLS-1$

			LOGGER.debug(msg);
		}
		// no else.
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dresdenocl.modelbus.modelinstance.types.IModelInstanceElement
	 * #asType(org.dresdenocl.pivotmodel.Type)
	 */
	public IModelInstanceElement asType(Type type) throws AsTypeCastException {

		if (type == null) {
			throw new IllegalArgumentException(
					"Parameter 'type' must not be null.");
		}
		// no else.

		IModelInstanceElement result;

		/* Check if cast is possible. */
		if (this.getOriginalType().conformsTo(type)) {

			/* If the object is null, perform the cast. */
			if (this.myEObject == null) {
				result = new EcoreModelInstanceObject(null, type, this
						.getOriginalType(), this.myFactory);
			}

			/*
			 * Else try to find a class representing the given type (required
			 * for probable method invocations later on).
			 */
			else {
				/* Try to find a class that is represented by the given type. */
				Class<?> typeClass;
				typeClass = EcoreModelInstanceTypeUtility.findClassOfType(
						this.myEObject.getClass(), type);

				/* If no class has been found, throw an exception. */
				if (typeClass == null) {
					String msg;

					msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotCastTypeClassNotFound;
					msg = NLS.bind(msg, this.getName(), type);

					throw new AsTypeCastException(msg);
				}
				// no else.

				/* Cast this object to the found type. */
				result = new EcoreModelInstanceObject(this.myEObject,
						typeClass, type, this.getOriginalType(), this.myFactory);
			}
			// end else.
		}

		/* Else cannot cast. */
		else {
			String msg;
			msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotCastTypeClassNotFound;
			msg = NLS.bind(msg, this.getName(), type);

			throw new AsTypeCastException(msg);
		}
		// end else.

		return result;
	}

	/**
	 * <p>
	 * Performs a copy of the adapted element of this
	 * {@link IModelInstanceElement} that can be used to store it as a @pre
	 * value of a postcondition's expression. The method should copy the adapted
	 * object and all its references that are expected to change during the
	 * methods execution the postcondition is defined on.
	 * </p>
	 * 
	 * <p>
	 * For {@link EcoreModelInstanceObject}s this method tries to clone the
	 * adapted {@link Object} if the {@link Object} implements {@link Clonable}
	 * . Else the {@link Object} will be copied using an probably existing empty
	 * {@link Constructor} and a flat copy will be created (means all attributes
	 * and associations will lead to the same values and identities. <strong>If
	 * neither the <code>clone()</code> method nor the empty {@link Constructor}
	 * are provided, this operation will fail with an
	 * {@link CopyForAtPreException}.</strong>
	 * </p>
	 * 
	 * @return A copy of the adapted element.
	 * @throws CopyForAtPreException
	 *             Thrown, if an error during the copy process occurs.
	 */
	public IModelInstanceElement copyForAtPre() throws CopyForAtPreException {

		IModelInstanceElement result;
		result = null;

		/* Check if the adapted object is clone-able. */
		if (this.myEObject instanceof Cloneable) {

			try {
				result = copyForAtPreWithClone();
			}

			catch (CopyForAtPreException e) {
				/* Catch the exception and try to copy again with reflections. */
			}
		}
		// no else.

		/*
		 * If not object has been created yet. Try to copy the object with
		 * reflections.
		 */
		if (result == null) {

			copyForAtPreWithReflections();
		}
		// no else.

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dresdenocl.modelbus.modelinstance.types.IModelInstanceObject
	 * #getObject()
	 */
	public Object getObject() {

		return this.myEObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dresdenocl.modelbus.modelinstance.types.IModelInstanceObject
	 * #getProperty(org.dresdenocl.pivotmodel.Property)
	 */
	public IModelInstanceElement getProperty(Property property)
			throws PropertyAccessException, PropertyNotFoundException {

		if (property == null) {
			throw new IllegalArgumentException(
					"Parameter 'property' must not be null.");
		}
		// no else.

		IModelInstanceElement result;

		/* Check if this object is undefined. */
		if (this.myEObject == null) {

			/* The result will be undefined as well. */
			result = this.myFactory.createModelInstanceElement(null, property
					.getType());
		}

		/* Else find the StructuralFeature of the property that can be accessed. */
		else {

			EStructuralFeature sf = this.myEObject.eClass()
					.getEStructuralFeature(property.getName());

			if (sf == null) {
				String msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_PropertyNotFoundInModelInstanceElement;
				msg = NLS.bind(msg, property, this.myEObject);
				throw new PropertyAccessException(msg);
			}

			Object adapteeResult = this.myEObject.eGet(sf);
			result = AbstractModelInstance.adaptInvocationResult(adapteeResult,
					property.getType(), this.myFactory);
		}
		// end else.

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.dresdenocl.modelbus.modelinstance.types.IModelInstanceObject
	 * #invokeOperation(org.dresdenocl.pivotmodel.Operation,
	 * java.util.List)
	 */
	public IModelInstanceElement invokeOperation(Operation operation,
			List<IModelInstanceElement> args)
			throws OperationNotFoundException, OperationAccessException {

		if (operation == null) {
			throw new IllegalArgumentException(
					"Parameter 'operation' must not be null.");
		}
		// no else.

		else if (args == null) {
			throw new IllegalArgumentException(
					"Parameter 'args' must not be null.");
		}
		// no else.

		IModelInstanceElement result;

		/* Check if this object is undefined. */
		if (this.myEObject == null) {

			/* The result will be undefined as well. */
			result = this.myFactory.createModelInstanceElement(null, operation
					.getType());
		}

		/* Else find and invoke the operation. */
		else {
			Method operationMethod;

			int argSize;
			Class<?>[] argumentTypes;
			Object[] argumentValues;

			/* Try to find the method to invoke. */
			operationMethod = this.findMethodOfAdaptedObject(operation);

			argumentTypes = operationMethod.getParameterTypes();
			argumentValues = new Object[args.size()];

			/* Avoid errors through to much arguments given by the invocation. */
			argSize = Math.min(args.size(), operation.getSignatureParameter()
					.size());

			/* Adapt the argument values. */
			for (int index = 0; index < argSize; index++) {

				argumentValues[index] = this.createAdaptedElement(args
						.get(index), argumentTypes[index]);
			}

			/* Try to invoke the found method. */
			try {
				Object adapteeResult;
				operationMethod.setAccessible(true);

				adapteeResult = operationMethod.invoke(this.myEObject,
						argumentValues);

				/* Adapt the result to the expected result type. */
				if (adapteeResult instanceof EObject) {
					try {
						Type adapteeType = this.myFactory.getTypeUtility()
								.findTypeOfEObjectInModel(
										(EObject) adapteeResult);

						result = AbstractModelInstance.adaptInvocationResult(
								adapteeResult, adapteeType, this.myFactory);
					}

					catch (TypeNotFoundInModelException e) {
						throw new OperationAccessException(
								"Result of invocation of Operation '"
										+ operation.getName()
										+ "' could not be adapted to any model type.",
								e);
					}
				}
				// no else.

				else {
					result = AbstractModelInstance.adaptInvocationResult(
							adapteeResult, operation.getType(), this.myFactory);
				}
			}

			catch (IllegalArgumentException e) {
				String msg;

				msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_OperationAccessFailed;
				msg = NLS.bind(msg, operation, e.getMessage());

				throw new OperationAccessException(msg, e);
			}

			catch (IllegalAccessException e) {
				String msg;

				msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_OperationAccessFailed;
				msg = NLS.bind(msg, operation, e.getMessage());

				throw new OperationAccessException(msg, e);
			}

			catch (InvocationTargetException e) {
				String msg;

				msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_OperationAccessFailed;
				msg = NLS.bind(msg, operation, e.getMessage());

				throw new OperationAccessException(msg, e);
			}
		}
		// end else.

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.dresdenocl.modelinstancetype.types.base.
	 * AbstractModelInstanceElement
	 * #isKindOf(org.dresdenocl.pivotmodel.Type)
	 */
	@Override
	public boolean isKindOf(Type type) {

		return this.getOriginalType().conformsTo(type);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {

		StringBuffer result;
		result = new StringBuffer();

		result.append(this.getClass().getSimpleName());
		result.append("[type=");
		result.append(this.getType().getName());
		result.append(",originalType=");
		result.append(this.getOriginalType().getName());
		result.append(",");
		result.append(this.myEObject.toString());
		result.append("]");

		return result.toString();
	}

	/**
	 * <p>
	 * A helper method that tries to copy the adapted object using the method
	 * {@link Object#clone()}.
	 * </p>
	 * 
	 * @return A copy of the adapted {@link EObject} of this
	 *         {@link EcoreModelInstanceObject}.
	 * @throws CopyForAtPreException
	 *             Thrown, if the adapted {@link EObject} cannot be copied via
	 *             clone method.
	 */
	private IModelInstanceElement copyForAtPreWithClone()
			throws CopyForAtPreException {

		IModelInstanceElement result;
		Method cloneMethod;

		/* Try to find and invoke the clone method. */
		try {
			EObject adaptedResult;

			cloneMethod = this.myEObject.getClass().getMethod("clone");
			cloneMethod.setAccessible(true);

			adaptedResult = (EObject) cloneMethod.invoke(this.myEObject);
			result = new EcoreModelInstanceObject(adaptedResult,
					this.myAdaptedType, this.myType, this.getOriginalType(),
					this.myFactory);
		}

		catch (SecurityException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (NoSuchMethodException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (IllegalArgumentException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (IllegalAccessException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (InvocationTargetException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method that tries to copy the adapted {@link Object} of this
	 * {@link EcoreModelInstanceObject} with an empty {@link Constructor} based
	 * on reflections. The copied {@link Object} will be a flat copy of this
	 * {@link Object}. Thus, the fields will all have the same value and id.
	 * </p>
	 * 
	 * @return A copy of the adapted {@link Object} of this
	 *         {@link EcoreModelInstanceObject}.
	 * @throws CopyForAtPreException
	 *             Thrown, if the adapted {@link EObject} cannot be copied using
	 *             an empty {@link Constructor}.
	 */
	private IModelInstanceObject copyForAtPreWithReflections()
			throws CopyForAtPreException {

		IModelInstanceObject result;
		Class<?> adapteeClass;

		adapteeClass = this.myEObject.getClass();

		try {
			EObject copiedAdaptedObject;
			Constructor<?> emptyConstructor;

			/* Try to find an empty constructor. */
			emptyConstructor = adapteeClass.getConstructor(new Class[0]);

			/* Copy the adapted object. */
			copiedAdaptedObject = (EObject) emptyConstructor
					.newInstance(new Object[0]);

			/* Iterate through the adapteeClass and all its super classes. */
			while (adapteeClass != null) {

				/* Initialize all fields with the same value. */
				for (Field field : adapteeClass.getDeclaredFields()) {

					field.setAccessible(true);

					/* Do not set static nor final fields. */
					if (!(Modifier.isFinal(field.getModifiers()) || Modifier
							.isStatic(field.getModifiers()))) {
						field.set(copiedAdaptedObject, field
								.get(this.myEObject));
					}
					// no else.
				}
				// end for.

				adapteeClass = adapteeClass.getSuperclass();
			}
			// end while.

			/* Create the adapter. */
			result = new EcoreModelInstanceObject(copiedAdaptedObject,
					this.myAdaptedType, this.myType, this.getOriginalType(),
					this.myFactory);
		}

		catch (SecurityException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (NoSuchMethodException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (IllegalArgumentException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (InstantiationException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (IllegalAccessException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}

		catch (InvocationTargetException e) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_CannotCopyForAtPre;
			msg = NLS.bind(msg, this.getName(), e.getMessage());

			throw new CopyForAtPreException(msg, e);
		}
		// end try.

		return result;
	}

	/**
	 * <p>
	 * Returns or creates the element that is adapted by a given
	 * {@link IModelInstanceElement}. E.g., if the given
	 * {@link IModelInstanceElement} is an {@link IModelInstanceObject}, the
	 * adapted {@link Object} is simply returned. For
	 * {@link IModelInstancePrimitiveType}, a newly created primitive is
	 * returned.
	 * </p>
	 * 
	 * @param modelInstanceElement
	 *            The {@link IModelInstanceElement} those adapted {@link Object}
	 *            shall be returned or created.
	 * @param typeClass
	 *            The {@link Class} the recreated element should be an instance
	 *            of. This could be required for
	 *            {@link IModelInstancePrimitiveType}s or for
	 *            {@link IModelInstanceCollection}s.
	 * @return The created or adapted value ({@link Object}).
	 */
	@SuppressWarnings("unchecked")
	private Object createAdaptedElement(
			IModelInstanceElement modelInstanceElement, Class<?> typeClass) {

		Object result;

		/* Check for null values. */
		if (modelInstanceElement == null) {
			result = null;
		}

		/* Else check if the given element is a primitive type. */
		else if (modelInstanceElement instanceof IModelInstancePrimitiveType) {

			/* Probably recreate a boolean value. */
			if (modelInstanceElement instanceof IModelInstanceBoolean) {

				result = ((IModelInstanceBoolean) modelInstanceElement)
						.getBoolean();
			}

			/* Else probably recreate an integer value. */
			else if (modelInstanceElement instanceof IModelInstanceInteger) {

				result = createAdaptedIntegerValue(
						(IModelInstanceInteger) modelInstanceElement, typeClass);
			}

			/* Else probably recreate a real value. */
			else if (modelInstanceElement instanceof IModelInstanceReal) {

				result = createAdaptedRealValue(
						(IModelInstanceReal) modelInstanceElement, typeClass);
			}

			/* Else probably recreate an String value. */
			else if (modelInstanceElement instanceof IModelInstanceString) {

				result = createAdaptedStringValue(
						(IModelInstanceString) modelInstanceElement, typeClass);
			}

			else {
				/* Other primitive types are not supported. Return null. */
				result = null;
			}
		}

		/* Else check if the given element is an enumeration literal. */
		else if (modelInstanceElement instanceof IModelInstanceEnumerationLiteral) {

			result = createAdaptedEnumerationLiteral(
					(IModelInstanceEnumerationLiteral) modelInstanceElement,
					typeClass);
		}

		/* Else check if the given element is a collection. */
		else if (modelInstanceElement instanceof IModelInstanceCollection) {

			/* Eventually adapt to an array. */
			if (typeClass.isArray()) {
				result = createAdaptedArray(modelInstanceElement, typeClass);
			}

			/* Else use the collection. */
			else if (Collection.class.isAssignableFrom(typeClass)) {
				result = createAdaptedCollection(
						(IModelInstanceCollection<IModelInstanceElement>) modelInstanceElement,
						typeClass);
			}

			/* Else throw an exception. */
			else {
				String msg;
				msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotRecreateCollection;

				throw new IllegalArgumentException(msg);
			}
		}

		/* Else check if the given element is an adapted object. */
		else if (modelInstanceElement instanceof IModelInstanceObject) {

			result = ((IModelInstanceObject) modelInstanceElement).getObject();
		}

		/* Other types are not known. */
		else {
			result = null;
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method the converts a given {@link IModelInstanceElement} into
	 * an Array value of a given {@link Class}.
	 * </p>
	 * 
	 * @param modelInstanceElement
	 *            The {@link IModelInstanceElement} that shall be converted.
	 * @param type
	 *            The {@link Class} to that the given
	 *            {@link IModelInstanceElement} shall be converted.
	 * @return The converted {@link Object}.
	 */
	@SuppressWarnings("unchecked")
	private Object createAdaptedArray(
			IModelInstanceElement modelInstanceElement, Class<?> type) {

		Object result;

		if (modelInstanceElement instanceof IModelInstanceCollection) {

			IModelInstanceCollection<IModelInstanceElement> modelInstanceCollection;
			Collection<IModelInstanceElement> adaptedCollection;

			Class<?> componentType;
			int index;

			componentType = type.getComponentType();

			modelInstanceCollection = (IModelInstanceCollection<IModelInstanceElement>) modelInstanceElement;
			adaptedCollection = modelInstanceCollection.getCollection();

			if (componentType.isPrimitive()) {

				/* Probably create an array of boolean. */
				if (boolean.class.isAssignableFrom(componentType)) {

					boolean[] array;
					array = new boolean[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceBoolean) anElement)
								.getBoolean().booleanValue();
					}

					result = array;
				}

				/* Probably create an array of byte. */
				else if (byte.class.isAssignableFrom(componentType)) {

					byte[] array;
					array = new byte[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement)
								.getLong().byteValue();
					}

					result = array;
				}

				/* Probably create an array of char. */
				else if (char.class.isAssignableFrom(componentType)) {

					char[] array;
					array = new char[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceString) anElement)
								.getString().charAt(0);
					}

					result = array;
				}

				/* Probably create an array of double. */
				else if (double.class.isAssignableFrom(componentType)) {

					double[] array;
					array = new double[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceReal) anElement)
								.getDouble().doubleValue();
					}

					result = array;
				}

				/* Probably create an array of float. */
				else if (float.class.isAssignableFrom(componentType)) {

					float[] array;
					array = new float[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceReal) anElement)
								.getDouble().floatValue();
					}

					result = array;
				}

				/* Probably create an array of int. */
				else if (int.class.isAssignableFrom(componentType)) {

					int[] array;
					array = new int[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement)
								.getLong().intValue();
					}

					result = array;
				}

				/* Probably create an array of long. */
				else if (long.class.isAssignableFrom(componentType)) {

					long[] array;
					array = new long[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement)
								.getLong().longValue();
					}

					result = array;
				}

				/* Probably create an array of short. */
				else if (short.class.isAssignableFrom(componentType)) {

					short[] array;
					array = new short[adaptedCollection.size()];

					index = 0;

					for (IModelInstanceElement anElement : adaptedCollection) {
						array[index] = ((IModelInstanceInteger) anElement)
								.getLong().shortValue();
					}

					result = array;
				}

				/* Else throw an exception. */
				else {
					throw new IllegalArgumentException(
							EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotRecreateArray);
				}
			}

			else {
				Object[] array;

				/* Create a new array of the given type. */
				array = (Object[]) Array.newInstance(componentType,
						adaptedCollection.size());

				index = 0;

				/* Fill the array with elements. */
				for (IModelInstanceElement anElement : adaptedCollection) {
					array[index] = createAdaptedElement(anElement,
							componentType);
				}
				// end for.

				result = array;
			}
			// end else.
		}

		else {
			throw new IllegalArgumentException(
					EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotRecreateArray);
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method that converts a given {@link IModelInstanceElement} into
	 * an {@link Collection} of a given {@link Class} type.
	 * </p>
	 * 
	 * @param modelInstanceCollection
	 *            The {@link IModelInstanceCollection} that shall be converted.
	 * @param type
	 *            The {@link Collection} {@link Class} to that the given
	 *            {@link IModelInstanceElement} shall be converted.
	 * @return The converted {@link Collection}.
	 */
	@SuppressWarnings("unchecked")
	private Collection<?> createAdaptedCollection(
			IModelInstanceCollection<IModelInstanceElement> modelInstanceCollection,
			Class<?> clazzType) {

		Collection<Object> result;

		if (Collection.class.isAssignableFrom(clazzType)) {

			/*
			 * Try to initialize the collection using the an empty constructor
			 * found via reflections.
			 */
			try {
				Constructor<?> collectionConstructor;

				collectionConstructor = clazzType.getConstructor(new Class[0]);
				result = (Collection<Object>) collectionConstructor
						.newInstance(new Object[0]);
			}

			/* Catch all possible exceptions and probably initialize with null. */
			catch (SecurityException e) {
				result = null;
			}

			catch (NoSuchMethodException e) {
				result = null;
			}

			catch (IllegalArgumentException e) {
				result = null;
			}

			catch (InstantiationException e) {
				result = null;
			}

			catch (IllegalAccessException e) {
				result = null;
			}

			catch (InvocationTargetException e) {
				result = null;
			}

			/*
			 * This could be implemented for other existing implementations of
			 * EList. For generated EMF Ecore without hacks and extendes ELists
			 * this should work.
			 */
			if (result == null) {

				if (UniqueEList.class.isAssignableFrom(clazzType)) {
					result = new UniqueEList<Object>();
				}

				else if (List.class.isAssignableFrom(clazzType)) {
					result = new BasicEList<Object>();
				}

				else if (Set.class.isAssignableFrom(clazzType)) {
					result = new HashSet<Object>();
				}
				// no else.
			}

			/* Probably create the contained elements. */
			if (result != null) {

				Class<?> elementClassType;

				/*
				 * TODO: The question how to retrieve the generic type of a List
				 * (if any exists) should be investigated very soon.
				 */
				/* Try to get the elements class. */
				if (clazzType.getTypeParameters().length == 1
						&& clazzType.getTypeParameters()[0].getBounds().length == 1
						&& clazzType.getTypeParameters()[0].getBounds()[0] instanceof Class) {
					elementClassType = (Class<?>) clazzType.getTypeParameters()[0]
							.getBounds()[0];
				}

				else {
					elementClassType = Object.class;
				}

				/* Create the value for all elements. */
				for (IModelInstanceElement anElement : modelInstanceCollection
						.getCollection()) {
					result
							.add(createAdaptedElement(anElement,
									elementClassType));
				}
				// end for.
			}

			/* Else throw an exception. */
			else {
				String msg;
				msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotRecreateCollection;

				throw new IllegalArgumentException(msg);
			}
		}

		/* Else throw an exception. */
		else {
			String msg;
			msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_CannotRecreateCollection;

			throw new IllegalArgumentException(msg);
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method the converts a given
	 * {@link IModelInstanceEnumerationLiteral} into an {@link Object} value of
	 * a given {@link Class}. If the given {@link Class} does not represents an
	 * {@link Enum}, a {@link IllegalArgumentException} is thrown.
	 * </p>
	 * 
	 * @param modelInstanceEnumerationLiteral
	 *            The {@link IModelInstanceEnumerationLiteral} that shall be
	 *            converted.
	 * @param type
	 *            The {@link Class} to that the given
	 *            {@link IModelInstanceEnumerationLiteral} shall be converted.
	 * @return The converted {@link Object}.
	 */
	private Object createAdaptedEnumerationLiteral(
			IModelInstanceEnumerationLiteral modelInstanceEnumerationLiteral,
			Class<?> typeClass) {

		Object result;

		/* Check if the given class represents an enumeration. */
		if (typeClass.isEnum()) {

			result = null;

			/*
			 * Try to find an enum constant having the same name as the
			 * enumeration literal.
			 */
			for (Object anEnumConstant : typeClass.getEnumConstants()) {
				if (anEnumConstant.toString().equals(
						modelInstanceEnumerationLiteral.getLiteral().getName())) {

					result = anEnumConstant;
					break;
				}
				// no else.
			}
			// end for.

			if (result == null) {
				String msg;

				msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_EnumerationLiteralNotFound;
				msg = NLS
						.bind(
								modelInstanceEnumerationLiteral.getLiteral()
										.getQualifiedName(),
								"The enumeration literal could not be adapted to any constant of the given Enum class.");

				throw new IllegalArgumentException(msg);
			}
			// no else.
		}

		/*
		 * Else check if the given class represents a super class of an Enum
		 * represented by this literal.
		 */
		else {

			List<String> enumerationQualifiedName;
			String enumClassName;

			enumerationQualifiedName = modelInstanceEnumerationLiteral
					.getLiteral().getQualifiedNameList();
			/* Remove the name of the literal. */
			enumerationQualifiedName
					.remove(enumerationQualifiedName.size() - 1);

			enumClassName = EcoreModelInstanceTypeUtility
					.toCanonicalName(enumerationQualifiedName);

			try {
				Class<?> enumClass;
				enumClass = this.loadJavaClass(enumClassName);

				/* Check if the found class represents an enumeration. */
				if (enumClass.isEnum()) {

					result = null;

					/*
					 * Try to find an enum constant having the same name as the
					 * enumeration literal.
					 */
					for (Object anEnumConstant : enumClass.getEnumConstants()) {
						if (anEnumConstant.toString().equals(
								modelInstanceEnumerationLiteral.getLiteral()
										.getName())) {

							result = anEnumConstant;
							break;
						}
					}
					// end for.

					if (result == null) {
						String msg;

						msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_EnumerationLiteralNotFound;
						msg = NLS
								.bind(
										modelInstanceEnumerationLiteral
												.getLiteral()
												.getQualifiedName(),
										"The enumeration literal could not be adapted to any constant of the given Enum class.");

						throw new IllegalArgumentException(msg);
					}
					// no else.
				}

				else {
					String msg;

					msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_EnumerationLiteralNotFound;
					msg = NLS.bind(modelInstanceEnumerationLiteral.getLiteral()
							.getQualifiedName(), "The found class " + enumClass
							+ " is not an Enum.");

					throw new IllegalArgumentException(msg);
				}
			}

			catch (ClassNotFoundException e) {
				String msg;

				msg = EcoreModelInstanceTypeMessages.EcoreModelInstance_EnumerationLiteralNotFound;
				msg = NLS.bind(modelInstanceEnumerationLiteral.getLiteral()
						.getQualifiedName(), e.getMessage());

				throw new IllegalArgumentException(msg, e);
			}
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method the converts a given {@link IModelInstanceInteger} into
	 * an Integer value of a given {@link Class}. If the given {@link Class}
	 * represents an unknown integer {@link Class}, a {@link Long} is returned.
	 * </p>
	 * 
	 * @param modelInstanceInteger
	 *            The {@link IModelInstanceElement} that shall be converted.
	 * @param type
	 *            The {@link Class} to that the given
	 *            {@link IModelInstanceElement} shall be converted.
	 * @return The converted {@link Object}.
	 */
	private Object createAdaptedIntegerValue(
			IModelInstanceInteger modelInstanceInteger, Class<?> type) {

		Object result;

		/* Probably recreate a BigDecimal value. */
		if (type.equals(BigDecimal.class)) {
			result = new BigDecimal(modelInstanceInteger.getLong());
		}

		/* Else probably recreate a BigInteger value. */
		else if (type.equals(BigInteger.class)) {
			result = BigInteger.valueOf(modelInstanceInteger.getLong());
		}

		/* Else probably recreate a Byte value. */
		else if (type.equals(byte.class) || type.equals(Byte.class)) {
			result = modelInstanceInteger.getLong().byteValue();
		}

		/* Else probably recreate an Integer value. */
		else if (type.equals(int.class) || type.equals(Integer.class)) {
			result = modelInstanceInteger.getLong().intValue();
		}

		/* Else probably recreate a Long value. */
		else if (type.equals(long.class) || type.equals(Long.class)) {
			result = modelInstanceInteger.getLong();
		}

		/* Else probably recreate a Short value. */
		else if (type.equals(short.class) || type.equals(Short.class)) {
			result = modelInstanceInteger.getLong().shortValue();
		}

		else {
			/* Other integer types are not supported. Return the Long value. */
			result = modelInstanceInteger.getLong();
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method the converts a given {@link IModelInstanceReal} into a
	 * Real value of a given {@link Class}. If the given {@link Class}
	 * represents an unknown real {@link Class}, a {@link Number} is returned.
	 * </p>
	 * 
	 * @param modelInstanceReal
	 *            The {@link IModelInstanceReal} that shall be converted.
	 * @param type
	 *            The {@link Class} to that the given {@link IModelInstanceReal}
	 *            shall be converted.
	 * @return The converted {@link Object}.
	 */
	private Object createAdaptedRealValue(IModelInstanceReal modelInstanceReal,
			Class<?> type) {

		Object result;

		/* Probably recreate a Double value. */
		if (type.equals(double.class) || type.equals(BigInteger.class)) {
			result = modelInstanceReal.getDouble();
		}

		/* Else probably recreate a Float value. */
		else if (type.equals(float.class) || type.equals(Float.class)) {
			result = modelInstanceReal.getDouble().floatValue();
		}

		else {
			/* Other integer types are not supported. Return the Double value. */
			result = modelInstanceReal.getDouble();
		}

		return result;
	}

	/**
	 * <p>
	 * A helper method the converts a given {@link IModelInstanceString} into a
	 * String value of a given {@link Class}. If the given {@link Class}
	 * represents an unknown String {@link Class}, a {@link String} is returned.
	 * </p>
	 * 
	 * @param modelInstanceString
	 *            The {@link IModelInstanceString} that shall be converted.
	 * @param type
	 *            The {@link Class} to that the given
	 *            {@link IModelInstanceString} shall be converted.
	 * @return The converted {@link Object}.
	 */
	private Object createAdaptedStringValue(
			IModelInstanceString modelInstanceString, Class<?> type) {

		Object result;
		String stringValue;

		stringValue = modelInstanceString.getString();

		/* Probably recreate a char value. */
		if (type.equals(char.class) || type.equals(BigInteger.class)) {

			if (stringValue.length() > 0) {
				result = stringValue.toCharArray()[0];
			}

			else {
				result = null;
			}
		}

		/* Else probably recreate a Character value. */
		else if (type.equals(float.class) || type.equals(Float.class)) {
			if (stringValue.length() > 0) {
				result = new Character(stringValue.toCharArray()[0]);
			}

			else {
				result = null;
			}
		}

		else {
			/*
			 * Other integer types are not supported (except of String). Return
			 * the String value.
			 */
			result = stringValue;
		}

		return result;
	}

	/**
	 * <p>
	 * A helper {@link Method} used to find a {@link Method} of the adapted
	 * {@link Object} of this {@link EcoreModelInstanceObject} that conforms to
	 * a given {@link Operation}.
	 * </p>
	 * 
	 * @param operation
	 *            The {@link Operation} for that a {@link Method} shall be
	 *            found.
	 * @return The found {@link Method}.
	 * @throws OperationNotFoundException
	 *             If no matching {@link Method} for the given {@link Operation}
	 *             can be found.
	 */
	private Method findMethodOfAdaptedObject(Operation operation)
			throws OperationNotFoundException {

		Method result;

		Class<?> methodSourceClass;

		result = null;
		methodSourceClass = this.myAdaptedType;

		/*
		 * Try to find an according method in the adapted objects class, or one
		 * of its super classes.
		 */
		while (methodSourceClass != null && result == null) {

			for (Method aMethod : methodSourceClass.getDeclaredMethods()) {

				boolean nameIsEqual;
				boolean resultTypeIsConform;
				boolean argumentSizeIsEqual;

				/* Check if the name matches to the given operation's name. */
				nameIsEqual = aMethod.getName().equals(operation.getName());

				/*
				 * Check if the return type matches to the given operation's
				 * type.
				 */
				resultTypeIsConform = EcoreModelInstanceTypeUtility
						.conformsTypeToType(aMethod.getGenericReturnType(),
								operation.getType());

				/*
				 * Check if the method has the same size of arguments as the
				 * given operation.
				 */
				argumentSizeIsEqual = aMethod.getParameterTypes().length == operation
						.getSignatureParameter().size();

				if (nameIsEqual && resultTypeIsConform && argumentSizeIsEqual) {

					java.lang.reflect.Type[] javaTypes;
					List<Parameter> pivotModelParamters;

					boolean matches;

					javaTypes = aMethod.getGenericParameterTypes();
					pivotModelParamters = operation.getSignatureParameter();

					matches = true;

					/* Compare the types of all arguments. */
					for (int index = 0; index < operation
							.getSignatureParameter().size(); index++) {

						if (!EcoreModelInstanceTypeUtility.conformsTypeToType(
								javaTypes[index], pivotModelParamters
										.get(index).getType())) {
							matches = false;
							break;
						}
						// no else.
					}

					if (matches) {
						result = aMethod;
						break;
					}
					// no else.
				}
				// no else.
			}
			// end for.

			methodSourceClass = methodSourceClass.getSuperclass();
		}
		// end while.

		/* Probably throw an exception. */
		if (result == null) {
			String msg;

			msg = EcoreModelInstanceTypeMessages.EcoreModelInstanceObject_OperationNotFound;
			msg = NLS.bind(msg, operation, this.myEObject.getClass());

			throw new OperationNotFoundException(msg);
		}
		// no else.

		return result;
	}

	/**
	 * <p>
	 * A helper method that tries to load a {@link Class} for a given canonical
	 * name using all {@link ClassLoader}s of this {@link JavaModelInstance}.
	 * </p>
	 * 
	 * @param canonicalName
	 *            The canonical name of the {@link Class} that shall be loaded.
	 * @return
	 * @throws ClassNotFoundException
	 *             Thrown, if the {@link Class} cannot be found by any
	 *             {@link ClassLoader} of this {@link JavaModelInstance}.
	 */
	private Class<?> loadJavaClass(String canonicalName)
			throws ClassNotFoundException {

		Class<?> result;
		result = null;

		result = this.myAdaptedType.getClassLoader().loadClass(canonicalName);

		return result;
	}
}