package android.support.v7.widget.a;

class a$1 implements Runnable {
    final /* synthetic */ a Yc;

    a$1(a aVar) {
        this.Yc = aVar;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
        r14 = this;
        r12 = -9223372036854775808;
        r6 = 0;
        r8 = 0;
        r0 = r14.Yc;
        r0 = r0.XG;
        if (r0 == 0) goto L_0x00df;
    L_0x000a:
        r9 = r14.Yc;
        r0 = r9.XG;
        if (r0 == 0) goto L_0x0136;
    L_0x0010:
        r10 = java.lang.System.currentTimeMillis();
        r0 = r9.Yb;
        r0 = (r0 > r12 ? 1 : (r0 == r12 ? 0 : -1));
        if (r0 != 0) goto L_0x00e0;
    L_0x001a:
        r4 = 0;
    L_0x001c:
        r0 = r9.Sa;
        r0 = r0.getLayoutManager();
        r1 = r9.ea;
        if (r1 != 0) goto L_0x002d;
    L_0x0026:
        r1 = new android.graphics.Rect;
        r1.<init>();
        r9.ea = r1;
    L_0x002d:
        r1 = r9.XG;
        r1 = r1.SU;
        r2 = r9.ea;
        r0.a(r1, r2);
        r1 = r0.eZ();
        if (r1 == 0) goto L_0x010b;
    L_0x003c:
        r1 = r9.XN;
        r2 = r9.XL;
        r1 = r1 + r2;
        r1 = (int) r1;
        r2 = r9.ea;
        r2 = r2.left;
        r2 = r1 - r2;
        r3 = r9.Sa;
        r3 = r3.getPaddingLeft();
        r3 = r2 - r3;
        r2 = r9.XL;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 >= 0) goto L_0x00e6;
    L_0x0056:
        if (r3 >= 0) goto L_0x00e6;
    L_0x0058:
        r0 = r0.fa();
        if (r0 == 0) goto L_0x0133;
    L_0x005e:
        r0 = r9.XO;
        r1 = r9.XM;
        r0 = r0 + r1;
        r0 = (int) r0;
        r1 = r9.ea;
        r1 = r1.top;
        r1 = r0 - r1;
        r2 = r9.Sa;
        r2 = r2.getPaddingTop();
        r7 = r1 - r2;
        r1 = r9.XM;
        r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r1 >= 0) goto L_0x010e;
    L_0x0078:
        if (r7 >= 0) goto L_0x010e;
    L_0x007a:
        if (r3 == 0) goto L_0x013c;
    L_0x007c:
        r0 = r9.XP;
        r1 = r9.Sa;
        r2 = r9.XG;
        r2 = r2.SU;
        r2 = r2.getWidth();
        r8 = r9.Sa;
        r8.getWidth();
        r3 = r0.a(r1, r2, r3, r4);
        r8 = r3;
    L_0x0092:
        if (r7 == 0) goto L_0x0139;
    L_0x0094:
        r0 = r9.XP;
        r1 = r9.Sa;
        r2 = r9.XG;
        r2 = r2.SU;
        r2 = r2.getHeight();
        r3 = r9.Sa;
        r3.getHeight();
        r3 = r7;
        r0 = r0.a(r1, r2, r3, r4);
    L_0x00aa:
        if (r8 != 0) goto L_0x00ae;
    L_0x00ac:
        if (r0 == 0) goto L_0x0136;
    L_0x00ae:
        r2 = r9.Yb;
        r1 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1));
        if (r1 != 0) goto L_0x00b6;
    L_0x00b4:
        r9.Yb = r10;
    L_0x00b6:
        r1 = r9.Sa;
        r1.scrollBy(r8, r0);
        r6 = 1;
    L_0x00bc:
        if (r6 == 0) goto L_0x00df;
    L_0x00be:
        r0 = r14.Yc;
        r0 = r0.XG;
        if (r0 == 0) goto L_0x00cd;
    L_0x00c4:
        r0 = r14.Yc;
        r1 = r14.Yc;
        r1 = r1.XG;
        android.support.v7.widget.a.a.a(r0, r1);
    L_0x00cd:
        r0 = r14.Yc;
        r0 = r0.Sa;
        r1 = r14.Yc;
        r1 = r1.XU;
        r0.removeCallbacks(r1);
        r0 = r14.Yc;
        r0 = r0.Sa;
        android.support.v4.view.z.a(r0, r14);
    L_0x00df:
        return;
    L_0x00e0:
        r0 = r9.Yb;
        r4 = r10 - r0;
        goto L_0x001c;
    L_0x00e6:
        r2 = r9.XL;
        r2 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1));
        if (r2 <= 0) goto L_0x010b;
    L_0x00ec:
        r2 = r9.XG;
        r2 = r2.SU;
        r2 = r2.getWidth();
        r1 = r1 + r2;
        r2 = r9.ea;
        r2 = r2.right;
        r1 = r1 + r2;
        r2 = r9.Sa;
        r2 = r2.getWidth();
        r3 = r9.Sa;
        r3 = r3.getPaddingRight();
        r2 = r2 - r3;
        r3 = r1 - r2;
        if (r3 > 0) goto L_0x0058;
    L_0x010b:
        r3 = r6;
        goto L_0x0058;
    L_0x010e:
        r1 = r9.XM;
        r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1));
        if (r1 <= 0) goto L_0x0133;
    L_0x0114:
        r1 = r9.XG;
        r1 = r1.SU;
        r1 = r1.getHeight();
        r0 = r0 + r1;
        r1 = r9.ea;
        r1 = r1.bottom;
        r0 = r0 + r1;
        r1 = r9.Sa;
        r1 = r1.getHeight();
        r2 = r9.Sa;
        r2 = r2.getPaddingBottom();
        r1 = r1 - r2;
        r7 = r0 - r1;
        if (r7 > 0) goto L_0x007a;
    L_0x0133:
        r7 = r6;
        goto L_0x007a;
    L_0x0136:
        r9.Yb = r12;
        goto L_0x00bc;
    L_0x0139:
        r0 = r7;
        goto L_0x00aa;
    L_0x013c:
        r8 = r3;
        goto L_0x0092;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.a.a$1.run():void");
    }
}
