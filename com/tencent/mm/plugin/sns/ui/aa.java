package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.modelsns.b;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.h.f;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.cfn;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.y;

public final class aa implements z {
    private String appId;
    private String appName;
    final MMActivity bGc;
    private String bZG;
    private String bZL;
    private String bZM;
    private Bitmap dHf = null;
    public String dyP = "";
    public String dyQ = "";
    private TextView eBO = null;
    String egr = "";
    private String fmS;
    private View gYR = null;
    private int h = -1;
    private boolean leb = false;
    private int nMA;
    private CdnImageView nMB = null;
    private TextView nMC = null;
    private b nMG = null;
    private String nMx = "";
    private byte[] nMy = null;
    private String nMz;
    private boolean nNT = false;
    private String nNU;
    private String nNV;
    private boolean nNW = false;
    private boolean nNX = false;
    private boolean nNY = false;
    private boolean nNZ = false;
    private WXMediaMessage nOa = null;
    private String nOb = "";
    private String nOc = "";
    private String nOd;
    private String nOe;
    private int nOf = 0;
    private b nOg = null;
    private int nOh = 0;
    private String nOi = "";
    private String nOj = "";
    private int nOk = 0;
    private String nOl = "";
    private String nOm = "";
    String nOn = "";
    private cfn nsD = null;
    private String title = "";
    private String videoUrl = "";
    private int w = -1;

    public aa(MMActivity mMActivity) {
        this.bGc = mMActivity;
    }

    public final void G(Bundle bundle) {
        this.nMG = b.p(this.bGc.getIntent());
        this.nOh = this.bGc.getIntent().getIntExtra("Ksnsupload_type", 0);
        this.nOk = this.bGc.getIntent().getIntExtra("KSnsStreamVideoTotalTime", 0);
        this.nOl = bi.aG(this.bGc.getIntent().getStringExtra("KSnsStreamVideoWroding"), "");
        this.nOm = bi.aG(this.bGc.getIntent().getStringExtra("KSnsStreamVideoWebUrl"), "");
        this.dyP = bi.aG(this.bGc.getIntent().getStringExtra("KSnsStreamVideoAduxInfo"), "");
        this.dyQ = bi.aG(this.bGc.getIntent().getStringExtra("KSnsStreamVideoPublishId"), "");
        this.w = this.bGc.getIntent().getIntExtra("Ksnsupload_width", -1);
        this.h = this.bGc.getIntent().getIntExtra("Ksnsupload_height", -1);
        this.nMA = this.bGc.getIntent().getIntExtra("Ksnsupload_source", 0);
        this.nNV = bi.aG(this.bGc.getIntent().getStringExtra("key_snsad_statextstr"), "");
        this.egr = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_link"), "");
        this.title = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_title"), "");
        this.nMx = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_imgurl"), "");
        this.nMy = this.bGc.getIntent().getByteArrayExtra("Ksnsupload_imgbuf");
        if (this.nMy == null && this.nOa != null && this.nOa.mediaObject != null && (this.nOa.mediaObject instanceof WXImageObject)) {
            this.nMy = ((WXImageObject) this.nOa.mediaObject).imageData;
        }
        this.leb = this.bGc.getIntent().getBooleanExtra("ksnsis_video", false);
        this.nNW = this.bGc.getIntent().getBooleanExtra("ksnsis_music", false);
        this.nNX = this.bGc.getIntent().getBooleanExtra("ksnsis_appbrand", false);
        this.bZG = bi.aG(this.bGc.getIntent().getStringExtra("src_username"), "");
        this.nMz = bi.aG(this.bGc.getIntent().getStringExtra("src_displayname"), "");
        this.appId = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appid"), "");
        this.appName = bi.aG(this.bGc.getIntent().getStringExtra("Ksnsupload_appname"), "");
        this.nNY = this.bGc.getIntent().getBooleanExtra("KThrid_app", false);
        this.nNZ = this.bGc.getIntent().getBooleanExtra("KSnsAction", false);
        this.nOd = bi.aG(this.bGc.getIntent().getStringExtra("ShareUrlOriginal"), "");
        this.nOe = bi.aG(this.bGc.getIntent().getStringExtra("ShareUrlOpen"), "");
        this.bZL = bi.aG(this.bGc.getIntent().getStringExtra("JsAppId"), "");
        this.bZM = bi.aG(this.bGc.getIntent().getStringExtra("KPublisherId"), "");
        this.fmS = bi.aG(this.bGc.getIntent().getStringExtra("reportSessionId"), "");
        this.nOf = this.bGc.getIntent().getIntExtra("Ksnsupload_contentattribute", 0);
        this.nOn = this.bGc.getIntent().getStringExtra("fav_note_xml");
        this.nOi = bi.aG(this.bGc.getIntent().getStringExtra("KsnsUpload_BrandUsername"), "");
        this.nOj = bi.aG(this.bGc.getIntent().getStringExtra("KsnsUpload_BrandPath"), "");
        this.nNU = bi.aG(this.bGc.getIntent().getStringExtra("KlinkThumb_url"), "");
        if (this.nNU.startsWith("http://mmsns.qpic.cn") || this.nNU.startsWith("https://mmsns.qpic.cn")) {
            this.nMx = this.nNU;
            this.nMy = null;
            x.i("MicroMsg.LinkWidget", "get thumb url %s", new Object[]{this.nNU});
        }
        Bundle bundleExtra = this.bGc.getIntent().getBundleExtra("Ksnsupload_timeline");
        if (bundleExtra != null) {
            this.nOa = new Req(bundleExtra).message;
            if (bi.oW(this.title)) {
                this.title = this.nOa.title;
            }
            if (bi.oW(this.nOc)) {
                this.nOc = this.nOa.description;
            }
            if (bi.bC(this.nMy)) {
                this.nMy = this.nOa.thumbData;
            }
        }
        byte[] byteArrayExtra = this.bGc.getIntent().getByteArrayExtra("KWebSearchInfo");
        if (byteArrayExtra != null) {
            this.nsD = new cfn();
            try {
                this.nsD.aG(byteArrayExtra);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.LinkWidget", e, "parse web search info failed", new Object[0]);
                this.nsD = null;
            }
        }
        String stringExtra = this.bGc.getIntent().getStringExtra("KSnsStrId");
        n Nl = af.byo().Nl(bi.aG(this.bGc.getIntent().getStringExtra("KSnsLocalId"), ""));
        if (!bi.oW(stringExtra)) {
            this.nOg = b.io(706);
            this.nOg.is(this.nOg.egR).nc(System.currentTimeMillis()).is(this.nOg.egS).is(1).nc(stringExtra);
            if (Nl != null) {
                this.nOg.ir(Nl.field_type);
                this.nOg.bP(Nl.xb(32)).nb(Nl.bBo()).nb(this.egr);
            }
            f.nxO.b(this.nOg);
        }
    }

    public final void H(Bundle bundle) {
    }

    public final boolean bBU() {
        return true;
    }

    public final View bBV() {
        this.gYR = y.gq(this.bGc).inflate(g.upload_media_link, null);
        if (!bi.oW(this.egr)) {
            this.gYR.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (bi.oW(aa.this.nOn)) {
                        x.i("MicroMsg.LinkWidget", "adlink url " + aa.this.egr);
                        Intent intent = new Intent();
                        intent.putExtra("rawUrl", aa.this.egr);
                        a.ezn.j(intent, aa.this.bGc);
                    }
                }
            });
        }
        this.nMB = (CdnImageView) this.gYR.findViewById(i.f.image_left);
        this.eBO = (TextView) this.gYR.findViewById(i.f.titletext);
        this.nMC = (TextView) this.gYR.findViewById(i.f.righttext);
        if (!(this.leb || this.nNW)) {
            boolean z = (this.nsD == null || bi.oW(this.nsD.pLr)) ? false : true;
            if (!z) {
                this.gYR.findViewById(i.f.state).setVisibility(8);
                if (bi.oW(this.title)) {
                    this.eBO.setText(this.title);
                } else {
                    this.eBO.setText(av.Oa(this.egr));
                }
                if (!bi.oW(this.nMx)) {
                    this.nMB.setVisibility(0);
                    this.nMB.setUrl(this.nMx);
                } else if (!bi.bC(this.nMy)) {
                    this.nMB.setVisibility(0);
                    this.dHf = c.bs(this.nMy);
                    this.nMB.setImageBitmap(this.dHf);
                    this.nNT = true;
                } else if (bi.oW(this.nOn)) {
                    this.nMB.setImageResource(i.i.app_attach_file_icon_webpage);
                    this.nMB.setVisibility(0);
                } else {
                    this.nMB.setImageResource(i.i.note_sns_link_default);
                    this.nMB.setVisibility(0);
                }
                com.tencent.mm.plugin.sns.data.i.b(this.nMB, this.bGc);
                return this.gYR;
            }
        }
        this.gYR.findViewById(i.f.state).setVisibility(0);
        if (bi.oW(this.title)) {
            this.eBO.setText(av.Oa(this.egr));
        } else {
            this.eBO.setText(this.title);
        }
        if (!bi.oW(this.nMx)) {
            this.nMB.setVisibility(0);
            this.nMB.setUrl(this.nMx);
        } else if (!bi.bC(this.nMy)) {
            this.nMB.setVisibility(0);
            this.dHf = c.bs(this.nMy);
            this.nMB.setImageBitmap(this.dHf);
            this.nNT = true;
        } else if (bi.oW(this.nOn)) {
            this.nMB.setImageResource(i.i.app_attach_file_icon_webpage);
            this.nMB.setVisibility(0);
        } else {
            this.nMB.setImageResource(i.i.note_sns_link_default);
            this.nMB.setVisibility(0);
        }
        com.tencent.mm.plugin.sns.data.i.b(this.nMB, this.bGc);
        return this.gYR;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r11, int r12, org.b.d.i r13, java.lang.String r14, java.util.List<java.lang.String> r15, com.tencent.mm.protocal.c.arj r16, int r17, boolean r18, java.util.List<java.lang.String> r19, com.tencent.mm.pointers.PInt r20, java.lang.String r21, int r22, int r23) {
        /*
        r10 = this;
        r1 = r10.nNW;
        if (r1 == 0) goto L_0x0113;
    L_0x0004:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 4;
        r1.<init>(r2);
    L_0x000a:
        r2 = r1.afv;
        r0 = r20;
        r0.value = r2;
        r2 = com.tencent.mm.plugin.sns.c.a.nkE;
        r0 = r17;
        if (r0 <= r2) goto L_0x001a;
    L_0x0016:
        r2 = 4;
        r1.wC(r2);
    L_0x001a:
        r2 = r10.nMy;
        if (r2 != 0) goto L_0x0061;
    L_0x001e:
        com.tencent.mm.ak.o.Pe();
        r2 = r10.nMx;
        r2 = com.tencent.mm.ak.c.jz(r2);
        if (r2 == 0) goto L_0x0061;
    L_0x0029:
        r3 = r2.isRecycled();
        if (r3 != 0) goto L_0x0061;
    L_0x002f:
        r3 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r4 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r5 = 0;
        r6 = 0;
        r2 = com.tencent.mm.sdk.platformtools.c.a(r2, r3, r4, r5, r6);
        r3 = "MicroMsg.LinkWidget";
        r4 = "create bitmap %d %d";
        r5 = 2;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r7 = r2.getHeight();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        r6 = 1;
        r7 = r2.getWidth();
        r7 = java.lang.Integer.valueOf(r7);
        r5[r6] = r7;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r2 = com.tencent.mm.sdk.platformtools.c.Q(r2);
        r10.nMy = r2;
    L_0x0061:
        r2 = r10.title;
        r2 = r1.MD(r2);
        r3 = r10.egr;
        r2 = r2.MB(r3);
        r3 = r10.egr;
        r2 = r2.MC(r3);
        r2.My(r14);
        r2 = r10.nOh;
        r3 = 15;
        if (r2 != r3) goto L_0x0093;
    L_0x007c:
        r2 = r10.bGc;
        r2 = r2.getIntent();
        r3 = "fav_note_link_description";
        r2 = r2.getStringExtra(r3);
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aG(r2, r3);
        r1.MB(r2);
    L_0x0093:
        r2 = r10.nNW;
        if (r2 == 0) goto L_0x01ad;
    L_0x0097:
        r2 = r10.nMy;
        r3 = r10.egr;
        r4 = r10.egr;
        r5 = r10.egr;
        r6 = 3;
        r7 = "";
        r8 = "";
        r2 = r1.a(r2, r3, r4, r5, r6, r7, r8);
        if (r2 != 0) goto L_0x00ac;
    L_0x00ac:
        r2 = r10.nMA;
        r1.wG(r2);
        r2 = r10.bZG;
        r1.MG(r2);
        r2 = r10.nMz;
        r1.MH(r2);
        r2 = r10.nNV;
        r3 = r1.nsx;
        r4 = com.tencent.mm.sdk.platformtools.bi.oV(r2);
        r3.nNV = r4;
        r3 = "MicroMsg.UploadPackHelper";
        r4 = "setStatExtStr:%s";
        r5 = 1;
        r5 = new java.lang.Object[r5];
        r6 = 0;
        r5[r6] = r2;
        com.tencent.mm.sdk.platformtools.x.i(r3, r4, r5);
        r1.wE(r11);
        if (r18 == 0) goto L_0x02a3;
    L_0x00d9:
        r2 = 1;
        r1.wH(r2);
    L_0x00dd:
        r0 = r19;
        r1.ci(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        if (r15 == 0) goto L_0x02a9;
    L_0x00e9:
        r2 = new java.util.LinkedList;
        r2.<init>();
        r4 = com.tencent.mm.model.s.Hv();
        r5 = r15.iterator();
    L_0x00f6:
        r2 = r5.hasNext();
        if (r2 == 0) goto L_0x02a9;
    L_0x00fc:
        r2 = r5.next();
        r2 = (java.lang.String) r2;
        r6 = r4.contains(r2);
        if (r6 != 0) goto L_0x00f6;
    L_0x0108:
        r6 = new com.tencent.mm.protocal.c.bqg;
        r6.<init>();
        r6.hbL = r2;
        r3.add(r6);
        goto L_0x00f6;
    L_0x0113:
        r1 = r10.leb;
        if (r1 == 0) goto L_0x011f;
    L_0x0117:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 5;
        r1.<init>(r2);
        goto L_0x000a;
    L_0x011f:
        r1 = r10.nNX;
        if (r1 == 0) goto L_0x013c;
    L_0x0123:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 25;
        r1.<init>(r2);
        r2 = r10.nOi;
        r3 = r1.nsx;
        r3 = r3.sqi;
        r3.username = r2;
        r2 = r10.nOj;
        r3 = r1.nsx;
        r3 = r3.sqi;
        r3.path = r2;
        goto L_0x000a;
    L_0x013c:
        r1 = r10.nOh;
        r2 = 11;
        if (r1 != r2) goto L_0x0176;
    L_0x0142:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 18;
        r1.<init>(r2);
        r2 = new com.tencent.mm.protocal.c.brh;
        r2.<init>();
        r3 = r10.nOl;
        r2.dyM = r3;
        r3 = r10.title;
        r2.dyL = r3;
        r3 = r10.egr;
        r2.dyJ = r3;
        r3 = r10.nOm;
        r2.dyN = r3;
        r3 = r10.nOk;
        r2.dyK = r3;
        r3 = r10.nMx;
        r2.dyO = r3;
        r3 = r10.dyP;
        r2.dyP = r3;
        r3 = r10.dyQ;
        r2.dyQ = r3;
        r1.nsC = r2;
        r3 = r1.nsx;
        r3.sqh = r2;
        goto L_0x000a;
    L_0x0176:
        r1 = r10.nOh;
        r2 = 15;
        if (r1 != r2) goto L_0x018d;
    L_0x017c:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 26;
        r1.<init>(r2);
        r2 = r10.nOn;
        r3 = r1.nsx;
        r3 = r3.sqc;
        r3.ruC = r2;
        goto L_0x000a;
    L_0x018d:
        r1 = r10.nOh;
        r2 = 16;
        if (r1 != r2) goto L_0x01a5;
    L_0x0193:
        r1 = r10.nsD;
        if (r1 == 0) goto L_0x01a5;
    L_0x0197:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 3;
        r1.<init>(r2);
        r2 = r10.nsD;
        if (r2 == 0) goto L_0x000a;
    L_0x01a1:
        r1.nsD = r2;
        goto L_0x000a;
    L_0x01a5:
        r1 = new com.tencent.mm.plugin.sns.model.ax;
        r2 = 3;
        r1.<init>(r2);
        goto L_0x000a;
    L_0x01ad:
        r2 = r10.leb;
        if (r2 == 0) goto L_0x01f3;
    L_0x01b1:
        r2 = 0;
        r3 = r10.nOa;
        if (r3 == 0) goto L_0x0359;
    L_0x01b6:
        r2 = r10.nOa;
        r2 = r2.mediaObject;
        r2 = (com.tencent.mm.opensdk.modelmsg.WXVideoObject) r2;
        r5 = r2;
    L_0x01bd:
        r2 = r10.nMy;
        r3 = r10.egr;
        if (r5 != 0) goto L_0x01e1;
    L_0x01c3:
        r4 = r10.egr;
    L_0x01c5:
        if (r5 != 0) goto L_0x01ea;
    L_0x01c7:
        r5 = r10.egr;
    L_0x01c9:
        r6 = 4;
        r7 = r10.title;
        r8 = "";
        r7 = com.tencent.mm.sdk.platformtools.bi.aG(r7, r8);
        r8 = r10.nOc;
        r9 = "";
        r8 = com.tencent.mm.sdk.platformtools.bi.aG(r8, r9);
        r1.a(r2, r3, r4, r5, r6, r7, r8);
        goto L_0x00ac;
    L_0x01e1:
        r4 = r5.videoLowBandUrl;
        r6 = r10.egr;
        r4 = com.tencent.mm.sdk.platformtools.bi.aG(r4, r6);
        goto L_0x01c5;
    L_0x01ea:
        r5 = r5.videoUrl;
        r6 = r10.egr;
        r5 = com.tencent.mm.sdk.platformtools.bi.aG(r5, r6);
        goto L_0x01c9;
    L_0x01f3:
        r2 = r10.nNU;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x0249;
    L_0x01fb:
        r2 = r10.nNU;
        r3 = "";
        r4 = "";
        r5 = r10.w;
        r6 = r10.h;
        r7 = "";
        r2 = com.tencent.mm.plugin.sns.model.ax.ab(r7, r2, r2);
        if (r2 != 0) goto L_0x021b;
    L_0x0210:
        r2 = "MicroMsg.UploadPackHelper";
        r3 = "share img o.url is null!";
        com.tencent.mm.sdk.platformtools.x.e(r2, r3);
        goto L_0x00ac;
    L_0x021b:
        r2.jOS = r3;
        if (r5 <= 0) goto L_0x022e;
    L_0x021f:
        if (r6 <= 0) goto L_0x022e;
    L_0x0221:
        r7 = new com.tencent.mm.protocal.c.atg;
        r7.<init>();
        r6 = (float) r6;
        r7.rWv = r6;
        r5 = (float) r5;
        r7.rWu = r5;
        r2.rVH = r7;
    L_0x022e:
        r5 = com.tencent.mm.sdk.platformtools.bi.oW(r4);
        if (r5 != 0) goto L_0x0236;
    L_0x0234:
        r2.bHD = r4;
    L_0x0236:
        r4 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r4 != 0) goto L_0x023e;
    L_0x023c:
        r2.jOS = r3;
    L_0x023e:
        r3 = r1.nsx;
        r3 = r3.sqc;
        r3 = r3.ruA;
        r3.add(r2);
        goto L_0x00ac;
    L_0x0249:
        r2 = r10.nMy;
        if (r2 == 0) goto L_0x00ac;
    L_0x024d:
        r2 = r10.nNX;
        if (r2 == 0) goto L_0x027b;
    L_0x0251:
        r4 = r10.nMy;
        if (r4 != 0) goto L_0x0288;
    L_0x0255:
        r2 = 0;
    L_0x0256:
        if (r2 == 0) goto L_0x027b;
    L_0x0258:
        r2 = "MicroMsg.LinkWidget";
        r3 = "isPngThumbData";
        com.tencent.mm.sdk.platformtools.x.i(r2, r3);
        r2 = r10.nMy;
        r2 = com.tencent.mm.plugin.sns.ui.f.aL(r2);
        if (r2 == 0) goto L_0x027b;
    L_0x0269:
        r3 = r2.length;
        if (r3 <= 0) goto L_0x027b;
    L_0x026c:
        r3 = "MicroMsg.LinkWidget";
        r4 = "use covert data";
        com.tencent.mm.sdk.platformtools.x.i(r3, r4);
        r2 = com.tencent.mm.plugin.sns.ui.f.aL(r2);
        r10.nMy = r2;
    L_0x027b:
        r2 = r10.nMy;
        r3 = "";
        r4 = "";
        r1.b(r2, r3, r4);
        goto L_0x00ac;
    L_0x0288:
        r2 = r4.length;
        r3 = 4;
        if (r2 >= r3) goto L_0x028e;
    L_0x028c:
        r2 = 0;
        goto L_0x0256;
    L_0x028e:
        r2 = 1;
        r3 = 4;
        r5 = new byte[r3];
        r5 = {-119, 80, 78, 71};
        r3 = 0;
    L_0x0296:
        r6 = 4;
        if (r3 >= r6) goto L_0x0256;
    L_0x0299:
        r6 = r4[r3];
        r7 = r5[r3];
        if (r6 == r7) goto L_0x02a0;
    L_0x029f:
        r2 = 0;
    L_0x02a0:
        r3 = r3 + 1;
        goto L_0x0296;
    L_0x02a3:
        r2 = 0;
        r1.wH(r2);
        goto L_0x00dd;
    L_0x02a9:
        if (r13 == 0) goto L_0x02b2;
    L_0x02ab:
        r2 = r13.token;
        r4 = r13.rWk;
        r1.eB(r2, r4);
    L_0x02b2:
        r1.ag(r3);
        r2 = r10.appId;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x02c2;
    L_0x02bd:
        r2 = r10.appId;
        r1.ME(r2);
    L_0x02c2:
        r2 = r10.appName;
        r2 = com.tencent.mm.sdk.platformtools.bi.oW(r2);
        if (r2 != 0) goto L_0x02d6;
    L_0x02ca:
        r2 = r10.appName;
        r3 = "";
        r2 = com.tencent.mm.sdk.platformtools.bi.aG(r2, r3);
        r1.MF(r2);
    L_0x02d6:
        r2 = r10.nNY;
        if (r2 == 0) goto L_0x02de;
    L_0x02da:
        r2 = 5;
        r1.wG(r2);
    L_0x02de:
        r0 = r16;
        r1.a(r0);
        r2 = r10.nNZ;
        if (r2 == 0) goto L_0x02ff;
    L_0x02e7:
        r2 = r10.nOa;
        if (r2 == 0) goto L_0x02ff;
    L_0x02eb:
        r2 = r10.nOa;
        r2 = r2.mediaTagName;
        r1.Mz(r2);
        r2 = r10.appId;
        r3 = r10.nOa;
        r3 = r3.messageExt;
        r4 = r10.nOa;
        r4 = r4.messageAction;
        r1.aa(r2, r3, r4);
    L_0x02ff:
        r0 = r21;
        r1.MA(r0);
        r2 = r10.nOd;
        r3 = r10.nOe;
        r4 = r10.bZL;
        r5 = r22;
        r6 = r23;
        r1.f(r2, r3, r4, r5, r6);
        r2 = r10.bZM;
        r3 = r1.nsy;
        r3.bZM = r2;
        r2 = r10.fmS;
        r1.setSessionId(r2);
        r2 = r10.nOf;
        r3 = r1.nsx;
        r3.dwt = r2;
        r1 = r1.commit();
        r2 = r10.nMG;
        if (r2 == 0) goto L_0x0336;
    L_0x032a:
        r2 = r10.nMG;
        r2.iq(r1);
        r2 = com.tencent.mm.plugin.sns.h.e.nxO;
        r3 = r10.nMG;
        r2.c(r3);
    L_0x0336:
        r2 = r10.nOg;
        if (r2 == 0) goto L_0x034b;
    L_0x033a:
        r2 = r10.nOg;
        r2.iq(r1);
        r1 = com.tencent.mm.plugin.sns.h.f.nxO;
        r2 = r10.nOg;
        r1.c(r2);
        r1 = r10.nOg;
        r1.RD();
    L_0x034b:
        r1 = com.tencent.mm.plugin.sns.model.af.byk();
        r1.bwX();
        r1 = r10.bGc;
        r1.finish();
        r1 = 0;
        return r1;
    L_0x0359:
        r5 = r2;
        goto L_0x01bd;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.aa.a(int, int, org.b.d.i, java.lang.String, java.util.List, com.tencent.mm.protocal.c.arj, int, boolean, java.util.List, com.tencent.mm.pointers.PInt, java.lang.String, int, int):boolean");
    }

    public final boolean d(int i, Intent intent) {
        return false;
    }

    public final boolean bBW() {
        if (!(this.dHf == null || this.dHf.isRecycled() || !this.nNT)) {
            this.dHf.recycle();
        }
        return false;
    }
}
