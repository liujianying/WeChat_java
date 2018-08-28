package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.tencent.mm.bv.d;
import com.tencent.mm.g.a.rz;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i$c;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.an;
import com.tencent.mm.ui.ap;

class bb$9 implements OnScrollListener {
    final /* synthetic */ bb ogl;

    bb$9(bb bbVar) {
        this.ogl = bbVar;
    }

    public final void onScrollStateChanged(AbsListView absListView, int i) {
        bb.c(this.ogl).xA(i);
        if (i == 0) {
            rz rzVar = new rz();
            rzVar.ccO.type = 5;
            rzVar.ccO.ccP = this.ogl.kww.getFirstVisiblePosition();
            rzVar.ccO.ccQ = this.ogl.kww.getLastVisiblePosition();
            rzVar.ccO.ccR = this.ogl.kww.getHeaderViewsCount();
            a.sFg.m(rzVar);
            if ((bb.a(this.ogl) instanceof SnsTimeLineUI) && ((SnsTimeLineUI) bb.a(this.ogl)).nUq != null) {
                ((SnsTimeLineUI) bb.a(this.ogl)).nUq.bwM();
            }
        }
        if (i == 2) {
            d.cov().dh(bb.class.getName() + bb.c(this.ogl).getType() + ".Listview", 4);
            this.ogl.it(true);
            return;
        }
        this.ogl.it(false);
    }

    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
        System.currentTimeMillis();
        this.ogl.ofV = (i + i2) - 1;
        if (this.ogl.kww.getLastVisiblePosition() == this.ogl.kww.getCount() - 1 && this.ogl.kww.getCount() != bb.f(this.ogl)) {
            x.d("MicroMsg.SnsActivity", "now refresh count: %s", new Object[]{Integer.valueOf(this.ogl.kww.getCount())});
            bb.a(this.ogl, this.ogl.kww.getCount());
            bb.g(this.ogl);
        }
        if (absListView.getChildCount() != 0) {
            int fromDPToPix;
            int i4;
            float ae;
            MMActivity mMActivity;
            int fromDPToPix2 = com.tencent.mm.bp.a.fromDPToPix(bb.a(this.ogl), 20);
            int fromDPToPix3 = com.tencent.mm.bp.a.fromDPToPix(bb.a(this.ogl), 100);
            int i5 = 0;
            float f = 1.0f;
            int ae2 = ap.ae(bb.a(this.ogl), i.d.DefaultActionbarHeightPort);
            int ae3 = ap.ae(bb.a(this.ogl), i.d.SmallActionbarHeight);
            Object obj = null;
            Object obj2 = null;
            int i6 = 0;
            if (bb.a(this.ogl) instanceof SnsTimeLineUI) {
                fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(bb.a(this.ogl), 245);
                i4 = ((SnsTimeLineUI) bb.a(this.ogl)).mController.aDx;
                i6 = fromDPToPix;
            } else if (bb.a(this.ogl) instanceof SnsUserUI) {
                fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(bb.a(this.ogl), 199);
                i4 = ((SnsUserUI) bb.a(this.ogl)).mController.aDx;
                i6 = fromDPToPix;
            } else {
                i4 = 0;
            }
            int fromDPToPix4 = i6 - com.tencent.mm.bp.a.fromDPToPix(bb.a(this.ogl), 30);
            int fromDPToPix5 = i6 - com.tencent.mm.bp.a.fromDPToPix(bb.a(this.ogl), 10);
            View childAt = absListView.getChildAt(0);
            fromDPToPix = childAt == null ? 0 : childAt.getTop();
            bb bbVar;
            if (i > bb.h(this.ogl)) {
                this.ogl.ogf = bb.TE();
                if (childAt != null) {
                    bbVar = this.ogl;
                    bbVar.iGo += childAt.getHeight();
                }
            } else if (i < bb.h(this.ogl)) {
                this.ogl.ogf = bb.bEp();
                bbVar = this.ogl;
                bbVar.iGo -= childAt.getHeight();
            } else if (Math.abs(fromDPToPix - bb.i(this.ogl)) > 1) {
                if (fromDPToPix < bb.i(this.ogl)) {
                    this.ogl.ogf = bb.TE();
                } else if (fromDPToPix > bb.i(this.ogl)) {
                    this.ogl.ogf = bb.bEp();
                }
            }
            this.ogl.ogh = (-fromDPToPix) + this.ogl.iGo;
            bb.b(this.ogl, i);
            bb.c(this.ogl, fromDPToPix);
            if (this.ogl.gFD != null) {
                if (this.ogl.ogh > i6) {
                    this.ogl.gFD.setVisibility(8);
                } else {
                    this.ogl.gFD.setVisibility(0);
                }
            }
            if (this.ogl.ogg != this.ogl.ogf) {
                this.ogl.start = this.ogl.ogh;
                this.ogl.ogi = false;
            }
            int obj3;
            if (i == 0) {
                int i7 = -childAt.getTop();
                if (i7 >= 0 && i7 <= fromDPToPix4) {
                    f = 1.0f;
                } else if (i7 <= fromDPToPix5) {
                    f = 1.0f - (((float) (i7 - fromDPToPix4)) / ((float) (fromDPToPix5 - fromDPToPix4)));
                } else if (i7 <= i6 + fromDPToPix2) {
                    f = 0.0f;
                }
                if (i7 <= i6 + fromDPToPix2) {
                    obj2 = 1;
                }
                if (i7 < 0 || i7 > i6) {
                    float f2;
                    if (i7 > i6) {
                        ae = ((float) ap.ae(bb.a(this.ogl), i.d.SmallActionbarHeight)) / ((float) ae2);
                        if (i7 <= i6 + fromDPToPix2) {
                            i5 = ((i7 - i6) * 100) / fromDPToPix2;
                            ae = 1.0f - (((1.0f - ae) * ((float) (i7 - i6))) / ((float) fromDPToPix2));
                        } else {
                            if (this.ogl.ogf == bb.bEp()) {
                                if (i4 >= ae2) {
                                    ae = 1.0f;
                                    i5 = 100;
                                } else if (this.ogl.start - this.ogl.ogh >= fromDPToPix3) {
                                    obj3 = 1;
                                    i5 = 100;
                                }
                            } else if (this.ogl.ogf == bb.TE() && i4 > ae3) {
                                f2 = ((float) (i4 - (this.ogl.ogh - this.ogl.ogd))) / ((float) ae2);
                                i5 = 100;
                            }
                            f2 = ae;
                            i5 = 100;
                        }
                    } else {
                        f2 = 1.0f;
                    }
                    ae = f2;
                } else {
                    i5 = 0;
                    ae = 1.0f;
                }
            } else {
                i5 = 100;
                float ae4 = ((float) ap.ae(bb.a(this.ogl), i.d.SmallActionbarHeight)) / ((float) ae2);
                if (this.ogl.ogf == bb.bEp()) {
                    if (i4 >= ae2) {
                        ae = 1.0f;
                    } else if (this.ogl.start - this.ogl.ogh >= fromDPToPix3) {
                        obj3 = 1;
                        ae = ae4;
                    }
                } else if (this.ogl.ogf == bb.TE() && i4 > ae3) {
                    ae = ((float) (i4 - (this.ogl.ogh - this.ogl.ogd))) / ((float) ae2);
                }
                ae = ae4;
            }
            if (this.ogl.ogd == 0) {
                ae = 1.0f;
            }
            this.ogl.ogd = this.ogl.ogh;
            this.ogl.ogg = this.ogl.ogf;
            if (bb.a(this.ogl) instanceof SnsTimeLineUI) {
                SnsTimeLineUI snsTimeLineUI = (SnsTimeLineUI) bb.a(this.ogl);
                if (this.ogl.oge != i5) {
                    snsTimeLineUI.aA((float) i5);
                    mMActivity = snsTimeLineUI;
                } else {
                    mMActivity = snsTimeLineUI;
                }
            } else {
                mMActivity = bb.a(this.ogl) instanceof SnsUserUI ? (SnsUserUI) bb.a(this.ogl) : null;
            }
            if (mMActivity != null) {
                if (this.ogl.oge != i5) {
                    if (i5 <= 0) {
                        mMActivity.lF(bb.a(this.ogl).getResources().getColor(i$c.transparent));
                    } else {
                        mMActivity.lF(an.eN(bb.a(this.ogl).getResources().getColor(i$c.normal_actionbar_color), i5));
                    }
                }
                if (obj3 == null) {
                    i6 = (int) (((float) ae2) * ae);
                    if (i6 < ae3) {
                        i6 = ae3;
                    }
                    if (i4 != i6) {
                        mMActivity.mController.DR(i6);
                    }
                } else if (!this.ogl.ogi) {
                    mMActivity.cqg();
                    this.ogl.ogi = true;
                }
                if (obj2 != null) {
                    mMActivity.mController.aB(f);
                }
            }
            this.ogl.oge = i5;
        }
    }
}
