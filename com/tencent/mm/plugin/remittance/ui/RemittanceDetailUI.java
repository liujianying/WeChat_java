package com.tencent.mm.plugin.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.ne;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.order.model.h;
import com.tencent.mm.plugin.remittance.model.u;
import com.tencent.mm.plugin.remittance.model.x;
import com.tencent.mm.plugin.wallet_core.c.ae;
import com.tencent.mm.plugin.wallet_core.model.o;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.aa;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.wallet_core.c.m;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;

public class RemittanceDetailUI extends WalletBaseUI {
    public TextView kUA = null;
    private String lOk;
    private String lOr;
    public ImageView mBO = null;
    public TextView mBP = null;
    public TextView mBQ = null;
    public Button mBR = null;
    public TextView mBS = null;
    public TextView mBT = null;
    public int mBU;
    public int mBV;
    public String mBW = null;
    public String mBX = null;
    protected String mBY = null;
    public int mBZ = 3;
    protected boolean mCa = false;
    protected int mCb;
    private int mCc;
    private u mCd;
    private c<ne> mCe = new 1(this);
    private String mzm = null;
    private int mzn;
    public String mzr = null;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mBU = getIntent().getIntExtra("invalid_time", 0);
        this.mBV = getIntent().getIntExtra("appmsg_type", 0);
        this.mBW = getIntent().getStringExtra("transaction_id");
        this.mBY = getIntent().getStringExtra("bill_id");
        this.mzr = getIntent().getStringExtra("transfer_id");
        this.mBX = getIntent().getStringExtra("sender_name");
        this.mBZ = getIntent().getIntExtra("effective_date", 3);
        this.mCa = getIntent().getBooleanExtra("is_sender", false);
        this.mCb = getIntent().getIntExtra("total_fee", 0);
        initView();
        vq(0);
        getIntent();
        a.sFg.b(this.mCe);
    }

    public void onDestroy() {
        a.sFg.c(this.mCe);
        super.onDestroy();
    }

    public void vq(int i) {
        a(new x(i, this.mBW, this.mzr, this.mBU), true, false);
    }

    protected final void initView() {
        setMMTitle(i.remittance_result_title);
        this.mBO = (ImageView) findViewById(f.remittance_detail_desc_icon);
        this.mBP = (TextView) findViewById(f.remittance_detail_result_desc);
        this.mBQ = (TextView) findViewById(f.remittance_detail_fee);
        this.mBR = (Button) findViewById(f.remittance_detail_collect_btn);
        this.kUA = (TextView) findViewById(f.remittance_detail_main_desc);
        this.mBS = (TextView) findViewById(f.remittance_detail_time_desc_one);
        this.mBT = (TextView) findViewById(f.remittance_detail_time_desc_two);
    }

    public void vr(int i) {
        m hVar;
        if (getIntent().getBooleanExtra("is_sender", false)) {
            hVar = new h(this.mBW, this.mBY, i);
        } else {
            hVar = new h(this.mzr, this.mBY, i);
        }
        hVar.dox = "RemittanceProcess";
        a(hVar, true, true);
    }

    public void X(Intent intent) {
        d.b(this, "remittance", ".ui.RemittanceResendMsgUI", intent);
    }

    public void brB() {
        u uVar = new u(this.mBW, this.mzr, this.mCb, "confirm", this.mBX, this.mBU);
        uVar.dox = "RemittanceProcess";
        a(uVar, true, true);
    }

    public void brC() {
        u uVar = new u(this.mBW, this.mzr, this.mCb, "refuse", this.mBX, this.mBU);
        uVar.dox = "RemittanceProcess";
        a(uVar, true, true);
    }

    private void brq() {
        if (this.mCc == 0 || this.mzn != 1 || bi.oW(this.mzm)) {
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.RemittanceDetailUI", "flag: %d, descUrl empty: %B", new Object[]{Integer.valueOf(this.mCc), Boolean.valueOf(bi.oW(this.mzm))});
            this.mController.removeAllOptionMenu();
            return;
        }
        addIconOptionMenu(0, e.wallet_qanda_icon, new 8(this));
    }

    public boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof x) {
            final x xVar = (x) lVar;
            if (i == 0 && i2 == 0) {
                if (xVar != null) {
                    if (xVar.klL) {
                        this.lOr = q.GF();
                        this.lOk = this.mBX;
                    } else {
                        this.lOr = this.mBX;
                        this.lOk = q.GF();
                    }
                    boolean equals = q.GF().equals(this.lOk);
                    this.mBR.setVisibility(8);
                    this.mBQ.setText(com.tencent.mm.wallet_core.ui.e.e(xVar.hUL, xVar.lNV));
                    CharSequence charSequence = xVar.myv;
                    if (!bi.oW(charSequence) && charSequence.contains("%s")) {
                        charSequence = charSequence.trim().replace("%s", aM(this.lOk, true));
                    }
                    CharSequence charSequence2 = xVar.myw;
                    Bundle bundle = new Bundle();
                    bundle.putString("transaction_id", this.mBW);
                    bundle.putString("receiver_name", this.lOk);
                    bundle.putString("transfer_id", this.mzr);
                    bundle.putInt("total_fee", this.mCb);
                    bundle.putString("sender_name", this.mBX);
                    bundle.putInt("invalid_time", this.mBU);
                    this.kUA.setClickable(true);
                    this.mBP.setClickable(true);
                    int i3 = xVar.status;
                    com.tencent.mm.sdk.platformtools.x.d("MicroMsg.RemittanceDetailUI", "status: %d", new Object[]{Integer.valueOf(i3)});
                    String string;
                    String string2;
                    CharSequence spannableString;
                    switch (i3) {
                        case 2000:
                            com.tencent.mm.plugin.order.c.a aVar;
                            if (equals) {
                                this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_wait);
                                this.mBR.setVisibility(0);
                                this.mBR.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        o.bOR();
                                        MMActivity mMActivity = RemittanceDetailUI.this;
                                        com.tencent.mm.wallet_core.d.e c = RemittanceDetailUI.this.uYO;
                                        1 1 = new 1(this);
                                        if (!o.a(mMActivity, c)) {
                                            RemittanceDetailUI.this.brB();
                                        }
                                    }
                                });
                                if (bi.oW(charSequence) || bi.oW(charSequence2)) {
                                    this.mBP.setText(i.remittance_detail_result_wait_receiver);
                                    if (xVar.myx == 0) {
                                        string = getString(i.remittance_detail_reveiver_tips2, new Object[]{Integer.valueOf(this.mBZ)});
                                    } else if (bi.oW(xVar.myw)) {
                                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.RemittanceDetailUI", "use hardcode wording");
                                        string = xVar.myx == 1 ? "24" : "2";
                                        string = getString(i.remittance_detail_reveiver_tips1, new Object[]{string}) + getString(i.remittance_detail_reveiver_tips2, new Object[]{Integer.valueOf(this.mBZ)});
                                    } else {
                                        string = xVar.myw;
                                    }
                                    string2 = getString(i.remittance_detail_refuse_action);
                                    charSequence2 = new SpannableString(string + string2);
                                    aVar = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar.lQF = new com.tencent.mm.plugin.order.c.a.a() {
                                        public final void onClick(View view) {
                                            com.tencent.mm.ui.base.h.a(RemittanceDetailUI.this, RemittanceDetailUI.this.getString(i.remittance_detail_refund_tips, new Object[]{RemittanceDetailUI.aM(xVar.myt, false)}), RemittanceDetailUI.this.getString(i.app_remind), RemittanceDetailUI.this.getString(i.remittance_detail_refuse_btn_text), RemittanceDetailUI.this.getString(i.app_cancel), new 1(this), new 2(this));
                                        }
                                    };
                                    charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                    this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.kUA.setText(charSequence2);
                                } else {
                                    this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                    this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                    this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                    this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                }
                            } else if (bi.oW(charSequence) || bi.oW(charSequence2)) {
                                this.mBP.setText(j.a(this, getString(i.remittance_detail_result_wait_sender, new Object[]{aM(this.lOk, true)}), this.mBP.getTextSize()));
                                string = getString(i.remittance_detail_sender_tips, new Object[]{Integer.valueOf(this.mBZ)});
                                string2 = getString(i.remittance_resend_transfer_msg);
                                charSequence2 = new SpannableString(string + string2);
                                aVar = new com.tencent.mm.plugin.order.c.a(this);
                                aVar.lQF = new 2(this);
                                charSequence2.setSpan(aVar, string.length(), string.length() + string2.length(), 33);
                                this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.kUA.setText(charSequence2);
                            } else {
                                this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                            }
                            this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_wait);
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myr)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setVisibility(8);
                            break;
                        case 2001:
                            this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_received);
                            if (!bi.oW(charSequence) && !bi.oW(charSequence2)) {
                                this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                            } else if (equals) {
                                this.mBP.setText(i.remittance_detail_result_collected);
                                charSequence = new SpannableStringBuilder(getString(i.remittance_detail_check_ballance));
                                com.tencent.mm.plugin.order.c.a aVar2 = new com.tencent.mm.plugin.order.c.a(this);
                                aVar2.lQF = new com.tencent.mm.plugin.order.c.a.a() {
                                    public final void onClick(View view) {
                                        com.tencent.mm.pluginsdk.wallet.h.ab(RemittanceDetailUI.this, 0);
                                    }
                                };
                                charSequence.setSpan(aVar2, 0, charSequence.length(), 18);
                                this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.kUA.setText(charSequence);
                                this.kUA.setVisibility(0);
                            } else {
                                this.mBP.setText(j.a(this, aM(this.lOk, true) + getString(i.remittance_detail_result_collected), this.mBP.getTextSize()));
                                this.kUA.setText(i.remittance_detail_sender_success_tips);
                                this.kUA.setVisibility(0);
                            }
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myr)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setText(getString(i.remittance_detail_receive_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myu)}));
                            this.mBT.setVisibility(0);
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_refunded);
                                if (!bi.oW(charSequence)) {
                                    this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                    this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                } else if (equals) {
                                    this.mBP.setText(i.remittance_detail_result_refunded);
                                } else {
                                    this.mBP.setText(j.a(this, aM(this.lOk, true) + getString(i.remittance_detail_result_refunded), this.mBP.getTextSize()));
                                }
                            } else {
                                this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_timed_out);
                                if (bi.oW(charSequence)) {
                                    this.mBP.setText(i.remittance_detail_result_timeout_refunded);
                                } else {
                                    this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                    this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                }
                            }
                            if (equals) {
                                this.kUA.setVisibility(8);
                            } else {
                                if (!bi.oW(charSequence2)) {
                                    this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                    this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                } else if ("CFT".equals(xVar.lOt) || "LQT".equals(xVar.lOt)) {
                                    boolean equals2 = "LQT".equals(xVar.lOt);
                                    string2 = equals2 ? getString(i.remittance_detail_refund_to_lqt) : getString(i.remittance_detail_refund_to_ballance);
                                    string = equals2 ? getString(i.remittance_detail_check_lqt) : getString(i.remittance_detail_check_ballance);
                                    spannableString = new SpannableString(string2 + string);
                                    com.tencent.mm.plugin.order.c.a aVar3 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar3.lQF = new 6(this, equals2);
                                    spannableString.setSpan(aVar3, string2.length(), string.length() + string2.length(), 33);
                                    this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.kUA.setText(spannableString);
                                } else {
                                    this.kUA.setText(i.remittance_detail_refund_to_bankcard);
                                }
                                this.kUA.setVisibility(0);
                            }
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myr)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setText(getString(i.remittance_detail_refund_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myu)}));
                            this.mBT.setVisibility(0);
                            break;
                        case 2004:
                            if (equals) {
                                this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_wait);
                                if (bi.oW(charSequence) || bi.oW(charSequence2)) {
                                    if (bi.oW(xVar.myv)) {
                                        this.mBP.setText(i.remittance_detail_result_receiver_waited);
                                    } else {
                                        this.mBP.setText(xVar.myv);
                                    }
                                    if (bi.oW(xVar.myw)) {
                                        this.kUA.setText(i.remittance_detail_receiver_wait_tips);
                                    } else {
                                        this.kUA.setText(xVar.myw);
                                    }
                                } else {
                                    this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                    this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                    this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                    this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                }
                            } else {
                                this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_wait);
                                if (bi.oW(charSequence) || bi.oW(charSequence2)) {
                                    if (!bi.oW(xVar.myv)) {
                                        try {
                                            this.mBP.setText(String.format(xVar.myv, new Object[]{aM(this.lOk, true)}));
                                        } catch (Throwable e) {
                                            com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.RemittanceDetailUI", e, "", new Object[0]);
                                        }
                                        if (bi.oW(xVar.myw)) {
                                            this.kUA.setText(xVar.myw);
                                        } else {
                                            this.kUA.setText("");
                                        }
                                    }
                                    this.mBP.setText(getString(i.remittance_detail_result_sender_waited, new Object[]{aM(this.lOk, true)}));
                                    if (bi.oW(xVar.myw)) {
                                        this.kUA.setText("");
                                    } else {
                                        this.kUA.setText(xVar.myw);
                                    }
                                } else {
                                    this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                    this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                    this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                    this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                }
                            }
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myr)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setText(getString(i.remittance_detail_receive_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myu)}));
                            this.mBT.setVisibility(0);
                            break;
                        case 2005:
                            this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.h.remittance_cancle);
                            if (bi.oW(charSequence) || bi.oW(charSequence2)) {
                                if (bi.oW(xVar.myv)) {
                                    this.mBP.setText(i.remittance_detail_result_canceled);
                                } else {
                                    this.mBP.setText(xVar.myv);
                                }
                                if (bi.oW(xVar.myw)) {
                                    if (equals) {
                                        this.kUA.setText(i.remittance_detail_receiver_cancel_tips);
                                    } else {
                                        this.kUA.setText(i.remittance_detail_sender_cancel_tips);
                                    }
                                } else if ("CFT".equals(xVar.lOt) || "LQT".equals(xVar.lOt)) {
                                    equals = "LQT".equals(xVar.lOt);
                                    Object obj = xVar.myw;
                                    charSequence = equals ? getString(i.remittance_detail_check_lqt) : getString(i.remittance_detail_check_ballance);
                                    spannableString = new SpannableStringBuilder();
                                    spannableString.append(obj);
                                    spannableString.append(charSequence);
                                    com.tencent.mm.plugin.order.c.a aVar4 = new com.tencent.mm.plugin.order.c.a(this);
                                    aVar4.lQF = new 7(this, equals);
                                    spannableString.setSpan(aVar4, obj.length(), spannableString.length(), 18);
                                    this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                    this.kUA.setText(spannableString);
                                } else {
                                    this.kUA.setText(xVar.myw);
                                }
                            } else {
                                this.mBP.setText(j.a(this, charSequence, (int) this.mBP.getTextSize(), bundle));
                                this.kUA.setText(j.a(this, charSequence2, (int) this.kUA.getTextSize(), bundle));
                                this.mBP.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                                this.kUA.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.d.m());
                            }
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myr)}));
                            this.mBS.setVisibility(0);
                            if (xVar.myu <= 0) {
                                this.mBT.setVisibility(8);
                                break;
                            }
                            this.mBT.setText(getString(i.remittance_detail_cancel_time, new Object[]{com.tencent.mm.wallet_core.ui.e.hb(xVar.myu)}));
                            this.mBT.setVisibility(0);
                            break;
                            break;
                        default:
                            finish();
                            break;
                    }
                    if (!bi.oW(xVar.myy)) {
                        com.tencent.mm.wallet_core.ui.e.a((TextView) findViewById(f.banner_tips), "7", xVar.myy, xVar.myz);
                    }
                }
                this.mCc = xVar.myx;
                g.Ek();
                this.mzm = (String) g.Ei().DT().get(aa.a.sVm, "");
                g.Ek();
                this.mzn = ((Integer) g.Ei().DT().get(aa.a.sVn, Integer.valueOf(0))).intValue();
                if (bi.oW(this.mzm)) {
                    ae.a(true, this.uYO);
                } else {
                    ae.a(false, this.uYO);
                }
                brq();
                if (xVar.lOD == 1) {
                    g.Ek();
                    if (((String) g.Ei().DT().get(327729, "0")).equals("0")) {
                        com.tencent.mm.ui.base.h.a(this.mController.tml, q.GS() ? i.chatting_item_appmsg_remittance_collect_tips_payu : i.wallet_remittance_collect_tips, i.wallet_remittance_collect_title, new 9(this));
                        g.Ek();
                        g.Ei().DT().set(327729, "1");
                    } else if (this.mCc == 0) {
                        com.tencent.mm.ui.base.h.bA(this.mController.tml, getString(i.remittance_detail_msg_collect_suc));
                    }
                }
                return true;
            }
        } else if (lVar instanceof u) {
            if (i == 0 && i2 == 0) {
                this.mCd = (u) lVar;
                if ("confirm".equals(this.mCd.mxA)) {
                    vq(1);
                } else {
                    aA(0, getString(i.remittance_detail_msg_refuse_suc));
                }
                return true;
            } else if (i2 == 416) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("realname_verify_process_jump_plugin", "remittance");
                bundle2.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
                return com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i2, lVar, bundle2, 1008);
            } else {
                aA(i2, str);
                return true;
            }
        } else if (lVar instanceof ae) {
            if (i == 0 && i2 == 0) {
                this.mzm = ((ae) lVar).pjN;
                this.mzn = ((ae) lVar).pjO;
                brq();
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.RemittanceDetailUI", "net error");
            }
            return true;
        }
        if (lVar instanceof com.tencent.mm.plugin.wallet_core.id_verify.model.e) {
            return true;
        }
        return false;
    }

    protected final int getLayoutId() {
        return com.tencent.mm.plugin.wxpay.a.g.remittance_detail_ui;
    }

    public final void aA(int i, String str) {
        Intent intent = new Intent();
        intent.putExtra("result_msg", str);
        setResult(i, intent);
        finish();
    }

    public void finish() {
        Bundle bundle = new Bundle();
        bundle.putString("realname_verify_process_jump_plugin", "remittance");
        bundle.putString("realname_verify_process_jump_activity", ".ui.RemittanceDetailUI");
        if (this.mCd == null || !com.tencent.mm.plugin.wallet_core.id_verify.util.a.b(this, this.mCd, bundle, true, 1008)) {
            super.finish();
        } else {
            this.mCd = null;
        }
    }

    public static String aM(String str, boolean z) {
        String gT = com.tencent.mm.wallet_core.ui.e.gT(str);
        if (gT == null) {
            return "";
        }
        if (gT.length() <= 10 || !z) {
            return gT;
        }
        return gT.substring(0, 8) + "...";
    }
}
