package com.tencent.mm.plugin.sns.ui;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.h;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;

class PreviewImageView$a extends h<String, Integer, Boolean> {
    private ImageView bRk;
    private Bitmap dHf;
    final /* synthetic */ PreviewImageView nQu;
    private String path;

    public final /* synthetic */ Object bxI() {
        if (PreviewImageView.a(this.nQu)) {
            return Boolean.valueOf(false);
        }
        this.dHf = c.e(this.path, af.byw(), af.byw(), true);
        x.d("MicroMsg.MMAsyncTask", "exifPath : %s degree : %d", new Object[]{this.path, Integer.valueOf(Exif.fromFile(this.path).getOrientationInDegree())});
        this.dHf = c.b(this.dHf, (float) r0);
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        super.onPostExecute((Boolean) obj);
        if (!PreviewImageView.a(this.nQu) && i.q(this.dHf)) {
            PreviewImageView.b(this.nQu).put(this.path, this.dHf);
            if (this.bRk.getTag() != null && (this.bRk.getTag() instanceof String) && this.bRk.getTag().equals(this.path)) {
                this.bRk.setImageBitmap(this.dHf);
            }
        }
    }

    public PreviewImageView$a(PreviewImageView previewImageView, ImageView imageView, String str) {
        this.nQu = previewImageView;
        this.bRk = imageView;
        this.path = str;
    }

    public final ag bxH() {
        return af.bxZ();
    }
}
