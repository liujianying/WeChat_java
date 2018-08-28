package com.tencent.mm.plugin.ext.c;

import android.graphics.Rect;
import android.util.SparseArray;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.x;

public final class d {
    private static SparseArray<byte[]> iKP = new SparseArray(1);

    interface c {
        b ar(String str, boolean z);
    }

    static /* synthetic */ b c(byte[] bArr, boolean z) {
        String str = null;
        if (bArr == null || bArr.length <= 14) {
            x.w("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: invalid yuv handle file!!");
            return null;
        }
        Object obj;
        if (z) {
            str = g.u(bArr);
        }
        Object obj2 = new byte[4];
        System.arraycopy(bArr, 0, obj2, 0, 4);
        Object obj3 = new byte[4];
        System.arraycopy(bArr, 4, obj3, 0, 4);
        Object obj4 = new byte[4];
        System.arraycopy(bArr, 8, obj4, 0, 4);
        Object obj5 = new byte[4];
        System.arraycopy(bArr, 12, obj5, 0, 4);
        Object obj6 = new byte[4];
        System.arraycopy(bArr, 16, obj6, 0, 4);
        Object obj7 = new byte[4];
        System.arraycopy(bArr, 20, obj7, 0, 4);
        Object obj8 = new byte[4];
        System.arraycopy(bArr, 24, obj8, 0, 4);
        int length = bArr.length - 28;
        Object obj9 = (byte[]) iKP.get(length);
        if (obj9 == null) {
            obj = new byte[length];
            iKP.put(length, obj);
        } else {
            obj = obj9;
        }
        System.arraycopy(bArr, 28, obj, 0, length);
        int au = au(obj2);
        int au2 = au(obj3);
        length = au(obj4);
        int au3 = au(obj5);
        x.i("MicroMsg.ExtQbarYuvRetrieverFactory", "hy: retrieved result: %s", new Object[]{new b(obj, au, au2, au(obj8), new Rect(length, au3, au(obj6) + length, au(obj7) + au3), str)});
        return new b(obj, au, au2, au(obj8), new Rect(length, au3, au(obj6) + length, au(obj7) + au3), str);
    }

    static c aJg() {
        return new a();
    }

    private static int au(byte[] bArr) {
        return (((bArr[3] & 255) | ((bArr[2] & 255) << 8)) | ((bArr[1] & 255) << 16)) | ((bArr[0] & 255) << 24);
    }
}
