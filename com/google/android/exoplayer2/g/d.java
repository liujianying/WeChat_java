package com.google.android.exoplayer2.g;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import com.google.android.exoplayer2.t;
import java.util.Arrays;
import java.util.Map;

public abstract class d extends g {
    private final SparseArray<Map<m, b>> aAl = new SparseArray();
    private final SparseBooleanArray aAm = new SparseBooleanArray();
    private a aAn;
    private int aeA = 0;

    protected abstract e[] a(s[] sVarArr, m[] mVarArr, int[][][] iArr);

    public final h a(s[] sVarArr, m mVar) {
        int i;
        int i2;
        int length;
        int i3;
        int i4;
        int b;
        int[] iArr;
        int[] iArr2 = new int[(sVarArr.length + 1)];
        l[][] lVarArr = new l[(sVarArr.length + 1)][];
        int[][][] iArr3 = new int[(sVarArr.length + 1)][][];
        for (i = 0; i < lVarArr.length; i++) {
            lVarArr[i] = new l[mVar.length];
            iArr3[i] = new int[mVar.length][];
        }
        int[] iArr4 = new int[sVarArr.length];
        for (i = 0; i < iArr4.length; i++) {
            iArr4[i] = sVarArr[i].iw();
        }
        i = 0;
        while (true) {
            i2 = i;
            if (i2 >= mVar.length) {
                break;
            }
            int[] iArr5;
            l lVar = mVar.asI[i2];
            length = sVarArr.length;
            i = 0;
            i3 = 0;
            while (i3 < sVarArr.length) {
                s sVar = sVarArr[i3];
                for (i4 = 0; i4 < lVar.length; i4++) {
                    b = sVar.b(lVar.asb[i4]) & 7;
                    if (b > i) {
                        if (b == 4) {
                            break;
                        }
                        i = b;
                        length = i3;
                    }
                }
                i3++;
            }
            i3 = length;
            if (i3 == sVarArr.length) {
                iArr5 = new int[lVar.length];
            } else {
                s sVar2 = sVarArr[i3];
                iArr = new int[lVar.length];
                for (i = 0; i < lVar.length; i++) {
                    iArr[i] = sVar2.b(lVar.asb[i]);
                }
                iArr5 = iArr;
            }
            length = iArr2[i3];
            lVarArr[i3][length] = lVar;
            iArr3[i3][length] = iArr5;
            iArr2[i3] = iArr2[i3] + 1;
            i = i2 + 1;
        }
        m[] mVarArr = new m[sVarArr.length];
        iArr = new int[sVarArr.length];
        i = 0;
        while (true) {
            i4 = i;
            if (i4 >= sVarArr.length) {
                break;
            }
            b = iArr2[i4];
            mVarArr[i4] = new m((l[]) Arrays.copyOf(lVarArr[i4], b));
            iArr3[i4] = (int[][]) Arrays.copyOf(iArr3[i4], b);
            iArr[i4] = sVarArr[i4].getTrackType();
            i = i4 + 1;
        }
        m mVar2 = new m((l[]) Arrays.copyOf(lVarArr[sVarArr.length], iArr2[sVarArr.length]));
        e[] a = a(sVarArr, mVarArr, iArr3);
        for (i2 = 0; i2 < sVarArr.length; i2++) {
            e eVar;
            e[] eVarArr;
            if (this.aAm.get(i2)) {
                eVar = null;
                b = i2;
                eVarArr = a;
            } else {
                m mVar3 = mVarArr[i2];
                Map map = (Map) this.aAl.get(i2);
                Object obj = (map == null || !map.containsKey(mVar3)) ? null : 1;
                if (obj != null) {
                    b bVar = (b) ((Map) this.aAl.get(i2)).get(mVar3);
                    if (bVar == null) {
                        eVar = null;
                        b = i2;
                        eVarArr = a;
                    } else {
                        a aVar = bVar.aAt;
                        l[] lVarArr2 = mVar3.asI;
                        eVar = aVar.lJ();
                        b = i2;
                        eVarArr = a;
                    }
                } else {
                }
            }
            eVarArr[b] = eVar;
        }
        a aVar2 = new a(iArr, mVarArr, iArr4, iArr3, mVar2);
        t[] tVarArr = new t[sVarArr.length];
        for (length = 0; length < sVarArr.length; length++) {
            tVarArr[length] = a[length] != null ? t.aez : null;
        }
        int i5 = this.aeA;
        if (i5 != 0) {
            b = -1;
            int i6 = -1;
            i4 = 0;
            while (i4 < sVarArr.length) {
                int trackType = sVarArr[i4].getTrackType();
                e eVar2 = a[i4];
                if ((trackType == 1 || trackType == 2) && eVar2 != null) {
                    Object obj2;
                    int[][] iArr6 = iArr3[i4];
                    m mVar4 = mVarArr[i4];
                    if (eVar2 == null) {
                        obj2 = null;
                    } else {
                        int a2 = mVar4.a(eVar2.lG());
                        for (length = 0; length < eVar2.length(); length++) {
                            if ((iArr6[a2][eVar2.cT(length)] & 32) != 32) {
                                obj2 = null;
                                break;
                            }
                        }
                        obj2 = 1;
                    }
                    if (obj2 != null) {
                        if (trackType == 1) {
                            if (b != -1) {
                                i3 = 0;
                                break;
                            }
                            length = i6;
                            b = i4;
                            i4++;
                            i6 = length;
                        } else if (i6 != -1) {
                            i3 = 0;
                            break;
                        } else {
                            length = i4;
                            i4++;
                            i6 = length;
                        }
                    }
                }
                length = i6;
                i4++;
                i6 = length;
            }
            i3 = 1;
            length = (b == -1 || i6 == -1) ? 0 : 1;
            if ((length & i3) != 0) {
                t tVar = new t(i5);
                tVarArr[b] = tVar;
                tVarArr[i6] = tVar;
            }
        }
        return new h(mVar, new f(a), aVar2, tVarArr);
    }

    public final void X(Object obj) {
        this.aAn = (a) obj;
    }
}
