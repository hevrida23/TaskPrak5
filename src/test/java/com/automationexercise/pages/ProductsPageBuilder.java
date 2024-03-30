package com.automationexercise.pages;

import org.openqa.selenium.WebDriver;

public class ProductsPageBuilder {
    private WebDriver driver;
    public void driver0;
    {
        Object object = null;

    }

    public ProductsPageBuilder setDriver(WebDriver driver) {
        this.driver = driver;
        return this;
    }

    public ProductsPageBuilder setDriver0(void driver0) {
        this.driver0 = driver0;
        this.driver0 = driver0;
        return this;
    }

    public ProductsPage createProductsPage() {
        return new ProductsPage(driver);
    }

    public void getDriver0() {
        return driver0;
    }
}