package com.tencent.mm.plugin.card.ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.f;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.ab;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.statusbar.DrawStatusBarActivity;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class CardAcceptCardListUI extends DrawStatusBarActivity implements e, a {
    int cae = 8;
    private String dxx = "";
    private p fUo = null;
    HashMap<String, Integer> hAR = new HashMap();
    private View hAX;
    private View hAY;
    private View hAZ;
    protected a hBa = null;
    private View hBb;
    private View hBc;
    private TextView hBd;
    private Button hBe;
    LinkedList<ky> hBf = new LinkedList();
    int hBg = 7;
    String hBh = "";
    String hBi = "";
    private String hBj = "";
    LinkedList<ky> hBk = new LinkedList();
    LinkedList<String> hBl = new LinkedList();
    protected ListView htk = null;
    protected RelativeLayout htm = null;
    private boolean hvg = false;
    private String hxf = "";
    private int hxg;
    private String hxh;
    private int hxi;
    private String hxj;
    public int hzB = 0;
    private String hzC = "";
    private String hzD = "";
    public ArrayList<String> hzE = new ArrayList();
    public ArrayList<String> hzF = new ArrayList();
    private Button hzu;

    static /* synthetic */ LinkedList b(CardAcceptCardListUI cardAcceptCardListUI) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < cardAcceptCardListUI.hBf.size(); i++) {
            linkedList.add(cardAcceptCardListUI.hBf.get(i));
        }
        return linkedList;
    }

    static /* synthetic */ void c(CardAcceptCardListUI cardAcceptCardListUI) {
        x.i("MicroMsg.CardAcceptCardListUI", "doSelectShareUser");
        h.mEJ.h(11582, new Object[]{"OpenShareUserSelectView", Integer.valueOf(0), "", "", "", ""});
        Intent intent = new Intent();
        intent.putExtra("KLabel_range_index", cardAcceptCardListUI.hzB);
        intent.putExtra("Klabel_name_list", cardAcceptCardListUI.hzC);
        intent.putExtra("Kother_user_name_list", cardAcceptCardListUI.hzD);
        intent.putExtra("k_sns_label_ui_title", cardAcceptCardListUI.getString(g.card_share_card_private_setting_title));
        intent.putExtra("k_sns_label_ui_style", 0);
        intent.putExtra("KLabel_is_filter_private", true);
        d.b(cardAcceptCardListUI, "sns", ".ui.SnsLabelUI", intent, 2);
        cardAcceptCardListUI.geJ = cardAcceptCardListUI;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.card.a.e.card_accept_card_list_ui;
    }

    protected final void initView() {
        setMMTitle(g.card_accept_card_list_ui_title);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                x.v("MicroMsg.CardAcceptCardListUI", "setBackBtn cancel");
                CardAcceptCardListUI.this.nR(1);
                return true;
            }
        });
        this.hAX = findViewById(com.tencent.mm.plugin.card.a.d.card_accept_card_list_ui);
        this.hAY = findViewById(com.tencent.mm.plugin.card.a.d.top_layout);
        this.hAZ = findViewById(com.tencent.mm.plugin.card.a.d.list_layout);
        this.hAY.setVisibility(4);
        this.htk = (ListView) findViewById(16908298);
        this.htm = (RelativeLayout) findViewById(com.tencent.mm.plugin.card.a.d.content_no_data);
        this.htk.setEmptyView(this.htm);
        this.hBa = new a(this);
        this.htk.setAdapter(this.hBa);
        this.htk.setOnItemClickListener(new 2(this));
        this.hBb = findViewById(com.tencent.mm.plugin.card.a.d.card_accept_layout);
        this.hzu = (Button) findViewById(com.tencent.mm.plugin.card.a.d.card_accept_btn);
        this.hzu.setOnClickListener(new 3(this));
        this.hzu.setEnabled(false);
        this.hBc = findViewById(com.tencent.mm.plugin.card.a.d.card_private_setting_layout);
        this.hBd = (TextView) findViewById(com.tencent.mm.plugin.card.a.d.card_private_setting_tv);
        this.hBe = (Button) findViewById(com.tencent.mm.plugin.card.a.d.card_private_setting_btn);
        this.hBe.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                CardAcceptCardListUI.c(CardAcceptCardListUI.this);
            }
        });
        Intent intent = getIntent();
        if (intent == null) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () intent == null");
            nR(2);
            return;
        }
        x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI handle data");
        String stringExtra = intent.getStringExtra("key_in_card_list");
        this.cae = intent.getIntExtra("key_from_scene", 8);
        String stringExtra2 = intent.getStringExtra("key_package_name");
        String stringExtra3 = intent.getStringExtra("key_sign");
        this.hBg = getIntent().getIntExtra("key_stastic_scene", 7);
        this.hBh = getIntent().getStringExtra("src_username");
        this.hBi = getIntent().getStringExtra("js_url");
        this.hBj = getIntent().getStringExtra("key_consumed_card_id");
        this.dxx = getIntent().getStringExtra("key_template_id");
        Collection aZ = com.tencent.mm.plugin.card.d.h.aZ(stringExtra, this.cae);
        if (aZ == null || aZ.size() == 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI initView () tempList == null || tempList.size() == 0");
            nR(2);
            return;
        }
        this.hBf.clear();
        this.hBf.addAll(aZ);
        this.hBk.clear();
        this.hBl.clear();
        this.hAR.clear();
        LinkedList linkedList = this.hBf;
        dO(true);
        com.tencent.mm.kernel.g.Eh().dpP.a(new ab(linkedList, this.cae, stringExtra2, stringExtra3, this.hBh, this.hBi, this.hBj, this.hBg), 0);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.Eh().dpP.a(690, this);
        com.tencent.mm.kernel.g.Eh().dpP.a(687, this);
        com.tencent.mm.kernel.g.Eh().dpP.a(902, this);
        initView();
    }

    protected void onDestroy() {
        com.tencent.mm.kernel.g.Eh().dpP.b(690, this);
        com.tencent.mm.kernel.g.Eh().dpP.b(687, this);
        com.tencent.mm.kernel.g.Eh().dpP.b(902, this);
        this.hBf.clear();
        a aVar = this.hBa;
        aVar.hzT.clear();
        aVar.mContext = null;
        super.onDestroy();
    }

    final void dO(boolean z) {
        if (z) {
            this.fUo = p.b(this, getString(g.loading_tips), false, 0, null);
        } else if (this.fUo != null && this.fUo.isShowing()) {
            this.fUo.dismiss();
            this.fUo = null;
        }
    }

    public final void a(int i, int i2, String str, l lVar) {
        String str2;
        int dimensionPixelOffset;
        Intent intent;
        if (i != 0 || i2 != 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "CardAddEntranceUI onSceneEnd() netsene type" + lVar.getType() + "errType = " + i + " errCode = " + i2);
            dO(false);
            com.tencent.mm.plugin.card.d.d.b(this, str, i2);
            if (lVar instanceof com.tencent.mm.plugin.card.model.p) {
                this.hxf = str;
            } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
                this.hxf = "";
            }
        } else if (lVar instanceof ab) {
            dO(false);
            ab abVar = (ab) lVar;
            str2 = abVar.hwU;
            this.hxg = abVar.hxg;
            this.hxh = abVar.hxh;
            this.hxi = abVar.hxi;
            this.hxj = abVar.hxj;
            x.i("MicroMsg.CardAcceptCardListUI", "accept_button_status: " + this.hxg + "  accept_button_wording: " + this.hxh);
            x.i("MicroMsg.CardAcceptCardListUI", "private_status: " + this.hxi + "  private_wording: " + this.hxj);
            List xO = f.xO(str2);
            Collection ay = ay(xO);
            if (xO == null || xO.size() <= 0) {
                x.e("MicroMsg.CardAcceptCardListUI", "The card info list size is 0!");
            } else {
                x.i("MicroMsg.CardAcceptCardListUI", "The card info list size is " + xO.size());
                if (ay != null && ay.size() > 0) {
                    a aVar = this.hBa;
                    Map map = this.hAR;
                    if (ay != null) {
                        aVar.hzT.clear();
                        aVar.hzT.addAll(ay);
                        aVar.hAR.putAll(map);
                    }
                }
                this.hBa.notifyDataSetChanged();
                if (((CardInfo) xO.get(0)).avS()) {
                    this.hvg = true;
                }
            }
            this.hAY.setVisibility(0);
            if (this.hBa.getCount() > 0) {
                Drawable cm;
                CardInfo nQ = this.hBa.nQ(0);
                m.a(this, nQ);
                this.hAX.setBackgroundColor(com.tencent.mm.plugin.card.d.l.xV(nQ.awm().dxh));
                com.tencent.mm.ui.statusbar.a.c(this.mController.contentView, com.tencent.mm.plugin.card.d.l.xV(nQ.awm().dxh), true);
                this.hBb.setVisibility(0);
                Drawable stateListDrawable = new StateListDrawable();
                dimensionPixelOffset = getResources().getDimensionPixelOffset(b.card_member_widget_bg_round_radius);
                if (this.hxg == 1) {
                    this.hzu.setEnabled(true);
                    cm = com.tencent.mm.plugin.card.d.l.cm(com.tencent.mm.plugin.card.d.l.xV(nQ.awm().dxh), dimensionPixelOffset);
                    int[] iArr = new int[]{16842919};
                    stateListDrawable.addState(iArr, com.tencent.mm.plugin.card.d.l.cm(com.tencent.mm.plugin.card.d.l.bc(nQ.awm().dxh, 175), dimensionPixelOffset));
                    stateListDrawable.addState(new int[0], cm);
                } else {
                    this.hzu.setEnabled(false);
                    stateListDrawable.addState(new int[0], com.tencent.mm.plugin.card.d.l.cm(com.tencent.mm.plugin.card.d.l.bc(nQ.awm().dxh, 175), dimensionPixelOffset));
                }
                this.hzu.setBackgroundDrawable(stateListDrawable);
                if (!TextUtils.isEmpty(this.hxh)) {
                    this.hzu.setText(this.hxh);
                }
                if (this.hxi == 1) {
                    int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(b.NormalPadding);
                    Drawable e = com.tencent.mm.plugin.card.d.l.e(this, getResources().getColor(com.tencent.mm.plugin.card.a.a.white), dimensionPixelOffset2);
                    stateListDrawable = com.tencent.mm.plugin.card.d.l.cm(getResources().getColor(com.tencent.mm.plugin.card.a.a.white), dimensionPixelOffset2);
                    cm = new StateListDrawable();
                    cm.addState(new int[]{16842919}, stateListDrawable);
                    cm.addState(new int[0], e);
                    this.hBe.setBackgroundDrawable(cm);
                    int[] iArr2 = new int[]{com.tencent.mm.plugin.card.d.l.xV(nQ.awm().dxh), getResources().getColor(com.tencent.mm.plugin.card.a.a.white)};
                    this.hBe.setTextColor(new ColorStateList(new int[][]{new int[]{16842919, 16842910}, new int[0]}, iArr2));
                    this.hBc.setVisibility(0);
                    if (TextUtils.isEmpty(this.hxj)) {
                        this.hBd.setText(g.card_share_card_private_setting);
                        return;
                    } else {
                        this.hBd.setText(this.hxj);
                        return;
                    }
                }
                this.hBc.setVisibility(8);
                LayoutParams layoutParams = (LayoutParams) this.hAY.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(b.SmallPadding);
                layoutParams.bottomMargin = getResources().getDimensionPixelSize(b.LargestPadding);
                this.hAY.setLayoutParams(layoutParams);
                this.hAY.invalidate();
                layoutParams = (LayoutParams) this.hBb.getLayoutParams();
                layoutParams.addRule(8, com.tencent.mm.plugin.card.a.d.list_layout);
                this.hBb.setLayoutParams(layoutParams);
                this.hBb.invalidate();
                return;
            }
            this.hBb.setVisibility(8);
            this.hBc.setVisibility(8);
            this.hAX.setBackgroundColor(getResources().getColor(com.tencent.mm.plugin.card.a.a.card_bg_color));
        } else if (lVar instanceof com.tencent.mm.plugin.card.model.p) {
            dO(false);
            com.tencent.mm.plugin.card.model.p pVar = (com.tencent.mm.plugin.card.model.p) lVar;
            if (pVar.hwV != 0) {
                str2 = pVar.hwW;
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(g.card_add_fail);
                }
                com.tencent.mm.ui.base.h.a(this, str2, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.this.nR(2);
                    }
                });
                this.hxf = pVar.hwU;
                return;
            }
            com.tencent.mm.ui.base.h.bA(this, getResources().getString(g.card_has_accept_tips));
            intent = new Intent();
            intent.putExtra("card_list", pVar.hwU);
            setResult(-1, intent);
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for card");
            com.tencent.mm.plugin.card.d.l.azQ();
            finish();
        } else if (lVar instanceof com.tencent.mm.plugin.card.sharecard.model.g) {
            dO(false);
            String str3 = ((com.tencent.mm.plugin.card.sharecard.model.g) lVar).hwU;
            dimensionPixelOffset = ((com.tencent.mm.plugin.card.sharecard.model.g) lVar).hwV;
            str2 = ((com.tencent.mm.plugin.card.sharecard.model.g) lVar).hwW;
            this.hxf = str3;
            if (dimensionPixelOffset != 0) {
                if (TextUtils.isEmpty(str2)) {
                    str2 = getString(g.card_share_fail);
                }
                com.tencent.mm.ui.base.h.a(this, str2, null, false, new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        CardAcceptCardListUI.this.nR(2);
                    }
                });
                return;
            }
            com.tencent.mm.ui.base.h.bA(this, getResources().getString(g.card_accept_success_tips));
            intent = new Intent();
            intent.putExtra("card_list", this.hxf);
            setResult(-1, intent);
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI setResult RESULT_OK for sharecard");
            com.tencent.mm.plugin.card.d.l.azS();
            ShareCardInfo shareCardInfo = new ShareCardInfo();
            f.a(shareCardInfo, str3);
            com.tencent.mm.plugin.card.d.l.a(shareCardInfo);
            am.axp().auM();
            finish();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI onKeyDown() back cancel");
            nR(1);
        }
        return super.onKeyDown(i, keyEvent);
    }

    private void nR(int i) {
        x.i("MicroMsg.CardAcceptCardListUI", "CardAcceptCardListUI finishUI() result_code:" + i);
        Intent intent = new Intent();
        intent.putExtra("card_list", this.hxf);
        intent.putExtra("result_code", i);
        setResult(0, intent);
        finish();
    }

    public final void b(int i, int i2, Intent intent) {
        switch (i) {
            case 2:
                if (i2 == -1) {
                    this.hzB = intent.getIntExtra("Ktag_range_index", 0);
                    x.i("MicroMsg.CardAcceptCardListUI", "mPrivateSelelct : %d", new Object[]{Integer.valueOf(this.hzB)});
                    if (this.hzB >= 2) {
                        this.hzC = intent.getStringExtra("Klabel_name_list");
                        this.hzD = intent.getStringExtra("Kother_user_name_list");
                        x.d("MicroMsg.CardAcceptCardListUI", "mPrivateSelect : %d, names : %s", new Object[]{Integer.valueOf(this.hzB), this.hzC});
                        if (TextUtils.isEmpty(this.hzC) && TextUtils.isEmpty(this.hzD)) {
                            x.e("MicroMsg.CardAcceptCardListUI", "mLabelNameList by getIntent is empty");
                            ayc();
                            return;
                        }
                        List asList = Arrays.asList(this.hzC.split(","));
                        this.hzF = com.tencent.mm.plugin.card.d.l.aB(asList);
                        this.hzE = com.tencent.mm.plugin.card.d.l.aA(asList);
                        if (this.hzD != null && this.hzD.length() > 0) {
                            this.hzE.addAll(Arrays.asList(this.hzD.split(",")));
                        }
                        if (this.hzF != null) {
                            x.i("MicroMsg.CardAcceptCardListUI", "mPrivateIdsList size is " + this.hzF.size());
                        }
                        if (this.hzE != null) {
                            x.i("MicroMsg.CardAcceptCardListUI", "mPrivateNamesList size is " + this.hzE.size());
                            Iterator it = this.hzE.iterator();
                            while (it.hasNext()) {
                                x.d("MicroMsg.CardAcceptCardListUI", "username : %s", new Object[]{(String) it.next()});
                            }
                        }
                        if (TextUtils.isEmpty(this.hzC)) {
                            ayc();
                            return;
                        } else if (this.hzB == 2) {
                            this.hBd.setText(getString(g.card_share_card_private_setting_share, new Object[]{axO()}));
                            return;
                        } else if (this.hzB == 3) {
                            this.hBd.setText(getString(g.card_share_card_private_setting_not_share, new Object[]{axO()}));
                            return;
                        } else {
                            return;
                        }
                    }
                    ayc();
                    return;
                }
                return;
            default:
                return;
        }
    }

    private String axO() {
        if (!TextUtils.isEmpty(this.hzC) && !TextUtils.isEmpty(this.hzD)) {
            return this.hzC + "," + com.tencent.mm.plugin.card.d.l.xZ(this.hzD);
        }
        if (!TextUtils.isEmpty(this.hzC)) {
            return this.hzC;
        }
        if (TextUtils.isEmpty(this.hzD)) {
            return "";
        }
        return com.tencent.mm.plugin.card.d.l.xZ(this.hzD);
    }

    private void ayc() {
        if (TextUtils.isEmpty(this.hxj)) {
            this.hBd.setText(g.card_share_card_private_setting);
        } else {
            this.hBd.setText(this.hxj);
        }
    }

    private ArrayList<CardInfo> ay(List<CardInfo> list) {
        if (list == null || list.size() == 0) {
            x.e("MicroMsg.CardAcceptCardListUI", "geCardInfoListByTpId list is empty!");
            return null;
        }
        this.hBk.clear();
        this.hBl.clear();
        this.hAR.clear();
        ArrayList<CardInfo> arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return arrayList;
            }
            CardInfo cardInfo = (CardInfo) list.get(i2);
            if (this.hBl.contains(cardInfo.field_card_tp_id)) {
                this.hAR.put(cardInfo.field_card_tp_id, Integer.valueOf(((Integer) this.hAR.get(cardInfo.field_card_tp_id)).intValue() + 1));
            } else {
                arrayList.add(cardInfo);
                this.hAR.put(cardInfo.field_card_tp_id, Integer.valueOf(1));
                this.hBl.add(cardInfo.field_card_tp_id);
            }
            i = i2 + 1;
        }
    }
}
