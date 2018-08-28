package com.tencent.liteav.muxer;

import android.content.Context;
import android.media.MediaFormat;
import com.tencent.liteav.basic.e.b;
import com.tencent.liteav.basic.log.TXCLog;

public class c implements a {
    private int a = 0;
    private a b;

    public c(Context context, int i) {
        switch (i) {
            case 0:
                this.a = 0;
                this.b = new d();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                return;
            case 1:
                this.a = 1;
                this.b = new b();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                return;
            default:
                if (a(context)) {
                    this.a = 0;
                    this.b = new d();
                    TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use sw model ");
                    return;
                }
                this.a = 1;
                this.b = new b();
                TXCLog.i("TXCMP4Muxer", "TXCMP4Muxer: use hw model ");
                return;
        }
    }

    public static boolean a(Context context) {
        b.a().a(context);
        if (b.a().e() == 1) {
            return true;
        }
        return false;
    }

    public void a(MediaFormat mediaFormat) {
        this.b.a(mediaFormat);
    }

    public void b(MediaFormat mediaFormat) {
        this.b.b(mediaFormat);
    }

    public void a(String str) {
        this.b.a(str);
    }

    public void a(byte[] bArr, int i, int i2, long j, int i3) {
        this.b.a(bArr, i, i2, j, i3);
    }

    public void b(byte[] bArr, int i, int i2, long j, int i3) {
        this.b.b(bArr, i, i2, j, i3);
    }

    public int a() {
        return this.b.a();
    }

    public int b() {
        return this.b.b();
    }

    public boolean c() {
        return this.b.c();
    }
}
