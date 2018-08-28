package com.tencent.mm.plugin.fav.b.e;

import android.database.Cursor;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends i<c> implements q {
    private List<p> avD = new LinkedList();
    private e diF;

    public final void a(p pVar) {
        if (pVar != null) {
            this.avD.add(pVar);
        }
    }

    public final void b(p pVar) {
        if (pVar != null) {
            this.avD.remove(pVar);
        }
    }

    public a(e eVar) {
        super(eVar, c.dhO, "FavCdnInfo", null);
        this.diF = eVar;
    }

    public final void aLt() {
        this.diF.fV("FavCdnInfo", "update FavCdnInfo set status = 1 where status <> 3");
    }

    /* renamed from: e */
    public final boolean b(c cVar) {
        int i = 0;
        if (cVar == null || !super.b(cVar)) {
            return false;
        }
        p[] pVarArr = new p[this.avD.size()];
        this.avD.toArray(pVarArr);
        int length = pVarArr.length;
        while (i < length) {
            p pVar = pVarArr[i];
            if (pVar != null) {
                pVar.d(cVar);
            }
            i++;
        }
        return true;
    }

    /* renamed from: a */
    public final boolean c(c cVar, String... strArr) {
        int i = 0;
        if (!super.c(cVar, strArr)) {
            return false;
        }
        p[] pVarArr = new p[this.avD.size()];
        this.avD.toArray(pVarArr);
        int length = pVarArr.length;
        while (i < length) {
            p pVar = pVarArr[i];
            if (pVar != null) {
                pVar.d(cVar);
            }
            i++;
        }
        return true;
    }

    /* renamed from: b */
    public final boolean a(c cVar, String... strArr) {
        int i = 0;
        if (!super.a(cVar, strArr)) {
            return false;
        }
        p[] pVarArr = new p[this.avD.size()];
        this.avD.toArray(pVarArr);
        int length = pVarArr.length;
        while (i < length) {
            p pVar = pVarArr[i];
            if (pVar != null) {
                pVar.d(cVar);
            }
            i++;
        }
        return true;
    }

    public final c Br(String str) {
        c cVar = null;
        if (bi.oW(str)) {
            x.e("MicroMsg.FavCdnStorage", "md5 null");
        } else {
            Cursor b = this.diF.b("select * from FavCdnInfo where dataId = '" + str + "'", null, 2);
            if (b != null) {
                if (b.moveToFirst()) {
                    cVar = new c();
                    cVar.d(b);
                }
                b.close();
            }
        }
        return cVar;
    }

    public final void x(g gVar) {
        this.diF.fV("FavCdnInfo", "update FavCdnInfo set status = 1,modifyTime = " + bi.VF() + " where favLocalId = " + gVar.field_localId + " and type = 0 and status <> 3");
    }

    public final LinkedList<c> aLu() {
        LinkedList<c> linkedList = null;
        Cursor b = this.diF.b("select * from FavCdnInfo where status = 1 order by modifyTime desc " + " limit 1", null, 2);
        if (b != null) {
            if (b.moveToFirst()) {
                linkedList = new LinkedList();
                do {
                    c cVar = new c();
                    cVar.d(b);
                    linkedList.add(cVar);
                } while (b.moveToNext());
                b.close();
            } else {
                b.close();
            }
        }
        return linkedList;
    }

    public final List<c> dt(long j) {
        List<c> arrayList = new ArrayList();
        Cursor b = this.diF.b("select * from FavCdnInfo where favLocalId = " + j, null, 2);
        if (b != null) {
            while (b.moveToNext()) {
                c cVar = new c();
                cVar.d(b);
                arrayList.add(cVar);
            }
            b.close();
        }
        x.v("MicroMsg.FavCdnStorage", "getInfos size:%d", new Object[]{Integer.valueOf(arrayList.size())});
        return arrayList;
    }

    public final List<c> du(long j) {
        List<c> linkedList = new LinkedList();
        Cursor b = this.diF.b("select * from FavCdnInfo where favLocalId = " + j + " and type = 0 and status = 3", null, 2);
        if (b == null || !b.moveToFirst()) {
            if (b != null) {
                b.close();
            }
            x.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList.size())});
            return linkedList;
        }
        do {
            c cVar = new c();
            cVar.d(b);
            linkedList.add(cVar);
        } while (b.moveToNext());
        if (b != null) {
            b.close();
        }
        x.v("MicroMsg.FavCdnStorage", "getUploadedInfos size:%d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final void dv(long j) {
        this.diF.fV("FavCdnInfo", String.format("delete from %s where %s = %d and %s = %d", new Object[]{"FavCdnInfo", "favLocalId", Long.valueOf(j), "type", Integer.valueOf(0)}));
    }

    public final int p(long j, int i) {
        Cursor b = this.diF.b("select status from FavCdnInfo where favLocalId = " + j + " and type = " + i, null, 2);
        if (b == null) {
            return 3;
        }
        if (b.moveToFirst()) {
            int i2 = 1;
            int i3 = 1;
            int i4 = 1;
            do {
                int i5 = b.getInt(0);
                if (i5 == 1) {
                    b.close();
                    return 1;
                }
                if (i5 != 4) {
                    i4 = 0;
                }
                if (i5 != 2) {
                    i3 = 0;
                }
                if (i5 != 3) {
                    i2 = 0;
                }
            } while (b.moveToNext());
            b.close();
            if (i3 != 0) {
                return 2;
            }
            if (i4 != 0) {
                return 4;
            }
            if (i2 != 0) {
                return 3;
            }
            return 0;
        }
        b.close();
        return 3;
    }

    public final Cursor aLv() {
        return this.diF.rawQuery("select * from FavCdnInfo where type = 0 and status = 1", null);
    }

    public final Cursor aLw() {
        return this.diF.rawQuery("select * from FavCdnInfo where type = 1 and status = 1", null);
    }

    public final boolean dw(long j) {
        c cVar = new c();
        cVar.field_favLocalId = j;
        return a(cVar, "favLocalId");
    }
}
