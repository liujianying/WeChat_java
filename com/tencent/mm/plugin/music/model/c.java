package com.tencent.mm.plugin.music.model;

import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.sdk.platformtools.x;

public final class c {
    OnAudioFocusChangeListener lxS = new 1(this);

    public final boolean requestFocus() {
        boolean z;
        int requestAudioFocus = h.bie().requestAudioFocus(this.lxS, 3, 2);
        String str = "MicroMsg.Music.MusicAudioFocusHelper";
        String str2 = "request audio focus %b";
        Object[] objArr = new Object[1];
        if (requestAudioFocus == 1) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        if (requestAudioFocus == 1) {
            return true;
        }
        return false;
    }

    public final void bhO() {
        x.i("MicroMsg.Music.MusicAudioFocusHelper", "abandonFocus");
        h.bie().abandonAudioFocus(this.lxS);
    }
}
