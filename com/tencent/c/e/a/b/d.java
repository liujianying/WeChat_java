package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    static b vkw;
    public int errorCode = 0;
    public b vkv = null;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.errorCode, 0);
        if (this.vkv != null) {
            jceOutputStream.write(this.vkv, 1);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.errorCode = jceInputStream.read(this.errorCode, 0, true);
        if (vkw == null) {
            vkw = new b();
        }
        this.vkv = (b) jceInputStream.read(vkw, 1, false);
    }
}
