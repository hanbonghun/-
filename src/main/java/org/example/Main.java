package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        //공통적으로 사용하는 것들을 모아두는 공간
        Container.init();
        new App().run();
        Container.close();
    }
}

