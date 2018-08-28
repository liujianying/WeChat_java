package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.cl;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.k.d;

public final class c {

    public static class a extends d implements b {
        public cl khn = new cl();

        public final byte[] Ie() {
            this.khn.shX = k.a(this);
            return this.khn.toByteArray();
        }

        public final int getCmdId() {
            return 289;
        }

        public final int If() {
            return 623;
        }
    }
}
