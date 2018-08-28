package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.d.b;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;

class CardNewMsgUI$9 implements OnClickListener {
    final /* synthetic */ CardNewMsgUI hFN;

    CardNewMsgUI$9(CardNewMsgUI cardNewMsgUI) {
        this.hFN = cardNewMsgUI;
    }

    public final void onClick(View view) {
        g gVar;
        if (view.getId() == d.extent_tv) {
            gVar = (g) view.getTag();
            if (gVar != null && gVar.awX() != null) {
                h.mEJ.h(11941, new Object[]{Integer.valueOf(2), gVar.field_card_id, gVar.field_card_tp_id, gVar.field_msg_id, ""});
                if (gVar.awX().hwF == 0) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_URL");
                    if (TextUtils.isEmpty(gVar.awX().url)) {
                        x.e("MicroMsg.CardNewMsgUI", "card msg button url is empty");
                    } else {
                        b.a(this.hFN, gVar.awX().url, 2);
                    }
                } else if (gVar.awX().hwF == 1) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_BUTTON_TYPE_SHOP");
                    Intent intent = new Intent();
                    intent.putExtra("KEY_CARD_ID", gVar.field_card_id);
                    intent.putExtra("KEY_CARD_TP_ID", gVar.field_card_tp_id);
                    intent.setClass(this.hFN, CardShopUI.class);
                    this.hFN.startActivity(intent);
                    h.mEJ.h(11324, new Object[]{"UsedStoresView", Integer.valueOf(gVar.field_card_type), gVar.field_card_tp_id, gVar.field_card_id, Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), ""});
                }
            }
        } else if (view.getId() == d.oper_layout) {
            gVar = (g) view.getTag();
            if (gVar != null && gVar.awY() != null) {
                if (gVar.awY().type == 0) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_TEXT");
                    if (TextUtils.isEmpty(gVar.awY().url)) {
                        x.e("MicroMsg.CardNewMsgUI", "card msg oper region url is empty");
                    } else {
                        b.a(this.hFN, gVar.awY().url, 2);
                    }
                } else if (gVar.awY().type == 1) {
                    x.i("MicroMsg.CardNewMsgUI", "card msg action_type is MM_CARD_ITEM_XML_MSG_OPERATION_REGION_TYPE_CARDS");
                }
            }
        }
    }
}
