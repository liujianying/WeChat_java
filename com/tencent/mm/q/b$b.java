package com.tencent.mm.q;

import android.database.Cursor;
import com.tencent.map.lib.gl.model.GLIcon;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.q.b.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

class b$b extends a {
    final /* synthetic */ b dhZ;
    public boolean dif;
    private HashSet<Long> dig;
    private long dih;
    private int dii;
    private HashMap<int[], e> dij;

    private b$b(b bVar) {
        this.dhZ = bVar;
        this.dif = false;
        this.dig = null;
        this.dih = Long.MIN_VALUE;
        this.dii = -1;
        this.dij = new HashMap();
    }

    /* synthetic */ b$b(b bVar, byte b) {
        this(bVar);
    }

    public final boolean execute() {
        x.i("MicroMsg.FTS.FTS5SearchFriendLogic", "Start building friend index.");
        this.dif = b.BU();
        if (this.dii < 0) {
            this.dii = 0;
        }
        x.d("MicroMsg.FTS.FTS5SearchFriendLogic", "[BuildFriendIndexTask mBuildMobileIndex : %s, mCurrentTask : %d]", new Object[]{Boolean.valueOf(this.dif), Integer.valueOf(this.dii)});
        if (this.dii == 0) {
            if (this.dif) {
                if (!this.dij.containsKey(c.jqm)) {
                    this.dij.put(c.jqm, new e((byte) 0));
                }
                if (this.dig == null) {
                    this.dig = new HashSet();
                    Cursor a = this.dhZ.dhX.a(c.jqm, false, true, false, false, false);
                    while (a.moveToNext()) {
                        this.dig.add(Long.valueOf(a.getLong(0)));
                    }
                    a.close();
                }
                if (Thread.interrupted()) {
                    throw new InterruptedException();
                }
                int i;
                e eVar;
                Cursor h = ((n) g.n(n.class)).getFTSMainDB().h("SELECT id, realname, realnamequanpin, realnamepyinitial, nickname, nicknamequanpin, nicknamepyinitial, username, status, moblie FROM addr_upload2 WHERE id > ? AND type=0 ORDER BY id;", new String[]{Long.toString(this.dih)});
                int i2 = 50;
                while (h.moveToNext()) {
                    if (Thread.interrupted()) {
                        h.close();
                        this.dhZ.dhX.commit();
                        throw new InterruptedException();
                    }
                    long j = h.getLong(0);
                    this.dih = j;
                    b$a b_a = new b$a();
                    b_a.id = j;
                    b_a.dia = h.getString(1);
                    b_a.dib = h.getString(2);
                    b_a.dic = h.getString(3);
                    b_a.bgn = h.getString(4);
                    b_a.did = h.getString(5);
                    b_a.die = h.getString(6);
                    b_a.userName = h.getString(7);
                    b_a.status = h.getInt(8);
                    b_a.bTi = h.getString(9);
                    b_a.type = 0;
                    if (b_a.status == GLIcon.RIGHT) {
                        b_a.status = 0;
                    }
                    if (b.a(b_a) && !this.dig.remove(Long.valueOf(b_a.id))) {
                        if (i2 >= 50) {
                            this.dhZ.dhX.commit();
                            this.dhZ.dhX.beginTransaction();
                            i = 0;
                        } else {
                            i = i2;
                        }
                        try {
                            i += b.a(this.dhZ, b_a);
                            eVar = (e) this.dij.get(c.jqm);
                            eVar.dim++;
                            i2 = i;
                        } catch (Throwable e) {
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchFriendLogic", e, "Build mobile friend index failed with exception.", new Object[0]);
                            eVar = (e) this.dij.get(c.jqm);
                            eVar.mFailedCount++;
                            i2 = i;
                        }
                    }
                }
                h.close();
                this.dhZ.dhX.commit();
                Iterator it = this.dig.iterator();
                i2 = 50;
                while (it.hasNext()) {
                    if (i2 >= 50) {
                        this.dhZ.dhX.commit();
                        this.dhZ.dhX.beginTransaction();
                        i = 0;
                    } else {
                        i = i2;
                    }
                    this.dhZ.dhX.b(c.jqm, ((Long) it.next()).longValue());
                    i++;
                    eVar = (e) this.dij.get(c.jqm);
                    eVar.din++;
                    it.remove();
                    i2 = i;
                }
                this.dhZ.dhX.commit();
                this.dig = null;
                this.dih = Long.MIN_VALUE;
            }
            this.dii = -1;
        }
        return true;
    }

    public final String toString() {
        return this.dij.containsKey(c.jqm) ? "BuildFriendIndex IDXTYPE_SET_CONTACT_FRIEND [new: " + ((e) this.dij.get(c.jqm)).dim + ", removed: " + ((e) this.dij.get(c.jqm)).din + ", failed: " + ((e) this.dij.get(c.jqm)).mFailedCount + "]" : "";
    }

    public final int getId() {
        return 2;
    }

    public final String getName() {
        return "BuildFriendIndexTask";
    }
}
