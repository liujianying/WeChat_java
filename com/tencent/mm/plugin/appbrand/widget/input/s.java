package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.appbrand.widget.d.a;
import com.tencent.mm.sdk.platformtools.ad;

public final class s implements a {
    private int gHO = 0;
    private final Rect gHP = new Rect();
    private boolean gHQ = false;
    private View gHR;
    a gHS;

    private void getWindowVisibleDisplayFrame(Rect rect) {
        if (this.gHR != null) {
            this.gHR.getWindowVisibleDisplayFrame(rect);
        }
    }

    private Context getContext() {
        return this.gHR == null ? ad.getContext() : this.gHR.getContext();
    }

    private int getFrameHeight() {
        if ((this.gHR == null ? null : this.gHR.getRootView()) == null) {
            return 0;
        }
        Rect rect = this.gHP;
        getWindowVisibleDisplayFrame(rect);
        return getContext().getResources().getDisplayMetrics().heightPixels - rect.top;
    }

    public final void bY(View view) {
        boolean ak;
        Object obj = 1;
        this.gHR = view;
        Rect rect = this.gHP;
        getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (this.gHO == 0) {
            this.gHO = height;
        } else {
            int frameHeight = getFrameHeight() - height;
            if (frameHeight > 0) {
                if (j.fA(getContext()) != frameHeight) {
                    ak = j.ak(getContext(), frameHeight);
                } else {
                    ak = false;
                }
                if (!(!ak || this.gHS == null || this.gHS.getHeight() == frameHeight)) {
                    this.gHS.ma(frameHeight);
                }
            }
        }
        if (getFrameHeight() > height) {
            ak = true;
        } else {
            ak = false;
        }
        if (this.gHQ == ak) {
            obj = null;
        }
        if (!(obj == null || this.gHS == null)) {
            this.gHS.dp(ak);
        }
        this.gHQ = ak;
        this.gHO = height;
        this.gHR = null;
    }
}
