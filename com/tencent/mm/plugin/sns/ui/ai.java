package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.ak.o;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

public final class ai implements z {
    private String appId = "";
    private String appName = "";
    private MMActivity bGc;
    private String bSw = "";
    private String bZG;
    private Bitmap dHf = null;
    private TextView eBO = null;
    private String egr = "";
    private int fwV = 9;
    private View gYR = null;
    private int h = -1;
    private boolean leb = false;
    private int nMA;
    private CdnImageView nMB = null;
    private TextView nMC = null;
    private int nMD;
    private String nME = "";
    private String nMF = "";
    private b nMG = null;
    private String nMx = "";
    private byte[] nMy = null;
    private String nMz;
    private String title = "";
    private int w = -1;

    public ai(MMActivity mMActivity, int i) {
        this.bGc = mMActivity;
        this.fwV = i;
    }

    public final void G(Bundle bundle) {
        this.nMG = b.p(this.bGc.getIntent());
        this.w = this.bGc.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.bGc.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.egr = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.nMx = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.bSw = this.bGc.getIntent().getStringExtra("KsnsUpload_imgPath");
        this.leb = this.bGc.getIntent().getBooleanExtra("ksnsis_video", false);
        this.bZG = bi.aG(this.bGc.getIntent().getStringExtra("src_username"), "");
        this.nMz = bi.aG(this.bGc.getIntent().getStringExtra("src_displayname"), "");
        this.nMF = bi.aG(this.bGc.getIntent().getStringExtra("KContentObjDesc"), "");
        this.nME = bi.aG(this.bGc.getIntent().getStringExtra("KUploadProduct_UserData"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.appId = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.nMD = this.bGc.getIntent().getIntExtra("KUploadProduct_subType", 0);
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return true;
    }

    public final View bBV() {
        this.gYR = y.gq(this.bGc).inflate(g.upload_media_link, null);
        this.nMB = (CdnImageView) this.gYR.findViewById(f.image_left);
        this.eBO = (TextView) this.gYR.findViewById(f.titletext);
        this.nMC = (TextView) this.gYR.findViewById(f.righttext);
        if (this.leb) {
            this.gYR.findViewById(f.state).setVisibility(0);
        } else {
            this.gYR.findViewById(f.state).setVisibility(8);
        }
        this.eBO.setText(this.title);
        if (this.fwV == 13) {
            this.eBO.setText(this.title + "\n" + this.nMF);
        }
        if (!bi.oW(this.nMx)) {
            this.nMB.setVisibility(0);
            this.nMB.setUrl(this.nMx);
        } else if (bi.bC(this.nMy)) {
            this.nMB.setVisibility(8);
        } else {
            this.nMB.setVisibility(0);
            this.dHf = c.bs(this.nMy);
            this.nMB.setImageBitmap(this.dHf);
        }
        i.b(this.nMB, this.bGc);
        return this.gYR;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        ax axVar = new ax(this.fwV);
        pInt.value = axVar.afv;
        if (i3 > a.nkE) {
            axVar.wC(2);
        }
        axVar.MD(this.title).MB(this.nMF).MC(this.egr).My(str);
        if (!bi.oW(this.bSw)) {
            axVar.a(FileOp.e(this.bSw, 0, -1), this.nMF, this.title, this.nMD, this.nME);
        } else if (!(bi.oW(this.nMx) || o.Pe() == null)) {
            o.Pe();
            Bitmap jz = com.tencent.mm.ak.c.jz(this.nMx);
            if (jz != null) {
                axVar.b(c.Q(jz), "", "");
            }
        }
        if (iVar != null) {
            axVar.eB(iVar.token, iVar.rWk);
        }
        axVar.wG(this.nMA);
        axVar.MG(this.bZG);
        axVar.MH(this.nMz);
        axVar.wE(i);
        axVar.f(null, null, null, i4, i5);
        if (z) {
            axVar.wH(1);
        } else {
            axVar.wH(0);
        }
        axVar.ci(list2);
        if (!bi.oW(this.appId)) {
            axVar.ME(this.appId);
            axVar.MF(this.appName);
        }
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
        axVar.ag(linkedList);
        axVar.a(arj);
        int commit = axVar.commit();
        if (this.nMG != null) {
            this.nMG.iq(commit);
            e.nxO.c(this.nMG);
        }
        af.byk().bwX();
        this.bGc.finish();
        return false;
    }

    public final boolean d(int i, Intent intent) {
        return false;
    }

    public final boolean bBW() {
        if (!(this.dHf == null || this.dHf.isRecycled())) {
            this.dHf.recycle();
        }
        return false;
    }
}
