/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

public class HttpTools {
	
	public static int doJSONPost(URL url, String body) throws IOException{
        //String encoding;
        String line;
        int response=-1;
        HttpURLConnection connection = null;
        OutputStreamWriter osw = null;
        System.out.println("**URL***"+url.getFile());
        BufferedReader in = null;
        BufferedReader inError = null;
        
        try {
        	System.out.println("en dopostjson BODY:\n"+body);
            //encoding = Base64.getEncoder().encodeToString((EntornoTools.user + ":"+ EntornoTools.password).getBytes("UTF-8"));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            connection.setRequestProperty("Accept", "application/json");
            //connection.setRequestProperty("Authorization", "Basic " + encoding);
            OutputStream os = connection.getOutputStream();
            osw = new OutputStreamWriter(os, "UTF-8");    
            osw.write(body);
            osw.flush();
            
            /*InputStream content = (InputStream)connection.getInputStream();
            in = new BufferedReader (new InputStreamReader (content));
            while ((line = in.readLine()) != null) {
                response += line+"\n";
            }*/
            
            connection.getInputStream();
            response = connection.getResponseCode();
            
            /*InputStream contentError = (InputStream)connection.getErrorStream();
            inError = new BufferedReader (new InputStreamReader (content));
            while ((line = inError.readLine()) != null) {
                response += line+"\n";
            }*/
            System.out.println("from doJSONPost -> "+
            "respuesta: "+response);
        } catch (IOException e) {
                throw new IOException(e);
        }
        finally{
            if(osw != null)
                osw.close();
            if(connection != null)
                connection.disconnect();
            if(in != null)
            	in.close();
            if(inError != null)
            	inError.close();
        }
        return response;
    }
    
    public static String doDelete(URL url) throws IOException{
        //String encoding;
        String line;
        String response="";
        HttpURLConnection connection = null;
        OutputStreamWriter osw = null;
        System.out.println("**URL***"+url.getFile());
        BufferedReader in = null;
        BufferedReader inError = null;
        try {
            //encoding = Base64.getEncoder().encodeToString((EntornoTools.user + ":"+ EntornoTools.password).getBytes("UTF-8"));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("DELETE");
            connection.setDoOutput(true);
            
            InputStream content = (InputStream)connection.getInputStream();
            in  = new BufferedReader (new InputStreamReader (content));
            while ((line = in.readLine()) != null) {
            //System.out.println(line);
                response += line+"\n";
            }
            
//            connection.getInputStream();
//            response = String.valueOf(connection.getResponseCode());
            
            
        } catch (IOException e) {
                throw new IOException(e);
        }
        finally{
            if(osw != null)
                osw.close();
            if(connection != null)
                connection.disconnect();
            if(in != null)
            	in.close();
            if(inError != null)
            	inError.close();
        }
        return response;
    }
    
    public static String doJSONGet(URL url) throws IOException{
        //String encoding;
        String line;
        String json="";
        HttpURLConnection connection = null;
        try {
            //encoding = Base64.getEncoder().encodeToString((EntornoTools.user + ":"+ EntornoTools.password).getBytes("UTF-8"));
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            //connection.setRequestProperty("Authorization", "Basic " + encoding);
            InputStream content = (InputStream)connection.getInputStream();
            BufferedReader in   = 
            new BufferedReader (new InputStreamReader (content));
            while ((line = in.readLine()) != null) {
            //System.out.println(line);
                json += line+"\n";
            }
        } catch (IOException e) {
                throw new IOException(e);
        }
        finally{
            if(connection != null)
                    connection.disconnect();
        }

        return json;
    }

}
