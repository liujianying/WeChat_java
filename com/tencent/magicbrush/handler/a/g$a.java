package com.tencent.magicbrush.handler.a;

import java.util.LinkedList;
import java.util.Queue;

class g$a {
    Queue<k> bnV = new LinkedList();

    g$a() {
    }

    final k te() {
        k kVar = (k) this.bnV.poll();
        if (kVar == null) {
            return new k();
        }
        return kVar;
    }
}
