package com.tencent.d.a.c;

import junit.framework.Assert;

public final class g {
    private static volatile a vlz = new a() {
        private boolean vlA = false;

        public final void cFM() {
            c.e("Soter.SoterDelegate", "soter: triggered OOM. using default imp, just record the flag", new Object[0]);
            this.vlA = true;
        }

        public final boolean cFL() {
            return this.vlA;
        }
    };

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        vlz = aVar;
    }

    public static void cFK() {
        vlz.cFM();
    }

    public static boolean cFL() {
        return vlz.cFL();
    }
}
