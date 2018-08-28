package com.tencent.mm.plugin.game.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.v;
import com.tencent.mm.plugin.game.wepkg.ipc.WepkgMainProcessService;
import com.tencent.mm.plugin.game.wepkg.utils.WepkgRunCgi.1;
import com.tencent.mm.plugin.game.wepkg.utils.WepkgRunCgi.RemoteCgiTask;
import com.tencent.mm.plugin.game.wepkg.utils.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.oy;
import com.tencent.mm.protocal.c.oz;
import com.tencent.mm.protocal.c.pg;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.List;

public final class WepkgVersionManager$WepkgNetSceneProcessTask extends BaseWepkgProcessTask {
    public static final Creator<WepkgVersionManager$WepkgNetSceneProcessTask> CREATOR = new 2();
    private int cga;
    private List<WepkgCheckReq> kgd;
    private int kge;

    /* synthetic */ WepkgVersionManager$WepkgNetSceneProcessTask(Parcel parcel, byte b) {
        this(parcel);
    }

    public WepkgVersionManager$WepkgNetSceneProcessTask() {
        this.kgd = new ArrayList();
    }

    private WepkgVersionManager$WepkgNetSceneProcessTask(Parcel parcel) {
        g(parcel);
    }

    public final void aai() {
        if (!bi.cX(this.kgd)) {
            a aVar = new a();
            aVar.dIF = 1313;
            aVar.dII = 0;
            aVar.dIJ = 0;
            aVar.uri = "/cgi-bin/mmgame-bin/checkwepkgversion";
            oy oyVar = new oy();
            for (WepkgCheckReq wepkgCheckReq : this.kgd) {
                pg pgVar = new pg();
                pgVar.rtC = WepkgCheckReq.a(wepkgCheckReq);
                pgVar.hcr = WepkgCheckReq.b(wepkgCheckReq);
                pgVar.otY = WepkgCheckReq.c(wepkgCheckReq);
                oyVar.rtf.add(pgVar);
            }
            aVar.dIG = oyVar;
            aVar.dIH = new oz();
            h.mEJ.a(859, 15, 1, false);
            b KT = aVar.KT();
            1 1 = new 1(this);
            if (ad.cic()) {
                v.a(KT, new 1(1));
                return;
            }
            RemoteCgiTask remoteCgiTask = new RemoteCgiTask();
            d.br(remoteCgiTask);
            remoteCgiTask.kgw = KT;
            remoteCgiTask.kgx = 1;
            remoteCgiTask.kgu = 1;
            WepkgMainProcessService.a(remoteCgiTask);
        }
    }

    public final void aaj() {
    }

    public final void k(Parcel parcel) {
        if (this.kgd == null) {
            this.kgd = new ArrayList();
        }
        parcel.readList(this.kgd, WepkgCheckReq.class.getClassLoader());
        this.cga = parcel.readInt();
        this.kge = parcel.readInt();
    }

    public final void v(Parcel parcel, int i) {
        parcel.writeList(this.kgd);
        parcel.writeInt(this.cga);
        parcel.writeInt(this.kge);
    }
}
