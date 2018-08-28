package com.tencent.mm.compatible.util;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnAudioFocusChangeListener {
    final /* synthetic */ c dgh;

    c$1(c cVar) {
        this.dgh = cVar;
    }

    public final void onAudioFocusChange(int i) {
        if (this.dgh.dgf != null) {
            x.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[]{Integer.valueOf(i)});
            this.dgh.dgf.ex(i);
        }
    }
}
