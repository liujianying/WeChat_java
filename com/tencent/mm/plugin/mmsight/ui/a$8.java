package com.tencent.mm.plugin.mmsight.ui;

import com.tencent.mm.plugin.mmsight.segment.c.b;
import com.tencent.mm.sdk.platformtools.x;

class a$8 implements b {
    final /* synthetic */ a lpk;

    a$8(a aVar) {
        this.lpk = aVar;
    }

    public final void K(float f, float f2) {
        if (this.lpk.lkZ != null) {
            int i = this.lpk.loU;
            this.lpk.loV = Math.round(((float) i) * f);
            this.lpk.loW = Math.round(((float) i) * f2);
            x.i("MicroMsg.MMSightVideoEditor", "onRecyclerChanged, start: %s, end: %s %s %s", new Object[]{Integer.valueOf(this.lpk.loV), Integer.valueOf(this.lpk.loW), Float.valueOf(f), Float.valueOf(f2)});
            this.lpk.lkZ.d((double) this.lpk.loV, true);
        }
    }

    public final void beO() {
        if (this.lpk.lkZ != null) {
            this.lpk.lkZ.pause();
        }
    }

    public final void L(float f, float f2) {
        if (this.lpk.lkZ != null) {
            int i = this.lpk.loU;
            this.lpk.loV = Math.round(((float) i) * f);
            this.lpk.loW = Math.round(((float) i) * f2);
            this.lpk.lkZ.d((double) this.lpk.loV, true);
            x.i("MicroMsg.MMSightVideoEditor", "onUp, start: %s, end: %s %s %s", new Object[]{Integer.valueOf(this.lpk.loV), Integer.valueOf(this.lpk.loW), Float.valueOf(f), Float.valueOf(f2)});
        }
    }

    public final void M(float f, float f2) {
    }
}
