package com.tencent.mm.plugin.address.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class AddInvoiceUI$1 implements OnTouchListener {
    final /* synthetic */ AddInvoiceUI eYy;

    AddInvoiceUI$1(AddInvoiceUI addInvoiceUI) {
        this.eYy = addInvoiceUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            return true;
        }
        if (motionEvent.getAction() != 1) {
            return false;
        }
        if (!AddInvoiceUI.a(this.eYy).isActivated()) {
            AddInvoiceUI.a(this.eYy).setActivated(true);
        }
        if (AddInvoiceUI.a(this.eYy).isActivated()) {
            AddInvoiceUI.b(this.eYy).setActivated(false);
            AddInvoiceUI.c(this.eYy).type = "0";
        }
        AddInvoiceUI.d(this.eYy);
        return true;
    }
}
