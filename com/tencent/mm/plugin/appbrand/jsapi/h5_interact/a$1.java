package com.tencent.mm.plugin.appbrand.jsapi.h5_interact;

import com.tencent.mm.plugin.appbrand.ipc.MMToClientEvent.a;

class a$1 implements a {
    a$1() {
    }

    public final void bj(Object obj) {
        if (obj instanceof SendDataToMiniProgramFromH5Event) {
            SendDataToMiniProgramFromH5Event sendDataToMiniProgramFromH5Event = (SendDataToMiniProgramFromH5Event) obj;
            a.j(sendDataToMiniProgramFromH5Event.fQs, sendDataToMiniProgramFromH5Event.data, sendDataToMiniProgramFromH5Event.fQt);
        }
    }
}
