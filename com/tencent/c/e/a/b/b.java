package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b extends JceStruct {
    public String byN = "";
    public String vkn = "";
    public int vkt = 0;
    public float vku = 0.0f;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vkn, 0);
        jceOutputStream.write(this.vkt, 1);
        jceOutputStream.write(this.vku, 2);
        if (this.byN != null) {
            jceOutputStream.write(this.byN, 3);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vkn = jceInputStream.readString(0, true);
        this.vkt = jceInputStream.read(this.vkt, 1, true);
        this.vku = jceInputStream.read(this.vku, 2, true);
        this.byN = jceInputStream.readString(3, false);
    }
}
