package com.tencent.mm.plugin.ipcall.a.c;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.plugin.ipcall.a.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

class a$1 extends ag {
    final /* synthetic */ a kqD;

    a$1(a aVar, Looper looper) {
        this.kqD = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null || message.what != 59998) {
            super.handleMessage(message);
            return;
        }
        x.d("MicroMsg.IPCallEngineManager", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
        a aVar;
        switch (message.arg1) {
            case 3:
                x.d("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEV");
                return;
            case 4:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_STARTDEVFAILED");
                aVar = this.kqD;
                x.d("MicroMsg.IPCallEngineManager", "handleStartDevFailed");
                if (aVar.kqC != null) {
                    aVar.kqC.aWN();
                    return;
                }
                return;
            case 5:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_RESET");
                if (message.arg2 == 4) {
                    x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_BROKEN");
                    a.a(this.kqD, 34);
                    return;
                } else if (message.arg2 == 1) {
                    x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_FAIL");
                    a.a(this.kqD, 20);
                    return;
                } else if (message.arg2 == 5) {
                    x.i("MicroMsg.IPCallEngineManager", "CHANNEL_EVENT_NETWORK_ERROR");
                    a.a(this.kqD, 30);
                    return;
                } else {
                    return;
                }
            case 6:
                aVar = this.kqD;
                x.d("MicroMsg.IPCallEngineManager", "channel connect!");
                if (aVar.kqA) {
                    x.d("MicroMsg.IPCallEngineManager", "channel already connect! do call not startEngine again");
                    return;
                }
                x.d("MicroMsg.IPCallEngineManager", "startNativeEngine, ret: %d", new Object[]{Integer.valueOf(aVar.kqx.startEngine())});
                if (aVar.kqx.startEngine() == 0) {
                    aVar.kqx.oOL = 0;
                } else {
                    aVar.kqx.oOL = 1;
                }
                aVar.kqx.setInactive();
                aVar.kqA = true;
                if (aVar.kqC != null) {
                    aVar.kqC.aWO();
                    return;
                }
                return;
            case 9:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_FIRST_PKT");
                return;
            case 10:
                x.i("MicroMsg.IPCallEngineManager", "NOTIFY_FROM_JNI_ANSWER_MARK");
                x.i("MicroMsg.IPCallEngineManager", "handleChannelAccept");
                g aXp = i.aXp();
                x.i("MicroMsg.IPCallSvrLogic", "handleChannelAccept");
                if (aXp.bXc) {
                    x.i("MicroMsg.IPCallSvrLogic", "current status has accepted, ignore channel accept");
                    return;
                }
                aXp.koI = true;
                if (aXp.koG != null) {
                    aXp.koG.fOu = 2;
                    au.DF().a(new o(aXp.koG.kpo, aXp.koG.kpp, aXp.koG.aXG(), aXp.koG.kpq, true), 0);
                }
                aXp.rx(2);
                return;
            default:
                return;
        }
    }
}
