/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ALitColPrimaryExpression extends PPrimaryExpression
{
    private PLiteralCollection _literalCollection_;

    public ALitColPrimaryExpression()
    {
    }

    public ALitColPrimaryExpression(
        PLiteralCollection _literalCollection_)
    {
        setLiteralCollection(_literalCollection_);

    }
    public Object clone()
    {
        return new ALitColPrimaryExpression(
            (PLiteralCollection) cloneNode(_literalCollection_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALitColPrimaryExpression(this);
    }

    public PLiteralCollection getLiteralCollection()
    {
        return _literalCollection_;
    }

    public void setLiteralCollection(PLiteralCollection node)
    {
        if(_literalCollection_ != null)
        {
            _literalCollection_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _literalCollection_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_literalCollection_);
    }

    void removeChild(Node child)
    {
        if(_literalCollection_ == child)
        {
            _literalCollection_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_literalCollection_ == oldChild)
        {
            setLiteralCollection((PLiteralCollection) newChild);
            return;
        }

    }
}
