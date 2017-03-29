package com.invento.somesh.invento2k17;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class Sponsor extends AppCompatActivity {

    private TextView TitleTxt;
    private TextView DescTxt;
    private ImageView mImage;
    private DatabaseReference mdatabase;
    private RecyclerView mblogList;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("Sponsor");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("Others");
        mdatabase.keepSynced(true);

        mblogList = (RecyclerView)findViewById(R.id.blog_list);
        mblogList.setHasFixedSize(true);
        mblogList.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<Spons, BlogViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<Spons, BlogViewHolder>(
                Spons.class,
                R.layout.spo_row,
                BlogViewHolder.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Spons model, int position) {

                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };

        mblogList.setAdapter(firebaseRecyclerAdapter);
        Toast.makeText(getApplicationContext(),"Syncing Data From Server",Toast.LENGTH_SHORT).show();


    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder{
        View mView  ;
        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setImage(final Context ctx, final String image){

            final ImageView post_image = (ImageView) mView.findViewById(R.id.post_image);
            // Picasso.with(ctx).load(image).into(post_image);

            Picasso.with(ctx).load(image).networkPolicy(NetworkPolicy.OFFLINE).into(post_image, new Callback() {
                @Override
                public void onSuccess() {

                }

                @Override
                public void onError() {
                    Picasso.with(ctx).load(image).into(post_image);

                }
            });
        }


    }
}
