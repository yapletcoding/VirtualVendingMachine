package com.techelevator.view;

import com.techelevator.InventoryScanner;
import com.techelevator.Product;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InventoryScannerTest {
    @Test
    public void inventoryScanner_input_Location_Return_Product_Info() throws FileNotFoundException {
        InventoryScanner inventoryScanner = new InventoryScanner();
        Map<String, List<Product>> testMap = inventoryScanner.InventoryScanner();

        Product test = testMap.get("A1").get(0);
        Assert.assertEquals("Potato Crisps", test.getName());
        Assert.assertEquals(new BigDecimal("3.05"), test.getPrice());

        Product test2 = testMap.get("B4").get(1);
        Assert.assertEquals("Crunchie", test2.getName());
        Assert.assertEquals(new BigDecimal("1.75"), test2.getPrice());
    }
}
