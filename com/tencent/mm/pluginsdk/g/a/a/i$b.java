package com.tencent.mm.pluginsdk.g.a.a;

enum i$b {
    DoNothing(0),
    DoCache(1),
    DoDecrypt(2),
    DoDelete(4);
    
    final int bWA;

    private i$b(int i) {
        this.bWA = i;
    }

    static boolean BO(int i) {
        return i == DoNothing.bWA;
    }

    static boolean BP(int i) {
        return (DoCache.bWA & i) > 0;
    }

    static boolean BQ(int i) {
        return (DoDecrypt.bWA & i) > 0;
    }

    static boolean BR(int i) {
        return (DoDelete.bWA & i) > 0;
    }

    static int Tk(String str) {
        if ("cache".equals(str)) {
            return DoCache.bWA;
        }
        if ("delete".equals(str)) {
            return DoDelete.bWA;
        }
        if ("decrypt".equals(str)) {
            return DoDecrypt.bWA;
        }
        return DoNothing.bWA;
    }
}
