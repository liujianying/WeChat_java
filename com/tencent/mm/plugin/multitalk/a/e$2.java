package com.tencent.mm.plugin.multitalk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class e$2 extends BroadcastReceiver {
    final /* synthetic */ e ltL;

    e$2(e eVar) {
        this.ltL = eVar;
    }

    public final void onReceive(Context context, Intent intent) {
        if (!this.ltL.bgl()) {
            return;
        }
        if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
            this.ltL.ltI.removeCallbacksAndMessages(null);
            this.ltL.ltI.postDelayed(new 1(this), 8000);
            return;
        }
        x.i("MicroMsg.MT.MultiTalkManager", "phone state %d", new Object[]{Integer.valueOf(i.v(context, intent))});
        if (i.v(context, intent) == 0) {
            ah.A(new Runnable() {
                public final void run() {
                    o.bgM().lta.mO(false);
                }
            });
        } else {
            ah.A(new Runnable() {
                public final void run() {
                    o.bgM().lta.mO(true);
                }
            });
        }
    }
}
