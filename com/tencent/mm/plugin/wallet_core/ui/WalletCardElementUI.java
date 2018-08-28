package com.tencent.mm.plugin.wallet_core.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.c.y;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.plugin.wallet_core.model.Authen;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.ElementQuery;
import com.tencent.mm.plugin.wallet_core.model.FavorPayInfo;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wallet_core.ui.view.WalletPhoneInputView;
import com.tencent.mm.plugin.wxpay.a$f;
import com.tencent.mm.plugin.wxpay.a$g;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ListViewInScrollView;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class WalletCardElementUI extends WalletBaseUI implements OnEditorActionListener, a {
    private String countryCode;
    private String dDe;
    private String dDf;
    private Button eUb;
    private String kJy;
    private String kJz;
    private Orders mCZ = null;
    private PayInfo mCn = null;
    private TextView nZV;
    private Authen pfc = new Authen();
    a pgk = null;
    private c phJ = new 6(this);
    private WalletFormView phM;
    private TextView phN;
    private TextView phO;
    private int phQ = 1;
    private Profession[] pjD;
    private ElementQuery pkA = new ElementQuery();
    private Profession pkB;
    private WalletFormView psR;
    private Bankcard psS = null;
    private TextView ptA;
    private TextView ptB;
    private TextView ptC;
    private TextView ptD;
    private TextView ptE;
    private TextView ptF;
    private TextView ptG;
    private TextView ptH;
    private WalletFormView ptI;
    private WalletFormView ptJ;
    private WalletFormView ptK;
    private WalletFormView ptL;
    private WalletFormView ptM;
    private WalletFormView ptN;
    private WalletFormView ptO;
    private WalletFormView ptP;
    private WalletFormView ptQ;
    private WalletFormView ptR;
    private WalletFormView ptS;
    private WalletFormView ptT;
    private WalletFormView ptU;
    private WalletFormView ptV;
    private WalletPhoneInputView ptW;
    private ScrollView ptX;
    private WalletFormView ptY = null;
    private WalletFormView ptZ;
    private Map<String, a.a> pua = null;
    private boolean pub = false;
    private CheckBox puc;
    private CheckBox pud;
    private String pue;
    private boolean puf;
    private boolean pug;
    private String puh;
    private WalletFormView pui;
    private List<ElementQuery> puj = new ArrayList();
    private int puk;
    private BaseAdapter pul = new BaseAdapter() {
        public final int getCount() {
            return WalletCardElementUI.this.pkA.bOF() != null ? WalletCardElementUI.this.pkA.bOF().size() : 0;
        }

        private Integer zq(int i) {
            return (Integer) WalletCardElementUI.this.pkA.bOF().get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            CheckedTextView checkedTextView = (CheckedTextView) View.inflate(WalletCardElementUI.this, a$g.wallet_list_dialog_item_singlechoice, null);
            checkedTextView.setText(o.bPe().Q(WalletCardElementUI.this, zq(i).intValue()));
            if (WalletCardElementUI.this.phQ == zq(i).intValue()) {
                checkedTextView.setChecked(true);
            } else {
                checkedTextView.setChecked(false);
            }
            return checkedTextView;
        }
    };
    private OnClickListener pum = new OnClickListener() {
        public final void onClick(View view) {
            h.mEJ.h(11353, new Object[]{Integer.valueOf(2), Integer.valueOf(0)});
            e.e(WalletCardElementUI.this, o.bOW().aCl());
        }
    };

    protected /* synthetic */ Dialog onCreateDialog(int i) {
        switch (i) {
            case 1:
                View inflate = getLayoutInflater().inflate(a$g.wallet_list_dialog, null);
                ListViewInScrollView listViewInScrollView = (ListViewInScrollView) inflate.findViewById(a$f.address_contactlist);
                listViewInScrollView.setAdapter(this.pul);
                listViewInScrollView.setOnItemClickListener(new OnItemClickListener() {
                    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                        WalletCardElementUI.this.dismissDialog(1);
                        int intValue = ((Integer) WalletCardElementUI.this.pkA.bOF().get(i)).intValue();
                        if (WalletCardElementUI.this.phQ != intValue) {
                            WalletCardElementUI.this.phQ = intValue;
                            WalletCardElementUI.this.ptL.setText(((CheckedTextView) view).getText().toString());
                            WalletCardElementUI.a(WalletCardElementUI.this.phM, WalletCardElementUI.this.phQ);
                            WalletCardElementUI.this.phM.bqn();
                            WalletCardElementUI.this.aL();
                            WalletCardElementUI.this.zp(WalletCardElementUI.this.phQ);
                        }
                    }
                });
                com.tencent.mm.ui.widget.a.c.a aVar = new com.tencent.mm.ui.widget.a.c.a(this);
                aVar.Gq(i.wallet_card_cre_type_tip);
                aVar.dR(inflate);
                aVar.e(null);
                return aVar.anj();
            default:
                return com.tencent.mm.ui.base.h.b(this, getString(i.wallet_card_cre_type_tip), "", true);
        }
    }

    public void onCreate(Bundle bundle) {
        int i = 0;
        super.onCreate(bundle);
        this.pkA = (ElementQuery) this.sy.getParcelable("elemt_query");
        this.mCZ = (Orders) this.sy.getParcelable("key_orders");
        this.mCn = (PayInfo) this.sy.getParcelable("key_pay_info");
        this.phQ = o.bOW().bPy();
        this.psS = (Bankcard) this.sy.getParcelable("key_history_bankcard");
        this.puf = this.sy.getBoolean("key_need_area", false);
        this.pug = this.sy.getBoolean("key_need_profession", false);
        if (this.puf || this.pug) {
            setMMTitle(i.wallet_elment_title2);
        } else {
            setMMTitle(i.wallet_elment_title);
        }
        Parcelable[] parcelableArray = this.sy.getParcelableArray("key_profession_list");
        if (parcelableArray != null) {
            this.pjD = new Profession[parcelableArray.length];
            while (i < parcelableArray.length) {
                this.pjD[i] = (Profession) parcelableArray[i];
                i++;
            }
        }
        if (this.mCn == null) {
            this.mCn = new PayInfo();
        }
        x.d("MicroMsg.WalletCardElmentUI", "mPayInfo " + this.mCn);
        FavorPayInfo favorPayInfo = (FavorPayInfo) this.sy.getParcelable("key_favor_pay_info");
        if (!(this.mCZ == null || favorPayInfo == null)) {
            this.pgk = b.psB.a(this.mCZ);
            if (this.pgk != null) {
                this.pua = this.pgk.Pl(this.pgk.Pp(favorPayInfo.pnP));
            } else {
                x.w("MicroMsg.WalletCardElmentUI", " get favorLogicHelper null");
            }
        }
        initView();
        this.ptX.pageScroll(33);
        com.tencent.mm.plugin.wallet_core.e.c.b(this, this.sy, 3);
        com.tencent.mm.sdk.b.a.sFg.b(this.phJ);
    }

    protected final void initView() {
        this.ptA = (TextView) findViewById(a$f.wallet_card_forgot_id_tipmsg);
        this.ptZ = (WalletFormView) findViewById(a$f.wallet_card_forgot_id);
        com.tencent.mm.wallet_core.ui.formview.a.b(this.ptZ);
        this.ptB = (TextView) findViewById(a$f.wallet_card_forgot_id_err_tipmsg);
        this.phN = (TextView) findViewById(a$f.wallet_card_identify_tipmsg);
        this.psR = (WalletFormView) findViewById(a$f.name_et);
        com.tencent.mm.wallet_core.ui.formview.a.e(this, this.psR);
        this.ptL = (WalletFormView) findViewById(a$f.wallet_cre_type);
        this.phM = (WalletFormView) findViewById(a$f.identity_et);
        com.tencent.mm.wallet_core.ui.formview.a.d(this.phM);
        this.phO = (TextView) findViewById(a$f.wallet_card_identify_err_hint);
        this.ptC = (TextView) findViewById(a$f.wallet_card_bankcard_type_tipmsg);
        this.ptI = (WalletFormView) findViewById(a$f.wallet_card_name);
        this.pui = (WalletFormView) findViewById(a$f.wallet_card_type);
        this.ptD = (TextView) findViewById(a$f.wallet_card_cardtype_tipmsg);
        this.ptH = (TextView) findViewById(a$f.wallet_card_favor);
        this.ptE = (TextView) findViewById(a$f.wallet_card_cvv_tipmsg);
        this.ptK = (WalletFormView) findViewById(a$f.cvv_et);
        com.tencent.mm.wallet_core.ui.formview.a.b(this, this.ptK);
        this.ptJ = (WalletFormView) findViewById(a$f.date_et);
        com.tencent.mm.wallet_core.ui.formview.a.a(this, this.ptJ);
        this.ptF = (TextView) findViewById(a$f.wallet_card_cvv_err_tipmsg);
        this.nZV = (TextView) findViewById(a$f.wallet_card_address_tipmsg);
        this.ptP = (WalletFormView) findViewById(a$f.first_name_et);
        this.ptQ = (WalletFormView) findViewById(a$f.last_name_et);
        this.ptR = (WalletFormView) findViewById(a$f.area_et);
        this.ptS = (WalletFormView) findViewById(a$f.address_et);
        this.ptT = (WalletFormView) findViewById(a$f.phone_et);
        this.ptU = (WalletFormView) findViewById(a$f.post_et);
        this.ptV = (WalletFormView) findViewById(a$f.email_et);
        com.tencent.mm.wallet_core.ui.formview.a.e(this.ptV);
        this.ptG = (TextView) findViewById(a$f.wallet_card_address_err_tipmsg);
        this.puc = (CheckBox) findViewById(a$f.agree_wx_cb);
        this.pud = (CheckBox) findViewById(a$f.agree_follow_bank_cb);
        this.eUb = (Button) findViewById(a$f.next_btn);
        this.ptX = (ScrollView) findViewById(a$f.wallet_sv);
        this.ptN = (WalletFormView) findViewById(a$f.private_profession_et);
        this.ptO = (WalletFormView) findViewById(a$f.private_address_et);
        this.ptW = (WalletPhoneInputView) findViewById(a$f.mobile_new_et);
        this.ptM = this.ptW.getPhoneNumberEt();
        this.psR.setOnInputValidChangeListener(this);
        this.ptZ.setOnInputValidChangeListener(this);
        this.ptL.setOnInputValidChangeListener(this);
        this.phM.setOnInputValidChangeListener(this);
        this.ptM.setOnInputValidChangeListener(new a() {
            public final void fE(boolean z) {
                if (!z) {
                    WalletCardElementUI.this.psS = null;
                    WalletCardElementUI.this.sy.putParcelable("key_history_bankcard", null);
                }
                WalletCardElementUI.this.ZB();
            }
        });
        this.ptK.setOnInputValidChangeListener(this);
        this.ptJ.setOnInputValidChangeListener(this);
        this.ptP.setOnInputValidChangeListener(this);
        this.ptQ.setOnInputValidChangeListener(this);
        this.ptR.setOnInputValidChangeListener(this);
        this.ptS.setOnInputValidChangeListener(this);
        this.ptT.setOnInputValidChangeListener(this);
        this.ptU.setOnInputValidChangeListener(this);
        this.ptV.setOnInputValidChangeListener(this);
        this.ptN.setOnInputValidChangeListener(this);
        this.ptO.setOnInputValidChangeListener(this);
        this.psR.setOnEditorActionListener(this);
        this.ptZ.setOnEditorActionListener(this);
        this.ptL.setOnEditorActionListener(this);
        this.phM.setOnEditorActionListener(this);
        this.ptM.setOnEditorActionListener(this);
        this.ptK.setOnEditorActionListener(this);
        this.ptJ.setOnEditorActionListener(this);
        this.ptP.setOnEditorActionListener(this);
        this.ptQ.setOnEditorActionListener(this);
        this.ptR.setOnEditorActionListener(this);
        this.ptS.setOnEditorActionListener(this);
        this.ptT.setOnEditorActionListener(this);
        this.ptU.setOnEditorActionListener(this);
        this.ptV.setOnEditorActionListener(this);
        this.ptO.setOnEditorActionListener(this);
        this.ptN.setOnEditorActionListener(this);
        this.ptI.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("key_support_bankcard", WalletCardElementUI.this.sy.getInt("key_support_bankcard", 3));
                bundle.putInt("key_bind_scene", WalletCardElementUI.this.sy.getInt("key_bind_scene", -1));
                if (!bi.oW(WalletCardElementUI.this.ptI.getText())) {
                    bundle.putString("key_bank_type", WalletCardElementUI.this.pkA.lMV);
                    bundle.putInt("key_bankcard_type", WalletCardElementUI.this.pkA.pnt);
                }
                WalletCardElementUI.this.Wq();
                com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(WalletCardElementUI.this);
                if (af != null) {
                    af.a(WalletCardElementUI.this, WalletBankCardSelectUI.class, bundle, 1);
                }
            }
        });
        this.pui.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(WalletCardElementUI.this.getString(i.wallet_deposit_card));
                arrayList.add(WalletCardElementUI.this.getString(i.wallet_credit_card));
                if (WalletCardElementUI.this.puj.size() == 1) {
                    ElementQuery elementQuery = (ElementQuery) WalletCardElementUI.this.puj.get(0);
                    if (elementQuery.bOE()) {
                        arrayList.remove(1);
                    } else if (elementQuery.bOu()) {
                        arrayList.remove(0);
                    }
                }
                b bVar = new b(WalletCardElementUI.this.mController.tml, arrayList);
                bVar.GC(WalletCardElementUI.this.puk);
                bVar.uLl = new 1(this, bVar);
                bVar.GB(com.tencent.mm.bp.a.fromDPToPix(WalletCardElementUI.this.mController.tml, 288));
                bVar.show();
            }
        });
        this.ptL.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                WalletCardElementUI.this.showDialog(1);
            }
        });
        this.ptO.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("GetAddress", true);
                intent.putExtra("ShowSelectedLocation", false);
                if (!Bankcard.zj(WalletCardElementUI.this.pkA.pjA)) {
                    intent.putExtra("IsRealNameVerifyScene", true);
                    intent.putExtra("IsNeedShowSearchBar", true);
                }
                d.b(WalletCardElementUI.this.mController.tml, ".ui.tools.MultiStageCitySelectUI", intent, 4);
            }
        });
        this.ptN.setOnClickListener(new 11(this));
        this.puc.setChecked(true);
        this.puc.setOnCheckedChangeListener(new 12(this));
        findViewById(a$f.agree_btn).setOnClickListener(new 13(this));
        this.ptR.setOnClickListener(new 14(this));
        this.eUb.setOnClickListener(new 2(this));
        d(this.ptZ, 0, false);
        d(this.phM, 1, false);
        a(this.ptM, 0, false, true, true);
        if (this.pkA != null && !bi.oW(this.pkA.pnz)) {
            com.tencent.mm.ui.base.h.a(this, this.pkA.pnz, null, true, null);
            this.pkA = null;
        } else if (this.sy.getInt("key_bind_scene", -1) == 5 && !this.pkA.pnO) {
            com.tencent.mm.ui.base.h.a(this, getString(i.wallet_wx_offline_no_support_micropay_dialog_content), null, true, null);
            this.pkA.knE = null;
        }
        aL();
        ZB();
        com.tencent.mm.wallet_core.c af = com.tencent.mm.wallet_core.a.af(this);
        if (af != null && af.cCT()) {
            Orders orders = (Orders) this.sy.getParcelable("key_orders");
            if (orders == null || orders.poP != 1) {
                this.pub = false;
                return;
            }
            this.pub = true;
            this.psR.setText(e.abZ(orders.plj));
            this.psR.setEnabled(false);
            this.psR.setFocusable(false);
            this.phQ = orders.poR;
            this.ptL.setText(o.bPe().Q(this, this.phQ));
            this.ptL.setEnabled(false);
            this.phM.setText(orders.poQ);
            this.phM.setEnabled(false);
            this.phM.setFocusable(false);
            this.phN.setText(i.wallet_card_assigned_userinfo_tips);
        }
    }

    private void aL() {
        if (this.pkA == null) {
            this.pkA = new ElementQuery();
        }
        if (this.pkA.pnN == 0) {
            this.ptW.bQN();
        } else {
            this.ptW.bQO();
            a(this.ptW.getPhoneNumberEt(), (EditText) this.ptW.findViewById(a$f.prefix_input_et), 0, false, false, true);
        }
        if (this.pkA == null || this.pua == null || !this.pua.containsKey(this.pkA.lMV)) {
            this.ptH.setVisibility(8);
        } else {
            double d;
            a.a aVar = (a.a) this.pua.get(this.pkA.lMV);
            if (aVar == null || aVar.psy == null) {
                d = 0.0d;
            } else {
                d = aVar.psz;
            }
            this.ptH.setText(getString(i.wallet_card_bank_favor_tips, new Object[]{e.B(d)}));
            this.ptH.setVisibility(0);
        }
        com.tencent.mm.wallet_core.a.af(this);
        Bankcard bankcard = (Bankcard) this.sy.getParcelable("key_bankcard");
        if (!bQd() || bankcard == null) {
            if (!bi.oW(this.pkA.knE)) {
                this.ptI.setText(this.pkA.knE);
                if (this.pkA.bOu()) {
                    this.pui.setVisibility(0);
                    this.pui.setText(getString(i.wallet_credit_card));
                } else if (this.pkA.bOE()) {
                    this.pui.setVisibility(0);
                    this.pui.setText(getString(i.wallet_deposit_card));
                }
            }
            a(new boolean[]{false}, new WalletFormView[]{this.ptZ}, this.ptA, this.ptB, true);
            a(new boolean[]{true}, new WalletFormView[]{this.ptI}, this.ptC, this.ptD, true);
            this.ptZ.setOnInfoIvClickListener(this.pum);
            if (o.bOW().bPw().bPk()) {
                this.ptZ.getInfoIv().setImageResource(a$h.wallet_scan_camera);
                this.ptZ.getInfoIv().setVisibility(0);
            } else {
                this.ptZ.getInfoIv().setVisibility(4);
            }
        } else {
            this.ptZ.setHint(getString(i.wallet_card_forgot_id_hint, new Object[]{bankcard.field_bankcardTail}));
            a(new boolean[]{true}, new WalletFormView[]{this.ptZ}, this.ptA, this.ptB);
            a(new boolean[]{false}, new WalletFormView[]{this.ptI}, this.ptC, this.ptD);
        }
        if (Bankcard.zj(this.pkA.pjA)) {
            a(new boolean[]{false, false, false}, new WalletFormView[]{this.psR, this.ptL, this.phM}, this.phN, this.phO);
            this.ptM.setVisibility(8);
            ju(true);
            this.ptO.setVisibility(8);
            this.ptN.setVisibility(8);
            findViewById(a$f.wallet_card_private_info_tipmsg).setVisibility(8);
        } else {
            boolean z = this.pkA.bOF() != null && this.pkA.bOF().size() > 0;
            if (bQd() || o.bOW().bPp()) {
                if (bi.oW(o.bOW().aCl())) {
                    this.psR.setHint(getString(i.wallet_card_username_hint));
                } else {
                    this.psR.setHint(getString(i.wallet_card_username_hint_forget, new Object[]{e.abZ(o.bOW().aCl())}));
                }
                a(new boolean[]{true, z, true}, new WalletFormView[]{this.psR, this.ptL, this.phM}, this.phN, this.phO);
                this.ptM.setVisibility(0);
            } else {
                boolean[] zArr = new boolean[3];
                zArr[0] = this.pkA.pnm;
                if (z && this.pkA.pnn) {
                    z = true;
                } else {
                    z = false;
                }
                zArr[1] = z;
                zArr[2] = this.pkA.pnn;
                a(zArr, new WalletFormView[]{this.psR, this.ptL, this.phM}, this.phN, this.phO);
                this.ptM.setVisibility(0);
                x.i("MicroMsg.WalletCardElmentUI", "elemt canModifyName:" + this.pkA.pnm + " canModifyIdentity:" + this.pkA.pnn);
            }
            if (this.psS != null) {
                if (!bi.oW(this.psS.field_mobile)) {
                    a(this.ptM, this.psS.field_mobile);
                }
                if (!bi.oW(this.psS.pln)) {
                    a(this.ptK, this.psS.pln);
                }
                if (!bi.oW(this.psS.plS)) {
                    a(this.ptJ, this.psS.plS);
                }
            }
            if (this.pkA.pnm) {
                this.phO.setText("");
            } else {
                this.phO.setText(getString(i.wallet_card_identify_security));
            }
            if (!bQd() || o.bOW().bPy() <= 0) {
                if (this.pul.getCount() <= 1) {
                    this.ptL.setClickable(false);
                    this.ptL.setEnabled(false);
                } else {
                    this.ptL.setClickable(true);
                    this.ptL.setEnabled(true);
                }
                List bOF = this.pkA.bOF();
                if (bOF == null || !bOF.contains(Integer.valueOf(this.phQ))) {
                    this.phQ = 1;
                }
                this.ptL.setText(o.bPe().Q(this, this.phQ));
            } else {
                this.ptL.setClickable(false);
                this.ptL.setText(o.bPe().Q(this, o.bOW().bPy()));
                this.ptL.setEnabled(false);
                a(this.phM, this.phQ);
            }
            zp(this.phQ);
            ju(false);
            if (this.puf) {
                this.ptO.setVisibility(0);
            } else {
                this.ptO.setVisibility(8);
            }
            if (this.pug) {
                this.ptN.setVisibility(0);
            } else {
                this.ptN.setVisibility(8);
            }
            if (this.puf || this.pug) {
                findViewById(a$f.wallet_card_private_info_tipmsg).setVisibility(0);
            } else {
                findViewById(a$f.wallet_card_private_info_tipmsg).setVisibility(8);
            }
        }
        a(new boolean[]{this.pkA.pno, this.pkA.pnp}, new WalletFormView[]{this.ptK, this.ptJ}, this.ptE, this.ptF);
        if (this.ptI.getVisibility() == 0) {
            switch (this.pkA.pns) {
                case 1:
                    this.ptD.setVisibility(8);
                    break;
                case 2:
                    this.ptD.setVisibility(8);
                    break;
                case 3:
                    this.ptD.setText(i.wallet_card_cardtype_tipmsg_cn);
                    this.ptD.setVisibility(0);
                    break;
                case 4:
                    this.ptD.setVisibility(8);
                    break;
                default:
                    this.ptD.setVisibility(8);
                    break;
            }
            this.ptD.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.normal_color));
        } else {
            this.ptD.setVisibility(8);
        }
        if (!(bi.oW(this.pkA.pnM) || this.ptD.getVisibility() == 0)) {
            x.i("MicroMsg.WalletCardElmentUI", "show pre auth word");
            this.ptD.setText(this.pkA.pnM);
            this.ptD.setVisibility(0);
        }
        if (bi.oW(this.pkA.pnx) || !s.he(this.pkA.pnx) || bQd()) {
            this.pud.setVisibility(8);
            return;
        }
        this.pud.setText(this.pkA.pny);
        this.pud.setVisibility(0);
    }

    private static void a(WalletFormView walletFormView, String str) {
        if (bi.oW(str)) {
            walletFormView.setVisibility(8);
            return;
        }
        KeyListener keyListener = walletFormView.getKeyListener();
        walletFormView.setKeyListener(null);
        walletFormView.setEnabled(false);
        walletFormView.setClickable(false);
        walletFormView.setText(str);
        walletFormView.setKeyListener(keyListener);
        walletFormView.setVisibility(0);
    }

    private void ju(boolean z) {
        int i = 0;
        if (z) {
            int i2;
            this.nZV.setVisibility(this.pkA.pnA ? 0 : 8);
            WalletFormView walletFormView = this.ptP;
            if (this.pkA.pnA) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.ptQ;
            if (this.pkA.pnB) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.ptR;
            if (this.pkA.pnC) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.ptS;
            if (this.pkA.pnF) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.ptT;
            if (this.pkA.pnH) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            walletFormView = this.ptU;
            if (this.pkA.pnG) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            walletFormView.setVisibility(i2);
            WalletFormView walletFormView2 = this.ptV;
            if (!this.pkA.pnI) {
                i = 8;
            }
            walletFormView2.setVisibility(i);
            this.ptG.setVisibility(4);
            return;
        }
        this.nZV.setVisibility(8);
        this.ptP.setVisibility(8);
        this.ptQ.setVisibility(8);
        this.ptR.setVisibility(8);
        this.ptS.setVisibility(8);
        this.ptT.setVisibility(8);
        this.ptU.setVisibility(8);
        this.ptV.setVisibility(8);
        this.ptG.setVisibility(8);
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2, boolean z) {
        int length = zArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (zArr[i2]) {
                i = 1;
                walletFormViewArr[i2].setVisibility(0);
            } else {
                walletFormViewArr[i2].setVisibility(8);
            }
        }
        if (i != 0) {
            textView.setVisibility(0);
            if (textView2 == null) {
                return;
            }
            if (z) {
                textView2.setVisibility(8);
                return;
            } else {
                textView2.setVisibility(4);
                return;
            }
        }
        textView.setVisibility(8);
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
    }

    private static void a(boolean[] zArr, WalletFormView[] walletFormViewArr, TextView textView, TextView textView2) {
        a(zArr, walletFormViewArr, textView, textView2, false);
    }

    private void bQc() {
        if (ZB()) {
            String text;
            com.tencent.mm.plugin.wallet_core.e.c.bQW();
            if (!bi.oW(this.pkA.pnx)) {
                Bundle bundle = this.sy;
                String str = "key_is_follow_bank_username";
                boolean z = this.pud.getVisibility() == 0 && this.pud.isChecked();
                bundle.putBoolean(str, z);
                this.sy.putString("key_bank_username", this.pkA.pnx);
            }
            FavorPayInfo favorPayInfo = (FavorPayInfo) this.sy.getParcelable("key_favor_pay_info");
            if (!(this.pkA == null || favorPayInfo == null || this.pgk == null || this.pua == null)) {
                if (this.pua.containsKey(this.pkA.lMV)) {
                    favorPayInfo.pnP = ((a.a) this.pua.get(this.pkA.lMV)).psy.pem;
                } else {
                    favorPayInfo.pnP = this.pgk.bb(favorPayInfo.pnP, false);
                }
                this.sy.putParcelable("key_favor_pay_info", favorPayInfo);
            }
            this.pfc = new Authen();
            if (this.psS != null) {
                this.pfc.lMW = this.psS.plT;
                this.pfc.plp = this.psS.field_bankcardTail;
            }
            String string = this.sy.getString("key_card_id");
            if (this.ptZ.getVisibility() == 0) {
                text = this.ptZ.getText();
            } else {
                text = string;
            }
            this.pfc.mpb = (PayInfo) this.sy.getParcelable("key_pay_info");
            this.pfc.plm = text;
            this.pfc.lMV = this.pkA.lMV;
            this.pfc.pll = this.phQ;
            this.pfc.pli = this.sy.getString("key_pwd1");
            if (!bi.oW(this.ptK.getText())) {
                this.pfc.pln = this.ptK.getText();
            }
            this.pfc.pjw = this.ptM.getText();
            this.pfc.plr = this.ptP.getText();
            this.pfc.pls = this.ptQ.getText();
            this.pfc.country = this.pue;
            this.pfc.csK = this.kJy;
            this.pfc.csL = this.kJz;
            this.pfc.dRH = this.ptS.getText();
            this.pfc.knG = this.ptT.getText();
            this.pfc.eXM = this.ptU.getText();
            this.pfc.csD = this.ptV.getText();
            text = e.aca(this.pfc.pjw);
            this.sy.putString("key_mobile", text);
            this.sy.putBoolean("key_is_oversea", this.pkA.pjA == 2);
            this.pfc.plk = this.phM.getText();
            this.pfc.plj = this.psR.getText();
            this.pfc.plo = this.ptJ.getText();
            favorPayInfo = (FavorPayInfo) this.sy.getParcelable("key_favor_pay_info");
            if (favorPayInfo != null) {
                this.pfc.plt = favorPayInfo.pnS;
                this.pfc.plu = favorPayInfo.pnP;
            }
            this.pfc.plz = "+" + this.ptW.getCountryCode();
            x.d("MicroMsg.WalletCardElmentUI", "payInfo " + this.pfc.mpb + " elemt.bankcardTag : " + this.pkA.pjA);
            x.i("MicroMsg.WalletCardElmentUI", " elemt.bankcardTag : " + this.pkA.pjA);
            Bundle bundle2 = this.sy;
            bundle2.putString("key_mobile", text);
            bundle2.putParcelable("key_authen", this.pfc);
            bundle2.putString("key_bank_phone", this.pkA.pnw);
            bundle2.putString("key_country_code", this.countryCode);
            bundle2.putString("key_province_code", this.dDf);
            bundle2.putString("key_city_code", this.dDe);
            bundle2.putParcelable("key_profession", this.pkB);
            bundle2.putString("key_bind_card_type", this.pfc.lMV);
            bundle2.putString("key_bind_card_show1", this.pkA.knE);
            bundle2.putString("key_bind_card_show2", 2 == this.pkA.pnt ? getString(i.wallet_credit_card) : getString(i.wallet_deposit_card));
            if (cDL().m(new Object[]{this.pfc, this.mCZ})) {
                x.i("MicroMsg.WalletCardElmentUI", "process controller deal with!!!");
            } else {
                x.e("MicroMsg.WalletCardElmentUI", "error process in the tenpay!!");
            }
        }
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.WalletCardElmentUI", " errCode: " + i2 + " errMsg :" + str);
        if (i != 0 || i2 != 0) {
            return false;
        }
        Bundle bundle = this.sy;
        x.d("MicroMsg.WalletCardElmentUI", "PayInfo  " + this.mCn);
        if (!(lVar instanceof y)) {
            return false;
        }
        x.i("MicroMsg.WalletCardElmentUI", "query bound bank card resp, forwardProcess");
        com.tencent.mm.wallet_core.a.j(this, bundle);
        return true;
    }

    protected final int getLayoutId() {
        return a$g.wallet_card_element_ui;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        x.i("MicroMsg.WalletCardElmentUI", "onAcvityResult requestCode:" + i);
        if (!this.ptW.d(i, i2, intent) && i2 == -1) {
            String stringExtra;
            String stringExtra2;
            String stringExtra3;
            switch (i) {
                case 1:
                    this.pkA = null;
                    this.puk = 0;
                    this.puh = intent.getStringExtra("bank_name");
                    this.ptI.setText(this.puh);
                    this.pui.setVisibility(0);
                    this.pui.setText("");
                    List<ElementQuery> list = o.bPe().pjy;
                    this.puj.clear();
                    if (list != null) {
                        for (ElementQuery elementQuery : list) {
                            if (elementQuery.knE.equals(this.puh)) {
                                this.puj.add(elementQuery);
                                if (this.sy.getInt("key_bind_scene", -1) == 5 && !elementQuery.pnO) {
                                    elementQuery.pnz = getString(i.wallet_wx_offline_no_support);
                                }
                                if (this.puj.size() >= 2) {
                                }
                            }
                        }
                    }
                    if (this.puj.size() == 1) {
                        this.pkA = (ElementQuery) this.puj.get(0);
                    }
                    this.psS = null;
                    aL();
                    break;
                case 2:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("Country");
                    this.pue = stringExtra + "|" + stringExtra2;
                    stringExtra3 = intent.getStringExtra("ProviceName");
                    String stringExtra4 = intent.getStringExtra("CityName");
                    if (!bi.oW(intent.getStringExtra("Contact_City"))) {
                        this.kJy = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.kJz = stringExtra4 + "|" + intent.getStringExtra("Contact_City");
                        if (bi.oW(stringExtra)) {
                            this.ptR.setText(stringExtra3 + " " + stringExtra4);
                        } else {
                            this.ptR.setText(stringExtra + " " + stringExtra4);
                        }
                    } else if (bi.oW(intent.getStringExtra("Contact_Province"))) {
                        this.kJz = this.pue;
                        this.ptR.setText(stringExtra);
                    } else {
                        this.kJz = stringExtra3 + "|" + intent.getStringExtra("Contact_Province");
                        this.ptR.setText(stringExtra + " " + stringExtra3);
                    }
                    if ("US".equals(stringExtra2) || "CA".equals(stringExtra2) || this.pkA.pnG) {
                        this.ptU.setVisibility(0);
                    } else {
                        this.ptU.setVisibility(8);
                    }
                    x.i("MicroMsg.WalletCardElmentUI", "onActivityResult for address countryName %s,countryCode %s, provinceName %s, cityName %s, mCity %s", new Object[]{stringExtra, stringExtra2, stringExtra3, stringExtra4, this.kJz});
                    break;
                case 3:
                    this.ptZ.set3DesValStr(intent.getStringExtra("key_bankcard_id"));
                    break;
                case 4:
                    stringExtra = intent.getStringExtra("CountryName");
                    stringExtra2 = intent.getStringExtra("ProviceName");
                    stringExtra3 = intent.getStringExtra("CityName");
                    this.countryCode = intent.getStringExtra("Country");
                    this.dDf = intent.getStringExtra("Contact_Province");
                    this.dDe = intent.getStringExtra("Contact_City");
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!bi.oW(stringExtra)) {
                        stringBuilder.append(stringExtra);
                    }
                    if (!bi.oW(stringExtra2)) {
                        stringBuilder.append(" ").append(stringExtra2);
                    }
                    if (!bi.oW(stringExtra3)) {
                        stringBuilder.append(" ").append(stringExtra3);
                    }
                    this.ptO.setText(stringBuilder.toString());
                    break;
                case 5:
                    this.pkB = (Profession) intent.getParcelableExtra("key_select_profession");
                    this.ptN.setText(this.pkB.pkT);
                    break;
            }
            ZB();
        }
    }

    private boolean ZB() {
        boolean z;
        boolean z2;
        WalletFormView walletFormView = this.ptY;
        this.ptY = null;
        if (this.ptI.dX(null)) {
            z = true;
        } else {
            if (this.ptY == null && walletFormView != this.ptI) {
                this.ptY = this.ptI;
            }
            this.ptD.setText(i.wallet_card_bankcard_type_err_tips);
            this.ptD.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
            z = false;
        }
        if (!this.psR.dX(null)) {
            if (this.ptY == null && walletFormView != this.psR) {
                this.ptY = this.psR;
            }
            z = false;
        }
        if (!this.ptZ.dX(this.ptB)) {
            if (this.ptY == null && walletFormView != this.ptZ) {
                this.ptY = this.ptZ;
            }
            z = false;
        }
        if (this.phM.dX(this.phO) || this.pub) {
            z2 = false;
        } else {
            if (this.ptY == null && walletFormView != this.phM) {
                this.ptY = this.phM;
            }
            this.phO.setText(i.wallet_card_identify_err_hint);
            this.phO.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
            z2 = true;
            z = false;
        }
        if (!this.ptM.dX(this.phO)) {
            if (z2) {
                this.phO.setText(i.wallet_card_err_id_phone);
                this.phO.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
            } else {
                this.phO.setText(i.wallet_card_err_phone);
                this.phO.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.red));
            }
            if (this.ptY == null && walletFormView != this.ptM) {
                this.ptY = this.ptM;
            }
            z = false;
        } else if (z2) {
            this.phO.setVisibility(0);
        }
        if (this.phO.getVisibility() == 4) {
            if (this.pkA.pnm) {
                this.phO.setText(getString(i.wallet_card_identify_first_tips));
            } else {
                this.phO.setText(getString(i.wallet_card_identify_security));
            }
            this.phO.setTextColor(getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color));
            this.phO.setVisibility(0);
        }
        if (this.ptK.dX(this.ptF)) {
            z2 = false;
        } else {
            if (this.ptY == null && walletFormView != this.ptK) {
                this.ptY = this.ptK;
            }
            z2 = true;
            z = false;
        }
        if (!this.ptJ.dX(this.ptF)) {
            if (this.ptY == null && walletFormView != this.ptJ) {
                this.ptY = this.ptJ;
            }
            z = false;
        } else if (z2) {
            this.ptF.setVisibility(4);
        }
        if (!this.puc.isChecked()) {
            z = false;
        }
        if (!this.ptP.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptP) {
                this.ptY = this.ptP;
            }
            z = false;
        }
        if (!this.ptQ.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptQ) {
                this.ptY = this.ptQ;
            }
            z = false;
        }
        if (!this.ptR.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptR) {
                this.ptY = this.ptR;
            }
            z = false;
        }
        if (!this.ptS.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptS) {
                this.ptY = this.ptS;
            }
            z = false;
        }
        if (!this.ptT.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptT) {
                this.ptY = this.ptT;
            }
            z = false;
        }
        if (!this.ptU.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptU) {
                this.ptY = this.ptU;
            }
            z = false;
        }
        if (!this.ptV.dX(this.ptG)) {
            if (this.ptY == null && walletFormView != this.ptV) {
                this.ptY = this.ptV;
            }
            z = false;
        }
        if (this.pug && !this.ptN.dX(null)) {
            if (this.ptY == null && walletFormView != this.ptN) {
                this.ptY = this.ptN;
            }
            z = false;
        }
        if (this.puf && !this.ptO.dX(null)) {
            if (this.ptY == null && walletFormView != this.ptO) {
                this.ptY = this.ptO;
            }
            z = false;
        }
        if (z) {
            this.eUb.setEnabled(true);
            this.eUb.setClickable(true);
            if (walletFormView != null) {
                walletFormView.setImeOptions(1073741824);
            }
        } else {
            this.eUb.setEnabled(false);
            this.eUb.setClickable(false);
        }
        return z;
    }

    public final void fE(boolean z) {
        ZB();
    }

    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        boolean z = false;
        x.d("MicroMsg.WalletCardElmentUI", "onEditorAction actionId : " + i);
        switch (i) {
            case 5:
                if (this.ptY != null) {
                    WalletFormView walletFormView = this.ptY;
                    if (walletFormView.uZy != null ? walletFormView.uZy.isFocusable() : false) {
                        walletFormView = this.ptY;
                        if (walletFormView.uZy != null) {
                            z = walletFormView.uZy.isClickable();
                        }
                        if (z && this.ptY.cDT()) {
                            this.ptY.cDV();
                        }
                    }
                    this.ptY.performClick();
                } else {
                    bQc();
                }
                return true;
            default:
                if (this.ptY != null) {
                    return false;
                }
                bQc();
                return false;
        }
    }

    public void onDestroy() {
        com.tencent.mm.sdk.b.a.sFg.c(this.phJ);
        super.onDestroy();
    }

    private static void a(WalletFormView walletFormView, int i) {
        com.tencent.mm.wallet_core.ui.formview.a.b logicDelegate = walletFormView.getLogicDelegate();
        if (logicDelegate instanceof com.tencent.mm.wallet_core.ui.formview.a.a) {
            ((com.tencent.mm.wallet_core.ui.formview.a.a) logicDelegate).Hf(i);
        }
    }

    private void zp(int i) {
        if (i == 1) {
            d(this.phM, 1, false);
        } else {
            d(this.phM, 1, true);
        }
    }

    protected final int getForceOrientation() {
        return 1;
    }

    private boolean bQd() {
        return this.sy.getBoolean("key_is_forgot_process", false);
    }
}
