package com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.g.a.aa;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.TbsVideoCacheTask;

public class BakOldUSBReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if ("MMBakchatServiceStart".equalsIgnoreCase(action)) {
                context.startService(new Intent().setClassName(context, "com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.BakOldUSBService").putExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL, intent.getStringExtra(TbsVideoCacheTask.KEY_VIDEO_CACHE_PARAM_URL)));
                x.d("MicroMsg.BakOldUSBReceiver", "START_ACTION onReceive start end");
            } else if ("MMBakchatServiceStop".equalsIgnoreCase(action)) {
                aa aaVar = new aa();
                aaVar.bHi.bHj = context;
                a.sFg.m(aaVar);
                x.d("MicroMsg.BakOldUSBReceiver", "STOP_ACTION onReceive stop end");
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.BakOldUSBReceiver", e, "onReceive:", new Object[0]);
        }
    }
}
