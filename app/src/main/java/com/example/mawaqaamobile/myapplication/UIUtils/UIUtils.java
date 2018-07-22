package com.example.mawaqaamobile.myapplication.UIUtils;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;

public class UIUtils {
    /**
     * Sets GridView height dynamically based on the height of the items this is used to show specifications Gridview.
     *
     * @return true if the listView is successfully resized, false otherwise
     */
    public static boolean setListViewHeightBasedOnItems(GridView gridView) {

        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter != null) {

            int numberOfItems = listAdapter.getCount();

            // Get total height of all items.
            int totalItemsHeight = 0;
            for (int itemPos = 0; itemPos < numberOfItems; itemPos++) {
                View item = listAdapter.getView(itemPos, null, gridView);
                item.measure(0, 0);
                totalItemsHeight += item.getMeasuredHeight();
            }

            // Get total height of all item dividers.
/*            int totalDividersHeight = listView.getHeight() *
                    (numberOfItems - 2);*/


            // Set list height.
            ViewGroup.LayoutParams params = gridView.getLayoutParams();
            params.height = (totalItemsHeight / 2) + 20;
            gridView.setLayoutParams(params);
            gridView.requestLayout();

            return true;

        } else {
            return false;
        }

    }
}
