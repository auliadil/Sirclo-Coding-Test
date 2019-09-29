//package com.sirclo.rest;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.URL;
//
//import org.json.JSONArray;
//import org.json.JSONObject;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.sirclo.model.IklimModel;
//
//@Service
//@Transactional
//public class RestService {
//	
//	@Override
//	public IklimModel getIklimModel(long idKota) {
//        	String key = "271da6b323b05ebaf2b4aaa0f3378f89";
//    		String path = "https://" + Setting.openWeatherUrl + "forecast?id=" + idKota + "&q=&mode=json&units=metric&cnt=5&appid=" + key;
////        	System.out.println(path);
//    		
////        	String key = "AIzaSyAE6FolYntrWscr26o9pd7ZytyGVcM29jHk";
////            String url = "https://maps.googleapis.com/maps/api/geocode/json?latlng=40.714224,-73.961452&key=" + key;
//            URL url = new URL(path);
////            System.out.println(obj.toString());
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            // optional default is GET
//            con.setRequestMethod("GET");
//            //add request header
//            con.setRequestProperty("User-Agent", "Mozilla/5.0");
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            StringBuffer response = new StringBuffer();
//            while ((inputLine = in .readLine()) != null) {
//                response.append(inputLine);
//            } in .close();
////            System.out.println(response.toString());
//           
//            JSONObject objIklim = new JSONObject(response.toString());
//            JSONArray list = objIklim.getJSONArray("list");
//            System.out.println(list);
//            IklimModel iklim = new IklimModel();
//            for(int i = 0; i < list.length(); i++) {
////            	System.out.println(1);
//            	JSONObject objList = new JSONObject(list.get(i).toString());
//            	Long dt = objList.getLong("dt");
//            	JSONObject main = objList.getJSONObject("main");
//            	Long temp = main.getLong("temp");
//            	Long temp_min = main.getLong("temp_min");
//            	Long temp_max = main.getLong("temp_max");
//            	iklim.getDt().add(dt);
//            	iklim.getTemp().add(temp);
//            	iklim.getTemp_min().add(temp_min);
//            	iklim.getTemp_max().add(temp_max);
//            }
//            JSONObject city = objIklim.getJSONObject("city");
//            iklim.setId(city.getLong("id"));
//            iklim.setName(city.getString("name"));
//            return iklim;
//        
//    }
//}
//
