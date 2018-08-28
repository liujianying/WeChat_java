package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.b;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public abstract class a extends b implements l {
    public String bWm;
    HashSet<String> jst = new HashSet();
    private com.tencent.mm.plugin.fts.a.a.a jsw;
    public List<com.tencent.mm.plugin.fts.a.d.e.a> jvp = Collections.synchronizedList(new LinkedList());

    public abstract com.tencent.mm.plugin.fts.a.a.a a(ag agVar, HashSet<String> hashSet);

    public abstract com.tencent.mm.plugin.fts.a.d.a.a a(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar);

    public abstract void a(j jVar, HashSet<String> hashSet);

    public a(Context context, e.b bVar, int i) {
        super(context, bVar, i);
    }

    public final void a(String str, ag agVar, HashSet<String> hashSet) {
        aQe();
        acV();
        this.bWm = str;
        this.jsw = a(agVar, (HashSet) hashSet);
    }

    public final void aQe() {
        if (this.jsw != null) {
            ((n) g.n(n.class)).cancelSearchTask(this.jsw);
            this.jsw = null;
        }
    }

    public int qg(int i) {
        int size = this.jvp.size();
        int i2 = 0;
        int i3 = i;
        while (i2 < size) {
            int i4;
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.jvp.get(i2);
            aVar.jta = i3;
            if (aVar.jtb) {
                i3++;
            }
            i3 += aVar.jte.size() + aVar.jth;
            aVar.jtc = i3;
            if (aVar.jtd) {
                i4 = i3 + 1;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        return i3;
    }

    public final com.tencent.mm.plugin.fts.a.d.a.a qh(int i) {
        int size = this.jvp.size();
        for (int i2 = 0; i2 < size; i2++) {
            com.tencent.mm.plugin.fts.a.d.a.a b;
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.jvp.get(i2);
            if (aVar.jta == i && aVar.jtb) {
                b = b(i, aVar);
            } else if (aVar.jtc == i && aVar.jtd) {
                b = c(i, aVar);
            } else if (i <= aVar.jtc) {
                b = a(i, aVar);
            } else {
                b = null;
            }
            if (b != null) {
                if (b.position == aVar.jtc) {
                    b.jtj = false;
                }
                b.jsZ = this.jsZ;
                b.jrx = aVar.jrx;
                b.jtk = aVar.iPZ;
                return b;
            }
        }
        return null;
    }

    public k b(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        return new k(i);
    }

    public com.tencent.mm.plugin.fts.ui.a.n c(int i, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        com.tencent.mm.plugin.fts.ui.a.n nVar = new com.tencent.mm.plugin.fts.ui.a.n(i);
        nVar.jtm = aVar.jtc - aVar.jta;
        nVar.jts = true;
        return nVar;
    }

    public final void acV() {
        this.bWm = null;
        this.jst.clear();
        this.jvp.clear();
    }

    public final void b(j jVar) {
        switch (jVar.bjW) {
            case -3:
            case -2:
            case -1:
                x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "onSearchError: type=%d | errorCode=%d | originQuery=%s", new Object[]{Integer.valueOf(getType()), Integer.valueOf(jVar.bjW), jVar.joH.bWm});
                if (!jVar.joH.bWm.equals(this.bWm)) {
                    x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same Query");
                    return;
                }
                break;
            case 0:
                x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "search type %d | result %d", new Object[]{Integer.valueOf(getType()), Integer.valueOf(jVar.jsx.size())});
                if (this.bWm != null && this.bWm.equals(jVar.joH.bWm)) {
                    this.jst = jVar.joH.jst;
                    a(jVar, this.jst);
                    break;
                }
                x.i("MicroMsg.FTS.BaseNativeFTSUIUnit", "Native Search: Not Same query origin:%s current:%s", new Object[]{jVar.joH.bWm, this.bWm});
                return;
            default:
                return;
        }
        this.jsY.a(this, jVar.joH.bWm);
    }

    public final LinkedList<Integer> aQf() {
        LinkedList<Integer> linkedList = new LinkedList();
        int size = this.jvp.size();
        for (int i = 0; i < size; i++) {
            com.tencent.mm.plugin.fts.a.d.e.a aVar = (com.tencent.mm.plugin.fts.a.d.e.a) this.jvp.get(i);
            if (aVar.jta != Integer.MAX_VALUE) {
                linkedList.add(Integer.valueOf(aVar.jta));
            }
        }
        return linkedList;
    }

    public com.tencent.mm.plugin.fts.a.d.a.a a(int i, int i2, com.tencent.mm.plugin.fts.a.a.l lVar, com.tencent.mm.plugin.fts.a.d.e.a aVar) {
        return null;
    }

    public final int aQw() {
        int size = this.jvp.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            for (com.tencent.mm.plugin.fts.a.a.l lVar : ((com.tencent.mm.plugin.fts.a.d.e.a) this.jvp.get(i2)).jte) {
                String aG = bi.aG(lVar.jrv, "");
                Object obj = -1;
                switch (aG.hashCode()) {
                    case -19329355:
                        if (aG.equals("create_chatroom​")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 255180560:
                        if (aG.equals("no_result​")) {
                            obj = 2;
                            break;
                        }
                        break;
                    case 541269703:
                        if (aG.equals("create_talker_message​")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                    case 1:
                    case 2:
                        break;
                    default:
                        i++;
                        break;
                }
            }
        }
        return i;
    }

    public final int aQg() {
        return aQw();
    }
}
