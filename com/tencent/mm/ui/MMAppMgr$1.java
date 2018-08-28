package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class MMAppMgr$1 implements a {
    final /* synthetic */ MMAppMgr tnp;

    MMAppMgr$1(MMAppMgr mMAppMgr) {
        this.tnp = mMAppMgr;
    }

    public final boolean vD() {
        String bQ = bi.bQ(ad.getContext());
        if (bQ == null || !bQ.toLowerCase().startsWith(ad.getPackageName())) {
            x.i("MicroMsg.MMAppMgr", "onTimerExpired, kill tools process");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(e$i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
            ad.getContext().sendBroadcast(intent);
        } else {
            x.i("MicroMsg.MMAppMgr", "onTimerExpired, top activity belongs to mm, skip kill tools");
        }
        return false;
    }
}
