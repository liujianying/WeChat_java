package com.tencent.mm.ui.statusbar;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Build.VERSION;
import android.view.Window;
import android.widget.FrameLayout;
import com.tencent.mm.ui.statusbar.c.a;

public class b extends FrameLayout implements a {
    static final boolean uuP = c.uuT;
    private final Paint cN;
    private int gwO;
    private final Activity mActivity;
    private int uuQ;
    private int uuR;
    private boolean uuS = false;

    public final void lH(int i) {
        Ge(i);
    }

    public final void dl(boolean z) {
        this.uuS = z;
        Ge(this.gwO);
    }

    public b(Context context) {
        super(context);
        if (uuP) {
            this.mActivity = d.cJ(context);
            c.ab(this.mActivity).a(this);
            this.cN = new Paint(1);
            this.cN.setStyle(Style.FILL);
            setWillNotDraw(false);
            return;
        }
        this.mActivity = null;
        this.cN = null;
    }

    private void Ge(int i) {
        this.gwO = Math.max(0, i);
        setPadding(0, this.uuS ? 0 : this.gwO, 0, 0);
        postInvalidate();
    }

    public void setStatusBarColor(int i) {
        if (uuP) {
            ar(i, d.c(this.mActivity.getWindow()));
        }
    }

    public final void ar(int i, boolean z) {
        int i2 = 0;
        this.uuQ = i;
        if (uuP) {
            b bVar;
            b bVar2;
            Window window = this.mActivity.getWindow();
            d.a(window);
            if (VERSION.SDK_INT < 23 || !d.a(window, z)) {
                if (VERSION.SDK_INT >= 21) {
                    if (z) {
                        i = d.AD(i);
                    }
                    this.uuQ = i;
                    if (z) {
                        i2 = Color.argb(51, 0, 0, 0);
                        bVar = this;
                        bVar.uuR = i2;
                    } else {
                        bVar2 = this;
                    }
                }
                postInvalidate();
            }
            this.uuQ = i;
            bVar2 = this;
            bVar = bVar2;
            bVar.uuR = i2;
            postInvalidate();
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        if (this.gwO > 0 && uuP && !this.uuS) {
            this.cN.setColor(this.uuQ);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.gwO, this.cN);
        }
        super.dispatchDraw(canvas);
        if (this.gwO > 0 && uuP && this.uuS) {
            this.cN.setColor(this.uuR);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) this.gwO, this.cN);
        }
    }
}
