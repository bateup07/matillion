package com.matillion.project;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.matillion.project.model.Element;
import com.matillion.project.model.Map;
import com.matillion.project.model.Row;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ThirdPart {

    private static final String CSV_FILE = "input/test_three.csv";
    private static final String API_KEY = "AIzaSyBrIc82c-lRG4kRc6KOSFkTh1YcDBDjhrI";

    public static void main(String[] args) throws IOException {

        //First step - Parse CSV file
        List<String> towns = parseCSV(CSV_FILE);

        //Second step - Pick up two towns randomly
        String[] twoTowns = getTowns(towns);

        //Third step - Calculate the distance between two towns
        String distance = getDistanceBetweenTwoTowns(twoTowns[0],twoTowns[1]);

        //Fourth step - Print out the distance
        System.out.println("It will take " + distance + " to walk from " + twoTowns[0].split(",")[0] +
                " to " + twoTowns[1].split(",")[0] + ".");

    }

    private static List<String> parseCSV(String csvFile) {

        Scanner scan = null;
        try {
            scan = new Scanner(new File(csvFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> towns = new ArrayList<String>();

        while (scan.hasNext()) {
            String line = scan.nextLine();
            towns.add(line);
        }
        scan.close();

        return towns;
    }

    private static String getDistanceBetweenTwoTowns(String twoTown, String twoTown1) throws IOException {

        String urlMap = "https://maps.googleapis.com/maps/api/distancematrix/json";
        urlMap += "?origins=" + URLEncoder.encode(twoTown, "UTF-8");
        urlMap += "&destinations=" + URLEncoder.encode(twoTown1, "UTF-8");
        urlMap += "&mode=walking";
        urlMap += "&key=" + API_KEY;

        URL url = new URL(urlMap);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject rootObj = root.getAsJsonObject();

        request.disconnect();

        Gson gson = new Gson();
        Map mapObject = gson.fromJson(rootObj, Map.class);

        String distanceAllocated = null;

        List<Row> rowElement = mapObject.getRows();
        if (rowElement !=null) {
            for (int i=0; i < rowElement.size();i++) {
                Row row = rowElement.get(i);
                if (row !=null) {
                    List<Element> element = row.getElements();
                    if(element !=null) {
                        for (int j=0; j < element.size();j++) {
                            Element element1 = element.get(j);
                            distanceAllocated = element1.getDuration().getText();
                        }
                    }
                }
            }
        }
        return distanceAllocated;
    }

    private static String[] getTowns(List<String> towns) {
        int twoElements = 2;
        Random rand = new Random();
        String[] twoTownsAllocated = new String[2];
        if (towns!=null) {
            for(int i =0; i < twoElements; i ++) {
                int randomIndex = rand.nextInt(towns.size());
                String randomElement = towns.get(randomIndex);
                twoTownsAllocated[i] = randomElement;
            }
        }
        return twoTownsAllocated;
    }
}