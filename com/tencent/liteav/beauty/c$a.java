package com.tencent.liteav.beauty;

import java.util.HashMap;
import java.util.Iterator;

protected class c$a {
    final /* synthetic */ c a;
    private HashMap<String, String> b = new HashMap();

    protected c$a(c cVar) {
        this.a = cVar;
    }

    public void a(String str, int i) {
        this.b.put(str, String.valueOf(i));
        String id = this.a.getID();
        if (id != null && id.length() > 0) {
            this.a.setStatusValue(3001, a());
        }
    }

    public String a() {
        String str = "";
        Iterator it = this.b.keySet().iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return "{" + str2 + "}";
            }
            str = (String) it.next();
            str = str2 + str + ":" + ((String) this.b.get(str)) + " ";
        }
    }
}
