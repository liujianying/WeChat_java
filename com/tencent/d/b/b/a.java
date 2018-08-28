package com.tencent.d.b.b;

import android.content.SharedPreferences;
import android.util.SparseArray;

public class a {
    private static volatile a vlO = null;
    private boolean bIu = false;
    private boolean huc = false;
    private SparseArray<String> vlP = new SparseArray(10);
    public SharedPreferences vlQ = null;

    public static a cFO() {
        if (vlO != null) {
            return vlO;
        }
        a aVar;
        synchronized (a.class) {
            if (vlO == null) {
                vlO = new a();
            }
            aVar = vlO;
        }
        return aVar;
    }

    public final boolean isInit() {
        boolean z;
        synchronized (a.class) {
            z = this.huc;
        }
        return z;
    }

    public final void cFP() {
        synchronized (a.class) {
            this.huc = true;
        }
    }

    public final boolean cFN() {
        boolean z;
        synchronized (a.class) {
            z = this.bIu;
        }
        return z;
    }

    public final void mQ(boolean z) {
        synchronized (a.class) {
            this.bIu = z;
        }
    }

    public final SparseArray<String> cFQ() {
        SparseArray<String> sparseArray;
        synchronized (a.class) {
            sparseArray = this.vlP;
        }
        return sparseArray;
    }

    public final SharedPreferences cFR() {
        SharedPreferences sharedPreferences;
        synchronized (a.class) {
            sharedPreferences = this.vlQ;
        }
        return sharedPreferences;
    }
}
