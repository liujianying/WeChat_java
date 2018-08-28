package com.tencent.mm.plugin.scanner.util;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.c;
import java.util.Map;

public final class i {
    public static boolean btj() {
        c fJ = com.tencent.mm.model.c.c.Jx().fJ("100027");
        if (fJ.isValid()) {
            Map ckq = fJ.ckq();
            if (ckq == null) {
                x.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList args == null");
                return false;
            } else if (ckq.containsKey("showEntrance") && "1".equals(ckq.get("showEntrance"))) {
                return true;
            } else {
                x.e("MicroMsg.ScanHistoryUtil", "not contain the showEntrance key or the value is not 1");
                return false;
            }
        }
        x.e("MicroMsg.ScanHistoryUtil", "shouldShowHistoryList item.isValid is false");
        return false;
    }
}
