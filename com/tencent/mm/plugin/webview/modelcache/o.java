package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.bi;

public final class o {
    private final j pTg;
    public final SparseArray<Object> pTh;
    public final SparseArray<Boolean> pTi;

    private static final class a {
        private static final o pTj = new o();
    }

    /* synthetic */ o(byte b) {
        this();
    }

    private o() {
        this.pTg = new j();
        this.pTh = new SparseArray();
        this.pTi = new SparseArray();
    }

    public static boolean QA(String str) {
        a.pTj;
        bi.oW(str);
        return false;
    }
}
