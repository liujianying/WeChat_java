package com.tencent.mm.plugin.webview.ui.tools;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.xweb.WebView;

public class LogoWebViewWrapper extends LinearLayout {
    private Context context;
    private int fW;
    WebView hNb;
    private boolean pVA = false;
    private boolean pVB = false;
    private boolean pVC = false;
    private int pVD = -1;
    FrameLayout pVp;
    private boolean pVq = false;
    private int pVr;
    private int pVs;
    private c pVt;
    private int pVu = 0;
    boolean pVv = false;
    private boolean pVw = false;
    private int pVx = 0;
    a pVy;
    b pVz;
    private int startY;

    public interface b {
        void Y(int i, boolean z);
    }

    public LogoWebViewWrapper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
        init();
    }

    @TargetApi(11)
    public LogoWebViewWrapper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.context = context;
        init();
    }

    public void setReleaseTargetHeight(int i) {
        this.pVx = i;
    }

    private void init() {
        setOrientation(1);
        this.fW = ViewConfiguration.get(this.context).getScaledTouchSlop();
    }

    public void setFastScrollBack(boolean z) {
        this.pVw = z;
    }

    public FrameLayout getWebViewContainer() {
        if (this.pVp == null) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if ((childAt instanceof FrameLayout) && childAt.getId() == R.h.logo_wv_container) {
                    this.pVp = (FrameLayout) childAt;
                    break;
                }
            }
        }
        return this.pVp;
    }

    public WebView getWebView() {
        return this.hNb;
    }

    public final void jY(boolean z) {
        this.pVv = z;
        if (this.pVv) {
            this.pVq = false;
            this.pVu = 0;
        }
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.pVv && !this.pVA) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 3 || action == 1) {
            this.pVq = false;
            this.pVu = 0;
            this.pVB = false;
            return false;
        } else if (action == 2 && this.pVq) {
            return true;
        } else {
            switch (action) {
                case 0:
                    if (this.hNb.isOverScrollStart()) {
                        this.pVr = (int) motionEvent.getY();
                        this.startY = (int) motionEvent.getY();
                        this.pVs = (int) motionEvent.getX();
                        this.pVq = false;
                        this.pVu = 0;
                        this.pVA = true;
                        this.pVB = true;
                        break;
                    }
                    break;
                case 2:
                    if (this.hNb.isOverScrollStart()) {
                        if (this.pVB) {
                            action = (int) motionEvent.getY();
                            int x = (int) motionEvent.getX();
                            int i = action - this.pVr;
                            int i2 = x - this.pVs;
                            if (Math.abs(i) > this.fW && Math.abs(i) > Math.abs(i2) && i > 0) {
                                this.pVr = action;
                                this.pVs = x;
                                if (this.pVu != 1) {
                                    this.pVu++;
                                    break;
                                }
                                this.pVq = true;
                                this.pVB = false;
                                x.i("MicroMsg.LogoWebViewWrapper", "Competitor wins in onTouchEvent");
                                if (this.pVy != null) {
                                    this.pVy.bVF();
                                    break;
                                }
                            }
                        }
                        this.pVr = (int) motionEvent.getY();
                        this.startY = (int) motionEvent.getY();
                        this.pVs = (int) motionEvent.getX();
                        this.pVq = false;
                        this.pVu = 0;
                        this.pVA = true;
                        this.pVB = true;
                        return this.pVq;
                    }
                    break;
            }
            return this.pVq;
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.pVv && !this.pVA) {
            return false;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.pVA = true;
                if (!this.hNb.isOverScrollStart()) {
                    return false;
                }
                this.pVr = (int) motionEvent.getY();
                this.startY = (int) motionEvent.getY();
                this.pVs = (int) motionEvent.getX();
                this.pVC = true;
                return true;
            case 1:
            case 3:
                this.pVC = false;
                if (!this.pVq && !this.pVA) {
                    return false;
                }
                this.pVq = false;
                P(-this.pVx, getScrollBackDuration());
                post(new 1(this));
                return true;
            case 2:
                if (!this.pVq) {
                    return false;
                }
                if (this.pVC) {
                    this.pVr = (int) motionEvent.getY();
                    this.pVs = (int) motionEvent.getX();
                    int min = Math.min(this.startY - this.pVr, 0) >> 1;
                    int overScrollDistance = getOverScrollDistance();
                    int sqrt = ((int) Math.sqrt((double) ((getLogoHeight() >> 1) * Math.abs(min)))) << 1;
                    if (sqrt <= Math.abs(min)) {
                        min = -sqrt;
                    } else if (Math.abs(min) > overScrollDistance) {
                        min = -overScrollDistance;
                    }
                    AB(min);
                    if (this.pVz != null) {
                        this.pVz.Y(min, true);
                    }
                    return true;
                }
                this.pVr = (int) motionEvent.getY();
                this.startY = (int) motionEvent.getY();
                this.pVs = (int) motionEvent.getX();
                this.pVC = true;
                return true;
            default:
                return false;
        }
    }

    private long getScrollBackDuration() {
        long abs = (long) Math.abs(getScrollY());
        long abs2 = Math.abs(abs - ((long) Math.abs(this.pVx)));
        if (abs2 >= abs) {
            return 300;
        }
        return (long) ((((float) abs2) / ((float) abs)) * 300.0f);
    }

    private int getLogoHeight() {
        if (this.pVD < 0) {
            this.pVD = (int) TypedValue.applyDimension(1, 60.0f, this.context.getResources().getDisplayMetrics());
        }
        return this.pVD;
    }

    private int getOverScrollDistance() {
        return getHeight();
    }

    public final void AB(int i) {
        int overScrollDistance = getOverScrollDistance();
        scrollTo(0, Math.min(overScrollDistance, Math.max(-overScrollDistance, i)));
    }

    public final void P(int i, long j) {
        if (this.pVt != null) {
            c cVar = this.pVt;
            cVar.pVI = false;
            cVar.pVE.removeCallbacks(cVar);
        }
        int scrollY = getScrollY();
        x.i("MicroMsg.LogoWebViewWrapper", "smoothScrollTo oldScrollValue = %s, newScrollValue = %s", new Object[]{Integer.valueOf(scrollY), Integer.valueOf(i)});
        if (scrollY != i) {
            this.pVt = new c(this, scrollY, i, j);
            post(this.pVt);
        }
    }

    public void setMMOverScrollListener(a aVar) {
        this.pVy = aVar;
    }

    public void setMMOverScrollOffsetListener(b bVar) {
        this.pVz = bVar;
    }
}
