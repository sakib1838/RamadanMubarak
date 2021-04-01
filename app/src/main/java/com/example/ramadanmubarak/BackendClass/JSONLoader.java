package com.example.ramadanmubarak.BackendClass;

import android.app.Activity;
import android.content.Context;
import android.provider.ContactsContract;

import com.example.ramadanmubarak.RahmatFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class JSONLoader {

    private Context context;

    public JSONLoader(Context context){
        this.context=context;
    }

    public String loadJsonFromAsset(){
        String json = null;

        try{
            InputStream is= context.getAssets().open("RamadanCalendarDhaka2021.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

    public Object parseJSON(JSONObject jsonObject) throws JSONException {
        Ramadan ramadan = new Ramadan();
        ramadan.setRamadanDay(jsonObject.getString("ramadanDay"));
        System.out.println(jsonObject.getString("ramadanDay"));
        ramadan.setDate(jsonObject.getString("date"));
        ramadan.setDay(jsonObject.getString("day"));
        ramadan.setSehar(jsonObject.getString("Sehar"));
        ramadan.setIftar(jsonObject.getString("Iftar"));

        return ramadan;
    }

}
