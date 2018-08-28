package com.tencent.mm.ak;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;
import com.tencent.mm.ak.l.b;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.g.c.cm;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class i implements e, f {
    private static Set<Integer> dUV = new HashSet();
    private Queue<e> bFd = new LinkedList();
    private boolean bFh = false;
    private boolean bFi = false;
    int bFj = 0;
    private long bFk = 0;
    a bFn = new a();
    private al bFo;
    private LinkedList<l> dUW = new LinkedList();
    public a dUX = null;
    private boolean dUY = false;
    private l.a dUZ = new 1(this);

    static /* synthetic */ void e(i iVar) {
        e eVar;
        iVar.bFk = System.currentTimeMillis();
        if (!iVar.bFh && iVar.bFd.size() == 0) {
            g Pf = o.Pf();
            Cursor b = Pf.dCZ.b(("select * " + " FROM ImgInfo2") + " WHERE iscomplete= 0 AND totalLen != 0 ", null, 0);
            int count = b.getCount();
            x.d("MicroMsg.ImgInfoStorage", "getUnfinishInfo resCount:" + count);
            List list;
            if (count == 0) {
                b.close();
                list = null;
            } else {
                list = new ArrayList();
                for (int i = 0; i < count; i++) {
                    b.moveToPosition(i);
                    e eVar2 = new e();
                    eVar2.d(b);
                    e hR = Pf.hR((int) eVar2.dTK);
                    if (hR != null) {
                        if (hR.bYu != 0 || hR.dTS != 0) {
                            list.add(eVar2);
                        }
                    } else if (eVar2.bYu != 0 || eVar2.dTS != 0) {
                        list.add(eVar2);
                    }
                }
                b.close();
            }
            if (list == null || list.size() == 0) {
                x.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (e eVar3 : list) {
                    if (bi.oW(eVar3.dTL)) {
                        x.i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        e hR2 = o.Pf().hR((int) eVar3.dTK);
                        if (dUV.contains(Integer.valueOf(hR2 == null ? (int) eVar3.dTK : (int) hR2.dTK))) {
                            x.d("MicroMsg.ImgService", "File is Already running:" + eVar3.dTK);
                        } else if (hR2 == null ? eVar3.dTS <= 0 || eVar3.bYu > 0 || eVar3.offset > eVar3.dHI || eVar3.status == -1 : hR2.dTS <= 0 || hR2.bYu > 0 || eVar3.offset > eVar3.dHI || eVar3.status == -1 || hR2.status == -1) {
                            if (((long) (eVar3.dTR + 600)) < bi.VE()) {
                                hU((int) eVar3.dTK);
                            } else {
                                iVar.bFd.add(eVar3);
                            }
                        }
                    }
                }
                iVar.bFd.size();
            }
        }
        if (iVar.bFh || iVar.bFd.size() > 0) {
            eVar3 = null;
            if (!iVar.bFh && iVar.bFd.size() > 0) {
                e hR3;
                while (iVar.bFd.size() > 0) {
                    eVar3 = (e) iVar.bFd.poll();
                    hR3 = o.Pf().hR((int) eVar3.dTK);
                    if (dUV.contains(Integer.valueOf(hR3 == null ? (int) eVar3.dTK : (int) hR3.dTK))) {
                        eVar3 = null;
                    }
                }
                iVar.bFh = true;
                if (eVar3 != null && eVar3.dTK > 0) {
                    l lVar;
                    hR3 = o.Pf().hR((int) eVar3.dTK);
                    if (hR3 != null) {
                        x.d("MicroMsg.ImgService", "try upload hdinfo ");
                        lVar = new l((int) hR3.dTK, 1);
                    } else {
                        x.d("MicroMsg.ImgService", "try upload normalinfo ");
                        lVar = new l((int) eVar3.dTK, 0);
                    }
                    g.Eh().dpP.a(lVar, 0);
                    return;
                }
                return;
            }
            return;
        }
        iVar.wx();
        x.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
    }

    public static boolean hS(int i) {
        return dUV.add(Integer.valueOf(i));
    }

    public static boolean hT(int i) {
        return dUV.remove(Integer.valueOf(i));
    }

    public i() {
        g.Ek();
        this.bFo = new al(g.Em().lnJ.getLooper(), new 5(this), false);
        if (g.Eh().dpP != null) {
            g.Eh().dpP.a(s$l.AppCompatTheme_spinnerStyle, this);
        }
        this.dUW.clear();
        this.dUY = false;
    }

    public final void a(String str, String str2, ArrayList<String> arrayList, int i, boolean z, int i2) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str3 = (String) it.next();
            x.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", new Object[]{Boolean.valueOf(z), Integer.valueOf(q.a(str3, str2, z) ? 1 : 0)});
            a(new l(str, str2, str3, r4, this, i, this.dUZ, i2));
        }
    }

    public final void a(ArrayList<Integer> arrayList, String str, String str2, ArrayList<String> arrayList2, int i, boolean z, int i2) {
        int i3 = 0;
        Iterator it = arrayList2.iterator();
        while (true) {
            int i4 = i3;
            if (it.hasNext()) {
                String str3 = (String) it.next();
                int intValue = ((Integer) arrayList.get(i4)).intValue();
                i3 = i4 + 1;
                int i5 = q.a(str3, str2, z) ? 1 : 0;
                String str4 = "";
                e hQ = o.Pf().hQ(intValue);
                if (hQ != null) {
                    str4 = hQ.dTV;
                }
                l lVar = new l((long) intValue, str, str2, str3, i5, this, i, str4, "", i2);
                lVar.dVF = new b(lVar, this.dUZ);
                a(lVar);
            } else {
                return;
            }
        }
    }

    private void a(l lVar) {
        g.Ek();
        g.Em().H(new 2(this, lVar));
    }

    public static void hU(int i) {
        x.w("MicroMsg.ImgService", "setImgError, %d", new Object[]{Integer.valueOf(i)});
        e hQ = o.Pf().hQ(i);
        if (hQ != null && hQ.dTK > 0) {
            cm dW;
            e hR = o.Pf().hR((int) hQ.dTK);
            if (hR != null) {
                hR.setStatus(-1);
                hR.bWA = 264;
                o.Pf().a((int) hR.dTK, hR);
                dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(hR.dTS);
            } else {
                hQ.setStatus(-1);
                hQ.bWA = 264;
                o.Pf().a(i, hQ);
                dW = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().dW(hQ.dTS);
            }
            if (dW.field_msgId == hQ.dTS) {
                dW.setStatus(5);
                com.tencent.mm.plugin.report.f.mDy.a(111, 31, 1, true);
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).bcY().a((long) ((int) dW.field_msgId), dW);
            }
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.d("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (lVar instanceof l) {
            l lVar2 = (l) lVar;
            if (!(this.dUX == null || lVar2 == null || lVar2.bGS == null)) {
                this.dUX.h(lVar2.bGS.field_msgId, lVar2.bGS.field_status != 5);
            }
        }
        g.Ek();
        g.Em().H(new 3(this, lVar));
    }

    private void wx() {
        this.bFd.clear();
        this.bFi = false;
        x.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.bFn.Ad());
    }

    public final void run() {
        g.Ek();
        g.Em().H(new 4(this));
    }

    public final void a(int i, int i2, l lVar) {
        l lVar2 = (l) lVar;
        if (this.dUX != null && lVar2 != null && lVar2.bGS != null) {
            this.dUX.b(lVar2.bGS.field_msgId, i, i2);
        }
    }
}
