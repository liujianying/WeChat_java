package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.c.a;
import com.tencent.mm.plugin.gcm.modelgcm.c.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public class e$a implements q {
    private final a khs = new a();
    private final b kht = new b();
    int uin;

    public final /* bridge */ /* synthetic */ e Id() {
        return this.kht;
    }

    public final int getType() {
        return 623;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/androidgcmreg";
    }

    public final d KV() {
        this.khs.qWv = com.tencent.mm.compatible.e.q.zz();
        this.khs.qWu = com.tencent.mm.protocal.d.DEVICE_TYPE;
        this.khs.qWt = com.tencent.mm.protocal.d.qVN;
        this.khs.eK(this.uin);
        return this.khs;
    }

    public final boolean KW() {
        return false;
    }

    public final int KP() {
        return 0;
    }
}
