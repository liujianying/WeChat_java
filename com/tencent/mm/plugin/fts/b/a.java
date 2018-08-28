package com.tencent.mm.plugin.fts.b;

import android.database.Cursor;
import android.support.design.a$i;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.PluginFTS;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.c$a;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.j;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import junit.framework.AssertionFailedError;

public final class a extends b {
    private static Set<String> jtI = new HashSet();
    private m dhW;
    private j iXo;
    private com.tencent.mm.sdk.e.m.b jtA = new 1(this);
    private com.tencent.mm.sdk.e.m.b jtB = new 2(this);
    private com.tencent.mm.sdk.e.j.a jtC = new 3(this);
    private com.tencent.mm.sdk.e.j.a jtD = new 4(this);
    private com.tencent.mm.sdk.b.c jtE = new 5(this);
    private com.tencent.mm.sdk.b.c jtF = new 6(this);
    private al jtG = new al(g.Em().lnJ.getLooper(), new 7(this), true);
    private al jtH = new al(g.Em().lnJ.getLooper(), new 8(this), false);
    private com.tencent.mm.plugin.fts.c.a jtu;
    private HashSet<String> jtv;
    private HashMap<String, List<Long>> jtw;
    private HashMap<String, String[]> jtx;
    private HashMap<String, List<Long>> jty;
    private Method jtz;

    private class a extends com.tencent.mm.plugin.fts.a.a.a {
        private int iXv;
        private int iXw;

        private a() {
            this.iXv = 0;
            this.iXw = 0;
        }

        /* synthetic */ a(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Start building chatroom index.");
            HashSet hashSet = new HashSet();
            Cursor rawQuery = a.this.jtu.jpT.rawQuery("SELECT DISTINCT chatroom FROM FTS5ChatRoomMembers;", null);
            while (rawQuery.moveToNext()) {
                hashSet.add(rawQuery.getString(0));
            }
            rawQuery.close();
            Cursor h = a.this.iXo.h("SELECT chatroomname, memberlist FROM chatroom;", null);
            int i = 5;
            while (h.moveToNext()) {
                if (Thread.interrupted()) {
                    h.close();
                    a.this.jtu.commit();
                    throw new InterruptedException();
                }
                String string = h.getString(0);
                Object split = c$a.jqy.split(h.getString(1));
                a.this.jtx.put(string, split);
                if (!hashSet.remove(string)) {
                    if (i >= 5) {
                        a.this.jtu.commit();
                        a.this.jtu.beginTransaction();
                        i = 0;
                    }
                    a.this.jtu.j(string, split);
                    i++;
                    this.iXv++;
                }
            }
            h.close();
            a.this.jtu.commit();
            Iterator it = hashSet.iterator();
            int i2 = 5;
            while (it.hasNext()) {
                String str = (String) it.next();
                if (i2 >= 5) {
                    a.this.jtu.commit();
                    a.this.jtu.beginTransaction();
                    i2 = 0;
                }
                a.this.jtu.CK(str);
                i = i2 + 1;
                this.iXw++;
                i2 = i;
            }
            a.this.jtu.commit();
            return true;
        }

        public final String getName() {
            return "BuildChatroomIndexTask";
        }

        public final String afC() {
            return String.format("{new: %d removed: %d}", new Object[]{Integer.valueOf(this.iXv), Integer.valueOf(this.iXw)});
        }

        public final int getId() {
            return 3;
        }
    }

    private class c extends com.tencent.mm.plugin.fts.a.a.a {
        private c() {
        }

        /* synthetic */ c(a aVar, byte b) {
            this();
        }

        public final boolean execute() {
            a.this.jtu.k(com.tencent.mm.plugin.fts.a.c.jqi);
            return true;
        }

        public final String getName() {
            return "DeleteAllFriendTask";
        }
    }

    private class e extends com.tencent.mm.plugin.fts.a.a.a {
        private String cYO;
        private boolean dio = false;

        public e(String str) {
            this.cYO = str;
        }

        public final boolean execute() {
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Insert Contact %s", new Object[]{this.cYO});
            ab Co = a.this.iXo.Co(this.cYO);
            if (Co == null || Co.field_username.length() <= 0 || !a.this.E(Co)) {
                this.dio = true;
            } else {
                a.this.F(Co);
            }
            a.this.jtw.remove(this.cYO);
            a.this.jtv.remove(this.cYO);
            return true;
        }

        public final String afC() {
            return String.format("{username: %s isSkipped: %b}", new Object[]{this.cYO, Boolean.valueOf(this.dio)});
        }

        public final String getName() {
            return "InsertContactTask";
        }
    }

    private class h extends com.tencent.mm.plugin.fts.a.a.a {
        private String cYO;
        private boolean dio = false;
        private boolean jud = false;

        public h(String str) {
            this.cYO = str;
        }

        public final boolean execute() {
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Dirty Contact %s", new Object[]{this.cYO});
            if (a.this.jtw.containsKey(this.cYO)) {
                this.jud = true;
            } else {
                a.this.jtu.Cs(this.cYO);
                List c = a.this.jtu.c(com.tencent.mm.plugin.fts.a.c.jqk, this.cYO);
                a.this.jtw.put(this.cYO, c);
                if (c.isEmpty()) {
                    this.dio = true;
                    a.this.dhW.a(65556, new e(this.cYO));
                } else {
                    Cursor CJ = a.this.jtu.CJ(this.cYO);
                    HashSet hashSet = new HashSet();
                    while (CJ.moveToNext()) {
                        hashSet.add(CJ.getString(0));
                    }
                    CJ.close();
                    Iterator it = hashSet.iterator();
                    while (it.hasNext()) {
                        String str = (String) it.next();
                        a.this.jtu.Cs(str);
                        if (!a.this.jtw.containsKey(str)) {
                            a.this.jtw.put(str, a.this.jtu.c(com.tencent.mm.plugin.fts.a.c.jqk, str));
                        }
                    }
                    a.this.jtv.remove(this.cYO);
                    ((PluginFTS) g.n(PluginFTS.class)).getTopHitsLogic().CH(this.cYO);
                }
            }
            return true;
        }

        public final String afC() {
            return String.format("{username: %s cached: %b isSkipped: %b}", new Object[]{this.cYO, Boolean.valueOf(this.jud), Boolean.valueOf(this.dio)});
        }

        public final String getName() {
            return "MarkContactDirtyTask";
        }

        public final int getId() {
            return 17;
        }
    }

    private class l extends com.tencent.mm.plugin.fts.a.a.h {
        public l(i iVar) {
            super(iVar);
        }

        protected final void a(com.tencent.mm.plugin.fts.a.a.j jVar) {
            int i = 0;
            super.a(jVar);
            com.tencent.mm.plugin.fts.c.a a = a.this.jtu;
            String str = this.jsj.bWm;
            Cursor rawQuery = a.jpT.rawQuery("SELECT count(*) FROM FTS5ChatRoomMembers WHERE member=?", new String[]{str});
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
            rawQuery.close();
            com.tencent.mm.plugin.fts.a.a.l lVar = new com.tencent.mm.plugin.fts.a.a.l();
            lVar.userData = Integer.valueOf(i);
            jVar.jsx = new ArrayList();
            jVar.jsx.add(lVar);
        }

        public final String getName() {
            return "SearchChatroomCountTask";
        }
    }

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        com.tencent.mm.plugin.fts.a.a.a lVar;
        switch (iVar.jsn) {
            case 5:
                lVar = new l(iVar);
                break;
            case 6:
                lVar = new k(this, iVar);
                break;
            case 7:
                lVar = new m(this, iVar);
                break;
            case 8:
                lVar = new o(this, iVar);
                break;
            case 9:
                lVar = new p(this, iVar);
                break;
            case 16:
                lVar = new q(this, iVar);
                break;
            case a$i.AppCompatTheme_actionModeCutDrawable /*32*/:
                lVar = new n(this, iVar);
                break;
            case a$i.AppCompatTheme_homeAsUpIndicator /*48*/:
                lVar = new t(this, iVar);
                break;
            case 64:
                lVar = new s(this, iVar);
                break;
            case 96:
                lVar = new r(this, iVar);
                break;
            default:
                lVar = new j(this, iVar);
                break;
        }
        return this.dhW.a(-65536, lVar);
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Success!");
            this.jtu = (com.tencent.mm.plugin.fts.c.a) ((n) g.n(n.class)).getFTSIndexStorage(3);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.iXo = ((n) g.n(n.class)).getFTSMainDB();
            this.jtv = new HashSet();
            this.jtw = new HashMap();
            this.jtx = new HashMap();
            this.jty = new HashMap();
            try {
                this.jtz = ai.class.getDeclaredMethod("wS", new Class[0]);
                this.jtz.setAccessible(true);
                this.dhW.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, new f(this, (byte) 0));
                this.dhW.a(131082, new a(this, (byte) 0));
                this.dhW.a(131092, new b(this, (byte) 0));
                this.dhW.a(Integer.MAX_VALUE, new c(this, (byte) 0));
                ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().c(this.jtC);
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().a(this.jtB);
                ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().a(this.jtA);
                com.tencent.mm.sdk.e.j.a aVar = this.jtD;
                if (com.tencent.mm.am.b.dYB != null) {
                    com.tencent.mm.am.b.dYB.a(aVar);
                }
                this.jtG.J(600000, 600000);
                this.jtE.cht();
                this.jtF.cht();
                return true;
            } catch (Throwable e) {
                AssertionFailedError assertionFailedError = new AssertionFailedError("Can't find BaseContact.parseBuff method, class prototype has changed.");
                assertionFailedError.initCause(e);
                throw assertionFailedError;
            }
        }
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        this.jtE.dead();
        this.jtF.dead();
        this.jtH.SO();
        this.jtG.SO();
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().b(this.jtB);
        ((com.tencent.mm.plugin.chatroom.b.b) g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().d(this.jtC);
        ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FW().b(this.jtA);
        com.tencent.mm.sdk.e.j.a aVar = this.jtD;
        if (com.tencent.mm.am.b.dYB != null) {
            com.tencent.mm.am.b.dYB.b(aVar);
        }
        if (this.jtw != null) {
            this.jtw.clear();
        }
        if (this.jtv != null) {
            this.jtv.clear();
        }
        this.jtu = null;
        this.dhW = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchContactLogic";
    }

    final int a(String str, ab abVar, String[] strArr, byte[] bArr, HashMap<String, ab> hashMap) {
        int i = 0;
        String str2 = abVar.field_nickname;
        String av = d.av(str2, false);
        String av2 = d.av(str2, true);
        long j = 0;
        long Cq = this.iXo.Cq(str);
        StringBuffer stringBuffer = new StringBuffer();
        if (strArr != null) {
            j = (long) strArr.length;
            HashMap hashMap2 = new HashMap();
            com.tencent.mm.i.a.a.a aVar = new com.tencent.mm.i.a.a.a();
            try {
                aVar.aG(bArr);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "parse chatroom data", new Object[0]);
            }
            Iterator it = aVar.dav.iterator();
            while (it.hasNext()) {
                com.tencent.mm.i.a.a.b bVar = (com.tencent.mm.i.a.a.b) it.next();
                if (!bi.oW(bVar.daA)) {
                    hashMap2.put(bVar.userName, bVar.daA);
                }
            }
            int length = strArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                }
                String str3 = strArr[i3];
                ab abVar2 = (ab) hashMap.get(str3);
                if (abVar2 != null) {
                    String str4 = abVar2.field_conRemark;
                    String str5 = abVar2.field_nickname;
                    String av3 = d.av(str4, false);
                    String av4 = d.av(str4, true);
                    stringBuffer.append(bi.aG(str4, " ")).append("‌");
                    stringBuffer.append(bi.aG(av3, " ")).append("‌");
                    stringBuffer.append(bi.aG(av4, " ")).append("‌");
                    str4 = d.av(str5, false);
                    av3 = d.av(str5, true);
                    stringBuffer.append(bi.aG(str5, " ")).append("‌");
                    stringBuffer.append(bi.aG(str4, " ")).append("‌");
                    stringBuffer.append(bi.aG(av3, " ")).append("‌");
                    stringBuffer.append(bi.aG((String) hashMap2.get(str3), " ")).append("‌");
                    C(abVar2);
                    stringBuffer.append(bi.aG(abVar2.csT, " ")).append("‌");
                    stringBuffer.append(bi.aG(d.cS(str3, abVar2.wM()), " ")).append("‌");
                    stringBuffer.append("​");
                }
                i2 = i3 + 1;
            }
        }
        if (!bi.oW(str2)) {
            this.jtu.a(131075, 5, j, str, Cq, str2);
            if (bi.oW(av)) {
                i = 1;
            } else {
                this.jtu.a(131075, 6, j, str, Cq, av);
                i = 2;
            }
            if (!bi.oW(av2)) {
                this.jtu.a(131075, 7, j, str, Cq, av2);
                i++;
            }
        }
        if (stringBuffer.length() <= 0) {
            return i;
        }
        stringBuffer.setLength(stringBuffer.length() - 1);
        this.jtu.a(131075, 38, j, str, Cq, stringBuffer.toString());
        return i + 1;
    }

    public final int i(String str, String[] strArr) {
        int simpleQueryForLong;
        String[] strArr2 = (String[]) this.jtx.get(str);
        this.jtu.beginTransaction();
        if (strArr2 == null) {
            this.jtu.CK(str);
            simpleQueryForLong = ((int) this.jtu.jvg.simpleQueryForLong()) + 0;
            if (strArr != null) {
                this.jtu.j(str, strArr);
                this.jtx.put(str, strArr);
                simpleQueryForLong += strArr.length;
            }
        } else if (strArr == null) {
            this.jtu.CK(str);
            simpleQueryForLong = ((int) this.jtu.jvg.simpleQueryForLong()) + 0;
            this.jtx.remove(str);
        } else {
            HashSet hashSet = new HashSet(Arrays.asList(strArr2));
            int i = 0;
            for (String str2 : strArr) {
                if (!hashSet.remove(str2)) {
                    com.tencent.mm.plugin.fts.c.a aVar = this.jtu;
                    aVar.jva.bindString(1, str);
                    aVar.jva.bindString(2, str2);
                    aVar.jva.execute();
                    i++;
                }
            }
            Iterator it = hashSet.iterator();
            while (true) {
                simpleQueryForLong = i;
                if (!it.hasNext()) {
                    break;
                }
                String str3 = (String) it.next();
                com.tencent.mm.plugin.fts.c.a aVar2 = this.jtu;
                aVar2.jvb.bindString(1, str);
                aVar2.jvb.bindString(2, str3);
                aVar2.jvb.execute();
                i = simpleQueryForLong + 1;
            }
            this.jtx.put(str, strArr);
        }
        this.jtu.commit();
        return simpleQueryForLong;
    }

    final void C(ab abVar) {
        try {
            this.jtz.invoke(abVar, new Object[0]);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FTS.FTS5SearchContactLogic", e, "Failed parsing RContact LVBuffer.", new Object[0]);
        }
    }

    static boolean CE(String str) {
        if (bi.oW(str) || str.endsWith("@stranger") || str.endsWith("@qqim") || str.endsWith("@app") || str.startsWith("fake_")) {
            return false;
        }
        return true;
    }

    static boolean D(ab abVar) {
        if ((abVar.isHidden() && !"notifymessage".equals(abVar.field_username)) || abVar.BA() || abVar.field_deleteFlag != 0) {
            return false;
        }
        if (com.tencent.mm.l.a.gd(abVar.field_type) || (!abVar.Bz() && !abVar.ckW())) {
            return true;
        }
        return false;
    }

    final boolean E(ab abVar) {
        String str = abVar.field_username;
        if (!D(abVar) || !CE(str)) {
            return false;
        }
        if (com.tencent.mm.l.a.gd(abVar.field_type)) {
            return true;
        }
        if (abVar.Bz() || abVar.ckW() || !this.iXo.Cp(str)) {
            return false;
        }
        return true;
    }

    final int F(ab abVar) {
        byte[] blob;
        if (!s.fq(abVar.field_username)) {
            return G(abVar);
        }
        String format = String.format("SELECT memberlist, roomdata FROM %s WHERE chatroomname = ?", new Object[]{"chatroom"});
        Cursor h = this.iXo.h(format, new String[]{abVar.field_username});
        CharSequence string;
        try {
            if (h.moveToNext()) {
                string = h.getString(0);
                blob = h.getBlob(1);
            } else {
                blob = null;
                string = null;
            }
            if (h != null) {
                h.close();
            }
            if (bi.oW(string) || blob == null) {
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "error chatroom data %s", new Object[]{abVar.field_username});
                if (i(abVar.field_username, null) <= 0) {
                    return 0;
                }
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{abVar.field_username, Integer.valueOf(i(abVar.field_username, null))});
                return 0;
            }
            String[] split = c$a.jqy.split(string);
            Arrays.sort(split, new 9(this));
            if (i(abVar.field_username, split) > 0) {
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{abVar.field_username, Integer.valueOf(i(abVar.field_username, split))});
            }
            HashMap hashMap = new HashMap();
            Cursor h2 = this.iXo.h("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.v(split) + ";", null);
            while (h2.moveToNext()) {
                try {
                    ab abVar2 = new ab();
                    abVar2.dhP = h2.getLong(0);
                    abVar2.setUsername(h2.getString(1));
                    abVar2.du(h2.getString(2));
                    abVar2.dv(h2.getString(3));
                    abVar2.dx(h2.getString(4));
                    abVar2.B(h2.getBlob(5));
                    hashMap.put(abVar2.field_username, abVar2);
                } finally {
                    if (h2 != null) {
                        h2.close();
                    }
                }
            }
            return a(abVar.field_username, abVar, split, blob, hashMap);
        } catch (Throwable th) {
            if (h != null) {
                h.close();
            }
            String[] split2 = c$a.jqy.split(string);
            Arrays.sort(split2, new 9(this));
            if (i(abVar.field_username, split2) > 0) {
                x.i("MicroMsg.FTS.FTS5SearchContactLogic", "updateChatroomMember %s %d", new Object[]{abVar.field_username, Integer.valueOf(i(abVar.field_username, split2))});
            }
            HashMap hashMap2 = new HashMap();
            Cursor h22 = this.iXo.h("SELECT rowid, username, alias, conRemark, nickname , lvbuff FROM rcontact WHERE username IN " + d.v(split2) + ";", null);
            while (h22.moveToNext()) {
                try {
                    ab abVar22 = new ab();
                    abVar22.dhP = h22.getLong(0);
                    abVar22.setUsername(h22.getString(1));
                    abVar22.du(h22.getString(2));
                    abVar22.dv(h22.getString(3));
                    abVar22.dx(h22.getString(4));
                    abVar22.B(h22.getBlob(5));
                    hashMap2.put(abVar22.field_username, abVar22);
                } finally {
                    if (h22 != null) {
                        h22.close();
                    }
                }
            }
            return a(abVar.field_username, abVar, split2, blob, hashMap2);
        }
    }

    final int G(ab abVar) {
        int i;
        int i2;
        String str;
        int i3;
        String str2;
        String str3;
        String str4;
        String str5;
        long j = abVar.dhP;
        String str6 = abVar.field_username;
        String wM = abVar.wM();
        String str7 = abVar.field_nickname;
        String av = d.av(str7, false);
        String av2 = d.av(str7, true);
        String str8 = abVar.field_conRemark;
        String av3 = d.av(str8, false);
        String av4 = d.av(str8, true);
        String str9 = abVar.csT;
        String str10 = abVar.field_contactLabelIds;
        String str11 = abVar.csZ;
        int i4 = abVar.field_verifyFlag;
        String str12 = "";
        long currentTimeMillis = System.currentTimeMillis();
        if ((i4 & ab.ckY()) != 0) {
            i4 = 131076;
            i = 0;
            str12 = bi.c(((com.tencent.mm.api.h) g.l(com.tencent.mm.api.h.class)).cC(str6), "​");
        } else if (ab.XR(str6)) {
            i4 = 131081;
            i = 0;
        } else {
            currentTimeMillis = this.iXo.Cq(str6);
            if (str10 == null || str10.length() <= 0) {
                i = 0;
                i4 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            } else {
                if (str10 != null) {
                    Object substring;
                    if (str10.endsWith("\u0000")) {
                        substring = str10.substring(0, str10.length() - 1);
                    } else {
                        String substring2 = str10;
                    }
                    if (substring2.length() == 0) {
                        i2 = 0;
                    } else {
                        List arrayList;
                        String[] split = c$a.jqF.split(substring2);
                        List list;
                        if (split.length != 0) {
                            arrayList = new ArrayList(split.length);
                            for (String str13 : split) {
                                arrayList.add(Long.valueOf(bi.getLong(str13, 0)));
                            }
                            list = arrayList;
                        } else {
                            list = null;
                        }
                        arrayList = (List) this.jty.get(str6);
                        if (arrayList == null) {
                            this.jtu.CI(str6);
                            if (!(list == null || list.isEmpty())) {
                                this.jtu.h(str6, list);
                                this.jty.put(str6, list);
                            }
                        } else if (list == null || list.isEmpty()) {
                            this.jtu.CI(str6);
                            this.jty.remove(str6);
                        } else {
                            long longValue;
                            com.tencent.mm.plugin.fts.c.a aVar;
                            HashSet hashSet = new HashSet(arrayList);
                            for (Long longValue2 : list) {
                                longValue = longValue2.longValue();
                                if (!hashSet.remove(Long.valueOf(longValue))) {
                                    aVar = this.jtu;
                                    aVar.jvd.bindString(1, str6);
                                    aVar.jvd.bindLong(2, longValue);
                                    aVar.jvd.execute();
                                }
                            }
                            Iterator it = hashSet.iterator();
                            while (it.hasNext()) {
                                longValue = ((Long) it.next()).longValue();
                                aVar = this.jtu;
                                aVar.jve.bindString(1, str6);
                                aVar.jve.bindLong(2, longValue);
                                aVar.jve.execute();
                            }
                            this.jty.put(str6, list);
                        }
                        arrayList = this.iXo.Cr(substring2);
                        if (arrayList.size() == 0) {
                            i2 = 0;
                        } else {
                            this.jtu.a(WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT, 11, j, str6, currentTimeMillis, bi.c(arrayList, "​"));
                            i2 = 1;
                        }
                    }
                } else {
                    i2 = 0;
                }
                i = i2 + 0;
                i4 = WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT;
            }
        }
        String cS = d.cS(str6, wM);
        if (cS == null || cS.length() == 0) {
            i3 = i;
        } else {
            this.jtu.a(i4, 15, j, str6, currentTimeMillis, cS);
            i3 = i + 1;
        }
        if (str8 == null || str8.length() == 0) {
            str13 = null;
            str2 = null;
            str10 = av2;
            str3 = av;
            cS = str7;
            str4 = null;
        } else {
            str10 = av4;
            str3 = av3;
            cS = str8;
            str2 = av2;
            str13 = av;
            str4 = str7;
        }
        if (!(cS == null || cS.length() == 0)) {
            if (cS.equalsIgnoreCase(str3)) {
                av4 = null;
            } else {
                av4 = str3;
            }
            if (av4 == null || av4.length() == 0 || av4.equalsIgnoreCase(str10)) {
                str5 = null;
            } else {
                str5 = str10;
            }
            this.jtu.a(i4, 1, j, str6, currentTimeMillis, cS);
            if (!(av4 == null || av4.length() == 0)) {
                this.jtu.a(i4, 2, j, str6, currentTimeMillis, av4);
            }
            if (!(str5 == null || str5.length() == 0)) {
                this.jtu.a(i4, 3, j, str6, currentTimeMillis, str5);
            }
            i3 += 3;
        }
        if (str4 == null || str4.length() == 0) {
            i = i3;
        } else {
            if (str4.equalsIgnoreCase(str13)) {
                str13 = null;
            }
            if (str13 == null || str13.length() == 0 || str13.equalsIgnoreCase(str2)) {
                str5 = null;
            } else {
                str5 = str2;
            }
            this.jtu.a(i4, 5, j, str6, currentTimeMillis, str4);
            if (!(str13 == null || str13.length() == 0)) {
                this.jtu.a(i4, 6, j, str6, currentTimeMillis, str13);
            }
            if (!(str5 == null || str5.length() == 0)) {
                this.jtu.a(i4, 7, j, str6, currentTimeMillis, str5);
            }
            i = i3 + 3;
        }
        if (str9 != null && str9.length() > 0) {
            this.jtu.a(i4, 4, j, str6, currentTimeMillis, str9);
            i++;
        }
        if (i4 == WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT) {
            if (bi.oW(str11)) {
                Cursor h = this.iXo.h("SELECT moblie FROM addr_upload2 WHERE username=?;", new String[]{str6});
                if (h.moveToFirst()) {
                    this.jtu.a(i4, 16, j, str6, currentTimeMillis, h.getString(0));
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                h.close();
                i = i2;
            } else {
                this.jtu.a(i4, 16, j, str6, currentTimeMillis, str11.replace(",", "​"));
                i++;
            }
            cS = abVar.getProvince();
            if (jtI.contains(cS)) {
                cS = "";
            }
            if (!(cS == null || cS.length() == 0)) {
                this.jtu.a(i4, 18, j, str6, currentTimeMillis, cS);
                i++;
            }
            cS = abVar.getCity();
            if (!(cS == null || cS.length() == 0)) {
                this.jtu.a(i4, 17, j, str6, currentTimeMillis, cS);
                i++;
            }
        }
        if (i4 == 131076 && !bi.oW(str12)) {
            this.jtu.a(i4, 19, j, str6, currentTimeMillis, str12);
            i++;
            cS = d.av(str12, false);
            if (!bi.oW(cS)) {
                this.jtu.a(i4, 20, j, str6, currentTimeMillis, cS);
                i++;
            }
            cS = d.av(str12, true);
            if (!bi.oW(cS)) {
                this.jtu.a(i4, 21, j, str6, currentTimeMillis, cS);
                i2 = i + 1;
                if (i4 != 131081) {
                    return i2 + a(abVar, currentTimeMillis);
                }
                return i2;
            }
        }
        i2 = i;
        if (i4 != 131081) {
            return i2;
        }
        return i2 + a(abVar, currentTimeMillis);
    }

    private int a(ab abVar, long j) {
        String str = abVar.cte;
        if (bi.oW(str)) {
            return 0;
        }
        com.tencent.mm.openim.a.c cVar = new com.tencent.mm.openim.a.c();
        cVar.oE(str);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < cVar.eul.size(); i++) {
            for (com.tencent.mm.openim.a.c.b oF : ((com.tencent.mm.openim.a.c.a) cVar.eul.get(i)).eum) {
                str = oF.oF(abVar.field_openImAppid);
                if (!bi.oW(str)) {
                    stringBuffer.append(str);
                    stringBuffer.append("‌");
                }
            }
            stringBuffer.append("​");
        }
        if (bi.oW(stringBuffer.toString())) {
            return 0;
        }
        x.i("MicroMsg.FTS.FTS5SearchContactLogic", "buildOpenIMContact %s", new Object[]{stringBuffer.toString()});
        this.jtu.a(131081, 51, abVar.dhP, abVar.field_username, j, stringBuffer.toString());
        return 1;
    }

    static {
        String[] split = ad.getContext().getString(com.tencent.mm.plugin.fts.h.a.country_others).split(";");
        if (split != null) {
            for (Object add : split) {
                jtI.add(add);
            }
        }
    }
}
