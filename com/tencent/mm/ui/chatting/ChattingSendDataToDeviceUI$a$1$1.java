package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.a.1;

class ChattingSendDataToDeviceUI$a$1$1 implements Runnable {
    final /* synthetic */ 1 tLQ;

    ChattingSendDataToDeviceUI$a$1$1(1 1) {
        this.tLQ = 1;
    }

    public final void run() {
        this.tLQ.tLI.tNv.setProgress(0);
        this.tLQ.tLI.tNv.setVisibility(4);
        this.tLQ.tLI.tLN.setText(this.tLQ.tLP.tLG.getText(R.l.chatting_send_success));
        this.tLQ.tLI.tLN.setTextColor(this.tLQ.tLP.tLG.getResources().getColor(R.e.send_data_sending));
        this.tLQ.tLJ.bLZ = "send_data_sucess";
        this.tLQ.tLJ.progress = 0;
        ChattingSendDataToDeviceUI.d(this.tLQ.tLP.tLG).put(this.tLQ.tLJ.deviceID, this.tLQ.tLJ);
        x.i("MicroMsg.ChattingSendDataToDeviceUI", " deviceId %s SEND_DATA_SUCCESS!", new Object[]{this.tLQ.tLJ.deviceID});
    }
}
