package com.example.fma_fe.activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fma_fe.R;
import com.example.fma_fe.adapters.MatchAdapter;
import com.example.fma_fe.models.Match;
import java.util.ArrayList;
import java.util.List;

public class MatchFragment extends Fragment {

  private RecyclerView recyclerView;
  private MatchAdapter adapter;
  private List<Match> matchList;

  public MatchFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_match, container, false);

    recyclerView = view.findViewById(R.id.recyclerViewMatches);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    // Fake data
    matchList = new ArrayList<>();
    matchList.add(new Match("Man City vs Arsenal", "13 Jul 2025 - 19:00","USA"));
    matchList.add(new Match("MU vs Liverpool", "14 Jul 2025 - 21:00","AA"));
    matchList.add(new Match("Chelsea vs Tottenham", "15 Jul 2025 - 18:30","BB"));

    adapter = new MatchAdapter(matchList);
    recyclerView.setAdapter(adapter);

    return view;
  }
}
