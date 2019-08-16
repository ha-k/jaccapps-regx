// *******************************************************************
// This file has been automatically generated from the grammar in file
// RegExp.grm by hlt.language.syntax.ParserGenerator on
// Thu Mar 29 08:47:59 CEST 2018 --- !!! PLEASE DO NO EDIT !!!
// *******************************************************************

package hlt.regx;

import java.io.Reader;
import java.io.StringReader;
import java.io.IOException;
import hlt.language.syntax.*;
import java.util.HashMap;
import hlt.language.util.*;
import hlt.language.tools.Misc;

public class RegularExpression extends ParseNode 
{
  public RegularExpression (ParseNode node)
    {
      super(node);
    }

  private RegExp expression;

    public RegExp getExpression ()
      {
	return expression;
      }

    public void setExpression (RegExp exp)
      {
	expression = exp;
      }
}
