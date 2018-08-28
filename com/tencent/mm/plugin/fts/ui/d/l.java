package com.tencent.mm.plugin.fts.ui.d;

import android.content.Context;
import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.c;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.plugin.fts.ui.a.o;
import com.tencent.mm.plugin.fts.ui.a.p;
import com.tencent.mm.plugin.fts.ui.n$g;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class l extends k {
    public String jsp;

    public l(Context context, b bVar, int i) {
        super(context, bVar, i);
    }

    public int getType() {
        return 176;
    }

    protected a a(ag agVar, HashSet<String> hashSet) {
        this.jzn = false;
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jsu = e.jsX;
        iVar.jsp = this.jsp;
        iVar.jsv = this;
        iVar.handler = agVar;
        iVar.jsn = 10;
        return ((n) g.n(n.class)).search(3, iVar);
    }

    protected final void a(j jVar, HashSet<String> hashSet) {
        switch (jVar.bjW) {
            case 0:
                if (jVar.jsx.size() > 0) {
                    int i = 0;
                    while (i < jVar.jsx.size()) {
                        com.tencent.mm.plugin.fts.a.d.e.a aVar = new com.tencent.mm.plugin.fts.a.d.e.a();
                        aVar.jtb = true;
                        aVar.jtg = (com.tencent.mm.plugin.fts.a.a.l) jVar.jsx.get(i);
                        aVar.jrx = jVar.jrx;
                        aVar.jte = (List) aVar.jtg.userData;
                        if (aVar.jte.size() <= 3 || i == jVar.jsx.size() - 1) {
                            aVar.jtf = false;
                            aVar.jtd = false;
                        } else {
                            aVar.jtf = true;
                            aVar.jtd = true;
                        }
                        this.jvp.add(aVar);
                        i++;
                    }
                    return;
                }
                com.tencent.mm.plugin.fts.a.d.e.a aVar2 = new com.tencent.mm.plugin.fts.a.d.e.a();
                aVar2.iPZ = -2;
                aVar2.jrx = jVar.jrx;
                aVar2.jtb = false;
                com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
                lVar.jrv = "no_result​";
                aVar2.jte = new ArrayList();
                aVar2.jte.add(lVar);
                this.jvp.add(aVar2);
                return;
            default:
                return;
        }
    }

    public final int qg(int i) {
        int size = this.jvp.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.jvp.get(i3);
            aVar.jta = i2;
            if (aVar.jtb) {
                i2++;
            }
            if (aVar.jte.size() > 3) {
                if (aVar.jtf) {
                    i2 += 3;
                } else {
                    i2 += aVar.jte.size();
                }
                aVar.jtc = i2;
                if (aVar.jtd) {
                    i2++;
                }
            } else {
                i2 += aVar.jte.size();
                aVar.jtc = i2;
            }
        }
        return i2;
    }

    protected k b(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        o oVar = new o(i);
        oVar.jxW = aVar.jtg;
        oVar.jrx = oVar.jxW.jrx;
        return oVar;
    }

    protected final com.tencent.mm.plugin.fts.ui.a.n c(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        c cVar = new c(i);
        cVar.jxE = n$g.fts_header_message;
        cVar.jxF = aVar.jtf;
        return cVar;
    }

    protected com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        int i2;
        if (aVar.jtb) {
            i2 = (i - aVar.jta) - 1;
        } else {
            i2 = i - aVar.jta;
        }
        if (i2 < 0 || i2 >= aVar.jte.size()) {
            return null;
        }
        com.tencent.mm.plugin.fts.a.a.l lVar = (com.tencent.mm.plugin.fts.a.a.l) aVar.jte.get(i2);
        if (lVar.jrv.equals("no_result​")) {
            return new com.tencent.mm.plugin.fts.ui.a.l(i);
        }
        p pVar = new p(i);
        pVar.fyJ = lVar;
        pVar.jxW = aVar.jtg;
        pVar.jrx = pVar.fyJ.jrx;
        pVar.jtk = -14;
        pVar.showType = 2;
        pVar.cF(lVar.type, lVar.jru);
        return pVar;
    }

    public final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        boolean z2 = false;
        super.a(view, aVar, z);
        if (aVar instanceof c) {
            int i = 0;
            while (i < this.jvp.size()) {
                com.tencent.mm.plugin.fts.a.d.e.a aVar2 = (com.tencent.mm.plugin.fts.a.d.e.a) this.jvp.get(i);
                if (aVar2.jtc == aVar.position) {
                    if (!aVar2.jtf) {
                        z2 = true;
                    }
                    aVar2.jtf = z2;
                } else {
                    i++;
                }
            }
        }
        return true;
    }

    protected int aQR() {
        return 2;
    }
}
