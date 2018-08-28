package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import com.tencent.mm.plugin.scanner.util.a;
import com.tencent.mm.plugin.scanner.util.e;
import com.tencent.mm.sdk.b.c;

public final class b {
    Activity mActivity;
    String mFE;
    e mFF;
    a mFG;
    e.a mFH = new 1(this);
    public c mFI = new 2(this);
    public c mFJ = new 3(this);

    public final void bsa() {
        if (this.mFF != null) {
            this.mFF.bsY();
            this.mFF = null;
        }
        this.mActivity = null;
        this.mFE = null;
    }
}
