package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b extends JceStruct {
    public int vib = 0;
    public int vic = 0;
    public int vid = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vib, 1);
        jceOutputStream.write(this.vic, 2);
        jceOutputStream.write(this.vid, 3);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vib = jceInputStream.read(this.vib, 1, true);
        this.vic = jceInputStream.read(this.vic, 2, true);
        this.vid = jceInputStream.read(this.vid, 3, true);
    }
}
