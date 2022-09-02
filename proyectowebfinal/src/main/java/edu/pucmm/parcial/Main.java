package edu.pucmm.parcial;

import edu.pucmm.parcial.Handler.*;
import edu.pucmm.parcial.Services.StartDatabase;

public class Main {
    public static void main(String[] args) throws Exception {
        StartDatabase.getInstancia().startDb();
        new mainHandler().startup();
        new soapHandler().init();

    }
}
