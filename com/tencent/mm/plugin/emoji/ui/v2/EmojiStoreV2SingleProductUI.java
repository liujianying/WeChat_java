package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.e.k;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.acr;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMTagPanel;
import com.tencent.mm.ui.contact.LabelContainerView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreV2SingleProductUI extends MMActivity implements OnScrollListener, e {
    private View Iq;
    private boolean acT = false;
    private String cYO;
    private ProgressDialog eEX;
    private int fdx;
    private long ihD;
    private String iiF;
    private String iiH;
    private i ipA;
    private int ipa = 0;
    private MMPullDownView ipy;
    private int iqV;
    private String iqW;
    private int iqX = -1;
    private String iqY;
    private String iqZ;
    private String ira;
    private String irb;
    private String irc;
    private int ird = 0;
    private PreViewListGridView ire;
    private d irf;
    private View irg;
    private TextView irh;
    private View iri;
    private boolean irj = true;
    private acr irk;
    private byte[] irl;
    private int irm = -1;
    private String irn;
    private LabelContainerView iro;
    private TextView irp;
    private MMTagPanel irq;
    private HashMap<String, Integer> irr = new HashMap();
    private ArrayList<String> irs;
    private boolean irt = false;
    private c iru = new 6(this);
    private MMPullDownView.e irv = new 7(this);
    private MMPullDownView.c irw = new MMPullDownView.c() {
        public final boolean aCi() {
            return false;
        }
    };
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    if (EmojiStoreV2SingleProductUI.this.iri != null) {
                        EmojiStoreV2SingleProductUI.this.iri.setVisibility(8);
                        return;
                    }
                    return;
                case 1002:
                    if (EmojiStoreV2SingleProductUI.this.iri != null) {
                        EmojiStoreV2SingleProductUI.this.iri.setVisibility(0);
                    }
                    sendEmptyMessage(1003);
                    return;
                case 1004:
                    EmojiStoreV2SingleProductUI.this.Wj();
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void a(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI, String str) {
        emojiStoreV2SingleProductUI.setMMTitle(R.l.emoji_store_product_title);
        emojiStoreV2SingleProductUI.showOptionMenu(1001, emojiStoreV2SingleProductUI.irj);
        if (emojiStoreV2SingleProductUI.irr == null || !emojiStoreV2SingleProductUI.irr.containsKey(str)) {
            emojiStoreV2SingleProductUI.irl = null;
            emojiStoreV2SingleProductUI.irm = -1;
            emojiStoreV2SingleProductUI.irn = emojiStoreV2SingleProductUI.getString(R.l.emoji_store_tag_all);
            emojiStoreV2SingleProductUI.ird = 1;
            emojiStoreV2SingleProductUI.iqV = 0;
            emojiStoreV2SingleProductUI.an(emojiStoreV2SingleProductUI.irl);
            emojiStoreV2SingleProductUI.zN("");
        } else {
            emojiStoreV2SingleProductUI.irm = -1;
            emojiStoreV2SingleProductUI.irn = str;
            emojiStoreV2SingleProductUI.ird = 4;
            emojiStoreV2SingleProductUI.iqV = ((Integer) emojiStoreV2SingleProductUI.irr.get(emojiStoreV2SingleProductUI.irn)).intValue();
            emojiStoreV2SingleProductUI.an(null);
            emojiStoreV2SingleProductUI.zN(str);
        }
        if (emojiStoreV2SingleProductUI.iro != null) {
            emojiStoreV2SingleProductUI.iro.setVisibility(8);
        }
    }

    static /* synthetic */ void o(EmojiStoreV2SingleProductUI emojiStoreV2SingleProductUI) {
        d dVar = new d(emojiStoreV2SingleProductUI.mController.tml, 1, false);
        dVar.ofp = new 4(emojiStoreV2SingleProductUI);
        dVar.ofq = new 5(emojiStoreV2SingleProductUI);
        dVar.bXO();
        h.mEJ.h(13224, new Object[]{Integer.valueOf(2), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2SingleProductUI.iqX)});
    }

    protected final int getLayoutId() {
        return R.i.emoji_store_v2_single_product_ui;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
        r9 = this;
        r8 = 4;
        r7 = 3;
        r6 = 2;
        r1 = 1;
        r2 = 0;
        super.onCreate(r10);
        r0 = r9.getIntent();
        r3 = "uin";
        r0 = r0.getIntExtra(r3, r2);
        r9.ipa = r0;
        r0 = r9.getIntent();
        r3 = "Select_Conv_User";
        r0 = r0.getStringExtra(r3);
        r9.cYO = r0;
        r0 = r9.getIntent();
        r3 = "searchID";
        r4 = 0;
        r4 = r0.getLongExtra(r3, r4);
        r9.ihD = r4;
        r0 = r9.getIntent();
        r3 = "id";
        r0 = r0.getStringExtra(r3);
        r9.iiH = r0;
        r0 = r9.getIntent();
        r3 = "tag_id";
        r0 = r0.getStringExtra(r3);
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r3 != 0) goto L_0x0059;
    L_0x004f:
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Exception -> 0x01a3 }
        r0 = r0.intValue();	 Catch:{ Exception -> 0x01a3 }
        r9.iqV = r0;	 Catch:{ Exception -> 0x01a3 }
    L_0x0059:
        r0 = r9.getIntent();
        r3 = "tag_desc";
        r0 = r0.getStringExtra(r3);
        r9.iqW = r0;
        r0 = r9.getIntent();
        r3 = "keyword";
        r0 = r0.getStringExtra(r3);
        r9.iiF = r0;
        r0 = r9.getIntent();
        r3 = "set_id";
        r0 = r0.getIntExtra(r3, r2);
        r9.iqX = r0;
        r0 = r9.getIntent();
        r3 = "set_title";
        r0 = r0.getStringExtra(r3);
        r9.iqY = r0;
        r0 = r9.getIntent();
        r3 = "set_iconURL";
        r0 = r0.getStringExtra(r3);
        r9.iqZ = r0;
        r0 = r9.getIntent();
        r3 = "set_desc";
        r0 = r0.getStringExtra(r3);
        r9.ira = r0;
        r0 = r9.getIntent();
        r3 = "headurl";
        r0 = r0.getStringExtra(r3);
        r9.irb = r0;
        r0 = r9.getIntent();
        r3 = "sns_object_data";
        r0 = r0.getStringExtra(r3);
        r9.irc = r0;
        r0 = r9.getIntent();
        r3 = "pageType";
        r0 = r0.getIntExtra(r3, r2);
        r9.ird = r0;
        r0 = r9.irc;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x0106;
    L_0x00d6:
        r0 = r9.irc;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.zw(r0);
        r9.iqX = r0;
        r0 = r9.irc;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.zx(r0);
        r9.iqY = r0;
        r0 = r9.irc;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.zz(r0);
        r9.iqZ = r0;
        r0 = r9.irc;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.zy(r0);
        r9.ira = r0;
        r0 = r9.irc;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.zA(r0);
        r9.irb = r0;
        r0 = r9.irc;
        r0 = com.tencent.mm.plugin.emoji.model.EmojiLogic.zB(r0);
        r9.ird = r0;
    L_0x0106:
        r0 = r9.ird;
        switch(r0) {
            case 0: goto L_0x01b0;
            case 1: goto L_0x01f4;
            case 2: goto L_0x01f8;
            case 3: goto L_0x0202;
            case 4: goto L_0x0208;
            case 5: goto L_0x020e;
            case 6: goto L_0x0218;
            default: goto L_0x010b;
        };
    L_0x010b:
        r9.irt = r1;
    L_0x010d:
        r0 = r9.irt;
        if (r0 == 0) goto L_0x0134;
    L_0x0111:
        r0 = new android.content.Intent;
        r0.<init>();
        r3 = "rawUrl";
        com.tencent.mm.plugin.emoji.model.i.aEw();
        r4 = "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0";
        r0.putExtra(r3, r4);
        r3 = "showShare";
        r0.putExtra(r3, r2);
        r3 = "webview";
        r4 = "com.tencent.mm.plugin.webview.ui.tools.WebViewUI";
        com.tencent.mm.bg.d.b(r9, r3, r4, r0);
        r9.finish();
    L_0x0134:
        r9.initView();
        r0 = r9.ipa;
        if (r0 != 0) goto L_0x017a;
    L_0x013b:
        r0 = r9.ird;
        if (r0 != r6) goto L_0x017a;
    L_0x013f:
        r0 = com.tencent.mm.plugin.emoji.model.i.aEA();
        r0 = r0.igD;
        r3 = r9.iiH;
        r0 = r0.ZC(r3);
        if (r0 == 0) goto L_0x021e;
    L_0x014d:
        r3 = r0.rHp;
        if (r3 == 0) goto L_0x021e;
    L_0x0151:
        r3 = r0.rHp;
        r3 = r3.rHi;
        if (r3 == 0) goto L_0x021e;
    L_0x0157:
        r3 = r0.rHp;
        r3 = r3.jPe;
        r3 = com.tencent.mm.sdk.platformtools.bi.oW(r3);
        if (r3 != 0) goto L_0x021e;
    L_0x0161:
        r0 = r0.rHp;
        r0 = r0.rHi;
        r9.ipa = r0;
        r0 = "MicroMsg.emoji.EmojiStoreV2SingleProductUI";
        r3 = "uin:%s ";
        r1 = new java.lang.Object[r1];
        r4 = r9.ipa;
        r4 = java.lang.Integer.valueOf(r4);
        r1[r2] = r4;
        com.tencent.mm.sdk.platformtools.x.i(r0, r3, r1);
    L_0x017a:
        r0 = r2;
    L_0x017b:
        if (r0 != 0) goto L_0x0221;
    L_0x017d:
        r9.Wj();
    L_0x0180:
        com.tencent.mm.model.au.HU();
        r0 = com.tencent.mm.model.c.DT();
        r1 = com.tencent.mm.storage.aa.a.sPa;
        r2 = java.lang.Boolean.valueOf(r2);
        r0.a(r1, r2);
        r0 = com.tencent.mm.model.au.DF();
        r1 = 821; // 0x335 float:1.15E-42 double:4.056E-321;
        r0.a(r1, r9);
        r0 = com.tencent.mm.model.au.DF();
        r1 = 239; // 0xef float:3.35E-43 double:1.18E-321;
        r0.a(r1, r9);
        return;
    L_0x01a3:
        r0 = move-exception;
        r3 = "MicroMsg.emoji.EmojiStoreV2SingleProductUI";
        r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);
        com.tencent.mm.sdk.platformtools.x.e(r3, r0);
        goto L_0x0059;
    L_0x01b0:
        r0 = r9.iiF;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x01c1;
    L_0x01b8:
        r0 = 5;
        r9.ird = r0;
        r9.irj = r2;
        r9.fdx = r6;
        goto L_0x010d;
    L_0x01c1:
        r0 = r9.iiH;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 != 0) goto L_0x01cf;
    L_0x01c9:
        r9.ird = r6;
        r9.fdx = r1;
        goto L_0x010d;
    L_0x01cf:
        r0 = r9.ipa;
        if (r0 == 0) goto L_0x01d9;
    L_0x01d3:
        r9.ird = r7;
        r9.fdx = r1;
        goto L_0x010d;
    L_0x01d9:
        r0 = r9.iqV;
        if (r0 == 0) goto L_0x01e3;
    L_0x01dd:
        r9.fdx = r7;
        r9.ird = r8;
        goto L_0x010d;
    L_0x01e3:
        r0 = r9.iqX;
        if (r0 <= 0) goto L_0x01ee;
    L_0x01e7:
        r0 = 6;
        r9.ird = r0;
        r9.fdx = r8;
        goto L_0x010d;
    L_0x01ee:
        r9.ird = r1;
        r9.fdx = r2;
        goto L_0x010d;
    L_0x01f4:
        r9.fdx = r2;
        goto L_0x010d;
    L_0x01f8:
        r0 = r9.iiH;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x010d;
    L_0x0200:
        goto L_0x010b;
    L_0x0202:
        r0 = r9.ipa;
        if (r0 != 0) goto L_0x010d;
    L_0x0206:
        goto L_0x010b;
    L_0x0208:
        r0 = r9.iqV;
        if (r0 != 0) goto L_0x010d;
    L_0x020c:
        goto L_0x010b;
    L_0x020e:
        r0 = r9.iiF;
        r0 = com.tencent.mm.sdk.platformtools.bi.oW(r0);
        if (r0 == 0) goto L_0x010d;
    L_0x0216:
        goto L_0x010b;
    L_0x0218:
        r0 = r9.iqX;
        if (r0 != 0) goto L_0x010d;
    L_0x021c:
        goto L_0x010b;
    L_0x021e:
        r0 = r1;
        goto L_0x017b;
    L_0x0221:
        r0 = r9.iiH;
        r1 = new com.tencent.mm.plugin.emoji.f.i;
        r1.<init>(r0);
        r9.ipA = r1;
        r0 = com.tencent.mm.model.au.DF();
        r1 = r9.ipA;
        r0.a(r1, r2);
        r0 = com.tencent.mm.R.l.app_waiting;
        r0 = r9.getString(r0);
        r9.zM(r0);
        goto L_0x0180;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleProductUI.onCreate(android.os.Bundle):void");
    }

    protected void onResume() {
        super.onResume();
        a.sFg.b(this.iru);
    }

    protected void onPause() {
        super.onPause();
        a.sFg.c(this.iru);
    }

    protected void onDestroy() {
        au.DF().b(239, this);
        au.DF().b(821, this);
        super.onDestroy();
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        switch (i) {
            case 2002:
                if (i2 == -1) {
                    String stringExtra = intent.getStringExtra("Select_Conv_User");
                    if (!bi.oW(stringExtra)) {
                        x.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", ".." + stringExtra);
                        int i3 = this.iqX;
                        String str = this.iqY;
                        String str2 = this.ira;
                        String str3 = this.iqZ;
                        String str4 = this.irb;
                        int i4 = this.ird;
                        com.tencent.mm.plugin.emoji.model.i.aEw();
                        k.a(this, stringExtra, 27, i3, str, str2, str3, str4, i4, "https://support.weixin.qq.com/cgi-bin/readtemplate?t=page/common_page__upgrade&text=text000&btn_text=btn_text_0&title=title_0");
                        break;
                    }
                }
                break;
            case 5001:
                if (i2 == -1) {
                    b.h(this, this.mController.tml.getString(R.l.finish_sent));
                    break;
                }
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void initView() {
        if (this.ird != 6 || bi.oW(this.iqY)) {
            setMMTitle(R.l.emoji_store_product_title);
        } else {
            setMMTitle(this.iqY);
        }
        setBackBtn(new 9(this));
        this.irf = new d(this.mController.tml);
        this.irf.isg = new 10(this);
        this.ire = (PreViewListGridView) findViewById(R.h.list);
        this.Iq = y.gq(this.mController.tml).inflate(R.i.emoji_store_v2_mgr_header, null);
        this.irg = this.Iq.findViewById(R.h.emoji_mgr);
        this.irh = (TextView) this.Iq.findViewById(R.h.emoji_tag);
        this.ire.addHeaderView(this.Iq);
        this.iri = y.gq(this.mController.tml).inflate(R.i.emoji_store_load_more, null);
        this.ire.addFooterView(this.iri);
        this.iri.setVisibility(8);
        this.ire.setAdapter(this.irf);
        this.ire.setOnScrollListener(this);
        this.ipy = (MMPullDownView) findViewById(R.h.load_more_view);
        this.ipy.setTopViewVisible(false);
        this.ipy.setOnBottomLoadDataListener(this.irv);
        this.ipy.setAtBottomCallBack(this.irw);
        this.ipy.setBottomViewVisible(false);
        this.ipy.setIsBottomShowAll(false);
        this.ipy.setIsReturnSuperDispatchWhenCancel(true);
        this.iro = (LabelContainerView) findViewById(R.h.select_contact_label_container);
        this.irp = (TextView) this.iro.findViewById(16908310);
        this.irp.setText(R.l.label_panel_search_by);
        this.irq = (MMTagPanel) this.iro.findViewById(R.h.contact_label_panel);
        this.irq.setTagSelectedBG(R.g.tag_green_tab_selector);
        this.irq.setTagSelectedTextColorRes(R.e.wechat_green);
        this.irn = getString(R.l.emoji_store_tag_all);
        this.iro.setOnLabelContainerListener(new 11(this));
        this.irq.setCallBack(new 12(this));
        addIconOptionMenu(1001, R.g.actionbar_emotag_icon, new 13(this));
        addIconOptionMenu(1002, R.k.ofm_send_icon, new 2(this));
        showOptionMenu(1001, false);
        showOptionMenu(1002, false);
    }

    public void onBackPressed() {
        if (this.iro == null || this.iro.getVisibility() != 0) {
            super.onBackPressed();
            return;
        }
        this.iro.setVisibility(8);
        showOptionMenu(1001, this.irj);
        setMMTitle(R.l.emoji_store_product_title);
    }

    private void Wj() {
        if (this.irt) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "need jeep to update page.");
            return;
        }
        this.irl = null;
        switch (this.ird) {
            case 1:
                this.irk = com.tencent.mm.plugin.emoji.model.i.aEA().igD.ZD("0");
                if (this.irk == null || this.irk.rHn == null || this.irf == null) {
                    zM(getString(R.l.app_waiting));
                } else {
                    a(this.irk);
                    this.irf.aQ(this.irk.rHn);
                }
                this.irj = true;
                h.mEJ.h(12875, new Object[]{Integer.valueOf(0), ""});
                break;
            case 2:
            case 3:
                showOptionMenu(1001, false);
                this.irj = false;
                h.mEJ.h(12875, new Object[]{Integer.valueOf(1), this.iiH});
                break;
            case 4:
                showOptionMenu(1001, false);
                this.irn = this.iqW;
                zN(this.irn);
                this.irj = false;
                h.mEJ.h(12875, new Object[]{Integer.valueOf(1), ""});
                break;
            case 5:
                this.irn = "";
                zN(this.iiF);
                this.irj = false;
                h.mEJ.h(12875, new Object[]{Integer.valueOf(2), ""});
                break;
            case 6:
                this.irn = "";
                showOptionMenu(1001, false);
                showOptionMenu(1002, true);
                h.mEJ.h(12875, new Object[]{Integer.valueOf(3), ""});
                break;
        }
        an(this.irl);
    }

    private void zM(String str) {
        if (isFinishing()) {
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[showLoadingDialog] acitivity is finished.");
            return;
        }
        getString(R.l.app_tip);
        this.eEX = com.tencent.mm.ui.base.h.a((Context) this, str, true, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (EmojiStoreV2SingleProductUI.this.ipA != null) {
                    au.DF().c(EmojiStoreV2SingleProductUI.this.ipA);
                }
            }
        });
    }

    private void aFs() {
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
    }

    private void an(byte[] bArr) {
        this.irl = null;
        switch (this.ird) {
            case 1:
                au.DF().a(new com.tencent.mm.plugin.emoji.f.h(1, this.ipa, this.iqV, this.iiF, this.iqX, bArr), 0);
                return;
            case 2:
            case 3:
                au.DF().a(new com.tencent.mm.plugin.emoji.f.h(2, this.ipa, this.iqV, this.iiF, this.iqX, bArr), 0);
                return;
            case 4:
                au.DF().a(new com.tencent.mm.plugin.emoji.f.h(3, this.ipa, this.iqV, this.iiF, this.iqX, bArr), 0);
                return;
            case 5:
                au.DF().a(new com.tencent.mm.plugin.emoji.f.h(4, this.ipa, this.iqV, this.iiF, this.iqX, bArr), 0);
                return;
            case 6:
                au.DF().a(new com.tencent.mm.plugin.emoji.f.h(5, this.ipa, this.iqV, this.iiF, this.iqX, bArr), 0);
                return;
            default:
                return;
        }
    }

    private void a(acr acr) {
        boolean z = false;
        if (acr == null || acr.rHo == null || acr.rHo.size() <= 0) {
            showOptionMenu(1001, false);
            return;
        }
        if (this.irj) {
            z = true;
        }
        showOptionMenu(1001, z);
        if (this.irq != null) {
            if (this.irs == null) {
                this.irs = new ArrayList();
            } else {
                this.irs.clear();
            }
            if (this.irr == null) {
                this.irr = new HashMap();
            }
            this.irr.clear();
            this.irs.add(getString(R.l.emoji_store_tag_all));
            Iterator it = acr.rHo.iterator();
            while (it.hasNext()) {
                tb tbVar = (tb) it.next();
                if (!(tbVar == null || bi.oW(tbVar.rws))) {
                    this.irs.add(tbVar.rws);
                    this.irr.put(tbVar.rws, Integer.valueOf(tbVar.rwr));
                }
            }
            Collection arrayList = new ArrayList();
            arrayList.add(this.irn);
            this.irq.a(arrayList, this.irs);
        }
    }

    private void zN(String str) {
        if (this.irg != null && this.irh != null) {
            switch (this.ird) {
                case 4:
                    if (!bi.oW(str)) {
                        this.irh.setText(getString(R.l.emoji_store_tag_tip, new Object[]{str}));
                        this.irh.setVisibility(0);
                        this.irg.setVisibility(0);
                        break;
                    }
                    break;
                case 5:
                    if (!bi.oW(str)) {
                        this.irh.setText(getString(R.l.emoji_store_search_tip, new Object[]{str}));
                        this.irh.setVisibility(0);
                        this.irg.setVisibility(0);
                        break;
                    }
                    break;
            }
            if (bi.oW(str)) {
                this.irh.setText("");
                this.irh.setVisibility(8);
                this.irg.setVisibility(8);
            }
        }
    }

    private void aGp() {
        if (!this.acT) {
            an(this.irl);
            this.acT = true;
            this.mHandler.sendEmptyMessageDelayed(1002, 200);
        }
    }

    private void L(LinkedList<ta> linkedList) {
        if (this.irf != null && linkedList != null) {
            if (this.irm == -1) {
                this.irf.aQ(linkedList);
                return;
            }
            d dVar = this.irf;
            if (dVar.idD == null) {
                dVar.idD = new ArrayList();
            }
            dVar.idD.addAll(linkedList);
            dVar.notifyDataSetChanged();
        }
    }

    private void aGq() {
        Toast.makeText(this.mController.tml, getString(R.l.emoji_unknow), 0).show();
    }

    public final void a(int i, int i2, String str, l lVar) {
        int type = lVar.getType();
        if (type == 821) {
            aFs();
            com.tencent.mm.plugin.emoji.f.h hVar = (com.tencent.mm.plugin.emoji.f.h) lVar;
            acr aEL = hVar.aEL();
            this.acT = false;
            if (this.iri != null) {
                this.iri.setVisibility(8);
                this.mHandler.removeMessages(1002);
                this.mHandler.sendEmptyMessageDelayed(1001, 200);
            }
            int i3 = hVar.eKI;
            if (((i == 0 && i2 == 0) || (i == 4 && (i2 == 2 || i2 == 3))) && ((this.irl == null || this.irl.length <= 0) && i3 != 3)) {
                a(aEL);
            }
            if (i == 0 || i == 4) {
                this.irl = hVar.iiD;
                if (i2 == 0) {
                    L(aEL.rHn);
                    this.irm = 0;
                    return;
                } else if (i2 == 2) {
                    L(aEL.rHn);
                    this.irm = 2;
                    return;
                } else if (i2 == 3) {
                    this.irm = -1;
                    L(aEL.rHn);
                    return;
                } else {
                    aGq();
                    return;
                }
            }
            aGq();
        } else if (type == 239) {
            aFs();
            if (i2 == 0 && i == 0) {
                act aEM = ((i) lVar).aEM();
                if (aEM != null && aEM.rHp != null) {
                    this.ipa = aEM.rHp.rHi;
                    if (this.mHandler != null) {
                        this.mHandler.sendEmptyMessage(1004);
                        return;
                    }
                    return;
                }
                return;
            }
            showOptionMenu(1001, false);
            com.tencent.mm.ui.base.h.b(this.mController.tml, getString(R.l.emoji_designer_load_failed), null, true);
            x.e("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "open single product ui failed.");
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 0 && absListView.getLastVisiblePosition() == absListView.getCount() - 1 && this.irm == 2 && !this.acT) {
            x.d("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "No More List.");
            aGp();
            x.i("MicroMsg.emoji.EmojiStoreV2SingleProductUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
        }
        if (i != 0 && this.ire != null) {
            this.ire.aGu();
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
