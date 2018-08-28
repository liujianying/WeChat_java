package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.shake.b.d;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.plugin.shake.d.a.a.a;
import com.tencent.mm.protocal.c.bhp;
import com.tencent.mm.protocal.c.bmo;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class j$1 implements a {
    final /* synthetic */ j mYU;

    j$1(j jVar) {
        this.mYU = jVar;
    }

    public final void b(bhp bhp, long j, boolean z) {
        if (j.a(this.mYU) == null) {
            x.w("Micromsg.ShakeMusicMgr", "shakeGetListener == null");
            return;
        }
        bmo bmo = (bmo) bhp;
        if (bmo == null) {
            x.w("Micromsg.ShakeMusicMgr", "resp null & return");
            j.a(this.mYU, new ArrayList());
        } else if (bmo.skR == 1) {
            long currentTimeMillis;
            if (j > j.b(this.mYU)) {
                currentTimeMillis = System.currentTimeMillis() - j;
            } else {
                currentTimeMillis = System.currentTimeMillis() - j.b(this.mYU);
            }
            if (bmo != null && !bi.oW(bmo.skT)) {
                boolean a;
                x.w("Micromsg.ShakeMusicMgr", "resCallback Type:%d, xml:%s", new Object[]{Integer.valueOf(bmo.skS), bmo.skT});
                String str = bmo.skT;
                if (str != null) {
                    str = str.trim();
                }
                switch (bmo.skS) {
                    case 0:
                        a = j.a(this.mYU, str);
                        break;
                    case 1:
                        a = j.b(this.mYU, str);
                        break;
                    case 2:
                        a = j.c(this.mYU, str);
                        break;
                    case 3:
                        a = j.d(this.mYU, str);
                        break;
                    case 4:
                        a = j.e(this.mYU, str);
                        break;
                    default:
                        x.w("Micromsg.ShakeMusicMgr", "parse unknown type:" + bmo.skS);
                        j.a(this.mYU, new ArrayList());
                        a = false;
                        break;
                }
                if (a) {
                    h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(1), Integer.valueOf((int) (System.currentTimeMillis() - j.b(this.mYU)))});
                    h.mEJ.e(835, 0, 1);
                    return;
                }
                h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(5), Long.valueOf(currentTimeMillis)});
                h.mEJ.e(835, 4, 1);
            } else if (z) {
                j.a(this.mYU, new ArrayList());
                h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(4), Integer.valueOf((int) currentTimeMillis)});
                h.mEJ.e(835, 3, 1);
            } else {
                j.a(this.mYU, new ArrayList());
                h.mEJ.h(10987, new Object[]{Integer.valueOf(1), "", Integer.valueOf(3), Integer.valueOf((int) currentTimeMillis)});
                h.mEJ.e(835, 2, 1);
            }
        } else {
            List arrayList = new ArrayList();
            if (bmo != null) {
                d dVar = new d();
                if (!(bmo.skN == null || bmo.skN.siK == null)) {
                    dVar.field_username = bmo.skN.siK.cfV();
                }
                if (!(bmo.skM == null || bmo.skM.siK == null)) {
                    dVar.field_nickname = bmo.skM.siK.cfV();
                }
                if (!(bmo.skN == null || bmo.skN.siK == null)) {
                    dVar.field_distance = bmo.skN.siK.cfV();
                }
                if (!(bmo.rKk == null || bmo.rKk.siK == null)) {
                    dVar.field_sns_bgurl = bmo.rKk.siK.cfV();
                }
                dVar.field_type = 4;
                dVar.field_insertBatch = 1;
                try {
                    dVar.field_lvbuffer = bmo.toByteArray();
                } catch (IOException e) {
                    x.w("Micromsg.ShakeMusicMgr", "insertItem, to lvbuf error [%s]", new Object[]{e.getLocalizedMessage()});
                }
                m.buC().a(dVar, true);
                arrayList.add(dVar);
            }
            j.c(this.mYU).d(arrayList, j);
        }
    }
}
