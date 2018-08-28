package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements e, k {
    private q dJM;
    private com.tencent.mm.ab.e diJ;
    private b<e.b> jgZ = null;

    public final /* synthetic */ void bx(Object obj) {
        a aVar = (a) obj;
        this.dJM = new b();
        c.a aVar2 = (c.a) this.dJM.KV();
        aVar2.onv.srU = aVar.vmd;
        aVar2.onv.srV = aVar.vmc;
    }

    protected final int Cc() {
        return 3;
    }

    protected final int a(q qVar) {
        return l.b.dJm;
    }

    public final int getType() {
        return 627;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.jgZ != null) {
                this.jgZ.cG(new e.b(true));
                return;
            }
            return;
        }
        x.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
        if (this.jgZ != null) {
            this.jgZ.cG(new e.b(false));
        }
    }

    public final void execute() {
        x.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        g.DF().a(this, 0);
    }

    public final void a(b<e.b> bVar) {
        this.jgZ = bVar;
    }
}
