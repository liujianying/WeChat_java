package com.tencent.mm.ui.base;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.sdk.platformtools.x;

class MMLoadMoreListView$1 implements OnScrollListener {
    final /* synthetic */ MMLoadMoreListView twa;

    MMLoadMoreListView$1(MMLoadMoreListView mMLoadMoreListView) {
        this.twa = mMLoadMoreListView;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1 && MMLoadMoreListView.a(this.twa) != null) {
            MMLoadMoreListView.a(this.twa).aAU();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (i == 0 && this.twa.getChildAt(0) != null && this.twa.getChildAt(0).getTop() == this.twa.getPaddingTop()) {
            MMLoadMoreListView.a(this.twa, true);
        } else {
            MMLoadMoreListView.a(this.twa, false);
        }
        x.d("MMLoadMoreListView", "newpoi scroll2Top %s", new Object[]{MMLoadMoreListView.b(this.twa)});
    }
}
