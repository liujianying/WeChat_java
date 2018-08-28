package com.tencent.mm.plugin.ipcall.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.k.g;
import com.tencent.mm.plugin.ipcall.b.c;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;

class IPCallShareCouponUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ IPCallShareCouponUI kyP;

    IPCallShareCouponUI$6(IPCallShareCouponUI iPCallShareCouponUI) {
        this.kyP = iPCallShareCouponUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        boolean z;
        String[] strArr;
        akc aYD = c.aYD();
        if (!(aYD == null || bi.oW(aYD.rMR))) {
            if (g.AT().getInt("WCOWebPayListSwitch", 0) > 0) {
                z = true;
                if (z) {
                    strArr = new String[]{this.kyP.getString(R.l.ip_call_help), this.kyP.getString(R.l.ip_call_agreement)};
                    IPCallShareCouponUI.a(this.kyP, false);
                } else {
                    strArr = new String[]{this.kyP.getString(R.l.ip_call_webview_recharge_title), this.kyP.getString(R.l.ip_call_help), this.kyP.getString(R.l.ip_call_agreement)};
                    IPCallShareCouponUI.a(this.kyP, true);
                }
                h.a(this.kyP.mController.tml, null, strArr, null, false, new 1(this));
                return true;
            }
        }
        z = false;
        if (z) {
            strArr = new String[]{this.kyP.getString(R.l.ip_call_help), this.kyP.getString(R.l.ip_call_agreement)};
            IPCallShareCouponUI.a(this.kyP, false);
        } else {
            strArr = new String[]{this.kyP.getString(R.l.ip_call_webview_recharge_title), this.kyP.getString(R.l.ip_call_help), this.kyP.getString(R.l.ip_call_agreement)};
            IPCallShareCouponUI.a(this.kyP, true);
        }
        h.a(this.kyP.mController.tml, null, strArr, null, false, new 1(this));
        return true;
    }
}
