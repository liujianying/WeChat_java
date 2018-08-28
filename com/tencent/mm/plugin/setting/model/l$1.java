package com.tencent.mm.plugin.setting.model;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class l$1 implements Runnable {
    final /* synthetic */ l mPc;

    public l$1(l lVar) {
        this.mPc = lVar;
    }

    public final void run() {
        l lVar = this.mPc;
        long currentTimeMillis = System.currentTimeMillis();
        LinkedList linkedList = new LinkedList();
        ay FR = ((i) g.l(i.class)).FR();
        String str = "@all.contact.without.chatroom";
        List arrayList = new ArrayList();
        arrayList.add("tmessage");
        arrayList.add("officialaccounts");
        arrayList.add("filehelper");
        arrayList.add("helper_entry");
        arrayList.add(q.GF());
        bl Hg = ((i) g.l(i.class)).FZ().Hg("@t.qq.com");
        if (Hg != null) {
            arrayList.add(Hg.name);
        }
        arrayList.add("blogapp");
        Cursor a = FR.a(str, null, arrayList, null, false, false);
        if (a != null) {
            a.moveToFirst();
            while (!a.isAfterLast()) {
                ab abVar = new ab();
                abVar.d(a);
                linkedList.add(abVar.field_username);
                a.moveToNext();
            }
            a.close();
        }
        x.i("MicroMsg.UnfamiliarContactEngine", "[getQuery] cost:%sms list size:%s", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(linkedList.size())});
        l.a(lVar, linkedList);
    }
}
