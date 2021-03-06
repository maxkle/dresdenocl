package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testCollectionIncludes {

    /**
     * <p>Defines the method testCollectionIncludes(java.util.Collection<Object> source, Object arg01) defined by the constraint
     * <code>context Class1
     *       def: testCollectionIncludes(source: Collection(OclAny), arg01: OclAny): Boolean = source ->includes(arg01)</code></p>
     */
    public Boolean testpackage.Class1.testCollectionIncludes(java.util.Collection<Object> source, Object arg01) {
        return org.dresdenocl.tools.codegen.ocl2java.types.util.OclCollections.includes(source, arg01);
    }
}