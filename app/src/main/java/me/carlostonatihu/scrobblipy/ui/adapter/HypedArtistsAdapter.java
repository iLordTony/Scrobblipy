package me.carlostonatihu.scrobblipy.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import me.carlostonatihu.scrobblipy.R;
import me.carlostonatihu.scrobblipy.domain.Artist;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 26/08/2015.
 */
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistsViewHolder> {

    Context context;
    ArrayList<Artist> artists;


    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }


    @Override
    public HypedArtistsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_hyped_artist, parent, false);

        return new HypedArtistsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(HypedArtistsViewHolder holder, int position) {
        Artist currentArtist = artists.get(position);
        holder.setArtistName(currentArtist.getName());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public void addAll(@NonNull ArrayList<Artist> artistList) {
        if(artistList == null) {
            throw new NullPointerException("No mame abuelo, lo dije");
        }
        this.artists.addAll(artistList);
        notifyDataSetChanged(); // O notifyItemRangeInserted(getItemCount() -1 , artistList.size())
    }

    public class HypedArtistsViewHolder extends RecyclerView.ViewHolder {

        TextView textArtistName;
        ImageView imageArtist;

        public HypedArtistsViewHolder(View itemView) {
            super(itemView);

            textArtistName = (TextView) itemView.findViewById(R.id.text_artist_name);
            imageArtist = (ImageView) itemView.findViewById(R.id.image_artist);
        }

        public void setArtistName(String artistName){
            textArtistName.setText(artistName);
        }

        public void setImageArtist(String imgArtist) {

        }
    }
}
