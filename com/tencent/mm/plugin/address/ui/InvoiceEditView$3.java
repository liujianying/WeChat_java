package com.tencent.mm.plugin.address.ui;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;

class InvoiceEditView$3 implements TextWatcher {
    final /* synthetic */ InvoiceEditView eYY;

    InvoiceEditView$3(InvoiceEditView invoiceEditView) {
        this.eYY = invoiceEditView;
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public final void afterTextChanged(Editable editable) {
        if (InvoiceEditView.a(this.eYY) == 5 && InvoiceEditView.b(this.eYY) != editable.toString().length()) {
            InvoiceEditView.a(this.eYY, editable.toString().length());
            this.eYY.setBankNumberValStr(editable.toString());
        }
        boolean ZF = this.eYY.ZF();
        if (!(ZF == this.eYY.eYL || InvoiceEditView.c(this.eYY) == null)) {
            x.d("MicroMsg.InvoiceEditView", "View:" + InvoiceEditView.d(this.eYY) + ", editType:" + InvoiceEditView.a(this.eYY) + " inputValid change to " + ZF);
            this.eYY.eYL = ZF;
            InvoiceEditView.c(this.eYY).ZC();
        }
        if ((!this.eYY.eYS || this.eYY.eYL) && this.eYY.eYS && this.eYY.eYL) {
            InvoiceEditView.e(this.eYY).setTextColor(this.eYY.getResources().getColor(R.e.black));
        }
        InvoiceEditView.a(this.eYY, InvoiceEditView.e(this.eYY).isFocused());
    }
}
