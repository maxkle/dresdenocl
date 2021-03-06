package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_staticDefProperty01 {

    /**
     * <p>Defines the field staticDefProperty01 defined by the constraint
     * <code>context Class1
     *       static def: staticDefProperty01: Integer =  42</code></p>
     */
    public static Integer testpackage.Class1.staticDefProperty01;

    /**
     * <p>Getter method for the attribute staticDefProperty01.</p>
     */
    public static Integer testpackage.Class1.getStaticDefProperty01() {
        return testpackage.Class1.staticDefProperty01;
    }
    /**
     * <p>Pointcut for all requests on {@link testpackage.Class1#staticDefProperty01}.</p>
     */
    protected pointcut staticDefProperty01Getter() :
    	get(static * testpackage.Class1.staticDefProperty01);

    /**
     * <p>Initializes the attribute staticDefProperty01 defined by the constraint
     * <code>context Class1
     *       static def: staticDefProperty01: Integer =  42</code></p>
     */
    before(): staticDefProperty01Getter() {
        testpackage.Class1.staticDefProperty01 = new Integer(42);
    }
}