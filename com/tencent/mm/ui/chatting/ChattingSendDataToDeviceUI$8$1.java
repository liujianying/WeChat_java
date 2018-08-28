package com.tencent.mm.ui.chatting;

import com.tencent.mm.R;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.8;

class ChattingSendDataToDeviceUI$8$1 implements Runnable {
    final /* synthetic */ 8 tLM;

    ChattingSendDataToDeviceUI$8$1(8 8) {
        this.tLM = 8;
    }

    public final void run() {
        this.tLM.tLI.tNv.setProgress(0);
        ChattingSendDataToDeviceUI.b(this.tLM.tLG).remove(this.tLM.pZP);
        this.tLM.tLI.tNv.setVisibility(4);
        this.tLM.tLI.tLN.setText(this.tLM.tLG.getText(R.l.chatting_send_success));
        this.tLM.tLI.tLN.setTextColor(this.tLM.tLG.getResources().getColor(R.e.send_data_sending));
        this.tLM.tLJ.bLZ = "send_data_sucess";
        this.tLM.tLJ.progress = 0;
        ChattingSendDataToDeviceUI.a(this.tLM.tLG, 4);
    }
}
