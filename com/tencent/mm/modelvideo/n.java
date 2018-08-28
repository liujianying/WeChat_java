package com.tencent.mm.modelvideo;

import com.tencent.mm.bt.h.d;
import com.tencent.mm.g.a.jk;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.p;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sns.i$l;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;

public class n implements ar {
    public HashMap<String, a> ena = new HashMap();
    private c<jk> enb = new 3(this);

    static /* synthetic */ void bq(int i, int i2) {
        int i3;
        int i4;
        switch (i2) {
            case 1:
                i3 = i$l.AppCompatTheme_buttonStyleSmall;
                i4 = i$l.AppCompatTheme_ratingBarStyleIndicator;
                break;
            case 2:
                i3 = i$l.AppCompatTheme_switchStyle;
                i4 = 117;
                break;
            case 4:
                i3 = 131;
                i4 = 137;
                break;
            case 5:
                i3 = 121;
                i4 = 127;
                break;
            default:
                return;
        }
        h.mEJ.a(422, (long) bi.f((Integer) h.a(i / 1000, new int[]{350, 544, 800, 1200, 1600, 2000}, i3, i4)), 1, false);
        x.i("MicroMsg.SubCoreMediaRpt", "rptIdkey [%d] bitrate [%d] sendScene [%d]", new Object[]{Integer.valueOf(i4), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public n() {
        a.sFg.b(this.enb);
    }

    public static n SY() {
        return (n) p.v(n.class);
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i, int i2) {
        a aVar = (a) this.ena.get(str2);
        if (aVar == null) {
            aVar = new a(this);
        }
        aVar.eno = str;
        aVar.enp = str2;
        aVar.toUser = str3;
        aVar.cqb = str4;
        aVar.enq = str5;
        aVar.ens = i;
        aVar.enr = i2;
        aVar.startTime = bi.VF();
        this.ena.put(str2, aVar);
        x.i("MicroMsg.SubCoreMediaRpt", "note video upload path[%s, %s] toUser %s msgSource %s snsInfoId %s sendScene %d cpStatus %d", new Object[]{str, str2, str3, str4, str5, Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public final void a(keep_SceneResult keep_sceneresult, String str) {
        if (keep_sceneresult != null && !bi.oW(str)) {
            g.Em().H(new 1(this, str, keep_sceneresult));
        }
    }

    public final HashMap<Integer, d> Ci() {
        return null;
    }

    public final void gi(int i) {
    }

    public final void bn(boolean z) {
    }

    public final void bo(boolean z) {
    }

    public final void onAccountRelease() {
    }
}
