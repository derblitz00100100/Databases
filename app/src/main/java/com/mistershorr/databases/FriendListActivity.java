package com.mistershorr.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.w3c.dom.Text;

import java.util.List;

public class FriendListActivity extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewClumsiness;
    private TextView textViewMoneyOwed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_friend);

        Backendless.Data.of( Friend.class).find(new AsyncCallback<List<Friend>>(){
            @Override
            public void handleResponse( List<Friend> foundFriends )
            {
                Log.d("LOADED FRIENDS", "handleResponse: " + foundFriends.toString());
                // make a custom adapter to display friends
                // load list that is retrieved into that adapter

                // make friend parcelable
                // when an item is clicked, it opens detail activity, loads info
            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                Toast.makeText(FriendListActivity.this, fault.getDetail(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
