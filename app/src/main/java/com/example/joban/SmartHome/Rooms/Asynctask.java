package com.example.joban.SmartHome.Rooms;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by joban on 05/03/2018.
 */

class  Asynctask extends AsyncTask<String,Void,Void> {

    Socket socket;
    @Override
    protected Void doInBackground(String... voids) {
        socket = new Socket();
        try{
            socket.connect(new InetSocketAddress(voids[1], 80), 1000);

            DataOutputStream DataOut = new DataOutputStream(socket.getOutputStream());
            DataOut.writeChars(voids[0]);
            DataOut.flush();

            socket.close();
        }catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
    }
}
