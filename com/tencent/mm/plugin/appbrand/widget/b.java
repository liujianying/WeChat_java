package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;

@SuppressLint({"AppCompatCustomView"})
public class b extends ImageView implements e {
    private boolean gEe;

    public b(Context context) {
        super(context);
    }

    public void setInterceptEvent(boolean z) {
        this.gEe = z;
    }

    public final boolean ail() {
        return this.gEe;
    }
}
