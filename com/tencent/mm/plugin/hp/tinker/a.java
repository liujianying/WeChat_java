package com.tencent.mm.plugin.hp.tinker;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;

public final class a {
    Handler handler = new Handler(Looper.getMainLooper());

    public a(Context context, a aVar) {
        Boolean bO = bO(context);
        com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "try post ScreenOffRetryPatch delay time: %d, screen: %b", new Object[]{Long.valueOf(6000), bO});
        IntentFilter intentFilter = new IntentFilter();
        1 1 = new 1(this, aVar);
        if (bO == null || bO.booleanValue()) {
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
        } else {
            com.tencent.tinker.lib.f.a.i("Tinker.ScreenOffRetryPatch", "screen is just off now, we can send message directly", new Object[0]);
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            this.handler.postDelayed(1, 6000);
        }
        context.registerReceiver(new 2(this, 1), intentFilter);
    }

    private static Boolean bO(Context context) {
        try {
            return (Boolean) PowerManager.class.getMethod("isScreenOn", new Class[0]).invoke((PowerManager) context.getSystemService("power"), new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }
}
