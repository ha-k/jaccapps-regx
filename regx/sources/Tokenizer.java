// FILE. . . . . /home/hak/hlt/src/hlt/language/jaccapps/regx/sources/Tokenizer.java
// EDIT BY . . . Hassan Ait-Kaci
// ON MACHINE. . Hp-Dv7
// STARTED ON. . Thu Oct 18 17:27:01 2012

/**
 * @version     Last modified on Thu Oct 18 17:27:59 2012 by hak
 * @author      <a href="mailto:hak@acm.org">Hassan A&iuml;t-Kaci</a>
 * @copyright   &copy; <a href="http://www.hassan-ait-kaci.net/">by the author</a>
 */

package hlt.regx;

import java.io.*;
import java.util.Date;

import hlt.language.syntax.*;
import hlt.language.util.Location;
import hlt.language.io.StreamTokenizer;

public class Tokenizer implements hlt.language.syntax.Tokenizer
{
  BufferedReader reader;
  StreamTokenizer input;
  String file = "stdin";

  Tokenizer () throws IOException
    {
      setupReader(new InputStreamReader(System.in));
      interactive = true;
      banner();
      prompt();
    }

  Tokenizer (File file) throws IOException
    {
      setupReader(new FileReader(file));
      this.file = file.toString();
      interactive = false;
      System.out.println("*** BATCH MODE: Parsing file: "+file);
    }

  private void setupReader (Reader rd)
    {
      setReader(rd);
      input = new StreamTokenizer(reader);
      input.ordinaryChars("|.?+*^_~();");
      input.quoteChar('\'');
      input.quoteChar('"');
      input.slashSlashComments(true);
      input.parseDigitsOnly();
    }

  public final int lineNumber()
    {
      return input.getLineNumber();
    }

  public final void setReader (Reader rd)
    {
      reader = new BufferedReader(rd);
    }

  public final Reader getReader ()
    {
      return reader;
    }

  public static boolean interactive;
  static String prompt = "> ";

  public static final void prompt ()
    {
      if (interactive)
        {
          System.out.print(prompt);
        }
    }

  static public final void setPrompt(String p)
    {
      prompt = p;
    }

  static String banner = "*** Welcome to the Regular Expression Normalizer!\n"+
                         "*** Session of "+ (new Date()+"\n\n"+
                         "*** [enter 'help;' for help]\n");

  public static final void banner ()
    {
      System.out.println(banner);
    }

  final boolean isOtherChar (int c)
    {
      return input.isOrdinaryChar(c)
        && !(input.isWhitespaceChar(c) || c == '(' || c == ')' || c == ',');
    }

  final ParseNode locate (ParseNode node)
    {
      return ((ParseNode)node.setStart(input.tokenStart()).setEnd(input.tokenEnd()))
	.setFile(file);
    }

  final ParseNode locate (ParseNode node, Location start)
    {
      return ((ParseNode)node.setStart(start).setEnd(input.tokenEnd()))
	.setFile(file);
    }

  public ParseNode nextToken() throws IOException
    {
      ParseNode t = null;

      switch (input.nextToken())
        {
        case StreamTokenizer.TT_EOF:
          reader.close();
          t = GenericParser.E_O_I;
          break;
        case '\'': case '"':
        case StreamTokenizer.TT_WORD:
	  if (input.sval == "quit" || input.sval == "trace" || input.sval == "help" || input.sval == "syntax")
	    t = GenericParser.literalToken(input.sval);
	  else
	    t = GenericParser.symbolToken("IDENTIFIER",input.sval);
          break;
        case StreamTokenizer.TT_NUMBER:
          if (input.isInteger)
            t = GenericParser.numberToken("NUMBER",(int)input.nval);
          else
            t = GenericParser.numberToken("NUMBER",input.nval);
          break;
        default:
          t = GenericParser.literalToken(String.valueOf((char)input.ttype));
        }

      locate(t);
      return t;
    }
}
