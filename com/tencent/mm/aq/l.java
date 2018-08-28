package com.tencent.mm.aq;

import com.tencent.mm.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.a.h.b;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;

@Deprecated
public final class l extends b {
    private auy ecl;

    public l(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, String str9, String str10) {
        super(1);
        this.ecl = new auy();
        this.ecl.rXT = 2048;
        this.ecl.rvi = new bhz().VO(bi.oV(str));
        this.ecl.rQz = new bhz().VO(bi.oV(str2));
        this.ecl.ray = 0;
        this.ecl.rXU = new bhz().VO(bi.oV(str3));
        this.ecl.rXV = new bhz().VO(bi.oV(str4));
        this.ecl.hcd = 0;
        byte[] e = e.e(bi.oV(str5), 0, -1);
        this.ecl.rXR = new com.tencent.mm.bk.b(e == null ? new byte[0] : e);
        this.ecl.rXQ = e == null ? 0 : e.length;
        this.ecl.eJH = 0;
        this.ecl.eJL = 0;
        this.ecl.eJK = bi.oV(str6);
        this.ecl.eJJ = bi.oV(str7);
        this.ecl.eJI = bi.oV(str8);
        this.ecl.raB = i;
        this.ecl.rTg = bi.oV(str9);
        this.ecl.rYa = 0;
        this.ecl.eJM = bi.oV(str10);
        this.ecl.rTi = 0;
        this.ecl.rTh = "";
        this.lcH = this.ecl;
    }
}
