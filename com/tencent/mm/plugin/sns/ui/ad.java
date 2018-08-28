package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sight.decode.ui.SightPlayImageView;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.aso;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.QImageView;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ad implements z {
    private String appId;
    private String appName;
    MMActivity bGc;
    private boolean bKE = false;
    String bKg = "";
    String bOX = "";
    String desc = "";
    String dwE;
    ProgressDialog eHw = null;
    private String fmS;
    private View gYR = null;
    String knh;
    private int nMA;
    private b nMG = null;
    private boolean nNY = false;
    private boolean nNZ = false;
    SightPlayImageView nOQ;
    boolean nOR = false;
    private Bitmap nOS = null;
    private aso nOT = new aso();
    private boolean nOU = false;
    private c nOV = new 1(this);
    ax nOW = null;
    private int nOX = 0;
    Runnable nOY = new 4(this);
    Runnable nOZ = new 5(this);
    private WXMediaMessage nOa = null;
    String videoPath = "";

    static /* synthetic */ void a(ad adVar) {
        if (adVar.nOW != null) {
            if (adVar.eHw != null) {
                adVar.eHw.dismiss();
            }
            x.i("MicroMsg.SightWidget", "commitDone");
            pn pnVar = new pn();
            pnVar.cap.type = 0;
            pnVar.cap.car = true;
            a.sFg.m(pnVar);
            adVar.nOR = true;
            int commit = adVar.nOW.commit();
            if (adVar.nMG != null) {
                adVar.nMG.iq(commit);
                e.nxO.c(adVar.nMG);
            }
            af.byv().nQT = 0;
            if (adVar.bGc.getIntent() != null && adVar.bGc.getIntent().getBooleanExtra("K_go_to_SnsTimeLineUI", false)) {
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(adVar.bGc, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                adVar.bGc.startActivity(intent);
            }
            adVar.bGc.setResult(-1);
            adVar.bGc.finish();
            af.byk().bwX();
        }
    }

    public ad(MMActivity mMActivity) {
        this.bGc = mMActivity;
    }

    public final void G(Bundle bundle) {
        this.nMG = b.p(this.bGc.getIntent());
        this.knh = bi.aG(this.bGc.getIntent().getStringExtra("KSightCdnUrl"), "");
        this.dwE = bi.aG(this.bGc.getIntent().getStringExtra("KSightCdnThumbUrl"), "");
        this.appId = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.nNY = this.bGc.getIntent().getBooleanExtra("KThrid_app", false);
        this.nNZ = this.bGc.getIntent().getBooleanExtra("KSnsAction", false);
        this.nOU = this.bGc.getIntent().getBooleanExtra("Kis_take_photo", false);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.fmS = bi.aG(this.bGc.getIntent().getStringExtra("reportSessionId"), "");
        Bundle bundleExtra = this.bGc.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.nOa = new Req(bundleExtra).message;
        }
        this.bOX = this.bGc.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.bGc.getIntent().getStringExtra("KSightPath");
        this.bKg = this.bGc.getIntent().getStringExtra("sight_md5");
        byte[] byteArrayExtra = this.bGc.getIntent().getByteArrayExtra("KMMSightExtInfo");
        if (byteArrayExtra != null) {
            try {
                this.nOT.aG(byteArrayExtra);
            } catch (Exception e) {
                x.i("MicroMsg.SightWidget", "error %s", new Object[]{e.getMessage()});
            }
        }
        if (this.nOT == null) {
            this.nOT = new aso();
            this.nOT.rUP = this.nOU;
        }
        this.nOT.bPS = this.fmS;
        pn pnVar = new pn();
        pnVar.cap.type = 2;
        a.sFg.m(pnVar);
        if (bi.oW(this.videoPath)) {
            this.videoPath = bi.aG(pnVar.caq.cau, "");
            x.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.videoPath});
        }
        this.bKg = bi.oW(this.bKg) ? bi.aG(pnVar.caq.cas, "") : this.bKg;
        x.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.bOX, this.videoPath, this.bKg});
        a.sFg.b(this.nOV);
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return true;
    }

    public final View bBV() {
        this.gYR = View.inflate(this.bGc, g.upload_new_sight_widget, null);
        this.nOQ = (SightPlayImageView) this.gYR.findViewById(f.thumb_iv);
        this.bGc.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.nOQ.dt(com.tencent.mm.bp.a.fromDPToPix(this.bGc, 100), com.tencent.mm.bp.a.fromDPToPix(this.bGc, 100));
        this.nOQ.setScaleType(QImageView.a.uHR);
        this.nOQ.ndG = true;
        this.nOQ.setOnClickListener(new 2(this));
        x.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.bOX + " " + FileOp.mI(this.videoPath) + " " + FileOp.mI(this.bOX));
        if (FileOp.cn(this.videoPath)) {
            x.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.videoPath, this.bKg});
        }
        this.nOQ.hK(false);
        this.nOQ.aO(this.videoPath, false);
        return this.gYR;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.nOW != null) {
            return false;
        }
        if (this.nOR) {
            return true;
        }
        this.nOR = true;
        this.desc = str;
        LinkedList linkedList = new LinkedList();
        if (list != null) {
            LinkedList linkedList2 = new LinkedList();
            List Hv = s.Hv();
            for (String str3 : list) {
                if (!Hv.contains(str3)) {
                    bqg bqg = new bqg();
                    bqg.hbL = str3;
                    linkedList.add(bqg);
                }
            }
        }
        this.nOW = new ax(15);
        pInt.value = this.nOW.afv;
        if (i3 > com.tencent.mm.plugin.sns.c.a.nkE) {
            this.nOW.wC(3);
        }
        ax My = this.nOW.My(str);
        LinkedList linkedList3 = new LinkedList();
        My.a(arj).ag(linkedList).wE(i).wF(i2).ci(list2);
        if (z) {
            this.nOW.wH(1);
        } else {
            this.nOW.wH(0);
        }
        this.nOW.ci(list2);
        this.nOW.wG(this.nMA);
        this.nOW.caX = this.nOT;
        this.nOW.f(null, null, null, i4, i5);
        if (!bi.oW(this.appId)) {
            this.nOW.ME(this.appId);
        }
        if (!bi.oW(this.appName)) {
            this.nOW.MF(bi.aG(this.appName, ""));
        }
        if (this.nNY) {
            this.nOW.wG(5);
        }
        if (this.nNZ && this.nOa != null) {
            this.nOW.Mz(this.nOa.mediaTagName);
            this.nOW.aa(this.appId, this.nOa.messageExt, this.nOa.messageAction);
        }
        ah.i(this.nOZ, 700);
        com.tencent.mm.sdk.f.e.post(new 3(this), "sight_send_ready");
        return true;
    }

    public final boolean d(int i, Intent intent) {
        return false;
    }

    public final boolean bBW() {
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        this.nOQ.aO(this.videoPath, true);
        a.sFg.c(this.nOV);
        if (com.tencent.mm.plugin.sns.data.i.q(this.nOS)) {
            this.nOS.recycle();
        }
        return false;
    }
}
