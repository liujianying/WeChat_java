package com.tencent.mm.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.Toast;
import com.tencent.mm.api.j;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.jsapi.audio.f;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.af.d;

class MMNewPhotoEditUI$5 implements j {
    final /* synthetic */ int eaH;
    final /* synthetic */ MMNewPhotoEditUI tnX;

    MMNewPhotoEditUI$5(MMNewPhotoEditUI mMNewPhotoEditUI, int i) {
        this.tnX = mMNewPhotoEditUI;
        this.eaH = i;
    }

    public final void c(Exception exception) {
        MMNewPhotoEditUI.b(this.tnX);
        x.e("MicroMsg.MMNewPhotoEditUI", "[onRefreshed] %s", new Object[]{exception});
        Toast.makeText(this.tnX, this.tnX.getResources().getString(d.err_save_edit_photo), 1).show();
        this.tnX.setResult(0);
        this.tnX.finish();
    }

    public final void a(Bitmap bitmap, boolean z) {
        x.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] w:%s h:%s", new Object[]{Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight())});
        try {
            String oN = r.oN("jpg");
            c.a(bitmap, 100, CompressFormat.PNG, oN, true);
            x.i("MicroMsg.MMNewPhotoEditUI", "[onSuccess] photoPath:%s", new Object[]{oN});
            if (MMNewPhotoEditUI.c(this.tnX) || this.eaH == 2) {
                r.a(oN, this.tnX);
            }
            if (!(this.eaH == 0 || bitmap.isRecycled())) {
                bitmap.recycle();
            }
            MMNewPhotoEditUI.a(this.tnX, oN);
            if (MMNewPhotoEditUI.d(this.tnX) != 291 && MMNewPhotoEditUI.d(this.tnX) != f.CTRL_INDEX) {
                MMNewPhotoEditUI.d(this.tnX, oN);
            } else if (this.eaH == 0) {
                MMNewPhotoEditUI.b(this.tnX, oN);
                MMNewPhotoEditUI.b(this.tnX);
                MMNewPhotoEditUI.b(this.tnX, 1);
            } else if (this.eaH == 1) {
                MMNewPhotoEditUI.c(this.tnX, oN);
                MMNewPhotoEditUI.b(this.tnX, 2);
                Toast.makeText(this.tnX.mController.tml, this.tnX.getString(d.fav_edit_photo_successfully), 1).show();
                MMNewPhotoEditUI.b(this.tnX);
                this.tnX.finish();
            } else if (this.eaH == 2) {
                Toast.makeText(this.tnX.mController.tml, this.tnX.getString(d.exports_saved, new Object[]{e.dgl}), 1).show();
                MMNewPhotoEditUI.b(this.tnX, 3);
                MMNewPhotoEditUI.b(this.tnX);
                this.tnX.finish();
            }
        } catch (Exception e) {
            c(e);
        }
    }
}
