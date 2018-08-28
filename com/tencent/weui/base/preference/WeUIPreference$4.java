package com.tencent.weui.base.preference;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class WeUIPreference$4 implements OnScrollListener {
    final /* synthetic */ WeUIPreference vzA;

    WeUIPreference$4(WeUIPreference weUIPreference) {
        this.vzA = weUIPreference;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (1 == i) {
            View currentFocus = this.vzA.getCurrentFocus();
            if (currentFocus != null) {
                currentFocus.clearFocus();
            }
        }
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }
}
