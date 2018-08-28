package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.record.a.c;
import com.tencent.mm.plugin.record.a.d;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public final class e extends i<f> implements d {
    private com.tencent.mm.sdk.e.e diF;
    private Vector<c> msa = new Vector();

    public e(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, f.dhO, "RecordCDNInfo", null);
        this.diF = eVar;
    }

    public final void a(c cVar) {
        g.Em().H(new 1(this, cVar));
    }

    public final void b(c cVar) {
        g.Em().H(new 2(this, cVar));
    }

    private void b(int i, f fVar) {
        g.Em().H(new 3(this, i, fVar));
    }

    public final List<f> bqp() {
        List<f> linkedList = new LinkedList();
        Cursor b = this.diF.b("SELECT * FROM RecordCDNInfo WHERE status != 3 AND status != 4 AND status != 2 AND status != -1", null, 2);
        if (b != null) {
            while (b.moveToNext()) {
                f fVar = new f();
                fVar.d(b);
                linkedList.add(fVar);
            }
            b.close();
        }
        x.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final List<f> vk(int i) {
        List<f> linkedList = new LinkedList();
        Cursor b = this.diF.b("SELECT * FROM RecordCDNInfo WHERE recordLocalId = " + i, null, 2);
        if (b != null) {
            while (b.moveToNext()) {
                f fVar = new f();
                fVar.d(b);
                linkedList.add(fVar);
            }
            b.close();
        }
        x.d("MicroMsg.RecordMsgCDNStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final f Kr(String str) {
        f fVar = null;
        Cursor b = this.diF.b("SELECT * FROM RecordCDNInfo WHERE mediaId='" + str + "'", null, 2);
        if (b != null && b.moveToFirst()) {
            fVar = new f();
            fVar.d(b);
        }
        if (b != null) {
            b.close();
        }
        return fVar;
    }

    public final boolean a(f fVar, String... strArr) {
        if (!super.a(fVar, strArr)) {
            return false;
        }
        b(0, fVar);
        return true;
    }

    /* renamed from: b */
    public final boolean c(f fVar, String... strArr) {
        if (!super.c(fVar, strArr)) {
            return false;
        }
        b(1, fVar);
        return true;
    }

    public final boolean a(f fVar) {
        if (!super.a(fVar)) {
            return false;
        }
        b(1, fVar);
        return true;
    }

    public final boolean b(f fVar) {
        if (fVar != null) {
            x.v("MicroMsg.RecordMsgCDNStorage", "insert record cdn info %s", new Object[]{fVar});
            if (!super.b(fVar)) {
                return false;
            }
            b(2, fVar);
            return true;
        }
        x.e("MicroMsg.RecordMsgCDNStorage", "insert null record cdn info");
        return false;
    }
}
