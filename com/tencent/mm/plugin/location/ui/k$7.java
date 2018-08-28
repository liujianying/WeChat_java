package com.tencent.mm.plugin.location.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.as;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$7 implements OnTouchListener {
    final /* synthetic */ k kGI;

    k$7(k kVar) {
        this.kGI = kVar;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                this.kGI.kGx = true;
                this.kGI.kGs.setVisibility(0);
                this.kGI.kGr.reset();
                VolumeMeter volumeMeter = this.kGI.kGr;
                if (!volumeMeter.kHk) {
                    volumeMeter.dRn = true;
                    volumeMeter.aZR();
                }
                this.kGI.kGq.setPressed(true);
                if (this.kGI.kGx) {
                    as.b(ad.getContext(), h.talkroom_press, new 1(this));
                    this.kGI.kGy = 1;
                    x.i("MicroMsg.TalkMgr", "micBtn pressed down");
                    this.kGI.kGA = bi.VG();
                    this.kGI.kGE.Sq();
                    this.kGI.aZK();
                    break;
                }
                break;
            case 1:
            case 3:
                this.kGI.kGq.setPressed(false);
                this.kGI.kGs.setVisibility(8);
                this.kGI.kGr.reset();
                this.kGI.kGr.dRn = false;
                if (this.kGI.kGx) {
                    this.kGI.kGx = false;
                    if (this.kGI.kGy == 5) {
                        x.i("MicroMsg.TalkMgr", "cancel during seize-success prepare time");
                        this.kGI.kGB.SO();
                        this.kGI.kGC.SO();
                    }
                    this.kGI.kGy = 0;
                    this.kGI.kGG.SO();
                    this.kGI.kGE.Sr();
                    as.I(ad.getContext(), h.talkroom_up);
                    this.kGI.aZK();
                    if (this.kGI.kGF != null) {
                        this.kGI.kGF.aZG();
                        break;
                    }
                }
                break;
            case 2:
                if (this.kGI.kGx) {
                    return false;
                }
        }
        return false;
    }
}
