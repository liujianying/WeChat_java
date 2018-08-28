package com.tencent.mm.plugin.exdevice.f.b;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.exdevice.f.a.f;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.l;
import com.tencent.mm.plugin.exdevice.f.a.m;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Assert;

public final class c implements e {
    public f iye;
    public f iyf;

    public c() {
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: constructing manager....");
        au.DF().a(1042, this);
        au.DF().a(1041, this);
        au.DF().a(1043, this);
        au.DF().a(1040, this);
    }

    public static void c(String str, String str2, String str3, int i) {
        au.DF().a(new l(str3, str2, i, str), 0);
    }

    public static ArrayList<d> Ad(String str) {
        ArrayList<d> arrayList = null;
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: getting like info...");
        if (bi.oW(str)) {
            x.w("MicroMsg.ExdeviceRankInfoManager", "hy: param error");
        } else {
            com.tencent.mm.plugin.exdevice.f.b.b.d aHf = ad.aHf();
            if (bi.oW(str)) {
                x.e("MicroMsg.ExdeviceRankInfoStg", "hy: param error");
            } else {
                String format = String.format("select *, rowid from %s where %s = ? order by %s desc", new Object[]{"HardDeviceRankInfo", "rankID", "score"});
                Cursor b = aHf.diF.b(format, new String[]{bi.aG(str, "")}, 2);
                if (b == null) {
                    x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                } else {
                    if (b.moveToFirst()) {
                        arrayList = new ArrayList();
                        do {
                            d dVar = new d();
                            dVar.d(b);
                            arrayList.add(dVar);
                        } while (b.moveToNext());
                    } else {
                        x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    }
                    b.close();
                }
            }
        }
        return arrayList;
    }

    public static void d(String str, ArrayList<d> arrayList) {
        com.tencent.mm.plugin.exdevice.f.b.b.d aHf = ad.aHf();
        Assert.assertTrue(!bi.oW(str));
        if (arrayList != null) {
            int i;
            Cursor b = aHf.diF.b(String.format("select COUNT(*) from %s where %s = ?", new Object[]{"HardDeviceRankInfo", "rankID"}), new String[]{bi.aG(str, "")}, 2);
            if (b == null) {
                x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                i = 0;
            } else {
                if (b.moveToFirst()) {
                    i = b.getInt(0);
                } else {
                    x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                    i = 0;
                }
                b.close();
            }
            Iterator it;
            if (i == 0) {
                it = arrayList.iterator();
                while (it.hasNext()) {
                    aHf.a((d) it.next(), false);
                }
                return;
            }
            it = arrayList.iterator();
            while (it.hasNext()) {
                aHf.b((d) it.next(), false);
            }
            return;
        }
        x.w("MicroMsg.ExdeviceRankInfoStg", "hy: data is null. abort insert");
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.d("MicroMsg.ExdeviceRankInfoManager", "hy: netscene back.err type: %d, err code: %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        if (lVar instanceof j) {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error.");
            }
        } else if (lVar instanceof l) {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        } else if (!(lVar instanceof m)) {
        } else {
            if (i != 0 || i2 != 0) {
                x.w("MicroMsg.ExdeviceRankInfoManager", "hy: scene error");
            }
        }
    }
}
