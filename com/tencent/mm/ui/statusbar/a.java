package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class a {
    private static b dQ(View view) {
        if (view == null) {
            return null;
        }
        View view2 = view;
        while (!(view2 instanceof b)) {
            ViewParent parent = view2.getParent();
            if (parent == null || !(parent instanceof ViewGroup)) {
                return null;
            }
            view2 = (View) parent;
        }
        return (b) view2;
    }

    public static void c(View view, int i, boolean z) {
        if (view != null && c.uuT) {
            b dQ = dQ(view);
            if (dQ != null) {
                dQ.ar(i, z);
                return;
            }
            Activity cJ = d.cJ(view.getContext());
            if (cJ != null) {
                cJ.getWindow().setStatusBarColor(i);
                d.a(cJ.getWindow(), z);
            }
        }
    }

    public static void u(View view, boolean z) {
        b dQ = dQ(view);
        if (dQ != null) {
            dQ.dl(z);
        }
    }

    public static int aa(Activity activity) {
        if (c.uuT && activity != null) {
            return c.ab(activity).uuW;
        }
        return 0;
    }
}
