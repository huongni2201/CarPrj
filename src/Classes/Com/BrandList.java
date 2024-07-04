/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes.Com;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrandList{

    private List<Brand> brands;

    public BrandList() {
    }

    public boolean loadFromFile(String fileName) {
        File file = new File(fileName);

        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = bf.readLine()) != null) {
                String[] words = line.split(",");

                brands.add(new Brand(words[0].trim(), words[1].trim(),
                        words[2].trim(),
                        Double.parseDouble(words[3].trim())));
            }
            return true;

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean saveToFile(String fileName) {
        File file = new File(fileName);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Brand brand : brands) {
                bw.write(brand.toString());
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;

    }

    public int searchID(String ID) {
        int length = brands.size();
        for (int i = 0; i < length; i++) {
            if (brands.get(i).getBrandID().equalsIgnoreCase(ID)) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        Menu menu = new Menu();
        
        return (Brand)menu.ref_getChoice((ArrayList) brands);
    }

    public void addBrand() {

    }

    public void updateBrand() {

    }

    public void listBrands() {

    }

    public Brand get(int pos) {
        return brands.get(pos);
    }
}
