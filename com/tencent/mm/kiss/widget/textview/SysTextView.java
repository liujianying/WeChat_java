package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStructure;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.reflect.Field;

public class SysTextView extends TextView implements a {
    private static boolean duw = false;
    private static Field dux = null;
    private g dui = new g(this, new a());

    public SysTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SysTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        super.setText(" ", BufferType.SPANNABLE);
        this.dui.duk = new a();
        this.dui.duk.textColor = super.getTextColors().getDefaultColor();
        this.dui.duk.dtW = super.getEllipsize();
        this.dui.duk.gravity = super.getGravity();
        this.dui.duk.duz = super.getTextSize();
        if (!duw) {
            try {
                if (dux == null) {
                    Field declaredField = TextView.class.getDeclaredField("mSingleLine");
                    dux = declaredField;
                    declaredField.setAccessible(true);
                }
                if (dux.getBoolean(this)) {
                    this.dui.duk.maxLines = 1;
                }
            } catch (Exception e) {
                x.e("MicroMsg.SysPLTextView", "initSingleLine error: %s", e.getMessage());
                duw = true;
            }
        }
    }

    protected f getLayoutWrapper() {
        if (this.dui == null) {
            return null;
        }
        return this.dui.getLayoutWrapper();
    }

    public a getConfig() {
        if (this.dui == null) {
            return null;
        }
        return this.dui.duk;
    }

    public void setSingleLine(boolean z) {
        if (this.dui != null) {
            this.dui.setSingleLine(z);
        }
    }

    public void setLines(int i) {
        if (this.dui != null) {
            this.dui.setLines(i);
        }
    }

    public boolean onPreDraw() {
        return true;
    }

    public void setText(CharSequence charSequence, BufferType bufferType) {
        setText$609c24db(charSequence);
    }

    public final void setText$609c24db(CharSequence charSequence) {
        if (this.dui == null) {
            super.setText("");
        } else {
            this.dui.setText(charSequence, false);
        }
    }

    public void setTextSize(float f) {
        setTextSize(0, f);
    }

    public void setTextSize(int i, float f) {
        if (this.dui != null) {
            this.dui.setTextSize(i, f);
        }
    }

    public void setTextLayout(f fVar) {
        if (this.dui != null) {
            this.dui.setTextLayout(fVar);
        }
    }

    public void setTextColor(int i) {
        if (this.dui != null) {
            this.dui.setTextColor(i);
        }
    }

    public void setGravity(int i) {
        if (this.dui != null) {
            this.dui.setGravity(i);
        }
    }

    public void setMaxLines(int i) {
        if (this.dui != null) {
            this.dui.setMaxLines(i);
        }
    }

    public void setMinLines(int i) {
        if (this.dui != null) {
            this.dui.setMinLines(i);
        }
    }

    public void setLayoutParams(LayoutParams layoutParams) {
        if (this.dui != null) {
            this.dui.Fd();
        }
        super.setLayoutParams(layoutParams);
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.dui != null) {
            this.dui.Fd();
        }
        super.setPadding(i, i2, i3, i4);
    }

    public CharSequence getText() {
        if (this.dui == null) {
            return null;
        }
        return this.dui.getText();
    }

    public float getTextSize() {
        if (this.dui == null) {
            return 0.0f;
        }
        return this.dui.getTextSize();
    }

    public int getTextColor() {
        return this.dui.getTextColor();
    }

    public Layout getTvLayout() {
        return this.dui.getTvLayout();
    }

    public int getLineCount() {
        if (this.dui == null) {
            return 0;
        }
        return this.dui.getLineCount();
    }

    public int getLineHeight() {
        if (this.dui == null) {
            return 0;
        }
        return this.dui.getLineHeight();
    }

    public int getSelectionStart() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionStart(getText());
    }

    public int getSelectionEnd() {
        if (getText() == null) {
            return -1;
        }
        return Selection.getSelectionEnd(getText());
    }

    public void setHandleClickableSpan(boolean z) {
        this.dui.dur = z;
    }

    public void setClickable(boolean z) {
        super.setClickable(z);
        if (this.dui != null) {
            this.dui.duq = z;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (getTvLayout() == null) {
            return false;
        }
        boolean v = this.dui.v(motionEvent);
        boolean onTouchEvent = super.onTouchEvent(motionEvent);
        if (v) {
            return true;
        }
        return onTouchEvent;
    }

    public boolean performClick() {
        if (this.dui != null && this.dui.performClick()) {
            return super.performClick();
        }
        return false;
    }

    protected void onDraw(Canvas canvas) {
        try {
            if (this.dui != null) {
                this.dui.onDraw(canvas);
            }
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
        }
    }

    public int getHorizontalDrawOffset() {
        if (this.dui == null) {
            return 0;
        }
        return this.dui.dun;
    }

    public int getVerticalDrawOffset() {
        if (this.dui == null) {
            return 0;
        }
        return this.dui.duo;
    }

    protected void onMeasure(int i, int i2) {
        try {
            Point aX = this.dui.aX(i, i2);
            if (aX != null) {
                setMeasuredDimension(aX.x, aX.y);
            } else {
                super.onMeasure(i, i2);
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e, "onMeasure error: %s", e.getMessage());
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e2, "", new Object[0]);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
    }

    public void onHoverChanged(boolean z) {
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        return false;
    }

    public void onProvideStructure(ViewStructure viewStructure) {
        try {
            super.onProvideStructure(viewStructure);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", e, "onProvideStructure error: %s", e.getMessage());
        }
    }

    public void dispatchProvideStructure(ViewStructure viewStructure) {
    }

    public int getBaseline() {
        try {
            return super.getBaseline();
        } catch (Throwable th) {
            x.printErrStackTrace("MicroMsg.SysPLTextView", th, "", new Object[0]);
            return -1;
        }
    }
}
