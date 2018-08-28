package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.plugin.sns.storage.m;
import com.tencent.mm.plugin.sns.ui.s.a;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.sdk.platformtools.x;

class ArtistBrowseUI$2 implements a {
    final /* synthetic */ ArtistBrowseUI nLc;

    ArtistBrowseUI$2(ArtistBrowseUI artistBrowseUI) {
        this.nLc = artistBrowseUI;
    }

    public final void bBL() {
        ate cntMedia = this.nLc.nTu.getCntMedia();
        if (cntMedia != null) {
            x.d("MicroMsg.ArtistBrowseUI", "set bg the meida id " + cntMedia.ksA);
            b io = b.io(723);
            io.nb(cntMedia.jPK);
            io.RD();
            if (FileOp.cn(an.s(af.getAccSnsPath(), cntMedia.ksA) + i.l(cntMedia))) {
                aw byk = af.byk();
                if (!(byk.bxU() == null || byk.bxU().equals(""))) {
                    String str = an.s(af.getAccSnsPath(), cntMedia.ksA) + i.l(cntMedia);
                    String s = an.s(af.getAccSnsPath(), byk.bxU());
                    if (FileOp.cn(str)) {
                        x.d("MicroMsg.UploadManager", "bg file is exist!'");
                        FileOp.mL(s);
                        FileOp.deleteFile(s + byk.bxU() + "bg_");
                        FileOp.deleteFile(s + byk.bxU() + "tbg_");
                        FileOp.y(str, s + byk.bxU() + "bg_");
                    } else {
                        FileOp.deleteFile(s + byk.bxU() + "bg_");
                        FileOp.deleteFile(s + byk.bxU() + "tbg_");
                        x.e("MicroMsg.UploadManager", "bg file is not exist! wait to down it");
                    }
                    m bys = af.bys();
                    s = byk.bxU();
                    String str2 = cntMedia.ksA;
                    l Np = bys.Np(s);
                    Np.field_bgId = str2;
                    bys.c(Np);
                }
                byk.byW();
                ax axVar = new ax(7);
                cntMedia.rVK = 1;
                axVar.nsx.sqc.ruA.add(cntMedia);
                axVar.wD(2);
                axVar.commit();
                Intent intent = new Intent();
                intent.setClass(this.nLc, SettingSnsBackgroundUI.class);
                intent.setFlags(536870912);
                intent.addFlags(67108864);
                this.nLc.startActivity(intent);
                this.nLc.finish();
            }
        }
    }
}
