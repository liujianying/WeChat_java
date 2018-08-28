package com.tencent.mm.plugin.normsg.a;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

public enum b implements a {
    ;
    
    private static a lFK;

    private static class a implements a {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void S(int i, int i2, int i3) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }

        public final String IO(String str) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return str;
        }

        public final String a(Object[][] objArr) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String ub(int i) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String gV(boolean z) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final String bjD() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return "";
        }

        public final boolean bjz() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final boolean cKL() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final boolean c(Object obj, Class cls) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final byte[] bjE() {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return new byte[0];
        }

        public final boolean bI(Object obj) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
            return false;
        }

        public final void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }

        public final void uc(int i) {
            x.w("MicroMsg.NormsgSource", "!! Dummy implementation !!");
        }
    }

    private b(String str) {
    }

    static {
        lFK = new a();
    }

    public static void a(a aVar) {
        if (aVar != null) {
            lFK = aVar;
        }
    }

    public final void S(int i, int i2, int i3) {
        lFK.S(i, i2, i3);
    }

    public final String IO(String str) {
        return lFK.IO(str);
    }

    public final String a(Object[][] objArr) {
        return lFK.a(objArr);
    }

    public final String ub(int i) {
        return lFK.ub(i);
    }

    public final String gV(boolean z) {
        return lFK.gV(z);
    }

    public final String bjD() {
        return lFK.bjD();
    }

    public final boolean bjz() {
        return lFK.bjz();
    }

    public final boolean cKL() {
        return lFK.cKL();
    }

    public final boolean c(Object obj, Class cls) {
        return lFK.c(obj, cls);
    }

    public final byte[] bjE() {
        return lFK.bjE();
    }

    public final boolean bI(Object obj) {
        return lFK.bI(obj);
    }

    public final void a(View view, Class<? extends com.tencent.mm.sdk.b.b> cls) {
        lFK.a(view, cls);
    }

    public final void uc(int i) {
        lFK.uc(i);
    }
}
