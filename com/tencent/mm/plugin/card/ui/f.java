package com.tencent.mm.plugin.card.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.a.g;
import com.tencent.mm.plugin.card.d.m;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.sharecard.a.b;
import com.tencent.mm.plugin.card.sharecard.model.l;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

public final class f {
    private MMActivity gKS;
    private ImageView[] hEA = new ImageView[3];
    private ImageView hEB;
    private int hEv;
    private View hEw;
    private TextView hEx;
    private TextView hEy;
    private ImageView hEz;
    View hyK;
    private b hzM;

    public f(MMActivity mMActivity, View view, int i, b bVar) {
        this.gKS = mMActivity;
        this.hyK = view;
        this.hEv = i;
        this.hzM = bVar;
        this.hEw = this.hyK.findViewById(d.card_home_page_item_layout);
        this.hEx = (TextView) this.hyK.findViewById(d.card_home_page_item_title);
        this.hEy = (TextView) this.hyK.findViewById(d.card_home_page_item_tips);
        this.hEz = (ImageView) this.hyK.findViewById(d.card_home_page_item_type_icon);
        this.hEA[0] = (ImageView) this.hyK.findViewById(d.card_home_page_item_icon_1);
        this.hEA[1] = (ImageView) this.hyK.findViewById(d.card_home_page_item_icon_2);
        this.hEA[2] = (ImageView) this.hyK.findViewById(d.card_home_page_item_icon_3);
        this.hEB = (ImageView) this.hyK.findViewById(d.card_red_dot_img);
        if (this.hEv == 1) {
            this.hEx.setText(this.gKS.getString(g.card_member_card_count_title, new Object[]{Integer.valueOf(0)}));
            this.hEz.setImageResource(com.tencent.mm.plugin.card.a.f.card_home_member_card_icon);
        } else if (this.hEv == 2) {
            this.hEx.setText(g.card_share_card_title);
            this.hEz.setImageResource(com.tencent.mm.plugin.card.a.f.card_home_friend_ticket_icon);
        } else if (this.hEv == 3) {
            this.hEx.setText(g.card_ticket_title);
            this.hEz.setImageResource(com.tencent.mm.plugin.card.a.f.card_home_my_ticket_icon);
        }
    }

    public final void setOnClickListener(OnClickListener onClickListener) {
        this.hEw.setOnClickListener(onClickListener);
    }

    public final void aL() {
        if (this.hEv == 2) {
            l lVar = (l) am.axn().getValue("key_share_card_layout_data");
            if (lVar == null) {
                x.w("MicroMsg.CardHomePageItemController", "updateShareCardView data is null");
                return;
            }
            if (bi.oW(lVar.hyz)) {
                this.hEy.setVisibility(8);
            } else {
                this.hEy.setVisibility(0);
                this.hEy.setText(lVar.hyz);
            }
            if (bi.cX(lVar.hyy)) {
                for (int i = 0; i < 3; i++) {
                    this.hEA[i].setVisibility(8);
                }
            } else {
                for (int i2 = 0; i2 < 3; i2++) {
                    if (i2 < lVar.hyy.size()) {
                        this.hEA[i2].setVisibility(0);
                        m.a(this.hEA[i2], (String) lVar.hyy.get(i2), this.gKS.getResources().getDimensionPixelSize(a.b.LargerPadding), c.my_card_package_defaultlogo, false);
                    } else {
                        this.hEA[i2].setVisibility(8);
                    }
                }
            }
            if (bi.cX(lVar.hyy) || lVar.hyy.size() != 1 || !lVar.cal || lVar.cam) {
                this.hEB.setVisibility(8);
            } else {
                this.hEB.setVisibility(0);
            }
        } else if (this.hEv == 3) {
            this.hEx.setText(g.card_ticket_title);
            this.hyK.findViewById(d.card_home_page_item_extra_relative).setVisibility(8);
            String str = (String) am.axn().getValue("key_card_entrance_tips");
            if (bi.oW(str)) {
                this.hEy.setVisibility(8);
                return;
            }
            this.hEy.setText(str);
            this.hEy.setVisibility(0);
        }
    }
}
