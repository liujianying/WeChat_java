package com.tencent.mm.e.b;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class g {
    public static final String bEE = (e.bnE + "test.wav");
    public static final String bEF = (e.bnE + "test.pcm");

    public static int t(String str, int i) {
        try {
            return bi.getInt(((a) com.tencent.mm.kernel.g.l(a.class)).AT().getValue(str), i);
        } catch (Exception e) {
            x.e("MicroMsg.RecorderUtil", "getIntValFromDynamicConfig parseInt failed, key: " + str);
            return i;
        } catch (Error e2) {
            x.e("MicroMsg.RecorderUtil", "error on parseInt failed, key: " + str);
            return i;
        }
    }
}
