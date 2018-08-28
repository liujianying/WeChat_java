package com.tencent.mm.plugin.luckymoney.sns;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.luckymoney.b.ae;
import com.tencent.mm.plugin.luckymoney.b.ah;
import com.tencent.mm.plugin.luckymoney.b.d;
import com.tencent.mm.plugin.luckymoney.b.o;
import com.tencent.mm.plugin.luckymoney.b.x;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyIndexUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMoneyInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyMyRecordUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyNumInputView;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyTextInputView;
import com.tencent.mm.plugin.luckymoney.ui.f;
import com.tencent.mm.plugin.luckymoney.ui.g.c;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bl;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.s;
import com.tenpay.android.wechat.MyKeyboardWindow;
import java.util.Map;

@a(19)
public class SnsLuckyMoneyPrepareUI extends LuckyMoneyBaseUI implements f {
    private al eVk = null;
    protected Dialog eXG = null;
    private ScrollView fPS;
    protected TextView hXQ = null;
    private TextView hXT;
    protected Button iqN = null;
    private d kLu;
    protected LuckyMoneyNumInputView kMf = null;
    protected LuckyMoneyTextInputView kMh = null;
    protected Button kMi = null;
    protected View kMk;
    private TextView kMn;
    private com.tencent.mm.plugin.luckymoney.ui.a kMp = new com.tencent.mm.plugin.luckymoney.ui.a();
    protected LuckyMoneyMoneyInputView kTn = null;
    private View kTo;
    private View kTp;
    private ViewGroup kTq;
    private int kTr;
    private String kTs;
    private int kTt;
    private boolean kTu;
    private String kTv;
    private int kTw;
    private com.tencent.mm.wallet_core.ui.a kTx;
    protected MyKeyboardWindow mKeyboard;
    private int mType;

    static /* synthetic */ void k(SnsLuckyMoneyPrepareUI snsLuckyMoneyPrepareUI) {
        if (snsLuckyMoneyPrepareUI.kMk != null && !snsLuckyMoneyPrepareUI.kMk.isShown()) {
            snsLuckyMoneyPrepareUI.kMk.setVisibility(0);
            snsLuckyMoneyPrepareUI.kTx.fI(true);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mType = getIntent().getIntExtra("key_type", 1);
        this.kTr = getIntent().getIntExtra("key_way", 3);
        this.kTu = getIntent().getIntExtra("key_from", 0) == 1;
        this.kTw = getIntent().getIntExtra("pay_channel", -1);
        b(new x("v1.0", (byte) 0), false);
        com.tencent.mm.plugin.luckymoney.a.a.bat();
        this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LuckyMoneyPrepareUI", "type=" + this.mType + ", fromAppPanel=" + this.kTu + ", config " + this.kLu);
        initView();
        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(1)});
    }

    protected final void initView() {
        getResources().getDrawable(e.lucky_money_actionbar_bg);
        setBackBtn(new 1(this));
        this.kTo = findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_ready_ll);
        this.kTp = findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_sent_area);
        this.iqN = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_send_btn);
        this.kMh = (LuckyMoneyTextInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_wish_et);
        this.kMh.setHintText(getString(i.lucky_money_default_wish));
        this.kMi = (Button) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_btn);
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_num_keyboard);
        this.kMk = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_keyboard_layout);
        this.hXT = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_amount_tips);
        this.kMf = (LuckyMoneyNumInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_num_et);
        this.kTn = (LuckyMoneyMoneyInputView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_et);
        this.hXQ = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_total_amount);
        this.kTq = (ViewGroup) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_opertaion);
        this.fPS = (ScrollView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_sv);
        this.kMn = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_notice_tips);
        if (this.mType == 1) {
            this.kTn.setTitle(getString(i.lucky_money_total_amount_title));
            this.kTn.setShowGroupIcon(true);
        } else {
            this.kTn.setTitle(getString(i.lucky_money_unit_amount_title));
            this.kTn.setShowGroupIcon(false);
        }
        this.kTn.setOnInputValidChangerListener(this);
        this.kMf.setOnInputValidChangerListener(this);
        this.kMh.setOnInputValidChangerListener(this);
        EditText editText = (EditText) this.kTn.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        EditText editText2 = (EditText) this.kMf.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
        ((InputMethodManager) this.mController.tml.getSystemService("input_method")).showSoftInput(editText, 0);
        editText.setOnClickListener(new 19(this, editText, editText2));
        TextView textView = (TextView) this.kTn.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_unit_title);
        if (textView != null) {
            textView.setOnClickListener(new 20(this, editText, editText2));
        }
        com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText2);
        ((InputMethodManager) this.mController.tml.getSystemService("input_method")).showSoftInput(editText2, 0);
        editText2.setOnClickListener(new 21(this, editText, editText2));
        if (this.kLu != null) {
            if (this.mType == 1) {
                this.kTn.setMaxAmount(this.kLu.kKT);
            } else {
                this.kTn.setMaxAmount(this.kLu.kKR);
            }
            this.kTn.setMinAmount(this.kLu.kKS);
        }
        if (!this.kTu || getIntent().getIntExtra("key_chatroom_num", 0) > 1) {
            this.kMf.setNum("");
        } else {
            this.kMf.setNum("1");
        }
        this.kMf.setMaxNum(this.kLu.kKQ);
        this.kMf.setMinNum(1);
        com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LuckyMoneyPrepareUI", "init num=" + this.kMf.getInput());
        this.kTn.setMaxLen(12);
        if (this.kTu) {
            if (getIntent().getIntExtra("key_chatroom_num", 0) > 0) {
                String string = getString(i.lucky_money_group_tips_random_prefix);
                String string2 = getString(i.lucky_money_group_tips_change_to_fixed);
                String string3 = getString(i.lucky_money_group_tips_fixed_prefix);
                String string4 = getString(i.lucky_money_group_tips_change_to_random);
                final CharSequence spannableString = new SpannableString(string + string2);
                com.tencent.mm.plugin.wallet_core.ui.h hVar = new com.tencent.mm.plugin.wallet_core.ui.h(this);
                spannableString.setSpan(hVar, string.length(), string.length() + string2.length(), 33);
                final SpannableString spannableString2 = new SpannableString(string3 + string4);
                com.tencent.mm.plugin.wallet_core.ui.h hVar2 = new com.tencent.mm.plugin.wallet_core.ui.h(this);
                spannableString2.setSpan(hVar2, string3.length(), string3.length() + string4.length(), 33);
                hVar.pvm = new com.tencent.mm.plugin.wallet_core.ui.h.a() {
                    public final void onClick(View view) {
                        int input = SnsLuckyMoneyPrepareUI.this.kMf.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.kTn.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 0;
                        SnsLuckyMoneyPrepareUI.this.kTn.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.kTn.setShowGroupIcon(false);
                        SnsLuckyMoneyPrepareUI.this.kTn.setTitle(SnsLuckyMoneyPrepareUI.this.getString(i.lucky_money_unit_amount_title));
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.kTn.setAmount(com.tencent.mm.wallet_core.ui.e.A(input2 / ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.kTn.setMaxAmount(SnsLuckyMoneyPrepareUI.this.kLu.kKR);
                        SnsLuckyMoneyPrepareUI.this.hXT.setText(spannableString2);
                        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.bbh()), Integer.valueOf(3)});
                    }
                };
                hVar2.pvm = new com.tencent.mm.plugin.wallet_core.ui.h.a() {
                    public final void onClick(View view) {
                        int input = SnsLuckyMoneyPrepareUI.this.kMf.getInput();
                        double input2 = SnsLuckyMoneyPrepareUI.this.kTn.getInput();
                        SnsLuckyMoneyPrepareUI.this.mType = 1;
                        SnsLuckyMoneyPrepareUI.this.kTn.setType(SnsLuckyMoneyPrepareUI.this.mType);
                        SnsLuckyMoneyPrepareUI.this.kTn.setTitle(SnsLuckyMoneyPrepareUI.this.getString(i.lucky_money_total_amount_title));
                        SnsLuckyMoneyPrepareUI.this.kTn.setShowGroupIcon(true);
                        if (input2 > 0.0d && input > 0) {
                            SnsLuckyMoneyPrepareUI.this.kTn.setAmount(com.tencent.mm.wallet_core.ui.e.A(input2 * ((double) input)));
                        }
                        SnsLuckyMoneyPrepareUI.this.kTn.setMaxAmount(SnsLuckyMoneyPrepareUI.this.kLu.kKT);
                        SnsLuckyMoneyPrepareUI.this.hXT.setText(spannableString);
                        h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.bbh()), Integer.valueOf(2)});
                    }
                };
                this.hXT.setMovementMethod(LinkMovementMethod.getInstance());
                this.hXT.setText(spannableString);
                this.hXT.setVisibility(0);
            } else {
                this.kMf.setVisibility(8);
            }
        } else if (this.mType == 1) {
            this.hXT.setText(this.kLu.kPE);
            this.hXT.setVisibility(0);
        } else if (this.mType == 0) {
            this.hXT.setText(this.kLu.kPF);
            this.hXT.setVisibility(0);
        }
        this.kMi.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.bbh()), Integer.valueOf(4)});
                if (SnsLuckyMoneyPrepareUI.this.kTn.baC() != 0) {
                    s.makeText(SnsLuckyMoneyPrepareUI.this.mController.tml, i.wallet_balance_save_input_invalid, 0).show();
                    return;
                }
                long C;
                l aeVar;
                int input = SnsLuckyMoneyPrepareUI.this.kMf.getInput();
                double input2 = SnsLuckyMoneyPrepareUI.this.kTn.getInput();
                long j = 0;
                if (SnsLuckyMoneyPrepareUI.this.mType == 1) {
                    C = com.tencent.mm.wallet_core.ui.e.C(input2);
                    g.Ek();
                    g.Ei().DT().set(356354, Integer.valueOf(input));
                } else {
                    C = com.tencent.mm.wallet_core.ui.e.C(((double) input) * input2);
                    j = com.tencent.mm.wallet_core.ui.e.C(input2);
                    g.Ek();
                    g.Ei().DT().set(356353, Integer.valueOf(input));
                }
                String input3 = SnsLuckyMoneyPrepareUI.this.kMh.getInput();
                if (bi.oW(input3)) {
                    input3 = SnsLuckyMoneyPrepareUI.this.getString(i.lucky_money_default_wish);
                }
                String stringExtra = SnsLuckyMoneyPrepareUI.this.getIntent().getStringExtra("key_username");
                if (!SnsLuckyMoneyPrepareUI.this.kTu || bi.oW(stringExtra)) {
                    aeVar = new ae(input, C, j, SnsLuckyMoneyPrepareUI.this.mType, input3, o.baX(), null, null, q.GF(), q.GH(), SnsLuckyMoneyPrepareUI.this.kTr);
                } else {
                    aeVar = new ae(input, C, j, SnsLuckyMoneyPrepareUI.this.mType, input3, o.baX(), stringExtra, o.gS(stringExtra), q.GF(), q.GH(), SnsLuckyMoneyPrepareUI.this.kTr);
                }
                SnsLuckyMoneyPrepareUI.this.b(aeVar, false);
                if (SnsLuckyMoneyPrepareUI.this.eXG != null) {
                    SnsLuckyMoneyPrepareUI.this.eXG.show();
                    return;
                }
                SnsLuckyMoneyPrepareUI.this.eXG = com.tencent.mm.wallet_core.ui.g.a(SnsLuckyMoneyPrepareUI.this.mController.tml, true, new 1(this));
            }
        });
        this.hXQ.setText(com.tencent.mm.wallet_core.ui.e.B(0.0d));
        this.kMp.a(this.kMf);
        this.kMp.a(this.kTn);
        this.kMp.a(this.kMh);
        this.kMp.f((TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_error_tips));
        if (this.kTu && this.mType == 1) {
            TextView textView2 = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_num_tips);
            textView2.setText(getString(i.lucky_money_num_group_tips, new Object[]{Integer.valueOf(getIntent().getIntExtra("key_chatroom_num", 8))}));
            textView2.setVisibility(0);
        }
        this.eVk = new al(new 17(this), false);
        if (this.fPS != null) {
            this.fPS.setOnTouchListener(new OnTouchListener() {
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        SnsLuckyMoneyPrepareUI.this.Wq();
                        SnsLuckyMoneyPrepareUI.this.YC();
                    }
                    return false;
                }
            });
        }
        this.kTn.setType(this.mType);
        if (this.kTu && getIntent().getIntExtra("key_chatroom_num", 0) == 0) {
            this.kTn.requestFocus();
        } else {
            this.kMf.requestFocus();
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        this.kMp.clear();
        this.eVk.ciq();
        if (this.eXG != null && this.eXG.isShowing()) {
            this.eXG.dismiss();
        }
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.lucky_money_prepare_ui;
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
        if (lVar instanceof ae) {
            if (this.eXG != null && this.eXG.isShowing()) {
                this.eXG.hide();
            }
            if (i == 0 && i2 == 0) {
                ae aeVar = (ae) lVar;
                this.kTt = aeVar.hUg;
                this.kTs = aeVar.kLZ;
                this.kTv = aeVar.kRr;
                PayInfo payInfo = new PayInfo();
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
                com.tencent.mm.ui.base.h.bA(this, str);
                return true;
            }
        }
        if (lVar instanceof ah) {
            if (i == 0 && i2 == 0) {
                if (this.kTu) {
                    com.tencent.mm.ui.base.h.bA(this, getString(i.has_send));
                    finish();
                } else {
                    bbq();
                    this.kTp.postDelayed(new Runnable() {
                        public final void run() {
                            Intent intent = new Intent();
                            intent.setClass(SnsLuckyMoneyPrepareUI.this.mController.tml, LuckyMoneyIndexUI.class);
                            intent.addFlags(67108864);
                            SnsLuckyMoneyPrepareUI.this.mController.tml.startActivity(intent);
                            SnsLuckyMoneyPrepareUI.this.finish();
                        }
                    }, 1000);
                }
                return true;
            } else if (i2 == 402) {
                com.tencent.mm.ui.base.h.a(this.mController.tml, str, "", getString(i.lucky_money_send_list_title), getString(i.app_cancel), new 3(this), new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                return true;
            }
        } else if (lVar instanceof x) {
            if (i == 0 && i2 == 0) {
                x xVar = (x) lVar;
                com.tencent.mm.plugin.luckymoney.a.a.bat();
                this.kLu = com.tencent.mm.plugin.luckymoney.a.a.bau().baS();
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.LuckyMoneyPrepareUI", "update config:" + this.kLu);
                if (this.mType == 1) {
                    this.kTn.setMaxAmount(this.kLu.kKT);
                } else {
                    this.kTn.setMaxAmount(this.kLu.kKR);
                }
                this.kTn.setMinAmount(this.kLu.kKS);
                this.kMf.setMaxNum(this.kLu.kKQ);
                if (xVar.kRd && this.kTu) {
                    TextView textView = (TextView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_has_tips);
                    textView.setOnClickListener(new 5(this));
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(8)});
                    textView.setVisibility(0);
                }
                if (bi.oW(xVar.hUy)) {
                    this.kMn.setVisibility(8);
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LuckyMoneyPrepareUI", "Put notice :" + xVar.hUy);
                    this.kMn.setText(xVar.hUy);
                    if (!bi.oW(xVar.kRf)) {
                        this.kMn.setOnClickListener(new 6(this, xVar));
                    }
                    this.kMn.setVisibility(0);
                }
                c cVar = new c();
                cVar.textColor = getResources().getColor(com.tencent.mm.plugin.wxpay.a.c.wallet_link_color);
                com.tencent.mm.plugin.luckymoney.ui.g.a(this, this.kTq, xVar.kRh, cVar);
            }
            return true;
        }
        return false;
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        String str;
        switch (i) {
            case 1:
                if (i2 == -1) {
                    h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(bbh()), Integer.valueOf(5)});
                    String stringExtra = getIntent().getStringExtra("key_username");
                    if (this.kTu && !bi.oW(stringExtra)) {
                        com.tencent.mm.ui.base.h.bA(this, getString(i.has_send));
                        Map z = bl.z(this.kTv, "msg");
                        if (z != null) {
                            str = (String) z.get(".msg.appmsg.wcpayinfo.paymsgid");
                            if (com.tencent.mm.plugin.luckymoney.a.a.bat().baw().Gb(str)) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.LuckyMoneyPrepareUI", "insert a local msg for luckymoney");
                                if (!o.C(this.kTv, stringExtra, 1)) {
                                    com.tencent.mm.sdk.platformtools.x.e("MicroMsg.LuckyMoneyPrepareUI", "LuckyMoneyUtil.sendLocalMsg fail!");
                                    com.tencent.mm.plugin.luckymoney.a.a.bat().baw().Gc(str);
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.x.e("MicroMsg.LuckyMoneyPrepareUI", "it is a duplicate msg");
                            }
                            finish();
                            break;
                        }
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.LuckyMoneyPrepareUI", "luckymoneyPrepareUI onActivityResult values is null");
                        finish();
                        return;
                    }
                    bbq();
                    new ag().postDelayed(new 7(this), 200);
                    this.iqN.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            h.mEJ.h(11701, new Object[]{Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(SnsLuckyMoneyPrepareUI.this.bbh()), Integer.valueOf(6)});
                            o.a(SnsLuckyMoneyPrepareUI.this, SnsLuckyMoneyPrepareUI.this.mType, SnsLuckyMoneyPrepareUI.this.kTt, false);
                            SnsLuckyMoneyPrepareUI.this.kTo.postDelayed(new 1(this), 100);
                        }
                    });
                    ((ImageView) findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_prepare_close_btn)).setOnClickListener(new 9(this));
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
        }
        super.onActivityResult(i, i2, intent);
    }

    protected final void z(View view, final int i) {
        this.mKeyboard = (MyKeyboardWindow) findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_num_keyboard);
        this.kMk = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_keyboard_layout);
        View findViewById = findViewById(com.tencent.mm.plugin.wxpay.a.f.tenpay_push_down);
        final EditText editText = (EditText) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_et);
        if (this.mKeyboard != null && editText != null && this.kMk != null) {
            com.tencent.mm.wallet_core.ui.e.setNoSystemInputOnEditText(editText);
            editText.setOnFocusChangeListener(new 10(this, i, editText));
            editText.setOnClickListener(new 12(this, i, editText));
            TextView textView = (TextView) view.findViewById(com.tencent.mm.plugin.wxpay.a.f.lucky_money_amount_unit_title);
            if (textView != null) {
                textView.setOnClickListener(new OnClickListener() {
                    final /* synthetic */ boolean eCF = false;

                    public final void onClick(View view) {
                        if (!SnsLuckyMoneyPrepareUI.this.kMk.isShown() && !this.eCF) {
                            SnsLuckyMoneyPrepareUI.k(SnsLuckyMoneyPrepareUI.this);
                            SnsLuckyMoneyPrepareUI.this.mKeyboard.setXMode(i);
                        } else if (this.eCF) {
                            SnsLuckyMoneyPrepareUI.this.Wq();
                            ((InputMethodManager) SnsLuckyMoneyPrepareUI.this.mController.tml.getSystemService("input_method")).showSoftInput(editText, 0);
                        }
                    }
                });
            }
            findViewById.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    SnsLuckyMoneyPrepareUI.this.Wq();
                }
            });
        }
    }

    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || this.kMk == null || !this.kMk.isShown()) {
            return super.onKeyUp(i, keyEvent);
        }
        Wq();
        return true;
    }

    protected final void Wq() {
        if (this.kMk != null && this.kMk.isShown()) {
            this.kMk.setVisibility(8);
            this.kTx.fI(false);
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
                boolean z2;
                if (this.mType == 0) {
                    if (d > this.kLu.kKR && this.kLu.kKR > 0.0d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_max_limit_tips, new Object[]{Math.round(this.kLu.kKR), bi.aG(this.kLu.kKW, "")}));
                        z2 = true;
                    }
                    z2 = false;
                } else {
                    if (d > this.kLu.kKU && this.kLu.kKU > 0.0d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_max_limit_tips, new Object[]{Math.round(this.kLu.kKU), bi.aG(this.kLu.kKW, "")}));
                        this.kMf.onError();
                        this.kTn.onError();
                        z2 = true;
                    }
                    z2 = false;
                }
                if (!z2) {
                    if (this.mType == 0) {
                        if (d < this.kLu.kKS) {
                            this.kMp.tn(getString(i.lucky_money_per_amount_min_limit_tips, new Object[]{com.tencent.mm.wallet_core.ui.e.A(this.kLu.kKS), bi.aG(this.kLu.kKW, "")}));
                            z = true;
                        }
                    } else if (d < 0.01d) {
                        this.kMp.tn(getString(i.lucky_money_per_amount_min_limit_tips, new Object[]{"0.01", bi.aG(this.kLu.kKW, "")}));
                        this.kMf.onError();
                        this.kTn.onError();
                        z = true;
                    }
                }
                z = z2;
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
        this.hXQ.setText(com.tencent.mm.wallet_core.ui.e.B(d2));
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
}
