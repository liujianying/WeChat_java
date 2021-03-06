package com.tencent.mm.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.test.suitebuilder.annotation.Suppress;
import android.text.Spannable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.sdk.platformtools.x;

public class MMTextView extends TextView {
    private long cYP = -1;
    private b uHg = null;
    private boolean uHh = false;
    private boolean uHi = false;
    private boolean uHj = false;
    private a uHk = null;
    private boolean uem = false;
    private GestureDetector uen = null;

    public void setMsgId(long j) {
        this.cYP = j;
    }

    public MMTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public MMTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void setMMTextViewCallBack(a aVar) {
        if (!this.uHj && aVar != null) {
            this.uHk = aVar;
            this.uHj = true;
        }
    }

    public void setIsFromChatting(boolean z) {
        if (!this.uHh) {
            this.uHh = z;
        }
    }

    private void init() {
        this.uen = new GestureDetector(getContext(), new 1(this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = action == 1 && this.uem;
        if (z) {
            x.d("MicroMsg.MMTextView", "ignore Action Up Event this time");
            return true;
        }
        boolean z2;
        if (action == 0) {
            this.uem = false;
        }
        if (this.uHg == null || this.uen == null) {
            z2 = false;
        } else {
            z2 = this.uen.onTouchEvent(motionEvent);
        }
        if (z2) {
            return z2;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setOnDoubleClickLitsener(b bVar) {
        this.uHg = bVar;
    }

    public void setTextInternal(CharSequence charSequence) {
        this.uHi = true;
        setText(charSequence);
    }

    @Suppress
    public void setText(CharSequence charSequence, BufferType bufferType) {
        super.setText(charSequence, bufferType);
        if (this.uHk != null && this.uHh && (charSequence instanceof Spannable) && ((Spannable) charSequence).getSpans(0, charSequence.length(), Object.class) != null) {
            this.uHk.a(charSequence, this.cYP);
        }
        this.uHi = false;
    }

    public void cancelLongPress() {
        x.d("MicroMsg.MMTextView", "cancelLongPress , should ignore Action Up Event next time");
        this.uem = true;
        super.cancelLongPress();
    }

    public boolean performLongClick() {
        x.d("MicroMsg.MMTextView", "performLongClick , should ignore Action Up Event next time");
        this.uem = true;
        return super.performLongClick();
    }

    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    protected void onDraw(Canvas canvas) {
        try {
            super.onDraw(canvas);
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
        }
    }

    public boolean onPreDraw() {
        try {
            return super.onPreDraw();
        } catch (Throwable th) {
            return true;
        }
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.MMTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
