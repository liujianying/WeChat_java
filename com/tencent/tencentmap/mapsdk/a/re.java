package com.tencent.tencentmap.mapsdk.a;

public enum re {
    QMapLanguage_zh,
    QMapLanguage_en;

    public static String a(re reVar) {
        return (reVar == null || reVar.name() == null || reVar.name().indexOf("_") == -1) ? "en" : reVar.name().substring(reVar.name().indexOf("_") + 1);
    }
}
