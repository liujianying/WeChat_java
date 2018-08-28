package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.smtt.sdk.WebView;

public class b$c {
    public int hhF = 0;
    public int hhG = 0;
    public int hhH = 0;
    public int hhI = 0;
    public int hhJ = 0;
    public int hhK = 0;

    public final boolean L(byte[] bArr, int i) {
        String bO = b.bO();
        String str = "data size = %d, offset = %d, lenght = %d";
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(bArr == null ? 0 : bArr.length);
        objArr[1] = Integer.valueOf(i);
        objArr[2] = Integer.valueOf(7);
        x.d(bO, str, objArr);
        if (bArr == null || i < 0 || bArr.length < i + 7) {
            x.e(b.bO(), "data input error");
            return false;
        }
        this.hhF = (bArr[i] & WebView.NORMAL_MODE_ALPHA) + ((bArr[i + 1] & WebView.NORMAL_MODE_ALPHA) << 8);
        this.hhG = bArr[i + 2] & WebView.NORMAL_MODE_ALPHA;
        this.hhH = bArr[i + 3] & WebView.NORMAL_MODE_ALPHA;
        this.hhI = bArr[i + 4] & WebView.NORMAL_MODE_ALPHA;
        this.hhJ = bArr[i + 5] & WebView.NORMAL_MODE_ALPHA;
        this.hhK = bArr[i + 6] & WebView.NORMAL_MODE_ALPHA;
        x.d(b.bO(), "year = %d, month = %d, day = %d, hours = %d, minutes = %d, seconds = %d", new Object[]{Integer.valueOf(this.hhF), Integer.valueOf(this.hhG), Integer.valueOf(this.hhH), Integer.valueOf(this.hhI), Integer.valueOf(this.hhJ), Integer.valueOf(this.hhK)});
        return true;
    }
}
