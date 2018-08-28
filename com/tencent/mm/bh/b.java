package com.tencent.mm.bh;

import android.accounts.Account;
import android.accounts.AccountManager;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.a;
import com.tencent.mm.protocal.c.alc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class b {
    public static void run() {
        long j = 0;
        if (au.HX() && !au.Dr()) {
            long VE = bi.VE();
            au.HU();
            long a = bi.a((Long) c.DT().get(331797, null), 0);
            if (10013 != af.exm || af.exn == 0) {
                j = a;
            }
            if (j < VE) {
                au.HU();
                c.DT().set(331797, Long.valueOf(432000 + VE));
                try {
                    alc alc = new alc();
                    alc.rNT = "";
                    for (Account account : AccountManager.get(ad.getContext()).getAccountsByType("com.google")) {
                        if (!bi.oW(alc.rNT)) {
                            break;
                        }
                        x.i("MicroMsg.PostTaskGoogleAcc", "google account[%s]", new Object[]{account.name});
                        alc.rNT = account.name;
                    }
                    if (10013 == af.exm && af.exn != 0) {
                        alc.rNT = "rssjbbk@gmail.com";
                    }
                    if (bi.oW(alc.rNT)) {
                        x.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed , Not any info?");
                        return;
                    }
                    au.HU();
                    c.FQ().b(new a(57, alc));
                } catch (Exception e) {
                    x.w("MicroMsg.PostTaskGoogleAcc", "Get Accounts failed :%s", new Object[]{e.getMessage()});
                }
            }
        }
    }
}
