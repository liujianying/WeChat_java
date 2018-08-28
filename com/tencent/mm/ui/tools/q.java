package com.tencent.mm.ui.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import com.tencent.mm.bp.a;
import com.tencent.mm.w.a.d;
import junit.framework.Assert;

public final class q {
    private static q uCr = null;
    private ColorStateList[] tEk = new ColorStateList[2];
    private boolean uCs = false;

    private q(Context context) {
        this.tEk[0] = a.ac(context, d.mm_open_status);
        this.tEk[1] = a.ac(context, d.mm_pref_summary);
    }

    private static q ha(Context context) {
        Assert.assertTrue(context != null);
        if (uCr == null || !uCr.uCs) {
            uCr = new q(context);
        }
        return uCr;
    }

    public static ColorStateList hb(Context context) {
        return ha(context).tEk[0];
    }

    public static ColorStateList hc(Context context) {
        return ha(context).tEk[1];
    }
}
