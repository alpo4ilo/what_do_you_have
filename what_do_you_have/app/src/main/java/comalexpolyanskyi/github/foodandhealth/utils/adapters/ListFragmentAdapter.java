package comalexpolyanskyi.github.foodandhealth.utils.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import java.util.List;
import comalexpolyanskyi.github.foodandhealth.R;
import comalexpolyanskyi.github.foodandhealth.ui.fragments.RecipesListFragment;
import comalexpolyanskyi.github.foodandhealth.utils.holders.ContextHolder;

public class ListFragmentAdapter<ListItemBean> extends AbstractAdapter<ListItemBean> {

    private final List<ListItemBean> values;
    private final RecipesListFragment.OnListFragmentInteractionListener listener;

    public ListFragmentAdapter(List<ListItemBean> items, RecipesListFragment.OnListFragmentInteractionListener listener){
        values = items;
        this.listener = listener;
    }

    @Override
    public void onBind(AbstractViewHolder holder, ListItemBean listItemBean, int position, int viewType) {
        //holder.<TextView>get(R.id.id).setText(listItemBean);
        //holder.<TextView>get(R.id.content).setText(listItemBean);
    }

    public ListItemBean getItem(final int position) {
        return values.get(position);
    }

    @Override
    public AbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AbstractViewHolder(LayoutInflater.from(ContextHolder.getContext()).inflate(R.layout.fragment_recipes_item, null), R.id.id, R.id.content);
    }

    public int getItemCount() {
        return values.size();
    }
}