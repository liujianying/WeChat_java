package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.u;

class RemittanceBusiUI$24 extends u {
    final /* synthetic */ RemittanceBusiUI mBt;

    RemittanceBusiUI$24(RemittanceBusiUI remittanceBusiUI) {
        this.mBt = remittanceBusiUI;
    }

    public final void aBU() {
        h.mEJ.h(15235, new Object[]{Integer.valueOf(5)});
        if (!RemittanceBusiUI.j(this.mBt)) {
            RemittanceBusiUI.a(this.mBt, RemittanceBusiUI.m(this.mBt));
        }
        if (RemittanceBusiUI.n(this.mBt) <= 0.0d) {
            s.makeText(this.mBt.mController.tml, a$i.wallet_balance_save_input_invalid, 0).show();
            return;
        }
        String str;
        String str2 = "MicroMsg.RemittanceBusiUI";
        String str3 = "mPayBtn onClick %s  isFinish:%s getFavorFlag: %s";
        Object[] objArr = new Object[3];
        objArr[0] = this.mBt.mBl;
        if (this.mBt.mBl == null) {
            str = "";
        } else {
            str = this.mBt.mBl.mxe;
        }
        objArr[1] = str;
        objArr[2] = Boolean.valueOf(this.mBt.mBi);
        x.i(str2, str3, objArr);
        if (RemittanceBusiUI.g(this.mBt) == 32) {
            if (!this.mBt.mBi) {
                RemittanceBusiUI.o(this.mBt);
                return;
            } else if (this.mBt.mBl == null || this.mBt.mBl.mxh != ((int) (RemittanceBusiUI.n(this.mBt) * 100.0d))) {
                RemittanceBusiUI.a(this.mBt, new 2(this), 0);
                return;
            } else if (this.mBt.mBl == null || !this.mBt.mBl.mxe) {
                if (this.mBt.mBl != null) {
                    this.mBt.mBl.mxc = new 1(this);
                    return;
                }
                return;
            }
        }
        RemittanceBusiUI.o(this.mBt);
    }
}
