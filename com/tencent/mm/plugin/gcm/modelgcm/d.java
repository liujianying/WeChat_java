package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.cn;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.b;

public final class d {

    public static class a extends com.tencent.mm.protocal.k.d implements b {
        public cn khp = new cn();

        public final byte[] Ie() {
            this.khp.shX = k.a(this);
            return this.khp.toByteArray();
        }

        public final int getCmdId() {
            return 241;
        }

        public final int If() {
            return 624;
        }
    }
}
