package com.tencent.mm.ui.bizchat;

import android.database.Cursor;
import com.tencent.mm.ac.a.c;
import com.tencent.mm.ac.z;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import java.util.LinkedList;

class BizChatConversationUI$a$10 implements Runnable {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$10(a aVar) {
        this.tEC = aVar;
    }

    public final void run() {
        x.i("MicroMsg.BizChatConversationFmUI", "updateChatInfoFromSvr");
        LinkedList linkedList = new LinkedList();
        LinkedList linkedList2 = new LinkedList();
        Cursor kY = z.Nb().kY(a.a(this.tEC));
        if (kY.moveToFirst()) {
            while (!kY.isAfterLast()) {
                com.tencent.mm.ac.a.a aVar = new com.tencent.mm.ac.a.a();
                aVar.d(kY);
                kY.moveToNext();
                c ak = z.Na().ak(aVar.field_bizChatId);
                if (ak.No()) {
                    if (ak.isGroup()) {
                        linkedList2.add(ak.field_bizChatServId);
                    } else {
                        linkedList.add(ak.field_bizChatServId);
                    }
                }
            }
        }
        kY.close();
        if (linkedList2.size() > 0) {
            z.Ng().a(linkedList2, a.a(this.tEC));
        }
        a.a(this.tEC, linkedList);
        if (linkedList.size() > 0) {
            z.Ng().b(linkedList, a.a(this.tEC));
        }
    }
}
