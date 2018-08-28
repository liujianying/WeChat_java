package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.ak.o;

class BizTimeLineUI$8 implements OnScrollListener {
    final /* synthetic */ BizTimeLineUI hst;

    BizTimeLineUI$8(BizTimeLineUI bizTimeLineUI) {
        this.hst = bizTimeLineUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        o.Pj().br(i);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        BizTimeLineUI.nA(i);
    }
}
