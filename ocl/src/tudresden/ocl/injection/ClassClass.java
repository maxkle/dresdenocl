/*
Copyright (C) 2000  Ralf Wiebicke

This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation; either
version 2.1 of the License, or (at your option) any later version.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, write to the Free Software
Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/

package tudresden.ocl.injection;

public class ClassClass extends ClassFeature
{

  private String packagename;

  /**
     @parameter parent may be null for non-inner classes
     @parameter packagename may be null for root package
  */
  public ClassClass(ClassClass parent, 
                    String packagename, 
                    int modifiers, 
                    String name)
    throws InjectorParseException
  {
    super(parent, modifiers, null, name);
    this.packagename=packagename;

    if(parent!=null && parent.getPackageName()!=packagename)
      throw new RuntimeException();
  }

  public String getPackageName()
  {
    return packagename;
  }

  public String getFullName()
  {
    StringBuffer buf=new StringBuffer();
    if(packagename!=null)
    {
      buf.append(packagename);
      buf.append('.');
    }
    int pos=buf.length();
    for(ClassClass i=this; i!=null; i=i.getParent())
    {
      if(i!=this)
        buf.insert(pos, '$');
      buf.insert(pos, i.getName());
    }
    return buf.toString();
  }

  public final int getAllowedModifiers()
  {
    return
      java.lang.reflect.Modifier.INTERFACE |
      java.lang.reflect.Modifier.PUBLIC |
      java.lang.reflect.Modifier.PROTECTED |
      java.lang.reflect.Modifier.PRIVATE |
      java.lang.reflect.Modifier.FINAL |
      java.lang.reflect.Modifier.STATIC |
      java.lang.reflect.Modifier.ABSTRACT;
  }

  public final void printMore(java.io.PrintStream o)
  {
    o.println("    package: >"+packagename+"<");
    o.println("    fullnam: >"+getFullName()+"<");
  }

}
