package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class a$b extends a {
    final /* synthetic */ a jtJ;
    private HashSet<String> jtL;
    private HashMap<String, ab> jtM;
    private long jtN;
    private long jtO;
    private int jtP;
    private int jtQ;
    private int jtR;
    private int jtS;
    private int jtT;
    private int jtU;
    private int jtV;

    private a$b(a aVar) {
        this.jtJ = aVar;
        this.jtM = new HashMap();
        this.jtN = -1;
        this.jtO = -1;
        this.jtP = 0;
        this.jtQ = 0;
        this.jtR = 0;
        this.jtS = 0;
    }

    /* synthetic */ a$b(a aVar, byte b) {
        this(aVar);
    }

    public final boolean execute() {
        int i;
        long j;
        List list;
        Throwable e;
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building contact index.");
        CA("start");
        if (this.jtL == null) {
            this.jtL = new HashSet();
            Cursor a = a.a(this.jtJ).a(c.jqk, true, false, true, false, true);
            while (a.moveToNext()) {
                String string = a.getString(1);
                i = a.getInt(2);
                j = a.getLong(0);
                if (i == 1) {
                    list = (List) a.b(this.jtJ).get(string);
                    if (list == null) {
                        list = new ArrayList(16);
                        a.b(this.jtJ).put(string, list);
                    }
                    list.add(Long.valueOf(j));
                } else {
                    this.jtL.add(string);
                    if (i == 2) {
                        a.c(this.jtJ).add(string);
                    }
                }
            }
            a.close();
            this.jtT = a.b(this.jtJ).size();
            this.jtU = a.c(this.jtJ).size();
            this.jtV = this.jtL.size();
            if (this.jtV < 5) {
                this.jro |= 1;
            }
        }
        CA("getBuildContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        if (a.b(this.jtJ).size() > 0) {
            List arrayList = new ArrayList();
            for (List list2 : a.b(this.jtJ).values()) {
                arrayList.addAll(list2);
            }
            a.b(this.jtJ).clear();
            a.a(this.jtJ).bi(arrayList);
        }
        CA("deleteDirtyContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        String str;
        if (a.c(this.jtJ).size() > 0) {
            Iterator it = a.c(this.jtJ).iterator();
            while (it.hasNext()) {
                str = (String) it.next();
                a.a(this.jtJ).D(str, a.d(this.jtJ).Cq(str));
            }
            a.c(this.jtJ).clear();
        }
        CA("updateTimestampContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Cursor h = a.d(this.jtJ).h("SELECT ROWID, username, alias, conRemark, nickname, verifyFlag, type, lvbuff, contactLabelIds FROM rcontact WHERE ROWID > ? AND deleteFlag=0 ORDER BY ROWID;", new String[]{Long.toString(this.jtN)});
        i = 50;
        while (h.moveToNext()) {
            if (Thread.interrupted()) {
                h.close();
                a.a(this.jtJ).commit();
                throw new InterruptedException();
            }
            j = h.getLong(0);
            this.jtN = j;
            ab abVar = new ab();
            abVar.dhP = j;
            abVar.setUsername(h.getString(1));
            abVar.du(h.getString(2));
            abVar.dv(h.getString(3));
            abVar.dx(h.getString(4));
            abVar.eF(h.getInt(5));
            abVar.setType(h.getInt(6));
            abVar.B(h.getBlob(7));
            abVar.dE(h.getString(8));
            abVar.eH(0);
            this.jtM.put(abVar.field_username, abVar);
            if (!(s.fq(abVar.field_username) || !this.jtJ.E(abVar) || this.jtL.remove(abVar.field_username))) {
                if (i >= 50) {
                    a.a(this.jtJ).commit();
                    a.a(this.jtJ).beginTransaction();
                    i = 0;
                }
                try {
                    if (!abVar.field_username.endsWith("@chatroom") && (abVar.field_verifyFlag & ab.ckY()) == 0) {
                        this.jtJ.C(abVar);
                        abVar.clb();
                    }
                    i += this.jtJ.G(abVar);
                    this.jtQ++;
                } catch (Throwable e2) {
                    x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Build contact index failed with exception.\n", new Object[0]);
                    this.jtS++;
                }
            }
        }
        h.close();
        a.a(this.jtJ).commit();
        CA("buildWXContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Cursor h2 = a.d(this.jtJ).h("SELECT rowid, chatroomname, memberlist, roomdata FROM chatroom WHERE ROWID > ? ORDER BY ROWID;", new String[]{Long.toString(this.jtO)});
        i = 50;
        while (h2.moveToNext()) {
            if (Thread.interrupted()) {
                h2.close();
                a.a(this.jtJ).commit();
                throw new InterruptedException();
            }
            this.jtO = h2.getLong(0);
            String string2 = h2.getString(1);
            if (!this.jtL.remove(string2)) {
                CharSequence string3 = h2.getString(2);
                byte[] blob = h2.getBlob(3);
                int a2;
                try {
                    String[] split = c.a.jqy.split(string3);
                    Arrays.sort(split, new 1(this));
                    int i2 = i + this.jtJ.i(string2, split);
                    try {
                        a2 = i2 + this.jtJ.a(string2, (ab) this.jtM.get(string2), split, blob, this.jtM);
                        try {
                            this.jtP++;
                            i = a2;
                        } catch (Throwable e3) {
                            e2 = e3;
                            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Build contact index failed with exception.\n", new Object[0]);
                            this.jtS++;
                            i = a2;
                            if (i < 50) {
                                a.a(this.jtJ).commit();
                                a.a(this.jtJ).beginTransaction();
                                i = 0;
                            }
                        }
                    } catch (Throwable e32) {
                        e2 = e32;
                        a2 = i2;
                        x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Build contact index failed with exception.\n", new Object[0]);
                        this.jtS++;
                        i = a2;
                        if (i < 50) {
                            a.a(this.jtJ).commit();
                            a.a(this.jtJ).beginTransaction();
                            i = 0;
                        }
                    }
                } catch (Exception e4) {
                    e2 = e4;
                    a2 = i;
                    x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e2, "Build contact index failed with exception.\n", new Object[0]);
                    this.jtS++;
                    i = a2;
                    if (i < 50) {
                        a.a(this.jtJ).commit();
                        a.a(this.jtJ).beginTransaction();
                        i = 0;
                    }
                }
                if (i < 50) {
                    a.a(this.jtJ).commit();
                    a.a(this.jtJ).beginTransaction();
                    i = 0;
                }
            }
        }
        h2.close();
        a.a(this.jtJ).commit();
        CA("buildChatroomContact");
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        this.jtR = this.jtL.size();
        Iterator it2 = this.jtL.iterator();
        while (it2.hasNext()) {
            str = (String) it2.next();
            a.a(this.jtJ).b(c.jqk, str);
            ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic().d(c.jqk, str);
        }
        this.jtL.clear();
        this.jtM.clear();
        CA("deleteUnusedContact");
        ((PluginFTS) g.n(PluginFTS.class)).setFTSIndexReady(true);
        return true;
    }

    public final String afC() {
        return String.format("{build: %d newContact: %d, newChatroom: %d, remove: %d, dirty: %d, timestamp: %d, fail: %d}", new Object[]{Integer.valueOf(this.jtV), Integer.valueOf(this.jtQ), Integer.valueOf(this.jtP), Integer.valueOf(this.jtR), Integer.valueOf(this.jtT), Integer.valueOf(this.jtU), Integer.valueOf(this.jtS)});
    }

    public final String getName() {
        return "BuildContactIndexTask";
    }

    public final int getId() {
        return 1;
    }
}
