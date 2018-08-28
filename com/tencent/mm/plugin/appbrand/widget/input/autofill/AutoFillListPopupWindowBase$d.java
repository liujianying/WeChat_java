package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

class AutoFillListPopupWindowBase$d implements OnScrollListener {
    final /* synthetic */ AutoFillListPopupWindowBase gKu;

    private AutoFillListPopupWindowBase$d(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.gKu = autoFillListPopupWindowBase;
    }

    /* synthetic */ AutoFillListPopupWindowBase$d(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
        this(autoFillListPopupWindowBase);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (AutoFillListPopupWindowBase.a(this.gKu) != null && AutoFillListPopupWindowBase.e(this.gKu) != null && AutoFillListPopupWindowBase.f(this.gKu) != null && AutoFillListPopupWindowBase.a(this.gKu) != null) {
            if (AutoFillListPopupWindowBase.a(this.gKu).getLastVisiblePosition() != AutoFillListPopupWindowBase.f(this.gKu).getCount() - 1 || AutoFillListPopupWindowBase.a(this.gKu).getChildAt(AutoFillListPopupWindowBase.a(this.gKu).getChildCount() - 1) == null || AutoFillListPopupWindowBase.a(this.gKu).getChildAt(AutoFillListPopupWindowBase.a(this.gKu).getChildCount() - 1).getBottom() > AutoFillListPopupWindowBase.a(this.gKu).getHeight()) {
                AutoFillListPopupWindowBase.e(this.gKu).setVisibility(0);
            } else {
                AutoFillListPopupWindowBase.e(this.gKu).setVisibility(8);
            }
        }
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1 && !this.gKu.isInputMethodNotNeeded() && AutoFillListPopupWindowBase.b(this.gKu).getContentView() != null) {
            AutoFillListPopupWindowBase.d(this.gKu).removeCallbacks(AutoFillListPopupWindowBase.c(this.gKu));
            AutoFillListPopupWindowBase.c(this.gKu).run();
        }
    }
}
