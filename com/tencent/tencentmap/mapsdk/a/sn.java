package com.tencent.tencentmap.mapsdk.a;

public final class sn {
    private static int a = 1000;
    private static int b = ro.a;
    private static int c = ro.b;
    private static int d = ro.c;
    private static int e = 0;
    private static int f = 1000;
    private static int g = ro.e;
    private static int h = 0;
    private static volatile boolean i = false;
    private static int j = 0;
    private static String k = null;
    private static byte[] l = new byte[0];
    private static byte[] m = new byte[0];

    public static int a() {
        int i;
        synchronized (l) {
            i = a;
        }
        return i;
    }

    public static void a(int i, int i2, int i3, int i4) {
        synchronized (l) {
            a = i;
            b = i2;
            c = i3;
            d = i4;
        }
    }

    public static void a(int i, int i2, int i3, int i4, String str, String str2) {
        synchronized (m) {
            e = i;
            f = i2;
            g = i3;
            h = i4;
            k = str2;
        }
    }

    public static void a(String str) {
        synchronized (m) {
            k = str;
        }
    }

    public static void a(boolean z) {
        i = z;
    }

    public static int b() {
        int i;
        synchronized (l) {
            i = b;
        }
        return i;
    }

    public static int c() {
        int i;
        synchronized (l) {
            i = c;
        }
        return i;
    }

    public static int d() {
        int i;
        synchronized (l) {
            i = d;
        }
        return i;
    }

    public static int e() {
        int i;
        synchronized (m) {
            i = f;
        }
        return i;
    }

    public static int f() {
        int i;
        synchronized (m) {
            i = e;
        }
        return i;
    }

    public static int g() {
        int i;
        synchronized (m) {
            i = g;
        }
        return i;
    }

    public static boolean h() {
        boolean z;
        synchronized (m) {
            z = i;
        }
        return z;
    }

    public static int i() {
        int i;
        synchronized (m) {
            i = h;
        }
        return i;
    }

    public static String j() {
        String str;
        synchronized (m) {
            str = k;
        }
        return str;
    }

    public static int k() {
        int i;
        synchronized (m) {
            i = j;
        }
        return i;
    }

    public static void l() {
        sy a = sy.a();
        int b = a.b("tencent_version");
        int b2 = a.b("tencent_style");
        int b3 = a.b("sat_version");
        int b4 = a.b("tencent_clean_cache_version");
        synchronized (l) {
            if (!(b2 == -1 || b == -1 || b3 == -1 || b4 == -1)) {
                b = b;
                a = b2;
                d = b3;
                c = b4;
            }
        }
        b = a.b("");
        b2 = a.b("world_map_style");
        b3 = a.b("world_map_scene");
        b4 = a.b("world_map_version");
        int b5 = a.b("world_map_protocol_version");
        boolean c = a.c("world_map_enable");
        a.a("world_map_tile_url_regex");
        String a2 = a.a("world_map_logo_change_rule_json");
        synchronized (m) {
            f = b2;
            e = b3;
            g = b4;
            h = b5;
            i = c;
            k = a2;
            j = b;
        }
    }

    public static boolean m() {
        boolean a;
        synchronized (m) {
            a = sy.a().a(new String[]{"", "world_map_scene", "world_map_style", "world_map_version", "world_map_tile_url_regex", "world_map_logo_change_rule_json", "world_map_protocol_version"});
        }
        return a;
    }
}
