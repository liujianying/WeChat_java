package com.tencent.mm.plugin.nfc_open;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.plugin.hce.a.b;
import com.tencent.mm.plugin.nfc.c.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.MultiProcessSharedPreferences;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class a$1 implements Runnable {
    final /* synthetic */ a lFt;

    a$1(a aVar) {
        this.lFt = aVar;
    }

    public final void run() {
        SharedPreferences sharedPreferences = MultiProcessSharedPreferences.getSharedPreferences(ad.getContext(), "system_config_prefs", 4);
        if (bi.bI(sharedPreferences.getLong("NFC_REPORT_TIME", 0)) > 86400000) {
            int i;
            int dX = a.bjr().dX(ad.getContext());
            int i2 = dX == 0 ? 0 : 1;
            if (b.aVV()) {
                i = 1;
            } else {
                i = 0;
            }
            x.i("MicroMsg.SubCoreCpuCard", "alvinluo NFC report isSupportNFC: %d, isSupportHCE: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i)});
            h.mEJ.h(12779, new Object[]{q.zy(), Integer.valueOf(i2), Integer.valueOf(i)});
            Editor edit = sharedPreferences.edit();
            edit.putLong("NFC_REPORT_TIME", bi.VG());
            edit.commit();
            x.i("MicroMsg.SubCoreCpuCard", "doNFCReport status = " + dX);
        }
    }
}
