package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.e.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class b extends d {
    private static final int[] azX = new int[0];
    private final a azY;
    private final AtomicReference<b> azZ;

    public static final class b {
        public final String aAa;
        public final String aAb;
        public final int aAc;
        public final int aAd;
        public final int aAe;
        public final boolean aAf;
        public final boolean aAg;
        public final boolean aAh;
        public final boolean aAi;
        public final boolean aAj;
        public final int viewportHeight;
        public final int viewportWidth;

        public b() {
            this((byte) 0);
        }

        private b(byte b) {
            this.aAa = null;
            this.aAb = null;
            this.aAh = false;
            this.aAi = true;
            this.aAc = Integer.MAX_VALUE;
            this.aAd = Integer.MAX_VALUE;
            this.aAe = Integer.MAX_VALUE;
            this.aAf = true;
            this.aAj = true;
            this.viewportWidth = Integer.MAX_VALUE;
            this.viewportHeight = Integer.MAX_VALUE;
            this.aAg = true;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.aAh == bVar.aAh && this.aAi == bVar.aAi && this.aAc == bVar.aAc && this.aAd == bVar.aAd && this.aAf == bVar.aAf && this.aAj == bVar.aAj && this.aAg == bVar.aAg && this.viewportWidth == bVar.viewportWidth && this.viewportHeight == bVar.viewportHeight && this.aAe == bVar.aAe && TextUtils.equals(this.aAa, bVar.aAa) && TextUtils.equals(this.aAb, bVar.aAb)) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            int i;
            int i2 = 1;
            int hashCode = ((this.aAh ? 1 : 0) + (((this.aAa.hashCode() * 31) + this.aAb.hashCode()) * 31)) * 31;
            if (this.aAi) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (((((((i + hashCode) * 31) + this.aAc) * 31) + this.aAd) * 31) + this.aAe) * 31;
            if (this.aAf) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (i + hashCode) * 31;
            if (this.aAj) {
                i = 1;
            } else {
                i = 0;
            }
            i = (i + hashCode) * 31;
            if (!this.aAg) {
                i2 = 0;
            }
            return ((((i + i2) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
        }
    }

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.azY = null;
        this.azZ = new AtomicReference(new b());
    }

    protected final e[] a(s[] sVarArr, m[] mVarArr, int[][][] iArr) {
        int i;
        int i2;
        int length = sVarArr.length;
        e[] eVarArr = new e[length];
        b bVar = (b) this.azZ.get();
        Object obj = null;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length) {
                break;
            }
            if (2 == sVarArr[i4].getTrackType()) {
                if (obj == null) {
                    s sVar = sVarArr[i4];
                    m mVar = mVarArr[i4];
                    int[][] iArr2 = iArr[i4];
                    a aVar = this.azY;
                    e eVar = null;
                    if (aVar != null) {
                        int i5 = bVar.aAi ? 24 : 16;
                        Object obj2 = (!bVar.aAh || (sVar.iw() & i5) == 0) ? null : 1;
                        i = 0;
                        while (true) {
                            int i6 = i;
                            if (i6 >= mVar.length) {
                                eVar = null;
                                break;
                            }
                            int[] iArr3;
                            l lVar = mVar.asI[i6];
                            int[] iArr4 = iArr2[i6];
                            int i7 = bVar.aAc;
                            int i8 = bVar.aAd;
                            int i9 = bVar.aAe;
                            i2 = bVar.viewportWidth;
                            int i10 = bVar.viewportHeight;
                            boolean z = bVar.aAg;
                            if (lVar.length < 2) {
                                iArr3 = azX;
                            } else {
                                List a = a(lVar, i2, i10, z);
                                if (a.size() < 2) {
                                    iArr3 = azX;
                                } else {
                                    String str;
                                    String str2 = null;
                                    if (obj2 == null) {
                                        HashSet hashSet = new HashSet();
                                        int i11 = 0;
                                        int i12 = 0;
                                        while (i12 < a.size()) {
                                            int a2;
                                            str = lVar.asb[((Integer) a.get(i12)).intValue()].adW;
                                            if (hashSet.add(str)) {
                                                a2 = a(lVar, iArr4, i5, str, i7, i8, i9, a);
                                                if (a2 > i11) {
                                                    i12++;
                                                    i11 = a2;
                                                    str2 = str;
                                                }
                                            }
                                            a2 = i11;
                                            str = str2;
                                            i12++;
                                            i11 = a2;
                                            str2 = str;
                                        }
                                        str = str2;
                                    } else {
                                        str = null;
                                    }
                                    b(lVar, iArr4, i5, str, i7, i8, i9, a);
                                    iArr3 = a.size() < 2 ? azX : t.q(a);
                                }
                            }
                            if (iArr3.length > 0) {
                                eVar = aVar.lJ();
                                break;
                            }
                            i = i6 + 1;
                        }
                    }
                    if (eVar == null) {
                        eVar = a(mVar, iArr2, bVar);
                    }
                    eVarArr[i4] = eVar;
                    obj = eVarArr[i4] != null ? 1 : null;
                }
                if (mVarArr[i4].length > 0) {
                    i3 = 1;
                } else {
                    i3 = 0;
                }
                i3 |= 0;
            } else {
                i3 = 0;
            }
            i4++;
        }
        Object obj3 = null;
        Object obj4 = null;
        i = 0;
        while (true) {
            i2 = i;
            if (i2 >= length) {
                return eVarArr;
            }
            switch (sVarArr[i2].getTrackType()) {
                case 1:
                    if (obj3 != null) {
                        break;
                    }
                    eVarArr[i2] = a(mVarArr[i2], iArr[i2], bVar, null != null ? null : this.azY);
                    obj3 = eVarArr[i2] != null ? 1 : null;
                    break;
                case 2:
                    break;
                case 3:
                    if (obj4 != null) {
                        break;
                    }
                    eVarArr[i2] = b(mVarArr[i2], iArr[i2], bVar);
                    obj4 = eVarArr[i2] != null ? 1 : null;
                    break;
                default:
                    eVarArr[i2] = c(mVarArr[i2], iArr[i2], bVar);
                    break;
            }
            i = i2 + 1;
        }
    }

    private static int a(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 >= list.size()) {
                return i8;
            }
            i5 = ((Integer) list.get(i7)).intValue();
            if (a(lVar.asb[i5], str, iArr[i5], i, i2, i3, i4)) {
                i5 = i8 + 1;
            } else {
                i5 = i8;
            }
            i6 = i7 + 1;
        }
    }

    private static void b(l lVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!a(lVar.asb[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        if (!r(i, false) || (i & i2) == 0) {
            return false;
        }
        if (str != null && !t.i(format.adW, str)) {
            return false;
        }
        if (format.width != -1 && format.width > i3) {
            return false;
        }
        if (format.height != -1 && format.height > i4) {
            return false;
        }
        if (format.bitrate == -1 || format.bitrate <= i5) {
            return true;
        }
        return false;
    }

    private static e a(m mVar, int[][] iArr, b bVar) {
        l lVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= mVar.length) {
                break;
            }
            l lVar2 = mVar.asI[i6];
            List a = a(lVar2, bVar.viewportWidth, bVar.viewportHeight, bVar.aAg);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < lVar2.length; i7++) {
                if (r(iArr2[i7], bVar.aAj)) {
                    Format format = lVar2.asb[i7];
                    Object obj = (!a.contains(Integer.valueOf(i7)) || ((format.width != -1 && format.width > bVar.aAc) || ((format.height != -1 && format.height > bVar.aAd) || (format.bitrate != -1 && format.bitrate > bVar.aAe)))) ? null : 1;
                    if (obj != null || bVar.aAf) {
                        i5 = obj != null ? 2 : 1;
                        boolean r = r(iArr2[i7], false);
                        if (r) {
                            i5 += 1000;
                        }
                        Object obj2 = i5 > i2 ? 1 : null;
                        if (i5 == i2) {
                            int au;
                            if (format.iP() != i4) {
                                au = au(format.iP(), i4);
                            } else {
                                au = au(format.bitrate, i3);
                            }
                            obj2 = (!r || obj == null) ? au < 0 ? 1 : null : au > 0 ? 1 : null;
                        }
                        if (obj2 != null) {
                            i3 = format.bitrate;
                            i4 = format.iP();
                            i2 = i5;
                            i = i7;
                            lVar = lVar2;
                        }
                    }
                }
            }
            i5 = i6 + 1;
        }
        return lVar == null ? null : new c(lVar, i);
    }

    private static int au(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    private static e a(m mVar, int[][] iArr, b bVar, a aVar) {
        int i;
        l lVar;
        int[] iArr2;
        int i2;
        int i3;
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (i = 0; i < mVar.length; i++) {
            lVar = mVar.asI[i];
            iArr2 = iArr[i];
            for (i2 = 0; i2 < lVar.length; i2++) {
                if (r(iArr2[i2], bVar.aAj)) {
                    Format format = lVar.asb[i2];
                    int i7 = iArr2[i2];
                    String str = bVar.aAa;
                    Object obj = (format.ael & 1) != 0 ? 1 : null;
                    i3 = a(format, str) ? obj != null ? 4 : 3 : obj != null ? 2 : 1;
                    if (r(i7, false)) {
                        i3 += 1000;
                    }
                    if (i3 > i6) {
                        i6 = i3;
                        i5 = i2;
                        i4 = i;
                    }
                }
            }
        }
        if (i4 == -1) {
            return null;
        }
        lVar = mVar.asI[i4];
        if (aVar != null) {
            int[] iArr3;
            iArr2 = iArr[i4];
            boolean z = bVar.aAh;
            i2 = 0;
            a aVar2 = null;
            HashSet hashSet = new HashSet();
            i3 = 0;
            while (i3 < lVar.length) {
                Format format2 = lVar.asb[i3];
                a aVar3 = new a(format2.aeg, format2.sampleRate, z ? null : format2.adW);
                if (hashSet.add(aVar3)) {
                    i4 = a(lVar, iArr2, aVar3);
                    if (i4 > i2) {
                        i3++;
                        aVar2 = aVar3;
                        i2 = i4;
                    }
                }
                aVar3 = aVar2;
                i4 = i2;
                i3++;
                aVar2 = aVar3;
                i2 = i4;
            }
            if (i2 > 1) {
                int[] iArr4 = new int[i2];
                i4 = 0;
                for (i = 0; i < lVar.length; i++) {
                    if (a(lVar.asb[i], iArr2[i], aVar2)) {
                        i2 = i4 + 1;
                        iArr4[i4] = i;
                        i4 = i2;
                    }
                }
                iArr3 = iArr4;
            } else {
                iArr3 = azX;
            }
            if (iArr3.length > 0) {
                return aVar.lJ();
            }
        }
        return new c(lVar, i5);
    }

    private static int a(l lVar, int[] iArr, a aVar) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= lVar.length) {
                return i3;
            }
            if (a(lVar.asb[i2], iArr[i2], aVar)) {
                i = i3 + 1;
            } else {
                i = i3;
            }
            i2++;
        }
    }

    private static boolean a(Format format, int i, a aVar) {
        if (!r(i, false) || format.aeg != aVar.aeg || format.sampleRate != aVar.sampleRate) {
            return false;
        }
        if (aVar.mimeType == null || TextUtils.equals(aVar.mimeType, format.adW)) {
            return true;
        }
        return false;
    }

    private static e b(m mVar, int[][] iArr, b bVar) {
        l lVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= mVar.length) {
                break;
            }
            l lVar2 = mVar.asI[i4];
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < lVar2.length; i5++) {
                if (r(iArr2[i5], bVar.aAj)) {
                    Format format = lVar2.asb[i5];
                    Object obj = (format.ael & 1) != 0 ? 1 : null;
                    Object obj2 = (format.ael & 2) != 0 ? 1 : null;
                    if (a(format, bVar.aAb)) {
                        if (obj != null) {
                            i3 = 6;
                        } else if (obj2 == null) {
                            i3 = 5;
                        } else {
                            i3 = 4;
                        }
                    } else if (obj != null) {
                        i3 = 3;
                    } else if (obj2 != null) {
                        if (a(format, bVar.aAa)) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                    }
                    if (r(iArr2[i5], false)) {
                        i3 += 1000;
                    }
                    if (i3 > i2) {
                        i2 = i3;
                        i = i5;
                        lVar = lVar2;
                    }
                }
            }
            i3 = i4 + 1;
        }
        return lVar == null ? null : new c(lVar, i);
    }

    private static e c(m mVar, int[][] iArr, b bVar) {
        boolean z = false;
        int i = 0;
        l lVar = null;
        for (int i2 = 0; i2 < mVar.length; i2++) {
            l lVar2 = mVar.asI[i2];
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < lVar2.length) {
                boolean z2;
                if (r(iArr2[i3], bVar.aAj)) {
                    if ((lVar2.asb[i3].ael & 1) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (r(iArr2[i3], false)) {
                        z2 += 1000;
                    }
                    if (z2 > z) {
                        i = i3;
                        lVar = lVar2;
                        i3++;
                        z = z2;
                    }
                }
                z2 = z;
                i3++;
                z = z2;
            }
        }
        if (lVar == null) {
            return null;
        }
        return new c(lVar, i);
    }

    private static boolean r(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    private static boolean a(Format format, String str) {
        return str != null && TextUtils.equals(str, t.aB(format.aem));
    }

    private static List<Integer> a(l lVar, int i, int i2, boolean z) {
        int i3;
        ArrayList arrayList = new ArrayList(lVar.length);
        for (i3 = 0; i3 < lVar.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == Integer.MAX_VALUE || i2 == Integer.MAX_VALUE) {
            return arrayList;
        }
        int i4 = Integer.MAX_VALUE;
        for (i3 = 0; i3 < lVar.length; i3++) {
            Format format = lVar.asb[i3];
            if (format.width > 0 && format.height > 0) {
                int i5;
                int i6;
                int i7 = format.width;
                int i8 = format.height;
                if (z) {
                    Object obj;
                    Object obj2;
                    if (i7 > i8) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (i > i2) {
                        obj2 = 1;
                    } else {
                        obj2 = null;
                    }
                    if (obj != obj2) {
                        Point point;
                        i5 = i;
                        i6 = i2;
                        if (i7 * i5 < i8 * i6) {
                            point = new Point(i6, t.aw(i6 * i8, i7));
                        } else {
                            point = new Point(t.aw(i5 * i7, i8), i5);
                        }
                        i5 = format.width * format.height;
                        if (format.width >= ((int) (((float) point.x) * 0.98f)) && format.height >= ((int) (((float) point.y) * 0.98f)) && i5 < i4) {
                            i4 = i5;
                        }
                    }
                }
                i5 = i2;
                i6 = i;
                if (i7 * i5 < i8 * i6) {
                    point = new Point(t.aw(i5 * i7, i8), i5);
                } else {
                    point = new Point(i6, t.aw(i6 * i8, i7));
                }
                i5 = format.width * format.height;
                i4 = i5;
            }
        }
        if (i4 != Integer.MAX_VALUE) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                i3 = lVar.asb[((Integer) arrayList.get(size)).intValue()].iP();
                if (i3 == -1 || i3 > i4) {
                    arrayList.remove(size);
                }
            }
        }
        return arrayList;
    }
}
