package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ab.v;
import com.tencent.mm.g.a.iy;
import com.tencent.mm.g.a.kz;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.b;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.applet.m;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter;
import com.tencent.mm.pluginsdk.ui.chat.ChatFooter.d;
import com.tencent.mm.pluginsdk.ui.d.g;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aer;
import com.tencent.mm.protocal.c.aes;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ai;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.chatting.b.b.o;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Iterator;

public class AppBrandServiceChattingUI extends MMFragmentActivity {
    public a tGG;
    public ag tGH = new ag();

    @SuppressLint({"ValidFragment"})
    public static class a extends y {
        private com.tencent.mm.ui.appbrand.a appBrandServiceActionSheet;
        private String appId;
        private String fPo;
        private String fPp;
        private String fPq;
        private boolean fPr;
        private String fPs;
        private boolean fPt;
        private b frR;
        private int fromScene;
        private WxaExposedParams gvj;
        private String mSceneId;
        private boolean tGK;
        private String tGL = "";
        private c<kz> tGM;
        private final d tGN = new 1(this);
        private g tGO = new g() {
            public final Object a(m mVar) {
                switch (mVar.type) {
                    case 1:
                    case 25:
                    case a$k.AppCompatTheme_actionModeSplitBackground /*30*/:
                    case 31:
                        return a.this.bAG.getTalkerUserName();
                    default:
                        return null;
                }
            }

            public final Object b(m mVar) {
                if (mVar.type != 45) {
                    return null;
                }
                String str = new String(Base64.decode(mVar.url, 0));
                String str2 = new String(Base64.decode(bi.aG((String) mVar.F(String.class), ""), 0));
                x.d("MicroMsg.AppBrandServiceChattingUI", "appId:%s,path:%s", new Object[]{str, str2});
                if (a.this.fromScene == 2 && a.this.gvj.appId.equals(str)) {
                    x.i("MicroMsg.AppBrandServiceChattingUI", "onBackFromContact appId:%s path:%s", new Object[]{str, str2});
                    a.a(a.this, str2);
                    return Boolean.valueOf(true);
                }
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1081;
                ((com.tencent.mm.plugin.appbrand.n.d) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(a.this.getContext(), null, str, 0, 0, str2, appBrandStatObject);
                return null;
            }
        };
        private com.tencent.mm.ui.appbrand.c tGP;

        static /* synthetic */ void h(a aVar) {
            Bitmap a;
            com.tencent.mm.y.g.a aVar2 = new com.tencent.mm.y.g.a();
            aVar2.title = aVar.fPo;
            aVar2.type = 33;
            aVar2.dyS = aVar.gvj.username;
            aVar2.dyR = bi.oW(aVar.fPp) ? aVar.gvj.bVs : aVar.fPp;
            aVar2.dyT = aVar.gvj.appId;
            aVar2.dyZ = aVar.gvj.fih;
            aVar2.dza = aVar.gvj.fii;
            aVar2.dyV = aVar.gvj.fso;
            aVar2.dyU = 2;
            aVar2.url = aVar.gvj.fsp;
            aVar2.dzb = aVar.gvj.iconUrl;
            aVar2.bZM = "wxapp_" + aVar.gvj.appId + aVar.gvj.bVs;
            aVar2.bZG = aVar.gvj.username;
            aVar2.bZH = aVar.gvj.nickname;
            byte[] bArr = new byte[0];
            if (bi.oW(aVar.fPs)) {
                a = com.tencent.mm.modelappbrand.b.b.Ka().a(aVar.fPq, null);
            } else {
                a = com.tencent.mm.modelappbrand.b.b.Ka().a("file://" + aVar.fPs, null);
                if (a == null || a.isRecycled()) {
                    a = com.tencent.mm.sdk.platformtools.c.Wb(aVar.fPq);
                    if (aVar.fPt) {
                        boolean deleteFile = e.deleteFile(aVar.fPs);
                        x.v("MicroMsg.AppBrandServiceChattingUI", "decode thumb icon bitmap by path(%s), and deleted(%s) file.", new Object[]{aVar.fPq, Boolean.valueOf(deleteFile)});
                    }
                }
            }
            if (a == null || a.isRecycled()) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "thumb image is null");
            } else {
                x.i("MicroMsg.AppBrandServiceChattingUI", "thumb image is not null ");
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                a.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                bArr = byteArrayOutputStream.toByteArray();
            }
            l.a(aVar2, aVar.getAppId(), aVar.fPo, aVar.bAG.getTalkerUserName(), null, bArr);
        }

        public a(byte b) {
            super((byte) 0);
        }

        public final void csH() {
            super.csH();
            this.fromScene = getIntExtra("app_brand_chatting_from_scene", 1);
            String str = "app_brand_chatting_expose_params";
            Parcelable parcelable = null;
            if (this.isCurrentActivity && thisActivity() != null) {
                parcelable = thisActivity().getIntent().getParcelableExtra(str);
            }
            if (parcelable == null && getArguments() != null) {
                parcelable = super.getArguments().getParcelable(str);
            }
            this.gvj = (WxaExposedParams) parcelable;
            this.mSceneId = bi.oV(getStringExtra("key_scene_id"));
            this.fPo = getStringExtra("sendMessageTitle");
            this.fPp = getStringExtra("sendMessagePath");
            this.fPq = getStringExtra("sendMessageImg");
            this.fPs = getStringExtra("sendMessageLocalImg");
            this.fPr = getBooleanExtra("showMessageCard", false).booleanValue();
            this.fPt = getBooleanExtra("needDelThumb", false).booleanValue();
            x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate fromScene:%d", new Object[]{Integer.valueOf(this.fromScene)});
            x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onCreate wxaExposedParams:%s", new Object[]{this.gvj});
            x.i("MicroMsg.AppBrandServiceChattingUI", "mSceneId:%s, sendMessageTitle:%s, sendMessagePath:%s, sendMessageImg:%s, showMessageCard:%b, needDelThumb:%b", new Object[]{this.mSceneId, this.fPo, this.fPp, this.fPq, Boolean.valueOf(this.fPr), Boolean.valueOf(this.fPt)});
        }

        public final void csI() {
            super.csI();
            j.a(this.tGO);
            if (TextUtils.isEmpty(this.tGL)) {
                this.tGL = com.tencent.mm.ui.appbrand.b.ZW(com.tencent.mm.ui.appbrand.b.ZV(this.bAG.getTalkerUserName()));
            }
            if (TextUtils.isEmpty(this.tGL)) {
                setMMSubTitle(R.l.app_brand_service_sub_title);
            } else {
                setMMSubTitle(getResources().getString(R.l.app_brand_service_sub_title) + "-" + this.tGL);
            }
        }

        public final void cpM() {
            b bVar;
            boolean z;
            String str = null;
            super.cpM();
            ChatFooter cvb = ((com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class)).cvb();
            cvb.cei();
            cvb.cep();
            cvb.ceA();
            cvb.ceD();
            cvb.ceu();
            cvb.ceq();
            cvb.ces();
            cvb.cet();
            cvb.cer();
            cvb.ceu();
            cvb.ceq();
            cvb.ceC();
            cvb.un();
            cvb.cev();
            cvb.S(true, true);
            cvb.kP(true);
            cvb.kQ(true);
            cvb.cew();
            cvb.cex();
            cvb.cey();
            cvb.cet();
            cvb.cez();
            cvb.kO(com.tencent.mm.bg.d.cfH());
            Object talkerUserName = this.bAG.getTalkerUserName();
            if (TextUtils.isEmpty(talkerUserName)) {
                bVar = null;
            } else {
                WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(talkerUserName);
                if (rR != null) {
                    bVar = rR.aen();
                } else {
                    x.e("MicroMsg.AppBrandServiceHelper", "username:%s, attr is null or getWxaBizMenuByUsername return null", new Object[]{talkerUserName});
                    bVar = null;
                }
            }
            this.frR = bVar;
            if (this.frR != null && this.frR.frZ.size() == 1) {
                cvb = ((com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class)).cvb();
                cvb.setSwitchButtonMode(1);
                cvb.setOnFooterSwitchListener(this.tGN);
            } else if (this.frR == null || this.frR.frZ == null) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu or wxaBizMenu.buttonList is empty");
            } else {
                x.e("MicroMsg.AppBrandServiceChattingUI", "wxaBizMenu.buttonList.size():%d", new Object[]{Integer.valueOf(this.frR.frZ.size())});
            }
            WxaAttributes rR2 = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(this.bAG.getTalkerUserName());
            if (rR2 == null || (rR2.field_appOpt & 2) <= 0) {
                z = false;
            } else {
                z = true;
            }
            this.tGK = z;
            if (rR2 != null) {
                str = rR2.field_appId;
            }
            this.appId = str;
            if (this.tGK) {
                ((o) this.bAG.O(o.class)).Fa(0);
            } else {
                ((o) this.bAG.O(o.class)).Fa(8);
            }
            if (this.fromScene == 2) {
                String appId = getAppId();
                str = this.bAG.getTalkerUserName();
                int i = this.fromScene;
                au.HU();
                ai Yq = com.tencent.mm.model.c.FW().Yq(str);
                if (Yq == null) {
                    x.e("MicroMsg.AppBrandServiceChattingUI", "cvs:%s is null, error", new Object[]{str});
                } else {
                    int i2 = Yq.field_unReadCount;
                    String oV = bi.oV(this.mSceneId);
                    x.d("MicroMsg.AppBrandServiceChattingUI", "stev report(%s), appId : %s, scene %s, unReadCount %d, sceneId %s", new Object[]{Integer.valueOf(13799), appId, Integer.valueOf(i), Integer.valueOf(i2), oV});
                    h.mEJ.h(13799, new Object[]{appId, Integer.valueOf(i), Integer.valueOf(i2), oV, Long.valueOf(bi.VE())});
                }
            }
            this.appBrandServiceActionSheet = new com.tencent.mm.ui.appbrand.a(getContext());
            if (this.fromScene == 2) {
                au.DF().a(new com.tencent.mm.modelsimple.g(this.bAG.getTalkerUserName(), 19, getStringExtra("key_temp_session_from")), 0);
                x.i("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingFmUI onActivityCreated NetSceneEnterTempSession");
            }
            this.tGM = new 3(this);
            com.tencent.mm.sdk.b.a.sFg.b(this.tGM);
            setMMSubTitle(R.l.app_brand_service_sub_title);
            setMMTitle(this.bAG.cuz());
            if (this.tGK) {
                ((o) this.bAG.O(o.class)).Fa(0);
            } else {
                ((o) this.bAG.O(o.class)).Fa(8);
            }
            addIconOptionMenu(0, R.l.app_brand_notify_setting_title, R.g.mm_title_btn_menu, new 5(this));
            showOptionMenu(true);
            com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
            aVar.dIF = 2912;
            aVar.uri = "/cgi-bin/mmbiz-bin/wxabusiness/getkefusessioninfo";
            aVar.dII = 0;
            aVar.dIJ = 0;
            aer aer = new aer();
            String ZV = com.tencent.mm.ui.appbrand.b.ZV(this.bAG.getTalkerUserName());
            if (bi.oW(ZV)) {
                aer.bPS = getAppId();
                aer.rIG = "";
            } else {
                aer.bPS = com.tencent.mm.ui.appbrand.b.rW(ZV);
                aer.rIG = getAppId();
            }
            aVar.dIG = aer;
            aVar.dIH = new aes();
            v.a(aVar.KT(), new com.tencent.mm.ab.v.a() {
                public final int a(int i, int i2, String str, com.tencent.mm.ab.b bVar, com.tencent.mm.ab.l lVar) {
                    x.i("MicroMsg.AppBrandServiceChattingUI", "callback, errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
                    aes aes = (aes) bVar.dIE.dIL;
                    if (i == 0 && i2 == 0 && aes != null && aes.rIH != null) {
                        StringBuilder stringBuilder = new StringBuilder();
                        Iterator it = aes.rIH.iterator();
                        while (it.hasNext()) {
                            stringBuilder.append(((String) it.next()) + "|");
                        }
                        x.d("MicroMsg.AppBrandServiceChattingUI", "block_qr_prefix:%s, size:%d", new Object[]{stringBuilder.toString(), Integer.valueOf(aes.rIH.size())});
                        com.tencent.mm.kernel.g.Ei().DT().a(com.tencent.mm.storage.aa.a.sTZ, stringBuilder.toString());
                    }
                    return 0;
                }
            });
        }

        private String getAppId() {
            if (bi.oW(this.appId)) {
                WxaAttributes rR = ((com.tencent.mm.plugin.appbrand.n.c) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.appbrand.n.c.class)).rR(this.bAG.getTalkerUserName());
                this.appId = rR == null ? null : rR.field_appId;
            }
            if (bi.oW(this.appId)) {
                x.e("MicroMsg.AppBrandServiceChattingUI", "error, appId is null");
            }
            return this.appId;
        }

        protected final void csJ() {
            super.csJ();
            iy iyVar = new iy();
            iyVar.bSB.bSv = 0;
            iyVar.bSB.aem = w.chP();
            if (s.fq(this.bAG.getTalkerUserName())) {
                iyVar.bSB.bSD = true;
            } else {
                iyVar.bSB.bSD = false;
            }
            com.tencent.mm.sdk.b.a.sFg.m(iyVar);
        }

        public final void onViewAttachedToWindow(View view) {
            super.onViewAttachedToWindow(view);
            if (this.fromScene == 2 && this.fPr) {
                if (this.tGP == null) {
                    ChatFooter cvb = ((com.tencent.mm.ui.chatting.b.b.m) this.bAG.O(com.tencent.mm.ui.chatting.b.b.m.class)).cvb();
                    this.tGP = new com.tencent.mm.ui.appbrand.c(getActivity(), cvb.getRootView(), cvb, !bi.oW(cvb.getLastText()));
                    this.tGP.qMR = false;
                }
                if (bi.oW(this.fPs)) {
                    com.tencent.mm.modelappbrand.b.b.Ka().a(this.tGP, this.fPq, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.g.class)).bc((int) Cm(75), (int) Cm(60)));
                } else {
                    com.tencent.mm.modelappbrand.b.b.Ka().a(this.tGP, "file://" + this.fPs, null, ((com.tencent.mm.modelappbrand.g) com.tencent.mm.kernel.g.l(com.tencent.mm.modelappbrand.g.class)).bc((int) Cm(75), (int) Cm(60)));
                }
                this.tGP.trm = new 7(this);
                com.tencent.mm.ui.appbrand.c cVar = this.tGP;
                x.d("MicroMsg.AppBrandServiceImageBubble", "show");
                au.Em().H(new c$4(cVar));
            }
        }

        private float Cm(int i) {
            return TypedValue.applyDimension(1, (float) i, getContext().getResources().getDisplayMetrics());
        }

        public final void csK() {
            super.csK();
            j.b(this.tGO);
        }

        public final void bw() {
            super.bw();
            com.tencent.mm.sdk.b.a.sFg.c(this.tGM);
        }
    }

    protected void onCreate(Bundle bundle) {
        getWindow().setFormat(-2);
        com.tencent.mm.pluginsdk.e.N(this);
        overridePendingTransition(0, 0);
        super.onCreate(null);
        if (getIntent().getStringExtra("Chat_User") == null) {
            finish();
            x.e("MicroMsg.AppBrandServiceChattingUI", "talker is null !!!");
            return;
        }
        setContentView(R.i.chattingui_activity_container);
        this.tGG = new a((byte) 0);
        Bundle extras = getIntent().getExtras();
        extras.putBoolean("FROM_APP_BRAND_CHATTING_ACTIVITY", true);
        this.tGG.setArguments(extras);
        getSupportFragmentManager().bk().a(R.h.mm_root_view, this.tGG).commit();
        getSupportActionBar().show();
        if (getIntent().getBooleanExtra("resend_fail_messages", false)) {
            ah.i(new 1(this), 500);
            getIntent().putExtra("is_need_resend_sns", false);
        }
        com.tencent.mm.permission.a.Vj().Vk();
        initNavigationSwipeBack();
        this.tGH.post(new 2(this));
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        x.d("MicroMsg.AppBrandServiceChattingUI", "AppBrandServiceChattingUI dispatch key event %s", new Object[]{keyEvent});
        if (this.tGG == null || !this.tGG.onKeyDown(keyEvent.getKeyCode(), keyEvent)) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }
}
