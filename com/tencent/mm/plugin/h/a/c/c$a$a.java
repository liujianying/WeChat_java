package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothSocket;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.h.a.c.c.a;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.lang.ref.WeakReference;

class c$a$a extends ag {
    private WeakReference<a> hgm = null;

    public c$a$a(Looper looper, a aVar) {
        super(looper);
        this.hgm = new WeakReference(aVar);
    }

    public final void handleMessage(Message message) {
        a aVar = (a) this.hgm.get();
        if (aVar == null) {
            x.e("MicroMsg.exdevice.BluetoothChatThreads", "null == connectTread");
            return;
        }
        switch (message.what) {
            case 0:
                x.i("MicroMsg.exdevice.ConnectThread", "------connectImp------");
                if (aVar.hiT) {
                    x.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready connect, just leave");
                    return;
                }
                try {
                    if (aVar.hiQ) {
                        aVar.hiP = aVar.hiU.createRfcommSocketToServiceRecord(a.hiF);
                    } else {
                        aVar.hiP = aVar.hiU.createInsecureRfcommSocketToServiceRecord(a.hiG);
                    }
                    try {
                        aVar.hiP.connect();
                        aVar.hiT = true;
                        b bVar = aVar.hiR;
                        a aVar2 = aVar.hiS;
                        BluetoothSocket bluetoothSocket = aVar.hiP;
                        x.i("MicroMsg.exdevice.BluetoothChatSession", "connected");
                        bVar.mState = 3;
                        if (bVar.hiN != null) {
                            bVar.hiN.cancel();
                            bVar.hiN = null;
                        }
                        if (bVar.hiO != null) {
                            bVar.hiO.cancel();
                            bVar.hiO = null;
                        }
                        bVar.hiN = new c$b(bVar, aVar2, bluetoothSocket);
                        e.b(bVar.hiN, "BluetoothChatSession_recv").start();
                        bVar.hiO = new c$c(bVar, aVar2, bluetoothSocket);
                        e.b(bVar.hiO, "BluetoothChatSession_send").start();
                        if (aVar.hiS != null) {
                            aVar.hiS.hiH.i(aVar.hiR.mSessionId, true);
                            return;
                        }
                        return;
                    } catch (IOException e) {
                        x.e("MicroMsg.exdevice.ConnectThread", "socket connect failed (%s)", new Object[]{e.toString()});
                        try {
                            aVar.hiP.close();
                        } catch (IOException e2) {
                            x.e("MicroMsg.exdevice.ConnectThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                        }
                        if (aVar.hiS != null) {
                            aVar.hiS.hiH.i(aVar.hiR.mSessionId, false);
                            return;
                        }
                        return;
                    }
                } catch (IOException e22) {
                    aVar.hiP = null;
                    x.e("MicroMsg.exdevice.ConnectThread", "createRfcommSocket Failed!!! (%s)", new Object[]{e22.toString()});
                    if (aVar.hiS != null) {
                        aVar.hiS.hiH.i(aVar.hiR.mSessionId, false);
                        return;
                    }
                    return;
                }
            case 1:
                if (aVar.hiT) {
                    try {
                        aVar.hiP.close();
                        return;
                    } catch (IOException e3) {
                        x.e("MicroMsg.exdevice.ConnectThread", "socket close failed (%s)", new Object[]{e3.toString()});
                        return;
                    }
                }
                x.w("MicroMsg.exdevice.ConnectThread", "Remoto device is aready disconnect, just leave");
                return;
            default:
                return;
        }
    }
}
