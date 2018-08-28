package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.pluginsdk.ui.d.k;
import com.tencent.mm.pluginsdk.ui.d.o;
import com.tencent.mm.pluginsdk.ui.d.o.a;

public class AsyncTextView extends TextView implements Runnable {
    private Context context;
    public int hER;
    public String nLu;
    public boolean nLv;
    public String nLw;
    public a nLx;
    public boolean nLy;
    public String userName;

    public AsyncTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
    }

    public AsyncTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    public void run() {
        if (getTag() instanceof String) {
            String str = (String) getTag();
            if (str != null && str.equals(this.userName)) {
                return;
            }
        }
        int i = this.hER == 11 ? 3 : 2;
        o oVar = new o(new com.tencent.mm.plugin.sns.data.a(this.nLv, this.userName, this.nLw, 1), this.nLx, i);
        Context context = getContext();
        CharSequence charSequence = this.nLu;
        getTextSize();
        k kVar = new k(j.b(context, charSequence, i));
        kVar.a(oVar, this.nLu, 0);
        setText(kVar, BufferType.SPANNABLE);
        setTag(this.userName);
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            return -1;
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }
}
