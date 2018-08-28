package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static ArrayList<b> viA = new ArrayList();
    static d viB = new d();
    static c viz = new c();
    public c viw = null;
    public ArrayList<b> vix = null;
    public d viy = null;

    public final JceStruct newInit() {
        return new a();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.viw != null) {
            jceOutputStream.write(this.viw, 0);
        }
        if (this.vix != null) {
            jceOutputStream.write(this.vix, 1);
        }
        if (this.viy != null) {
            jceOutputStream.write(this.viy, 2);
        }
    }

    static {
        viA.add(new b());
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.viw = (c) jceInputStream.read(viz, 0, false);
        this.vix = (ArrayList) jceInputStream.read(viA, 1, false);
        this.viy = (d) jceInputStream.read(viB, 2, false);
    }
}
