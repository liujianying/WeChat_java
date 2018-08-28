package com.tencent.mm.ui.chatting;

import android.view.View;
import com.tencent.mm.g.a.dz;
import com.tencent.mm.g.a.ed;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.7;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChattingSendDataToDeviceUI$b {
    final /* synthetic */ ChattingSendDataToDeviceUI tLG;

    public ChattingSendDataToDeviceUI$b(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI) {
        this.tLG = chattingSendDataToDeviceUI;
    }

    public final boolean n(b bVar) {
        if (bVar instanceof dz) {
            List list = ((dz) bVar).bLM.bKZ;
            List arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                c cVar = new c(this.tLG);
                cVar.bKv = (String) ((Map) list.get(i)).get("deviceType");
                cVar.deviceID = (String) ((Map) list.get(i)).get("deviceID");
                cVar.daA = (String) ((Map) list.get(i)).get("displayName");
                cVar.iconUrl = (String) ((Map) list.get(i)).get("iconUrl");
                cVar.bLU = (String) ((Map) list.get(i)).get("ability");
                cVar.tLS = (String) ((Map) list.get(i)).get("abilityInf");
                if ((this.tLG.bLV && ChattingSendDataToDeviceUI.b(cVar, ChattingSendDataToDeviceUI.f(this.tLG))) || (!this.tLG.bLV && ChattingSendDataToDeviceUI.b(cVar, ChattingSendDataToDeviceUI.g(this.tLG)))) {
                    if (ChattingSendDataToDeviceUI.d(this.tLG).containsKey(cVar.deviceID) && ((c) ChattingSendDataToDeviceUI.d(this.tLG).get(cVar.deviceID)).bLZ != null) {
                        cVar.bLZ = ((c) ChattingSendDataToDeviceUI.d(this.tLG).get(cVar.deviceID)).bLZ;
                        cVar.progress = ((c) ChattingSendDataToDeviceUI.d(this.tLG).get(cVar.deviceID)).progress;
                    }
                    arrayList.add(cVar);
                }
            }
            if (ChattingSendDataToDeviceUI.l(this.tLG).size() != arrayList.size()) {
                ChattingSendDataToDeviceUI.a(this.tLG, arrayList);
                this.tLG.runOnUiThread(new 1(this));
            }
        } else if (bVar instanceof ed) {
            ed edVar = (ed) bVar;
            String str = edVar.bLX.bLZ;
            String str2 = edVar.bLX.byN;
            if (str.equals("send_data_sending")) {
                ChattingSendDataToDeviceUI.a(this.tLG, "send_data_sending", str2, edVar.bLX.progress);
            } else if (str.equals("send_data_failed")) {
                ChattingSendDataToDeviceUI.a(this.tLG, "send_data_failed", str2, 0);
            } else if (str.equals("send_data_sucess")) {
                ChattingSendDataToDeviceUI chattingSendDataToDeviceUI = this.tLG;
                try {
                    aq aqVar = (aq) ((View) chattingSendDataToDeviceUI.tLB.get(Integer.valueOf(((Integer) chattingSendDataToDeviceUI.tLC.get(str2)).intValue()))).getTag();
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "set progress to success now: %s deviceId %s", new Object[]{Integer.valueOf(aqVar.tNv.getProgress()), str2});
                    c cVar2 = (c) chattingSendDataToDeviceUI.tLA.get(str2);
                    chattingSendDataToDeviceUI.runOnUiThread(new 7(chattingSendDataToDeviceUI, aqVar, cVar2));
                    int abs = Math.abs(aqVar.tNv.getProgress());
                    cVar2.progress = abs;
                    x.d("MicroMsg.ChattingSendDataToDeviceUI", "sleepTime %d", new Object[]{Integer.valueOf(abs >= 100 ? 0 : 500 / (100 - abs))});
                    e.b(new ChattingSendDataToDeviceUI$8(chattingSendDataToDeviceUI, abs, aqVar, str2, cVar2, r6), "progressSuccess_handler").start();
                    chattingSendDataToDeviceUI.tLA.put(cVar2.deviceID, cVar2);
                } catch (Exception e) {
                    x.e("MicroMsg.ChattingSendDataToDeviceUI", "ap: set progress to success exception %s", new Object[]{e});
                }
            }
        }
        return true;
    }
}
