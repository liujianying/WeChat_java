package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    public String dMB = "";
    public String model = "";
    public String platform = "";
    public int root = 0;
    public String vjk = "";
    public String vjl = "";
    public int vjm = 0;
    public String vjn = "";

    public final JceStruct newInit() {
        return new d();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.vjk != null) {
            jceOutputStream.write(this.vjk, 0);
        }
        if (this.vjl != null) {
            jceOutputStream.write(this.vjl, 1);
        }
        if (this.dMB != null) {
            jceOutputStream.write(this.dMB, 2);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 3);
        }
        if (this.vjm != 0) {
            jceOutputStream.write(this.vjm, 4);
        }
        if (this.vjn != null) {
            jceOutputStream.write(this.vjn, 5);
        }
        if (this.platform != null) {
            jceOutputStream.write(this.platform, 6);
        }
        if (this.root != 0) {
            jceOutputStream.write(this.root, 7);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vjk = jceInputStream.readString(0, false);
        this.vjl = jceInputStream.readString(1, false);
        this.dMB = jceInputStream.readString(2, false);
        this.model = jceInputStream.readString(3, false);
        this.vjm = jceInputStream.read(this.vjm, 4, false);
        this.vjn = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, false);
        this.root = jceInputStream.read(this.root, 7, false);
    }
}
