package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;

public final class m implements OnTouchListener {
    private static boolean DEBUG = false;
    private static int qQr;
    private static int um = ViewConfiguration.getTapTimeout();
    String fmS;
    private n qQn = null;
    private boolean qQo = false;
    private View qQp = null;
    private boolean qQq = false;
    private Context qQs = null;
    private ag qQt = new ag(Looper.getMainLooper());
    private b qQu = new b(this, (byte) 0);
    private a qQv = new a();
    private View view;

    class a implements Runnable {
        a() {
        }

        public final void run() {
            if (m.this.view != null && m.this.view.isPressed()) {
                x.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                m.this.qQq = true;
                m.this.aXL();
            }
        }
    }

    private class b implements Runnable {
        private b() {
        }

        /* synthetic */ b(m mVar, byte b) {
            this();
        }

        public final void run() {
            m.this.Cs(m.um);
        }
    }

    static {
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        qQr = longPressTimeout;
        if (longPressTimeout > um * 2) {
            qQr -= um;
        }
        x.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(qQr));
    }

    public m(Context context) {
        this.qQs = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        r11 = this;
        r0 = r12 instanceof android.widget.TextView;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r0 = r13.getAction();
        if (r0 != 0) goto L_0x0028;
    L_0x0010:
        r0 = 2;
        r0 = new int[r0];
        r1 = 0;
        r2 = r13.getRawX();
        r2 = (int) r2;
        r0[r1] = r2;
        r1 = 1;
        r2 = r13.getRawY();
        r2 = (int) r2;
        r0[r1] = r2;
        r1 = com.tencent.mm.plugin.comm.a.e.touch_loc;
        r12.setTag(r1, r0);
    L_0x0028:
        r11.view = r12;
        r0 = r12 instanceof android.widget.TextView;
        if (r0 == 0) goto L_0x0136;
    L_0x002e:
        r0 = r12;
        r0 = (android.widget.TextView) r0;
        r2 = r0.getLayout();
        r0 = r12;
        r0 = (android.widget.TextView) r0;
        r1 = r0.getText();
        r3 = r2;
    L_0x003d:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x008e;
    L_0x0041:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "ontouch action: %d, isLongPress:%b ";
        r2.<init>(r4);
        r2 = r2.append(r3);
        r4 = " ";
        r2 = r2.append(r4);
        r4 = r1 instanceof android.text.Spanned;
        r2 = r2.append(r4);
        r4 = " ";
        r2 = r2.append(r4);
        r4 = com.tencent.mm.sdk.platformtools.bi.cjd();
        r4 = r4.toString();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r13.getAction();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r11.qQq;
        r6 = java.lang.Boolean.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.d(r0, r2, r4);
    L_0x008e:
        r5 = android.view.MotionEvent.obtain(r13);
        r0 = r1 instanceof android.text.Spanned;
        if (r0 == 0) goto L_0x00df;
    L_0x0096:
        if (r3 == 0) goto L_0x00df;
    L_0x0098:
        r0 = r1;
        r0 = (android.text.Spanned) r0;
        r2 = r5.getAction();
        r12.invalidate();
        if (r12 == 0) goto L_0x00ac;
    L_0x00a4:
        if (r0 == 0) goto L_0x00ac;
    L_0x00a6:
        r4 = com.tencent.mm.pluginsdk.ui.d.e.a(r12, r0);
        if (r4 != 0) goto L_0x00df;
    L_0x00ac:
        r4 = 1;
        if (r2 == r4) goto L_0x00b7;
    L_0x00af:
        if (r2 == 0) goto L_0x00b7;
    L_0x00b1:
        r4 = 2;
        if (r2 == r4) goto L_0x00b7;
    L_0x00b4:
        r4 = 3;
        if (r2 != r4) goto L_0x0275;
    L_0x00b7:
        r2 = r5.getX();
        r4 = (int) r2;
        r2 = r5.getY();
        r6 = (int) r2;
        r2 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r2 == 0) goto L_0x0163;
    L_0x00c5:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.getHorizontalDrawOffset();
        if (r4 < r2) goto L_0x00dc;
    L_0x00ce:
        r7 = r3.getWidth();
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.getHorizontalDrawOffset();
        r2 = r2 + r7;
        if (r4 <= r2) goto L_0x0147;
    L_0x00dc:
        r11.H(r5);
    L_0x00df:
        r5.recycle();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0133;
    L_0x00e6:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "ontouch action2: %d, isLongPress:%b ";
        r2.<init>(r4);
        r2 = r2.append(r3);
        r3 = " ";
        r2 = r2.append(r3);
        r1 = r1 instanceof android.text.Spanned;
        r1 = r2.append(r1);
        r2 = " processResult: false ";
        r1 = r1.append(r2);
        r2 = com.tencent.mm.sdk.platformtools.bi.cjd();
        r2 = r2.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.getAction();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r11.qQq;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.x.d(r0, r1, r2);
    L_0x0133:
        r0 = 0;
        goto L_0x0009;
    L_0x0136:
        r0 = r12;
        r0 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r0;
        r2 = r0.getTvLayout();
        r0 = r12;
        r0 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r0;
        r1 = r0.getText();
        r3 = r2;
        goto L_0x003d;
    L_0x0147:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.getVerticalDrawOffset();
        if (r6 < r2) goto L_0x015e;
    L_0x0150:
        r7 = r3.getHeight();
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.getVerticalDrawOffset();
        r2 = r2 + r7;
        if (r6 <= r2) goto L_0x019f;
    L_0x015e:
        r11.H(r5);
        goto L_0x00df;
    L_0x0163:
        r2 = r12 instanceof android.widget.TextView;
        if (r2 == 0) goto L_0x019f;
    L_0x0167:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        if (r4 < r2) goto L_0x017e;
    L_0x0170:
        r7 = r3.getWidth();
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        r2 = r2 + r7;
        if (r4 <= r2) goto L_0x0183;
    L_0x017e:
        r11.H(r5);
        goto L_0x00df;
    L_0x0183:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        if (r6 < r2) goto L_0x019a;
    L_0x018c:
        r7 = r3.getHeight();
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        r2 = r2 + r7;
        if (r6 <= r2) goto L_0x019f;
    L_0x019a:
        r11.H(r5);
        goto L_0x00df;
    L_0x019f:
        r2 = r12 instanceof android.widget.TextView;
        if (r2 == 0) goto L_0x0295;
    L_0x01a3:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        r4 = r4 - r2;
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        r2 = r6 - r2;
    L_0x01b4:
        r6 = r12.getScrollX();
        r4 = r4 + r6;
        r6 = r12.getScrollY();
        r2 = r2 + r6;
        r2 = r3.getLineForVertical(r2);
        r4 = (float) r4;
        r2 = r3.getOffsetForHorizontal(r2, r4);
        r4 = r12 instanceof android.widget.TextView;
        if (r4 == 0) goto L_0x01d3;
    L_0x01cb:
        r4 = r0.length();
        if (r2 >= r4) goto L_0x01d3;
    L_0x01d1:
        r2 = r2 + 1;
    L_0x01d3:
        r4 = r5.getAction();
        r6 = com.tencent.mm.pluginsdk.ui.d.n.class;
        r0 = r0.getSpans(r2, r2, r6);
        r0 = (com.tencent.mm.pluginsdk.ui.d.n[]) r0;
        r2 = r0.length;
        r2 = r2 + -1;
        r6 = DEBUG;
        if (r6 == 0) goto L_0x0234;
    L_0x01e6:
        r6 = "MicroMsg.PressSpanTouchListener";
        r7 = new java.lang.StringBuilder;
        r8 = "processPress action: %d, isLongPress:%b ";
        r7.<init>(r8);
        r8 = r0.length;
        r7 = r7.append(r8);
        r8 = " ";
        r7 = r7.append(r8);
        r8 = r11.qQn;
        r7 = r7.append(r8);
        r8 = " ";
        r7 = r7.append(r8);
        r8 = com.tencent.mm.sdk.platformtools.bi.cjd();
        r8 = r8.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.getAction();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r11.qQq;
        r10 = java.lang.Boolean.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.x.d(r6, r7, r8);
    L_0x0234:
        r6 = r0.length;
        if (r6 == 0) goto L_0x03c8;
    L_0x0237:
        r6 = 1;
        if (r4 != r6) goto L_0x0309;
    L_0x023a:
        r0 = r11.qQt;
        r2 = r11.qQu;
        r0.removeCallbacks(r2);
        r0 = r11.qQt;
        r2 = r11.qQv;
        r0.removeCallbacks(r2);
        r0 = r11.qQq;
        if (r0 == 0) goto L_0x02b9;
    L_0x024c:
        r11.aXL();
        r0 = 0;
        r11.qQq = r0;
        r0 = r11.qQo;
        r12.setClickable(r0);
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x025b:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action1 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
    L_0x0275:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x00df;
    L_0x0279:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processTouch action2 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x00df;
    L_0x0295:
        r2 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r2 == 0) goto L_0x02ac;
    L_0x0299:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.getHorizontalDrawOffset();
        r4 = r4 - r2;
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.getVerticalDrawOffset();
        r2 = r6 - r2;
        goto L_0x01b4;
    L_0x02ac:
        r2 = r12.getPaddingLeft();
        r4 = r4 - r2;
        r2 = r12.getPaddingTop();
        r2 = r6 - r2;
        goto L_0x01b4;
    L_0x02b9:
        r0 = 0;
        r11.qQq = r0;
        r0 = r11.qQn;
        if (r0 == 0) goto L_0x02ff;
    L_0x02c0:
        r0 = r11.qQn;
        r2 = r11.fmS;
        r0.setSessionId(r2);
        r0 = r11.qQs;
        if (r0 == 0) goto L_0x02d2;
    L_0x02cb:
        r0 = r11.qQn;
        r2 = r11.qQs;
        r0.setContext(r2);
    L_0x02d2:
        r0 = r11.qQn;
        r0.onClick(r12);
    L_0x02d7:
        r0 = r11.qQo;
        r12.setClickable(r0);
        r11.aXL();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x02e3:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action2 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x0275;
    L_0x02ff:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = "ACTION_UP error, lastClickSpan is null";
        com.tencent.mm.sdk.platformtools.x.e(r0, r2);
        goto L_0x02d7;
    L_0x0309:
        if (r4 == 0) goto L_0x030e;
    L_0x030b:
        r6 = 2;
        if (r4 != r6) goto L_0x038f;
    L_0x030e:
        if (r4 != 0) goto L_0x0318;
    L_0x0310:
        r6 = qQr;
        if (r6 <= 0) goto L_0x0318;
    L_0x0314:
        r6 = 0;
        r11.Cs(r6);
    L_0x0318:
        if (r4 != 0) goto L_0x0320;
    L_0x031a:
        r4 = r12.isClickable();
        r11.qQo = r4;
    L_0x0320:
        r11.aXL();
        r4 = r0[r2];
        r11.qQn = r4;
        r11.qQp = r12;
        r4 = r0[r2];
        r6 = 0;
        r4.setContext(r6);
        r4 = r0[r2];
        r6 = 1;
        r4.lmQ = r6;
        r4 = r0[r2];
        r6 = 1;
        r4.mEnable = r6;
        r12.invalidate();
        r4 = r11.qQq;
        if (r4 == 0) goto L_0x036f;
    L_0x0340:
        r4 = r0[r2];
        r6 = 0;
        r4.lmQ = r6;
        r0 = r0[r2];
        r2 = 0;
        r0.mEnable = r2;
        r0 = r11.qQo;
        r12.setClickable(r0);
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x0353:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action3 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x0275;
    L_0x036f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x0373:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action4 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x0275;
    L_0x038f:
        r0 = 3;
        if (r4 != r0) goto L_0x03cb;
    L_0x0392:
        r0 = r11.qQt;
        r2 = r11.qQu;
        r0.removeCallbacks(r2);
        r0 = r11.qQt;
        r2 = r11.qQv;
        r0.removeCallbacks(r2);
        r0 = r11.qQo;
        r12.setClickable(r0);
        r11.aXL();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x03ac:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action5 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x0275;
    L_0x03c8:
        r11.aXL();
    L_0x03cb:
        r0 = 1;
        if (r4 != r0) goto L_0x03d1;
    L_0x03ce:
        r0 = 0;
        r11.qQq = r0;
    L_0x03d1:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0275;
    L_0x03d5:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action6 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.x.i(r0, r2);
        goto L_0x0275;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.d.m.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void H(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            aXL();
        }
    }

    public final void aXL() {
        if (this.qQn != null) {
            this.qQn.lmQ = false;
            this.qQn.setContext(null);
            this.qQp.invalidate();
            this.qQp = null;
            this.qQn = null;
        }
    }

    private void Cs(int i) {
        if (this.view != null) {
            this.qQt.postDelayed(this.qQv, (long) (qQr - i));
        }
    }
}
