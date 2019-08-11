/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuzzygenetic;

import static fuzzygenetic.Readfile.Countline;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;
/**
 *
 * @author Y
 */

public class FuzzyGenetic {

 static String[][] flight, kota, tour, reverse, terbang;
 static String[] awal;
 static ArrayList<ArrayList<String>> aList = new ArrayList<>();
 static ArrayList<ArrayList<String>> List = new ArrayList<>();
 static ArrayList<ArrayList<String>>[] am = new ArrayList[301];
// static String[][] tour, re;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String lokasi_file = "Data/10.in";
        try {
            //int total=0;
            //String line;
            Readfile.Countline(lokasi_file);
            String cities, wilayah;
            //text = br.readLine();
            awal = Readfile.wadah.get(0).split(" ");
            System.out.println(awal[0]+" "+awal[1]);
            int num = Integer.parseInt(awal[0]);
            kota = new String[num][];
            int y= Readfile.baris(num);
            System.out.println(y);
            flight = new String[y][4];
            for(int i=0;i<num;i++){
                wilayah = Readfile.wadah.get((2*i)+1);
                //System.out.println(wilayah);
                cities = Readfile.wadah.get((2*i)+2);
                String[] kotas = cities.split(" ");
                kota [i]=new String[kotas.length+1];
                kota[i][0] = wilayah;
                    for (int q=0 ;q<kotas.length;q++){
                        kota[i][q+1] = kotas[q];
                        //System.out.print(kota[i][q+1]+" ");
                    }
                    
                //System.out.println();    
                }
            
             for (int b=0;b<=num;b++) { 
                am[b] = new ArrayList<ArrayList<String>>(); 
                }   
            for(int k=0;k<y;k++){
               //text = br.readLine();
                String [] jadual = Readfile.wadah.get((num*2)+1+k).split(" ");
                    int m=Integer.parseInt(jadual[2]);
                    
                    for(int j=0;j<=num;j++){
                        if(m==j || m==0){
                            ArrayList<String> an = new ArrayList<String>();
                            for(int z=0;z<jadual.length;z++){
                            an.add(jadual[z]);
                            }
                            am[j].add(an);
                        }
                     
                    }
                    
                    
                   // for(int j=0;j<jadual.length;j++){
                   // flight [k][j]= jadual[j];
                   // }
            }
            //pecahhari(num);
            //System.out.println();
            
            initial(num, awal[1], y);
            
            
            System.out.println("=============================================");
            System.out.println("Hasil Dari Awal");
            for(int u=0;u<=num;u++){
                System.out.println("Hari ke "+u+" :"+tour[u][0]+" "+tour[u][1]);
                
            }
            
            if(ceknull()==true){
            Tour.total=0;
            init(num, awal[1], y);
            int coba=0;
               while(ceknul()==true){
               Tour.total=0;
               init(num, awal[1], y);
               coba++;
               System.out.println(coba);
               }
                System.out.println("=============================================");
                System.out.println("Hasil Backtrack");
                for(int u=0;u<=num;u++){
                System.out.println("Hari ke "+u+" :"+reverse[u][0]+" "+reverse[u][1]);
                
            
            
                }
            }
            
             System.out.println("Total Cost: "+Tour.total);
        } 
        catch (FileNotFoundException fnfe) {
            fnfe.getMessage();
        } 
        catch (IOException ioe) {
            ioe.getMessage();
        }
    }
//MEMASUKKAN Ke ARRAY Tour
         static void initial(int banyak, String awal, int fly){
             //String area = null;
             tour = new String[banyak+1][2];
             tour[0][1]=awal;
             tour[0][0]=cek(banyak,awal);
             //String wadah;
             for(int q=1;q<=banyak;q++){
                tour [q][1]=random(awal,q,fly);
                if(tour[q][1]==null){
                break;
                }else{
                 tour[q][0]=cek(banyak,tour [q][1]);
                awal=tour [q][1];
                }
               
             }
            }
//CEK AREA       
        static String cek(int banyak, String in){
        for(int q=0;q<banyak;q++){
                for(int g=1;g<kota[q].length;g++){
                    if(kota[q][g].equals(in)){
                            in=kota[q][0];
                        }else{
                        
                    }
                    } 
                }
            return in;
         }
//Cek AREA YANG SUDAH DIKUNJUNGI(MASIH ERROR)
        static boolean Area(int hari,int tou, int h){
        boolean l=true;
        String a = cek(tou, am[hari].get(h).get(1));
            for(int j=0;j<tou;j++){
                String k = tour[j][0];
                    if(a==k){
                        l=false;
                        break;
                    }
            }
        return l;
        }
        
//RANDOM AREA        
        static String random(String awl, int hari, int bnyak){
            String kata=null;
            int m=Integer.parseInt(awal[0]);
//Banyaknya rute tersedia pada hari Tersebut
            
            if(m==hari){
//Memasukkan rute ke dalam Array 
                //re = new String[a][4];
                for(int i=0;i<am[hari].size();i++){
                    if((am[hari].get(i).get(0).equals(awl)) && cek(m,am[hari].get(i).get(1)).equals(cek(m, awal[1]))){
                        ArrayList<String> a1 = new ArrayList<String>();
                        for(int z=0;z<am[hari].get(i).size();z++){
                            a1.add(am[hari].get(i).get(z));
                            //re[b][z]=flight[i][z];
                        }
                        aList.add(a1);
                    //b++;
                    }
            
                }
               
            }else{
                
            for(int i=0;i<am[hari].size();i++){
                    if(am[hari].get(i).get(0).equals(awl) && cekhari(hari,i,1)&& Area(hari,m,i)){
                        ArrayList<String> a1 = new ArrayList<String>();
                    for(int z=0;z<am[hari].get(i).size();z++){
                            a1.add(am[hari].get(i).get(z));
                            //re[b][z]=flight[i][z];
                        }
                    aList.add(a1);
                }
            
            }
            
            }
             
//Melakukan Random rute yang didapatkan pada hari tersebut
                //System.out.println(aList);
                
                Random pnerbngan = new Random();
                if(aList.size()!=0){
                    /*
                    int a=pnerbngan.nextInt(aList.size());
                    //System.out.println(a);
                    if(hari!=m){
                    while(cekdepan(aList.get(a).get(1), hari, 1)==false){
                    aList.remove(a);
                    //System.out.println(a);
                    a=pnerbngan.nextInt(aList.size());
                    
                    }
                    kata=aList.get(a).get(1);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);
                  
                    }else{
                    kata=aList.get(a).get(1);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);
                    }
                    */
                     
                    
                    //}
                    //System.out.println(a);
                    int a=pnerbngan.nextInt(aList.size());
                    a=pnerbngan.nextInt(aList.size());
                    kata=aList.get(a).get(1);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);
                }
            aList.clear();
            return kata;
        }
        
        static boolean cekdepan(String awl, int hari, int s){
        Boolean j=false;
        int m=Integer.parseInt(awal[0]);
        String a=cek(m, awl);
        if(s==1){
        for(int x=0; x<am[hari+s].size();x++){
            String b= cek(m, am[hari+s].get(x).get(1));
            if(awl.equals(am[hari+s].get(x).get(0)) && Ars(a,b,m) && a!=b){
                j=true;
            }
            
        }
        }else{
        for(int x=0; x<am[hari+s].size();x++){
            String b= cek(m, am[hari+s].get(x).get(0));
            if(awl.equals(am[hari+s].get(x).get(1)) && Ar(a,b,m) && a!=b){
                j=true;
            }
            
        }        
        }
        return j;
        }
        
        static boolean Ars(String a, String b, int h){
        boolean l=true;
        //String a = cek(tou, am[hari].get(h).get(1));
            for(int j=0;j<h;j++){
                String k = tour[j][0];
                    if(a==k){
                        l=false;
                        break;
                    }
            }
        return l;
        }
         static boolean Ar(String a, String b, int h){
        boolean l=true;
        //String a = cek(tou, am[hari].get(h).get(1));
            for(int j=0;j<h;j++){
                String k = reverse[j][0];
                    if(a==k){
                        l=false;
                        break;
                    }
            }
        return l;
        }
        
//Megecek apakah hari selanjutnya terdapat rute yang bersambungan
        static boolean cekhari(int hari, int a, int l){
               boolean c=false;
               if(l==1){
               for(int f=0;f<am[hari+l].size();f++){
                    //int j =Integer.parseInt(am[hari+l].get(f).get(2));
                    //int j =Integer.parseInt(re[g][2]);
                        if(am[hari].get(a).get(1).equals(am[hari+l].get(f).get(0))){
                        c=true;
                        break;
                        }
                }
               }else{
               for(int f=0;f<am[hari+l].size();f++){
                    //int j =Integer.parseInt(am[hari+l].get(f).get(2));
                    //int j =Integer.parseInt(re[g][2]);
                        if(am[hari].get(a).get(0).equals(am[hari+l].get(f).get(1))){
                        c=true;
                        break;
                        }
                }
               }
            return c;
        }

    static boolean ceknull() {
    Boolean j=false;
    for(int i=0;i<tour.length;i++){
        if(tour[i][0]==null){
        j=true;
        break;
        }
    }
    return j;
    }
      
    
    
    //MASIH DALAM TAHAP PENGEMBANGAN       
//===========================================================================================================================
    static void init(int banyak, String awal, int fly){
             //String area = null;
             reverse = new String[banyak+1][2];
             //reverse[0][1]=awal;
             //reverse[0][0]=cek(banyak,awal);
             //String wadah;
             //System.out.println(banyak);
             reverse[banyak][1]=randm(awal,banyak,fly);
             //System.out.println(reverse[banyak][1]);
             awal=reverse[banyak][1];
             reverse[banyak][0]=cek(banyak,reverse[banyak][1]);
                for(int q=banyak-1;q>=0;q--){
                    //System.out.println(q);
                    reverse[q][1]=sdad(awal,q,fly);
                    //System.out.println(reverse[q][1]);
                    reverse[q][0]=cek(banyak,reverse[q][1]);
                    awal=reverse[q][1];
             }
            }

    private static String randm(String akh, int hari, int bnyak) {
            String kata=null;
            int m=Integer.parseInt(awal[0]);
//Banyaknya rute tersedia pada hari Tersebut
                for(int i=0;i<am[hari].size();i++){
                
                    if(cek(m, am[hari].get(i).get(1)).equals(cek(m, awal[1]))){
                        ArrayList<String> a1 = new ArrayList<String>();
                        for(int z=0;z<am[hari].get(i).size();z++){
                            a1.add(am[hari].get(i).get(z));
                            //re[b][z]=flight[i][z];
                        }
                        aList.add(a1);
                    //b++;
                    }
            
                }
                
            //System.out.println(aList);
//Melakukan Random rute yang didapatkan pada hari tersebut            
            Random pnerbngan = new Random();
                if(aList.size()!=0){
                    int a=pnerbngan.nextInt(aList.size());
                    kata=aList.get(a).get(1);//re[a][1];
                    //int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    //Tour.cost(j);
                }
            aList.clear();
            return kata;
        
        
    }
    
     
        static boolean Are(int hari,int tou, int h){
        boolean l=true;
        String a = cek(tou, am[hari].get(h).get(0));
            for(int j=1;j<=tou;j++){
                String k = reverse[j][0];
                    if(a==k){
                        l=false;
                        //break;
                    }
            }
        return l;
        }
         
         static String sdad(String akh, int hari, int bnyak){
            String kata=null;
            int m=Integer.parseInt(awal[0]);
            if(hari==m-1){
                for(int i=0;i<am[hari+1].size();i++){
                    if(am[hari+1].get(i).get(1).equals(akh)&& cekhari(hari+1,i,-1)){
                        ArrayList<String> a1 = new ArrayList<String>();
                        for(int z=0;z<am[hari+1].get(i).size();z++){
                            a1.add(am[hari+1].get(i).get(z));
                        }
                        aList.add(a1);
                    }
                }
               
                    
                }        
            
            if(hari != m-1 || hari !=0){
            for(int i=0;i<am[hari+1].size();i++){
                    if( am[hari+1].get(i).get(1).equals(akh)  && Are(hari+1,m, i) && cekhari(hari+1,i,-1)){
                    ArrayList<String> a1 = new ArrayList<String>();
                        for(int z=0;z<am[hari+1].get(i).size();z++){
                      a1.add(am[hari+1].get(i).get(z));
                    }
                    aList.add(a1);
                    }
            
            }
            
            }
            if(hari ==0){
            for(int i=0;i<am[hari+1].size();i++){
                    if(am[hari+1].get(i).get(1).equals(akh) && am[hari+1].get(i).get(0).equals(awal[1])){
                         ArrayList<String> a1 = new ArrayList<String>();
                        for(int z=0;z<am[hari+1].get(i).size();z++){
                        a1.add(am[hari+1].get(i).get(z));
                        }
                    aList.add(a1);
                    }
            }
            
            }
            
            
            //System.out.println(aList);
//Melakukan Random rute yang didapatkan pada hari tersebut            
            Random pnerbngan = new Random();
                if(aList.size()!=0){
                   /* int a=pnerbngan.nextInt(aList.size());
                   // if(hari>1){
                   // liat(aList.get(a).get(0), hari);
                    
                    //}
                    
                    kata=aList.get(a).get(0);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);*/
                    /*
                    int a=pnerbngan.nextInt(aList.size());
                    //System.out.println(a);
                    if(hari!=0){
                    while(cekdepan(aList.get(a).get(0), hari+1,-1)==false){
                    //System.out.println(aList.get(a).get(0));    
                    // System.out.println(a);
                    aList.remove(a);
                    a=pnerbngan.nextInt(aList.size());
                    
                    }
                    kata=aList.get(a).get(0);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);
                  
                    }else{
                    kata=aList.get(a).get(0);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);
                    }
                    */
                    
                    int a=pnerbngan.nextInt(aList.size());
                    a=pnerbngan.nextInt(aList.size());
                    kata=aList.get(a).get(0);//re[a][1];
                    int j= Integer.parseInt(aList.get(a).get(3));//re[a][3]);
                    Tour.cost(j);
                    
                    
                }
            aList.clear();
            return kata;
        
        
    }
         
         
   
    public static void pecahhari(int a) {
            for (int b=0;b<=a;b++) { 
                am[b] = new ArrayList<ArrayList<String>>(); 
                }        
            for(int i=0;i<flight.length;i++){
                int k =Integer.parseInt(flight[i][2]);
                    for(int j=0;j<=a;j++){
                        if(k==j || k==0){
                            ArrayList<String> an = new ArrayList<String>();
                            for(int z=0;z<flight[i].length;z++){
                            an.add(flight[i][z]);
                            }
                            am[j].add(an);
                        }
                     
                    }
            }
            //System.out.println(am[1]);
            //System.out.println(am[4]);
            //sambung();
            //System.out.println(am[1].size());
        
    }
    
     public static void sambung(){
         int banyak= Integer.parseInt(awal[0]);
            for(int q=1;q<=banyak;q++){
                clean(q);
             }
            for(int q=1;q<=banyak;q++){
                cleanl(q);
             }
        
        
     }
     
    

    private static boolean ceknul() {
        Boolean j=false;
        for(int i=0;i<reverse.length;i++){
        if(reverse[i][0]==null){
        j=true;
        break;
        }
        }
    return j;
    }
    
    //RANDOM AREA        
        static void clean(int hari){
            String kata=null;
            int m=Integer.parseInt(awal[0]);
//Banyaknya rute tersedia pada hari Tersebut
            
            if(hari==m){
//Memasukkan rute ke dalam Array 
                //re = new String[a][4];
                for(int i=0;i<am[hari].size();i++){
                    if( cek(m, am[hari].get(i).get(1)).equals(cek(m, awal[1])) &&cekhari(hari,i,-1)){
                        
                        
                    //b++;
                    }else{
                    am[hari].remove(i);
                    }
            
                }
               
            }else if(hari==1){
             for(int i=0;i<am[hari].size();i++){
                    if(am[1].get(i).get(0)==awal[1]){
                        
                        
                    //b++;
                    }else{
                    am[hari].remove(i);
                    }
            
                }
            }
            else{
            for(int i=0;i<am[hari].size();i++){
                    if(cekhari(hari,i,-1)){
                        
                   
                }else{
                    am[hari].remove(i);
                    }
            
            }
            
            }
             
//Melakukan Random rute yang didapatkan pada hari tersebut
            //System.out.println(aList);
            
            //aList.clear();
            
        }

    /*private static void liat(String a, int b) {
        for int(){}
        
    }*/

    private static void cleanl(int hari) {
        String kata=null;
            int m=Integer.parseInt(awal[0]);
//Banyaknya rute tersedia pada hari Tersebut
            
            if(hari==m){
//Memasukkan rute ke dalam Array 
                //re = new String[a][4];
                for(int i=0;i<am[hari].size();i++){
                    if(cek(m, am[hari].get(i).get(1)).equals(cek(m, awal[1]))){
                        
                        
                    //b++;
                    }else{
                    am[hari].remove(i);
                    }
            
                }
               
            }else if(hari==1){
             for(int i=0;i<am[hari].size();i++){
                    if(am[1].get(i).get(0)==awal[1] && cekhari(hari,i,1)){
                        
                        
                    //b++;
                    }else{
                    am[hari].remove(i);
                    }
            
                }
            }
            else{
            for(int i=0;i<am[hari].size();i++){
                    if(cekhari(hari,i,1)){
                        
                   
                }else{
                    am[hari].remove(i);
                    }
            
            }
            
            }
             
//Melakukan Random rute yang didapatkan pada hari tersebut
            //System.out.println(aList);
            
            //aList.clear();
    
    }
    
}