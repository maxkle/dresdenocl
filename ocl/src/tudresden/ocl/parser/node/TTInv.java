/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TTInv extends Token
{
    public TTInv()
    {
        super.setText("inv");
    }

    public TTInv(int line, int pos)
    {
        super.setText("inv");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TTInv(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTInv(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TTInv text.");
    }
}
