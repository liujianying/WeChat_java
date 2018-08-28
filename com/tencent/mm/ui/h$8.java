package com.tencent.mm.ui;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.ui.e.i;

class h$8 implements Runnable {
    final /* synthetic */ h tiG;

    h$8(h hVar) {
        this.tiG = hVar;
    }

    public final void run() {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
        this.tiG.sendBroadcast(intent);
    }
}
