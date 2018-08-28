package com.tencent.mm.plugin.emoji.ui.fts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.d.a;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.k;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FTSEmojiDetailPageUI extends MMActivity implements e {
    private int bJt;
    private String bKk;
    private String bOs;
    private String bVd;
    private String designerName;
    private int dzF;
    private ProgressBar gVi;
    private EmojiInfo gZe;
    private k gcQ;
    private String ihE;
    private a ihx = new a() {
        public final void h(EmojiInfo emojiInfo) {
            if (emojiInfo == null || FTSEmojiDetailPageUI.this.gZe == null || !FTSEmojiDetailPageUI.this.gZe.Xh().equals(emojiInfo.Xh())) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "somethings error.");
                return;
            }
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiServiceCallback onDownload %s", new Object[]{FTSEmojiDetailPageUI.this.gZe.Xh()});
            ah.A(new 1(this));
        }
    };
    private String ioA;
    private String ioB;
    private String ioC;
    private c ioD = new c<cs>() {
        {
            this.sFo = cs.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            cs csVar = (cs) bVar;
            if (FTSEmojiDetailPageUI.this.gZe != null && csVar.bKf.bKg.equals(FTSEmojiDetailPageUI.this.gZe.Xh())) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "emojiDownloadListener callback %s", new Object[]{FTSEmojiDetailPageUI.this.gZe.Xh()});
                ah.A(new 1(this));
            }
            return false;
        }
    };
    private i ioE = new 10(this);
    private d ioF = new 3(this);
    private MMAnimateView ioo;
    private Button iop;
    private Button ioq;
    private TextView ior;
    private ImageView ios;
    private View iot;
    private boolean iou;
    private boolean iov;
    private String iow;
    private String iox;
    private String ioy;
    private String ioz;
    private int scene;
    private int type;

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2) {
        ad.b(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.iow, fTSEmojiDetailPageUI.ihE, 2, 0);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("mutil_select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Msg_thumb_path", str);
        intent.putExtra("emoji_activity_id", str2);
        intent.putExtra("MMActivity.OverrideEnterAnimation", R.a.fast_faded_in);
        com.tencent.mm.bg.d.b(fTSEmojiDetailPageUI, ".ui.transmit.SelectConversationUI", intent, 0);
        fTSEmojiDetailPageUI.overridePendingTransition(R.a.push_up_in, R.a.fast_faded_out);
    }

    static /* synthetic */ void a(FTSEmojiDetailPageUI fTSEmojiDetailPageUI, String str, String str2, String str3, String str4) {
        ad.b(fTSEmojiDetailPageUI.scene, fTSEmojiDetailPageUI.iow, fTSEmojiDetailPageUI.ihE, 1, 0);
        EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(str);
        au.HU();
        String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", str);
        if (Zy == null && com.tencent.mm.a.e.cn(L)) {
            int i = o.Wf(L) ? EmojiInfo.tcJ : EmojiInfo.tcI;
            EmojiInfo emojiInfo = new EmojiInfo();
            emojiInfo.field_md5 = str;
            emojiInfo.field_catalog = EmojiInfo.tcB;
            emojiInfo.field_type = i;
            emojiInfo.field_size = com.tencent.mm.a.e.cm(L);
            emojiInfo.field_temp = 1;
            emojiInfo.field_designerID = str2;
            emojiInfo.field_thumbUrl = str3;
            emojiInfo.field_activityid = str4;
            com.tencent.mm.plugin.emoji.model.i.aEA().igx.n(emojiInfo);
            Zy = emojiInfo;
        }
        if (Zy != null) {
            boolean a = com.tencent.mm.plugin.emoji.model.i.aEw().a(fTSEmojiDetailPageUI, Zy, 18, q.GF());
            x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "doAddAction %b", new Object[]{Boolean.valueOf(a)});
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI r9) {
        /*
        r8 = 27;
        r3 = 3;
        r1 = 1;
        r2 = 0;
        r4 = r9.scene;
        r5 = r9.iow;
        r6 = r9.ihE;
        r0 = r9.type;
        switch(r0) {
            case 2: goto L_0x00a8;
            case 3: goto L_0x00b3;
            case 4: goto L_0x00be;
            default: goto L_0x0010;
        };
    L_0x0010:
        r0 = r2;
    L_0x0011:
        r7 = r9.aGg();
        if (r7 == 0) goto L_0x0018;
    L_0x0017:
        r0 = 4;
    L_0x0018:
        com.tencent.mm.plugin.websearch.api.ad.b(r4, r5, r6, r3, r0);
        r0 = r9.aGg();
        if (r0 == 0) goto L_0x00c9;
    L_0x0021:
        r0 = new android.os.Bundle;
        r0.<init>();
        r2 = "stat_scene";
        r3 = 8;
        r0.putInt(r2, r3);
        r2 = "stat_search_id";
        r3 = r9.iow;
        r0.putString(r2, r3);
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r9.iow;
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.ihE;
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.scene;
        r3 = java.lang.String.valueOf(r3);
        r2 = r2.append(r3);
        r3 = ":";
        r2 = r2.append(r3);
        r3 = r9.type;
        r3 = java.lang.String.valueOf(r3);
        r2 = r2.append(r3);
        r2 = r2.toString();
        r3 = new android.content.Intent;
        r3.<init>();
        r4 = "key_username";
        r5 = r9.ioC;
        r3.putExtra(r4, r5);
        r4 = "key_can_swipe_back";
        r3.putExtra(r4, r1);
        r1 = "key_from_scene";
        r4 = 6;
        r3.putExtra(r1, r4);
        r1 = "key_scene_note";
        r3.putExtra(r1, r2);
        r1 = "_stat_obj";
        r3.putExtra(r1, r0);
        r0 = r9.mController;
        r0 = r0.tml;
        r1 = "appbrand";
        r2 = ".ui.AppBrandProfileUI";
        com.tencent.mm.bg.d.b(r0, r1, r2, r3);
    L_0x00a7:
        return;
    L_0x00a8:
        r0 = r9.bKk;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00b0:
        r0 = r1;
        goto L_0x0011;
    L_0x00b3:
        r0 = r9.bOs;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00bb:
        r0 = 2;
        goto L_0x0011;
    L_0x00be:
        r0 = r9.ioz;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0010;
    L_0x00c6:
        r0 = r3;
        goto L_0x0011;
    L_0x00c9:
        r0 = new android.content.Intent;
        r0.<init>();
        r1 = "preceding_scence";
        r3 = r9.getIntent();
        r4 = "preceding_scence";
        r2 = r3.getIntExtra(r4, r2);
        r0.putExtra(r1, r2);
        r1 = "download_entrance_scene";
        r0.putExtra(r1, r8);
        r1 = "searchID";
        r2 = r9.iow;
        r4 = 0;
        r2 = com.tencent.mm.sdk.platformtools.bi.getLong(r2, r4);
        r0.putExtra(r1, r2);
        r1 = "docID";
        r2 = r9.ihE;
        r0.putExtra(r1, r2);
        r1 = r9.type;
        switch(r1) {
            case 2: goto L_0x0101;
            case 3: goto L_0x0127;
            case 4: goto L_0x014b;
            default: goto L_0x0100;
        };
    L_0x0100:
        goto L_0x00a7;
    L_0x0101:
        r1 = com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.class;
        r0.setClass(r9, r1);
        r1 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r0.setFlags(r1);
        r1 = "extra_scence";
        r2 = r9.scene;
        r0.putExtra(r1, r2);
        r1 = "extra_type";
        r2 = r9.type;
        r0.putExtra(r1, r2);
        r1 = "extra_id";
        r2 = r9.bKk;
        r0.putExtra(r1, r2);
    L_0x0123:
        r9.startActivity(r0);
        goto L_0x00a7;
    L_0x0127:
        r1 = com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2DesignerUI.class;
        r0.setClass(r9, r1);
        r1 = "extra_scence";
        r0.putExtra(r1, r8);
        r1 = "id";
        r2 = r9.bOs;
        r0.putExtra(r1, r2);
        r1 = "name";
        r2 = r9.designerName;
        r0.putExtra(r1, r2);
        r1 = "headurl";
        r2 = r9.ioB;
        r0.putExtra(r1, r2);
        goto L_0x0123;
    L_0x014b:
        r1 = r9.ioz;
        r1 = com.tencent.mm.sdk.platformtools.bi.oW(r1);
        if (r1 != 0) goto L_0x00a7;
    L_0x0153:
        r1 = "rawUrl";
        r2 = r9.ioz;
        r0.putExtra(r1, r2);
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r2 = "webview";
        r3 = ".ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r1, r2, r3, r0);
        goto L_0x00a7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI.b(com.tencent.mm.plugin.emoji.ui.fts.FTSEmojiDetailPageUI):void");
    }

    static /* synthetic */ void c(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        if (fTSEmojiDetailPageUI.iov) {
            arrayList.add(Integer.valueOf(1));
            arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.save_to_local));
        }
        arrayList.add(Integer.valueOf(2));
        arrayList2.add(fTSEmojiDetailPageUI.getString(R.l.emoji_store_complaints));
        if (fTSEmojiDetailPageUI.gcQ == null) {
            fTSEmojiDetailPageUI.gcQ = new k(fTSEmojiDetailPageUI.mController.tml);
        }
        fTSEmojiDetailPageUI.gcQ.ofp = new 11(fTSEmojiDetailPageUI, arrayList, arrayList2);
        fTSEmojiDetailPageUI.gcQ.ofq = fTSEmojiDetailPageUI.ioF;
        fTSEmojiDetailPageUI.gcQ.d(new 2(fTSEmojiDetailPageUI));
        h.a(fTSEmojiDetailPageUI.mController.tml, fTSEmojiDetailPageUI.gcQ.bEo());
    }

    static /* synthetic */ void g(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        x.d("MicroMsg.FTS.FTSEmojiDetailPageUI", "ApplicationLanguage" + w.chP());
        String str = fTSEmojiDetailPageUI.getString(R.l.fts_emoji_complaints_doc) + w.chP();
        Intent intent = new Intent();
        intent.putExtra(FFmpegMetadataRetriever.METADATA_KEY_TITLE, fTSEmojiDetailPageUI.getString(R.l.emoji_store_complaints));
        intent.putExtra("rawUrl", str);
        intent.putExtra("showShare", false);
        intent.putExtra("neverGetA8Key", true);
        com.tencent.mm.bg.d.b(fTSEmojiDetailPageUI, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void h(FTSEmojiDetailPageUI fTSEmojiDetailPageUI) {
        if (FileOp.cn(fTSEmojiDetailPageUI.bVd)) {
            l.i(fTSEmojiDetailPageUI.bVd, fTSEmojiDetailPageUI);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iop = (Button) findViewById(R.h.emoji_add_btn);
        this.ioq = (Button) findViewById(R.h.emoji_send_btn);
        this.ioo = (MMAnimateView) findViewById(R.h.emoji_image_iv);
        this.gVi = (ProgressBar) findViewById(R.h.loading_pb);
        this.ior = (TextView) findViewById(R.h.emoji_source_title_tv);
        this.ios = (ImageView) findViewById(R.h.emoji_source_iv);
        this.iot = findViewById(R.h.bottom_bar);
        setBackBtn(new 1(this));
        this.iop.setOnClickListener(new 4(this));
        this.ioq.setOnClickListener(new 5(this));
        this.iot.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                FTSEmojiDetailPageUI.b(FTSEmojiDetailPageUI.this);
            }
        });
        addIconOptionMenu(0, R.g.mm_title_btn_menu, new 7(this));
        this.type = getIntent().getIntExtra("extra_type", 0);
        this.scene = getIntent().getIntExtra("extra_scence", 0);
        this.gZe = new EmojiInfo();
        this.gZe.field_designerID = getIntent().getStringExtra("id");
        this.gZe.field_name = getIntent().getStringExtra("extra_emoji_name");
        this.gZe.field_aeskey = getIntent().getStringExtra("extra_aeskey");
        this.gZe.field_encrypturl = getIntent().getStringExtra("extra_encrypt_url");
        this.gZe.field_thumbUrl = getIntent().getStringExtra("extra_thumb_url");
        this.gZe.field_md5 = getIntent().getStringExtra("extra_md5");
        this.gZe.field_groupId = getIntent().getStringExtra("extra_product_id");
        this.bKk = this.gZe.field_groupId;
        this.ioy = getIntent().getStringExtra("extra_product_name");
        this.iox = getIntent().getStringExtra("productUrl");
        this.ioz = getIntent().getStringExtra("extra_article_url");
        this.ioA = getIntent().getStringExtra("extra_article_name");
        this.bOs = this.gZe.field_designerID;
        this.designerName = getIntent().getStringExtra("name");
        this.ioB = getIntent().getStringExtra("headurl");
        this.ioC = getIntent().getStringExtra("weapp_user_name");
        this.dzF = getIntent().getIntExtra("weapp_version", 0);
        this.bJt = getIntent().getIntExtra("source_type", 0);
        this.iow = getIntent().getStringExtra("searchID");
        this.ihE = getIntent().getStringExtra("docID");
        this.iou = getIntent().getBooleanExtra("disableAddSticker", false);
        this.iov = getIntent().getBooleanExtra("needSavePhotosAlbum", false);
        String stringExtra = getIntent().getStringExtra("activityId");
        if (!bi.oW(stringExtra)) {
            this.gZe.field_activityid = stringExtra;
        }
        com.tencent.mm.sdk.b.a.sFg.b(this.ioD);
        com.tencent.mm.plugin.emoji.model.i.aEu().ihj = this.ihx;
        ad.v(this.scene, this.iow, this.ihE);
        eo(true);
        x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "localPath=%s", new Object[]{this.bVd});
        ad.v(this.scene, this.iow, this.ihE);
    }

    protected void onResume() {
        super.onResume();
        aGf();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        if (i == 0 && i2 == -1) {
            EmojiInfo emojiInfo;
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            String stringExtra2 = intent.getStringExtra("custom_send_text");
            EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.gZe.Xh());
            if (Zy == null) {
                au.HU();
                String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", this.gZe.Xh());
                if (com.tencent.mm.a.e.cn(L)) {
                    int i3 = o.Wf(L) ? EmojiInfo.tcJ : EmojiInfo.tcI;
                    EmojiInfo emojiInfo2 = new EmojiInfo();
                    emojiInfo2.field_md5 = this.gZe.Xh();
                    emojiInfo2.field_catalog = EmojiInfo.tcB;
                    emojiInfo2.field_type = i3;
                    emojiInfo2.field_size = com.tencent.mm.a.e.cm(L);
                    emojiInfo2.field_temp = 1;
                    if (!bi.oW(this.gZe.field_activityid)) {
                        emojiInfo2.field_activityid = this.gZe.field_activityid;
                    }
                    emojiInfo2.field_designerID = this.gZe.field_designerID;
                    emojiInfo2.field_thumbUrl = this.gZe.field_thumbUrl;
                    Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.n(emojiInfo2);
                }
                emojiInfo = Zy;
            } else {
                Zy.field_designerID = this.gZe.field_designerID;
                Zy.field_thumbUrl = this.gZe.field_thumbUrl;
                emojiInfo = Zy;
            }
            for (String str : bi.F(bi.aG(stringExtra, "").split(","))) {
                if (emojiInfo != null) {
                    com.tencent.mm.plugin.emoji.model.i.aEw().a(str, emojiInfo, null);
                    if (!bi.oW(stringExtra2)) {
                        g.bcT().dF(stringExtra2, str);
                    }
                }
            }
            com.tencent.mm.ui.widget.snackbar.b.h(this, this.mController.tml.getString(R.l.finish_sent));
        }
    }

    private void eo(boolean z) {
        if (z) {
            setMMTitle(this.gZe.getName());
        }
        switch (this.type) {
            case 2:
                com.tencent.mm.ak.o.Pj().a(this.iox, this.ios);
                this.ior.setText(this.ioy);
                this.bVd = this.gZe.cnF();
                break;
            case 3:
                com.tencent.mm.ak.o.Pj().a(this.ioB, this.ios);
                this.ior.setText(this.designerName);
                this.bVd = this.gZe.cnF();
                break;
            case 4:
                this.ios.setVisibility(8);
                if (!bi.oW(this.ioA)) {
                    this.ior.setText(this.ioA);
                    break;
                } else {
                    this.ior.setText(R.l.search_emoji_network_source);
                    break;
                }
        }
        if (FileOp.cn(this.bVd)) {
            this.gVi.setVisibility(8);
            this.ioo.setVisibility(0);
            EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.gZe.Xh());
            if (Zy == null || (Zy.field_reserved4 & EmojiInfo.tcW) != EmojiInfo.tcW) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: no decrypt");
                this.ioo.setImageFilePath(this.bVd);
            } else {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "file exist: decrypt");
                this.ioo.g(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().a(Zy), "");
            }
            aGf();
            EmojiInfo Zy2 = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.gZe.Xh());
            if (Zy2 == null) {
                Zy = this.gZe;
            } else {
                Zy = Zy2;
            }
            if (Zy.field_catalog == EmojiInfo.tcH || bi.oW(Zy.field_groupId) || ((!bi.oW(Zy.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zl(Zy.field_groupId)) || this.type == 4)) {
                this.ioq.setEnabled(true);
            } else {
                String str = this.gZe.field_groupId;
                au.DF().a(423, this);
                au.DF().a(new com.tencent.mm.plugin.emoji.f.g(str, (byte) 0), 0);
            }
        } else if (z) {
            if (this.type == 4) {
                File file = new File(getCacheDir(), com.tencent.mm.a.g.u(this.gZe.field_encrypturl.getBytes()));
                if (file.exists()) {
                    this.gZe.field_md5 = com.tencent.mm.a.g.m(file);
                    au.HU();
                    String L = EmojiLogic.L(com.tencent.mm.model.c.Gg(), "", this.gZe.field_md5);
                    if (!FileOp.cn(L)) {
                        FileOp.y(file.getAbsolutePath(), L);
                    }
                    this.bVd = L;
                    eo(false);
                } else {
                    com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
                    aVar.dXy = true;
                    aVar.dXA = file.getAbsolutePath();
                    aVar.dYc = new Object[]{file.getAbsolutePath()};
                    com.tencent.mm.plugin.emoji.model.i.aDZ().a(this.gZe.field_encrypturl, null, aVar.Pt(), this.ioE);
                }
            } else {
                this.ioo.setVisibility(8);
                this.gVi.setVisibility(0);
                this.iop.setText(R.l.emoji_store_add_emoji);
                this.ioq.setText(R.l.retransmits);
                this.iop.setEnabled(false);
                this.ioq.setEnabled(false);
                com.tencent.mm.plugin.emoji.model.i.aEu().g(this.gZe);
            }
        }
        if (this.iou) {
            this.iop.setVisibility(8);
        }
    }

    private void aGf() {
        EmojiInfo Zy = com.tencent.mm.plugin.emoji.model.i.aEA().igx.Zy(this.gZe.Xh());
        if (Zy == null) {
            Zy = this.gZe;
        }
        if (Zy.field_catalog == EmojiGroupInfo.tcA) {
            this.iop.setEnabled(false);
            this.iop.setText(R.l.app_added);
            return;
        }
        this.iop.setText(R.l.emoji_store_add_emoji);
        if (com.tencent.mm.a.e.cn(this.bVd)) {
            this.iop.setEnabled(true);
        } else {
            this.iop.setEnabled(false);
        }
    }

    private boolean aGg() {
        if (bi.oW(this.ioC) || this.bJt != 1) {
            return false;
        }
        return true;
    }

    protected final int getLayoutId() {
        return R.i.fts_emoji_detail_page_ui;
    }

    protected void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.ioD);
        com.tencent.mm.plugin.emoji.model.i.aEu().ihj = null;
        super.onDestroy();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        if (lVar instanceof com.tencent.mm.plugin.emoji.f.g) {
            au.DF().b(423, this);
            com.tencent.mm.plugin.emoji.f.g gVar = (com.tencent.mm.plugin.emoji.f.g) lVar;
            if (gVar == null || bi.oW(gVar.iiv) || this.gZe == null || bi.oW(this.gZe.field_groupId) || !this.gZe.field_groupId.equalsIgnoreCase(gVar.iiv)) {
                x.i("MicroMsg.FTS.FTSEmojiDetailPageUI", "no the same product ID");
            } else if (i == 0 && i2 == 0) {
                this.ioq.setEnabled(true);
            } else {
                this.ioq.setEnabled(false);
            }
        }
    }
}
