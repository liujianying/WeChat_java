package android.support.design.widget;

import android.database.DataSetObserver;

class TabLayout$b extends DataSetObserver {
    final /* synthetic */ TabLayout hJ;

    private TabLayout$b(TabLayout tabLayout) {
        this.hJ = tabLayout;
    }

    /* synthetic */ TabLayout$b(TabLayout tabLayout, byte b) {
        this(tabLayout);
    }

    public final void onChanged() {
        TabLayout.p(this.hJ);
    }

    public final void onInvalidated() {
        TabLayout.p(this.hJ);
    }
}
