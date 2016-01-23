package com.sopiana.yang.javaDecompiler;

import java.util.Vector;
import com.sopiana.yang.javaDecompiler.optionParser.OptionParser;
/**
 * Java Decompiler option parser. Parse the given application argument passed to the application and 
 * store the value to specific application setting parameter.
 * 
 * <p>Supported application arguments are:</p>
 * <ul>
 * <li><code>-input &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code>: followed by .jar or .class to be decompiled</li>
 * <li><code>-outputpath </code>: followed by folder name which the output saved</li>
 * <li><code>-version &nbsp;&nbsp;&nbsp;</code>: to show the Java Decompiler current version</li>
 * <li><code>-help &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</code>: to show Java Decompiler usage</li>
 * </ul>
 * @author yang.sopiana
 *
 */
public final class appOption extends OptionParser
{
	private String inputFileName;
	private String outputPath;
	private boolean showVersion;
	private boolean showHelp;
	private String[] helpContents;
	/**
	 * <code>appOption</code> costructor, create instance of <code>appOption</code>.
	 * 
	 * <p><code>appOption</code> store application setting value from the application arguments. 
	 * It store the input file name, output folder path, and help contents</p>
	 * @param argv passed application arguments
	 */
	public appOption(String[] argv) 
	{
		super(argv);
	}
	
	/**
	 * Method for preparing option key and the help contents
	 * 
	 * <p>Called by the constructor, used to list up all option key and the help contents.
	 * Modify this method to add or remove supported application arguments.
	 * When adding or removing an option, make sure the <code>key</code> and <code>helpContents</code> are in 
	 * same sequence.</p>
	 */
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
	/**
	 * Show the application usage on screen
	 * 
	 * <p>Prints out all key option and it's help contents. This method will automatically called when 
	 * no application arguments or when user passes <code>-help</code> argument.</p>
	 */
	public void printUsage() 
	{
		System.out.println("Usage:");
		for(int i=0;i<keys.length;++i)
			System.out.println("\t"+keys[i]+"\t:"+helpContents[i]);
	}
	/**
	 * Check the application argument passed by user, and store the value to specific application setting variable.
	 * 
	 * <p>The application argument should start with minus character (<code>-</code>) followed by supported application arguments.
	 * The application argument is not case sensitive.</p>
	 * <p>When passing parameter with space, used double quoted (<code>"</code>) parameter. <br>
	 * For example: <code>-input "just test.jar"</code>
	 * </p>
	 * @param argv application arguments given by user
	 */
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
	/**
	 * Get the .jar of .class file inputed by user
	 * 
	 * <p>Accessor method for <code>inputFileName</code> variable. Stores the input file from given application arguments.</p>
	 * @return .jar of .class file to be decompiled
	 */
	public String getInputFileName()		{ return this.inputFileName; }
	/**
	 * Get the intended output folder inputed by user
	 * 
	 * <p>Accessor method for <code>outputPath</code> variable. Stores the intended output folder from given application 
	 * arguments. When no output folder specified in application parameter, the default output folder will be same folder as 
	 * the application path</p>
	 * @return folder path where the ouput will be stored
	 */
	public String getOutputPath()			{ return this.outputPath; }
	/**
	 * Check if application version should be printed out or not
	 * 
	 * <p>Accessor method for <code>showVersion</code> variable. The variable will be set if user passes <code>-version</code> 
	 * option to application</p>
	 * @return <code>true</code> if <code>-version</code> is passed to application, <code>false</code> otherwise.
	 */
	public boolean isShowVersion()			{ return this.showVersion; }
	/**
	 * Check if application help contents should be printed out or not
	 * 
	 * <p>Accessor method for <code>showHelp</code> variable. The variable will be set if user passes <code>-help</code> 
	 * option to application, or no argument at all</p>
	 * @return <code>true</code> if <code>-help</code> is passed to application or no argument is passed, 
	 * <code>false</code> otherwise.
	 */
	public boolean isShowHelp()				{ return this.showHelp; }

}
