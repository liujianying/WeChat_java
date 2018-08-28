package com.tencent.mm.plugin.hp.tinker;

import android.app.AlarmManager;
import android.app.PendingIntent;
import com.tencent.mm.ab.o;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.m.a;
import com.tencent.mm.pluginsdk.f.e;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;

class TinkerPatchResultService$2 implements a {
    final /* synthetic */ TinkerPatchResultService knc;

    TinkerPatchResultService$2(TinkerPatchResultService tinkerPatchResultService) {
        this.knc = tinkerPatchResultService;
    }

    public final void bL(boolean z) {
        if (!z) {
            com.tencent.tinker.lib.f.a.i("Tinker.TinkerPatchResultService", "app is background now, i can kill quietly", new Object[0]);
            x.chS();
            o DF = g.DF();
            if (DF.dJx == null ? true : DF.dJx.booleanValue()) {
                x.i("Tinker.TinkerPatchResultService", "we are in foreground, trigger reboot now.");
                ((AlarmManager) this.knc.getSystemService("alarm")).set(1, System.currentTimeMillis() + 1000, PendingIntent.getActivity(this.knc.getApplicationContext(), 1, this.knc.getPackageManager().getLaunchIntentForPackage(this.knc.getPackageName()), 1073741824));
            } else {
                x.w("Tinker.TinkerPatchResultService", "we are in background, do not explicitly trigger reboot.");
            }
            e.qBn.h(ad.getContext(), true);
        }
    }
}
