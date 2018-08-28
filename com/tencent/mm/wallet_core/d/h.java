package com.tencent.mm.wallet_core.d;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.wxpay.a$i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.wallet_core.a;
import com.tencent.mm.wallet_core.c;
import com.tencent.mm.wallet_core.c.i;
import com.tencent.mm.wallet_core.e.a.b;
import com.tencent.mm.wallet_core.tenpay.model.j;
import com.tencent.mm.wallet_core.tenpay.model.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public final class h {
    public static boolean a(WalletBaseUI walletBaseUI, l lVar, int i, int i2, String str) {
        boolean z = false;
        if (i == 1000) {
            String string;
            if (bi.oW(str)) {
                string = walletBaseUI.getString(a$i.wallet_unknown_err);
            } else {
                string = str;
            }
            c af = a.af(walletBaseUI);
            switch (i2) {
                case -100869:
                    com.tencent.mm.ui.base.h.a(walletBaseUI, walletBaseUI.getString(a$i.wallet_err_wording_not_open_wallet), null, false, new 11(walletBaseUI, i2));
                    z = true;
                    break;
                case -100868:
                    com.tencent.mm.ui.base.h.a(walletBaseUI, walletBaseUI.getString(a$i.wallet_err_wording_payment_not_match), null, false, new 10(walletBaseUI, i2));
                    z = true;
                    break;
                case 401:
                    int i3;
                    if (lVar instanceof j) {
                        i3 = ((j) lVar).ppo;
                    } else {
                        i3 = 0;
                    }
                    if (i3 == 1) {
                        com.tencent.mm.ui.base.h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.wallet_forget_notretry_password), new 1(walletBaseUI));
                    } else {
                        com.tencent.mm.ui.base.h.a(walletBaseUI, false, string, "", walletBaseUI.getString(a$i.wallet_forget_password), walletBaseUI.getString(a$i.app_retry), new 4(lVar, walletBaseUI), new 5(walletBaseUI));
                    }
                    z = true;
                    break;
                case 402:
                case 403:
                case 408:
                    if (af != null) {
                        z = af.a(walletBaseUI, i2, string);
                        break;
                    }
                    break;
                case 404:
                    if (af != null) {
                        z = af.a(walletBaseUI, i2, string);
                        break;
                    }
                    break;
                case 405:
                    if (lVar instanceof j) {
                        z = ((j) lVar).ppo;
                    }
                    if (z) {
                        com.tencent.mm.ui.base.h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.wallet_forget_notretry_password), new 7(walletBaseUI));
                    } else {
                        com.tencent.mm.ui.base.h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.wallet_retry), walletBaseUI.getString(a$i.app_cancel), new 8(walletBaseUI), null);
                    }
                    z = true;
                    break;
                case 407:
                    cDs();
                    if (q.GS()) {
                        b(walletBaseUI, i2, string);
                    } else {
                        com.tencent.mm.ui.base.h.a(walletBaseUI, string, null, false, new 6(walletBaseUI, i2));
                    }
                    z = true;
                    break;
                case 412:
                    com.tencent.mm.ui.base.h.a(walletBaseUI, string, "", walletBaseUI.getString(a$i.wallet_verify_user_info_tips), walletBaseUI.getString(a$i.app_cancel), new 9(walletBaseUI), null);
                    z = true;
                    break;
                case 414:
                    cDs();
                    b(walletBaseUI, i2, string);
                    z = true;
                    break;
            }
        }
        if (lVar instanceof i) {
            ((i) lVar).uXo = z;
        }
        return z;
    }

    private static void cDs() {
        l bVar;
        if (q.GS()) {
            bVar = new b();
        } else {
            bVar = new m();
        }
        g.Ek();
        g.Eh().dpP.a(bVar, 0);
    }

    private static void b(final WalletBaseUI walletBaseUI, final int i, String str) {
        com.tencent.mm.ui.base.h.a(walletBaseUI, false, str, "", walletBaseUI.getString(a$i.wallet_err_wording_contact_me_payu), walletBaseUI.getString(a$i.app_cancel), new 2(walletBaseUI), new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                a.c(walletBaseUI, walletBaseUI.sy, i);
                if (walletBaseUI.bbR() || walletBaseUI.mController.contentView.getVisibility() != 0) {
                    walletBaseUI.finish();
                }
            }
        });
    }
}
