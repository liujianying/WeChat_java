package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ak.o;

class b$6 implements OnScrollListener {
    final /* synthetic */ b hRX;

    b$6(b bVar) {
        this.hRX = bVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.Pj().br(i);
        if (i != 2) {
            b.a(this.hRX, false);
            b.g(this.hRX).removeCallbacksAndMessages(null);
            b.g(this.hRX).sendEmptyMessageDelayed(0, 200);
            return;
        }
        b.a(this.hRX, true);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
