package com.tencent.mm.plugin.h.a.a;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends j {
    private byte hfq = (byte) 0;

    final boolean ac(byte[] bArr) {
        if (bi.bC(bArr)) {
            x.e("MicroMsg.exdevice.IBeaconTLVSectionA", "valueByte is null or nil");
            return false;
        } else if (2 != this.mLength) {
            x.d("MicroMsg.exdevice.IBeaconTLVSectionA", "IBEACON_TLV_SECTION_A_LENGTH != mLength(%d)", new Object[]{Integer.valueOf(this.mLength)});
            return false;
        } else {
            this.hfq = bArr[0];
            return true;
        }
    }
}
