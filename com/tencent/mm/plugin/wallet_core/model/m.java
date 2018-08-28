package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.plugin.wallet_core.ui.a;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;

public abstract class m<K> {
    Map<String, Integer> poo = new HashMap();
    List<K> pop = new LinkedList();
    public Vector<b> poq = new Vector();
    List<String> por = new LinkedList();

    public abstract String a(Vector<b> vector, int i);

    public final void c(List<K> list, List<K> list2, List<String> list3) {
        int i;
        this.por = list3;
        this.pop = list2;
        this.poq.clear();
        this.poq = new Vector(list.size());
        for (i = 0; i < list.size(); i++) {
            b bVar = new b(this);
            Object obj = list.get(i);
            bVar.poy = obj;
            if (this.pop.contains(obj)) {
                bVar.poz = a.pov;
            } else {
                bVar.poz = a.pou;
            }
            this.poq.add(bVar);
        }
        this.poo.clear();
        for (i = 0; i < list3.size(); i++) {
            this.poo.put(list3.get(i), Integer.valueOf(0));
        }
        bOP();
    }

    public final void dZ(int i, int i2) {
        ((b) this.poq.get(i)).poz = i2;
    }

    public final void bOP() {
        for (int i = 0; i < this.poq.size(); i++) {
            if (((b) this.poq.get(i)).poz != a.pov) {
                String a = a(this.poq, i);
                if (!this.poo.containsKey(a)) {
                    Object obj;
                    String[] Po = a.Po(a);
                    for (int i2 = 0; i2 < this.por.size(); i2++) {
                        for (CharSequence contains : Po) {
                            if (!((String) this.por.get(i2)).contains(contains)) {
                                obj = null;
                                break;
                            }
                        }
                        int obj2 = 1;
                        if (obj2 != null) {
                            obj2 = 1;
                            break;
                        }
                    }
                    obj2 = null;
                    if (obj2 == null) {
                        dZ(i, a.pou);
                    }
                }
                dZ(i, a.pow);
            }
        }
    }
}
