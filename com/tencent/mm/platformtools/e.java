package com.tencent.mm.platformtools;

import android.app.Activity;
import java.util.HashSet;
import java.util.Set;

public abstract class e implements com.tencent.mm.ab.e {
    public Activity activity;
    Set<Integer> evJ = new HashSet();

    public abstract boolean b(ah ahVar);

    public abstract boolean c(ah ahVar);

    public abstract boolean d(ah ahVar);

    public abstract boolean e(ah ahVar);

    public e(Activity activity) {
        this.activity = activity;
    }

    public final boolean a(ah ahVar) {
        if (ahVar.action == 0) {
            return false;
        }
        switch (ahVar.action) {
            case 1:
                return b(ahVar);
            case 2:
                return c(ahVar);
            case 4:
                return d(ahVar);
            case 5:
                return e(ahVar);
            default:
                return false;
        }
    }
}
