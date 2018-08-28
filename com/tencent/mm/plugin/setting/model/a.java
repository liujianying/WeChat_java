package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public final class a {
    public static a mOG;
    private static a mOH;
    public boolean egv = false;

    /* renamed from: com.tencent.mm.plugin.setting.model.a$1 */
    class AnonymousClass1 implements com.tencent.mm.model.bg.a {
        final /* synthetic */ String dgX;
        final /* synthetic */ int esz;

        public AnonymousClass1(String str, int i) {
            this.dgX = str;
            this.esz = i;
        }

        public final void a(e eVar) {
            g.DF().a(1, "", 0, false);
            x.chR();
            g.DF().a(2, this.dgX, this.esz, g.Eg().Dx());
        }
    }

    public static a btq() {
        if (mOH == null) {
            mOH = new a();
        }
        return mOH;
    }

    public static long wy(String str) {
        long j = 0;
        try {
            return new SimpleDateFormat("yyyyMMddHHmmss").parse(str).getTime();
        } catch (ParseException e) {
            x.e("MicroMsg.FixToolsUplogModel", "dateToTimeStamp failed. date:%s, stack:%s", new Object[]{str, bi.cjd()});
            return j;
        }
    }
}
