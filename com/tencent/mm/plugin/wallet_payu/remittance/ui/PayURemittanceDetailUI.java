package com.tencent.mm.plugin.wallet_payu.remittance.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import com.tencent.mm.ab.l;
import com.tencent.mm.bg.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.order.c.a;
import com.tencent.mm.plugin.remittance.ui.RemittanceDetailUI;
import com.tencent.mm.plugin.wallet_payu.remittance.a.b;
import com.tencent.mm.plugin.wallet_payu.remittance.a.c;
import com.tencent.mm.plugin.wallet_payu.remittance.a.f;
import com.tencent.mm.plugin.wxpay.a$h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.ui.e;

public class PayURemittanceDetailUI extends RemittanceDetailUI {
    private int lOn;
    private int lOo;
    private int mCb;
    private String mDa;
    private String pFZ;
    private String pGa;
    private int pGb;
    private int pGc;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mCb = getIntent().getIntExtra("total_fee", 0);
        this.pFZ = getIntent().getStringExtra("fee_type");
        if (getIntent().getBooleanExtra("is_sender", false)) {
            this.pGa = q.GF();
            this.mDa = this.mBX;
            return;
        }
        this.pGa = this.mBX;
        this.mDa = q.GF();
    }

    protected final void vq(int i) {
        a(new f(this.mzr, this.mBX, this.mBU), true, false);
    }

    protected final void vr(int i) {
        a(new f(this.mzr, this.mBX, this.mBU, i), true, false);
    }

    protected final void X(Intent intent) {
        d.b(this, "wallet_payu", ".remittance.ui.PayURemittanceResendMsgUI", intent);
    }

    protected final void brB() {
        a(new c(this.mzr, this.mCb, this.pFZ, this.mBX), true, true);
    }

    protected final void brC() {
        a(new b(this.mzr, this.mCb, this.pFZ, this.mBX), true, true);
    }

    public final boolean d(int i, int i2, String str, l lVar) {
        if (lVar instanceof f) {
            f fVar = (f) lVar;
            String string;
            CharSequence spannableString;
            a aVar;
            if (fVar.bNI != 0) {
                boolean equals;
                boolean z = false;
                if (i == 0 && i2 == 0) {
                    this.pGb = fVar.status;
                    this.pGc = fVar.myr;
                    this.lOo = fVar.pFV;
                    this.lOn = fVar.pFW;
                    this.mCb = (int) (fVar.hUL * 100.0d);
                    this.pFZ = fVar.lNV;
                    z = true;
                    equals = this.mDa.equals(q.GF());
                    this.mBR.setVisibility(8);
                    this.mBQ.setText(e.e(((double) this.mCb) / 100.0d, this.pFZ));
                    int i3 = this.pGb;
                    String string2;
                    CharSequence spannableString2;
                    a aVar2;
                    switch (i3) {
                        case 2000:
                            if (equals) {
                                this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.e.wallet_subject_receiving);
                                this.mBR.setVisibility(0);
                                this.mBR.setOnClickListener(new 2(this));
                                string = getString(i.remittance_detail_reveiver_tips_payu, new Object[]{Integer.valueOf(this.mBZ)});
                                string2 = getString(i.remittance_detail_refuse_action);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.lQF = new 3(this);
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.kUA.setText(spannableString2);
                            } else {
                                this.mBP.setText(j.a(this, getString(i.remittance_detail_result_wait_sender, new Object[]{aM(this.mDa, true)}), this.mBP.getTextSize()));
                                string = getString(i.remittance_detail_sender_tips_payu, new Object[]{Integer.valueOf(this.mBZ)});
                                string2 = getString(i.remittance_resend_transfer_msg);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.lQF = new 1(this);
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.kUA.setText(spannableString2);
                            }
                            this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.e.wallet_subject_receiving);
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{e.hb(this.lOo)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setVisibility(8);
                            equals = true;
                            break;
                        case 2001:
                            this.mBO.setImageResource(a$h.remittance_received);
                            if (equals) {
                                this.mBP.setText(i.remittance_detail_result_collected);
                                Object string3 = getString(i.remittance_detail_check_ballance);
                                spannableString = new SpannableString(string3);
                                aVar = new a(this);
                                aVar.lQF = new 4(this);
                                spannableString.setSpan(aVar, 0, string3.length(), 33);
                                this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.kUA.setText(spannableString);
                                this.kUA.setVisibility(0);
                            } else {
                                this.mBP.setText(j.a(this, aM(this.mDa, true) + " " + getString(i.remittance_detail_result_collected), this.mBP.getTextSize()));
                                this.kUA.setVisibility(8);
                            }
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{e.hb(this.pGc)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setText(getString(i.remittance_detail_receive_time, new Object[]{e.hb(this.lOn)}));
                            this.mBT.setVisibility(0);
                            equals = true;
                            break;
                        case 2002:
                        case 2003:
                            if (i3 != 2003 || equals) {
                                this.mBO.setImageResource(a$h.remittance_refunded);
                                if (equals) {
                                    this.mBP.setText(i.remittance_detail_result_refunded);
                                } else {
                                    this.mBP.setText(j.a(this, aM(this.mDa, true) + getString(i.remittance_detail_result_refunded), this.mBP.getTextSize()));
                                }
                            } else {
                                this.mBO.setImageResource(a$h.remittance_timed_out);
                                this.mBP.setText(i.remittance_detail_result_timeout_refunded);
                            }
                            if (equals) {
                                this.kUA.setText("");
                            } else {
                                string = getString(i.remittance_detail_refund_to_ballance);
                                string2 = getString(i.remittance_detail_check_ballance);
                                spannableString2 = new SpannableString(string + string2);
                                aVar2 = new a(this);
                                aVar2.lQF = new 5(this);
                                spannableString2.setSpan(aVar2, string.length(), string.length() + string2.length(), 33);
                                this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                                this.kUA.setText(spannableString2);
                            }
                            this.kUA.setVisibility(0);
                            this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{e.hb(this.pGc)}));
                            this.mBS.setVisibility(0);
                            this.mBT.setText(getString(i.remittance_detail_refund_time, new Object[]{e.hb(this.lOo)}));
                            this.mBT.setVisibility(0);
                            equals = true;
                            break;
                        default:
                            finish();
                            break;
                    }
                }
                equals = z;
                if (fVar.bWA != 1) {
                    return equals;
                }
                g.Ek();
                if (((String) g.Ei().DT().get(327729, "0")).equals("0")) {
                    h.a(this.mController.tml, i.chatting_item_appmsg_remittance_collect_tips_payu, i.wallet_remittance_collect_tips, new 8(this));
                    g.Ek();
                    g.Ei().DT().set(327729, "1");
                    return equals;
                }
                h.bA(this.mController.tml, getString(i.remittance_detail_msg_collect_suc));
                return equals;
            } else if (i == 0 && i2 == 0) {
                if (this.mBV == 1 && !getIntent().getBooleanExtra("is_sender", false)) {
                    this.mBO.setImageResource(com.tencent.mm.plugin.wxpay.a.e.wallet_subject_receiving);
                    this.mBP.setText(i.remittance_detail_result_wait_receiver);
                    this.mBQ.setText(e.e(fVar.hUL, fVar.lNV));
                    this.mBR.setVisibility(0);
                    this.mBR.setOnClickListener(new 6(this));
                    String string4 = getString(i.remittance_detail_reveiver_tips_payu, new Object[]{Integer.valueOf(this.mBZ)});
                    string = getString(i.remittance_detail_refuse_action);
                    spannableString = new SpannableString(string4 + string);
                    aVar = new a(this);
                    aVar.lQF = new 7(this);
                    spannableString.setSpan(aVar, string4.length(), string4.length() + string.length(), 33);
                    this.kUA.setMovementMethod(LinkMovementMethod.getInstance());
                    this.kUA.setText(spannableString);
                    this.mBS.setText(getString(i.remittance_detail_transfer_time, new Object[]{e.hb(fVar.myr)}));
                    this.mBS.setVisibility(0);
                    this.mBT.setVisibility(8);
                }
                return true;
            } else {
                vr(0);
                return true;
            }
        } else if (!(lVar instanceof c) && !(lVar instanceof b)) {
            return false;
        } else {
            if (i == 0 && i2 == 0) {
                if (lVar instanceof c) {
                    vr(1);
                } else {
                    aA(0, getString(i.remittance_detail_msg_refuse_suc));
                }
                return true;
            }
            aA(i2, str);
            return true;
        }
    }
}
