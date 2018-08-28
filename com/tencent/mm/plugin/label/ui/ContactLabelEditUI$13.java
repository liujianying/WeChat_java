package com.tencent.mm.plugin.label.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class ContactLabelEditUI$13 implements OnScrollListener {
    final /* synthetic */ ContactLabelEditUI kAZ;

    ContactLabelEditUI$13(ContactLabelEditUI contactLabelEditUI) {
        this.kAZ = contactLabelEditUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2 || i == 1) {
            this.kAZ.YC();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
