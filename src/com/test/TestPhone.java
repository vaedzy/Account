package com.test;

import com.account.utils.MobileMessageCheck;

import java.io.IOException;

public class TestPhone {
    public static void main(String [] args) throws IOException {
        String code = "";
        code = MobileMessageCheck.checkMsg("18725967698");
        System.out.println(code);
    }
}
