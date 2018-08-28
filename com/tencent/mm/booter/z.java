package com.tencent.mm.booter;

import com.tencent.mm.platformtools.ai;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.w;
import java.util.HashSet;

public final class z {
    public static z cXH = new z();
    public w cXI = new w(aa.duN + "staytime.cfg");
    public c cXJ = new 1(this);
    public c cXK = new 2(this);
    public a cXL;
    public int cXM = 0;
    HashSet<Long> cXN = new HashSet();
    HashSet<Long> cXO = new HashSet();
    public long cXP;
    public long cXQ;
    public String cXR;
    public long cXS = -1;
    public int cXT = 20;
    public int cXU = 24;
    public int cXV = 30;
    public int cXW = 10800;
    public boolean hasInit = false;

    private z() {
    }

    public final void eG(String str) {
        a.sFg.c(this.cXJ);
        a.sFg.c(this.cXK);
        this.cXO.clear();
        this.cXN.clear();
        if (str == null || this.cXL == null) {
            boolean z;
            String str2 = "MicroMsg.StayTimeReport";
            String str3 = "exitChattingUI chatUser or reprotingItem is null, chatUser:%s, reportingItem is null:%b";
            Object[] objArr = new Object[2];
            objArr[0] = str;
            if (this.cXL == null) {
                z = true;
            } else {
                z = false;
            }
            objArr[1] = Boolean.valueOf(z);
            x.i(str2, str3, objArr);
        } else if (str.equals(this.cXL.cXY)) {
            a aVar = this.cXL;
            aVar.time += ai.bI(this.cXP) / 1000;
            this.cXI.set(5, ((String) this.cXI.get(5, "")) + this.cXL.toString());
            long j = this.cXI.getLong(4, 0);
            int Di = this.cXI.Di(6) + 1;
            this.cXI.setInt(6, Di);
            x.i("MicroMsg.StayTimeReport", "exitChattingUI, chatUser:%s, type:%d, stayTime:%d, stayWebTime:%d, chattingReportCnt:%d", new Object[]{this.cXL.cXY, Integer.valueOf(this.cXL.type), Long.valueOf(this.cXL.time), Integer.valueOf(this.cXL.cYc), Integer.valueOf(Di)});
            x.i("MicroMsg.StayTimeReport", "exitChattingUI goBackHistoryStatus:%d, recnCnt:%d, sendCnt:%d", new Object[]{Integer.valueOf(this.cXL.cYd), Integer.valueOf(this.cXL.cYe), Integer.valueOf(this.cXL.cYf)});
            if (ai.bG(j) > ((long) this.cXW) || Di > this.cXV) {
                Di = 1;
            } else {
                Di = 0;
            }
            if (Di != 0) {
                x.i("MicroMsg.StayTimeReport", "report （13062） %d: %s", new Object[]{Integer.valueOf(13062), ((String) this.cXI.get(5, "")) + "," + j + "," + ai.VE()});
                h.mEJ.k(13062, r0);
                this.cXI.setInt(6, 0);
                this.cXI.set(5, "");
            }
            this.cXL = null;
        } else {
            x.i("MicroMsg.StayTimeReport", "exitChattingUI no startedUI: %s, start:", new Object[]{str, this.cXL.cXY});
        }
    }
}
