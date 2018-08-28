package com.tencent.mm.cache;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public interface e {

    public static class a {
        private static Map<String, e> dam = new HashMap();

        public static void a(String str, e eVar) {
            dam.put(str, eVar);
        }

        private static e eY(String str) {
            return (e) dam.get(str);
        }

        public static <T> T E(String str, String str2) {
            return a(eY(str), str2);
        }

        public static <T> void a(String str, String str2, T t) {
            e eY = eY(str);
            if (eY == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
            } else {
                eY.o(str2, t);
            }
        }

        public static <T> void F(String str, String str2) {
            b(eY(str), str2);
        }

        private static <T> T a(e eVar, String str) {
            T t = null;
            if (eVar == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
                return t;
            }
            try {
                return eVar.get(str);
            } catch (Throwable e) {
                x.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                x.e("MicroMsg.ICacheService.Factory", "exception:%s", bi.i(e));
                return t;
            }
        }

        private static <T> T b(e eVar, String str) {
            T t = null;
            if (eVar == null) {
                x.e("MicroMsg.ICacheService.Factory", "null service");
                return t;
            }
            try {
                return eVar.remove(str);
            } catch (Throwable e) {
                x.e("MicroMsg.ICacheService.Factory", "cast failed, different type ?");
                x.e("MicroMsg.ICacheService.Factory", "exception:%s", bi.i(e));
                return t;
            }
        }
    }

    Object get(Object obj);

    void o(Object obj, Object obj2);

    Object remove(Object obj);
}
