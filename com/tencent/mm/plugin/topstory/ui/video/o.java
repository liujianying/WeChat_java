package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.protocal.c.bti;
import com.tencent.mm.sdk.platformtools.x;

public final class o {
    a oAb;
    d oCc = new d();
    m oCd;
    n oCe;
    bti oCf;
    public boolean oCg;
    boolean oCh;
    a oCi = new 1(this);
    boolean oCj;

    static /* synthetic */ j a(String str, String str2, String str3, a aVar) {
        j jVar = new j();
        jVar.field_mediaId = str;
        jVar.url = str2;
        jVar.dQm = 1;
        jVar.dQh = 3;
        jVar.concurrentCount = 4;
        jVar.field_fullpath = str3;
        jVar.dQt = aVar;
        return jVar;
    }

    private void bIA() {
        this.oCc.bv(false);
    }

    public final boolean bIB() {
        if (this.oCd != null) {
            return this.oCd.isPlaying();
        }
        return false;
    }

    public final void setMute(boolean z) {
        if (this.oCd != null) {
            this.oCd.setMute(z);
        }
    }

    public final void bGR() {
        if (this.oCd != null) {
            this.oCc.a(this.oCi);
            this.oCd.setKeepScreenOn(true);
            this.oCd.play();
            this.oCh = false;
        }
    }

    public final void bAf() {
        if (this.oCd != null) {
            bIA();
            this.oCd.setKeepScreenOn(false);
            this.oCd.pause();
            this.oCh = true;
        }
    }

    public final void stopPlay() {
        if (this.oCd != null) {
            x.i("MicroMsg.TopStory.TopStoryVideoViewMgr", "stop play");
            bIA();
            ((TopStoryVideoPlayTextureView) this.oCd.hEl).setAlpha(0.0f);
            this.oCd.setKeepScreenOn(false);
            this.oCd.stop();
            this.oCf = null;
            this.oCg = false;
            this.oCh = false;
            this.oAb.bHU().b(this.oAb.bHT());
            this.oAb.bHU().bIe();
            if (this.oCe != null) {
                n nVar = this.oCe;
                nVar.oBf.onDestroy();
                nVar.bIt();
            }
        }
    }

    public final int getCurrPosSec() {
        if (this.oCd != null) {
            return this.oCd.getCurrPosSec();
        }
        return 0;
    }

    public final int getVideoDurationSec() {
        if (this.oCd != null) {
            return this.oCd.getVideoDurationSec();
        }
        return 0;
    }

    public final int getCurrPosMs() {
        if (this.oCd != null) {
            return this.oCd.getCurrPosMs();
        }
        return 0;
    }

    public static boolean G(long j, long j2) {
        if (j >= 50 || j2 > 5242880) {
            return true;
        }
        return false;
    }
}
