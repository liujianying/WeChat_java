package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.g.a.qt;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.f.a.j;
import com.tencent.mm.plugin.exdevice.f.a.j.a;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.f.b.e;
import com.tencent.mm.plugin.exdevice.f.b.f;
import com.tencent.mm.plugin.exdevice.model.ac;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMPullDownView;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceRankInfoUI extends MMActivity implements a, e, f, d {
    private static int iEp = 128;
    private boolean En;
    private String gaG;
    private String gtX;
    private p iBL = null;
    private ImageView iDX;
    private Map<String, String> iEI = new HashMap();
    private View iEd;
    private String iEf;
    private String iEg;
    private boolean iFA;
    private String iFB;
    private boolean iFC;
    private j iFD;
    private b<j> iFE = new 12(this);
    private int iFF;
    private ListView iFj;
    private b iFk;
    private View iFl;
    private ExdeviceRankListHeaderView iFm;
    private ExdeviceRankChampionInfoView iFn;
    private View iFo;
    private String iFp;
    private String iFq;
    private String iFr;
    private String iFs;
    private com.tencent.mm.plugin.exdevice.f.b.a.a iFt;
    private String iFu;
    private int iFv;
    private List<e> iFw;
    private ArrayList<c> iFx;
    private ArrayList<d> iFy;
    private boolean iFz;
    private boolean ixI;
    public boolean ixU;
    public String ixV;

    static /* synthetic */ void c(ExdeviceRankInfoUI exdeviceRankInfoUI, String str) {
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("Retr_Msg_Type", 0);
        intent.putExtra("image_path", str);
        com.tencent.mm.bg.d.b(exdeviceRankInfoUI, ".ui.transmit.SelectConversationUI", intent, 1);
    }

    static /* synthetic */ void j(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(exdeviceRankInfoUI.mController.tml, 1, false);
        dVar.ofp = new 19(exdeviceRankInfoUI);
        dVar.ofq = new 20(exdeviceRankInfoUI);
        dVar.bXO();
    }

    static /* synthetic */ void n(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        if (bi.oW(exdeviceRankInfoUI.ixV)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a Ah = ad.aHi().Ah(exdeviceRankInfoUI.gtX);
            if (Ah != null) {
                exdeviceRankInfoUI.ixV = Ah.field_championUrl;
            }
        }
        d f = b.f(exdeviceRankInfoUI.gtX, exdeviceRankInfoUI.iFy);
        String str = "--";
        String str2 = "0";
        if (f != null) {
            str = String.valueOf(f.field_ranknum);
            str2 = String.valueOf(f.field_score);
        }
        new ac().a(exdeviceRankInfoUI, str, str2, exdeviceRankInfoUI.ixV, new 13(exdeviceRankInfoUI));
    }

    static /* synthetic */ void o(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", "https://ssl.gongyi.qq.com/yxj_health/index.html");
        com.tencent.mm.bg.d.b(exdeviceRankInfoUI, "webview", ".ui.tools.WebViewUI", intent);
    }

    static /* synthetic */ void p(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        com.tencent.mm.ui.widget.a.d dVar = new com.tencent.mm.ui.widget.a.d(exdeviceRankInfoUI.mController.tml, 1, false);
        dVar.ofp = new n.c() {
            public final void a(l lVar) {
                if (ExdeviceRankInfoUI.this.ixI) {
                    lVar.e(1, ExdeviceRankInfoUI.this.getString(R.l.exdevice_profile_already_like_cover));
                } else {
                    lVar.e(0, ExdeviceRankInfoUI.this.getString(R.l.exdevice_profile_like_cover));
                }
            }
        };
        dVar.ofq = new 17(exdeviceRankInfoUI);
        dVar.bXO();
    }

    private void ez(boolean z) {
        if (!this.iFA || z) {
            ad.aHm();
            this.iFy = com.tencent.mm.plugin.exdevice.f.b.c.Ad(this.iFs);
            this.iFx = ad.aHg().aHs();
            this.iFw = this.iFk.b(this.iFx, this.iFy, this.ixU);
            runOnUiThread(new 1(this));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.En = false;
        this.gtX = q.GF();
        Intent intent = getIntent();
        this.iFp = intent.getStringExtra("key_rank_info");
        this.iFq = intent.getStringExtra("key_rank_semi");
        this.iFr = intent.getStringExtra("app_username");
        this.iFs = intent.getStringExtra("rank_id");
        this.iFz = intent.getBooleanExtra("key_is_latest", false);
        this.iFu = intent.getStringExtra("key_champioin_username");
        this.iFv = intent.getIntExtra("device_type", 0);
        this.iFB = intent.getStringExtra("locate_to_username");
        this.iFA = intent.getBooleanExtra("key_only_show_latest_rank", false);
        if (bi.oW(this.iFs) || "#".equals(this.iFs)) {
            if (!this.iFA) {
                d dVar;
                com.tencent.mm.plugin.exdevice.f.b.b.d aHf = ad.aHf();
                Cursor b = aHf.diF.b(String.format("select * from %s order by %s desc limit 1", new Object[]{"HardDeviceRankInfo", "rankID"}), null, 2);
                if (b == null) {
                    x.e("MicroMsg.ExdeviceRankInfoStg", "Get no rank in DB");
                    dVar = null;
                } else {
                    if (b.moveToFirst()) {
                        dVar = new d();
                        dVar.d(b);
                    } else {
                        x.d("MicroMsg.ExdeviceRankInfoStg", "hy: no record");
                        dVar = null;
                    }
                    b.close();
                }
                if (dVar != null) {
                    this.iFs = dVar.field_rankID;
                    this.iFr = dVar.field_appusername;
                }
            }
            this.iFu = null;
            this.iFz = true;
        }
        ad.aHm();
        this.iFy = com.tencent.mm.plugin.exdevice.f.b.c.Ad(this.iFs);
        if (!this.iFA) {
            if (this.iFy == null || this.iFy.size() <= 0) {
                this.iFx = new ArrayList();
                this.iFy = com.tencent.mm.plugin.exdevice.f.a.a.a(this.iFs, this.iFr, this.iFp, this.iFq, this.iEI, this.iFx);
                ad.aHm();
                com.tencent.mm.plugin.exdevice.f.b.c.d(this.iFs, this.iFy);
            } else {
                com.tencent.mm.plugin.exdevice.f.a.a.a(this.iFp, this.iFq, this.iEI);
            }
            this.iFx = ad.aHg().aHs();
        }
        this.iFk = new b(this, this.iFr);
        this.iFk.iEI = this.iEI;
        this.iFw = this.iFk.b(this.iFx, this.iFy, this.ixU);
        this.iFk.iEH = this.iFw;
        if (bi.oW(this.iFu)) {
            aIg();
        }
        this.iFt = ad.aHi().Ah(this.iFu);
        if (this.iFt == null && !bi.oW(this.iFu)) {
            this.iFt = new com.tencent.mm.plugin.exdevice.f.b.a.a();
            this.iFt.field_username = this.iFu;
            this.iFt.field_championMotto = getIntent().getStringExtra("key_champion_info");
            this.iFt.field_championUrl = getIntent().getStringExtra("key_champion_coverimg");
            ad.aHm();
            ad.aHi().a(this.iFt);
        }
        initView();
        if (this.iFy != null && this.iFy.size() > 0) {
            this.iFn.Av(((d) this.iFy.get(0)).field_username);
        }
        ad.aHn().a(this);
        ad.aHm().iye = this;
        aIe();
        setBackBtn(new 18(this));
        setMMTitle(R.l.exdevice_wechat_sport_rank_title);
        showOptionMenu(true);
        aIf();
        qt qtVar = new qt();
        qtVar.cbp.action = 2;
        com.tencent.mm.sdk.b.a.sFg.a(qtVar, Looper.getMainLooper());
    }

    private void aIe() {
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "updateRankInfoUIFromServer");
        this.iFD = new j(this.iFs, this.iFr, this.iFu, this.iFz, this.iFE);
        this.iFD.ixX = this;
        au.DF().a(this.iFD, 0);
    }

    private void aIf() {
        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "try2LocateToUser, locate2User(%s), username(%s).", new Object[]{this.iFB, this.gtX});
        if (!bi.oW(this.iFB)) {
            int i;
            String str = this.iFB;
            x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser, locate2User(%s), username(%s).", new Object[]{str, this.gtX});
            if (bi.oW(str)) {
                i = -1;
            } else if (this.iFw == null || this.iFw.size() == 0) {
                i = -2;
            } else {
                i = 0;
                while (i < this.iFw.size()) {
                    d dVar = ((e) this.iFw.get(i)).iHF;
                    int i2 = ((e) this.iFw.get(i)).iHG;
                    if (dVar != null && str.equalsIgnoreCase(dVar.field_username) && !str.equalsIgnoreCase(this.gtX) && (i2 & 2) != 2) {
                        DisplayMetrics displayMetrics = new DisplayMetrics();
                        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
                        x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "locateToUser pos(%d).(h : %d)", new Object[]{Integer.valueOf(i), Integer.valueOf(displayMetrics.heightPixels)});
                        this.iFj.setSelectionFromTop(i, i2 / 4);
                        this.iFk.iEJ = str;
                        this.iFk.notifyDataSetInvalidated();
                        aIi();
                        break;
                    }
                    i++;
                }
                this.iFk.iEJ = null;
                i = -3;
            }
            if (i >= 0) {
                return;
            }
        }
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "locate to username is null or nil.");
    }

    private void aHY() {
        if (this.iFt == null || this.gtX == null || !this.gtX.equals(this.iFt.field_username) || !bi.oW(this.iFt.field_championUrl)) {
            if (this.iEd != null) {
                this.iEd.setVisibility(8);
            }
            if (this.iFt != null && !bi.aG(this.iFt.field_username, "").equals(this.gtX) && !bi.oW(this.iFt.field_championUrl)) {
                this.iFm.setOnViewClickListener(new 22(this));
                return;
            }
            return;
        }
        if (this.iEd != null) {
            this.iEd.setVisibility(0);
        }
        if (this.iFm != null) {
            this.iFm.setOnViewClickListener(new 21(this));
        }
    }

    private void aIg() {
        String aIh = aIh();
        if (!bi.oW(aIh)) {
            this.iFu = aIh;
        }
    }

    private String aIh() {
        if (this.iFw != null) {
            for (e eVar : this.iFw) {
                d dVar = eVar.iHF;
                if (dVar != null && dVar.field_ranknum == 1) {
                    return dVar.field_username;
                }
            }
        }
        return null;
    }

    protected final void initView() {
        int dimensionPixelSize;
        int size;
        boolean z;
        this.iFl = findViewById(R.h.not_support_msg_type);
        ExdeviceRankListHeaderView exdeviceRankListHeaderView = new ExdeviceRankListHeaderView(this);
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        if (i == 0) {
            i = com.tencent.mm.plugin.exdevice.j.b.B(this, getResources().getDimensionPixelSize(R.f.ExdeviceDefaultStatusBarHeight));
        }
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightLand);
        } else {
            dimensionPixelSize = getResources().getDimensionPixelSize(R.f.DefaultActionbarHeightPort);
        }
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        i = ((defaultDisplay.getHeight() / 2) - i) - dimensionPixelSize;
        if (defaultDisplay.getHeight() <= 0 || i <= 0) {
            i = getResources().getDimensionPixelSize(R.f.ExdeviceChangeCoverClickAreaHeight);
        }
        exdeviceRankListHeaderView.setMinimumHeight(i);
        exdeviceRankListHeaderView.setMinimumWidth(defaultDisplay.getWidth());
        exdeviceRankListHeaderView.setTag(Integer.valueOf(i));
        this.iFm = exdeviceRankListHeaderView;
        MMPullDownView mMPullDownView = (MMPullDownView) findViewById(R.h.pulldown_view);
        this.iFj = (ListView) findViewById(R.h.exdevice_rank_info_lv);
        this.iFn = (ExdeviceRankChampionInfoView) findViewById(R.h.championInfoV);
        this.iEd = findViewById(R.h.setCoverV);
        this.iEd.setOnClickListener(new 23(this));
        this.iFm.setIsShowTip(false);
        aHY();
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setTopViewVisible(false);
        mMPullDownView.setBottomViewVisible(false);
        mMPullDownView.setIsBottomShowAll(false);
        mMPullDownView.setIsTopShowAll(false);
        mMPullDownView.setCanOverScrool(true);
        mMPullDownView.setOnInterceptTouchEventListener(new 24(this));
        mMPullDownView.setAtBottomCallBack(new 2(this));
        mMPullDownView.setOnScrollChangedListener(new 3(this));
        mMPullDownView.setAtTopCallBack(new 4(this));
        this.iFj.setOnScrollListener(new 5(this));
        this.iFj.addHeaderView(this.iFm, null, false);
        View inflate = getLayoutInflater().inflate(R.i.exdevice_rank_footer_view, null);
        this.iFo = inflate.findViewById(R.h.invite_friend_footer);
        inflate.findViewById(R.h.invite_friend_btn).setOnClickListener(new 6(this));
        this.iFo.setVisibility(8);
        this.iFj.addFooterView(inflate);
        if (this.iFx != null) {
            dimensionPixelSize = this.iFx.size();
        } else {
            dimensionPixelSize = 0;
        }
        if (this.iFy != null) {
            size = this.iFy.size();
        } else {
            size = 0;
        }
        if (dimensionPixelSize + size == 0) {
            this.iFw = new ArrayList();
            this.iFk.iEH = this.iFw;
            getString(R.l.app_tip);
            this.iBL = h.a(this, getString(R.l.loading_tips), true, new 7(this));
        }
        this.iFj.setAdapter(this.iFk);
        this.iFk.iEK = this;
        if (this.iFv == 1) {
            this.iFj.setVisibility(0);
            this.iFl.setVisibility(8);
            z = true;
        } else {
            this.iFj.setVisibility(8);
            this.iFl.setVisibility(0);
            z = false;
        }
        if (z) {
            this.iDX = (ImageView) findViewById(R.h.exdevice_bg_iv);
            mMPullDownView.setCanOverScrool(false);
            dimensionPixelSize = com.tencent.mm.bp.a.fk(this);
            i = ((Integer) this.iFm.getTag()).intValue();
            if (this.ixU) {
                i += (getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarSize) / 2) + getResources().getDimensionPixelSize(R.f.ExdeviceProfileAvatarRoundStrokeWidth);
            }
            this.iDX.setLayoutParams(new LayoutParams(dimensionPixelSize, i));
            aIj();
            eA(false);
            return;
        }
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: cannot handle this device type");
        finish();
    }

    private void aIi() {
        View childAt = this.iFj.getChildAt(0);
        int[] iArr = new int[2];
        if (childAt != null) {
            if (this.iFj.getFirstVisiblePosition() == 0) {
                childAt.getLocationOnScreen(iArr);
                if (bi.oW(this.iFB) && iEp == 128) {
                    iEp = iArr[1];
                }
                int i = iArr[1];
                if (i > 0) {
                    float f;
                    if (i >= iEp) {
                        f = 1.0f;
                    } else {
                        f = ((float) i) / ((float) iEp);
                    }
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "ap-alpha: %s", new Object[]{Float.valueOf(f)});
                    this.iFn.setAlpha(f);
                    this.iFn.setVisibility(0);
                    this.iEd.setAlpha(f);
                    return;
                }
            }
            this.iFn.setAlpha(0.0f);
            this.iEd.setAlpha(0.0f);
            this.iFn.setVisibility(8);
        }
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onRestart() {
        super.onRestart();
        ez(true);
    }

    protected void onDestroy() {
        this.En = true;
        if (this.iFk != null) {
            b.finish();
        }
        super.onDestroy();
        if (this.iFD != null) {
            this.iFD.ixX = null;
        }
        ad.aHn().b(this);
        ad.aHm().iye = null;
        ad.aHm().iyf = null;
        if (this.iFF > 0) {
            int i = this.iFF;
            x.v("MicroMsg.Sport.SportReportLogic", "reportLikeCount count=%d", new Object[]{Integer.valueOf(i)});
            com.tencent.mm.plugin.report.f.mDy.h(13168, new Object[]{Integer.valueOf(0), Integer.valueOf(i)});
        }
    }

    protected void onPause() {
        super.onPause();
    }

    protected final int getLayoutId() {
        return R.i.exdevice_rank_info;
    }

    private void aIj() {
        if (this.iFt == null) {
            this.iDX.setImageResource(R.e.darkgrey);
            this.gaG = null;
        } else if (this.gaG == this.iFt.field_championUrl) {
        } else {
            if (this.gaG == null || !this.gaG.equals(this.iFt.field_championUrl)) {
                com.tencent.mm.plugin.exdevice.f.a.e.a(this, this.iDX, this.iFt.field_championUrl, R.e.darkgrey);
                this.gaG = this.iFt.field_championUrl;
            }
        }
    }

    private void eA(boolean z) {
        if (z) {
            aIg();
        }
        if (bi.oW(this.iFr)) {
            this.iFn.setVisibility(8);
            return;
        }
        this.iFn.Av(this.iFu);
        this.iFn.setVisibility(0);
    }

    public final void b(String str, com.tencent.mm.plugin.exdevice.f.b.d dVar) {
        boolean z = (dVar == null || bi.oW(str)) ? false : true;
        Assert.assertTrue(z);
        if ("HardDeviceRankInfo".equals(str)) {
            if (this.iFs != null && this.iFs.equals(dVar.ixK)) {
                x.i("MicroMsg.Sport.ExdeviceRankInfoUI", "onRankChange, rankId(%s).", new Object[]{this.iFs});
                ez(true);
                if (bi.oW(this.iFu) || !this.iFu.equals(aIh())) {
                    aIg();
                    this.iFt = ad.aHi().Ah(this.iFu);
                    runOnUiThread(new 8(this));
                }
                runOnUiThread(new 9(this));
            }
        } else if ("HardDeviceChampionInfo".equals(str) && !bi.oW(this.iFu) && this.iFu.equals(dVar.username)) {
            this.iFt = ad.aHi().Ah(this.iFu);
            runOnUiThread(new 10(this));
        }
    }

    public final void Ae(String str) {
        x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank changed to %s", new Object[]{str});
        this.iFs = str;
    }

    public final void Ax(String str) {
        com.tencent.mm.plugin.sport.b.d.kB(6);
        Intent intent = new Intent(this, ExdeviceProfileUI.class);
        intent.putExtra("username", str);
        intent.putExtra("usernickname", (String) this.iEI.get(str));
        intent.putExtra("app_username", this.iFr);
        intent.putExtra("rank_id", this.iFs);
        startActivityForResult(intent, 4);
    }

    public final void aIk() {
        com.tencent.mm.plugin.sport.b.d.kB(31);
        aIl();
    }

    public final void bk(String str, int i) {
        ad.aHm();
        String str2 = this.iFs;
        String str3 = this.iFr;
        com.tencent.mm.plugin.exdevice.f.b.b.d aHf = ad.aHf();
        boolean z = (bi.oW(str2) || bi.oW(str) || (i != 1 && i != 0 && i != 2)) ? false : true;
        Assert.assertTrue(z);
        d a = aHf.a(new com.tencent.mm.plugin.exdevice.f.b.d(str2, null, str));
        if (a == null) {
            x.w("MicroMsg.ExdeviceRankInfoStg", "hy: info is null. abort");
        } else {
            a.field_selfLikeState = i;
            switch (a.field_selfLikeState) {
                case 0:
                    a.field_likecount--;
                    break;
                case 1:
                    a.field_likecount++;
                    break;
                default:
                    x.w("MicroMsg.ExdeviceRankInfoStg", "hy: still loading...abort");
                    break;
            }
            aHf.a(a, true);
        }
        com.tencent.mm.plugin.exdevice.f.b.c.c(str2, str3, str, i);
        this.iFF++;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (!com.tencent.mm.plugin.exdevice.f.a.e.a(this, i, i2, intent, this.iFr) && i2 == -1) {
            String stringExtra;
            switch (i) {
                case 1:
                    if (intent == null) {
                        x.e("MicroMsg.Sport.ExdeviceRankInfoUI", "onActivityResult, data is null.(reqestCode : %d)", new Object[]{Integer.valueOf(i)});
                        return;
                    }
                    stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        x.e("MicroMsg.Sport.ExdeviceRankInfoUI", "select conversation failed, toUser is null.");
                        return;
                    }
                    ac.a(this, stringExtra, ac.dc(this), intent.getStringExtra("custom_send_text"), this.iEg);
                    h.bA(this.mController.tml, getResources().getString(R.l.app_shared));
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Select conversation return.");
                    return;
                case 2:
                    h.bA(this.mController.tml, getResources().getString(R.l.app_shared));
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "Share to timeline return.");
                    return;
                case 3:
                    if (intent != null) {
                        List<String> F = bi.F(intent.getStringExtra("received_card_name").split(","));
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        for (String stringExtra3 : F) {
                            g.bcT().l("gh_43f2581f6fd6", stringExtra3, s.fq(stringExtra3));
                            if (!bi.oW(stringExtra2)) {
                                ow owVar = new ow();
                                owVar.bZQ.bZR = stringExtra3;
                                owVar.bZQ.content = stringExtra2;
                                owVar.bZQ.type = s.hQ(stringExtra3);
                                owVar.bZQ.flags = 0;
                                com.tencent.mm.sdk.b.a.sFg.m(owVar);
                            }
                        }
                        return;
                    }
                    return;
                case 4:
                    if (intent != null && intent.getBooleanExtra("KeyNeedUpdateRank", false)) {
                        aIe();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public final boolean Ay(String str) {
        if (bi.oW(this.iFs) || "#".equals(this.iFs)) {
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: rank id is not valid.abort the event");
            Toast.makeText(this, getString(R.l.exdevice_rank_id_not_ready), 0).show();
            return true;
        } else if (!q.GF().equals(str)) {
            return false;
        } else {
            x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "hy: is self. see who likes me");
            Intent intent = new Intent(this, ExdeviceLikeUI.class);
            intent.putExtra("app_username", this.iFr);
            intent.putExtra("rank_id", this.iFs);
            intent.putExtra("key_is_like_read_only", true);
            startActivity(intent);
            return true;
        }
    }

    private void aIl() {
        if (bi.oW(this.ixV)) {
            com.tencent.mm.plugin.exdevice.f.b.a.a Ah = ad.aHi().Ah(this.gtX);
            if (Ah != null) {
                this.ixV = Ah.field_championUrl;
            }
        }
        d f = b.f(this.gtX, this.iFy);
        String str = "--";
        String str2 = "0";
        if (f != null) {
            str = String.valueOf(f.field_ranknum);
            str2 = String.valueOf(f.field_score);
        }
        new ac().a(this, str, str2, this.ixV, new 11(this));
    }

    public final void a(j jVar) {
        runOnUiThread(new Runnable() {
            public final void run() {
                if (ExdeviceRankInfoUI.this.iBL != null && ExdeviceRankInfoUI.this.iBL.isShowing()) {
                    ExdeviceRankInfoUI.this.iBL.dismiss();
                    ExdeviceRankInfoUI.this.iBL = null;
                    x.d("MicroMsg.Sport.ExdeviceRankInfoUI", "dismiss tips dialog.");
                }
            }
        });
        this.iEf = jVar.ixy;
        this.iEg = jVar.ixz;
        this.ixV = jVar.ixV;
        this.ixU = jVar.ixU;
        this.ixI = jVar.ixI;
        this.iFy = jVar.ixN;
        this.iFx = jVar.ixO;
        this.iFw = this.iFk.b(this.iFx, this.iFy, this.ixU);
        runOnUiThread(new Runnable() {
            public final void run() {
                ExdeviceRankInfoUI.this.iFk.iEH = ExdeviceRankInfoUI.this.iFw;
                ExdeviceRankInfoUI.this.iFk.notifyDataSetChanged();
                ExdeviceRankInfoUI.this.iFo.setVisibility(0);
            }
        });
    }
}
