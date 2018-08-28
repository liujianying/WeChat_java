package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.mu;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

class s$2 extends c<mu> {
    final /* synthetic */ s nor;

    s$2(s sVar) {
        this.nor = sVar;
        this.sFo = mu.class.getName().hashCode();
    }

    private boolean a(mu muVar) {
        if (this.nor.nop.containsKey(muVar.bXK.filePath)) {
            String encode;
            int intValue = ((Integer) this.nor.nop.remove(muVar.bXK.filePath)).intValue();
            String str = "";
            try {
                encode = URLEncoder.encode(muVar.bXK.result, "UTF-8");
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.NetSceneSnsPost", e, "", new Object[0]);
                encode = str;
            }
            if (this.nor.dlT != 0) {
                ate ate = (ate) this.nor.noo.get(muVar.bXK.filePath);
                this.nor.non += String.format("position=%d&qrUrl=%s&md5=%s&imgUrl=%s&codeType=%d|", new Object[]{Integer.valueOf(intValue), encode, ate.rVS, ate.jPK, Integer.valueOf(muVar.bXK.bJr)});
            }
            if (this.nor.nom == 12) {
                str = "2,3,," + encode;
                if (intValue == 0) {
                    try {
                        str = str + "," + URLEncoder.encode(this.nor.noq, "UTF-8");
                    } catch (UnsupportedEncodingException e2) {
                        x.e("MicroMsg.NetSceneSnsPost", "", new Object[]{e2.getMessage()});
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
