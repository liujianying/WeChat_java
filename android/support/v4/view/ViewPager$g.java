package android.support.v4.view;

import android.database.DataSetObserver;

class ViewPager$g extends DataSetObserver {
    final /* synthetic */ ViewPager wT;

    private ViewPager$g(ViewPager viewPager) {
        this.wT = viewPager;
    }

    /* synthetic */ ViewPager$g(ViewPager viewPager, byte b) {
        this(viewPager);
    }

    public final void onChanged() {
        this.wT.ce();
    }

    public final void onInvalidated() {
        this.wT.ce();
    }
}
