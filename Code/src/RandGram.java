import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import javax.swing.*;


public class RandGram extends Applet
{
  private static int numTypes;
  private static String senType;
  /*
  public static void main(String[] args)
    throws IOException
  {
    System.out.println();
    
    Scanner in = new Scanner(System.in);
    
    numTypes = (int)(Math.random() * 5.0D + 1.0D);
    String[] types = new String[numTypes];
    
    senType = getSenType();
    
    int count = 0;
    do
    {
      types[count] = randGram();
      if (!isDuplicate(types, count)) {
        count++;
      }
    } while (count < numTypes);
    System.out.println(senType + " --> ");
    for (int i = 0; i < numTypes - 1; i++) {
      System.out.print(types[i] + ", ");
    }
    System.out.println(types[(numTypes - 1)]);
    
    System.out.println();
    
    System.out.print("Try another? [Y / N]\t\t");
    char choice = in.nextLine().toUpperCase().charAt(0);
    System.out.println();
    if (choice == 'Y') {
      repeat(args);
    }
  }
  */
  public static void draw(Graphics g)
  {
	  g.setColor(new Color(0,0,0));
	  g.drawRect(0,0,800,300);
	  Font trb = new Font("Verdana", Font.BOLD, 18);
	  g.setFont(trb);
	  numTypes = (int)(Math.random() * 5.0D + 1.0D);
	  String[] types = new String[numTypes];
	  
	  senType = getSenType();
	  int count = 0;
	  
	  do
	  {
	     types[count] = randGram();
	     if (!isDuplicate(types, count)) 
	     {
	       count++;
	     }
	  } while (count < numTypes);
	  
	  String str = senType + " sentence:\t";
	  
	  for (int i = 0; i < numTypes - 1; i++) 
	  {
	      str.concat(types[i] + ", ");
	  }
	  
	  str.concat("and " + types[(numTypes - 1)]);
	  
	  str.concat("\n\nDo you want another one? Type in [Y/N]");
	  
	  g.drawString(str,15,15);
  }
  /*
  public static void main(String [] args) throws IOException
  {
	  numTypes = (int)(Math.random() * 5.0D + 1.0D);
	  String[] types = new String[numTypes];
	  
	  senType = getSenType();
	  int count = 0;
	  
	  do
	  {
	     types[count] = randGram();
	     if (!isDuplicate(types, count)) 
	     {
	       count++;
	     }
	  } while (count < numTypes);
	  
	  String str = senType + " sentence:\t";
	  
	  for (int i = 0; i < numTypes - 1; i++) 
	  {
	      str.concat(types[i] + ", ");
	  }
	  
	  str.concat("and " + types[(numTypes - 1)]);
	  
	  str.concat("\n\nDo you want another one? Type in [Y/N]");
	  
	  String s = JOptionPane.showInputDialog(str);
	  
	  boolean bool = true;
	  
	  while(bool)
	  {
		  if(s.toUpperCase().equals("Y"))
		  {
			  main(args);
		  }
		  else if (s.toUpperCase().equals("N"))
		  {
			  return;
		  }
		  else
		  {
			  s = JOptionPane.showInputDialog("Do you want another one? Type in [Y/N]");
		  }
	  }
  }
  */
  public static String getSenType()
  {
    double r = Math.random();
    if (r < 0.25D) {
      return "Simple";
    }
    if (r < 0.5D) {
      return "Compound";
    }
    if (r < 0.75D) {
      return "Complex";
    }
    return "Compound-Complex";
  }
  
  public static String randGram()
  {
    String t = "";
    double r = Math.random();
    double numElem = 6.0D;
    if ((senType.equals("Complex")) || (senType.equals("Compound-Complex"))) {
      numElem += 2.0D;
    }
    String e;
    if (r < 1.0D / numElem)
    {
      e = "Prepositional Phrase";
    }
    else if (r < 2.0D / numElem)
    {
      e = "Predicate Nominative";
      r = Math.random();
      if (r < 0.5D) {
        e = "Pronoun as a " + e;
      }
    }
    else if (r < 3.0D / numElem)
    {
      e = "Participial Phrase";
      t = "adjective";
    }
    else
    {
      if (r < 4.0D / numElem)
      {
        e = "Appositive";
      }
      else if (r < 5.0D / numElem)
      {
        e = "Gerund Phrase";
        t = "noun";
      }
      else if (r < 6.0D / numElem)
      {
        e = "Infinitive Phrase";
        t = "noun";
      }
      else
      {
        
        if (r < 7.0D / numElem) {
          e = "Comparison Exception";
        } else {
          e = getClause();
        }
      }
    }
    r = Math.random();
    if (r < 0.5D) {
      e = e + getFunction(t);
    }
    return e;
  }
  
  public static String getClause()
  {
    double r = Math.random();
    String t;
    String c;
    if (r < 0.3333333333333333D)
    {
      c = "Adverb Clause";
      t = "adverb";
    }
    else
    {
      if (r < 0.6666666666666666D)
      {
        c = "Adjective Clause";
        t = "adjective";
      }
      else
      {
        c = "Noun Clause";
        t = "noun";
      }
    }
    if (Math.random() < 0.5D) {
      c = c + getFunction(t);
    }
    return c;
  }
  
  public static String getFunction(String t)
  {
    String s = " as a ";
    if (t.equals("noun"))
    {
      double r = Math.random();
      if (r < 0.25D) {
        s = s + "Subject";
      } else {
        s = s + "Direct Object";
      }
    }
    else if (t.equals("adverb"))
    {
      s = s + "Prepositional Phrase";
    }
    else
    {
      s = "";
    }
    return s;
  }
  
  public static String getTitle()
  {
    String t = "Title of a ";
    double r = Math.random();
    if (r < 0.1666666666666667D) {
      t = t + "Book";
    } else if (r < 0.3333333333333333D) {
      t = t + "Play";
    } else if (r < 0.5D) {
      t = t + "Movie";
    } else if (r < 0.6666666666666666D) {
      t = t + "Short Story";
    } else if (r < 0.8333333333333334D) {
      t = t + "Poem";
    } else {
      t = t + "Song";
    }
    return t;
  }
  
  private static boolean isDuplicate(String[] s, int index)
  {
    for (int i = 0; i < index; i++) {
      if (s[index].equals(s[i]))
      {
        s[index] = "";
        return true;
      }
    }
    return false;
  }
  
  private static void repeat(String[] args)
    throws IOException
  {
    main(args);
  }
}
