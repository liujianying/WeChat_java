package com.tencent.mm.compatible.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import com.tencent.mm.compatible.util.b.b;
import com.tencent.mm.sdk.platformtools.x;

@TargetApi(8)
public final class c implements b {
    private Context context;
    private AudioManager dge;
    b$a dgf;
    private OnAudioFocusChangeListener dgg = new 1(this);

    public final void a(b$a b_a) {
        this.dgf = b_a;
    }

    public c(Context context) {
        this.context = context;
    }

    public final boolean requestFocus() {
        if (this.dge == null && this.context != null) {
            this.dge = (AudioManager) this.context.getSystemService("audio");
        }
        boolean z = this.dge != null ? 1 == this.dge.requestAudioFocus(this.dgg, 3, 2) : false;
        x.l("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.dgg.hashCode())});
        return z;
    }

    public final boolean zY() {
        if (this.dge == null && this.context != null) {
            this.dge = (AudioManager) this.context.getSystemService("audio");
        }
        boolean z = this.dge != null ? 1 == this.dge.abandonAudioFocus(this.dgg) : false;
        x.l("MicroMsg.AudioFocusHelper", "jacks abandonFocus: %B, %x", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.dgg.hashCode())});
        return z;
    }
}
