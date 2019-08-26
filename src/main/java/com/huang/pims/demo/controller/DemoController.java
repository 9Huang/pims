package com.huang.pims.demo.controller;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/demo")
public class DemoController {



    @ResponseBody
    @RequestMapping("/href")
    public String hrefRequest() {
        return "hrefResponse";
    }

    @ResponseBody
    @RequestMapping("/parse")
    public String parse() {
        String str = "init";

        try (FileOutputStream fos = new FileOutputStream("bank_bin.xls")) {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource("bank_bin.txt");
            if (null != resource && null != resource.getFile() && resource.getFile().exists()) {
                BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));
                String line;
                StringBuilder sb;
                String bin;
                Map<String, Bank> bankMap = new HashMap<>();

                String indexKey01 = "类型是";
                String indexKey02 = "长度为";
                String indexKey03 = "位";
                while ((line = bufferedReader.readLine()) != null) {
                    sb = new StringBuilder();
                    for (char c : line.toCharArray()) {
                        if (c >= 48 && c <= 57) {
                            sb.append(c);
                        } else {
                            break;
                        }
                    }
                    bin = sb.toString();
                    if (StringUtils.isBlank(bin)) {
                        continue;
                    }
                    Bank b = bankMap.get(bin);
                    if (null == b) {
                        Bank bank = new Bank();
                        bank.setBin(bin);
                        bank.setBinClass(line.substring(bin.length()));
                        bankMap.put(bin, bank);

                    } else {
                        Bank bank = b;
                        if (null == bank.getStatus()) {
                            if (line.indexOf(indexKey01) > -1) {
                                bank.setBinType(line.substring(line.indexOf(indexKey01) + indexKey01.length()));
                            } else if (line.indexOf(indexKey02) > -1) {
                                bank.setBinLength(line.substring(line.indexOf(indexKey02) + indexKey02.length(), line.indexOf(indexKey03)));
                            }
                            bankMap.put(bin, bank);
                        } else {
                            System.out.println(line);
                        }
                    }


                }
                System.out.println("bankMap："+bankMap.size());
                bankMap.entrySet().stream().forEach(kv -> System.out.println(JSONArray.toJSONString(kv.getValue())));

                HSSFWorkbook workbook = new HSSFWorkbook();
                HSSFSheet sheet = workbook.createSheet("bank");
                HSSFRow titleRow = sheet.createRow(0);
                HSSFCell cell;
                cell = titleRow.createCell(0);
                cell.setCellValue("BIN");
                cell = titleRow.createCell(1);
                cell.setCellValue("银行");
                cell = titleRow.createCell(2);
                cell.setCellValue("支行");
                cell = titleRow.createCell(3);
                cell.setCellValue("卡号长度");


                int lineNum = 1;

                for (Map.Entry<String, Bank> entry : bankMap.entrySet()) {
                    HSSFRow dataRow = sheet.createRow(lineNum);
                    dataRow.createCell(0).setCellValue(entry.getKey());
                    dataRow.createCell(1).setCellValue(entry.getValue().getBinClass());
                    dataRow.createCell(2).setCellValue(entry.getValue().getBinType());
                    dataRow.createCell(3).setCellValue(entry.getValue().getBinLength());
                    ++lineNum;
                }


                workbook.write(fos);


                str = "ok";
            } else {
                str = "not found";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }


}
