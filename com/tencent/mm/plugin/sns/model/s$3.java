package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.mt;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class s$3 extends c<mt> {
    final /* synthetic */ s nor;

    s$3(s sVar) {
        this.nor = sVar;
        this.sFo = mt.class.getName().hashCode();
    }

    private boolean a(mt mtVar) {
        if (this.nor.nop.containsKey(mtVar.bXJ.filePath)) {
            int intValue = ((Integer) this.nor.nop.remove(mtVar.bXJ.filePath)).intValue();
            if (this.nor.nom == 12) {
                String str = "2,3,,";
                if (intValue == 0) {
                    try {
                        str = str + "," + URLEncoder.encode(this.nor.noq, "UTF-8");
                    } catch (UnsupportedEncodingException e) {
                        x.e("MicroMsg.NetSceneSnsPost", "", new Object[]{e.getMessage()});
                    }
                }
                x.i("MicroMsg.NetSceneSnsPost", "androidSystemShareFixed(13717) fileToIndex:%d,  %s", new Object[]{Integer.valueOf(intValue), str});
                h.mEJ.k(13717, str);
            }
            s.a(this.nor);
        }
        return false;
    }
}
