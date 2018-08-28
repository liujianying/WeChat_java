package com.tencent.mm.ui.voicesearch;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import java.util.ArrayList;
import java.util.List;

class b$9 implements Runnable {
    final /* synthetic */ b uFM;

    b$9(b bVar) {
        this.uFM = bVar;
    }

    public final void run() {
        int i = 0;
        b bVar;
        if (b.g(this.uFM) != null && b.g(this.uFM).length != 0) {
            List arrayList = new ArrayList();
            String[] g = b.g(this.uFM);
            int length = g.length;
            while (i < length) {
                String str = g[i];
                if (this.uFM.abp(str)) {
                    arrayList.add(str);
                }
                i++;
            }
            if (arrayList.size() > 0) {
                b bVar2 = this.uFM;
                au.HU();
                b.a(bVar2, c.FR().a((String[]) arrayList.toArray(new String[arrayList.size()]), b.h(this.uFM), b.a(this.uFM)));
                return;
            }
            bVar = this.uFM;
            au.HU();
            b.b(bVar, c.FR().bdj());
        } else if (b.i(this.uFM) == null) {
            bVar = this.uFM;
            au.HU();
            b.e(bVar, c.FR().bdj());
        } else if (b.h(this.uFM).equals("@all.chatroom.contact")) {
            Cursor a = au.HU().dAc.a(b.i(this.uFM), "@micromsg.with.all.biz.qq.com", b.a(this.uFM), false);
            ArrayList arrayList2 = new ArrayList();
            ArrayList arrayList3 = new ArrayList();
            while (a.moveToNext()) {
                String string = a.getString(a.getColumnIndex("username"));
                if (string.endsWith("@chatroom")) {
                    arrayList3.add(string);
                } else {
                    arrayList2.add(string);
                }
            }
            if (!a.isClosed()) {
                a.close();
            }
            if (arrayList2.size() == 0 && arrayList3.size() == 0) {
                au.HU();
                a = c.FR().bdj();
            } else {
                a = au.HU().dAc.a(b.i(this.uFM), arrayList2, null, arrayList3, b.a(this.uFM));
            }
            b.d(this.uFM, a);
        } else {
            b.c(this.uFM, au.HU().dAc.a(b.i(this.uFM), b.h(this.uFM), b.a(this.uFM), true));
        }
    }
}
