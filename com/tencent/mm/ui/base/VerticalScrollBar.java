package com.tencent.mm.ui.base;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.w.a.f;
import com.tencent.mm.w.a.g;
import com.tencent.mm.w.a.k;

public abstract class VerticalScrollBar extends View {
    private int atr;
    private float duz;
    private Paint fBa;
    public float kuU;
    public int kuV;
    public String[] kuW;
    private float kuX = 0.0f;
    private float kuY;
    private o kuZ;
    private TextView kva;
    private int kvb;
    public a tBm;

    public abstract void aAV();

    public abstract int getToastLayoutId();

    public VerticalScrollBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        aAV();
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.kvb = b.b(context, 3.0f);
        View inflate = inflate(context, getToastLayoutId(), null);
        int b = b.b(context, (float) this.kuV);
        this.kuZ = new o(inflate, b, b);
        this.kva = (TextView) inflate.findViewById(g.show_head_toast_text);
        this.fBa = new Paint();
        this.fBa.setAntiAlias(true);
        this.fBa.setColor(-11119018);
        this.fBa.setTextAlign(Align.CENTER);
    }

    public void setOnScrollBarTouchListener(a aVar) {
        this.tBm = aVar;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        this.duz = ((float) measuredHeight) / (((float) this.kuW.length) * this.kuU);
        this.fBa.setTextSize(this.duz);
        if (this.kuX != this.duz) {
            this.kuX = this.duz;
            post(new 1(this, measuredWidth, measuredHeight));
        }
        for (measuredHeight = 0; measuredHeight < this.kuW.length; measuredHeight++) {
            canvas.drawText(this.kuW[measuredHeight], ((float) measuredWidth) / 2.0f, this.duz + ((((float) measuredHeight) * this.duz) * this.kuU), this.fBa);
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
            setBackgroundDrawable(a.f(getContext(), f.scrollbar_bg));
            int i = (int) (this.kuY / (this.duz * this.kuU));
            if (i >= this.kuW.length) {
                i = this.kuW.length - 1;
            }
            this.atr = i;
            if (this.atr == -1) {
                this.kva.setText(k.scroll_bar_search);
            } else {
                this.kva.setText(this.kuW[this.atr]);
            }
            this.kuZ.showAtLocation(this, 17, 0, 0);
            if (this.tBm != null) {
                if (this.atr == -1) {
                    this.tBm.ys(a.af(getContext(), k.scroll_bar_search));
                } else {
                    this.tBm.ys(this.kuW[this.atr]);
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
