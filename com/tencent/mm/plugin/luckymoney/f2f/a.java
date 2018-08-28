package com.tencent.mm.plugin.luckymoney.f2f;

import android.media.SoundPool;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public final class a {
    public volatile boolean gYf = false;
    public SoundPool kMT = new SoundPool(2, 3, 0);
    Hashtable<String, Integer> kMU = new Hashtable();
    Map<Integer, Boolean> kMV = new HashMap();

    public final void eR(String str) {
        if (this.kMU.containsKey(str)) {
            int intValue = ((Integer) this.kMU.get(str)).intValue();
            if (intValue >= 0 && this.kMV.containsKey(Integer.valueOf(intValue)) && ((Boolean) this.kMV.get(Integer.valueOf(intValue))).booleanValue()) {
                this.kMT.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }
}
