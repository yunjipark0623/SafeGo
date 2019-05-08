package com.example.fragmenttest.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.fragmenttest.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HowTo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HowTo extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HowTo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HowTo.
     */
    // TODO: Rename and change types and number of parameters
    public static HowTo newInstance(String param1, String param2) {
        HowTo fragment = new HowTo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_how_to,container,false);
//
//        ImageView ImageView = (ImageView) rootView.findViewById(R.id.imageButton);
//        ImageView ImageView2 = (ImageView) rootView.findViewById(R.id.imageButton2);
//
//        ImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://www.seqway.com/media/1959/25265-00001_ac-ones1-um_web.pdf")));
//                startActivity(myIntent);
//            }
//        });
//
//        ImageView2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://www.seqway.com/media/1959/25265-00001_ac-ones1-um_web.pdf")));
//                startActivity(myIntent);
//            }
//        });
//        return rootView;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_how_to, container, false);
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_how_to,container,false);

        ImageView ImageView = (ImageView) rootView.findViewById(R.id.imageButton);
        ImageView ImageView2 = (ImageView) rootView.findViewById(R.id.imageButton2);

        ImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://www.seqway.com/media/1959/25265-00001_ac-ones1-um_web.pdf")));
                startActivity(myIntent);
            }
        });

        ImageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://www.seqway.com/media/1959/25265-00001_ac-ones1-um_web.pdf")));
                startActivity(myIntent);
            }
        });
        return rootView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

//    public void ImageView(View view) {
//        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://www.seqway.com/media/1959/25265-00001_ac-ones1-um_web.pdf")));
//        startActivity(myIntent);
//    }
//
//    public void ImageView2(View view){
//        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(("http://seqway.com/media/2271/25521-00001_ab-miniplus-user-manual-en.pdf")));
//        startActivity(myIntent);
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
//    public interface OnFragmentInteractionListener {
//        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
//    }
}
