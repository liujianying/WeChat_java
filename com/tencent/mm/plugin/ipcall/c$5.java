package com.tencent.mm.plugin.ipcall;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ad;

class c$5 implements a {
    final /* synthetic */ c kob;

    c$5(c cVar) {
        this.kob = cVar;
    }

    public final boolean aWU() {
        if (i.aXt().aXj()) {
            return true;
        }
        return false;
    }

    public final void a(Intent intent, h hVar) {
        if (i.aXt().aXm()) {
            int aWT = this.kob.aWT();
            hVar.OJ(String.format("%02d:%02d", new Object[]{Integer.valueOf(aWT / 60), Integer.valueOf(aWT % 60)}));
            return;
        }
        hVar.OI(ad.getContext().getString(R.l.multitalk_waiting_wording));
    }
}
