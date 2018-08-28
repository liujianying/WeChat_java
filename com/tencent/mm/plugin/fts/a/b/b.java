package com.tencent.mm.plugin.fts.a.b;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;

public final class b {
    private HashSet<String> jsP = new HashSet();
    public c jsQ = new c(' ');

    public final void CC(String str) {
        if (this.jsP.add(str)) {
            c cVar = this.jsQ;
            char[] toCharArray = str.toLowerCase().toCharArray();
            for (int i = 0; i < toCharArray.length; i++) {
                int i2 = toCharArray[i] - 97;
                if (cVar.jsR[i2] == null) {
                    cVar.jsR[i2] = new c(toCharArray[i]);
                }
                cVar = cVar.jsR[i2];
            }
            cVar.jsO = true;
        }
    }

    public final List<List<String>> CD(String str) {
        Queue arrayDeque = new ArrayDeque();
        arrayDeque.offer(new a(0, 0, null));
        char[] toCharArray = str.toLowerCase().toCharArray();
        List<List<String>> arrayList = new ArrayList();
        while (!arrayDeque.isEmpty()) {
            a aVar = (a) arrayDeque.poll();
            if (aVar == null) {
                break;
            }
            int i = aVar.end;
            c cVar = this.jsQ;
            while (i < toCharArray.length) {
                int i2 = toCharArray[i] - 97;
                if (cVar.jsR[i2] == null) {
                    break;
                }
                cVar = cVar.jsR[i2];
                if (cVar.jsO || i == toCharArray.length - 1) {
                    if (aVar.ayR == null) {
                        aVar.ayR = new ArrayList();
                    }
                    a aVar2 = new a(aVar.end, i + 1, aVar);
                    aVar.ayR.add(aVar2);
                    if (aVar2.end == toCharArray.length) {
                        aVar2.jsO = true;
                    }
                    arrayDeque.offer(aVar2);
                }
                i++;
            }
            if (aVar.jsO) {
                List arrayList2 = new ArrayList();
                while (aVar != null) {
                    if (aVar.end > aVar.start) {
                        arrayList2.add(str.substring(aVar.start, aVar.end));
                    }
                    aVar = aVar.jsN;
                }
                Collections.reverse(arrayList2);
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }
}
