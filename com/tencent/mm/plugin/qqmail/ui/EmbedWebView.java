package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView extends MMWebView {
    private GestureDetector mgc = new GestureDetector(new 1(this));
    private boolean mgd = false;
    private float[] mge = new float[2];
    private float[] mgf = new float[2];
    private float[] mgg = new float[2];
    private float[] mgh = new float[2];

    public EmbedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        postDelayed(new 2(this), 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r10 = 1184645120; // 0x469c4000 float:20000.0 double:5.852924563E-315;
        r8 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r0 = 1;
        r1 = 0;
        r2 = r11.mgc;
        r2.onTouchEvent(r12);
        r2 = r11.mgd;
        if (r2 == 0) goto L_0x001f;
    L_0x0010:
        r2 = r12.getAction();
        r2 = r2 & 255;
        r3 = r12.getPointerCount();
        r4 = 2;
        if (r3 == r4) goto L_0x0024;
    L_0x001d:
        if (r1 != 0) goto L_0x0023;
    L_0x001f:
        r0 = super.onTouchEvent(r12);
    L_0x0023:
        return r0;
    L_0x0024:
        switch(r2) {
            case 2: goto L_0x003e;
            case 3: goto L_0x0027;
            case 4: goto L_0x0027;
            case 5: goto L_0x0029;
            default: goto L_0x0027;
        };
    L_0x0027:
        r1 = r0;
        goto L_0x001d;
    L_0x0029:
        if (r1 >= r3) goto L_0x0027;
    L_0x002b:
        r2 = r11.mge;
        r4 = r12.getX(r1);
        r2[r1] = r4;
        r2 = r11.mgf;
        r4 = r12.getY(r1);
        r2[r1] = r4;
        r1 = r1 + 1;
        goto L_0x0029;
    L_0x003e:
        r2 = r1;
    L_0x003f:
        if (r2 >= r3) goto L_0x0054;
    L_0x0041:
        r4 = r11.mgg;
        r5 = r12.getX(r2);
        r4[r2] = r5;
        r4 = r11.mgh;
        r5 = r12.getY(r2);
        r4[r2] = r5;
        r2 = r2 + 1;
        goto L_0x003f;
    L_0x0054:
        r2 = r11.mge;
        r2 = r2[r0];
        r3 = r11.mge;
        r3 = r3[r1];
        r2 = r2 - r3;
        r2 = (double) r2;
        r2 = java.lang.Math.pow(r2, r8);
        r4 = r11.mgf;
        r4 = r4[r0];
        r5 = r11.mgf;
        r5 = r5[r1];
        r4 = r4 - r5;
        r4 = (double) r4;
        r4 = java.lang.Math.pow(r4, r8);
        r2 = r2 + r4;
        r2 = (float) r2;
        r3 = r11.mgg;
        r3 = r3[r0];
        r4 = r11.mgg;
        r4 = r4[r1];
        r3 = r3 - r4;
        r4 = (double) r3;
        r4 = java.lang.Math.pow(r4, r8);
        r3 = r11.mgh;
        r3 = r3[r0];
        r6 = r11.mgh;
        r6 = r6[r1];
        r3 = r3 - r6;
        r6 = (double) r3;
        r6 = java.lang.Math.pow(r6, r8);
        r4 = r4 + r6;
        r3 = (float) r4;
        r4 = r2 - r3;
        r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x00bb;
    L_0x0096:
        r11.zoomOut();
    L_0x0099:
        r2 = r11.mge;
        r3 = r11.mgg;
        r3 = r3[r1];
        r2[r1] = r3;
        r2 = r11.mge;
        r3 = r11.mgg;
        r3 = r3[r0];
        r2[r0] = r3;
        r2 = r11.mgf;
        r3 = r11.mgh;
        r3 = r3[r1];
        r2[r1] = r3;
        r1 = r11.mgf;
        r2 = r11.mgh;
        r2 = r2[r0];
        r1[r0] = r2;
        goto L_0x0027;
    L_0x00bb:
        r2 = r3 - r2;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0099;
    L_0x00c1:
        r11.zoomIn();
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.ui.EmbedWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
