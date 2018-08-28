package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.x;

public abstract class j {
    protected byte hfx = (byte) 0;
    protected byte[] hfy = null;
    protected int mLength = -1;

    abstract boolean ac(byte[] bArr);

    public final boolean a(a aVar) {
        if (aVar.getSize() == 0) {
            x.w("MicroMsg.exdevice.TLVBase", "autoBuffer is null or nil");
            return false;
        }
        byte[] bArr = new byte[1];
        aVar.M(bArr, 1);
        byte b = bArr[0];
        if (b + 1 > aVar.getSize()) {
            x.w("MicroMsg.exdevice.TLVBase", "lengthInt(%d) + 1 > autoBuffer.getSize()(%d)", new Object[]{Integer.valueOf(b), Integer.valueOf(aVar.getSize())});
            return false;
        } else if (b <= (byte) 1) {
            x.w("MicroMsg.exdevice.TLVBase", "length(%d) <= 1", new Object[]{Integer.valueOf(b)});
            return false;
        } else {
            this.mLength = b;
            aVar.M(bArr, 1);
            this.hfx = bArr[0];
            this.hfy = new byte[(this.mLength - 1)];
            aVar.M(this.hfy, this.hfy.length);
            return ac(this.hfy);
        }
    }
}
