package com.tencent.mm.plugin.wenote.model.nativenote.c;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.l;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.nativenote.c.a.a;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class e implements a {
    public static boolean mHasInit = false;
    public static volatile e qsb = null;
    public ag mHandler = null;
    public int mScreenHeight = 0;
    public int mScreenWidth = 0;
    public TextView qsA = null;
    public TextView qsB = null;
    public TextView qsC = null;
    public TextView qsD = null;
    public TextView qsE = null;
    public TextView qsF = null;
    public TextView qsG = null;
    public TextView qsH = null;
    public boolean qsc = true;
    public int qsd = 0;
    public int qse = 0;
    public int qsf = 14;
    public int qsg = 0;
    public int qsh = 0;
    public int qsi = 0;
    public int qsj = 0;
    public int qsk = 0;
    public int qsl = 0;
    public int qsm = 0;
    public int[] qsn = null;
    public int[] qso = null;
    public int[] qsp = null;
    public int[] qsq = null;
    public PopupWindow qsr = null;
    public PopupWindow qss = null;
    public PopupWindow qst = null;
    public PopupWindow qsu = null;
    public com.tencent.mm.plugin.wenote.model.nativenote.b.a qsv = null;
    public d qsw = null;
    public b qsx = null;
    public al qsy = null;
    public al qsz = null;

    static /* synthetic */ boolean l(e eVar) {
        if (eVar.cao() == 3) {
            int i = eVar.qsw.dHJ;
            while (true) {
                int i2 = i;
                if (i2 > eVar.qsw.endPos) {
                    break;
                }
                b Bv = c.bZD().Bv(i2);
                if (Bv != null && Bv.getType() == 4 && ((k) Bv).qoV.booleanValue()) {
                    return true;
                }
                i = i2 + 1;
            }
        }
        return false;
    }

    private e() {
        mHasInit = false;
    }

    public static e cap() {
        if (qsb == null) {
            synchronized (c.class) {
                if (qsb == null) {
                    qsb = new e();
                }
            }
        }
        return qsb;
    }

    public static boolean isEnabled() {
        return mHasInit;
    }

    public final boolean isEditable() {
        return mHasInit && this.qsc;
    }

    private RecyclerView bAt() {
        if (this.qsv != null) {
            return this.qsv.bZw();
        }
        return null;
    }

    private int caq() {
        if (this.qsv != null) {
            return this.qsv.bZt() + this.qsv.bZu();
        }
        return 0;
    }

    public final int cao() {
        if (!mHasInit) {
            return 0;
        }
        if (this.qsw == null) {
            this.qsw = new d();
        }
        return this.qsw.cao();
    }

    public final d car() {
        if (!mHasInit) {
            return new d();
        }
        if (this.qsw == null) {
            this.qsw = new d();
        }
        return new d(this.qsw.dHJ, this.qsw.startOffset, this.qsw.endPos, this.qsw.qsa);
    }

    public final boolean w(int i, int i2, int i3, int i4) {
        if (!mHasInit) {
            return false;
        }
        boolean z;
        if (this.qsw == null) {
            this.qsw = new d(i, i2, i3, i4);
            z = true;
        } else if (this.qsw.dHJ == i && this.qsw.startOffset == i2 && this.qsw.endPos == i3 && this.qsw.qsa == i4) {
            z = false;
        } else {
            this.qsw.set(i, i2, i3, i4);
            z = true;
        }
        if (z) {
            x.d("NoteSelectManager", "setSelectInfo: %d:%d - %d:%d", Integer.valueOf(this.qsw.dHJ), Integer.valueOf(this.qsw.startOffset), Integer.valueOf(this.qsw.endPos), Integer.valueOf(this.qsw.qsa));
        }
        return z;
    }

    public final int Bx(int i) {
        if (!mHasInit || this.qsw == null || cao() == 0 || i < this.qsw.dHJ || i > this.qsw.endPos) {
            return 0;
        }
        if (i == this.qsw.dHJ && i == this.qsw.endPos) {
            return 1;
        }
        if (i > this.qsw.dHJ && i < this.qsw.endPos) {
            return 2;
        }
        if (i == this.qsw.dHJ && i < this.qsw.endPos) {
            return 4;
        }
        if (i <= this.qsw.dHJ || i != this.qsw.endPos) {
            return 0;
        }
        return 3;
    }

    private void ac(int i, int i2, int i3) {
        if (mHasInit) {
            switch (i) {
                case 2:
                    if (this.qso != null && this.qso.length == 2) {
                        this.qso[0] = i2;
                        this.qso[1] = i3;
                        return;
                    }
                    return;
                case 3:
                    if (this.qsp != null && this.qsp.length == 2) {
                        this.qsp[0] = i2;
                        this.qsp[1] = i3;
                        return;
                    }
                    return;
                case 4:
                    if (this.qsq != null && this.qsq.length == 2) {
                        this.qsq[0] = i2;
                        this.qsq[1] = i3;
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    private static boolean p(int[] iArr) {
        return (!mHasInit || iArr == null || iArr.length != 2 || iArr[0] == -1 || iArr[1] == -1) ? false : true;
    }

    private void cas() {
        if (this.qsv != null) {
            this.qsv.bZs();
        }
    }

    public final void cat() {
        if (mHasInit) {
            w(-1, -1, -1, -1);
            f(true, 0);
            cax();
            cav();
        }
    }

    public final void Q(boolean z, boolean z2) {
        if (mHasInit) {
            cax();
            cav();
            f(true, 50);
            ky(z);
            kw(z2);
        }
    }

    public final void f(boolean z, long j) {
        if (mHasInit && this.mHandler != null) {
            this.mHandler.postDelayed(new 1(this, z), j);
        }
    }

    public final void a(View view, View view2, View view3, int i) {
        if (mHasInit && view != null && view2 != null && view3 != null && this.qsw != null) {
            switch (Bx(i)) {
                case 0:
                    view.setVisibility(8);
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
                case 1:
                    if (this.qsw.startOffset == this.qsw.qsa) {
                        view.setVisibility(8);
                    } else {
                        view.setVisibility(0);
                    }
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
                case 2:
                    view.setVisibility(0);
                    view2.setVisibility(0);
                    view3.setVisibility(0);
                    return;
                case 3:
                    if (this.qsw.qsa != 0) {
                        view.setVisibility(0);
                        view2.setVisibility(0);
                        view3.setVisibility(4);
                        return;
                    }
                    break;
                case 4:
                    if (this.qsw.startOffset == 0) {
                        view.setVisibility(0);
                        view2.setVisibility(4);
                        view3.setVisibility(0);
                        return;
                    }
                    view.setVisibility(8);
                    view2.setVisibility(4);
                    view3.setVisibility(4);
                    return;
            }
            view.setVisibility(8);
            view2.setVisibility(4);
            view3.setVisibility(4);
        }
    }

    public final boolean cau() {
        return this.qsu != null && this.qsu.isShowing();
    }

    public final void cav() {
        if (this.qsu != null) {
            this.qsu.dismiss();
        }
    }

    public final void kw(final boolean z) {
        this.mHandler.postDelayed(new Runnable() {
            public final void run() {
                e.this.kx(z);
            }
        }, 50);
    }

    public final void kx(boolean z) {
        if (mHasInit && this.qsu != null) {
            RecyclerView bAt = bAt();
            int cao = cao();
            if (bAt == null || cao == 0 || ((cao == 1 && !z) || (this.qsx != null && this.qsx.getType() == 1))) {
                cav();
                return;
            }
            b Bv;
            boolean z2;
            boolean l;
            View view;
            int bZN;
            int bZO;
            b Bv2;
            boolean l2;
            View view2;
            boolean l3;
            View view3;
            boolean l4;
            View view4;
            boolean l5;
            View view5;
            boolean l6 = l(this.qsA, false);
            boolean l7 = l(this.qsB, false);
            View view6 = this.qsC;
            if (cao() == 1) {
                Bv = c.bZD().Bv(this.qsw.dHJ);
                if (!(Bv == null || (c.bZD().size() <= 1 && Bv.getType() == 1 && bi.oW(((h) Bv).content)))) {
                    z2 = true;
                    l = l(view6, z2);
                    view = this.qsD;
                    bZN = c.bZD().bZN();
                    bZO = c.bZD().bZO();
                    Bv2 = c.bZD().Bv(bZN);
                    Bv = c.bZD().Bv(bZO);
                    if (Bv2 != null || Bv == null) {
                        z2 = false;
                    } else {
                        if (this.qsw != null && this.qsw.dHJ == bZN && this.qsw.startOffset == 0 && this.qsw.endPos == bZO) {
                            if (Bv.getType() == 1) {
                                Spanned Sk = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(((h) Bv).content);
                                if (Sk == null) {
                                    z2 = false;
                                } else if (this.qsw.qsa == Sk.length()) {
                                    z2 = false;
                                }
                            } else if (Bv.getType() != 1 && this.qsw.qsa == 1) {
                                z2 = false;
                            }
                        }
                        z2 = true;
                    }
                    l2 = l(view, z2);
                    view2 = this.qsE;
                    if (this.qsc) {
                        z2 = false;
                    } else {
                        cao = cao();
                        z2 = (cao == 0 || cao == 1) ? false : this.qsv != null ? !this.qsv.bZv() : true;
                    }
                    l3 = l(view2, z2);
                    view3 = this.qsF;
                    cao = cao();
                    z2 = this.qsc && (cao == 2 || cao == 3);
                    l4 = l(view3, z2);
                    view4 = this.qsG;
                    cao = cao();
                    z2 = cao != 2 || cao == 3;
                    l5 = l(view4, z2);
                    view5 = this.qsH;
                    z2 = (this.qsc || cao() == 0) ? false : f.eE(ad.getContext()) != 1;
                    z2 = l6 || l7 || l || l2 || l3 || l4 || l5 || l(view5, z2);
                    if (z2) {
                        cav();
                    }
                    int i;
                    int height;
                    int fi;
                    bZO = D(bAt);
                    int caA = caA();
                    if (this.qsu == null || this.qsu.getContentView() == null) {
                        cao = 0;
                        i = 0;
                    } else {
                        this.qsu.getContentView().measure(0, 0);
                        i = (this.qsg * 2) + this.qsu.getContentView().getMeasuredHeight();
                        cao = this.qsu.getContentView().getMeasuredWidth() + (this.qsg * 2);
                    }
                    bZN = i == 0 ? this.qsi : i;
                    if (cao == 0) {
                        i = this.qsj;
                    } else {
                        i = cao;
                    }
                    int i2;
                    if (this.qsr != null && this.qsr.isShowing() && p(this.qso)) {
                        i2 = this.qso[1] - bZN;
                        height = (this.qso[1] + this.qsr.getHeight()) - this.qsk;
                        if (i2 >= bZO && i2 <= caA) {
                            cao = this.qso[0];
                            height = i2;
                        } else if (height < bZO || height > caA) {
                            cao = -1000;
                            height = -1;
                        } else {
                            cao = this.qso[0];
                        }
                    } else {
                        int height2;
                        int height3;
                        if (this.qss != null && this.qss.isShowing() && p(this.qsp)) {
                            i2 = this.qsp[1] - bZN;
                            height2 = (this.qsp[1] + this.qss.getHeight()) - this.qsk;
                            if (i2 >= bZO && i2 <= caA) {
                                cao = this.qsp[0];
                                height2 = this.qsq[1] - bZN;
                                height3 = (this.qsq[1] + this.qst.getHeight()) - this.qsk;
                                if (i2 == -1) {
                                    if (i2 + bZN > this.qsq[1] && height3 >= bZO && height3 <= caA) {
                                        cao = this.qsq[0];
                                        height = height3;
                                    }
                                } else if (height2 >= bZO && height2 <= caA) {
                                    cao = this.qsq[0];
                                    height = height2;
                                } else if (height3 >= bZO && height3 <= caA) {
                                    cao = this.qsq[0];
                                    height = height3;
                                }
                            } else if (height2 >= bZO && height2 <= caA) {
                                cao = this.qsp[0];
                                i2 = height2;
                                if (this.qst != null && this.qst.isShowing() && p(this.qsq)) {
                                    height2 = this.qsq[1] - bZN;
                                    height3 = (this.qsq[1] + this.qst.getHeight()) - this.qsk;
                                    if (i2 == -1) {
                                        if (height2 >= bZO && height2 <= caA) {
                                            cao = this.qsq[0];
                                            height = height2;
                                        } else if (height3 >= bZO && height3 <= caA) {
                                            cao = this.qsq[0];
                                            height = height3;
                                        }
                                    } else if (i2 + bZN > this.qsq[1] && height3 >= bZO && height3 <= caA) {
                                        cao = this.qsq[0];
                                        height = height3;
                                    }
                                }
                                height = i2;
                            }
                        }
                        cao = -1000;
                        i2 = -1;
                        height2 = this.qsq[1] - bZN;
                        height3 = (this.qsq[1] + this.qst.getHeight()) - this.qsk;
                        if (i2 == -1) {
                            if (height2 >= bZO && height2 <= caA) {
                                cao = this.qsq[0];
                                height = height2;
                            } else if (height3 >= bZO && height3 <= caA) {
                                cao = this.qsq[0];
                                height = height3;
                            }
                        } else if (i2 + bZN > this.qsq[1] && height3 >= bZO && height3 <= caA) {
                            cao = this.qsq[0];
                            height = height3;
                        }
                    }
                    if (height == -1) {
                        RecyclerView.h layoutManager = bAt.getLayoutManager();
                        if (layoutManager != null && (layoutManager instanceof LinearLayoutManager)) {
                            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                            fi = linearLayoutManager.fi();
                            cao = linearLayoutManager.fj();
                            if (this.qsw.dHJ <= fi && this.qsw.endPos >= cao) {
                                height = l.CTRL_BYTE;
                                cao = -1000;
                            }
                        }
                        cao = -1000;
                    }
                    if (height == -1) {
                        cav();
                        return;
                    }
                    fi = this.mScreenWidth / 3;
                    int i3 = (this.mScreenWidth * 2) / 3;
                    if (cao == -1000 || (cao >= fi && cao <= i3)) {
                        d(bAt, (this.mScreenWidth - i) / 2, height);
                        return;
                    } else if (cao < fi) {
                        d(bAt, this.qsh, height);
                        return;
                    } else {
                        d(bAt, (this.mScreenWidth - i) - this.qsh, height);
                        return;
                    }
                }
            }
            z2 = false;
            l = l(view6, z2);
            view = this.qsD;
            bZN = c.bZD().bZN();
            bZO = c.bZD().bZO();
            Bv2 = c.bZD().Bv(bZN);
            Bv = c.bZD().Bv(bZO);
            if (Bv2 != null) {
            }
            z2 = false;
            l2 = l(view, z2);
            view2 = this.qsE;
            if (this.qsc) {
                cao = cao();
                z2 = (cao == 0 || cao == 1) ? false : this.qsv != null ? !this.qsv.bZv() : true;
            } else {
                z2 = false;
            }
            l3 = l(view2, z2);
            view3 = this.qsF;
            cao = cao();
            if (!this.qsc) {
            }
            l4 = l(view3, z2);
            view4 = this.qsG;
            cao = cao();
            if (cao != 2) {
            }
            l5 = l(view4, z2);
            view5 = this.qsH;
            if (this.qsc) {
            }
            if (!l6) {
            }
            if (z2) {
                int i4;
                int height4;
                int fi2;
                bZO = D(bAt);
                int caA2 = caA();
                if (this.qsu == null || this.qsu.getContentView() == null) {
                    cao = 0;
                    i4 = 0;
                } else {
                    this.qsu.getContentView().measure(0, 0);
                    i4 = (this.qsg * 2) + this.qsu.getContentView().getMeasuredHeight();
                    cao = this.qsu.getContentView().getMeasuredWidth() + (this.qsg * 2);
                }
                bZN = i4 == 0 ? this.qsi : i4;
                if (cao == 0) {
                    i4 = this.qsj;
                } else {
                    i4 = cao;
                }
                int i22;
                if (this.qsr != null && this.qsr.isShowing() && p(this.qso)) {
                    i22 = this.qso[1] - bZN;
                    height4 = (this.qso[1] + this.qsr.getHeight()) - this.qsk;
                    if (i22 >= bZO && i22 <= caA2) {
                        cao = this.qso[0];
                        height4 = i22;
                    } else if (height4 < bZO || height4 > caA2) {
                        cao = -1000;
                        height4 = -1;
                    } else {
                        cao = this.qso[0];
                    }
                } else {
                    int height22;
                    int height32;
                    if (this.qss != null && this.qss.isShowing() && p(this.qsp)) {
                        i22 = this.qsp[1] - bZN;
                        height22 = (this.qsp[1] + this.qss.getHeight()) - this.qsk;
                        if (i22 >= bZO && i22 <= caA2) {
                            cao = this.qsp[0];
                            height22 = this.qsq[1] - bZN;
                            height32 = (this.qsq[1] + this.qst.getHeight()) - this.qsk;
                            if (i22 == -1) {
                                if (i22 + bZN > this.qsq[1] && height32 >= bZO && height32 <= caA2) {
                                    cao = this.qsq[0];
                                    height4 = height32;
                                }
                            } else if (height22 >= bZO && height22 <= caA2) {
                                cao = this.qsq[0];
                                height4 = height22;
                            } else if (height32 >= bZO && height32 <= caA2) {
                                cao = this.qsq[0];
                                height4 = height32;
                            }
                        } else if (height22 >= bZO && height22 <= caA2) {
                            cao = this.qsp[0];
                            i22 = height22;
                            if (this.qst != null && this.qst.isShowing() && p(this.qsq)) {
                                height22 = this.qsq[1] - bZN;
                                height32 = (this.qsq[1] + this.qst.getHeight()) - this.qsk;
                                if (i22 == -1) {
                                    if (height22 >= bZO && height22 <= caA2) {
                                        cao = this.qsq[0];
                                        height4 = height22;
                                    } else if (height32 >= bZO && height32 <= caA2) {
                                        cao = this.qsq[0];
                                        height4 = height32;
                                    }
                                } else if (i22 + bZN > this.qsq[1] && height32 >= bZO && height32 <= caA2) {
                                    cao = this.qsq[0];
                                    height4 = height32;
                                }
                            }
                            height4 = i22;
                        }
                    }
                    cao = -1000;
                    i22 = -1;
                    height22 = this.qsq[1] - bZN;
                    height32 = (this.qsq[1] + this.qst.getHeight()) - this.qsk;
                    if (i22 == -1) {
                        if (height22 >= bZO && height22 <= caA2) {
                            cao = this.qsq[0];
                            height4 = height22;
                        } else if (height32 >= bZO && height32 <= caA2) {
                            cao = this.qsq[0];
                            height4 = height32;
                        }
                    } else if (i22 + bZN > this.qsq[1] && height32 >= bZO && height32 <= caA2) {
                        cao = this.qsq[0];
                        height4 = height32;
                    }
                }
                if (height4 == -1) {
                    RecyclerView.h layoutManager2 = bAt.getLayoutManager();
                    if (layoutManager2 != null && (layoutManager2 instanceof LinearLayoutManager)) {
                        LinearLayoutManager linearLayoutManager2 = (LinearLayoutManager) layoutManager2;
                        fi2 = linearLayoutManager2.fi();
                        cao = linearLayoutManager2.fj();
                        if (this.qsw.dHJ <= fi2 && this.qsw.endPos >= cao) {
                            height4 = l.CTRL_BYTE;
                            cao = -1000;
                        }
                    }
                    cao = -1000;
                }
                if (height4 == -1) {
                    cav();
                    return;
                }
                fi2 = this.mScreenWidth / 3;
                int i32 = (this.mScreenWidth * 2) / 3;
                if (cao == -1000 || (cao >= fi2 && cao <= i32)) {
                    d(bAt, (this.mScreenWidth - i4) / 2, height4);
                    return;
                } else if (cao < fi2) {
                    d(bAt, this.qsh, height4);
                    return;
                } else {
                    d(bAt, (this.mScreenWidth - i4) - this.qsh, height4);
                    return;
                }
            }
            cav();
        }
    }

    public final boolean caw() {
        return this.qsr != null && this.qsr.isShowing();
    }

    public final void cax() {
        if (mHasInit) {
            By(2);
            By(3);
            By(4);
        }
    }

    private boolean By(int i) {
        boolean z = true;
        if (this.qsx != null && this.qsx.hER == i && this.qsx.getType() == 1) {
            return false;
        }
        if (i == 2 && this.qsr != null) {
            this.qsr.dismiss();
            ac(2, -1, -1);
        } else if (i == 3 && this.qss != null) {
            this.qss.dismiss();
            ac(3, -1, -1);
        } else if (i != 4 || this.qst == null) {
            z = false;
        } else {
            this.qst.dismiss();
            ac(4, -1, -1);
        }
        return z;
    }

    public final void ky(boolean z) {
        if (mHasInit) {
            RecyclerView bAt = bAt();
            int cao = cao();
            if (bAt == null || cao == 0 || (cao == 1 && !z)) {
                cax();
                return;
            }
            View g = f.g(bAt, this.qsw.dHJ);
            View g2 = f.g(bAt, this.qsw.endPos);
            if (cao == 1) {
                By(3);
                By(4);
                a(2, bAt, g, this.qsw.startOffset);
                return;
            }
            By(2);
            a(3, bAt, g, this.qsw.startOffset);
            a(4, bAt, g2, this.qsw.qsa);
        }
    }

    private void a(int i, RecyclerView recyclerView, View view, int i2) {
        if (mHasInit && recyclerView != null) {
            c dd = f.dd(view);
            if (dd == null) {
                By(i);
                return;
            }
            WXRTEditText wXRTEditText;
            if (dd.qrX != null) {
                wXRTEditText = dd.qrX;
            } else {
                if (!(dd.qrY == null || dd.qrZ == null)) {
                    if (i2 == 0) {
                        i2 = 0;
                        wXRTEditText = dd.qrY;
                    } else if (i2 == 1) {
                        i2 = 0;
                        wXRTEditText = dd.qrZ;
                    }
                }
                wXRTEditText = null;
            }
            if (wXRTEditText == null) {
                By(i);
                return;
            }
            Editable text = wXRTEditText.getText();
            if (text == null || i2 < 0 || i2 > text.length()) {
                By(i);
                return;
            }
            Layout layout = wXRTEditText.getLayout();
            if (layout == null) {
                By(i);
                return;
            }
            boolean a;
            float primaryHorizontal = layout.getPrimaryHorizontal(i2) + ((float) wXRTEditText.getPaddingLeft());
            float lineTop = (float) (layout.getLineTop(layout.getLineForOffset(i2)) + wXRTEditText.getPaddingTop());
            if (wXRTEditText.getEditTextType() != 0) {
                lineTop = (lineTop + ((float) wXRTEditText.getHeight())) - ((float) this.qsd);
                if (i == 3) {
                    primaryHorizontal += (float) this.qsm;
                } else if (i == 4) {
                    primaryHorizontal -= (float) this.qsm;
                }
            }
            int[] iArr = new int[2];
            wXRTEditText.getLocationOnScreen(iArr);
            switch (i) {
                case 2:
                    a = a(2, recyclerView, this.qsr, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.qsl)), (int) (((float) iArr[1]) + lineTop));
                    break;
                case 3:
                    a = a(3, recyclerView, this.qss, (int) ((primaryHorizontal + ((float) iArr[0])) - ((float) this.qss.getWidth())), (int) (((float) iArr[1]) + lineTop));
                    break;
                case 4:
                    a = a(4, recyclerView, this.qst, (int) (primaryHorizontal + ((float) iArr[0])), (int) (((float) iArr[1]) + lineTop));
                    break;
                default:
                    a = false;
                    break;
            }
            if (!a) {
                By(i);
            }
        }
    }

    private boolean a(int i, RecyclerView recyclerView, PopupWindow popupWindow, int i2, int i3) {
        if (!mHasInit || recyclerView == null || popupWindow == null || i3 < D(recyclerView) || i3 > this.mScreenHeight - caq()) {
            return false;
        }
        if (popupWindow.isShowing()) {
            popupWindow.update(i2, i3, -1, -1, false);
            ac(i, i2, i3);
        } else {
            popupWindow.showAtLocation(recyclerView, 0, i2, i3);
            ac(i, i2, i3);
        }
        if (i == 2) {
            if (this.qsz == null) {
                this.qsz = new al(new 7(this), false);
            } else {
                this.qsz.SO();
            }
            this.qsz.J(3000, 0);
        }
        return true;
    }

    private boolean d(RecyclerView recyclerView, int i, int i2) {
        if (!mHasInit || recyclerView == null || this.qsu == null || i2 < D(recyclerView) || i2 > this.mScreenHeight - caq()) {
            return false;
        }
        if (this.qsu.isShowing()) {
            this.qsu.update(i, i2, -1, -1, false);
        } else {
            this.qsu.showAtLocation(recyclerView, 0, i, i2);
        }
        return true;
    }

    public final void a(int i, MotionEvent motionEvent) {
        if (mHasInit && this.mHandler != null) {
            if (this.qsx == null || this.qsx.getType() != 1 || this.qsx.hER == i) {
                switch (motionEvent.getAction()) {
                    case 0:
                        cay();
                        if (!cau()) {
                            kx(true);
                        }
                        this.qsx.a(i, motionEvent.getRawX(), motionEvent.getRawY(), motionEvent.getX(), motionEvent.getY(), 0);
                        return;
                    case 1:
                    case 3:
                        cay();
                        this.mHandler.postDelayed(new 8(this), 200);
                        return;
                    case 2:
                        if (this.qsx != null && this.qsx.getType() == 1) {
                            this.qsx.qrP = motionEvent.getRawX();
                            this.qsx.qrQ = motionEvent.getRawY();
                            kz(true);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }

    private void kz(boolean z) {
        if (mHasInit && this.qsr != null && this.qss != null && this.qst != null && this.qsw != null) {
            RecyclerView bAt = bAt();
            if (bAt != null && this.qsx != null && this.qsx.getType() == 1) {
                int i = this.qsx.hER;
                if (i == 2 || i == 3 || i == 4) {
                    int i2;
                    boolean z2;
                    float f = this.qsx.qrP - this.qsx.fto;
                    float f2 = ((float) (this.qsd / 2)) + (this.qsx.qrQ - this.qsx.ftp);
                    if (i == 2) {
                        f += (float) (this.qsr.getWidth() / 2);
                    } else if (i == 3) {
                        f += (float) this.qss.getWidth();
                    }
                    bAt.getLocationOnScreen(this.qsn);
                    View u = bAt.u(f - ((float) this.qsn[0]), f2 - ((float) this.qsn[1]));
                    c dd = f.dd(u);
                    WXRTEditText wXRTEditText = null;
                    if (dd == null) {
                        i2 = 2;
                    } else if (dd.qrX != null) {
                        wXRTEditText = dd.qrX;
                        int[] iArr = new int[2];
                        wXRTEditText.getLocationOnScreen(iArr);
                        i2 = ad(i, wXRTEditText.getPosInDataList(), wXRTEditText.getOffsetForPosition(f - ((float) iArr[0]), f2 - ((float) iArr[1])));
                    } else if (dd.qrY == null || dd.qrZ == null) {
                        i2 = 0;
                    } else {
                        WXRTEditText wXRTEditText2;
                        int ad;
                        if (i == 3) {
                            wXRTEditText2 = dd.qrY;
                            ad = ad(i, wXRTEditText2.getPosInDataList(), 0);
                            if (ad == 2 || ad == 3) {
                                a(i, bAt, this.qss, (int) (this.qsx.qrP - this.qsx.fto), (int) (this.qsx.qrQ - this.qsx.ftp));
                                i2 = ad;
                                wXRTEditText = wXRTEditText2;
                            }
                        } else if (i == 4) {
                            wXRTEditText2 = dd.qrZ;
                            ad = ad(i, wXRTEditText2.getPosInDataList(), 1);
                            if (ad == 2 || ad == 3) {
                                a(i, bAt, this.qst, (int) (this.qsx.qrP - this.qsx.fto), (int) (this.qsx.qrQ - this.qsx.ftp));
                                i2 = ad;
                                wXRTEditText = wXRTEditText2;
                            }
                        } else {
                            int[] iArr2 = new int[2];
                            u.getLocationOnScreen(iArr2);
                            if (f <= ((float) (iArr2[0] + (u.getWidth() / 2)))) {
                                wXRTEditText2 = dd.qrY;
                                ad = ad(i, wXRTEditText2.getPosInDataList(), 0);
                            } else {
                                wXRTEditText2 = dd.qrZ;
                                ad = ad(i, wXRTEditText2.getPosInDataList(), 1);
                            }
                            if (ad == 2 || ad == 3) {
                                a(i, bAt, this.qsr, (int) (this.qsx.qrP - this.qsx.fto), (int) (this.qsx.qrQ - this.qsx.ftp));
                            }
                        }
                        i2 = ad;
                        wXRTEditText = wXRTEditText2;
                    }
                    switch (i2) {
                        case 1:
                            z2 = false;
                            break;
                        case 2:
                            z2 = true;
                            break;
                        case 3:
                            Editable text = wXRTEditText.getText();
                            int cao = cao();
                            if (this.qsc && text != null && cao == 1) {
                                if (!wXRTEditText.hasFocus()) {
                                    wXRTEditText.requestFocus();
                                }
                                if (wXRTEditText.getEditTextType() == 1 || wXRTEditText.getEditTextType() == 2) {
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                    wXRTEditText.setSelection(0);
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                                } else if (this.qsw.startOffset <= text.length()) {
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                    wXRTEditText.setSelection(this.qsw.startOffset);
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                                }
                            } else if (this.qsc && text != null && cao == 2 && wXRTEditText.hasFocus()) {
                                if (wXRTEditText.getEditTextType() == 1 || wXRTEditText.getEditTextType() == 2) {
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                    wXRTEditText.setSelection(0);
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                                } else if (this.qsw.startOffset <= text.length() && this.qsw.qsa <= text.length()) {
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(true);
                                    wXRTEditText.setSelection(this.qsw.startOffset, this.qsw.qsa);
                                    wXRTEditText.setIgnoreSelectChangeByMultiSelect(false);
                                }
                            }
                            if (cao == 3 || cao == 0) {
                                cas();
                            }
                            cav();
                            f(true, 0);
                            if (i == 4) {
                                i2 = this.qsw.qsa;
                            } else {
                                i2 = this.qsw.startOffset;
                            }
                            a(i, bAt, u, i2);
                            z2 = true;
                            break;
                        default:
                            return;
                    }
                    if (!z2) {
                        caz();
                    } else if (!z) {
                    } else {
                        if (this.qsx.qrQ >= ((float) D(bAt)) && this.qsx.qrQ <= ((float) caA())) {
                            return;
                        }
                        if (this.qsy == null || this.qsy.ciq()) {
                            caz();
                            this.qsy.J(100, 100);
                        }
                    }
                }
            }
        }
    }

    private int ad(int i, int i2, int i3) {
        if (!mHasInit) {
            return 0;
        }
        boolean w;
        switch (i) {
            case 2:
                w = w(i2, i3, i2, i3);
                break;
            case 3:
                if (this.qsw != null && i2 <= this.qsw.endPos && (i2 != this.qsw.endPos || i3 < this.qsw.qsa)) {
                    w = w(i2, i3, this.qsw.endPos, this.qsw.qsa);
                    break;
                }
                return 1;
                break;
            case 4:
                if (this.qsw != null && i2 >= this.qsw.dHJ && (i2 != this.qsw.dHJ || i3 > this.qsw.startOffset)) {
                    w = w(this.qsw.dHJ, this.qsw.startOffset, i2, i3);
                    break;
                }
                return 1;
            default:
                return 0;
        }
        if (w) {
            return 3;
        }
        return 2;
    }

    private void cay() {
        if (this.qsx == null) {
            this.qsx = new b();
        } else {
            this.qsx.reset();
        }
    }

    private void caz() {
        if (this.qsy == null) {
            this.qsy = new al(new 9(this), true);
        } else {
            this.qsy.SO();
        }
    }

    private int D(RecyclerView recyclerView) {
        if (recyclerView == null) {
            return 150;
        }
        recyclerView.getLocationOnScreen(this.qsn);
        if (p(this.qsn)) {
            return this.qsn[1];
        }
        return 150;
    }

    private int caA() {
        int i = 0;
        if (this.qsv != null) {
            i = this.qsv.bZt();
        }
        if (i == 0 && this.qsv != null) {
            i = this.qsv.bZu();
        }
        if (i == 0) {
            i = 150;
        }
        return this.mScreenHeight - i;
    }

    public static void f(TextView textView, int i) {
        if (textView != null) {
            textView.setTextSize(1, (float) i);
        }
    }

    private void caB() {
        if (this.qsv != null) {
            this.qsv.bZr();
        }
    }

    public final void caC() {
        x.i("NoteSelectManager", "deleteSelectedData");
        if (mHasInit) {
            cav();
            int cao = cao();
            if (cao == 2) {
                a(true, null, "");
                return;
            } else if (cao == 3) {
                b(true, null, "");
                return;
            } else {
                x.e("NoteSelectManager", "deleteSelectedData: not in select");
                caB();
                return;
            }
        }
        x.e("NoteSelectManager", "deleteSelectedData: not init");
    }

    private SpannableStringBuilder a(boolean z, ArrayList<b> arrayList, String str) {
        int i = 2;
        d car = car();
        cat();
        int cao = car.cao();
        if (cao == 1 || cao == 2) {
            b Bv = c.bZD().Bv(car.dHJ);
            if (Bv == null) {
                x.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: item is null");
                return null;
            }
            SpannableStringBuilder spannableStringBuilder;
            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder();
            if (Bv.getType() != 1) {
                if (cao == 1 && z) {
                    ArrayList arrayList2;
                    if (car.startOffset == 0) {
                        i = 1;
                    }
                    if (arrayList != null && arrayList.size() > 0) {
                        ArrayList<b> arrayList22 = arrayList;
                    } else if (bi.oW(str)) {
                        return spannableStringBuilder2;
                    } else {
                        arrayList22 = new ArrayList();
                        h hVar = new h();
                        hVar.content = str;
                        hVar.qoH = false;
                        hVar.qoJ = -1;
                        arrayList22.add(hVar);
                    }
                    c.bZD().a(arrayList22, i, car.dHJ, car.startOffset, car.qsa);
                    c.bZD().er(car.dHJ - 1, (arrayList22.size() + car.dHJ) + 1);
                }
                spannableStringBuilder = spannableStringBuilder2;
            } else if (!z || arrayList == null || arrayList.size() <= 0) {
                spannableStringBuilder = a((h) Bv, car.startOffset, car.qsa, false, z, str, true);
                if (this.qsv != null) {
                    this.qsv.Bo(car.dHJ);
                }
                if (z) {
                    c.bZD().bZM();
                }
            } else {
                spannableStringBuilder = a((h) Bv, car.startOffset, car.qsa, false, false, "", true);
                c.bZD().a(arrayList, 0, car.dHJ, car.startOffset, car.qsa);
                c.bZD().er(car.dHJ, (car.dHJ + arrayList.size()) + 1);
            }
            return spannableStringBuilder;
        }
        x.e("NoteSelectManager", "getAndProcessSelectedDataInSingleSelect: incorrect select");
        return null;
    }

    private ArrayList<b> b(boolean z, ArrayList<b> arrayList, String str) {
        d car = car();
        cat();
        List arrayList2 = new ArrayList();
        if (car.cao() != 3) {
            x.e("NoteSelectManager", "getAndProcessSelectedDataInMultiSelect: incorrect select");
            return null;
        }
        int i;
        h hVar;
        int i2 = car.dHJ;
        int i3 = car.endPos;
        while (true) {
            int i4 = i3;
            i = i2;
            if (i4 < car.dHJ) {
                break;
            }
            b Bv = c.bZD().Bv(i4);
            if (Bv != null) {
                h hVar2;
                Object a;
                if (i4 == car.endPos && Bv.getType() == 1) {
                    hVar2 = (h) Bv;
                    a = a(hVar2, 0, car.qsa, false, z, "", false);
                    if (!bi.K(a)) {
                        hVar = new h();
                        hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                        hVar.qoJ = -1;
                        hVar.qoH = false;
                        arrayList2.add(hVar);
                    }
                    if (z && bi.oW(hVar2.content)) {
                        c.bZD().ab(i4, true);
                    }
                } else if (i4 == car.dHJ && Bv.getType() == 1) {
                    hVar2 = (h) Bv;
                    a = a(hVar2, car.startOffset, 0, true, z, "", false);
                    if (!bi.K(a)) {
                        hVar = new h();
                        hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(a);
                        hVar.qoJ = -1;
                        hVar.qoH = false;
                        arrayList2.add(hVar);
                    }
                    if (z && bi.oW(hVar2.content)) {
                        c.bZD().ab(i4, true);
                    } else {
                        i++;
                    }
                } else {
                    arrayList2.add(com.tencent.mm.plugin.wenote.b.c.c(Bv));
                    if (z) {
                        c.bZD().ab(i4, true);
                    }
                }
            }
            i2 = i;
            i3 = i4 - 1;
        }
        if (z) {
            i2 = i - 1;
            i3 = i + 1;
            if (arrayList == null || arrayList.size() <= 0) {
                hVar = new h();
                if (str == null) {
                    str = "";
                }
                hVar.content = str;
                hVar.qoH = false;
                hVar.qoJ = -1;
                c.bZD().a(i, hVar);
            } else {
                c.bZD().a(i, arrayList);
                i3 = arrayList.size() + i;
            }
            c.bZD().er(i2, i3);
        }
        Collections.reverse(arrayList2);
        return arrayList2;
    }

    private static SpannableStringBuilder a(h hVar, int i, int i2, boolean z, boolean z2, String str, boolean z3) {
        SpannableStringBuilder spannableStringBuilder = null;
        if (hVar == null) {
            x.e("NoteSelectManager", "processTextDataItem: textDataItem is null");
        } else {
            Spanned Sk = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(hVar.content);
            if (Sk == null) {
                x.e("NoteSelectManager", "processTextDataItem: spannedText is null");
            } else {
                int length;
                if (z) {
                    length = Sk.length();
                } else {
                    length = i2;
                }
                if (str == null) {
                    str = "";
                }
                if (i < 0 || i > Sk.length() || length < 0 || length > Sk.length() || i > length) {
                    x.e("NoteSelectManager", "processTextDataItem: incorrect offset");
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) Sk.subSequence(0, i);
                    spannableStringBuilder = (SpannableStringBuilder) Sk.subSequence(i, length);
                    SpannableStringBuilder spannableStringBuilder3 = (SpannableStringBuilder) Sk.subSequence(length, Sk.length());
                    if (z2) {
                        length = spannableStringBuilder2.length();
                        if (!bi.oW(str)) {
                            Spanned Sk2 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(str);
                            if (Sk2 != null) {
                                length += Sk2.length();
                            }
                        }
                        hVar.content = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannableStringBuilder2) + str + com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(spannableStringBuilder3);
                    }
                    if (z3) {
                        hVar.qoH = true;
                        hVar.qoJ = length;
                    } else {
                        hVar.qoH = false;
                        hVar.qoJ = -1;
                    }
                }
            }
        }
        return spannableStringBuilder;
    }

    private static boolean l(View view, boolean z) {
        if (view == null) {
            return false;
        }
        if (z) {
            view.setVisibility(0);
            return true;
        }
        view.setVisibility(8);
        return false;
    }
}
