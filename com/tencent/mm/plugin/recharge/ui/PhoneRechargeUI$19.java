package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.protocal.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;

class PhoneRechargeUI$19 implements OnClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$19(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final void onClick(View view) {
        if (PhoneRechargeUI.f(this.mqa) != null) {
            f.eA(6, 1);
            if (!PhoneRechargeUI.a(this.mqa, PhoneRechargeUI.f(this.mqa).pdR, PhoneRechargeUI.f(this.mqa).dzE) && !bi.oW(PhoneRechargeUI.f(this.mqa).url)) {
                try {
                    PhoneRechargeUI.c(this.mqa, URLDecoder.decode(PhoneRechargeUI.f(this.mqa).url, "utf-8"));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
                }
            }
        }
    }
}
