package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import com.tencent.mm.plugin.voip.model.v2protocal;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;

public final class a {
    public boolean kqA = false;
    public v2protocal kqx = new v2protocal(this.kqy);
    private ag kqy = new 1(this, Looper.getMainLooper());
    public boolean kqz = false;
    public a oYb = null;

    public interface a {
        void aWO();

        void bML();
    }

    public static int OP(String str) {
        String[] split = str.split("\\.");
        return bi.getInt(split[3], 0) + (((bi.getInt(split[0], 0) << 24) + (bi.getInt(split[1], 0) << 16)) + (bi.getInt(split[2], 0) << 8));
    }
}
