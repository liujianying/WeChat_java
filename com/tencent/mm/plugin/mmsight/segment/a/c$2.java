package com.tencent.mm.plugin.mmsight.segment.a;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.x;

class c$2 implements a {
    final /* synthetic */ c lnN;

    c$2(c cVar) {
        this.lnN = cVar;
    }

    public final boolean vD() {
        if (this.lnN.released) {
            return false;
        }
        try {
            if (!this.lnN.isPlaying()) {
                return true;
            }
            int currentPosition = this.lnN.getCurrentPosition();
            if (this.lnN.lnl != null) {
                this.lnN.lnl.sZ(currentPosition);
            }
            x.d("MicroMsg.SectionRepeatMediaPlayer", "position[%d] repeat[%d, %d] duration[%d]", new Object[]{Integer.valueOf(currentPosition), Integer.valueOf(this.lnN.lnB), Integer.valueOf(this.lnN.lnC), Integer.valueOf(this.lnN.getDuration())});
            if (currentPosition < this.lnN.lnC) {
                return true;
            }
            x.i("MicroMsg.SectionRepeatMediaPlayer", "reach repeat end time, seek to %s", new Object[]{Integer.valueOf(this.lnN.lnC)});
            this.lnN.seekTo(this.lnN.lnB);
            return false;
        } catch (IllegalStateException e) {
            x.e("MicroMsg.SectionRepeatMediaPlayer", "MediaPlayer may be released. %s", new Object[]{e.getMessage()});
            if (this.lnN.released) {
                return false;
            }
            return true;
        }
    }
}
