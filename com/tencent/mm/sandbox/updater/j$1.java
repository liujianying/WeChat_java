package com.tencent.mm.sandbox.updater;

import android.app.NotificationManager;
import android.content.Intent;
import com.tencent.mm.opensdk.constants.ConstantsAPI$WXApp;
import com.tencent.mm.sdk.platformtools.x;

class j$1 implements Runnable {
    final /* synthetic */ int sEP;
    final /* synthetic */ j sEQ;

    j$1(j jVar, int i) {
        this.sEQ = jVar;
        this.sEP = i;
    }

    public final void run() {
        ((NotificationManager) this.sEQ.mContext.getSystemService("notification")).cancel(99);
        x.d("MicroMsg.UpdaterManager", "finishType == " + this.sEP);
        if (this.sEP == 2 && this.sEQ.sDi == 1) {
            Intent intent = new Intent();
            intent.setAction("com.tencent.mm.sandbox.updater.intent.ACTION_EXIT_APP");
            this.sEQ.mContext.sendBroadcast(intent, ConstantsAPI$WXApp.WXAPP_BROADCAST_PERMISSION);
        }
    }
}
