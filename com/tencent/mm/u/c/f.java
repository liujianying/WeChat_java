package com.tencent.mm.u.c;

import com.tencent.mm.u.b.d;
import com.tencent.mm.u.d.a;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;
import org.json.JSONObject;

public final class f {
    public a doM;
    public d doX;
    public g dpa;

    public f(d dVar, g gVar, a aVar) {
        Assert.assertNotNull(dVar);
        Assert.assertNotNull(gVar);
        Assert.assertNotNull(aVar);
        this.doX = dVar;
        this.dpa = gVar;
        this.doM = aVar;
    }

    public static String Db() {
        Map hashMap = new HashMap();
        hashMap.put("nativeTime", Long.valueOf(System.currentTimeMillis()));
        return new JSONObject(hashMap).toString();
    }
}
