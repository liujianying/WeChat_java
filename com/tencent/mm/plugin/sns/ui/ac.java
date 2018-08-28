package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;
import java.util.LinkedList;
import java.util.List;

public final class ac implements z {
    private String appName = "";
    MMActivity bGc;
    String bPS = "";
    private TextView eBO = null;
    private c fIu = new 1(this);
    private View gYR;
    boolean hTT = false;
    String mediaId;
    private int nMA;
    private CdnImageView nMB = null;
    private TextView nMC = null;
    private b nMG = null;
    private boolean nNY = false;
    private boolean nNZ = false;
    ImageView nON;
    private Bitmap nOO;
    WXMediaMessage nOa = null;

    public ac(MMActivity mMActivity) {
        this.bGc = mMActivity;
        a.sFg.b(this.fIu);
    }

    public final void G(Bundle bundle) {
        this.nOa = new Req(this.bGc.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
        this.mediaId = this.bGc.getIntent().getStringExtra("Ksnsupload_musicid");
        this.nMG = b.p(this.bGc.getIntent());
        this.bPS = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.nNY = this.bGc.getIntent().getBooleanExtra("KThrid_app", false);
        this.nNZ = this.bGc.getIntent().getBooleanExtra("KSnsAction", false);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return true;
    }

    final void bCk() {
        new ag(this.bGc.getMainLooper()).post(new 2(this));
    }

    public final View bBV() {
        this.gYR = y.gq(this.bGc).inflate(g.upload_media_music, null);
        this.nMB = (CdnImageView) this.gYR.findViewById(f.image_left);
        this.eBO = (TextView) this.gYR.findViewById(f.titletext);
        this.nMC = (TextView) this.gYR.findViewById(f.righttext);
        this.gYR.findViewById(f.state).setVisibility(8);
        this.eBO.setText(this.nOa.title);
        if (this.nOa.thumbData != null) {
            this.nOO = com.tencent.mm.sdk.platformtools.c.bs(this.nOa.thumbData);
        }
        this.nMB.setImageBitmap(this.nOO);
        if (bi.oW(this.nOa.description)) {
            this.nMC.setVisibility(8);
        } else {
            this.nMC.setText(this.nOa.description);
            this.nMC.setVisibility(0);
        }
        this.nON = (ImageView) this.gYR.findViewById(f.state);
        this.nON.setVisibility(0);
        if (com.tencent.mm.an.b.PY() && this.hTT) {
            this.nON.setImageResource(e.music_pauseicon);
        } else {
            this.nON.setImageResource(e.music_playicon);
        }
        this.nON.setOnClickListener(new 4(this));
        i.b(this.nMB, this.bGc);
        return this.gYR;
    }

    public final boolean a(int i, int i2, org.b.d.i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        af.byk();
        ax b = aw.b(this.nOa, str, this.bPS, this.appName);
        if (b == null) {
            x.e("MicroMsg.MusicWidget", "packHelper == null, %s, %s", new Object[]{this.bPS, this.appName});
            return false;
        }
        pInt.value = b.afv;
        if (i3 > com.tencent.mm.plugin.sns.c.a.nkE) {
            b.wC(4);
        }
        b.wG(this.nMA);
        if (this.nNY) {
            b.wG(5);
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
        b.ag(linkedList);
        if (iVar != null) {
            b.eB(iVar.token, iVar.rWk);
        }
        b.a(arj);
        if (z) {
            b.wH(1);
        } else {
            b.wH(0);
        }
        b.ci(list2).wE(i);
        b.f(null, null, null, i4, i5);
        if (this.nNZ && this.nOa != null) {
            b.Mz(this.nOa.mediaTagName);
            b.aa(this.bPS, this.nOa.messageExt, this.nOa.messageAction);
        }
        int commit = b.commit();
        if (this.nMG != null) {
            this.nMG.iq(commit);
            com.tencent.mm.plugin.sns.h.e.nxO.c(this.nMG);
        }
        af.byk().bwX();
        this.bGc.finish();
        return false;
    }

    public final boolean d(int i, Intent intent) {
        return false;
    }

    public final boolean bBW() {
        if (!(this.nOO == null || this.nOO.isRecycled())) {
            this.nOO.recycle();
        }
        a.sFg.c(this.fIu);
        if (com.tencent.mm.an.b.PY() && this.hTT) {
            bCk();
        }
        return com.tencent.mm.an.b.PY();
    }
}
