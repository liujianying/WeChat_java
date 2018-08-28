package com.tencent.mm.plugin.clean.ui.newui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ak.o;

class b$5 implements OnScrollListener {
    final /* synthetic */ b hTn;

    b$5(b bVar) {
        this.hTn = bVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.Pj().br(i);
        if (i != 2) {
            b.a(this.hTn, false);
            b.c(this.hTn).removeCallbacksAndMessages(null);
            b.c(this.hTn).sendEmptyMessageDelayed(0, 200);
            return;
        }
        b.a(this.hTn, true);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
