/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X1PFcpHelper extends XPFcpHelper
{
    private XPFcpHelper _xPFcpHelper_;
    private PFcpHelper _pFcpHelper_;

    public X1PFcpHelper()
    {
    }

    public X1PFcpHelper(
        XPFcpHelper _xPFcpHelper_,
        PFcpHelper _pFcpHelper_)
    {
        setXPFcpHelper(_xPFcpHelper_);
        setPFcpHelper(_pFcpHelper_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPFcpHelper getXPFcpHelper()
    {
        return _xPFcpHelper_;
    }

    public void setXPFcpHelper(XPFcpHelper node)
    {
        if(_xPFcpHelper_ != null)
        {
            _xPFcpHelper_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPFcpHelper_ = node;
    }

    public PFcpHelper getPFcpHelper()
    {
        return _pFcpHelper_;
    }

    public void setPFcpHelper(PFcpHelper node)
    {
        if(_pFcpHelper_ != null)
        {
            _pFcpHelper_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pFcpHelper_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPFcpHelper_ == child)
        {
            _xPFcpHelper_ = null;
        }

        if(_pFcpHelper_ == child)
        {
            _pFcpHelper_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPFcpHelper_) +
            toString(_pFcpHelper_);
    }
}
