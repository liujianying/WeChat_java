package com.tencent.mm.plugin.appbrand.r;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class k {
    private static final Comparator<e> gBQ = new 1();

    public static b a(a aVar, boolean z) {
        int anr = aVar.anr();
        int ans = aVar.ans();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new d(anr, ans));
        int abs = (anr + ans) + Math.abs(anr - ans);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a = a(aVar, dVar.gCb, dVar.gCc, dVar.gCd, dVar.gCe, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.x += dVar.gCb;
                a.y += dVar.gCd;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.gCb = dVar.gCb;
                dVar2.gCd = dVar.gCd;
                if (a.gCf) {
                    dVar2.gCc = a.x;
                    dVar2.gCe = a.y;
                } else if (a.gCa) {
                    dVar2.gCc = a.x - 1;
                    dVar2.gCe = a.y;
                } else {
                    dVar2.gCc = a.x;
                    dVar2.gCe = a.y - 1;
                }
                arrayList2.add(dVar2);
                if (!a.gCf) {
                    dVar.gCb = a.x + a.size;
                    dVar.gCd = a.y + a.size;
                } else if (a.gCa) {
                    dVar.gCb = (a.x + a.size) + 1;
                    dVar.gCd = a.y + a.size;
                } else {
                    dVar.gCb = a.x + a.size;
                    dVar.gCd = (a.y + a.size) + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, gBQ);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    private static e a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i <= 0 || i4 - i3 <= 0) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11;
            boolean z;
            int i12;
            int i13;
            e eVar;
            int i14 = -i10;
            while (i14 <= i10) {
                if (i14 == (-i10) || (i14 != i10 && iArr[(i5 + i14) - 1] < iArr[(i5 + i14) + 1])) {
                    i11 = iArr[(i5 + i14) + 1];
                    z = false;
                } else {
                    i11 = iArr[(i5 + i14) - 1] + 1;
                    z = true;
                }
                i12 = i11 - i14;
                i13 = i11;
                while (i13 < i6 && i12 < i7 && aVar.bV(i + i13, i3 + i12)) {
                    i13++;
                    i12++;
                }
                iArr[i5 + i14] = i13;
                if (obj == null || i14 < (i8 - i10) + 1 || i14 > (i8 + i10) - 1 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i14 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i14];
                    eVar.y = eVar.x - i14;
                    eVar.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    eVar.gCa = z;
                    eVar.gCf = false;
                    return eVar;
                }
            }
            i14 = -i10;
            while (i14 <= i10) {
                int i15 = i14 + i8;
                if (i15 == i10 + i8 || (i15 != (-i10) + i8 && iArr2[(i5 + i15) - 1] < iArr2[(i5 + i15) + 1])) {
                    i11 = iArr2[(i5 + i15) - 1];
                    z = false;
                } else {
                    i11 = iArr2[(i5 + i15) + 1] - 1;
                    z = true;
                }
                i12 = i11 - i15;
                i13 = i11;
                while (i13 > 0 && i12 > 0 && aVar.bV((i + i13) - 1, (i3 + i12) - 1)) {
                    i13--;
                    i12--;
                }
                iArr2[i5 + i15] = i13;
                if (obj != null || i14 + i8 < (-i10) || i14 + i8 > i10 || iArr[i5 + i15] < iArr2[i5 + i15]) {
                    i14 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i15];
                    eVar.y = eVar.x - i15;
                    eVar.size = iArr[i5 + i15] - iArr2[i5 + i15];
                    eVar.gCa = z;
                    eVar.gCf = true;
                    return eVar;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
