package com.tencent.mm.platformtools;

import android.graphics.Bitmap;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bi;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Vector;

public final class y {
    private static Vector<WeakReference<a>> dHo = new Vector();
    private static LinkedList<a> ewc = new LinkedList();

    public interface a {
        void m(String str, Bitmap bitmap);
    }

    static /* synthetic */ void l(String str, Bitmap bitmap) {
        Collection vector = new Vector();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < dHo.size()) {
                WeakReference weakReference = (WeakReference) dHo.get(i2);
                if (weakReference != null) {
                    a aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.m(str, bitmap);
                    } else {
                        vector.add(weakReference);
                    }
                }
                i = i2 + 1;
            } else {
                dHo.removeAll(vector);
                return;
            }
        }
    }

    public static boolean a(a aVar) {
        return dHo.add(new WeakReference(aVar));
    }

    public static boolean b(a aVar) {
        ewc.remove(aVar);
        return ewc.add(aVar);
    }

    public static boolean c(a aVar) {
        return ewc.remove(aVar);
    }

    public static Bitmap a(w wVar) {
        if (!b(wVar)) {
            return null;
        }
        if (!g.Ei().DW()) {
            return wVar.VA();
        }
        if (wVar.Vz()) {
            return b.a(b.ewd, wVar);
        }
        return b.b(b.ewd, wVar);
    }

    public static Bitmap oQ(String str) {
        return b.oQ(str);
    }

    public static Bitmap o(String str, int i, int i2) {
        return b.o(str, i, i2);
    }

    public static Bitmap oR(String str) {
        return b.oR(str);
    }

    private static boolean b(w wVar) {
        if (wVar == null || bi.oW(wVar.Vw())) {
            return false;
        }
        return true;
    }
}
