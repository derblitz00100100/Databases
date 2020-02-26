package com.mistershorr.databases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;

public class FriendDetailActivity extends AppCompatActivity {

    private EditText editTextName;
    private SeekBar seekBarClumsiness;
    private Switch switchAwesomeness;
    private SeekBar seekBarGymFrequency;
    private RatingBar ratingBarTrustworthiness;
    private EditText editTextMoneyOwed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_detail);
        wireWidgets();
        Intent lastIntent = getIntent();
        Friend friendSelected = lastIntent.getParcelableExtra(FriendListActivity.EXTRA_FRIEND);

        editTextName.setText(friendSelected.getName());
        seekBarClumsiness.setProgress(friendSelected.getClumsiness());
        switchAwesomeness.setChecked(friendSelected.isAwesome());
        seekBarGymFrequency.setProgress((int) friendSelected.getGymFrequency());
        ratingBarTrustworthiness.setRating(friendSelected.getTrustworthiness());
        editTextMoneyOwed.setText(friendSelected.getMoneyOwed() + "");

    }

    private void wireWidgets() {
        editTextName = findViewById(R.id.editText_frienddetail_name);
        seekBarClumsiness = findViewById(R.id.seekBar_frienddetail_clumsiness);
        switchAwesomeness = findViewById(R.id.switch_frienddetail_awesomeness);
        seekBarGymFrequency = findViewById(R.id.seekBar_frienddetail_gym);
        ratingBarTrustworthiness = findViewById(R.id.ratingBar_frienddetail_trust);
        editTextMoneyOwed = findViewById(R.id.editText_frienddetail_money);
    }
}
