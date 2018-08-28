package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.design.a$i;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.o;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.emoji.a.f;
import com.tencent.mm.plugin.emoji.e.k.2;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.i;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.h;
import com.tencent.mm.plugin.emoji.model.h.a;
import com.tencent.mm.plugin.emoji.model.h.b;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.act;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.MMPullDownView.c;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.y;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class EmojiStoreV2DesignerUI extends MMActivity implements OnScrollListener, OnItemClickListener, e, a, b, c, MMPullDownView.e {
    private ListView CU;
    private View Iq;
    private int fdx;
    private long ihD;
    private String ihE;
    private String ihI;
    private String iiH;
    private com.tencent.mm.sdk.b.c ikA = new 1(this);
    private g ikB;
    f ikI;
    private int iki = -1;
    private boolean ikj;
    private byte[] ikl;
    protected final int ikp = 131074;
    private final int ikq = 131075;
    private final int ikr = 131076;
    private final String iks = "product_id";
    private final String ikt = "progress";
    private final String iku = "status";
    private com.tencent.mm.plugin.emoji.model.f ikx;
    private h iky;
    private i ipA;
    private p ipB;
    private am.b.a ipC = new 8(this);
    private final int ipD = 10001;
    private final int ipE = 10002;
    private final int ipF = 10003;
    private com.tencent.mm.plugin.emoji.f.p ipG;
    private int ipa;
    private String ipb;
    private String ipc;
    private ab ipd;
    private View ipe;
    private BannerEmojiView ipf;
    private TextView ipg;
    private TextView iph;
    private View ipi;
    private View ipj;
    private TextView ipk;
    private ImageView ipl;
    private TextView ipm;
    private TextView ipn;
    View ipo;
    private List<ta> ipp = new ArrayList();
    private View ipq;
    PreViewListGridView ipr;
    private d ips;
    View ipt;
    View ipu;
    View ipv;
    TextView ipw;
    View ipx;
    private MMPullDownView ipy;
    private agl ipz;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            String string;
            switch (message.what) {
                case 10001:
                    EmojiStoreV2DesignerUI.this.er(false);
                    return;
                case 10002:
                    EmojiStoreV2DesignerUI.this.updateData();
                    return;
                case 10003:
                    EmojiStoreV2DesignerUI.this.Wj();
                    return;
                case 131075:
                    if (EmojiStoreV2DesignerUI.this.ikI != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            EmojiStoreV2DesignerUI.this.ikI.bf(string, message.getData().getInt("progress"));
                            return;
                        }
                        return;
                    }
                    return;
                case 131076:
                    if (EmojiStoreV2DesignerUI.this.ikI != null && message.getData() != null) {
                        string = message.getData().getString("product_id");
                        if (string != null) {
                            EmojiStoreV2DesignerUI.this.ikI.be(string, message.getData().getInt("status"));
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };

    static /* synthetic */ void e(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.ipa != 0) {
            Intent intent = new Intent();
            intent.putExtra("uin", emojiStoreV2DesignerUI.ipa);
            intent.setClass(emojiStoreV2DesignerUI.mController.tml, EmojiStoreV2SingleProductUI.class);
            emojiStoreV2DesignerUI.startActivity(intent);
        }
    }

    static /* synthetic */ void h(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        if (emojiStoreV2DesignerUI.ipz != null && !bi.oW(emojiStoreV2DesignerUI.ipz.rgK)) {
            Intent intent = new Intent();
            intent.putExtra("Contact_User", emojiStoreV2DesignerUI.ipz.rgK);
            d.b(emojiStoreV2DesignerUI.mController.tml, "profile", ".ui.ContactInfoUI", intent);
            com.tencent.mm.plugin.report.service.h.mEJ.h(12067, new Object[]{Integer.valueOf(3), "", "", "", ""});
        }
    }

    static /* synthetic */ void i(EmojiStoreV2DesignerUI emojiStoreV2DesignerUI) {
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(emojiStoreV2DesignerUI.mController.tml, 1, false);
        dVar.ofp = new 5(emojiStoreV2DesignerUI);
        dVar.ofq = new 6(emojiStoreV2DesignerUI);
        dVar.bXO();
        com.tencent.mm.plugin.report.service.h.mEJ.h(13224, new Object[]{Integer.valueOf(3), Integer.valueOf(0), "", Integer.valueOf(emojiStoreV2DesignerUI.ipa)});
    }

    protected final int getLayoutId() {
        return R.i.emoji_store_v2_designer_ui;
    }

    public void onCreate(Bundle bundle) {
        boolean z;
        super.onCreate(bundle);
        this.iiH = getIntent().getStringExtra("id");
        this.ipa = getIntent().getIntExtra("uin", 0);
        this.ihI = getIntent().getStringExtra("name");
        this.ipb = getIntent().getStringExtra("headurl");
        this.ipc = getIntent().getStringExtra("rediret_url");
        this.fdx = getIntent().getIntExtra("extra_scence", 0);
        this.ihD = getIntent().getLongExtra("searchID", 0);
        this.ihE = bi.aG(getIntent().getStringExtra("docID"), "");
        String stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ipa = EmojiLogic.zp(stringExtra);
            this.ihI = EmojiLogic.zq(stringExtra);
            this.ipc = EmojiLogic.zv(stringExtra);
        }
        initView();
        if (!bi.oW(this.iiH)) {
            act ZC = com.tencent.mm.plugin.emoji.model.i.aEA().igD.ZC(this.iiH);
            if (ZC == null || ZC.rHp == null || ZC.rHp.rHi == 0 || bi.oW(ZC.rHp.jPe)) {
                z = true;
                if (z) {
                    Wj();
                } else {
                    this.ipA = new i(this.iiH);
                    au.DF().a(this.ipA, 0);
                    getString(R.l.app_tip);
                    this.ipB = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.app_waiting), true, new 7(this));
                }
                au.DF().a(239, this);
                au.DF().a(720, this);
                com.tencent.mm.sdk.b.a.sFg.b(this.ikA);
                com.tencent.mm.plugin.report.service.h.mEJ.h(12067, new Object[]{Integer.valueOf(1), "", "", "", ""});
                com.tencent.mm.plugin.report.service.h.mEJ.h(12740, new Object[]{Integer.valueOf(2), o.getString(this.ipa), "", "", Integer.valueOf(this.fdx)});
            }
            this.ipa = ZC.rHp.rHi;
            this.ihI = ZC.rHp.jPe;
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "uin:%s name:%s", new Object[]{Integer.valueOf(this.ipa), this.ihI});
        }
        z = false;
        if (z) {
            this.ipA = new i(this.iiH);
            au.DF().a(this.ipA, 0);
            getString(R.l.app_tip);
            this.ipB = com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.app_waiting), true, new 7(this));
        } else {
            Wj();
        }
        au.DF().a(239, this);
        au.DF().a(720, this);
        com.tencent.mm.sdk.b.a.sFg.b(this.ikA);
        com.tencent.mm.plugin.report.service.h.mEJ.h(12067, new Object[]{Integer.valueOf(1), "", "", "", ""});
        com.tencent.mm.plugin.report.service.h.mEJ.h(12740, new Object[]{Integer.valueOf(2), o.getString(this.ipa), "", "", Integer.valueOf(this.fdx)});
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(423, this);
    }

    protected void onPause() {
        super.onPause();
        au.DF().b(423, this);
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.ipG != null) {
            au.DF().c(this.ipG);
        }
        au.DF().b(239, this);
        au.DF().b(720, this);
        com.tencent.mm.sdk.b.a.sFg.c(this.ikA);
        if (this.mHandler != null) {
            this.mHandler.removeMessages(10002);
            this.mHandler.removeMessages(10001);
            this.mHandler = null;
        }
    }

    protected final void initView() {
        if (!bi.oW(this.ihI)) {
            setMMTitle(this.ihI);
        }
        this.Iq = y.gq(this.mController.tml).inflate(R.i.emoji_store_v2_designer_header, null);
        this.ipe = this.Iq.findViewById(R.h.designer_header);
        this.ipf = (BannerEmojiView) this.ipe.findViewById(R.h.emoji_bar_view);
        this.ipg = (TextView) this.Iq.findViewById(R.h.designer_name);
        this.iph = (TextView) this.Iq.findViewById(R.h.designer_desc);
        this.ipi = this.Iq.findViewById(R.h.designer_bar_line);
        this.ipj = this.Iq.findViewById(R.h.designer_bar_container);
        this.ipk = (TextView) this.Iq.findViewById(R.h.designer_title);
        this.ipl = (ImageView) this.Iq.findViewById(R.h.designer_icon);
        this.ipm = (TextView) this.Iq.findViewById(R.h.designer_detail);
        this.ipn = (TextView) this.Iq.findViewById(R.h.designer_works);
        this.ipo = this.Iq.findViewById(R.h.designer_product);
        this.ipq = this.Iq.findViewById(R.h.designer_product_more);
        this.ipq.setOnClickListener(new 10(this));
        this.ipr = (PreViewListGridView) this.Iq.findViewById(R.h.designer_product_list);
        this.ips = new d(this.mController.tml);
        this.ips.isg = new d.a() {
            public final void ms(int i) {
                if (EmojiStoreV2DesignerUI.this.ipr != null && EmojiStoreV2DesignerUI.this.ips != null) {
                    ta oY = EmojiStoreV2DesignerUI.this.ips.oY(i);
                    if (oY != null) {
                        try {
                            Intent intent = new Intent();
                            intent.putExtra("extra_object", oY.toByteArray());
                            intent.setClass(EmojiStoreV2DesignerUI.this.mController.tml, EmojiStoreV2SingleProductDialogUI.class);
                            EmojiStoreV2DesignerUI.this.startActivity(intent);
                            EmojiStoreV2DesignerUI.this.overridePendingTransition(R.a.pop_in, R.a.pop_out);
                        } catch (Exception e) {
                        }
                    }
                }
            }
        };
        this.ipr.setAdapter(this.ips);
        this.ipt = this.Iq.findViewById(R.h.designer_product_title);
        this.ipu = this.Iq.findViewById(R.h.designer_product_title_tv);
        this.ipv = this.Iq.findViewById(R.h.designer_product_more);
        this.ipw = (TextView) this.Iq.findViewById(R.h.designer_single_product);
        this.ipx = this.Iq.findViewById(R.h.designer_product_divider);
        this.ipy = (MMPullDownView) findViewById(R.h.load_more_pull_view);
        this.ipy.setOnBottomLoadDataListener(this);
        this.ipy.setAtBottomCallBack(this);
        this.ipy.setBottomViewVisible(false);
        this.ipy.setIsBottomShowAll(false);
        this.CU = (ListView) findViewById(16908298);
        this.CU.setOnItemClickListener(this);
        this.CU.setOnScrollListener(this);
        this.ipj.setOnClickListener(new 12(this));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                EmojiStoreV2DesignerUI.this.finish();
                return false;
            }
        });
        addIconOptionMenu(0, R.k.ofm_send_icon, new 14(this));
    }

    private void Wj() {
        setMMTitle(this.ihI);
        this.ikI = new f(this.mController.tml);
        this.CU.addHeaderView(this.Iq);
        this.CU.setAdapter(this.ikI);
        this.ikI.ieo = this;
        this.ikI.idJ = n.aEg();
        this.ikI.idK = false;
        this.ipg.setText(this.ihI);
        this.ipz = com.tencent.mm.plugin.emoji.model.i.aEA().igA.ZH(String.valueOf(this.ipa));
        this.iky = new h();
        this.iky.gKE = this;
        this.iky.ihz = this.ikI;
        this.iky.ihC = 6;
        this.iky.ihF = this;
        this.iky.ihI = this.ihI;
        this.iky.ihD = this.ihD;
        this.iky.ihE = this.ihE;
        if (this.ipz != null) {
            c(com.tencent.mm.plugin.emoji.f.p.a(this.ipz));
            List list = this.ipz.rgD;
            LinkedList linkedList = this.ipz.rHC;
            aP(list);
        }
        updateData();
        am(this.ikl);
    }

    private void updateData() {
        if (this.ipz == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update data failed. data is null.");
            return;
        }
        er(true);
        if (bi.oW(this.ipz.rgK)) {
            x.w("MicroMsg.emoji.EmojiStoreV2DesignerUI", "mData.BizName is null");
            this.ipi.setVisibility(8);
            this.ipj.setVisibility(8);
        } else {
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "biz name is :%s", new Object[]{this.ipz.rgK});
            au.HU();
            this.ipd = com.tencent.mm.model.c.FR().Yg(this.ipz.rgK);
        }
        if ((this.ipd == null || ((int) this.ipd.dhP) == 0) && am.a.dBr != null) {
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "getContact %s", new Object[]{this.ipz.rgK});
            am.a.dBr.a(this.ipz.rgK, "", this.ipC);
        }
        this.ipm.setText(R.l.emoji_store_weixin);
        if (bi.oW(this.ipz.jOS)) {
            this.iph.setVisibility(8);
        } else {
            this.iph.setText(this.ipz.jOS);
            this.iph.setVisibility(0);
        }
        aGl();
        if (this.ikx == null || this.ikx.ihq == null || this.ikx.ihq.isEmpty()) {
            this.ipn.setVisibility(8);
        } else {
            this.ipn.setVisibility(0);
        }
    }

    protected final void er(boolean z) {
        if (this.ipz == null) {
            x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "update header failed. data is null.");
        } else if (this.ipf != null && !bi.oW(this.ipz.rJT)) {
            String str = this.ipz.rJT;
            com.tencent.mm.bp.a.getDensity(this);
            EmojiInfo a = EmojiLogic.a("Designer", 8, str, true);
            if (a != null) {
                this.ipf.setImageFilePath(a.cnF());
            } else if (z) {
                com.tencent.mm.ak.o.Pj().a(this.ipz.rJT, null, com.tencent.mm.plugin.emoji.e.f.g("Designer", this.ipz.rJT, new Object[]{"Designer", "BANNER"}), new 15(this));
            } else {
                x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "updateDesignerHeader failed");
            }
        }
    }

    private void aGl() {
        if (this.ipd == null || ((int) this.ipd.dhP) == 0) {
            this.ipj.setVisibility(8);
            this.ipi.setVisibility(8);
            return;
        }
        this.ipj.setVisibility(0);
        this.ipi.setVisibility(0);
        if (bi.oW(this.ipd.BK())) {
            this.ipk.setText(this.ipd.field_username);
        } else {
            this.ipk.setText(this.ipd.BK());
        }
        com.tencent.mm.pluginsdk.ui.a.b.n(this.ipl, this.ipd.field_username);
        this.ipm.setEnabled(true);
    }

    private void am(byte[] bArr) {
        this.ikj = true;
        this.ipG = new com.tencent.mm.plugin.emoji.f.p(this.ipa, bArr);
        au.DF().a(this.ipG, 0);
    }

    public final void a(int i, int i2, String str, l lVar) {
        switch (lVar.getType()) {
            case 239:
                if (this.ipB != null && this.ipB.isShowing()) {
                    this.ipB.dismiss();
                }
                if (i2 == 0 && i == 0) {
                    act aEM = ((i) lVar).aEM();
                    if (aEM != null && aEM.rHp != null) {
                        this.ipa = aEM.rHp.rHi;
                        this.ihI = aEM.rHp.jPe;
                        this.ipb = aEM.rHp.rxm;
                        if (this.mHandler != null) {
                            this.mHandler.sendEmptyMessage(10003);
                            return;
                        }
                        return;
                    }
                    return;
                }
                showOptionMenu(0, false);
                com.tencent.mm.ui.base.h.b(this.mController.tml, getString(R.l.emoji_designer_load_failed), null, true);
                x.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "open designer failed .");
                return;
            case 423:
                g gVar = (g) lVar;
                if (i == 0 && i2 == 0) {
                    bf(gVar.iiv, 0);
                    return;
                }
                String str2 = gVar.iiv;
                String str3 = gVar.iix;
                String str4 = gVar.iiw;
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.l.emoji_store_download_failed_msg, new Object[]{str4}), "", new 3(this, str2, str3, str4), new 4(this));
                be(gVar.iiv, -1);
                return;
            case 720:
                this.ikj = false;
                if (i == 0 || i == 4) {
                    com.tencent.mm.plugin.emoji.f.p pVar = (com.tencent.mm.plugin.emoji.f.p) lVar;
                    com.tencent.mm.plugin.emoji.model.f a = com.tencent.mm.plugin.emoji.f.p.a(pVar.aET());
                    if (i2 == 0) {
                        this.ipz = pVar.aET();
                        c(a);
                    } else if (i2 == 2) {
                        this.ipz = pVar.aET();
                        b(this.iki, a);
                        this.iki = 2;
                    } else if (i2 == 3) {
                        this.ipz = pVar.aET();
                        b(this.iki, a);
                        this.iki = 1;
                        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed errCode:%d", new Object[]{Integer.valueOf(i2)});
                    }
                    if (this.ikl == null && this.ipz != null) {
                        com.tencent.mm.plugin.emoji.model.i.aEA().igA.a(String.valueOf(this.ipa), pVar.aET());
                        this.ipp = this.ipz.rgD;
                        List list = this.ipp;
                        LinkedList linkedList = this.ipz.rHC;
                        aP(list);
                    }
                    this.ikl = pVar.iiN;
                    return;
                }
                x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get person designer failed");
                return;
            default:
                x.e("MicroMsg.emoji.EmojiStoreV2DesignerUI", "unknow scene type");
                return;
        }
    }

    private void aP(List<ta> list) {
        int i = 1;
        String value = com.tencent.mm.k.g.AT().getValue("ShowDesignerEmoji");
        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "get dynamic Disgner_Emoji_Store_Show config value:%s", new Object[]{value});
        if (bi.oW(value) || bi.WU(value) != 1) {
            i = 0;
        }
        if (list == null || list.size() <= 0 || i == 0) {
            this.ipo.setVisibility(8);
            return;
        }
        this.ipo.setVisibility(0);
        if (this.mHandler != null) {
            this.mHandler.post(new 2(this, list));
        }
        this.ips.aQ(list);
    }

    private void c(com.tencent.mm.plugin.emoji.model.f fVar) {
        b(this.iki, fVar);
        this.iki = 0;
    }

    private void b(int i, com.tencent.mm.plugin.emoji.model.f fVar) {
        Object obj = 1;
        switch (i) {
            case -1:
                this.ikx = fVar;
                break;
            case 0:
                this.ikx = fVar;
                break;
            case 1:
                this.ikx = fVar;
                break;
            case 2:
                if (this.ikx == null) {
                    this.ikx = new com.tencent.mm.plugin.emoji.model.f();
                }
                this.ikx.oL(fVar.ihp);
                this.ikx.aN(fVar.ihq);
                break;
            default:
                obj = null;
                break;
        }
        if (this.ikx != null && obj != null) {
            if (this.ikI != null) {
                this.ikI.b(this.ikx);
            }
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(10002);
            }
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i != 0 || absListView.getLastVisiblePosition() != absListView.getCount() - 1) {
            return;
        }
        if (this.iki == 0 || this.ikj) {
            x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", "No More List.");
            return;
        }
        am(this.ikl);
        x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "[onScrollStateChanged] startLoadRemoteEmoji.");
    }

    public final boolean aCg() {
        return true;
    }

    public final boolean aCi() {
        return false;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (this.ikI != null) {
            com.tencent.mm.plugin.emoji.a.a.f oG = this.ikI.oG(i - this.CU.getHeaderViewsCount());
            if (oG != null) {
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
                    intent.putExtra("preceding_scence", a$i.AppCompatTheme_ratingBarStyle);
                    intent.putExtra("download_entrance_scene", 6);
                    intent.putExtra("call_by", 1);
                    intent.putExtra("check_clickflag", false);
                    intent.putExtra("extra_status", oG.mStatus);
                    intent.putExtra("extra_progress", oG.pF);
                    intent.putExtra("searchID", this.ihD);
                    String stringExtra = getIntent().getStringExtra("to_talker_name");
                    if (!bi.oW(stringExtra)) {
                        intent.putExtra("to_talker_name", stringExtra);
                    }
                }
                if (intent != null) {
                    startActivity(intent);
                }
            }
        }
    }

    public final void a(com.tencent.mm.plugin.emoji.a.a aVar) {
        String str = "MicroMsg.emoji.EmojiStoreV2DesignerUI";
        String str2 = "[onProductClick] productId:%s, productPrice:%s, productStatus:%d";
        Object[] objArr = new Object[3];
        objArr[0] = aVar.getProductId();
        objArr[1] = TextUtils.isEmpty(aVar.aDq()) ? "" : aVar.aDq();
        objArr[2] = Integer.valueOf(aVar.aDp());
        x.i(str, str2, objArr);
        aVar.aDp();
        this.iky.a(aVar);
    }

    public final void M(String str, String str2, String str3) {
        N(str, str2, str3);
        aFq();
    }

    public final void aEs() {
    }

    protected final g N(String str, String str2, String str3) {
        this.ikB = new g(str, str2, str3);
        return this.ikB;
    }

    protected final void aFq() {
        au.DF().a(this.ikB, 0);
    }

    final void bf(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("progress", i);
        obtain.what = 131075;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    final void be(String str, int i) {
        Message obtain = Message.obtain();
        obtain.getData().putString("product_id", str);
        obtain.getData().putInt("status", i);
        obtain.what = 131076;
        if (this.mHandler != null) {
            this.mHandler.sendMessage(obtain);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        this.iky.onActivityResult(i, i2, intent);
        if (i == 2002 && i2 == -1) {
            String stringExtra = intent.getStringExtra("Select_Conv_User");
            if (bi.oW(stringExtra) || this.ipz == null) {
                x.i("MicroMsg.emoji.EmojiStoreV2DesignerUI", "member or data is null.");
            } else {
                x.d("MicroMsg.emoji.EmojiStoreV2DesignerUI", ".." + stringExtra);
                String str = this.ihI;
                String str2 = this.ipz.jOS;
                int i3 = this.ipa;
                String str3 = this.ipc;
                String str4 = this.ihI;
                String str5 = this.ipz.rxm;
                String stringBuffer = new StringBuffer(getResources().getString(R.l.app_designer_share)).append(str).toString();
                com.tencent.mm.pluginsdk.ui.applet.g.a aVar = new com.tencent.mm.pluginsdk.ui.applet.g.a(this);
                aVar.bZ(stringExtra).TH(stringBuffer).BX(R.l.app_send);
                aVar.TI(str5).cdP();
                aVar.TK(getString(R.l.confirm_dialog_edittext_hint)).a(new 2(stringExtra, str4, str2, i3, str3, str, str5, this)).eIW.show();
            }
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final int getForceOrientation() {
        return 1;
    }
}
