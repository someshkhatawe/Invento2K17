package com.invento.somesh.invento2k17;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CulturalFragment extends ListFragment {

    ListView listView;
    Intent i;

    String[] players={"Show Bizz(movie Making)","cut Throat(Solo Singing)","Feel THe BEat(Dance)",
            "Rock the Range(Battle of Bands","vouge(The Fashion show"};


    public CulturalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_cultural, container,false);



        ListAdapter adapter=new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,players);
        setListAdapter(adapter);

        return  rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        switch(position) {
            case 0:
                Intent intent = new Intent(getActivity(), ShowBizz.class);
                startActivity(intent);
                break;

            case 1:
                Intent intent2 = new Intent(getActivity(), CutThroat.class);
                startActivity(intent2);
                break;
        }
    }


}
