package org.splunkjava;

import com.splunk.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Java Application: Splunk Enterprise - Java Integration
 *                   Fetching data from Splunk through queries like Splunk App Search
 *                   Sending Events to splunkd server (Splunk Enterprise Server)
 *
 * @author    Mauro Travieso
 * @version   1.0
 *
 * Bugs: None known
 */

public class SplunkJava {

    public static void main(String[] args) {

        // Overriding the static method setSslSecurityProtocol 
        // to implement the security protocol of choice
        HttpService.setSslSecurityProtocol( SSLSecurityProtocol.TLSv1_2 );

        // Method 1
        Map<String, Object> connectionArgs = new HashMap<String,Object>();
        connectionArgs.put("host", "splunk_server");
        connectionArgs.put("username", "user");       // <- Implement Security with Scanner class
        connectionArgs.put("password", "password");   // <- Implement Security with Scanner class
        connectionArgs.put("port", 8089);             // splunkd server port
        connectionArgs.put("scheme", "https");

        // To login and save the session which gets put in the HTTP Authorization header
        Service splunkService = Service.connect(connectionArgs);
        //splunkService.login();
        System.out.println("Sucessfully connected with session token: " + splunkService.getToken() + "\n");

        // Getting Service info
        ServiceInfo info = splunkService.getInfo();
        System.out.println("Info:");
        for (String key : info.keySet())
            System.out.println(" " + key + ": " + info.get(key));
        System.out.println(" ");

        // Method 2
//        ServiceArgs loginArgs = new ServiceArgs();
//
//        loginArgs.setHost("splunk_server");
//        loginArgs.setUsername("user");
//        loginArgs.setPassword("password");
//        loginArgs.setPort(8089);
//        loginArgs.setScheme("https");
//        Service splunkService = Service.connect(loginArgs);


        // Searching through Query arguments
        Args queryArgs = new Args();
        queryArgs.put("earliest_time", "-4h@h");
        queryArgs.put("latest_time", "now");

        System.out.println("Query results: ");
        Job job = splunkService
                .getJobs()
                .create("search index=hdfs_logs | head 1");

        while (!job.isDone()) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println("Exception caught");
            }
        }

        try {
            Args outputArgs = new Args();

            // Output mode formats: CSV, JSON, XML(default)
            // outputArgs.put("output_mode", "json");
            // outputArgs.put("output_mode", "csv");
            // outputArgs.put("output_mode", "raw");
            outputArgs.put("output_mode", "xml");
            InputStream stream = job.getResults(outputArgs);

            byte[] buffer = new byte[4096];
            while (stream.read(buffer) != -1) {
                System.out.println(new String(buffer));
            }
        } catch (Exception e) {
            System.out.println("Exception caught!!!");
        }

        // Sending events to Splunkd server

        // Setting the sourcetype
        Args logArgs = new Args();
        logArgs.put("sourcetype", "JavaSplunk");

        Receiver receiver = splunkService.getReceiver();

        int num_events = 7;
        for (int i=0; i<num_events; i++) {
            // Event to send to Splunk
            receiver.log("main", logArgs, "Java Splunk event");
        }

        // Search in Splunk using "index=main sourcetype=JavaSplunk"
        System.out.println("\n\nEvent(s) sent successfully!!!");
        System.out.println("\nSearch in Splunk, using -> index=main sourcetype=JavaSplunk");

    }

}
