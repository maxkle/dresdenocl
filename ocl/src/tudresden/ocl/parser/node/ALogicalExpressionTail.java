/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ALogicalExpressionTail extends PLogicalExpressionTail
{
    private PLogicalOperator _logicalOperator_;
    private PRelationalExpression _relationalExpression_;

    public ALogicalExpressionTail()
    {
    }

    public ALogicalExpressionTail(
        PLogicalOperator _logicalOperator_,
        PRelationalExpression _relationalExpression_)
    {
        setLogicalOperator(_logicalOperator_);

        setRelationalExpression(_relationalExpression_);

    }
    public Object clone()
    {
        return new ALogicalExpressionTail(
            (PLogicalOperator) cloneNode(_logicalOperator_),
            (PRelationalExpression) cloneNode(_relationalExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALogicalExpressionTail(this);
    }

    public PLogicalOperator getLogicalOperator()
    {
        return _logicalOperator_;
    }

    public void setLogicalOperator(PLogicalOperator node)
    {
        if(_logicalOperator_ != null)
        {
            _logicalOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _logicalOperator_ = node;
    }

    public PRelationalExpression getRelationalExpression()
    {
        return _relationalExpression_;
    }

    public void setRelationalExpression(PRelationalExpression node)
    {
        if(_relationalExpression_ != null)
        {
            _relationalExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _relationalExpression_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_logicalOperator_)
            + toString(_relationalExpression_);
    }

    void removeChild(Node child)
    {
        if(_logicalOperator_ == child)
        {
            _logicalOperator_ = null;
            return;
        }

        if(_relationalExpression_ == child)
        {
            _relationalExpression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_logicalOperator_ == oldChild)
        {
            setLogicalOperator((PLogicalOperator) newChild);
            return;
        }

        if(_relationalExpression_ == oldChild)
        {
            setRelationalExpression((PRelationalExpression) newChild);
            return;
        }

    }
}
