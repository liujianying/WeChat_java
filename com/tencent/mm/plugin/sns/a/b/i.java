package com.tencent.mm.plugin.sns.a.b;

import android.database.Cursor;
import android.os.SystemClock;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.q;
import com.tencent.mm.protocal.c.apz;
import com.tencent.mm.protocal.c.bow;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public final class i implements e {
    public static int njA = 1800;
    public static int njB = 43200;
    public static int njw = 20480;
    public static int njx = 30720;
    public static int njy = 51200;
    public static int njz = 60;
    private long njC = 0;
    private bow njD = new bow();
    private boolean njE = false;
    private long njF = 0;
    private int njG = 0;
    private int njv = 0;
    private Random random = new Random(System.currentTimeMillis());

    static /* synthetic */ void d(i iVar) {
        if (iVar.njD.rbN.size() > 0) {
            x.i("MicroMsg.SnsLogMgr", "trigerSave " + iVar.njD.rbN.size());
            af.byh().a(iVar.njD);
            iVar.njD.rbN.clear();
        }
    }

    static /* synthetic */ void e(i iVar) {
        int i;
        String str;
        int i2;
        if (bi.bI(iVar.njF) >= 100 || iVar.njG <= 0) {
            iVar.njG = njw;
            if (ao.isWifi(ad.getContext())) {
                iVar.njG = njy;
            }
            if (ao.is3G(ad.getContext()) || ao.is4G(ad.getContext())) {
                iVar.njG = njx;
            }
            if (ao.is2G(ad.getContext())) {
                iVar.njG = njw;
            }
            iVar.njF = SystemClock.elapsedRealtime();
            i = iVar.njG;
        } else {
            i = iVar.njG;
        }
        List linkedList = new LinkedList();
        bow dz = af.byh().dz(i, iVar.njv);
        apz apz;
        if (dz.rbN.size() == 0) {
            str = "read from memery";
            i2 = 0;
            while (iVar.njD.rbN.size() > 0) {
                apz = (apz) iVar.njD.rbN.remove();
                if (apz.rSu.lR.length + i2 >= i) {
                    break;
                }
                i2 += apz.rSu.lR.length;
                linkedList.add(apz);
            }
        } else {
            str = "read from db";
            i2 = 0;
            while (dz.rbN.size() > 0) {
                apz = (apz) dz.rbN.remove();
                linkedList.add(apz);
                i2 = apz.rSu.lR.length + i2;
            }
        }
        String str2 = str;
        if (linkedList.size() == 0) {
            x.i("MicroMsg.SnsLogMgr", "nothing for report");
            return;
        }
        x.i("MicroMsg.SnsLogMgr", "size " + i2 + " " + linkedList.size() + " " + i + " logItemList.LogList.size  " + iVar.njD.rbN.size() + " label:  " + str2);
        e eVar = new e(linkedList);
        g.Ek();
        g.Eh().dpP.a(eVar, 0);
    }

    public final void h(int i, Object... objArr) {
        af.byb().post(new 1(this, i, objArr));
        if (!this.njE) {
            this.njE = true;
            af.byb().postDelayed(new Runnable() {
                public final void run() {
                    i.this.njE = false;
                    i.this.bwP();
                }
            }, 2000);
        }
    }

    public final void bwP() {
        if (af.npv) {
            g.Ek();
            int intValue = ((Integer) g.Ei().DT().get(a.sQJ, Integer.valueOf(0))).intValue();
            g.Ek();
            int intValue2 = ((Integer) g.Ei().DT().get(a.sQI, Integer.valueOf(-1))).intValue();
            if (intValue2 > njB || intValue2 < 0) {
                intValue2 = this.random.nextInt((njA - njz) + 1) + njz;
            }
            if ((System.currentTimeMillis() / 1000) - ((long) intValue) > ((long) intValue2)) {
                intValue2 = 1;
            } else {
                intValue2 = 0;
            }
            if (intValue2 == 0) {
                bwQ();
                x.d("MicroMsg.SnsLogMgr", "pass report ");
                return;
            }
            q byh = af.byh();
            String str = "select rowid from SnsReportKv order by rowid desc  limit 1";
            x.i("MicroMsg.SnsKvReportStg", " getLast " + str);
            Cursor b = byh.dCZ.b(str, null, 2);
            if (b.moveToFirst()) {
                intValue2 = b.getInt(0);
            } else {
                intValue2 = 0;
            }
            b.close();
            this.njv = intValue2;
            bwR();
            bwQ();
        }
    }

    private void bwQ() {
        af.byb().post(new 3(this));
    }

    private void bwR() {
        af.byb().post(new 4(this));
    }

    public static String n(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            x.w("MicroMsg.SnsLogMgr", "vals is null, use '' as value");
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = objArr.length - 1;
        for (int i = 0; i < length; i++) {
            stringBuilder.append(String.valueOf(objArr[i])).append(',');
        }
        stringBuilder.append(String.valueOf(objArr[length]));
        return stringBuilder.toString();
    }

    public final void a(int i, int i2, String str, l lVar) {
        if (lVar.getType() == 1802 && (lVar instanceof e)) {
            e eVar = (e) lVar;
            if (i == 0 && i2 == 0) {
                g.Ek();
                g.Ei().DT().a(a.sQJ, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
                bwR();
                return;
            }
            List<apz> list = eVar.gxs;
            q byh = af.byh();
            bow bow = new bow();
            for (apz add : list) {
                bow.rbN.add(add);
            }
            byh.a(bow);
        }
    }
}
