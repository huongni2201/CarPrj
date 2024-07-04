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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Huong
 */
public class CarList {

    private List<Car> cars;
    private BrandList brandList;

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }

    public boolean loadToFile(String fileName) {
        File file = new File(fileName);
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(",");
                int pos = brandList.searchID(words[1]);

                Brand brand = brandList.get(pos);
                cars.add(new Car(words[0].trim(), (Brand) brand,
                        words[2].trim(), words[3].trim(),
                        words[4].trim()));
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
            for (Car car : cars) {
                bw.write(car.toString());
            }
            return true;
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    public int searchID(String carID) {
        int len = cars.size();
        for (int i = 0; i < len; i++) {
            if(cars.get(i).getCarID().equalsIgnoreCase(carID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchFrame(String fID) {
        int len = cars.size();
        for (int i = 0; i < len; i++) {
            if(cars.get(i).getFrameID().equalsIgnoreCase(fID)) {
                return i;
            }
        }
        return -1;
    }
    
    public int searchEngine(String eID) {
        int len = cars.size();
        for (int i = 0; i < len; i++) {
            if(cars.get(i).getEngineID().equalsIgnoreCase(eID)) {
                return i;
            }
        }
        return -1;
    }
    
    

}
