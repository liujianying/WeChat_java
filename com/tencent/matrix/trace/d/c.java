package com.tencent.matrix.trace.d;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.util.SparseArray;
import android.view.ViewTreeObserver.OnDrawListener;
import com.tencent.matrix.d.b;
import java.util.HashMap;
import java.util.LinkedList;

public final class c extends a implements OnDrawListener, com.tencent.matrix.trace.c.a.a {
    private final com.tencent.matrix.trace.a.a bsS;
    private com.tencent.matrix.trace.c.a btJ;
    private boolean bum = false;
    private HashMap<String, Integer> bun;
    private SparseArray<String> buo;
    private LinkedList<Integer> bup;
    private SparseArray<LinkedList<Integer>> buq;

    private enum a {
        DROPPED_FROZEN(4),
        DROPPED_HIGH(3),
        DROPPED_MIDDLE(2),
        DROPPED_NORMAL(1),
        DROPPED_BEST(0);
        
        int index;

        private a(int i) {
            this.index = i;
        }
    }

    public c(com.tencent.matrix.trace.a aVar, com.tencent.matrix.trace.a.a aVar2) {
        super(aVar);
        this.bsS = aVar2;
        this.bup = new LinkedList();
        this.bun = new HashMap();
        this.buo = new SparseArray();
        this.buq = new SparseArray();
        this.btJ = new com.tencent.matrix.trace.c.a(com.tencent.matrix.d.a.tJ(), aVar2.bte);
    }

    public final void onActivityCreated(Activity activity) {
        super.onActivityCreated(activity);
    }

    public final void onFront(Activity activity) {
        super.onFront(activity);
        if (this.btJ != null) {
            this.btJ.cancel();
            this.btJ.a(this, true);
        }
    }

    public final void onBackground(Activity activity) {
        super.onBackground(activity);
        if (this.btJ != null) {
            this.btJ.cancel();
            this.btJ.a(this, false);
        }
    }

    public final void onDestroy() {
        super.onDestroy();
        if (this.btJ != null) {
            this.btJ.cancel();
            this.btJ = null;
        }
        if (this.bun != null) {
            this.bun.clear();
            this.bun = null;
        }
        if (this.buo != null) {
            this.buo.clear();
            this.buo = null;
        }
        if (this.bup != null) {
            this.bup.clear();
            this.bup = null;
        }
        if (this.buq != null) {
            this.buq.clear();
            this.buq = null;
        }
    }

    public final void onDraw() {
        this.bum = true;
    }

    protected final String getTag() {
        return "Trace_FPS";
    }

    public final void onChange(final Activity activity, Fragment fragment) {
        super.onChange(activity, fragment);
        b.i("Matrix.FPSTracer", "[onChange] activity:%s", activity.getClass().getSimpleName());
        activity.getWindow().getDecorView().post(new Runnable() {
            public final void run() {
                activity.getWindow().getDecorView().getViewTreeObserver().removeOnDrawListener(c.this);
                activity.getWindow().getDecorView().getViewTreeObserver().addOnDrawListener(c.this);
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void tG() {
        /*
        r20 = this;
        r0 = r20;
        r3 = r0.bup;
        monitor-enter(r3);
        r0 = r20;
        r2 = r0.bup;	 Catch:{ all -> 0x0059 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x0059 }
        if (r2 == 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r3);	 Catch:{ all -> 0x0059 }
    L_0x0010:
        return;
    L_0x0011:
        r0 = r20;
        r4 = r0.bup;	 Catch:{ all -> 0x0059 }
        r2 = new java.util.LinkedList;	 Catch:{ all -> 0x0059 }
        r2.<init>();	 Catch:{ all -> 0x0059 }
        r0 = r20;
        r0.bup = r2;	 Catch:{ all -> 0x0059 }
        monitor-exit(r3);	 Catch:{ all -> 0x0059 }
        r3 = r4.iterator();
    L_0x0023:
        r2 = r3.hasNext();
        if (r2 == 0) goto L_0x005c;
    L_0x0029:
        r2 = r3.next();
        r2 = (java.lang.Integer) r2;
        r2 = r2.intValue();
        r5 = r2 >> 22;
        r6 = 4194303; // 0x3fffff float:5.87747E-39 double:2.072261E-317;
        r6 = r6 & r2;
        r0 = r20;
        r2 = r0.buq;
        r2 = r2.get(r5);
        r2 = (java.util.LinkedList) r2;
        if (r2 != 0) goto L_0x0051;
    L_0x0045:
        r2 = new java.util.LinkedList;
        r2.<init>();
        r0 = r20;
        r7 = r0.buq;
        r7.put(r5, r2);
    L_0x0051:
        r5 = java.lang.Integer.valueOf(r6);
        r2.add(r5);
        goto L_0x0023;
    L_0x0059:
        r2 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0059 }
        throw r2;
    L_0x005c:
        r4.clear();
        r2 = 0;
        r13 = r2;
    L_0x0061:
        r0 = r20;
        r2 = r0.buq;
        r2 = r2.size();
        if (r13 >= r2) goto L_0x0010;
    L_0x006b:
        r0 = r20;
        r2 = r0.buq;
        r14 = r2.keyAt(r13);
        r0 = r20;
        r2 = r0.buq;
        r2 = r2.get(r14);
        r3 = r2;
        r3 = (java.util.LinkedList) r3;
        r7 = 0;
        r6 = 0;
        r8 = 0;
        r2 = com.tencent.matrix.trace.d.c.a.values();
        r2 = r2.length;
        r5 = new int[r2];
        r2 = com.tencent.matrix.trace.d.c.a.values();
        r2 = r2.length;
        r2 = new int[r2];
        r15 = r3.iterator();
        r4 = r2;
    L_0x0094:
        r2 = r15.hasNext();
        if (r2 == 0) goto L_0x025f;
    L_0x009a:
        r2 = r15.next();
        r2 = (java.lang.Integer) r2;
        r9 = r2.intValue();
        r12 = r7 + r9;
        r8 = r8 + 1;
        r2 = r2.intValue();
        r2 = r2 / 1600;
        r10 = r2 + -1;
        r2 = 42;
        if (r10 < r2) goto L_0x01f4;
    L_0x00b4:
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_FROZEN;
        r2 = r2.index;
        r7 = r5[r2];
        r7 = r7 + 1;
        r5[r2] = r7;
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_FROZEN;
        r7 = r2.index;
        r2 = r4[r7];
        r9 = r4;
    L_0x00c5:
        r11 = r9;
    L_0x00c6:
        r2 = r2 + r10;
        r11[r7] = r2;
        r10 = (long) r12;
        r0 = r20;
        r2 = r0.bsS;
        r0 = r2.bta;
        r16 = r0;
        r18 = 100;
        r16 = r16 * r18;
        r2 = (r10 > r16 ? 1 : (r10 == r16 ? 0 : -1));
        if (r2 < 0) goto L_0x02a2;
    L_0x00da:
        r2 = 1114636288; // 0x42700000 float:60.0 double:5.507034975E-315;
        r7 = 1203982336; // 0x47c35000 float:100000.0 double:5.948463104E-315;
        r9 = r8 - r6;
        r9 = (float) r9;
        r7 = r7 * r9;
        r9 = (float) r12;
        r7 = r7 / r9;
        r2 = java.lang.Math.min(r2, r7);
        r7 = "Matrix.FPSTracer";
        r9 = "scene:%s fps:%s sumTime:%s [%s:%s]";
        r10 = 5;
        r10 = new java.lang.Object[r10];
        r11 = 0;
        r0 = r20;
        r0 = r0.buo;
        r16 = r0;
        r0 = r16;
        r16 = r0.get(r14);
        r10[r11] = r16;
        r11 = 1;
        r16 = java.lang.Float.valueOf(r2);
        r10[r11] = r16;
        r11 = 2;
        r12 = java.lang.Integer.valueOf(r12);
        r10[r11] = r12;
        r11 = 3;
        r12 = java.lang.Integer.valueOf(r8);
        r10[r11] = r12;
        r11 = 4;
        r6 = java.lang.Integer.valueOf(r6);
        r10[r11] = r6;
        com.tencent.matrix.d.b.i(r7, r9, r10);
        r6 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x024e }
        r6.<init>();	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_HIGH;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_HIGH;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r9 = r5[r9];	 Catch:{ JSONException -> 0x024e }
        r6.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_MIDDLE;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_MIDDLE;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r9 = r5[r9];	 Catch:{ JSONException -> 0x024e }
        r6.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_NORMAL;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_NORMAL;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r9 = r5[r9];	 Catch:{ JSONException -> 0x024e }
        r6.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_BEST;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_BEST;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r5 = r5[r9];	 Catch:{ JSONException -> 0x024e }
        r6.put(r7, r5);	 Catch:{ JSONException -> 0x024e }
        r5 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x024e }
        r5.<init>();	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_HIGH;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_HIGH;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r9 = r4[r9];	 Catch:{ JSONException -> 0x024e }
        r5.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_MIDDLE;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_MIDDLE;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r9 = r4[r9];	 Catch:{ JSONException -> 0x024e }
        r5.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_NORMAL;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_NORMAL;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r9 = r4[r9];	 Catch:{ JSONException -> 0x024e }
        r5.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = com.tencent.matrix.trace.d.c.a.DROPPED_BEST;	 Catch:{ JSONException -> 0x024e }
        r7 = r7.name();	 Catch:{ JSONException -> 0x024e }
        r9 = com.tencent.matrix.trace.d.c.a.DROPPED_BEST;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.index;	 Catch:{ JSONException -> 0x024e }
        r4 = r4[r9];	 Catch:{ JSONException -> 0x024e }
        r5.put(r7, r4);	 Catch:{ JSONException -> 0x024e }
        r4 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x024e }
        r4.<init>();	 Catch:{ JSONException -> 0x024e }
        r7 = "machine";
        r0 = r20;
        r9 = r0.bsS;	 Catch:{ JSONException -> 0x024e }
        r0 = r20;
        r10 = r0.btG;	 Catch:{ JSONException -> 0x024e }
        r10 = r10.application;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.aA(r10);	 Catch:{ JSONException -> 0x024e }
        r4.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = "scene";
        r0 = r20;
        r9 = r0.buo;	 Catch:{ JSONException -> 0x024e }
        r9 = r9.get(r14);	 Catch:{ JSONException -> 0x024e }
        r4.put(r7, r9);	 Catch:{ JSONException -> 0x024e }
        r7 = "dropLevel";
        r4.put(r7, r6);	 Catch:{ JSONException -> 0x024e }
        r6 = "dropSum";
        r4.put(r6, r5);	 Catch:{ JSONException -> 0x024e }
        r5 = "fps";
        r6 = (double) r2;	 Catch:{ JSONException -> 0x024e }
        r4.put(r5, r6);	 Catch:{ JSONException -> 0x024e }
        r0 = r20;
        r0.b(r4);	 Catch:{ JSONException -> 0x024e }
    L_0x01e1:
        r2 = com.tencent.matrix.trace.d.c.a.values();
        r2 = r2.length;
        r5 = new int[r2];
        r2 = com.tencent.matrix.trace.d.c.a.values();
        r2 = r2.length;
        r2 = new int[r2];
        r7 = 0;
        r6 = r8;
    L_0x01f1:
        r4 = r2;
        goto L_0x0094;
    L_0x01f4:
        r2 = 12;
        if (r10 < r2) goto L_0x020b;
    L_0x01f8:
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_HIGH;
        r2 = r2.index;
        r7 = r5[r2];
        r7 = r7 + 1;
        r5[r2] = r7;
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_HIGH;
        r7 = r2.index;
        r2 = r4[r7];
        r9 = r4;
        goto L_0x00c5;
    L_0x020b:
        r2 = 6;
        if (r10 < r2) goto L_0x0221;
    L_0x020e:
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_MIDDLE;
        r2 = r2.index;
        r7 = r5[r2];
        r7 = r7 + 1;
        r5[r2] = r7;
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_MIDDLE;
        r7 = r2.index;
        r2 = r4[r7];
        r9 = r4;
        goto L_0x00c5;
    L_0x0221:
        r2 = 2;
        if (r10 < r2) goto L_0x0237;
    L_0x0224:
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_NORMAL;
        r2 = r2.index;
        r7 = r5[r2];
        r7 = r7 + 1;
        r5[r2] = r7;
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_NORMAL;
        r7 = r2.index;
        r2 = r4[r7];
        r9 = r4;
        goto L_0x00c5;
    L_0x0237:
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_BEST;
        r2 = r2.index;
        r7 = r5[r2];
        r7 = r7 + 1;
        r5[r2] = r7;
        r2 = com.tencent.matrix.trace.d.c.a.DROPPED_BEST;
        r7 = r2.index;
        r2 = r4[r7];
        if (r10 >= 0) goto L_0x02a6;
    L_0x0249:
        r9 = 0;
        r10 = r9;
        r11 = r4;
        goto L_0x00c6;
    L_0x024e:
        r2 = move-exception;
        r4 = "Matrix.FPSTracer";
        r5 = "json error";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r2;
        com.tencent.matrix.d.b.e(r4, r5, r6);
        goto L_0x01e1;
    L_0x025f:
        if (r6 <= 0) goto L_0x026a;
    L_0x0261:
        r2 = 0;
    L_0x0262:
        if (r2 >= r6) goto L_0x026a;
    L_0x0264:
        r3.removeFirst();
        r2 = r2 + 1;
        goto L_0x0262;
    L_0x026a:
        r2 = r3.isEmpty();
        if (r2 != 0) goto L_0x029d;
    L_0x0270:
        r2 = "Matrix.FPSTracer";
        r3 = "[doReport] sumTime:[%sms < %sms], scene:[%s]";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r7 / 100;
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r0 = r20;
        r6 = r0.bsS;
        r6 = r6.bta;
        r6 = java.lang.Long.valueOf(r6);
        r4[r5] = r6;
        r5 = 2;
        r0 = r20;
        r6 = r0.buo;
        r6 = r6.get(r14);
        r4[r5] = r6;
        com.tencent.matrix.d.b.d(r2, r3, r4);
    L_0x029d:
        r2 = r13 + 1;
        r13 = r2;
        goto L_0x0061;
    L_0x02a2:
        r2 = r4;
        r7 = r12;
        goto L_0x01f1;
    L_0x02a6:
        r9 = r4;
        goto L_0x00c5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.matrix.trace.d.c.tG():void");
    }

    public final void h(long j, long j2) {
        if (!this.isBackground && this.bum) {
            com.tencent.matrix.trace.a.a aVar = this.bsS;
            if (aVar.bsZ == null ? true : aVar.bsZ.contains(this.btH)) {
                int intValue;
                String str = this.btH;
                if (this.bun.containsKey(str)) {
                    intValue = ((Integer) this.bun.get(str)).intValue();
                } else {
                    intValue = this.bun.size() + 1;
                    this.bun.put(str, Integer.valueOf(intValue));
                    this.buo.put(intValue, str);
                }
                intValue = (int) (((long) ((intValue | 0) << 22)) | (((j2 - j) / 10000) & 4194303));
                synchronized (this.bup) {
                    this.bup.add(Integer.valueOf(intValue));
                }
            }
        }
        this.bum = false;
    }
}
