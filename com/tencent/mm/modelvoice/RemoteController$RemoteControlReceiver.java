package com.tencent.mm.modelvoice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;

public class RemoteController$RemoteControlReceiver extends BroadcastReceiver {
    private static al bAZ;
    private static RemoteController$a eoP;

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            if ("android.intent.action.MEDIA_BUTTON".equals(intent.getAction())) {
                if (bAZ == null && eoP != null) {
                    x.d("MicroMsg.RemoteControlReceiver", "got remote key event down");
                    bAZ = new al(new 1(this), true);
                }
                if (bAZ != null) {
                    bAZ.J(1000, 1000);
                    return;
                }
                return;
            }
            x.d("MicroMsg.RemoteControlReceiver", "unknown action, ignore" + intent.getAction());
        }
    }

    public static void TA() {
        eoP = null;
        if (bAZ != null) {
            bAZ.SO();
            bAZ = null;
        }
    }
}
