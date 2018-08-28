package com.tencent.mm.plugin.appbrand.page;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.plugin.appbrand.jsapi.container.AppBrandNativeContainerView;
import com.tencent.mm.plugin.appbrand.page.u.b;
import com.tencent.mm.sdk.platformtools.bd;

class u$6 extends bd<Boolean> {
    final /* synthetic */ int fKG;
    final /* synthetic */ u goS;
    final /* synthetic */ y goX;
    final /* synthetic */ int goY;

    u$6(u uVar, Boolean bool, int i, y yVar, int i2) {
        this.goS = uVar;
        this.fKG = i;
        this.goX = yVar;
        this.goY = i2;
        super(1000, bool, (byte) 0);
    }

    protected final /* synthetic */ Object run() {
        boolean z;
        u uVar = this.goS;
        int i = this.fKG;
        y yVar = this.goX;
        int i2 = this.goY;
        if (i == uVar.goN) {
            z = false;
        } else {
            b lv = uVar.lv(i);
            if (lv == null || lv.gpb == null) {
                z = false;
            } else {
                View view = (View) lv.gpb.get();
                if (view == null) {
                    z = false;
                } else {
                    b lv2;
                    uVar.goR = i;
                    ViewGroup ls = uVar.ls(lv.gpc);
                    if ((ls instanceof AppBrandNativeContainerView) && ((AppBrandNativeContainerView) ls).fPF) {
                        lv2 = uVar.lv(lv.gpc);
                        if (lv2 != null) {
                            ViewGroup ls2 = uVar.ls(lv2.gpc);
                            if (ls2 != null) {
                                View view2 = (View) lv.gpb.get();
                                if (view2 != null) {
                                    LayoutParams layoutParams = view2.getLayoutParams();
                                    layoutParams.width = -1;
                                    layoutParams.height = -1;
                                    view2.setLayoutParams(layoutParams);
                                }
                                uVar.goR = lv2.id;
                                ls = ls2;
                                if (ls != null) {
                                    view = (View) lv2.gpb.get();
                                    int indexOfChild = ls.indexOfChild(view);
                                    if (uVar.goP != null) {
                                        ViewGroup viewGroup = (ViewGroup) uVar.goP.getParent();
                                        if (viewGroup != null) {
                                            viewGroup.removeView(uVar.goP);
                                        }
                                    }
                                    ls.addView(uVar.goP, indexOfChild);
                                    ls.removeView(view);
                                }
                                uVar.goO = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) lv2.z};
                                uVar.gnB.r(view, i2);
                                uVar.goN = i;
                                uVar.goQ = yVar;
                                z = true;
                            }
                        }
                    }
                    lv2 = lv;
                    if (ls != null) {
                        view = (View) lv2.gpb.get();
                        int indexOfChild2 = ls.indexOfChild(view);
                        if (uVar.goP != null) {
                            ViewGroup viewGroup2 = (ViewGroup) uVar.goP.getParent();
                            if (viewGroup2 != null) {
                                viewGroup2.removeView(uVar.goP);
                            }
                        }
                        ls.addView(uVar.goP, indexOfChild2);
                        ls.removeView(view);
                    }
                    uVar.goO = new float[]{view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight(), (float) lv2.z};
                    uVar.gnB.r(view, i2);
                    uVar.goN = i;
                    uVar.goQ = yVar;
                    z = true;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
