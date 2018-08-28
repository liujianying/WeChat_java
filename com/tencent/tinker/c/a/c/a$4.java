package com.tencent.tinker.c.a.c;

import com.tencent.tinker.a.a.b.b;
import java.io.ByteArrayOutputStream;

class a$4 implements b {
    final /* synthetic */ a vrA;
    final /* synthetic */ ByteArrayOutputStream vrB;

    public a$4(a aVar, ByteArrayOutputStream byteArrayOutputStream) {
        this.vrA = aVar;
        this.vrB = byteArrayOutputStream;
    }

    public final void writeByte(int i) {
        this.vrB.write(i);
    }
}
