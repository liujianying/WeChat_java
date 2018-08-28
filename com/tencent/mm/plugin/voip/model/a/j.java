package com.tencent.mm.plugin.voip.model.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.protocal.c.byx;
import com.tencent.mm.protocal.c.cao;
import com.tencent.mm.protocal.c.cap;

public final class j extends n<cao, cap> {
    public j(long j, long j2, int i, String str, String str2, int i2, int i3, int[] iArr) {
        a aVar = new a();
        aVar.dIG = new cao();
        aVar.dIH = new cap();
        aVar.uri = "/cgi-bin/micromsg-bin/voipspeedresult";
        aVar.dIF = 901;
        aVar.dII = 901;
        aVar.dIJ = 1000000901;
        this.diG = aVar.KT();
        cao cao = (cao) this.diG.dID.dIL;
        cao.swW = j;
        cao.rxH = j2;
        cao.rth = i;
        cao.swX = new bhz().VO(str);
        cao.swY = new bhz().VO(str2);
        cao.rji = 0.0d;
        cao.rjj = 0.0d;
        cao.rxG = i2;
        cao.swZ = i3;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < i3) {
                bqo bqo = new bqo();
                i5 = i4 + 1;
                bqo.som = iArr[i4];
                i4 = i5 + 1;
                bqo.son = iArr[i5];
                i5 = i4 + 1;
                bqo.soo = iArr[i4];
                bqo.sop = new byx();
                int i7 = i5 + 1;
                bqo.sop.spR = iArr[i5];
                i4 = i7 + 1;
                bqo.sop.sed = iArr[i7];
                i5 = i4 + 1;
                bqo.soq = iArr[i4];
                i4 = i5 + 1;
                bqo.sor = iArr[i5];
                i5 = i4 + 1;
                bqo.sos = iArr[i4];
                i4 = i5 + 1;
                bqo.sot = iArr[i5];
                for (i5 = 0; i5 < bqo.sot; i5++) {
                    if (i4 < iArr.length) {
                        i7 = i4 + 1;
                        bqo.sou.add(Integer.valueOf(iArr[i4]));
                        i4 = i7;
                    }
                }
                if (i4 < iArr.length) {
                    i5 = i4 + 1;
                    bqo.sov = iArr[i4];
                    i4 = i5;
                }
                for (i5 = 0; i5 < bqo.sov; i5++) {
                    if (i4 < iArr.length) {
                        i7 = i4 + 1;
                        bqo.sow.add(Integer.valueOf(iArr[i4]));
                        i4 = i7;
                    }
                }
                if (i4 < iArr.length) {
                    i5 = i4 + 1;
                    bqo.sox = iArr[i4];
                    i4 = i5;
                }
                for (i5 = 0; i5 < bqo.sox; i5++) {
                    if (i4 < iArr.length) {
                        i7 = i4 + 1;
                        bqo.soy.add(Integer.valueOf(iArr[i4]));
                        i4 = i7;
                    }
                }
                com.tencent.mm.plugin.voip.b.a.eU("MicroMsg.NetSceneVoipSpeedResult", "SpeedResult: pkt_size[" + bqo.son + "], pkt_count[" + bqo.soo + "], svr_ip[" + bqo.sop.spR + "], avg_rtt[" + bqo.soq + "], min_rtt[" + bqo.sor + "], max_rtt[" + bqo.sos + "], rtt_count[" + bqo.sot + "], down_seq_count[" + bqo.sov + "], up_seq_count[" + bqo.sox + "]");
                cao.rIv.add(bqo);
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }

    public final int getType() {
        return 901;
    }

    public final e bLm() {
        return new 1(this);
    }
}
