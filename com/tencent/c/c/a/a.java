package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a extends JceStruct {
    public int vhY = 0;
    public int vhZ = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vhY, 0);
        jceOutputStream.write(this.vhZ, 1);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vhY = jceInputStream.read(this.vhY, 0, true);
        this.vhZ = jceInputStream.read(this.vhZ, 1, false);
    }
}
