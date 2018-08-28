package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.HandlerThread;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class c$a {
    BluetoothSocket hiP;
    final boolean hiQ = true;
    public final b hiR;
    public final a hiS;
    boolean hiT = false;
    final BluetoothDevice hiU;
    public final ag mHandler;
    private final HandlerThread mThread;

    public c$a(b bVar, a aVar, BluetoothDevice bluetoothDevice) {
        this.hiS = aVar;
        this.hiR = bVar;
        this.hiU = bluetoothDevice;
        this.mThread = e.Xs("BluetoothChatThreads_handlerThread");
        this.mThread.start();
        this.mHandler = new a(this.mThread.getLooper(), this);
    }

    public final void disconnect() {
        x.i("MicroMsg.exdevice.ConnectThread", "------disconnect------");
        if (!this.mHandler.sendMessage(this.mHandler.obtainMessage(1))) {
            x.e("MicroMsg.exdevice.ConnectThread", "sendMessage = %d failed!!!", new Object[]{Integer.valueOf(1)});
        }
        if (d.fR(18)) {
            this.mThread.quitSafely();
        } else {
            this.mThread.quit();
        }
    }
}
