package com.tencent.mm.ui.applet;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public final class a implements OnScrollListener {
    private OnScrollListener qEM;

    public a() {
        this((byte) 0);
    }

    private a(byte b) {
        this.qEM = null;
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.qEM != null) {
            this.qEM.onScroll(absListView, i, i2, i3);
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (this.qEM != null) {
            this.qEM.onScrollStateChanged(absListView, i);
        }
    }
}
