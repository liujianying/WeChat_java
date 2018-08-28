package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AddInvoiceUI$2 implements OnTouchListener {
    final /* synthetic */ AddInvoiceUI eYy;

    AddInvoiceUI$2(AddInvoiceUI addInvoiceUI) {
        this.eYy = addInvoiceUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (!AddInvoiceUI.b(this.eYy).isActivated()) {
            AddInvoiceUI.b(this.eYy).setActivated(true);
        }
        if (AddInvoiceUI.b(this.eYy).isActivated()) {
            AddInvoiceUI.a(this.eYy).setActivated(false);
            AddInvoiceUI.c(this.eYy).type = "1";
        }
        AddInvoiceUI.d(this.eYy);
        return true;
    }
}
