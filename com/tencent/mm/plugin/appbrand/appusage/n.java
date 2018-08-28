package com.tencent.mm.plugin.appbrand.appusage;

import android.os.Bundle;
import com.tencent.mm.plugin.appbrand.config.k.a;
import com.tencent.mm.plugin.appbrand.config.r;
import com.tencent.mm.protocal.c.cgr;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

enum n {
    ;

    static void a(int i, Bundle bundle, LinkedList<cgr> linkedList) {
        a aVar;
        Collection hashSet = new HashSet();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            cgr cgr = (cgr) it.next();
            if (!bi.oW(cgr.username)) {
                hashSet.add(cgr.username);
            }
        }
        List arrayList = new ArrayList(hashSet.size());
        arrayList.addAll(hashSet);
        if (i != 3) {
            aVar = a.frs;
        } else if (bundle == null || bundle.getInt("launcher_ui_enter_scene") != 13) {
            aVar = a.frt;
        } else {
            aVar = a.frv;
        }
        r.a(arrayList, aVar);
    }
}
