package com.tencent.mm.compatible.util;

import android.content.Context;
import com.tencent.mm.compatible.a.a;

public final class b {
    b dgb = null;
    private final String dgc = "audio_lock";
    Context mContext = null;

    public b(Context context) {
        this.mContext = context;
        a.a(8, new 1(this));
    }

    public final boolean requestFocus() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.dgb == null) {
                z = false;
            } else {
                z = this.dgb.requestFocus();
            }
        }
        return z;
    }

    public final boolean zY() {
        boolean z;
        synchronized ("audio_lock") {
            if (this.dgb == null) {
                z = false;
            } else {
                z = this.dgb.zY();
            }
        }
        return z;
    }

    public final void a(a aVar) {
        if (this.dgb != null) {
            this.dgb.a(aVar);
        }
    }
}
