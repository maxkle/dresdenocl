/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AGteqRelationalOperator extends PRelationalOperator
{
    private TGteq _gteq_;

    public AGteqRelationalOperator()
    {
    }

    public AGteqRelationalOperator(
        TGteq _gteq_)
    {
        setGteq(_gteq_);

    }
    public Object clone()
    {
        return new AGteqRelationalOperator(
            (TGteq) cloneNode(_gteq_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGteqRelationalOperator(this);
    }

    public TGteq getGteq()
    {
        return _gteq_;
    }

    public void setGteq(TGteq node)
    {
        if(_gteq_ != null)
        {
            _gteq_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _gteq_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_gteq_);
    }

    void removeChild(Node child)
    {
        if(_gteq_ == child)
        {
            _gteq_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_gteq_ == oldChild)
        {
            setGteq((TGteq) newChild);
            return;
        }

    }
}
