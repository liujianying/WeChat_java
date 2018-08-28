package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.wenote.model.a.b;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.b.a;
import com.tencent.mm.protocal.c.vx;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.utils.TbsLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class c {
    private static volatile c qpQ = null;
    public ArrayList<b> gBc = null;
    public a qpR = null;
    public vx qpS = null;
    public int qpT = 0;
    public int qpU = 0;
    public int qpV = 0;
    public boolean qpW = false;

    private c() {
    }

    public static c bZD() {
        if (qpQ == null) {
            synchronized (c.class) {
                if (qpQ == null) {
                    qpQ = new c();
                }
            }
        }
        return qpQ;
    }

    public final int size() {
        return this.gBc != null ? this.gBc.size() : 0;
    }

    public final b Bv(int i) {
        if (this.gBc == null || i < 0 || i >= this.gBc.size()) {
            return null;
        }
        return (b) this.gBc.get(i);
    }

    public final boolean a(b bVar) {
        boolean z = true;
        synchronized (this) {
            if (bVar != null) {
                if (this.gBc != null) {
                    this.gBc.add(bVar);
                    a(bVar, true);
                }
            }
            z = false;
        }
        return z;
    }

    public final boolean a(int i, ArrayList<b> arrayList) {
        if (arrayList == null || arrayList.size() <= 0) {
            return false;
        }
        int i2;
        int i3;
        boolean z;
        synchronized (this) {
            if (this.gBc != null) {
                int i4 = 0;
                i2 = 0;
                i3 = i;
                while (i4 < arrayList.size() && i3 >= 0 && i3 <= this.gBc.size()) {
                    b bVar = (b) arrayList.get(i4);
                    if (bVar != null) {
                        b(bVar);
                        this.gBc.add(i3, bVar);
                        i2++;
                        i3++;
                        a(bVar, true);
                    }
                    i4++;
                    i2 = i2;
                }
                z = true;
            } else {
                z = false;
                i2 = 0;
                i3 = i;
            }
        }
        if (!z || this.qpR == null) {
            return z;
        }
        this.qpR.en(i3 - i2, i2);
        return z;
    }

    public final boolean a(int i, b bVar) {
        boolean z = true;
        synchronized (this) {
            if (this.gBc == null || i < 0 || i > this.gBc.size()) {
                z = false;
            } else {
                this.gBc.add(i, bVar);
                a(bVar, true);
            }
        }
        if (z && this.qpR != null) {
            this.qpR.Bp(i);
            if (i > 0) {
                this.qpR.eo(i - 1, this.gBc.size() - (i - 1));
            } else {
                this.qpR.eo(i, this.gBc.size() - i);
            }
        }
        return z;
    }

    private boolean b(int i, b bVar) {
        if (bVar == null || this.gBc == null || i < 0 || i > this.gBc.size()) {
            return false;
        }
        this.gBc.add(i, bVar);
        a(bVar, true);
        return true;
    }

    public final boolean ab(int i, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (this.gBc != null && i >= 0 && i < this.gBc.size()) {
                a((b) this.gBc.get(i), false);
                this.gBc.remove(i);
                z2 = true;
            }
        }
        if (z2 && z && this.qpR != null) {
            this.qpR.Bq(i);
            if (i > 0) {
                this.qpR.eo(i - 1, this.gBc.size() - (i - 1));
            } else {
                this.qpR.eo(i, this.gBc.size() - i);
            }
        }
        return z2;
    }

    private boolean Bw(int i) {
        if (this.gBc == null || i < 0 || i >= this.gBc.size()) {
            return false;
        }
        a((b) this.gBc.get(i), false);
        this.gBc.remove(i);
        return true;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r5, com.tencent.mm.plugin.wenote.model.a.b r6) {
        /*
        r4 = this;
        r1 = 0;
        r2 = -1;
        monitor-enter(r4);
        r0 = r4.gBc;	 Catch:{ all -> 0x0048 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
    L_0x0008:
        return;
    L_0x0009:
        r1 = r1 + 1;
    L_0x000b:
        r0 = r4.gBc;	 Catch:{ all -> 0x0048 }
        r0 = r0.size();	 Catch:{ all -> 0x0048 }
        if (r1 >= r0) goto L_0x004b;
    L_0x0013:
        r0 = r4.gBc;	 Catch:{ all -> 0x0048 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0048 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0048 }
        r0 = r0.bZg();	 Catch:{ all -> 0x0048 }
        r0 = r0.equals(r5);	 Catch:{ all -> 0x0048 }
        if (r0 == 0) goto L_0x0009;
    L_0x0025:
        r0 = r4.gBc;	 Catch:{ all -> 0x0048 }
        r0 = r0.get(r1);	 Catch:{ all -> 0x0048 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0048 }
        r3 = 0;
        r4.a(r0, r3);	 Catch:{ all -> 0x0048 }
        r0 = r4.gBc;	 Catch:{ all -> 0x0048 }
        r0.set(r1, r6);	 Catch:{ all -> 0x0048 }
        r0 = 1;
        r4.a(r6, r0);	 Catch:{ all -> 0x0048 }
        r0 = r1;
    L_0x003b:
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        if (r0 == r2) goto L_0x0008;
    L_0x003e:
        r1 = r4.qpR;
        if (r1 == 0) goto L_0x0008;
    L_0x0042:
        r1 = r4.qpR;
        r1.Bo(r0);
        goto L_0x0008;
    L_0x0048:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0048 }
        throw r0;
    L_0x004b:
        r0 = r2;
        goto L_0x003b;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.lang.String, com.tencent.mm.plugin.wenote.model.a.b):void");
    }

    public final void bZE() {
        String str = "MicroMsg.Note.NoteDataManager";
        String str2 = "clear mDataList, size:%d";
        Object[] objArr = new Object[1];
        objArr[0] = Integer.valueOf(this.gBc != null ? this.gBc.size() : 0);
        x.i(str, str2, objArr);
        synchronized (this) {
            if (this.gBc != null) {
                this.gBc.clear();
            }
        }
        this.qpV = 0;
        this.qpU = 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ac(int r4, boolean r5) {
        /*
        r3 = this;
        monitor-enter(r3);
        r0 = r3.gBc;	 Catch:{ all -> 0x002c }
        if (r0 != 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
    L_0x0006:
        return;
    L_0x0007:
        if (r4 < 0) goto L_0x002f;
    L_0x0009:
        r0 = r3.gBc;	 Catch:{ all -> 0x002c }
        r0 = r0.size();	 Catch:{ all -> 0x002c }
        if (r4 >= r0) goto L_0x002f;
    L_0x0011:
        r0 = r3.gBc;	 Catch:{ all -> 0x002c }
        r0 = r0.get(r4);	 Catch:{ all -> 0x002c }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x002a;
    L_0x001b:
        r1 = r0.qoO;	 Catch:{ all -> 0x002c }
        if (r1 == r5) goto L_0x002a;
    L_0x001f:
        r0.qoO = r5;	 Catch:{ all -> 0x002c }
        r0 = r3.qpR;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x002a;
    L_0x0025:
        r0 = r3.qpR;	 Catch:{ all -> 0x002c }
        r0.Bo(r4);	 Catch:{ all -> 0x002c }
    L_0x002a:
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
        goto L_0x0006;
    L_0x002c:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x002c }
        throw r0;
    L_0x002f:
        r0 = -1;
        if (r4 != r0) goto L_0x002a;
    L_0x0032:
        r0 = 0;
        r1 = r0;
    L_0x0034:
        r0 = r3.gBc;	 Catch:{ all -> 0x002c }
        r0 = r0.size();	 Catch:{ all -> 0x002c }
        if (r1 >= r0) goto L_0x002a;
    L_0x003c:
        r0 = r3.gBc;	 Catch:{ all -> 0x002c }
        r0 = r0.get(r1);	 Catch:{ all -> 0x002c }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0055;
    L_0x0046:
        r2 = r0.qoO;	 Catch:{ all -> 0x002c }
        if (r2 == r5) goto L_0x0055;
    L_0x004a:
        r0.qoO = r5;	 Catch:{ all -> 0x002c }
        r0 = r3.qpR;	 Catch:{ all -> 0x002c }
        if (r0 == 0) goto L_0x0055;
    L_0x0050:
        r0 = r3.qpR;	 Catch:{ all -> 0x002c }
        r0.Bo(r1);	 Catch:{ all -> 0x002c }
    L_0x0055:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0034;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.ac(int, boolean):void");
    }

    public final int bZF() {
        int i;
        synchronized (this) {
            if (this.gBc != null) {
                for (int i2 = 0; i2 < this.gBc.size(); i2++) {
                    if (((b) this.gBc.get(i2)).qoH) {
                        i = i2;
                        break;
                    }
                }
            }
            i = -1;
        }
        return i;
    }

    public final void bZG() {
        synchronized (this) {
            if (this.gBc != null) {
                Iterator it = this.gBc.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    bVar.qoH = false;
                    bVar.qoN = false;
                }
            }
        }
    }

    private void bZH() {
        if (this.gBc != null) {
            Iterator it = this.gBc.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                bVar.qoH = false;
                bVar.qoN = false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void ad(int r4, boolean r5) {
        /*
        r3 = this;
        r0 = 0;
        monitor-enter(r3);
        r1 = r3.gBc;	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x0010;
    L_0x0006:
        if (r4 < 0) goto L_0x0010;
    L_0x0008:
        r1 = r3.gBc;	 Catch:{ all -> 0x004d }
        r1 = r1.size();	 Catch:{ all -> 0x004d }
        if (r4 < r1) goto L_0x0012;
    L_0x0010:
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
    L_0x0011:
        return;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        r0 = r3.gBc;	 Catch:{ all -> 0x004d }
        r0 = r0.size();	 Catch:{ all -> 0x004d }
        if (r1 >= r0) goto L_0x0050;
    L_0x001b:
        if (r1 != r4) goto L_0x0036;
    L_0x001d:
        r0 = r3.gBc;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r2 = 1;
        r0.qoH = r2;	 Catch:{ all -> 0x004d }
        r0 = r3.gBc;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r0.qoN = r5;	 Catch:{ all -> 0x004d }
    L_0x0032:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0013;
    L_0x0036:
        r0 = r3.gBc;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r2 = 0;
        r0.qoH = r2;	 Catch:{ all -> 0x004d }
        r0 = r3.gBc;	 Catch:{ all -> 0x004d }
        r0 = r0.get(r1);	 Catch:{ all -> 0x004d }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x004d }
        r2 = 0;
        r0.qoN = r2;	 Catch:{ all -> 0x004d }
        goto L_0x0032;
    L_0x004d:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
        throw r0;
    L_0x0050:
        monitor-exit(r3);	 Catch:{ all -> 0x004d }
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.ad(int, boolean):void");
    }

    public final int bZI() {
        int i;
        synchronized (this) {
            if (this.gBc != null) {
                int i2 = 0;
                while (i2 < this.gBc.size()) {
                    if (((b) this.gBc.get(i2)).getType() == 4 && ((k) this.gBc.get(i2)).qoV.booleanValue()) {
                        i = i2;
                        break;
                    }
                    i2++;
                }
            }
            i = -1;
        }
        return i;
    }

    public final String bZJ() {
        String stringBuilder;
        synchronized (this) {
            if (this.qpT == 0 && this.gBc != null) {
                Iterator it = this.gBc.iterator();
                while (it.hasNext()) {
                    n nVar = (n) ((b) it.next());
                    if (nVar.qpc.startsWith("WeNote_")) {
                        int i = bi.getInt(nVar.qpc.substring(7), -1);
                        if (i <= this.qpT) {
                            i = this.qpT;
                        }
                        this.qpT = i;
                    }
                }
            }
            StringBuilder stringBuilder2 = new StringBuilder("WeNote_");
            int i2 = this.qpT + 1;
            this.qpT = i2;
            stringBuilder = stringBuilder2.append(i2).toString();
        }
        return stringBuilder;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String bZK() {
        /*
        r4 = this;
        r1 = "";
        monitor-enter(r4);
        r0 = r4.gBc;	 Catch:{ all -> 0x0156 }
        if (r0 == 0) goto L_0x0010;
    L_0x0008:
        r0 = r4.gBc;	 Catch:{ all -> 0x0156 }
        r0 = r0.size();	 Catch:{ all -> 0x0156 }
        if (r0 > 0) goto L_0x0015;
    L_0x0010:
        r0 = "";
        monitor-exit(r4);	 Catch:{ all -> 0x0156 }
    L_0x0014:
        return r0;
    L_0x0015:
        r0 = 0;
        r2 = r0;
    L_0x0017:
        r0 = r4.gBc;	 Catch:{ all -> 0x0156 }
        r0 = r0.size();	 Catch:{ all -> 0x0156 }
        if (r2 >= r0) goto L_0x0149;
    L_0x001f:
        r0 = r4.gBc;	 Catch:{ all -> 0x0156 }
        r0 = r0.get(r2);	 Catch:{ all -> 0x0156 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0156 }
        r3 = r0.getType();	 Catch:{ all -> 0x0156 }
        switch(r3) {
            case -1: goto L_0x0133;
            case 0: goto L_0x002e;
            case 1: goto L_0x0033;
            case 2: goto L_0x00a7;
            case 3: goto L_0x00fb;
            case 4: goto L_0x00df;
            case 5: goto L_0x0117;
            case 6: goto L_0x00c3;
            default: goto L_0x002e;
        };	 Catch:{ all -> 0x0156 }
    L_0x002e:
        r0 = r1;
    L_0x002f:
        r2 = r2 + 1;
        r1 = r0;
        goto L_0x0017;
    L_0x0033:
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x0156 }
        r3 = r0.content;	 Catch:{ all -> 0x0156 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);	 Catch:{ all -> 0x0156 }
        if (r3 == 0) goto L_0x0052;
    L_0x003d:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r0.<init>();	 Catch:{ all -> 0x0156 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0156 }
        r1 = "<br/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x0052:
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r3.<init>();	 Catch:{ all -> 0x0156 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.content;	 Catch:{ all -> 0x0156 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0156 }
        r1 = r0.toString();	 Catch:{ all -> 0x0156 }
        r0 = r2 + 1;
        r3 = r4.gBc;	 Catch:{ all -> 0x0156 }
        r3 = r3.size();	 Catch:{ all -> 0x0156 }
        if (r0 >= r3) goto L_0x002e;
    L_0x006f:
        r0 = r4.gBc;	 Catch:{ all -> 0x0156 }
        r3 = r2 + 1;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0156 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x0156 }
        r0 = r0.getType();	 Catch:{ all -> 0x0156 }
        r3 = 1;
        if (r0 != r3) goto L_0x002e;
    L_0x0080:
        r0 = r4.gBc;	 Catch:{ all -> 0x0156 }
        r3 = r2 + 1;
        r0 = r0.get(r3);	 Catch:{ all -> 0x0156 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x0156 }
        r0 = r0.content;	 Catch:{ all -> 0x0156 }
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);	 Catch:{ all -> 0x0156 }
        if (r0 != 0) goto L_0x002e;
    L_0x0092:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r0.<init>();	 Catch:{ all -> 0x0156 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0156 }
        r1 = "<br/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x00a7:
        r0 = (com.tencent.mm.plugin.wenote.model.a.e) r0;	 Catch:{ all -> 0x0156 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r3.<init>();	 Catch:{ all -> 0x0156 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.qpc;	 Catch:{ all -> 0x0156 }
        r3 = 2;
        r0 = cK(r0, r3);	 Catch:{ all -> 0x0156 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x00c3:
        r0 = (com.tencent.mm.plugin.wenote.model.a.j) r0;	 Catch:{ all -> 0x0156 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r3.<init>();	 Catch:{ all -> 0x0156 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.qpc;	 Catch:{ all -> 0x0156 }
        r3 = 6;
        r0 = cK(r0, r3);	 Catch:{ all -> 0x0156 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x00df:
        r0 = (com.tencent.mm.plugin.wenote.model.a.k) r0;	 Catch:{ all -> 0x0156 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r3.<init>();	 Catch:{ all -> 0x0156 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.qpc;	 Catch:{ all -> 0x0156 }
        r3 = 4;
        r0 = cK(r0, r3);	 Catch:{ all -> 0x0156 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x00fb:
        r0 = (com.tencent.mm.plugin.wenote.model.a.f) r0;	 Catch:{ all -> 0x0156 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r3.<init>();	 Catch:{ all -> 0x0156 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.qpc;	 Catch:{ all -> 0x0156 }
        r3 = 3;
        r0 = cK(r0, r3);	 Catch:{ all -> 0x0156 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x0117:
        r0 = (com.tencent.mm.plugin.wenote.model.a.c) r0;	 Catch:{ all -> 0x0156 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r3.<init>();	 Catch:{ all -> 0x0156 }
        r1 = r3.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.qpc;	 Catch:{ all -> 0x0156 }
        r3 = 5;
        r0 = cK(r0, r3);	 Catch:{ all -> 0x0156 }
        r0 = r1.append(r0);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x0133:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0156 }
        r0.<init>();	 Catch:{ all -> 0x0156 }
        r0 = r0.append(r1);	 Catch:{ all -> 0x0156 }
        r1 = "<hr/>";
        r0 = r0.append(r1);	 Catch:{ all -> 0x0156 }
        r0 = r0.toString();	 Catch:{ all -> 0x0156 }
        goto L_0x002f;
    L_0x0149:
        r0 = "\n";
        r2 = "<br/>";
        r0 = r1.replaceAll(r0, r2);	 Catch:{ all -> 0x0156 }
        monitor-exit(r4);	 Catch:{ all -> 0x0156 }
        goto L_0x0014;
    L_0x0156:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0156 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bZK():java.lang.String");
    }

    private static String cK(String str, int i) {
        return String.format("<div><object data-type=\"%d\" id=\"%s\" name=\"%s\" class=\"item item-\"></object></div>", new Object[]{Integer.valueOf(i), str, str});
    }

    public final wl Sm(String str) {
        if (bi.oW(str)) {
            x.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem error ,htmlstr is null or nil");
            return null;
        }
        String o;
        int i;
        List arrayList = new ArrayList();
        synchronized (this) {
            int i2 = 0;
            while (i2 < this.gBc.size()) {
                b bVar = (b) this.gBc.get(i2);
                if (bi.oW(bVar.jdM)) {
                    bVar.jdM = f.Sf(bVar.toString());
                }
                h hVar;
                h hVar2;
                if (bVar.getType() == -1) {
                    if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).type != 1) {
                        hVar = new h();
                        hVar.content = "\n";
                        hVar.jdM = bVar.jdM;
                        hVar.qpc = "-1";
                        hVar.type = 1;
                        hVar.qpb = null;
                        arrayList.add(hVar);
                    } else {
                        hVar2 = (h) arrayList.get(arrayList.size() - 1);
                        hVar2.content += "\n";
                    }
                } else if (bVar.getType() >= -1) {
                    if ((bVar.getType() == 6 || bVar.getType() == 4) && bi.oW(((n) bVar).bVd)) {
                        vx vxVar = new vx();
                        vxVar.UO(bVar.jdM);
                        vxVar.UL(bVar.bZh());
                        o = f.o(vxVar);
                        if (FileOp.cn(o)) {
                            x.e("MicroMsg.Note.NoteDataManager", "getFavProtoItem,type = %d, localfile exsit,but localpath is null or nil, set path here", new Object[]{Integer.valueOf(bVar.getType())});
                            ((n) bVar).bVd = o;
                        }
                    }
                    if (bVar.getType() != 1) {
                        arrayList.add((n) bVar);
                    } else {
                        hVar2 = (h) bVar;
                        if (!bi.oW(hVar2.content)) {
                            if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                                hVar = new h();
                                hVar.content = hVar2.content;
                                hVar.jdM = hVar2.jdM;
                                hVar.qpc = hVar2.qpc;
                                hVar.type = hVar2.type;
                                hVar.qpb = null;
                                arrayList.add(hVar);
                            } else {
                                hVar = (h) arrayList.get(arrayList.size() - 1);
                                hVar.content += hVar2.content;
                            }
                            if (i2 + 1 < this.gBc.size() && ((b) this.gBc.get(i2 + 1)).getType() == 1 && !bi.oW(((h) this.gBc.get(i2 + 1)).content)) {
                                hVar2 = (h) arrayList.get(arrayList.size() - 1);
                                hVar2.content += "<br/>";
                            }
                        } else if (arrayList.size() <= 0 || ((n) arrayList.get(arrayList.size() - 1)).getType() != 1) {
                            hVar = new h();
                            hVar.content = "<br/>";
                            hVar.jdM = hVar2.jdM;
                            hVar.qpc = hVar2.qpc;
                            hVar.type = hVar2.type;
                            hVar.qpb = null;
                            arrayList.add(hVar);
                        } else {
                            hVar2 = (h) arrayList.get(arrayList.size() - 1);
                            hVar2.content += "<br/>";
                        }
                    }
                }
                i2++;
            }
        }
        String replaceAll = Pattern.compile("</wx-", 2).matcher(Pattern.compile("<wx-", 2).matcher(str).replaceAll("<")).replaceAll("</");
        byte[] bytes;
        try {
            bytes = replaceAll.getBytes("UTF-8");
            i = 0;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.Note.NoteDataManager", e, "", new Object[0]);
            x.e("MicroMsg.Note.NoteDataManager", "writehtmlfile, use utf-8 encoding error,use default encoding,");
            boolean i3 = true;
            bytes = null;
        }
        this.qpS.CF(8);
        this.qpS.UY("WeNoteHtmlFile");
        this.qpS.kY(true);
        this.qpS.UL(".htm");
        this.qpS.UO(f.Sf(this.qpS.toString()));
        o = f.o(this.qpS);
        x.i("MicroMsg.Note.NoteDataManager", "getFavProtoItem: save note html file, path is %s", new Object[]{o});
        File file = new File(o);
        if (file.exists()) {
            file.delete();
        }
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable e2) {
                x.printErrStackTrace("MicroMsg.Note.NoteDataManager", e2, "", new Object[0]);
                return null;
            }
        }
        if (i3 == 0 && e.b(o, bytes, bytes.length) == 0) {
            this.qpS.UP(o);
            x.i("MicroMsg.Note.NoteDataManager", "do WNNoteBase.ConvertNote2FavProtoItem");
            return d.a(replaceAll, arrayList, this.qpS);
        }
        x.i("MicroMsg.Note.NoteDataManager", "writefile error,return");
        Toast.makeText(ad.getContext(), ad.getContext().getString(R.l.favorite_save_fail), 1).show();
        return null;
    }

    public final int a(b bVar, WXRTEditText wXRTEditText, boolean z, boolean z2, boolean z3) {
        if (bVar == null) {
            return -1;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(bVar);
        return a(arrayList, wXRTEditText, true, z, z2, z3);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.b> r10, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText r11, boolean r12, boolean r13, boolean r14, boolean r15) {
        /*
        r9 = this;
        r6 = 5;
        r4 = 2;
        r2 = -1;
        r7 = 1;
        r5 = 0;
        if (r10 == 0) goto L_0x0011;
    L_0x0007:
        r1 = r10.size();
        if (r1 <= 0) goto L_0x0011;
    L_0x000d:
        r1 = r9.gBc;
        if (r1 != 0) goto L_0x001c;
    L_0x0011:
        r1 = "MicroMsg.Note.NoteDataManager";
        r3 = "insertItemList,error,return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
        r1 = r2;
    L_0x001b:
        return r1;
    L_0x001c:
        r1 = com.tencent.mm.plugin.wenote.model.c.bZb();
        r1 = r1.qnC;
        if (r1 != 0) goto L_0x002f;
    L_0x0024:
        r1 = "MicroMsg.Note.NoteDataManager";
        r3 = "insertItemList, but get wnnote base is null, return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r3);
        r1 = r2;
        goto L_0x001b;
    L_0x002f:
        if (r13 == 0) goto L_0x0042;
    L_0x0031:
        r1 = r9.Y(r10);
        if (r1 == 0) goto L_0x0042;
    L_0x0037:
        r1 = r9.qpR;
        if (r1 == 0) goto L_0x0042;
    L_0x003b:
        r1 = r9.qpR;
        r1.bZn();
        r1 = r2;
        goto L_0x001b;
    L_0x0042:
        if (r12 == 0) goto L_0x006c;
    L_0x0044:
        r1 = r10.size();
        r1 = r1 + -1;
        r1 = r10.get(r1);
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;
        r1.qoJ = r2;
        r1.qoH = r7;
        r1.qoN = r5;
        if (r11 == 0) goto L_0x006c;
    L_0x0058:
        r3 = r11.qqV;
        if (r3 == 0) goto L_0x006c;
    L_0x005c:
        r3 = r11.getEditTextType();
        if (r3 != r4) goto L_0x00a8;
    L_0x0062:
        r1.qoQ = r4;
    L_0x0064:
        r11.qqV = r5;
        r3 = r11.qoR;
        r1.qoR = r3;
        r11.qoR = r5;
    L_0x006c:
        if (r11 == 0) goto L_0x0074;
    L_0x006e:
        r1 = r11.getRecyclerItemPosition();
        if (r1 == 0) goto L_0x00b1;
    L_0x0074:
        monitor-enter(r9);
        if (r11 != 0) goto L_0x015d;
    L_0x0077:
        r3 = r9.size();	 Catch:{ all -> 0x0267 }
        r9.bZH();	 Catch:{ all -> 0x0267 }
        r4 = r10.iterator();	 Catch:{ all -> 0x0267 }
        r2 = r3;
    L_0x0083:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x00ee;
    L_0x0089:
        r1 = r4.next();	 Catch:{ all -> 0x0267 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x0267 }
        r9.b(r1);	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x02a9;
    L_0x0094:
        r6 = r9.gBc;	 Catch:{ all -> 0x0267 }
        if (r6 == 0) goto L_0x02a9;
    L_0x0098:
        r6 = r9.gBc;	 Catch:{ all -> 0x0267 }
        r6.add(r1);	 Catch:{ all -> 0x0267 }
        r6 = 1;
        r9.a(r1, r6);	 Catch:{ all -> 0x0267 }
        r1 = r7;
    L_0x00a2:
        if (r1 == 0) goto L_0x02ac;
    L_0x00a4:
        r1 = r2 + 1;
    L_0x00a6:
        r2 = r1;
        goto L_0x0083;
    L_0x00a8:
        r3 = r11.getEditTextType();
        if (r3 != r7) goto L_0x0064;
    L_0x00ae:
        r1.qoQ = r7;
        goto L_0x0064;
    L_0x00b1:
        r1 = r11.getEditTextType();
        if (r1 == r4) goto L_0x0074;
    L_0x00b7:
        r1 = r11.getSelectionStart();
        if (r1 != 0) goto L_0x0074;
    L_0x00bd:
        if (r10 == 0) goto L_0x0074;
    L_0x00bf:
        r1 = r10.size();
        if (r1 <= 0) goto L_0x0074;
    L_0x00c5:
        r1 = r10.get(r5);
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;
        r1 = r1.getType();
        if (r1 == r4) goto L_0x00dc;
    L_0x00d1:
        r3 = 6;
        if (r1 == r3) goto L_0x00dc;
    L_0x00d4:
        if (r1 == r6) goto L_0x00dc;
    L_0x00d6:
        r3 = 3;
        if (r1 == r3) goto L_0x00dc;
    L_0x00d9:
        r3 = 4;
        if (r1 != r3) goto L_0x0074;
    L_0x00dc:
        r1 = new com.tencent.mm.plugin.wenote.model.a.h;
        r1.<init>();
        r3 = "";
        r1.content = r3;
        r1.qoH = r5;
        r1.qoN = r5;
        r10.add(r5, r1);
        goto L_0x0074;
    L_0x00ee:
        r4 = r5;
    L_0x00ef:
        monitor-exit(r9);	 Catch:{ all -> 0x0267 }
        r1 = r2 + -1;
        if (r1 < 0) goto L_0x026a;
    L_0x00f4:
        r1 = r2 + -1;
        r6 = bZD();
        r6 = r6.size();
        if (r1 >= r6) goto L_0x026a;
    L_0x0100:
        r1 = r2 + -1;
    L_0x0102:
        if (r15 == 0) goto L_0x0125;
    L_0x0104:
        r1 = r1 + 1;
        r2 = r2 + 1;
        r9.bZH();
        r6 = bZD();
        r6 = r6.size();
        if (r1 >= r6) goto L_0x0276;
    L_0x0115:
        r6 = bZD();
        r6 = r6.Bv(r1);
        if (r6 == 0) goto L_0x0125;
    L_0x011f:
        r6.qoJ = r5;
        r6.qoH = r7;
        r6.qoN = r5;
    L_0x0125:
        r5 = r9.qpR;
        if (r5 == 0) goto L_0x0158;
    L_0x0129:
        r2 = r2 - r3;
        if (r4 == 0) goto L_0x012e;
    L_0x012c:
        r2 = r2 + 1;
    L_0x012e:
        if (r3 < 0) goto L_0x0137;
    L_0x0130:
        if (r2 <= 0) goto L_0x0137;
    L_0x0132:
        r4 = r9.qpR;
        r4.en(r3, r2);
    L_0x0137:
        if (r3 <= 0) goto L_0x028d;
    L_0x0139:
        r2 = r9.qpR;
        r4 = r3 + -1;
        r5 = bZD();
        r5 = r5.size();
        r3 = r3 + -1;
        r3 = r5 - r3;
        r2.eo(r4, r3);
    L_0x014c:
        if (r14 == 0) goto L_0x0153;
    L_0x014e:
        r2 = r9.qpR;
        r2.bZm();
    L_0x0153:
        r2 = r9.qpR;
        r2.Br(r1);
    L_0x0158:
        r9.bZM();
        goto L_0x001b;
    L_0x015d:
        r6 = r11.getRecyclerItemPosition();	 Catch:{ all -> 0x0267 }
        r3 = r9.Bv(r6);	 Catch:{ all -> 0x0267 }
        if (r3 != 0) goto L_0x016b;
    L_0x0167:
        monitor-exit(r9);	 Catch:{ all -> 0x0267 }
        r1 = r2;
        goto L_0x001b;
    L_0x016b:
        r9.bZH();	 Catch:{ all -> 0x0267 }
        r1 = r11.getEditTextType();	 Catch:{ all -> 0x0267 }
        if (r1 != 0) goto L_0x0241;
    L_0x0174:
        r1 = r3.getType();	 Catch:{ all -> 0x0267 }
        if (r1 != r7) goto L_0x0241;
    L_0x017a:
        r2 = r11.getSelection();	 Catch:{ all -> 0x0267 }
        r4 = r11.getText();	 Catch:{ all -> 0x0267 }
        r1 = 0;
        r8 = r2.Tw;	 Catch:{ all -> 0x0267 }
        r1 = r4.subSequence(r1, r8);	 Catch:{ all -> 0x0267 }
        r2 = r2.tK;	 Catch:{ all -> 0x0267 }
        r8 = r4.length();	 Catch:{ all -> 0x0267 }
        r2 = r4.subSequence(r2, r8);	 Catch:{ all -> 0x0267 }
        r1 = (android.text.Spanned) r1;	 Catch:{ all -> 0x0267 }
        r4 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x0267 }
        r0 = r2;
        r0 = (android.text.Spanned) r0;	 Catch:{ all -> 0x0267 }
        r1 = r0;
        r2 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x0267 }
        r0 = r3;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x0267 }
        r1 = r0;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r4);	 Catch:{ all -> 0x0267 }
        if (r3 != 0) goto L_0x0213;
    L_0x01ab:
        r3 = "<br/>";
        r3 = r4.endsWith(r3);	 Catch:{ all -> 0x0267 }
        if (r3 == 0) goto L_0x0211;
    L_0x01b4:
        r3 = 0;
        r8 = r4.length();	 Catch:{ all -> 0x0267 }
        r8 = r8 + -5;
        r3 = r4.substring(r3, r8);	 Catch:{ all -> 0x0267 }
    L_0x01bf:
        r1.content = r3;	 Catch:{ all -> 0x0267 }
        r6 = r6 + 1;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ all -> 0x0267 }
        if (r1 != 0) goto L_0x023d;
    L_0x01c9:
        r1 = new com.tencent.mm.plugin.wenote.model.a.h;	 Catch:{ all -> 0x0267 }
        r1.<init>();	 Catch:{ all -> 0x0267 }
        r3 = 1;
        r1.type = r3;	 Catch:{ all -> 0x0267 }
        r3 = "<br/>";
        r3 = r2.startsWith(r3);	 Catch:{ all -> 0x0267 }
        if (r3 == 0) goto L_0x01e3;
    L_0x01da:
        r3 = 5;
        r4 = r2.length();	 Catch:{ all -> 0x0267 }
        r2 = r2.substring(r3, r4);	 Catch:{ all -> 0x0267 }
    L_0x01e3:
        r1.content = r2;	 Catch:{ all -> 0x0267 }
        r2 = 0;
        r1.qoJ = r2;	 Catch:{ all -> 0x0267 }
        r2 = 0;
        r1.qoH = r2;	 Catch:{ all -> 0x0267 }
        r2 = 0;
        r1.qoN = r2;	 Catch:{ all -> 0x0267 }
        r9.b(r6, r1);	 Catch:{ all -> 0x0267 }
        r3 = r6;
        r4 = r7;
        r2 = r6;
    L_0x01f4:
        r6 = r10.iterator();	 Catch:{ all -> 0x0267 }
    L_0x01f8:
        r1 = r6.hasNext();	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x00ef;
    L_0x01fe:
        r1 = r6.next();	 Catch:{ all -> 0x0267 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x0267 }
        r9.b(r1);	 Catch:{ all -> 0x0267 }
        r1 = r9.b(r2, r1);	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x02a6;
    L_0x020d:
        r1 = r2 + 1;
    L_0x020f:
        r2 = r1;
        goto L_0x01f8;
    L_0x0211:
        r3 = r4;
        goto L_0x01bf;
    L_0x0213:
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r2);	 Catch:{ all -> 0x0267 }
        if (r3 != 0) goto L_0x0231;
    L_0x0219:
        r3 = "<br/>";
        r3 = r2.startsWith(r3);	 Catch:{ all -> 0x0267 }
        if (r3 == 0) goto L_0x022b;
    L_0x0222:
        r3 = 5;
        r4 = r2.length();	 Catch:{ all -> 0x0267 }
        r2 = r2.substring(r3, r4);	 Catch:{ all -> 0x0267 }
    L_0x022b:
        r1.content = r2;	 Catch:{ all -> 0x0267 }
        r3 = r6;
        r4 = r5;
        r2 = r6;
        goto L_0x01f4;
    L_0x0231:
        r9.Bw(r6);	 Catch:{ all -> 0x0267 }
        r1 = r9.qpR;	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x023d;
    L_0x0238:
        r1 = r9.qpR;	 Catch:{ all -> 0x0267 }
        r1.Bq(r6);	 Catch:{ all -> 0x0267 }
    L_0x023d:
        r3 = r6;
        r4 = r5;
        r2 = r6;
        goto L_0x01f4;
    L_0x0241:
        r1 = r11.getEditTextType();	 Catch:{ all -> 0x0267 }
        if (r1 == r7) goto L_0x02a4;
    L_0x0247:
        r3 = r6 + 1;
    L_0x0249:
        r4 = r10.iterator();	 Catch:{ all -> 0x0267 }
        r2 = r3;
    L_0x024e:
        r1 = r4.hasNext();	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x029f;
    L_0x0254:
        r1 = r4.next();	 Catch:{ all -> 0x0267 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x0267 }
        r9.b(r1);	 Catch:{ all -> 0x0267 }
        r1 = r9.b(r2, r1);	 Catch:{ all -> 0x0267 }
        if (r1 == 0) goto L_0x02a2;
    L_0x0263:
        r1 = r2 + 1;
    L_0x0265:
        r2 = r1;
        goto L_0x024e;
    L_0x0267:
        r1 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x0267 }
        throw r1;
    L_0x026a:
        r1 = bZD();
        r1 = r1.size();
        r1 = r1 + -1;
        goto L_0x0102;
    L_0x0276:
        r6 = new com.tencent.mm.plugin.wenote.model.a.h;
        r6.<init>();
        r6.type = r7;
        r8 = "";
        r6.content = r8;
        r6.qoJ = r5;
        r6.qoH = r7;
        r6.qoN = r5;
        r9.b(r1, r6);
        goto L_0x0125;
    L_0x028d:
        if (r3 != 0) goto L_0x014c;
    L_0x028f:
        r2 = r9.qpR;
        r4 = bZD();
        r4 = r4.size();
        r4 = r4 - r3;
        r2.eo(r3, r4);
        goto L_0x014c;
    L_0x029f:
        r4 = r5;
        goto L_0x00ef;
    L_0x02a2:
        r1 = r2;
        goto L_0x0265;
    L_0x02a4:
        r3 = r6;
        goto L_0x0249;
    L_0x02a6:
        r1 = r2;
        goto L_0x020f;
    L_0x02a9:
        r1 = r5;
        goto L_0x00a2;
    L_0x02ac:
        r1 = r2;
        goto L_0x00a6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, com.tencent.mm.plugin.wenote.model.nativenote.manager.WXRTEditText, boolean, boolean, boolean, boolean):int");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(java.util.ArrayList<com.tencent.mm.plugin.wenote.model.a.b> r9, int r10, int r11, int r12, int r13) {
        /*
        r8 = this;
        r6 = 1;
        r3 = -1;
        r4 = 0;
        if (r9 == 0) goto L_0x0017;
    L_0x0005:
        r1 = r9.size();
        if (r1 <= 0) goto L_0x0017;
    L_0x000b:
        r1 = r8.gBc;
        if (r1 == 0) goto L_0x0017;
    L_0x000f:
        if (r11 < 0) goto L_0x0017;
    L_0x0011:
        if (r12 < 0) goto L_0x0017;
    L_0x0013:
        if (r13 < 0) goto L_0x0017;
    L_0x0015:
        if (r13 >= r12) goto L_0x0022;
    L_0x0017:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList,error,return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
    L_0x0021:
        return r1;
    L_0x0022:
        r1 = com.tencent.mm.plugin.wenote.model.c.bZb();
        r1 = r1.qnC;
        if (r1 != 0) goto L_0x0035;
    L_0x002a:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList, but get wnnote base is null, return";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
        goto L_0x0021;
    L_0x0035:
        r1 = r9.size();
        r1 = r1 + -1;
        r1 = r9.get(r1);
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;
        if (r1 != 0) goto L_0x004e;
    L_0x0043:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList, lastInsertItem is null";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
        goto L_0x0021;
    L_0x004e:
        r1.qoJ = r3;
        r1.qoH = r6;
        r1.qoN = r4;
        r2 = r8.Bv(r11);
        if (r2 != 0) goto L_0x0065;
    L_0x005a:
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "pasteItemList, item is null";
        com.tencent.mm.sdk.platformtools.x.e(r1, r2);
        r1 = r3;
        goto L_0x0021;
    L_0x0065:
        monitor-enter(r8);
        r8.bZH();	 Catch:{ all -> 0x01d5 }
        if (r10 != 0) goto L_0x016f;
    L_0x006b:
        r1 = r2.getType();	 Catch:{ all -> 0x01d5 }
        if (r1 != r6) goto L_0x016f;
    L_0x0071:
        r0 = r2;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x01d5 }
        r1 = r0;
        r1 = r1.content;	 Catch:{ all -> 0x01d5 }
        r5 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(r1);	 Catch:{ all -> 0x01d5 }
        if (r5 == 0) goto L_0x0089;
    L_0x007d:
        r1 = r5.length();	 Catch:{ all -> 0x01d5 }
        if (r12 > r1) goto L_0x0089;
    L_0x0083:
        r1 = r5.length();	 Catch:{ all -> 0x01d5 }
        if (r13 <= r1) goto L_0x00b6;
    L_0x0089:
        r2 = "MicroMsg.Note.NoteDataManager";
        r4 = "pasteItemList error, oriText:%d  startOff:%d  endOff:%d";
        r1 = 3;
        r6 = new java.lang.Object[r1];	 Catch:{ all -> 0x01d5 }
        r7 = 0;
        if (r5 != 0) goto L_0x00b1;
    L_0x0095:
        r1 = r3;
    L_0x0096:
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ all -> 0x01d5 }
        r6[r7] = r1;	 Catch:{ all -> 0x01d5 }
        r1 = 1;
        r5 = java.lang.Integer.valueOf(r12);	 Catch:{ all -> 0x01d5 }
        r6[r1] = r5;	 Catch:{ all -> 0x01d5 }
        r1 = 2;
        r5 = java.lang.Integer.valueOf(r13);	 Catch:{ all -> 0x01d5 }
        r6[r1] = r5;	 Catch:{ all -> 0x01d5 }
        com.tencent.mm.sdk.platformtools.x.e(r2, r4, r6);	 Catch:{ all -> 0x01d5 }
        monitor-exit(r8);	 Catch:{ all -> 0x01d5 }
        r1 = r3;
        goto L_0x0021;
    L_0x00b1:
        r1 = r5.length();	 Catch:{ all -> 0x01d5 }
        goto L_0x0096;
    L_0x00b6:
        r1 = 0;
        r1 = r5.subSequence(r1, r12);	 Catch:{ all -> 0x01d5 }
        r3 = r5.length();	 Catch:{ all -> 0x01d5 }
        r3 = r5.subSequence(r13, r3);	 Catch:{ all -> 0x01d5 }
        r1 = (android.text.Spanned) r1;	 Catch:{ all -> 0x01d5 }
        r5 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x01d5 }
        r0 = r3;
        r0 = (android.text.Spanned) r0;	 Catch:{ all -> 0x01d5 }
        r1 = r0;
        r1 = com.tencent.mm.plugin.wenote.model.nativenote.a.b.a(r1);	 Catch:{ all -> 0x01d5 }
        r2 = (com.tencent.mm.plugin.wenote.model.a.h) r2;	 Catch:{ all -> 0x01d5 }
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r5);	 Catch:{ all -> 0x01d5 }
        if (r3 != 0) goto L_0x0141;
    L_0x00d9:
        r3 = "<br/>";
        r3 = r5.endsWith(r3);	 Catch:{ all -> 0x01d5 }
        if (r3 == 0) goto L_0x013f;
    L_0x00e2:
        r3 = 0;
        r7 = r5.length();	 Catch:{ all -> 0x01d5 }
        r7 = r7 + -5;
        r3 = r5.substring(r3, r7);	 Catch:{ all -> 0x01d5 }
    L_0x00ed:
        r2.content = r3;	 Catch:{ all -> 0x01d5 }
        r11 = r11 + 1;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r1);	 Catch:{ all -> 0x01d5 }
        if (r2 != 0) goto L_0x016b;
    L_0x00f7:
        r2 = new com.tencent.mm.plugin.wenote.model.a.h;	 Catch:{ all -> 0x01d5 }
        r2.<init>();	 Catch:{ all -> 0x01d5 }
        r3 = 1;
        r2.type = r3;	 Catch:{ all -> 0x01d5 }
        r3 = "<br/>";
        r3 = r1.startsWith(r3);	 Catch:{ all -> 0x01d5 }
        if (r3 == 0) goto L_0x0111;
    L_0x0108:
        r3 = 5;
        r4 = r1.length();	 Catch:{ all -> 0x01d5 }
        r1 = r1.substring(r3, r4);	 Catch:{ all -> 0x01d5 }
    L_0x0111:
        r2.content = r1;	 Catch:{ all -> 0x01d5 }
        r1 = 0;
        r2.qoJ = r1;	 Catch:{ all -> 0x01d5 }
        r1 = 0;
        r2.qoH = r1;	 Catch:{ all -> 0x01d5 }
        r1 = 0;
        r2.qoN = r1;	 Catch:{ all -> 0x01d5 }
        r8.b(r11, r2);	 Catch:{ all -> 0x01d5 }
        r3 = r6;
        r5 = r11;
        r2 = r11;
    L_0x0122:
        r4 = r9.iterator();	 Catch:{ all -> 0x01d5 }
    L_0x0126:
        r1 = r4.hasNext();	 Catch:{ all -> 0x01d5 }
        if (r1 == 0) goto L_0x0192;
    L_0x012c:
        r1 = r4.next();	 Catch:{ all -> 0x01d5 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x01d5 }
        r8.b(r1);	 Catch:{ all -> 0x01d5 }
        r1 = r8.b(r2, r1);	 Catch:{ all -> 0x01d5 }
        if (r1 == 0) goto L_0x01f9;
    L_0x013b:
        r1 = r2 + 1;
    L_0x013d:
        r2 = r1;
        goto L_0x0126;
    L_0x013f:
        r3 = r5;
        goto L_0x00ed;
    L_0x0141:
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r1);	 Catch:{ all -> 0x01d5 }
        if (r3 != 0) goto L_0x015f;
    L_0x0147:
        r3 = "<br/>";
        r3 = r1.startsWith(r3);	 Catch:{ all -> 0x01d5 }
        if (r3 == 0) goto L_0x0159;
    L_0x0150:
        r3 = 5;
        r5 = r1.length();	 Catch:{ all -> 0x01d5 }
        r1 = r1.substring(r3, r5);	 Catch:{ all -> 0x01d5 }
    L_0x0159:
        r2.content = r1;	 Catch:{ all -> 0x01d5 }
        r3 = r4;
        r5 = r11;
        r2 = r11;
        goto L_0x0122;
    L_0x015f:
        r8.Bw(r11);	 Catch:{ all -> 0x01d5 }
        r1 = r8.qpR;	 Catch:{ all -> 0x01d5 }
        if (r1 == 0) goto L_0x016b;
    L_0x0166:
        r1 = r8.qpR;	 Catch:{ all -> 0x01d5 }
        r1.Bq(r11);	 Catch:{ all -> 0x01d5 }
    L_0x016b:
        r3 = r4;
        r5 = r11;
        r2 = r11;
        goto L_0x0122;
    L_0x016f:
        if (r10 == r6) goto L_0x01f6;
    L_0x0171:
        r5 = r11 + 1;
    L_0x0173:
        r3 = r9.iterator();	 Catch:{ all -> 0x01d5 }
        r2 = r5;
    L_0x0178:
        r1 = r3.hasNext();	 Catch:{ all -> 0x01d5 }
        if (r1 == 0) goto L_0x0191;
    L_0x017e:
        r1 = r3.next();	 Catch:{ all -> 0x01d5 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x01d5 }
        r8.b(r1);	 Catch:{ all -> 0x01d5 }
        r1 = r8.b(r2, r1);	 Catch:{ all -> 0x01d5 }
        if (r1 == 0) goto L_0x01f4;
    L_0x018d:
        r1 = r2 + 1;
    L_0x018f:
        r2 = r1;
        goto L_0x0178;
    L_0x0191:
        r3 = r4;
    L_0x0192:
        monitor-exit(r8);	 Catch:{ all -> 0x01d5 }
        r1 = r2 + -1;
        if (r1 < 0) goto L_0x01d8;
    L_0x0197:
        r1 = r2 + -1;
        r4 = bZD();
        r4 = r4.size();
        if (r1 >= r4) goto L_0x01d8;
    L_0x01a3:
        r1 = r2 + -1;
    L_0x01a5:
        r4 = r8.qpR;
        if (r4 == 0) goto L_0x01d0;
    L_0x01a9:
        r2 = r2 - r5;
        if (r3 == 0) goto L_0x01ae;
    L_0x01ac:
        r2 = r2 + 1;
    L_0x01ae:
        if (r5 < 0) goto L_0x01b7;
    L_0x01b0:
        if (r2 <= 0) goto L_0x01b7;
    L_0x01b2:
        r3 = r8.qpR;
        r3.en(r5, r2);
    L_0x01b7:
        if (r5 <= 0) goto L_0x01e3;
    L_0x01b9:
        r2 = r8.qpR;
        r3 = r5 + -1;
        r4 = bZD();
        r4 = r4.size();
        r5 = r5 + -1;
        r4 = r4 - r5;
        r2.eo(r3, r4);
    L_0x01cb:
        r2 = r8.qpR;
        r2.Br(r1);
    L_0x01d0:
        r8.bZM();
        goto L_0x0021;
    L_0x01d5:
        r1 = move-exception;
        monitor-exit(r8);	 Catch:{ all -> 0x01d5 }
        throw r1;
    L_0x01d8:
        r1 = bZD();
        r1 = r1.size();
        r1 = r1 + -1;
        goto L_0x01a5;
    L_0x01e3:
        if (r5 != 0) goto L_0x01cb;
    L_0x01e5:
        r2 = r8.qpR;
        r3 = bZD();
        r3 = r3.size();
        r3 = r3 - r5;
        r2.eo(r5, r3);
        goto L_0x01cb;
    L_0x01f4:
        r1 = r2;
        goto L_0x018f;
    L_0x01f6:
        r5 = r11;
        goto L_0x0173;
    L_0x01f9:
        r1 = r2;
        goto L_0x013d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.a(java.util.ArrayList, int, int, int, int):int");
    }

    private void b(b bVar) {
        if (bVar != null) {
            n nVar = (n) bVar;
            if (nVar.getType() > 1) {
                if (bi.oW(nVar.qpc)) {
                    if (this.qpT == 0 && this.gBc != null) {
                        Iterator it = this.gBc.iterator();
                        while (it.hasNext()) {
                            n nVar2 = (n) ((b) it.next());
                            if (nVar2.qpc.startsWith("WeNote_")) {
                                int i = bi.getInt(nVar2.qpc.substring(7), -1);
                                if (i <= this.qpT) {
                                    i = this.qpT;
                                }
                                this.qpT = i;
                            }
                        }
                    }
                    StringBuilder stringBuilder = new StringBuilder("WeNote_");
                    int i2 = this.qpT + 1;
                    this.qpT = i2;
                    nVar.qpc = stringBuilder.append(i2).toString();
                }
                d dVar = com.tencent.mm.plugin.wenote.model.c.bZb().qnC;
                if (dVar == null) {
                    x.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but get wnnote base is null", new Object[]{bVar.toString()});
                } else if (dVar.qnI == null) {
                    x.e("MicroMsg.Note.NoteDataManager", "processItem,item is %s, but mEditorIdToDataItem is null", new Object[]{bVar.toString()});
                } else {
                    dVar.qnI.put(nVar.qpc, nVar);
                }
            }
            if (bi.oW(bVar.jdM)) {
                bVar.jdM = f.Sf(bVar.toString());
            }
        }
    }

    public final ArrayList<b> bZL() {
        if (this.gBc == null) {
            return null;
        }
        ArrayList<b> arrayList = new ArrayList();
        synchronized (this) {
            Iterator it = this.gBc.iterator();
            while (it.hasNext()) {
                arrayList.add(com.tencent.mm.plugin.wenote.b.c.c((b) it.next()));
            }
        }
        return arrayList;
    }

    public final boolean Y(ArrayList<b> arrayList) {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.getType() != 1) {
                i++;
            } else {
                stringBuilder.append(((h) bVar).content);
            }
        }
        return eq(com.tencent.mm.plugin.wenote.b.c.Sr(stringBuilder.toString()), i);
    }

    public final boolean eq(int i, int i2) {
        boolean z;
        boolean z2;
        if (i < 0) {
            z = false;
        } else {
            z = true;
        }
        if (i2 < 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (z && this.qpU + i > 16384) {
            return true;
        }
        if (!z2 || this.qpV + i2 <= 30) {
            return false;
        }
        return true;
    }

    public final void bZM() {
        au.Em().H(new 3(this));
    }

    private void a(b bVar, boolean z) {
        if (bVar != null) {
            if (bVar.getType() == 1) {
                int Sr = com.tencent.mm.plugin.wenote.b.c.Sr(((h) bVar).content);
                if (z) {
                    this.qpU = Sr + this.qpU;
                } else {
                    this.qpU -= Sr;
                }
            } else if (z) {
                this.qpV++;
            } else {
                this.qpV--;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void er(int r10, int r11) {
        /*
        r9 = this;
        r0 = 0;
        r3 = -1;
        r8 = 1;
        r1 = "MicroMsg.Note.NoteDataManager";
        r2 = "checkMergeTextDataItem startPos: %d endPos: %d needNotify: %b";
        r4 = 3;
        r4 = new java.lang.Object[r4];
        r5 = java.lang.Integer.valueOf(r10);
        r4[r0] = r5;
        r5 = java.lang.Integer.valueOf(r11);
        r4[r8] = r5;
        r5 = 2;
        r6 = java.lang.Boolean.valueOf(r8);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.x.i(r1, r2, r4);
        monitor-enter(r9);
        r1 = r9.gBc;	 Catch:{ all -> 0x00e3 }
        if (r1 != 0) goto L_0x0029;
    L_0x0027:
        monitor-exit(r9);	 Catch:{ all -> 0x00e3 }
    L_0x0028:
        return;
    L_0x0029:
        if (r10 > 0) goto L_0x002c;
    L_0x002b:
        r10 = r0;
    L_0x002c:
        r0 = r9.gBc;	 Catch:{ all -> 0x00e3 }
        r0 = r0.size();	 Catch:{ all -> 0x00e3 }
        if (r11 < r0) goto L_0x011b;
    L_0x0034:
        r0 = r9.gBc;	 Catch:{ all -> 0x00e3 }
        r0 = r0.size();	 Catch:{ all -> 0x00e3 }
        r11 = r0 + -1;
        r2 = r3;
    L_0x003d:
        if (r11 <= r10) goto L_0x0103;
    L_0x003f:
        r0 = r9.gBc;	 Catch:{ all -> 0x00e3 }
        r0 = r0.get(r11);	 Catch:{ all -> 0x00e3 }
        r0 = (com.tencent.mm.plugin.wenote.model.a.b) r0;	 Catch:{ all -> 0x00e3 }
        r1 = r9.gBc;	 Catch:{ all -> 0x00e3 }
        r4 = r11 + -1;
        r1 = r1.get(r4);	 Catch:{ all -> 0x00e3 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.b) r1;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00d1;
    L_0x0053:
        r4 = r0.getType();	 Catch:{ all -> 0x00e3 }
        if (r4 != r8) goto L_0x00d1;
    L_0x0059:
        if (r1 == 0) goto L_0x00d1;
    L_0x005b:
        r4 = r1.getType();	 Catch:{ all -> 0x00e3 }
        if (r4 != r8) goto L_0x00d1;
    L_0x0061:
        r2 = r11 + -1;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;	 Catch:{ all -> 0x00e3 }
        r1 = (com.tencent.mm.plugin.wenote.model.a.h) r1;	 Catch:{ all -> 0x00e3 }
        r4 = r0.content;	 Catch:{ all -> 0x00e3 }
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r4);	 Catch:{ all -> 0x00e3 }
        if (r4 != 0) goto L_0x00f5;
    L_0x006f:
        r4 = r0.content;	 Catch:{ all -> 0x00e3 }
        r4 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(r4);	 Catch:{ all -> 0x00e3 }
        r5 = r1.content;	 Catch:{ all -> 0x00e3 }
        r5 = com.tencent.mm.plugin.wenote.model.nativenote.a.a.Sk(r5);	 Catch:{ all -> 0x00e3 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00e3 }
        r6.<init>();	 Catch:{ all -> 0x00e3 }
        r7 = r1.content;	 Catch:{ all -> 0x00e3 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e3 }
        r7 = "<br/>";
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e3 }
        r7 = r0.content;	 Catch:{ all -> 0x00e3 }
        r6 = r6.append(r7);	 Catch:{ all -> 0x00e3 }
        r6 = r6.toString();	 Catch:{ all -> 0x00e3 }
        r1.content = r6;	 Catch:{ all -> 0x00e3 }
        r6 = r0.qoH;	 Catch:{ all -> 0x00e3 }
        if (r6 == 0) goto L_0x00e6;
    L_0x009d:
        r6 = 1;
        r1.qoH = r6;	 Catch:{ all -> 0x00e3 }
        r6 = 0;
        r1.qoN = r6;	 Catch:{ all -> 0x00e3 }
        r6 = r0.qoJ;	 Catch:{ all -> 0x00e3 }
        if (r6 == r3) goto L_0x00af;
    L_0x00a7:
        r6 = r0.qoJ;	 Catch:{ all -> 0x00e3 }
        r4 = r4.length();	 Catch:{ all -> 0x00e3 }
        if (r6 < r4) goto L_0x00d7;
    L_0x00af:
        r0 = -1;
        r1.qoJ = r0;	 Catch:{ all -> 0x00e3 }
    L_0x00b2:
        r0 = "MicroMsg.Note.NoteDataManager";
        r1 = "checkMergeTextDataItem remove position: %d";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x00e3 }
        r5 = 0;
        r6 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x00e3 }
        r4[r5] = r6;	 Catch:{ all -> 0x00e3 }
        com.tencent.mm.sdk.platformtools.x.i(r0, r1, r4);	 Catch:{ all -> 0x00e3 }
        r9.Bw(r11);	 Catch:{ all -> 0x00e3 }
        r0 = r9.qpR;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00d1;
    L_0x00cc:
        r0 = r9.qpR;	 Catch:{ all -> 0x00e3 }
        r0.Bq(r11);	 Catch:{ all -> 0x00e3 }
    L_0x00d1:
        r0 = r2;
        r11 = r11 + -1;
        r2 = r0;
        goto L_0x003d;
    L_0x00d7:
        r4 = r5.length();	 Catch:{ all -> 0x00e3 }
        r4 = r4 + 1;
        r0 = r0.qoJ;	 Catch:{ all -> 0x00e3 }
        r0 = r0 + r4;
        r1.qoJ = r0;	 Catch:{ all -> 0x00e3 }
        goto L_0x00b2;
    L_0x00e3:
        r0 = move-exception;
        monitor-exit(r9);	 Catch:{ all -> 0x00e3 }
        throw r0;
    L_0x00e6:
        r0 = r1.qoH;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00b2;
    L_0x00ea:
        r0 = r1.qoJ;	 Catch:{ all -> 0x00e3 }
        if (r0 != r3) goto L_0x00b2;
    L_0x00ee:
        r0 = r5.length();	 Catch:{ all -> 0x00e3 }
        r1.qoJ = r0;	 Catch:{ all -> 0x00e3 }
        goto L_0x00b2;
    L_0x00f5:
        r0 = r0.qoH;	 Catch:{ all -> 0x00e3 }
        if (r0 == 0) goto L_0x00b2;
    L_0x00f9:
        r0 = 1;
        r1.qoH = r0;	 Catch:{ all -> 0x00e3 }
        r0 = 0;
        r1.qoN = r0;	 Catch:{ all -> 0x00e3 }
        r0 = -1;
        r1.qoJ = r0;	 Catch:{ all -> 0x00e3 }
        goto L_0x00b2;
    L_0x0103:
        monitor-exit(r9);	 Catch:{ all -> 0x00e3 }
        if (r2 == r3) goto L_0x0116;
    L_0x0106:
        r0 = r9.qpR;
        if (r0 == 0) goto L_0x0116;
    L_0x010a:
        r0 = r9.qpR;
        r1 = r9.gBc;
        r1 = r1.size();
        r1 = r1 - r2;
        r0.eo(r2, r1);
    L_0x0116:
        r9.bZM();
        goto L_0x0028;
    L_0x011b:
        r2 = r3;
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.nativenote.manager.c.er(int, int):void");
    }

    public final String Sn(String str) {
        String replace;
        synchronized (this) {
            if (this.gBc != null) {
                int i = 0;
                String str2 = str;
                while (i < this.gBc.size()) {
                    if (((b) this.gBc.get(i)).getType() == 1) {
                        replace = com.tencent.mm.plugin.wenote.b.b.Sp(((h) this.gBc.get(i)).content).replace("&lt;", "<").replace("&gt;", ">").replace(" ", " ");
                        if (!bi.oW(replace)) {
                            int i2;
                            String[] split = replace.split("\n");
                            for (int i3 = 0; i3 < split.length; i3++) {
                                if (!bi.oW(split[i3].trim())) {
                                    replace = split[i3];
                                    i2 = 1;
                                    break;
                                }
                            }
                            i2 = 0;
                            replace = str2;
                            if (i2 != 0) {
                                break;
                            }
                            i++;
                            str2 = replace;
                        }
                    }
                    replace = str2;
                    i++;
                    str2 = replace;
                }
                replace = str2;
            } else {
                replace = str;
            }
        }
        if (replace.length() > TbsLog.TBSLOG_CODE_SDK_BASE) {
            return replace.substring(0, TbsLog.TBSLOG_CODE_SDK_BASE);
        }
        return replace;
    }

    public final int bZN() {
        synchronized (this) {
            if (this.gBc == null) {
                return -1;
            }
            int i = 0;
            while (i < this.gBc.size()) {
                b bVar = (b) this.gBc.get(i);
                if (bVar == null || bVar.getType() == -3 || bVar.getType() == -2) {
                    i++;
                } else {
                    return i;
                }
            }
            return -1;
        }
    }

    public final int bZO() {
        synchronized (this) {
            if (this.gBc == null) {
                return -1;
            }
            int size = this.gBc.size() - 1;
            while (size >= 0) {
                b bVar = (b) this.gBc.get(size);
                if (bVar == null || bVar.getType() == -3 || bVar.getType() == -2) {
                    size--;
                } else {
                    return size;
                }
            }
            return -1;
        }
    }
}
