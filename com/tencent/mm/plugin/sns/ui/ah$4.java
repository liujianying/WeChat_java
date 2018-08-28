package com.tencent.mm.plugin.sns.ui;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mm.compatible.util.Exif;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class ah$4 implements Runnable {
    final /* synthetic */ ah nQf;

    ah$4(ah ahVar) {
        this.nQf = ahVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        for (int i : this.nQf.nPY.nQj) {
            int i2;
            Exif fromFile = Exif.fromFile(i2);
            int i3 = (fromFile.latitude < 0.0d || fromFile.longitude < 0.0d) ? 0 : 1;
            String str = fromFile.model;
            int i4 = fromFile.imageWidth;
            int i5 = fromFile.imageHeight;
            if (i4 <= 0 || i5 <= 0) {
                Options options = new Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(i2, options);
                i5 = options.outWidth;
                i2 = options.outHeight;
            }
            i4 = i5;
            i5 = (int) fromFile.getUxtimeDatatimeOriginal();
            h.mEJ.h(15523, new Object[]{Integer.valueOf(i3), str, Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i5)});
        }
        x.d("MicroMsg.PicWidget", "report photo info cost " + (System.currentTimeMillis() - currentTimeMillis));
    }
}
