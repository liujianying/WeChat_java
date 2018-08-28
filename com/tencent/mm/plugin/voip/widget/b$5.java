package com.tencent.mm.plugin.voip.widget;

import android.content.Intent;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.b.b;
import com.tencent.mm.plugin.voip.ui.a;
import com.tencent.mm.plugin.voip.ui.h;
import com.tencent.mm.sdk.platformtools.ad;

class b$5 implements a {
    final /* synthetic */ b oWh;

    b$5(b bVar) {
        this.oWh = bVar;
    }

    public final boolean aWU() {
        if (b.yW(b.e(this.oWh)) || b.yU(b.e(this.oWh))) {
            return true;
        }
        return false;
    }

    public final void a(Intent intent, h hVar) {
        if (intent.getBooleanExtra("Voip_Is_Talking", false)) {
            hVar.OI(this.oWh.bMq());
        } else {
            hVar.OI(ad.getContext().getString(R.l.multitalk_waiting_wording));
        }
    }
}
