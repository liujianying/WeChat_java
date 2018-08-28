package com.tencent.mm.pluginsdk.ui.applet;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.aa.c;

class b$3 implements Runnable {
    final /* synthetic */ b qIl;

    b$3(b bVar) {
        this.qIl = bVar;
    }

    public final void run() {
        ImageView imageView = (ImageView) this.qIl.qIi.getContentView().findViewById(R.h.confirm_dialog_thumb_iv);
        if (imageView != null) {
            Bitmap a = c.a(this.qIl.ipd.field_username, false, -1);
            if (a != null && this.qIl.ipd.ckW()) {
                a = com.tencent.mm.sdk.platformtools.c.a(a, false, (float) (a.getWidth() / 2));
            }
            if (a != null && !a.isRecycled()) {
                imageView.setImageBitmap(a);
                imageView.setVisibility(0);
            }
        }
    }
}
