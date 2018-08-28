package com.tencent.mm.ac.a;

import com.tencent.mm.ac.z;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class k extends i<j> {
    public static final String[] diD = new String[]{i.a(j.dhO, "BizChatUserInfo")};
    final com.tencent.mm.sdk.e.k<a, b> dKC = new com.tencent.mm.sdk.e.k<a, b>() {
        protected final /* bridge */ /* synthetic */ void q(Object obj, Object obj2) {
        }
    };
    Map<String, String> dNh = new HashMap();
    public e diF;

    public interface a {
    }

    public k(e eVar) {
        super(eVar, j.dhO, "BizChatUserInfo", null);
        this.diF = eVar;
        eVar.fV("BizChatUserInfo", "CREATE INDEX IF NOT EXISTS bizUserIdIndex ON BizChatUserInfo ( userId )");
        this.dNh.clear();
    }

    public final j cz(String str) {
        if (bi.oW(str)) {
            x.w("MicroMsg.BizChatUserInfoStorage", "get  wrong argument");
            return null;
        }
        j jVar = new j();
        jVar.field_userId = str;
        super.b(jVar, new String[0]);
        return jVar;
    }

    /* renamed from: a */
    public final boolean b(j jVar) {
        x.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo insert");
        if (jVar == null) {
            x.w("MicroMsg.BizChatUserInfoStorage", "insert wrong argument");
            return false;
        }
        boolean b = super.b(jVar);
        if (!b) {
            return b;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.dNR = a.dNN;
        bVar.dNS = jVar;
        this.dKC.ci(bVar);
        this.dKC.doNotify();
        return b;
    }

    public final boolean b(j jVar) {
        x.d("MicroMsg.BizChatUserInfoStorage", "BizChatUserInfo update");
        if (jVar == null) {
            x.w("MicroMsg.BizChatUserInfoStorage", "update wrong argument");
            return false;
        }
        if (jVar == null || bi.oW(jVar.field_userName)) {
            x.i("MicroMsg.BizChatUserInfoStorage", "dealWithChatNamePY null");
        } else {
            jVar.field_userNamePY = h.oI(jVar.field_userName);
        }
        boolean a = super.a(jVar);
        if (!a) {
            return a;
        }
        b bVar = new b();
        bVar.userId = jVar.field_userId;
        bVar.dNR = a.dNP;
        bVar.dNS = jVar;
        this.dKC.ci(bVar);
        this.dKC.doNotify();
        return a;
    }

    public final j lm(String str) {
        if (str == null) {
            x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo brandUserName is null");
            return null;
        }
        String cA = cA(str);
        if (cA != null) {
            return cz(cA);
        }
        x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserInfo myUserIdString is null");
        return null;
    }

    public final String cA(String str) {
        if (str == null) {
            x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId brandUserName is null");
            return null;
        }
        x.i("MicroMsg.BizChatUserInfoStorage", "getMyUserId:%s", new Object[]{str});
        if (this.dNh.containsKey(str) && this.dNh.get(str) != null) {
            return (String) this.dNh.get(str);
        }
        f lk = z.Nd().lk(str);
        if (lk != null) {
            x.d("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo brandUserName:%s,%s", new Object[]{str, lk.field_userId});
            this.dNh.put(str, lk.field_userId);
            return lk.field_userId;
        }
        x.w("MicroMsg.BizChatUserInfoStorage", "getMyUserId bizChatMyUserInfo == null brandUserName:%s", new Object[]{str});
        return null;
    }

    public final void c(j jVar) {
        x.i("MicroMsg.BizChatUserInfoStorage", "updateUserName");
        j cz = cz(jVar.field_userId);
        if (cz == null) {
            b(jVar);
        } else if (!bi.oW(jVar.field_userName) && !jVar.field_userName.equals(cz.field_userName)) {
            cz.field_userName = jVar.field_userName;
            b(cz);
        }
    }

    public static String a(String[] strArr, List<String> list) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(" 1=1 ");
        String str = "";
        if (list != null && list.size() > 0) {
            String str2;
            Iterator it = list.iterator();
            while (true) {
                str2 = str;
                if (!it.hasNext()) {
                    break;
                }
                str = str2 + " and userId != '" + ((String) it.next()) + "'";
            }
            str = str2;
        }
        stringBuilder.append(str);
        stringBuilder.append(" and ");
        stringBuilder.append("userId in(");
        for (int i = 0; i < strArr.length; i++) {
            if (i > 0) {
                stringBuilder.append(" , ");
            }
            stringBuilder.append(" '").append(strArr[i]).append("' ");
        }
        stringBuilder.append(" )");
        return stringBuilder.toString();
    }
}
