package org.drivrhq.drivr.unit.web.browser;

import org.drivrhq.drivr.web.browser.BrowserFactory;
import org.drivrhq.drivr.web.browser.enums.BrowserType;
import org.drivrhq.drivr.web.browser.enums.DriverRunType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

/**
 * (C) Copyright 2017 Dominic Pace (https://github.com/Dominic-Pace)
 * ----------------------------------------------------------------------------
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * ----------------------------------------------------------------------------
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * ----------------------------------------------------------------------------
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
public class BrowserFactoryTests {

    private BrowserFactory browserFactory;
    private WebDriver driver;
    private String driverType;

    @AfterMethod
    public void cleanUpAfterTest() {
        driver.quit();
    }

    @Test
    public void chromeDriverInstanceTest() {
        browserFactory = new BrowserFactory(BrowserType.CHROME);

        driver = browserFactory.getBrowserInstance(DriverRunType.DIRECT);
        driverType = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();

        Assert.assertTrue(driverType.toLowerCase().equals("chrome"),
                "The browser type was " + driverType + " but was expected to be chrome.");
    }

    @Test
    public void firefoxDriverInstanceTest() {
        browserFactory = new BrowserFactory(BrowserType.FIREFOX);

        driver = browserFactory.getBrowserInstance(DriverRunType.DIRECT);
        driverType = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();

        Assert.assertTrue(driverType.toLowerCase().equals("firefox"),
                "The browser type was " + driverType + " but was expected to be firefox.");
    }
}
