package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class f extends JceStruct {
    public long vkB = 0;
    public float x = 0.0f;
    public float y = 0.0f;
    public float z = 0.0f;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vkB, 0);
        jceOutputStream.write(this.x, 1);
        jceOutputStream.write(this.y, 2);
        jceOutputStream.write(this.z, 3);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vkB = jceInputStream.read(this.vkB, 0, true);
        this.x = jceInputStream.read(this.x, 1, true);
        this.y = jceInputStream.read(this.y, 2, true);
        this.z = jceInputStream.read(this.z, 3, true);
    }
}
