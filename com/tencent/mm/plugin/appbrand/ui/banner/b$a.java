package com.tencent.mm.plugin.appbrand.ui.banner;

enum b$a {
    appId,
    versionType,
    appName,
    iconURL,
    customText;
    
    static final int gxQ = 0;

    static {
        gxQ = values().length;
    }

    public final String Ke() {
        return "appbrand_top_banner_in_chatting_extra_key_" + name();
    }
}
