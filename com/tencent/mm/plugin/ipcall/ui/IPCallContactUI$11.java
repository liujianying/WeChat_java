package com.tencent.mm.plugin.ipcall.ui;

import android.annotation.TargetApi;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class IPCallContactUI$11 implements OnScrollListener {
    final /* synthetic */ IPCallContactUI kuK;
    private int kuL = 0;

    IPCallContactUI$11(IPCallContactUI iPCallContactUI) {
        this.kuK = iPCallContactUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        this.kuL = i;
        this.kuK.YC();
    }

    @TargetApi(11)
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (IPCallContactUI.i(this.kuK) == -1) {
            IPCallContactUI.a(this.kuK, i);
        } else if (IPCallContactUI.j(this.kuK) == -1) {
            IPCallContactUI.b(this.kuK, i);
        }
    }
}
