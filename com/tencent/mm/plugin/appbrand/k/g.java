package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.plugin.appbrand.k.f.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class g {
    public volatile boolean bgH = false;
    String fEl;
    int gkT;
    Map<String, String> gkX;
    ArrayList<String> gkY;
    int gkZ = 15;
    HttpURLConnection glb = null;
    String glc;
    String glh;
    Map<String, String> gli;
    a glj;
    String mFileName;
    String mMimeType;
    String mName;
    String mUrl;
    private long startTime;

    g(String str, String str2, String str3, String str4, int i, String str5, a aVar) {
        this.glh = str;
        this.mUrl = str2;
        this.glj = aVar;
        this.mName = str3;
        this.mFileName = str4;
        this.gkT = i;
        this.mMimeType = str5;
        this.startTime = System.currentTimeMillis();
    }

    public final int alt() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }
}
