/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AExpression extends PExpression
{
    private final LinkedList _letExpression_ = new TypedLinkedList(new LetExpression_Cast());
    private PLogicalExpression _logicalExpression_;

    public AExpression()
    {
    }

    public AExpression(
        List _letExpression_,
        PLogicalExpression _logicalExpression_)
    {
        {
            Object temp[] = _letExpression_.toArray();
            for(int i = 0; i < temp.length; i++)
            {
                this._letExpression_.add(temp[i]);
            }
        }

        setLogicalExpression(_logicalExpression_);

    }

    public AExpression(
        XPLetExpression _letExpression_,
        PLogicalExpression _logicalExpression_)
    {
        if(_letExpression_ != null)
        {
            while(_letExpression_ instanceof X1PLetExpression)
            {
                this._letExpression_.addFirst(((X1PLetExpression) _letExpression_).getPLetExpression());
                _letExpression_ = ((X1PLetExpression) _letExpression_).getXPLetExpression();
            }
            this._letExpression_.addFirst(((X2PLetExpression) _letExpression_).getPLetExpression());
        }

        setLogicalExpression(_logicalExpression_);

    }
    public Object clone()
    {
        return new AExpression(
            cloneList(_letExpression_),
            (PLogicalExpression) cloneNode(_logicalExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAExpression(this);
    }

    public LinkedList getLetExpression()
    {
        return _letExpression_;
    }

    public void setLetExpression(List list)
    {
        Object temp[] = list.toArray();
        for(int i = 0; i < temp.length; i++)
        {
            _letExpression_.add(temp[i]);
        }
    }

    public PLogicalExpression getLogicalExpression()
    {
        return _logicalExpression_;
    }

    public void setLogicalExpression(PLogicalExpression node)
    {
        if(_logicalExpression_ != null)
        {
            _logicalExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _logicalExpression_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_letExpression_)
            + toString(_logicalExpression_);
    }

    void removeChild(Node child)
    {
        if(_letExpression_.remove(child))
        {
            return;
        }

        if(_logicalExpression_ == child)
        {
            _logicalExpression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        for(ListIterator i = _letExpression_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        if(_logicalExpression_ == oldChild)
        {
            setLogicalExpression((PLogicalExpression) newChild);
            return;
        }

    }

    private class LetExpression_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PLetExpression node = (PLetExpression) o;

            if((node.parent() != null) &&
                (node.parent() != AExpression.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AExpression.this))
            {
                node.parent(AExpression.this);
            }

            return node;
        }
    }
}
