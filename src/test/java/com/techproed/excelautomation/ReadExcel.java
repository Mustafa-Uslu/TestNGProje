package com.techproed.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

public class ReadExcel {

    @Test
    public void test() throws IOException {
        String dosyaYolu="C:\\Users\\Asus\\IdeaProjects\\TestNGProje\\src\\test\\resources\\ULKELER.xlsx";
        //Java'da bir dosyayı açmak için bu kullanılır.
        // Parametre bölümüne açmak istediğimiz dosyanın adresi (dosya yolu,path) yazılır
        FileInputStream fileInputStream =new FileInputStream(dosyaYolu);
        // Workbook (excel) dosyasını okumaya başladık.
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        // 1. sayfaya gider. (index değeri 0'dan başlar.)
        Sheet sheet       = workbook.getSheetAt(0);//0 index numarali sayfaya gider index 0 dan baslar
        // 1. satıra gidelim. (index değeri 0'dan başlar.)
        Row row           = sheet.getRow(0);
        // 1. Hücreyi alalım. (index değeri 0'dan başlar.)
        Cell ulkeler      = row.getCell(0);
        Cell baskentler   = row.getCell(1);
        Cell meshurlar    = row.getCell(2);
        System.out.println(ulkeler);
        System.out.println(baskentler);
        System.out.println(meshurlar);

        // Excel'e Git -> Sheet 0'a git -> 3. İndexteki Satıra git -> 1. İndexteki Hücre
        System.out.println(workbook.getSheetAt(0).getRow(3).getCell(1));
        System.out.println(workbook.getSheetAt(0).getRow(7).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(1).getCell(2));
        System.out.println(workbook.getSheetAt(0).getRow(10).getCell(0));

        // Son satır(Row)'ın numarasını almak için (indexini, index 0 dan başlar)
        int satirSayisi = workbook.getSheetAt(0).getLastRowNum() + 1;
        System.out.println("Satır sayısı : " + satirSayisi);

        // İçerisinde veri olan satır sayısını almak isterseniz
        // index'i 1'den başlıyor.
        int doluSatirSayisi = workbook.getSheetAt(0).getPhysicalNumberOfRows(); //dolu hucre sayisini verir
        System.out.println("Dolu Satır Sayısı : " + doluSatirSayisi);

        // ülkeler sütunu yazdirma
        int sonSatirinIndexi =workbook.getSheetAt(0).getLastRowNum(); //10
        for (int i=0 ; i<=sonSatirinIndexi ; i++){
            System.out.println(workbook.getSheetAt(0).getRow(i).getCell(0));
        }
        // baskentler sütunu yazdirma
        for (int j=0 ; j<=sonSatirinIndexi ; j++){
            System.out.println(workbook.getSheetAt(0).getRow(j).getCell(1));
        }
        System.out.println(" ");
        // meshur sütunu yazdirma
        for (int k=0 ; k<=sonSatirinIndexi ; k++){
            System.out.println(workbook.getSheetAt(0).getRow(k).getCell(2));
        }
        // bir satırın son sütunun indexini alma
        int sonSutunIndex = workbook.getSheetAt(0).getRow(0).getLastCellNum();// index 1'den basliyor
        System.out.println("Son Sütun İndex : " + sonSutunIndex);


        Random random = new Random(); //rasgele sectirme
        for (int i = 0; i <10 ; i++) {
            int a = random.nextInt(10);
            int b = random.nextInt(3);
            System.out.print(workbook.getSheetAt(0).getRow(a).getCell(b)+"-");
        }
        System.out.println(" ");
        //tek satiri yazdirma
        for(int k = 0; k < sonSutunIndex ; k++) {
            System.out.println("4. Satır " + k + ". Sütun :" + workbook.getSheetAt(0).getRow(3).getCell(k));
        }
        // tüm verileri yazdirma
        for(int i=0;i<sonSatirinIndexi;i++){
            for (int j = 0; j < sonSatirinIndexi; j++) {
                System.out.print(workbook.getSheetAt(0).getRow(i).getCell(j)+"-");
            }
            System.out.println("");
        }
        workbook.close();
        fileInputStream.close();
    }

}
