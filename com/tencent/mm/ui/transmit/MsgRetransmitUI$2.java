package com.tencent.mm.ui.transmit;

import com.tencent.mm.R;
import com.tencent.mm.ab.f;
import com.tencent.mm.ab.l;

class MsgRetransmitUI$2 implements f {
    final /* synthetic */ MsgRetransmitUI uDL;

    MsgRetransmitUI$2(MsgRetransmitUI msgRetransmitUI) {
        this.uDL = msgRetransmitUI;
    }

    public final void a(int i, int i2, l lVar) {
        if (MsgRetransmitUI.b(this.uDL) != null && i2 != 0) {
            int i3 = (int) ((((long) i) * 100) / ((long) i2));
            MsgRetransmitUI.b(this.uDL).setMessage(this.uDL.getString(R.l.msgretr_uploading_img, new Object[]{Integer.valueOf(MsgRetransmitUI.c(this.uDL)), Integer.valueOf(MsgRetransmitUI.d(this.uDL)), Integer.valueOf(i3)}));
        }
    }
}
