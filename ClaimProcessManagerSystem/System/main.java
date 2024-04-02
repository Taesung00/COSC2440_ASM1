package System;

import Components.Claim;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.io.IOException;

import Functions.*;
import Components.*;

/**
 * @author <Taesung Yoon - S3847581>
 */

public class main {
    public static void main(String[] args) throws IOException, ParseException {
        Load l1 = new Load();
        l1.printAllFilesStartWith("C-");
    }
}
