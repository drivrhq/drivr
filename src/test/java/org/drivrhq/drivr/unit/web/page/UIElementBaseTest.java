package org.drivrhq.drivr.unit.web.page;

import org.drivrhq.drivr.web.browser.BrowserFactory;
import org.drivrhq.drivr.web.browser.enums.BrowserType;
import org.drivrhq.drivr.web.browser.enums.DriverRunType;
import org.drivrhq.drivr.web.page.Page;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

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
public class UIElementBaseTest {

    protected WebDriver driver;
    protected Page samplePage;
    protected String baseURL = "http://automationpractice.com/index.php";

    @AfterTest
    public void cleanupDriverAfterTest() {
        driver.quit();

    }

    @BeforeTest
    public void setupWebDriverBeforeTest() {
        BrowserFactory factory = new BrowserFactory(BrowserType.CHROME);

        driver = factory.getBrowserInstance(DriverRunType.DIRECT);

    }

    @BeforeMethod
    public void setupWebPageBeforeEachMethod() {
        samplePage = new Page(driver, baseURL);

    }
}
