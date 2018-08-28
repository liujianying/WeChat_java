package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.game.wepkg.model.c.a;
import com.tencent.mm.plugin.game.wepkg.utils.d;

class c$a$1 extends a {
    final /* synthetic */ Bundle bAE;
    final /* synthetic */ c dmx;
    final /* synthetic */ a keV;

    c$a$1(a aVar, c cVar, Bundle bundle) {
        this.keV = aVar;
        this.dmx = cVar;
        this.bAE = bundle;
    }

    public final void a(BaseWepkgProcessTask baseWepkgProcessTask) {
        if ((baseWepkgProcessTask instanceof WepkgCrossProcessTask) && baseWepkgProcessTask.bGZ) {
            d.Em().H(new 1(this, ((WepkgCrossProcessTask) baseWepkgProcessTask).kfj));
        }
    }
}
