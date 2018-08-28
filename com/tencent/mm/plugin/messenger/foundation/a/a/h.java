package com.tencent.mm.plugin.messenger.foundation.a.a;

import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

public interface h {

    public static class b {
        public int bWA = -1;
        public byte[] buffer;
        public int cmdId;
        public long dSH;
        public int id;
        public int lcD;
        public long lcE;
        public String lcF;
        public String lcG;
        public com.tencent.mm.bk.a lcH;

        public b(int i) {
            this.cmdId = i;
        }

        public int getCmdId() {
            return this.cmdId;
        }

        public final byte[] getBuffer() {
            if (this.buffer == null && this.lcH != null) {
                try {
                    this.buffer = this.lcH.toByteArray();
                } catch (IOException e) {
                    x.e("MicroMsg.OpLog.Operation", "summeroplog Operation toByteArray err: " + e.getMessage());
                }
            }
            return this.buffer;
        }
    }

    public static class a extends b {
        private int cmdId;

        public a(int i, com.tencent.mm.bk.a aVar) {
            super(i);
            this.cmdId = i;
            this.lcH = aVar;
        }

        public final int getCmdId() {
            return this.cmdId;
        }
    }
}
