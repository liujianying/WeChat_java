package com.tencent.mm.modelmulti;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.sdk.platformtools.x;

class m$1 extends BroadcastReceiver {
    final /* synthetic */ a eaj;
    final /* synthetic */ boolean eak = false;
    final /* synthetic */ m eal;

    m$1(m mVar, a aVar) {
        this.eal = mVar;
        this.eaj = aVar;
    }

    public final void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ScreenState", "ScreenReceiver action [%s] ", intent == null ? "" : intent.getAction());
        if ("android.intent.action.SCREEN_OFF".equals(intent == null ? "" : intent.getAction())) {
            this.eal.eai = Boolean.valueOf(false);
        } else {
            this.eal.eai = Boolean.valueOf(true);
        }
        if (this.eaj != null) {
            this.eaj.bL(this.eal.eai.booleanValue());
        }
        if (this.eak) {
            context.unregisterReceiver(this);
        }
    }
}
