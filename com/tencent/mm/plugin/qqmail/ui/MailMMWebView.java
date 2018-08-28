package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.plugin.webview.ui.tools.widget.MMWebViewWithJsApi;

public class MailMMWebView extends MMWebViewWithJsApi {
    private float fto;
    private float ftp;
    boolean mhB;
    private View mhC;
    private View mhD;
    private boolean mhE;
    private boolean mhF;

    public MailMMWebView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MailMMWebView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.mhB = true;
        super.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int webScrollY = getWebScrollY();
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.fto = x;
                this.ftp = y;
                if (this.mhC == null || ((int) this.ftp) >= getVisibleTitleBarHeight()) {
                    if (this.mhD != null && this.mhD.getVisibility() == 0 && this.ftp + ((float) getBottomHeight()) > ((float) getHeight())) {
                        this.mhF = true;
                        break;
                    }
                }
                this.mhE = true;
                break;
                break;
            case 2:
                if (Math.abs(y - this.ftp) > 50.0f && this.mhE) {
                    motionEvent.setAction(3);
                    motionEvent.setLocation(this.fto, this.ftp + ((float) webScrollY));
                    this.mhC.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(0);
                    motionEvent.setLocation(this.fto, this.ftp);
                    super.dispatchTouchEvent(motionEvent);
                    motionEvent.setAction(2);
                    motionEvent.setLocation(x, y);
                    break;
                }
        }
        if (this.mhE && this.mhC != null) {
            motionEvent.setLocation(x, y + ((float) webScrollY));
            return this.mhC.dispatchTouchEvent(motionEvent);
        } else if (!this.mhF || this.mhD == null) {
            return super.dispatchTouchEvent(motionEvent);
        } else {
            motionEvent.setLocation(x, (y + ((float) getBottomHeight())) - ((float) getHeight()));
            return this.mhD.dispatchTouchEvent(motionEvent);
        }
    }

    public void onWebViewScrollChanged(int i, int i2, int i3, int i4) {
        int contentHeight = (int) (((float) getContentHeight()) * getScale());
        int height = getHeight() + i2;
        super.onWebViewScrollChanged(i, i2, i3, i4);
        invalidate();
        if (contentHeight - height < getBottomHeight()) {
            if (Math.abs(contentHeight - height) > 20) {
                bpe();
                hj(false);
            } else {
                hj(true);
            }
        }
        if (getVisibleTitleHeight() == 0) {
            bpd();
        }
    }

    public void setEmbeddedTitleBarCompat(View view) {
        setEmbeddedTitleBarSinceJellyBean(view);
    }

    public int computeVerticalScrollExtent() {
        return getViewHeightWithTitleBar() - getVisibleTitleBarHeight();
    }

    public int computeVerticalScrollOffset() {
        return Math.max(getWebScrollY() - getTitleHeight(), 0);
    }

    public int getVisibleTitleBarHeight() {
        return Math.max(getTitleHeight() - getWebScrollY(), 0);
    }

    protected boolean drawChild(Canvas canvas, View view, long j) {
        if (view != this.mhC) {
            return super.drawChild(canvas, view, j);
        }
        int webScrollY = getWebScrollY();
        canvas.save();
        canvas.translate(0.0f, (float) (-webScrollY));
        boolean drawChild = super.drawChild(canvas, view, j);
        canvas.restore();
        return drawChild;
    }

    public int getTitleHeight() {
        if (this.mhC != null) {
            return this.mhC.getHeight();
        }
        return 0;
    }

    public int getBottomHeight() {
        if (this.mhD != null) {
            return this.mhD.getHeight();
        }
        return 0;
    }

    public final void bpd() {
        evaluateJavascript("javascript:_updateTitleBarHeight(" + ((int) (((float) getTitleHeight()) / getScale())) + ");", null);
    }

    public final void bpe() {
        evaluateJavascript("javascript:_updateBottomBarHeight(" + ((int) (((float) getBottomHeight()) / getScale())) + ");", null);
    }

    private int getViewHeightWithTitleBar() {
        int height = getHeight();
        if (!isHorizontalScrollBarEnabled() || overlayHorizontalScrollbar()) {
            return height;
        }
        return height - getHorizontalScrollbarHeight();
    }

    private void setEmbeddedTitleBarSinceJellyBean(View view) {
        if (view != null) {
            if (this.mhC != null) {
                removeView(this.mhC);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            this.mhC = new a(this, getContext());
            ((a) this.mhC).addView(view, new FrameLayout.LayoutParams(-1, -2));
            this.mhC.setBackgroundColor(-1);
            addView(this.mhC, layoutParams);
        }
    }

    public final void hj(boolean z) {
        if (this.mhD == null) {
            return;
        }
        if (z) {
            this.mhD.setVisibility(0);
        } else {
            this.mhD.setVisibility(4);
        }
    }

    public void setEmbeddedBottomBar(View view) {
        if (view != null) {
            if (this.mhD != null) {
                removeView(this.mhD);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 80);
            this.mhD = new a(this, getContext());
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) view.getLayoutParams();
            LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.setMargins(layoutParams2.leftMargin, layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            ((a) this.mhD).addView(view, layoutParams3);
            addView(this.mhD, layoutParams);
            this.mhD.setVisibility(4);
        }
    }
}
