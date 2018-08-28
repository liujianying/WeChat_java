package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.plugin.exdevice.j.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Arrays;

public final class h extends j {
    private static final byte[] hfr = new byte[]{(byte) 76, (byte) 0, (byte) 2, (byte) 21};
    private byte[] hfs = null;
    public byte[] hft = null;
    public short hfu = (short) -1;
    public short hfv = (short) -1;
    public int hfw = 0;

    final boolean ac(byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconTLVSectionB", "valueByte is null or nil");
            return false;
        } else if (26 != this.mLength) {
            x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "IBEACON_TLV_SECTION_B_LENGTH != mLength(%d) ", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            a aVar = new a(bArr.length);
            aVar.N(bArr, bArr.length);
            byte[] bArr2 = new byte[4];
            aVar.M(bArr2, 4);
            if (Arrays.equals(bArr2, hfr)) {
                this.hfs = bArr2;
                this.hft = new byte[16];
                aVar.M(this.hft, 16);
                try {
                    this.hfu = aVar.readShort();
                    this.hfv = aVar.readShort();
                    bArr2 = new byte[1];
                    aVar.M(bArr2, 1);
                    this.hfw = bArr2[0];
                    return true;
                } catch (Throwable e) {
                    x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Read major/minor from autobuffer failed!!!");
                    x.printErrStackTrace("MicroMsg.exdevice.IBeaconTLVSectionB", e, "", new Object[0]);
                    return false;
                }
            }
            x.d("MicroMsg.exdevice.IBeaconTLVSectionB", "Cannot find ibeacon cookies!!!");
            return false;
        }
    }
}
