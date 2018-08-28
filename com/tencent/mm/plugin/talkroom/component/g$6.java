package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.sdk.platformtools.bd;

class g$6 extends bd<byte[]> {
    final /* synthetic */ String hMX;
    final /* synthetic */ int[] ovH;
    final /* synthetic */ g ovy;

    g$6(g gVar, int[] iArr, String str) {
        this.ovy = gVar;
        this.ovH = iArr;
        this.hMX = str;
        super(3000, null, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        PByteArray pByteArray = new PByteArray();
        this.ovH[0] = g.a(this.ovy).GetStatis(pByteArray, this.hMX);
        return pByteArray.value;
    }
}
