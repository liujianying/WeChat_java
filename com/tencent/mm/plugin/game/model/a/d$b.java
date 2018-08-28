package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;

class d$b extends BroadcastReceiver {
    private d$b() {
    }

    /* synthetic */ d$b(byte b) {
        this();
    }

    public final void onReceive(Context context, Intent intent) {
        if (!g.Eg().Dx() || a.Dr()) {
            x.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
            return;
        }
        int netType = ao.getNetType(ad.getContext());
        if (netType != d.uw()) {
            d.eq(netType);
            if (netType == 0) {
                x.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, checkDownload", new Object[]{Integer.valueOf(netType)});
                g.a.aUH().fv(false);
                return;
            }
            x.i("MicroMsg.GameSilentDownloadListener", "netStateChange, netState = %s, pauseDownload", new Object[]{Integer.valueOf(netType)});
            g.a.aUH();
            g.pauseDownload();
        }
    }
}
