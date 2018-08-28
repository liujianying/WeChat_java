package com.tencent.mm.az;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.at;

public final class c {
    public static long o(String str, long j) {
        long j2 = 0;
        if (str != null) {
            at YN = d.SE().YN(str);
            if (YN != null) {
                j2 = YN.field_createTime + 1;
            }
        }
        return j2 > j * 1000 ? j2 : j * 1000;
    }

    public static void d(long j, String str) {
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, rowId: %d, talker: %s", new Object[]{Long.valueOf(j), str});
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fconversation, ret = " + d.SF().m(j, str));
        x.i("MicroMsg.FMessageLogic", "clearFMsgAndFConvByTalker, delete fmsginfo, ret = " + d.SE().Gy(str));
    }
}
