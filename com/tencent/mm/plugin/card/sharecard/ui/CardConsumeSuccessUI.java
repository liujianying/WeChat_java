package com.tencent.mm.plugin.card.sharecard.ui;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.g.a.bx;
import com.tencent.mm.plugin.card.a$a;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.d.r;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.card.sharecard.model.g;
import com.tencent.mm.plugin.card.sharecard.model.j;
import com.tencent.mm.plugin.card.sharecard.model.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.bmv;
import com.tencent.mm.protocal.c.bnk;
import com.tencent.mm.protocal.c.lf;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CardConsumeSuccessUI extends DrawStatusBarActivity implements e {
    private View FU;
    private final String TAG = "MicroMsg.CardConsumeSuccessUI";
    private OnClickListener eZF = new OnClickListener() {
        public final void onClick(View view) {
            if (view.getId() == d.accept_btn) {
                CardConsumeSuccessUI.a(CardConsumeSuccessUI.this);
            } else if (view.getId() == d.success_share_tv) {
                Intent intent = new Intent();
                intent.putExtra("KLabel_range_index", CardConsumeSuccessUI.this.hzB);
                intent.putExtra("Klabel_name_list", CardConsumeSuccessUI.this.hzC);
                intent.putExtra("Kother_user_name_list", CardConsumeSuccessUI.this.hzD);
                intent.putExtra("k_sns_label_ui_title", CardConsumeSuccessUI.this.getString(a$g.card_share_card_private_setting_title));
                intent.putExtra("k_sns_label_ui_style", 0);
                intent.putExtra("KLabel_is_filter_private", true);
                com.tencent.mm.bg.d.b(CardConsumeSuccessUI.this, "sns", ".ui.SnsLabelUI", intent, 1);
            }
        }
    };
    private p fUo = null;
    ag giD = new ag(Looper.getMainLooper());
    private String htC = "";
    private String huQ = "";
    int hzA = 0;
    public int hzB = 0;
    private String hzC = "";
    private String hzD = "";
    public ArrayList<String> hzE = new ArrayList();
    public ArrayList<String> hzF = new ArrayList();
    private TextView hzd;
    private TextView hze;
    private TextView hzp;
    private TextView hzq;
    private TextView hzr;
    private TextView hzs;
    private ImageView hzt;
    private Button hzu;
    private CheckBox hzv;
    private j hzw;
    private String hzx = "";
    private String hzy = "";
    int hzz = 0;
    private long mStartTime = 0;

    static /* synthetic */ void a(CardConsumeSuccessUI cardConsumeSuccessUI) {
        if (cardConsumeSuccessUI.hzw == null || cardConsumeSuccessUI.hzw.hyp == null || cardConsumeSuccessUI.hzw.hyp.isEmpty()) {
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list == null || mConsumedInfo.list.isEmpty()!");
            return;
        }
        cardConsumeSuccessUI.dO(true);
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardConsumeSuccessUI.hzw.hyp.size(); i++) {
            lf lfVar = ((q) cardConsumeSuccessUI.hzw.hyp.get(i)).hvZ;
            bmv bmv = new bmv();
            if (lfVar != null) {
                bmv.huU = lfVar.huU;
                cardConsumeSuccessUI.huQ = lfVar.huU;
            }
            bmv.cad = ((q) cardConsumeSuccessUI.hzw.hyp.get(i)).cad;
            bmv.qZO = "";
            bmv.qZN = "";
            bmv.qZP = cardConsumeSuccessUI.hzA;
            linkedList.add(bmv);
        }
        String str = cardConsumeSuccessUI.hzz == 1 ? cardConsumeSuccessUI.hzw.hyq : cardConsumeSuccessUI.htC;
        bnk f = l.f(cardConsumeSuccessUI.hzB, cardConsumeSuccessUI.hzE, cardConsumeSuccessUI.hzF);
        com.tencent.mm.ab.l gVar = cardConsumeSuccessUI.hzv.isChecked() ? new g(0, linkedList, cardConsumeSuccessUI.hzw.hys, str, f, 20, null) : new g(0, linkedList, "", str, f, 20, null);
        if (cardConsumeSuccessUI.hzv != null && cardConsumeSuccessUI.hzv.getVisibility() == 0) {
            if (cardConsumeSuccessUI.hzv.isChecked()) {
                h.mEJ.h(11324, new Object[]{"CardConsumeSuccessFollowServices", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            } else {
                h.mEJ.h(11324, new Object[]{"CardConsumeSuccessView", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
            }
        }
        com.tencent.mm.kernel.g.Eh().dpP.a(gVar, 0);
    }

    private void dO(boolean z) {
        if (z) {
            this.fUo = p.b(this, getString(a$g.loading_tips), true, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    protected final int getLayoutId() {
        return a$e.card_consume_success_ui;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.i("MicroMsg.CardConsumeSuccessUI", "onCreate()");
        this.mStartTime = System.currentTimeMillis();
        setMMTitle("");
        setResult(0);
        com.tencent.mm.kernel.g.Eh().dpP.a(902, this);
        com.tencent.mm.kernel.g.Eh().dpP.a(910, this);
        String str = "";
        this.hzz = getIntent().getIntExtra("key_from_scene", 0);
        if (this.hzz == 1) {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_JS");
            this.hzx = getIntent().getStringExtra("key_consumed_card_id");
            this.hzy = getIntent().getStringExtra("key_consumed_Code");
            if (TextUtils.isEmpty(this.hzx)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCardId is empty!");
                nP(0);
                finish();
                return;
            }
            x.i("MicroMsg.CardConsumeSuccessUI", "the mConsumdeCode is " + this.hzy);
            dO(true);
            com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.d("", this.hzx, this.hzy), 0);
            axN();
            this.hzA = 7;
        } else if (this.hzz == 2) {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_MSG_UI");
            this.htC = getIntent().getStringExtra("key_card_id");
            if (TextUtils.isEmpty(this.htC)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                nP(0);
                finish();
                return;
            }
            x.i("MicroMsg.CardConsumeSuccessUI", "the mCardId is " + this.htC);
            dO(true);
            com.tencent.mm.kernel.g.Eh().dpP.a(new com.tencent.mm.plugin.card.sharecard.model.d(this.htC, "", ""), 0);
            axN();
            this.hzA = 4;
        } else {
            x.i("MicroMsg.CardConsumeSuccessUI", "SCENE_FROM_CONSUMED_CODE");
            this.htC = getIntent().getStringExtra("KEY_CARD_ID");
            if (xD(getIntent().getStringExtra("KEY_CARD_CONSUMED_JSON"))) {
                String str2;
                if (!(this.hzw == null || bi.cX(this.hzw.hyp))) {
                    lf lfVar = ((q) this.hzw.hyp.get(0)).hvZ;
                    if (lfVar != null) {
                        str2 = lfVar.dxh;
                        if (bi.oW(str2)) {
                            str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                        }
                        this.hzA = getIntent().getIntExtra("key_stastic_scene", 0);
                        str = str2;
                    }
                }
                str2 = str;
                if (bi.oW(str2)) {
                    str2 = getIntent().getStringExtra("KEY_CARD_COLOR");
                }
                this.hzA = getIntent().getIntExtra("key_stastic_scene", 0);
                str = str2;
            } else {
                x.e("MicroMsg.CardConsumeSuccessUI", "the mCardId is empty!");
                nP(0);
                finish();
                return;
            }
        }
        h.mEJ.h(11324, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(0), "", "", Integer.valueOf(0), Integer.valueOf(this.hzA), "", Integer.valueOf(0), ""});
        initView();
        if (!TextUtils.isEmpty(str)) {
            xE(str);
        }
    }

    private boolean xD(String str) {
        if (TextUtils.isEmpty(str)) {
            x.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the consumed json is empty!");
            return false;
        }
        this.hzw = r.ye(str);
        if (this.hzw != null) {
            return true;
        }
        x.e("MicroMsg.CardConsumeSuccessUI", "parseCardConsumedJson the mConsumedInfo is null! json is " + str);
        return false;
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Eh().dpP.b(902, this);
        com.tencent.mm.kernel.g.Eh().dpP.b(910, this);
        long currentTimeMillis = System.currentTimeMillis() - this.mStartTime;
        if (TextUtils.isEmpty(this.htC)) {
            h.mEJ.h(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.hzz), this.huQ, this.hzx, Long.valueOf(currentTimeMillis)});
        } else {
            h.mEJ.h(13219, new Object[]{"CardConsumeSuccessUI", Integer.valueOf(this.hzz), this.huQ, this.htC, Long.valueOf(currentTimeMillis)});
        }
        super.onDestroy();
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.FU = this.mController.contentView;
        this.hzd = (TextView) findViewById(d.card_brand_name);
        this.hze = (TextView) findViewById(d.card_name);
        this.hzp = (TextView) findViewById(d.card_count);
        this.hzq = (TextView) findViewById(d.success_tips);
        this.hzr = (TextView) findViewById(d.success_share_tv);
        this.hzs = (TextView) findViewById(d.success_share_detail_tv);
        this.hzt = (ImageView) findViewById(d.card_img);
        this.hzu = (Button) findViewById(d.accept_btn);
        this.hzv = (CheckBox) findViewById(d.attention_checkbox);
        this.hzu.setOnClickListener(this.eZF);
        this.hzv.setOnClickListener(this.eZF);
        this.hzr.setOnClickListener(this.eZF);
        if (this.hzw != null) {
            aL();
        }
    }

    private void aL() {
        if (this.hzw == null) {
            x.e("MicroMsg.CardConsumeSuccessUI", "don't updateView() , mConsumedInfo is null");
            return;
        }
        findViewById(d.rootView).setVisibility(0);
        if (TextUtils.isEmpty(this.hzw.hyr) || TextUtils.isEmpty(this.hzw.hys)) {
            this.hzv.setVisibility(8);
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.subscribe_wording is empty or subscribe_app_username is empty!");
        } else {
            this.hzv.setText(this.hzw.hyr);
            this.hzv.setVisibility(0);
        }
        if (this.hzw.hyp == null || this.hzw.hyp.size() <= 0) {
            this.hzu.setEnabled(false);
            x.e("MicroMsg.CardConsumeSuccessUI", "mConsumedInfo.list is null!");
            return;
        }
        this.hzq.setText(getString(a$g.card_consumed_success_count_tip, new Object[]{Integer.valueOf(this.hzw.hyp.size())}));
        lf lfVar = ((q) this.hzw.hyp.get(0)).hvZ;
        if (lfVar != null) {
            xE(lfVar.dxh);
            this.hzd.setText(lfVar.hwh);
            this.hze.setText(lfVar.title);
            int dimensionPixelSize = getResources().getDimensionPixelSize(b.card_list_logo_height);
            if (TextUtils.isEmpty(lfVar.huW)) {
                x.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo.logo_url is empty!");
                this.hzt.setImageResource(c.my_card_package_defaultlogo);
            } else {
                a aVar = new a();
                aVar.dXB = com.tencent.mm.compatible.util.e.bnE;
                o.Pk();
                aVar.dXU = null;
                aVar.dXA = m.xr(lfVar.huW);
                aVar.dXy = true;
                aVar.dXW = true;
                aVar.dXw = true;
                aVar.dXF = dimensionPixelSize;
                aVar.dXE = dimensionPixelSize;
                aVar.dXN = c.my_card_package_defaultlogo;
                o.Pj().a(lfVar.huW, this.hzt, aVar.Pt());
            }
            if (TextUtils.isEmpty(lfVar.rnP)) {
                this.hzu.setText(a$g.card_consume_accept_btn);
                return;
            }
            x.e("MicroMsg.CardConsumeSuccessUI", "accept_wording is empty!");
            this.hzu.setText(lfVar.rnP);
            return;
        }
        x.e("MicroMsg.CardConsumeSuccessUI", "cardTpInfo is null!");
    }

    private void axN() {
        this.mController.contentView.setBackgroundColor(getResources().getColor(a$a.card_bg_color));
        findViewById(d.rootView).setVisibility(4);
    }

    @TargetApi(16)
    private void xE(String str) {
        int xV = l.xV(str);
        this.FU.setBackgroundColor(xV);
        lF(xV);
        com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, xV, true);
        if (com.tencent.mm.compatible.util.d.fR(16)) {
            this.hzu.setBackground(l.cm(xV, getResources().getDimensionPixelSize(b.card_accept_btn_height) / 2));
        } else {
            this.hzu.setBackgroundDrawable(l.cm(xV, getResources().getDimensionPixelSize(b.card_accept_btn_height) / 2));
        }
        this.FU.invalidate();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.ab.l lVar) {
        x.i("MicroMsg.CardConsumeSuccessUI", "onSceneEnd, errType = " + i + " errCode = " + i2 + " scene cmd is " + lVar.getType());
        dO(false);
        if (i == 0 && i2 == 0) {
            if (lVar instanceof g) {
                g gVar = (g) lVar;
                if (gVar.hwV == 0) {
                    com.tencent.mm.ui.base.h.bA(this, getString(a$g.card_accept_success_tips));
                    setResult(-1);
                    this.hzu.setEnabled(false);
                    l.azS();
                    x.i("MicroMsg.CardConsumeSuccessUI", "finish UI!");
                    nP(-1);
                    String str2 = ((g) lVar).hwU;
                    ShareCardInfo shareCardInfo = new ShareCardInfo();
                    f.a(shareCardInfo, str2);
                    l.a(shareCardInfo);
                    am.axp().auM();
                    finish();
                    return;
                }
                x.e("MicroMsg.CardConsumeSuccessUI", "shareNetscene.getRetCode() is " + gVar.hwV);
                com.tencent.mm.plugin.card.d.d.b(this, gVar.hwW);
                com.tencent.mm.ui.base.h.bA(this, getString(a$g.card_accept_fail_tips));
            } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) {
                com.tencent.mm.plugin.card.sharecard.model.d dVar = (com.tencent.mm.plugin.card.sharecard.model.d) lVar;
                if (dVar.hwV == 0) {
                    if (TextUtils.isEmpty(dVar.hwU) || !xD(dVar.hwU)) {
                        x.e("MicroMsg.CardConsumeSuccessUI", "consumed return json is empty, finish ui!");
                        if (this.hzz == 1) {
                            nP(0);
                            finish();
                            return;
                        }
                        axN();
                        xF(dVar.hwW);
                        if (bi.oW(dVar.hwW)) {
                            com.tencent.mm.ui.base.h.bA(this, getString(a$g.card_accept_over_limite));
                            return;
                        } else {
                            com.tencent.mm.ui.base.h.bA(this, dVar.hwW);
                            return;
                        }
                    }
                    x.i("MicroMsg.CardConsumeSuccessUI", "consumed return json is valid, update ui");
                    this.giD.post(new Runnable() {
                        public final void run() {
                            CardConsumeSuccessUI.this.aL();
                        }
                    });
                } else if (this.hzz == 1) {
                    nP(0);
                    finish();
                } else {
                    x.e("MicroMsg.CardConsumeSuccessUI", "succScene.getRetCode() is " + dVar.hwV);
                    axN();
                    xF(dVar.hwW);
                }
            }
        } else if ((lVar instanceof com.tencent.mm.plugin.card.sharecard.model.d) && this.hzz == 1) {
            nP(0);
            finish();
        } else {
            com.tencent.mm.plugin.card.d.d.b(this, str);
        }
    }

    private void xF(String str) {
        if (TextUtils.isEmpty(str)) {
            str = getString(a$g.card_accept_over_limite);
        }
        com.tencent.mm.ui.base.h.a(this, str, "", false, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                CardConsumeSuccessUI.nP(0);
                CardConsumeSuccessUI.this.finish();
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.e("MicroMsg.CardConsumeSuccessUI", "onKeyDown finishUI");
            nP(0);
            finish();
        }
        return super.onKeyDown(i, keyEvent);
    }

    private static void nP(int i) {
        x.i("MicroMsg.CardConsumeSuccessUI", "pushConsumedEvent resultCode is " + i);
        bx bxVar = new bx();
        bxVar.bJo.bjW = i;
        com.tencent.mm.sdk.b.a.sFg.m(bxVar);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1:
                if (i2 == -1) {
                    this.hzB = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.hzB)});
                    if (this.hzB >= 2) {
                        this.hzC = intent.getStringExtra("Klabel_name_list");
                        this.hzD = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardConsumeSuccessUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.hzB), this.hzC});
                        if (TextUtils.isEmpty(this.hzC) && TextUtils.isEmpty(this.hzD)) {
                            x.e("MicroMsg.CardConsumeSuccessUI", "mLabelNameList and mPrivateTmpUsers by getIntent is empty");
                            return;
                        }
                        List asList = Arrays.asList(this.hzC.split(","));
                        this.hzF = l.aB(asList);
                        this.hzE = l.aA(asList);
                        if (this.hzD != null && this.hzD.length() > 0) {
                            this.hzE.addAll(Arrays.asList(this.hzD.split(",")));
                        }
                        if (this.hzF != null) {
                            x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateIdsList size is " + this.hzF.size());
                        }
                        if (this.hzE != null) {
                            x.i("MicroMsg.CardConsumeSuccessUI", "mPrivateNamesList size is " + this.hzE.size());
                            Iterator it = this.hzE.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardConsumeSuccessUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (this.hzB == 2) {
                            this.hzs.setVisibility(0);
                            this.hzs.setText(getString(a$g.card_share_card_private_setting_share, new Object[]{axO()}));
                            return;
                        } else if (this.hzB == 3) {
                            this.hzs.setVisibility(0);
                            this.hzs.setText(getString(a$g.card_share_card_private_setting_not_share, new Object[]{axO()}));
                            return;
                        } else {
                            this.hzs.setVisibility(8);
                            return;
                        }
                    }
                    this.hzs.setVisibility(8);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String axO() {
        if (!TextUtils.isEmpty(this.hzC) && !TextUtils.isEmpty(this.hzD)) {
            return this.hzC + "," + l.xZ(this.hzD);
        }
        if (!TextUtils.isEmpty(this.hzC)) {
            return this.hzC;
        }
        if (TextUtils.isEmpty(this.hzD)) {
            return "";
        }
        return l.xZ(this.hzD);
    }
}
