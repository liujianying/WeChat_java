package com.tencent.mm.plugin.websearch.api;

import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.x;

public class ac$a {
    public String bWP;
    public int clear;
    public long eaP = System.currentTimeMillis();
    public String id;
    public long kSz;
    public int pLn;
    public int pMm;
    public int pMn;
    public int pMo;
    int pMp;
    public String text;
    public long timestamp;
    public int type;

    public final boolean isValid() {
        if (this.clear == 1) {
            return false;
        }
        if (this.pMn > d.qVN) {
            x.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s clientVersion %d invalid ,curVer is %d", this.id, Integer.valueOf(this.pMn), Integer.valueOf(d.qVN));
            return false;
        }
        int i;
        boolean i2;
        if (System.currentTimeMillis() > this.eaP + (this.kSz * 1000)) {
            i2 = 1;
        } else {
            i2 = false;
        }
        if (i2 != 0) {
            x.i("MicroMsg.WebSearch.WebSearchRedPointMgr", "msgid %s expired", this.id);
            return false;
        }
        String str = "MicroMsg.WebSearch.WebSearchRedPointMgr";
        String str2 = this.pMm + "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
        Object[] objArr = new Object[5];
        if (p.zP(0) >= this.pLn) {
            i2 = true;
        } else {
            i2 = false;
        }
        objArr[0] = Boolean.valueOf(i2);
        objArr[1] = Integer.valueOf(this.pLn);
        objArr[2] = Integer.valueOf(p.zP(0));
        objArr[3] = Long.valueOf(this.timestamp);
        objArr[4] = Long.valueOf(ac.bTi());
        x.i(str, str2, objArr);
        if (p.zP(0) < this.pLn || this.timestamp <= ac.bTi()) {
            return false;
        }
        return true;
    }
}
