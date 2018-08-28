package com.tencent.mm.plugin.appbrand.page;

import com.tencent.mm.plugin.appbrand.jsapi.an;

public enum aa {
    APP_LAUNCH("appLaunch"),
    NAVIGATE_TO(an.NAME),
    NAVIGATE_BACK("navigateBack"),
    REDIRECT_TO("redirectTo"),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB("switchTab");
    
    private final String type;

    private aa(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
