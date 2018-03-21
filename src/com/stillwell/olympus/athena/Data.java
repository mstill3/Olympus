//*****************************************************************************
//  Matt Stillwell
//  8/20/14
//	1/18/15
//  Athena - Data
//
//  This code will display all computer info
//
//*****************************************************************************
package com.stillwell.olympus.athena;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.swing.filechooser.FileSystemView;

public class Data
{

	private static String title;
	private static String currentUSBName;

	//accounts for manufacturing GB difference
	private final static double DEAD_SPACE = 0.93125;	

	//===================================================
	// constructor to initialize
	//===================================================
	public Data()
	{
		//La Mochila de Mateo	
		//LEXAR     
		//USB20FD   
		//Matt Stillwell's Passport
		setCurrentUSBName("MATT");
		setTitle("                             "
				+ "                          COMPUTER "
				+ "INFORMATION:                       "
				+ "         Matt Stillwell");
	}

	//===================================================
	// sets title to data sheet
	//===================================================
	public void setTitle(String str)
	{
		title = str;
	}

	//===================================================
	// returns title of data sheet
	//===================================================
	public String getTitle()
	{
		return title;
	}

	//===================================================
	// sets current USB name
	//===================================================
	public void setCurrentUSBName(String usbName)
	{
		currentUSBName = usbName;
	}

	//===================================================
	// returns current USB name
	//===================================================
	public String getCurrentUSBName()
	{
		return currentUSBName;
	}

	//===================================================
	// gets country on pc 
	//===================================================
	public static String getCountry()
	{
		return System.getProperty("user.country");
	}

	//===================================================
	// gets language on pc
	//===================================================
	public static String getLanguage()
	{
		return System.getProperty("user.language");
	}

	//===================================================
	// gets ip address of pc
	//===================================================
	public static String getIPAddress()
	{
		String ipAddress = "";
		try 
		{
			ipAddress = Inet4Address.getLocalHost().getHostAddress();
		}
		catch (UnknownHostException e)
		{
			return "Could not retrieve ip";
		}
		return ipAddress;
	}

	//===================================================
	// gets mac address of pc
	//===================================================
	public static String getMacAddress()
	{
		String macAddress = "";
		try
		{
			InetAddress ip = InetAddress.getLocalHost();
			NetworkInterface network = 
					NetworkInterface.getByInetAddress(ip);
			byte[] mac = network.getHardwareAddress();

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++)
				sb.append(String.format("%02X%s", mac[i], 
						(i < mac.length - 1) ? "-" : ""));		
			macAddress = sb.toString();

		}
		catch (UnknownHostException e)
		{
			return "Unkown Host";
		}
		catch (SocketException e)
		{
			return "Socket Error";
		}
		return macAddress;
	}

	//===================================================
	// gets computer name on pc
	//===================================================
	public static String getComputerName()
	{
		String computerName = "";
		try
		{
			computerName = InetAddress.getLocalHost().getHostName();
		}
		catch (UnknownHostException e1)
		{ 
			System.out.println("'hostName' not found");
		}
		return computerName;
	}

	//===================================================
	// gets user name on pc
	//===================================================
	public static String getUserName()
	{
		return System.getProperty("user.name");
	}

	//===================================================
	// gets all drives plugged in
	//===================================================
	public static String getDrives()
	{
		String temp = "";
		List <File>files = Arrays.asList(File.listRoots());
		for (File f : files) 
		{ 
			String s1 = FileSystemView.getFileSystemView().getSystemDisplayName (f);
			temp += s1 + "\t";
		}
		return temp.trim();
	}
	
	public static String[] getResources()
	{
		File dir = new File("res/");
		return dir.list();
	}

	//===================================================
	// checks if usbName in plugged in
	//===================================================
	public static boolean isUsbPluggedIn(String usbName)
	{
		List <File>files = Arrays.asList(File.listRoots());
		for (File f : files)
		{
			String s1 = FileSystemView.getFileSystemView().getSystemDisplayName (f);
			if(s1.contains(usbName))
				return true;
		}
		return false;
	}

	//===================================================
	// gets usbName drive letter
	//===================================================
	public static String getUsbDriveLetter(String usbName)
	{
		List <File>files = Arrays.asList(File.listRoots());
		for (File f : files)
		{ 
			String s1 = FileSystemView.getFileSystemView().getSystemDisplayName (f);
			if(s1.contains(usbName)) 
				return s1.substring(usbName.length() + 2, usbName.length() + 3);
		}
		return "Not Found";
	}

	//===================================================
	// gets usbName file
	//===================================================
	public static File getUsbDriveLetterFile(String usbName)
	{
		return new File(getUsbDriveLetter(usbName) + ":\\");
	}

	//===================================================
	// gets usbName file path
	//===================================================
	public static File getUsbFilePath(String usbName)
	{
		return new File(getUsbDriveLetter(usbName) + ":\\Matt");
	}

	//===================================================
	// gets total space on usbName drive
	//===================================================
	public static double getUsbSpaceTotal(String usbName)
	{
		return getUsbDriveLetterFile(usbName).getTotalSpace() * DEAD_SPACE;
	}

	//===================================================
	// gets space left on usbName drive
	//===================================================
	public static double getUsbSpaceLeft(String usbName)
	{
		return getUsbDriveLetterFile(usbName).getFreeSpace() * DEAD_SPACE;
	}

	//===================================================
	// gets space used on usbName drive
	//===================================================
	public static double getUsbSpaceUsed(String usbName)
	{
		return getUsbSpaceTotal(usbName) - getUsbSpaceLeft(usbName) * DEAD_SPACE;
	}

	//===================================================
	// converts bytes to gigabytes
	//===================================================
	public static double bytesToGigabytes(double b) {
		return b / 1000000000;
	}

	//===================================================
	// converts gigabytes to bytes
	//===================================================
	public static double gigabytesToBytes(double g)
	{
		return g * 1000000000;
	}

	//===================================================
	// gets usbName drive space statement 
	//===================================================
	public static String getUsbSpaceStatement(String usbName)
	{
		return (int)bytesToGigabytes(getUsbSpaceLeft(usbName)) + " GB free of " + 
				(int)bytesToGigabytes(getUsbSpaceTotal(usbName)) + " GB";
	}

	//===================================================
	// gets current date
	//===================================================
	public static String getDate()
	{
		DateFormat coolFormat = new SimpleDateFormat("MM/dd/yy");
		return coolFormat.format(new Date());
	}

	//===================================================
	// gets current time
	//===================================================
	public static String getTime()
	{
		DateFormat timeFormat = new SimpleDateFormat("hh:mm aa");
		return timeFormat.format(new Date());
	}

	//===================================================
	// gets screen size of pc
	//===================================================
	public static Dimension getScreenSize()
	{
		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	//===================================================
	// gets screen width of pc
	//===================================================
	public static double getScreenWidth()
	{
		return getScreenSize().getWidth();
	}

	//===================================================
	// gets screen height of pc
	//===================================================
	public static double getScreenHeight()
	{
		return getScreenSize().getHeight();
	}

	//===================================================
	// gets screen resolution of pc
	//===================================================
	public static int getScreenResolution()
	{
		return Toolkit.getDefaultToolkit().getScreenResolution();
	}

	//===================================================
	// gets operating system name on pc
	//===================================================
	public static String getOSName()
	{
		return System.getProperty("os.name");
	}

	//===================================================
	// gets operating system version on pc
	//===================================================
	public static String getOSVersion()
	{
		return System.getProperty("os.version");
	}

	//===================================================
	// gets operating system architecture on pc
	//===================================================
	public static String getOSArchitecture()
	{
		return System.getProperty("sun.arch.data.model");
	}

	//===================================================
	// gets vendor on pc
	//===================================================
	public static String getVendor()
	{
		return System.getProperty("java.vendor");
	}

	//===================================================
	// gets java version on pc
	//===================================================
	public static String getJavaVersion()
	{
		return System.getProperty("java.version");
	}

	//===================================================
	// gets processor identity on pc
	//===================================================
	public static String getProcessorIdentity()
	{
		return System.getenv("PROCESSOR_IDENTIFIER");
	}

	//===================================================
	// gets number of processors on pc
	//===================================================
	public static int getNumProcessors()
	{
		return Integer.parseInt(System.getenv("NUMBER_OF_PROCESSORS"));
	}

	//===================================================
	// gets system roots on pc
	//===================================================
	public static String getSystemRoots()
	{
		//		System.out.println("File system roots returned by FileSystemView.getFileSystemView():");
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File[] roots = fsv.getRoots();
		String root = "";
		for (int i = 0; i < roots.length; i++) 
		{
			//			System.out.println("Root: " + roots[i]);
			root += roots[i] + "\n   ";
		}
		//		System.out.println("Home directory: " + fsv.getHomeDirectory());
		//		System.out.println("File system roots returned by File.listRoots():");
		File[] f = File.listRoots();
		for (int i = 0; i < f.length; i++)
		{
			//			System.out.println("Drive: " + f[i]);
			root += "   Drive: " + f[i] + "\n";
			//			System.out.println("Display name: " + fsv.getSystemDisplayName(f[i]));
			root += "   Display name: " + fsv.getSystemDisplayName(f[i]) + "\n";
			//			System.out.println("Is drive: " + fsv.isDrive(f[i]));
			root += "   Is drive: " + fsv.isDrive(f[i]) + "\n";
			//			System.out.println("Is floppy: " + fsv.isFloppyDrive(f[i]));
			root += "   Is floppy: " + fsv.isFloppyDrive(f[i]) + "\n";
			//			System.out.println("Readable: " + f[i].canRead());
			root += "   Readable: " + f[i].canRead() + "\n";
			//			System.out.println("Writable: " + f[i].canWrite());
			root +=    "Writable: " + f[i].canWrite() + "\n";
			//			System.out.println("Total space: " + f[i].getTotalSpace());
			root += "   Total space: " + f[i].getTotalSpace() + "\n";
			//			System.out.println("Usable space: " + f[i].getUsableSpace());
			root += "   Usable space: " + f[i].getUsableSpace() + "\n";		
		}

		return root;

	}

	//===================================================
	// gets task manager processes on pc
	//===================================================
	public static String getTaskManagerProcesses()
	{
		String processes = "";
		try
		{
			String line;
			Process p = Runtime.getRuntime().exec(System.getenv("windir") + "\\system32\\" + "tasklist.exe");
			BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
			while ((line = input.readLine()) != null) 
			{
				//	            System.out.println(line); //<-- Parse data here.
				processes += line + "\n   ";
			}
			input.close();
		}
		catch (Exception err)
		{
			err.printStackTrace();
		}
		return processes;
	}

	//===================================================
	// gets all system specs
	//===================================================
	public String toString()
	{
		String str = "";
		str += printSeperator(title.length()) +
				title + printSeperator(title.length()) + "\n\n\n" +
				"   Country: " + printSeperator(getCountry().length()) + "   " + getCountry() + printSeperator(getCountry().length()) + "\n\n" + 
				"   Language: " + printSeperator(getLanguage().length()) + "   " + getLanguage() + printSeperator(getLanguage().length()) + "\n\n" + 
				"   IP Address: " + printSeperator(getIPAddress().length()) + "   " + getIPAddress() + printSeperator(getIPAddress().length()) + "\n\n" + 
				"   Mac Address: " + printSeperator(getMacAddress().length()) + "   " + getMacAddress() + printSeperator(getMacAddress().length()) + "\n\n" + 
				"   Computer Name: " + printSeperator(getComputerName().length()) + "   " + getComputerName() + printSeperator(getComputerName().length()) + "\n\n" + 
				"   Username: " + printSeperator(getUserName().length()) + "   " + getUserName() + printSeperator(getUserName().length()) + "\n\n" +
				"   Drives: " + printSeperator(getDrives().length()) + "   " + getDrives() + printSeperator(getDrives().length()) + "\n\n" + 
				"   Chosen USB Name: " + printSeperator(currentUSBName.length()) + "   " + currentUSBName + printSeperator(currentUSBName.length()) + "\n\n" +
				"   Chosen USB Plugged In: " + printSeperator((isUsbPluggedIn(getCurrentUSBName()) + "").length()) + "   " + isUsbPluggedIn(getCurrentUSBName()) + printSeperator((isUsbPluggedIn(getCurrentUSBName()) + "").length()) + "\n\n";

		if(isUsbPluggedIn(getCurrentUSBName()))
			str +=  "   Chosen USB Space: " + printSeperator(getUsbSpaceStatement(getCurrentUSBName()).length()) + "   " + getUsbSpaceStatement(getCurrentUSBName()) + printSeperator(getUsbSpaceStatement(getCurrentUSBName()).length()) + "\n\n" +
					"   Chosen USB Drive Letter: " + printSeperator(getUsbDriveLetter(getCurrentUSBName()).length()) + "   " + getUsbDriveLetter(getCurrentUSBName()) + printSeperator(getUsbDriveLetter(getCurrentUSBName()).length()) + "\n\n" +
					"   Chosen USB File Path: " + printSeperator(getUsbFilePath(getCurrentUSBName()).toString().length()) + "   " + getUsbFilePath(getCurrentUSBName()) + printSeperator(getUsbFilePath(getCurrentUSBName()).toString().length()) + "\n\n";	

		str += "   Date: " + printSeperator(getDate().length()) + "   " + getDate() + printSeperator(getDate().length()) + "\n\n" +
				"   Time: " + printSeperator(getTime().length()) + "   " + getTime() + printSeperator(getTime().length()) + "\n\n" +
				"   Java Version: " + printSeperator(getJavaVersion().length()) + "   " + getJavaVersion() + printSeperator(getJavaVersion().length()) + "\n\n" +
				"   OS Name: " + printSeperator(getOSName().length()) + "   " + getOSName() + printSeperator(getOSName().length()) + "\n\n" +
				"   OS Version: " + printSeperator(getOSVersion().length()) + "   " + getOSVersion() + printSeperator(getOSVersion().length()) + "\n\n" +
				"   OS Architecture: " + printSeperator(getOSArchitecture().length()) + "   " + getOSArchitecture() + printSeperator(getOSArchitecture().length()) + "\n\n" +
				"   Screen Width: " + printSeperator((getScreenWidth() + "").length()) + "   " + getScreenWidth() + printSeperator((getScreenWidth() + "").length()) + "\n\n" +
				"   Screen Height: " + printSeperator((getScreenWidth() + "").length()) + "   " + getScreenHeight() + printSeperator((getScreenWidth() + "").length()) + "\n\n" +
				"   Number of Processor Cores: " + printSeperator(getNumProcessors()) + "   " + getNumProcessors() + printSeperator(getNumProcessors()) + "\n\n" +
				"   Processor Identity: " + printSeperator(getProcessorIdentity().length()) + "   " + getProcessorIdentity() + printSeperator(getProcessorIdentity().length()) + "\n\n" +
				"   Roots: " + printSeperator(30) + "   " + getSystemRoots() + printSeperator(30) + "\n\n\n" +
				"   Task Manager Processes: " + printSeperator(70) + "   " + getTaskManagerProcesses() + printSeperator(70) + "\n\n";

		return str;
	}

	//===================================================
	// organizes data based on size
	//===================================================
	private static String printSeperator(int size)
	{
		String seperator = "";
		if(size < 20)
			seperator = "\n   ---------------------------------------------\n";
		else if(size < 40)
			seperator = "\n   ------------------------------------------------------------\n";
		else if(size < 80)
			seperator = "\n   ---------------------------------------------------------------------------------------------------------------------------------------\n";
		else //120
			seperator = "\n   ========================================================================================================================\n";
		return seperator;
	}

}