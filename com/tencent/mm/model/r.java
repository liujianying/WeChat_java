package com.tencent.mm.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.l.a;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class r {
    private static Set<String> dAL = new HashSet();

    public static String gR(String str) {
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null || bi.oW(Yg.field_nickname)) {
            return str;
        }
        return Yg.field_nickname;
    }

    public static String getDisplayName(String str, String str2) {
        if (bi.oW(str2)) {
            return gT(str);
        }
        String gU = gU(str);
        if (!bi.oW(gU)) {
            return gU;
        }
        gU = m.L(str, str2);
        if (bi.oW(gU)) {
            return gT(str);
        }
        return gU;
    }

    public static String gS(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        x.d("MicroMsg.ContactCommDisplay", "username: %s", new Object[]{str});
        if (Yg == null) {
            return str;
        }
        if (str.toLowerCase().endsWith("@chatroom") && bi.oW(Yg.field_nickname)) {
            String gT = ((b) g.l(b.class)).Ga().gT(str);
            if (!bi.oW(gT)) {
                return gT;
            }
        }
        if (Yg.BK() == null || Yg.BK().length() <= 0) {
            return str;
        }
        return Yg.BK();
    }

    public static String gT(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        return s.a(((i) g.l(i.class)).FR().Yg(str), str);
    }

    public static String a(ab abVar, String str) {
        return s.a(abVar, str);
    }

    public static String a(ab abVar, String str, boolean z) {
        if (abVar == null) {
            return str;
        }
        if (z && bi.oW(abVar.field_nickname)) {
            return ((b) g.l(b.class)).Ga().gT(str);
        }
        if (abVar.BL() != null && abVar.BL().length() > 0) {
            return abVar.BL();
        }
        if (bi.oW(abVar.field_nickname) && s.hN(str)) {
            return a.fv(str);
        }
        return str;
    }

    public static String c(ab abVar) {
        String gT = gT(abVar.field_username);
        if (!s.fq(abVar.field_username) || !gT.equals(abVar.field_username)) {
            return gT;
        }
        List<String> il = ((b) g.l(b.class)).Ga().il(abVar.field_username);
        if (il == null || il.size() <= 0) {
            return ad.getResources().getString(com.tencent.mm.plugin.messenger.b.a.address_chatroom_contact_nick);
        }
        List arrayList = new ArrayList();
        for (String gT2 : il) {
            arrayList.add(gT(gT2));
        }
        return "(" + bi.c(arrayList, ", ") + ")";
    }

    public static String gU(String str) {
        ab Yg = ((i) g.l(i.class)).FR().Yg(str);
        if (Yg == null) {
            return "";
        }
        if (bi.oW(Yg.field_conRemark)) {
            return "";
        }
        return Yg.field_conRemark;
    }

    public static void d(Set<String> set) {
        dAL = set;
    }

    public static String gV(String str) {
        if (dAL.contains(str)) {
            return "";
        }
        return str;
    }
}
