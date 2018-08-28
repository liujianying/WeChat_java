package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.a.c.i;
import com.tencent.mm.ak.a.c.j;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.plugin.emoji.e.k.1;
import com.tencent.mm.plugin.emoji.e.n;
import com.tencent.mm.plugin.emoji.f.g;
import com.tencent.mm.plugin.emoji.f.k;
import com.tencent.mm.plugin.emoji.f.l;
import com.tencent.mm.plugin.emoji.f.o;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.v2.DonorsAvatarView;
import com.tencent.mm.plugin.emoji.ui.widget.MMCopiableTextView;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.model.h$a;
import com.tencent.mm.pluginsdk.ui.emoji.BannerEmojiView;
import com.tencent.mm.protocal.c.adb;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.protocal.c.adj;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.to;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSizeTextView;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import java.io.File;
import java.util.ArrayList;

public class EmojiStoreDetailUI extends MMActivity implements OnClickListener, e, a {
    private ProgressDialog eEX;
    private View gQd;
    private int hPK;
    private ProgressBar idk;
    private long ihD = 0;
    private String ihE = "";
    private b ihH;
    private String iiv;
    private String iiw;
    private String iix;
    private c ikA = new 1(this);
    private to ikO = new to();
    private String ikP = "";
    private int ikw;
    private adj imA = null;
    private boolean imB;
    private TextView imC;
    private View imD;
    private EmojiDetailScrollView imE;
    private BannerEmojiView imF;
    private TextView imG;
    private MMAutoSizeTextView imH;
    private TextView imI;
    private TextView imJ;
    private TextView imK;
    private EmojiDetailGridView imL;
    private ImageView imM;
    private View imN;
    private TextView imO;
    private TextView imP;
    private int imQ;
    private View imR;
    private ProgressBar imS;
    private View imT;
    private ImageView imU;
    private TextView imV;
    private View imW;
    private View imX;
    private MMCopiableTextView imY;
    private Button imZ;
    private int imr;
    private String ims;
    private boolean imt;
    private boolean imu = false;
    private int imv = -1;
    private l imw;
    private g imx;
    private o imy;
    private a imz;
    private DonorsAvatarView ina;
    private TextView inb;
    private int inc;
    private int ind;
    private int ine;
    private String inf;
    private boolean ing;
    private int inh;
    private int ini = -1;
    private String inj;
    private String[] ink = new String[1];
    private boolean inl = false;
    private View inm;
    private boolean inn = true;
    private adb ino;
    private boolean inp = false;
    private boolean inq = true;
    private OnClickListener inr = new 12(this);
    private OnClickListener ins = new 16(this);
    private OnClickListener int = new 17(this);
    private OnClickListener inu = new 18(this);
    private i inv = new 20(this);
    private i inw = new 21(this);
    private j inx = new 22(this);
    private h$a iny = new 15(this);
    private Context mContext;
    private ag mHandler = new ag() {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1001:
                    EmojiStoreDetailUI.e(EmojiStoreDetailUI.this);
                    return;
                case 1002:
                    EmojiStoreDetailUI.this.aFT();
                    return;
                case 1003:
                    EmojiStoreDetailUI.this.aFW();
                    return;
                case 1004:
                    if (EmojiStoreDetailUI.this.imJ.getVisibility() == 0) {
                        EmojiStoreDetailUI.this.imJ.setVisibility(8);
                        EmojiStoreDetailUI.this.imN.setVisibility(0);
                        EmojiStoreDetailUI.this.imM.setVisibility(0);
                    }
                    EmojiStoreDetailUI.this.idk.setProgress(EmojiStoreDetailUI.this.pF);
                    return;
                case 1005:
                    EmojiStoreDetailUI.this.imE.scrollTo(0, 0);
                    return;
                case 1006:
                    EmojiStoreDetailUI.this.el(false);
                    return;
                case 1007:
                    EmojiStoreDetailUI.this.aFU();
                    return;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow message, cannt handle.");
                    return;
            }
        }
    };
    private int mNumColumns;
    private int pF;

    static /* synthetic */ void e(EmojiStoreDetailUI emojiStoreDetailUI) {
        if (!com.tencent.mm.plugin.emoji.h.a.zT(emojiStoreDetailUI.iiv)) {
            au.HU();
            if (com.tencent.mm.model.c.isSDCardAvailable() && com.tencent.mm.plugin.emoji.model.i.aEA().igy.Zt(emojiStoreDetailUI.iiv)) {
                if (com.tencent.mm.plugin.emoji.model.i.aEA().igx.zs(emojiStoreDetailUI.iiv) > 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    au.HU();
                    File file = new File(stringBuilder.append(com.tencent.mm.model.c.Gg()).append(emojiStoreDetailUI.iiv).toString());
                    if (file.exists()) {
                        File[] listFiles = file.listFiles();
                        if (listFiles == null || listFiles.length <= 0) {
                            com.tencent.mm.plugin.emoji.model.i.aEA().igy.Zu(emojiStoreDetailUI.iiv);
                            com.tencent.mm.plugin.emoji.model.i.aEA().igx.ZB(emojiStoreDetailUI.iiv);
                        } else {
                            emojiStoreDetailUI.imB = true;
                            emojiStoreDetailUI.imv = 7;
                            emojiStoreDetailUI.aFW();
                            return;
                        }
                    }
                }
                com.tencent.mm.plugin.emoji.model.i.aEA().igx.ZB(emojiStoreDetailUI.iiv);
            }
            emojiStoreDetailUI.imB = false;
        }
    }

    static /* synthetic */ void u(EmojiStoreDetailUI emojiStoreDetailUI) {
        d dVar = new d(emojiStoreDetailUI.mContext, 1, false);
        dVar.ofp = new 13(emojiStoreDetailUI);
        dVar.ofq = new 14(emojiStoreDetailUI);
        dVar.bXO();
        h.mEJ.h(13224, new Object[]{Integer.valueOf(0), Integer.valueOf(0), "", ""});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ing = q.GR();
        this.ihH = new b(2003);
        Intent intent = getIntent();
        this.iiv = getIntent().getStringExtra("extra_id");
        this.ikw = getIntent().getIntExtra("preceding_scence", -1);
        this.iiw = getIntent().getStringExtra("extra_name");
        this.imr = getIntent().getIntExtra("call_by", -1);
        Object stringExtra = getIntent().getStringExtra("sns_object_data");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.iiv = EmojiLogic.zo(stringExtra);
            this.ikw = 0;
            this.ikw = 10;
            h.mEJ.h(10993, new Object[]{Integer.valueOf(3), this.iiv});
        }
        if (TextUtils.isEmpty(this.iiv)) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] product id is null.");
            finish();
        }
        if (this.ikw == -1) {
            x.e("MicroMsg.emoji.EmojiStoreDetailUI", "[hadleIntent] emoticon preceding scence no set!");
            finish();
        }
        this.inn = intent.getBooleanExtra("check_clickflag", true);
        this.inf = intent.getStringExtra("cdn_client_id");
        this.ine = intent.getIntExtra("download_entrance_scene", 0);
        this.ihD = intent.getLongExtra("searchID", 0);
        this.ihE = bi.aG(intent.getStringExtra("docID"), "");
        stringExtra = intent.getStringExtra("extra_copyright");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ikO.rxa = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_coverurl");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ikO.rwY = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_description");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ikO.rwR = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ikO.rwT = stringExtra;
        }
        int intExtra = intent.getIntExtra("extra_type", -1);
        if (intExtra != -1) {
            this.ikO.rwU = intExtra;
        }
        intExtra = intent.getIntExtra("extra_flag", -1);
        if (intExtra != -1) {
            this.ikO.rwV = intExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_type");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ikO.rxc = stringExtra;
        }
        stringExtra = intent.getStringExtra("extra_price_num");
        if (!TextUtils.isEmpty(stringExtra)) {
            this.ikO.rxb = stringExtra;
        }
        if (this.ing) {
            this.inj = intent.getStringExtra("google_price");
            if (TextUtils.isEmpty(this.inj)) {
                this.inh = 11;
                com.tencent.mm.pluginsdk.model.h.a(this, this.ink, this.iny);
            }
        }
        this.imt = intent.getBooleanExtra("reward_tip", false);
        this.ink[0] = this.iiv;
        this.ikO.rem = this.iiv;
        this.ikO.rwQ = this.iiw;
        this.ikO.rxi = this.ims;
        this.ikO.hcD = -1;
        this.mContext = this;
        initView();
        if (com.tencent.mm.plugin.emoji.h.a.zT(this.iiv)) {
            ActionBarActivity actionBarActivity = this.mController.tml;
            to toVar = new to();
            toVar.rem = EmojiGroupInfo.tcy;
            toVar.rwQ = actionBarActivity.getString(R.l.emoji_store_tuzi_title);
            toVar.rwR = actionBarActivity.getString(R.l.emoji_store_tuzi_desc);
            toVar.rwS = actionBarActivity.getString(R.l.emoji_store_tuzi_auth);
            toVar.rwT = "";
            toVar.rwU = 0;
            toVar.rwV = 1;
            toVar.rwY = "";
            toVar.rwZ = 0;
            toVar.rxa = actionBarActivity.getString(R.l.emoji_store_tuzi_copyright);
            toVar.rxd = "";
            toVar.rxb = "";
            toVar.rxc = "";
            toVar.rxh = actionBarActivity.getString(R.l.emoji_store_tuzi_timelimitStr);
            this.ikO = toVar;
            this.inp = true;
            this.ino = EmojiLogic.aEq();
            aFS();
        } else {
            com.tencent.mm.storage.emotion.i ZE = com.tencent.mm.plugin.emoji.model.i.aEA().igB.ZE(this.iiv);
            if (!(ZE == null || ZE.field_content == null)) {
                add add = new add();
                try {
                    add.aG(ZE.field_content);
                    this.ikO = add.rHx;
                    this.ikP = ZE.field_lan;
                } catch (Throwable e) {
                    x.e("MicroMsg.emoji.EmojiStoreDetailUI", "exception:%s", new Object[]{bi.i(e)});
                }
            }
            if (this.ikO == null) {
                this.imw = new l(this.iiv, this.ikw);
            } else if (bi.oW(this.ikP) || !this.ikP.equalsIgnoreCase(w.fD(this.mContext))) {
                this.imw = new l(this.iiv, this.ikw);
            } else {
                this.imw = new l(this.iiv, this.ikw, this.ikO.hcD);
            }
            au.DF().a(this.imw, 0);
            if (this.imr == -1 || this.imr == 3) {
                this.imD.setVisibility(8);
                this.gQd.setVisibility(8);
                getString(R.l.app_tip);
                this.eEX = com.tencent.mm.ui.base.h.a(this, getString(R.l.app_waiting), true, new 5(this));
            }
            aFQ();
            if (this.inn) {
                au.DF().a(new k(this.iiv), 0);
            } else {
                this.inp = true;
                this.ino = EmojiLogic.aEq();
            }
        }
        aFT();
        com.tencent.mm.plugin.emoji.model.i.aEA().igy.c(this);
        com.tencent.mm.sdk.b.a.sFg.b(this.ikA);
        au.DF().a(423, this);
        au.DF().a(822, this);
        h(this.iiv, getIntent().getIntExtra("extra_status", -1), getIntent().getIntExtra("extra_progress", 0), this.inf);
        this.inq = true;
        h.mEJ.h(12740, new Object[]{Integer.valueOf(1), "", this.iiv, "", Integer.valueOf(this.ine)});
        if (this.imt && this.imE != null) {
            this.mHandler.postDelayed(new 2(this), 0);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    protected final int getLayoutId() {
        return R.i.emoji_store_detail;
    }

    protected final void initView() {
        if (!bi.oW(this.iiw)) {
            setMMTitle(this.iiw);
        }
        setBackBtn(new 3(this));
        this.hPK = com.tencent.mm.bp.a.ad(this.mContext, R.f.emoji_detail_item_margin);
        this.inc = getResources().getDimensionPixelSize(R.f.emoji_detail_item_image_size);
        this.inc = com.tencent.mm.bp.a.ad(this.mContext, R.f.emoji_detail_item_image_size);
        this.mNumColumns = 4;
        this.imE = (EmojiDetailScrollView) findViewById(R.h.scrollview);
        this.gQd = findViewById(R.h.empty);
        this.imC = (TextView) this.gQd.findViewById(R.h.empty_content);
        this.imD = findViewById(R.h.emoji_store_detail);
        this.imF = (BannerEmojiView) findViewById(R.h.emoji_image);
        this.imF.setMinimumHeight((int) (((float) (((this.imF.getRight() - this.imF.getLeft()) - this.imF.getPaddingRight()) - this.imF.getPaddingLeft())) * 0.56f));
        this.imG = (TextView) findViewById(R.h.emoji_tip);
        this.imH = (MMAutoSizeTextView) findViewById(R.h.emoji_title);
        this.imI = (TextView) findViewById(R.h.emoji_copyright);
        this.imJ = (TextView) findViewById(R.h.emoji_type);
        this.imK = (TextView) findViewById(R.h.emoji_destrition);
        this.imQ = com.tencent.mm.bp.a.fk(this.mController.tml);
        this.imR = findViewById(R.h.emoji_action);
        this.imL = (EmojiDetailGridView) findViewById(R.h.emoji_gridview);
        if (com.tencent.mm.plugin.emoji.h.a.zT(this.iiv)) {
            this.imz = new b(this);
        } else {
            this.imz = new a(this);
        }
        this.imN = findViewById(R.h.emoji_progress);
        this.idk = (ProgressBar) findViewById(R.h.emoji_download_progress);
        this.imM = (ImageView) findViewById(R.h.emoji_close);
        this.imM.setOnClickListener(this);
        this.imN.setVisibility(8);
        this.imM.setVisibility(8);
        this.idk.setProgress(0);
        this.imL.setAdapter(this.imz);
        this.imL.setColumnWidth(this.inc);
        this.imL.setNumColumns(this.mNumColumns);
        this.imL.setHorizontalSpacing(this.hPK);
        this.imL.setVerticalSpacing(this.hPK);
        this.imL.setEmojiDetailScrollView(this.imE);
        this.imL.setFromDetail(true);
        this.imJ.setOnClickListener(this);
        this.imO = (TextView) findViewById(R.h.emoji_service);
        this.imP = (TextView) findViewById(R.h.emoji_complaints);
        this.imO.setOnClickListener(this.inr);
        this.imP.setOnClickListener(this.ins);
        this.imS = (ProgressBar) findViewById(R.h.emoji_google_price_loading);
        this.imS.setVisibility(this.ing ? 0 : 8);
        this.inm = findViewById(R.h.emoji_long_touch_pre_tips);
        this.imW = findViewById(R.h.emoji_designer_line_2);
        this.imT = findViewById(R.h.designer_bar_container);
        this.imU = (ImageView) findViewById(R.h.designer_icon);
        this.imV = (TextView) findViewById(R.h.designer_title);
        this.imX = findViewById(R.h.emoji_reward);
        this.imY = (MMCopiableTextView) findViewById(R.h.reward_begword);
        this.imZ = (Button) findViewById(R.h.reward_btn);
        this.inb = (TextView) findViewById(R.h.reward_info);
        this.ina = (DonorsAvatarView) findViewById(R.h.reward_avatar);
        this.imZ.setOnClickListener(this.int);
        this.inb.setOnClickListener(this.inu);
    }

    public void onStart() {
        super.onStart();
    }

    protected void onResume() {
        super.onResume();
        au.DF().a(412, this);
        au.DF().a(521, this);
        this.inl = false;
        if (!this.inq) {
            aFQ();
            oP(1007);
        }
        aFR();
        this.inq = false;
        oP(1001);
    }

    protected void onPause() {
        super.onPause();
        au.DF().b(412, this);
        au.DF().b(521, this);
    }

    protected void onStop() {
        super.onStop();
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.plugin.emoji.model.i.aEA().igy.d(this);
        com.tencent.mm.sdk.b.a.sFg.c(this.ikA);
        au.DF().b(423, this);
        au.DF().b(822, this);
        if (this.imL != null) {
            this.imL.release();
        }
    }

    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putInt("status", this.imv);
        bundle.putInt("progress", this.pF);
    }

    protected void onRestoreInstanceState(Bundle bundle) {
        this.imv = bundle.getInt("status");
        this.pF = bundle.getInt("progress");
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.h.emoji_type) {
            String stringExtra;
            if (this.imv == 7) {
                stringExtra = getIntent().getStringExtra("to_talker_name");
                if (bi.oW(stringExtra) || !this.imu) {
                    this.ihH.p(this);
                    h.mEJ.h(12069, new Object[]{Integer.valueOf(2), this.iiv});
                } else {
                    b.a(stringExtra, this.iiv, (Activity) this);
                }
                x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks kv stat update click use emoji");
                h.mEJ.k(11076, "0, ");
                return;
            }
            switch (this.imv) {
                case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                case 0:
                case 3:
                    aFZ();
                    this.imv = 6;
                    aFW();
                    h.mEJ.h(12066, new Object[]{Integer.valueOf(1), Integer.valueOf(this.ine), "", this.iiv, Long.valueOf(this.ihD), this.ihE});
                    return;
                case 4:
                    if (!this.inl) {
                        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mProductId:%s, mData.PackPrice:%s,PriceType:%s", new Object[]{this.iiv, this.ikO.rwT, this.ikO.rxc});
                        Intent intent = new Intent();
                        intent.putExtra("key_product_id", this.iiv);
                        if (this.ing) {
                            intent.putExtra("key_currency_type", "");
                            intent.putExtra("key_price", this.inj);
                        } else {
                            intent.putExtra("key_currency_type", this.ikO.rxc);
                            intent.putExtra("key_price", this.ikO.rxb);
                        }
                        com.tencent.mm.bg.d.b(this, "wallet_index", ".ui.WalletIapUI", intent, 2001);
                        h.mEJ.h(12066, new Object[]{Integer.valueOf(2), Integer.valueOf(this.ine), "", this.iiv, Long.valueOf(this.ihD), this.ihE});
                        this.inl = true;
                        return;
                    }
                    return;
                case 5:
                    this.imv = 3;
                    aFW();
                    return;
                case 10:
                case 12:
                    switch (this.ini) {
                        case 10233:
                            stringExtra = getString(R.l.emoji_no_on_sale);
                            break;
                        case 10234:
                            stringExtra = getString(R.l.emoji_google_no_install);
                            break;
                        case 10235:
                            stringExtra = getString(R.l.emoji_timeout);
                            break;
                        default:
                            stringExtra = getString(R.l.emoji_unknow);
                            break;
                    }
                    com.tencent.mm.ui.base.h.b(this, stringExtra, null, true);
                    return;
                case 11:
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "can not be clicked.");
                    return;
                default:
                    x.e("MicroMsg.emoji.EmojiStoreDetailUI", "can not product status.%d", new Object[]{Integer.valueOf(this.imv)});
                    return;
            }
        } else if (id == R.h.emoji_download_progress) {
            aFY();
        } else if (id == R.h.emoji_close) {
            aFY();
        } else {
            x.w("MicroMsg.emoji.EmojiStoreDetailUI", "click view is unknow.");
        }
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] errType:%d, errCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        if (this.eEX != null && this.eEX.isShowing()) {
            this.eEX.dismiss();
        }
        switch (lVar.getType()) {
            case 412:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDetail");
                l lVar2 = (l) lVar;
                if (lVar2 == null || bi.oW(lVar2.iiv) || !lVar2.iiv.equalsIgnoreCase(this.iiv)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0) {
                    if (i2 == 0) {
                        this.ikO = lVar2.aEO();
                        oP(1002);
                        return;
                    } else if (i2 == 1) {
                        aFO();
                        return;
                    } else {
                        this.imC.setText(R.l.emoji_store_load_failed);
                        aFP();
                        return;
                    }
                } else if (i2 == 5) {
                    if (!(lVar2 == null || lVar2.aEO() == null)) {
                        this.ikO.rwV = lVar2.aEO().rwV;
                    }
                    oP(1002);
                    return;
                } else if (i2 == 1) {
                    aFO();
                    return;
                } else {
                    this.imE.setVisibility(8);
                    this.gQd.setVisibility(0);
                    this.imC.setText(R.l.emoji_store_load_failed_network);
                    aFP();
                    return;
                }
            case 423:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_ExchangeEmotionPack");
                g gVar = (g) lVar;
                if (gVar == null || bi.oW(gVar.iiv) || !gVar.iiv.equalsIgnoreCase(this.iiv)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                    return;
                } else if (i == 0 && i2 == 0) {
                    this.inf = gVar.dVk;
                    this.imv = 6;
                    aFW();
                    return;
                } else {
                    this.imv = -1;
                    aFW();
                    String str2 = this.iiw;
                    com.tencent.mm.ui.base.h.a(this, String.format(getString(R.l.emoji_store_download_failed_msg), new Object[]{str2}), "", new 10(this), new 11(this));
                    return;
                }
            case 521:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_GetEmotionDesc");
                k kVar = (k) lVar;
                if (kVar == null || bi.oW(kVar.iil) || !kVar.iil.equalsIgnoreCase(this.iiv)) {
                    x.i("MicroMsg.emoji.EmojiStoreDetailUI", "no equal productid");
                } else {
                    if (i == 0 && i2 == 0) {
                        this.ino = (adb) kVar.diG.dIE.dIL;
                    } else {
                        this.ino = null;
                    }
                    this.inp = true;
                    aFX();
                }
                this.inp = true;
                aFX();
                return;
            case 822:
                x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[onSceneEnd] MMFunc_MMGetEmotionReward");
                if (i == 0 && i2 == 0) {
                    this.imA = ((o) lVar).aES();
                    oP(1007);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void aFO() {
        this.gQd.setVisibility(0);
        this.imD.setVisibility(8);
        this.imE.setVisibility(8);
        this.imC.setText(R.l.emoji_no_find);
    }

    private void aFP() {
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "[handleLoadDataFailed]");
        if (this.ikO == null || this.ikO.rwV == 0) {
            this.gQd.setVisibility(0);
            this.imD.setVisibility(8);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "onActivityResult. requestCode:[%d] resultCode:[%d]", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
        String str;
        if (i == 2001) {
            str = "";
            int intExtra;
            if (intent != null) {
                intExtra = intent.getIntExtra("key_err_code", 0);
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "errCode:" + intExtra);
                str = intent.getStringExtra("key_err_msg");
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "errMsg:" + str);
            } else {
                intExtra = 0;
            }
            this.inl = false;
            if (i2 != -1) {
                this.imv = -1;
                aFW();
                if (q.GR()) {
                    h.mEJ.a(166, 6, 1, false);
                } else {
                    h.mEJ.a(166, 2, 1, false);
                }
            } else if (intent != null && intExtra == 0) {
                ArrayList stringArrayListExtra = intent.getStringArrayListExtra("key_response_product_ids");
                ArrayList stringArrayListExtra2 = intent.getStringArrayListExtra("key_response_series_ids");
                if (stringArrayListExtra == null || !stringArrayListExtra.contains(this.iiv)) {
                    this.imv = -1;
                    aFW();
                    zE(str);
                    return;
                }
                for (int i3 = 0; i3 < stringArrayListExtra.size(); i3++) {
                    if (this.iiv.equals(stringArrayListExtra.get(i3))) {
                        this.iix = (String) stringArrayListExtra2.get(i3);
                    }
                }
                this.ikO.rwV = 1;
                aFZ();
                this.imv = 6;
                com.tencent.mm.ui.base.h.bA(this, str);
                if (q.GR()) {
                    h.mEJ.a(166, 4, 1, false);
                } else {
                    h.mEJ.a(166, 0, 1, false);
                }
            } else if (intent != null && intExtra == 100000002) {
                aFZ();
                this.imv = 6;
                this.imz.notifyDataSetChanged();
                if (q.GR()) {
                    h.mEJ.a(166, 7, 1, false);
                } else {
                    h.mEJ.a(166, 3, 1, false);
                }
            } else if (intent == null || intExtra != 1) {
                this.imv = -1;
                aFW();
                zE(str);
                if (q.GR()) {
                    h.mEJ.a(166, 5, 1, false);
                } else {
                    h.mEJ.a(166, 1, 1, false);
                }
            } else {
                this.imv = -1;
                aFW();
                if (q.GR()) {
                    h.mEJ.a(166, 6, 1, false);
                } else {
                    h.mEJ.a(166, 2, 1, false);
                }
            }
        } else if (i == 2002) {
            if (i2 == -1) {
                str = intent.getStringExtra("Select_Conv_User");
                if (!bi.oW(str)) {
                    x.d("MicroMsg.emoji.EmojiStoreDetailUI", ".." + str);
                    String str2 = this.iiv;
                    String str3 = this.ikO.rwQ;
                    String str4 = this.ikO.rwR;
                    String str5 = this.ikO.jPG;
                    String str6 = this.ikO.rxj;
                    int i4 = this.ikO.rwV;
                    String stringBuffer = new StringBuffer(getResources().getString(R.l.app_emoji_share)).append(str3).toString();
                    com.tencent.mm.pluginsdk.ui.applet.g.a aVar = new com.tencent.mm.pluginsdk.ui.applet.g.a(this);
                    aVar.bZ(str).TH(stringBuffer).BX(R.l.app_send);
                    aVar.TI(str5).cdP();
                    aVar.TK(getString(R.l.confirm_dialog_edittext_hint)).a(new 1(str, str2, str3, str4, str5, str6, i4, this)).eIW.show();
                }
            }
        } else if (i == this.ihH.guC && i2 == -1) {
            x.d("MicroMsg.emoji.EmojiStoreDetailUI", "jacks use emoji to : %s", new Object[]{intent.getStringExtra("Select_Conv_User")});
            b.a(intent, this.iiv, (Activity) this);
            h.mEJ.h(12069, new Object[]{Integer.valueOf(3), this.iiv});
        }
    }

    public final void a(String str, com.tencent.mm.sdk.e.l lVar) {
        oP(1001);
    }

    private void zE(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(R.l.emoji_play_failed);
        }
        com.tencent.mm.ui.base.h.a(this, str, "", new 4(this));
    }

    private void aFQ() {
        this.imA = com.tencent.mm.plugin.emoji.model.i.aEA().igC.ZF(this.iiv);
    }

    private void aFR() {
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwV, 64) && n.aEg()) {
            this.imy = new o(this.iiv, o.iiS);
            au.DF().a(this.imy, 0);
        }
    }

    private boolean aFS() {
        boolean aFS = com.tencent.mm.plugin.emoji.h.a.aFS();
        this.imB = aFS;
        this.imv = aFS ? 7 : 3;
        return aFS;
    }

    private void aFT() {
        if (!bi.oW(this.ikO.rwQ)) {
            setMMTitle(this.ikO.rwQ);
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PanelUrl:%s", new Object[]{this.ikO.rxd});
        this.imD.setVisibility(0);
        this.gQd.setVisibility(8);
        el(true);
        this.imH.setText(this.ikO.rwQ);
        this.imI.setText(this.ikO.rxa);
        this.imK.setText(this.ikO.rwR);
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwU, 1)) {
            this.imG.setVisibility(8);
        } else {
            this.imG.setVisibility(0);
            this.imG.setText(R.l.emoji_type_gif);
        }
        aFV();
        aFW();
        aFX();
        if (com.tencent.mm.plugin.emoji.h.a.zT(this.iiv) || !(this.ikO.rxg == null || this.ikO.rxg.size() <= 0 || ((ayu) this.ikO.rxg.get(0)).sbC == null)) {
            this.imL.setIsShowPopWin(true);
            this.inm.setVisibility(0);
        } else {
            this.inm.setVisibility(8);
            this.imL.setIsShowPopWin(false);
        }
        this.imL.setProductId(this.iiv);
        if (this.imz != null) {
            this.imz.notifyDataSetInvalidated();
        }
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "mData.PackFlag:%s", new Object[]{this.ikO.rwV});
        if ((this.ikO.rwV & 16) == 16) {
            addIconOptionMenu(0, R.k.ofm_send_icon, new 7(this));
        }
        this.imH.setMaxWidth((((this.imQ - this.imR.getWidth()) - (com.tencent.mm.bp.a.ad(this.mController.tml, R.f.NormalPadding) * 2)) - this.imG.getWidth()) - (com.tencent.mm.bp.a.ad(this.mController.tml, R.f.ListPadding) * 2));
        this.imH.setVisibility(8);
        this.imH.setVisibility(0);
        if (this.ikO.rxl == null || this.ikO.rxl.rHi == 0 || this.ine == 6) {
            this.imW.setVisibility(8);
            this.imT.setVisibility(8);
        } else {
            this.imW.setVisibility(0);
            this.imT.setVisibility(0);
            com.tencent.mm.ak.o.Pj().a(this.ikO.rxl.rxm, this.imU, f.cs(this.iiv, this.ikO.rxl.rxm));
            this.imV.setText(this.ikO.rxl.jPe);
            this.imT.setOnClickListener(new 6(this));
        }
        LayoutParams layoutParams;
        if ((this.ikO.rwV & 32) == 32) {
            layoutParams = (LayoutParams) this.imP.getLayoutParams();
            LayoutParams layoutParams2 = (LayoutParams) this.imO.getLayoutParams();
            this.imP.setVisibility(0);
            layoutParams.weight = 1.0f;
            layoutParams.gravity = 3;
            layoutParams.leftMargin = com.tencent.mm.bp.a.ad(this.mController.tml, R.f.NormalPadding);
            this.imP.setLayoutParams(layoutParams);
            this.imP.setGravity(3);
            layoutParams2.weight = 1.0f;
            layoutParams2.gravity = 5;
            layoutParams2.rightMargin = com.tencent.mm.bp.a.ad(this.mController.tml, R.f.NormalPadding);
            this.imO.setLayoutParams(layoutParams2);
            this.imO.setGravity(5);
        } else {
            layoutParams = (LayoutParams) this.imO.getLayoutParams();
            layoutParams.gravity = 17;
            this.imO.setLayoutParams(layoutParams);
            this.imO.setGravity(17);
            this.imP.setVisibility(8);
        }
        aFU();
    }

    private void el(boolean z) {
        EmojiInfo emojiInfo = null;
        if (!bi.oW(this.ikO.rwY)) {
            String str;
            if (z) {
                str = this.iiv;
                String str2 = this.ikO.rwY;
                com.tencent.mm.bp.a.getDensity(this.mContext);
                emojiInfo = EmojiLogic.a(str, str2, this.inv);
            } else {
                str = this.iiv;
                String str3 = this.ikO.rwY;
                com.tencent.mm.bp.a.getDensity(this.mContext);
                emojiInfo = EmojiLogic.a(str, 4, str3, true);
            }
        }
        if (!(emojiInfo == null || this.imF == null)) {
            this.imF.setImageFilePath(emojiInfo.cnF());
        }
        if (com.tencent.mm.plugin.emoji.h.a.zT(this.iiv)) {
            this.imF.setImageResource(R.g.tuzi_banner);
        }
    }

    public final void aFU() {
        if (!com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwV, 64) || !n.aEg()) {
            this.imX.setVisibility(8);
        } else if (this.imA != null) {
            this.imX.setVisibility(0);
            this.imZ.setText(R.l.emoji_store_reward);
            this.imY.setText(this.imA.rHP.rxq);
            this.imY.setLongClickable(false);
            if (this.imA.rHy > 0) {
                this.inb.setVisibility(0);
                String valueOf = String.valueOf(this.imA.rHy);
                Object format = String.format(getString(R.l.emoji_store_reward_info), new Object[]{Integer.valueOf(this.imA.rHy)});
                CharSequence spannableString = new SpannableString(format);
                int indexOf = format.indexOf(valueOf);
                if (indexOf >= 0) {
                    spannableString.setSpan(new ForegroundColorSpan(getResources().getColor(R.e.emotion_reward_link_color)), indexOf, valueOf.length() + indexOf, 33);
                }
                this.inb.setText(spannableString);
            } else {
                this.inb.setVisibility(8);
            }
            if (this.imA.rHz == null || this.imA.rHz.size() <= 0) {
                this.ina.setVisibility(8);
                return;
            }
            this.ina.setVisibility(0);
            this.ina.b(this.iiv, this.imA.rHz);
        } else {
            this.imX.setVisibility(8);
            aFR();
        }
    }

    private void aFV() {
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwU, 8)) {
            this.ind = 0;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwU, 4)) {
            this.ind = 0;
        } else if (this.ing || !TextUtils.isEmpty(this.ikO.rwT)) {
            this.ind = 1;
        } else {
            this.ind = 0;
        }
        x.i("MicroMsg.emoji.EmojiStoreDetailUI", "PackFlag:%d", new Object[]{Integer.valueOf(this.ikO.rwV)});
        if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwV, 8) && com.tencent.mm.plugin.emoji.a.a.e.oK(this.ikO.rwU)) {
            this.imv = 8;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwV, 1) || com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwU, 8)) {
            this.imv = 3;
        } else if (com.tencent.mm.plugin.emoji.a.a.e.oK(this.ikO.rwU)) {
            this.imv = 0;
        } else if (!this.ing && (TextUtils.isEmpty(this.ikO.rxb) || this.ikO.rxb.equals("0"))) {
            this.imv = 0;
        } else if (!this.ing) {
            this.imv = 4;
        } else if (TextUtils.isEmpty(this.inj)) {
            this.imv = this.inh;
        } else {
            this.imv = 4;
        }
        if (this.imB) {
            this.imv = 7;
        }
    }

    private void aFW() {
        while (true) {
            if (com.tencent.mm.plugin.emoji.h.a.zT(this.iiv)) {
                aFS();
            }
            switch (this.imv) {
                case IX5WebViewClient.ERROR_UNKNOWN /*-1*/:
                    aFV();
                case 0:
                    this.imS.setVisibility(8);
                    this.imJ.setTextColor(getResources().getColorStateList(R.e.white_text_color_selector));
                    this.imJ.setBackgroundResource(R.g.btn_solid_green);
                    this.imJ.setText(R.l.emoji_store_download);
                    this.imJ.setEnabled(true);
                    return;
                case 3:
                    this.imS.setVisibility(8);
                    this.imJ.setTextColor(getResources().getColorStateList(R.e.white_text_color_selector));
                    this.imJ.setBackgroundResource(R.g.btn_solid_green);
                    this.imJ.setText(R.l.emoji_store_download);
                    this.imJ.setEnabled(true);
                    return;
                case 4:
                    this.imS.setVisibility(8);
                    this.imJ.setTextColor(getResources().getColorStateList(R.e.white_text_color_selector));
                    this.imJ.setBackgroundResource(R.g.btn_solid_green);
                    this.imJ.setEnabled(true);
                    if (!this.ing) {
                        this.imJ.setText(this.ikO.rwT);
                        this.imv = 4;
                        return;
                    } else if (bi.oW(this.inj)) {
                        this.imJ.setText("");
                        return;
                    } else {
                        this.imJ.setText(this.inj);
                        return;
                    }
                case 5:
                    this.imS.setVisibility(8);
                    this.imJ.setBackgroundResource(R.g.btn_solid_green);
                    this.imJ.setText(R.l.emoji_store_download);
                    this.imJ.setEnabled(true);
                    break;
                case 6:
                    this.imS.setVisibility(8);
                    this.imJ.setEnabled(false);
                    this.imN.setVisibility(0);
                    this.imM.setVisibility(0);
                    this.imJ.setVisibility(4);
                    if (this.imr == 3) {
                        return;
                    }
                    return;
                case 7:
                    this.imS.setVisibility(8);
                    this.imJ.setEnabled(true);
                    this.imJ.setBackgroundResource(R.g.btn_solid_green);
                    this.imJ.setText(R.l.emoji_store_used_now);
                    this.imN.setVisibility(8);
                    this.idk.setProgress(0);
                    this.imM.setVisibility(4);
                    this.imJ.setVisibility(0);
                    if (this.imr == 3) {
                        return;
                    }
                    return;
                case 8:
                    this.imS.setVisibility(8);
                    this.imJ.setTextColor(getResources().getColorStateList(R.e.emoji_download_finish_color));
                    this.imJ.setBackgroundResource(R.g.btn_solid_white);
                    this.imJ.setText(R.l.emoji_store_expire);
                    this.imJ.setEnabled(false);
                    return;
                case 10:
                case 12:
                    this.imS.setVisibility(8);
                    this.imJ.setVisibility(0);
                    this.imJ.setBackgroundResource(R.g.btn_solid_green);
                    this.imJ.setText(R.l.emoji_store_play);
                    this.imJ.setEnabled(true);
                    this.imN.setVisibility(8);
                    this.idk.setProgress(0);
                    this.imM.setVisibility(4);
                    return;
                case 11:
                    break;
                default:
                    x.w("MicroMsg.emoji.EmojiStoreDetailUI", "unknow product status:%d", new Object[]{Integer.valueOf(this.imv)});
                    return;
            }
        }
        this.imS.setVisibility(0);
        this.imJ.setVisibility(0);
        this.imJ.setBackgroundResource(R.g.white_bigbtn_tips_normal);
        this.imJ.setText("");
        this.imJ.setEnabled(false);
        this.imN.setVisibility(8);
        this.idk.setProgress(0);
        this.imM.setVisibility(4);
    }

    private void aFX() {
        if (!this.inp) {
            return;
        }
        if (this.ino != null && (this.ino.rHw & 1) == 1) {
            return;
        }
        if ((this.ikO == null || !com.tencent.mm.plugin.emoji.a.a.e.cs(this.ikO.rwV, 1)) && this.ino != null && !TextUtils.isEmpty(this.ino.rHv)) {
            this.imJ.setText(this.ino.rHv);
            this.imJ.setTextColor(this.mController.tml.getResources().getColor(R.e.half_alpha_black));
            this.imJ.setBackgroundDrawable(null);
            this.imJ.setEnabled(false);
        }
    }

    private void aFY() {
        com.tencent.mm.ui.base.h.a(this, R.l.emoji_store_cancle_download_msg, 0, R.l.emoji_store_stop_download, R.l.emoji_store_continue_download, new 8(this), new 9(this));
    }

    public final void h(String str, int i, int i2, String str2) {
        x.d("MicroMsg.emoji.EmojiStoreDetailUI", "productId:%s,status:%d, progress:%d, cdnClientID:%s, ", new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), str2});
        if (!bi.oW(str) && str.equals(this.iiv)) {
            if (!TextUtils.isEmpty(str2)) {
                this.inf = str2;
            }
            if (i == -1) {
                if (this.imv != -1) {
                    this.imv = -1;
                    oP(1003);
                }
            } else if (i == 7) {
                this.imv = 7;
                oP(1003);
            } else if (i != 6) {
                x.w("MicroMsg.emoji.EmojiStoreDetailUI", "[onExchange] do nothing.");
            } else if (!TextUtils.isEmpty(str) && str.equals(this.iiv)) {
                this.imv = 6;
                this.pF = i2;
                oP(1004);
            }
        }
    }

    private void aFZ() {
        if (com.tencent.mm.plugin.emoji.h.a.zT(this.iiv)) {
            com.tencent.mm.plugin.emoji.f.a.aEF();
            com.tencent.mm.plugin.emoji.f.a.aEG();
            return;
        }
        this.imx = new g(this.iiv, this.iix, this.iiw);
        au.DF().a(this.imx, 0);
        switch (this.ikw) {
            case 9:
                h.mEJ.h(11598, new Object[]{Integer.valueOf(2), this.iiv});
                return;
            case 10:
                h.mEJ.h(11598, new Object[]{Integer.valueOf(1), this.iiv});
                return;
            case 11:
                h.mEJ.h(11598, new Object[]{Integer.valueOf(3), this.iiv});
                return;
            default:
                return;
        }
    }

    public final void oP(int i) {
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(i);
        }
    }
}
