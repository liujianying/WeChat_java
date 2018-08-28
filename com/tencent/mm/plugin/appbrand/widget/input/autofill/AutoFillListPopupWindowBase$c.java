package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.database.DataSetObserver;

class AutoFillListPopupWindowBase$c extends DataSetObserver {
    final /* synthetic */ AutoFillListPopupWindowBase gKu;

    private AutoFillListPopupWindowBase$c(AutoFillListPopupWindowBase autoFillListPopupWindowBase) {
        this.gKu = autoFillListPopupWindowBase;
    }

    /* synthetic */ AutoFillListPopupWindowBase$c(AutoFillListPopupWindowBase autoFillListPopupWindowBase, byte b) {
        this(autoFillListPopupWindowBase);
    }

    public final void onChanged() {
        if (this.gKu.eZB.isShowing()) {
            this.gKu.show();
        }
    }

    public final void onInvalidated() {
        this.gKu.dismiss();
    }
}
