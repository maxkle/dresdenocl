/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class AEmptyRelationalExpression extends PRelationalExpression
{

    public AEmptyRelationalExpression()
    {
    }
    public Object clone()
    {
        return new AEmptyRelationalExpression();
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAEmptyRelationalExpression(this);
    }

    public String toString()
    {
        return "";
    }

    void removeChild(Node child)
    {
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }
}
