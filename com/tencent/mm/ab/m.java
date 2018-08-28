package com.tencent.mm.ab;

import com.tencent.mm.model.av;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amt;
import com.tencent.mm.protocal.c.avs;
import com.tencent.mm.protocal.c.iz;
import com.tencent.mm.sdk.platformtools.x;

public abstract class m extends l implements k {
    protected int dJp = 3;
    private boolean dJq = false;

    public abstract void Ld();

    public abstract e Le();

    public abstract void a(int i, int i2, String str, q qVar);

    public abstract iz c(q qVar);

    public abstract avs d(q qVar);

    public abstract amt e(q qVar);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 4 && i3 == -301) {
            x.i("MicroMsg.NetSceneIDCRedirectBase", "alvinluo NetScene pre process MM_ERR_IDC_REDIRECT redirectCount: %d", new Object[]{Integer.valueOf(this.dJp)});
            if (qVar != null) {
                x.i("MicroMsg.NetSceneIDCRedirectBase", "update idc info");
                av.a(true, c(qVar), d(qVar), e(qVar));
            }
            this.dJp--;
            if (this.dJp <= 0) {
                Ld();
                this.dJq = false;
                return;
            }
            x.d("MicroMsg.NetSceneIDCRedirectBase", "redirect IDC");
            a(this.dIX, Le());
            return;
        }
        a(i2, i3, str, qVar);
    }
}
