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

package tudresden.ocl.check.types.xmifacade;

import java.util.*;
import tudresden.ocl.check.types.*;
import tudresden.ocl.check.OclTypeException;

/**
   Implements ModelFacade using model information of a xmi file.

   Additional notes:

   An attribute overrides an inherited attribute, if and and only if it has the same name.
   Ordinary attributes and attributes generated by association partner role names are
   handled equally.
   If an ambiguity is caused by this behaviour, the attribute name is marked to be
   ambiguious for this class, and cannot be used for OCL any more (see OCL spec 5.4.1).
   This ambiguity is inherited to all classes, which do not override this attribute name.
   However, overriding such an ambiguious attribute in a subclass makes this attribute
   available for the subclass and its subclasses again.

   Overriding attributes is considered to be unnormal, and issues a warning to standard out.

   An operation overrides an inherited operation, if and only if it has the same signature.
   The signature consist of the name and a vector of parameter types. Note, that parameter
   types must be exactly equal. Matching by inheritance is not enough.

   Overriding an operation with a different return type is considered to be unnormal,
   and issues a warning to standard out.

   If you dont like the warnings, edit ModelClass.flatten for your needs.
   @see #flatten()
*/
public final class Model implements ModelFacade
{
  /**
     Maps classifier names to ModelClass objects.
     @see ModelClass
  */
  private HashMap classifiers=new HashMap();

  /**
     A description of the source of this model.
     Usually the xmi file.
     Should be independent from system environment,
     so that regression tests have always the same description.
  */
  private String description;
  
  public Model(String description)
  {
    this.description=description;
  }

  /**
     Flattens all classes in model.
  */
  public void flatten()
  {
    for(Iterator i=classifiers.values().iterator(); i.hasNext(); )
      ((ModelClass)(i.next())).flatten();
  }

  /**
     Useful for debugging.
  */
  public void printData()
  {
    String log;
    try
    {
      log=System.getProperty("tudresden.ocl.check.types.xmifacade.log");
    }
    catch(SecurityException e) {log=null;};

    if(log!=null)
    {
      printData(System.out);
    }
  }

  /**
     Useful for debugging.
  */
  public void printData(java.io.PrintStream o)
  {
    HashSet done=new HashSet();
    for(Iterator i=(new TreeSet(classifiers.keySet())).iterator(); i.hasNext(); )
    {
      String classname=(String)i.next();
      ModelClass classobject=(ModelClass)classifiers.get(classname);
      o.println("classifier "+classname+" --> "+classobject.getFullName());
      if(done.add(classobject))
        classobject.printData(o);
    }
  }

  public void putClassifier(ModelClass modelclass)
  {
    String fullname =modelclass.getFullName();
    String shortname=modelclass.getShortName();

    if(classifiers.put(fullname, modelclass)!=null)
      throw new ModelException("ambigous classifier name: "+fullname);

    if(!shortname.equals(fullname))
      if(classifiers.put(shortname, modelclass)!=null)
        throw new ModelException("ambigous classifier name: "+shortname);

    modelclass.setModel(this);
  }

  public static String strip(String x)
  {
    if(x.indexOf((int)' ')<0)
      return x;

    StringBuffer buf=new StringBuffer();
    for(int i=0; i<x.length(); i++)
    {
      char c=x.charAt(i);
      if(c!=' ')
        buf.append(c);
    }
    //System.out.println("stripping "+x+" to "+buf);
    return buf.toString();
  }

  public Any getClassifier(String name)
  {
    //System.out.println("xmifacade: getClassifier "+name);

    Any a=((Any)classifiers.get(strip(name)));
    if(a==null)
      throw new OclTypeException("Classifier \""+name+"\" in xmifacade["+description+"] not found.");
    return a;
  }

  /**
     A dummy type for Void, since Basic does not provide one.
     Used for internal structure only. Is never returned to users of XmiModelFacade.
     @see tudresden.ocl.check.types.Basic
  */
  public static final Any VOID=new Any()
  {
    public Type navigateQualified(String name, Type[] qualifiers) throws OclTypeException
    {
      throw new IllegalArgumentException("called Model.VOID.navigateQualified(\""+qualifierString(name,qualifiers)+"\"), this should never happen.");
    }

    public Type navigateParameterized(String name, Type[] params) throws OclTypeException
    {
      throw new IllegalArgumentException("called Model.VOID.navigateParameterized(\""+signatureString(name,params)+"\"), this should never happen.");
    }

    public boolean hasState(String name)
    {
      return false;
    }

    public boolean conformsTo(Type type)
    {
      return (this==type);
    }

    public String toString()
    {
      return "void";
    }
  };

  /**
     Indicates, that a ModelAttribute is ambiguiuos, thus cannot be used in OCL.
     @see ModelAttribute
  */
  public static final Any AMBIGOUS=new Any()
  {
    public Type navigateQualified(String name, Type[] qualifiers) throws OclTypeException
    {
      throw new IllegalArgumentException(
        "called Model.AMBIGOUS.navigateQualified(\""+qualifierString(name,qualifiers)+"\"), this should never happen.");
    }

    public Type navigateParameterized(String name, Type[] params) throws OclTypeException
    {
      throw new IllegalArgumentException(
        "called Model.AMBIGOUS.navigateParameterized(\""+signatureString(name,params)+"\"), this should never happen.");
    }

    public boolean hasState(String name)
    {
      return false;
    }

    public boolean conformsTo(Type type)
    {
      throw new IllegalArgumentException(
        "called Model.AMBIGOUS.conformsTo(\""+type+"\"), this should never happen.");
    }

    public String toString()
    {
      return "AMBIGOUS";
    }
  };

  public String toString()
  {
    return getClass().toString()+"("+description+")";
  }

  /**
     Makes a nice string from a method signature or a qualified feature.
     The result looks like Java source code.
  */
  public static String signatureString(String name, Type[] params)
  {
    return stringOf(name, params, '(', ')');
  }

  public static String qualifierString(String name, Type[] qualifiers)
  {
    if(qualifiers==null)
      return name;
    else
      return stringOf(name, qualifiers, '[', ']');
  }

  private static String stringOf(String name, Type[] params, char openBracket, char closeBracket)
  {
    StringBuffer b=new StringBuffer(name);
    b.append(openBracket);
    for(int i=0; i<params.length; i++)
    {
      b.append(typeString(params[i]));
      if(i<(params.length-1)) b.append(',');
    }
    b.append(closeBracket);
    return new String(b);
  }


  /**
     Basic.toString returns "Integer" instead of "int", which can't
     be distiguished from class Integer.
     Used for debugging output only.
     @see tudresden.ocl.check.types.Basic#toString()
  */
  public static String typeString(Type t)
  {
    return
     (t instanceof Basic) ?
     t.toString().toLowerCase() :
     t.toString();
  }
}
