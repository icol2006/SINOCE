/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patron;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author dafons
 */
public class LoggerHandlerSingleton {

    private static LoggerHandlerSingleton instance;
    private FileHandler fh;

    private LoggerHandlerSingleton() {
        try {
            fh = new FileHandler("./bitacora.log");
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (SecurityException | IOException e) {
            
        }
    }

    public static LoggerHandlerSingleton getInstance() {
        if (instance == null) {
            instance = new LoggerHandlerSingleton();
        }

        return instance;
    }

    public FileHandler getFh() {
        return fh;
    }
}
