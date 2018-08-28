package com.tencent.mm.storage;

import android.database.Cursor;
import android.os.Looper;
import com.tencent.mm.bt.h;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.storage.r.a;
import com.tencent.mm.storage.r.b;
import com.tencent.mm.storage.r.c;
import java.util.LinkedList;
import java.util.List;

public final class t extends i<q> {
    public static final String[] ciG = new String[]{"CREATE  INDEX IF NOT EXISTS msg_svr_id_index ON BizTimeLineSingleMsgInfo ( msgSvrId ) ", "CREATE  INDEX IF NOT EXISTS talker_index ON BizTimeLineSingleMsgInfo ( talker ) ", "CREATE  INDEX IF NOT EXISTS  create_time_index ON BizTimeLineSingleMsgInfo ( createTime ) ", "CREATE  INDEX IF NOT EXISTS  status_talker_index ON BizTimeLineSingleMsgInfo ( status,talker ) "};
    public static final String[] diD = new String[]{i.a(q.dhO, "BizTimeLineSingleMsgInfo")};
    public final h dCZ;
    private final k<c, a> sNT = new 1(this);

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

    public t(h hVar) {
        super(hVar, q.dhO, "BizTimeLineSingleMsgInfo", ciG);
        this.dCZ = hVar;
    }

    /* renamed from: c */
    public final boolean b(q qVar) {
        boolean a = super.a(qVar, false);
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

    public final List<q> ckI() {
        Cursor query = this.dCZ.query("BizTimeLineSingleMsgInfo", null, "status!=?", new String[]{"4"}, null, null, "createTime DESC ");
        List<q> linkedList = new LinkedList();
        while (query.moveToNext()) {
            q qVar = new q();
            qVar.d(query);
            linkedList.add(qVar);
        }
        query.close();
        return linkedList;
    }

    public final q ckB() {
        q qVar = null;
        Cursor b = this.dCZ.b("SELECT * FROM BizTimeLineSingleMsgInfo where status != 4 order by createTime DESC limit 1", null, 0);
        if (b.moveToFirst()) {
            qVar = new q();
            qVar.d(b);
        }
        b.close();
        return qVar;
    }

    public final int axd() {
        int i = 0;
        Cursor b = this.dCZ.b("SELECT count(*) FROM BizTimeLineSingleMsgInfo where status != 4", null, 0);
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
}
