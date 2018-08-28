package com.tencent.mm.plugin.voip.video;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import com.tencent.mm.plugin.voip.video.i.a;

class i$3 implements OnCompletionListener {
    final /* synthetic */ i oVi;
    final /* synthetic */ int oVj;
    final /* synthetic */ long oVk;
    final /* synthetic */ boolean oVl;
    final /* synthetic */ int oVm;

    i$3(i iVar, int i, long j, boolean z, int i2) {
        this.oVi = iVar;
        this.oVj = i;
        this.oVk = j;
        this.oVl = z;
        this.oVm = i2;
    }

    public final void onCompletion(MediaPlayer mediaPlayer) {
        if (System.currentTimeMillis() - this.oVi.oVf > 70000) {
            this.oVi.oVe = 4;
        }
        if (this.oVi.bwu) {
            this.oVi.oVh = new a(this.oVi, this.oVj, this.oVk, this.oVl, this.oVm);
            this.oVi.dvh.postDelayed(this.oVi.oVh, this.oVk);
        }
    }
}
