package com.tencent.mm.ui.base;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class MMListPopupWindow$d implements OnScrollListener {
    final /* synthetic */ MMListPopupWindow tvV;

    private MMListPopupWindow$d(MMListPopupWindow mMListPopupWindow) {
        this.tvV = mMListPopupWindow;
    }

    /* synthetic */ MMListPopupWindow$d(MMListPopupWindow mMListPopupWindow, byte b) {
        this(mMListPopupWindow);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (MMListPopupWindow.a(this.tvV) != null && MMListPopupWindow.e(this.tvV) != null && MMListPopupWindow.f(this.tvV) != null && MMListPopupWindow.a(this.tvV) != null) {
            if (MMListPopupWindow.a(this.tvV).getLastVisiblePosition() != MMListPopupWindow.f(this.tvV).getCount() - 1 || MMListPopupWindow.a(this.tvV).getChildAt(MMListPopupWindow.a(this.tvV).getChildCount() - 1) == null || MMListPopupWindow.a(this.tvV).getChildAt(MMListPopupWindow.a(this.tvV).getChildCount() - 1).getBottom() > MMListPopupWindow.a(this.tvV).getHeight()) {
                MMListPopupWindow.e(this.tvV).setVisibility(0);
            } else {
                MMListPopupWindow.e(this.tvV).setVisibility(8);
            }
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.tvV.isInputMethodNotNeeded() && MMListPopupWindow.b(this.tvV).getContentView() != null) {
            MMListPopupWindow.d(this.tvV).removeCallbacks(MMListPopupWindow.c(this.tvV));
            MMListPopupWindow.c(this.tvV).run();
        }
    }
}
