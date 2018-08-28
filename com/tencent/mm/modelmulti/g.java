package com.tencent.mm.modelmulti;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.t$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private q dJM;
    public long dYY = -1;
    private byte[] dZu;
    private e diJ;
    private int uin = 0;

    public static class b implements q {
        private final t$a dZv = new t$a();
        private final com.tencent.mm.protocal.t.b dZw = new com.tencent.mm.protocal.t.b();
        int uin;

        public final /* bridge */ /* synthetic */ com.tencent.mm.protocal.k.e Id() {
            return this.dZw;
        }

        public final int getType() {
            return 268369922;
        }

        public final String getUri() {
            return null;
        }

        public final d KV() {
            this.dZv.qWv = com.tencent.mm.compatible.e.q.zz();
            this.dZv.qWu = com.tencent.mm.protocal.d.DEVICE_TYPE;
            this.dZv.qWt = com.tencent.mm.protocal.d.qVN;
            this.dZv.eK(this.uin);
            return this.dZv;
        }

        public final boolean KW() {
            return false;
        }

        public final int KP() {
            return 0;
        }
    }

    public g(long j, byte[] bArr) {
        this.dYY = j;
        this.dZu = bArr;
    }

    public g(long j, byte[] bArr, int i) {
        this.dYY = j;
        this.dZu = bArr;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bi.bC(this.dZu)) {
            x.e("MicroMsg.NetSceneNotifyData", "dkpush %s", new Object[]{"get keyBuf failed"});
            return -1;
        }
        if (this.uin == 0) {
            this.dJM = new a();
        } else {
            this.dJM = new b();
            ((b) this.dJM).uin = this.uin;
        }
        x.i("MicroMsg.NetSceneNotifyData", "doScene now:%d buf:%s", new Object[]{Long.valueOf(this.dYY), bi.bA(this.dZu)});
        ((t$a) this.dJM.KV()).eaP = this.dYY;
        ((t$a) this.dJM.KV()).bOK = this.dZu;
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 268369922;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneNotifyData", "onGYNetEnd [%d,%d] %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }
}
