package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.a.e;
import com.tencent.mm.sdk.d.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import org.json.JSONObject;

class j$1 extends c {
    final /* synthetic */ j ffE;

    j$1(j jVar) {
        this.ffE = jVar;
    }

    public final void enter() {
        super.enter();
        x.i("MicroMsg.LibIncrementalTestCase[incremental]", "WriteMockLibInfo enter");
        String abT = af.abT();
        if (bi.oW(abT)) {
            j.a(this.ffE, "!!MockLibInfo Path Error!!");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("version", j.a(this.ffE));
            File file = new File(abT);
            file.delete();
            file.createNewFile();
            byte[] bytes = jSONObject.toString().getBytes("UTF-8");
            int b = e.b(file.getAbsolutePath(), bytes, bytes.length);
            if (b != 0) {
                j.a(this.ffE, "MockLibInfo Write Error " + b);
            } else {
                j.a(this.ffE, j.b(this.ffE));
            }
        } catch (Exception e) {
            j.a(this.ffE, "MockLibInfo Write Exception " + e.getMessage());
        }
    }
}
