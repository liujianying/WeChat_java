package com.tencent.mm.plugin.webview.ui.tools.game.menu;

import android.content.Context;
import com.tencent.mm.protocal.c.atl;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.l;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class c {
    private static c qgs;

    public static c bXN() {
        if (qgs == null) {
            synchronized (c.class) {
                if (qgs == null) {
                    qgs = new c();
                }
            }
        }
        return qgs;
    }

    public static l c(Context context, List<atl> list) {
        if (bi.cX(list)) {
            return null;
        }
        List<atl> arrayList = new ArrayList();
        for (atl atl : list) {
            if (atl != null && a.Ba(atl.rDF)) {
                arrayList.add(atl);
            }
        }
        if (bi.cX(arrayList)) {
            return null;
        }
        Collections.sort(arrayList, new 1());
        int i = ((atl) arrayList.get(arrayList.size() - 1)).rWP;
        List<atl> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < i; i2++) {
            arrayList2.add(null);
        }
        for (atl atl2 : arrayList) {
            if (atl2.rWP > 0 && atl2.rWP <= arrayList2.size()) {
                arrayList2.set(atl2.rWP - 1, atl2);
            }
        }
        l lVar = new l(context);
        for (atl atl22 : arrayList2) {
            if (atl22 == null) {
                lVar.e(-1, "");
            } else {
                lVar.e(atl22.rWO, atl22.bHD + "__" + atl22.lPl);
            }
        }
        return lVar;
    }
}
