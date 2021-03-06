package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testBagAsSet {

    /**
     * <p>Defines the method testBagAsSet(java.util.List<Object> source) defined by the constraint
     * <code>context Class1
     *       def: testBagAsSet(source: Bag(OclAny)):    Set(OclAny) = source ->asSet()</code></p>
     */
    public java.util.Set<Object> testpackage.Class1.testBagAsSet(java.util.List<Object> source) {
        return org.dresdenocl.tools.codegen.ocl2java.types.util.OclBags.asSet(source);
    }
}