package com.tencent.mm.pluginsdk.f;

import com.tencent.mm.sdk.a.b;
import java.util.concurrent.ConcurrentHashMap;

public final class d {
    public static d qBm = new d("default");
    private boolean kws = false;
    private ConcurrentHashMap<String, Integer> qBj = new ConcurrentHashMap();
    private ConcurrentHashMap<String, Long> qBk = new ConcurrentHashMap();
    private String qBl = "";

    public d(String str) {
        if (b.chp()) {
            this.kws = true;
        }
        this.qBl = str;
    }

    public final void Tf(String str) {
        if (this.kws) {
            int intValue;
            long longValue;
            if (this.qBj.containsKey(str)) {
                intValue = ((Integer) this.qBj.get(str)).intValue();
            } else {
                intValue = 0;
            }
            int i = intValue + 1;
            this.qBj.put(str, Integer.valueOf(i));
            if (this.qBk.containsKey(str)) {
                longValue = ((Long) this.qBk.get(str)).longValue();
            } else {
                longValue = 0;
            }
            if (System.currentTimeMillis() - longValue > 1000) {
                new StringBuilder().append(this.qBl).append("user get fps ").append(i).append(" fpswraper: ").append(str);
                this.qBj.put(str, Integer.valueOf(0));
                this.qBk.put(str, Long.valueOf(System.currentTimeMillis()));
            }
        }
    }
}
