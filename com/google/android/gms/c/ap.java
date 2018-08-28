package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class ap extends af<ap> {
    public String aYS;
    public int aYT;
    private int aYU;
    private String aYV;
    public String aYW;
    private boolean aYX;
    private boolean aYY;
    private boolean aYZ;

    public ap() {
        this((byte) 0);
    }

    private ap(byte b) {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits == 0) {
            leastSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
            if (leastSignificantBits == 0) {
                leastSignificantBits = Integer.MAX_VALUE;
            }
        }
        this(leastSignificantBits);
    }

    private ap(int i) {
        if (i == 0) {
            throw new IllegalArgumentException("Given Integer is zero");
        }
        this.aYT = i;
        this.aYY = false;
    }

    private void qq() {
        if (this.aYZ) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public final /* synthetic */ void a(af afVar) {
        String str;
        int i;
        boolean z;
        ap apVar = (ap) afVar;
        if (!TextUtils.isEmpty(this.aYS)) {
            str = this.aYS;
            apVar.qq();
            apVar.aYS = str;
        }
        if (this.aYT != 0) {
            i = this.aYT;
            apVar.qq();
            apVar.aYT = i;
        }
        if (this.aYU != 0) {
            i = this.aYU;
            apVar.qq();
            apVar.aYU = i;
        }
        if (!TextUtils.isEmpty(this.aYV)) {
            str = this.aYV;
            apVar.qq();
            apVar.aYV = str;
        }
        if (!TextUtils.isEmpty(this.aYW)) {
            Object obj = this.aYW;
            apVar.qq();
            if (TextUtils.isEmpty(obj)) {
                apVar.aYW = null;
            } else {
                apVar.aYW = obj;
            }
        }
        if (this.aYX) {
            z = this.aYX;
            apVar.qq();
            apVar.aYX = z;
        }
        if (this.aYY) {
            z = this.aYY;
            apVar.qq();
            apVar.aYY = z;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("screenName", this.aYS);
        hashMap.put("interstitial", Boolean.valueOf(this.aYX));
        hashMap.put("automatic", Boolean.valueOf(this.aYY));
        hashMap.put("screenId", Integer.valueOf(this.aYT));
        hashMap.put("referrerScreenId", Integer.valueOf(this.aYU));
        hashMap.put("referrerScreenName", this.aYV);
        hashMap.put("referrerUri", this.aYW);
        return af.ak(hashMap);
    }
}
