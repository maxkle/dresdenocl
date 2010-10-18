package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testBooleanToString {

    /**
     * <p>Defines the method testBooleanToString(Boolean source) defined by the constraint
     * <code>context Class1
     *       def: testBooleanToString(source: Boolean): String =
    source.toString()</code></p>
     */
    public String testpackage.Class1.testBooleanToString(Boolean source) {
        return source.toString();
    }
}