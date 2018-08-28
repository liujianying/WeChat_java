package com.tencent.mm.ui.tools;

import android.view.View;
import android.view.View.OnClickListener;

class CropImageNewUI$5 implements OnClickListener {
    final /* synthetic */ CropImageNewUI uwf;

    CropImageNewUI$5(CropImageNewUI cropImageNewUI) {
        this.uwf = cropImageNewUI;
    }

    public final void onClick(View view) {
        CropImageNewUI.j(this.uwf).zoomIn();
    }
}
