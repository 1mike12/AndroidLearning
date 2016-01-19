package fragmentList;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1mike12 on 10/14/2015.
 */
public class MyListFragment extends ListFragment {
    List<String> list_ = new ArrayList<>();
    ArrayAdapter<String> adapter_;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        list_.add("zero");
        list_.add("one");
        list_.add("two");

        adapter_ = new ArrayAdapter<>(inflater.getContext(), android.R.layout.simple_list_item_1, list_);
        setListAdapter(adapter_);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Context context = getActivity().getApplicationContext();
        CharSequence text = "position: " + position + "id: " + id;

        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    public void addToList(String s) {
        list_.add(s);
        adapter_.notifyDataSetChanged();
    }

    public void clear(){
        list_.clear();
        adapter_.notifyDataSetChanged();
    }

}
