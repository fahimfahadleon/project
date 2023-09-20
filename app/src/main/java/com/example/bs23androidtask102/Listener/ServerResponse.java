package com.example.bs23androidtask102.Listener;
import org.json.JSONException;

public interface ServerResponse {
    void onResponse(String response,int code,int requestcode) throws JSONException;
    void onFailure(String failresponse) throws JSONException;
}
