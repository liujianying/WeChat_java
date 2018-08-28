package com.tencent.mm.ui.tools;

import android.content.Intent;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.ad;

class CropImageNewUI$22 implements Runnable {
    final /* synthetic */ CropImageNewUI uwf;

    CropImageNewUI$22(CropImageNewUI cropImageNewUI) {
        this.uwf = cropImageNewUI;
    }

    public final void run() {
        boolean z = false;
        if (CropImageNewUI.e(this.uwf) != null) {
            if (this.uwf.getIntent().getBooleanExtra("CropImage_DirectlyIntoFilter", false)) {
                Editor edit = this.uwf.getSharedPreferences(ad.chY(), 0).edit();
                String str = "CropImage_Filter_Show";
                if (CropImageNewUI.e(this.uwf).findViewById(R.h.cropimage_filter_gallery).getVisibility() == 0) {
                    z = true;
                }
                edit.putBoolean(str, z);
                edit.commit();
            }
            String stringExtra = this.uwf.getIntent().getStringExtra("CropImage_OutputPath");
            if (stringExtra == null) {
                stringExtra = e.dgl + g.u((CropImageNewUI.o(this.uwf) + System.currentTimeMillis()).getBytes()) + "_fiter.jpg";
            }
            Intent intent = new Intent();
            intent.putExtra("CropImage_Compress_Img", true);
            if (CropImageNewUI.e(this.uwf) != null) {
                intent.putExtra("CropImage_filterId", CropImageNewUI.e(this.uwf).getFilterId());
            }
            if (CropImageNewUI.e(this.uwf).getFilterId() == 0) {
                intent.putExtra("CropImage_OutputPath", CropImageNewUI.o(this.uwf));
                this.uwf.setResult(-1, intent);
            } else if (CropImageNewUI.a(this.uwf, CropImageNewUI.e(this.uwf).getFilterBmp(), stringExtra)) {
                intent.putExtra("CropImage_OutputPath", stringExtra);
                this.uwf.setResult(-1, intent);
            } else {
                this.uwf.setResult(-1);
            }
            this.uwf.finish();
        }
    }
}
