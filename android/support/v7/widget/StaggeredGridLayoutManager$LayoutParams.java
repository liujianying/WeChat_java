package android.support.v7.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.StaggeredGridLayoutManager.b;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;

public class StaggeredGridLayoutManager$LayoutParams extends LayoutParams {
    b Ve;
    boolean Vf;

    public StaggeredGridLayoutManager$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public StaggeredGridLayoutManager$LayoutParams(int i, int i2) {
        super(i, i2);
    }

    public StaggeredGridLayoutManager$LayoutParams(MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public StaggeredGridLayoutManager$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public final int gS() {
        if (this.Ve == null) {
            return -1;
        }
        return this.Ve.mIndex;
    }
}
