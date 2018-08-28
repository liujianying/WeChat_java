package com.tencent.mm.plugin.appbrand.jsapi.bluetooth;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.plugin.report.service.h;
import java.util.ArrayList;

public final class c {
    public static void kB(int i) {
        h.mEJ.e(762, (long) i, 1);
    }

    public static void bK(int i, int i2) {
        ArrayList arrayList = new ArrayList();
        IDKey iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        iDKey = new IDKey();
        iDKey.SetID(762);
        iDKey.SetKey(i2);
        iDKey.SetValue(1);
        arrayList.add(iDKey);
        h.mEJ.b(arrayList, true);
    }
}
