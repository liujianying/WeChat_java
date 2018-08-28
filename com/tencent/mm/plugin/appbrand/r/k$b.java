package com.tencent.mm.plugin.appbrand.r;

import com.tencent.mm.plugin.appbrand.r.k.c;
import com.tencent.mm.plugin.appbrand.r.k.e;
import java.util.Arrays;
import java.util.List;

public class k$b {
    public final List<e> gBR;
    public final int[] gBS;
    private final int[] gBT;
    public final k$a gBU;
    public final int gBV;
    public final int gBW;
    private final boolean gBX;

    k$b(k$a k_a, List<e> list, int[] iArr, int[] iArr2, boolean z) {
        this.gBR = list;
        this.gBS = iArr;
        this.gBT = iArr2;
        Arrays.fill(this.gBS, 0);
        Arrays.fill(this.gBT, 0);
        this.gBU = k_a;
        this.gBV = k_a.anr();
        this.gBW = k_a.ans();
        this.gBX = z;
        e eVar = this.gBR.isEmpty() ? null : (e) this.gBR.get(0);
        if (!(eVar != null && eVar.x == 0 && eVar.y == 0)) {
            eVar = new e();
            eVar.x = 0;
            eVar.y = 0;
            eVar.gCa = false;
            eVar.size = 0;
            eVar.gCf = false;
            this.gBR.add(0, eVar);
        }
        aoA();
    }

    private void aoA() {
        int i = this.gBV;
        int i2 = this.gBW;
        for (int size = this.gBR.size() - 1; size >= 0; size--) {
            e eVar = (e) this.gBR.get(size);
            int i3 = eVar.x + eVar.size;
            int i4 = eVar.y + eVar.size;
            if (this.gBX) {
                while (i > i3) {
                    if (this.gBS[i - 1] == 0) {
                        c(i, i2, size, false);
                    }
                    i--;
                }
                while (i2 > i4) {
                    if (this.gBT[i2 - 1] == 0) {
                        c(i, i2, size, true);
                    }
                    i2--;
                }
            }
            for (i2 = 0; i2 < eVar.size; i2++) {
                i3 = eVar.x + i2;
                i4 = eVar.y + i2;
                i = this.gBU.bW(i3, i4) ? 1 : 2;
                this.gBS[i3] = (i4 << 5) | i;
                this.gBT[i4] = i | (i3 << 5);
            }
            i = eVar.x;
            i2 = eVar.y;
        }
    }

    private boolean c(int i, int i2, int i3, boolean z) {
        int i4;
        int i5;
        int i6;
        int i7 = 8;
        if (z) {
            i4 = i2 - 1;
            i2--;
            i5 = i;
            i6 = i4;
        } else {
            i6 = i - 1;
            i5 = i - 1;
        }
        while (i3 >= 0) {
            e eVar = (e) this.gBR.get(i3);
            int i8 = eVar.x + eVar.size;
            int i9 = eVar.y + eVar.size;
            if (z) {
                for (i5--; i5 >= i8; i5--) {
                    if (this.gBU.bV(i5, i6)) {
                        i4 = this.gBU.bW(i5, i6) ? 8 : 4;
                        this.gBT[i6] = (i5 << 5) | 16;
                        this.gBS[i5] = i4 | (i6 << 5);
                        return true;
                    }
                }
                continue;
            } else {
                for (i5 = i2 - 1; i5 >= i9; i5--) {
                    if (this.gBU.bV(i6, i5)) {
                        if (!this.gBU.bW(i6, i5)) {
                            i7 = 4;
                        }
                        this.gBS[i - 1] = (i5 << 5) | 16;
                        this.gBT[i5] = i7 | ((i - 1) << 5);
                        return true;
                    }
                }
                continue;
            }
            i5 = eVar.x;
            i2 = eVar.y;
            i3--;
        }
        return false;
    }

    private static c c(List<c> list, int i, boolean z) {
        int size = list.size() - 1;
        while (size >= 0) {
            c cVar = (c) list.get(size);
            if (cVar.gBY == i && cVar.gCa == z) {
                list.remove(size);
                while (true) {
                    int i2 = size;
                    if (i2 >= list.size()) {
                        return cVar;
                    }
                    c cVar2 = (c) list.get(i2);
                    cVar2.gBZ = (z ? 1 : -1) + cVar2.gBZ;
                    size = i2 + 1;
                }
            } else {
                size--;
            }
        }
        return null;
    }

    public final void a(List<c> list, l lVar, int i, int i2, int i3) {
        if (this.gBX) {
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.gBT[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        lVar.bR(i, 1);
                        for (c cVar : list) {
                            cVar.gBZ++;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.gBT[i3 + i4] >> 5;
                        lVar.bT(c(list, i6, true).gBZ, i);
                        if (i5 != 4) {
                            break;
                        }
                        lVar.d(i, 1, this.gBU.bX(i6, i3 + i4));
                        break;
                    case 16:
                        list.add(new c(i3 + i4, i, false));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                }
            }
            return;
        }
        lVar.bR(i, i2);
    }

    public final void b(List<c> list, l lVar, int i, int i2, int i3) {
        if (this.gBX) {
            for (int i4 = i2 - 1; i4 >= 0; i4--) {
                int i5 = this.gBS[i3 + i4] & 31;
                switch (i5) {
                    case 0:
                        lVar.bS(i + i4, 1);
                        for (c cVar : list) {
                            cVar.gBZ--;
                        }
                        break;
                    case 4:
                    case 8:
                        int i6 = this.gBS[i3 + i4] >> 5;
                        c c = c(list, i6, false);
                        lVar.bT(i + i4, c.gBZ - 1);
                        if (i5 != 4) {
                            break;
                        }
                        lVar.d(c.gBZ - 1, 1, this.gBU.bX(i3 + i4, i6));
                        break;
                    case 16:
                        list.add(new c(i3 + i4, i + i4, true));
                        break;
                    default:
                        throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                }
            }
            return;
        }
        lVar.bS(i, i2);
    }
}
