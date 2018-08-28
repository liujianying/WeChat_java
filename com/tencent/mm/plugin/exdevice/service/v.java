package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

public final class v {
    private static v iyR = null;
    public ah egm = new ah();
    final HashMap<Long, Integer> iyS = new HashMap();

    private v() {
    }

    public static v aHH() {
        if (iyR == null) {
            iyR = new v();
        }
        return iyR;
    }
}
