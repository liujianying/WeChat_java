package com.tencent.mm.plugin.fingerprint.ui;

import com.tencent.mm.plugin.soter.c.a;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.lang.ref.WeakReference;

public class FingerPrintAuthUI$a implements c {
    final /* synthetic */ FingerPrintAuthUI jhs;
    private WeakReference<FingerPrintAuthUI> jhv = null;

    public FingerPrintAuthUI$a(FingerPrintAuthUI fingerPrintAuthUI, FingerPrintAuthUI fingerPrintAuthUI2) {
        this.jhs = fingerPrintAuthUI;
        this.jhv = new WeakReference(fingerPrintAuthUI2);
    }

    private FingerPrintAuthUI aNN() {
        if (this.jhv != null) {
            return (FingerPrintAuthUI) this.jhv.get();
        }
        return null;
    }

    public final void aK(int i, int i2) {
        String string;
        switch (i) {
            case 0:
                x.i("MicroMsg.FingerPrintAuthUI", "identify success");
                if (aNN() != null) {
                    FingerPrintAuthUI.a(aNN(), i2);
                    return;
                }
                return;
            case 2001:
                x.i("MicroMsg.FingerPrintAuthUI", "identify timeout");
                if (aNN() != null) {
                    FingerPrintAuthUI.a(this.jhs, false);
                    return;
                }
                return;
            case 2002:
                x.i("MicroMsg.FingerPrintAuthUI", "identify FingerPrintConst.RESULT_NO_MATCH");
                if (aNN() != null) {
                    FingerPrintAuthUI.a(aNN());
                    FingerPrintAuthUI.a(this.jhs, true);
                    return;
                }
                return;
            case 2005:
            case 2007:
            case 10308:
                x.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ad.getContext().getString(i.soter_on_error_common);
                if (i == 10308) {
                    string = ad.getContext().getString(i.soter_on_error_max_trial);
                    a.c(6, -1000223, -1, "too many trial");
                } else {
                    a.c(TbsLog.TBSLOG_CODE_SDK_BASE, -1000223, i, "fingerprint error");
                }
                if (aNN() != null) {
                    FingerPrintAuthUI.a(aNN(), string, -1);
                    return;
                }
                return;
            case 2009:
                x.i("MicroMsg.FingerPrintAuthUI", "hy: on error: %d", new Object[]{Integer.valueOf(i)});
                string = ad.getContext().getString(i.soter_on_error_common);
                a.c(TbsLog.TBSLOG_CODE_SDK_BASE, -1000223, i, "fingerprint error");
                a.xQ(2);
                if (aNN() != null) {
                    FingerPrintAuthUI.a(aNN(), string, -1);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
