package com.bisca.stethodemo.view.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bisca.stethodemo.R;
import com.bisca.stethodemo.data.model.Feed;
import com.squareup.picasso.Picasso;

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
    Feed feed = feedList.get(position);

    holder.title.setText(feed.getTitle());
    Picasso.with(holder.itemView.getContext()).load(feed.getUrl()).into(holder.image);
  }

  public void setItems(List<Feed> feedList) {
    this.feedList = feedList;
  }

  @Override
  public int getItemCount() {
    return feedList != null ? feedList.size() : 0;
  }

  public class FeedViewHolder extends RecyclerView.ViewHolder {

    private ImageView image;
    private TextView title;
    private View gradientView;

    public FeedViewHolder(View itemView) {
      super(itemView);
      image = (ImageView) itemView.findViewById(R.id.image);
      title = (TextView) itemView.findViewById(R.id.title);
      gradientView = itemView.findViewById(R.id.gradient_layout);
    }
  }
}
