package com.example.home.Second;


import android.util.Log;

import com.example.home.First.CreateCallback;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class BruderManager {

    public void createBruder(String name, int size, Double temperature, Double humidity, String image, CreateCallback callback) {
        ParseObject Bruder = new ParseObject("Bruder");
        Bruder.put("name", name);
        Bruder.put("size",size );
        Bruder.put("temperature", temperature);
        Bruder.put("humidity", humidity);
        Bruder.put("image", image);
        Bruder.saveInBackground(e -> {
            if (e == null) {
                Log.i("CreateBruder", "Bruder created");
                    callback.onComplete(null);
            }
            else {Log.e("BruderCreate", e.getMessage());
                callback.onComplete(e);}
        });
    }

    public void readBruders(ReadCallbackBruder callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bruder");
        query.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> objects, ParseException e) {
                List<Bruder> Bruders = new ArrayList<>();
                if (e == null) {
                    for (ParseObject parseObject : objects) {
                        String id = parseObject.getObjectId();
                        String name = parseObject.getString("name");
                        int size = parseObject.getInt("size");
                        Double temperature = parseObject.getDouble("temperature");
                        Double humidity = parseObject.getDouble("humidity");
                        String image = parseObject.getString("image");

                      Bruder Bruder;
                        Bruder = new Bruder(name,size, temperature, humidity, image);
                        Bruder.setObjectId(id);
                        Bruders.add(Bruder);

                    }
                }
                callback.onComplete(Bruders, e);
            }
        });
    }

    public void updateBruder(String id,int size, String newName, Double newTemperature, Double newHumidity, String newImage, UpdateCallbackBruder callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bruder");
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

    public void deleteBruder(String id, DeleteCallbackBruder callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bruder");
        query.getInBackground(id, (parseObject, e) -> {
            if (e == null) {
                parseObject.deleteInBackground(callback::onComplete);
            } else {
                callback.onComplete(e);
            }
        });
    }
    public void readBruder(String id, ReadOneCallbackBruder callback) {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Bruder");
        query.getInBackground(id, (parseObject, e) -> {
            if (e == null) {
                String name = parseObject.getString("name");
                int size = parseObject.getInt("size");
                Double temperature = parseObject.getDouble("temperature");
                Double humidity = parseObject.getDouble("humidity");
                String image = parseObject.getString("image");
                Bruder Bruder = new Bruder(name,size, temperature, humidity, image);
                Bruder.setObjectId(id);
                callback.onComplete(Bruder, e);
            }
            else {callback.onComplete(null, e);}
        });
    }

}
 interface CreateCallbackBruder {
    void onComplete(ParseException e);
}

interface ReadCallbackBruder{
    void onComplete(List<Bruder> Bruders, ParseException e);
}

 interface UpdateCallbackBruder {
    void onComplete(ParseException e);
}

 interface DeleteCallbackBruder {
    void onComplete(ParseException e);
}
interface ReadOneCallbackBruder {
    void onComplete(Bruder Bruders, ParseException e);
}

