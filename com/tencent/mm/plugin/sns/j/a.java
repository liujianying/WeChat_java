package com.tencent.mm.plugin.sns.j;

import android.database.Cursor;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.sns.j.c.b;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.i;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.ui.aw;
import com.tencent.mm.protocal.c.boh;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a extends com.tencent.mm.vending.app.a implements e {
    String gtX;
    boolean nNG;
    String ocI;
    boolean ocJ;
    int ocK;
    public volatile aw oeg;
    protected volatile com.tencent.mm.plugin.sns.model.am.a oha;
    private com.tencent.mm.plugin.sns.b.h.a oni;

    public final void a(com.tencent.mm.plugin.sns.b.h.a aVar) {
        this.oha = af.bye();
        com.tencent.mm.plugin.sns.j.c.a aVar2 = (com.tencent.mm.plugin.sns.j.c.a) P(com.tencent.mm.plugin.sns.j.c.a.class);
        this.oni = aVar;
        this.oha.a(1, aVar2.gtX, this.oni);
    }

    public final com.tencent.mm.plugin.sns.model.am.a bye() {
        return this.oha;
    }

    protected final void onCreate() {
        super.onCreate();
        a(b.class, new 1(this));
        a(com.tencent.mm.plugin.sns.j.c.a.class, new 2(this));
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onCreate %s", new Object[]{this});
        af.byj().nmF.clear();
        af.byj();
        com.tencent.mm.plugin.sns.model.b.bxr();
    }

    protected final void onDestroy() {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onDestroy %s", new Object[]{this});
        g.Ek();
        if (!(!g.Eg().Dx() || this.oha == null || this.oni == null)) {
            this.oha.a(this.oni, 1);
        }
        super.onDestroy();
    }

    static b bFa() {
        b bVar = new b();
        Cursor bAP = af.byt().bAP();
        int count = bAP.getCount();
        String str = "";
        if (count > 0) {
            bAP.moveToFirst();
            j jVar = new j();
            jVar.d(bAP);
            try {
                str = ((boh) new boh().aG(jVar.field_curActionBuf)).seC;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.SnsTimelineInteractor", e, "", new Object[0]);
            }
        }
        bAP.close();
        String[] split = ((String) g.Ei().DT().get(com.tencent.mm.storage.aa.a.taf, "")).split("&");
        List arrayList = new ArrayList();
        for (int i = 2; i < split.length; i++) {
            long j = bi.getLong(split[i], 0);
            if (j != 0) {
                arrayList.add(Long.valueOf(j));
            }
        }
        Collections.reverse(arrayList);
        i.h(arrayList.size() > 0 ? (Long) arrayList.get(0) : null);
        bVar.onp = count;
        bVar.ono = str;
        bVar.onq = arrayList;
        return bVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.SnsTimelineInteractor", "SnsTimelineInteractor onSceneEnd  errType %d %d %s %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str, lVar.toString()});
    }

    public final void g(String str, boolean z, int i) {
        this.oha.a(1, str, z, i);
    }

    public final void h(String str, boolean z, int i) {
        this.oha.b(1, str, z, i);
    }
}
