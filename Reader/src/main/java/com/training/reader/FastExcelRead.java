package com.training.reader;



import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.dhatim.fastexcel.reader.ReadableWorkbook;
import org.dhatim.fastexcel.reader.Row;
import org.dhatim.fastexcel.reader.Sheet;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.training.entity.Register;
import com.training.entity.RequestPayload;

import lombok.var;

public class FastExcelRead {

    public static void main(String[] args) throws IOException {
    	List<String> list=new ArrayList<String>();
    	String url1="http://localhost:9000/enrolluser";
    	
    	String url = "http://localhost:9000/getUser/9";
    	RestTemplate restTemplate = new RestTemplate();
    	System.out.println("Hi");
    	ResponseEntity<Register> response = restTemplate.getForEntity(url,Register.class);
    	// ResponseEntity<Invoice[]> response = restTemplate.exchange(url, HttpMethod.GET, null, Invoice[].class);
    	System.out.println("Hi1");
    	System.out.println(response);
    	Register invs = response.getBody();
    	System.out.println("Hi2");
    	System.out.println(invs.toString());
    	
        
    	RequestPayload request=new RequestPayload("arpia@zee.com",399);
    	System.out.println(request);
    	ResponseEntity<String> response1 = restTemplate.postForEntity(url1,request,String.class);
    	String invs1 = response1.getBody();
    	System.out.println("Hi2");
    	System.out.println(invs1.toString());


        var f = new File("C:\\\\Users\\\\arpit.shreshth\\\\zee_ent\\\\Reader\\\\src\\\\main\\\\resources/words.xlsx");

        try (var wb = new ReadableWorkbook(f)) {

            Sheet sheet = wb.getFirstSheet();

            try (Stream<Row> rows = sheet.openStream()) {

                var it = rows.iterator();

                int i = 0;
                while (it.hasNext()) {

                    var row = it.next();
                    System.out.println();
                    
                    row.stream().forEach(cell -> list.add(cell.getText()));

                    i++;
                }
                int pointer=list.size()-1;
                 while(pointer>=2) {
                	String a=list.get(pointer);
                	pointer--;
                	String b=list.get(pointer);
                	pointer--;
                	System.out.println(b);
                	int c=Integer.parseInt(a);
                	RequestPayload request1=new RequestPayload(b,c);
                	System.out.println(request);
                	ResponseEntity<String> response2 = restTemplate.postForEntity(url1,request1,String.class);
                	String invs2 = response2.getBody();
                	System.out.println("Hi2");
                	System.out.println(invs2.toString());
                	
                	
                }
                System.out.println(list.size());
            }
        }
    }
}