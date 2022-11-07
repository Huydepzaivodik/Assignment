/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;


import bo.BrandList;
import consts.IConst;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BrandList brandBO = new BrandList();
        brandBO.loadFromFile(IConst.BRANDPATH);   
        brandBO.show();
    }
    
}
