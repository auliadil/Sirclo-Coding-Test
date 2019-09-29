package com.sirclo.service;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sirclo.model.IklimModel;
import com.sirclo.model.RowModel;
import com.sirclo.rest.Setting;
import com.sirclo.service.IklimService;

@Service
@Transactional
public class IklimServiceImp implements IklimService{
	
	@Override
	public IklimModel getIklimModel(long idKota) {
		try {
        	String key = "271da6b323b05ebaf2b4aaa0f3378f89";
    		String path = "https://" + Setting.openWeatherUrl + "forecast?id=" + idKota + "&q=&mode=json&units=metric&cnt=5&appid=" + key;
            URL url = new URL(path);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();
           
            JSONObject objIklim = new JSONObject(response.toString());
            JSONArray list = objIklim.getJSONArray("list");
            IklimModel iklim = new IklimModel();
            for(int i = 0; i < list.length(); i++) {
            	JSONObject objList = new JSONObject(list.get(i).toString());
            	Long dt = objList.getLong("dt");
            	JSONObject main = objList.getJSONObject("main");
            	Long temp = main.getLong("temp");
            	Long temp_min = main.getLong("temp_min");
            	Long temp_max = main.getLong("temp_max");
            	iklim.getDt().add(dt);
            	iklim.getTemp().add(temp);
            	iklim.getTemp_min().add(temp_min);
            	iklim.getTemp_max().add(temp_max);
            }
            JSONObject city = objIklim.getJSONObject("city");
            iklim.setId(city.getLong("id"));
            iklim.setName(city.getString("name"));
            return iklim;
		}
		catch (Exception e) {
			return null;
		}
    }
	
	public LinkedList<RowModel> getRowModel(IklimModel iklimModel) {
		
		LinkedList<RowModel> rowList = new LinkedList<RowModel>();
		for(int i = 0; i < iklimModel.getDt().size(); i++) {
			RowModel row = new RowModel(iklimModel.getDt().get(i), iklimModel.getTemp().get(i), iklimModel.getTemp_min().get(i), iklimModel.getTemp_max().get(i));
			rowList.add(row);
		}
		return rowList;
	}

	@Override
	public long getRataSuhu(LinkedList<RowModel> rowList) {
		long totalSuhu = 0;
		int size = rowList.size();
		for(int i = 0; i < size; i++) {
			totalSuhu += rowList.get(i).getSuhu();
		}
		
		return totalSuhu/size;
	}

	@Override
	public long getRataPerbedaan(LinkedList<RowModel> rowList) {
		int size = rowList.size();
		long totalPerbedaan = 0;
		for(int i = 0; i < size; i++) {
			totalPerbedaan += rowList.get(i).getPerbedaan();
		}
		return totalPerbedaan/size;
	}
}

