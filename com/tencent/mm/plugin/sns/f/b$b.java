package com.tencent.mm.plugin.sns.f;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.sdk.platformtools.x;

class b$b {
    long egG;
    StringBuffer ntT = new StringBuffer();
    String ntU;
    long ntV;
    long ntW;
    String ntX;
    String ntY;

    public b$b(long j, String str, String str2, String str3, String str4) {
        this.ntU = str;
        this.ntX = str2;
        this.ntY = str3;
        this.egG = j;
        this.ntV = System.currentTimeMillis();
        this.ntT.append("1:0:" + str4);
    }

    public b$b(long j, String str, String str2, String str3) {
        this.ntU = str;
        this.ntX = str2;
        this.ntY = str3;
        this.egG = j;
        this.ntV = System.currentTimeMillis();
        this.ntT.append("0:0:");
    }

    public final void MM(String str) {
        x.d("MicroMsg.AdNotLikeAbTestHelper", "addactionResult " + str);
        if (this.ntT.length() != 0) {
            this.ntT.append("|");
        }
        this.ntT.append(str);
    }

    public final void xP() {
        this.ntW = System.currentTimeMillis();
        x.d("MicroMsg.AdNotLikeAbTestHelper", "report abtestnotlike " + this.egG + " uxinfo:" + this.ntU + " actionresult: " + this.ntT + " " + this.ntV + " " + this.ntW);
        h.mEJ.h(11988, new Object[]{this.ntY, this.ntX, "", "", i.eF(this.egG), this.ntU, this.ntT, Long.valueOf(this.ntV / 1000), Long.valueOf(this.ntW / 1000)});
    }
}
