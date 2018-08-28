package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.mm.ipcinvoker.d.b;
import com.tencent.mm.ipcinvoker.d.e;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.plugin.appbrand.wxawidget.a;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    private static final Map<String, List<a>> dmH = new ConcurrentHashMap();
    private static List<a> gQp = new LinkedList();
    private static final e gQq = new 1();

    static /* synthetic */ void b(String str, ArrayList arrayList) {
        if (!bi.oW(str) && arrayList != null && !arrayList.isEmpty()) {
            for (a at : new LinkedList(gQp)) {
                at.at(arrayList);
            }
            List list = (List) dmH.get(str);
            if (list != null) {
                for (a at2 : new LinkedList(list)) {
                    at2.at(arrayList);
                }
            }
        }
    }

    public static boolean a(a aVar) {
        if (gQp.contains(aVar)) {
            return false;
        }
        if (dmH.isEmpty() && gQp.isEmpty()) {
            com.tencent.mm.ipcinvoker.d.d dVar = c.gQo;
            e eVar = gQq;
            com.tencent.mm.ipcinvoker.d dVar2 = dVar.dmX;
            String str = dVar.bHA;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Parcelable bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.au(eVar));
                bundle.putString("Event", str);
                f.a(dVar2.dmw, bundle, com.tencent.mm.ipcinvoker.d.a.class, eVar);
            }
        }
        return gQp.add(aVar);
    }

    public static boolean b(a aVar) {
        boolean remove = gQp.remove(aVar);
        if (dmH.isEmpty() && gQp.isEmpty()) {
            com.tencent.mm.ipcinvoker.d.d dVar = c.gQo;
            e eVar = gQq;
            com.tencent.mm.ipcinvoker.d dVar2 = dVar.dmX;
            String str = dVar.bHA;
            if (!(str == null || str.length() == 0 || eVar == null)) {
                Parcelable bundle = new Bundle();
                bundle.putString("Token", com.tencent.mm.ipcinvoker.d.au(eVar));
                bundle.putString("Event", str);
                f.a(dVar2.dmw, bundle, b.class, null);
            }
        }
        return remove;
    }
}
