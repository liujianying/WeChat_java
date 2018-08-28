package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class ah$b {
    final /* synthetic */ ah nQf;
    ArrayList<String> nQj = new ArrayList();
    Map<String, Boolean> nQk = new HashMap();
    Map<String, Integer> nQl = new HashMap();

    ah$b(ah ahVar) {
        this.nQf = ahVar;
    }

    public final ah$b l(String str, int i, boolean z) {
        this.nQj.add(str);
        this.nQl.put(str, Integer.valueOf(i));
        this.nQk.put(str, Boolean.valueOf(z));
        return this;
    }

    public final void N(ArrayList<String> arrayList) {
        this.nQk.clear();
        if (arrayList == null) {
            this.nQj = new ArrayList();
            return;
        }
        this.nQj = arrayList;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            this.nQk.put((String) it.next(), Boolean.valueOf(false));
        }
    }

    public final String toString() {
        String str = "";
        Iterator it = this.nQj.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = (String) it.next();
            int i = 0;
            if (this.nQl != null) {
                i = ((Integer) this.nQl.get(str)).intValue();
            }
            str = str2 + str + "," + i + ";";
        }
    }

    public final ah$b NU(String str) {
        try {
            for (String split : str.split(";")) {
                String[] split2 = split.split(",");
                this.nQj.add(split2[0]);
                this.nQl.put(split2[0], Integer.valueOf(bi.getInt(split2[1], 0)));
            }
        } catch (Exception e) {
        }
        return this;
    }
}
