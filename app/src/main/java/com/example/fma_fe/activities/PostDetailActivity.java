package com.example.fma_fe.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fma_fe.R;
import com.example.fma_fe.models.Post;

public class PostDetailActivity extends AppCompatActivity {

    private TextView txtTeamVs, txtTime, txtPitch, txtDescription;
    private Button btnOpenMap;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_detail);

        txtTeamVs = findViewById(R.id.txt_team_vs);
        txtTime = findViewById(R.id.txt_time);
        txtPitch = findViewById(R.id.txt_pitch);
        txtDescription = findViewById(R.id.txt_description);
        btnOpenMap = findViewById(R.id.btn_open_map);
        btnBack = findViewById(R.id.btn_back);
        btnBack.setOnClickListener(v -> finish());

        Post post = (Post) getIntent().getSerializableExtra("post");

        if (post != null) {
            txtTeamVs.setText(post.getTeamName() + " vs " + post.getReceivingTeamName());
            txtTime.setText(post.getMatchTime());
            txtPitch.setText(post.getPitchName());
            txtDescription.setText(post.getDescription());

            btnOpenMap.setOnClickListener(v -> {
                String mapUri = "geo:0,0?q=" + Uri.encode(post.getPitchLocation());
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mapUri));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            });
        }
    }
}
