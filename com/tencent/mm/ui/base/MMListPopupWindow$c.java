package com.tencent.mm.ui.base;

import android.database.DataSetObserver;

class MMListPopupWindow$c extends DataSetObserver {
    final /* synthetic */ MMListPopupWindow tvV;

    private MMListPopupWindow$c(MMListPopupWindow mMListPopupWindow) {
        this.tvV = mMListPopupWindow;
    }

    /* synthetic */ MMListPopupWindow$c(MMListPopupWindow mMListPopupWindow, byte b) {
        this(mMListPopupWindow);
    }

    public final void onChanged() {
        if (this.tvV.eZB.isShowing()) {
            this.tvV.show();
        }
    }

    public final void onInvalidated() {
        this.tvV.dismiss();
    }
}
