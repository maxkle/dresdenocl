/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X2PConstraintBody extends XPConstraintBody
{
    private PConstraintBody _pConstraintBody_;

    public X2PConstraintBody()
    {
    }

    public X2PConstraintBody(
        PConstraintBody _pConstraintBody_)
    {
        setPConstraintBody(_pConstraintBody_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PConstraintBody getPConstraintBody()
    {
        return _pConstraintBody_;
    }

    public void setPConstraintBody(PConstraintBody node)
    {
        if(_pConstraintBody_ != null)
        {
            _pConstraintBody_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pConstraintBody_ = node;
    }

    void removeChild(Node child)
    {
        if(_pConstraintBody_ == child)
        {
            _pConstraintBody_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pConstraintBody_);
    }
}
