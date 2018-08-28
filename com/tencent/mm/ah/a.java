package com.tencent.mm.ah;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.ab.l.b;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import junit.framework.Assert;

public final class a extends l implements k {
    private bd bGS = new bd();
    private e diJ;
    private ag handler = new 1(this);

    public a(String str, String str2) {
        boolean z = true;
        this.bGS.setStatus(1);
        this.bGS.ep(str);
        this.bGS.ay(com.tencent.mm.model.bd.iD(str));
        this.bGS.eX(1);
        this.bGS.setContent(str2);
        this.bGS.setType(s.hQ(str));
        au.HU();
        long T = c.FT().T(this.bGS);
        if (T == -1) {
            z = false;
        }
        Assert.assertTrue(z);
        x.i("MicroMsg.NetSceneSendMsgFake", "new msg inserted to db , local id = " + T);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneSendMsgFake", "send local msg, msgId = " + this.bGS.field_msgId);
        this.handler.sendEmptyMessageDelayed(0, 500);
        return 999;
    }

    public final int getType() {
        return 522;
    }

    protected final int a(q qVar) {
        return b.dJm;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendMsgFake", "recv local msg, msgId = " + this.bGS.field_msgId);
        this.bGS.setStatus(2);
        this.bGS.ay(com.tencent.mm.model.bd.o(this.bGS.field_talker, System.currentTimeMillis() / 1000));
        au.HU();
        c.FT().a(this.bGS.field_msgId, this.bGS);
        this.diJ.a(0, 0, str, this);
    }
}
