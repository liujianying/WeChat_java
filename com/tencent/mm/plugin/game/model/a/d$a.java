package com.tencent.mm.plugin.game.model.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.x;

class d$a extends BroadcastReceiver {
    private d$a() {
    }

    /* synthetic */ d$a(byte b) {
        this();
    }

    public final void onReceive(Context context, Intent intent) {
        if (!g.Eg().Dx() || a.Dr()) {
            x.e("MicroMsg.GameSilentDownloadListener", "acc has not ready");
        } else if (intent == null) {
        } else {
            if ("android.intent.action.BATTERY_OKAY".equals(intent.getAction())) {
                x.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_OKAY, checkDownload");
                g.a.aUH().fv(true);
            } else if ("android.intent.action.BATTERY_LOW".equals(intent.getAction())) {
                x.i("MicroMsg.GameSilentDownloadListener", "batteryChange: ACTION_BATTERY_LOW, pauseDownload");
                g.a.aUH();
                g.pauseDownload();
            }
        }
    }
}
