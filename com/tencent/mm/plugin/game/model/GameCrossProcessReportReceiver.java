package com.tencent.mm.plugin.game.model;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

public class GameCrossProcessReportReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            x.e("MicroMsg.GameCrossProcessReportReceiver", "onReceive intent == null");
        } else if ("com.tencent.mm.game.report.GameCrossProcessReportReceiver".equals(intent.getAction())) {
            an(intent.getIntExtra("LOGID_KEY", 0), intent.getStringExtra("LOGEXT_KEY"));
        }
    }

    private static void an(int i, String str) {
        x.i("MicroMsg.GameCrossProcessReportReceiver", "game cross process report, logId:%d, logExt:%s", new Object[]{Integer.valueOf(i), str});
        ((b) g.l(b.class)).aSg().a(new am$a(i, str));
    }

    public static void H(int i, String str) {
        if (ad.cic()) {
            an(i, str);
            return;
        }
        String str2 = ad.getPackageName() + ".plugin.game.model.GameCrossProcessReportReceiver";
        Intent intent = new Intent("com.tencent.mm.game.report.GameCrossProcessReportReceiver");
        intent.setComponent(new ComponentName(ad.getPackageName(), str2));
        intent.putExtra("LOGID_KEY", i);
        intent.putExtra("LOGEXT_KEY", str);
        ad.getContext().sendBroadcast(intent);
    }
}
