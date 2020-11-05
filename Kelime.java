/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kelime;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Sefa Dedeoğlu
 */
public class Kelime {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        int indis;
        ArrayList<String> liste = new ArrayList<>();
        Scanner scanner = new Scanner(System.in,"ISO-8859-9");
        boolean boolagain = true;
        while(boolagain){
            for (int i = 0; i < 50; ++i) System.out.println();//javada system cls kismini kullanamadigimdan ekrani temizliyorum
        char[] sesliharfler = {'A','E','O','Ö','U','Ü','I','İ'};
        char[] sessizharfler = { 'B', 'C', 'Ç', 'D', 'F', 'G', 'Ğ', 'H', 'Q', 'J', 'K', 'L', 'M', 'N', 'P', 'R', 'S', 'Ş', 'T', 'V', 'Y', 'Z'};
        char[] RandomHarfler = new char[9];
            System.out.println("Degerler Random gelsin mi yes/no\n");
            String sorguRandom = scanner.nextLine();
            if(sorguRandom.equals("yes")){
            for(int i=0;i<8;i++){
            if(i<4){
                indis = (int)(Math.random()*21);
                RandomHarfler[i] = sessizharfler[indis];
            }
            else{
                indis = (int)(Math.random()*8);
                RandomHarfler[i] = sesliharfler[indis];
            }
        }
            }
            else{
            for(int i=0;i<8;i++){
            System.out.println((i+1)+". Harf : ");
            String degisken = scanner.nextLine();
            degisken = degisken.toUpperCase();
            RandomHarfler[i]=degisken.toCharArray()[0];
        }
            }
        System.out.println("Bonus harf ister misiniz ?(Yes/No)");
        String ifBonus = scanner.nextLine();
        if(ifBonus.equals("Yes")||ifBonus.equals("yes")){
            System.out.println("Bonus Harf:");
            String degisken = scanner.nextLine();
            degisken = degisken.toUpperCase();
            RandomHarfler[8]=degisken.toCharArray()[0];
        }
        System.out.println("-----------------------\nRandom Harfler\n---------------------------------\n");
        for(int i=0;i<RandomHarfler.length;i++){
            System.out.print("\t"+RandomHarfler[i]);
        }
        System.out.println("\n");
        File file = new File("D://kelime.txt");
        if(!file.exists()){
            System.out.println("dosya yok");
        }
            FileReader fileReader =  new FileReader(file);
            String line;
            BufferedReader br = new BufferedReader(fileReader);
            while((line = br.readLine())!=null){
                int sayac = 0;
                boolean a = false;
                line = line.toUpperCase();
                char[] dosyaLine = line.toCharArray();
                String denemeee = "";
                for(int k=0;k<RandomHarfler.length;k++){
                    denemeee+=RandomHarfler[k];
                }
                char[] randomLine =denemeee.toCharArray();
                for(int i=0;i<dosyaLine.length;i++){
                    a=false;
                    for(int j=0;j<randomLine.length;j++){
                        if(randomLine[j]==dosyaLine[i]){
                            randomLine[j]='*';
                            a=true;
                        }
                    }
                    if(a==false){
                        break;
                    }
                    sayac++;
                }
                if(a==true){
                    String text;
                    if (sayac >= 3 && sayac < 6)
                    {
                        text = line +" "+sayac+" puan";
                        liste.add(text);
                    }
                    else if (sayac == 6)
                    {
                        text = line + " " + 7 + " puan";
                        liste.add(text);
                    }
                    else if (sayac == 7)
                    {
                        text = line + " " + 9 + " puan";
                        liste.add(text);
                    }
                    else if (sayac == 8)
                    {
                        text = line + " " + 11 + " puan";
                        liste.add(text);
                    }
                    else if (sayac == 9)
                    {
                        text = line + " " + 15 + " puan";
                        liste.add(text);

                    }
                }
            }
            liste.forEach((sonuclar) -> {
                System.out.println(sonuclar);
            });
            System.out.println("Yeniden Başlatmak ister misiniz?(yes/no)");
            String again = scanner.nextLine();
            if(again.equals("no")){
                boolagain=false;
            }
          }
    }
    
}
