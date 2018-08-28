package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public final class r extends i<q> {
    public static final String[] ciG = new String[]{"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  order_flag_index ON BizTimeLineInfo ( orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  has_show_index ON BizTimeLineInfo ( hasShow ) ", "CREATE  INDEX IF NOT EXISTS  status_order_flag_index ON BizTimeLineInfo ( status,orderFlag ) ", "CREATE  INDEX IF NOT EXISTS  has_show_talker_index ON BizTimeLineInfo ( hasShow,talker ) "};
    public static final String[] diD = new String[]{i.a(q.dhO, "BizTimeLineInfo")};
    public final h dCZ;
    private final k<c, a> sNT = new k<c, a>() {
    };
    private final long sNU = 10;
    private AtomicLong sNV = new AtomicLong(10);
    private long sNW = 10;

    public interface c {
        /* renamed from: a */
        void q(a aVar);
    }

    public final void b(a aVar) {
        if (this.sNT.ci(aVar)) {
            this.sNT.doNotify();
        }
    }

    public final void a(c cVar, Looper looper) {
        this.sNT.a(cVar, looper);
    }

    public final void a(c cVar) {
        this.sNT.remove(cVar);
    }

    public r(h hVar) {
        super(hVar, q.dhO, "BizTimeLineInfo", ciG);
        this.dCZ = hVar;
        ckF();
    }

    /* renamed from: c */
    public final boolean b(q qVar) {
        boolean a = super.a(qVar, false);
        gk(qVar.ckx());
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.sNZ = qVar;
        aVar.sNY = b.sOa;
        b(aVar);
        return a;
    }

    public final boolean d(q qVar) {
        boolean b = super.b(qVar, false, new String[]{"msgSvrId"});
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.sNZ = qVar;
        aVar.sNY = b.sOc;
        b(aVar);
        return b;
    }

    public final q gg(long j) {
        q qVar = new q();
        Cursor a = this.dCZ.a("BizTimeLineInfo", null, "msgSvrId" + "=?", new String[]{String.valueOf(j)}, null, null, null, 2);
        if (a.moveToFirst()) {
            qVar.d(a);
            a.close();
            return qVar;
        }
        a.close();
        return null;
    }

    public final List<q> gh(long j) {
        return n(this.dCZ.query("BizTimeLineInfo", null, "orderFlag>=?", new String[]{String.valueOf(j)}, null, null, "orderFlag DESC"));
    }

    public static List<q> n(Cursor cursor) {
        List<q> linkedList = new LinkedList();
        while (cursor.moveToNext()) {
            q qVar = new q();
            qVar.d(cursor);
            linkedList.add(qVar);
        }
        cursor.close();
        return linkedList;
    }

    public final q ckB() {
        q qVar = null;
        Cursor b = this.dCZ.b("SELECT * FROM BizTimeLineInfo order by orderFlag DESC limit 1", null, 0);
        if (b.moveToFirst()) {
            qVar = new q();
            qVar.d(b);
        }
        b.close();
        return qVar;
    }

    public final int gi(long j) {
        int i = 0;
        Cursor b = this.dCZ.b("SELECT count(*) FROM BizTimeLineInfo where status != 4 and orderFlag >= " + (-4294967296L & j), null, 0);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final int ckC() {
        int i = 0;
        Cursor b = this.dCZ.b("SELECT count(*) FROM BizTimeLineInfo where hasShow != 1 ", null, 0);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final boolean Gy(String str) {
        q qVar = new q();
        qVar.field_talker = str;
        boolean a = super.a(qVar, false, new String[]{"talker"});
        a aVar = new a();
        aVar.talker = qVar.field_talker;
        aVar.sNZ = qVar;
        aVar.sNY = b.sOb;
        b(aVar);
        return a;
    }

    public final void gj(long j) {
        q qVar = new q();
        qVar.field_msgId = j;
        super.a(qVar, false, new String[]{"msgId"});
        a aVar = new a();
        aVar.sNY = b.sOb;
        b(aVar);
    }

    private synchronized void gk(long j) {
        this.sNW = Math.max(j, this.sNW);
    }

    public final synchronized long ckD() {
        return this.sNW;
    }

    public final synchronized long ckx() {
        return this.sNV.longValue();
    }

    public final synchronized long ckE() {
        return this.sNV.incrementAndGet();
    }

    private synchronized void ckF() {
        this.sNW = ckG() >> 32;
        if (this.sNW < 10) {
            this.sNW = 10;
        }
        q ckB = ckB();
        if (ckB == null) {
            x.w("MicroMsg.BizTimeLineInfoStorage", "initGroupId is null, id %d", new Object[]{Long.valueOf(this.sNW)});
        } else {
            if (ckB.field_status == 4) {
                this.sNV.set(this.sNW + 1);
            } else {
                this.sNV.set(this.sNW);
            }
            x.i("MicroMsg.BizTimeLineInfoStorage", "initGroupId id %d/%d, status %d", new Object[]{Long.valueOf(this.sNV.longValue()), Long.valueOf(this.sNW), Integer.valueOf(ckB.field_status)});
        }
    }

    private synchronized long ckG() {
        long j;
        Cursor b = this.dCZ.b("select max(orderFlag) from BizTimeLineInfo", null, 2);
        j = 0;
        if (b.moveToFirst()) {
            j = b.getLong(0);
        }
        b.close();
        return j;
    }
}
