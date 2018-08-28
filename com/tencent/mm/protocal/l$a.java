package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.gt;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class l$a extends d implements b {
    public int netType;
    public int qWE = 0;

    public final byte[] Ie() {
        gt gtVar = new gt();
        gtVar.rgt = d.qVN;
        gtVar.rgY = 2;
        gtVar.rgZ = this.netType;
        gtVar.rha = this.qWE;
        x.i("MicroMsg.MMBgFg", "somr online:%d nettype:%d ver:%d devid:%d", new Object[]{Integer.valueOf(gtVar.rha), Integer.valueOf(gtVar.rgZ), Integer.valueOf(gtVar.rgt), Integer.valueOf(gtVar.rgY)});
        byte[] bArr = null;
        try {
            return gtVar.toByteArray();
        } catch (Throwable e) {
            x.e("MicroMsg.MMBgFg", "MMBgfg toProtoBuf exception:%s", new Object[]{bi.i(e)});
            return bArr;
        }
    }

    public final int If() {
        return 0;
    }

    public final int getCmdId() {
        return 312;
    }

    public final boolean cgo() {
        return true;
    }

    public final boolean LB() {
        return false;
    }
}
