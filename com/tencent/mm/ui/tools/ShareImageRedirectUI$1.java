package com.tencent.mm.ui.tools;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.mm.R;

class ShareImageRedirectUI$1 implements OnTouchListener {
    final /* synthetic */ ShareImageRedirectUI uBL;

    ShareImageRedirectUI$1(ShareImageRedirectUI shareImageRedirectUI) {
        this.uBL = shareImageRedirectUI;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        Toast.makeText(this.uBL, R.l.shareimg_open_camera_failed, 1).show();
        this.uBL.finish();
        return false;
    }
}
