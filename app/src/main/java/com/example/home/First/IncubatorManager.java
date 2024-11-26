package com.example.home.First;


import android.util.Log;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class IncubatorManager {

    public void createIncubator(String name,int size, Double temperature, Double humidity, String image , CreateCallback callback) {
        ParseObject incubator = new ParseObject("Incubator");
        incubator.put("name", name);
        incubator.put("size",size );
        incubator.put("temperature", temperature);
        incubator.put("humidity", humidity);
        incubator.put("image", image);
        incubator.saveInBackground(e -> {
            if (e == null) {
                Log.i("CreateIncubator", "Incubator created");
                callback.onComplete(null);
            }
            else {Log.e("IncubatorCreate", e.getMessage());
                callback.onComplete(e);}
        });
    }

    public void readIncubators(ReadCallback callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Incubator");
        query.findInBackground((objects, e) -> {
            List<Incubator> incubators = new ArrayList<>();
            if (e == null) {
                for (ParseObject parseObject : objects) {
                    String id = parseObject.getObjectId();
                    String name = parseObject.getString("name");
                    int size = parseObject.getInt("size");
                    Double temperature = parseObject.getDouble("temperature");
                    Double humidity = parseObject.getDouble("humidity");
                    String image = parseObject.getString("image");

                    Incubator incubator = new Incubator(name,size, temperature, humidity, image);
                    incubator.setObjectId(id);
                    incubators.add(incubator);

                }
            }
            callback.onComplete(incubators, e);
        });
    }

    public void updateIncubator(String id,int size, String newName, Double newTemperature, Double newHumidity, String newImage, UpdateCallback callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Incubator");
        query.getInBackground(id, (parseObject, e) -> {
            if (e == null) {
                parseObject.put("name", newName);
                parseObject.put("size", size);
                parseObject.put("temperature", newTemperature);
                parseObject.put("humidity", newHumidity);
                parseObject.put("image", newImage);
                parseObject.saveInBackground(callback::onComplete);
            } else {
                callback.onComplete(e);
            }
        });
    }

    public void deleteIncubator(String id, DeleteCallback callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Incubator");
        query.getInBackground(id, (parseObject, e) -> {
            if (e == null) {
                parseObject.deleteInBackground(callback::onComplete);
            } else {
                callback.onComplete(e);
            }
        });
    }
    public void readIncubator(String id, ReadOneCallback callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Incubator");
        query.getInBackground(id, (parseObject, e) -> {
            if (e == null) {
                String name = parseObject.getString("name");
                int size = parseObject.getInt("size");
                Double temperature = parseObject.getDouble("temperature");
                Double humidity = parseObject.getDouble("humidity");
                String image = parseObject.getString("image");
                Incubator incubator = new Incubator(name,size, temperature, humidity, image);
                incubator.setObjectId(id);
                callback.onComplete(incubator, null);
            }
            else {callback.onComplete(null, e);}
        });
    }

}

interface ReadCallback {
    void onComplete(List<Incubator> incubators, ParseException e);
}

 interface UpdateCallback {
    void onComplete(ParseException e);
}

 interface DeleteCallback {
    void onComplete(ParseException e);
}
interface ReadOneCallback {
    void onComplete(Incubator incubators, ParseException e);
}

