package com.tencent.mm.modelvideo;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class MMVideoView$1 implements a {
    final /* synthetic */ MMVideoView elR;

    MMVideoView$1(MMVideoView mMVideoView) {
        this.elR = mMVideoView;
    }

    public final boolean vD() {
        if (MMVideoView.a(this.elR) == null) {
            return false;
        }
        boolean iC;
        boolean isPlaying = this.elR.isPlaying();
        if (isPlaying) {
            MMVideoView.b(this.elR);
        }
        try {
            int currentPosition = MMVideoView.c(this.elR).getCurrentPosition() / BaseReportManager.MAX_READ_COUNT;
            MMVideoView.a(this.elR, currentPosition);
            iC = this.elR.iC(currentPosition);
        } catch (Exception e) {
            x.e(MMVideoView.d(this.elR), "%s online video timer check error [%s] ", new Object[]{MMVideoView.e(this.elR), e.toString()});
            iC = false;
        }
        x.d(MMVideoView.f(this.elR), "%s check timer[%b] isplay[%b]", new Object[]{MMVideoView.g(this.elR), Boolean.valueOf(iC), Boolean.valueOf(isPlaying)});
        if (iC && isPlaying) {
            return true;
        }
        return false;
    }
}
