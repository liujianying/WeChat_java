package com.tencent.c.e.a.a;

import android.content.Context;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.util.SparseArray;
import com.tencent.c.e.a.b.a;
import com.tencent.c.e.a.b.e;
import com.tencent.c.e.a.b.g;
import com.tencent.c.f.d;
import com.tencent.c.f.i;
import java.util.ArrayList;
import java.util.List;

public final class b {
    private static final int[] vjQ = new int[]{1, 5, 4, 8, 9, 2};
    private static int vjR = -1;

    public static a a(int i, int i2, Context context, int i3, SparseArray<i> sparseArray, List<k> list) {
        a aVar = new a();
        aVar.vkm = 0;
        aVar.vkn = "";
        aVar.pMn = i.bL(context, context.getPackageName()).versionCode;
        aVar.vie = "14D6ACDE3C2F2F48";
        aVar.bVU = 500000;
        aVar.requestType = i3;
        aVar.vkp = acn(context.getPackageName());
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.addAll(((i) sparseArray.valueAt(i4)).eg(list));
        }
        if (arrayList.size() <= 0 || arrayList.get(0) == null) {
            throw new IllegalArgumentException("invalid stateUnits");
        }
        e eVar = new e();
        eVar.vkx = ((g) arrayList.get(0)).vkC;
        eVar.vky = arrayList;
        eVar.vjz = i;
        eVar.action = i2;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(eVar);
        aVar.vko = arrayList2;
        aVar.imei = acn(d.ht(context));
        aVar.imsi = acn(d.hu(context));
        aVar.dMB = acn(Build.BRAND);
        aVar.model = acn(Build.MODEL);
        aVar.vkq = acn(Build.FINGERPRINT);
        aVar.vkr = hr(context);
        aVar.sdkVer = VERSION.SDK_INT;
        aVar.seW = 2;
        return aVar;
    }

    private static String acn(String str) {
        return str == null ? "" : str;
    }

    private static int hr(Context context) {
        if (vjR == -1) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            if (sensorManager == null) {
                return vjR;
            }
            int i = 1;
            for (int i2 = 0; i2 < vjQ.length; i2++) {
                int i3;
                if (sensorManager.getDefaultSensor(vjQ[i2]) == null) {
                    i3 = 0;
                } else {
                    i3 = 1;
                }
                i |= i3 << i2;
            }
            vjR = i;
        }
        return vjR;
    }
}
