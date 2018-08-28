package com.tencent.mm.plugin.h.a.c;

import android.bluetooth.BluetoothSocket;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import junit.framework.Assert;

public final class c$c implements Runnable {
    private b hiR = null;
    private a hiS = null;
    private volatile boolean hiW = false;
    private volatile Runnable hiX = null;
    private OutputStream hiY = null;
    private final LinkedList<byte[]> hiZ = new LinkedList();
    private final LinkedList<byte[]> hja = new LinkedList();

    public c$c(b bVar, a aVar, BluetoothSocket bluetoothSocket) {
        this.hiR = bVar;
        this.hiS = aVar;
        try {
            OutputStream outputStream = bluetoothSocket.getOutputStream();
            this.hiX = this;
            this.hiY = outputStream;
        } catch (IOException e) {
            x.e("MicroMsg.exdevice.SendThread", "temp sockets not created", new Object[]{e});
            this.hiY = null;
            if (this.hiS != null) {
                this.hiS.hiH.b(this.hiR.mSessionId, 11, "Can not get write stream");
            }
        }
    }

    public final void run() {
        x.i("MicroMsg.exdevice.SendThread", "BEGIN SendThread");
        if (this.hiY != null) {
            while (!this.hiW) {
                if (this.hiX == null) {
                    x.w("MicroMsg.exdevice.SendThread", "Send thread has been close. just leave");
                    return;
                } else if (!this.hja.isEmpty()) {
                    try {
                        this.hiY.write((byte[]) this.hja.pop());
                        if (this.hiS != null) {
                            this.hiS.hiH.j(this.hiR.mSessionId, true);
                        }
                    } catch (IOException e) {
                        if (this.hiS != null) {
                            this.hiS.hiH.j(this.hiR.mSessionId, false);
                        }
                    }
                } else if (this.hiZ.isEmpty()) {
                    synchronized (this) {
                        try {
                            wait();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.exdevice.SendThread", e2, "", new Object[0]);
                            x.w("MicroMsg.exdevice.SendThread", "BluetoothChatThread_SendRunnable InterruptedException...");
                        }
                    }
                } else {
                    synchronized (this.hiZ) {
                        Assert.assertTrue(this.hja.addAll(this.hiZ));
                        this.hiZ.clear();
                    }
                }
            }
        }
    }

    public final boolean af(byte[] bArr) {
        x.i("MicroMsg.exdevice.SendThread", "------write------buffer length = %d", new Object[]{Integer.valueOf(bArr.length)});
        if (this.hiX == null) {
            x.e("MicroMsg.exdevice.SendThread", "Send thread has been close. Send data abort");
            return false;
        }
        synchronized (this) {
            this.hiZ.add(bArr);
            notify();
        }
        return true;
    }

    public final void cancel() {
        this.hiX = null;
        this.hiW = true;
        synchronized (this) {
            notify();
        }
        this.hja.clear();
        this.hiZ.clear();
    }
}
