package com.tencent.tencentmap.mapsdk.a;

import com.qq.jutil.crypto.HexUtil;
import java.nio.ByteBuffer;

public class az {
    int a = 0;
    byte[] b;
    int c;
    ao d;
    jp e;

    public static az a(boolean z, int i, byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 4);
        allocate.putInt(allocate.capacity()).put(bArr).flip();
        return new az(i, allocate.array());
    }

    public static az a(int i, int i2) {
        az azVar = new az(i2, new byte[0]);
        jp jpVar = new jp();
        jpVar.e = i;
        jpVar.c = i2;
        azVar.e = jpVar;
        return azVar;
    }

    private az(int i, byte[] bArr) {
        this.c = i;
        a(bArr);
    }

    public void a(byte[] bArr) {
        this.b = bArr;
        this.a = bArr.length;
    }

    public String toString() {
        return "seq:" + this.c + " " + HexUtil.bytes2HexStr(this.b);
    }

    public void a(ao aoVar) {
        this.d = aoVar;
    }
}
