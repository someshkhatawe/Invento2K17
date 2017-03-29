package com.invento.somesh.invento2k17;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class NonTechnicalFragment extends ListFragment {


    String[] events={"Show Bizz(movie Making)","cut Throat(Solo Singing)","Feel THe BEat(Dance)",
            "Rock the Range(Battle of Bands","vouge(The Fashion show"};



    public NonTechnicalFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_non_technical, container,false);

        ListAdapter adapter=new ArrayAdapter<String>(getActivity(), R.layout.row_layout,R.id.txtitem,events);
        setListAdapter(adapter);

        return  rootView;
    }

}
