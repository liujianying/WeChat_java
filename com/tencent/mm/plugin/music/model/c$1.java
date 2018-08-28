package com.tencent.mm.plugin.music.model;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements OnAudioFocusChangeListener {
    final /* synthetic */ c lxT;

    c$1(c cVar) {
        this.lxT = cVar;
    }

    public final void onAudioFocusChange(int i) {
        x.i("MicroMsg.Music.MusicAudioFocusHelper", "focus change %d", new Object[]{Integer.valueOf(i)});
        if (i == -2 || i == -3) {
            x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus lossTransient");
            if (h.bic().bhQ().PZ()) {
                h.bic().bhQ().bhn();
            }
        } else if (i == 1 || i == 2 || i == 3) {
            x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus gain");
            if (h.bic().bhQ().PZ()) {
                h.bic().bhQ().resume();
            }
        } else if (i == -1) {
            x.i("MicroMsg.Music.MusicAudioFocusHelper", "audio focus loss, passive pause");
            if (h.bic().bhQ().PZ()) {
                h.bic().bhQ().bhn();
                h.bic();
                e.bhX();
                h.bic().bhY();
            }
            h.bie().abandonAudioFocus(this.lxT.lxS);
        }
    }
}
