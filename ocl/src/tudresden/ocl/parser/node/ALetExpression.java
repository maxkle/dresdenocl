/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ALetExpression extends PLetExpression
{
    private TTLet _tLet_;
    private TName _name_;
    private PLetExpressionTypeDeclaration _letExpressionTypeDeclaration_;
    private TEqual _equal_;
    private PExpression _expression_;
    private TTIn _tIn_;

    public ALetExpression()
    {
    }

    public ALetExpression(
        TTLet _tLet_,
        TName _name_,
        PLetExpressionTypeDeclaration _letExpressionTypeDeclaration_,
        TEqual _equal_,
        PExpression _expression_,
        TTIn _tIn_)
    {
        setTLet(_tLet_);

        setName(_name_);

        setLetExpressionTypeDeclaration(_letExpressionTypeDeclaration_);

        setEqual(_equal_);

        setExpression(_expression_);

        setTIn(_tIn_);

    }
    public Object clone()
    {
        return new ALetExpression(
            (TTLet) cloneNode(_tLet_),
            (TName) cloneNode(_name_),
            (PLetExpressionTypeDeclaration) cloneNode(_letExpressionTypeDeclaration_),
            (TEqual) cloneNode(_equal_),
            (PExpression) cloneNode(_expression_),
            (TTIn) cloneNode(_tIn_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALetExpression(this);
    }

    public TTLet getTLet()
    {
        return _tLet_;
    }

    public void setTLet(TTLet node)
    {
        if(_tLet_ != null)
        {
            _tLet_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tLet_ = node;
    }

    public TName getName()
    {
        return _name_;
    }

    public void setName(TName node)
    {
        if(_name_ != null)
        {
            _name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _name_ = node;
    }

    public PLetExpressionTypeDeclaration getLetExpressionTypeDeclaration()
    {
        return _letExpressionTypeDeclaration_;
    }

    public void setLetExpressionTypeDeclaration(PLetExpressionTypeDeclaration node)
    {
        if(_letExpressionTypeDeclaration_ != null)
        {
            _letExpressionTypeDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _letExpressionTypeDeclaration_ = node;
    }

    public TEqual getEqual()
    {
        return _equal_;
    }

    public void setEqual(TEqual node)
    {
        if(_equal_ != null)
        {
            _equal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _equal_ = node;
    }

    public PExpression getExpression()
    {
        return _expression_;
    }

    public void setExpression(PExpression node)
    {
        if(_expression_ != null)
        {
            _expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _expression_ = node;
    }

    public TTIn getTIn()
    {
        return _tIn_;
    }

    public void setTIn(TTIn node)
    {
        if(_tIn_ != null)
        {
            _tIn_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tIn_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tLet_)
            + toString(_name_)
            + toString(_letExpressionTypeDeclaration_)
            + toString(_equal_)
            + toString(_expression_)
            + toString(_tIn_);
    }

    void removeChild(Node child)
    {
        if(_tLet_ == child)
        {
            _tLet_ = null;
            return;
        }

        if(_name_ == child)
        {
            _name_ = null;
            return;
        }

        if(_letExpressionTypeDeclaration_ == child)
        {
            _letExpressionTypeDeclaration_ = null;
            return;
        }

        if(_equal_ == child)
        {
            _equal_ = null;
            return;
        }

        if(_expression_ == child)
        {
            _expression_ = null;
            return;
        }

        if(_tIn_ == child)
        {
            _tIn_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_tLet_ == oldChild)
        {
            setTLet((TTLet) newChild);
            return;
        }

        if(_name_ == oldChild)
        {
            setName((TName) newChild);
            return;
        }

        if(_letExpressionTypeDeclaration_ == oldChild)
        {
            setLetExpressionTypeDeclaration((PLetExpressionTypeDeclaration) newChild);
            return;
        }

        if(_equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(_expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        if(_tIn_ == oldChild)
        {
            setTIn((TTIn) newChild);
            return;
        }

    }
}
