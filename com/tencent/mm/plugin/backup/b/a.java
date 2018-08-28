package com.tencent.mm.plugin.backup.b;

import android.os.HandlerThread;
import com.tencent.mm.lan_cs.Client;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements com.tencent.mm.plugin.backup.f.b.a {
    public static final byte[] gRO = "GSMW".getBytes();
    private String gRP;
    private int gRQ;
    public ag gRR = null;
    public a gRS;
    public int mode = 0;

    public final void connect(String str, int i) {
        this.mode = 2;
        this.gRP = str;
        this.gRQ = i;
        Client.duF = new 2(this);
    }

    public final void stop() {
        x.i("MicroMsg.BackupCEngine", "BackupCEngine stop.");
        if (this.mode == 1) {
            Java2C.stop();
            b.arI();
            this.mode = 0;
        } else if (this.mode == 2) {
            Client.Java2C.disconnect();
            b.arI();
            this.mode = 0;
        }
    }

    public final void j(int i, byte[] bArr) {
        long VF = bi.VF();
        x.v("MicroMsg.BackupCEngine", "send seq:%d buff:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(bi.bD(bArr))});
        if (this.gRR == null || !this.gRR.getLooper().getThread().isAlive()) {
            HandlerThread Xs = e.Xs("BackupCEngine_sendHandler");
            Xs.setPriority(10);
            Xs.start();
            this.gRR = new ag(Xs.getLooper());
            x.w("MicroMsg.BackupCEngine", "BackupCEngine send, new writerHandler:%d", new Object[]{Long.valueOf(Xs.getId())});
        }
        this.gRR.post(new 4(this, i, bArr, VF));
    }

    public final int k(int i, byte[] bArr) {
        int send;
        long VF = bi.VF();
        if (this.mode == 1) {
            send = Java2C.send(this.gRP, this.gRQ, bArr);
        } else if (this.mode == 2) {
            send = Client.Java2C.send(this.gRP, this.gRQ, bArr);
            b.mK(bi.bD(bArr));
        } else {
            send = 0;
        }
        x.i("MicroMsg.BackupCEngine", "sendSameThread, result[%d], seq[%d], buflen[%d], send time[%d]", new Object[]{Integer.valueOf(send), Integer.valueOf(i), Integer.valueOf(bi.bD(bArr)), Long.valueOf(bi.bH(VF))});
        return send;
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        ah.A(new 5(this, z, i, i2, bArr));
    }
}
