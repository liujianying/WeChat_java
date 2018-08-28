package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;

public final class d {
    private static final int qbu = ((b.qbp / 2) * (b.qbp / 2));
    private MMActivity gKS;
    private int mScreenHeight;
    private int mScreenWidth;
    private boolean qbA;
    private float qbB = 2.0f;
    private float qbC = 0.15f;
    private long qbD;
    private boolean qbf;
    private f qbr;
    private float qbs;
    private int qbv = (b.qbj - (b.qbp / 2));
    private int qbw = ((-b.qbp) / 2);
    private a qbx;
    private LayoutParams qby;
    private boolean qbz;

    static /* synthetic */ void g(d dVar) {
        if (!dVar.qbz) {
            dVar.qbx.setVisibility(0);
            dVar.qbz = true;
        }
    }

    public d(MMActivity mMActivity, f fVar) {
        this.gKS = mMActivity;
        this.qbr = fVar;
        this.qbx = new a(this.gKS);
        this.qbx.qbF = new d$a$a() {
            public final void onChange(boolean z) {
                d.this.kf(z);
                d.this.qby.bottomMargin = d.this.qbv;
                d.this.qby.rightMargin = d.this.qbw;
                d.this.qbx.setLayoutParams(d.this.qby);
            }
        };
        kf(a.fk(ad.getContext()) > a.fl(ad.getContext()));
        this.qby = new LayoutParams(-2, -2);
        this.qby.gravity = 85;
        this.qby.bottomMargin = this.qbv;
        this.qby.rightMargin = this.qbw;
        this.qbx.setLayoutParams(this.qby);
    }

    public final void start() {
        bWP();
        this.qbD = -1;
        if (this.gKS.getSwipeBackLayout() != null) {
            this.gKS.getSwipeBackLayout().setSwipeBackListener(new b() {
                public final void aw(float f) {
                    if (d.this.qbD < 0) {
                        d.this.qbD = bi.VF();
                    }
                    if (d.a(d.this, f)) {
                        if (!d.this.qbA) {
                            float c = d.this.qbB * f;
                            if (c > 1.0f) {
                                c = 1.0f;
                            }
                            if (d.this.qbf) {
                                d.this.qby.bottomMargin = (int) (((c * 0.5f) - 1.0f) * ((float) b.qbp));
                                d.this.qby.rightMargin = d.this.qby.bottomMargin + b.qbj;
                            } else {
                                d.this.qby.rightMargin = (int) (((c * 0.5f) - 1.0f) * ((float) b.qbp));
                                d.this.qby.bottomMargin = d.this.qby.rightMargin + b.qbj;
                            }
                            d.this.qbx.setLayoutParams(d.this.qby);
                        }
                        d.g(d.this);
                        return;
                    }
                    d.this.bWP();
                }

                public final void G(MotionEvent motionEvent) {
                    boolean b = d.this.qbA;
                    d.a(d.this, motionEvent);
                    if (d.this.qbz && d.this.qbA != b) {
                        if (d.this.qbA) {
                            d.this.qby.rightMargin = d.this.qbw;
                            d.this.qby.bottomMargin = d.this.qbv;
                            d.this.qbx.setLayoutParams(d.this.qby);
                            d.this.qbs = motionEvent.getRawX();
                        }
                        a f = d.this.qbx;
                        x.v("MicroMsg.BagIndicatorController.BagIndicator", "onHitChange %b", new Object[]{Boolean.valueOf(d.this.qbA)});
                        if (d.this.qbA) {
                            f.gER.setImageResource(R.k.webview_bag_indicator_icon_press);
                            f.R(1.0f, b.qbq);
                            if (f.hXL != null) {
                                f.hXL.vibrate(10);
                                return;
                            }
                            return;
                        }
                        f.gER.setImageResource(R.k.webview_bag_indicator_icon_normal);
                        f.R(b.qbq, 1.0f);
                    }
                }

                public final boolean ke(boolean z) {
                    x.i("MicroMsg.BagIndicatorController", "onViewReleased willSwipeBack:%b %b", new Object[]{Boolean.valueOf(z), Boolean.valueOf(d.this.qbA)});
                    d.this.qbD = -1;
                    if (!z) {
                        d.this.bWP();
                        d.this.qbA = false;
                        return false;
                    } else if (!d.this.qbA) {
                        return false;
                    } else {
                        x.v("MicroMsg.BagIndicatorController", "onViewReleased showBag");
                        d.this.bWP();
                        d.this.qbA = false;
                        d.this.qbr.b(d.this.qbs, 14);
                        return true;
                    }
                }
            });
            this.qbx.setVisibility(8);
            ViewGroup viewGroup = (ViewGroup) this.gKS.getWindow().getDecorView();
            try {
                if (this.qbx.getParent() == null) {
                    viewGroup.addView(this.qbx, 1);
                } else {
                    x.i("MicroMsg.BagIndicatorController", "start already added");
                }
            } catch (Exception e) {
                x.e("MicroMsg.BagIndicatorController", "start addView exp:%s", new Object[]{e.getLocalizedMessage()});
            }
        }
    }

    private void bWP() {
        if (this.qbz) {
            this.qbx.setVisibility(8);
            this.qbz = false;
        }
    }

    private void kf(boolean z) {
        x.i("MicroMsg.BagIndicatorController", "updateOrientation isLandscape:%b", new Object[]{Boolean.valueOf(z)});
        this.qbf = z;
        this.mScreenWidth = a.fk(ad.getContext());
        this.mScreenHeight = a.fl(ad.getContext());
        if (z) {
            this.qbv = (-b.qbp) / 2;
            this.qbw = b.qbj - (b.qbp / 2);
        } else {
            this.qbv = b.qbj - (b.qbp / 2);
            this.qbw = (-b.qbp) / 2;
        }
        this.qbB = 1.0f / ((((float) (this.mScreenWidth - (b.qbo / 2))) / ((float) this.mScreenWidth)) - 0.2f);
        x.d("MicroMsg.BagIndicatorController", "initIndicator mIndicatorScaleGainConstant:%f", new Object[]{Float.valueOf(this.qbB)});
    }
}
