package com.tencent.mm.plugin.voip_cs.b.b;

import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.voip.b.a;
import com.tencent.mm.plugin.voip_cs.b.b;
import com.tencent.mm.plugin.voip_cs.b.c;
import com.tencent.mm.protocal.c.bxi;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.nio.ByteBuffer;

class a$1 extends ag {
    final /* synthetic */ a oYc;

    a$1(a aVar, Looper looper) {
        this.oYc = aVar;
        super(looper);
    }

    public final void handleMessage(Message message) {
        if (message == null) {
            super.handleMessage(message);
            return;
        }
        x.d("MicroMsg.VoipCSEngine", "msg.what: %d, msg.obj: %s, msg.arg1: %s, msg.arg2: %s", new Object[]{Integer.valueOf(message.what), message.obj, Integer.valueOf(message.arg1), Integer.valueOf(message.arg2)});
        a aVar;
        switch (message.arg1) {
            case 3:
                x.d("MicroMsg.VoipCSEngine", "start dev!");
                return;
            case 5:
                x.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_RESET");
                if (message.arg2 == 4) {
                    x.i("MicroMsg.VoipCSEngine", "channel broken...");
                    b.bMx().oWM = 1;
                } else if (message.arg2 == 5) {
                    x.i("MicroMsg.VoipCSEngine", "channel event network failer...");
                    b.bMx().oWM = 6;
                } else {
                    x.i("MicroMsg.VoipCSEngine", "channel connect fail...");
                    b.bMx().oWM = 5;
                }
                aVar = this.oYc;
                x.i("MicroMsg.VoipCSEngine", "channel connect failed!");
                b.bMx().bjS = 1;
                if (aVar.oYb != null) {
                    aVar.oYb.bML();
                    return;
                }
                return;
            case 6:
                x.i("MicroMsg.VoipCSEngine", "jni throw NOTIFY_FROM_JNI_CHANNEL_CONNECTED");
                c bMx = b.bMx();
                x.d("MicroMsg.VoipCSReportHelper", "channelConnect");
                bMx.oWP = 1;
                aVar = this.oYc;
                x.i("MicroMsg.VoipCSEngine", "channel connect!");
                if (aVar.kqA) {
                    x.i("MicroMsg.VoipCSEngine", "channel already connect! do call not startEngine again");
                    return;
                }
                aVar.kqA = true;
                x.i("MicroMsg.VoipCSEngine", "start engine");
                aVar.kqx.setInactive();
                x.d("MicroMsg.VoipCSEngine", "setChannelActiveAfterAccept");
                if (!aVar.kqA) {
                    x.d("MicroMsg.VoipCSEngine", "channel not connect now");
                }
                aVar.kqx.setActive();
                int startEngine = aVar.kqx.startEngine();
                if (startEngine == 0) {
                    x.i("MicroMsg.VoipCSEngine", "start engine suc!");
                    int[] iArr = new int[]{b.bMv().kqx.oPt, b.bMv().kqx.oPu};
                    ByteBuffer allocate = ByteBuffer.allocate(8);
                    allocate.asIntBuffer().put(iArr);
                    if (b.bMv().kqx.setAppCmd(34, allocate.array(), 2) < 0) {
                        x.i("MicroMsg.VoipCSEngine", "setAppCmd: type:34,qosparam:" + iArr[0] + "," + iArr[1] + ",ret:" + startEngine);
                    }
                    b.bMx().oWN = 1;
                } else {
                    x.i("MicroMsg.VoipCSEngine", "start engine fail!");
                    b.bMx().oWN = 0;
                }
                if (aVar.oYb != null && b.bMw().oXs != 2) {
                    aVar.oYb.aWO();
                    b.bMw().oXs = 2;
                    return;
                }
                return;
            case 8:
                byte[] bArr = (byte[]) message.obj;
                a aVar2 = this.oYc;
                try {
                    bxi bxi = (bxi) new bxi().aG(bArr);
                    a.eU("MicroMsg.VoipCSEngine", "steve: onRecvRUDPCmd:" + bxi.stM);
                    switch (bxi.stM) {
                        case 3:
                            if (bxi.stN != null) {
                                Object obj = bxi.stN.lR;
                                a.eU("MicroMsg.VoipCSEngine", "steve: remote new network type:" + obj);
                                int appCmd = aVar2.kqx.setAppCmd(302, obj, 4);
                                if (appCmd < 0) {
                                    a.eU("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] update remote network type " + obj + "fail:" + appCmd + ", [roomid=" + aVar2.kqx.oOl + ", roomkey=" + aVar2.kqx.kpp + "]");
                                    return;
                                }
                                return;
                            }
                            a.eU("MicroMsg.VoipCSEngine", "steve:[ENGINE]IMVQQEngine::SetAppCmd[EMethodSetRemoteNetType] empty buffer");
                            return;
                        default:
                            return;
                    }
                } catch (Exception e) {
                    a.eU("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                    return;
                }
                a.eU("MicroMsg.VoipCSEngine", "onVoipLocalNetTypeChange Error");
                return;
            case 100:
                a.b((byte[]) message.obj, "MicroMsg.VoipCSEngine", message.arg2);
                return;
            case 101:
                a.b((byte[]) message.obj, "MicroMsg.VoipCSEngine-JNI_CORE", message.arg2);
                return;
            default:
                return;
        }
    }
}
