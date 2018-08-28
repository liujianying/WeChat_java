package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.b;

class ChattingSendDataToDeviceUI$b$1 implements Runnable {
    final /* synthetic */ b tLR;

    ChattingSendDataToDeviceUI$b$1(b bVar) {
        this.tLR = bVar;
    }

    public final void run() {
        this.tLR.tLG.tLj.aQ(this.tLR.tLG.tLr);
        if (this.tLR.tLG.tLj.getCount() > 0) {
            this.tLR.tLG.tLo.setText(R.l.chatting_available_device);
            this.tLR.tLG.tLu = false;
        }
        this.tLR.tLG.tLj.notifyDataSetChanged();
    }
}
