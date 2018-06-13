package com.example.joban.SmartHome;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.joban.SmartHome.Rooms.Room1;
import com.example.joban.SmartHome.Rooms.Room10;
import com.example.joban.SmartHome.Rooms.Room2;
import com.example.joban.SmartHome.Rooms.Room3;
import com.example.joban.SmartHome.Rooms.Room4;
import com.example.joban.SmartHome.Rooms.Room5;
import com.example.joban.SmartHome.Rooms.Room6;
import com.example.joban.SmartHome.Rooms.Room7;
import com.example.joban.SmartHome.Rooms.Room8;
import com.example.joban.SmartHome.Rooms.Room9;

import java.util.List;

public class AlbumsAdapter extends RecyclerView.Adapter<AlbumsAdapter.MyViewHolder> {

    private Context mContext;
    private List<Album> albumList;
    private RelativeLayout main;

    public AlbumsAdapter(Context mContext, List<Album> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public ImageView thumbnail;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            thumbnail = view.findViewById(R.id.thumbnail);
            main = view.findViewById(R.id.main);
            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getPosition();
                    Toast.makeText(itemView.getContext(), "Position:" + Integer.toString(getPosition()), Toast.LENGTH_SHORT).show();
                    if(position==0) {
                        Intent intent = new Intent(mContext, Room1.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position ==1){
                        Intent intent = new Intent(mContext, Room2.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==2){
                        Intent intent = new Intent(mContext, Room3.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==3){
                        Intent intent = new Intent(mContext, Room4.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==4){
                        Intent intent = new Intent(mContext, Room5.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==5){
                        Intent intent = new Intent(mContext, Room6.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==6){
                        Intent intent = new Intent(mContext, Room7.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==7){
                        Intent intent = new Intent(mContext, Room8.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else if (position==8){
                        Intent intent = new Intent(mContext, Room9.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    } else if (position==9){
                        Intent intent = new Intent(mContext, Room10.class);
                        intent.putExtra("ItemPosition", position);
                        mContext.startActivity(intent);
                    }
                    else {
                        System.out.println("position...."+position);
                    }
                }
            });
        }
    }

    @Override
    public AlbumsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.album_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Album album = albumList.get(position);
        holder.title.setText(album.getName());
        Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
