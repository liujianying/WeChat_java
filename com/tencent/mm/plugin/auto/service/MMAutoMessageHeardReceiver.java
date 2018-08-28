package com.tencent.mm.plugin.auto.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.s;
import com.tencent.mm.sdk.platformtools.x;

public class MMAutoMessageHeardReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        String j = s.j(intent, "key_username");
        if (j != null) {
            x.i("MicroMsg.auto.MMAutoMessageHeardReceiver", "username %s heard", new Object[]{j});
            au.getNotification().cancelNotification(j);
            au.HU();
            c.FW().Ys(j);
        }
    }
}
