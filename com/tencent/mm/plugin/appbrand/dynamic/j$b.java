package com.tencent.mm.plugin.appbrand.dynamic;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.d.a;

public class j$b implements a {
    public String appId = "";
    int bGF;
    String bOd;
    int dCn;
    String fuL = "";

    public j$b(String str, String str2, int i, String str3, int i2) {
        this.fuL = str;
        this.appId = str2;
        this.bGF = i;
        this.bOd = str3;
        this.dCn = i2;
    }

    public final Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putString("widgetId", this.fuL);
        bundle.putString("appid", this.appId);
        bundle.putInt("appState", this.bGF);
        bundle.putString("reqKey", this.bOd);
        bundle.putInt("serviceType", this.dCn);
        return bundle;
    }

    public final void fromBundle(Bundle bundle) {
        this.fuL = bundle.getString("widgetId");
        this.appId = bundle.getString("appid");
        this.bGF = bundle.getInt("appState");
        this.bOd = bundle.getString("reqKey");
        this.dCn = bundle.getInt("serviceType");
    }
}
