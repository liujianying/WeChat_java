package com.tencent.mm.j;

import com.tencent.mm.storage.bd;

public interface a {

    public static class a {
        private static a daD = null;

        public static void a(a aVar) {
            daD = aVar;
        }

        public static a yw() {
            return daD;
        }
    }

    void c(bd bdVar);

    String d(bd bdVar);

    boolean eZ(String str);

    String z(String str, int i);
}
