package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.*;

public class InventoryScanner {

    public Map<String, List<Product>> InventoryScanner() throws FileNotFoundException {
        Map<String, List<Product>> inventoryMap = new TreeMap<>() ;
        String path = "C:\\Users\\Student\\workspace\\mod1-capstone-green-t6\\java\\vendingmachine.csv";
        File inventory = new File(path);
        Scanner fileScan = new Scanner(inventory);
        while(fileScan.hasNextLine()){
            String line = fileScan.nextLine();
            String[] productInfoArray = line.split("[|]");

            if(productInfoArray[0].contains("A")){
                List<Product> productInfo = new ArrayList<>();
                for (int i=0; i<6; i++){
                    Chip chipBrand = new Chip(productInfoArray[1], new BigDecimal(productInfoArray[2]));
                    productInfo.add(chipBrand);
                }
                inventoryMap.put(productInfoArray[0],productInfo);
            } else if(productInfoArray[0].contains("B")){
                List<Product> productInfo = new ArrayList<>();
                for (int i=0; i<6; i++){
                    Candy candyBrand = new Candy(productInfoArray[1], new BigDecimal(productInfoArray[2]));
                    productInfo.add(candyBrand);
                }
                inventoryMap.put(productInfoArray[0],productInfo);
            } else if(productInfoArray[0].contains("C")){
                List<Product> productInfo = new ArrayList<>();
                for (int i=0; i<6; i++){
                    Drink drinkBrand = new Drink(productInfoArray[1], new BigDecimal(productInfoArray[2]));
                    productInfo.add(drinkBrand);
                }
                inventoryMap.put(productInfoArray[0],productInfo);
            }
            if(productInfoArray[0].contains("D")){
                List<Product> productInfo = new ArrayList<>();
                for (int i=0; i<6; i++){
                    Gum gumBrand = new Gum(productInfoArray[1], new BigDecimal(productInfoArray[2]));
                    productInfo.add(gumBrand);
                }
                inventoryMap.put(productInfoArray[0],productInfo);
            }

        }
        return inventoryMap;
    }
}

