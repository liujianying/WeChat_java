package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel;

import android.os.Looper;
import com.tencent.mm.a.k;
import com.tencent.mm.plugin.backup.a.d;
import com.tencent.mm.plugin.backup.f.b.a;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.zip.CRC32;

public final class b implements a {
    public static final byte[] gRO = "GSMW".getBytes();
    private Socket gDe = null;
    private Boolean gZj = Boolean.valueOf(false);
    private ServerSocket gZk = null;
    private ag gZl = null;
    private ag gZm = new ag(Looper.getMainLooper());
    private DataOutputStream gZn = null;
    private int gZo = 0;
    private int gZp = 0;
    private long gZq = 0;
    private Object lock = new Object();

    public b() {
        asT();
    }

    public final void c(int i, List<pw> list) {
        x.i("MicroMsg.BakOldJavaEngine", "connect type:%d", new Object[]{Integer.valueOf(i)});
        asT();
        e.post(new 1(this, i, list), "BackupJavaEngine_connect");
    }

    public final void asR() {
        x.i("MicroMsg.BakOldJavaEngine", "close connect");
        asS();
        a(true, 0, 10003, null);
    }

    private void asS() {
        this.gZo = 0;
        this.gZp = 0;
        this.gZq = 0;
        this.gZj = Boolean.valueOf(true);
        try {
            synchronized (this.lock) {
                if (this.gZn != null) {
                    this.gZn.close();
                }
            }
        } catch (Exception e) {
        }
        try {
            if (this.gDe != null) {
                this.gDe.close();
            }
        } catch (Exception e2) {
        }
    }

    private void a(boolean z, int i, int i2, byte[] bArr) {
        this.gZm.post(new 2(this, z, i, i2, bArr));
    }

    public final void j(int i, byte[] bArr) {
        if (this.gZl != null) {
            Z(bArr);
        } else {
            this.gZm.postDelayed(new 3(this, i, bArr), 200);
        }
    }

    public final int k(int i, byte[] bArr) {
        return 0;
    }

    public final void Z(byte[] bArr) {
        if (this.gZj.booleanValue()) {
            x.e("MicroMsg.BakOldJavaEngine", "engine has stop");
        } else {
            this.gZl.post(new 4(this, bArr));
        }
    }

    private void asT() {
        if (this.gZl == null || !this.gZl.getLooper().getThread().isAlive()) {
            e.b(new 5(this), "BackupJavaEngine_handler").start();
        }
    }

    private void a(DataInputStream dataInputStream) {
        int i;
        String format;
        while (!this.gZj.booleanValue() && this.gZo != 4) {
            try {
                if (gRO[this.gZo] == dataInputStream.readByte()) {
                    this.gZo++;
                } else {
                    long VE = bi.VE();
                    if (((long) this.gZp) - (VE - this.gZq) < 10) {
                        if (this.gZp < 0) {
                            this.gZp = 0;
                        }
                        this.gZp++;
                        this.gZq = VE;
                        i = 0;
                    } else {
                        boolean i2 = true;
                    }
                    if (i2 == 0) {
                        format = String.format("GSMW in the %dth step error:expect:%02X, butGet:%02X", new Object[]{Integer.valueOf(this.gZo + 1), Integer.valueOf(gRO[this.gZo] & WebView.NORMAL_MODE_ALPHA), Integer.valueOf(r1 & WebView.NORMAL_MODE_ALPHA)});
                        x.e("MicroMsg.BakOldJavaEngine", format);
                        a(true, 0, 10007, format.getBytes());
                    }
                    this.gZo = 0;
                }
            } catch (Exception e) {
                x.e("MicroMsg.BakOldJavaEngine", "loopRead %s", new Object[]{e});
                try {
                    dataInputStream.close();
                } catch (IOException e2) {
                }
                if (!this.gZj.booleanValue()) {
                    a(true, 0, 10006, ("read_error " + e).getBytes());
                }
                asS();
                return;
            }
        }
        this.gZo = 0;
        int readInt = dataInputStream.readInt();
        short readShort = dataInputStream.readShort();
        short readShort2 = dataInputStream.readShort();
        int readInt2 = dataInputStream.readInt();
        if (readInt2 > 16777216) {
            format = String.format("loopRead size to large:%d", new Object[]{Integer.valueOf(readInt2)});
            x.e("MicroMsg.BakOldJavaEngine", format);
            this.gZj = Boolean.valueOf(true);
            a(true, 0, 10007, format.getBytes());
            return;
        }
        int readInt3 = dataInputStream.readInt();
        x.i("MicroMsg.BakOldJavaEngine", "read buf size:" + readInt2);
        byte[] bArr = new byte[(readInt2 - 20)];
        i2 = 0;
        while (i2 < bArr.length) {
            int read = dataInputStream.read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e3) {
                }
            } else {
                i2 += read;
            }
        }
        PByteArray pByteArray = new PByteArray();
        byte[] bArr2 = gRO;
        if (readShort != (short) 1) {
            format = String.format("unpack failed, getVersion:%d", new Object[]{Short.valueOf(readShort)});
            x.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i2 = -1;
        } else if (com.tencent.mm.plugin.backup.f.b.aqS() != 1 || readInt3 == com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.a(bArr2, readInt, readShort, readShort2, readInt2, bArr)) {
            if (!(readShort2 == (short) 1 || readShort2 == (short) 2)) {
                bArr = k.a(bArr, d.aqT());
            }
            pByteArray.value = bArr;
            i2 = 0;
        } else {
            new CRC32().update(bArr);
            String Y = com.tencent.mm.plugin.backup.bakoldlogic.bakoldmodel.b.Y(bArr);
            format = String.format("unpack failed--calcSum:%d, getfromPcMgr:%d, seq:%d, type:%d, size:%d, just buf.crc:%d, last 100 bytes:%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(readInt3), Integer.valueOf(readInt), Short.valueOf(readShort2), Integer.valueOf(readInt2), Integer.valueOf((int) r2.getValue()), Y});
            x.e("MicroMsg.BakOldPacker", format);
            pByteArray.value = format.getBytes();
            i2 = -2;
        }
        x.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d]", new Object[]{Integer.valueOf(i2)});
        if (i2 != 0) {
            a(true, 0, 10007, (pByteArray.value == null ? "" : new String(pByteArray.value)).getBytes());
            return;
        }
        x.d("MicroMsg.BakOldJavaEngine", "summerbak loopRead unpack ret[%d], seq[%d], type[%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(readInt), Short.valueOf(readShort2)});
        a(false, readInt, readShort2, pByteArray.value);
    }
}
