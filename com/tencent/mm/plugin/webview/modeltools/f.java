package com.tencent.mm.plugin.webview.modeltools;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Looper;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ag.a;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;
import java.io.IOException;
import java.util.Locale;

public final class f {
    ag guJ = new ag(Looper.getMainLooper(), this.pUr);
    MMWebView pUo;
    public String pUp;
    c pUq;
    private a pUr = new 1(this);

    private final class b implements Runnable {
        private Bitmap mBitmap;

        public b(Bitmap bitmap) {
            this.mBitmap = bitmap;
        }

        public final void run() {
            f.this.pUp = String.format(Locale.US, "%s%s_%08x.jpg", new Object[]{e.bnE, Long.valueOf(System.currentTimeMillis()), Integer.valueOf(this.mBitmap.hashCode())});
            try {
                c.a(this.mBitmap, 100, CompressFormat.JPEG, f.this.pUp, true);
            } catch (IOException e) {
                x.e("MicroMsg.ViewCaptureHelper", "saveBitmapToImage failed, " + e.getMessage());
                f.this.pUp = null;
            }
            this.mBitmap.recycle();
            f.this.guJ.sendEmptyMessage(2);
        }
    }

    public final void a(MMWebView mMWebView, c cVar) {
        this.pUo = mMWebView;
        this.pUq = cVar;
        this.guJ.sendEmptyMessage(1);
    }

    public final void bVc() {
        com.tencent.mm.sdk.f.e.post(new a(this, (byte) 0), "ViewCaptureHelper_DeleteBitmap");
    }
}
