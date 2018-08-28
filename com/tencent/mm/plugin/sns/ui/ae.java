package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class ae implements z {
    private String appName = "";
    private MMActivity bGc;
    private String bPS = "";
    private int nMA;
    private b nMG = null;
    private boolean nNY = false;
    private boolean nNZ = false;
    private WXMediaMessage nOa = null;
    private String nPc = "";
    private boolean nPd = false;

    public ae(MMActivity mMActivity, boolean z) {
        this.bGc = mMActivity;
        this.nPd = z;
    }

    public final void G(Bundle bundle) {
        this.nMG = b.p(this.bGc.getIntent());
        this.nPc = this.bGc.getIntent().getStringExtra(h.thz);
        this.bPS = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.nNY = this.bGc.getIntent().getBooleanExtra("KThrid_app", false);
        this.nNZ = this.bGc.getIntent().getBooleanExtra("KSnsAction", false);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        Bundle bundleExtra = this.bGc.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.nOa = new Req(bundleExtra).message;
        }
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return this.nPd;
    }

    public final View bBV() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.bGc.isFinishing()) {
            return false;
        }
        ax axVar = new ax(2);
        pInt.value = axVar.afv;
        if (i3 > a.nkE) {
            axVar.wC(2);
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
        if (z) {
            axVar.wH(1);
        } else {
            axVar.wH(0);
        }
        if (iVar != null) {
            axVar.eB(iVar.token, iVar.rWk);
        }
        axVar.wG(this.nMA);
        if (this.nNY) {
            axVar.wG(5);
        }
        if (this.nNZ && this.nOa != null) {
            axVar.Mz(this.nOa.mediaTagName);
            axVar.aa(this.bPS, this.nOa.messageExt, this.nOa.messageAction);
        }
        axVar.f(null, null, null, i4, i5);
        axVar.My(str).a(arj).ag(linkedList).wE(i).wF(i2).ci(list2);
        int commit = axVar.commit();
        if (this.nMG != null) {
            this.nMG.iq(commit);
            e.nxO.c(this.nMG);
        }
        this.bGc.setResult(-1);
        af.byk().bwX();
        this.bGc.finish();
        return true;
    }

    public final boolean d(int i, Intent intent) {
        return false;
    }

    public final boolean bBW() {
        return false;
    }
}
