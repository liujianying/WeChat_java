package com.tencent.mm.plugin.messenger.foundation.a;

import com.tencent.mm.protocal.c.pm;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public interface q {

    public static class a {
        private static ConcurrentHashMap<Integer, q> lco = new ConcurrentHashMap();

        public static void a(int i, q qVar) {
            Assert.assertTrue(lco.get(Integer.valueOf(i)) == null);
            lco.put(Integer.valueOf(i), qVar);
        }

        public static q sw(int i) {
            return (q) lco.get(Integer.valueOf(i));
        }
    }

    void a(pm pmVar, byte[] bArr, boolean z, s sVar);
}
