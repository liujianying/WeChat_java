package com.tencent.mm.plugin.sns.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ProgressBar;
import com.tencent.mm.g.a.pn;
import com.tencent.mm.memory.n;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sight.decode.a.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;
import java.util.List;

public final class al implements z {
    MMActivity bGc;
    private boolean bKE = false;
    String bKg = "";
    String bOX = "";
    private String desc = "";
    ProgressDialog eHw = null;
    ProgressBar eVR;
    private View gYR = null;
    private int nMA;
    private b nMG = null;
    private boolean nOR = false;
    private Bitmap nOS = null;
    private c nOV = new 1(this);
    ax nOW = null;
    a nRH;
    com.tencent.mm.plugin.sight.decode.ui.c nRI = null;
    String videoPath = "";

    public al(MMActivity mMActivity) {
        this.bGc = mMActivity;
    }

    public final void G(Bundle bundle) {
        this.nMG = b.p(this.bGc.getIntent());
        this.bOX = this.bGc.getIntent().getStringExtra("KSightThumbPath");
        this.videoPath = this.bGc.getIntent().getStringExtra("KSightPath");
        this.bKg = this.bGc.getIntent().getStringExtra("sight_md5");
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        pn pnVar = new pn();
        pnVar.cap.type = 2;
        com.tencent.mm.sdk.b.a.sFg.m(pnVar);
        if (bi.oW(this.videoPath)) {
            this.videoPath = bi.aG(pnVar.caq.cau, "");
            x.e("MicroMsg.SightWidget", "videoPath is null %s", new Object[]{this.videoPath});
        }
        this.bKg = bi.oW(this.bKg) ? bi.aG(pnVar.caq.cas, "") : this.bKg;
        x.i("MicroMsg.SightWidget", "oncreate thumb path %s videopath %s md5 %s", new Object[]{this.bOX, this.videoPath, this.bKg});
        com.tencent.mm.sdk.b.a.sFg.b(this.nOV);
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return true;
    }

    public final View bBV() {
        this.gYR = View.inflate(this.bGc, g.upload_sight_widget, null);
        this.nRH = (a) this.gYR.findViewById(f.image);
        this.nRH.setDrawableWidth(com.tencent.mm.bp.a.fromDPToPix(this.bGc, 90));
        this.eVR = (ProgressBar) this.gYR.findViewById(f.load_progress);
        this.bGc.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        this.gYR.findViewById(f.chatting_click_area).setOnClickListener(new 2(this));
        x.i("MicroMsg.SightWidget", "videoPath " + this.videoPath + " thumbPath " + this.bOX + " " + FileOp.mI(this.videoPath) + " " + FileOp.mI(this.bOX));
        if (FileOp.cn(this.videoPath)) {
            this.nRH.aO(this.videoPath, false);
            this.eVR.setVisibility(8);
            x.i("MicroMsg.SightWidget", "videopath exist videopath %s md5 %s", new Object[]{this.videoPath, this.bKg});
        } else {
            n LJ = i.LJ(this.bOX);
            if (LJ != null) {
                this.nOS = LJ.Fw();
                if (i.q(this.nOS)) {
                    this.nRH.setThumbBmp(this.nOS);
                }
            }
            this.eVR.setVisibility(0);
        }
        return this.gYR;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.nOW != null) {
            return false;
        }
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
        this.nOW.ci(list2).wE(i);
        this.nOW.wG(this.nMA);
        this.nOW.f(null, null, null, i4, i5);
        if (FileOp.cn(this.videoPath)) {
            bCC();
            return true;
        }
        x.i("MicroMsg.SightWidget", "commit file is not exist " + this.videoPath);
        MMActivity mMActivity = this.bGc;
        this.bGc.getString(j.app_tip);
        this.eHw = h.a(mMActivity, this.bGc.getString(j.sns_sight_send_wait), true, new 3(this));
        return true;
    }

    final void bCC() {
        if (!this.nOR) {
            if (this.nOW.o(this.videoPath, this.bOX, this.desc, this.bKg)) {
                pn pnVar = new pn();
                pnVar.cap.type = 0;
                pnVar.cap.car = true;
                com.tencent.mm.sdk.b.a.sFg.m(pnVar);
                this.nOR = true;
                int commit = this.nOW.commit();
                if (this.nMG != null) {
                    this.nMG.iq(commit);
                    e.nxO.c(this.nMG);
                }
                af.byv().nQT = 0;
                Intent intent = new Intent();
                intent.putExtra("sns_resume_state", false);
                intent.putExtra("sns_timeline_NeedFirstLoadint", true);
                intent.setClass(this.bGc, SnsTimeLineUI.class);
                intent.addFlags(67108864);
                this.bGc.startActivity(intent);
                this.bGc.setResult(-1);
                this.bGc.finish();
                return;
            }
            x.i("MicroMsg.SightWidget", "videopath " + FileOp.mI(this.videoPath) + " thumb: " + FileOp.mI(this.bOX));
            com.tencent.mm.ui.base.s.makeText(this.bGc, j.sendrequest_send_fail, 0).show();
        }
    }

    public final boolean d(int i, Intent intent) {
        return false;
    }

    public final boolean bBW() {
        if (this.eHw != null) {
            this.eHw.dismiss();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.nOV);
        if (i.q(this.nOS)) {
            this.nOS.recycle();
        }
        return false;
    }
}
