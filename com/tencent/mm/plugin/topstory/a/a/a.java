package com.tencent.mm.plugin.topstory.a.a;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.f;
import java.util.ArrayList;

public final class a {
    public static int bzI = 845;

    public static void a(com.tencent.mm.plugin.topstory.a.b.a aVar) {
        ArrayList arrayList;
        IDKey iDKey;
        if (aVar.ozb > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(bzI);
            iDKey.SetKey(0);
            iDKey.SetValue(aVar.ozb);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(bzI);
            iDKey.SetKey(1);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            f.mDy.b(arrayList, false);
        }
        if (aVar.oyS > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(bzI);
            iDKey.SetKey(2);
            iDKey.SetValue(aVar.oyS);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(bzI);
            iDKey.SetKey(3);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            f.mDy.b(arrayList, false);
        }
        if (aVar.ozc > 0) {
            arrayList = new ArrayList();
            iDKey = new IDKey();
            iDKey.SetID(bzI);
            iDKey.SetKey(4);
            iDKey.SetValue(aVar.ozc);
            arrayList.add(iDKey);
            iDKey = new IDKey();
            iDKey.SetID(bzI);
            iDKey.SetKey(5);
            iDKey.SetValue(1);
            arrayList.add(iDKey);
            f.mDy.b(arrayList, false);
        }
    }
}
