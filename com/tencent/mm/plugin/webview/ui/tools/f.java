package com.tencent.mm.plugin.webview.ui.tools;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.LogoWebViewWrapper.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.MMWebView;

public final class f implements b {
    static final int pXi = R.g.webview_pulldown_refresh;
    private boolean YM = false;
    public boolean fpo = false;
    a pXe;
    ImageView pXf;
    LogoWebViewWrapper pXg;
    int pXh = 0;
    private boolean pXj = false;
    private int pXk = 0;
    private float pXl = 0.0f;
    private ValueAnimator pXm;
    private ViewPropertyAnimator pXn;
    private float pXo;
    private View pXp;
    View pXq;
    private TextView pXr;
    private boolean pXs = true;
    public boolean pXt = false;

    public final void da(View view) {
        String str;
        this.pXg = (LogoWebViewWrapper) view.findViewById(R.h.logo_web_view_wrapper);
        this.pXf = (ImageView) view.findViewById(R.h.webview_logo_refresh_iv);
        this.pXp = view.findViewById(R.h.webview_logo_container);
        if (this.pXp != null) {
            this.pXq = this.pXp.findViewById(R.h.x5_logo);
            this.pXr = (TextView) this.pXq.findViewById(R.h.x5_logo_url);
        }
        this.pXh = BackwardSupportUtil.b.b(this.pXg.getContext(), 72.0f);
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "refreshImage.id = %s, logoWrapper.id = %s";
        Object[] objArr = new Object[2];
        if (this.pXf == null) {
            str = "null";
        } else {
            str = String.valueOf(this.pXf.getId());
        }
        objArr[0] = str;
        if (this.pXg == null) {
            str = "null";
        } else {
            str = String.valueOf(this.pXg.getId());
        }
        objArr[1] = str;
        x.d(str2, str3, objArr);
        x.d("MicroMsg.WebViewPullDownLogoDelegate", "LOADING_LOGO_HEIGHT = %d", new Object[]{Integer.valueOf(this.pXh)});
    }

    public final void b(MMWebView mMWebView) {
        mMWebView.setCompetitorView(this.pXg);
        mMWebView.cAy();
        if (VERSION.SDK_INT <= 10) {
            this.pXg.getWebViewContainer().setBackgroundColor(this.pXg.getResources().getColor(R.e.webview_logo_bg_color));
        }
        LogoWebViewWrapper logoWebViewWrapper = this.pXg;
        logoWebViewWrapper.getWebViewContainer();
        if (logoWebViewWrapper.pVp != null) {
            logoWebViewWrapper.hNb = mMWebView;
            logoWebViewWrapper.pVp.addView(logoWebViewWrapper.hNb);
        }
        CharSequence charSequence = "";
        if (mMWebView.isXWalkKernel() || mMWebView.getIsX5Kernel()) {
            this.pXs = true;
        } else {
            this.pXs = false;
        }
        if (!(this.pXq == null || mMWebView.getIsX5Kernel())) {
            ((ImageView) this.pXq.findViewById(R.h.x5_logo_img)).setVisibility(8);
            ((TextView) this.pXq.findViewById(R.h.info_txt)).setText(charSequence);
        }
        if (!this.pXs || this.pXt) {
            jY(true);
            return;
        }
        jY(false);
        if (this.pXq != null) {
            this.pXq.setVisibility(0);
        }
    }

    public final void bVT() {
        this.fpo = false;
        stopLoading();
        if (this.pXs && this.pXq != null && !this.pXt) {
            jY(false);
            this.pXg.setReleaseTargetHeight(0);
            this.pXq.setVisibility(0);
        }
    }

    public final void startLoading() {
        if (!this.YM && this.pXf != null && this.pXg != null) {
            this.YM = true;
            this.pXg.jY(true);
            this.pXf.clearAnimation();
            if (this.pXm != null) {
                this.pXm.cancel();
            }
            this.pXm = ObjectAnimator.ofFloat(this, "startLoadingStep", new float[]{this.pXl + 0.0f, this.pXl + 354.0f});
            this.pXm.setDuration(960);
            this.pXm.setRepeatMode(1);
            this.pXm.setRepeatCount(-1);
            this.pXm.setInterpolator(new LinearInterpolator());
            this.pXm.start();
            if (this.pXe != null) {
                this.pXe.bVV();
            }
        }
    }

    public final void stopLoading() {
        if (this.YM) {
            x.d("MicroMsg.WebViewPullDownLogoDelegate", "stopLoading()");
            this.pXj = true;
            this.YM = false;
            if (this.pXg != null && this.fpo) {
                this.pXg.jY(false);
            }
            if (this.pXm != null) {
                this.pXm.cancel();
            }
            if (this.pXg != null) {
                this.pXg.P(0, 250);
            }
            if (this.pXf != null) {
                x.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage, alpha to 0f");
                this.pXf.animate().alpha(0.0f).setDuration(500).start();
            }
        }
    }

    public final void release() {
        if (this.pXg != null) {
            LogoWebViewWrapper logoWebViewWrapper = this.pXg;
            if (logoWebViewWrapper.pVp != null) {
                logoWebViewWrapper.pVp.removeView(logoWebViewWrapper.hNb);
                logoWebViewWrapper.hNb = null;
            }
            logoWebViewWrapper = this.pXg;
            logoWebViewWrapper.pVz = null;
            logoWebViewWrapper.pVy = null;
        }
        if (this.pXp != null) {
            ((ViewGroup) this.pXp).removeAllViews();
        }
        this.pXg = null;
        this.pXf = null;
        this.pXk = 0;
        if (this.pXm != null) {
            this.pXm.cancel();
            this.pXm = null;
        }
    }

    public final void AH(int i) {
        if (this.pXp != null) {
            this.pXp.setBackgroundColor(i);
        }
    }

    public final void bVU() {
        if (this.pXq != null) {
            this.pXq.setVisibility(8);
        }
    }

    public final void Y(int i, boolean z) {
        String str;
        String str2 = "MicroMsg.WebViewPullDownLogoDelegate";
        String str3 = "onOverScrollOffset, offset = %d, pointerDown = %b, refreshImage.visibility = %s, refreshImage.drawable = %s, refreshImage.alpha = %s";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(i);
        objArr[1] = Boolean.valueOf(z);
        if (this.pXf == null) {
            str = "null";
        } else {
            str = String.valueOf(this.pXf.getVisibility());
        }
        objArr[2] = str;
        if (this.pXf == null) {
            str = "null";
        } else {
            str = this.pXf.getDrawable().toString();
        }
        objArr[3] = str;
        if (this.pXf == null) {
            str = "null";
        } else {
            str = String.valueOf(this.pXf.getAlpha());
        }
        objArr[4] = str;
        x.v(str2, str3, objArr);
        if (this.fpo) {
            if (i == 0) {
                this.pXj = false;
            }
            if (this.pXf != null) {
                if (z) {
                    if (Math.abs(i) >= this.pXh) {
                        if (this.pXg != null) {
                            this.pXg.setReleaseTargetHeight(this.pXh);
                        }
                    } else if (this.pXg != null) {
                        this.pXg.setReleaseTargetHeight(0);
                    }
                } else if (Math.abs(i) > this.pXh && !this.YM) {
                    x.d("MicroMsg.WebViewPullDownLogoDelegate", "startLoading()");
                    startLoading();
                    return;
                } else if (this.YM) {
                    return;
                }
                if (this.pXf != null && this.pXf.getAlpha() < 1.0f && this.pXn == null && z) {
                    x.d("MicroMsg.WebViewPullDownLogoDelegate", "refreshImage alpha to 1.0f");
                    this.pXn = this.pXf.animate().alpha(1.0f).setDuration(500);
                    this.pXn.setListener(new 1(this));
                    this.pXn.start();
                }
                if (!this.pXj) {
                    int i2 = (-i) - this.pXk;
                    if (Math.abs(i) >= this.pXh) {
                        i2 *= 5;
                    } else {
                        i2 *= 2;
                    }
                    this.pXk = -i;
                    float height = ((float) this.pXf.getHeight()) / 2.0f;
                    float width = ((float) this.pXf.getWidth()) / 2.0f;
                    this.pXl -= (float) i2;
                    this.pXf.setScaleType(ScaleType.MATRIX);
                    Matrix imageMatrix = this.pXf.getImageMatrix();
                    imageMatrix.postRotate((float) (-i2), width, height);
                    this.pXf.setImageMatrix(imageMatrix);
                    this.pXf.setImageResource(pXi);
                }
                this.pXf.invalidate();
            }
        }
    }

    public final float getStartLoadingStep() {
        return this.pXo;
    }

    public final void setStartLoadingStep(float f) {
        float f2 = 0.0f;
        this.pXo = f;
        this.pXf.setScaleType(ScaleType.MATRIX);
        Matrix imageMatrix = this.pXf.getImageMatrix();
        float width = this.pXf == null ? 0.0f : ((float) this.pXf.getWidth()) / 2.0f;
        if (this.pXf != null) {
            f2 = ((float) this.pXf.getHeight()) / 2.0f;
        }
        imageMatrix.setRotate(f, width, f2);
        this.pXl = f;
        this.pXf.invalidate();
    }

    public final void jY(boolean z) {
        if (this.pXg != null && this.pXg.pVv != z) {
            this.pXg.jY(z);
            if (this.pXq != null) {
                this.pXq.setVisibility(8);
            }
            this.pXt = z;
        }
    }

    public final void setCurrentURL(String str) {
        if (!this.pXs || this.pXt) {
            jY(true);
            if (this.pXq != null && this.pXq.getVisibility() == 0) {
                this.pXq.setVisibility(8);
            }
        } else if (this.pXr != null) {
            if (!bi.oW(str)) {
                if (!bi.oW(Uri.parse(str).getHost())) {
                    CharSequence string = this.pXr.getContext().getString(R.l.webview_logo_url, new Object[]{r0});
                    this.pXr.setVisibility(0);
                    this.pXr.setText(string);
                    jY(false);
                    return;
                }
            }
            this.pXr.setVisibility(8);
        }
    }
}
