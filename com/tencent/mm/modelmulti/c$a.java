package com.tencent.mm.modelmulti;

import com.tencent.mm.network.q;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.protocal.s.a;
import com.tencent.mm.protocal.s.b;

public class c$a implements q {
    private final a dZc;
    private final b dZd;
    private final boolean dZe;
    int uin;

    public c$a() {
        this.dZc = new a();
        this.dZd = new b();
        this.dZe = false;
    }

    public c$a(b bVar) {
        this.dZc = new a();
        this.dZd = bVar;
        this.dZe = true;
    }

    public final e Id() {
        return this.dZd;
    }

    public final int getType() {
        return 138;
    }

    public final String getUri() {
        return "/cgi-bin/micromsg-bin/newsync";
    }

    public final d KV() {
        this.dZc.qWv = com.tencent.mm.compatible.e.q.zz();
        this.dZc.qWu = com.tencent.mm.protocal.d.DEVICE_TYPE;
        this.dZc.qWt = com.tencent.mm.protocal.d.qVN;
        this.dZc.eK(this.uin);
        return this.dZc;
    }

    public final boolean KW() {
        return false;
    }

    public final int KP() {
        return 0;
    }
}
