package com.tencent.mm.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.a.f;
import com.tencent.mm.bt.d;
import com.tencent.mm.bt.h;
import com.tencent.mm.model.s;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ay.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class ah extends m implements ay {
    public static final String[] ciG = new String[]{"CREATE UNIQUE INDEX IF NOT EXISTS  contact_username_unique_index ON rcontact ( username )", "CREATE INDEX IF NOT EXISTS  contact_alias_index ON rcontact ( alias )", "CREATE INDEX IF NOT EXISTS  en_username_unique_index ON rcontact ( encryptUsername )", "CREATE UNIQUE INDEX IF NOT EXISTS  bottle_username_unique_index ON bottlecontact ( username )", "CREATE INDEX IF NOT EXISTS type_verifyFlag_index ON rcontact ( type,verifyFlag ) "};
    public static final String[] diD = new String[]{i.a(ab.dhO, "rcontact"), i.a(ab.dhO, "bottlecontact"), i.a(ac.dhO, "ContactCmdBuf"), "CREATE TABLE IF NOT EXISTS contact ( contactID INTEGER PRIMARY KEY, sex INT, type INT, showHead INT, username VARCHAR(40), nickname VARCHAR(40), pyInitial VARCHAR(40), quanPin VARCHAR(60), reserved TEXT );", "CREATE TABLE IF NOT EXISTS contact_ext ( username VARCHAR(40), Uin INTEGER DEFAULT 0, Email VARCHAR(128), Mobile VARCHAR(40), ShowFlag INTEGER DEFAULT 0 , ConType INTEGER DEFAULT 0 , ConRemark TEXT, ConRemark_PYShort TEXT, ConRemark_PYFull TEXT, ConQQMBlog TEXT, ConSMBlog TEXT, DomainList TEXT, reserved1 INT DEFAULT 0 , reserved2 INT DEFAULT 0 , reserved3 INT DEFAULT 0 , reserved4 INT DEFAULT 0 , reserved5 INT DEFAULT 0 , reserved6 TEXT, reserved7 TEXT, reserved8 TEXT, reserved9 TEXT, reserved10 TEXT, weiboflag  INT DEFAULT 0 ,weibonickname TEXT  );"};
    private static String tau = "showHead = 32";
    private static String tav = "type & 64 !=0 ";
    private final k<a, ab> dKC = new k<a, ab>() {
        protected final /* synthetic */ void q(Object obj, Object obj2) {
            ((a) obj).a(ah.this, (ab) obj2);
        }
    };
    private e diF;
    private e tar;
    public final f<String, ab> tas = new f(200);
    public final f<String, Integer> tat = new f(400);

    private static String XZ(String str) {
        return "select *,rowid from " + Ya(str) + " ";
    }

    private static String Ya(String str) {
        if (ab.gY(str)) {
            return "bottlecontact";
        }
        return "rcontact";
    }

    public ah(h hVar) {
        int i = 1;
        int i2 = 0;
        Cursor b = hVar.b("PRAGMA table_info( contact_ext )", null, 2);
        int columnIndex = b.getColumnIndex("name");
        int i3 = 0;
        int i4 = 0;
        while (b.moveToNext() && (i4 == 0 || i3 == 0)) {
            if (columnIndex >= 0) {
                String string = b.getString(columnIndex);
                if ("weiboNickname".equalsIgnoreCase(string)) {
                    i3 = 1;
                } else if ("weiboFlag".equalsIgnoreCase(string)) {
                    i4 = 1;
                }
            }
        }
        b.close();
        if (i4 == 0) {
            hVar.fV("contact_ext", "Alter table contact_ext add weiboFlag INT DEFAULT 0 ");
        }
        if (i3 == 0) {
            hVar.fV("contact_ext", "Alter table contact_ext add weiboNickname INT DEFAULT 0 ");
        }
        Cursor b2 = hVar.b("PRAGMA table_info( rcontact )", null, 2);
        i4 = b2.getColumnIndex("name");
        while (b2.moveToNext()) {
            if (i4 >= 0) {
                if ("verifyFlag".equalsIgnoreCase(b2.getString(i4))) {
                    break;
                }
            }
        }
        i = 0;
        b2.close();
        if (i == 0) {
            hVar.fV("rcontact", "Alter table rcontact add verifyFlag INT DEFAULT 0 ");
        }
        for (String fV : i.a(com.tencent.mm.l.a.dhO, "bottlecontact", hVar)) {
            hVar.fV("bottlecontact", fV);
        }
        for (String fV2 : i.a(com.tencent.mm.l.a.dhO, "rcontact", hVar)) {
            hVar.fV("rcontact", fV2);
        }
        String[] strArr = ciG;
        i = strArr.length;
        while (i2 < i) {
            hVar.fV("rcontact", strArr[i2]);
            i2++;
        }
        this.diF = hVar;
        this.tar = hVar;
    }

    public final void a(a aVar) {
        this.dKC.a(aVar, null);
    }

    public final void b(a aVar) {
        if (this.dKC != null) {
            this.dKC.remove(aVar);
        }
    }

    public final ab Yb(String str) {
        ab abVar = (ab) this.tas.get(str);
        return abVar != null ? abVar : null;
    }

    public final void Q(ab abVar) {
        if (abVar != null && abVar.field_username != null && abVar.field_type != 0) {
            this.tas.m(abVar.field_username, abVar);
            this.tat.m(abVar.field_username, Integer.valueOf(abVar.field_type));
        }
    }

    private void Ck(String str) {
        if (!bi.oW(str)) {
            this.tas.remove(str);
            this.tat.remove(str);
        }
    }

    public final boolean Yc(String str) {
        if (bi.oW(str) || (str.contains("@") && !str.endsWith("@stranger"))) {
            return false;
        }
        Integer num = (Integer) this.tat.get(str);
        if (num != null) {
            return com.tencent.mm.l.a.gd(num.intValue());
        }
        ab Yg = Yg(str);
        if (Yg == null || !(Yg.field_username.equals(str) || str.equals(Yg.field_encryptUsername))) {
            this.tat.m(str, Integer.valueOf(0));
            return false;
        }
        this.tat.m(str, Integer.valueOf(Yg.field_type));
        return com.tencent.mm.l.a.gd(Yg.field_type);
    }

    public final boolean R(ab abVar) {
        if (Yi(abVar.field_username)) {
            if (a(abVar.field_username, abVar) == 0) {
                return true;
            }
            return false;
        } else if (U(abVar) < 0) {
            return false;
        } else {
            return true;
        }
    }

    public final ab Yd(String str) {
        if (bi.oW(str)) {
            return null;
        }
        ab abVar = new ab();
        Cursor b = this.diF.b("select *,rowid from rcontact where alias=" + h.fz(str), null, 2);
        if (b.moveToFirst()) {
            abVar.d(b);
            Q(abVar);
        }
        b.close();
        abVar.clb();
        return abVar;
    }

    public final Cursor a(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + e(str, str2, list) + dj(list2) + clp();
        x.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.diF.b(str3, null, 4);
        }
        com.tencent.mm.bt.a.f[] fVarArr = new com.tencent.mm.bt.a.f[2];
        String str4 = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact " + i(list, z2) + clq();
        x.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor b = this.diF.b(str4, null, 4);
        Cursor b2 = this.diF.b(str3, null, 4);
        if (!(b instanceof com.tencent.mm.bt.a.f) || !(b2 instanceof com.tencent.mm.bt.a.f)) {
            return d.cnR();
        }
        fVarArr[0] = (com.tencent.mm.bt.a.f) b;
        fVarArr[1] = (com.tencent.mm.bt.a.f) b2;
        return new com.tencent.mm.bt.a.e(fVarArr);
    }

    public final List<String> cli() {
        Cursor b = this.diF.b(" select acctTypeId from OpenIMAppIdInfo where appid in (" + (" select openImAppid from rcontact" + clv() + " group by openImAppid ") + ") group by acctTypeId", null, 4);
        List<String> linkedList = new LinkedList();
        if (b.moveToFirst()) {
            do {
                String string = b.getString(0);
                if (!bi.oW(string)) {
                    linkedList.add(string);
                }
            } while (b.moveToNext());
        }
        b.close();
        return linkedList;
    }

    public final Cursor a(List<String> list, String str, List<String> list2) {
        Iterator it;
        String str2;
        String str3 = ("select rcontact.username ,rcontact.nickname ,rcontact.alias,rcontact.conRemark,rcontact.verifyFlag,rcontact.showHead,rcontact.weiboFlag,rcontact.rowid ,rcontact.deleteFlag,rcontact.lvbuff,rcontact.descWordingId, rcontact.openImAppid,  OpenIMWordingInfo.wording, OpenIMWordingInfo.quanpin  from rcontact left join OpenIMWordingInfo on rcontact.descWordingId=OpenIMWordingInfo.wordingId " + " and OpenIMWordingInfo.language='" + str + "' ") + clv();
        String str4 = "";
        if (list2.size() > 0) {
            it = list2.iterator();
            while (true) {
                str2 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = (String) it.next();
                if (str2.equals("")) {
                    str2 = str2 + " and (";
                } else {
                    str2 = str2 + " or ";
                }
                str4 = str2 + "openImAppid == '" + str4 + "'";
            }
            str4 = str2 + " )";
        }
        str3 = str3 + str4;
        str4 = "";
        if (list != null && list.size() > 0) {
            it = list.iterator();
            while (true) {
                str2 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str2 + " and username != '" + ((String) it.next()) + "'";
            }
            str4 = str2;
        }
        x.v("MicroMsg.ContactStorage", "getOpenIMCursor:%s", new Object[]{(str3 + str4) + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin "});
        return this.diF.b((str3 + str4) + " order by OpenIMWordingInfo.quanpin IS NULL, OpenIMWordingInfo.quanpin ", null, 4);
    }

    public final Cursor df(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,type from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.diF.rawQuery(str + clp(), null);
    }

    public final Cursor dg(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.diF.rawQuery(str + clp(), null);
    }

    public final Cursor b(String str, String str2, List<String> list, List<String> list2, boolean z, boolean z2) {
        String str3 = "select username from rcontact " + e(str, str2, list) + dj(list2) + clp();
        x.v("MicroMsg.ContactStorage", str3);
        if (!z) {
            return this.diF.rawQuery(str3, null);
        }
        com.tencent.mm.bt.a.f[] fVarArr = new com.tencent.mm.bt.a.f[2];
        String str4 = "select username from rcontact " + i(list, z2) + clq();
        x.v("MicroMsg.ContactStorage", "favourSql " + str3);
        Cursor b = this.diF.b(str4, null, 4);
        Cursor b2 = this.diF.b(str3, null, 4);
        if (!(b instanceof com.tencent.mm.bt.a.f) || !(b2 instanceof com.tencent.mm.bt.a.f)) {
            return d.cnR();
        }
        fVarArr[0] = (com.tencent.mm.bt.a.f) b;
        fVarArr[1] = (com.tencent.mm.bt.a.f) b2;
        return new com.tencent.mm.bt.a.e(fVarArr);
    }

    public final ab Ye(String str) {
        if (bi.oW(str)) {
            return null;
        }
        if (ab.gY(str)) {
            str = ab.XV(str);
        }
        ab Yb = Yb(str);
        if (Yb != null) {
            Yb.clb();
            return Yb;
        }
        Yb = new ab();
        Cursor b = this.diF.b(XZ(str) + " where username=" + h.fz(str), null, 2);
        if (b.moveToFirst()) {
            Yb.d(b);
            Q(Yb);
        }
        b.close();
        Yb.clb();
        return Yb;
    }

    public final ab Yf(String str) {
        if (bi.oW(str)) {
            return null;
        }
        if (ab.gY(str)) {
            str = ab.XV(str);
        }
        ab Yb = Yb(str);
        if (Yb != null) {
            return Yb;
        }
        Yb = new ab();
        Cursor b = this.diF.b(XZ(str) + " where username=" + h.fz(str) + " or encryptUsername=" + h.fz(str), null, 2);
        if (b.moveToFirst()) {
            Yb.d(b);
            Q(Yb);
        }
        b.close();
        return Yb;
    }

    public final ab Yg(String str) {
        if (bi.oW(str)) {
            return null;
        }
        if (ab.gY(str)) {
            str = ab.XV(str);
        }
        ab Yb = Yb(str);
        if (Yb != null) {
            return Yb;
        }
        Yb = new ab();
        Cursor b = this.diF.b(XZ(str) + " where username=" + h.fz(str) + " or encryptUsername=" + h.fz(str), null, 2);
        if (b.moveToFirst()) {
            Yb.d(b);
            b.close();
            Yb.clb();
            Q(Yb);
        } else {
            b.close();
        }
        return Yb;
    }

    public final ab gl(long j) {
        ab abVar = null;
        if (j > 0) {
            Cursor b = this.diF.b("select * ,rowid from rcontact  where rowid=" + j, null, 2);
            if (b.moveToFirst()) {
                abVar = new ab();
                abVar.d(b);
                Q(abVar);
            }
            b.close();
            if (abVar != null) {
                abVar.clb();
            }
        }
        return abVar;
    }

    public final long Yh(String str) {
        ab Yg = Yg(str);
        if (Yg == null || Yg.dhP <= 0) {
            return -1;
        }
        return (long) ((int) Yg.dhP);
    }

    public final boolean Yi(String str) {
        ab Yg = Yg(str);
        if (Yg == null || bi.oW(Yg.field_username) || !Yg.field_username.equals(str)) {
            return false;
        }
        return true;
    }

    public final boolean Yj(String str) {
        boolean z = false;
        if (!bi.oW(str)) {
            Cursor b = this.diF.b("select count(*) from " + Ya(str) + " where type & " + com.tencent.mm.l.a.Bt() + " !=0 and username=" + h.fz(str), null, 2);
            if (b.moveToFirst() && b.getInt(0) > 0) {
                z = true;
            }
            b.close();
        }
        return z;
    }

    public final boolean S(ab abVar) {
        Assert.assertTrue("contact NULL !", abVar != null);
        if (!V(abVar)) {
            return true;
        }
        abVar.eD(abVar.AY());
        this.dKC.ci(abVar);
        this.dKC.doNotify();
        x.d("MicroMsg.ContactStorage", "replace : username=%s, showHead=%d, verifyFlag=%d", new Object[]{abVar.field_username, Integer.valueOf(abVar.field_showHead), Integer.valueOf(abVar.field_verifyFlag)});
        ContentValues wH = abVar.wH();
        if (((int) abVar.dhP) > 0) {
            wH.put("rowid", Integer.valueOf((int) abVar.dhP));
        }
        boolean z = this.diF.replace(Ya(abVar.field_username), com.tencent.mm.l.a.dhO.sKz, wH) > 0;
        Ck(abVar.field_username);
        if (!bi.oW(abVar.field_encryptUsername)) {
            Ck(abVar.field_encryptUsername);
        }
        if (!z) {
            return false;
        }
        b(4, this, abVar.field_username);
        return true;
    }

    public final boolean T(ab abVar) {
        return U(abVar) > 0;
    }

    public final int U(ab abVar) {
        if (bi.oV(abVar.field_username).length() <= 0) {
            x.e("MicroMsg.ContactStorage", "FATAL ERROR, invalid contact, empty username");
            return -1;
        }
        int i;
        abVar.eD(abVar.AY());
        this.dKC.ci(abVar);
        this.dKC.doNotify();
        int insert = (int) this.diF.insert(Ya(abVar.field_username), com.tencent.mm.l.a.dhO.sKz, abVar.wH());
        int bH = (int) bi.bH(System.currentTimeMillis());
        boolean z = b.foreground;
        com.tencent.mm.plugin.report.f fVar = com.tencent.mm.plugin.report.f.mDy;
        int i2 = z ? 11 : 14;
        if (z) {
            i = 12;
        } else {
            i = 15;
        }
        fVar.e(463, i2, i, bH, false);
        x.i("MicroMsg.ContactStorage", "insert : username=%s, showHead=%d, verifyFlag=%d, ret=:%d take[%s]ms fg:%b", new Object[]{abVar.field_username, Integer.valueOf(abVar.field_showHead), Integer.valueOf(abVar.field_verifyFlag), Integer.valueOf(insert), Integer.valueOf(bH), Boolean.valueOf(z)});
        if (insert != -1) {
            abVar.dhP = (long) insert;
            Q(abVar);
            b(2, this, abVar.field_username);
            return insert;
        }
        x.e("MicroMsg.ContactStorage", "insert failed: username=" + abVar.field_username);
        return -1;
    }

    public final int x(String str, byte[] bArr) {
        int i = -1;
        if (bi.oW(str)) {
            x.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return -1;
        }
        ac acVar = new ac();
        acVar.field_cmdbuf = bArr;
        acVar.field_username = str;
        int replace = (int) this.diF.replace("ContactCmdBuf", "username", acVar.wH());
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "setCmdbuf user:%s buf:%d result:%d";
        Object[] objArr = new Object[3];
        objArr[0] = str;
        if (bArr != null) {
            i = bArr.length;
        }
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(replace);
        x.d(str2, str3, objArr);
        return replace;
    }

    public final byte[] Yk(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ContactStorage", "getCmdbuf failed user is null");
            return null;
        }
        ac acVar = new ac();
        Cursor a = this.diF.a("ContactCmdBuf", null, "username=?", new String[]{str}, null, null, null, 2);
        if (a.moveToFirst()) {
            acVar.d(a);
        }
        a.close();
        String str2 = "MicroMsg.ContactStorage";
        String str3 = "getCmdbuf user:%s buf:%d";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = Integer.valueOf(acVar.field_cmdbuf == null ? -1 : acVar.field_cmdbuf.length);
        x.d(str2, str3, objArr);
        return acVar.field_cmdbuf;
    }

    public final int Yl(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ContactStorage", "delCmdBuf failed user is null");
            return -1;
        }
        x.d("MicroMsg.ContactStorage", "delCmdBuf user:%s ret:%d", new Object[]{str, Integer.valueOf(this.diF.delete("ContactCmdBuf", "username=?", new String[]{str}))});
        return this.diF.delete("ContactCmdBuf", "username=?", new String[]{str});
    }

    public final int Ym(String str) {
        Assert.assertTrue(str.length() > 0);
        if (ab.gY(str)) {
            str = ab.XV(str);
        }
        Ck(str);
        ab abVar = new ab(str);
        abVar.setType(0);
        abVar.setUsername("fake_" + bi.VF());
        abVar.dD("fake_" + bi.VF());
        int update = this.diF.update(Ya(str), abVar.wH(), "username=?", new String[]{str});
        Yl(str);
        x.w("MicroMsg.ContactStorage", "delete (because the fucking talker id , dk just mark it  disappear .) user:%s res:%s %s", new Object[]{str, Integer.valueOf(update), bi.cjd()});
        if (update != 0) {
            b(5, this, str);
        }
        return update;
    }

    public final int a(String str, ab abVar) {
        x.i("MicroMsg.ContactStorage", "begin to update contact : " + str);
        if (!V(abVar)) {
            return 1;
        }
        int update;
        long currentTimeMillis = System.currentTimeMillis();
        if (ab.gY(str)) {
            str = ab.XV(str);
        }
        abVar.eD(abVar.AY());
        this.dKC.ci(abVar);
        this.dKC.doNotify();
        ContentValues wH = abVar.wH();
        if (((int) abVar.dhP) > 0) {
            wH.put("rowid", Integer.valueOf((int) abVar.dhP));
        }
        if (wH.size() > 0) {
            update = this.diF.update(Ya(str), wH, "username=?", new String[]{str});
        } else {
            update = 0;
        }
        x.i("MicroMsg.ContactStorage", "update : username=%s, showHead=%d, verifyFlag=%d, result1=%d, take[%d]ms", new Object[]{abVar.field_username, Integer.valueOf(abVar.field_showHead), Integer.valueOf(abVar.field_verifyFlag), Integer.valueOf(update), Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        Ck(str);
        if (!bi.oW(abVar.field_encryptUsername)) {
            Ck(abVar.field_encryptUsername);
        }
        if (update == 0) {
            return update;
        }
        b(4, this, str);
        return update;
    }

    public final int b(String str, ab abVar) {
        int i = 0;
        if (bi.oW(str) || abVar == null || bi.oW(abVar.field_username)) {
            x.e("MicroMsg.ContactStorage", "update : wrong input!");
            return 0;
        }
        x.d("MicroMsg.ContactStorage", "updateEncryptUser contact: " + abVar.field_username + " enUsername: " + str);
        if (!V(abVar)) {
            return 1;
        }
        if (ab.gY(abVar.field_username)) {
            abVar.setUsername(ab.XV(abVar.field_username));
        }
        abVar.eD(abVar.AY());
        this.dKC.ci(abVar);
        this.dKC.doNotify();
        x.d("MicroMsg.ContactStorage", "update : oldUsername=%s, username=%s, showHead=%d, verifyFlag=%d", new Object[]{str, abVar.field_username, Integer.valueOf(abVar.field_showHead), Integer.valueOf(abVar.field_verifyFlag)});
        ContentValues wH = abVar.wH();
        ab abVar2;
        if (abVar.dhP <= 0) {
            abVar2 = new ab(str);
            abVar2.setType(0);
            abVar2.setUsername("fake_" + bi.VF());
            abVar2.dD("fake_" + bi.VF());
            x.d("MicroMsg.ContactStorage", "newContact.contactId <= 0 | delete " + Ya(str) + " user :" + str + ", res:" + this.diF.update(Ya(str), abVar2.wH(), "username=?", new String[]{str}));
            if (wH.size() > 0) {
                i = (int) this.diF.replace(Ya(abVar.field_username), com.tencent.mm.l.a.dhO.sKz, wH);
            }
        } else if (!str.equals(abVar.field_username)) {
            abVar2 = new ab(str);
            abVar2.setType(0);
            abVar2.setUsername("fake_" + bi.VF());
            abVar2.dD("fake_" + bi.VF());
            x.d("MicroMsg.ContactStorage", "delete " + Ya(str) + " user :" + str + ", res:" + this.diF.update(Ya(str), abVar2.wH(), "username=?", new String[]{str}));
            if (wH.size() > 0) {
                i = this.diF.update(Ya(abVar.field_username), wH, "rowid=?", new String[]{abVar.dhP});
            }
        } else if (wH.size() > 0) {
            x.i("MicroMsg.ContactStorage", "summercontact en equal username[%s], result1[%d], contactId[%d]", new Object[]{abVar.field_username, Integer.valueOf(this.diF.update(Ya(abVar.field_username), wH, "rowid=?", new String[]{abVar.dhP})), Long.valueOf(abVar.dhP)});
            i = r1;
        }
        Ck(abVar.field_username);
        if (!bi.oW(abVar.field_encryptUsername)) {
            Ck(abVar.field_encryptUsername);
        }
        b(3, this, str);
        b(3, this, abVar.field_username);
        return i;
    }

    public final void c(String str, ab abVar) {
        if (str != null) {
            if (ab.gY(str)) {
                str = ab.XV(str);
            }
            abVar.eD(abVar.AY());
            if (s.d(abVar)) {
                abVar.eD(43);
                abVar.dy(com.tencent.mm.platformtools.h.oJ(abVar.BK()));
                abVar.dz(com.tencent.mm.platformtools.h.oI(abVar.BK()));
                abVar.dB(com.tencent.mm.platformtools.h.oI(abVar.BL()));
                abVar.dC(abVar.BL());
                return;
            }
            if (s.hE(abVar.field_username)) {
                x.i("MicroMsg.ContactStorage", "update official account helper showhead %d", new Object[]{Integer.valueOf(31)});
                abVar.eD(31);
            }
            this.dKC.ci(abVar);
            this.dKC.doNotify();
            x.d("MicroMsg.ContactStorage", "username=%s, showHead=%d, verifyFlag=%d", new Object[]{abVar.field_username, Integer.valueOf(abVar.field_showHead), Integer.valueOf(abVar.field_verifyFlag)});
            ContentValues wH = abVar.wH();
            if (((int) abVar.dhP) > 0) {
                wH.put("rowid", Integer.valueOf((int) abVar.dhP));
            }
            if (wH.size() > 0) {
                this.diF.update(Ya(str), wH, "username=?", new String[]{str});
            }
        }
    }

    public final Cursor dh(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where ";
        while (i < list.size()) {
            if (i != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i)) + "'";
            }
            i++;
        }
        return this.diF.rawQuery(str + clp(), null);
    }

    public final Cursor di(List<String> list) {
        boolean z;
        int i = 0;
        if (list.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        String str = "select * ,rowid from rcontact  where (";
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (i2 != list.size() - 1) {
                str = str + "username = '" + ((String) list.get(i2)) + "' OR ";
            } else {
                str = str + "username = '" + ((String) list.get(i2)) + "'";
            }
        }
        str = str + ") order by case username ";
        while (i < list.size()) {
            str = str + " when '" + ((String) list.get(i)) + "' then " + i;
            i++;
        }
        str = str + " end";
        x.d("MicroMsg.ContactStorage", "getCursorByNamesInListOrder sql:" + str);
        return this.diF.rawQuery(str, null);
    }

    public final List<String> clj() {
        Cursor b = this.diF.b("select username from rcontact where " + cls(), null, 2);
        List arrayList = new ArrayList();
        if (b != null) {
            if (b.moveToFirst()) {
                do {
                    arrayList.add(b.getString(0));
                } while (b.moveToNext());
            }
            b.close();
        }
        return arrayList;
    }

    public final Cursor clk() {
        return this.diF.rawQuery("select * ,rowid from rcontact  where " + ("type & " + com.tencent.mm.l.a.Bt() + "=0 and username like '%@chatroom'"), null);
    }

    public final Cursor cll() {
        String str = "select * ,rowid from rcontact " + clr() + " AND type & 256 !=0 " + clp();
        x.v("MicroMsg.ContactStorage", str);
        return this.diF.rawQuery(str, null);
    }

    public final Cursor clm() {
        String str = "select * ,rowid from rcontact  where " + tav + " and verifyFlag & " + ab.ckY() + " !=0 ";
        x.v("MicroMsg.ContactStorage", "dkbf:" + str);
        return this.diF.rawQuery(str, null);
    }

    public final Cursor cln() {
        String str = "select * ,rowid from rcontact " + clr() + " AND " + tav + " AND " + tau + clq();
        x.v("MicroMsg.ContactStorage", str);
        return this.diF.rawQuery(str, null);
    }

    private static String dj(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String append : list) {
            stringBuilder.append(" or username = '").append(append).append("'");
        }
        return stringBuilder.toString();
    }

    public final Cursor b(String str, String str2, List<String> list) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + dj(null) + clp();
        x.v("MicroMsg.ContactStorage", str3);
        return this.diF.rawQuery(str3, null);
    }

    private static String dk(List<String> list) {
        String dj = dj(list);
        int indexOf = dj.indexOf("or");
        if (indexOf <= 2) {
            return dj.substring(indexOf + 2);
        }
        return dj;
    }

    public final Cursor h(List<String> list, boolean z) {
        String str = "select * ,rowid from rcontact  where " + dk(list);
        if (z) {
            str = str + " " + clp();
        }
        x.d("MicroMsg.ContactStorage", "sql " + str);
        return this.diF.rawQuery(str, null);
    }

    public final Cursor dl(List<String> list) {
        return this.diF.rawQuery("select * ,rowid from rcontact where (" + tav + ") and (" + dk(list) + ")" + clq(), null);
    }

    public final Cursor dm(List<String> list) {
        return this.diF.rawQuery("select * ,rowid from rcontact where (" + tav + ") and (" + dk(list) + ")" + clq() + " and (username like  '%@openim' )", null);
    }

    public final Cursor dn(List<String> list) {
        String str = "select * ,rowid from rcontact " + i(list, false) + clq();
        x.v("MicroMsg.ContactStorage", "favourSql " + str);
        return this.diF.rawQuery(str, null);
    }

    public final Cursor do(List<String> list) {
        String str = "select * ,rowid from rcontact " + i(list, false) + clq() + " and (username like  '%@openim' )";
        x.v("MicroMsg.ContactStorage", "favourSql " + str);
        return this.diF.rawQuery(str, null);
    }

    public final Cursor c(String str, String str2, List<String> list) {
        return b(str, str2, list);
    }

    public final Cursor d(String str, String str2, List<String> list) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list) + clp();
        x.v("MicroMsg.ContactStorage", str3);
        return this.diF.rawQuery(str3, null);
    }

    public final int clo() {
        int i = 0;
        String str = "select count(rowid) from rcontact " + e("@biz.contact", null, null);
        x.v("MicroMsg.ContactStorage", str);
        Cursor b = this.diF.b(str, null, 2);
        if (b.moveToFirst()) {
            i = b.getInt(0);
        }
        b.close();
        return i;
    }

    public final List<String> dp(List<String> list) {
        if (list.isEmpty()) {
            x.w("MicroMsg.ContactStorage", "getFilterList: but white list is empty");
            return new LinkedList();
        }
        long VG = bi.VG();
        List<String> linkedList = new LinkedList();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("username='").append((String) list.get(0)).append("'");
        for (int i = 1; i < list.size(); i++) {
            stringBuilder.append(" or username='").append((String) list.get(i)).append("'");
        }
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("showHead asc, ");
        stringBuilder2.append("pyInitial asc, ");
        stringBuilder2.append("quanPin asc, ");
        stringBuilder2.append("nickname asc, ");
        stringBuilder2.append("username asc ");
        x.i("MicroMsg.ContactStorage", "getFilterList: sql is %s", new Object[]{String.format("select %s from %s where (%s) and (%s & %d != 0)  order by %s", new Object[]{"username", "rcontact", stringBuilder.toString(), "type", Integer.valueOf(com.tencent.mm.l.a.Bs()), stringBuilder2.toString()})});
        Cursor b = this.diF.b(r0, null, 2);
        if (b != null) {
            while (b.moveToNext()) {
                linkedList.add(b.getString(0));
            }
            b.close();
        }
        x.i("MicroMsg.ContactStorage", "getFilerList: use time[%d ms] whiteList[%s], usernameList[%s]", new Object[]{Long.valueOf(bi.bI(VG)), list, linkedList.toString()});
        return linkedList;
    }

    public final int[] b(String str, String str2, String[] strArr, List<String> list) {
        String str3 = "select distinct showHead from rcontact " + e(str, str2, list) + I(strArr) + clp();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.diF.rawQuery(str3, null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct db.rawQuery last" + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowHeadDistinct  cu.getCount() last" + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] b(String str, String str2, String str3, List<String> list) {
        String str4 = "select distinct showHead from rcontact " + e(str, str2, list) + Yn(str3) + clp();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.diF.rawQuery(str4, null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] dq(List<String> list) {
        String str = "select distinct showHead from rcontact  where (" + dk(list) + ") " + clp();
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.diF.rawQuery(str, null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount() >= 0 ? rawQuery.getCount() : 0;
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getShowSectionByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        int[] iArr = new int[count];
        if (rawQuery.getCount() > 0) {
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String str3, List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor rawQuery = this.diF.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + Yn(str3)) + " group by showHead", null);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = rawQuery.getCount();
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final int[] dr(List<String> list) {
        int[] iArr = null;
        long currentTimeMillis = System.currentTimeMillis();
        Cursor b = this.diF.b(("select count(*) from rcontact " + "where " + dk(list)) + " group by showHead", null, 2);
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead db.rawQuery : " + (System.currentTimeMillis() - currentTimeMillis));
        currentTimeMillis = System.currentTimeMillis();
        int count = b.getCount();
        x.d("MicroMsg.ContactStorage", "kevin MMCore.getAccStg().getContactStg().getSectionNumByShowHead cu.getCount() : " + (System.currentTimeMillis() - currentTimeMillis));
        if (count > 0) {
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                b.moveToPosition(i);
                iArr[i] = b.getInt(0);
            }
        }
        b.close();
        return iArr;
    }

    public final int[] c(String str, String str2, String[] strArr, List<String> list) {
        int[] iArr = null;
        Cursor rawQuery = this.diF.rawQuery(("select count(*) from rcontact " + e(str, str2, list) + I(strArr)) + " group by showHead", null);
        if (rawQuery.getCount() > 0) {
            int count = rawQuery.getCount();
            iArr = new int[count];
            for (int i = 0; i < count; i++) {
                rawQuery.moveToPosition(i);
                iArr[i] = rawQuery.getInt(0);
            }
        }
        rawQuery.close();
        return iArr;
    }

    public final Cursor a(String[] strArr, String str, List<String> list) {
        String str2 = "select * ,rowid from rcontact " + e(str, null, list) + I(strArr);
        if (strArr != null && strArr.length > 0) {
            str2 = str2 + " order by 1=1 ";
            for (String str3 : strArr) {
                str2 = str2 + ",username='" + str3 + "' desc";
            }
        }
        x.v("MicroMsg.ContactStorage", "getSearchCursorByArrOrder sql : " + str2);
        return this.diF.rawQuery(str2, null);
    }

    public final Cursor a(String[] strArr, String str, String str2, List<String> list, List<String> list2) {
        String str3 = "select * ,rowid from rcontact " + e(str, str2, list2) + I(strArr) + s(str2, list) + clp();
        x.i("MicroMsg.ContactStorage", str3);
        return this.diF.rawQuery(str3, null);
    }

    private static String s(String str, List<String> list) {
        if (str == null || str.equals("")) {
            return "";
        }
        String str2 = " and (";
        if (!(list == null || list.size() == 0)) {
            String str3;
            Iterator it = list.iterator();
            while (true) {
                str3 = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str3 + "username = '" + ((String) it.next()) + "' or ";
            }
            str2 = str3;
        }
        return (((((((str2 + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    private static String I(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        String str = " and (";
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                str = str + " or ";
            }
            str = str + "username = '" + strArr[i] + "' ";
        }
        return str + " )";
    }

    public final String Yn(String str) {
        if (str == null || str.equals("")) {
            return "";
        }
        return (((((((" and (" + "conRemark like '%" + str + "%' or ") + "conRemarkPYFull like '%" + str + "%' or ") + "conRemarkPYShort like '%" + str + "%' or ") + "alias like '%" + str + "%' or ") + "username like '%" + str + "%' or ") + "nickname like '%" + str + "%' or ") + "pyInitial like '%" + str + "%' or ") + "quanPin like '%" + str + "%' )";
    }

    private static String clp() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    public final String MD() {
        return clp();
    }

    private static String clq() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" order by case when verifyFlag & " + ab.ckY() + " != 0 then 0 else 1 end , showHead asc, ");
        stringBuffer.append(" case when length(conRemarkPYFull) > 0 then upper(conRemarkPYFull) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" case when length(conRemark) > 0 then upper(conRemark) ");
        stringBuffer.append(" else upper(quanPin) end asc, ");
        stringBuffer.append(" upper(quanPin) asc, ");
        stringBuffer.append(" upper(nickname) asc, ");
        stringBuffer.append(" upper(username) asc ");
        return stringBuffer.toString();
    }

    private static String T(boolean z, boolean z2) {
        String str = "type & " + com.tencent.mm.l.a.Bs() + "!=0";
        if (z) {
            str = str + " or type & " + com.tencent.mm.l.a.Bv() + "!=0";
        }
        str = ((" where (" + str + ")") + " and type & " + com.tencent.mm.l.a.Bw() + "=0 ") + " and type & " + com.tencent.mm.l.a.Bt() + " =0 ";
        if (z2) {
            return str;
        }
        return str + " and verifyFlag & " + ab.ckY() + " =0 ";
    }

    private static String clr() {
        return (" where (" + ("type & " + com.tencent.mm.l.a.Bs() + "!=0") + ") and ") + "type & " + com.tencent.mm.l.a.Bw() + "=0  ";
    }

    private static String cls() {
        return "( (" + ("type & " + com.tencent.mm.l.a.Bs() + "!=0") + ") and type & " + com.tencent.mm.l.a.Bt() + "=0 and username like '%@chatroom')";
    }

    private static String clt() {
        return "( (" + ("type & " + com.tencent.mm.l.a.Bs() + "!=0") + ") and type & " + com.tencent.mm.l.a.Bt() + "=0 and username like '%@talkroom')";
    }

    private static String clu() {
        return "type & " + com.tencent.mm.l.a.Bt() + "=0 and username like '%@openim'";
    }

    private static String clv() {
        return clr() + " and " + clu();
    }

    private static String i(List<String> list, boolean z) {
        String str = T(false, z) + " AND " + tav;
        String str2 = "";
        if (list != null && list.size() > 0) {
            String str3;
            Iterator it = list.iterator();
            while (true) {
                str3 = str2;
                if (!it.hasNext()) {
                    break;
                }
                str2 = str3 + " AND username != '" + ((String) it.next()) + "'";
            }
            str2 = str3;
        }
        return str + str2;
    }

    public final String e(String str, String str2, List<String> list) {
        String str3;
        String str4;
        boolean z = true;
        String str5 = "";
        StringBuilder append;
        String T;
        if (str == null || str.equals("@all.android")) {
            str3 = str5 + T(true, false);
        } else if (str.equals("@all.contact.android")) {
            str3 = str5 + clr();
        } else if (str.equals("@all.chatroom.contact")) {
            str3 = str5 + ((" where (" + ("(type & " + com.tencent.mm.l.a.Bs() + "!=0 and username like '%@chatroom')") + ") and ") + "type & " + com.tencent.mm.l.a.Bw() + "=0 ");
        } else if (str.equals("@all.contact.without.chatroom")) {
            append = new StringBuilder().append(str5);
            T = T(false, false);
            if (T == null || T.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(T + " and ( username not like '%@%'" + (" or (" + clt() + ')' + " or (" + clu() + ")") + ")").toString();
        } else if (str.equals("@all.contact.without.chatroom.without.openim")) {
            append = new StringBuilder().append(str5);
            T = T(false, false);
            if (T == null || T.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(T + " and ( username not like '%@%'" + (" or (" + clt() + ')') + ")").toString();
        } else if (str.equals("@black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.l.a.Bt() + "!=0");
        } else if (str.equals("@werun.black.android")) {
            str3 = str5 + (" where type & " + com.tencent.mm.l.a.Bu() + "!=0");
        } else if (str.equals("@t.qq.com")) {
            str3 = str5 + (" where username like '%" + "@t.qq.com" + "'");
        } else if (str.equals("@domain.android")) {
            append = new StringBuilder().append(str5);
            T = T(true, false);
            if (T == null || T.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(T + " and domainList like '%" + str2 + "%'").toString();
        } else if (str.equals("@micromsg.qq.com")) {
            append = new StringBuilder().append(str5);
            T = T(false, false);
            if (T == null || T.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str4 = " or (" + cls() + ')';
            str3 = append.append(T + " and ( username not like '%@%'" + str4 + (" or (" + clt() + ')') + ")").toString();
        } else if (str.equals("@micromsg.no.verify.biz.qq.com")) {
            append = new StringBuilder().append(str5);
            T = (((" where (" + ("type & " + com.tencent.mm.l.a.Bs() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.l.a.Bw() + " =0 and ") + "type & " + com.tencent.mm.l.a.Bt() + " =0 and ") + "verifyFlag & " + ab.ckY() + " =0";
            if (T == null || T.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(T + " and ( username not like '%@%'" + (" or (" + cls() + ')') + ")").toString();
        } else if (str.equals("@micromsg.with.all.biz.qq.com")) {
            append = new StringBuilder().append(str5);
            T = ((" where (" + ("type & " + com.tencent.mm.l.a.Bs() + " !=0 ") + ") and ") + "type & " + com.tencent.mm.l.a.Bw() + " =0 and ") + "type & " + com.tencent.mm.l.a.Bt() + " =0";
            if (T == null || T.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(T + " and ( username not like '%@%'" + (" or (" + cls() + ')') + ")").toString();
        } else if (str.equals("@qqim")) {
            append = new StringBuilder().append(str5);
            T = "@qqim";
            String T2 = T(false, false);
            if (T2 == null || T2.length() <= 0) {
                z = false;
            }
            Assert.assertTrue(z);
            str3 = append.append(T2 + " and username like '%" + T + "'").toString();
        } else if (str.equals("@all.chatroom")) {
            str3 = str5 + (" where (" + (((("type & " + com.tencent.mm.l.a.Bs() + " !=0") + " or type & 2 !=0") + " or type & 4 !=0") + " or 1") + ") ");
        } else if (str.equals("@verify.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.l.a.Bs() + " != 0 and ") + "verifyFlag & " + ab.ckX() + " != 0") + ") ");
        } else if (str.equals("@biz.contact")) {
            str3 = str5 + (" where (" + (("type & " + com.tencent.mm.l.a.Bs() + " != 0 and ") + "verifyFlag & " + ab.ckY() + " != 0") + ") ");
        } else if (str.equals("@all.weixin.android")) {
            str3 = str5 + (" where (" + ("type & " + com.tencent.mm.l.a.Bs() + " != 0 or  (username not like '%@qqim' and username not like '%@qr' and username not like '%@bottle' and username not like '%@fb' and username not like '%@google' and username not like '%@t.qq.com' and username not like '%@t.sina.com' and username not like '%@t.sina.com" + "')") + ") ");
        } else if (str.equals("@openim.contact")) {
            str3 = str5 + clv();
        } else {
            x.d("MicroMsg.ContactStorage", "unknow role type");
            str3 = str5 + T(false, false);
        }
        str4 = "";
        if (list != null && list.size() > 0) {
            Iterator it = list.iterator();
            while (true) {
                str5 = str4;
                if (!it.hasNext()) {
                    break;
                }
                str4 = str5 + " and username != '" + ((String) it.next()) + "'";
            }
            str4 = str5;
        }
        return str3 + str4;
    }

    public final int b(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bs()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bw()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bt()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username != '").append(strArr2[i]).append("'");
        }
        stringBuilder.append(" or username = 'weixin'");
        Cursor b = this.diF.b(stringBuilder.toString(), null, 2);
        if (b == null || !b.moveToFirst()) {
            i = 0;
        } else {
            i = b.getInt(0);
            b.close();
        }
        x.d("MicroMsg.ContactStorage", "getNormalContactCount, sql:%s, result:%d", new Object[]{r2, Integer.valueOf(i)});
        return i;
    }

    public final int c(String[] strArr, String... strArr2) {
        int i;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select count(username) from rcontact where ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bs()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bw()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bt()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username like '%@chatroom')");
        if (strArr != null && strArr.length > 0) {
            for (String append : strArr) {
                stringBuilder.append(" and rcontact.username != '").append(append).append("'");
            }
        }
        for (i = 0; i < 4; i++) {
            stringBuilder.append(" and rcontact.username != '").append(strArr2[i]).append("'");
        }
        Cursor b = this.diF.b(stringBuilder.toString(), null, 2);
        if (b == null || !b.moveToFirst()) {
            i = 0;
        } else {
            i = b.getInt(0);
            b.close();
        }
        x.v("MicroMsg.ContactStorage", "getChatroomContactCount, sql:%s, result:%d", new Object[]{r2, Integer.valueOf(i)});
        return i;
    }

    public final Cursor bdj() {
        return this.diF.rawQuery("select * ,rowid from rcontact  where rowid = -1", null);
    }

    protected final boolean Xu() {
        if (this.diF != null && !this.diF.cjr()) {
            return true;
        }
        String str = "MicroMsg.ContactStorage";
        String str2 = "shouldProcessEvent db is close :%s";
        Object[] objArr = new Object[1];
        objArr[0] = this.diF == null ? "null" : Boolean.valueOf(this.diF.cjr());
        x.w(str, str2, objArr);
        return false;
    }

    private static boolean V(ab abVar) {
        boolean z = false;
        if (abVar != null) {
            int i = abVar.versionCode;
            if (i > 0) {
                z = true;
            }
            x.d("MicroMsg.ContactStorage", "it need to update contact: " + z + " version code : " + i + " user: " + abVar.field_username);
        }
        return z;
    }

    public final Cursor clw() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("select username ,nickname ,alias,conRemark,verifyFlag,showHead,weiboFlag,rowid ,deleteFlag,lvbuff,descWordingId,openImAppid from rcontact  where ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bs()).append(" !=0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bw()).append(" =0 and ");
        stringBuilder.append("type & ").append(com.tencent.mm.l.a.Bt()).append(" =0 and ");
        stringBuilder.append("verifyFlag & 8 = 0 and ");
        stringBuilder.append("( username not like '%@%')");
        stringBuilder.append(" or username = 'weixin'");
        Cursor b = this.diF.b(stringBuilder.toString(), null, 2);
        x.i("MicroMsg.ContactStorage", "[oneliang]getNormalContactCursor, sql:%s", new Object[]{r0});
        return b;
    }
}
