/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X1PFormalParameterListTail extends XPFormalParameterListTail
{
    private XPFormalParameterListTail _xPFormalParameterListTail_;
    private PFormalParameterListTail _pFormalParameterListTail_;

    public X1PFormalParameterListTail()
    {
    }

    public X1PFormalParameterListTail(
        XPFormalParameterListTail _xPFormalParameterListTail_,
        PFormalParameterListTail _pFormalParameterListTail_)
    {
        setXPFormalParameterListTail(_xPFormalParameterListTail_);
        setPFormalParameterListTail(_pFormalParameterListTail_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPFormalParameterListTail getXPFormalParameterListTail()
    {
        return _xPFormalParameterListTail_;
    }

    public void setXPFormalParameterListTail(XPFormalParameterListTail node)
    {
        if(_xPFormalParameterListTail_ != null)
        {
            _xPFormalParameterListTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPFormalParameterListTail_ = node;
    }

    public PFormalParameterListTail getPFormalParameterListTail()
    {
        return _pFormalParameterListTail_;
    }

    public void setPFormalParameterListTail(PFormalParameterListTail node)
    {
        if(_pFormalParameterListTail_ != null)
        {
            _pFormalParameterListTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pFormalParameterListTail_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPFormalParameterListTail_ == child)
        {
            _xPFormalParameterListTail_ = null;
        }

        if(_pFormalParameterListTail_ == child)
        {
            _pFormalParameterListTail_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPFormalParameterListTail_) +
            toString(_pFormalParameterListTail_);
    }
}
