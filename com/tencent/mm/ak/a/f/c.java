package com.tencent.mm.ak.a.f;

import android.graphics.Bitmap;
import android.os.Looper;
import android.widget.ImageView;
import com.tencent.mm.ak.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class c implements Runnable {
    private String aAL;
    private Bitmap bitmap;
    private b dYi;
    private com.tencent.mm.ak.a.c dYk;
    private String url;

    public c(String str, com.tencent.mm.ak.a.c cVar, Bitmap bitmap, b bVar, String str2) {
        this.url = str;
        this.dYk = cVar;
        this.bitmap = bitmap;
        this.dYi = bVar;
        this.aAL = str2;
    }

    public final void run() {
        if (bi.oW(this.url) || this.dYk == null || this.bitmap == null || this.bitmap.isRecycled() || this.dYi == null) {
            x.w("MicroMsg.imageloader.ImageShowTask", "[cpan] run something is null.");
            return;
        }
        if (this.url.equals((String) this.dYi.dWV.get(Integer.valueOf(this.dYk.Pr())))) {
            com.tencent.mm.ak.a.c cVar = this.dYk;
            Bitmap bitmap = this.bitmap;
            if (Looper.myLooper() == Looper.getMainLooper() && cVar.dWX != null) {
                ImageView imageView = (ImageView) cVar.dWX.get();
                if (imageView != null) {
                    imageView.setImageBitmap(bitmap);
                }
            }
            this.dYi.a(this.dYk);
            return;
        }
        x.w("MicroMsg.imageloader.ImageShowTask", "[cpan] url is not equals view url.");
    }
}
