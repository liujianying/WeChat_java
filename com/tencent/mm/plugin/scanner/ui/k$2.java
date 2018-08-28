package com.tencent.mm.plugin.scanner.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.R;
import com.tencent.mm.plugin.scanner.util.p;
import com.tencent.mm.sdk.platformtools.x;

class k$2 implements Runnable {
    final /* synthetic */ k mKV;

    k$2(k kVar) {
        this.mKV = kVar;
    }

    public final void run() {
        if (System.currentTimeMillis() - k.a(this.mKV) > 30000) {
            x.d("MicroMsg.scanner.ScanModeImage", "show scan img nothing recognize");
            this.mKV.mKp.hu(true);
            this.mKV.gmo.setVisibility(8);
            k.b(this.mKV).setText(R.l.scan_img_nothing_recognize);
            k.b(this.mKV).setVisibility(0);
            if (k.c(this.mKV) == null) {
                k.a(this.mKV, new OnTouchListener() {
                    public final boolean onTouch(View view, MotionEvent motionEvent) {
                        k$2.this.mKV.mKp.hu(false);
                        k$2.this.mKV.gmo.setVisibility(0);
                        k$2.this.mKV.gmo.setText(p.et(p.mOc, k$2.this.mKV.mKp.getContext().getString(R.l.scan_img_tips_focus)));
                        k.b(k$2.this.mKV).setVisibility(8);
                        k.a(k$2.this.mKV, System.currentTimeMillis());
                        return false;
                    }
                });
            }
            k.d(this.mKV).setOnTouchListener(k.c(this.mKV));
        }
    }
}
