package com.huang.pims.utils;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.SimpleBookmark;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class PdfUtil {

    private PdfUtil() {
        super();
    }

    private static final List<String> M_LIST = new ArrayList<>();
    
    private static Map<String, Integer> countMap = new LinkedHashMap<>();

    static {
        M_LIST.add("蒲公英");M_LIST.add("大青叶");M_LIST.add("苦参");M_LIST.add("黄芪");M_LIST.add("黄柏");M_LIST.add("黄芩");
        M_LIST.add("黄连");M_LIST.add("青蒿");M_LIST.add("常山");M_LIST.add("柴胡");M_LIST.add("地榆");M_LIST.add("白茅根");
        M_LIST.add("白芍");M_LIST.add("鸦胆子");M_LIST.add("甘草");M_LIST.add("当归");M_LIST.add("乌梅");M_LIST.add("大黄");
        M_LIST.add("茵陈");M_LIST.add("地锦草");M_LIST.add("仙鹤草");M_LIST.add("马齿苋");M_LIST.add("白头翁");M_LIST.add("秦皮");
        M_LIST.add("三七");M_LIST.add("白芨");M_LIST.add("山药");M_LIST.add("连翘");M_LIST.add("地黄");M_LIST.add("雷丸");
        M_LIST.add("贯众");M_LIST.add("大蒜");M_LIST.add("苦楝皮");M_LIST.add("姜");M_LIST.add("使君子");M_LIST.add("槟榔");

        M_LIST.stream().forEach(x -> countMap.put(x, 0));
    }
    public static Map<String, Integer> readPdf(InputStream inputStream) throws IOException {
        PdfReader pdfReader = new PdfReader(inputStream);

        return doSomething(pdfReader);
    }


//    public static void readPdf(String filePath) throws IOException {
//        PdfReader pdfReader = new PdfReader(filePath);
//        doSomething(pdfReader);
//
//    }

    private static Map<String, Integer> doSomething(PdfReader pdfReader) throws IOException {
        Map<String, Integer> map = new LinkedHashMap<>();
        int pages = pdfReader.getNumberOfPages();
        for (int i=1;i<=pages;i++) {
            String pageContent = PdfTextExtractor.getTextFromPage(pdfReader, i);
            M_LIST.stream().forEach(key -> {
                count(pageContent, key, map);
            });
        }
        for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
            countMap.put(entry.getKey(), countMap.get(entry.getKey()) + map.get(entry.getKey()));
        }
        return map;
    }

    public static void count(String source, String key, Map<String, Integer> map) {
        int start = 0;
        int idx = -1;
        int initCount = Objects.isNull(map.get(key)) ? 0 : map.get(key);
        int count = initCount;
        while ((idx = source.indexOf(key, start)) > -1) {
            count = count + 1;
            start = idx + key.length();
        }
        map.put(key, count);
    }


    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String fileName = "D:/"+ sdf.format(new Date()) + ".xls";
//
//        try{
//
//            File dir = new File("D:/aaa/");
//
//            File dataFile = new File(fileName);
//            System.out.println("创建数据文件:"+dataFile.createNewFile());
//
//            HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
//            HSSFSheet sheet = hssfWorkbook.createSheet("统计");
//            HSSFRow titleRow = sheet.createRow(0);
//            titleRow.createCell(0).setCellValue("");
//            int i = 1;
//            for (String key : M_LIST) {
//                titleRow.createCell(i).setCellValue(key);
//                i += 1;
//            }
//            int fileNum = 0;
//            if (dir.exists() && dir.isDirectory()) {
//                Map<String, Integer> map = null;
//                int ln = 1;
//                HSSFRow row;
//                for (File pdf : dir.listFiles()) {
//                    row = sheet.createRow(ln);
//                    row.createCell(0).setCellValue(pdf.getName());
//                    map = readPdf(new FileInputStream(pdf));
//                    int cn = 1;
//                    for(Map.Entry<String, Integer> entry : map.entrySet()) {
//                        row.createCell(cn).setCellValue(entry.getValue());
//                        cn += 1;
//                    }
//                    ln += 1;
//                    fileNum += 1;
//                }
//            }
//
//            HSSFRow lastRow = sheet.createRow(1 + fileNum + 1);
//            lastRow.createCell(0).setCellValue("总计");
//            int cn = 1;
//            for(Map.Entry<String, Integer> entry : countMap.entrySet()) {
//                lastRow.createCell(cn).setCellValue(entry.getValue());
//                cn += 1;
//            }
//
//            hssfWorkbook.write(new File(fileName));
//
//            System.out.println(countMap.toString());
//        } catch (FileNotFoundException e0) {
//            e0.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        String source = "蒲公英、大青叶、苦参、黄芪、常山、柴胡、常山、柴胡、苦参、青蒿、地榆炭、白茅根、白头翁、苦参、鸦胆子、旱莲草、地锦草、鸭跖草、败酱草、翻白草、藿香、紫苏、大腹皮、茯苓、白芷、陈皮、白术、厚朴、常山、地榆、玄参、地锦草、白茅根、常山、苦参、青蒿、青蒿、常山、白头翁、仙鹤草、槐花、黄芩、甘草、常山、白头翁、黄柏、仙鹤草、柴胡、黄芪、常山、苦参、地榆、柴胡、绞股蓝、青蒿、仙鹤草、何首乌、白头翁、肉桂、常山、青蒿、白头翁、黄连、黄芪、山楂、苦参、使君子、地榆、大黄、青蒿、常山、黄连、甘草、马鞭草、黄柏、郁金、栀子、苦参、白头翁、黄芪、白芍、苦参、马鞭草、五倍子、苦参、秦皮、苍术、乌梅、青蒿、仙鹤草、何首乌、白头翁、肉桂、常山、青蒿、苦参、黄芪、仙鹤草、常山、青蒿、苦参、柴胡、地榆、白头翁、常山、柴胡、青蒿、槟榔、苍术、仙鹤草、地榆、三七、大黄、黄连、黄柏、青蒿、常山、苦参、旱莲草、仙鹤草、柴胡、黄芪、甘草、常山、地榆、苦参、白头翁、仙鹤草、黄芩、柴胡、甘草、常山、青蒿、苦参、柴胡、地榆、白头翁、青蒿、使君子、大黄、当归、地榆、青蒿、常山、大黄、黄连、黄柏、黄芪、苦参、仙鹤草、地榆、常山、青蒿、常山、柴胡、地榆、绞股蓝、常山、柴胡、苦参、青蒿、地榆炭、白毛根、青蒿、常山、地榆、白芍、茵陈、黄柏、白头翁、秦皮、白芍、生地榆、苦参、三七、白及、鸦胆子、炒侧柏叶、生甘草、常山、鸦胆子、苦参、常山、仙鹤草、苦参、白头翁、苦参、地榆、乌梅、黄柏、黄芪、甘草、常山、青蒿、柴胡、黄芪、甘草、当归、熟地、黄柏、黄莲、黄芩、大黄、甘草、青蒿、常山、苦参、旱莲草、仙鹤草、柴胡、黄芪、甘草";


        List<String> mlist = new ArrayList<>(128);
        try {
            FileReader fileReader = new FileReader("D:/yao.txt");
            BufferedReader reader = new BufferedReader(fileReader, 4*1024);
            String s = "";
            int num = 0;

            while ((s = reader.readLine()) != null) {
                if (!s.trim().equals("")) {
                    mlist.addAll(Arrays.asList(StringUtils.split(s, "、")));
                    System.out.println((num += 1)+"=>"+s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



//        Map<String, List<String>> map = Arrays.asList(StringUtils.split(source, "、")).stream().collect(Collectors.groupingBy(String::valueOf));
        Map<String, List<String>> map = mlist.stream().collect(Collectors.groupingBy(String::valueOf));
        Map<String,Integer> cmap = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            cmap.put(entry.getKey(), entry.getValue().size());
        }

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        HSSFSheet sheet = hssfWorkbook.createSheet("统计");
        HSSFRow titleRow = sheet.createRow(0);
        titleRow.createCell(0).setCellValue("中药名称");
        titleRow.createCell(1).setCellValue("数量");

        HSSFRow dataRow;
        int dataLine = 1;
        for (Map.Entry<String, Integer> entry : cmap.entrySet()) {
            dataRow = sheet.createRow(dataLine);
            dataRow.createCell(0).setCellValue(entry.getKey());
            dataRow.createCell(1).setCellValue(entry.getValue());
            dataLine += 1;
        }

        try {
            hssfWorkbook.write(new File(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
