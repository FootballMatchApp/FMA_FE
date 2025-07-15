package com.example.fma_fe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fma_fe.R;
import com.example.fma_fe.adapters.PostAdapter;
import com.example.fma_fe.models.Post;

import java.util.ArrayList;
import java.util.List;

public class MatchFragment extends Fragment {

  private RecyclerView recyclerView;
  private PostAdapter adapter;
  private List<Post> postList;

  public MatchFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_match, container, false);

    recyclerView = view.findViewById(R.id.recyclerViewMatches);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    // Fake data
    postList = new ArrayList<>();
    postList.add(new Post(1, 1, 1, "pitch1", 2,
            "2025-07-13T19:00:00Z", "Friendly match", "Opponent", "Open",
            "https://example.com/image1.jpg", "2025-07-10T12:00:00Z", "2025-07-10T12:00:00Z",
            "Man City", "Arsenal", "USA Stadium"));

    postList.add(new Post(2, 2, 1, "pitch2", 3,
            "2025-07-14T21:00:00Z", "Training game", "Teammate", "Pending",
            "https://example.com/image2.jpg", "2025-07-10T15:00:00Z", "2025-07-10T15:00:00Z",
            "MU", "Liverpool", "England Field"));


    postList.get(0).setTeamName("Man City");
    postList.get(0).setReceivingTeamName("Arsenal");
    postList.get(0).setPitchName("USA Stadium");
    postList.get(0).setPitchLocation("USA Stadium, NY");

    adapter = new PostAdapter(getContext(), postList);
    adapter.setOnPostClickListener(new PostAdapter.OnPostClickListener() {
      @Override
      public void onPostClick(Post post) {
        Intent intent = new Intent(getContext(), PostDetailActivity.class);
        intent.putExtra("post", post);
        startActivity(intent);
      }

      @Override
      public void onExpandClick(Post post) {

      }
    });

    recyclerView.setAdapter(adapter);
    return view;
  }
}
