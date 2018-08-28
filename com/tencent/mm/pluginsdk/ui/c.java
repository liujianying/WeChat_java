package com.tencent.mm.pluginsdk.ui;

import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.ui.a.b;

public final class c extends i implements com.tencent.mm.aa.f.c {
    a qEK;
    int qEL;

    private static class a implements com.tencent.mm.pluginsdk.ui.i.a {
        Bitmap hqv = null;
        private com.tencent.mm.pluginsdk.ui.i.a lZs;

        public a(com.tencent.mm.pluginsdk.ui.i.a aVar) {
            this.lZs = aVar;
        }

        public final Bitmap b(String str, int i, int i2, int i3) {
            if (this.lZs != null) {
                return this.lZs.b(str, i, i2, i3);
            }
            return null;
        }

        public final Bitmap cJ(String str) {
            if (this.lZs != null) {
                return this.lZs.cJ(str);
            }
            return null;
        }

        public final Bitmap cK(String str) {
            if (this.lZs != null) {
                return this.lZs.cK(str);
            }
            return null;
        }

        public final Bitmap uM() {
            if (this.hqv != null && !this.hqv.isRecycled()) {
                return this.hqv;
            }
            if (this.lZs != null) {
                return this.lZs.uM();
            }
            return null;
        }

        public final void a(i iVar) {
            if (this.lZs != null) {
                this.lZs.a(iVar);
            }
        }
    }

    public c(String str) {
        this(str, (byte) 0);
    }

    private c(String str, byte b) {
        super(new a(b.ccZ()), str, (byte) 0);
        this.qEK = (a) this.lZs;
    }
}
