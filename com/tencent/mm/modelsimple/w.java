package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkg;
import com.tencent.mm.protocal.v$a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import junit.framework.Assert;

public final class w extends l implements k {
    private final q dJM;
    private e diJ;

    public w(int i, String str) {
        this(i, str, "");
    }

    public w(int i, String str, String str2) {
        this.dJM = new b();
        v$a v_a = (v$a) this.dJM.KV();
        v_a.qXa.hbL = com.tencent.mm.model.q.GF();
        bkg bkg = v_a.qXa;
        StringBuilder stringBuilder = new StringBuilder();
        if (i == 0) {
            i = 64;
        }
        stringBuilder = stringBuilder.append(i).append(";");
        if (str == null) {
            str = "";
        }
        bkg.jSA = stringBuilder.append(str).toString();
        x.d("MicroMsg.NetSceneSendCard", "content:" + v_a.qXa.jSA);
        Assert.assertTrue("empty sendcard", true);
        v_a.qXa.rZh = 64;
        if (str2 != null && str2.length() > 0) {
            v_a.qXa.sjW = str2;
        }
    }

    public w(String str) {
        this.dJM = new b();
        v$a v_a = (v$a) this.dJM.KV();
        v_a.qXa.hbL = com.tencent.mm.model.q.GF();
        v_a.qXa.jSA = str;
        x.d("MicroMsg.NetSceneSendCard", "content:" + str);
        v_a.qXa.rKl = bi.f((Integer) g.Ei().DT().get(66561, null));
        Assert.assertTrue("empty sendcard", true);
        v_a.qXa.rZh = 128;
    }

    public w(String str, boolean z, boolean z2) {
        int i;
        this.dJM = new b();
        v$a v_a = (v$a) this.dJM.KV();
        v_a.qXa.hbL = com.tencent.mm.model.q.GF();
        v_a.qXa.jSA = str;
        x.d("MicroMsg.NetSceneSendCard", "content:" + str);
        v_a.qXa.rKl = bi.f((Integer) g.Ei().DT().get(66561, null));
        int i2 = ((z ? 1 : 0) | 0) | 0;
        if (z2) {
            i = 4;
        } else {
            i = 0;
        }
        i = (i | i2) | 8;
        Assert.assertTrue("empty sendcard", true);
        v_a.qXa.rZh = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 26;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, qVar.Id().qWD, this);
    }
}
