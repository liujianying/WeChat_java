package com.tencent.mm.ac.a;

import com.tencent.mm.ac.o;
import com.tencent.mm.ac.z;
import com.tencent.mm.api.a;
import com.tencent.mm.api.g;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.plugin.p.c;
import com.tencent.mm.protocal.c.hu;
import com.tencent.mm.protocal.c.xr;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bd;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class e {
    public static String cqb = null;
    public static final Object dNr = new Object();

    public static boolean lb(String str) {
        if (str == null) {
            return false;
        }
        if (str.endsWith("@qy_u") || str.endsWith("@qy_g")) {
            return true;
        }
        return false;
    }

    public static boolean lc(String str) {
        if (str != null) {
            return str.endsWith("@qy_g");
        }
        x.i("MicroMsg.BizChatInfoStorageLogic", "isGroupChat chatId == null");
        return false;
    }

    public static boolean c(c cVar) {
        if (cVar == null) {
            return false;
        }
        List<String> Nn = cVar.Nn();
        String cA = ((g) com.tencent.mm.kernel.g.l(g.class)).cA(cVar.field_brandUserName);
        if (cA == null) {
            x.w("MicroMsg.BaseBizChatInfo", "bizchat myUserId is null");
            return false;
        }
        for (String equals : Nn) {
            if (cA.equals(equals)) {
                return true;
            }
        }
        x.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom myUserId is %s", new Object[]{cA});
        x.w("MicroMsg.BaseBizChatInfo", "bizchat not in chatroom memberlist is %s", new Object[]{Arrays.toString(Nn.toArray())});
        return false;
    }

    public static int bj(long j) {
        List bk = bk(j);
        if (bk != null) {
            return bk.size();
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "getMembersCountByBizChatId list == null");
        return 0;
    }

    public static List<String> bk(long j) {
        return z.Na().ak(j).Nn();
    }

    public static String ld(String str) {
        if (str == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getUserName bizChatId == null");
            return null;
        }
        j cz = z.Nc().cz(str);
        if (cz != null) {
            return cz.field_userName;
        }
        x.i("MicroMsg.BizChatInfoStorageLogic", "getUserName userInfo == null");
        return null;
    }

    public static String le(String str) {
        j cz = z.Nc().cz(str);
        if (cz != null) {
            return cz.field_headImageUrl;
        }
        return null;
    }

    public static c a(c cVar, long j) {
        String str = "MicroMsg.BizChatInfoStorageLogic";
        String str2 = "protectBizChatNotExist bizChatId:%s BizChatInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = Long.valueOf(j);
        objArr[1] = Long.valueOf(cVar == null ? -1 : cVar.field_bizChatLocalId);
        x.w(str, str2, objArr);
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        cVar2.field_bizChatLocalId = j;
        z.Na().b(cVar2);
        return z.Na().ak(j);
    }

    public static j a(j jVar, String str) {
        String str2 = "MicroMsg.BizChatInfoStorageLogic";
        String str3 = "protectBizChatNotExist userId:%s BizChatUserInfo:%s ";
        Object[] objArr = new Object[2];
        objArr[0] = str;
        objArr[1] = jVar == null ? Integer.valueOf(-1) : jVar.field_userId;
        x.w(str2, str3, objArr);
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j();
        jVar2.field_userId = str;
        z.Nc().b(jVar2);
        jVar = z.Nc().cz(str);
        if (jVar != null) {
            return jVar;
        }
        x.e("MicroMsg.BizChatInfoStorageLogic", "protectContactNotExist contact get from db is null!");
        return jVar2;
    }

    public static j lf(String str) {
        j jVar = null;
        if (bi.oW(str)) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo brandUserName==null");
        } else {
            f lk = z.Nd().lk(str);
            if (lk == null) {
                x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatMyUserInfo==null");
            } else {
                jVar = z.Nc().cz(lk.field_userId);
                if (jVar == null) {
                    x.w("MicroMsg.BizChatInfoStorageLogic", "getBizChatMyUserInfo bizChatUserInfo==null");
                }
            }
        }
        return jVar;
    }

    public static String lg(String str) {
        if (str == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource msgSource==null");
            return null;
        }
        int indexOf = str.indexOf("<enterprise_info>") + 17;
        int indexOf2 = str.indexOf("</enterprise_info>");
        if (indexOf == -1 || indexOf2 == -1 || indexOf >= indexOf2) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getFormatMsgSource error start:%s,end:%s", new Object[]{Integer.valueOf(indexOf), Integer.valueOf(indexOf2)});
            return null;
        }
        CharSequence substring = str.substring(indexOf, indexOf2);
        return str.replace(substring, substring.replace("<", "&lt;").replace(">", "&gt;"));
    }

    public static String Ir() {
        String str;
        synchronized (dNr) {
            str = cqb;
        }
        return str;
    }

    public static String d(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "getMsgSource bizChatInfo=%s");
            return null;
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "format msgSource");
        if (cVar.field_bizChatServId == null) {
            x.d("MicroMsg.BizChatInfoStorageLogic", "getMsgSource field_bizChatId=%s", new Object[]{cVar.field_bizChatServId});
            return null;
        }
        j lf = lf(cVar.field_brandUserName);
        if (lf == null || lf.field_userId == null) {
            x.d("MicroMsg.BizChatInfoStorageLogic", " bizChatMyUserInfo.field_userId is null getMsgSource field_bizChatId=%s", new Object[]{cVar.field_bizChatServId});
            return null;
        }
        synchronized (dNr) {
            cqb = String.format("<msgsource><enterprise_info><qy_msg_type>%d</qy_msg_type><bizchat_id>%s</bizchat_id><bizchat_ver>%d</bizchat_ver><user_id>%s</user_id></enterprise_info></msgsource>", new Object[]{Integer.valueOf(1), cVar.field_bizChatServId, Integer.valueOf(cVar.field_chatVersion), lf.field_userId});
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "send msgSource:%s", new Object[]{cqb});
        return cqb;
    }

    public static void lh(String str) {
        synchronized (dNr) {
            cqb = str;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.ac.a.c e(com.tencent.mm.ac.a.c r4) {
        /*
        r3 = 1;
        r0 = r4.field_bizChatServId;
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        r4 = 0;
    L_0x0006:
        return r4;
    L_0x0007:
        r0 = com.tencent.mm.ac.z.Na();
        r1 = r4.field_bizChatServId;
        r0 = r0.la(r1);
        if (r0 == 0) goto L_0x0057;
    L_0x0013:
        r1 = r4.field_chatVersion;
        r2 = r0.field_chatVersion;
        if (r1 > r2) goto L_0x0021;
    L_0x0019:
        r1 = r0.field_brandUserName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 == 0) goto L_0x0063;
    L_0x0021:
        r1 = r4.field_chatName;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x002d;
    L_0x0029:
        r1 = r4.field_chatName;
        r0.field_chatName = r1;
    L_0x002d:
        r1 = r4.field_brandUserName;
        r0.field_brandUserName = r1;
        r0.field_needToUpdate = r3;
        r1 = r4.field_chatType;
        r0.field_chatType = r1;
        r1 = com.tencent.mm.ac.z.Na();
        r1.b(r0);
        r4 = r0;
    L_0x003f:
        r0 = r4.No();
        if (r0 == 0) goto L_0x0006;
    L_0x0045:
        r0 = r4.isGroup();
        if (r0 == 0) goto L_0x0065;
    L_0x004b:
        r0 = com.tencent.mm.ac.z.Ng();
        r1 = r4.field_bizChatServId;
        r2 = r4.field_brandUserName;
        r0.aj(r1, r2);
        goto L_0x0006;
    L_0x0057:
        r4.field_needToUpdate = r3;
        r1 = com.tencent.mm.ac.z.Na();
        r1 = r1.a(r4);
        if (r1 != 0) goto L_0x003f;
    L_0x0063:
        r4 = r0;
        goto L_0x003f;
    L_0x0065:
        r0 = com.tencent.mm.ac.z.Ng();
        r1 = r4.field_bizChatServId;
        r2 = r4.field_brandUserName;
        r0.ak(r1, r2);
        goto L_0x0006;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ac.a.e.e(com.tencent.mm.ac.a.c):com.tencent.mm.ac.a.c");
    }

    public static boolean f(c cVar) {
        x.d("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember");
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: bizChatInfo == null");
            return false;
        }
        List<String> Nn = cVar.Nn();
        if (Nn == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: list == null");
            return false;
        }
        LinkedList linkedList = new LinkedList();
        for (String str : Nn) {
            j cz = z.Nc().cz(str);
            if (cz != null && cz.No()) {
                linkedList.add(str);
            }
        }
        if (linkedList.size() > 0) {
            z.Ng().b(linkedList, cVar.field_brandUserName);
            return true;
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "updateBizChatMember: no need to update");
        return false;
    }

    public static String bl(long j) {
        return z.Na().ak(j).field_bizChatServId;
    }

    public static long li(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "chatId == null");
            return -1;
        }
        c la = z.Na().la(str);
        if (la != null) {
            return la.field_bizChatLocalId;
        }
        x.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo == null");
        return -1;
    }

    public static void D(String str, boolean z) {
        if (bi.oW(str)) {
            x.d("MicroMsg.BizChatInfoStorageLogic", "delEnterpriseChatConvAndHeadImg, empty brandUserName");
            return;
        }
        x.d("MicroMsg.BizChatInfoStorageLogic", "deleteMsgByTalkers");
        com.tencent.mm.kernel.g.Em().H(new 1(str, z));
    }

    public static void n(final String str, final String str2, final String str3) {
        x.i("MicroMsg.BizChatInfoStorageLogic", "qy_chat_update %s, %s, %s", new Object[]{str, str2, str3});
        com.tencent.mm.kernel.g.Em().H(new Runnable() {
            public final void run() {
                c la = z.Na().la(str2);
                if (la != null) {
                    if (la.field_chatVersion < bi.getInt(str3, Integer.MAX_VALUE)) {
                        la.field_needToUpdate = true;
                        z.Na().b(la);
                    }
                    if (la.isGroup()) {
                        z.Ng().aj(la.field_bizChatServId, str);
                    } else {
                        z.Ng().ak(la.field_bizChatServId, str);
                    }
                }
            }
        });
    }

    public static String cy(String str) {
        return a.cy(str);
    }

    public static String lj(String str) {
        if (bi.oW(str)) {
            str = "tempUser";
        }
        StringBuilder stringBuilder = new StringBuilder(c.Gc());
        stringBuilder.append(com.tencent.mm.a.g.u(str.getBytes())).append("/");
        stringBuilder.append("user/");
        return stringBuilder.toString();
    }

    public static boolean a(c cVar, String str, String str2, xr xrVar) {
        if (!(str == null || bi.oW(cVar.field_brandUserName))) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 1 && bi.oW(str2)) {
                    boolean z;
                    JSONObject jSONObject = jSONArray.getJSONObject(0);
                    String string = jSONObject.getString("id");
                    j cz = z.Nc().cz(string);
                    if (cz == null) {
                        cz = new j();
                        z = true;
                    } else {
                        z = false;
                    }
                    cz.field_userId = string;
                    cz.field_userName = jSONObject.getString("nick_name");
                    cz.field_headImageUrl = jSONObject.getString("head_img_url");
                    cz.field_profileUrl = jSONObject.getString("profile_url");
                    cz.field_UserVersion = jSONObject.getInt("ver");
                    if (cz.field_brandUserName == null || cz.field_brandUserName.length() == 0) {
                        cz.field_brandUserName = cVar.field_brandUserName;
                        z = true;
                    }
                    if (cz.field_addMemberUrl == null || cz.field_addMemberUrl.length() == 0) {
                        cz.field_addMemberUrl = cVar.field_addMemberUrl;
                        z = true;
                    }
                    if (!z.Nc().b(cz)) {
                        z.Nc().a(cz);
                    }
                    if (z) {
                        z.Ng().al(cz.field_userId, cz.field_brandUserName);
                    }
                    c cVar2 = new c();
                    cVar2.field_bizChatServId = cz.field_userId;
                    cVar2.field_brandUserName = cz.field_brandUserName;
                    cVar2.field_chatName = cz.field_userName;
                    cVar2.field_chatType = 1;
                    cVar2 = e(cVar2);
                    if (cVar2 == null) {
                        return false;
                    }
                    cVar.field_bizChatLocalId = cVar2.field_bizChatLocalId;
                    cVar.field_chatName = cz.field_userName;
                    return true;
                }
                LinkedList linkedList = new LinkedList();
                if (!bi.oW(str2)) {
                    hu huVar = new hu();
                    huVar.riL = str2;
                    linkedList.add(huVar);
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    j jVar = new j();
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    jVar.field_userId = jSONObject2.getString("id");
                    jVar.field_userName = jSONObject2.getString("nick_name");
                    jVar.field_brandUserName = cVar.field_brandUserName;
                    jVar.field_headImageUrl = jSONObject2.getString("head_img_url");
                    jVar.field_profileUrl = jSONObject2.getString("profile_url");
                    jVar.field_UserVersion = jSONObject2.getInt("ver");
                    jVar.field_addMemberUrl = cVar.field_addMemberUrl;
                    if (!z.Nc().b(jVar)) {
                        z.Nc().a(jVar);
                    }
                    hu huVar2 = new hu();
                    huVar2.riL = jVar.field_userId;
                    linkedList.add(huVar2);
                }
                xrVar.riM = linkedList;
                cVar.field_bizChatLocalId = -1;
                return true;
            } catch (Throwable e) {
                x.i("MicroMsg.BizChatInfoStorageLogic", "parse memberJson Exception:%s", new Object[]{e.getMessage()});
                x.printErrStackTrace("MicroMsg.BizChatInfoStorageLogic", e, "", new Object[0]);
            }
        }
        return false;
    }

    public static void g(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "bizChatInfo is null");
            return;
        }
        boolean bg = z.Nb().bg(cVar.field_bizChatLocalId);
        boolean hu = cVar.hu(16);
        x.d("MicroMsg.BizChatInfoStorageLogic", "convPlaceTop: %s ,bizChatPlaceTop: %s, chatName: %s ", new Object[]{Boolean.valueOf(bg), Boolean.valueOf(hu), cVar.field_chatName});
        if (hu && !bg) {
            z.Nb().bh(cVar.field_bizChatLocalId);
        } else if (!hu && bg) {
            z.Nb().bi(cVar.field_bizChatLocalId);
        }
    }

    public static void h(c cVar) {
        if (cVar == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName bizChatInfo is null");
            return;
        }
        ai Yq = ((i) com.tencent.mm.kernel.g.l(i.class)).FW().Yq(cVar.field_brandUserName);
        if (Yq == null) {
            x.w("MicroMsg.BizChatInfoStorageLogic", "updateBrandUserConvName cvs is null");
            return;
        }
        bd GE = ((i) com.tencent.mm.kernel.g.l(i.class)).bcY().GE(cVar.field_brandUserName);
        bd aq = ((o) com.tencent.mm.kernel.g.l(o.class)).FU().aq(cVar.field_brandUserName, cVar.field_bizChatLocalId);
        if (GE != null && aq != null && GE.field_msgId == aq.field_msgId) {
            String str = Yq.field_digest;
            if (str != null) {
                int indexOf = str.indexOf(":");
                if (indexOf != -1) {
                    String substring = str.substring(0, indexOf);
                    str = str.substring(indexOf + 1);
                    if (substring != null && !substring.equals(cVar.field_chatName)) {
                        Yq.ed(cVar.field_chatName + ":" + str);
                        ((i) com.tencent.mm.kernel.g.l(i.class)).FW().a(Yq, Yq.field_username);
                    }
                }
            }
        }
    }
}
