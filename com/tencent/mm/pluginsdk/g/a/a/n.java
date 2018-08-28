package com.tencent.mm.pluginsdk.g.a.a;

import android.database.Cursor;
import android.util.SparseArray;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.pluginsdk.g.a.a.a.a;
import com.tencent.mm.pluginsdk.g.a.a.i.b;
import com.tencent.mm.pluginsdk.g.a.c.s;
import com.tencent.mm.protocal.c.bhi;
import com.tencent.mm.protocal.c.bhm;
import com.tencent.mm.protocal.c.bho;
import com.tencent.mm.protocal.c.oj;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public abstract class n extends l implements k {
    protected static final SparseArray<a> qCK = new SparseArray();
    private volatile e diJ;
    protected final List<bho> qCJ = new LinkedList();

    protected abstract q ccA();

    protected abstract String getTag();

    protected abstract oj i(q qVar);

    static /* synthetic */ void a(n nVar, int i, bhi bhi) {
        if (bhi != null) {
            x.i(nVar.getTag(), "resType = %d, subType = %d, res.Oper = %d", new Object[]{Integer.valueOf(i), Integer.valueOf(bhi.sdX), Integer.valueOf(bhi.rIr)});
            if (bhi.sih != null) {
                x.i(nVar.getTag(), "resource.Info.FileFlag %d ", new Object[]{Integer.valueOf(bhi.sih.sis)});
            }
            if (b.BO(bhi.rIr)) {
                x.i(nVar.getTag(), "just do nothing");
                return;
            }
            if (b.BP(bhi.rIr)) {
                x.i(nVar.getTag(), "do cache");
                b$c.qCd.b(i, bhi, false);
            }
            if (b.BQ(bhi.rIr)) {
                x.i(nVar.getTag(), "do decrypt");
                b$c.qCd.a(i, bhi, false, false);
            }
            if (b.BR(bhi.rIr)) {
                x.i(nVar.getTag(), "do delete");
                b$c.qCd.a(i, bhi, false);
            }
        }
    }

    public static void a(a aVar) {
        qCK.put(39, aVar);
    }

    n() {
        for (int i : i.qCl) {
            a aVar = (a) qCK.get(i);
            if (aVar == null || !aVar.mZ(i)) {
                bho bho = new bho();
                bho.hcE = i;
                this.qCJ.add(bho);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.d(getTag(), "before dispatch");
        for (bho bho : this.qCJ) {
            com.tencent.mm.sdk.e.e eVar3;
            int i = bho.hcE;
            com.tencent.mm.pluginsdk.g.a.c.q ccH = q$a.qDx;
            if (ccH.fAQ) {
                eVar3 = ccH.qDu.dCZ;
            } else {
                eVar3 = null;
            }
            List emptyList;
            if (eVar3 == null) {
                emptyList = Collections.emptyList();
            } else {
                Cursor a = eVar3.a("ResDownloaderRecordTable", null, "urlKey" + String.format(Locale.US, " like '%d.%%.data'", new Object[]{Integer.valueOf(i)}) + " and groupId1=" + String.format(Locale.US, "'%s'", new Object[]{"CheckResUpdate"}), null, null, null, null, 2);
                if (a == null || a.isClosed()) {
                    emptyList = Collections.emptyList();
                } else {
                    if (a.moveToFirst()) {
                        emptyList = new LinkedList();
                        do {
                            s sVar = new s();
                            sVar.d(a);
                            emptyList.add(sVar);
                        } while (a.moveToNext());
                    } else {
                        emptyList = Collections.emptyList();
                    }
                    a.close();
                }
            }
            StringBuilder stringBuilder = new StringBuilder("{ ");
            for (s sVar2 : emptyList) {
                int i2 = bi.getInt(sVar2.field_fileVersion, -1);
                if (i2 >= 0) {
                    bhm bhm = new bhm();
                    bhm.sdX = sVar2.field_subType;
                    bhm.sir = i2;
                    bhm.sip = sVar2.field_keyVersion;
                    bhm.qCh = sVar2.field_EID;
                    bho.siw.add(bhm);
                    stringBuilder.append(sVar2.field_subType).append(", ");
                }
            }
            stringBuilder.append(" }");
            x.i(getTag(), "before doScene, add subtypeList(%s) in type(%d)", new Object[]{stringBuilder.toString(), Integer.valueOf(bho.hcE)});
        }
        return a(eVar, ccA(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i(getTag(), "onGYNetEnd errType(%d), errCode(%d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            oj i4 = i(qVar);
            String tag = getTag();
            String str2 = "response.Res.size() = %s";
            Object[] objArr = new Object[1];
            objArr[0] = bi.cX(i4.rsG) ? "null" : String.valueOf(i4.rsG.size());
            x.i(tag, str2, objArr);
            if (!bi.cX(i4.rsG)) {
                com.tencent.mm.sdk.f.e.post(new 1(this, i4.rsG), "NetSceneCheckResUpdate-ResponseHandlingThread");
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
