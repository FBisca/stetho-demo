package com.bisca.stethodemo.view.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bisca.stethodemo.R;
import com.bisca.stethodemo.data.model.Feed;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

  private List<Feed> feedList;

  @Override
  public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed, parent, false);
    return new FeedViewHolder(view);
  }

  @Override
  public void onBindViewHolder(FeedViewHolder holder, int position) {

  }

  @Override
  public int getItemCount() {
    return feedList != null ? feedList.size() : 0;
  }

  public class FeedViewHolder extends RecyclerView.ViewHolder {

    public FeedViewHolder(View itemView) {
      super(itemView);
    }
  }
}
