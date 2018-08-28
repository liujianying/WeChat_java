package com.tencent.mm.plugin.freewifi.ui;

import android.content.Context;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.Date;

public final class a extends b {
    private static Date jmj = null;
    private boolean hasInit = false;
    private Runnable jmk = new 2(this);

    public a(Context context) {
        super(context);
        initialize();
    }

    public final int getLayoutId() {
        return R.i.free_wifi_tips;
    }

    private void initialize() {
        if (this.view != null) {
            View findViewById = this.view.findViewById(R.h.free_wifi_tip_view);
            if (!this.hasInit) {
                this.hasInit = true;
                findViewById.setOnClickListener(new 1(this));
                findViewById.setVisibility(8);
            }
        }
    }

    public final void destroy() {
    }

    public final boolean anR() {
        if (this.hasInit) {
            ah.M(this.jmk);
            ah.i(this.jmk, 500);
            return true;
        }
        initialize();
        return false;
    }
}
