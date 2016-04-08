package jp.co.future.androidbase.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import jp.co.future.androidbase.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";

    private String mParam1;

    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of this fragment using the provided parameters.
     *
     * @param param1
     *            Parameter 1.
     * @param param2
     *            Parameter 2.
     * @return A new instance of fragment TopMenuFragment.
     */
    public static MainActivityFragment newInstance(String param1, String param2) {
        MainActivityFragment fragment = new MainActivityFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        //setTextSizeByInch(rootView);
        // ボタンがクリックされた時の処理
        rootView.findViewById(R.id.btn_aa).setOnClickListener(buttonClickListener);

        // 設定ボタンがクリックされた時の処理
        rootView.findViewById(R.id.btn_settei).setOnClickListener(buttonClickListener);

        return rootView;
    }

    // ボタンがクリックされた時のリスナー
    OnClickListener buttonClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            onButtonPressed(v);
        }
    };

    // ボタンがクリックされた時
    public void onButtonPressed(View v) {
        if (mListener != null) {
            int id = v.getId();
            if (id == R.id.btn_aa) {
                mListener.onAaClicked(v);
            } else if (id == R.id.btn_settei) {
                mListener.onSetteiClicked(v);
            }

        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this fragment to allow an interaction in this
     * fragment to be communicated to the activity and potentially other fragments contained in that activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html" >Communicating with Other
     * Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // ボタンがクリックされた時
        public void onAaClicked(View v);

        // 一ボタンがクリックされた時
        public void onSetteiClicked(View v);



    }
}
