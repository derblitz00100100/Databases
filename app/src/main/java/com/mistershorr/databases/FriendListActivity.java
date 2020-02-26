package com.mistershorr.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;

import org.w3c.dom.Text;

import java.util.List;

public class FriendListActivity extends AppCompatActivity {

    private ListView friendListView;
    private List<Friend> friendList;
    private FriendAdapter friendAdapter;

    public static final String EXTRA_FRIEND = "friend selected";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friendlist);

        Backendless.Data.of( Friend.class).find(new AsyncCallback<List<Friend>>(){
            @Override
            public void handleResponse( List<Friend> foundFriends )
            {
                Log.d("LOADED FRIENDS", "handleResponse: " + foundFriends.toString());
                friendList = foundFriends;

                // make a custom adapter to display friends
                // load list that is retrieved into that adapter
                friendAdapter = new FriendAdapter(friendList);
                friendListView = findViewById(R.id.listview_friendlist_friendlistview);
                friendListView.setAdapter(friendAdapter);

                // make friend parcelable
                // when an item is clicked, it opens detail activity, loads info
                friendListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                        Intent targetIntent = new Intent(FriendListActivity.this, FriendDetailActivity.class);
                        targetIntent.putExtra(EXTRA_FRIEND, friendList.get(position));
                        startActivity(targetIntent);
                        finish();
                    }
                });

            }
            @Override
            public void handleFault( BackendlessFault fault )
            {
                Toast.makeText(FriendListActivity.this, fault.getDetail(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private class FriendAdapter extends ArrayAdapter<Friend> {
        private List<Friend> friendsList;

        public FriendAdapter(List<Friend> friendsList) {
            super(FriendListActivity.this, -1, friendsList);
            this.friendsList = friendsList;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = getLayoutInflater();

            if (convertView == null) {
                convertView = inflater.inflate(R.layout.item_friend, parent, false);
            }

            TextView textViewName = convertView.findViewById(R.id.textView_frienditem_name);
            TextView textViewClumsiness = convertView.findViewById(R.id.textView_frienditem_clumsiness);
            TextView textViewMoneyOwed = convertView.findViewById(R.id.textView_frienditem_money);

            textViewName.setText(friendsList.get(position).getName());
            textViewClumsiness.setText(friendsList.get(position).getClumsiness() + "");
            textViewMoneyOwed.setText(String.valueOf(friendsList.get(position).getMoneyOwed() + ""));

            return convertView;
        }
    }
}
