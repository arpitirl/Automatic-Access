package com.training.writer;

import org.dhatim.fastexcel.Workbook;
import org.dhatim.fastexcel.Worksheet;

import lombok.var;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FastExcelSimpleWrite {

    public static void main(String[] args) throws IOException {

        var words = List.of("sky", "blue", "work", "falcon");

        int row = 0;
        int col = 0;

        var f = new File("C:\\Users\\arpit.shreshth\\zee_ent\\Reader\\src\\main\\resources/words.xlsx");

        try (var fos = new FileOutputStream(f)) {

            var wb = new Workbook(fos, "Application", "1.0");
            Worksheet ws = wb.newWorksheet("Sheet 1");

            for (var word : words) {

                ws.value(row, col, word);
                row++;
            }

            wb.finish();
        }
    }
}