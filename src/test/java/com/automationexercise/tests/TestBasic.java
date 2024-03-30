package com.automationexercise.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestBasic {
    public static void main(String[] args) {
        // Inisialisasi driver
        WebDriver driver = new ChromeDriver();
        Duration duration;
        duration = Duration.ofSeconds(5);


        // Buka URL
        driver.get("http://automationexercise.com");

        // Tunggu hingga iframe muncul
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("aswift_2"));

        // Sekarang berada di dalam iframe, cari dan klik elemen
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.id("days")));
        element.click();

        // Keluar dari iframe dan kembali ke konteks default
        driver.switchTo().defaultContent();

        // Lanjutkan dengan langkah-langkah selanjutnya

        // Tutup browser
        driver.quit();
    }
}