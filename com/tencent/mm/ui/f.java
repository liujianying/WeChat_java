package com.tencent.mm.ui;

import android.content.Context;
import android.util.SparseArray;
import android.widget.BaseAdapter;
import com.tencent.mm.bt.a.a;
import com.tencent.mm.bt.a.d;
import com.tencent.mm.bt.a.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public abstract class f<K, T extends a> extends BaseAdapter {
    public String TAG;
    public Context context;
    private int kEf;
    private int pageSize;
    public boolean thB;
    public c thC;
    private HashMap<K, b<K, T>> thD;
    protected a thE;
    public int thF;
    public int thG;
    public boolean thH;
    int thI;
    private boolean thJ;
    private boolean thK;
    private e thL;
    public K thM;

    public static class b<K, T> {
        public K object;
        public int thP;
        public T thQ = null;

        public b(K k, int i) {
            this.object = k;
            this.thP = i;
        }

        public final int hashCode() {
            int i;
            int i2 = (this.thP + 31) * 31;
            if (this.object == null) {
                i = 0;
            } else {
                i = this.object.hashCode();
            }
            return i + i2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.thP != bVar.thP) {
                return false;
            }
            if (this.object == null) {
                if (bVar.object != null) {
                    return false;
                }
                return true;
            } else if (this.object.equals(bVar.object)) {
                return true;
            } else {
                return false;
            }
        }
    }

    public abstract SparseArray<K>[] a(HashSet<b<K, T>> hashSet, SparseArray<K>[] sparseArrayArr);

    public abstract ArrayList<T> ae(ArrayList<K> arrayList);

    public abstract d<K> coW();

    public abstract T coc();

    public final void a(a aVar) {
        this.thE = aVar;
    }

    public final void coT() {
        this.thE = null;
    }

    public f(Context context) {
        this(context, (byte) 0);
        this.pageSize = Downloads.MIN_RETYR_AFTER;
        x.i(this.TAG, "newCursor setPageSize %d", new Object[]{Integer.valueOf(Downloads.MIN_RETYR_AFTER)});
    }

    private f(Context context, byte b) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.thB = true;
        this.thF = TbsLog.TBSLOG_CODE_SDK_BASE;
        this.thG = 3000;
        this.thH = true;
        this.kEf = 0;
        this.thI = 0;
        this.thM = null;
        this.context = context;
        this.thJ = true;
    }

    private f(Context context, char c) {
        this.TAG = "MicroMsg.CursorDataAdapter";
        this.thB = true;
        this.thF = TbsLog.TBSLOG_CODE_SDK_BASE;
        this.thG = 3000;
        this.thH = true;
        this.kEf = 0;
        this.thI = 0;
        this.thM = null;
        this.context = context;
        this.thJ = true;
        this.thK = false;
        this.thF = 800;
        this.thG = 2000;
    }

    public f(Context context, short s) {
        this(context, 0);
    }

    private void a(c cVar) {
        lv(false);
        this.thC = cVar;
        this.thC.getCount();
        coU();
    }

    private void a(d<K> dVar) {
        lv(true);
        if (this.thC == null || this.thC.teA != dVar) {
            if (!(this.thC == null || this.thC.isClosed())) {
                this.thC.close();
                this.thC = null;
            }
            this.thC = new c(this, dVar);
            this.thC.getCount();
            coU();
            notifyDataSetChanged();
        }
    }

    private void coU() {
        if (this.thJ) {
            int i = this.thC.cnU() ? 1 : 2;
            if (!(i == this.thI || this.thI == 0)) {
                if (this.thL != null && this.thL.cpg()) {
                    a(new c(this, coW()), true, false);
                }
                x.i(this.TAG, "newcursor change update stats  %d ", new Object[]{Integer.valueOf(i)});
            }
            this.thI = i;
        }
    }

    public boolean cnU() {
        if (this.thC == null) {
            return false;
        }
        return this.thC.cnU();
    }

    public int getCount() {
        if (this.thC == null) {
            long currentTimeMillis = System.currentTimeMillis();
            a(coW());
            x.i(this.TAG, "newcursor createCursor last : %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
        }
        bt("getcount", false);
        return this.thC.getCount();
    }

    public final int coV() {
        if (this.thC == null) {
            return 0;
        }
        d dVar = this.thC.teA;
        if (dVar == null) {
            return 0;
        }
        if (dVar instanceof e) {
            return ((e) dVar).ter[0].getCount();
        }
        throw new RuntimeException("the cursor is not instanceof MergeHeapCursor ,please call getCount() instead ");
    }

    private void bt(String str, boolean z) {
        int i;
        if (this.kEf == 0) {
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 == 0 && (this.thH | z) != 0) {
            if (!z) {
                x.i(this.TAG, "newcursor cache needRefresh : needRefreshInfront :%b from : %s %s", new Object[]{Boolean.valueOf(this.thH), str, bi.cjd()});
            }
            lu(false);
        }
    }

    /* renamed from: Dy */
    public final T getItem(int i) {
        if (this.thC == null) {
            a(coW());
        }
        bt("getItem", false);
        this.thC.teA.moveToPosition(i);
        T Dy = this.thC.teA.Dy(i);
        if (Dy != null) {
            Dy.cks();
        } else {
            x.e(this.TAG, "newcursor getItem error %d", new Object[]{Integer.valueOf(i)});
        }
        return Dy;
    }

    public long getItemId(int i) {
        return 0;
    }

    public final T cn(K k) {
        if (this.thC == null) {
            return null;
        }
        return this.thC.teA.cn(k);
    }

    public final SparseArray<K>[] coX() {
        if (this.thC == null) {
            return null;
        }
        SparseArray[] cnS = this.thC.cnS();
        SparseArray<K>[] sparseArrayArr = new SparseArray[cnS.length];
        for (int i = 0; i < sparseArrayArr.length; i++) {
            sparseArrayArr[i] = new SparseArray();
            for (int i2 = 0; i2 < cnS[i].size(); i2++) {
                sparseArrayArr[i].put(i2, cnS[i].get(i2));
            }
        }
        return sparseArrayArr;
    }

    private void coY() {
        this.thD.clear();
        this.thD.put(this.thM, null);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void lu(boolean r10) {
        /*
        r9 = this;
        r8 = 2;
        r3 = 1;
        r2 = 0;
        r0 = r9.thK;
        if (r0 != 0) goto L_0x0009;
    L_0x0007:
        if (r10 == 0) goto L_0x006e;
    L_0x0009:
        r0 = r9.thL;
        if (r0 == 0) goto L_0x0015;
    L_0x000d:
        r0 = r9.thL;
        r0 = r0.cpg();
        if (r0 != 0) goto L_0x001b;
    L_0x0015:
        r0 = r9.coZ();
        if (r0 == 0) goto L_0x0068;
    L_0x001b:
        r0 = r3;
    L_0x001c:
        if (r0 == 0) goto L_0x0065;
    L_0x001e:
        r1 = r9.coZ();
        r0 = r9.thL;
        if (r0 == 0) goto L_0x009d;
    L_0x0026:
        r0 = r9.thL;
        r0 = r0.cpi();
        r4 = r9.TAG;
        r5 = "newcursor mWorkerHandler.isHandingMsg,type is %d ";
        r6 = new java.lang.Object[r3];
        r7 = java.lang.Integer.valueOf(r0);
        r6[r2] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        if (r0 == 0) goto L_0x0043;
    L_0x003e:
        r4 = r9.thL;
        r4.cpe();
    L_0x0043:
        if (r1 == r8) goto L_0x009d;
    L_0x0045:
        r1 = r9.TAG;
        r4 = "newcursor ensureNewState  refreshstatus is %d ";
        r5 = new java.lang.Object[r3];
        r6 = java.lang.Integer.valueOf(r0);
        r5[r2] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r4, r5);
        r9.kEf = r2;
        if (r0 != r8) goto L_0x006a;
    L_0x0059:
        r0 = new com.tencent.mm.ui.f$c;
        r1 = r9.coW();
        r0.<init>(r9, r1);
        r9.a(r0, r3, r3);
    L_0x0065:
        r9.kEf = r2;
    L_0x0067:
        return;
    L_0x0068:
        r0 = r2;
        goto L_0x001c;
    L_0x006a:
        r9.cpa();
        goto L_0x0065;
    L_0x006e:
        r0 = r9.coZ();
        if (r0 != 0) goto L_0x007d;
    L_0x0074:
        r0 = r9.TAG;
        r1 = "newcursor need not change ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0067;
    L_0x007d:
        if (r0 != r8) goto L_0x008c;
    L_0x007f:
        r1 = r9.TAG;
        r3 = "newcursor enqueueMessage resetcursor ";
        com.tencent.mm.sdk.platformtools.x.i(r1, r3);
        r1 = r9.thD;
        r1.clear();
    L_0x008c:
        r1 = r9.thL;
        if (r1 != 0) goto L_0x0097;
    L_0x0090:
        r1 = new com.tencent.mm.ui.f$e;
        r1.<init>(r9);
        r9.thL = r1;
    L_0x0097:
        r1 = r9.thL;
        r1.DH(r0);
        goto L_0x0065;
    L_0x009d:
        r0 = r1;
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.f.lu(boolean):void");
    }

    private int coZ() {
        if (this.thD == null || this.thD.size() == 0) {
            return 0;
        }
        if (this.thD.containsKey(this.thM)) {
            return 2;
        }
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(K r10, int r11) {
        /*
        r9 = this;
        r6 = 5;
        r8 = 3;
        r7 = 2;
        r1 = 0;
        r2 = 1;
        r0 = r9.thC;
        if (r0 == 0) goto L_0x0070;
    L_0x0009:
        r0 = r9.thD;
        if (r0 != 0) goto L_0x0014;
    L_0x000d:
        r0 = new java.util.HashMap;
        r0.<init>();
        r9.thD = r0;
    L_0x0014:
        r0 = r9.thD;
        r3 = r9.thM;
        r0 = r0.containsKey(r3);
        if (r11 == r6) goto L_0x0024;
    L_0x001e:
        r3 = r9.thJ;
        if (r3 == 0) goto L_0x0024;
    L_0x0022:
        if (r11 != r2) goto L_0x007e;
    L_0x0024:
        if (r11 == r6) goto L_0x0071;
    L_0x0026:
        r9.coY();
    L_0x0029:
        r0 = r9.TAG;
        r3 = "newcursor syncHandle is true ,changeType is %d  ";
        r4 = new java.lang.Object[r2];
        r5 = java.lang.Integer.valueOf(r11);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r0 = r2;
    L_0x003a:
        r3 = r9.coZ();
        r9.kEf = r3;
        r4 = r9.TAG;
        r5 = "newcursor refreshStatus: %d ,hasLoadedAllDataStatus %b changeType :%d ";
        r6 = new java.lang.Object[r8];
        r3 = r9.kEf;
        r3 = java.lang.Integer.valueOf(r3);
        r6[r1] = r3;
        r3 = r9.thI;
        if (r3 != r2) goto L_0x0166;
    L_0x0053:
        r3 = r2;
    L_0x0054:
        r3 = java.lang.Boolean.valueOf(r3);
        r6[r2] = r3;
        r3 = java.lang.Integer.valueOf(r11);
        r6[r7] = r3;
        com.tencent.mm.sdk.platformtools.x.i(r4, r5, r6);
        if (r0 == 0) goto L_0x0169;
    L_0x0065:
        r0 = r9.TAG;
        r1 = "newcursor event is refresh sync ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r9.lu(r2);
    L_0x0070:
        return;
    L_0x0071:
        if (r0 != 0) goto L_0x0029;
    L_0x0073:
        r0 = r9.thD;
        r3 = new com.tencent.mm.ui.f$b;
        r3.<init>(r10, r11);
        r0.put(r10, r3);
        goto L_0x0029;
    L_0x007e:
        if (r0 == 0) goto L_0x0089;
    L_0x0080:
        r0 = r9.TAG;
        r1 = "newcursor need reset ,return ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x0070;
    L_0x0089:
        r0 = r9.thI;
        if (r0 != r2) goto L_0x0160;
    L_0x008d:
        r0 = r9.thC;
        r0 = r0.cm(r10);
        if (r0 != 0) goto L_0x0097;
    L_0x0095:
        if (r11 != r7) goto L_0x0155;
    L_0x0097:
        r4 = r9.thD;
        r5 = new com.tencent.mm.ui.f$b;
        r5.<init>(r10, r11);
        r0 = r5.thP;
        if (r0 != r7) goto L_0x00ae;
    L_0x00a2:
        r0 = r9.thC;
        r3 = r5.object;
        r0 = r0.cm(r3);
        if (r0 == 0) goto L_0x00ae;
    L_0x00ac:
        r5.thP = r8;
    L_0x00ae:
        r0 = r4.get(r10);
        r0 = (com.tencent.mm.ui.f.b) r0;
        if (r0 == 0) goto L_0x010f;
    L_0x00b6:
        r3 = r2;
    L_0x00b7:
        if (r3 == 0) goto L_0x0150;
    L_0x00b9:
        r4.remove(r0);
        r3 = r5.thP;
        switch(r3) {
            case 2: goto L_0x0124;
            case 3: goto L_0x00c1;
            case 4: goto L_0x00c1;
            case 5: goto L_0x0111;
            default: goto L_0x00c1;
        };
    L_0x00c1:
        r0 = r0.thP;
        switch(r0) {
            case 2: goto L_0x014c;
            case 3: goto L_0x00c6;
            case 4: goto L_0x00c6;
            case 5: goto L_0x0142;
            default: goto L_0x00c6;
        };
    L_0x00c6:
        r5.thP = r8;
    L_0x00c8:
        r4.put(r10, r5);
    L_0x00cb:
        r0 = r9.thC;
        r3 = r4.size();
        r0 = r0.teA;
        r0 = r0.Dx(r3);
        if (r0 != 0) goto L_0x00f6;
    L_0x00d9:
        r0 = r9.TAG;
        r3 = "newcursor events size exceed limit :size is :  %d";
        r5 = new java.lang.Object[r2];
        r6 = r4.size();
        r6 = java.lang.Integer.valueOf(r6);
        r5[r1] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r5);
        r4.clear();
        r0 = r9.thM;
        r3 = 0;
        r4.put(r0, r3);
    L_0x00f6:
        r0 = r9.TAG;
        r3 = "newcursor add event events size %d";
        r4 = new java.lang.Object[r2];
        r5 = r9.thD;
        r5 = r5.size();
        r5 = java.lang.Integer.valueOf(r5);
        r4[r1] = r5;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r4);
        r0 = r1;
        goto L_0x003a;
    L_0x010f:
        r3 = r1;
        goto L_0x00b7;
    L_0x0111:
        r0 = r0.thP;
        switch(r0) {
            case 2: goto L_0x00f6;
            case 3: goto L_0x0116;
            case 4: goto L_0x0116;
            case 5: goto L_0x0119;
            default: goto L_0x0116;
        };
    L_0x0116:
        r5.thP = r6;
        goto L_0x00c8;
    L_0x0119:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now delete, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r5.thP = r6;
        goto L_0x00c8;
    L_0x0124:
        r0 = r0.thP;
        switch(r0) {
            case 2: goto L_0x0137;
            case 3: goto L_0x0129;
            case 4: goto L_0x0129;
            case 5: goto L_0x0134;
            default: goto L_0x0129;
        };
    L_0x0129:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last update, now insert, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r5.thP = r7;
        goto L_0x00c8;
    L_0x0134:
        r5.thP = r8;
        goto L_0x00c8;
    L_0x0137:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last insert, now insert, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r5.thP = r7;
        goto L_0x00c8;
    L_0x0142:
        r0 = r9.TAG;
        r3 = "newcursor processEvent last delete, now update, impossible";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        goto L_0x00c6;
    L_0x014c:
        r5.thP = r7;
        goto L_0x00c8;
    L_0x0150:
        r4.put(r10, r5);
        goto L_0x00cb;
    L_0x0155:
        r0 = r9.TAG;
        r3 = "newcursor event pass ";
        com.tencent.mm.sdk.platformtools.x.i(r0, r3);
        r0 = r1;
        goto L_0x003a;
    L_0x0160:
        r9.coY();
        r0 = r1;
        goto L_0x003a;
    L_0x0166:
        r3 = r1;
        goto L_0x0054;
    L_0x0169:
        r0 = r9.thB;
        if (r0 == 0) goto L_0x0070;
    L_0x016d:
        r0 = r9.thH;
        if (r0 == 0) goto L_0x0070;
    L_0x0171:
        r9.lu(r1);
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.f.q(java.lang.Object, int):void");
    }

    public final void resume() {
        x.i(this.TAG, "newcursor resume ");
        this.thB = true;
        bt("resume", true);
    }

    public void pause() {
        this.thB = false;
        x.i(this.TAG, "new cursor pasue");
    }

    private void a(d dVar) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.thE != null) {
            this.thE.Xa();
        }
        dVar.cpb();
        notifyDataSetChanged();
        if (this.thE != null) {
            this.thE.Xb();
        }
        if (this.thL != null) {
            this.thL.cph();
        }
        x.i(this.TAG, "newcursor update callback last :%d ", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    private void cpa() {
        if (this.thC == null || this.thC.isClosed() || this.thD.size() != 0) {
            a(new 1(this));
        } else {
            x.i(this.TAG, "events size is 0  ");
        }
    }

    private void a(final c cVar, boolean z, boolean z2) {
        if (z) {
            if (this.thL != null && this.thL.cpg()) {
                this.thL.cpe();
            }
            if (this.thD != null) {
                this.thD.clear();
            }
        }
        if (z2) {
            a(new d() {
                public final void cpb() {
                    f.this.a(cVar);
                }
            });
        } else {
            a((c) cVar);
        }
    }

    public final void a(SparseArray<K>[] sparseArrayArr) {
        SparseArray[] cnS = this.thC.cnS();
        for (int i = 0; i < cnS.length; i++) {
            cnS[i].clear();
            for (int i2 = 0; i2 < sparseArrayArr[i].size(); i2++) {
                cnS[i].put(i2, sparseArrayArr[i].get(i2));
            }
        }
    }

    public final void lv(boolean z) {
        if (this.thC != null) {
            this.thC.close();
            this.thC = null;
        }
        if (z && this.thL != null) {
            this.thL.quit();
            this.thL = null;
            if (this.thD != null) {
                this.thD.clear();
                x.i(this.TAG, "newcursor closeCursor,clear events");
            }
        }
        this.kEf = 0;
        this.thI = 0;
    }
}
