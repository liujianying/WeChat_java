package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.plugin.scanner.a.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class k {
    public static LinkedList<String> bY(List<a> list) {
        LinkedList<String> linkedList = new LinkedList();
        for (int i = 0; i < list.size(); i++) {
            List list2 = ((a) list.get(i)).egs;
            for (int i2 = 0; i2 < list2.size(); i2++) {
                a aVar = (a) list2.get(i2);
                if (a(aVar)) {
                    linkedList.add(aVar.aAL);
                }
            }
        }
        return linkedList;
    }

    public static Map<String, a> bZ(List<String> list) {
        Map<String, a> hashMap = new HashMap();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return hashMap;
            }
            String str = (String) list.get(i2);
            x.d("MicroMsg.ProductUpdateLogic", "toUpdateXmlList info: i=" + i2 + ";" + bi.oV(str));
            a n = a.n(bl.z(str, "action"), ".action");
            if (!(n == null || n.showType == 2)) {
                hashMap.put(n.aAL, n);
            }
            i = i2 + 1;
        }
    }

    public static boolean b(List<a> list, Map<String, a> map) {
        if (map == null || map.size() <= 0 || list == null) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                boolean z2;
                List list2 = ((a) list.get(i)).egs;
                int i2 = 0;
                boolean z3 = false;
                while (true) {
                    z2 = z;
                    if (i2 >= list2.size()) {
                        break;
                    }
                    a aVar = (a) list2.get(i2);
                    if (a(aVar)) {
                        a aVar2 = (a) map.get(aVar.aAL);
                        if (aVar2 != null) {
                            x.i("MicroMsg.ProductUpdateLogic", "Updating action , info: key=" + aVar.aAL);
                            list2.remove(i2);
                            list2.add(i2, aVar2);
                            z3 = true;
                            int i3 = 1;
                        }
                        z = z3;
                    } else {
                        z = true;
                    }
                    i2++;
                }
                ((a) list.get(i)).mFs = z3;
                z = z2;
            }
        }
        return z;
    }

    public static boolean a(a aVar) {
        return !bi.oW(aVar.aAL);
    }
}
