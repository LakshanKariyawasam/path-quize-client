package com.perisic.peripherals;


import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import javafx.application.Application; 
import javafx.scene.Scene; 
import javafx.stage.Stage;
import javafx.scene.web.*; 

//import java.net.http.HttpClient;
//import java.net.http.HttpRequest;
//import java.net.http.HttpResponse;
   
public class Dashboard extends Application { 
   
//    private String stringData;

	// launch the application 
    public void start(Stage stage) 
    { 
        try { 
        
            // set title for the stage 
            stage.setTitle("Dashboard"); 
   
            // create a webview object 
            WebView w = new WebView(); 
   
            // get the web engine 
            WebEngine e = w.getEngine();
            e.load("https://chart-service.herokuapp.com/tasks/zdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4/1"); 
   
            // create a scene 
            Scene scene = new Scene(w, w.getPrefWidth(),  
                                     w.getPrefHeight()); 
   
            // set the scene 
            stage.setScene(scene); 
   
            stage.show(); 
        } 
   
        catch (Exception e) { 
   
            System.out.println(e.getMessage()); 
        } 
    } 
   
    // Main Method 
    public static void main(String args[]) 
    { 
   
        // launch the application 
        launch(args); 
    } 
} 
