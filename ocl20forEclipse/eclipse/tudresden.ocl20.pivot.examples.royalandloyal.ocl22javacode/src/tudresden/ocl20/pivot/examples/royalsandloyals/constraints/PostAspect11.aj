package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect PostAspect11 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Date#now()}.</p>
     */
    protected pointcut nowCaller():
    	execution(* tudresden.ocl20.pivot.examples.royalsandloyals.Date.now());
    
    /**
     * <p>Checks a postcondition for the now() defined by the constraint
     * <code>context Date::now() : tudresden.ocl20.pivot.examples.royalsandloyals.Date
     *       post: result[].oclIsUndefined().not()</code></p>
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