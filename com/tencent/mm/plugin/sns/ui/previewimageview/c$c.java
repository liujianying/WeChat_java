package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class c$c extends h<String, Integer, Boolean> {
    private ImageView bRk;
    private Bitmap dHf;
    final /* synthetic */ c olw;
    private String path;

    public final /* synthetic */ Object bxI() {
        if (c.b(this.olw)) {
            return Boolean.valueOf(false);
        }
        this.dHf = c.e(this.path, af.byw(), af.byw(), true);
        x.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", new Object[]{this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree())});
        this.dHf = c.b(this.dHf, (float) r0);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        if (!c.b(this.olw) && i.q(this.dHf)) {
            c.a(this.olw).put(this.path, this.dHf);
            if (this.bRk.getTag() != null && (this.bRk.getTag() instanceof String) && this.bRk.getTag().equals(this.path)) {
                this.bRk.setImageBitmap(this.dHf);
            }
        }
    }

    public c$c(c cVar, ImageView imageView, String str) {
        this.olw = cVar;
        this.bRk = imageView;
        this.path = str;
    }

    public final ag bxH() {
        return af.bxZ();
    }
}
