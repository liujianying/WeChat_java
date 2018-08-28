package com.tencent.mm.plugin.welab.d;

import android.text.TextUtils;
import com.tencent.mm.kernel.g;
import com.tencent.mm.s.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static final b qnt = new b();
    public Map<String, Integer> qmR = new HashMap();
    public String tag = "";

    public static b bYX() {
        return qnt;
    }

    private b() {
        bYM();
    }

    private void bYM() {
        this.tag = (String) g.Ei().DT().get(a.sXi, null);
        x.i("WeLabRedPointMgr", "load red tag " + this.tag);
        if (!TextUtils.isEmpty(this.tag)) {
            for (Object obj : this.tag.split("&")) {
                if (!TextUtils.isEmpty(obj)) {
                    String[] split = obj.split("=");
                    if (split != null && split.length == 2) {
                        this.qmR.put(split[0], Integer.valueOf(bi.WU(split[1])));
                    }
                }
            }
        }
    }

    public final boolean e(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (aVar.field_RedPoint != 1) {
            return false;
        }
        boolean z = aVar.bTJ() || aVar.field_Switch == 3;
        if (z || Sc(aVar.field_LabsAppId)) {
            return false;
        }
        return true;
    }

    private boolean Sc(String str) {
        return this.qmR.containsKey(str) && ((Integer) this.qmR.get(str)).intValue() == 1;
    }

    public final void f(com.tencent.mm.plugin.welab.c.a.a aVar) {
        if (aVar.field_RedPoint == 1 && !Sc(aVar.field_LabsAppId) && aVar.bYT()) {
            c.Cp().v(266267, true);
        }
    }

    public static void bYY() {
        Object obj;
        List<com.tencent.mm.plugin.welab.c.a.a> bYJ = com.tencent.mm.plugin.welab.b.bYI().bYJ();
        if (bYJ == null || bYJ.isEmpty()) {
        } else {
        }
        for (com.tencent.mm.plugin.welab.c.a.a aVar : bYJ) {
            if (aVar != null && qnt.e(aVar)) {
                obj = null;
                break;
            }
        }
        int obj2 = 1;
        if (obj2 != null) {
            c.Cp().aV(266267, 266241);
        }
    }

    public static boolean bYZ() {
        return c.Cp().aU(266267, 266241);
    }

    public static boolean bZa() {
        return ad.chZ().getBoolean("key_has_enter_welab", false);
    }
}
