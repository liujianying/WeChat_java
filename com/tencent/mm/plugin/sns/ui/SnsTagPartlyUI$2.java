package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.q;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.storage.t;
import com.tencent.mm.ui.contact.s;

class SnsTagPartlyUI$2 implements OnItemClickListener {
    final /* synthetic */ SnsTagPartlyUI obN;

    SnsTagPartlyUI$2(SnsTagPartlyUI snsTagPartlyUI) {
        this.obN = snsTagPartlyUI;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        if (i < SnsTagPartlyUI.a(this.obN).getCount() - 1) {
            Intent intent = new Intent();
            t tVar = (t) SnsTagPartlyUI.a(this.obN).getItem(i);
            if (tVar != null) {
                intent.putExtra("k_sns_tag_id", tVar.field_tagId);
                intent.setClass(this.obN, SnsTagDetailUI.class);
                this.obN.startActivity(intent);
                return;
            }
            return;
        }
        Intent intent2 = new Intent();
        String GF = q.GF();
        intent2.putExtra("titile", this.obN.getString(j.address_title_add_contact));
        intent2.putExtra("list_type", 1);
        intent2.putExtra("list_attr", s.s(new int[]{s.ukF, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT}));
        intent2.putExtra("block_contact", GF);
        d.b(this.obN, ".ui.contact.SelectContactUI", intent2, 1);
    }
}
