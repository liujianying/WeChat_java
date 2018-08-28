package com.tencent.mm.plugin.ipcall.a.a;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.sdk.platformtools.x;

public abstract class a implements e {
    protected int errCode = 0;
    protected int errType = 0;
    public c koG;
    public a kpk;

    public abstract int Mw();

    public abstract int[] aXB();

    public abstract void aXC();

    public abstract void b(c cVar);

    public abstract void onDestroy();

    public void init() {
        for (int a : aXB()) {
            au.DF().a(a, this);
        }
        aXC();
    }

    public void destroy() {
        for (int b : aXB()) {
            au.DF().b(b, this);
        }
        this.kpk = null;
        onDestroy();
    }

    public void a(c cVar) {
        x.d("MicroMsg.BaseIPCallService", "start service, type: %d", new Object[]{Integer.valueOf(Mw())});
        this.koG = cVar;
        b(this.koG);
    }

    public void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.BaseIPCallService", "onSceneEnd, errType: %d, errCode: %d, scene.getType: %d, serviceType: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(lVar.getType()), Integer.valueOf(Mw())});
        this.errType = i;
        this.errCode = i2;
        if (i == 0 && i2 == 0) {
            if (this.kpk != null) {
                this.kpk.a(Mw(), lVar, i, i2);
            }
        } else if (this.kpk != null) {
            this.kpk.b(Mw(), lVar, i, i2);
        }
    }
}
