package com.tencent.magicbrush.a;

public final class c {

    public static class a {
        private static d bnm = new c();

        public static void a(d dVar) {
            bnm = dVar;
        }

        public static void i(int i, String str) {
            bnm.j(i, str);
        }
    }

    private static class c implements d {
        private c() {
        }

        /* synthetic */ c(byte b) {
            this();
        }

        public final void j(int i, String str) {
            f.i("Console", str, new Object[0]);
        }
    }
}
