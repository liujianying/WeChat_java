package com.tencent.mm.plugin.collect.ui;

import android.support.design.widget.BottomSheetBehavior;
import com.tencent.mm.sdk.platformtools.x;

class CollectBillListUI$6 implements Runnable {
    final /* synthetic */ CollectBillListUI hXk;
    final /* synthetic */ DatePickerDialogView hXl;
    final /* synthetic */ BottomSheetBehavior hXm;

    CollectBillListUI$6(CollectBillListUI collectBillListUI, DatePickerDialogView datePickerDialogView, BottomSheetBehavior bottomSheetBehavior) {
        this.hXk = collectBillListUI;
        this.hXl = datePickerDialogView;
        this.hXm = bottomSheetBehavior;
    }

    public final void run() {
        x.d("MicroMsg.CollectBillListUI", "view height: %d", new Object[]{Integer.valueOf(this.hXl.getHeight())});
        this.hXm.q(this.hXl.getHeight());
    }
}
