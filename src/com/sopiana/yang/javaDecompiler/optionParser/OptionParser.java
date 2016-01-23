package com.sopiana.yang.javaDecompiler.optionParser;

import java.util.StringTokenizer;
import java.util.Vector;
/**
 * Abstract super class for <code>appOption</code>.
 * 
 * <p>Defines abstraction for application option and holds the allowed option key. Also contains the <code>parse()</code> 
 * function to process the given application arguments and store the value to specific application setting's variable</p>
 * @author yang.sopiana
 *
 */
public abstract class OptionParser
{
	/**
	 * String array to store allowed option key
	 */
	protected String[] keys;
	/**
	 * Store given application arguments inputed by user
	 */
	protected Vector<String> argv = new Vector<String>();
	/**
	 * Methods to list up all allowed arguments to be processed in the applications.
	 * 
	 * <p>The sub class should list up all allowed document and store it in the array <code>keys</code>.
	 * The method is called by the constructor.</p>
	 */
	protected abstract void prepareKeys();
	/**
	 * Method to display application usage
	 * 
	 * <p>Sub class should override this method and list up the information to be given when there's no arguments given to 
	 * the application. </p>
	 */
	protected abstract void printUsage();
	/**
	 * Check the application argument passed by user, and store the value to specific application setting variable.
	 * 
	 * @param argv application arguments given by user
	 */
	protected abstract void parseOptionsFromCommandLine(Vector<String> argv);
	/**
	 * Constructor of <code>OptionParser</code> class.
	 * 
	 * <p>The constructor is doing following action:</p>
	 * <ol>
	 * <li>Store given arguments to <code>argv</code> field.</li>
	 * <li>List up allowed application option keys</li>
	 * <li>Parse the given arguments based on the allowed option keys</li>
	 * </ol>
	 * @param argv application arguments given by user
	 */
	public OptionParser(String[] argv)
	{
		for(int i=0;i<argv.length;++i)
			this.argv.addElement(argv[i]);
		prepareKeys();
		parse();
	}
	
	/**
	 * Method to parse application arguments and prints out help screen when no arguments are given to application
	 */
	public void parse()
	{
		try 
		{
			if ((argv == null) || (argv.size() == 0)) 
			{
				printUsage();
				System.exit(1);
			}
			
			parseOptionsFromCommandLine(argv);
		} 
		catch (Exception anyException) 
		{
			printUsage();
			System.exit(1);
		}
	}
	/**
	 * Concat string inside doublequote (<code>"</code>) string vector
	 * 
	 * <p>The inputed arguments will be automatically separated by space character.
	 * Use this method to merge string inside doublequote character</p>
	 * 
	 * @param v application arguments given by user
	 * @return String vector with concatenated string inline the quote
	 */
	protected Vector<String> putQuotedTogether(Vector<?> v)
	{
		boolean qOn = false;
		Vector<String> pV = new Vector<String>();

		for (int i = 0; i < v.size(); i++) 
		{
			String str = (String)v.elementAt(i);
			if (str.indexOf("\"") == -1)
			{
				if (qOn)
					pV.setElementAt((String)pV.lastElement() + " " + str, pV.indexOf(pV.lastElement()));
				else
					pV.addElement(str);
			}
			else 
			{
				if ((!str.startsWith("\"")) && (!str.endsWith("\"")))
				{
					printUsage();
					System.exit(1);
				}
				if (!qOn) 
				{
					qOn = true;
					pV.addElement(str);
				} 
				else 
				{
					qOn = false;
					pV.setElementAt((String)pV.lastElement() + " " + str, pV.indexOf(pV.lastElement()));
				}
			}
		}
		
		for (int i = 0; i < pV.size(); i++) 
		{
			if (((String)pV.elementAt(i)).indexOf("\"") != -1)
			{
				StringTokenizer st = new StringTokenizer((String)pV.elementAt(i), "\"");
				
				String str = "";
				while (st.hasMoreElements())
					str = str + st.nextToken();
				pV.setElementAt(str, i);
			}
		}
		return pV;
	}
}