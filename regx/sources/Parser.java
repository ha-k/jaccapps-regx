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


/* ************ */
/* PARSER CLASS */
/* ************ */

public class Parser extends StaticParser
{
  /* ************************ */
  /* PARSER CLASS CONSTRUCTOR */
  /* ************************ */

  public Parser (Tokenizer t)
    {
      input = t;
      xmlroot = "Session";
    }

  /* ************************* */
  /* PARSER CLASS DECLARATIONS */
  /* ************************* */

  void p ()
    {
      System.out.println();
    }

  void p (String s)
    {
      System.out.println(s);
    }

  void help ()
    {
      p();
      p("Enter one of the following ending with a ';':");
      p();
      p("- a regular expression to normalize - e.g., '(a|b).()'");
      p("- a definition: 'Variable = expression' - e.g., 'Foo = a|b'");
      p("- 'syntax' to have a syntax summary");      
      p("- 'trace' to toggle tracing");      
      p("- 'help' to print these lines");      
      p("- 'quit' to quit");
      p();
      Tokenizer.prompt();
    }

  void syntax ()
    {
      p();
      p("REGULAR EXPRESSION SYNTAX SUMMARY:");
      p("----------------------------------");
      p();
      p("CATEGORY        KIND:   DESCRIPTION                    - EXAMPLE");
      p("--------        -----   -----------                    - -------");
      p("Empty           symbol: ()");
      p("Alphabet        symbol: lowercase-start identifier     - a, foo, bAR");
      p("Variable        symbol: capitalized identifier         - A, Foo, BAR");
      p("Choice          bin-op: infix   '|'    (X or Y)        - a | b");
      p("Concat          bin-op: infix   '.'    (X then Y)      - a . b");
      p("Option          mon-op: postfix '?'    (zero or one)   - a?");
      p("Plus            mon-op: postfix '+'    (one or more)   - a+");
      p("Star            mon-op: postfix '*'    (zero or more)  - a*");
      p("Power           mon-op: postfix '^n'   (exactly n)     - a^2");
      p("Bounded range   mon-op: postfix '_m^n' ('|' of m to n) - a_1^3");
      p("Unbounded range mon-op: postfix '_n~'  (at least n)    - a_2~");
      p();
      p("'|' has less precedence than '.'");
      p("'.' has less precedence than '?', '+', '*', '_', or '^'");
      p("'|' and '.' associate to the right");
      p("'?', '+', '*', '_', and '^' associate to the left");
      p("use parentheses to enforce precedence");
      p();
      Tokenizer.prompt();
    }

  /**
   * The definition store. It associates a <a
   * href="../../../../../../doc/hlt/code/language/util/RegExp.html">
   * <tt>RegExp</tt></a> <tt>E</tt> to a <a
   * href="../../../../../../doc/hlt/code/language/util/RegExpSymbol.html">
   * <tt>RegExpSymbol</tt></a> <tt>s</tt>, which is henceforth
   * interpreted as <tt>E</tt> wherever it occurs, <font
   * color="red"><u><i>including in <tt>E</tt> itself!</i></u></font>.
   */
  HashMap defs = new HashMap();


  /* ********************** */
  /* STATIC INITIALIZATIONS */
  /* ********************** */

  static
    {
      initializeTerminals();
      initializeNonTerminals();
      initializeRules();
      initializeParserActions();
      initializeParserStates();
      initializeActionTables();
      initializeGotoTables();
      initializeStateTables();
    }

  /* ********************* */
  /* PARTIAL PARSE METHODS */
  /* ********************* */

  final static ParseNode $SESSION_SWITCH$ = new ParseNode(terminals[3]);

  public final void parseSession (String s) throws IOException
    {
      parseSession(new StringReader(s));
    }

  public final void parseSession (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($SESSION_SWITCH$);
      parse();
    }

  final static ParseNode $REGULAREXPRESSION_SWITCH$ = new ParseNode(terminals[4]);

  public final void parseRegularExpression (String s) throws IOException
    {
      parseRegularExpression(new StringReader(s));
    }

  public final void parseRegularExpression (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($REGULAREXPRESSION_SWITCH$);
      parse();
    }

  final static ParseNode $DEFINITION_SWITCH$ = new ParseNode(terminals[5]);

  public final void parseDefinition (String s) throws IOException
    {
      parseDefinition(new StringReader(s));
    }

  public final void parseDefinition (Reader r) throws IOException
    {
      input.setReader(r);
      errorManager().recoverFromErrors(false);
      setSwitchToken($DEFINITION_SWITCH$);
      parse();
    }

  /* **************** */
  /* SEMANTIC ACTIONS */
  /* **************** */

  protected ParseNode semanticAction(ParserRule $rule$) throws IOException
    {
      ParseNode $head$ = new ParseNode($rule$.head);

      switch($rule$.index())
        {
          case 2:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 3:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 4:
            {
            $head$ = $head$.copy(node($rule$,2));
            break;
            }
          case 8:
            {
            RegularExpression $node1$;
                if (node($rule$,0) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,0);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,0));
                     replaceStackNode($rule$,0,$node1$);
                   }

  	    RegExp exp = $node1$.getExpression();
  	    RegExp cpy = exp.deepCopy();
  
  	    p("        "+Misc.repeat(30,'='));
  	    p("ORIG:   "+cpy);
  	    p("        "+Misc.repeat(30,'-'));
  
    	    RegExp nrm = exp.normalForm();
  	    p("NORM:   "+nrm.toNormalString());
  	    p("        "+Misc.repeat(30,'='));
  
            Tokenizer.prompt();
            break;
            }
          case 10:
            {
            Definition $node1$;
                if (node($rule$,0) instanceof Definition)
                   $node1$ = (Definition)node($rule$,0);
                 else
                 {
                     $node1$ = new Definition(node($rule$,0));
                     replaceStackNode($rule$,0,$node1$);
                   }

            p($node1$.getMessage());
            Tokenizer.prompt();
            break;
            }
          case 12:
            {
            help();
            break;
            }
          case 14:
            {
            syntax();
            break;
            }
          case 16:
            {
            p("*** Toggling trace ...");
  	    RegExp.toggleTrace();
            break;
            }
          case 18:
            {
            errorManager().reportErrors(true);
            Tokenizer.prompt();
            break;
            }
          case 20:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;

  	    $node0$.setExpression(RegExpSymbol.EMPTY);
            break;
            }
          case 21:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;

  	    String name = node($rule$,1).svalue();
  	    RegExp definition = (RegExp)defs.get(RegExpSymbol.get(name));
  	    if (definition == null)
  	      $node0$.setExpression(RegExpSymbol.get(name));
  	    else
  	      $node0$.setExpression(definition);
            break;
            }
          case 22:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    RegularExpression $node3$;
                if (node($rule$,3) instanceof RegularExpression)
                   $node3$ = (RegularExpression)node($rule$,3);
                 else
                 {
                     $node3$ = new RegularExpression(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

  	    $node0$.setExpression(new RegExpChoice($node1$.getExpression(),
  	  	  	  	  	      $node3$.getExpression()));
            break;
            }
          case 23:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }
    RegularExpression $node3$;
                if (node($rule$,3) instanceof RegularExpression)
                   $node3$ = (RegularExpression)node($rule$,3);
                 else
                 {
                     $node3$ = new RegularExpression(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }

  	    $node0$.setExpression(new RegExpConcat($node1$.getExpression(),
  	  	  	  	  	      $node3$.getExpression()));
            break;
            }
          case 24:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

  	    $node0$.setExpression(new RegExpOption($node1$.getExpression()));
            break;
            }
          case 25:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

  	    $node0$.setExpression(new RegExpPlus($node1$.getExpression()));
            break;
            }
          case 26:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

  	    $node0$.setExpression(new RegExpStar($node1$.getExpression()));
            break;
            }
          case 27:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

  	    $node0$.setExpression(new RegExpPower($node1$.getExpression(),
  	  	  	  	  	     (int)node($rule$,3).nvalue()));
            break;
            }
          case 28:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

  	    $node0$.setExpression(new RegExpPowerRange($node1$.getExpression(),
  	  	  	  	  	  	  (int)node($rule$,3).nvalue(),
  	  	  	  	  	  	  (int)node($rule$,5).nvalue()));
            break;
            }
          case 29:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node1$;
                if (node($rule$,1) instanceof RegularExpression)
                   $node1$ = (RegularExpression)node($rule$,1);
                 else
                 {
                     $node1$ = new RegularExpression(node($rule$,1));
                     replaceStackNode($rule$,1,$node1$);
                   }

  	    $node0$.setExpression(new RegExpPowerRange($node1$.getExpression(),
  	  	  	  	  	  	  (int)node($rule$,3).nvalue()));
            break;
            }
          case 30:
            {
            RegularExpression $node0$ = new RegularExpression($head$);
                 $head$ = (RegularExpression)$node0$;
    RegularExpression $node2$;
                if (node($rule$,2) instanceof RegularExpression)
                   $node2$ = (RegularExpression)node($rule$,2);
                 else
                 {
                     $node2$ = new RegularExpression(node($rule$,2));
                     replaceStackNode($rule$,2,$node2$);
                   }

  	    $node0$.setExpression($node2$.getExpression());
            break;
            }
          case 31:
            {
            RegularExpression $node3$;
                if (node($rule$,3) instanceof RegularExpression)
                   $node3$ = (RegularExpression)node($rule$,3);
                 else
                 {
                     $node3$ = new RegularExpression(node($rule$,3));
                     replaceStackNode($rule$,3,$node3$);
                   }
    Definition $node0$ = new Definition($head$);
                 $head$ = (Definition)$node0$;

  	    String name = node($rule$,1).svalue();
  	    RegExp definition = $node3$.getExpression();
            defs.put(RegExpSymbol.get(name),definition);
            $node0$.setMessage("Defined: "+name+" = "+definition);
  	    $node0$.setSvalue(name);
            break;
            }
          case 32:
            {
            p("Bye bye!...");
  	    System.exit(0);
            break;
            }
          case 0: case 1: case 6: case 34: 
            break;
          default:
            $head$ = $head$.copy(node($rule$,1));
            break;
        }
      return $head$;
    }

  /* **************** */
  /* TERMINAL SYMBOLS */
  /* **************** */

  static void initializeTerminals ()
    {
      terminals = new ParserTerminal[24];

      newTerminal(0,"$EMPTY$",1,2);
      newTerminal(1,"$E_O_I$",1,2);
      newTerminal(2,"error",1,2);
      newTerminal(3,"$Session_switch$",1,2);
      newTerminal(4,"$RegularExpression_switch$",1,2);
      newTerminal(5,"$Definition_switch$",1,2);
      newTerminal(6,"IDENTIFIER",1,2);
      newTerminal(7,"NUMBER",1,2);
      newTerminal(8,"|",11,1);
      newTerminal(9,".",21,1);
      newTerminal(10,"?",31,0);
      newTerminal(11,"+",31,0);
      newTerminal(12,"*",31,0);
      newTerminal(13,"_",31,0);
      newTerminal(14,"^",31,0);
      newTerminal(15,";",1,2);
      newTerminal(16,"help",1,2);
      newTerminal(17,"syntax",1,2);
      newTerminal(18,"trace",1,2);
      newTerminal(19,"(",1,2);
      newTerminal(20,")",1,2);
      newTerminal(21,"~",1,2);
      newTerminal(22,"=",1,2);
      newTerminal(23,"quit",1,2);
    }

  /* ******************** */
  /* NON-TERMINAL SYMBOLS */
  /* ******************** */

  static void initializeNonTerminals ()
    {
      nonterminals = new ParserNonTerminal[16];

      newNonTerminal(0,"$START$");
      newNonTerminal(1,"$ROOTS$");
      newNonTerminal(2,"Session");
      newNonTerminal(3,"RegularExpression");
      newNonTerminal(4,"Definition");
      newNonTerminal(5,"Actions");
      newNonTerminal(6,"Exit_opt");
      newNonTerminal(7,"Action");
      newNonTerminal(8,"$ACTION0$");
      newNonTerminal(9,"$ACTION1$");
      newNonTerminal(10,"$ACTION2$");
      newNonTerminal(11,"$ACTION3$");
      newNonTerminal(12,"$ACTION4$");
      newNonTerminal(13,"$ACTION5$");
      newNonTerminal(14,"Exit");
      newNonTerminal(15,"$ACTION6$");
    }

  /* **************** */
  /* PRODUCTION RULES */
  /* **************** */

  static void initializeRules ()
    {
      rules = new ParserRule[36];

      rules[0] = new ParserRule(0,1,0,1,2);
      rules[1] = new ParserRule(1,1,1,1,2);
      rules[2] = new ParserRule(1,2,2,1,2);
      rules[3] = new ParserRule(1,2,3,1,2);
      rules[4] = new ParserRule(1,2,4,1,2);
      rules[5] = new ParserRule(2,2,5,1,2);
      rules[6] = new ParserRule(5,0,6,1,2);
      rules[7] = new ParserRule(5,2,7,1,2);
      rules[8] = new ParserRule(8,0,8,1,2);
      rules[9] = new ParserRule(7,3,9,1,2);
      rules[10] = new ParserRule(9,0,10,1,2);
      rules[11] = new ParserRule(7,3,11,1,2);
      rules[12] = new ParserRule(10,0,12,1,2);
      rules[13] = new ParserRule(7,3,13,1,2);
      rules[14] = new ParserRule(11,0,14,1,2);
      rules[15] = new ParserRule(7,3,15,1,2);
      rules[16] = new ParserRule(12,0,16,1,2);
      rules[17] = new ParserRule(7,3,17,1,2);
      rules[18] = new ParserRule(13,0,18,1,2);
      rules[19] = new ParserRule(7,3,19,1,2);
      rules[20] = new ParserRule(3,2,20,1,2);
      rules[21] = new ParserRule(3,1,21,1,2);
      rules[22] = new ParserRule(3,3,22,11,1);
      rules[23] = new ParserRule(3,3,23,21,1);
      rules[24] = new ParserRule(3,2,24,31,0);
      rules[25] = new ParserRule(3,2,25,31,0);
      rules[26] = new ParserRule(3,2,26,31,0);
      rules[27] = new ParserRule(3,3,27,1,2);
      rules[28] = new ParserRule(3,5,28,1,2);
      rules[29] = new ParserRule(3,4,29,1,2);
      rules[30] = new ParserRule(3,3,30,1,2);
      rules[31] = new ParserRule(4,3,31,1,2);
      rules[32] = new ParserRule(15,0,32,1,2);
      rules[33] = new ParserRule(14,3,33,1,2);
      rules[34] = new ParserRule(6,0,34,1,2);
      rules[35] = new ParserRule(6,1,35,1,2);
    }

  /* ************** */
  /* PARSER ACTIONS */
  /* ************** */

  static void initializeParserActions ()
    {
      actions = new ParserAction[286];

      newAction(0,5,0);
      newAction(1,2,0);
      newAction(2,0,3);
      newAction(3,0,4);
      newAction(4,0,5);
      newAction(5,1,6);
      newAction(6,1,6);
      newAction(7,1,6);
      newAction(8,1,6);
      newAction(9,1,6);
      newAction(10,1,6);
      newAction(11,1,6);
      newAction(12,1,6);
      newAction(13,1,1);
      newAction(14,1,6);
      newAction(15,1,6);
      newAction(16,1,6);
      newAction(17,1,6);
      newAction(18,1,6);
      newAction(19,1,6);
      newAction(20,1,6);
      newAction(21,1,6);
      newAction(22,0,11);
      newAction(23,0,43);
      newAction(24,0,54);
      newAction(25,1,34);
      newAction(26,0,10);
      newAction(27,0,11);
      newAction(28,0,12);
      newAction(29,0,15);
      newAction(30,0,16);
      newAction(31,0,17);
      newAction(32,0,18);
      newAction(33,1,5);
      newAction(34,1,7);
      newAction(35,1,7);
      newAction(36,1,7);
      newAction(37,1,7);
      newAction(38,1,7);
      newAction(39,1,7);
      newAction(40,1,7);
      newAction(41,1,7);
      newAction(42,1,35);
      newAction(43,1,32);
      newAction(44,0,48);
      newAction(45,0,11);
      newAction(46,0,43);
      newAction(47,1,21);
      newAction(48,1,21);
      newAction(49,1,21);
      newAction(50,1,21);
      newAction(51,1,21);
      newAction(52,1,21);
      newAction(53,1,21);
      newAction(54,1,21);
      newAction(55,0,46);
      newAction(56,0,30);
      newAction(57,0,31);
      newAction(58,0,32);
      newAction(59,0,33);
      newAction(60,0,34);
      newAction(61,0,35);
      newAction(62,0,36);
      newAction(63,1,8);
      newAction(64,1,10);
      newAction(65,1,12);
      newAction(66,1,14);
      newAction(67,1,16);
      newAction(68,1,18);
      newAction(69,0,20);
      newAction(70,1,19);
      newAction(71,1,19);
      newAction(72,1,19);
      newAction(73,1,19);
      newAction(74,1,19);
      newAction(75,1,19);
      newAction(76,1,19);
      newAction(77,1,19);
      newAction(78,0,22);
      newAction(79,1,17);
      newAction(80,1,17);
      newAction(81,1,17);
      newAction(82,1,17);
      newAction(83,1,17);
      newAction(84,1,17);
      newAction(85,1,17);
      newAction(86,1,17);
      newAction(87,0,24);
      newAction(88,1,15);
      newAction(89,1,15);
      newAction(90,1,15);
      newAction(91,1,15);
      newAction(92,1,15);
      newAction(93,1,15);
      newAction(94,1,15);
      newAction(95,1,15);
      newAction(96,0,26);
      newAction(97,1,13);
      newAction(98,1,13);
      newAction(99,1,13);
      newAction(100,1,13);
      newAction(101,1,13);
      newAction(102,1,13);
      newAction(103,1,13);
      newAction(104,1,13);
      newAction(105,0,28);
      newAction(106,1,11);
      newAction(107,1,11);
      newAction(108,1,11);
      newAction(109,1,11);
      newAction(110,1,11);
      newAction(111,1,11);
      newAction(112,1,11);
      newAction(113,1,11);
      newAction(114,0,45);
      newAction(115,0,11);
      newAction(116,0,43);
      newAction(117,0,11);
      newAction(118,0,43);
      newAction(119,1,24);
      newAction(120,1,24);
      newAction(121,1,24);
      newAction(122,1,24);
      newAction(123,1,24);
      newAction(124,1,24);
      newAction(125,1,24);
      newAction(126,1,24);
      newAction(127,1,24);
      newAction(128,1,24);
      newAction(129,1,25);
      newAction(130,1,25);
      newAction(131,1,25);
      newAction(132,1,25);
      newAction(133,1,25);
      newAction(134,1,25);
      newAction(135,1,25);
      newAction(136,1,25);
      newAction(137,1,25);
      newAction(138,1,25);
      newAction(139,1,26);
      newAction(140,1,26);
      newAction(141,1,26);
      newAction(142,1,26);
      newAction(143,1,26);
      newAction(144,1,26);
      newAction(145,1,26);
      newAction(146,1,26);
      newAction(147,1,26);
      newAction(148,1,26);
      newAction(149,0,41);
      newAction(150,0,37);
      newAction(151,0,38);
      newAction(152,0,39);
      newAction(153,0,40);
      newAction(154,1,29);
      newAction(155,1,29);
      newAction(156,1,29);
      newAction(157,1,29);
      newAction(158,1,29);
      newAction(159,1,29);
      newAction(160,1,29);
      newAction(161,1,29);
      newAction(162,1,29);
      newAction(163,1,29);
      newAction(164,1,28);
      newAction(165,1,28);
      newAction(166,1,28);
      newAction(167,1,28);
      newAction(168,1,28);
      newAction(169,1,28);
      newAction(170,1,28);
      newAction(171,1,28);
      newAction(172,1,28);
      newAction(173,1,28);
      newAction(174,1,27);
      newAction(175,1,27);
      newAction(176,1,27);
      newAction(177,1,27);
      newAction(178,1,27);
      newAction(179,1,27);
      newAction(180,1,27);
      newAction(181,1,27);
      newAction(182,1,27);
      newAction(183,1,27);
      newAction(184,0,30);
      newAction(185,0,31);
      newAction(186,1,23);
      newAction(187,1,23);
      newAction(188,1,23);
      newAction(189,1,23);
      newAction(190,1,23);
      newAction(191,1,23);
      newAction(192,1,23);
      newAction(193,1,23);
      newAction(194,1,23);
      newAction(195,0,32);
      newAction(196,0,33);
      newAction(197,0,34);
      newAction(198,0,35);
      newAction(199,0,36);
      newAction(200,1,21);
      newAction(201,1,21);
      newAction(202,1,21);
      newAction(203,1,21);
      newAction(204,1,21);
      newAction(205,1,21);
      newAction(206,1,21);
      newAction(207,1,21);
      newAction(208,1,21);
      newAction(209,1,21);
      newAction(210,0,30);
      newAction(211,1,22);
      newAction(212,1,22);
      newAction(213,1,22);
      newAction(214,1,22);
      newAction(215,1,22);
      newAction(216,1,22);
      newAction(217,1,22);
      newAction(218,1,22);
      newAction(219,1,22);
      newAction(220,0,31);
      newAction(221,0,32);
      newAction(222,0,33);
      newAction(223,0,34);
      newAction(224,0,35);
      newAction(225,0,36);
      newAction(226,1,9);
      newAction(227,1,9);
      newAction(228,1,9);
      newAction(229,1,9);
      newAction(230,1,9);
      newAction(231,1,9);
      newAction(232,1,9);
      newAction(233,1,9);
      newAction(234,0,11);
      newAction(235,0,43);
      newAction(236,0,30);
      newAction(237,0,31);
      newAction(238,0,32);
      newAction(239,0,33);
      newAction(240,0,34);
      newAction(241,0,35);
      newAction(242,0,36);
      newAction(243,1,31);
      newAction(244,1,31);
      newAction(245,1,20);
      newAction(246,1,20);
      newAction(247,1,20);
      newAction(248,1,20);
      newAction(249,1,20);
      newAction(250,1,20);
      newAction(251,1,20);
      newAction(252,1,20);
      newAction(253,1,20);
      newAction(254,1,20);
      newAction(255,0,30);
      newAction(256,0,31);
      newAction(257,0,32);
      newAction(258,0,33);
      newAction(259,0,34);
      newAction(260,0,35);
      newAction(261,0,36);
      newAction(262,0,50);
      newAction(263,1,30);
      newAction(264,1,30);
      newAction(265,1,30);
      newAction(266,1,30);
      newAction(267,1,30);
      newAction(268,1,30);
      newAction(269,1,30);
      newAction(270,1,30);
      newAction(271,1,30);
      newAction(272,1,30);
      newAction(273,0,52);
      newAction(274,1,33);
      newAction(275,1,4);
      newAction(276,0,46);
      newAction(277,1,3);
      newAction(278,0,30);
      newAction(279,0,31);
      newAction(280,0,32);
      newAction(281,0,33);
      newAction(282,0,34);
      newAction(283,0,35);
      newAction(284,0,36);
      newAction(285,1,2);
    }

  /* ************* */
  /* PARSER STATES */
  /* ************* */

  static void initializeParserStates ()
    {
      states = new ParserState[57];

      for (int i=0; i<57; i++) newState(i);
    }

  /* ************* */
  /* ACTION TABLES */
  /* ************* */

  static void initializeActionTables ()
    {
      newActionTables(54);

      newActionTable(0,11);
	setAction(0,16,8);
	setAction(0,1,5);
	setAction(0,17,9);
	setAction(0,2,6);
	setAction(0,18,10);
	setAction(0,3,2);
	setAction(0,19,11);
	setAction(0,4,3);
	setAction(0,5,4);
	setAction(0,6,7);
	setAction(0,23,12);

      newActionTable(1,1);
	setAction(1,1,1);

      newActionTable(2,1);
	setAction(2,1,13);

      newActionTable(3,8);
	setAction(3,16,17);
	setAction(3,1,14);
	setAction(3,17,18);
	setAction(3,2,15);
	setAction(3,18,19);
	setAction(3,19,20);
	setAction(3,6,16);
	setAction(3,23,21);

      newActionTable(4,2);
	setAction(4,19,22);
	setAction(4,6,23);

      newActionTable(5,1);
	setAction(5,6,24);

      newActionTable(6,8);
	setAction(6,16,29);
	setAction(6,1,25);
	setAction(6,17,30);
	setAction(6,18,31);
	setAction(6,2,32);
	setAction(6,19,27);
	setAction(6,6,28);
	setAction(6,23,26);

      newActionTable(7,1);
	setAction(7,1,33);

      newActionTable(8,8);
	setAction(8,16,37);
	setAction(8,1,34);
	setAction(8,17,38);
	setAction(8,2,35);
	setAction(8,18,39);
	setAction(8,19,40);
	setAction(8,6,36);
	setAction(8,23,41);

      newActionTable(9,1);
	setAction(9,1,42);

      newActionTable(10,1);
	setAction(10,15,43);

      newActionTable(11,3);
	setAction(11,19,45);
	setAction(11,20,44);
	setAction(11,6,46);

      newActionTable(12,9);
	setAction(12,22,55);
	setAction(12,8,47);
	setAction(12,9,48);
	setAction(12,10,49);
	setAction(12,11,50);
	setAction(12,12,51);
	setAction(12,13,52);
	setAction(12,14,53);
	setAction(12,15,54);

      newActionTable(13,8);
	setAction(13,8,56);
	setAction(13,9,57);
	setAction(13,10,58);
	setAction(13,11,59);
	setAction(13,12,60);
	setAction(13,13,62);
	setAction(13,14,61);
	setAction(13,15,63);

      newActionTable(14,1);
	setAction(14,15,64);

      newActionTable(15,1);
	setAction(15,15,65);

      newActionTable(16,1);
	setAction(16,15,66);

      newActionTable(17,1);
	setAction(17,15,67);

      newActionTable(18,1);
	setAction(18,15,68);

      newActionTable(19,1);
	setAction(19,15,69);

      newActionTable(20,8);
	setAction(20,16,73);
	setAction(20,1,70);
	setAction(20,17,74);
	setAction(20,2,71);
	setAction(20,18,75);
	setAction(20,19,76);
	setAction(20,6,72);
	setAction(20,23,77);

      newActionTable(21,1);
	setAction(21,15,78);

      newActionTable(22,8);
	setAction(22,16,82);
	setAction(22,1,79);
	setAction(22,17,83);
	setAction(22,2,80);
	setAction(22,18,84);
	setAction(22,19,85);
	setAction(22,6,81);
	setAction(22,23,86);

      newActionTable(23,1);
	setAction(23,15,87);

      newActionTable(24,8);
	setAction(24,16,91);
	setAction(24,1,88);
	setAction(24,17,92);
	setAction(24,2,89);
	setAction(24,18,93);
	setAction(24,19,94);
	setAction(24,6,90);
	setAction(24,23,95);

      newActionTable(25,1);
	setAction(25,15,96);

      newActionTable(26,8);
	setAction(26,16,100);
	setAction(26,1,97);
	setAction(26,17,101);
	setAction(26,2,98);
	setAction(26,18,102);
	setAction(26,19,103);
	setAction(26,6,99);
	setAction(26,23,104);

      newActionTable(27,1);
	setAction(27,15,105);

      newActionTable(28,8);
	setAction(28,16,109);
	setAction(28,1,106);
	setAction(28,17,110);
	setAction(28,2,107);
	setAction(28,18,111);
	setAction(28,19,112);
	setAction(28,6,108);
	setAction(28,23,113);

      newActionTable(29,1);
	setAction(29,15,114);

      newActionTable(30,10);
	setAction(30,1,119);
	setAction(30,20,128);
	setAction(30,8,120);
	setAction(30,9,121);
	setAction(30,10,122);
	setAction(30,11,123);
	setAction(30,12,124);
	setAction(30,13,125);
	setAction(30,14,126);
	setAction(30,15,127);

      newActionTable(31,10);
	setAction(31,1,129);
	setAction(31,20,138);
	setAction(31,8,130);
	setAction(31,9,131);
	setAction(31,10,132);
	setAction(31,11,133);
	setAction(31,12,134);
	setAction(31,13,135);
	setAction(31,14,136);
	setAction(31,15,137);

      newActionTable(32,10);
	setAction(32,1,139);
	setAction(32,20,148);
	setAction(32,8,140);
	setAction(32,9,141);
	setAction(32,10,142);
	setAction(32,11,143);
	setAction(32,12,144);
	setAction(32,13,145);
	setAction(32,14,146);
	setAction(32,15,147);

      newActionTable(33,1);
	setAction(33,7,149);

      newActionTable(34,1);
	setAction(34,7,150);

      newActionTable(35,2);
	setAction(35,21,152);
	setAction(35,14,151);

      newActionTable(36,1);
	setAction(36,7,153);

      newActionTable(37,10);
	setAction(37,1,154);
	setAction(37,20,163);
	setAction(37,8,155);
	setAction(37,9,156);
	setAction(37,10,157);
	setAction(37,11,158);
	setAction(37,12,159);
	setAction(37,13,160);
	setAction(37,14,161);
	setAction(37,15,162);

      newActionTable(38,10);
	setAction(38,1,164);
	setAction(38,20,173);
	setAction(38,8,165);
	setAction(38,9,166);
	setAction(38,10,167);
	setAction(38,11,168);
	setAction(38,12,169);
	setAction(38,13,170);
	setAction(38,14,171);
	setAction(38,15,172);

      newActionTable(39,10);
	setAction(39,1,174);
	setAction(39,20,183);
	setAction(39,8,175);
	setAction(39,9,176);
	setAction(39,10,177);
	setAction(39,11,178);
	setAction(39,12,179);
	setAction(39,13,180);
	setAction(39,14,181);
	setAction(39,15,182);

      newActionTable(40,10);
	setAction(40,1,186);
	setAction(40,20,194);
	setAction(40,8,187);
	setAction(40,9,185);
	setAction(40,10,195);
	setAction(40,11,196);
	setAction(40,12,197);
	setAction(40,13,199);
	setAction(40,14,198);
	setAction(40,15,193);

      newActionTable(41,10);
	setAction(41,1,200);
	setAction(41,20,209);
	setAction(41,8,201);
	setAction(41,9,202);
	setAction(41,10,203);
	setAction(41,11,204);
	setAction(41,12,205);
	setAction(41,13,206);
	setAction(41,14,207);
	setAction(41,15,208);

      newActionTable(42,10);
	setAction(42,1,211);
	setAction(42,20,219);
	setAction(42,8,210);
	setAction(42,9,220);
	setAction(42,10,221);
	setAction(42,11,222);
	setAction(42,12,223);
	setAction(42,13,225);
	setAction(42,14,224);
	setAction(42,15,218);

      newActionTable(43,8);
	setAction(43,16,229);
	setAction(43,1,226);
	setAction(43,17,230);
	setAction(43,2,227);
	setAction(43,18,231);
	setAction(43,19,232);
	setAction(43,6,228);
	setAction(43,23,233);

      newActionTable(44,9);
	setAction(44,1,243);
	setAction(44,8,236);
	setAction(44,9,237);
	setAction(44,10,238);
	setAction(44,11,239);
	setAction(44,12,240);
	setAction(44,13,242);
	setAction(44,14,241);
	setAction(44,15,244);

      newActionTable(45,10);
	setAction(45,1,245);
	setAction(45,20,254);
	setAction(45,8,246);
	setAction(45,9,247);
	setAction(45,10,248);
	setAction(45,11,249);
	setAction(45,12,250);
	setAction(45,13,251);
	setAction(45,14,252);
	setAction(45,15,253);

      newActionTable(46,8);
	setAction(46,20,262);
	setAction(46,8,255);
	setAction(46,9,256);
	setAction(46,10,257);
	setAction(46,11,258);
	setAction(46,12,259);
	setAction(46,13,261);
	setAction(46,14,260);

      newActionTable(47,10);
	setAction(47,1,263);
	setAction(47,20,272);
	setAction(47,8,264);
	setAction(47,9,265);
	setAction(47,10,266);
	setAction(47,11,267);
	setAction(47,12,268);
	setAction(47,13,269);
	setAction(47,14,270);
	setAction(47,15,271);

      newActionTable(48,1);
	setAction(48,15,273);

      newActionTable(49,1);
	setAction(49,1,274);

      newActionTable(50,1);
	setAction(50,1,275);

      newActionTable(51,1);
	setAction(51,22,276);

      newActionTable(52,8);
	setAction(52,1,277);
	setAction(52,8,278);
	setAction(52,9,279);
	setAction(52,10,280);
	setAction(52,11,281);
	setAction(52,12,282);
	setAction(52,13,284);
	setAction(52,14,283);

      newActionTable(53,1);
	setAction(53,1,285);

    }

  /* *********** */
  /* GOTO TABLES */
  /* *********** */

  static void initializeGotoTables ()
    {
      newGotoTables(17);

      newGotoTable(0,3);
	setGoto(0,1,1);
	setGoto(0,2,2);
	setGoto(0,5,6);

      newGotoTable(1,0);

      newGotoTable(2,2);
	setGoto(2,2,56);
	setGoto(2,5,6);

      newGotoTable(3,1);
	setGoto(3,3,55);

      newGotoTable(4,1);
	setGoto(4,4,53);

      newGotoTable(5,5);
	setGoto(5,3,13);
	setGoto(5,4,14);
	setGoto(5,6,7);
	setGoto(5,7,8);
	setGoto(5,14,9);

      newGotoTable(6,1);
	setGoto(6,15,51);

      newGotoTable(7,1);
	setGoto(7,3,49);

      newGotoTable(8,1);
	setGoto(8,8,29);

      newGotoTable(9,1);
	setGoto(9,9,27);

      newGotoTable(10,1);
	setGoto(10,10,25);

      newGotoTable(11,1);
	setGoto(11,11,23);

      newGotoTable(12,1);
	setGoto(12,12,21);

      newGotoTable(13,1);
	setGoto(13,13,19);

      newGotoTable(14,1);
	setGoto(14,3,44);

      newGotoTable(15,1);
	setGoto(15,3,42);

      newGotoTable(16,1);
	setGoto(16,3,47);

    }

  /* ************ */
  /* STATE TABLES */
  /* ************ */

  static void initializeStateTables ()
    {
      setTables(0,0,0);
      setTables(1,1,1);
      setTables(2,2,1);
      setTables(3,3,2);
      setTables(4,4,3);
      setTables(5,5,4);
      setTables(6,6,5);
      setTables(7,7,1);
      setTables(8,8,1);
      setTables(9,9,1);
      setTables(10,10,6);
      setTables(11,11,7);
      setTables(12,12,1);
      setTables(13,13,8);
      setTables(14,14,9);
      setTables(15,15,10);
      setTables(16,16,11);
      setTables(17,17,12);
      setTables(18,18,13);
      setTables(19,19,1);
      setTables(20,20,1);
      setTables(21,21,1);
      setTables(22,22,1);
      setTables(23,23,1);
      setTables(24,24,1);
      setTables(25,25,1);
      setTables(26,26,1);
      setTables(27,27,1);
      setTables(28,28,1);
      setTables(29,29,1);
      setTables(30,4,14);
      setTables(31,4,15);
      setTables(32,30,1);
      setTables(33,31,1);
      setTables(34,32,1);
      setTables(35,33,1);
      setTables(36,34,1);
      setTables(37,35,1);
      setTables(38,36,1);
      setTables(39,37,1);
      setTables(40,38,1);
      setTables(41,39,1);
      setTables(42,40,1);
      setTables(43,41,1);
      setTables(44,42,1);
      setTables(45,43,1);
      setTables(46,4,16);
      setTables(47,44,1);
      setTables(48,45,1);
      setTables(49,46,1);
      setTables(50,47,1);
      setTables(51,48,1);
      setTables(52,49,1);
      setTables(53,50,1);
      setTables(54,51,1);
      setTables(55,52,1);
      setTables(56,53,1);
    }
}
