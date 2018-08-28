package com.tencent.mm.ak;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

class p$1 extends AsyncTask<String, Integer, Bitmap> {
    final /* synthetic */ p dWK;

    p$1(p pVar) {
        this.dWK = pVar;
    }

    protected final /* synthetic */ Object doInBackground(Object[] objArr) {
        String[] strArr = (String[]) objArr;
        if (strArr.length <= 0) {
            return null;
        }
        String lV = p.lV(strArr[0]);
        return new File(lV).exists() ? c.Wb(lV) : null;
    }

    protected final /* synthetic */ void onPostExecute(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        if (bitmap != null) {
            x.d("MicroMsg.UrlImageCacheService", "load from sdcard");
            if (!this.dWK.dWJ) {
                o.Pe();
                c.h(this.dWK.dWI.url, bitmap);
                this.dWK.dWI.dWL.i(this.dWK.dWI.url, bitmap);
            }
            this.dWK.dWI = null;
            this.dWK.Pm();
            return;
        }
        x.i("MicroMsg.UrlImageCacheService", "try load from " + this.dWK.dWI.url);
        o.Pe().a(this.dWK.dWI.url, this.dWK);
    }
}
