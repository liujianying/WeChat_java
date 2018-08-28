package com.tencent.mm.ak;

import android.graphics.Bitmap.CompressFormat;
import android.os.AsyncTask;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;

class p$2 extends AsyncTask<p$b, Integer, Integer> {
    final /* synthetic */ p dWK;

    p$2(p pVar) {
        this.dWK = pVar;
    }

    private static Integer a(p$b... p_bArr) {
        if (p_bArr.length == 0 || bi.oW(p_bArr[0].path) || p_bArr[0].bitmap == null) {
            x.e("MicroMsg.UrlImageCacheService", "nothing to save");
        } else {
            try {
                c.a(p_bArr[0].bitmap, 100, CompressFormat.PNG, p_bArr[0].path, false);
            } catch (IOException e) {
                x.e("MicroMsg.UrlImageCacheService", "save bitmap to image failed: " + e.toString());
            }
        }
        return null;
    }
}
