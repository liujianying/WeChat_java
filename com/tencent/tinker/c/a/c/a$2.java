package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import java.io.ByteArrayOutputStream;

class a$2 implements b {
    final /* synthetic */ ByteArrayOutputStream vpQ;
    final /* synthetic */ a vrA;

    public a$2(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.vrA = aVar;
        this.vpQ = byteArrayOutputStream;
    }

    public final void writeByte(int i) {
        this.vpQ.write(i);
    }
}
