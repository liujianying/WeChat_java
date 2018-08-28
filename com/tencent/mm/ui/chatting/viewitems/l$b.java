package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.tj;
import com.tencent.mm.model.q;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.y.g;

public class l$b extends b {
    private a tKy;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 419430449) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_appmsg_remittance);
        rVar.setTag(new l.a().dD(rVar));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        g.a J;
        boolean z = true;
        this.tKy = aVar2;
        l.a aVar3 = (l.a) aVar;
        String str2 = bdVar.field_content;
        if (str2 != null) {
            J = g.a.J(str2, bdVar.field_reserved);
        } else {
            J = null;
        }
        if (J != null) {
            l.a.P(aVar3.hrH, aVar3.uau);
            aVar3.hrH.setBackgroundResource(R.g.c2c_chatfrom_bg);
            aVar3.hrH.setPadding(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 13), 0, aVar2.tTq.getContext().getResources().getDimensionPixelOffset(R.f.chattingBubblepadding), 0);
            aVar3.ubs.setSingleLine(true);
            tj tjVar = new tj();
            tjVar.ceU.bXz = J.dxB;
            com.tencent.mm.sdk.b.a.sFg.m(tjVar);
            if (tjVar.ceV.ceW) {
                z = false;
            }
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
                    if (ai.oW(J.dyI)) {
                        aVar3.ubs.setText(R.l.chatting_item_appmsg_remittance_receiver_title);
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
                    aVar3.ubt.setText(J.dxz);
                    aVar3.ubr.setImageResource(R.k.c2c_remittance_received_icon);
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
            aVar3.hrH.setOnTouchListener(((com.tencent.mm.ui.chatting.b.b.g) aVar2.O(com.tencent.mm.ui.chatting.b.b.g.class)).ctw());
            aVar3.hrH.setTag(new au(bdVar, aVar2.cwr(), i, null, 0));
        }
    }

    private static void a(l.a aVar) {
        int paddingLeft = aVar.hrH.getPaddingLeft();
        int paddingTop = aVar.hrH.getPaddingTop();
        int paddingRight = aVar.hrH.getPaddingRight();
        int paddingBottom = aVar.hrH.getPaddingBottom();
        aVar.hrH.setBackgroundResource(R.g.c2c_chatfrom_done_bg);
        aVar.hrH.setPadding(paddingLeft, paddingTop, paddingRight, paddingBottom);
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        int i = ((au) view.getTag()).position;
        if (bdVar != null) {
            contextMenu.add(i, 100, 0, this.tKy.tTq.getMMResources().getString(R.l.chatting_long_click_menu_delete_msg));
        }
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 100:
                com.tencent.mm.model.bd.aU(bdVar.field_msgId);
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        String str = bdVar.field_content;
        g.a aVar2 = null;
        if (str != null) {
            aVar2 = g.a.J(str, bdVar.field_reserved);
        }
        if (aVar2 == null) {
            return false;
        }
        Intent intent = new Intent();
        intent.putExtra("sender_name", bdVar.field_talker);
        switch (aVar2.dxy) {
            case 1:
            case 7:
                intent.putExtra("invalid_time", aVar2.dxC);
                intent.putExtra("is_sender", false);
                intent.putExtra("appmsg_type", aVar2.dxy);
                intent.putExtra("transfer_id", aVar2.dxB);
                intent.putExtra("transaction_id", aVar2.dxA);
                intent.putExtra("effective_date", aVar2.dxD);
                intent.putExtra("total_fee", aVar2.bYg);
                intent.putExtra("fee_type", aVar2.bJg);
                if (q.GS()) {
                    d.a(aVar.tTq, "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent, 221);
                    return true;
                }
                d.a(aVar.tTq, "remittance", ".ui.RemittanceDetailUI", intent, 221);
                return true;
            case 3:
            case 4:
            case 5:
            case 6:
                intent.putExtra("is_sender", true);
                intent.putExtra("appmsg_type", aVar2.dxy);
                intent.putExtra("transfer_id", aVar2.dxB);
                intent.putExtra("transaction_id", aVar2.dxA);
                intent.putExtra("effective_date", aVar2.dxD);
                intent.putExtra("total_fee", aVar2.bYg);
                intent.putExtra("fee_type", aVar2.bJg);
                if (q.GS()) {
                    d.b(aVar.tTq.getContext(), "wallet_payu", ".remittance.ui.PayURemittanceDetailUI", intent);
                    return true;
                }
                d.b(aVar.tTq.getContext(), "remittance", ".ui.RemittanceDetailUI", intent);
                return true;
            default:
                x.w("MicroMsg.ChattingItemAppMsgRemittanceFrom", "Unrecognized type %d, probably version to low & check update!", new Object[]{Integer.valueOf(aVar2.dxy)});
                ai.cj(aVar.tTq.getContext());
                return true;
        }
    }
}
