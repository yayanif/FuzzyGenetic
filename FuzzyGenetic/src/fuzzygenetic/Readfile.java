/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzygenetic;
/**
 *
 * @author Y
 */
import static fuzzygenetic.Readfile.wadah;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.util.ArrayList;

public class Readfile {
    //static String[] wadah;
    //static int total = 0;
    static ArrayList<String> wadah = new ArrayList<String>();
    
    public static void Countline(String x) throws FileNotFoundException, IOException{
        String line;
        FileReader ab = new FileReader(x);
        BufferedReader hitung = new BufferedReader(ab);
        while((line=hitung.readLine())!=null){
        wadah.add(line);
        //total++;
        }
    }
    
    public static int baris(int area){
    int j= wadah.size()-(2*area)-1;
    return j;
    }
    
}