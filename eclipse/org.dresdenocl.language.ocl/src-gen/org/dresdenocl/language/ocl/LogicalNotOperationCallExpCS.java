/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.dresdenocl.language.ocl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Logical Not Operation Call Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.dresdenocl.language.ocl.LogicalNotOperationCallExpCS#getOperationName <em>Operation Name</em>}</li>
 *   <li>{@link org.dresdenocl.language.ocl.LogicalNotOperationCallExpCS#getTarget <em>Target</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.dresdenocl.language.ocl.OclPackage#getLogicalNotOperationCallExpCS()
 * @model
 * @generated
 */
public interface LogicalNotOperationCallExpCS extends OperationCallExpCS {
	/**
   * Returns the value of the '<em><b>Operation Name</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Operation Name</em>' attribute.
   * @see #setOperationName(String)
   * @see org.dresdenocl.language.ocl.OclPackage#getLogicalNotOperationCallExpCS_OperationName()
   * @model required="true"
   * @generated
   */
	String getOperationName();

	/**
   * Sets the value of the '{@link org.dresdenocl.language.ocl.LogicalNotOperationCallExpCS#getOperationName <em>Operation Name</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Operation Name</em>' attribute.
   * @see #getOperationName()
   * @generated
   */
	void setOperationName(String value);

	/**
   * Returns the value of the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Target</em>' containment reference.
   * @see #setTarget(OclExpressionCS)
   * @see org.dresdenocl.language.ocl.OclPackage#getLogicalNotOperationCallExpCS_Target()
   * @model containment="true" required="true"
   * @generated
   */
	OclExpressionCS getTarget();

	/**
   * Sets the value of the '{@link org.dresdenocl.language.ocl.LogicalNotOperationCallExpCS#getTarget <em>Target</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target</em>' containment reference.
   * @see #getTarget()
   * @generated
   */
	void setTarget(OclExpressionCS value);

} // LogicalNotOperationCallExpCS
