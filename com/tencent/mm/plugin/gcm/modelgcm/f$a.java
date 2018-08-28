package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.d.a;
import com.tencent.mm.plugin.gcm.modelgcm.d.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;

public class f$a implements q {
    private final a khu = new a();
    private final b khv = new b();
    int uin;

    public final /* bridge */ /* synthetic */ e Id() {
        return this.khv;
    }

    public final int getType() {
        return 624;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/androidgcmunreg";
    }

    public final d KV() {
        this.khu.qWv = com.tencent.mm.compatible.e.q.zz();
        this.khu.qWu = com.tencent.mm.protocal.d.DEVICE_TYPE;
        this.khu.qWt = com.tencent.mm.protocal.d.qVN;
        this.khu.eK(this.uin);
        return this.khu;
    }

    public final boolean KW() {
        return false;
    }

    public final int KP() {
        return 0;
    }
}
