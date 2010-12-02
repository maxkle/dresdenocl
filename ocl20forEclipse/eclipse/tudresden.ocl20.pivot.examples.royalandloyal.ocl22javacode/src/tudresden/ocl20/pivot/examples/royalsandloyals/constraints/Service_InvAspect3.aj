package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Service_InvAspect3 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Service#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Service aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.Service.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class Service defined by the constraint
     * <code>context Service
     *       inv: self.oclIsInvalid() = false</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Service aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of Service. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Service")) {
        Boolean result1;
        
        /* Check if the expression results in invalid. */
        try {
            /* DUMMY variable is necessary to form literals into a statement. */
            Object DUMMY = aClass; 
            result1 = false;
        }
        
        catch (Exception e) {
            result1 = true;
        }
    
        if (!((Object) result1).equals(new Boolean(false))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}