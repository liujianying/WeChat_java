package com.tencent.mm.plugin.aa.ui;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class LaunchAAByPersonAmountSelectUI$7 implements OnScrollListener {
    final /* synthetic */ LaunchAAByPersonAmountSelectUI eDf;

    LaunchAAByPersonAmountSelectUI$7(LaunchAAByPersonAmountSelectUI launchAAByPersonAmountSelectUI) {
        this.eDf = launchAAByPersonAmountSelectUI;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            this.eDf.Wq();
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
