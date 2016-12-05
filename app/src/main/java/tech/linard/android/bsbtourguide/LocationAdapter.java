package tech.linard.android.bsbtourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import static android.R.color.holo_red_dark;

/**
 * Created by lucas on 05/12/16.
 */

public class LocationAdapter extends ArrayAdapter<Location> {
    private int mListType;

    public LocationAdapter(Context context, int resource, List<Location> objects) {
        super(context, 0, objects);
        mListType = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Location currentLocation = getItem(position);
        TextView txtTitle = (TextView) listItemView.findViewById(R.id.list_item_title);
        txtTitle.setText(currentLocation.getTitle());
        ImageView icon = (ImageView) listItemView.findViewById(R.id.lis_item_icon);

        switch (mListType) {
            case 1:
                icon.setImageResource(R.drawable.ic_shopping_cart_black_24dp);
                break;
            case 2:
                icon.setImageResource(R.drawable.ic_food_black_24dp);
                break;
            case 3:
                icon.setImageResource(R.drawable.ic_tree_black_24dp);
                break;
            case 4:
                if (currentLocation.getTitle().equalsIgnoreCase("Catedral Metropolitana Nossa Senhora Aparecida")) {
                    icon.setImageResource(R.drawable.catedral);
                } else if  (currentLocation.getTitle().equalsIgnoreCase("Congresso Nacional")) {
                    icon.setImageResource(R.drawable.congresso);
                } else if (currentLocation.getTitle().equalsIgnoreCase("Supremo Tribunal Federal")) {
                    icon.setImageResource(R.drawable.stf);
                } else if (currentLocation.getTitle().equalsIgnoreCase("Palácio do Planalto")) {
                    icon.setImageResource(R.drawable.planalto);
                }
                break;
        }
        return listItemView;
    }
}
