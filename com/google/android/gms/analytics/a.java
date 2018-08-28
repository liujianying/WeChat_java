package com.google.android.gms.analytics;

import com.google.android.gms.analytics.internal.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a extends c {
    private static List<Runnable> aEG = new ArrayList();
    public boolean aEH;
    public boolean aEI;
    private Set<Object> aEJ = new HashSet();
    public boolean aEK;
    volatile boolean aEL;

    public a(q qVar) {
        super(qVar);
    }

    public static void mD() {
        synchronized (a.class) {
            if (aEG != null) {
                for (Runnable run : aEG) {
                    run.run();
                }
                aEG = null;
            }
        }
    }
}
