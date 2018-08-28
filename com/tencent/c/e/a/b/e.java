package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class e extends JceStruct {
    static ArrayList<g> vkA;
    public int action = 0;
    public double lat = 0.0d;
    public int vjz = 0;
    public long vkx = 0;
    public ArrayList<g> vky = null;
    public double vkz = 0.0d;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vkx, 0);
        jceOutputStream.write(this.vky, 1);
        if (this.vjz != 0) {
            jceOutputStream.write(this.vjz, 2);
        }
        if (this.action != 0) {
            jceOutputStream.write(this.action, 3);
        }
        if (this.lat != 0.0d) {
            jceOutputStream.write(this.lat, 4);
        }
        if (this.vkz != 0.0d) {
            jceOutputStream.write(this.vkz, 5);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vkx = jceInputStream.read(this.vkx, 0, true);
        if (vkA == null) {
            vkA = new ArrayList();
            vkA.add(new g());
        }
        this.vky = (ArrayList) jceInputStream.read(vkA, 1, true);
        this.vjz = jceInputStream.read(this.vjz, 2, false);
        this.action = jceInputStream.read(this.action, 3, false);
        this.lat = jceInputStream.read(this.lat, 4, false);
        this.vkz = jceInputStream.read(this.vkz, 5, false);
    }
}
