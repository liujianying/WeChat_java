package com.tencent.mm.modelmulti;

import android.database.Cursor;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aw;
import java.util.ArrayList;
import java.util.Iterator;

class b$2 implements Runnable {
    final /* synthetic */ b dYL;

    b$2(b bVar) {
        this.dYL = bVar;
    }

    public final void run() {
        Cursor axc = o.PO().PL().axc();
        if (axc != null) {
            long currentTimeMillis = System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            if (axc.moveToFirst()) {
                while (!axc.isAfterLast()) {
                    aw awVar = new aw();
                    awVar.d(axc);
                    if (awVar.field_originSvrId != 0) {
                        if (currentTimeMillis > 604800000 + (awVar.field_createTime * 1000)) {
                            arrayList.add(awVar);
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d] but expired and delete", new Object[]{Long.valueOf(awVar.field_originSvrId)});
                        } else {
                            x.i("MicroMsg.GetChatRoomMsgService", "summerbadcr get syscmdinfo from db originSvrId[%d]", new Object[]{Long.valueOf(awVar.field_originSvrId)});
                            this.dYL.dYH.put(Long.valueOf(awVar.field_originSvrId), awVar);
                        }
                    }
                    axc.moveToNext();
                }
            }
            axc.close();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                aw awVar2 = (aw) it.next();
                o.PO().PL().a(awVar2, false, new String[]{""});
            }
        }
    }
}
