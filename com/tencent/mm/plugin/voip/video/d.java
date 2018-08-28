package com.tencent.mm.plugin.voip.video;

import android.content.Context;
import android.media.ToneGenerator;
import android.provider.Settings.System;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public final class d {
    public static Context mContext;
    private static final HashMap<String, Integer> oTG;
    public Object oTH = new Object();
    public ToneGenerator oTI;
    private final int oTJ = 250;

    static {
        HashMap hashMap = new HashMap();
        oTG = hashMap;
        hashMap.put("1", Integer.valueOf(1));
        oTG.put("2", Integer.valueOf(2));
        oTG.put("3", Integer.valueOf(3));
        oTG.put("4", Integer.valueOf(4));
        oTG.put("5", Integer.valueOf(5));
        oTG.put("6", Integer.valueOf(6));
        oTG.put("7", Integer.valueOf(7));
        oTG.put("8", Integer.valueOf(8));
        oTG.put("9", Integer.valueOf(9));
        oTG.put("0", Integer.valueOf(0));
        oTG.put("#", Integer.valueOf(11));
        oTG.put("*", Integer.valueOf(10));
    }

    public d(Context context) {
        mContext = context;
        if (context != null) {
            try {
                synchronized (this.oTH) {
                    if (bMf() && this.oTI == null) {
                        this.oTI = new ToneGenerator(3, 66);
                    }
                }
            } catch (Exception e) {
                x.d("MicroMsg.DTMFToneGenerator", "获取音频发生器单例失败！！！");
                x.d("MicroMsg.DTMFToneGenerator", e.getMessage());
                this.oTI = null;
            }
        }
    }

    private d() {
    }

    public static boolean bMf() {
        return System.getInt(mContext.getContentResolver(), "dtmf_tone", 1) == 1;
    }

    public static int OL(String str) {
        if (str == null || str.equals("") || !oTG.containsKey(str)) {
            return -1;
        }
        return ((Integer) oTG.get(str)).intValue();
    }
}
