package com.tencent.mm.plugin.appbrand.launching.b;

enum b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", 1005);
    
    final String eeG;
    final int scene;

    private b(String str, int i) {
        this.eeG = str;
        this.scene = i;
    }

    static String akT() {
        return "";
    }

    static int akU() {
        return 0;
    }

    static String akV() {
        return "";
    }
}
