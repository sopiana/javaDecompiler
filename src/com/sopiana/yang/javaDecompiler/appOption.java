package com.sopiana.yang.javaDecompiler;


import java.util.Vector;
import com.sopiana.yang.javaDecompiler.optionParser.OptionParser;

public final class appOption extends OptionParser
{
	private String inputFileName;
	private String outputPath;
	private boolean showVersion;
	private boolean showHelp;
	private String[] helpContents;
	
	public appOption(String[] argv) 
	{
		super(argv);
	}

	protected void prepareKeys() 
	{
		keys = new String[] { "-input", "-outputpath", "-version", "-help"};
	
		helpContents = new String[]{
				".jar or .class file name to be read (mandatory)",
				"path where the output file saved",
				"print capReader version",
				"show this message"
		};
	}

	public void printUsage() 
	{
		System.out.println("Usage:");
		for(int i=0;i<keys.length;++i)
			System.out.println("\t"+keys[i]+"\t:"+helpContents[i]);
	}

	protected void parseOptionsFromCommandLine(Vector<String> argv) 
	{
		Vector<String> pv = putQuotedTogether(argv);
		
		for(int i=0;i<pv.size();++i)
		{
			if(pv.get(i).equalsIgnoreCase("-input"))
				this.inputFileName = pv.get(i++ +1);
			else if(pv.get(i).equalsIgnoreCase("-outputpath"))
				this.outputPath = pv.get(i++ +1);
			else if(pv.get(i).equalsIgnoreCase("-version"))
				this.showVersion = true;
			else if(pv.get(i).equalsIgnoreCase("-help"))
				this.showHelp = true;
		}
	}
	
	public String getInputFileName()		{ return this.inputFileName; }
	public String getOutputPath()			{ return this.outputPath; }
	public boolean isShowVersion()			{ return this.showVersion; }
	public boolean isShowHelp()				{ return this.showHelp; }

}
