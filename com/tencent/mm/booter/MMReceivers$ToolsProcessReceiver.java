package com.tencent.mm.booter;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class MMReceivers$ToolsProcessReceiver extends BroadcastReceiver {
    private static MMReceivers$a cWR = null;

    public static void a(MMReceivers$a mMReceivers$a) {
        cWR = mMReceivers$a;
    }

    public void onReceive(Context context, Intent intent) {
        if (cWR != null) {
            cWR.onReceive(context, intent);
        }
    }
}
