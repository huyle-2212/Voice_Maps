package com.example.huyle.voice_maps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Locale;
import java.util.concurrent.TimeUnit;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, View.OnClickListener {

    private GoogleMap mMap;
    private Marker mCurrentLocation;
    Button button;
    ObjectInputStream inputStream;
    PrintWriter OutputStream;
    Socket socket;
    String data;
    String[] content;
    Location position = new Location("Huy");
    double l1, l2;
    WifiManager wifimanager;
    WifiInfo wifiinfor;
    boolean flag = false;
    TextToSpeech toSpeech;
    int result;
    String text;
    String text1;
    String text2;
    String text3;
    String text4;
    String text5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        button = findViewById(R.id.button2);
        button.setOnClickListener(this);

        wifimanager = (WifiManager) getApplicationContext().getSystemService(getApplicationContext().WIFI_SERVICE);
        wifiinfor = wifimanager.getConnectionInfo();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        toSpeech = new TextToSpeech(MapsActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status==TextToSpeech.SUCCESS){
                    result = toSpeech.setLanguage(Locale.ENGLISH);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Feature not supported on your device",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng current = new LatLng(10.762887, 106.681835);
        mMap.addMarker(new MarkerOptions().position(current).title("Current Location").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(current));
        text5 = "Current Location";
        toSpeech.speak(text5, TextToSpeech.QUEUE_FLUSH, null);
    }

    public void OnLocationChange(Location location)
    {
        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        if(location.getLatitude()==10.7622222 && location.getLongitude()==106.682778){
            mMap.addMarker(new MarkerOptions().position(latLng).title("Current flood on Nguyen Van Cu Street").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if(marker.getTitle().equals("Current flood on Nguyen Van Cu Street")){
                        text = "Current flood on Nguyen Van Cu Street";
                        toSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, null);
                        }
                        return false;
                    }
                });


        }
        if(location.getLatitude()==10.7677778 && location.getLongitude()==106.6713889){
            mMap.addMarker(new MarkerOptions().position(latLng).title("Current flood on Su Van Hanh Street").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if (marker.getTitle().equals("Current flood on Su Van Hanh Street")) {
                            text1 = "Current flood on Su Van Hanh Street";
                            toSpeech.speak(text1, TextToSpeech.QUEUE_FLUSH, null);
                        }
                        return false;
                    }
                });

        }
        if(location.getLatitude()==10.75444444 && location.getLongitude()==106.6786111){
            mMap.addMarker(new MarkerOptions().position(latLng).title("Current flood on Tran Hung Dao Street").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if(marker.getTitle().equals("Current flood on Tran Hung Dao Street")){
                        text2 = "Current flood on Tran Hung Dao Street";
                        toSpeech.speak(text2, TextToSpeech.QUEUE_FLUSH, null);
                        }
                        return false;
                    }
                });

        }
        if(location.getLatitude()==10.77388889 && location.getLongitude()==106.70333333){
             mMap.addMarker(new MarkerOptions().position(latLng).title("Current flood on Nguyen Hue Street").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if(marker.getTitle().equals("Current flood on Nguyen Hue Street")){
                        text3 = "Current flood on Nguyen Hue Street";
                        toSpeech.speak(text3, TextToSpeech.QUEUE_FLUSH, null);
                        }
                        return false;
                    }
                });

        }
        if(location.getLatitude()==10.77055556 && location.getLongitude()==106.700555556) {
            mMap.addMarker(new MarkerOptions().position(latLng).title("Current flood on Nguyen Du Street").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        if(marker.getTitle().equals("Current flood on Nguyen Du Street")){
                            text4 = "Current flood on Nguyen Du Street";
                            toSpeech.speak(text4, TextToSpeech.QUEUE_FLUSH, null);
                        }
                        return false;
                    }
                });

        }

    }

    public void DeleteLocationChange(Location location)
    {

        LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mCurrentLocation = mMap.addMarker(markerOptions);
        mCurrentLocation.remove();

    }

    public void SetLocation(double LatLn, double LongLn)
    {
        position.setLatitude(LatLn);
        position.setLongitude(LongLn);
    }

    public Location GetLocation()
    {
        return position;
    }

    @Override
    public void onClick(View view) {

        Thread client = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    socket = new Socket("35.232.197.34",9999);
                    inputStream = new ObjectInputStream(socket.getInputStream());
                    OutputStream = new PrintWriter(socket.getOutputStream());


                    registerReceiver(new BroadcastReceiver() {
                        @Override
                        public void onReceive(Context context, Intent intent) {

                            if(content[0].equals("khongmua"))
                            {
                                mMap.clear();
                            }
                            if(content[0].equals("mua")){
                                SetLocation(Double.parseDouble(content[1]), Double.parseDouble(content[2]));
                                OnLocationChange(GetLocation());}

                        }
                    }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));

                    while (true) {
                        data = inputStream.readObject().toString();
                        System.out.println(data);
                        content = data.split(":");

                        wifimanager.startScan();
                        TimeUnit.SECONDS.sleep(4);

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        client.start();
    }
}
