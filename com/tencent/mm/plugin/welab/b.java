package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.plugin.welab.c.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b qmL = new b();
    public c pNL;
    public a qmM;
    public Map<String, com.tencent.mm.plugin.welab.a.a.b> qmN = new HashMap();
    public com.tencent.mm.plugin.welab.a.a.b qmO;

    public b() {
        c.a aVar = new c.a();
        aVar.dXy = true;
        aVar.dXx = true;
        this.pNL = aVar.Pt();
    }

    public static b bYI() {
        return qmL;
    }

    public static String a(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b RS = qmL.RS(aVar.field_LabsAppId);
        if (RS != null) {
            str = aVar.field_LabsAppId;
            str = RS.bYR();
            x.i("WelabMgr", "get appName from opener , appid %s, appName %s", new Object[]{aVar.field_LabsAppId, str});
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.Sa("field_Title");
        }
        return str;
    }

    public static String b(com.tencent.mm.plugin.welab.c.a.a aVar) {
        String str = "";
        com.tencent.mm.plugin.welab.a.a.b RS = qmL.RS(aVar.field_LabsAppId);
        if (RS != null) {
            str = aVar.field_LabsAppId;
            str = RS.bYQ();
            x.i("WelabMgr", "get icon url from opener , appid %s, url %s", new Object[]{aVar.field_LabsAppId, str});
        }
        if (TextUtils.isEmpty(str)) {
            return aVar.field_Icon;
        }
        return str;
    }

    private com.tencent.mm.plugin.welab.a.a.b RS(String str) {
        return (com.tencent.mm.plugin.welab.a.a.b) this.qmN.get(str);
    }

    public static void O(boolean z, boolean z2) {
        f.P(z, z2);
    }

    public final List<com.tencent.mm.plugin.welab.c.a.a> bYJ() {
        List<com.tencent.mm.plugin.welab.c.a.a> bYS = this.qmM.bYS();
        Iterator it = bYS.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.welab.c.a.a aVar = (com.tencent.mm.plugin.welab.c.a.a) it.next();
            if (!aVar.isRunning() || (!(aVar.field_Switch == 2 || aVar.field_Switch == 1) || "labs1de6f3".equals(aVar.field_LabsAppId))) {
                it.remove();
            }
        }
        x.i("WelabMgr", new StringBuilder("online lab ").append(bYS).toString() != null ? bYS.toString() : "");
        return bYS;
    }

    public final com.tencent.mm.plugin.welab.c.a.a RT(String str) {
        a aVar = this.qmM;
        com.tencent.mm.plugin.welab.c.a.a aVar2 = new com.tencent.mm.plugin.welab.c.a.a();
        aVar2.field_LabsAppId = str;
        aVar.b(aVar2, new String[0]);
        return aVar2;
    }
}
