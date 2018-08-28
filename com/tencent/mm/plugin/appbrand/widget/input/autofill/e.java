package com.tencent.mm.plugin.appbrand.widget.input.autofill;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.s.a;
import com.tencent.mm.plugin.appbrand.s.f;

public final class e extends AutoFillListPopupWindowBase {
    private final Context mContext;

    e(Context context) {
        super(context, null, 0);
        this.mContext = context;
        this.eZB.setInputMethodMode(2);
        this.eZB.setBackgroundDrawable(context.getResources().getDrawable(f.abc_popup_background_mtrl_mult));
        this.Qf = true;
        this.eZB.setFocusable(false);
        this.PR = false;
        this.PS = true;
        this.eZB.setAnimationStyle(a.appbrand_autofill_dropdown);
    }

    public final void show() {
        super.show();
    }
}
