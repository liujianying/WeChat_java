package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX$Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.e;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.aw;
import com.tencent.mm.plugin.sns.model.ax;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.c.arj;
import com.tencent.mm.protocal.c.bqg;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.e.h;
import java.util.LinkedList;
import java.util.List;
import org.b.d.i;

public final class be implements z {
    private String appName = "";
    private MMActivity bGc;
    private String bPS = "";
    private int nMA;
    private b nMG = null;
    private boolean nNY = false;
    private boolean nNZ = false;
    private WXMediaMessage nOa = null;
    private String nPc = "";

    public be(MMActivity mMActivity) {
        this.bGc = mMActivity;
    }

    public final void G(Bundle bundle) {
        this.nMG = b.p(this.bGc.getIntent());
        this.nPc = this.bGc.getIntent().getStringExtra(h.thz);
        this.bPS = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.nNY = this.bGc.getIntent().getBooleanExtra("KThrid_app", false);
        this.nNZ = this.bGc.getIntent().getBooleanExtra("KSnsAction", false);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.nOa = new SendMessageToWX$Req(this.bGc.getIntent().getBundleExtra("Ksnsupload_timeline")).message;
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return true;
    }

    public final View bBV() {
        return null;
    }

    public final boolean a(int i, int i2, i iVar, String str, List<String> list, arj arj, int i3, boolean z, List<String> list2, PInt pInt, String str2, int i4, int i5) {
        if (this.nOa != null) {
            this.nOa.description = str;
            if (this.nOa.mediaObject != null && (this.nOa.mediaObject instanceof WXTextObject)) {
                ((WXTextObject) this.nOa.mediaObject).text = str;
            }
        }
        af.byk();
        ax b = aw.b(this.nOa, str, this.bPS, this.appName);
        if (b == null) {
            x.e("MicroMsg.TextWidget", "packHelper == null, %s, %s", new Object[]{this.bPS, this.appName});
            return false;
        }
        pInt.value = b.afv;
        if (i3 > a.nkE) {
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
        return false;
    }
}
