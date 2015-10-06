package com.viksaa.ssspalsh.dialogfragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.ssspalsh.R;
import com.viksaa.ssspalsh.activity.MainActivity;
import com.viksaa.ssspalsh.adapters.EffectsAdapter;
import com.viksaa.ssspalsh.util.Constants;
import com.viksaa.ssspalsh.util.UIUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;

/**
 * Created by varsovski on 28-Sep-15.
 */
public class ListDialogFragment extends AppCompatDialogFragment {

    @Bind(R.id.txtTitle)
    TextView mTxtTitle;
    @Bind(R.id.lvTechn)
    ListView mLlvTechn;

    private EffectsAdapter mAdapter;
    private int forWhat;


    public static ListDialogFragment newInstance(int flag) {
        ListDialogFragment dialogFragment = new ListDialogFragment();
        Bundle args = new Bundle();
        args.putInt(Constants.FOR_WHAT, flag);
        dialogFragment.setArguments(args);
        return dialogFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_fragment_list, container, false);
        ButterKnife.bind(this, v);

        initUI();

        return v;
    }


    public void initUI() {
        setCancelable(true);

        mAdapter = new EffectsAdapter(getActivity());
        mLlvTechn.setAdapter(mAdapter);

        forWhat = getArguments().getInt(Constants.FOR_WHAT);
    }


    @OnItemClick(R.id.lvTechn)
    public void onListClick(AdapterView<?> parent, View view, int position, long id) {
        Techniques t = Techniques.values()[position];
        MainActivity a = ((MainActivity) getActivity());
        String selected = UIUtil.getTechniqueTitle(mAdapter.getItem(position));
        if (forWhat == Constants.FOR_LOGO) {
            a.getConfigSplash().setAnimLogoSplashTechnique(t);
            a.setTechnique(Constants.FOR_LOGO, selected);
        } else {
            a.getConfigSplash().setAnimTitleTechnique(t);
            a.setTechnique(Constants.FOR_TEXT, selected);
        }


        dismiss();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
