package com.tencent.mm.ui.chatting;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.R;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.ec;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;

class ChattingSendDataToDeviceUI$1 implements OnItemClickListener {
    final /* synthetic */ ChattingSendDataToDeviceUI tLG;

    ChattingSendDataToDeviceUI$1(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        this.tLG = chattingSendDataToDeviceUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.tLG.tLv = true;
        c EU = ChattingSendDataToDeviceUI.a(this.tLG).EU(i);
        String str = EU.bKv;
        String str2 = EU.deviceID;
        String str3 = EU.bLU;
        try {
            if (ChattingSendDataToDeviceUI.b(this.tLG).get(str2) != null) {
                x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: some file is sending");
                cw cwVar = new cw();
                cwVar.bKr.byN = str2;
                a.sFg.m(cwVar);
                ChattingSendDataToDeviceUI.a(this.tLG, "send_data_cancel", str2, 0);
                EU.bLZ = "send_data_cancel";
                ChattingSendDataToDeviceUI.b(this.tLG).remove(str2);
                aq aqVar = (aq) ((View) ChattingSendDataToDeviceUI.c(this.tLG).get(Integer.valueOf(i))).getTag();
                aqVar.tLN.setText(this.tLG.getText(R.l.chatting_send_cancel));
                aqVar.tLN.setTextColor(this.tLG.getResources().getColor(R.e.send_data_cancel));
                aqVar.tNv.setVisibility(8);
                aqVar.tNv.setProgress(0);
                return;
            }
            EU.bLZ = "send_data_sending";
            ChattingSendDataToDeviceUI.d(this.tLG).put(EU.deviceID, EU);
            ChattingSendDataToDeviceUI.b(this.tLG).put(str2, view);
            ChattingSendDataToDeviceUI.a(this.tLG, "send_data_sending", str2, 1);
            ChattingSendDataToDeviceUI.a(this.tLG, 3);
            ec ecVar = new ec();
            ecVar.bLS.byN = str2;
            ecVar.bLS.bKv = str;
            ecVar.bLS.data = ChattingSendDataToDeviceUI.e(this.tLG);
            ecVar.bLS.bLU = str3;
            if (this.tLG.bLV) {
                ecVar.bLS.bKW = ChattingSendDataToDeviceUI.f(this.tLG);
                ecVar.bLS.bLV = this.tLG.bLV;
            } else {
                ecVar.bLS.bJC = ChattingSendDataToDeviceUI.g(this.tLG);
            }
            a.sFg.m(ecVar);
            if (!ecVar.bLT.bLW) {
                ChattingSendDataToDeviceUI.aaj("send_data_failed");
                x.e("MicroMsg.ChattingSendDataToDeviceUI", " e.result.isSuccess is false, send fail!");
            }
        } catch (Exception e) {
            ChattingSendDataToDeviceUI.aaj("send_data_failed");
            x.e("MicroMsg.ChattingSendDataToDeviceUI", "send to device item click exception %s", new Object[]{e});
        }
    }
}
