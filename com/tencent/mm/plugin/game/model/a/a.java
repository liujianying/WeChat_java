package com.tencent.mm.plugin.game.model.a;

import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public final class a {
    public static a aUG() {
        Intent registerReceiver = ad.getContext().registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        a aVar = new a();
        if (registerReceiver != null) {
            try {
                int intExtra = registerReceiver.getIntExtra(DownloadInfo.STATUS, -1);
                boolean z = intExtra == 2 || intExtra == 5;
                aVar.gCp = z;
                aVar.jOI = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
            } catch (Exception e) {
                x.e("MicroMsg.BatteryHelper", "err:%s", new Object[]{e.getMessage()});
            }
        }
        return aVar;
    }
}
