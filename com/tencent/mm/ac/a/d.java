package com.tencent.mm.ac.a;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.g.c.w;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.concurrent.atomic.AtomicLong;

public final class d extends i<w> {
    public static final String[] diD = new String[]{i.a(c.dhO, "BizChatInfo")};
    final k<a, b> dKC = new k<a, b>() {
        protected final /* synthetic */ void q(Object obj, Object obj2) {
            ((a) obj).a((b) obj2);
        }
    };
    private AtomicLong dNj = new AtomicLong(-1);
    public e diF;

    public d(e eVar) {
        super(eVar, c.dhO, "BizChatInfo", null);
        this.diF = eVar;
        eVar.fV("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatLocalIdIndex ON BizChatInfo ( bizChatLocalId )");
        eVar.fV("BizChatInfo", "CREATE INDEX IF NOT EXISTS bizChatIdIndex ON BizChatInfo ( bizChatServId )");
        eVar.fV("BizChatInfo", "CREATE INDEX IF NOT EXISTS brandUserNameIndex ON BizChatInfo ( brandUserName )");
        synchronized (this.dNj) {
            Cursor b = this.diF.b("select max(bizChatLocalId) from BizChatInfo", null, 2);
            long j = 0;
            if (b.moveToFirst()) {
                j = (long) b.getInt(0);
                if (j > this.dNj.get()) {
                    this.dNj.set(j);
                }
            }
            b.close();
            x.i("MicroMsg.BizChatInfoStorage", "loading new BizChat id:" + j);
        }
    }

    public final void a(a aVar, Looper looper) {
        this.dKC.a(aVar, looper);
    }

    public final void a(a aVar) {
        if (this.dKC != null) {
            this.dKC.remove(aVar);
        }
    }

    public final c ak(long j) {
        c cVar = new c();
        cVar.field_bizChatLocalId = j;
        super.b(cVar, new String[0]);
        return cVar;
    }

    public final c la(String str) {
        c cVar = null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select * ");
        stringBuilder.append(" from BizChatInfo");
        stringBuilder.append(" where bizChatServId = '").append(str).append("' ");
        stringBuilder.append(" limit 1");
        x.d("MicroMsg.BizChatInfoStorage", "getByServId sql %s", new Object[]{stringBuilder.toString()});
        Cursor rawQuery = rawQuery(r1, new String[0]);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                cVar = new c();
                cVar.d(rawQuery);
            }
            rawQuery.close();
        }
        return cVar;
    }

    public final boolean be(long j) {
        c ak = ak(j);
        boolean a = super.a(ak, new String[]{"bizChatLocalId"});
        if (a) {
            b bVar = new b();
            bVar.dNf = ak.field_bizChatLocalId;
            bVar.bKC = ak.field_brandUserName;
            bVar.dNp = a.dNm;
            bVar.dNq = ak;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
        }
        return a;
    }

    public final boolean a(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorage", "insert wrong argument");
            return false;
        } else if (bi.oW(cVar.field_bizChatServId)) {
            x.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid null");
            return false;
        } else {
            c la = la(cVar.field_bizChatServId);
            if (la != null) {
                cVar.field_bizChatLocalId = la.field_bizChatLocalId;
                x.e("MicroMsg.BizChatInfoStorage", "insert bizchat servid exist");
                return true;
            }
            cVar.field_bizChatLocalId = Np();
            boolean b = super.b(cVar);
            if (!b) {
                return b;
            }
            b bVar = new b();
            bVar.dNf = cVar.field_bizChatLocalId;
            bVar.bKC = cVar.field_brandUserName;
            bVar.dNp = a.dNl;
            bVar.dNq = cVar;
            this.dKC.ci(bVar);
            this.dKC.doNotify();
            return b;
        }
    }

    public final boolean b(c cVar) {
        boolean z = false;
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorage", "update wrong argument");
        } else if (cVar.field_bizChatLocalId < 0) {
            x.e("MicroMsg.BizChatInfoStorage", "update bizchat localid neg");
        } else {
            c ak = ak(cVar.field_bizChatLocalId);
            if (bi.oW(ak.field_bizChatServId) || ak.field_bizChatServId.equals(cVar.field_bizChatServId)) {
                if (cVar == null || bi.oW(cVar.field_chatName)) {
                    x.i("MicroMsg.BizChatInfoStorage", "dealWithChatNamePY null");
                } else {
                    cVar.field_chatNamePY = h.oI(cVar.field_chatName);
                }
                z = super.a(cVar);
                if (z) {
                    e.g(cVar);
                    b bVar = new b();
                    bVar.dNf = cVar.field_bizChatLocalId;
                    bVar.bKC = cVar.field_brandUserName;
                    bVar.dNp = a.dNn;
                    bVar.dNq = cVar;
                    this.dKC.ci(bVar);
                    this.dKC.doNotify();
                }
            } else {
                x.e("MicroMsg.BizChatInfoStorage", "update bizchat servid nequal");
            }
        }
        return z;
    }

    private long Np() {
        synchronized (this.dNj) {
            x.i("MicroMsg.BizChatInfoStorage", "incBizChatLocalId %d  ", new Object[]{Long.valueOf(this.dNj.incrementAndGet())});
        }
        return r2;
    }
}
