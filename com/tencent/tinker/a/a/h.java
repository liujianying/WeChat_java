package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;
import com.tencent.tinker.a.a.t.a.a;

public final class h extends a<h> {
    public int voM;
    public int[] voN;
    public byte[] voO;

    public final /* synthetic */ int compareTo(Object obj) {
        h hVar = (h) obj;
        int i = this.voM;
        int i2 = hVar.voM;
        if (i != i2) {
            return i - i2;
        }
        int[] iArr = this.voN;
        int[] iArr2 = hVar.voN;
        int length = iArr.length;
        i = iArr2.length;
        if (length < i) {
            i = -1;
        } else if (length > i) {
            i = 1;
        } else {
            for (i2 = 0; i2 < length; i2++) {
                i = c.fI(iArr[i2], iArr2[i2]);
                if (i != 0) {
                    break;
                }
            }
            i = 0;
        }
        return i == 0 ? c.l(this.voO, hVar.voO) : i;
    }

    public h(int i, int i2, int[] iArr, byte[] bArr) {
        super(i);
        this.voM = i2;
        this.voN = iArr;
        this.voO = bArr;
    }
}
