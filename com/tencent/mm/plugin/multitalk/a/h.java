package com.tencent.mm.plugin.multitalk.a;

import android.app.Activity;
import com.tencent.mm.R;
import com.tencent.mm.ax.e;

public final class h {
    private boolean ltY;
    private boolean ltZ;

    public final void v(Activity activity) {
        if (!this.ltY) {
            this.ltY = true;
            e.a(activity, R.l.multitalk_not_support_video_tip, null);
        }
    }

    public final void w(Activity activity) {
        if (!this.ltZ) {
            this.ltZ = true;
            e.a(activity, R.l.voip_not_wifi_warnning_message, null);
        }
    }

    public final void reset() {
        this.ltZ = false;
        this.ltY = false;
    }
}
