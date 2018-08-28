package com.google.android.gms.c;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public final class al extends af<al> {
    public String aYE;
    public int aYF;
    public int aYG;
    public int aYH;
    public int aYI;
    public int aYJ;

    public final /* synthetic */ void a(af afVar) {
        al alVar = (al) afVar;
        if (this.aYF != 0) {
            alVar.aYF = this.aYF;
        }
        if (this.aYG != 0) {
            alVar.aYG = this.aYG;
        }
        if (this.aYH != 0) {
            alVar.aYH = this.aYH;
        }
        if (this.aYI != 0) {
            alVar.aYI = this.aYI;
        }
        if (this.aYJ != 0) {
            alVar.aYJ = this.aYJ;
        }
        if (!TextUtils.isEmpty(this.aYE)) {
            alVar.aYE = this.aYE;
        }
    }

    public final String toString() {
        Map hashMap = new HashMap();
        hashMap.put("language", this.aYE);
        hashMap.put("screenColors", Integer.valueOf(this.aYF));
        hashMap.put("screenWidth", Integer.valueOf(this.aYG));
        hashMap.put("screenHeight", Integer.valueOf(this.aYH));
        hashMap.put("viewportWidth", Integer.valueOf(this.aYI));
        hashMap.put("viewportHeight", Integer.valueOf(this.aYJ));
        return ak(hashMap);
    }
}
