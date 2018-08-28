package com.tencent.liteav.network;

import java.util.ArrayList;
import org.json.JSONObject;

class c$1 extends Thread {
    final /* synthetic */ String a;
    final /* synthetic */ int b;
    final /* synthetic */ c c;

    c$1(c cVar, String str, String str2, int i) {
        this.c = cVar;
        this.a = str2;
        this.b = i;
        super(str);
    }

    public void run() {
        if (this.c.a != null) {
            ArrayList arrayList = new ArrayList();
            int i = 0;
            while (i < 5) {
                try {
                    String a = c.a(this.c, this.a, this.b);
                    try {
                        JSONObject jSONObject = new JSONObject(a);
                        if (jSONObject.has("use") && jSONObject.getInt("use") == 0) {
                            break;
                        }
                    } catch (Exception e) {
                    }
                    arrayList = c.a(this.c, a);
                    if (arrayList != null && arrayList.size() > 0) {
                        break;
                    }
                    sleep(1000, 0);
                    i++;
                } catch (Exception e2) {
                }
            }
            this.c.a.onFetchDone(0, arrayList);
        }
    }
}
