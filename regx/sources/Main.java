// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/regx/sources/Main.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Thu Oct 18 17:16:36 2012

/**
 * @version     Last modified on Thu Oct 18 17:19:48 2012 by hak
 * @author      <a href="mailto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

package hlt.regx;

import java.io.File;

public class Main
{
  public static void main (String[] args)
    {
      try
        {
          Tokenizer t;

          if(args.length>0)
	    {
	      t = new Tokenizer(new File(args[0]));
	    }
          else
            t = new Tokenizer();

          try
            {
              new Parser(t).parse();
            }
          catch (Exception e)
            {
              System.out.println("*** Parsing error: "+e);
	      e.printStackTrace();
            }
        }
      catch (Exception e)
        {
          System.out.println("*** Tokenizing error: "+e);
        }
    }
}
