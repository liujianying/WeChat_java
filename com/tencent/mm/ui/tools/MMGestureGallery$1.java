package com.tencent.mm.ui.tools;

import android.view.View.OnTouchListener;

class MMGestureGallery$1 implements OnTouchListener {
    final /* synthetic */ MMGestureGallery uAo;

    MMGestureGallery$1(MMGestureGallery mMGestureGallery) {
        this.uAo = mMGestureGallery;
    }

    private void czI() {
        czJ();
        MMGestureGallery.e(this.uAo).h(2, 500, 0);
    }

    private void czJ() {
        MMGestureGallery.e(this.uAo).removeMessages(2);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        r11 = this;
        r10 = 1108082688; // 0x420c0000 float:35.0 double:5.47465589E-315;
        r9 = 1092616192; // 0x41200000 float:10.0 double:5.398241246E-315;
        r8 = 0;
        r2 = 1;
        r1 = 0;
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.f(r0);
        if (r0 != 0) goto L_0x0018;
    L_0x000f:
        r0 = r11.uAo;
        r3 = android.view.VelocityTracker.obtain();
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
    L_0x0018:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.f(r0);
        r0.addMovement(r13);
        r0 = r11.uAo;
        r0 = r0.getSelectedView();
        r3 = r0 instanceof android.view.ViewGroup;
        if (r3 == 0) goto L_0x00d5;
    L_0x002b:
        r3 = r13.getAction();
        if (r3 != 0) goto L_0x0043;
    L_0x0031:
        r3 = r11.uAo;
        r4 = com.tencent.mm.ui.base.f.i(r13, r1);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r3, r4);
        r3 = r11.uAo;
        r4 = com.tencent.mm.ui.base.f.j(r13, r1);
        com.tencent.mm.ui.tools.MMGestureGallery.b(r3, r4);
    L_0x0043:
        r3 = com.tencent.mm.w.a.g.image;
        r3 = r0.findViewById(r3);
        if (r3 == 0) goto L_0x0067;
    L_0x004b:
        r4 = r3.getVisibility();
        if (r4 != 0) goto L_0x0067;
    L_0x0051:
        r3 = r3 instanceof com.tencent.mm.ui.base.MultiTouchImageView;
        if (r3 != 0) goto L_0x0067;
    L_0x0055:
        r3 = r13.getAction();
        if (r3 != 0) goto L_0x005e;
    L_0x005b:
        r11.czI();
    L_0x005e:
        r3 = r13.getAction();
        if (r3 != r2) goto L_0x0067;
    L_0x0064:
        r11.czJ();
    L_0x0067:
        r3 = com.tencent.mm.w.a.g.image_gallery_download_success;
        r0 = r0.findViewById(r3);
        if (r0 == 0) goto L_0x0077;
    L_0x006f:
        r3 = r0.getVisibility();
        r4 = 8;
        if (r3 != r4) goto L_0x00be;
    L_0x0077:
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.g(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x007f:
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.h(r3);
        if (r3 == 0) goto L_0x00be;
    L_0x0087:
        r3 = r13.getAction();
        if (r3 != r2) goto L_0x00be;
    L_0x008d:
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.i(r3);
        r4 = com.tencent.mm.ui.base.f.i(r13, r1);
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1));
        if (r3 >= 0) goto L_0x00be;
    L_0x00a0:
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.j(r3);
        r4 = com.tencent.mm.ui.base.f.j(r13, r1);
        r3 = r3 - r4;
        r3 = java.lang.Math.abs(r3);
        r3 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1));
        if (r3 >= 0) goto L_0x00be;
    L_0x00b3:
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.k(r3);
        if (r3 != 0) goto L_0x00be;
    L_0x00bb:
        r11.mu(r2);
    L_0x00be:
        r3 = r13.getAction();
        if (r3 != r2) goto L_0x00c9;
    L_0x00c4:
        r3 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.l(r3);
    L_0x00c9:
        if (r0 == 0) goto L_0x00d3;
    L_0x00cb:
        r3 = com.tencent.mm.w.a.g.image;
        r0 = r0.findViewById(r3);
        if (r0 != 0) goto L_0x00d5;
    L_0x00d3:
        r0 = r1;
    L_0x00d4:
        return r0;
    L_0x00d5:
        r3 = r0 instanceof com.tencent.mm.ui.base.MultiTouchImageView;
        if (r3 == 0) goto L_0x0530;
    L_0x00d9:
        r3 = r11.uAo;
        r0 = (com.tencent.mm.ui.base.MultiTouchImageView) r0;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r3, r0);
        r0 = "dktest";
        r3 = new java.lang.StringBuilder;
        r4 = "MMGestureGallery onTouch event.getAction():";
        r3.<init>(r4);
        r4 = r13.getAction();
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);
        r0 = r13.getAction();
        if (r0 != 0) goto L_0x017b;
    L_0x0100:
        r11.czI();
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.a(r0);
        r0.crn();
        r0 = r11.uAo;
        r3 = r13.getX();
        com.tencent.mm.ui.tools.MMGestureGallery.c(r0, r3);
        r0 = r11.uAo;
        r3 = r13.getY();
        com.tencent.mm.ui.tools.MMGestureGallery.d(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.e(r0, r8);
        r0 = r11.uAo;
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getScale();
        com.tencent.mm.ui.tools.MMGestureGallery.f(r0, r3);
        r0 = "dktest";
        r3 = new java.lang.StringBuilder;
        r4 = "originalScale :";
        r3.<init>(r4);
        r4 = r11.uAo;
        r4 = com.tencent.mm.ui.tools.MMGestureGallery.m(r4);
        r3 = r3.append(r4);
        r3 = r3.toString();
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r1);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.n(r0);
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.o(r0);
        if (r0 != r2) goto L_0x036a;
    L_0x0160:
        r0 = r11.uAo;
        r4 = java.lang.System.currentTimeMillis();
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r4);
        r0 = r11.uAo;
        r3 = com.tencent.mm.ui.base.f.i(r13, r1);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
        r0 = r11.uAo;
        r3 = com.tencent.mm.ui.base.f.j(r13, r1);
        com.tencent.mm.ui.tools.MMGestureGallery.b(r0, r3);
    L_0x017b:
        r0 = r13.getAction();
        r3 = 6;
        if (r0 == r3) goto L_0x018a;
    L_0x0182:
        r0 = r13.getAction();
        r3 = 262; // 0x106 float:3.67E-43 double:1.294E-321;
        if (r0 != r3) goto L_0x023e;
    L_0x018a:
        r11.czJ();
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.e(r0, r8);
        r0 = r11.uAo;
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getScale();
        com.tencent.mm.ui.tools.MMGestureGallery.f(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r2);
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.m(r0);
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getScaleRate();
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 >= 0) goto L_0x01df;
    L_0x01ba:
        r0 = com.tencent.mm.ui.base.f.i(r13, r1);
        r3 = com.tencent.mm.ui.base.f.i(r13, r2);
        r0 = r0 - r3;
        r3 = com.tencent.mm.ui.base.f.j(r13, r1);
        r4 = com.tencent.mm.ui.base.f.j(r13, r2);
        r3 = r3 - r4;
        r4 = r11.uAo;
        r4 = com.tencent.mm.ui.tools.MMGestureGallery.a(r4);
        r5 = com.tencent.mm.ui.base.f.i(r13, r2);
        r0 = r0 + r5;
        r5 = com.tencent.mm.ui.base.f.j(r13, r2);
        r3 = r3 + r5;
        r4.T(r0, r3);
    L_0x01df:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.m(r0);
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getDoubleTabScale();
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r3 = r3 * r4;
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 <= 0) goto L_0x023e;
    L_0x01f6:
        r0 = com.tencent.mm.ui.base.f.i(r13, r1);
        r3 = com.tencent.mm.ui.base.f.i(r13, r2);
        r0 = r0 - r3;
        r3 = com.tencent.mm.ui.base.f.j(r13, r1);
        r4 = com.tencent.mm.ui.base.f.j(r13, r2);
        r3 = r3 - r4;
        r4 = r11.uAo;
        r4 = com.tencent.mm.ui.tools.MMGestureGallery.a(r4);
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.a(r5);
        r5 = r5.getDoubleTabScale();
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 * r6;
        r4.setMaxZoomLimit(r5);
        r4 = r11.uAo;
        r4 = com.tencent.mm.ui.tools.MMGestureGallery.a(r4);
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.a(r5);
        r5 = r5.getDoubleTabScale();
        r6 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r5 = r5 * r6;
        r6 = com.tencent.mm.ui.base.f.i(r13, r2);
        r0 = r0 + r6;
        r6 = com.tencent.mm.ui.base.f.j(r13, r2);
        r3 = r3 + r6;
        r4.h(r5, r0, r3);
    L_0x023e:
        r0 = r13.getAction();
        if (r0 != r2) goto L_0x0316;
    L_0x0244:
        r11.czJ();
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.r(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.s(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.l(r0);
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.t(r0);
        if (r0 != 0) goto L_0x0276;
    L_0x025e:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.u(r0);
        if (r0 != 0) goto L_0x0276;
    L_0x0266:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.v(r0);
        if (r0 != 0) goto L_0x0276;
    L_0x026e:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.w(r0);
        if (r0 == 0) goto L_0x0418;
    L_0x0276:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.x(r0);
        if (r0 != 0) goto L_0x0286;
    L_0x027e:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.y(r0);
        if (r0 == 0) goto L_0x0418;
    L_0x0286:
        r0 = r11.uAo;
        r3 = new com.tencent.mm.ui.tools.MMGestureGallery$h;
        r4 = r11.uAo;
        r3.<init>(r4);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.z(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.A(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.B(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.C(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.D(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.E(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.F(r0);
    L_0x02b5:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.e(r0, r8);
        r0 = r11.uAo;
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getScale();
        com.tencent.mm.ui.tools.MMGestureGallery.f(r0, r3);
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.o(r0);
        if (r0 != r2) goto L_0x0316;
    L_0x02d1:
        r0 = r11.uAo;
        r4 = java.lang.System.currentTimeMillis();
        com.tencent.mm.ui.tools.MMGestureGallery.c(r0, r4);
        r0 = r11.uAo;
        r4 = com.tencent.mm.ui.tools.MMGestureGallery.q(r0);
        r0 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.L(r0);
        r4 = r4 - r6;
        r6 = 350; // 0x15e float:4.9E-43 double:1.73E-321;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x04ea;
    L_0x02ed:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.i(r0);
        r3 = com.tencent.mm.ui.base.f.i(r13, r1);
        r0 = r0 - r3;
        r0 = java.lang.Math.abs(r0);
        r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r0 >= 0) goto L_0x0316;
    L_0x0300:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.j(r0);
        r3 = com.tencent.mm.ui.base.f.j(r13, r1);
        r0 = r0 - r3;
        r0 = java.lang.Math.abs(r0);
        r0 = (r0 > r9 ? 1 : (r0 == r9 ? 0 : -1));
        if (r0 >= 0) goto L_0x0316;
    L_0x0313:
        r11.mu(r1);
    L_0x0316:
        r0 = r13.getAction();
        r3 = 5;
        if (r0 == r3) goto L_0x0325;
    L_0x031d:
        r0 = r13.getAction();
        r3 = 261; // 0x105 float:3.66E-43 double:1.29E-321;
        if (r0 != r3) goto L_0x033e;
    L_0x0325:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.e(r0, r8);
        r0 = r11.uAo;
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getScale();
        com.tencent.mm.ui.tools.MMGestureGallery.f(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r2);
    L_0x033e:
        r0 = r13.getAction();
        r3 = 2;
        if (r0 != r3) goto L_0x0530;
    L_0x0345:
        r0 = com.tencent.mm.ui.base.f.L(r13);
        r3 = 2;
        if (r0 != r3) goto L_0x055d;
    L_0x034c:
        r11.czJ();
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.M(r0);
        if (r0 != 0) goto L_0x0367;
    L_0x0357:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.v(r0);
        if (r0 != 0) goto L_0x0367;
    L_0x035f:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.w(r0);
        if (r0 == 0) goto L_0x04fa;
    L_0x0367:
        r0 = r2;
        goto L_0x00d4;
    L_0x036a:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.o(r0);
        r3 = 2;
        if (r0 != r3) goto L_0x017b;
    L_0x0373:
        r0 = r11.uAo;
        r4 = java.lang.System.currentTimeMillis();
        com.tencent.mm.ui.tools.MMGestureGallery.b(r0, r4);
        r0 = r11.uAo;
        r4 = com.tencent.mm.ui.tools.MMGestureGallery.p(r0);
        r0 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.q(r0);
        r4 = r4 - r6;
        r6 = 350; // 0x15e float:4.9E-43 double:1.73E-321;
        r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r0 >= 0) goto L_0x0411;
    L_0x038f:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.i(r0);
        r3 = com.tencent.mm.ui.base.f.i(r13, r1);
        r0 = r0 - r3;
        r0 = java.lang.Math.abs(r0);
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 >= 0) goto L_0x040a;
    L_0x03a2:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.j(r0);
        r3 = com.tencent.mm.ui.base.f.j(r13, r1);
        r0 = r0 - r3;
        r0 = java.lang.Math.abs(r0);
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 >= 0) goto L_0x040a;
    L_0x03b5:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r1);
        r0 = "MicroMsg.MMGestureGallery";
        r3 = "double click!";
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.a(r0);
        r0 = r0.getScale();
        r3 = r11.uAo;
        r3 = com.tencent.mm.ui.tools.MMGestureGallery.a(r3);
        r3 = r3.getScaleRate();
        r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1));
        if (r0 > 0) goto L_0x03ee;
    L_0x03db:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.a(r0);
        r3 = com.tencent.mm.ui.base.f.i(r13, r1);
        r4 = com.tencent.mm.ui.base.f.j(r13, r1);
        r0.U(r3, r4);
        goto L_0x017b;
    L_0x03ee:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.a(r0);
        r3 = com.tencent.mm.ui.base.f.i(r13, r1);
        r4 = com.tencent.mm.ui.base.f.j(r13, r1);
        r0.T(r3, r4);
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.a(r0);
        r0.csa();
        goto L_0x017b;
    L_0x040a:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r2);
        goto L_0x017b;
    L_0x0411:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r2);
        goto L_0x017b;
    L_0x0418:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.v(r0);
        if (r0 != 0) goto L_0x0428;
    L_0x0420:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.t(r0);
        if (r0 == 0) goto L_0x0443;
    L_0x0428:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.C(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.A(r0);
        r0 = r11.uAo;
        r3 = new com.tencent.mm.ui.tools.MMGestureGallery$i;
        r4 = r11.uAo;
        r3.<init>(r4);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.z(r0);
    L_0x0443:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.w(r0);
        if (r0 != 0) goto L_0x0453;
    L_0x044b:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.u(r0);
        if (r0 == 0) goto L_0x046e;
    L_0x0453:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.D(r0);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.B(r0);
        r0 = r11.uAo;
        r3 = new com.tencent.mm.ui.tools.MMGestureGallery$j;
        r4 = r11.uAo;
        r3.<init>(r4);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.z(r0);
    L_0x046e:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.x(r0);
        if (r0 == 0) goto L_0x048c;
    L_0x0476:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.E(r0);
        r0 = r11.uAo;
        r3 = new com.tencent.mm.ui.tools.MMGestureGallery$k;
        r4 = r11.uAo;
        r3.<init>(r4);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.z(r0);
    L_0x048c:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.y(r0);
        if (r0 == 0) goto L_0x04aa;
    L_0x0494:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.F(r0);
        r0 = r11.uAo;
        r3 = new com.tencent.mm.ui.tools.MMGestureGallery$g;
        r4 = r11.uAo;
        r3.<init>(r4);
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r3);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.z(r0);
    L_0x04aa:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.G(r0);
        if (r0 == 0) goto L_0x04c8;
    L_0x04b2:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.H(r0);
        if (r0 == 0) goto L_0x04c3;
    L_0x04ba:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.H(r0);
        r0.O(r8, r8);
    L_0x04c3:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.b(r0, r1);
    L_0x04c8:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.I(r0);
        if (r0 == 0) goto L_0x02b5;
    L_0x04d0:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.J(r0);
        if (r0 != 0) goto L_0x02b5;
    L_0x04d8:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.K(r0);
        r4 = 0;
        r0.w(r4, r2);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.b(r0, r1);
        goto L_0x02b5;
    L_0x04ea:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r1);
        r0 = "MicroMsg.MMGestureGallery";
        r3 = "single long click over!";
        com.tencent.mm.sdk.platformtools.x.d(r0, r3);
        goto L_0x0316;
    L_0x04fa:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r2);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r1);
        r0 = com.tencent.mm.ui.base.f.i(r13, r1);
        r3 = com.tencent.mm.ui.base.f.i(r13, r2);
        r0 = r0 - r3;
        r3 = com.tencent.mm.ui.base.f.j(r13, r1);
        r4 = com.tencent.mm.ui.base.f.j(r13, r2);
        r3 = r3 - r4;
        r4 = r0 * r0;
        r5 = r3 * r3;
        r4 = r4 + r5;
        r4 = (double) r4;
        r4 = java.lang.Math.sqrt(r4);
        r4 = (float) r4;
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.N(r5);
        r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1));
        if (r5 != 0) goto L_0x0533;
    L_0x052b:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.e(r0, r4);
    L_0x0530:
        r0 = r1;
        goto L_0x00d4;
    L_0x0533:
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.N(r5);
        r4 = r4 / r5;
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.O(r5);
        if (r5 == 0) goto L_0x0530;
    L_0x0542:
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.a(r5);
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.m(r6);
        r4 = r4 * r6;
        r6 = com.tencent.mm.ui.base.f.i(r13, r2);
        r0 = r0 + r6;
        r2 = com.tencent.mm.ui.base.f.j(r13, r2);
        r2 = r2 + r3;
        r5.h(r4, r0, r2);
        goto L_0x0530;
    L_0x055d:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.f(r0);
        r3 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0.computeCurrentVelocity(r3);
        r3 = r0.getXVelocity();
        r3 = (int) r3;
        r0 = r0.getYVelocity();
        r0 = (int) r0;
        r4 = r13.getX();
        r5 = r11.uAo;
        r5 = com.tencent.mm.ui.tools.MMGestureGallery.P(r5);
        r4 = r4 - r5;
        r5 = r13.getY();
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.Q(r6);
        r5 = r5 - r6;
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.H(r6);
        if (r6 == 0) goto L_0x05fc;
    L_0x0590:
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.J(r6);
        if (r6 != 0) goto L_0x05fc;
    L_0x0598:
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.O(r6);
        if (r6 != 0) goto L_0x05fc;
    L_0x05a0:
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.m(r6);
        r7 = r11.uAo;
        r7 = com.tencent.mm.ui.tools.MMGestureGallery.a(r7);
        r7 = r7.getScaleRate();
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x05fc;
    L_0x05b4:
        r6 = r11.uAo;
        r6 = com.tencent.mm.ui.tools.MMGestureGallery.H(r6);
        r6.P(r4, r5);
        r6 = java.lang.Math.abs(r4);
        r7 = 1132068864; // 0x437a0000 float:250.0 double:5.593163344E-315;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 > 0) goto L_0x05db;
    L_0x05c7:
        r6 = java.lang.Math.abs(r0);
        r3 = java.lang.Math.abs(r3);
        if (r6 <= r3) goto L_0x05db;
    L_0x05d1:
        if (r0 <= 0) goto L_0x05db;
    L_0x05d3:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.k(r0);
        if (r0 == 0) goto L_0x05e3;
    L_0x05db:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.I(r0);
        if (r0 == 0) goto L_0x0643;
    L_0x05e3:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.H(r0);
        r0.O(r4, r5);
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.b(r0, r2);
    L_0x05f1:
        r0 = 1128792064; // 0x43480000 float:200.0 double:5.5769738E-315;
        r0 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1));
        if (r0 <= 0) goto L_0x0649;
    L_0x05f7:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.c(r0, r1);
    L_0x05fc:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.f(r0);
        if (r0 == 0) goto L_0x0613;
    L_0x0604:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.f(r0);
        r0.recycle();
        r0 = r11.uAo;
        r2 = 0;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r2);
    L_0x0613:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.i(r0);
        r2 = com.tencent.mm.ui.base.f.i(r13, r1);
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 > 0) goto L_0x0639;
    L_0x0626:
        r0 = r11.uAo;
        r0 = com.tencent.mm.ui.tools.MMGestureGallery.j(r0);
        r2 = com.tencent.mm.ui.base.f.j(r13, r1);
        r0 = r0 - r2;
        r0 = java.lang.Math.abs(r0);
        r0 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
        if (r0 <= 0) goto L_0x0530;
    L_0x0639:
        r11.czJ();
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.a(r0, r1);
        goto L_0x0530;
    L_0x0643:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.b(r0, r1);
        goto L_0x05f1;
    L_0x0649:
        r0 = r11.uAo;
        com.tencent.mm.ui.tools.MMGestureGallery.c(r0, r2);
        goto L_0x05fc;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.tools.MMGestureGallery$1.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void mu(boolean z) {
        MMGestureGallery.K(this.uAo).w(350, z);
    }
}
