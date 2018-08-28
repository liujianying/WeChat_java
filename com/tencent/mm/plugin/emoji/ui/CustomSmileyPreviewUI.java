package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.j;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.pluginsdk.ui.emoji.MMEmojiView;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.acz;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.a.d;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CustomSmileyPreviewUI extends MMActivity implements OnItemClickListener, e, a, b {
    private ListView CU;
    private final String TAG = "MicroMsg.emoji.CustomSmileyPreviewUI";
    private String bKk;
    private EmojiInfo gZe;
    private c ikA = new 3(this);
    private g ikB;
    f ikI;
    private View ikJ;
    private ImageView ikK;
    private TextView ikL;
    private TextView ikM;
    private act ikN;
    private to ikO = new to();
    private String ikP;
    private TextView ikQ;
    private h ikR;
    private acz ikS;
    private final int ikT = 131077;
    private long ikU;
    String ikV;
    private String ikW;
    private c ikX = new c<oc>() {
        {
            this.sFo = oc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.b.b bVar) {
            oc ocVar = (oc) bVar;
            if (CustomSmileyPreviewUI.this.ikU != 0 && ocVar.bYY.bZb == CustomSmileyPreviewUI.this.ikU) {
                x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "msg is revoked.");
                com.tencent.mm.ui.base.h.a(CustomSmileyPreviewUI.this.mController.tml, ocVar.bYY.bYZ, "", CustomSmileyPreviewUI.this.getString(R.l.chatting_revoke_msg_dialog_confirm), false, new 1(this));
            }
            return false;
        }
    };
    protected final int ikp = 131074;
    private final int ikq = 131075;
    private final int ikr = 131076;
    private final String iks = "product_id";
    private final String ikt = "progress";
    private final String iku = "status";
    ag mHandler = new 1(this);

    static /* synthetic */ void f(CustomSmileyPreviewUI customSmileyPreviewUI) {
        customSmileyPreviewUI.gZe = i.aEA().igx.Zy(customSmileyPreviewUI.gZe.Xh());
        d dVar = new d(customSmileyPreviewUI, 1, false);
        dVar.ofp = new n.c() {
            public final void a(l lVar) {
                if (!(CustomSmileyPreviewUI.this.gZe.field_catalog == EmojiInfo.tcH || CustomSmileyPreviewUI.this.gZe.cny())) {
                    lVar.eR(0, R.l.add_to_custom_smiley);
                }
                if (CustomSmileyPreviewUI.this.gZe.field_catalog == EmojiInfo.tcH || bi.oW(CustomSmileyPreviewUI.this.gZe.field_groupId) || (!bi.oW(CustomSmileyPreviewUI.this.gZe.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zl(CustomSmileyPreviewUI.this.gZe.field_groupId))) {
                    lVar.eR(1, R.l.retransmits);
                }
                lVar.eR(2, R.l.emoji_expose);
            }
        };
        dVar.ofq = new 2(customSmileyPreviewUI);
        dVar.bXO();
    }

    static /* synthetic */ void n(CustomSmileyPreviewUI customSmileyPreviewUI) {
        String stringExtra = customSmileyPreviewUI.getIntent().getStringExtra("custom_smiley_preview_md5");
        int intExtra = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_CompressType", 0);
        int intExtra2 = customSmileyPreviewUI.getIntent().getIntExtra("CropImage_Msg_Id", -1);
        Intent intent = new Intent();
        intent.putExtra("Retr_File_Name", stringExtra);
        intent.putExtra("Retr_Msg_Id", intExtra2);
        intent.putExtra("Retr_Msg_Type", 5);
        intent.putExtra("Retr_Compress_Type", intExtra);
        com.tencent.mm.plugin.emoji.b.ezn.l(intent, customSmileyPreviewUI);
        com.tencent.mm.plugin.report.service.h.mEJ.h(12789, new Object[]{Integer.valueOf(1), customSmileyPreviewUI.gZe.Xh(), Integer.valueOf(1), customSmileyPreviewUI.gZe.field_designerID, customSmileyPreviewUI.gZe.field_groupId, customSmileyPreviewUI.ikV, "", "", "", customSmileyPreviewUI.gZe.field_activityid});
    }

    static /* synthetic */ void o(CustomSmileyPreviewUI customSmileyPreviewUI) {
        Intent intent = new Intent();
        ArrayList arrayList = new ArrayList();
        arrayList.add(customSmileyPreviewUI.ikW);
        intent.putStringArrayListExtra("k_outside_expose_proof_item_list", arrayList);
        intent.putExtra("k_username", customSmileyPreviewUI.ikV);
        intent.putExtra("k_expose_msg_id", customSmileyPreviewUI.ikU);
        intent.putExtra("k_expose_msg_type", 47);
        intent.putExtra("showShare", false);
        intent.putExtra("rawUrl", String.format("https://weixin110.qq.com/security/readtemplate?t=weixin_report/w_type&scene=%d#wechat_redirect", new Object[]{Integer.valueOf(51)}));
        com.tencent.mm.bg.d.b(customSmileyPreviewUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    protected final int getLayoutId() {
        return R.i.custom_smiley_preview;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        au.DF().a(412, this);
        au.DF().a(521, this);
        au.DF().a(411, this);
        au.DF().a(239, this);
        au.DF().a(368, this);
        com.tencent.mm.sdk.b.a.sFg.b(this.ikA);
        com.tencent.mm.sdk.b.a.sFg.b(this.ikX);
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    public void onStart() {
        super.onStart();
    }

    public void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        au.DF().b(412, this);
        au.DF().b(521, this);
        au.DF().b(411, this);
        au.DF().b(239, this);
        au.DF().b(368, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.ikA);
        com.tencent.mm.sdk.b.a.sFg.c(this.ikX);
        super.onDestroy();
    }

    protected final void initView() {
        setMMTitle("");
        String stringExtra = getIntent().getStringExtra("custom_smiley_preview_md5");
        this.ikU = getIntent().getLongExtra("msg_id", 0);
        this.ikV = getIntent().getStringExtra("msg_sender");
        this.ikW = getIntent().getStringExtra("msg_content");
        x.d("MicroMsg.emoji.CustomSmileyPreviewUI", "[initView] md5:%s", new Object[]{stringExtra});
        Object oV = bi.oV(stringExtra);
        if (TextUtils.isEmpty(oV)) {
            x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail md5 is fail");
            finish();
        }
        this.ikQ = (TextView) findViewById(R.h.custom_smiley_emoji_desc);
        MMEmojiView mMEmojiView = (MMEmojiView) findViewById(R.h.custom_smiley_preview_emojiview);
        if (com.tencent.mm.sdk.a.b.chp()) {
            mMEmojiView.setOnClickListener(new 5(this, mMEmojiView));
        }
        if (mMEmojiView == null) {
            x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "CustomSmileyPreviewUI ini fail emojiView is null.");
            finish();
            return;
        }
        String str;
        String str2;
        boolean z;
        com.tencent.mm.plugin.report.service.h hVar;
        Object[] objArr;
        this.gZe = i.aEA().igx.Zy(oV);
        if (this.gZe.cny()) {
            InputStream bt = EmojiInfo.bt(this, this.gZe.getName());
            if (bt != null) {
                mMEmojiView.a(bt, this.gZe.getName());
            } else {
                str = "MicroMsg.emoji.CustomSmileyPreviewUI";
                str2 = "input stream is null. emoji name is:%s";
                Object[] objArr2 = new Object[1];
                objArr2[0] = this.gZe == null ? "null" : this.gZe.getName();
                x.e(str, str2, objArr2);
            }
        } else {
            mMEmojiView.a(this.gZe, "");
            if (!(this.gZe == null || this.gZe.cnE())) {
                com.tencent.mm.plugin.emoji.e.c.aDJ();
                com.tencent.mm.plugin.emoji.e.c.a(this.gZe, true);
            }
        }
        CharSequence zf = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zf(this.gZe.Xh());
        if (!(this.ikQ == null || bi.oW(zf))) {
            this.ikQ.setText(zf);
            mMEmojiView.setContentDescription(zf);
        }
        str2 = getIntent().getStringExtra("custom_smiley_preview_appid");
        String stringExtra2 = getIntent().getStringExtra("custom_smiley_preview_appname");
        TextView textView = (TextView) findViewById(R.h.appsource);
        com.tencent.mm.pluginsdk.model.app.f bl = com.tencent.mm.pluginsdk.model.app.g.bl(str2, true);
        str = (bl == null || bl.field_appName == null || bl.field_appName.trim().length() <= 0) ? stringExtra2 : bl.field_appName;
        if (str2 != null && str2.length() > 0) {
            if (str == null || str.trim().length() == 0 || str.equals("weixinfile") || str.equals("invalid_appname")) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                textView.setText(getString(R.l.chatting_source_from, new Object[]{com.tencent.mm.pluginsdk.model.app.g.b(this.mController.tml, bl, str)}));
                textView.setVisibility(0);
                com.tencent.mm.pluginsdk.ui.chat.l.b bVar = new com.tencent.mm.pluginsdk.ui.chat.l.b();
                bVar.appId = str2;
                bVar.bXS = "message";
                textView.setTag(bVar);
                textView.setOnClickListener(new com.tencent.mm.pluginsdk.ui.chat.l(this));
                Bitmap b = com.tencent.mm.pluginsdk.model.app.g.b(str2, 2, com.tencent.mm.bp.a.getDensity(this));
                if (b == null || b.isRecycled()) {
                    a(this, textView, BitmapFactory.decodeResource(getResources(), R.g.nosdcard_watermark_icon));
                } else {
                    a(this, textView, b);
                }
                setBackBtn(new 6(this));
                if (this.gZe.field_catalog != EmojiInfo.tcH || this.gZe.cny()) {
                    z = false;
                } else {
                    z = true;
                }
                if (this.gZe.field_catalog == EmojiInfo.tcH || bi.oW(this.gZe.field_groupId) || (!bi.oW(this.gZe.field_groupId) && ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.n(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().zl(this.gZe.field_groupId))) {
                    z = true;
                }
                addIconOptionMenu(0, R.g.mm_title_btn_menu, new OnMenuItemClickListener() {
                    public final boolean onMenuItemClick(MenuItem menuItem) {
                        CustomSmileyPreviewUI.f(CustomSmileyPreviewUI.this);
                        return true;
                    }
                });
                showOptionMenu(z);
                this.ikJ = findViewById(R.h.designer_bar_container);
                this.ikK = (ImageView) this.ikJ.findViewById(R.h.designer_icon);
                this.ikL = (TextView) this.ikJ.findViewById(R.h.designer_title);
                this.ikM = (TextView) this.ikJ.findViewById(R.h.designer_detail);
                this.ikJ.setVisibility(8);
                if (!(this.gZe == null || bi.oW(this.gZe.field_designerID))) {
                    this.ikN = i.aEA().igD.ZC(this.gZe.field_designerID);
                    au.DF().a(new com.tencent.mm.plugin.emoji.f.i(this.gZe.field_designerID), 0);
                }
                if (!(this.gZe == null || bi.oW(this.gZe.field_activityid))) {
                    this.ikS = i.aEA().igA.ZI(this.gZe.field_activityid);
                    stringExtra = this.gZe.field_activityid;
                    stringExtra2 = this.gZe.field_md5;
                    if (this.ikS == null && (this.ikS == null || this.ikS.rHt == null || ((long) this.ikS.rHt.rwD) >= System.currentTimeMillis() / 1000)) {
                        x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "no need to load emoji activity");
                    } else {
                        au.DF().a(new j(stringExtra, stringExtra2), 0);
                    }
                }
                aFx();
                this.ikJ.setOnClickListener(new 8(this));
                hVar = com.tencent.mm.plugin.report.service.h.mEJ;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(2);
                objArr[1] = this.bKk;
                objArr[2] = oV;
                if (this.gZe != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.gZe.field_designerID;
                }
                objArr[3] = stringExtra;
                if (this.gZe != null) {
                    stringExtra = "";
                } else {
                    stringExtra = this.gZe.field_activityid;
                }
                objArr[4] = stringExtra;
                hVar.h(12067, objArr);
            }
        }
        textView.setVisibility(8);
        this.bKk = this.gZe.field_groupId;
        au.DF().a(new k(this.bKk), 0);
        this.CU = (ListView) findViewById(16908298);
        this.ikI = new f(this.mController.tml);
        this.ikI.ieo = this;
        this.ikI.idH = true;
        this.ikI.idK = false;
        this.CU.setOnItemClickListener(this);
        this.CU.setAdapter(this.ikI);
        this.ikI.iem = this.CU;
        if (!bi.oW(this.bKk)) {
            com.tencent.mm.storage.emotion.i ZE = i.aEA().igB.ZE(this.bKk);
            if (!(ZE == null || ZE.field_content == null)) {
                add add = new add();
                try {
                    add.aG(ZE.field_content);
                    this.ikO = add.rHx;
                    this.ikP = ZE.field_lan;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.CustomSmileyPreviewUI", "exception:%s", new Object[]{bi.i(e)});
                }
            }
            if (this.ikO == null || bi.oW(this.ikP) || !this.ikP.equalsIgnoreCase(w.fD(this.mController.tml))) {
                au.DF().a(new com.tencent.mm.plugin.emoji.f.l(this.bKk, 1), 0);
            } else {
                com.tencent.mm.plugin.emoji.a.a.c aFy = aFy();
                if (this.ikI != null) {
                    this.ikI.a(aFy);
                }
                au.DF().a(new com.tencent.mm.plugin.emoji.f.l(this.bKk, 1, this.ikO.hcD), 0);
            }
        }
        this.ikR = new h();
        this.ikR.gKE = this;
        this.ikR.ihz = this.ikI;
        this.ikR.ihC = 9;
        this.ikR.ihF = this;
        a(this.bKk, this.gZe);
        setBackBtn(new 6(this));
        if (this.gZe.field_catalog != EmojiInfo.tcH) {
        }
        z = false;
        z = true;
        addIconOptionMenu(0, R.g.mm_title_btn_menu, /* anonymous class already generated */);
        showOptionMenu(z);
        this.ikJ = findViewById(R.h.designer_bar_container);
        this.ikK = (ImageView) this.ikJ.findViewById(R.h.designer_icon);
        this.ikL = (TextView) this.ikJ.findViewById(R.h.designer_title);
        this.ikM = (TextView) this.ikJ.findViewById(R.h.designer_detail);
        this.ikJ.setVisibility(8);
        this.ikN = i.aEA().igD.ZC(this.gZe.field_designerID);
        au.DF().a(new com.tencent.mm.plugin.emoji.f.i(this.gZe.field_designerID), 0);
        this.ikS = i.aEA().igA.ZI(this.gZe.field_activityid);
        stringExtra = this.gZe.field_activityid;
        stringExtra2 = this.gZe.field_md5;
        if (this.ikS == null) {
        }
        au.DF().a(new j(stringExtra, stringExtra2), 0);
        aFx();
        this.ikJ.setOnClickListener(new 8(this));
        hVar = com.tencent.mm.plugin.report.service.h.mEJ;
        objArr = new Object[5];
        objArr[0] = Integer.valueOf(2);
        objArr[1] = this.bKk;
        objArr[2] = oV;
        if (this.gZe != null) {
            stringExtra = this.gZe.field_designerID;
        } else {
            stringExtra = "";
        }
        objArr[3] = stringExtra;
        if (this.gZe != null) {
            stringExtra = this.gZe.field_activityid;
        } else {
            stringExtra = "";
        }
        objArr[4] = stringExtra;
        hVar.h(12067, objArr);
    }

    private void aFx() {
        this.mHandler.post(new 9(this));
    }

    private static void a(CustomSmileyPreviewUI customSmileyPreviewUI, TextView textView, Bitmap bitmap) {
        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
        int dimension = (int) customSmileyPreviewUI.getResources().getDimension(R.f.HintTextSize);
        bitmapDrawable.setBounds(0, 0, dimension, dimension);
        textView.setCompoundDrawables(bitmapDrawable, null, null, null);
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        switch (lVar.getType()) {
            case 239:
                this.ikN = ((com.tencent.mm.plugin.emoji.f.i) lVar).aEM();
                aFx();
                return;
            case 368:
                if (i2 == 0) {
                    j jVar = (j) lVar;
                    acz acz = (acz) jVar.diG.dIE.dIL;
                    if (!(acz == null || acz.rHt == null)) {
                        acz.rHt.rwD = ((int) (System.currentTimeMillis() / 1000)) + acz.rHt.rwD;
                        i.aEA().igA.a(jVar.iiI, acz);
                    }
                    this.ikS = acz;
                    aFx();
                    return;
                }
                x.w("MicroMsg.emoji.CustomSmileyPreviewUI", "get activity failed.");
                return;
            case 411:
                i.aEA().igA.a(12, ((com.tencent.mm.plugin.emoji.f.n) lVar).aEQ());
                return;
            case 412:
                com.tencent.mm.plugin.emoji.f.l lVar2 = (com.tencent.mm.plugin.emoji.f.l) lVar;
                String str2;
                String str3;
                Object[] objArr;
                com.tencent.mm.plugin.emoji.a.a.c aFy;
                if (i == 0) {
                    if (i2 == 0) {
                        this.ikO = lVar2.aEO();
                        if (this.ikO == null || TextUtils.isEmpty(this.bKk) || !this.bKk.equals(this.ikO.rem)) {
                            str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                            str3 = "[onSceneEnd no same product id] cureent:%s,scene:%s";
                            objArr = new Object[2];
                            objArr[0] = this.bKk;
                            objArr[1] = this.ikO == null ? "" : this.ikO.rem;
                            x.i(str2, str3, objArr);
                            return;
                        }
                        aFy = aFy();
                        if (this.ikI != null) {
                            this.ikI.a(aFy);
                        }
                        this.mHandler.sendEmptyMessage(0);
                        x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.ikO.rem);
                        return;
                    } else if (i2 != 1) {
                        return;
                    } else {
                        return;
                    }
                } else if (i2 != 5) {
                    return;
                } else {
                    if (this.ikO == null || lVar2.aEO() == null || TextUtils.isEmpty(this.bKk) || !this.bKk.equals(this.ikO.rem) || this.ikO.rwV == lVar2.aEO().rwV) {
                        str2 = "MicroMsg.emoji.CustomSmileyPreviewUI";
                        str3 = "[onSceneEnd no same product id or PackFlag is same.] cureent:%s,scene:%s";
                        objArr = new Object[2];
                        objArr[0] = this.bKk;
                        objArr[1] = this.ikO == null ? "" : this.ikO.rem;
                        x.i(str2, str3, objArr);
                        return;
                    }
                    this.ikO.rwV = lVar2.aEO().rwV;
                    aFy = aFy();
                    if (this.ikI != null) {
                        this.ikI.a(aFy);
                    }
                    this.mHandler.sendEmptyMessage(0);
                    x.i("MicroMsg.emoji.CustomSmileyPreviewUI", "[onSceneEnd]" + this.ikO.rem);
                    return;
                }
            case 521:
                if (i2 == 0) {
                    this.mHandler.sendEmptyMessage(2);
                    this.mHandler.sendEmptyMessageDelayed(131077, 500);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private com.tencent.mm.plugin.emoji.a.a.c aFy() {
        List arrayList = new ArrayList();
        ts tsVar = new ts();
        tsVar.rwY = this.ikO.rwY;
        tsVar.jPG = this.ikO.jPG;
        tsVar.rwQ = this.ikO.rwQ;
        tsVar.rwV = this.ikO.rwV;
        tsVar.rwR = this.ikO.rwR;
        tsVar.rwZ = this.ikO.rwZ;
        tsVar.rwU = this.ikO.rwU;
        tsVar.rwT = this.ikO.rwT;
        tsVar.rxb = this.ikO.rxb;
        tsVar.rxc = this.ikO.rxc;
        tsVar.rem = this.ikO.rem;
        arrayList.add(new com.tencent.mm.plugin.emoji.a.a.f(tsVar));
        return new com.tencent.mm.plugin.emoji.a.a.c(arrayList);
    }

    private void a(String str, EmojiInfo emojiInfo) {
        if (!bi.oW(str) && emojiInfo != null) {
            if (!bi.oW(str) && emojiInfo.field_catalog != EmojiGroupInfo.tcz && emojiInfo.field_catalog != EmojiGroupInfo.tcy && ((emojiInfo.field_type != EmojiInfo.tcL || emojiInfo.field_type != EmojiInfo.tcM) && i.aEA().igz.Zv(str))) {
                if (this.CU != null) {
                    this.CU.setVisibility(0);
                }
                if (this.ikI == null) {
                    return;
                }
                if (i.aEA().igz.Zw(str)) {
                    this.ikI.idI = true;
                } else {
                    this.ikI.idI = false;
                }
            } else if (this.CU != null) {
                this.CU.setVisibility(8);
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.CustomSmileyPreviewUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.aDq()) ? "" : aVar.aDq();
        objArr[2] = Integer.valueOf(aVar.aDp());
        x.i(str, str2, objArr);
        this.ikR.a(aVar);
    }

    public final void M(String str, String str2, String str3) {
        this.ikB = new g(str, str2, str3);
        au.DF().a(this.ikB, 0);
    }

    public final void aEs() {
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.ikI != null && i >= 0 && i < this.ikI.getCount()) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.ikI.oG(i);
            Intent intent = new Intent();
            intent.setClass(this, EmojiStoreDetailUI.class);
            ts tsVar = oG.iez;
            if (tsVar == null) {
                intent = null;
            } else {
                intent.putExtra("extra_id", tsVar.rem);
                intent.putExtra("extra_name", tsVar.rwQ);
                intent.putExtra("extra_copyright", tsVar.rxa);
                intent.putExtra("extra_coverurl", tsVar.rwY);
                intent.putExtra("extra_description", tsVar.rwR);
                intent.putExtra("extra_price", tsVar.rwT);
                intent.putExtra("extra_type", tsVar.rwU);
                intent.putExtra("extra_flag", tsVar.rwV);
                intent.putExtra("preceding_scence", 4);
                intent.putExtra("call_by", 1);
                intent.putExtra("download_entrance_scene", 9);
                intent.putExtra("check_clickflag", true);
                intent.putExtra("extra_status", oG.mStatus);
                intent.putExtra("extra_progress", oG.pF);
                String stringExtra = getIntent().getStringExtra("to_talker_name");
                if (!bi.oW(stringExtra)) {
                    intent.putExtra("to_talker_name", stringExtra);
                }
            }
            startActivity(intent);
        }
    }
}
