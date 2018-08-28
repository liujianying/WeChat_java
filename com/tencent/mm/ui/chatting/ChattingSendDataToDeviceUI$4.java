package com.tencent.mm.ui.chatting;

import com.tencent.mm.pluginsdk.model.app.f;
import java.util.Comparator;
import java.util.List;

class ChattingSendDataToDeviceUI$4 implements Comparator<f> {
    final /* synthetic */ ChattingSendDataToDeviceUI tLG;
    final /* synthetic */ List tqs;

    ChattingSendDataToDeviceUI$4(ChattingSendDataToDeviceUI chattingSendDataToDeviceUI, List list) {
        this.tLG = chattingSendDataToDeviceUI;
        this.tqs = list;
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return this.tqs.indexOf(((f) obj2).field_appId) - this.tqs.indexOf(((f) obj).field_appId);
    }
}
