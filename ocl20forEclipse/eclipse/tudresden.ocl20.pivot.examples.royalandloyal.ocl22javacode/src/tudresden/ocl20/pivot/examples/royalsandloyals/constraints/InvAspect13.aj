package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect InvAspect13 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedLoyaltyAccount;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class LoyaltyAccount defined by the constraint
     * <code>context LoyaltyAccount
     *       inv: points[].>( 0).implies( transactions[] -> exists ( , t | t[].points[].>( 0)))</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of LoyaltyAccount. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount")) {
        Boolean result1;
        result1 = false;
        
        /* Iterator Exists: Iterate and check, if any element fulfills the condition. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement1 : aClass.transactions) {
            if ((anElement1.points > new Integer(0))) {
                result1 = true;
                break;
            }
            // no else
        }
    
        if (!(!(aClass.points > new Integer(0)) || result1)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}