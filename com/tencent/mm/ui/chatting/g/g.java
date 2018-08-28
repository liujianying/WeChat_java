package com.tencent.mm.ui.chatting.g;

import android.content.Context;
import android.support.v7.widget.RecyclerView.t;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.a.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.y.g.a;

public final class g extends b {
    int gBh = -1;

    static /* synthetic */ String a(g gVar, Context context, bd bdVar, a aVar, boolean z, int i) {
        if (aVar == null || context == null) {
            return "";
        }
        switch (i) {
            case 1:
            case 7:
                au.HU();
                com.tencent.mm.l.a Yf = c.FR().Yf(bdVar.field_talker);
                String BL = Yf != null ? Yf.BL() : bdVar.field_talker;
                if (!z) {
                    return gVar.mContext.getString(R.l.chatting_item_appmsg_remittance_accpeted_receiver);
                }
                if (!bi.oW(aVar.dyI)) {
                    return aVar.dyI;
                }
                if (bdVar.field_isSend != 1) {
                    return gVar.mContext.getString(R.l.chatting_item_appmsg_remittance_receiver_title);
                }
                return gVar.mContext.getString(R.l.chatting_item_appmsg_remittance_payer_title, new Object[]{BL});
            case 3:
                if (z) {
                    return bi.oW(aVar.dyI) ? ad.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer) : ad.getContext().getString(R.l.chatting_item_appmsg_remittance_accepted_payer) + "-" + aVar.dyI;
                } else {
                    return ad.getContext().getString(R.l.chatting_item_appmsg_remittance_accpeted_receiver);
                }
            case 4:
                if (z) {
                    return bi.oW(aVar.dyI) ? ad.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer) : ad.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected_payer) + "-" + aVar.dyI;
                } else {
                    return ad.getContext().getString(R.l.chatting_item_appmsg_remittance_rejected);
                }
            case 5:
                if (z) {
                    return bi.oW(aVar.dyI) ? ad.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer) : ad.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_payer) + "-" + aVar.dyI;
                } else {
                    return ad.getContext().getString(R.l.chatting_item_appmsg_remittance_delay_confirm_receiver);
                }
            case 6:
                return context.getResources().getString(R.l.chatting_item_appmsg_remittance_cancel);
            default:
                return aVar.description;
        }
    }

    public g(Context context) {
        super(context);
    }

    public final int getType() {
        return 5;
    }

    public static boolean lN(int i) {
        return bi.WU("1001") == i || bi.WU("1002") == i || 419430449 == i;
    }

    public final void cwG() {
        this.tXZ.cwK();
        com.tencent.mm.kernel.g.Ek();
        com.tencent.mm.kernel.g.Em().H(new 1(this));
    }

    public final String Wm() {
        return this.mContext.getString(R.l.search_chatroom_pay);
    }

    public final String cwJ() {
        return this.mContext.getString(R.l.search_chatroom_pay);
    }

    public final e cwH() {
        return new 2(this);
    }

    public final t m(ViewGroup viewGroup) {
        return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.i.file_list_item, viewGroup, false));
    }

    public final void a(b.a aVar, int i) {
        b bVar = (b) aVar;
        a aVar2 = (a) EZ(i);
        if (bi.oW(aVar2.desc)) {
            bVar.eCn.setVisibility(8);
        } else {
            bVar.eCn.setVisibility(0);
            bVar.eCn.setText(bi.aG(aVar2.desc, ""));
        }
        int fromDPToPix = com.tencent.mm.bp.a.fromDPToPix(this.mContext, 6);
        bVar.gmn.setPadding(fromDPToPix, fromDPToPix, fromDPToPix, fromDPToPix);
        bVar.gmn.setImageResource(aVar2.iconRes);
        bVar.gmn.setBackgroundColor(aVar2.tYG);
    }
}
