package com.tencent.mm.plugin.i;

import android.content.Context;
import android.content.Intent;
import com.tencent.mars.BaseEvent;
import com.tencent.mm.aa.p;
import com.tencent.mm.ab.o;
import com.tencent.mm.ab.o.a;
import com.tencent.mm.booter.NotifyReceiver.NotifyService;
import com.tencent.mm.platformtools.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMAppMgr;

class e$1 implements a {
    final /* synthetic */ e hjp;

    e$1(e eVar) {
        this.hjp = eVar;
    }

    public final void a(o oVar, boolean z) {
        if (z && !oVar.foreground) {
            if (e.atZ()) {
                com.tencent.mrs.a.onDestroy();
                MMAppMgr.cqu();
                x.appenderClose();
                BaseEvent.onSingalCrash(0);
                x.e("MicroMsg.MMCoreInitTask", "now killing the working process....");
                if (b.Vo()) {
                    x.e("MicroMsg.MMCoreInitTask", "address book syncing, wait a minute please");
                    return;
                }
                Context context = ad.getContext();
                context.stopService(new Intent(context, NotifyService.class));
                p.k(new 1(this));
                return;
            }
            x.w("MicroMsg.MMCoreInitTask", "can't kill the working process");
        }
    }

    public final void a(o oVar) {
    }
}
