package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class c {
    private static List<a> dmY = new LinkedList();
    private static Map<String, a> dmZ = new HashMap();

    public static a fH(String str) {
        return (a) dmZ.get(str);
    }

    public static a ax(Object obj) {
        for (a aVar : dmY) {
            if (aVar.aw(obj)) {
                return aVar;
            }
        }
        return null;
    }

    public static void a(Object obj, Parcel parcel) {
        a ax = ax(obj);
        if (ax != null) {
            ax.a(obj, parcel);
        }
    }

    public static Object a(String str, Parcel parcel) {
        a fH = fH(str);
        if (fH != null) {
            return fH.e(parcel);
        }
        return null;
    }

    public static void a(a aVar) {
        if (aVar != null && !dmY.contains(aVar)) {
            dmZ.put(aVar.getClass().getName(), aVar);
            dmY.add(aVar);
        }
    }
}
