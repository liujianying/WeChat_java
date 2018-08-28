package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.b.b;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blo;
import com.tencent.mm.protocal.c.blp;
import com.tencent.mm.sdk.platformtools.x;

public final class ak extends x {
    private int cmdId;
    private String qAA;

    public ak(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new blo();
        aVar.dIH = new blp();
        aVar.uri = "/cgi-bin/micromsg-bin/setappsetting";
        aVar.dIF = 396;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        blo blo = (blo) this.ivx.dID.dIL;
        blo.jPc = str;
        blo.sku = 0;
        blo.skv = str2;
        this.cmdId = 0;
        this.qAA = str2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i2 == 0) {
            blp blp = (blp) this.ivx.dIE.dIL;
            if (blp != null) {
                i bmk = com.tencent.mm.plugin.ac.a.a.a.bmm().bmk();
                f bl = g.bl(blp.jPc, false);
                if (bl != null) {
                    bl.field_authFlag = blp.rdF;
                    x.d("MicroMsg.NetSceneSetAppSetting", "onGYNetEnd, update ret = " + bmk.a(bl, new String[0]) + ", appId = " + blp.jPc);
                }
            }
        }
    }

    public final byte[] cbx() {
        try {
            return ((b) this.ivx.KV()).Ie();
        } catch (Exception e) {
            x.e("MicroMsg.NetSceneSetAppSetting", "toProtBuf failed: " + e.getMessage());
            return null;
        }
    }

    public final void bg(byte[] bArr) {
        if (bArr == null) {
            x.e("MicroMsg.NetSceneSetAppSetting", "buf is null");
            return;
        }
        try {
            this.ivx.dIE.G(bArr);
        } catch (Throwable e) {
            x.e("MicroMsg.NetSceneSetAppSetting", "parse error: " + e.getMessage());
            x.printErrStackTrace("MicroMsg.NetSceneSetAppSetting", e, "", new Object[0]);
        }
    }

    public final int getType() {
        return 2;
    }
}
