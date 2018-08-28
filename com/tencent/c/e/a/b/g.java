package com.tencent.c.e.a.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class g extends JceStruct {
    static Map<Integer, ArrayList<f>> vkF;
    public long vkC = 0;
    public Map<Integer, ArrayList<f>> vkD = null;
    public int vkE = 0;
    public int vki = 0;
    public int vkj = 0;
    public int vkk = 0;
    public int vkl = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.vkC, 0);
        jceOutputStream.write(this.vkD, 1);
        jceOutputStream.write(this.vki, 2);
        jceOutputStream.write(this.vkj, 3);
        jceOutputStream.write(this.vkk, 4);
        jceOutputStream.write(this.vkl, 5);
        if (this.vkE != 0) {
            jceOutputStream.write(this.vkE, 6);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.vkC = jceInputStream.read(this.vkC, 0, true);
        if (vkF == null) {
            vkF = new HashMap();
            Integer valueOf = Integer.valueOf(0);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new f());
            vkF.put(valueOf, arrayList);
        }
        this.vkD = (Map) jceInputStream.read(vkF, 1, true);
        this.vki = jceInputStream.read(this.vki, 2, false);
        this.vkj = jceInputStream.read(this.vkj, 3, false);
        this.vkk = jceInputStream.read(this.vkk, 4, false);
        this.vkl = jceInputStream.read(this.vkl, 5, false);
        this.vkE = jceInputStream.read(this.vkE, 6, false);
    }
}
