package com.tencent.mm.plugin.ipcall.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class IPCallMsgUI$5 implements OnScrollListener {
    final /* synthetic */ IPCallMsgUI kwA;

    IPCallMsgUI$5(IPCallMsgUI iPCallMsgUI) {
        this.kwA = iPCallMsgUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
            IPCallMsgUI$a b = IPCallMsgUI.b(this.kwA);
            if (!b.ayQ()) {
                b.hFO += 10;
                if (b.hFO > b.edl) {
                    b.hFO = b.edl;
                }
            } else if (IPCallMsgUI.d(b.kwA).getParent() != null) {
                IPCallMsgUI.a(b.kwA).removeFooterView(IPCallMsgUI.d(b.kwA));
            }
            IPCallMsgUI.b(this.kwA).a(null, null);
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
