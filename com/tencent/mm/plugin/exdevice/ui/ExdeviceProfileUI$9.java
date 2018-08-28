package com.tencent.mm.plugin.exdevice.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ExdeviceProfileUI$9 implements OnScrollListener {
    final /* synthetic */ ExdeviceProfileUI iEx;

    ExdeviceProfileUI$9(ExdeviceProfileUI exdeviceProfileUI) {
        this.iEx = exdeviceProfileUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        ExdeviceProfileUI.A(this.iEx);
    }
}
