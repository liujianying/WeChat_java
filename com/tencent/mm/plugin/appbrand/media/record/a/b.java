package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.mm.plugin.appbrand.media.record.a.c.a;
import com.tencent.mm.sdk.platformtools.x;

public class b implements c {
    String giV = "audio/mp4a-latm";
    String giW = "audio/mpeg";
    a giX = null;
    int giY = 0;
    int giZ = 0;
    byte[] gja;
    int gjb = 0;

    public final void lj(int i) {
        x.i("MicroMsg.Record.AudioEncoder", "mMinBufferSize:%d", new Object[]{Integer.valueOf(this.giY)});
        this.giY = i;
    }

    public final void a(a aVar) {
        this.giX = aVar;
    }

    public final void lk(int i) {
        x.i("MicroMsg.Record.AudioEncoder", "setEncodeBuffFrameSize frameSize:%d", new Object[]{Integer.valueOf(i)});
        this.giZ = i * 1024;
        this.gja = new byte[(i * 1024)];
    }

    public boolean e(String str, int i, int i2, int i3) {
        return false;
    }

    public boolean a(boolean z, byte[] bArr, int i) {
        return false;
    }

    public void flush() {
    }

    public void close() {
    }

    public final void d(byte[] bArr, int i, boolean z) {
        if (this.giX == null) {
            x.e("MicroMsg.Record.AudioEncoder", "mEncodeListener is null, return");
        } else if (this.giZ == 0) {
            x.e("MicroMsg.Record.AudioEncoder", "no frameSize, return");
        } else {
            if (i > this.giZ) {
                x.w("MicroMsg.Record.AudioEncoder", "buffSize:%d frameSize:%d, buffSize > frameSize ", new Object[]{Integer.valueOf(i), Integer.valueOf(this.giZ)});
            }
            x.d("MicroMsg.Record.AudioEncoder", "bufferedSize:%d, buffSize:%d", new Object[]{Integer.valueOf(this.gjb), Integer.valueOf(i)});
            int i2 = this.gjb + i;
            if (i2 >= this.giZ && bArr != null) {
                x.d("MicroMsg.Record.AudioEncoder", "flush all, currentBufferedSize:%d", new Object[]{Integer.valueOf(i2)});
                if (i2 > this.gja.length) {
                    x.i("MicroMsg.Record.AudioEncoder", "expand the end codeBuffer:%d", new Object[]{Integer.valueOf(i2)});
                    Object obj = this.gja;
                    this.gja = new byte[i2];
                    System.arraycopy(obj, 0, this.gja, 0, this.gjb);
                }
                System.arraycopy(bArr, 0, this.gja, this.gjb, i);
                this.giX.c(this.gja, i2, false);
                this.gjb = 0;
            } else if (bArr != null) {
                System.arraycopy(bArr, 0, this.gja, this.gjb, i);
                this.gjb = i2;
                x.d("MicroMsg.Record.AudioEncoder", "append buff, currentBufferedSize:%d", new Object[]{Integer.valueOf(this.gjb)});
            }
            if (z) {
                x.i("MicroMsg.Record.AudioEncoder", "isEnd is true, flush the buffer, bufferedSize:%d", new Object[]{Integer.valueOf(this.gjb)});
                this.giX.c(this.gja, this.gjb, z);
                this.gjb = 0;
            }
        }
    }
}
