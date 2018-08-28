package com.tencent.mm.model.d;

import com.tencent.mm.compatible.e.m;
import com.tencent.mm.model.au;
import com.tencent.mm.model.d.a.a;
import com.tencent.mm.sdk.platformtools.ak.b;
import java.util.Iterator;
import java.util.LinkedList;

class a$2 implements b {
    final /* synthetic */ a dFa;

    public a$2(a aVar) {
        this.dFa = aVar;
    }

    public final String JF() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("worker thread id = " + au.Em().lnJ.getLooper().getThread().getId() + "[" + au.Em().cij() + "]\n");
        stringBuilder.append("#cpu freq(KHz)[max=" + m.zk() + ", min=" + m.zl() + ", cur=" + m.zm() + "]\n");
        LinkedList linkedList = new LinkedList(a.d(this.dFa));
        Iterator it = linkedList.iterator();
        stringBuilder.append("#done tasks size = " + linkedList.size() + 10);
        if (it != null) {
            int i = 0;
            while (it.hasNext() && i < a.j(this.dFa)) {
                stringBuilder.append("[index = " + i + " | taskinfo:" + ((a) it.next()).info + "]\n");
                i++;
            }
        }
        stringBuilder.append("\n#waiting" + au.Em().cil().dump(false));
        return stringBuilder.toString();
    }
}
