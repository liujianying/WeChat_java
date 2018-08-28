package com.tencent.mm.plugin.topstory;

import com.tencent.mm.g.a.os;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.plugin.topstory.a.c.a;
import com.tencent.mm.plugin.topstory.a.e;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.plugin.websearch.api.r;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.btf;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

public final class b implements e {
    private com.tencent.mm.ab.e dKj = new 2(this);
    private btf oyD;
    n oyE = new 1(this);
    a oyF;

    public b() {
        ((o) g.n(o.class)).getSysCmdMsgExtension().a("mmsearch_reddot_new", this.oyE);
        this.oyD = new btf();
        b(this.oyD);
        btf btf = this.oyD;
        String str = (String) g.Ei().DT().get(aa.a.sZB, "");
        if (!bi.oW(str)) {
            String[] split = str.split(",");
            if (split != null) {
                try {
                    if (split.length == 13) {
                        btf.bWQ = split[0];
                        btf.sqF = Integer.valueOf(split[1]).intValue();
                        btf.pMn = Integer.valueOf(split[2]).intValue();
                        btf.pMo = Integer.valueOf(split[3]).intValue();
                        btf.pMm = Integer.valueOf(split[4]).intValue();
                        btf.eiD = Long.valueOf(split[5]).longValue();
                        btf.pLn = Integer.valueOf(split[6]).intValue();
                        btf.sqG = Long.valueOf(split[7]).longValue();
                        btf.text = split[8];
                        btf.type = Integer.valueOf(split[9]).intValue();
                        btf.csE = Integer.valueOf(split[10]).intValue();
                        btf.sqE = Long.valueOf(split[11]).longValue();
                        btf.bWP = split[12];
                        return;
                    }
                } catch (Exception e) {
                    g.Ei().DT().a(aa.a.sZB, "");
                    return;
                }
            }
            g.Ei().DT().a(aa.a.sZB, "");
        }
    }

    public final boolean bHt() {
        int bHz = bHz();
        if (bHz == 0) {
            boolean z;
            JSONObject PX = r.PX("discoverRecommendEntry");
            if (((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RZ("labs_browse")) {
                if (((com.tencent.mm.plugin.welab.a.a.a) g.l(com.tencent.mm.plugin.welab.a.a.a.class)).RX("labs_browse")) {
                    z = true;
                }
                z = false;
            } else {
                if (PX.optInt("entrySwitch") == 1) {
                    z = true;
                }
                z = false;
            }
            x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "recommend show %b", new Object[]{Boolean.valueOf(z)});
            if (z) {
                return true;
            }
        } else if (bHz == -3) {
            ad.aS(14, this.oyD.bWQ);
            bHv();
        }
        return false;
    }

    public final void bHu() {
        if (bHt()) {
            x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "click red dot, report and clear red dot");
            ad.aS(12, this.oyD.bWQ);
            bHv();
        }
    }

    private void bHv() {
        this.oyD = new btf();
        b(this.oyD);
        g.Ei().DT().a(aa.a.sZB, "");
    }

    public final btf bHw() {
        return this.oyD;
    }

    public final void bHx() {
        if (this.oyD.csE != 1) {
            this.oyD.csE = 1;
            ad.aS(11, this.oyD.bWQ);
            bHy();
        }
    }

    public final void fu(long j) {
        x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "rec updateRedDotTimestamp %d", new Object[]{Long.valueOf(j)});
        g.Ei().DT().a(aa.a.sZA, Long.valueOf(j));
    }

    public final void a(btf btf) {
        if (!(this.oyD == null || bi.oW(this.oyD.bWQ) || this.oyD.csE == 1)) {
            switch (bHz()) {
                case IX5WebViewClient.ERROR_AUTHENTICATION /*-4*/:
                    ad.aS(13, this.oyD.bWQ);
                    break;
                case 0:
                    ad.aS(15, this.oyD.bWQ);
                    break;
            }
        }
        this.oyD = btf;
        bHy();
        ad.aS(10, this.oyD.bWQ);
        if (this.oyD.pMm == 3) {
            String optString = r.PX("discoverRecommendEntry").optString("wording");
            bte bte = new bte();
            bte.sqA = UUID.randomUUID().toString();
            bte.scene = 0;
            bte.fuu = "";
            bte.bHt = optString;
            optString = p.zK(0);
            bte.bJK = optString;
            bte.bWr = optString;
            ps psVar = new ps();
            psVar.aAL = "redPointMsgId";
            psVar.rtV = this.oyD.bWQ;
            bte.pKZ.add(psVar);
            psVar = new ps();
            psVar.aAL = "netType";
            psVar.rtV = p.bjC();
            bte.pKZ.add(psVar);
            psVar = new ps();
            psVar.aAL = "time_zone_min";
            psVar.rtV = String.valueOf(((-TimeZone.getDefault().getRawOffset()) / 1000) / 60);
            bte.pKZ.add(psVar);
            this.oyF = new a(bte);
            g.DF().a(this.oyF.getType(), this.dKj);
            g.DF().a(this.oyF, 0);
            return;
        }
        com.tencent.mm.sdk.b.a.sFg.m(new os());
    }

    private void bHy() {
        com.tencent.mm.storage.x DT = g.Ei().DT();
        aa.a aVar = aa.a.sZB;
        btf btf = this.oyD;
        DT.a(aVar, String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", new Object[]{btf.bWQ, Integer.valueOf(btf.sqF), Integer.valueOf(btf.pMn), Integer.valueOf(btf.pMo), Integer.valueOf(btf.pMm), Long.valueOf(btf.eiD), Integer.valueOf(btf.pLn), Long.valueOf(btf.sqG), btf.text, Integer.valueOf(btf.type), Integer.valueOf(btf.csE), Long.valueOf(btf.sqE), btf.bWP}));
    }

    static void b(btf btf) {
        btf.bWP = "";
        btf.bWQ = "";
        btf.text = "";
    }

    private int bHz() {
        int i = 1;
        if (bi.oW(this.oyD.bWQ)) {
            return -5;
        }
        if (this.oyD.sqF == 1) {
            return -1;
        }
        if (this.oyD.pMn > d.qVN) {
            x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s clientVersion %d invalid ,curVer is %d", new Object[]{this.oyD.bWQ, Integer.valueOf(this.oyD.pMn), Integer.valueOf(d.qVN)});
            return -2;
        }
        if (System.currentTimeMillis() > this.oyD.sqG + (this.oyD.eiD * 1000)) {
            x.i("MicroMsg.TopStory.TopStoryRedDotImpl", "msgid %s expired", new Object[]{this.oyD.bWQ});
            return -3;
        }
        boolean z;
        String str = "MicroMsg.TopStory.TopStoryRedDotImpl";
        String str2 = "h5 version valid ? %b, red.h5 %d, cur.h5 %s, red.timestamp %d, last rec.timestamp %d";
        Object[] objArr = new Object[5];
        if (p.zP(1) >= this.oyD.pLn) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.oyD.pLn);
        objArr[2] = Integer.valueOf(p.zP(1));
        objArr[3] = Long.valueOf(this.oyD.sqE);
        objArr[4] = Long.valueOf(bHA());
        x.i(str, str2, objArr);
        if (p.zP(1) < this.oyD.pLn || this.oyD.sqE <= bHA()) {
            i = 0;
        }
        if (i == 0) {
            return -4;
        }
        return 0;
    }

    private static long bHA() {
        Object obj = g.Ei().DT().get(aa.a.sZA, null);
        return obj == null ? 0 : ((Long) obj).longValue();
    }
}
