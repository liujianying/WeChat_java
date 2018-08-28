package com.tencent.tinker.loader.hotplug;

import java.util.HashMap;
import java.util.Map;

public class ActivityStubManager {
    private static Map<String, String> vtJ = new HashMap();
    private static final int[] vtK = new int[]{10, 3};
    private static final int[] vtL = new int[]{10, 3};
    private static final int[] vtM = new int[]{10, 3};
    private static final int[] vtN = new int[]{10, 3};
    private static final int[] vtO = new int[]{0, 0};
    private static final int[] vtP = new int[]{0, 0};
    private static final int[] vtQ = new int[]{0, 0};
    private static final int[] vtR = new int[]{0, 0};

    public static String r(String str, int i, boolean z) {
        String str2 = (String) vtJ.get(str);
        if (str2 != null) {
            return str2;
        }
        String str3;
        int[] iArr;
        int[] iArr2;
        int i2;
        int[] iArr3;
        switch (i) {
            case 1:
                str3 = ActivityStubs.vtU;
                iArr3 = vtP;
                iArr = vtL;
                iArr2 = iArr3;
                break;
            case 2:
                str3 = ActivityStubs.vtV;
                iArr3 = vtQ;
                iArr = vtM;
                iArr2 = iArr3;
                break;
            case 3:
                str3 = ActivityStubs.vtW;
                iArr3 = vtR;
                iArr = vtN;
                iArr2 = iArr3;
                break;
            default:
                str3 = ActivityStubs.vtT;
                iArr3 = vtO;
                iArr = vtK;
                iArr2 = iArr3;
                break;
        }
        if (z) {
            str3 = str3 + "_T";
            i2 = 1;
        } else {
            i2 = 0;
        }
        int i3 = iArr2[i2];
        iArr2[i2] = i3 + 1;
        if (i3 >= iArr[i2]) {
            iArr2[i2] = 0;
            i2 = 0;
        } else {
            i2 = i3;
        }
        str2 = String.format(str3, new Object[]{Integer.valueOf(i2)});
        vtJ.put(str, str2);
        return str2;
    }

    private ActivityStubManager() {
        throw new UnsupportedOperationException();
    }
}
