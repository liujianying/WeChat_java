package com.tencent.mm.plugin.wear.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import com.tencent.mm.plugin.wear.model.e.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;

public class WearMessageLogic extends BroadcastReceiver {
    public WearMessageLogic() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.tencent.mm.wear.message");
        ad.getContext().registerReceiver(this, intentFilter, "com.tencent.mm.wear.message", null);
    }

    public void onReceive(Context context, Intent intent) {
        byte b = (byte) 0;
        if (intent.getAction().equals("com.tencent.mm.wear.message")) {
            Bundle extras = intent.getExtras();
            int i = extras.getInt("key_connecttype");
            if (i == 1) {
                a aVar = new a(this, (byte) 0);
                aVar.pJs = i;
                aVar.pJt = extras.getInt("key_funid");
                aVar.mFO = extras.getInt("key_sessionid");
                aVar.pJu = extras.getByteArray("key_data");
                a zG = a.bSl().pIK.zG(aVar.pJt);
                if (zG != null) {
                    b = zG.zF(aVar.pJt);
                }
                if (b != (byte) 0) {
                    ah.A(aVar);
                } else {
                    e.post(aVar, "WearHttpMessageTask_" + aVar.pJt);
                }
            } else if (i == 2) {
                b bVar = new b(this, (byte) 0);
                bVar.pJs = i;
                bVar.pJt = extras.getInt("key_funid");
                bVar.mFO = extras.getInt("key_sessionid");
                bVar.pJu = extras.getByteArray("key_data");
                a.bSl().pIS.a(bVar);
            } else if (i == 3) {
                a.bSl().pIS.a(new c(this, (byte) 0));
            }
        }
    }
}
