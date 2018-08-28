package com.tencent.mm.ui.contact;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.tencent.mm.ui.base.MMTagPanelScrollView;
import com.tencent.smtt.sdk.WebView;

public class LabelContainerView extends MMTagPanelScrollView {
    float uA;
    float uB;
    float uC;
    float uD;
    private int ug;
    boolean ujN = false;
    boolean ujO = true;
    boolean ujP = false;
    float ujQ;
    float ujR;
    float ujS;
    float ujT;
    private a ujU;
    boolean uv = true;

    public LabelContainerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cyo();
    }

    public LabelContainerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cyo();
    }

    public void setOnLabelContainerListener(a aVar) {
        this.ujU = aVar;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = (action & WebView.NORMAL_MODE_ALPHA) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.ujO = true;
                this.ujR = f2;
                this.ujQ = f2;
                this.ujT = f3;
                this.ujS = f3;
                this.ujP = true;
                break;
            case 1:
            case 3:
                this.ujO = true;
                this.ujP = false;
                break;
            case 2:
                int i2 = (int) (f2 - this.ujQ);
                actionIndex = (int) (f3 - this.ujS);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.ug) {
                    this.ujO = false;
                    return true;
                }
                break;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    private void cyo() {
        int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        this.ug = scaledTouchSlop * scaledTouchSlop;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        boolean z = (action & WebView.NORMAL_MODE_ALPHA) == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float f = 0.0f;
        float f2 = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            if (actionIndex != i) {
                f2 += motionEvent.getX(i);
                f += motionEvent.getY(i);
            }
        }
        actionIndex = z ? pointerCount - 1 : pointerCount;
        f2 /= (float) actionIndex;
        float f3 = f / ((float) actionIndex);
        switch (action) {
            case 0:
                this.uv = true;
                this.uA = f2;
                this.uC = f2;
                this.uB = f3;
                this.uD = f3;
                this.ujN = true;
                break;
            case 1:
            case 3:
                if ((this.uv || !this.ujN) && this.ujU != null) {
                    this.ujU.aGr();
                }
                this.uv = true;
                this.ujN = false;
                break;
            case 2:
                if (!this.ujN) {
                    this.uv = true;
                    this.uA = f2;
                    this.uC = f2;
                    this.uB = f3;
                    this.uD = f3;
                    this.ujN = true;
                }
                if (this.ujU != null) {
                    this.ujU.aGs();
                }
                int i2 = (int) (f2 - this.uC);
                actionIndex = (int) (f3 - this.uD);
                if ((actionIndex * actionIndex) + (i2 * i2) > this.ug) {
                    this.uv = false;
                    break;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }
}
