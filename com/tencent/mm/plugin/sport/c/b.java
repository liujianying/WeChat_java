package com.tencent.mm.plugin.sport.c;

import android.os.Looper;
import com.tencent.mm.g.a.fh;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bn;
import java.util.Calendar;
import org.json.JSONObject;

public final class b {
    public c<qt> ooJ = new c<qt>() {
        {
            this.sFo = qt.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            qt qtVar = (qt) bVar;
            switch (qtVar.cbp.action) {
                case 1:
                case 2:
                case 3:
                    if (n.bFQ()) {
                        boolean ft;
                        long ciZ = bi.ciZ() / 10000;
                        long L = i.L(513, 0);
                        long L2 = i.L(512, 0);
                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(L);
                        instance.set(11, 0);
                        instance.set(12, 0);
                        instance.set(13, 0);
                        if (ciZ != instance.getTimeInMillis() / 10000) {
                            L2 = 0;
                        }
                        if (qtVar.cbp.action == 1) {
                            ft = b.this.ft(L2);
                            fh fhVar = new fh();
                            fhVar.bNx.action = 1;
                            a.sFg.a(fhVar, Looper.getMainLooper());
                        } else {
                            ft = n.F(b.this.bFG(), L2) ? b.this.ft(L2) : false;
                        }
                        x.i("MicroMsg.Sport.ExtApiStepManager", "upload step %d %d %b", new Object[]{Integer.valueOf(qtVar.cbp.action), Long.valueOf(L2), Boolean.valueOf(ft)});
                        break;
                    }
                    break;
            }
            return false;
        }
    };
    public f ooK;
    public c ooQ = new 1(this);
    private long ooR;
    private long ooS;

    public b() {
        this.ooQ.cht();
        this.ooJ.cht();
    }

    final boolean i(com.tencent.mm.sdk.b.b bVar) {
        fh fhVar = (fh) bVar;
        switch (fhVar.bNx.action) {
            case 2:
                int i;
                long j = fhVar.bNx.bNA;
                long currentTimeMillis = System.currentTimeMillis();
                long j2 = fhVar.bNx.bNB;
                com.tencent.mm.g.a.fh.b bVar2 = fhVar.bNy;
                if (!n.bFv()) {
                    i = 3906;
                } else if (n.bFQ()) {
                    long L = i.L(513, 0);
                    long L2 = i.L(512, 0);
                    x.v("MicroMsg.Sport.ExtApiStepManager", "lastUpdateTime:%d lastUpdateStep:%d newUpdateTime:%d newUpdateStep:%d", new Object[]{Long.valueOf(L), Long.valueOf(L2), Long.valueOf(currentTimeMillis), Long.valueOf(j)});
                    if (currentTimeMillis - L < 300000) {
                        x.w("MicroMsg.Sport.ExtApiStepManager", "update interval must larger than 5 minute");
                        i = 3903;
                    } else {
                        JSONObject bFJ = g.bFJ();
                        if (!bi.u(currentTimeMillis, L)) {
                            L = bi.ciZ();
                            L2 = 0;
                        }
                        long j3 = currentTimeMillis - L;
                        x.v("MicroMsg.Sport.ExtApiStepManager", "interval5m %d intervalTime %d newUpdateTime:%d compareUpdateTime:%d maxIncreaseStep:%d", new Object[]{Long.valueOf((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))), Long.valueOf(j3), Long.valueOf(currentTimeMillis), Long.valueOf(L), Long.valueOf(((long) bFJ.optInt("stepCounterMaxStep5m")) * ((j3 / 300000) + ((long) (j3 % 300000 > 0 ? 1 : 0))))});
                        L2 = j - L2;
                        if (L2 < 0 || L2 > r14) {
                            x.w("MicroMsg.Sport.ExtApiStepManager", "invalid step in 5 minute actual: %d max: %d", new Object[]{Long.valueOf(L2), Long.valueOf(r14)});
                            i = 3904;
                        } else {
                            x.i("MicroMsg.Sport.ExtApiStepManager", "can update time: %s, step: %d", new Object[]{n.bx(currentTimeMillis), Long.valueOf(j)});
                            i.M(513, currentTimeMillis);
                            i.M(512, j);
                            i.M(514, j2);
                            i = 1;
                        }
                    }
                } else {
                    i = 3902;
                }
                bVar2.bNE = i;
                if (fhVar.bNy.bNE == 1) {
                    if (this.ooR == 0) {
                        this.ooR = i.L(515, 0);
                    }
                    boolean E = n.E(this.ooR, System.currentTimeMillis());
                    boolean F = n.F(bFG(), j);
                    if (E && F) {
                        ft(j);
                    }
                }
                fhVar.bNy.bND = true;
                break;
            case 3:
                try {
                    JSONObject optJSONObject = g.bFJ().optJSONObject("extStepApiConfig");
                    if (optJSONObject != null) {
                        fhVar.bNy.bNC = optJSONObject.toString();
                    }
                    if (bi.oW(fhVar.bNy.bNC)) {
                        fhVar.bNy.bNE = 3905;
                    } else {
                        fhVar.bNy.bNE = 1;
                    }
                } catch (Exception e) {
                    fhVar.bNy.bNE = 3905;
                }
                fhVar.bNy.bND = true;
                break;
        }
        return true;
    }

    final boolean ft(long j) {
        if (this.ooK != null) {
            g.DF().c(this.ooK);
        }
        long currentTimeMillis = System.currentTimeMillis();
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        x.i("MicroMsg.Sport.ExtApiStepManager", "update Api Step time: %s stepCount: %s", new Object[]{n.bx(currentTimeMillis), Long.valueOf(j)});
        this.ooK = new f("", "gh_43f2581f6fd6", (int) (instance.getTimeInMillis() / 1000), (int) (currentTimeMillis / 1000), (int) j, bn.cmZ(), 2);
        g.DF().a(this.ooK, 0);
        this.ooR = currentTimeMillis;
        i.M(515, currentTimeMillis);
        this.ooS = j;
        i.L(516, this.ooS);
        return true;
    }

    public final long bFG() {
        if (this.ooS == 0) {
            this.ooS = i.L(516, 0);
        }
        return this.ooS;
    }
}
