package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.f.b;
import android.support.v7.widget.ap;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements b, m, OnItemClickListener {
    private static final int[] HN = new int[]{16842964, 16843049};
    private int HO;
    private f bq;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ap a = ap.a(context, attributeSet, HN, i);
        if (a.hasValue(0)) {
            setBackgroundDrawable(a.getDrawable(0));
        }
        if (a.hasValue(1)) {
            setDivider(a.getDrawable(1));
        }
        a.Ww.recycle();
    }

    public final void a(f fVar) {
        this.bq = fVar;
    }

    protected final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public final boolean f(h hVar) {
        return this.bq.a((MenuItem) hVar, null, 0);
    }

    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        f((h) getAdapter().getItem(i));
    }

    public final int getWindowAnimations() {
        return this.HO;
    }
}
