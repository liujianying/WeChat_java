package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import com.tencent.mm.booter.MMReceivers.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Locale;

public class d$a implements a {
    public final void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            String stringExtra = intent.getStringExtra("exdevice_process_action_code_key");
            x.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, action %s", new Object[]{stringExtra});
            if (!bi.oW(stringExtra) && stringExtra.equals("action_reload_resources")) {
                String stringExtra2 = intent.getStringExtra("exdevice_language");
                x.i("MicroMsg.ExDeviceProcessReceiver", "onReceive, language %s", new Object[]{stringExtra2});
                Locale Wl = w.Wl(stringExtra2);
                if ("language_default".equalsIgnoreCase(stringExtra2)) {
                    if (VERSION.SDK_INT >= 24) {
                        Wl = w.sGk;
                        Locale.setDefault(Wl);
                    } else {
                        Wl = Locale.getDefault();
                    }
                }
                w.a(context.getApplicationContext(), Wl);
                ad.a(com.tencent.mm.bq.a.a(context.getApplicationContext().getResources(), context.getApplicationContext(), stringExtra2));
            }
        }
    }
}
