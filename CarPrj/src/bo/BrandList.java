/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import entity.Brand;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author user
 */
public class BrandList {
    
    private List<Brand> lstBrand = new ArrayList<>();
    
    public boolean loadFromFile(String fileBrands) { 
        boolean result = false;
        try {
            File f = new File(fileBrands);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                //StringTokenizer stk = new StringTokenizer(line, ",");
                String [] words = line.split(", ");
                String brandid = words[0];
                String brandName = words[1];
                String soundBrand = words[2];
                double price = Double.parseDouble(words[3]);
                Brand tmp = new Brand(brandid, brandName, soundBrand, price);
                lstBrand.add(tmp);
            }
            System.out.println("End of file. ");
            br.close();
            fr.close();
            result = true;
            System.out.println("Read data from file " + fileBrands + " is completerd. ");
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
        }
        return result;
    }

    public boolean saveToFile(String fileBrands) {
        boolean result = false;
        try {
            File f = new File(fileBrands);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            for (Brand b : lstBrand) {
                pw.println(b);
            }
            System.out.println("Save to file " + fileBrands + " is success. ");
            pw.close();
            fw.close();

        } catch (Exception e) {

            return result;

        }
        return result;
    }
    
    public void show() {
        for( Brand b : lstBrand) {
            System.out.println(b);
        }
    }
    
    public void addBrand() {  // can fix them
        Scanner sc = new Scanner(System.in);
        String id = sc.nextLine();
        String name = sc.nextLine();
        String sound =sc.nextLine();
        double price = Double.parseDouble(sc.nextLine());
        Brand b = new Brand(id, name, sound, price);
        lstBrand.add(b);
    }
}
