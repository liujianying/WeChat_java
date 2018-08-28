package com.tencent.mm.plugin.record.ui;

import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import java.util.List;

class RecordMsgImageUI$7 implements c {
    final /* synthetic */ List ioK;
    final /* synthetic */ List ioL;
    final /* synthetic */ RecordMsgImageUI mtp;

    RecordMsgImageUI$7(RecordMsgImageUI recordMsgImageUI, List list, List list2) {
        this.mtp = recordMsgImageUI;
        this.ioK = list;
        this.ioL = list2;
    }

    public final void a(l lVar) {
        lVar.setHeaderTitle("");
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.ioK.size()) {
                lVar.e(((Integer) this.ioK.get(i2)).intValue(), (CharSequence) this.ioL.get(i2));
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
