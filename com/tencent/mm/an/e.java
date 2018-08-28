package com.tencent.mm.an;

import com.tencent.mm.an.a.b;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.avq;
import com.tencent.mm.protocal.c.bsu;
import com.tencent.mm.y.g.a;

public final class e implements b {
    public final avq a(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        avq avq = new avq();
        avq.rYj = i;
        avq.rYo = str;
        avq.rYl = str2;
        avq.rYm = str3;
        avq.rYr = str4;
        avq.rYq = str5;
        avq.rYp = str6;
        avq.rYu = str8;
        avq.jQb = str11;
        avq.rYt = str9;
        avq.rsp = str7;
        avq.rYk = 0.0f;
        avq.rYn = str10;
        avq.rgC = 1;
        avq.rYs = null;
        avq.rvP = str7;
        return avq;
    }

    public final avq a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12) {
        avq avq = new avq();
        avq.rYj = 7;
        avq.rYo = str;
        avq.rYw = str2;
        avq.rYl = str3;
        avq.rYm = str4;
        avq.rYr = str5;
        avq.rYq = str6;
        avq.rYp = str7;
        avq.rYu = str9;
        avq.jQb = str12;
        avq.rYt = str10;
        avq.rsp = str8;
        avq.rYk = 0.0f;
        avq.rYn = str11;
        avq.rgC = 1;
        avq.rYs = null;
        avq.rvP = str8;
        return avq;
    }

    public final avq a(String str, bsu bsu, int i) {
        String str2 = null;
        if (bsu == null || bsu.sqc == null || bsu.sqc.ruA == null || bsu.sqc.ruA.size() <= 0) {
            return null;
        }
        ate ate = (ate) bsu.sqc.ruA.get(0);
        if (ate == null) {
            return null;
        }
        avq avq = new avq();
        avq.rYj = i;
        avq.rsp = bsu.ksA;
        avq.rYk = 0.0f;
        avq.rYn = "";
        avq.rYo = ate.rVE;
        avq.rYt = null;
        avq.rgC = 1;
        avq.rYs = null;
        avq.rYl = ate.bHD;
        avq.rYm = ate.jOS;
        if (bsu.sqc != null) {
            str2 = bsu.sqc.jPK;
        }
        avq.rYr = str2;
        avq.rYq = ate.rVI;
        avq.rYp = ate.jPK;
        avq.rYv = ate.rVF;
        avq.rvP = ate.ksA;
        avq.rYu = str;
        avq.jQb = bsu.sqb.ksA;
        avq.rYA = bsu.hbL;
        return avq;
    }

    public final avq a(a aVar, String str, String str2, String str3, String str4) {
        if (aVar == null) {
            return null;
        }
        avq avq = new avq();
        avq.rYj = 0;
        avq.rsp = str;
        avq.rYk = 0.0f;
        avq.rYn = "";
        avq.rYo = str2;
        avq.rYt = str4;
        avq.rgC = 1;
        avq.rYs = null;
        avq.rYl = aVar.title;
        avq.rYm = aVar.description;
        avq.rYr = aVar.url;
        avq.rYq = aVar.dwn;
        avq.rYp = aVar.dwN;
        avq.jQb = aVar.appId;
        avq.rYu = str3;
        return avq;
    }
}
