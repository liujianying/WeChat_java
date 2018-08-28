package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.api.d;
import com.tencent.mm.api.l;
import com.tencent.mm.sdk.platformtools.x;

class a$5 implements l {
    final /* synthetic */ a lpk;

    a$5(a aVar) {
        this.lpk = aVar;
    }

    public final void a(d dVar) {
        x.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedFeature] features:%s", new Object[]{dVar.name()});
        if (dVar == d.bwS) {
            a.a(this.lpk);
        }
    }

    public final void a(d dVar, int i) {
        x.i("MicroMsg.MMSightVideoEditor", "photoEditor [onSelectedDetailFeature] features:%s index:%s", new Object[]{dVar.name(), Integer.valueOf(i)});
    }

    public final void aD(boolean z) {
        if (z) {
            this.lpk.bGc.showVKB();
        } else {
            this.lpk.bGc.hideVKB(this.lpk.loY);
        }
    }
}
