package com.tencent.mm.plugin.sns.ui;

import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.o;

public final class ab implements OnTouchListener {
    private static o nOI;
    private static TextView nOJ;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
        r9 = this;
        r8 = 2;
        r5 = 1;
        r4 = 0;
        r10 = (android.widget.TextView) r10;
        r10.getTag();
        r1 = r10.getText();
        r0 = r10.getLayout();
        if (r0 != 0) goto L_0x001d;
    L_0x0012:
        r2 = r10 instanceof com.tencent.mm.kiss.widget.textview.SysTextView;
        if (r2 == 0) goto L_0x001d;
    L_0x0016:
        r0 = r10;
        r0 = (com.tencent.mm.kiss.widget.textview.SysTextView) r0;
        r0 = r0.getTvLayout();
    L_0x001d:
        r2 = r1 instanceof android.text.Spannable;
        if (r2 == 0) goto L_0x0179;
    L_0x0021:
        if (r0 == 0) goto L_0x0179;
    L_0x0023:
        r0 = r1;
        r0 = (android.text.Spannable) r0;
        r3 = r11.getAction();
        r1 = r10.getLayout();
        if (r1 != 0) goto L_0x017c;
    L_0x0030:
        r2 = r10 instanceof com.tencent.mm.kiss.widget.textview.SysTextView;
        if (r2 == 0) goto L_0x017c;
    L_0x0034:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.SysTextView) r1;
        r1 = r1.getTvLayout();
        r2 = r1;
    L_0x003c:
        r10.invalidate();
        if (r10 == 0) goto L_0x004b;
    L_0x0041:
        if (r0 == 0) goto L_0x004b;
    L_0x0043:
        r1 = com.tencent.mm.pluginsdk.ui.d.e.a(r10, r0);
        if (r1 == 0) goto L_0x004b;
    L_0x0049:
        r0 = r4;
    L_0x004a:
        return r0;
    L_0x004b:
        if (r3 == r5) goto L_0x0051;
    L_0x004d:
        if (r3 == 0) goto L_0x0051;
    L_0x004f:
        if (r3 != r8) goto L_0x0173;
    L_0x0051:
        r1 = r11.getX();
        r3 = (int) r1;
        r1 = r11.getY();
        r6 = (int) r1;
        r1 = r10 instanceof com.tencent.mm.kiss.widget.textview.PLSysTextView;
        if (r1 == 0) goto L_0x0091;
    L_0x005f:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.getHorizontalDrawOffset();
        if (r3 < r1) goto L_0x0076;
    L_0x0068:
        r7 = r2.getWidth();
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.getHorizontalDrawOffset();
        r1 = r1 + r7;
        if (r3 <= r1) goto L_0x0078;
    L_0x0076:
        r0 = r4;
        goto L_0x004a;
    L_0x0078:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.getVerticalDrawOffset();
        if (r6 < r1) goto L_0x008f;
    L_0x0081:
        r7 = r2.getHeight();
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.getVerticalDrawOffset();
        r1 = r1 + r7;
        if (r6 <= r1) goto L_0x00bb;
    L_0x008f:
        r0 = r4;
        goto L_0x004a;
    L_0x0091:
        r1 = r10 instanceof android.widget.TextView;
        if (r1 == 0) goto L_0x00bb;
    L_0x0095:
        r1 = r10.getTotalPaddingLeft();
        if (r3 < r1) goto L_0x00a6;
    L_0x009b:
        r1 = r2.getWidth();
        r7 = r10.getTotalPaddingLeft();
        r1 = r1 + r7;
        if (r3 <= r1) goto L_0x00a8;
    L_0x00a6:
        r0 = r4;
        goto L_0x004a;
    L_0x00a8:
        r1 = r10.getTotalPaddingTop();
        if (r6 < r1) goto L_0x00b9;
    L_0x00ae:
        r1 = r2.getHeight();
        r7 = r10.getTotalPaddingTop();
        r1 = r1 + r7;
        if (r6 <= r1) goto L_0x00bb;
    L_0x00b9:
        r0 = r4;
        goto L_0x004a;
    L_0x00bb:
        r1 = r10 instanceof com.tencent.mm.kiss.widget.textview.PLSysTextView;
        if (r1 == 0) goto L_0x0138;
    L_0x00bf:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.getHorizontalDrawOffset();
        r3 = r3 - r1;
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.getVerticalDrawOffset();
        r1 = r6 - r1;
    L_0x00d0:
        r6 = r10.getScrollX();
        r3 = r3 + r6;
        r6 = r10.getScrollY();
        r1 = r1 + r6;
        r1 = r2.getLineForVertical(r1);
        r3 = (float) r3;
        r1 = r2.getOffsetForHorizontal(r1, r3);
        r2 = r11.getAction();
        r3 = com.tencent.mm.pluginsdk.ui.d.o.class;
        r0 = r0.getSpans(r1, r1, r3);
        r0 = (com.tencent.mm.pluginsdk.ui.d.o[]) r0;
        r1 = r0.length;
        r3 = r1 + -1;
        r1 = "MicroMsg.MMOnTouchListener";
        r6 = new java.lang.StringBuilder;
        r7 = " action span Len: ";
        r6.<init>(r7);
        r7 = r0.length;
        r6 = r6.append(r7);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.x.d(r1, r6);
        r1 = r10.getLayout();
        if (r1 != 0) goto L_0x0119;
    L_0x010f:
        r1 = r10 instanceof com.tencent.mm.kiss.widget.textview.SysTextView;
        if (r1 == 0) goto L_0x0119;
    L_0x0113:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.SysTextView) r1;
        r1.getTvLayout();
    L_0x0119:
        r1 = r0.length;
        if (r1 == 0) goto L_0x016e;
    L_0x011c:
        if (r2 != r5) goto L_0x0155;
    L_0x011e:
        r0 = r0[r3];
        r0.onClick(r10);
        r0 = new com.tencent.mm.sdk.platformtools.ag;
        r0.<init>();
        r1 = new com.tencent.mm.plugin.sns.ui.ab$1;
        r1.<init>(r9);
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0.postDelayed(r1, r2);
        r0 = r5;
    L_0x0133:
        if (r0 == 0) goto L_0x0173;
    L_0x0135:
        r0 = r5;
        goto L_0x004a;
    L_0x0138:
        r1 = r10 instanceof android.widget.TextView;
        if (r1 == 0) goto L_0x0148;
    L_0x013c:
        r1 = r10.getTotalPaddingLeft();
        r3 = r3 - r1;
        r1 = r10.getTotalPaddingTop();
        r1 = r6 - r1;
        goto L_0x00d0;
    L_0x0148:
        r1 = r10.getPaddingLeft();
        r3 = r3 - r1;
        r1 = r10.getPaddingTop();
        r1 = r6 - r1;
        goto L_0x00d0;
    L_0x0155:
        if (r2 == 0) goto L_0x015c;
    L_0x0157:
        if (r2 == r8) goto L_0x015c;
    L_0x0159:
        r1 = 3;
        if (r2 != r1) goto L_0x0171;
    L_0x015c:
        bCj();
        r1 = r0[r3];
        nOI = r1;
        nOJ = r10;
        r0 = r0[r3];
        r0.lmQ = r5;
        r10.invalidate();
        r0 = r5;
        goto L_0x0133;
    L_0x016e:
        bCj();
    L_0x0171:
        r0 = r4;
        goto L_0x0133;
    L_0x0173:
        bCj();
        r0 = r4;
        goto L_0x004a;
    L_0x0179:
        r0 = r4;
        goto L_0x004a;
    L_0x017c:
        r2 = r1;
        goto L_0x003c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.ab.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public static void bCj() {
        if (nOI != null) {
            nOI.lmQ = false;
            nOJ.invalidate();
            nOJ = null;
            nOI = null;
        }
    }
}
