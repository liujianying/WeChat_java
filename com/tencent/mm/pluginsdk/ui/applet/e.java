package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.ak.a.c.g;
import com.tencent.mm.ak.a.d.b;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

public final class e implements g {
    private int qIq;
    private int qIr;
    private int qIs;
    a qIt;

    public e() {
        this(0, 0, 0, null);
    }

    public e(int i, int i2, int i3, a aVar) {
        this.qIq = i;
        this.qIr = i2;
        this.qIs = i3;
        this.qIt = aVar;
    }

    public final void me(String str) {
        x.d("MicroMsg.ReaderAppUI", "onImageLoadStart, url: %s", str);
        h.mEJ.a(86, 0, 1, false);
    }

    public final Bitmap a(String str, b bVar) {
        if (this.qIq == 0) {
            return null;
        }
        if (bVar == null || bVar.bitmap == null || bVar.bitmap.isRecycled()) {
            x.w("MicroMsg.ReaderAppUI", "onProcessBitmap bitmap is null");
            return null;
        } else if (bi.oW(str)) {
            x.w("MicroMsg.ReaderAppUI", "onProcessBitmap url is null");
            return null;
        } else {
            try {
                Bitmap a = c.a(bVar.bitmap, this.qIr, this.qIs, true);
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a, this.qIr, this.qIs, true);
                if (!(createScaledBitmap == a || a == null || a.isRecycled())) {
                    a.recycle();
                }
                a = c.d(createScaledBitmap, this.qIq);
                if (!(createScaledBitmap == null || createScaledBitmap.isRecycled())) {
                    createScaledBitmap.recycle();
                }
                return a;
            } catch (OutOfMemoryError e) {
                x.w("MicroMsg.ReaderAppUI", "onProcessBitmap OutOfMemoryError %s", e.getMessage());
                return null;
            }
        }
    }

    public final void a(String str, View view, b bVar) {
        if (!(this.qIt == null || bVar.bitmap == null || bVar.bitmap.isRecycled())) {
            1 1 = new 1(this);
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                1.run();
            } else {
                ah.A(1);
            }
        }
        if (bVar.bJu == 2) {
            boolean z;
            x.d("MicroMsg.ReaderAppUI", "onImageLoadFinish, url:%s, contentType: %s", str, bVar.aBC);
            if (q.Pn() && !bi.oW(bVar.aBC) && q.lY(str) && bVar.aBC.equals("image/webp")) {
                z = true;
            } else {
                z = false;
            }
            x.d("MicroMsg.ReaderAppUI", "onImageLoadFinish, isDownloadWebp: %b, status: %d", Boolean.valueOf(z), Integer.valueOf(bVar.status));
            switch (bVar.status) {
                case 0:
                    if (z) {
                        h.mEJ.a(86, 13, 1, false);
                        return;
                    }
                    return;
                case 1:
                    h.mEJ.a(86, 2, 1, false);
                    if (z) {
                        h.mEJ.a(86, 15, 1, false);
                        return;
                    }
                    return;
                case 3:
                    if (z) {
                        h.mEJ.a(86, 14, 1, false);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
