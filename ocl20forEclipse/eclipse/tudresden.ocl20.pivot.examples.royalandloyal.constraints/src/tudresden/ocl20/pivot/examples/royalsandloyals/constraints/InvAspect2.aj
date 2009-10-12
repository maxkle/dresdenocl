package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect InvAspect2 {

    /**
     * <p>Describes all Constructors of the class {@link tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard}.</p>
     */
    protected pointcut allCustomerCardConstructors(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass):
        execution(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard.new(..)) && this(aClass);
    
    /**
     * <p>Pointcut for all changes of the attribute {@link tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard#validFrom}.</p>
     */
    protected pointcut validFromSetter(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass) :
        set(* tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard.validFrom) && this(aClass); 

    /**
     * <p>Pointcut for all changes of the attribute {@link tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard#validThru}.</p>
     */
    protected pointcut validThruSetter(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass) :
        set(* tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard.validThru) && this(aClass); 
    
    /**
     * <p>Pointcut to collect all attributeSetters.</p>
     */
    protected pointcut allSetters(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass) :
    	validFromSetter(aClass)
    	|| validThruSetter(aClass);
    /**
     * <p><code>Checks an invariant on the class CustomerCard defined by the constraint
     * <code>context CustomerCard
     *       inv: validFrom[].isBefore( validThru[])</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass) : allCustomerCardConstructors(aClass) || allSetters(aClass) {
        /* Disable this constraint for subclasses of CustomerCard. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard")) {
        if (!aClass.validFrom.isBefore(aClass.validThru)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}