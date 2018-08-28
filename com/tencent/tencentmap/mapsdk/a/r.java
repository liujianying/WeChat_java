package com.tencent.tencentmap.mapsdk.a;

import android.content.Context;
import android.content.SharedPreferences;

public class r {
    private static r a;
    private SharedPreferences b = null;

    public static r a(Context context) {
        if (a == null) {
            synchronized (r.class) {
                if (a == null) {
                    a = new r(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private r(Context context) {
        this.b = context.getSharedPreferences("com.tencent.tencentmap.mapsdk.maps.offlinemap", 0);
    }

    public int a() {
        return this.b.getInt("mapConfigVersion", -1);
    }

    public boolean a(int i) {
        return this.b.edit().putInt("mapConfigVersion", i).commit();
    }

    public boolean a(long j) {
        return this.b.edit().putLong("mapConfigLastCheckTime", j).commit();
    }

    public int b() {
        return this.b.getInt("mapPoiIcon", -1);
    }

    public boolean b(int i) {
        return this.b.edit().putInt("mapPoiIcon", i).commit();
    }

    public int c() {
        return this.b.getInt("mapIconVersion", -1);
    }

    public boolean c(int i) {
        return this.b.edit().putInt("mapIconVersion", i).commit();
    }

    public int d() {
        return this.b.getInt("rttConfigVersion", 0);
    }

    public boolean d(int i) {
        return this.b.edit().putInt("rttConfigVersion", i).commit();
    }

    public String e() {
        return this.b.getString("sdkVersion", null);
    }

    public boolean a(String str) {
        return this.b.edit().putString("sdkVersion", str).commit();
    }

    public boolean a(boolean z) {
        return this.b.edit().putBoolean("worldMapEnabled", z).commit();
    }

    public boolean f() {
        return this.b.getBoolean("worldMapEnabled", false);
    }

    public boolean b(boolean z) {
        return this.b.edit().putBoolean("specialDistrictEnable", z).commit();
    }

    public boolean g() {
        return this.b.getBoolean("specialDistrictEnable", false);
    }

    public boolean e(int i) {
        return this.b.edit().putInt("worldMapStyle", i).commit();
    }

    public int h() {
        return this.b.getInt("worldMapStyle", -1);
    }

    public boolean f(int i) {
        return this.b.edit().putInt("worldMapVersion", i).commit();
    }

    public int i() {
        return this.b.getInt("worldMapVersion", -1);
    }

    public boolean g(int i) {
        return this.b.edit().putInt("worldMapScene", i).commit();
    }

    public int j() {
        return this.b.getInt("worldMapScene", -1);
    }

    public boolean b(String str) {
        return this.b.edit().putString("mapSourceType", str).commit();
    }

    public String k() {
        return this.b.getString("mapSourceType", null);
    }

    public boolean c(String str) {
        return this.b.edit().putString("taiwanMapName", str).commit();
    }

    public String l() {
        return this.b.getString("taiwanMapName", null);
    }

    public boolean h(int i) {
        return this.b.edit().putInt("worldMapFrontierVersion", i).commit();
    }

    public int m() {
        return this.b.getInt("worldMapFrontierVersion", -1);
    }

    public boolean d(String str) {
        return this.b.edit().putString("worldTileURLExpression", str).commit();
    }

    public String n() {
        return this.b.getString("worldTileURLExpression", null);
    }

    public boolean e(String str) {
        return this.b.edit().putString("taiwanTileURLExpression", str).commit();
    }

    public String o() {
        return this.b.getString("taiwanTileURLExpression", null);
    }

    public boolean i(int i) {
        return this.b.edit().putInt("mapConfigIndoorVersion", i).commit();
    }

    public int p() {
        return this.b.getInt("mapConfigIndoorVersion", 0);
    }

    public boolean j(int i) {
        return this.b.edit().putInt("mapPoiIconIndoorVersion", i).commit();
    }

    public int q() {
        return this.b.getInt("mapPoiIconIndoorVersion", 0);
    }

    public boolean f(String str) {
        return this.b.edit().putString("mapConfigZipMd5", str).commit();
    }

    public String r() {
        return this.b.getString("mapConfigZipMd5", null);
    }

    public boolean g(String str) {
        return this.b.edit().putString("mapPoiIconZipMd5", str).commit();
    }

    public String s() {
        return this.b.getString("mapPoiIconZipMd5", null);
    }

    public boolean h(String str) {
        return this.b.edit().putString("mapIconZipMd5", str).commit();
    }

    public String t() {
        return this.b.getString("mapIconZipMd5", null);
    }

    public boolean k(int i) {
        return this.b.edit().putInt("closeRoadSytleNomalModeVersion", i).commit();
    }

    public int u() {
        return this.b.getInt("closeRoadSytleNomalModeVersion", 0);
    }

    public boolean l(int i) {
        return this.b.edit().putInt("closeRoadStyleTrafficModeVersion", i).commit();
    }

    public int v() {
        return this.b.getInt("closeRoadStyleTrafficModeVersion", 0);
    }

    public int w() {
        return this.b.getInt("handDrawMapVer", 0);
    }

    public boolean m(int i) {
        return this.b.edit().putInt("handDrawMapVer", i).commit();
    }
}
