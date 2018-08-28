package com.tencent.mm.ui.chatting.a;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelvideo.o;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.modelvideo.s;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.pluginsdk.model.app.ao;
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.y.g.a;

public class a$c {
    public bd bXQ;
    public String imagePath;
    boolean leb;
    public a tNJ = new a(this);
    public long timeStamp;
    public int type = 0;

    public final boolean equals(Object obj) {
        if (this.bXQ == null || !(obj instanceof bd) || obj == null) {
            return super.equals(obj);
        }
        return this.bXQ.field_msgId == ((bd) obj).field_msgId;
    }

    public a$c(bd bdVar) {
        String nL;
        this.bXQ = bdVar;
        if (bdVar.cmj() || bdVar.cmk()) {
            this.leb = true;
            o.Ta();
            nL = s.nL(bdVar.field_imgPath);
            r nW = t.nW(bdVar.field_imgPath);
            if (nW != null) {
                this.tNJ.tNK = bi.iR(nW.enM);
            }
            this.tNJ.bXA = a.J(bdVar.field_content, bdVar.field_reserved);
        } else {
            nL = com.tencent.mm.ak.o.Pf().d(bdVar.field_imgPath, false, false);
            if (!(bi.oW(nL) || nL.endsWith("hd") || !FileOp.cn(nL + "hd"))) {
                nL = nL + "hd";
            }
        }
        if (bdVar.cmo()) {
            a gp = a.gp(bdVar.field_content);
            String str = null;
            if (!(gp == null || gp.bGP == null || gp.bGP.length() <= 0)) {
                b SR = ao.asF().SR(gp.bGP);
                if (SR != null) {
                    str = SR.field_fileFullPath;
                }
            }
            if (str != null) {
                nL = str;
            }
        }
        this.imagePath = nL;
        this.timeStamp = bdVar.field_createTime;
    }

    public a$c(long j) {
        this.timeStamp = j;
        this.type = Integer.MAX_VALUE;
    }
}
