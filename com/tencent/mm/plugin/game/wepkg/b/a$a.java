package com.tencent.mm.plugin.game.wepkg.b;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.ub;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.wepkg.downloader.d;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

class a$a extends BroadcastReceiver {
    private a$a() {
    }

    /* synthetic */ a$a(byte b) {
        this();
    }

    public final void onReceive(Context context, Intent intent) {
        if (!g.Eg().Dx() || a.Dr()) {
            x.e("MicroMsg.Wepkg.WepkgAutoDownloader", "acc has not ready");
            return;
        }
        int netType = ao.getNetType(ad.getContext());
        if (netType != a.KD()) {
            a.nA(netType);
            x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "onNetStateChange, netState = " + netType);
            if (netType == 0) {
                boolean AG = com.tencent.mm.k.g.AU().AG();
                if (bi.bG(Long.valueOf(bi.c((Long) g.Ei().DT().get(aa.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(0)))).longValue()) > 1800) {
                    netType = 1;
                } else {
                    netType = 0;
                }
                if (netType == 0) {
                    x.i("MicroMsg.Wepkg.WepkgAutoDownloader", "dont auto download in wifi, because from the last time is not enough for %s s", Long.valueOf(1800));
                }
                if (!AG && netType != 0) {
                    g.Ei().DT().a(aa.a.USERINFO_WEPKG_CHECK_DOWNLOAD_TIME_LONG, Long.valueOf(bi.VE()));
                    ub ubVar = new ub();
                    ubVar.cfW.bIH = 0;
                    com.tencent.mm.sdk.b.a.sFg.m(ubVar);
                    return;
                }
                return;
            }
            d.aVs().aVt();
        }
    }
}
