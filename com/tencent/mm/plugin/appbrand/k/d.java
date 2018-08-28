package com.tencent.mm.plugin.appbrand.k;

import com.tencent.mm.plugin.appbrand.k.c.a;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Map;

public final class d {
    String fEl;
    int gkT;
    byte[] gkU;
    String gkV;
    a gkW;
    Map<String, String> gkX;
    ArrayList<String> gkY;
    int gkZ = 15;
    String gla;
    HttpURLConnection glb;
    String glc;
    String mUrl;
    private long startTime;

    public d(String str, byte[] bArr, int i, a aVar, String str2) {
        this.mUrl = str;
        this.gkU = bArr;
        this.gkW = aVar;
        this.gkT = i;
        this.gkV = str2;
        this.startTime = System.currentTimeMillis();
    }

    public final int alt() {
        return (int) (System.currentTimeMillis() - this.startTime);
    }

    public final long getDataSize() {
        if (this.gkU != null) {
            return (long) this.gkU.length;
        }
        return 0;
    }
}
