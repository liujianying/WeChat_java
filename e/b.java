package e;

import com.tencent.tencentmap.mapsdk.a.md;
import com.tencent.tencentmap.mapsdk.a.me;
import com.tencent.tencentmap.mapsdk.a.mf;

public final class b extends mf {
    static byte[] a;
    public byte[] atn = null;

    public final void writeTo(me meVar) {
        meVar.a(this.atn, 0);
    }

    static {
        byte[] bArr = new byte[1];
        a = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(md mdVar) {
        this.atn = mdVar.a(a, 0, true);
    }
}
