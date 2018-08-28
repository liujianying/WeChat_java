package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.g.a.pl;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.v;
import com.tencent.mm.plugin.luckymoney.b.y;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.c;
import com.tencent.mm.ui.widget.snackbar.b;
import com.tencent.mm.wallet_core.c.u;
import com.tencent.mm.wallet_core.ui.MMScrollView;
import com.tencent.mm.wallet_core.ui.e;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class LuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private al eVk = null;
    private Dialog eXG = null;
    private TextView hXQ = null;
    private TextView hXT;
    private int hop;
    private Button iqN = null;
    private d kLu;
    private LuckyMoneyNumInputView kMf = null;
    private LuckyMoneyTextInputView kMh = null;
    private Button kMi = null;
    protected View kMk;
    private MMScrollView kMm;
    private TextView kMn;
    private a kMp = new a();
    private LuckyMoneyMoneyInputView kTn = null;
    private View kTo;
    private View kTp;
    private ViewGroup kTq;
    private int kTr;
    private String kTs;
    private int kTt;
    private boolean kTu;
    private String kTv;
    private int kTw;
    private String kUn;
    private int kWP = 1;
    private String kWQ = e.abX("CNY");
    private String kWR = null;
    private RealnameGuideHelper kWS;
    private String kWT;
    private c kWU;
    private boolean kWV = false;
    private com.tencent.mm.sdk.b.c<pl> kWW = new 12(this);
    protected MyKeyboardWindow mKeyboard;
    private int mType;

    static /* synthetic */ void s(LuckyMoneyPrepareUI luckyMoneyPrepareUI) {
        luckyMoneyPrepareUI.kWU = new c(luckyMoneyPrepareUI, 1, false);
        luckyMoneyPrepareUI.kWU.ofp = new 2(luckyMoneyPrepareUI);
        luckyMoneyPrepareUI.kWU.ofq = new n.d() {
            public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
                if (i == 0) {
                    Intent intent = new Intent();
                    intent.setClass(LuckyMoneyPrepareUI.this.mController.tml, LuckyMoneyMyRecordUI.class);
                    intent.putExtra("key_type", 2);
                    LuckyMoneyPrepareUI.this.startActivity(intent);
                } else if (i == 1) {
                    h.mEJ.h(15511, new Object[]{Integer.valueOf(LuckyMoneyPrepareUI.this.kWP), Integer.valueOf(1)});
                    if (LuckyMoneyPrepareUI.this.kWP == 1) {
                        e.l(LuckyMoneyPrepareUI.this.mController.tml, "https://kf.qq.com/touch/scene_product.html?scene_id=kf7", false);
                        return;
                    }
                    String str = "MicroMsg.LuckyMoneyPrepareUI";
                    String str2 = "show qa foreign, config url: %s";
                    Object[] objArr = new Object[1];
                    objArr[0] = LuckyMoneyPrepareUI.this.kLu != null ? LuckyMoneyPrepareUI.this.kLu.kPH : "";
                    x.i(str, str2, objArr);
                    if (LuckyMoneyPrepareUI.this.kLu == null || bi.oW(LuckyMoneyPrepareUI.this.kLu.kPH)) {
                        e.l(LuckyMoneyPrepareUI.this.mController.tml, "https://hkwallet.moneydata.hk/hybrid/www/weixin/hongbao_hk_v2/zh_hk/faq.shtml", false);
                    } else {
                        e.l(LuckyMoneyPrepareUI.this.mController.tml, LuckyMoneyPrepareUI.this.kLu.kPH, false);
                    }
                }
            }
        };
        luckyMoneyPrepareUI.kWU.bXO();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.kTr = getIntent().getIntExtra("key_way", 3);
        this.hop = getIntent().getIntExtra("key_from", 0);
        this.kTu = this.hop == 1;
        this.kTw = getIntent().getIntExtra("pay_channel", -1);
        b(new com.tencent.mm.plugin.luckymoney.b.x("v1.0", (byte) 0), true);
        com.tencent.mm.plugin.luckymoney.a.a.bat();
        this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
        x.i("MicroMsg.LuckyMoneyPrepareUI", "mInWay:" + this.kTr + "mChannel:" + this.kTw);
        x.i("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.kTu + ", config " + this.kLu);
        initView();
        com.tencent.mm.sdk.b.a.sFg.a(this.kWW);
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(1)});
    }

    protected void onResume() {
        super.onResume();
        jr(1970);
    }

    protected void onStop() {
        super.onStop();
        js(1970);
    }

    protected final void initView() {
        setBackBtn(new 1(this));
        this.kTo = findViewById(f.lucky_money_prepare_ready_ll);
        this.kTp = findViewById(f.lucky_money_prepare_sent_area);
        this.iqN = (Button) findViewById(f.lucky_money_prepare_send_btn);
        this.kMh = (LuckyMoneyTextInputView) findViewById(f.lucky_money_wish_et);
        this.kMh.setHintText(getString(i.lucky_money_default_wish));
        this.kMi = (Button) findViewById(f.lucky_money_prepare_btn);
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.tenpay_num_keyboard);
        this.kMk = findViewById(f.tenpay_keyboard_layout);
        this.hXT = (TextView) findViewById(f.lucky_money_prepare_amount_tips);
        this.kMf = (LuckyMoneyNumInputView) findViewById(f.lucky_money_num_et);
        this.kTn = (LuckyMoneyMoneyInputView) findViewById(f.lucky_money_amount_et);
        this.hXQ = (TextView) findViewById(f.lucky_money_prepare_total_amount);
        this.kTq = (ViewGroup) findViewById(f.lucky_money_prepare_opertaion);
        this.kMm = (MMScrollView) findViewById(f.lucky_money_sv);
        this.kMn = (TextView) findViewById(f.lucky_money_prepare_notice_tips);
        if (this.mType == 1) {
            setMMTitle(i.lucky_money_group);
            this.kTn.setTitle(getString(i.lucky_money_total_amount_title));
            this.kTn.setShowGroupIcon(true);
        } else {
            setMMTitle(i.lucky_money_normal);
            this.kTn.setTitle(getString(i.lucky_money_unit_amount_title));
            this.kTn.setShowGroupIcon(false);
        }
        this.kTn.setOnInputValidChangerListener(this);
        this.kTn.setHint(getString(i.lucky_money_money_hint));
        this.kMf.setOnInputValidChangerListener(this);
        this.kMf.setHint(getString(i.lucky_money_num_hint));
        this.kMh.setOnInputValidChangerListener(this);
        final EditText editText = (EditText) this.kTn.findViewById(f.lucky_money_et);
        final EditText editText2 = (EditText) this.kMf.findViewById(f.lucky_money_et);
        e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.tml.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                if (editable.toString().startsWith(".")) {
                    editable.insert(0, "0");
                }
                String obj = editable.toString();
                int indexOf = obj.indexOf(".");
                int length = obj.length();
                if (indexOf >= 0 && length - indexOf > 3) {
                    editable.delete(indexOf + 3, length);
                } else if (indexOf > 6) {
                    editable.delete(6, indexOf);
                } else if (indexOf == -1 && length > 6) {
                    editable.delete(6, length);
                }
                editText.setContentDescription(editable.toString());
            }
        });
        editText2.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                editText2.setContentDescription(editable.toString());
            }
        });
        editText.setOnClickListener(new 6(this, editText, editText2));
        editText.requestFocus();
        TextView textView = (TextView) this.kTn.findViewById(f.lucky_money_amount_unit_title);
        if (textView != null) {
            textView.setOnClickListener(new 7(this, editText, editText2));
        }
        e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.tml.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new 8(this, editText, editText2));
        ((MMEditText) this.kMh.findViewById(f.lucky_money_text)).setOnFocusChangeListener(new 9(this, editText, editText2));
        if (this.kLu != null) {
            if (this.mType == 1) {
                this.kTn.setMaxAmount(this.kLu.kKT);
            } else {
                this.kTn.setMaxAmount(this.kLu.kKR);
            }
            this.kTn.setMinAmount(this.kLu.kKS);
            if (this.kLu.hUw != 1) {
                dD(this.kLu.kKW, this.kLu.kKV);
            }
        }
        if (!this.kTu || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.kMf.setNum("");
        } else {
            this.kMf.setNum("1");
        }
        this.kMf.setMaxNum(this.kLu.kKQ);
        this.kMf.setMinNum(1);
        x.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.kMf.getInput());
        this.kTn.setMaxLen(12);
        if (this.kTu || this.hop == 2) {
            setMMTitle(i.lucky_money_to_send_title);
            int intExtra = getIntent().getIntExtra("key_chatroom_num", 0);
            if (this.kTu && intExtra == 0) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "single hb");
                this.kMf.setVisibility(8);
            } else {
                String str;
                String string = getString(i.lucky_money_f2f_random_tip_prefix);
                String string2 = getString(i.lucky_money_group_tips_change_to_fixed);
                String string3 = getString(i.lucky_money_f2f_fixed_tip_prefix);
                String string4 = getString(i.lucky_money_group_tips_change_to_random);
                if (!this.kTu || intExtra <= 0) {
                    if (this.hop == 2) {
                        x.i("MicroMsg.LuckyMoneyPrepareUI", "f2f hb");
                        this.kMh.setVisibility(8);
                    }
                    str = string;
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "group hb,%d people", new Object[]{Integer.valueOf(intExtra)});
                    str = getString(i.lucky_money_group_tips_random_prefix);
                    string = getString(i.lucky_money_group_tips_fixed_prefix);
                    TextView textView2 = (TextView) findViewById(f.lucky_money_prepare_num_tips);
                    textView2.setText(getString(i.lucky_money_num_group_tips, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
                    textView2.setVisibility(0);
                    string3 = string;
                }
                com.tencent.mm.plugin.wallet_core.ui.h hVar = new com.tencent.mm.plugin.wallet_core.ui.h(this);
                CharSequence spannableString = new SpannableString(str + string2);
                spannableString.setSpan(hVar, str.length(), str.length() + string2.length(), 33);
                SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.h hVar2 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
                spannableString2.setSpan(hVar2, string3.length(), string3.length() + string4.length(), 33);
                hVar.pvm = new 11(this, spannableString2);
                hVar2.pvm = new 22(this, spannableString);
                this.hXT.setMovementMethod(LinkMovementMethod.getInstance());
                if (com.tencent.mm.ui.a.a.a.cqX().cqW()) {
                    this.hXT.setOnClickListener(new 27(this, spannableString, hVar, hVar2));
                }
                this.hXT.setText(spannableString);
                this.hXT.setVisibility(0);
            }
        } else if (this.mType == 1) {
            this.hXT.setText(this.kLu.kPE);
            this.hXT.setVisibility(0);
        } else if (this.mType == 0) {
            this.hXT.setText(this.kLu.kPF);
            this.hXT.setVisibility(0);
        }
        this.kMi.setOnClickListener(new 28(this));
        this.kMp.a(this.kMf);
        this.kMp.a(this.kTn);
        this.kMp.a(this.kMh);
        this.kMp.f((TextView) findViewById(f.lucky_money_prepare_error_tips));
        this.eVk = new al(new 29(this), false);
        if (this.kMm != null) {
            this.kMm.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        LuckyMoneyPrepareUI.this.Wq();
                        LuckyMoneyPrepareUI.this.YC();
                    }
                    return false;
                }
            });
        }
        this.kTn.setType(this.mType);
        if (this.kWP == 1) {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.mm_title_btn_menu, new 31(this));
        } else {
            addIconOptionMenu(0, com.tencent.mm.plugin.wxpay.a.e.lucky_money_help_btn, new 32(this));
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.kMp.clear();
        this.eVk.ciq();
        if (this.eXG != null && this.eXG.isShowing()) {
            this.eXG.dismiss();
        }
        com.tencent.mm.sdk.b.a.sFg.c(this.kWW);
    }

    protected final int getLayoutId() {
        return g.lucky_money_prepare_ui;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() != 4 || this.kTo.getVisibility() != 0) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this.kTo.setVisibility(8);
        bbp();
        return true;
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "errType:" + i + " errCode:" + i2 + " errMsg:" + str + " scenetype:" + lVar.getType());
        PayInfo payInfo;
        if (lVar instanceof ae) {
            if (this.eXG != null && this.eXG.isShowing()) {
                this.eXG.dismiss();
            }
            if (this.kWV) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "has show alert return");
                return true;
            } else if (i == 0 && i2 == 0) {
                ae aeVar = (ae) lVar;
                this.kTt = aeVar.hUg;
                this.kTs = aeVar.kLZ;
                this.kTv = aeVar.kRr;
                this.kUn = aeVar.kLZ;
                this.kWT = aeVar.kRx;
                payInfo = new PayInfo();
                payInfo.bOd = aeVar.kRq;
                payInfo.bVY = 37;
                payInfo.bVU = this.kTw;
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 1);
                return true;
            } else if (i2 == 401) {
                this.kMi.setEnabled(false);
                this.kMi.setClickable(false);
                this.eVk.J(5000, 5000);
                com.tencent.mm.ui.base.h.bA(this, str);
                return true;
            } else {
                if (TextUtils.isEmpty(str)) {
                    str = getString(i.wallet_unknown_err);
                }
                com.tencent.mm.ui.base.h.a(this, str, null, false, new 10(this));
                return true;
            }
        }
        if (lVar instanceof ah) {
            if (i == 0 && i2 == 0) {
                if (this.kTu) {
                    b.h(this, getString(i.has_send));
                    com.tencent.mm.sdk.platformtools.ah.i(new 13(this), 1800);
                } else {
                    bbq();
                    this.kTp.setVisibility(0);
                    this.kTp.postDelayed(new 14(this), 1000);
                }
                return true;
            } else if (i2 == 402) {
                com.tencent.mm.ui.base.h.a(this.mController.tml, str, "", getString(i.lucky_money_send_list_title), getString(i.app_cancel), new 15(this), new 16(this));
                return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.luckymoney.b.x) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "NetSceneLuckyMoneyGetConfig resp,errType=" + i + ";errCode=" + i2 + ";errMsg=" + str);
            if (i == 0 && i2 == 0) {
                com.tencent.mm.plugin.luckymoney.b.x xVar = (com.tencent.mm.plugin.luckymoney.b.x) lVar;
                com.tencent.mm.plugin.luckymoney.a.a.bat();
                this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
                x.i("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.kLu);
                if (this.mType == 1) {
                    this.kTn.setMaxAmount(this.kLu.kKT);
                } else {
                    this.kTn.setMaxAmount(this.kLu.kKR);
                }
                this.kTn.setMinAmount(this.kLu.kKS);
                this.kMf.setMaxNum(this.kLu.kKQ);
                this.kWQ = xVar.kKV;
                this.kWP = xVar.hUw;
                this.kWR = xVar.kLf;
                if (!(bi.oW(this.kWR) || this.kMh == null)) {
                    com.tencent.mm.sdk.platformtools.ah.A(new 17(this));
                }
                if (xVar.kRd && this.kTu) {
                    TextView textView = (TextView) findViewById(f.lucky_money_prepare_has_tips);
                    textView.setOnClickListener(new 18(this));
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (bi.oW(xVar.hUy)) {
                    this.kMn.setVisibility(8);
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + xVar.hUy);
                    this.kMn.setText(xVar.hUy);
                    if (!bi.oW(xVar.kRf)) {
                        this.kMn.setOnClickListener(new 19(this, xVar));
                    }
                    this.kMn.setVisibility(0);
                }
                g.c cVar = new g.c();
                if (xVar.kRh == null || bi.oW(xVar.kRh.content)) {
                    cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.hint_text_color);
                } else {
                    cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.wallet_link_color);
                }
                g.a(this, this.kTq, xVar.kRh, cVar);
                dD(xVar.kKW, xVar.kKV);
                c(0.0d, this.kWQ);
            }
            return true;
        } else if (lVar instanceof y) {
            js(1645);
            if (this.eXG != null && this.eXG.isShowing()) {
                this.eXG.hide();
            }
            if (i == 0 && i2 == 0) {
                String str2 = ((y) lVar).hUK;
                if (bi.oW(str2)) {
                    x.e("MicroMsg.LuckyMoneyPrepareUI", "payUrl is null");
                } else {
                    x.i("MicroMsg.LuckyMoneyPrepareUI", "payUrl is not null");
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", str2);
                    intent.putExtra("showShare", false);
                    com.tencent.mm.bg.d.b(this, "webview", ".ui.tools.WebViewUI", intent, 3);
                }
                return true;
            }
        } else if (lVar instanceof com.tencent.mm.plugin.luckymoney.f2f.a.c) {
            if (i == 0 && i2 == 0) {
                if (this.eXG != null) {
                    this.eXG.dismiss();
                }
                this.kUn = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) lVar).kLZ;
                this.kWT = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) lVar).kNn;
                payInfo = new PayInfo();
                payInfo.bOd = ((com.tencent.mm.plugin.luckymoney.f2f.a.c) lVar).bOd;
                payInfo.bVY = 37;
                u.j(37, payInfo.bOd, i2);
                com.tencent.mm.pluginsdk.wallet.h.a(this, payInfo, 4);
            } else {
                u.j(37, "", i2);
                if (!bi.oW(str)) {
                    com.tencent.mm.ui.base.h.b(this, str, getString(i.lucky_money_app_tip), true);
                }
                this.eXG.dismiss();
            }
            return true;
        }
        return false;
    }

    private void dD(String str, String str2) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "initH5LuckyMoneyView  currencyWording=" + str);
        TextView textView = (TextView) findViewById(f.lucky_money_amount_unit_title);
        if (bi.oW(str)) {
            textView.setText(getString(i.lucky_money_amount_unit_title));
        } else {
            textView.setText(str);
        }
        if (bi.oW(str2)) {
            c(0.0d, e.abX("CNY"));
        } else {
            c(0.0d, str2);
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (intent != null && intent.hasExtra("key_realname_guide_helper")) {
                    this.kWS = (RealnameGuideHelper) intent.getParcelableExtra("key_realname_guide_helper");
                }
                if (i2 == -1) {
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (!this.kTu || bi.oW(stringExtra)) {
                        bbq();
                        View findViewById = findViewById(f.lucky_money_prepare_ready_packet_ll);
                        this.kTo.setVisibility(0);
                        o.a(findViewById, null);
                        this.iqN.setOnClickListener(new 20(this));
                        ((ImageView) findViewById(f.lucky_money_prepare_close_btn)).setOnClickListener(new 21(this));
                    } else {
                        com.tencent.mm.ui.base.h.bA(this, getString(i.has_send));
                        Map z = bl.z(this.kTv, "msg");
                        if (z == null) {
                            x.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                            finish();
                            return;
                        }
                        str = (String) z.get(".msg.appmsg.wcpayinfo.paymsgid");
                        if (com.tencent.mm.plugin.luckymoney.a.a.bat().baw().Gb(str)) {
                            x.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                            if (!o.C(this.kTv, stringExtra, 1)) {
                                x.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                com.tencent.mm.plugin.luckymoney.a.a.bat().baw().Gc(str);
                            }
                        } else {
                            x.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                        }
                        finish();
                    }
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    Gg(str);
                    break;
                }
                break;
            case 2:
                if (i2 != -1 || intent == null) {
                    if (i2 == 0) {
                        Intent intent2 = new Intent();
                        intent2.setClass(this.mController.tml, LuckyMoneyMyRecordUI.class);
                        intent2.putExtra("key_type", 1);
                        startActivity(intent2);
                        break;
                    }
                }
                str = intent.getStringExtra("Select_Conv_User");
                h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(7), str});
                if (!bi.oW(str)) {
                    l(new ah(str.replaceAll(",", "|"), this.kTs, "v1.0"));
                    break;
                } else {
                    finish();
                    break;
                }
                break;
            case 3:
                if (intent != null && intent.hasExtra("result_data")) {
                    Bundle bundleExtra = intent.getBundleExtra("result_data");
                    if (bundleExtra == null) {
                        x.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY bundle is null");
                        break;
                    }
                    int i3 = bi.getInt(bundleExtra.getString("payState", "2"), 0);
                    x.e("MicroMsg.LuckyMoneyPrepareUI", "onActivityResult REQUEST_CODE_H5_PAY payState is " + i3 + ";STATE_H5_PAY_SUCC=0");
                    if (i3 == 0) {
                        finish();
                        break;
                    }
                }
                break;
            case 4:
                if (i2 == -1) {
                    str = "";
                    if (intent != null) {
                        str = intent.getStringExtra("key_trans_id");
                    }
                    Gg(str);
                }
                finish();
                break;
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(f.tenpay_num_keyboard);
        this.kMk = findViewById(f.tenpay_keyboard_layout);
        View findViewById = findViewById(f.tenpay_push_down);
        EditText editText = (EditText) view.findViewById(f.lucky_money_et);
        if (this.mKeyboard != null && editText != null && this.kMk != null) {
            e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new 23(this, i, editText));
            editText.setOnClickListener(new 24(this, i, editText));
            TextView textView = (TextView) view.findViewById(f.lucky_money_amount_unit_title);
            if (textView != null) {
                textView.setOnClickListener(new 25(this, editText, view, i));
            }
            findViewById.setOnClickListener(new 26(this));
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.kMk == null || !this.kMk.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        this.kMk.setVisibility(8);
        return true;
    }

    protected final void Wq() {
        if (this.kMk != null && this.kMk.isShown()) {
            this.kMk.setVisibility(8);
        }
    }

    public final void baD() {
        double d;
        double d2;
        com.tencent.mm.plugin.luckymoney.a.a.bat();
        this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
        if (this.kTn.baC() == 3 || this.kMf.baC() == 3) {
            d = 0.0d;
            d2 = 0.0d;
        } else {
            int input = this.kMf.getInput();
            d2 = this.kTn.getInput();
            if (this.mType == 0) {
                d2 *= (double) input;
                d = this.kTn.getInput();
            } else {
                d = input > 0 ? this.kTn.getInput() / ((double) input) : 0.0d;
            }
        }
        if (this.kMp.bbv()) {
            x.i("MicroMsg.LuckyMoneyPrepareUI", "has error");
            this.kMi.setClickable(false);
            this.kMi.setEnabled(false);
        } else {
            boolean z;
            if (d2 == 0.0d || d == 0.0d) {
                z = true;
            } else if (d2 > this.kLu.kKT && this.kLu.kKT > 0.0d) {
                this.kMp.tn(getString(i.lucky_money_total_amount_max_limit_tips, new Object[]{Math.round(this.kLu.kKT), bi.aG(this.kLu.kKW, "")}));
                z = true;
            } else if (d > 0.0d) {
                x.i("MicroMsg.LuckyMoneyPrepareUI", "perAmount " + d);
                if (this.mType == 0) {
                    if (d > this.kLu.kKR && this.kLu.kKR > 0.0d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_max_limit_tips, new Object[]{Math.round(this.kLu.kKR), bi.aG(this.kLu.kKW, "")}));
                        z = true;
                    }
                    z = false;
                } else {
                    if (d > this.kLu.kKU && this.kLu.kKU > 0.0d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_max_limit_tips, new Object[]{Math.round(this.kLu.kKU), bi.aG(this.kLu.kKW, "")}));
                        this.kMf.onError();
                        this.kTn.onError();
                        z = true;
                    }
                    z = false;
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for max value");
                if (!z) {
                    if (this.mType == 0) {
                        if (d < this.kLu.kKS) {
                            this.kMp.tn(getString(i.lucky_money_per_amount_min_limit_tips, new Object[]{e.A(this.kLu.kKS), bi.aG(this.kLu.kKW, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_min_limit_tips, new Object[]{"0.01", bi.aG(this.kLu.kKW, "")}));
                        this.kMf.onError();
                        this.kTn.onError();
                        z = true;
                    }
                }
                x.i("MicroMsg.LuckyMoneyPrepareUI", "furtherCheckHasErr:" + z + " for min value");
            } else {
                z = false;
            }
            if (z) {
                this.kMi.setClickable(false);
                this.kMi.setEnabled(false);
            } else {
                this.kMi.setClickable(true);
                this.kMi.setEnabled(true);
            }
        }
        c(d2, this.kWQ);
    }

    private void c(double d, String str) {
        if (bi.oW(str)) {
            this.hXQ.setText(e.B(d));
        } else {
            this.hXQ.setText(str + e.A(d));
        }
    }

    private int bbh() {
        if (!this.kTu) {
            return 3;
        }
        if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
            return 2;
        }
        return 1;
    }

    public void finish() {
        if (this.kWS != null) {
            Intent intent = new Intent();
            intent.putExtra("key_realname_guide_helper", this.kWS);
            com.tencent.mm.bg.d.b(this, "wallet_core", ".id_verify.RealnameDialogActivity", intent);
        }
        super.finish();
    }

    private void Gg(String str) {
        x.i("MicroMsg.LuckyMoneyPrepareUI", "do business callback");
        b(new v(this.kUn, str, this.kWT), false);
    }
}
