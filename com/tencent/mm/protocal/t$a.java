package com.tencent.mm.protocal;

import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.bi;

public class t$a extends d implements b {
    public byte[] bOK = null;
    public long eaP = -1;

    public final byte[] Ie() {
        Object obj = new byte[(this.bOK.length + 8)];
        int VF = (int) (bi.VF() - this.eaP);
        obj[0] = (byte) ((VF >> 24) & 255);
        obj[1] = (byte) ((VF >> 16) & 255);
        obj[2] = (byte) ((VF >> 8) & 255);
        obj[3] = (byte) (VF & 255);
        obj[4] = (byte) ((this.bOK.length >> 24) & 255);
        obj[5] = (byte) ((this.bOK.length >> 16) & 255);
        obj[6] = (byte) ((this.bOK.length >> 8) & 255);
        obj[7] = (byte) (this.bOK.length & 255);
        System.arraycopy(this.bOK, 0, obj, 8, this.bOK.length);
        bi.bB(obj);
        return obj;
    }

    public final int getCmdId() {
        return 1000000190;
    }

    public final int If() {
        return 268369922;
    }

    public final boolean LB() {
        return false;
    }
}
