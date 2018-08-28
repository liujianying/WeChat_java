package com.tencent.mm.compatible.f;

import android.util.SparseArray;
import java.util.Locale;

class a$a {
    public String byT;
    public int dfQ;
    public int dfR;
    public int dfS;
    public SparseArray<String> dfT;

    private a$a() {
    }

    /* synthetic */ a$a(byte b) {
        this();
    }

    public final String toString() {
        return String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.byT, Integer.valueOf(this.dfQ), Integer.valueOf(this.dfR), this.dfT, Integer.valueOf(this.dfS)});
    }
}
