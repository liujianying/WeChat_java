package com.tencent.mm.plugin.appbrand.jsapi.version;

public enum a {
    UPDATING("updating"),
    NO_UPDATE("noUpdate"),
    UPDATE_READY("updateReady"),
    UPDATE_FAILED("updateFailed");
    
    public final String fZP;

    private a(String str) {
        this.fZP = str;
    }

    public static a uc(String str) {
        for (a aVar : values()) {
            if (aVar.fZP.equals(str)) {
                return aVar;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid name %s", new Object[]{str}));
    }

    public final String toString() {
        return this.fZP;
    }
}
