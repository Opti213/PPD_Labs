package com.redbox.technology.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.redbox.technology.R;
import com.squareup.picasso.Picasso;

public class TemplatePageFragment extends Fragment {
    private ImageView iconImageView;
    private TextView nameTextView;
    private TextView helpTextView;
    private String title;
    private String help;
    private String icon;
    private int page;

    public static TemplatePageFragment newInstance(int page, String title, String help, String icon){
        TemplatePageFragment templatePageFragment = new TemplatePageFragment();
        Bundle args = new Bundle();
        args.putInt("page", page);
        args.putString("title",title);
        args.putString("help", help);
        args.putString("icon", icon);
        templatePageFragment.setArguments(args);
        return templatePageFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_item_layout, container, false);
        nameTextView = view.findViewById(R.id.pagerNameTextView);
        helpTextView = view.findViewById(R.id.helpTextView);
        iconImageView = view.findViewById(R.id.pageIconImageView);
        nameTextView.setText(title);
        helpTextView.setText(help);

        Picasso.get().load(getResources().getString(R.string.img_url) + icon).into(iconImageView);

        return view;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        page = getArguments().getInt("page", 0);
        title = getArguments().getString("title");
        help = getArguments().getString("help");
        icon = getArguments().getString("icon");
    }


}
