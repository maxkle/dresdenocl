package tudresden.ocl20.pivot.interpreter.event.internal;

import java.util.EventObject;

import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.essentialocl.standardlibrary.OclAny;
import tudresden.ocl20.pivot.interpreter.IInterpreterRegistry;

/**
 * 
 * @author Ronny
 * TODO: Ronny Document this
 */
public class InterpreterTraceEvent extends EventObject{
	
	private static final long serialVersionUID = -7975866761417314905L;
	
	private OclAny result;
	private OclExpression expression;

	public InterpreterTraceEvent(IInterpreterRegistry source, OclExpression expression, OclAny result) {
		super(source);
		
		this.expression = expression;
		this.result = result;
	}
	
	public OclAny getResult(){
		return this.result;
	}
	
	public OclExpression getExpression() {
		return this.expression;
	}
	
	@Override
	public IInterpreterRegistry getSource() {
		return (IInterpreterRegistry) super.getSource();
	}
	
}