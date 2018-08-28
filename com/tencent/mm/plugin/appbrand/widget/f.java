package com.tencent.mm.plugin.appbrand.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.plugin.appbrand.jsapi.base.e;
import com.tencent.mm.plugin.appbrand.widget.g.a;

@SuppressLint({"AppCompatCustomView"})
public class f extends TextView implements e {
    private a gEC;
    private boolean gEe;

    public f(Context context) {
        super(context);
        super.setIncludeFontPadding(false);
        super.setLineSpacing(0.0f, 1.0f);
        super.setSpannableFactory(new 1(this));
    }

    public void setLineHeight(int i) {
        if (this.gEC == null) {
            this.gEC = new a((float) i);
        }
        if (this.gEC.af((float) i)) {
            invalidate();
        }
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        if (bufferType == BufferType.NORMAL) {
            bufferType = BufferType.SPANNABLE;
        }
        super.setText(charSequence, bufferType);
    }

    public void setInterceptEvent(boolean z) {
        this.gEe = z;
    }

    public final boolean ail() {
        return this.gEe;
    }
}
