package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;

class FingerPrintAuthTransparentUI$1 implements c {
    final /* synthetic */ FingerPrintAuthTransparentUI jhl;

    FingerPrintAuthTransparentUI$1(FingerPrintAuthTransparentUI fingerPrintAuthTransparentUI) {
        this.jhl = fingerPrintAuthTransparentUI;
    }

    public final void aK(int i, int i2) {
        String string;
        switch (i) {
            case 0:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify success");
                FingerPrintAuthTransparentUI.a(this.jhl, i2);
                FingerPrintAuthTransparentUI.a(this.jhl);
                return;
            case 2001:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify timeout");
                return;
            case 2002:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                FingerPrintAuthTransparentUI.b(this.jhl);
                FingerPrintAuthTransparentUI.a(this.jhl, true);
                return;
            case 2005:
            case 2007:
            case 10308:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ad.getContext().getString(i.soter_on_error_common);
                if (i == 10308) {
                    string = ad.getContext().getString(i.soter_on_error_max_trial);
                    a.c(6, -1000223, -1, "too many trial");
                } else {
                    a.c(TbsLog.TBSLOG_CODE_SDK_BASE, -1000223, i, "fingerprint error");
                }
                FingerPrintAuthTransparentUI.a(this.jhl, string);
                return;
            case 2009:
                x.i("MicroMsg.FingerPrintAuthTransparentUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ad.getContext().getString(i.soter_on_error_common);
                a.c(TbsLog.TBSLOG_CODE_SDK_BASE, -1000223, i, "fingerprint error");
                a.xQ(2);
                FingerPrintAuthTransparentUI.a(this.jhl, string);
                return;
            default:
                return;
        }
    }
}
