/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TBar extends Token
{
    public TBar()
    {
        super.setText("|");
    }

    public TBar(int line, int pos)
    {
        super.setText("|");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TBar(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTBar(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TBar text.");
    }
}
