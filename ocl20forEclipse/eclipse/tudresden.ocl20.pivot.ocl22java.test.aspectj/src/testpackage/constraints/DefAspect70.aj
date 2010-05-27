package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect70 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testSequenceReverse(java.util.List<Object> source)}.</p>
     */
    protected pointcut testSequenceReverseCaller(testpackage.Class1 aClass, java.util.List<Object> source):
    	call(* testpackage.Class1.testSequenceReverse(java.util.List<Object>))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testSequenceReverse(java.util.List<Object> source) defined by the constraint
     * <code>context Class1
     *       def: testSequenceReverse = source[].reverse()</code></p>
     */
    java.util.List<Object> around(testpackage.Class1 aClass, java.util.List<Object> source): testSequenceReverseCaller(aClass, source) {
        return tudresden.ocl20.pivot.ocl22java.types.util.OclSequences.reverse(source);
    }
}