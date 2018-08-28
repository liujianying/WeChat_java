package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public class StaticTextView extends View implements a {
    protected g dui = new g(this, Fc());

    public StaticTextView(Context context) {
        super(context);
        this.dui.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.dui.init();
    }

    public StaticTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dui.init();
    }

    public a getConfig() {
        if (this.dui == null) {
            return null;
        }
        return this.dui.duk;
    }

    public a Fc() {
        return new a();
    }

    public void setConfig(a aVar) {
        this.dui.duk = aVar;
    }

    public void setTextSize(float f) {
        this.dui.setTextSize(0, f);
    }

    public final void setTextSize$255e752(float f) {
        this.dui.setTextSize(1, f);
    }

    public void setTextLayout(f fVar) {
        this.dui.setTextLayout(fVar);
    }

    public void setTextColor(int i) {
        this.dui.setTextColor(i);
    }

    public void setGravity(int i) {
        this.dui.setGravity(i);
    }

    public void setMaxLines(int i) {
        this.dui.setMaxLines(i);
    }

    public int getMaxLines() {
        return this.dui.getMaxLines();
    }

    public void setMinLines(int i) {
        this.dui.setMinLines(i);
    }

    public void setLines(int i) {
        this.dui.setLines(i);
    }

    public void setSingleLine(boolean z) {
        this.dui.setSingleLine(z);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        this.dui.setText(charSequence, z);
        setContentDescription(charSequence);
    }

    public void setText(CharSequence charSequence) {
        setText(charSequence, true);
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
        return this.dui.getText();
    }

    public float getTextSize() {
        return this.dui.getTextSize();
    }

    public int getTextColor() {
        return this.dui.getTextColor();
    }

    public Layout getTvLayout() {
        return this.dui.getTvLayout();
    }

    public f getLayoutWrapper() {
        if (this.dui == null) {
            return null;
        }
        return this.dui.getLayoutWrapper();
    }

    public int getLineCount() {
        return this.dui.getLineCount();
    }

    public int getLineHeight() {
        return this.dui.getLineHeight();
    }

    public int getSelectionStart() {
        return this.dui.getSelectionStart();
    }

    public int getSelectionEnd() {
        return this.dui.getSelectionEnd();
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
        super.onDraw(canvas);
        if (this.dui != null) {
            this.dui.onDraw(canvas);
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

    public void onMeasure(int i, int i2) {
        if (this.dui == null) {
            super.onMeasure(i, i2);
            return;
        }
        Point aX = this.dui.aX(i, i2);
        if (aX != null) {
            setMeasuredDimension(aX.x, aX.y);
        } else {
            super.onMeasure(i, i2);
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

    public int getOrientation() {
        int i = getResources().getConfiguration().orientation;
        x.i("MicroMsg.StaticTextView", "test test getOrientation " + i);
        return i;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        if (!bi.K(getText())) {
            accessibilityEvent.getText().add(getText());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (!bi.K(getText())) {
            accessibilityNodeInfo.addAction(256);
            accessibilityNodeInfo.addAction(512);
            accessibilityNodeInfo.setMovementGranularities(31);
            if (d.fR(18)) {
                accessibilityNodeInfo.addAction(131072);
            }
        }
        if (isFocused() && d.fR(18)) {
            accessibilityNodeInfo.addAction(16384);
            accessibilityNodeInfo.addAction(32768);
            accessibilityNodeInfo.addAction(65536);
        }
        if (d.fR(19) && this.dui.getMaxLines() > 1) {
            accessibilityNodeInfo.setMultiLine(true);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 8192) {
            accessibilityEvent.setFromIndex(Selection.getSelectionStart(getText()));
            accessibilityEvent.setToIndex(Selection.getSelectionEnd(getText()));
            if (!bi.K(getText())) {
                accessibilityEvent.setItemCount(getText().length());
            }
        }
    }
}
