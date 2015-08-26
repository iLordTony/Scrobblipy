package me.carlostonatihu.scrobblipy.ui;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Project: Scrobblipy
 * Created by Carlos Tonatihu Barrera on 26/08/2015.
 */
public class ItemOffsetDecoration extends RecyclerView.ItemDecoration{

    // La medida en pixeles del espaciado
    private int mItemOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId) {
        int itemOffsetDp = context.getResources().getInteger(integerResId);
        mItemOffset = converToPx(itemOffsetDp, context.getResources().getDisplayMetrics());
    }

    public int converToPx (int offsetDp, DisplayMetrics metrics) {
        return offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
