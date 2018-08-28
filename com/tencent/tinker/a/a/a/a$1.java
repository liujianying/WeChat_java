package com.tencent.tinker.a.a.a;

import com.tencent.tinker.a.a.b.b;
import java.io.ByteArrayOutputStream;

class a$1 implements b {
    final /* synthetic */ ByteArrayOutputStream vpQ;
    final /* synthetic */ a vpR;

    a$1(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.vpR = aVar;
        this.vpQ = byteArrayOutputStream;
    }

    public final void writeByte(int i) {
        this.vpQ.write(i);
    }
}
