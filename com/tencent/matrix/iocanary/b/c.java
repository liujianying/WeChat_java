package com.tencent.matrix.iocanary.b;

public final class c {
    private static final c brd = new c();
    private static volatile boolean bre = true;
    private static volatile b brf = new a();

    public interface b {
    }

    private static final class a implements b {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }
    }

    public static void setEnabled(boolean z) {
        bre = z;
    }

    private c() {
    }
}
