package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout;

public class WebViewKeyboardLinearLayout extends KeyboardLinearLayout {
    private boolean mHasInit = false;
    private int mHeight;
    private boolean pWR;
    private int pWS;
    private int pWT;
    private int pWU;

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public WebViewKeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    protected final void AG(int i) {
        x.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout : b: " + i + " mHasInit: " + this.mHasInit + " mHasKeyboard: " + this.pWR);
        Rect rect = new Rect();
        getWindowVisibleDisplayFrame(rect);
        int height = getRootView().getHeight();
        if (!this.mHasInit) {
            this.mHasInit = true;
            this.mHeight = i;
            x.i("MicroMsg.WebViewKeyboardLinearLayout", "init height:%d", new Object[]{Integer.valueOf(this.mHeight)});
            qN(-1);
            this.pWU = height - rect.bottom;
        }
        x.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, current rect = %s", new Object[]{rect.toString()});
        height = rect.height();
        this.mHeight = height;
        x.d("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, usableHeightNow = %d, previousUsableHeight = %d", new Object[]{Integer.valueOf(height), Integer.valueOf(this.pWS)});
        if (this.pWS != height) {
            int height2 = (getRootView().getHeight() - this.pWU) - rect.top;
            int i2 = height2 - height;
            if (i2 > height2 / 4) {
                this.pWR = true;
                this.pWT = i2;
                qN(-3);
                x.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, show keyboard!! mHeight: " + this.mHeight + " b: " + i + " mKBHeight: " + this.pWT);
            } else {
                this.pWR = false;
                qN(-2);
                x.w("MicroMsg.WebViewKeyboardLinearLayout", "onLayout, hide keyboard!! mHeight: " + this.mHeight + " b: " + i);
            }
            this.pWS = height;
        }
    }

    public final int getKeyBoardHeight() {
        return this.pWT;
    }
}
