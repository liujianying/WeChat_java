package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.webview.modelcache.d.a;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;
import java.util.List;

public final class k extends i<f> {
    private static volatile k pSZ = null;
    private final e diF;
    public final boolean fAQ;

    public static List<a> bUH() {
        List linkedList = new LinkedList();
        linkedList.add(new a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{i.a(f.dhO, "WebViewResourceCache")}));
        return linkedList;
    }

    public static k bUI() {
        if (!au.HX()) {
            return new k(null);
        }
        if (pSZ == null) {
            synchronized (k.class) {
                if (pSZ == null || !pSZ.fAQ) {
                    au.HU();
                    pSZ = new k(c.FO());
                }
            }
        }
        return pSZ;
    }

    private k(e eVar) {
        super(eVar, f.dhO, "WebViewResourceCache", null);
        this.diF = eVar;
        this.fAQ = eVar != null;
        if (!this.fAQ) {
            x.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
    }

    static String Ap(int i) {
        String str = "1=1";
        if (b$a.Am(i) && b$a.Al(i)) {
            return str;
        }
        return String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
    }

    public final List<f> n(String str, String... strArr) {
        List<f> list = null;
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    f fVar = new f();
                    fVar.d(rawQuery);
                    list.add(fVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    public final boolean checkIsCached(String str, int i) {
        if (!this.fAQ || bi.oW(str)) {
            return false;
        }
        String Ap = Ap(i);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", Ap}), new String[]{String.valueOf(ac.ce(str).hashCode())});
        if (rawQuery == null) {
            return false;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        rawQuery.close();
        return false;
    }

    private boolean a(f fVar) {
        if (!this.fAQ) {
            return false;
        }
        if (bi.oW(fVar.field_url)) {
            x.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            return false;
        }
        String ce = ac.ce(fVar.field_url);
        if (bi.oW(ce)) {
            x.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", new Object[]{fVar.field_url});
            return false;
        }
        fVar.field_urlMd5Hashcode = ce.hashCode();
        long VE = bi.VE();
        fVar.field_accessTime = VE;
        fVar.field_createTime = VE;
        return a(fVar, false);
    }

    public final boolean insert(f fVar, int i, int i2) {
        return a(fVar);
    }

    public final boolean update(f fVar, int i, int i2) {
        return b(fVar);
    }

    public final boolean b(f fVar) {
        if (!this.fAQ) {
            return false;
        }
        if (bi.oW(fVar.field_url)) {
            x.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            return false;
        }
        long VE = bi.VE();
        fVar.field_accessTime = VE;
        fVar.field_createTime = VE;
        x.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = " + fVar);
        return b(fVar, false, new String[]{"urlMd5Hashcode", "appId", "domain", "cacheType", "packageId"});
    }
}
