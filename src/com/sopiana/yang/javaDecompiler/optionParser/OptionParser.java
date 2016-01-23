package com.sopiana.yang.javaDecompiler.optionParser;

import java.util.StringTokenizer;
import java.util.Vector;

public abstract class OptionParser
{
	protected String[] keys;
	protected Vector<String> argv = new Vector<String>();
	
	protected abstract void prepareKeys();
	protected abstract void printUsage();
	protected abstract void parseOptionsFromCommandLine(Vector<String> argv);
	
	public OptionParser(String[] argv)
	{
		for(int i=0;i<argv.length;++i)
			this.argv.addElement(argv[i]);
		prepareKeys();
		parse();
	}
	
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