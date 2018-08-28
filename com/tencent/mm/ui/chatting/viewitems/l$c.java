package com.tencent.mm.ui.chatting.viewitems;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.chatting.b.b.g;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.g$a;
import com.tencent.smtt.sdk.TbsListener$ErrorCode;

public class l$c extends b {
    private a tKy;

    public final boolean bba() {
        return true;
    }

    public final boolean aq(int i, boolean z) {
        if (z && i == 419430449) {
            return true;
        }
        return false;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_to_appmsg_remittance);
        rVar.setTag(new l.a().dD(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g$a J;
        this.tKy = aVar2;
        l.a aVar3 = (l.a) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g$a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            l.a.P(aVar3.hrH, aVar3.uau);
            aVar3.hrH.setBackgroundResource(R.g.c2c_chatto_bg);
            aVar3.hrH.setPadding(aVar2.tTq.getContext().getResources().getDimensionPixelSize(R.f.MiddlePadding), 0, com.tencent.mm.bp.a.fromDPToPix(aVar2.tTq.getContext(), 13), 0);
            aVar3.ubs.setSingleLine(true);
            tj tjVar = new tj();
            tjVar.ceU.bXz = J.dxB;
            com.tencent.mm.sdk.b.a.sFg.m(tjVar);
            boolean z = tjVar.ceV.ceW;
            if (tjVar.ceV.status == -2) {
                z = false;
            }
            int i2 = tjVar.ceV.status;
            if (i2 <= 0) {
                i2 = J.dxy;
            }
            CharSequence string;
            switch (i2) {
                case 1:
                case 7:
                    au.HU();
                    ab Yf = c.FR().Yf(bdVar.field_talker);
                    if (Yf != null) {
                        str2 = Yf.BL();
                    } else {
                        str2 = bdVar.field_talker;
                    }
                    if (ai.oW(J.dyI)) {
                        aVar3.ubs.setText(j.a(aVar2.tTq.getContext(), aVar2.tTq.getMMResources().getString(R.l.chatting_item_appmsg_remittance_payer_title, new Object[]{ai.oV(str2)}), aVar3.ubs.getTextSize()));
                    } else {
                        aVar3.ubs.setText(j.a(aVar2.tTq.getContext(), J.dyI));
                    }
                    aVar3.ubt.setText(J.dxz);
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_icon);
                    break;
                case 3:
                    if (z) {
                        if (ai.oW(J.dyI)) {
                            string = ad.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer);
                        } else {
                            string = ad.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer) + "-" + J.dyI;
                        }
                        aVar3.ubs.setText(j.a(aVar2.tTq.getContext(), string));
                    } else {
                        aVar3.ubs.setText(R.l.chatting_item_appmsg_remittance_accpeted_receiver);
                    }
                    aVar3.ubt.setText(J.dxz);
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_received_icon);
                    a(aVar3);
                    break;
                case 4:
                    aVar3.ubt.setText(J.dxz);
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_rejected_icon);
                    if (z) {
                        if (ai.oW(J.dyI)) {
                            string = ad.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer);
                        } else {
                            string = ad.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer) + "-" + J.dyI;
                        }
                        aVar3.ubs.setText(j.a(aVar2.tTq.getContext(), string));
                    } else {
                        aVar3.ubs.setText(R.l.chatting_item_appmsg_remittance_rejected);
                    }
                    a(aVar3);
                    break;
                case 5:
                    if (z) {
                        if (ai.oW(J.dyI)) {
                            string = ad.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer);
                        } else {
                            string = ad.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer) + "-" + J.dyI;
                        }
                        aVar3.ubs.setText(j.a(aVar2.tTq.getContext(), string));
                    } else {
                        aVar3.ubs.setText(R.l.chatting_item_appmsg_remittance_delay_confirm_receiver);
                    }
                    aVar3.ubt.setText(J.dxz);
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_received_icon);
                    a(aVar3);
                    break;
                case 6:
                    aVar3.ubs.setText(R.l.chatting_item_appmsg_remittance_cancel);
                    aVar3.ubt.setText(J.dxz);
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_cancle_icon);
                    a(aVar3);
                    break;
                default:
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_icon);
                    aVar3.ubs.setSingleLine(false);
                    aVar3.ubs.setMaxLines(2);
                    aVar3.ubt.setText(null);
                    aVar3.ubs.setText(J.description);
                    break;
            }
            aVar3.hrH.setOnClickListener(d(aVar2));
            aVar3.hrH.setOnLongClickListener(c(aVar2));
            aVar3.hrH.setOnTouchListener(((g) aVar2.O(g.class)).ctw());
            aVar3.hrH.setTag(new au(bdVar, this.tKy.cwr(), i, null, 0));
        }
    }

    private static void a(l.a aVar) {
        int paddingLeft = aVar.hrH.getPaddingLeft();
        int paddingTop = aVar.hrH.getPaddingTop();
        int paddingRight = aVar.hrH.getPaddingRight();
        int paddingBottom = aVar.hrH.getPaddingBottom();
        aVar.hrH.setBackgroundResource(R.g.c2c_chatto_done_bg);
        aVar.hrH.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        String str = bdVar.field_content;
        g$a g_a = null;
        if (str != null) {
            g_a = g$a.J(str, bdVar.field_reserved);
        }
        if (g_a != null) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
            if (g_a.dxy == 1) {
                contextMenu.add(i, 103, 0, this.tKy.tTq.getMMResources().getString(R.l.span_remittance_resend));
            }
        }
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                return true;
            case 103:
                String str = bdVar.field_content;
                g$a g_a = null;
                if (str != null) {
                    g_a = g$a.J(str, bdVar.field_reserved);
                }
                if (g_a != null) {
                    String str2 = g_a.dxA;
                    String str3 = bdVar.field_talker;
                    int i = g_a.dxC;
                    int i2 = g_a.bYg;
                    String str4 = g_a.bJg;
                    Context context = aVar.tTq.getContext();
                    String string = aVar.tTq.getMMResources().getString(R.l.span_remittance_confirm_resend_msg);
                    String string2 = aVar.tTq.getMMResources().getString(R.l.app_remind);
                    String string3 = aVar.tTq.getMMResources().getString(R.l.span_remittance_resend);
                    String string4 = aVar.tTq.getMMResources().getString(R.l.app_cancel);
                    1 1 = new 1(this, str2, str3, i, i2, str4, aVar);
                    h.a(context, string, string2, string3, string4, 1, new 2(this));
                }
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        String str = bdVar.field_content;
        g$a g_a = null;
        if (str != null) {
            g_a = g$a.J(str, bdVar.field_reserved);
        }
        if (g_a == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sender_name", bdVar.field_talker);
        switch (g_a.dxy) {
            case 1:
            case 7:
                intent.putExtra("invalid_time", g_a.dxC);
                intent.putExtra("is_sender", true);
                intent.putExtra("appmsg_type", g_a.dxy);
                intent.putExtra("transfer_id", g_a.dxB);
                intent.putExtra("transaction_id", g_a.dxA);
                intent.putExtra("effective_date", g_a.dxD);
                intent.putExtra("total_fee", g_a.bYg);
                intent.putExtra("fee_type", g_a.bJg);
                3 3 = new 3(this, aVar);
                if (!q.GS()) {
                    d.a(aVar.tTo, "remittance", ".ui.RemittanceDetailUI", intent, TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS, 3);
                    break;
                }
                d.a(aVar.tTo, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, TbsListener$ErrorCode.INCRUPDATE_INSTALL_SUCCESS, 3);
                break;
            case 3:
            case 4:
            case 5:
            case 6:
                intent.putExtra("appmsg_type", g_a.dxy);
                intent.putExtra("transfer_id", g_a.dxB);
                intent.putExtra("transaction_id", g_a.dxA);
                intent.putExtra("effective_date", g_a.dxD);
                intent.putExtra("total_fee", g_a.bYg);
                intent.putExtra("fee_type", g_a.bJg);
                if (!q.GS()) {
                    d.b(aVar.tTq.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                    break;
                }
                d.b(aVar.tTq.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                break;
            default:
                x.w("MicroMsg.ChattingItemAppMsgRemittanceTo", "Unrecognized type %d, probably version to low & check update!", new Object[]{Integer.valueOf(g_a.dxy)});
                ai.cj(aVar.tTq.getContext());
                break;
        }
        return true;
    }
}
