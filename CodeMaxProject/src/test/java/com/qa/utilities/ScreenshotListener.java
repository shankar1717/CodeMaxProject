//package com.qa.utilities;
//
//import org.testng.ITestListener;
//import org.testng.ITestResult;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import java.io.File;
//import java.io.IOException;
//import org.apache.commons.io.FileUtils;
//
//public class ScreenshotListener implements ITestListener {
//
//	private WebDriver driver;
//
//	// Constructor to receive WebDriver instance
//	public ScreenshotListener(WebDriver driver) {
//		this.driver = driver;
//	}
//
//	@Override
//	public void onTestStart(ITestResult result) {
//		// Method stub
//	}
//
//	@Override
//	public void onTestSuccess(ITestResult result) {
//		captureScreenshot(result);
//		System.out.println("Test passed: " + result.getName());
//	}
//
//	@Override
//	public void onTestFailure(ITestResult result) {
//		captureScreenshot(result);
//	}
//
//	@Override
//	public void onTestSkipped(ITestResult result) {
//		// Method stub
//	}
//
//	// Method to capture screenshot
//	private void captureScreenshot(ITestResult result) {
//		
//		
//		// Convert WebDriver to TakesScreenshot
//		TakesScreenshot ts = (TakesScreenshot) driver;
//
//		// Capture screenshot as File
//		File source = ts.getScreenshotAs(OutputType.FILE);
//
//		// Define destination path for screenshot
//		String destinationPath = System.getProperty("user.dir") + "/screenshots/" + result.getName() + ".png";
//		// String destinationPath = "screenshots/" + result.getName() + ".png";
//
//		// Create a destination file
//		File destination = new File(destinationPath);
//		try {
//			// Copy screenshot to the desired location
//			FileUtils.copyFile(source, destination);
//		} catch (IOException e) {
//			e.printStackTrace();
//
//		}
//		System.out.println("Screenshot taken at: " + destinationPath);
//
//	}
//}
