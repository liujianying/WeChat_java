package com.tencent.mm.plugin.address.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.h;

class AddInvoiceUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ AddInvoiceUI eYy;

    AddInvoiceUI$4(AddInvoiceUI addInvoiceUI) {
        this.eYy = addInvoiceUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (AddInvoiceUI.f(this.eYy) == 0) {
            h.mEJ.h(14199, new Object[]{Integer.valueOf(3)});
        } else {
            h.mEJ.h(14199, new Object[]{Integer.valueOf(4)});
        }
        if (AddInvoiceUI.a(this.eYy) != null && AddInvoiceUI.a(this.eYy).isActivated() && AddInvoiceUI.g(this.eYy).getText().length() == 0) {
            this.eYy.ZE();
            return false;
        } else if (AddInvoiceUI.b(this.eYy) != null && AddInvoiceUI.b(this.eYy).isActivated() && AddInvoiceUI.h(this.eYy).getText().length() == 0) {
            this.eYy.ZE();
            return false;
        } else if (AddInvoiceUI.f(this.eYy) != 0 && AddInvoiceUI.h(this.eYy).getText().length() == 0 && AddInvoiceUI.g(this.eYy).getText().length() == 0) {
            this.eYy.ZE();
            return false;
        } else if (AddInvoiceUI.i(this.eYy).getText().length() > 100) {
            AddInvoiceUI addInvoiceUI = this.eYy;
            com.tencent.mm.ui.base.h.a(addInvoiceUI, addInvoiceUI.getString(R.l.invoice_bytes_tax_limit_error), addInvoiceUI.getString(R.l.app_tip), false, null);
            return false;
        } else if (AddInvoiceUI.d(this.eYy)) {
            if (AddInvoiceUI.a(this.eYy).isActivated()) {
                AddInvoiceUI.c(this.eYy).type = "0";
            } else if (AddInvoiceUI.b(this.eYy).isActivated()) {
                AddInvoiceUI.c(this.eYy).type = "1";
            }
            if (AddInvoiceUI.j(this.eYy) != null) {
                AddInvoiceUI.c(this.eYy).type = AddInvoiceUI.j(this.eYy).type;
            }
            AddInvoiceUI.c(this.eYy).title = AddInvoiceUI.g(this.eYy).getText();
            AddInvoiceUI.c(this.eYy).knB = AddInvoiceUI.h(this.eYy).getText();
            AddInvoiceUI.c(this.eYy).knC = AddInvoiceUI.i(this.eYy).getText();
            AddInvoiceUI.c(this.eYy).knA = AddInvoiceUI.f(this.eYy);
            AddInvoiceUI.c(this.eYy).knG = AddInvoiceUI.k(this.eYy).getText();
            AddInvoiceUI.c(this.eYy).knE = AddInvoiceUI.m(this.eYy).getText();
            AddInvoiceUI.c(this.eYy).knD = AddInvoiceUI.l(this.eYy).getText();
            AddInvoiceUI.c(this.eYy).knI = AddInvoiceUI.n(this.eYy).getText();
            AddInvoiceUI.o(this.eYy);
            return true;
        } else {
            if ((AddInvoiceUI.a(this.eYy) != null && AddInvoiceUI.a(this.eYy).isActivated()) || !(AddInvoiceUI.j(this.eYy) == null || AddInvoiceUI.j(this.eYy).type == null || !AddInvoiceUI.j(this.eYy).type.equals("0"))) {
                AddInvoiceUI addInvoiceUI2;
                if (!AddInvoiceUI.k(this.eYy).ZF()) {
                    addInvoiceUI2 = this.eYy;
                    com.tencent.mm.ui.base.h.a(addInvoiceUI2, addInvoiceUI2.getString(R.l.invoice_phone_limit_error), addInvoiceUI2.getString(R.l.app_tip), false, null);
                }
                if (!AddInvoiceUI.l(this.eYy).ZF()) {
                    addInvoiceUI2 = this.eYy;
                    com.tencent.mm.ui.base.h.a(addInvoiceUI2, addInvoiceUI2.getString(R.l.invoice_bank_number_limit_error), addInvoiceUI2.getString(R.l.app_tip), false, null);
                }
            }
            return true;
        }
    }
}
