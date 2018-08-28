package com.tencent.mm.plugin.facedetect.ui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b iRW;

    b$1(b bVar) {
        this.iRW = bVar;
    }

    public final void onClick(View view) {
        if (this.iRW.iRV != null) {
            this.iRW.iRV.onCancel();
        }
        this.iRW.dismiss();
    }
}
