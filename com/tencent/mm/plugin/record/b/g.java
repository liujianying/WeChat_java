package com.tencent.mm.plugin.record.b;

import android.database.Cursor;
import com.tencent.mm.plugin.record.a.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class g extends i<com.tencent.mm.plugin.record.a.g> implements e {
    private com.tencent.mm.sdk.e.e diF;

    public g(com.tencent.mm.sdk.e.e eVar) {
        super(eVar, com.tencent.mm.plugin.record.a.g.dhO, "RecordMessageInfo", null);
        this.diF = eVar;
    }

    public final List<com.tencent.mm.plugin.record.a.g> bqq() {
        List<com.tencent.mm.plugin.record.a.g> linkedList = new LinkedList();
        Cursor axc = axc();
        if (axc != null) {
            axc.moveToFirst();
            while (!axc.isAfterLast()) {
                com.tencent.mm.plugin.record.a.g gVar = new com.tencent.mm.plugin.record.a.g();
                gVar.d(axc);
                linkedList.add(gVar);
                axc.moveToNext();
            }
            axc.close();
        }
        x.d("MicroMsg.RecordMsgStorage", "get all finish, result count %d", new Object[]{Integer.valueOf(linkedList.size())});
        return linkedList;
    }

    public final void vl(int i) {
        int delete = this.diF.delete("RecordMessageInfo", "localId=?", new String[]{String.valueOf(i)});
        x.d("MicroMsg.RecordMsgStorage", "delete record msg item, local id %d, result %d", new Object[]{Integer.valueOf(i), Integer.valueOf(delete)});
    }

    public final com.tencent.mm.plugin.record.a.g vm(int i) {
        com.tencent.mm.plugin.record.a.g gVar = null;
        x.d("MicroMsg.RecordMsgStorage", "get by local id, sql[%s], local[%d]", new Object[]{"SELECT * FROM RecordMessageInfo WHERE localId=" + i, Integer.valueOf(i)});
        Cursor b = this.diF.b(r1, null, 2);
        if (b != null && b.moveToFirst()) {
            gVar = new com.tencent.mm.plugin.record.a.g();
            gVar.d(b);
        }
        if (b != null) {
            b.close();
        }
        return gVar;
    }
}
