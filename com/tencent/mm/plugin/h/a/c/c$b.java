package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.InputStream;

public final class c$b implements Runnable {
    private final BluetoothSocket hiP;
    private b hiR;
    a hiS;
    private InputStream hiV = null;
    private volatile boolean hiW = false;

    public c$b(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
        this.hiP = bluetoothSocket;
        this.hiR = bVar;
        this.hiS = aVar;
        try {
            this.hiV = bluetoothSocket.getInputStream();
        } catch (IOException e) {
            this.hiV = null;
            x.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! (%s)", new Object[]{e.toString()});
        }
    }

    public final void run() {
        x.i("MicroMsg.exdevice.RecvThread", "BEGIN RecvThread");
        if (this.hiV == null) {
            x.e("MicroMsg.exdevice.RecvThread", "socket.getInputStream failed!!! Just Leave");
            return;
        }
        Object obj = new byte[2048];
        while (!this.hiW) {
            try {
                int read = this.hiV.read(obj);
                if (read > 0) {
                    x.i("MicroMsg.exdevice.RecvThread", "------On data receivce------data length = %d", new Object[]{Integer.valueOf(read)});
                    x.d("MicroMsg.exdevice.RecvThread", "data dump = %s", new Object[]{b.O(obj, read)});
                    Object obj2 = new byte[read];
                    System.arraycopy(obj, 0, obj2, 0, read);
                    if (this.hiS != null) {
                        this.hiS.hiH.b(this.hiR.mSessionId, obj2);
                    }
                }
            } catch (IOException e) {
                x.e("MicroMsg.exdevice.RecvThread", "mInStream.read Failed!!! (%s)", new Object[]{e.toString()});
                try {
                    this.hiP.close();
                    return;
                } catch (IOException e2) {
                    x.e("MicroMsg.exdevice.RecvThread", "Close socket failed!!! (%s)", new Object[]{e2.toString()});
                    return;
                }
            }
        }
        x.w("MicroMsg.exdevice.RecvThread", "Cancel is called while receiving data, just leave");
    }

    public final void cancel() {
        x.i("MicroMsg.exdevice.RecvThread", "------cancel------");
        if (this.hiW) {
            x.w("MicroMsg.exdevice.RecvThread", "Cancel is done aready, just leave");
            return;
        }
        this.hiW = true;
        e.S(this);
        try {
            this.hiP.close();
        } catch (IOException e) {
            x.e("MicroMsg.exdevice.RecvThread", "close() of connect socket failed", new Object[]{e});
        }
    }
}
