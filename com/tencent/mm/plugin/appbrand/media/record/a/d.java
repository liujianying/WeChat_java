package com.tencent.mm.plugin.appbrand.media.record.a;

import com.tencent.mm.plugin.appbrand.media.encode.Mp3EncodeJni;
import com.tencent.mm.plugin.appbrand.media.record.f;
import com.tencent.mm.plugin.appbrand.media.record.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.io.FileOutputStream;

public final class d extends b {
    private int ehg = 2;
    private byte[] gjc;
    private FileOutputStream mFileOutputStream;
    private String mFilePath = "";

    public final boolean e(String str, int i, int i2, int i3) {
        boolean z = true;
        x.i("MicroMsg.Record.MP3AudioEncoder", "init, filePath:%s, sampleRate:%d, channelCount:%d, bitRate:%d", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mFilePath = str;
        this.ehg = i2;
        x.i("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni.init ret :%d", new Object[]{Integer.valueOf(Mp3EncodeJni.init(i, i2, i, i3 / TbsLog.TBSLOG_CODE_SDK_BASE, 5))});
        if (Mp3EncodeJni.init(i, i2, i, i3 / TbsLog.TBSLOG_CODE_SDK_BASE, 5) == -1) {
            h.li(17);
            return false;
        }
        x.i("MicroMsg.Record.MP3AudioEncoder", "lame MPEG version:%d", new Object[]{Integer.valueOf(Mp3EncodeJni.getVersion())});
        try {
            this.mFileOutputStream = new FileOutputStream(str);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "init", new Object[0]);
            h.li(18);
            z = false;
        }
        return z;
    }

    public final boolean a(boolean z, byte[] bArr, int i) {
        boolean z2 = true;
        if (this.giY <= 0) {
            x.e("MicroMsg.Record.MP3AudioEncoder", "mMinBufferSize %d is invalid", new Object[]{Integer.valueOf(this.giY)});
            return false;
        } else if (this.mFileOutputStream == null) {
            x.e("MicroMsg.Record.MP3AudioEncoder", "mFileOutputStream is null");
            return false;
        } else {
            if (this.gjc == null) {
                x.i("MicroMsg.Record.MP3AudioEncoder", "channelCnt:%d, mMinBufferSize:%d, size:%d, ", new Object[]{Integer.valueOf(this.ehg), Integer.valueOf(this.giY), Integer.valueOf((int) (7200.0d + (((double) (this.giY * this.ehg)) * 1.25d)))});
                this.gjc = new byte[r2];
            }
            short[] E = f.E(bArr, i);
            int encode = Mp3EncodeJni.encode(E, E, i / 2, this.gjc);
            x.d("MicroMsg.Record.MP3AudioEncoder", "len:%d, shorts.len:%d, encodedSize:%d", new Object[]{Integer.valueOf(i), Integer.valueOf(E.length), Integer.valueOf(encode)});
            if (encode > 0) {
                x.d("MicroMsg.Record.MP3AudioEncoder", "encodeSize:%d, len:%d", new Object[]{Integer.valueOf(encode), Integer.valueOf(i)});
                try {
                    this.mFileOutputStream.write(this.gjc, 0, encode);
                    d(this.gjc, encode, false);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "encode write", new Object[0]);
                    h.li(20);
                    z2 = false;
                }
            } else {
                x.e("MicroMsg.Record.MP3AudioEncoder", "Mp3EncodeJni encode fail, encodedSize:%d", new Object[]{Integer.valueOf(encode)});
                z2 = false;
            }
            return z2;
        }
    }

    public final void flush() {
        x.i("MicroMsg.Record.MP3AudioEncoder", "flush");
        if (this.mFileOutputStream == null || this.gjc == null) {
            x.e("MicroMsg.Record.MP3AudioEncoder", "flush, mFileOutputStream or mMp3Buffer is null");
            return;
        }
        int flush = Mp3EncodeJni.flush(this.gjc);
        if (flush > 0) {
            try {
                this.mFileOutputStream.write(this.gjc, 0, flush);
                d(this.gjc, flush, true);
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "flush write", new Object[0]);
                h.li(20);
                return;
            }
        }
        x.e("MicroMsg.Record.MP3AudioEncoder", "flush fail, flushResult:%d", new Object[]{Integer.valueOf(flush)});
    }

    public final void close() {
        x.i("MicroMsg.Record.MP3AudioEncoder", "close");
        Mp3EncodeJni.close();
        if (this.mFileOutputStream != null) {
            try {
                this.mFileOutputStream.close();
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Record.MP3AudioEncoder", e, "close", new Object[0]);
                h.li(20);
            }
            this.mFileOutputStream = null;
        }
    }
}
