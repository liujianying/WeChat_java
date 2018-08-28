package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$9 implements Runnable {
    final /* synthetic */ int fdk;
    final /* synthetic */ String pZP;
    final /* synthetic */ String qas;
    final /* synthetic */ ChattingSendDataToDeviceUI tLG;
    TextView tLN;

    ChattingSendDataToDeviceUI$9(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, String str, String str2, int i) {
        this.tLG = chattingSendDataToDeviceUI;
        this.pZP = str;
        this.qas = str2;
        this.fdk = i;
    }

    public final void run() {
        try {
            c cVar = (c) ChattingSendDataToDeviceUI.d(this.tLG).get(this.pZP);
            cVar.bLZ = this.qas;
            if (this.fdk > cVar.progress) {
                cVar.progress = this.fdk;
            }
            View view = (View) ChattingSendDataToDeviceUI.c(this.tLG).get(Integer.valueOf(((Integer) ChattingSendDataToDeviceUI.k(this.tLG).get(this.pZP)).intValue()));
            aq aqVar = (aq) view.getTag();
            if (aqVar == null) {
                x.w("MicroMsg.ChattingSendDataToDeviceUI", "get view holder is null");
                return;
            }
            this.tLN = aqVar.tLN;
            this.tLN.setVisibility(0);
            if (this.qas.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.a(this.tLG, 5);
                this.tLN.setText(this.tLG.getString(R.l.chatting_send_failed));
                ChattingSendDataToDeviceUI.b(this.tLG).remove(this.pZP);
                this.tLN.setTextColor(this.tLG.getResources().getColor(R.e.send_state_text_failed));
                ChattingSendDataToDeviceUI.a(false, 0, view);
            } else if (this.qas.equals("send_data_sending")) {
                this.tLN.setText(this.tLG.getString(R.l.chatting_sending));
                this.tLN.setTextColor(this.tLG.getResources().getColor(R.e.send_data_sending));
                ChattingSendDataToDeviceUI.a(true, this.fdk, view);
            } else if (this.qas.equals("send_data_cancel")) {
                ChattingSendDataToDeviceUI.a(this.tLG, 6);
                this.tLN.setText(this.tLG.getString(R.l.chatting_send_cancel));
                this.tLN.setTextColor(this.tLG.getResources().getColor(R.e.send_data_cancel));
                ChattingSendDataToDeviceUI.a(true, 0, view);
            }
            ChattingSendDataToDeviceUI.d(this.tLG).put(cVar.deviceID, cVar);
        } catch (Exception e) {
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: send Data: %s", new Object[]{e.getMessage()});
        }
    }
}
