package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.sdk.platformtools.al;

class CropImageNewUI$9 implements OnTouchListener {
    final /* synthetic */ CropImageNewUI uwf;
    final /* synthetic */ al uwg;

    CropImageNewUI$9(CropImageNewUI cropImageNewUI, al alVar) {
        this.uwf = cropImageNewUI;
        this.uwg = alVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.uwg.J(200, 200);
                break;
            case 1:
                this.uwg.SO();
                break;
        }
        return false;
    }
}
