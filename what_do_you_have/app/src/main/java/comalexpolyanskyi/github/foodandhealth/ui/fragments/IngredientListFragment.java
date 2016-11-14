package comalexpolyanskyi.github.foodandhealth.ui.fragments;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import comalexpolyanskyi.github.foodandhealth.R;
import comalexpolyanskyi.github.foodandhealth.presenter.IngredientListFragmentPresenter;
import comalexpolyanskyi.github.foodandhealth.presenter.MVPContract;
import comalexpolyanskyi.github.foodandhealth.utils.adapters.sectionAdapter.IngredientSectionCursorAdapter;


public class IngredientListFragment extends Fragment implements MVPContract.RequiredView<Cursor> {

    private static final String ACTION = "Action";
    private View progressBar;
    private View view;
    private ListView listView;
    private IngredientSectionCursorAdapter arrayAdapter;
    private MVPContract.Presenter<Void> presenter;
    private Cursor data;

    public IngredientListFragment(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_ingredient_list, container, false);
        progressBar = view.findViewById(R.id.list_fragment_progress);
        listView = (ListView) view.findViewById(R.id.ingredient_list_view);
        bindListView();
        bindMVP(savedInstanceState);
        return view;
    }

    private void bindListView(){
        arrayAdapter = new IngredientSectionCursorAdapter(getContext(), data);
        listView.setFastScrollEnabled(true);
        listView.setFastScrollAlwaysVisible(true);
        listView.setAdapter(arrayAdapter);
    }

    public void bindMVP(Bundle savedInstanceState) {
        if (savedInstanceState == null || presenter == null) {
            this.presenter = new IngredientListFragmentPresenter(this);
            presenter.loadData(null);
        } else {
            this.presenter.onConfigurationChanged(this);
        }
    }

    @Override
    public void returnData(Cursor response) {
        data = response;
        arrayAdapter.updateDataSet(response);
    }

    @Override
    public void returnError(String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG).setAction(ACTION, null).show();
    }

    @Override
    public void showProgress(boolean isInProgress) {
        if(isInProgress){
            progressBar.setVisibility(View.VISIBLE);
            listView.setVisibility(View.GONE);
        }else{
            progressBar.setVisibility(View.GONE);
            listView.setVisibility(View.VISIBLE);
        }
    }
}
