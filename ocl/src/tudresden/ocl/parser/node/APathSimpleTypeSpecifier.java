/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class APathSimpleTypeSpecifier extends PSimpleTypeSpecifier
{
    private PPathTypeName _pathTypeName_;

    public APathSimpleTypeSpecifier()
    {
    }

    public APathSimpleTypeSpecifier(
        PPathTypeName _pathTypeName_)
    {
        setPathTypeName(_pathTypeName_);

    }
    public Object clone()
    {
        return new APathSimpleTypeSpecifier(
            (PPathTypeName) cloneNode(_pathTypeName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAPathSimpleTypeSpecifier(this);
    }

    public PPathTypeName getPathTypeName()
    {
        return _pathTypeName_;
    }

    public void setPathTypeName(PPathTypeName node)
    {
        if(_pathTypeName_ != null)
        {
            _pathTypeName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pathTypeName_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_pathTypeName_);
    }

    void removeChild(Node child)
    {
        if(_pathTypeName_ == child)
        {
            _pathTypeName_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_pathTypeName_ == oldChild)
        {
            setPathTypeName((PPathTypeName) newChild);
            return;
        }

    }
}
