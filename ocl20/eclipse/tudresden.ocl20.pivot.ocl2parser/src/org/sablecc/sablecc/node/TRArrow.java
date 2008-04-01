/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;

public final class TRArrow extends Token
{
    public TRArrow()
    {
        super.setText("->");
    }

    public TRArrow(int line, int pos)
    {
        super.setText("->");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TRArrow(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRArrow(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TRArrow text.");
    }
}