package com.tencent.mm.wallet_core.d;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.sdk.platformtools.x;

public abstract class c<T extends d> implements e {
    public int rtType;
    public e uXI;
    T uXJ;

    public abstract void a(d dVar);

    public abstract boolean a(int i, int i2, T t);

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.IDelayQueryOrder", "errType: %d, errCode: %d, errMsg: %s scene %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar});
        if ((lVar instanceof d) && !a(i, i2, (d) lVar) && this.uXI != null && this.uXJ != null && (this.uXJ instanceof l)) {
            this.uXI.a(i, i2, str, (l) this.uXJ);
        }
    }
}
