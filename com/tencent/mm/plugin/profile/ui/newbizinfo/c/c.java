package com.tencent.mm.plugin.profile.ui.newbizinfo.c;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    public static final void bT(String str, int i) {
        x.d("MicroMsg.Kv13307", "username:%s scene::%s optype:%d opscene:%d", new Object[]{str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(4)});
        h.mEJ.h(13307, new Object[]{str, Integer.valueOf(3), Integer.valueOf(i), Integer.valueOf(4)});
    }
}
