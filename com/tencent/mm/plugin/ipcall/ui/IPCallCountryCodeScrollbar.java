package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.ui.base.o;

public class IPCallCountryCodeScrollbar extends View {
    public static final String[] kuT = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    private int atr;
    private float duz;
    private Paint fBa;
    protected float kuU = 1.3f;
    protected int kuV = 79;
    protected String[] kuW = new String[]{"↑"};
    private float kuX = 0.0f;
    private float kuY;
    private o kuZ;
    private TextView kva;
    private int kvb;
    private a kvc;

    public final void Fc(String str) {
        Object str2;
        Object obj = null;
        for (String equals : kuT) {
            if (equals.equals(str2)) {
                obj = 1;
            }
        }
        if (obj == null) {
            str2 = "#";
        }
        int length = this.kuW.length + 1;
        String[] strArr = new String[length];
        String[] strArr2 = this.kuW;
        int length2 = strArr2.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            String str3 = strArr2[i];
            if (!str3.equals(str2)) {
                strArr[i2] = str3;
                i++;
                i2++;
            } else {
                return;
            }
        }
        strArr[length - 1] = str2;
        this.kuW = strArr;
    }

    protected int getToastLayoutId() {
        return R.i.show_head_toast;
    }

    public IPCallCountryCodeScrollbar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.kvb = b.b(context, 3.0f);
        View inflate = inflate(context, getToastLayoutId(), null);
        int b = b.b(context, (float) this.kuV);
        this.kuZ = new o(inflate, b, b);
        this.kva = (TextView) inflate.findViewById(R.h.show_head_toast_text);
        this.fBa = new Paint();
        this.fBa.setAntiAlias(true);
        this.fBa.setColor(-11119018);
        this.fBa.setTextAlign(Align.CENTER);
    }

    public void setOnScrollBarTouchListener(a aVar) {
        this.kvc = aVar;
    }

    protected void onDraw(Canvas canvas) {
        int i = 0;
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.duz = ((float) measuredHeight) / (((float) this.kuW.length) * this.kuU);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.f.NormalTextSize);
        if (this.duz > ((float) dimensionPixelSize)) {
            this.duz = (float) dimensionPixelSize;
        }
        this.fBa.setTextSize(this.duz);
        if (this.kuX != this.duz) {
            this.kuX = this.duz;
            post(new 1(this, measuredWidth, measuredHeight));
        }
        if (this.duz == ((float) dimensionPixelSize)) {
            float length = (((float) measuredHeight) - ((((float) this.kuW.length) * this.duz) * this.kuU)) / 2.0f;
            while (i < this.kuW.length) {
                canvas.drawText(this.kuW[i], ((float) measuredWidth) / 2.0f, (this.duz + length) + ((((float) i) * this.duz) * this.kuU), this.fBa);
                i++;
            }
            return;
        }
        while (i < this.kuW.length) {
            canvas.drawText(this.kuW[i], ((float) measuredWidth) / 2.0f, this.duz + ((((float) i) * this.duz) * this.kuU), this.fBa);
            i++;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 || motionEvent.getAction() == 2) {
            this.kuY = motionEvent.getY();
            if (this.kuY < 0.0f) {
                this.kuY = 0.0f;
            }
            if (this.kuY > ((float) getMeasuredHeight())) {
                this.kuY = (float) getMeasuredHeight();
            }
            setBackgroundDrawable(a.f(getContext(), R.g.scrollbar_bg));
            float f = this.duz * this.kuU;
            int measuredHeight = (int) ((this.kuY - ((((float) getMeasuredHeight()) - (((float) this.kuW.length) * f)) / 2.0f)) / f);
            if (measuredHeight < 0) {
                measuredHeight = 0;
            }
            if (measuredHeight >= this.kuW.length) {
                measuredHeight = this.kuW.length - 1;
            }
            this.atr = measuredHeight;
            if (this.atr == -1) {
                this.kva.setText(R.l.scroll_bar_search);
            } else {
                this.kva.setText(this.kuW[this.atr]);
            }
            this.kuZ.showAtLocation(this, 17, 0, 0);
            if (this.kvc != null) {
                if (this.atr == -1) {
                    this.kvc.ys(a.af(getContext(), R.l.scroll_bar_search));
                } else {
                    this.kvc.ys(this.kuW[this.atr]);
                }
            }
            invalidate();
        }
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
            setBackgroundResource(0);
            this.kuZ.dismiss();
        }
        return true;
    }
}
