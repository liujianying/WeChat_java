package com.tencent.mm.ui.chatting.g;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.a$c;
import com.tencent.mm.ui.gridviewheaders.a;
import java.util.Date;
import java.util.LinkedList;

class e$7 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ boolean tXV;
    final /* synthetic */ e tYu;

    e$7(e eVar, boolean z, int i) {
        this.tYu = eVar;
        this.tXV = z;
        this.dPF = i;
    }

    public final void run() {
        Cursor Y;
        if (this.tXV) {
            e eVar;
            if (e.i(this.tYu) == -1) {
                eVar = this.tYu;
                au.HU();
                e.b(eVar, c.FT().GW(e.j(this.tYu)));
            } else {
                eVar = this.tYu;
                au.HU();
                e.b(eVar, c.FU().aw(e.j(this.tYu), e.i(this.tYu)));
            }
        }
        int k = (this.dPF < 0 || e.k(this.tYu) - this.dPF <= 200) ? 200 : e.k(this.tYu) - this.dPF;
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "offset:%s limit:%s", new Object[]{Integer.valueOf(this.dPF), Integer.valueOf(k)});
        LinkedList linkedList = new LinkedList();
        if (e.i(this.tYu) == -1) {
            au.HU();
            Y = c.FT().Y(e.j(this.tYu), e.a(this.tYu).size() - e.l(this.tYu), k);
        } else {
            au.HU();
            Y = c.FU().b(e.j(this.tYu), e.i(this.tYu), e.a(this.tYu).size() - e.l(this.tYu), k);
        }
        if (Y == null) {
            x.e("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] NULL == cursor ");
            return;
        }
        bd bdVar;
        long b;
        long j = 0;
        while (Y.moveToNext()) {
            try {
                bdVar = new bd();
                bdVar.d(Y);
                b = a.czj().b(new Date(bdVar.field_createTime));
                if (j != b) {
                    linkedList.add(new a$c(bdVar.field_createTime));
                    e.m(this.tYu);
                }
                linkedList.add(new a$c(bdVar));
                j = b;
            } finally {
                Y.close();
            }
        }
        LinkedList linkedList2 = new LinkedList();
        if (linkedList.size() - e.l(this.tYu) == k) {
            Cursor n;
            long j2 = ((a$c) linkedList.get(0)).timeStamp;
            a.czj();
            b = a.gO(j2);
            x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] list size:%s start:%s end:%s", new Object[]{Integer.valueOf(linkedList.size()), Long.valueOf(b), Long.valueOf(j2)});
            if (e.i(this.tYu) == -1) {
                au.HU();
                n = c.FT().n(e.j(this.tYu), b, j2);
            } else {
                au.HU();
                n = c.FU().b(e.j(this.tYu), e.i(this.tYu), b, j2);
            }
            Date date = new Date(j2);
            b = a.czj().b(date);
            while (n != null) {
                try {
                    if (!n.moveToNext()) {
                        break;
                    }
                    bdVar = new bd();
                    bdVar.d(n);
                    j2 = a.czj().b(new Date(bdVar.field_createTime));
                    if (b != j2 && a.czj().b(date) != j2) {
                        linkedList2.add(new a$c(bdVar.field_createTime));
                        e.m(this.tYu);
                        b = j2;
                    } else if (linkedList.size() > 0 && linkedList2.size() == 0) {
                        linkedList2.add(0, linkedList.remove(0));
                    }
                    linkedList2.add(new a$c(bdVar));
                } catch (Throwable th) {
                    if (n != null) {
                        n.close();
                    }
                    Y.close();
                }
            }
            if (n != null) {
                n.close();
            }
        }
        int size = linkedList.size() + linkedList2.size();
        e.a(this.tYu).addAll(0, linkedList2);
        e.a(this.tYu).addAll(linkedList2.size(), linkedList);
        linkedList.clear();
        linkedList2.clear();
        e.n(this.tYu);
        x.i("MicroMsg.MediaHistoryGalleryPresenter", "[loadData] %s", new Object[]{Integer.valueOf(e.a(this.tYu).size())});
        ah.A(new 1(this, size));
    }
}
