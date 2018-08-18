package com.example.genjeh.mycataloguemovieuiux.Fragment;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.genjeh.mycataloguemovieuiux.Adapter.MovieFavoriteAdapter;
import com.example.genjeh.mycataloguemovieuiux.Database.DbContract;
import com.example.genjeh.mycataloguemovieuiux.Loader.LoaderMovieFavorit;
import com.example.genjeh.mycataloguemovieuiux.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class FavoriteFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor> {
    @BindView(R.id.rv_movie)
    RecyclerView rvMovie;

    @BindView(R.id.progressbar)
    ProgressBar progressBar;

    private MovieFavoriteAdapter adapter;
    private static final int LOAD_ID_MOVIE_FAVORITE = 400;
    public FavoriteFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite, container, false);
        ButterKnife.bind(this,view);

        adapter = new MovieFavoriteAdapter(getContext());
        rvMovie.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMovie.setAdapter(adapter);
        rvMovie.setNestedScrollingEnabled(true);

        getLoaderManager().initLoader(LOAD_ID_MOVIE_FAVORITE,null,this);

        return view;
    }

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, @Nullable Bundle args) {
        return new LoaderMovieFavorit(getContext());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<Cursor> loader, Cursor data) {
        adapter.setDataMovieFav(data);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onLoaderReset(@NonNull Loader<Cursor> loader) {
        adapter.setDataMovieFav(null);
        adapter.notifyDataSetChanged();
    }
}
