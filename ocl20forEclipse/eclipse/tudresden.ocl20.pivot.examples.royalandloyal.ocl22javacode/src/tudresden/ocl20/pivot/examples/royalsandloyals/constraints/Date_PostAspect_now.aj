package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Date_PostAspect_now {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Date#now()}.</p>
     */
    protected pointcut nowCaller():
    	execution(* tudresden.ocl20.pivot.examples.royalsandloyals.Date.now());
    
    /**
     * <p>Checks a postcondition for the operation {@link Date#now()} defined by the constraint
     * <code>context Date::now() : tudresden.ocl20.pivot.examples.royalsandloyals.Date
     *       post: not result.oclIsUndefined()</code></p>
     */
    tudresden.ocl20.pivot.examples.royalsandloyals.Date around(): nowCaller() {
    
        tudresden.ocl20.pivot.examples.royalsandloyals.Date result;
        result = proceed();
    
        if (!!(result == null)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
    
        return result;
    }
}