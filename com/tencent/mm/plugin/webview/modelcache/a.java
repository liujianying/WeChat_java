package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.g.c.eq;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    private static final SparseArray<a> pSN = new SparseArray();
    private static volatile b pSO = null;
    private static final byte[] pSP = new byte[0];
    public final String appId;
    public final b pSM = bUE();
    public final String path;

    private static final class a extends eq {
        private static final com.tencent.mm.sdk.e.c.a dzU = eq.wI();

        private a() {
        }

        public /* synthetic */ a(byte b) {
            this();
        }

        protected final com.tencent.mm.sdk.e.c.a AX() {
            return dzU;
        }
    }

    public static com.tencent.mm.plugin.webview.modelcache.d.a bUD() {
        return new com.tencent.mm.plugin.webview.modelcache.d.a("WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode(), new String[]{i.a(eq.wI(), "WebViewCacheAppIdOccupation")});
    }

    public static a Qz(String str) {
        if (bi.oW(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) pSN.get(hashCode);
        if (aVar == null) {
            aVar = new a(str);
            pSN.put(hashCode, aVar);
            return aVar;
        }
        FileOp.mL(aVar.path);
        return aVar;
    }

    static void clearCache() {
        pSN.clear();
    }

    private static b bUE() {
        if (!au.HX()) {
            return new b(null);
        }
        b bVar;
        synchronized (pSP) {
            if (pSO == null || !pSO.fAQ) {
                au.HU();
                pSO = new b(c.FO());
            }
            bVar = pSO;
        }
        return bVar;
    }

    private a(String str) {
        this.appId = str;
        FileOp.mL(e.dgx + "sfs");
        this.path = e.dgx + String.valueOf(str.hashCode());
        FileOp.mL(this.path);
    }
}
