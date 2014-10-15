package com.supercalculator;

import android.widget.EditText;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class CalculatorTest extends UiAutomatorTestCase {
	
	public void testShouldCalculate() throws UiObjectNotFoundException {
		new UiObject(new UiSelector().className(EditText.class).instance(0)).setText("10");
		new UiObject(new UiSelector().className(EditText.class).instance(1)).setText("5");
		new UiObject(new UiSelector().text("Calcular")).click();
		assertTrue("The result should be visible.", new UiObject(new UiSelector().text("O resultado de 10 + 5 é 15.")).waitForExists(2000));
		UiDevice.getInstance().pressBack();
	}
	
	public void testShouldShowMessageWhenFirstFieldIsEmpty() throws UiObjectNotFoundException {
		new UiObject(new UiSelector().className(EditText.class).instance(0)).setText("");
		new UiObject(new UiSelector().className(EditText.class).instance(1)).setText("5");
		new UiObject(new UiSelector().text("Calcular")).click();
		assertTrue("Should show a message.", new UiObject(new UiSelector().text("Por favor, preencha os dois campos.")).waitForExists(2000));
		new UiObject(new UiSelector().text("Ok")).clearTextField();
	}
	
	public void testShouldShowMessageWhenSecondFieldIsEmpty() throws UiObjectNotFoundException {
		new UiObject(new UiSelector().className(EditText.class).instance(0)).setText("10");
		new UiObject(new UiSelector().className(EditText.class).instance(1)).setText("");
		new UiObject(new UiSelector().text("Calcular")).click();
		assertTrue("Should show a message.", new UiObject(new UiSelector().text("Por favor, preencha os dois campos.")).waitForExists(2000));
		new UiObject(new UiSelector().text("Ok")).clearTextField();
	}
}
