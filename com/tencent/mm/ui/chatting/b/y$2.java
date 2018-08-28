package com.tencent.mm.ui.chatting.b;

import android.content.ComponentName;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.e.i;

class y$2 implements Runnable {
    final /* synthetic */ y tQV;

    y$2(y yVar) {
        this.tQV = yVar;
    }

    public final void run() {
        if (this.tQV.bAG != null) {
            x.i("MicroMsg.ChattingUI.MessBoxComponent", "now try to activity the tools process");
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(i.thA, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
            intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS");
            this.tQV.bAG.tTq.sendBroadcast(intent);
        }
    }
}
