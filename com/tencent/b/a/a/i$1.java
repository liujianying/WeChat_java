package com.tencent.b.a.a;

import org.json.JSONObject;

class i$1 implements Runnable {
    final /* synthetic */ i bvE;
    private final /* synthetic */ String bvF;

    public i$1(i iVar, String str) {
        this.bvE = iVar;
        this.bvF = str;
    }

    public final void run() {
        try {
            new StringBuilder("receive data:").append(this.bvF);
            int i = 100;
            int i2 = 3;
            if (s.ci(this.bvF)) {
                JSONObject jSONObject = new JSONObject(this.bvF);
                if (!jSONObject.isNull("mid")) {
                    String optString = jSONObject.optString("mid");
                    if (s.cj(optString) && !s.cj(this.bvE.tO())) {
                        i.a(this.bvE).bvx = optString;
                        i.a(this.bvE).bvw = s.aK(i.tQ());
                        i.a(this.bvE).bjM = s.aJ(i.tQ());
                        if (jSONObject.isNull("ts")) {
                            i.a(this.bvE).bvy = System.currentTimeMillis();
                        } else {
                            long optLong = jSONObject.optLong("ts");
                            if (optLong > 0) {
                                i.a(this.bvE).bvy = optLong;
                            }
                        }
                        new StringBuilder("new mid midEntity:").append(i.a(this.bvE).toString());
                        r.aH(i.tQ()).b(i.a(this.bvE));
                    }
                }
                if (!jSONObject.isNull(a.bvf)) {
                    i = jSONObject.getInt(a.bvf);
                }
                if (!jSONObject.isNull(a.bvg)) {
                    i2 = jSONObject.getInt(a.bvg);
                }
                j.bvG = jSONObject.optInt("disable", 0);
                j.bvH = jSONObject.optInt("limit", 0);
            }
            r aH = r.aH(i.tQ());
            a tU = aH.tU();
            if (i > 0) {
                tU.bvb = i;
            }
            if (i2 > 0) {
                tU.bvc = i2;
            }
            tU.buZ = System.currentTimeMillis();
            tU.bva = 0;
            aH.b(tU);
        } catch (Throwable th) {
        }
    }
}
