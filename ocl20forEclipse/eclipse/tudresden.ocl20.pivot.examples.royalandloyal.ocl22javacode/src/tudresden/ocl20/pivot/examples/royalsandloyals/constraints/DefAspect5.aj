package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect DefAspect5 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.Customer extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedCustomer;
    
    /**
     * <p>Pointcut for all requests on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Customer#initial}.</p>
     */
    protected pointcut initialGetter(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass) :
    	get(* initial) && this(aClass);
    
    /**
     * <p>Initializes the attribute initial defined by the constraint
     * <code>context Customer
     *       def: initial = name[].substring( 1, 1)</code></p>
     */
    before(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass): initialGetter(aClass) {
        aClass.initial = aClass.name.substring(new Integer(1) - 1, new Integer(1));
    }
}