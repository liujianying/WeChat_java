package com.tencent.mm.pluginsdk.g.a.c;

import android.annotation.SuppressLint;
import com.tencent.mm.a.g;
import com.tencent.mm.bt.h;
import com.tencent.mm.bt.h.d;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class t extends i<s> {
    private static final String[] diD = new String[]{i.a(s.dhO, "ResDownloaderRecordTable")};
    private static final String qDA = (aa.duN + g.u(String.format("mm%d", new Object[]{Integer.valueOf(Integer.MIN_VALUE)}).getBytes()) + "/");
    @SuppressLint({"UseSparseArrays"})
    private static final HashMap<Integer, d> qDB;
    public final h dCZ;
    private final HashMap<String, Object> qDC = new HashMap();

    static {
        HashMap hashMap = new HashMap();
        qDB = hashMap;
        hashMap.put(Integer.valueOf("RES_DOWNLOADER_RECORD_TABLE".hashCode()), new 1());
        Iterator it = r.ccI().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    private t(h hVar) {
        super(hVar, s.dhO, "ResDownloaderRecordTable", null);
        this.dCZ = hVar;
        Iterator it = r.ccI().iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    static t ccJ() {
        try {
            new File(qDA).mkdirs();
            h hVar = new h();
            if (hVar.a(qDA + "ResDown.db", qDA + "EnResDown.db", -2147483648L, q.zy(), qDB)) {
                return new t(hVar);
            }
            x.f("MicroMsg.ResDownloaderStorage", "res downloader db init failed");
            return null;
        } catch (Exception e) {
            x.e("MicroMsg.ResDownloaderStorage", "new storage failed, exception = %s", new Object[]{e});
            return null;
        }
    }

    public final boolean jy(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ResDownloaderStorage", "delete with null or nil urlKey, return false");
            return false;
        }
        s sVar = new s();
        sVar.field_urlKey_hashcode = str.hashCode();
        return super.a(sVar, new String[]{"urlKey_hashcode"});
    }

    public final boolean h(s sVar) {
        if (bi.oW(sVar.field_urlKey)) {
            return false;
        }
        sVar.field_urlKey_hashcode = sVar.field_urlKey.hashCode();
        return super.c(sVar, new String[]{"urlKey_hashcode"});
    }

    /* renamed from: i */
    public final boolean b(s sVar) {
        if (bi.oW(sVar.field_urlKey)) {
            return false;
        }
        sVar.field_urlKey_hashcode = sVar.field_urlKey.hashCode();
        return super.b(sVar);
    }

    public final s Tn(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.ResDownloaderStorage", "query with null or nil urlKey, return null");
            return null;
        }
        s sVar = new s();
        sVar.field_urlKey_hashcode = str.hashCode();
        if (super.b(sVar, new String[]{"urlKey_hashcode"})) {
            return sVar;
        }
        return null;
    }
}
