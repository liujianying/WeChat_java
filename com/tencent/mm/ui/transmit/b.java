package com.tencent.mm.ui.transmit;

import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.h;
import com.tencent.mm.ui.contact.m;

public final class b extends m {
    String bWm;
    private ag handler = new ag(Looper.getMainLooper());
    j jsk;
    private a jsw;
    private MMCreateChatroomUI uDd;
    private l uDe = new 1(this);

    public b(MMCreateChatroomUI mMCreateChatroomUI, int i) {
        super(mMCreateChatroomUI, false, i);
        this.uDd = mMCreateChatroomUI;
    }

    public final void a(String str, int[] iArr, boolean z) {
        this.bWm = str;
        i iVar = new i();
        iVar.handler = this.handler;
        iVar.jsv = this.uDe;
        iVar.bWm = str;
        iVar.jsu = com.tencent.mm.plugin.fts.a.c.b.jsU;
        iVar.jsq = new int[]{131072};
        iVar.jst.add("filehelper");
        iVar.jst.add(q.GF());
        iVar.jst.addAll(this.uDd.uDh.cAa());
        this.jsw = ((n) g.n(n.class)).search(2, iVar);
    }

    public final void acV() {
        if (this.jsw != null) {
            ((n) g.n(n.class)).cancelSearchTask(this.jsw);
        }
        this.bWm = null;
    }

    protected final com.tencent.mm.ui.contact.a.a iW(int i) {
        com.tencent.mm.ui.contact.a.a hVar;
        com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) this.jsk.jsx.get(i);
        if (lVar.jrv.equals("no_result​")) {
            hVar = new h(i);
        } else {
            d dVar = new d(i);
            dVar.fyJ = lVar;
            dVar.jrx = this.jsk.jrx;
            dVar.ujX = bwq();
            dVar.djH = true;
            dVar.jtl = i + 1;
            dVar.cF(dVar.fyJ.type, dVar.fyJ.jru);
            hVar = dVar;
        }
        hVar.bWm = this.bWm;
        hVar.scene = this.scene;
        hVar.ujX = false;
        return hVar;
    }

    public final int getCount() {
        if (this.jsk == null || this.jsk.jsx == null) {
            return 0;
        }
        return this.jsk.jsx.size();
    }
}
