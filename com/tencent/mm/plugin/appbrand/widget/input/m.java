package com.tencent.mm.plugin.appbrand.widget.input;

import android.support.v4.e.a;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.r.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.h;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum m {
    ;
    
    public static final Map<String, Integer> gHq = null;
    public static final Set<String> gHr = null;
    private static final Map<Integer, WeakReference<y>> gHs = null;
    private static final a<p, z> gHt = null;

    static {
        Set hashSet = new HashSet();
        hashSet.add("text");
        hashSet.add("emoji");
        hashSet.add("number");
        hashSet.add("digit");
        hashSet.add("idcard");
        gHr = Collections.unmodifiableSet(hashSet);
        Map hashMap = new HashMap(3);
        hashMap.put("digit", Integer.valueOf(2));
        hashMap.put("number", Integer.valueOf(0));
        hashMap.put("idcard", Integer.valueOf(1));
        gHq = Collections.unmodifiableMap(hashMap);
        gHs = new HashMap();
        gHt = new a();
    }

    public static void m(p pVar) {
        if (pVar != null) {
            j jVar = new j(pVar);
        }
    }

    static void a(int i, y yVar) {
        if (yVar != null) {
            c.runOnUiThread(new 1(i, yVar));
        }
    }

    static y lY(int i) {
        WeakReference weakReference = (WeakReference) gHs.get(Integer.valueOf(i));
        return weakReference == null ? null : (y) weakReference.get();
    }

    public static void a(p pVar, String str, Integer num) {
        if (pVar != null) {
            c.runOnUiThread(new 2(pVar, str, num));
        }
    }

    @Deprecated
    public static boolean a(h hVar, int i) {
        WeakReference weakReference = (WeakReference) gHs.get(Integer.valueOf(i));
        y yVar = weakReference == null ? null : (y) weakReference.get();
        AppBrandInputInvokeHandler appBrandInputInvokeHandler = yVar instanceof AppBrandInputInvokeHandler ? (AppBrandInputInvokeHandler) yVar : null;
        return appBrandInputInvokeHandler != null && appBrandInputInvokeHandler.updateInput(hVar);
    }

    public static boolean n(p pVar) {
        return a(pVar, null);
    }

    public static boolean a(p pVar, Integer num) {
        if (num == null) {
            z zVar = (z) gHt.get(pVar);
            if (zVar == null) {
                return false;
            }
            num = Integer.valueOf(zVar.getInputId());
        }
        y lY = lY(num.intValue());
        return lY != null && lY.hideKeyboard();
    }

    public static boolean a(p pVar, int i, int i2, int i3) {
        y lY = lY(i);
        return lY != null && lY.isAttachedTo(pVar) && lY.showKeyboard(i2, i3);
    }

    public static void o(p pVar) {
        ah.A(new 3(pVar));
    }

    public static boolean lZ(int i) {
        y lY = lY(i);
        return lY != null && lY.removeSelf();
    }

    static void a(p pVar, z zVar) {
        if (pVar != null) {
            c.runOnUiThread(new 4(pVar, zVar));
        }
    }

    static void p(p pVar) {
        if (pVar != null) {
            c.runOnUiThread(new 5(pVar));
        }
    }

    static y q(p pVar) {
        if (pVar == null) {
            return null;
        }
        z zVar = (z) gHt.get(pVar);
        if (zVar == null) {
            return null;
        }
        return lY(zVar.getInputId());
    }
}
