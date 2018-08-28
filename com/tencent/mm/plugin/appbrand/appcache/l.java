package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.appcache.s.a;
import com.tencent.mm.plugin.appbrand.appcache.s.b;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.concurrent.ConcurrentHashMap;

public final class l implements b {
    private static final ConcurrentHashMap<String, Boolean> ffL = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.appcache.l$1 */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] ffM = new int[a.values().length];

        static {
            try {
                ffM[a.ffW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                ffM[a.ffX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                ffM[a.ffY.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                ffM[a.ffZ.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                ffM[a.fga.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    static /* synthetic */ boolean qF(String str) {
        return !bi.oW(str) && Boolean.TRUE.equals(ffL.get(str));
    }

    public final a a(com.tencent.mm.plugin.appbrand.appcache.base.a aVar) {
        if (ai.class == aVar.getClass() || ad.class == aVar.getClass() || ae.class == aVar.getClass()) {
            return new a(aVar, (byte) 0);
        }
        return null;
    }

    public static void qE(String str) {
        if (!bi.oW(str)) {
            ffL.put(str, Boolean.valueOf(true));
        }
    }
}
