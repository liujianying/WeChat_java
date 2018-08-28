package com.tencent.mm.plugin.base.stub;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.pluginsdk.model.app.aq;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.x;

class WXCommProvider$1 extends BroadcastReceiver {
    final /* synthetic */ WXCommProvider hdU;

    WXCommProvider$1(WXCommProvider wXCommProvider) {
        this.hdU = wXCommProvider;
    }

    public void onReceive(Context context, Intent intent) {
        aq aqVar;
        if (System.currentTimeMillis() - aq.qBd >= 600000) {
            x.e("MicroMsg.AppUtil", "hy: get comm model time expired");
            aqVar = null;
        } else {
            aqVar = aq.qBc;
        }
        if (aqVar != null) {
            x.i("MicroMsg.WXCommProvider", "hy: has wxcomm query request. start to continue requesting");
            Cursor a = this.hdU.a(aqVar.uri, aqVar.projection, aqVar.selection, aqVar.selectionArgs, aqVar.qBa, aqVar.code, aqVar.qBb);
            if (a != null) {
                a.close();
            }
            p.cbS();
        }
    }
}
