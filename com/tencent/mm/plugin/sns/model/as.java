package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.plugin.sns.data.g;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.pluginsdk.model.k;
import com.tencent.mm.sdk.platformtools.ag;
import java.io.OutputStream;

public final class as extends k<g, String, Boolean> {
    private OutputStream dHY = null;
    private String dHZ;
    private String fileName;
    private String mediaId;
    private String nnX;
    private String nob = "";

    public final /* synthetic */ Object bxI() {
        return Boolean.valueOf(true);
    }

    public final /* synthetic */ void onPostExecute(Object obj) {
        Boolean bool = (Boolean) obj;
        super.onPostExecute(bool);
        bool.booleanValue();
        af.byj().LV(this.nob);
    }

    public final /* synthetic */ void p(Object[] objArr) {
        g[] gVarArr = (g[]) objArr;
        super.p(gVarArr);
        g gVar = gVarArr[0];
        if (gVar != null) {
            this.mediaId = gVar.mediaId;
            this.nnX = an.s(af.getAccSnsPath(), this.mediaId);
            this.nob = i.aF(gVar.requestType, this.mediaId);
            this.dHZ = "sns_tmpt_" + this.mediaId;
            this.fileName = "snst_" + this.mediaId;
        }
    }

    public final ag bxH() {
        return af.bya();
    }
}
