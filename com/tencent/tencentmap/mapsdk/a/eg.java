package com.tencent.tencentmap.mapsdk.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.tencentmap.mapsdk.a.ef.b;

final class eg extends BroadcastReceiver {
    private /* synthetic */ ef a;

    eg(ef efVar) {
        this.a = efVar;
    }

    public final void onReceive(Context context, Intent intent) {
        try {
            el.a().a(new b(this.a, intent));
        } catch (Throwable th) {
        }
    }
}
