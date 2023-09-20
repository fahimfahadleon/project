package com.example.bs23androidtask102;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.bs23androidtask102.Important.Important;
import com.example.bs23androidtask102.Listener.ServerResponse;
import com.example.bs23androidtask102.ViewModel.ContainerViewModel;
import com.example.bs23androidtask102.ViewModel.ViewModelFactory;
import com.example.bs23androidtask102.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements ServerResponse{

    // Used to load the 'bs23androidtask102' library on application startup.
    static {
        System.loadLibrary("bs23androidtask102");
    }
    native void setUpEnvironment();
    static native void globalRequest(ServerResponse serverResponse, String requesttype, String link, JSONObject jsonObject, int requestcode, Context context);
    static native void checkResponse(String response);


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        setContentView(binding.getRoot());
        setUpEnvironment();
        ContainerViewModel model = new ContainerViewModel();
        model.initLister();
        binding.setViewModel(model);

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("q","android");
            jsonObject.put("sort","stars");
            globalRequest(this,"GET", Important.getGetDesiredList(),jsonObject,1,this);
        }catch (Exception e){
            e.printStackTrace();
        }



    }

    @Override
    public void onResponse(String response, int code, int requestcode) throws JSONException {
        Log.e("Response",response);
        checkResponse(response);
    }

    @Override
    public void onFailure(String failresponse) throws JSONException {

    }

    /**
     * A native method that is implemented by the 'bs23androidtask102' native library,
     * which is packaged with this application.
     */

}