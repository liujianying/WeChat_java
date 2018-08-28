package com.tencent.mm.plugin.appbrand.jsapi.f.a;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.appbrand.widget.e.c;
import com.tencent.mm.plugin.appbrand.widget.e.e;
import java.util.LinkedList;

public final class a {
    private static LinkedList<View> fSN = new LinkedList();
    private static LinkedList<e> fSO = new LinkedList();
    private static LinkedList<c> fSP = new LinkedList();

    public static c ajh() {
        c cVar;
        synchronized (fSP) {
            if (fSP.size() <= 0) {
                cVar = null;
            } else {
                cVar = (c) fSP.removeFirst();
                bJ(cVar);
            }
        }
        return cVar;
    }

    public static boolean a(c cVar) {
        boolean z;
        synchronized (fSP) {
            if (fSP.size() > 10) {
                z = false;
            } else {
                fSP.push(cVar);
                z = true;
            }
        }
        return z;
    }

    public static e aji() {
        e eVar;
        synchronized (fSO) {
            if (fSO.size() <= 0) {
                eVar = null;
            } else {
                eVar = (e) fSO.removeFirst();
                bJ(eVar);
            }
        }
        return eVar;
    }

    public static boolean a(e eVar) {
        boolean z;
        synchronized (fSO) {
            if (fSO.size() > 10) {
                z = false;
            } else {
                fSO.push(eVar);
                z = true;
            }
        }
        return z;
    }

    private static void bJ(View view) {
        if (view != null && ViewGroup.class.isInstance(view.getParent())) {
            ((ViewGroup) view.getParent()).removeView(view);
        }
    }
}
