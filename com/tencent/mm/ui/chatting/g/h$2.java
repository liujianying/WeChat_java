package com.tencent.mm.ui.chatting.g;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.chatting.g.h.a;
import com.tencent.mm.ui.tools.k;

class h$2 implements e {
    final /* synthetic */ h tYI;

    h$2(h hVar) {
        this.tYI = hVar;
    }

    public final void a(int i, b bVar) {
        x.i("MicroMsg.UrlHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
        if (bVar == null) {
            x.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] null == baseItem, position:%s", new Object[]{Integer.valueOf(i)});
            return;
        }
        a aVar = (a) bVar;
        if (aVar.getType() == 5) {
            h.a(this.tYI, aVar);
        } else if (aVar.getType() == 7) {
            h.b(this.tYI, aVar);
        } else if (aVar.getType() == 15) {
            h.c(this.tYI, aVar);
        } else if (aVar.getType() == 26) {
            h.d(this.tYI, aVar);
        } else if (aVar.getType() == 27) {
            h.e(this.tYI, aVar);
        } else {
            x.e("MicroMsg.UrlHistoryListPresenter", "[onItemClick] type:%s", new Object[]{Integer.valueOf(aVar.getType())});
        }
    }

    public final void a(View view, int i, b bVar) {
        x.i("MicroMsg.UrlHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
        new k(view.getContext()).b(view, new 1(this), new 2(this, bVar, i));
    }
}
