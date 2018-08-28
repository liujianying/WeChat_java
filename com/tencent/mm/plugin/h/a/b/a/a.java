package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.plugin.exdevice.j.b;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;

public abstract class a implements Serializable {
    private static final String TAG = a.class.getName();
    public long hgC;
    public String hhi;
    public int hhj;

    public abstract byte[] atV();

    public static a ad(byte[] bArr) {
        if (bArr == null || bArr.length <= 0) {
            x.e(TAG, "data input error");
            return null;
        }
        Object at = b.at(bArr);
        if (at != null && (at instanceof a)) {
            return (a) at;
        }
        x.e(TAG, "bytes2object is not instanceof BaseProfileParser");
        return null;
    }
}
