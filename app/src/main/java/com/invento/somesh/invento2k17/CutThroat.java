package com.invento.somesh.invento2k17;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class CutThroat extends AppCompatActivity {

    private DatabaseReference mdatabase;
    private RecyclerView mblogList;

    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mRootReference = firebaseDatabase.getReference();
    private DatabaseReference mChildReference = mRootReference.child("cutthroat");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cut_throat);

        mdatabase = FirebaseDatabase.getInstance().getReference().child("Event2");
        mdatabase.keepSynced(true);

        mblogList = (RecyclerView)findViewById(R.id.blog_list);
        mblogList.setHasFixedSize(true);
        mblogList.setLayoutManager(new LinearLayoutManager(this));

    }
    @Override
    protected void onStart() {
        super.onStart();


        FirebaseRecyclerAdapter<Blog, ShowBizz.BlogViewHolder> firebaseRecyclerAdapter =new FirebaseRecyclerAdapter<Blog, ShowBizz.BlogViewHolder>(
                Blog.class,
                R.layout.blog_row,
                ShowBizz.BlogViewHolder.class,
                mdatabase
        ) {
            @Override
            protected void populateViewHolder(ShowBizz.BlogViewHolder viewHolder, Blog model, int position) {

                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(),model.getImage());
            }
        };

        mblogList.setAdapter(firebaseRecyclerAdapter);


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

        public void setImage(Context ctx, String image){

            ImageView post_image = (ImageView) mView.findViewById(R.id.post_image);
            Picasso.with(ctx).load(image).into(post_image);
        }


    }

}

