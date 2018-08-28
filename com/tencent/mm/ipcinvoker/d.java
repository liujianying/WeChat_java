package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.d.e;
import junit.framework.Assert;

public final class d {
    public String dmw;

    private static abstract class c implements e {
        String token;

        c(String str) {
            this.token = str;
            Assert.assertNotNull(str);
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof c)) {
                return false;
            }
            return this.token.equals(((c) obj).token);
        }
    }

    public d(String str) {
        this.dmw = str;
    }

    public static String au(Object obj) {
        return "Token#IPCObserver#" + obj.hashCode();
    }
}
