package com.tencent.mm.plugin.game.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.q;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.game.f$c;

public class GameIndexListView$a extends g {
    private final Drawable OZ;
    private int fi;
    final /* synthetic */ GameIndexListView jYS;

    public GameIndexListView$a(GameIndexListView gameIndexListView, Resources resources, int i) {
        this.jYS = gameIndexListView;
        this.OZ = new ColorDrawable(resources.getColor(i));
        this.fi = resources.getDimensionPixelSize(f$c.GameDividedSize);
    }

    public final void a(Canvas canvas, RecyclerView recyclerView, q qVar) {
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i = 0; i < childCount - 1; i++) {
            View childAt = recyclerView.getChildAt(i);
            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
            if ((childAt2 instanceof GameBestSellingItemView) || (childAt2 instanceof GameBestSellingTitle) || (childAt2 instanceof GameFeedModuleTitle)) {
                super.a(canvas, recyclerView, qVar);
            } else {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                int bottom = layoutParams.bottomMargin + childAt.getBottom();
                this.OZ.setBounds(paddingLeft, bottom, width, this.fi + bottom);
                this.OZ.draw(canvas);
            }
        }
    }

    public final void a(Rect rect, View view, RecyclerView recyclerView, q qVar) {
        rect.set(0, 0, 0, this.fi);
    }
}
