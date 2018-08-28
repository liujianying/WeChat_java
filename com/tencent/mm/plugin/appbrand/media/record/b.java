package com.tencent.mm.plugin.appbrand.media.record;

public enum b {
    AUTO(0),
    MIC(1),
    CAMCORDER(5),
    VOICE_RECOGNITION(6),
    VOICE_COMMUNICATION(7),
    UNPROCESSED(9);
    
    public int gih;

    private b(int i) {
        this.gih = i;
    }

    public static b a(String str, b bVar) {
        if (str == null || str.length() <= 0) {
            return bVar;
        }
        b valueOf = valueOf(str);
        return valueOf != null ? valueOf : bVar;
    }
}
