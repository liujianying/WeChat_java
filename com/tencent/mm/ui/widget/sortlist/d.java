package com.tencent.mm.ui.widget.sortlist;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.widget.sortlist.DragSortListView.i;

public class d implements i {
    private ListView CU;
    private ImageView isa;
    private Bitmap uOW;
    int uOX = -16777216;

    public d(ListView listView) {
        this.CU = listView;
    }

    public final View GK(int i) {
        View childAt = this.CU.getChildAt((this.CU.getHeaderViewsCount() + i) - this.CU.getFirstVisiblePosition());
        if (childAt == null) {
            return null;
        }
        childAt.setPressed(false);
        childAt.setDrawingCacheEnabled(true);
        this.uOW = Bitmap.createBitmap(childAt.getDrawingCache());
        childAt.setDrawingCacheEnabled(false);
        if (this.isa == null) {
            this.isa = new ImageView(this.CU.getContext());
        }
        this.isa.setBackgroundColor(this.uOX);
        this.isa.setPadding(0, 0, 0, 0);
        this.isa.setImageBitmap(this.uOW);
        this.isa.setLayoutParams(new LayoutParams(childAt.getWidth(), childAt.getHeight()));
        return this.isa;
    }

    public void i(Point point) {
    }

    public final void dV(View view) {
        if (view instanceof ImageView) {
            ((ImageView) view).setImageDrawable(null);
        }
        ao.t("bitmap recycle %s", new Object[]{this.uOW.toString()});
        this.uOW.recycle();
        this.uOW = null;
    }
}
