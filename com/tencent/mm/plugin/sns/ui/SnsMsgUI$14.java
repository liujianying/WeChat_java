package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class SnsMsgUI$14 implements f {
    final /* synthetic */ SnsMsgUI nYl;

    SnsMsgUI$14(SnsMsgUI snsMsgUI) {
        this.nYl = snsMsgUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.SnsMsgUI", "onItemDel object null");
            return;
        }
        try {
            SnsMsgUI.a(this.nYl, bi.WU(obj.toString()));
        } catch (Throwable e) {
            x.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
            x.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
        }
    }
}
