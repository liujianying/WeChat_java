package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bk.a;
import com.tencent.mm.plugin.game.d.bn;
import com.tencent.mm.plugin.game.d.e;
import com.tencent.mm.plugin.game.e.d;
import java.util.Iterator;
import java.util.LinkedList;

public final class ad extends ac {
    public LinkedList<d> jNA;
    private int jNB = 0;
    public bn jNz;
    private int mType = 0;

    public ad(a aVar, int i, int i2) {
        if (aVar == null) {
            this.jNz = new bn();
            return;
        }
        this.jNz = (bn) aVar;
        this.mType = i;
        this.jNB = i2;
        LinkedList linkedList = new LinkedList();
        if (this.jNz.jSk != null) {
            int i3 = this.jNB + 1;
            Iterator it = this.jNz.jSk.iterator();
            int i4 = i3;
            while (it.hasNext()) {
                d a = a((e) it.next());
                if (a != null) {
                    switch (this.mType) {
                        case 1:
                            a.scene = 16;
                            a.bYq = 1601;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        case 2:
                            a.scene = 15;
                            a.bYq = 1501;
                            i3 = i4 + 1;
                            a.position = i4;
                            break;
                        default:
                            i3 = i4;
                            break;
                    }
                    linkedList.add(a);
                    i4 = i3;
                }
            }
        }
        this.jNA = linkedList;
        d.S(this.jNA);
    }
}
