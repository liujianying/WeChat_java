package com.tencent.mm.ai;

import android.os.Looper;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.report.f;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.byf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;

class c$4 implements a {
    final /* synthetic */ c dST;

    c$4(c cVar) {
        this.dST = cVar;
    }

    public final boolean vD() {
        if (this.dST.dSN.isEmpty()) {
            x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , wait doscene!");
            return false;
        }
        boolean z;
        int i;
        int intValue;
        long VF = bi.VF();
        int i2 = this.dST.dGS ? 5 : 15;
        ArrayList arrayList = new ArrayList(i2 * 2);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 < i2) {
                c.a aVar = (c.a) this.dST.dSN.peek();
                if (aVar == null) {
                    x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler queue maybe this time is null , break and wait doscene!");
                    z = false;
                } else {
                    LinkedList linkedList = aVar.dSZ.rHc;
                    LinkedList linkedList2 = aVar.dSZ.rHd;
                    i = aVar.dTa;
                    if (linkedList.size() <= i) {
                        this.dST.dSN.poll();
                        if (this.dST.dSN.isEmpty()) {
                            x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is empty break", new Object[]{Integer.valueOf(i), Integer.valueOf(r8)});
                            this.dST.dSO = 0;
                            this.dST.dSR.J(0, 0);
                            z = false;
                        } else {
                            x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler resp proc fin gr.curIdx:%d size:%d and retList is not empty continue next", new Object[]{Integer.valueOf(i), Integer.valueOf(r8)});
                        }
                    } else {
                        aue aue = (aue) linkedList.get(i);
                        intValue = ((Integer) linkedList2.get(i)).intValue();
                        String aG = bi.aG(ab.a(aue.rvi), "");
                        String aG2 = bi.aG(aue.eJM, "");
                        arrayList.add(aG);
                        arrayList.add(aG2);
                        switch (intValue) {
                            case -477:
                                z = d.OK().lE(aG);
                                boolean lE = d.OK().lE(aG2);
                                boolean gE = m.gE(aG);
                                x.e("MicroMsg.GetContactService", "respHandler getFailed USERNAME_INVAILD :%d ErrName: %s %s %s %s %s", new Object[]{Integer.valueOf(intValue), aG, aG2, Boolean.valueOf(z), Boolean.valueOf(lE), Boolean.valueOf(gE)});
                                f.mDy.a(832, 1, 1, false);
                                z = false;
                                break;
                            case 0:
                                String aG3;
                                if (aVar.dSZ.rHe != null && aVar.dSZ.rHe.size() > i) {
                                    if (aG.equals(((byf) aVar.dSZ.rHe.get(i)).username)) {
                                        aG3 = bi.aG(((byf) aVar.dSZ.rHe.get(i)).sup, "");
                                        x.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[]{aG, aG2, aG3});
                                        b.ezo.a(aue, aG3);
                                        f.mDy.a(832, 0, 1, false);
                                        z = true;
                                        break;
                                    }
                                }
                                String str = "MicroMsg.GetContactService";
                                String str2 = "get antispamticket from resp failed: list:%s idx:%d  user:%s";
                                Object[] objArr = new Object[3];
                                if (aVar.dSZ.rHe == null) {
                                    aG3 = "null";
                                } else {
                                    aG3 = Integer.valueOf(aVar.dSZ.rHe.size());
                                }
                                objArr[0] = aG3;
                                objArr[1] = Integer.valueOf(i);
                                objArr[2] = aG;
                                x.w(str, str2, objArr);
                                aG3 = "";
                                x.i("MicroMsg.GetContactService", "dkverify respHandler mod contact: %s %s %s", new Object[]{aG, aG2, aG3});
                                b.ezo.a(aue, aG3);
                                f.mDy.a(832, 0, 1, false);
                                z = true;
                            default:
                                z = m.gE(aG);
                                x.e("MicroMsg.GetContactService", "respHandler getFailed :%d ErrName: %s %s %s", new Object[]{Integer.valueOf(intValue), aG, aG2, Boolean.valueOf(z)});
                                f.mDy.a(832, 2, 1, false);
                                z = false;
                                break;
                        }
                        new ag(Looper.getMainLooper()).post(new 1(this, aG, aG2, z));
                        aVar.dTa++;
                    }
                    i3 = i4 + 1;
                }
            } else {
                z = true;
            }
        }
        i = arrayList.size();
        if (i > 0) {
            au.HU();
            long dO = c.FO().dO(Thread.currentThread().getId());
            b OK = d.OK();
            for (intValue = 0; intValue < i; intValue++) {
                OK.lE((String) arrayList.get(intValue));
            }
            au.HU();
            c.FO().gp(dO);
        }
        x.i("MicroMsg.GetContactService", "tryStartNetscene respHandler onTimerExpired netSceneRunning : " + this.dST.dGS + " ret: " + z + " maxCnt: " + i2 + " deleteCount: " + i + " take: " + (bi.VF() - VF) + "ms");
        return z;
    }
}
