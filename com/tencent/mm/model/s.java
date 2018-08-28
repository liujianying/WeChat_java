package com.tencent.mm.model;

import android.database.Cursor;
import com.tencent.mm.g.c.ai;
import com.tencent.mm.g.c.am;
import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.protocal.c.aue;
import com.tencent.mm.protocal.c.aut;
import com.tencent.mm.protocal.c.bhy;
import com.tencent.mm.protocal.c.bhz;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bl;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class s {
    private static ag dAM = null;
    public static final String dAN = c("rconversation.username", new String[]{"@chatroom", "@openim", "@micromsg.qq.com"});
    public static final String dAO = c("rconversation.username", new String[]{"@chatroom", "@micromsg.qq.com"});
    public static final String dAP = c("rconversation.username", new String[]{"@t.qq.com"});
    public static final String dAQ = c("rconversation.username", new String[]{"@qqim"});
    public static final String dAR = c("rconversation.username", new String[]{"@chatroom_exclusive"});
    public static final String dAS = c("rconversation.username", new String[]{"@micromsg.qq.com"});
    public static final String dAT = c("rconversation.username", new String[]{"@app"});
    public static final String dAU = c("rconversation.username", new String[]{"@chatroom"});
    public static final String[] dAV = new String[]{"qqmail", "fmessage", "tmessage", "qmessage", "qqsync", "floatbottle", "lbsapp", "shakeapp", "medianote", "qqfriend", "newsapp", "blogapp", "facebookapp", "topstoryapp", "masssendapp", "feedsapp", "voipapp", "cardpackage", "voicevoipapp", "voiceinputapp", "officialaccounts", "linkedinplugin", "notifymessage", "appbrandcustomerservicemsg"};

    public static void a(ag agVar) {
        dAM = agVar;
    }

    public static boolean gW(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.contains("@") || str.endsWith("@micromsg.qq.com")) {
            return true;
        }
        return false;
    }

    public static boolean fq(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@chatroom");
    }

    public static boolean gX(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qy_u");
    }

    public static boolean gY(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@bottle");
    }

    public static boolean gZ(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@qqim");
    }

    public static boolean ha(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@lbsroom");
    }

    public static boolean d(ab abVar) {
        if (abVar != null && bi.oV(abVar.field_username).endsWith("@chatroom") && a.gd(abVar.field_type)) {
            return true;
        }
        return false;
    }

    public static boolean hb(String str) {
        return "gh_43f2581f6fd6".equals(str);
    }

    public static boolean hc(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (!str.endsWith("@chatroom")) {
            return false;
        }
        ai Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null || !a.gd(Yg.field_type)) {
            return false;
        }
        return true;
    }

    public static boolean hd(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        return str.endsWith("@stranger");
    }

    public static List<String> Hp() {
        return ((i) g.l(i.class)).FR().clj();
    }

    public static List<ab> Hq() {
        List<ab> arrayList = new ArrayList();
        Cursor clk = ((i) g.l(i.class)).FR().clk();
        if (clk.moveToFirst()) {
            do {
                ab abVar = new ab();
                abVar.d(clk);
                arrayList.add(abVar);
            } while (clk.moveToNext());
        }
        clk.close();
        return arrayList;
    }

    public static String a(ab abVar, String str) {
        if (abVar == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bi.oW(abVar.field_nickname)) {
            String gT = ((b) g.l(b.class)).Ga().gT(str);
            if (!bi.oW(gT)) {
                return gT;
            }
        }
        if (abVar.BL() == null || abVar.BL().length() <= 0) {
            return str;
        }
        return abVar.BL();
    }

    public static boolean he(String str) {
        if (str == null || str.length() <= 0) {
            return true;
        }
        return a.gd(((i) g.l(i.class)).FR().Yg(str).field_type);
    }

    public static boolean hf(String str) {
        if (bi.oW(str)) {
            return false;
        }
        ai Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            return false;
        }
        return ab.Dk(Yg.field_verifyFlag);
    }

    public static boolean gU(int i) {
        return ab.Dk(i);
    }

    public static void e(ab abVar) {
        Assert.assertTrue(abVar != null);
        ai Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (!(Yg == null || bi.oW(Yg.field_username))) {
            ai abVar2 = Yg;
        }
        abVar2.Bh();
        t(abVar2);
    }

    public static void s(String str, boolean z) {
        ai Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg != null && !bi.oW(Yg.field_username)) {
            if (z) {
                Yg.Bq();
            } else {
                Yg.Br();
            }
            s(Yg);
        }
    }

    public static void f(ab abVar) {
        Assert.assertTrue(abVar != null);
        ai Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (!(Yg == null || bi.oW(Yg.field_username))) {
            ai abVar2 = Yg;
        }
        abVar2.Bf();
        t(abVar2);
    }

    public static void g(ab abVar) {
        Assert.assertTrue(abVar != null);
        ai Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (!(Yg == null || bi.oW(Yg.field_username))) {
            ai abVar2 = Yg;
        }
        abVar2.Bg();
        t(abVar2);
    }

    public static void h(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Bd();
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.iq(abVar.field_username);
        }
        t(Yg);
    }

    public static void i(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Be();
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.ir(abVar.field_username);
        }
        t(Yg);
        am Yq = ((i) g.l(i.class)).FW().Yq(abVar.field_username);
        if (Yq != null && "@blacklist".equals(Yq.field_parentRef)) {
            ((i) g.l(i.class)).FW().d(new String[]{Yq.field_username}, "");
        }
    }

    public static void j(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Bq();
        Yg.eD(abVar.AY());
        s(Yg);
    }

    public static void k(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Br();
        Yg.eD(abVar.AY());
        s(Yg);
    }

    public static void l(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Bm();
        Yg.eD(abVar.AY());
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.is(abVar.field_username);
        }
        t(Yg);
    }

    public static void m(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Bn();
        Yg.eD(abVar.AY());
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.it(abVar.field_username);
        }
        t(Yg);
    }

    public static void t(String str, boolean z) {
        Assert.assertTrue(!bi.oW(str));
        ai Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg != null && !bi.oW(Yg.field_username)) {
            Yg.setType(Yg.field_type | 2048);
            if (ab.XR(str) && dAM != null) {
                dAM.io(str);
            }
            t(Yg);
            if (z) {
                ((i) g.l(i.class)).FW().Yv(str);
            }
        }
    }

    public static void hg(String str) {
        com.tencent.mm.storage.ai Yq = ((i) g.l(i.class)).FW().Yq(str);
        Object obj = null;
        if (Yq == null) {
            Yq = new com.tencent.mm.storage.ai();
            Yq.clx();
            obj = 1;
            Yq.setUsername(str);
        }
        Yq.as(System.currentTimeMillis());
        if (obj != null) {
            ((i) g.l(i.class)).FW().d(Yq);
        } else {
            ((i) g.l(i.class)).FW().a(Yq, str);
        }
    }

    public static void u(String str, boolean z) {
        Assert.assertTrue(!bi.oW(str));
        ai Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg != null && !bi.oW(Yg.field_username)) {
            Yg.setType(Yg.field_type & -2049);
            if (ab.XR(str) && dAM != null) {
                dAM.ip(str);
            }
            t(Yg);
            if (z) {
                ((i) g.l(i.class)).FW().Yw(str);
            }
        }
    }

    public static void n(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Bo();
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.iu(abVar.field_username);
        }
        t(Yg);
    }

    public static void o(ab abVar) {
        Assert.assertTrue(abVar != null);
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        if (Yg == null || bi.oW(Yg.field_username)) {
            Yg = abVar;
        }
        Yg.Bp();
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.iv(abVar.field_username);
        }
        t(Yg);
    }

    public static void p(ab abVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue("MicroMsg.ContactStorageLogic: user is null", abVar != null);
        String str = "MicroMsg.ContactStorageLogic: contactId == 0";
        if (((int) abVar.dhP) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(str, z);
        String str2 = "MicroMsg.ContactStorageLogic: username length <= 0";
        if (abVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(str2, z2);
        abVar.Bb();
        ((i) g.l(i.class)).FR().a(abVar.field_username, abVar);
    }

    public static void q(ab abVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(abVar != null);
        if (((int) abVar.dhP) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (abVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        abVar.Bb();
        ((i) g.l(i.class)).FR().a(abVar.field_username, abVar);
        t(abVar);
    }

    public static void b(ab abVar, String str) {
        ab Yg = ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        boolean z = (Yg == null || str == null) ? false : true;
        Assert.assertTrue(z);
        Yg.dv(str);
        if (ab.XR(abVar.field_username) && dAM != null) {
            dAM.Q(abVar.field_username, str);
        }
        t(Yg);
    }

    public static void r(ab abVar) {
        boolean z;
        boolean z2 = true;
        Assert.assertTrue(abVar != null);
        if (((int) abVar.dhP) != 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (abVar.field_username.length() <= 0) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        abVar.BI();
        t(abVar);
    }

    private static void s(ab abVar) {
        Assert.assertTrue(abVar != null);
        if (((int) abVar.dhP) == 0) {
            ((i) g.l(i.class)).FR().U(abVar);
            ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        }
        ((i) g.l(i.class)).FR().a(abVar.field_username, abVar);
        com.tencent.mm.bk.a aut = new aut();
        aut.rXy = abVar.field_username;
        if (abVar.BF()) {
            aut.rXK = 1;
        } else {
            aut.rXK = 2;
        }
        ((i) g.l(i.class)).FQ().b(new h.a(52, aut));
    }

    public static void t(ab abVar) {
        Assert.assertTrue(abVar != null);
        if (((int) abVar.dhP) == 0) {
            ((i) g.l(i.class)).FR().U(abVar);
            ((i) g.l(i.class)).FR().Yg(abVar.field_username);
        }
        ((i) g.l(i.class)).FR().a(abVar.field_username, abVar);
        if (!ab.XR(abVar.field_username)) {
            u(abVar);
        }
    }

    public static void u(ab abVar) {
        x.i("MicroMsg.ContactStorageLogic", "oplog modContact user:%s remark:%s type:%d ", abVar.field_username, abVar.field_conRemark, Integer.valueOf(abVar.field_type));
        com.tencent.mm.bk.a aue = new aue();
        aue.rvi = new bhz().VO(bi.oV(abVar.field_username));
        aue.rQz = new bhz().VO(bi.oV(abVar.field_nickname));
        aue.ruT = new bhz().VO(bi.oV(abVar.wP()));
        aue.ruU = new bhz().VO(bi.oV(abVar.wQ()));
        aue.eJH = abVar.sex;
        aue.ruj = 561023;
        aue.ruk = abVar.field_type;
        aue.rWH = new bhz().VO(bi.oV(abVar.field_conRemark));
        aue.rWI = new bhz().VO(bi.oV(abVar.field_conRemarkPYShort));
        aue.rWJ = new bhz().VO(bi.oV(abVar.field_conRemarkPYFull));
        aue.rup = abVar.csF;
        aue.rXd = new bhz().VO(bi.oV(abVar.field_domainList));
        aue.rut = abVar.csI;
        aue.eJL = abVar.csJ;
        aue.eJK = bi.oV(abVar.signature);
        aue.eJJ = bi.oV(abVar.getCityCode());
        aue.eJI = bi.oV(abVar.cla());
        aue.rTg = bi.oV(abVar.csO);
        aue.rTi = abVar.field_weiboFlag;
        aue.rWZ = 0;
        aue.rcn = new bhy();
        aue.eJQ = bi.oV(abVar.getCountryCode());
        ((i) g.l(i.class)).FQ().b(new h.a(2, aue));
    }

    public static void hh(String str) {
        if (!bi.oW(str)) {
            ab Yg = ((i) g.l(i.class)).FR().Yg(str);
            if (Yg != null) {
                Yg.AZ();
                ((i) g.l(i.class)).FR().a(str, Yg);
            }
        }
    }

    public static int[] b(String str, String str2, List<String> list, String str3) {
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((i) g.l(i.class)).FR().b(str, str2, str3, (List) list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] c = ((i) g.l(i.class)).FR().c(str, str2, str3, (List) list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] G(List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        int[] dq = ((i) g.l(i.class)).FR().dq(list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowHeadDistinct(" + (System.currentTimeMillis() - currentTimeMillis));
        if (dq.length <= 0) {
            return null;
        }
        currentTimeMillis = System.currentTimeMillis();
        int[] dr = ((i) g.l(i.class)).FR().dr(list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getSectionNumByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (dr == null) {
            return null;
        }
        Assert.assertTrue(dq.length == dr.length);
        int[] iArr = new int[dr.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < dq.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += dr[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static int[] a(String str, String str2, List<String> list, String[] strArr) {
        int[] b = ((i) g.l(i.class)).FR().b(str, str2, strArr, (List) list);
        if (b.length <= 0) {
            return null;
        }
        int[] c = ((i) g.l(i.class)).FR().c(str, str2, strArr, (List) list);
        if (c == null) {
            return null;
        }
        Assert.assertTrue(b.length == c.length);
        int[] iArr = new int[c.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < b.length) {
            int i4 = i3 + 1;
            iArr[i3] = i2;
            i2 += c[i];
            i++;
            i3 = i4;
        }
        return iArr;
    }

    public static String[] a(String str, String str2, String[] strArr, List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((i) g.l(i.class)).FR().b(str, str2, strArr, (List) list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr2 = new String[b.length];
        int i = 0;
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr2[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr2[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr2[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr2;
    }

    public static String[] a(String str, String str2, String str3, List<String> list) {
        long currentTimeMillis = System.currentTimeMillis();
        int[] b = ((i) g.l(i.class)).FR().b(str, str2, str3, (List) list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (b.length <= 0) {
            return null;
        }
        String[] strArr = new String[b.length];
        int i = 0;
        int i2 = 0;
        while (i < b.length) {
            int i3;
            char c = (char) b[i];
            if (c == '{') {
                i3 = i2 + 1;
                strArr[i2] = "#";
            } else if (c == ' ') {
                i3 = i2 + 1;
                strArr[i2] = "$";
            } else {
                i3 = i2 + 1;
                strArr[i2] = String.valueOf(c);
            }
            i++;
            i2 = i3;
        }
        return strArr;
    }

    public static String[] H(List<String> list) {
        int i = 0;
        long currentTimeMillis = System.currentTimeMillis();
        int[] dq = ((i) g.l(i.class)).FR().dq(list);
        x.d("MicroMsg.ContactStorageLogic", "kevin service(IMessengerStorage.class).getContactStg().getShowSectionByShowHead" + (System.currentTimeMillis() - currentTimeMillis));
        if (dq.length <= 0) {
            return null;
        }
        String[] strArr = new String[dq.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= dq.length) {
                return strArr;
            }
            char c = (char) dq[i2];
            if (c == '{') {
                i = i3 + 1;
                strArr[i3] = "#";
            } else if (c == ' ') {
                i = i3 + 1;
                strArr[i3] = "$";
            } else {
                i = i3 + 1;
                strArr[i3] = String.valueOf(c);
            }
            i2++;
        }
    }

    public static boolean hi(String str) {
        return str != null ? str.equalsIgnoreCase("qqmail") : false;
    }

    public static boolean hj(String str) {
        return str != null ? str.equalsIgnoreCase("fmessage") : false;
    }

    public static boolean hk(String str) {
        return str != null ? str.equalsIgnoreCase("tmessage") : false;
    }

    public static boolean hl(String str) {
        return str != null ? str.equalsIgnoreCase("floatbottle") : false;
    }

    public static boolean hm(String str) {
        return str != null ? str.equalsIgnoreCase("qmessage") : false;
    }

    public static boolean hn(String str) {
        return str != null ? str.equalsIgnoreCase("facebookapp") : false;
    }

    public static boolean ho(String str) {
        return str != null ? str.equalsIgnoreCase("masssendapp") : false;
    }

    public static boolean Hr() {
        return false;
    }

    public static boolean hp(String str) {
        return str != null ? str.equalsIgnoreCase("feedsapp") : false;
    }

    public static boolean hq(String str) {
        return "qqsync".equalsIgnoreCase(str);
    }

    public static boolean hr(String str) {
        if (str != null) {
            return str.equalsIgnoreCase("weixin") || str.equalsIgnoreCase("gh_9639b5a92773");
        } else {
            return false;
        }
    }

    public static boolean hs(String str) {
        return str != null ? str.equalsIgnoreCase("lbsapp") : false;
    }

    public static boolean ht(String str) {
        return str != null ? str.equalsIgnoreCase("shakeapp") : false;
    }

    public static boolean hu(String str) {
        return str != null ? str.equalsIgnoreCase("medianote") : false;
    }

    public static boolean hv(String str) {
        return str != null ? str.equalsIgnoreCase("newsapp") : false;
    }

    public static boolean hw(String str) {
        return str != null ? str.equalsIgnoreCase("topstoryapp") : false;
    }

    public static boolean hx(String str) {
        return str != null ? str.equalsIgnoreCase("voipapp") : false;
    }

    public static boolean hy(String str) {
        return str != null ? str.equalsIgnoreCase("voicevoipapp") : false;
    }

    public static boolean hz(String str) {
        return str != null ? str.equalsIgnoreCase("voiceinputapp") : false;
    }

    public static boolean hA(String str) {
        return str != null ? str.equalsIgnoreCase("linkedinplugin") : false;
    }

    public static boolean hB(String str) {
        return hC(str);
    }

    public static boolean hC(String str) {
        return str != null ? str.equalsIgnoreCase("gh_22b87fa7cb3c") : false;
    }

    public static boolean hD(String str) {
        return str != null ? str.equalsIgnoreCase("blogapp") : false;
    }

    public static boolean hE(String str) {
        return str != null ? str.equalsIgnoreCase("officialaccounts") : false;
    }

    public static boolean hF(String str) {
        return str != null ? str.equalsIgnoreCase("helper_entry") : false;
    }

    public static boolean hG(String str) {
        return str != null ? str.equalsIgnoreCase("qqfriend") : false;
    }

    public static boolean hH(String str) {
        return "filehelper".equalsIgnoreCase(str);
    }

    public static boolean hI(String str) {
        return str != null ? str.equalsIgnoreCase("pc_share") : false;
    }

    public static boolean hJ(String str) {
        return str != null ? str.equalsIgnoreCase("notifymessage") : false;
    }

    public static boolean hK(String str) {
        return str != null ? str.equalsIgnoreCase("notification_messages") : false;
    }

    public static boolean hL(String str) {
        if (hM(str) || hO(str) || hE(str) || hF(str)) {
            return true;
        }
        return false;
    }

    public static boolean hM(String str) {
        g.Ek();
        String str2 = (String) g.Ei().DT().get(21, null);
        if ((str2 == null || !str2.equalsIgnoreCase(str)) && !str.equalsIgnoreCase("weixin")) {
            return false;
        }
        return true;
    }

    public static boolean hN(String str) {
        return str != null ? str.equalsIgnoreCase("appbrandcustomerservicemsg") : false;
    }

    public static boolean hO(String str) {
        for (String equalsIgnoreCase : dAV) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean hP(String str) {
        if (hO(str) || ab.XQ(str) || ab.XO(str) || ab.gY(str)) {
            return true;
        }
        return false;
    }

    public static int hQ(String str) {
        Assert.assertTrue(bi.oV(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 1;
        }
        if (ab.XO(toLowerCase)) {
            return 11;
        }
        if (ab.XQ(toLowerCase)) {
            return 36;
        }
        return ab.gY(toLowerCase) ? 1 : 1;
    }

    public static int hR(String str) {
        Assert.assertTrue(bi.oV(str).length() > 0);
        String toLowerCase = str.trim().toLowerCase();
        if (toLowerCase.endsWith("@chatroom")) {
            return 3;
        }
        if (ab.XO(toLowerCase)) {
            return 13;
        }
        if (ab.XQ(toLowerCase)) {
            return 39;
        }
        if (ab.gY(toLowerCase)) {
            return 3;
        }
        if (toLowerCase.contains("@")) {
            return 3;
        }
        return 3;
    }

    public static boolean hS(String str) {
        if (((i) g.l(i.class)).FR().Yg(str).csI != 1) {
            return false;
        }
        return true;
    }

    public static boolean hT(String str) {
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null || !Yg.BD()) {
            return false;
        }
        return true;
    }

    public static boolean hU(String str) {
        if (str == null || str.length() <= 0) {
            return false;
        }
        if (str.startsWith("t.qq.com/") || str.startsWith("http://t.qq.com/")) {
            return true;
        }
        return false;
    }

    public static String hV(String str) {
        if (hU(str)) {
            return str.replace("http://t.qq.com/", "").replace("t.qq.com/", "");
        }
        return "";
    }

    public static boolean v(ab abVar) {
        return (abVar.field_weiboFlag & 1) != 0;
    }

    public static boolean Hs() {
        if (!q.Hm()) {
            return false;
        }
        bl Hg = ((i) g.l(i.class)).FZ().Hg("@t.qq.com");
        if (Hg == null || bi.oW(Hg.name)) {
            return false;
        }
        return true;
    }

    public static boolean Ht() {
        if (!q.Hm()) {
            return false;
        }
        bl Hg = ((i) g.l(i.class)).FZ().Hg("@t.qq.com");
        if (Hg == null || bi.oV(Hg.name).length() == 0) {
            return false;
        }
        return true;
    }

    public static List<ab> Hu() {
        List<ab> linkedList = new LinkedList();
        Cursor cln = ((i) g.l(i.class)).FR().cln();
        if (cln.getCount() == 0) {
            cln.close();
            return linkedList;
        }
        cln.moveToFirst();
        do {
            ab abVar = new ab();
            abVar.d(cln);
            linkedList.add(abVar);
        } while (cln.moveToNext());
        cln.close();
        x.d("MicroMsg.ContactStorageLogic", "getFavourList size:  " + linkedList.size());
        return linkedList;
    }

    public static List<String> Hv() {
        List<String> linkedList = new LinkedList();
        Cursor cll = ((i) g.l(i.class)).FR().cll();
        if (cll.getCount() == 0) {
            cll.close();
            return linkedList;
        }
        cll.moveToFirst();
        do {
            ai abVar = new ab();
            abVar.d(cll);
            linkedList.add(abVar.field_username);
        } while (cll.moveToNext());
        cll.close();
        x.d("MicroMsg.ContactStorageLogic", "getSnsBlackContactList size:  " + linkedList.size());
        return linkedList;
    }

    public static boolean a(com.tencent.mm.storage.ai aiVar) {
        String str = aiVar.field_username;
        if (hO(str) || hM(str) || hE(str) || hF(str) || aiVar.field_conversationTime == -1) {
            return false;
        }
        if (hf(str)) {
            return true;
        }
        return true;
    }

    public static boolean b(com.tencent.mm.storage.ai aiVar) {
        String str = aiVar.field_username;
        if (hE(str) || hN(str)) {
            return false;
        }
        return true;
    }

    public static int Hw() {
        return ((i) g.l(i.class)).FR().b(dAV, q.GF(), "weixin", "helper_entry", "filehelper");
    }

    private static String c(String str, String[] strArr) {
        String str2 = " and ( 1 != 1 ";
        for (Object obj : strArr) {
            if ("@all.android".equals(obj)) {
                str2 = str2 + " or 1 = 1";
            } else if ("@micromsg.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " not like '%@%'";
            } else if ("@chatroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@chatroom'";
            } else if ("@talkroom".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@talkroom'";
            } else if ("@t.qq.com".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@t.qq.com'";
            } else if ("@qqim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@qqim'";
            } else if ("@chatroom_exclusive".equals(obj)) {
                str2 = str2 + " or " + str + "not like %@chatroom";
            } else if ("@app".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@app'";
            } else if ("@openim".equals(obj)) {
                str2 = str2 + " or " + str + " like '%@openim'";
            }
        }
        return str2 + " ) ";
    }

    public static boolean hW(String str) {
        return str.equals("weixinsrc") || str.equalsIgnoreCase("gh_6e99ff560306");
    }
}
