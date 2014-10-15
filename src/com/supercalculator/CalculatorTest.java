package com.supercalculator;

import android.widget.EditText;

import com.android.uiautomator.core.UiDevice;
import com.android.uiautomator.core.UiObject;
import com.android.uiautomator.core.UiObjectNotFoundException;
import com.android.uiautomator.core.UiSelector;
import com.android.uiautomator.testrunner.UiAutomatorTestCase;

public class CalculatorTest extends UiAutomatorTestCase {
	
	public void testShouldCalculate() throws UiObjectNotFoundException {
		typeOnEditText("10", 0);
		typeOnEditText("5", 1);
		new UiObject(new UiSelector().text("Calcular")).click();
		assertTrue("The result should be visible.", new UiObject(new UiSelector().textContains("Resultado: 10 + 5 = 15")).waitForExists(5000));
		UiDevice.getInstance().pressBack();
	}
	
	public void testShouldShowMessageWhenFirstFieldIsEmpty() throws UiObjectNotFoundException {
		typeOnEditText("", 0);
		typeOnEditText("5", 1);
		new UiObject(new UiSelector().text("Calcular")).click();
		assertTrue("Should show a message.", new UiObject(new UiSelector().text("Por favor, preencha os dois campos.")).waitForExists(2000));
		new UiObject(new UiSelector().text("Ok")).clearTextField();
	}
	
	public void testShouldShowMessageWhenSecondFieldIsEmpty() throws UiObjectNotFoundException {
		typeOnEditText("10", 0);
		typeOnEditText("", 1);
		new UiObject(new UiSelector().text("Calcular")).click();
		assertTrue("Should show a message.", new UiObject(new UiSelector().text("Por favor, preencha os dois campos.")).waitForExists(2000));
		new UiObject(new UiSelector().text("Ok")).clearTextField();
	}
	
	private void typeOnEditText(String text, int instance) throws UiObjectNotFoundException {
		UiObject editText = new UiObject(new UiSelector().className(EditText.class).instance(instance));
		eraseText(editText);
		editText.setText(text);
	}
	
	private void eraseText(UiObject uiObject) throws UiObjectNotFoundException {
		uiObject.clickBottomRight();
		String currentText = uiObject.getText();
		for (int i = 0; i < currentText.length(); i++) {
			UiDevice.getInstance().pressDelete();
		}
	}
}
