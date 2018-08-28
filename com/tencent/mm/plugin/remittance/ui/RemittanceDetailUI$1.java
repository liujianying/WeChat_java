package com.tencent.mm.plugin.remittance.ui;

import com.tencent.mm.g.a.ne;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class RemittanceDetailUI$1 extends c<ne> {
    final /* synthetic */ RemittanceDetailUI mCf;

    RemittanceDetailUI$1(RemittanceDetailUI remittanceDetailUI) {
        this.mCf = remittanceDetailUI;
        this.sFo = ne.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        ne neVar = (ne) bVar;
        if (!(bi.oW(neVar.bYf.bOe) || bi.oW(neVar.bYf.bXz))) {
            h.a(this.mCf, this.mCf.getString(i.remittance_detail_refund_tips, new Object[]{RemittanceDetailUI.aM(RemittanceDetailUI.a(this.mCf), false)}), this.mCf.getString(i.app_remind), this.mCf.getString(i.remittance_detail_refuse_btn_text), this.mCf.getString(i.app_cancel), new 1(this, neVar), new 2(this));
        }
        return false;
    }
}
