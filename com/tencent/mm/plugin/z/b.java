package com.tencent.mm.plugin.z;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class b {
    public static int lst = 0;
    public static int lsu = 1644429312;
    public static int lsv = 302122240;
    public static int lsw = 50;
    public static int lsx = 20;
    public static int lsy = 100;
    public static int lsz = 3;

    public static void bfD() {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100224");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            lst = bi.getInt((String) ckq.get("SyncOpen"), 0);
            lsu = bi.getInt((String) ckq.get("WindowsVersion"), 1644429312);
            lsv = bi.getInt((String) ckq.get("MacVersion"), 302122240);
            lsw = bi.getInt((String) ckq.get("MsgSyncSessionCount"), 50);
            lsx = bi.getInt((String) ckq.get("MsgSyncMsgCount"), 20);
            lsy = bi.getInt((String) ckq.get("MsgSyncSessionListCount"), 100);
            lsz = bi.getInt((String) ckq.get("MsgSyncTimeLimit"), 3);
        }
        x.i("MicroMsg.MsgSynchronizeConstants", "initMsgSynchronizeAbtest, SYNC_CLOSE:%d, WINDOWS_VERSION:%d, MAC_VERSION:%d, SESSION_COUNT:%d, MSG_COUNT%d, MSG_LIST_COUNT:%d, TIME_LIMIT:%d", Integer.valueOf(lst), Integer.valueOf(lsu), Integer.valueOf(lsv), Integer.valueOf(lsw), Integer.valueOf(lsx), Integer.valueOf(lsy), Integer.valueOf(lsz));
    }
}
