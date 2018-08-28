package com.tencent.mm.plugin.appbrand.widget.e;

import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.appbrand.q.f;

public final class c extends LinearLayout {
    public static final int gMp = Color.parseColor("#000000");
    public static final int gMq = Color.parseColor("#000000");
    private TextView eGX;

    public c(Context context) {
        super(context);
        setLayoutParams(new LayoutParams(-2, -2));
        setOrientation(1);
        setGravity(17);
        this.eGX = new TextView(context);
        this.eGX.setLayoutParams(new LayoutParams(-2, -2));
        addView(this.eGX);
        int lP = f.lP(3);
        setPadding(lP, lP, lP, lP);
    }

    public final void setText(String str) {
        this.eGX.setText(str);
    }

    public final void setTextSize(int i) {
        this.eGX.setTextSize((float) i);
    }

    public final void setTextColor(int i) {
        this.eGX.setTextColor(i);
    }

    public final void setTitlePadding(int i) {
        this.eGX.setPadding(i, i, i, i);
    }

    public final void setGravity(String str) {
        if (str.equals("left")) {
            this.eGX.setGravity(3);
        } else if (str.equals("right")) {
            this.eGX.setGravity(5);
        } else {
            str.equals("center");
            this.eGX.setGravity(17);
        }
    }

    public final void ca(int i, int i2) {
        b bVar = new b();
        bVar.Tl = (float) i;
        bVar.cN.setColor(i2);
        setBackgroundDrawable(bVar);
    }
}
