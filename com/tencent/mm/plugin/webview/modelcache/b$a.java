package com.tencent.mm.plugin.webview.modelcache;

public enum b$a {
    HTTP(1),
    HTTPS(2);
    
    final int bWA;

    private b$a(int i) {
        this.bWA = i;
    }

    public static boolean Al(int i) {
        return (HTTP.bWA & i) > 0;
    }

    public static boolean Am(int i) {
        return (HTTPS.bWA & i) > 0;
    }

    public static int bUG() {
        return HTTP.bWA | 0;
    }

    public static int An(int i) {
        return HTTPS.bWA | i;
    }

    public static String toString(int i) {
        String str = "[ %s | %s ]";
        Object[] objArr = new Object[2];
        objArr[0] = Al(i) ? "http" : "-";
        objArr[1] = Am(i) ? "https" : "-";
        return String.format(str, objArr);
    }
}
