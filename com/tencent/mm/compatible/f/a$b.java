package com.tencent.mm.compatible.f;

import android.util.SparseArray;
import java.util.Locale;

class a$b {
    public int dfS;
    public SparseArray<String> dfT;
    public String dfU;
    public String model;
    public String version;

    private a$b() {
    }

    /* synthetic */ a$b(byte b) {
        this();
    }

    public final String toString() {
        return String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.dfU, this.model, this.version, this.dfT, Integer.valueOf(this.dfS)});
    }
}
