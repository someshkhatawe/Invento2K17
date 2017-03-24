package com.invento.somesh.invento2k17;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class ShowBizz extends AppCompatActivity {
    private TextView TitleTxt;
    private TextView DescTxt;
    private ImageView mImage;
    private DatabaseReference mdatabase;
    private RecyclerView mblogList;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("showbizz");
    private DatabaseReference mChildReference2 = mChildReference.child("Title");
    private DatabaseReference mChildReference3 = mChildReference.child("Desc");
    private DatabaseReference mChildReference4 = mChildReference.child("image");





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_bizz);
        mdatabase = FirebaseDatabase.getInstance().getReference().child("Blog");
        mdatabase.keepSynced(true);

        mblogList = (RecyclerView)findViewById(R.id.blog_list);
        mblogList.setHasFixedSize(true);
        mblogList.setLayoutManager(new LinearLayoutManager(this));

        DescTxt = (TextView) findViewById(R.id.post_text);
        TitleTxt = (TextView) findViewById(R.id.post_title);
        mImage = (ImageView) findViewById(R.id.post_image);


    }



    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<Blog, BlogViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<Blog, BlogViewHolder>(
                Blog.class,
                R.layout.blog_row,
                BlogViewHolder.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(BlogViewHolder viewHolder, Blog model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
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

        public void setTitle(String Title){
            TextView post_title = (TextView) mView.findViewById(R.id.post_title);
            post_title.setText(Title);
        }

        public void setDesc(String Desc){
            TextView post_desc = (TextView) mView.findViewById(R.id.post_text);
            post_desc.setText(Desc);
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
