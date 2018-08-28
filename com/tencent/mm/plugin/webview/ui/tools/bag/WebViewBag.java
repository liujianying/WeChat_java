package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.plugin.webview.ui.tools.bag.WebViewBagBgView.1;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public class WebViewBag extends FrameLayout {
    private static final int qcb = (((com.tencent.mm.bp.a.fl(ad.getContext()) - b.qbk) - b.qbm) - b.qbn);
    private ImageView gER;
    View ido;
    private WindowManager inU;
    protected ag ioW;
    private OnClickListener mOnClickListener;
    private long mStartTime;
    private PointF oVD = new PointF();
    private Point oVE = new Point();
    private Point oVF = new Point();
    private Point oVG = new Point();
    private Point oVH;
    private Runnable oVI = new Runnable() {
        public final void run() {
            float currentTimeMillis = (((float) (System.currentTimeMillis() - WebViewBag.this.mStartTime)) * 1.0f) / 200.0f;
            if (currentTimeMillis <= 1.0f) {
                WebViewBag.this.ioW.postDelayed(WebViewBag.this.oVI, 5);
                WebViewBag.this.dW(WebViewBag.this.oVF.x + ((int) (((((float) WebViewBag.this.oVG.x) * 1.0f) - ((float) WebViewBag.this.oVF.x)) * currentTimeMillis)), ((int) (currentTimeMillis * ((((float) WebViewBag.this.oVG.y) * 1.0f) - ((float) WebViewBag.this.oVF.y)))) + WebViewBag.this.oVF.y);
                return;
            }
            WebViewBag.this.dW(WebViewBag.this.oVG.x, WebViewBag.this.oVG.y);
            WebViewBag.this.onAnimationEnd();
        }
    };
    private a qbY;
    private WebViewBagBgView qbZ;
    private boolean qca;

    public interface a {
        void el(int i, int i2);

        void onTouchEvent(MotionEvent motionEvent);
    }

    protected void onConfigurationChanged(Configuration configuration) {
        x.i("MicroMsg.WebViewBag", "onConfigurationChanged orientation:%d", new Object[]{Integer.valueOf(configuration.orientation)});
        this.oVH.x = com.tencent.mm.bp.a.fk(ad.getContext());
        this.oVH.y = com.tencent.mm.bp.a.fl(ad.getContext());
    }

    public WebViewBag(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.inU = (WindowManager) context.getSystemService("window");
        this.ioW = new ag();
        this.oVH = new Point(com.tencent.mm.bp.a.fk(ad.getContext()), com.tencent.mm.bp.a.fl(ad.getContext()));
        LayoutInflater.from(context).inflate(R.i.webview_bag, this);
        this.gER = (ImageView) findViewById(R.h.icon);
        this.qbZ = (WebViewBagBgView) findViewById(R.h.bg);
        this.ido = findViewById(R.h.root);
        this.qbZ.setStartColor(context.getResources().getColor(R.e.webview_bag_bg_color));
        this.qbZ.setAngryColor(context.getResources().getColor(R.e.webview_bag_bg_angry_color));
    }

    public final void bWT() {
        Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        Animation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        Animation animationSet = new AnimationSet(true);
        animationSet.addAnimation(alphaAnimation);
        animationSet.addAnimation(scaleAnimation);
        animationSet.setDuration(100);
        animationSet.restrictDuration(150);
        animationSet.setFillAfter(true);
        this.ido.startAnimation(animationSet);
    }

    public void setIcon(String str) {
        com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
        aVar.dXW = true;
        aVar.dXN = R.k.webview_bag_default_icon;
        o.Pj().a(str, this.gER, aVar.Pt());
    }

    public final void j(int i, int i2, long j) {
        WebViewBagBgView webViewBagBgView = this.qbZ;
        webViewBagBgView.qck = false;
        long currentTimeMillis = System.currentTimeMillis();
        x.i("MicroMsg.WebViewBagBgView", "setAngryInfo:%d now:%d", new Object[]{Long.valueOf(j), Long.valueOf(currentTimeMillis)});
        webViewBagBgView.mDuration = i;
        webViewBagBgView.ouh = i2;
        webViewBagBgView.mStartTime = j;
        webViewBagBgView.fE(currentTimeMillis);
        if (j > currentTimeMillis) {
            webViewBagBgView.postDelayed(new 1(webViewBagBgView), j - currentTimeMillis);
        } else {
            webViewBagBgView.qck = true;
        }
        webViewBagBgView.invalidate();
    }

    public void setListener(a aVar) {
        this.qbY = aVar;
    }

    public void setTouchEnable(boolean z) {
        x.i("MicroMsg.WebViewBag", "setTouchEnable enable:%b", new Object[]{Boolean.valueOf(z)});
        this.qca = z;
    }

    protected Point getLastTouchDownViewPos() {
        return this.oVE;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.qca) {
            return super.onTouchEvent(motionEvent);
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.oVD.x = motionEvent.getRawX();
                this.oVD.y = motionEvent.getRawY();
                LayoutParams layoutParams = (LayoutParams) getLayoutParams();
                this.oVE.x = layoutParams.x;
                this.oVE.y = layoutParams.y;
                break;
            case 1:
                if (Math.abs(motionEvent.getRawX() - this.oVD.x) < ((float) b.b(getContext(), 3.0f)) && Math.abs(motionEvent.getRawY() - this.oVD.y) < ((float) b.b(getContext(), 3.0f))) {
                    if (this.mOnClickListener != null) {
                        this.mOnClickListener.onClick(this);
                        break;
                    }
                }
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                this.oVF.x = (int) Math.max(Math.min((rawX + ((float) this.oVE.x)) - this.oVD.x, (float) this.oVH.x), 0.0f);
                this.oVF.y = (int) Math.max(Math.min((rawY + ((float) this.oVE.y)) - this.oVD.y, (float) this.oVH.y), 0.0f);
                if (this.oVF.x + (getWidth() / 2) <= this.oVH.x / 2) {
                    this.oVG.x = b.qbn;
                } else {
                    this.oVG.x = (this.oVH.x - getWidth()) - b.qbn;
                }
                this.oVG.y = this.oVF.y;
                if (this.oVG.y == 0) {
                    this.oVG.y = b.qbn;
                } else if (this.oVG.y > qcb) {
                    this.oVG.y = qcb;
                }
                this.mStartTime = System.currentTimeMillis();
                this.ioW.postDelayed(this.oVI, 5);
                if (this.qbY != null) {
                    this.qbY.el(this.oVG.x, this.oVG.y);
                    break;
                }
                break;
            case 2:
                dW((int) Math.max(Math.min((((float) this.oVE.x) + motionEvent.getRawX()) - this.oVD.x, (float) this.oVH.x), 0.0f), (int) Math.max(Math.min((((float) this.oVE.y) + motionEvent.getRawY()) - this.oVD.y, (float) this.oVH.y), 0.0f));
                break;
        }
        if (this.qbY != null) {
            this.qbY.onTouchEvent(motionEvent);
        }
        return true;
    }

    private void dW(int i, int i2) {
        if (this.inU != null) {
            LayoutParams layoutParams = (LayoutParams) getLayoutParams();
            layoutParams.x = i;
            layoutParams.y = i2;
            try {
                this.inU.updateViewLayout(this, layoutParams);
            } catch (Throwable th) {
                x.printErrStackTrace("MicroMsg.WebViewBag", th, "", new Object[0]);
            }
        }
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}
