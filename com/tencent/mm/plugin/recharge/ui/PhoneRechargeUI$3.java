package com.tencent.mm.plugin.recharge.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.x;
import java.net.URLDecoder;

class PhoneRechargeUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ PhoneRechargeUI mqa;

    PhoneRechargeUI$3(PhoneRechargeUI phoneRechargeUI) {
        this.mqa = phoneRechargeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!PhoneRechargeUI.a(this.mqa, PhoneRechargeUI.i(this.mqa).pdR, PhoneRechargeUI.i(this.mqa).dzE)) {
            try {
                PhoneRechargeUI.c(this.mqa, URLDecoder.decode(PhoneRechargeUI.i(this.mqa).url, "utf-8"));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.PhoneRechargeUI", e, "", new Object[0]);
            }
        }
        return false;
    }
}
