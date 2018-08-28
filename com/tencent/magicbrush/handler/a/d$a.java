package com.tencent.magicbrush.handler.a;

import com.tencent.magicbrush.handler.a.d.b;
import java.util.LinkedList;
import java.util.Queue;

public class d$a {
    public Queue<b> bnG = new LinkedList();

    public final b td() {
        b bVar = (b) this.bnG.poll();
        if (bVar == null) {
            return new b();
        }
        return bVar;
    }

    public final void a(b bVar) {
        this.bnG.offer(bVar);
    }
}
