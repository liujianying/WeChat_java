package com.tencent.mm.plugin.recharge.ui;

import android.widget.AutoCompleteTextView;
import com.tencent.mm.plugin.recharge.model.b;
import com.tencent.mm.plugin.recharge.ui.form.MallFormView.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class PhoneRechargeUI$12 implements a {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$12(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void fE(boolean z) {
        if (z) {
            this.mqa.YC();
            String pK = b.pK(PhoneRechargeUI.a(this.mqa).getText());
            if (pK == null) {
                x.e("MicroMsg.PhoneRechargeUI", "null phone, return");
                return;
            }
            e.a(new 1(this, pK), "search_matched_mobile");
            if (PhoneRechargeUI.c(this.mqa)) {
                PhoneRechargeUI.a(this.mqa, false);
                return;
            }
            x.d("MicroMsg.PhoneRechargeUI", "clear focus");
            PhoneRechargeUI.a(this.mqa, true);
            return;
        }
        PhoneRechargeUI.a(this.mqa).getTipsTv().setText("");
        PhoneRechargeUI.a(this.mqa).getTipsTv().setTextColor(this.mqa.getResources().getColor(c.normal_text_color));
        PhoneRechargeUI.d(this.mqa);
        PhoneRechargeUI.e(this.mqa);
        if (bi.oW(PhoneRechargeUI.a(this.mqa).getText())) {
            ((AutoCompleteTextView) PhoneRechargeUI.a(this.mqa).getContentEditText()).showDropDown();
        }
    }
}
