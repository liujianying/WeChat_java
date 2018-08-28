package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.a$e;
import com.tencent.mm.plugin.card.a$g;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.sharecard.model.r;
import com.tencent.mm.plugin.card.ui.a.g;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.MMActivity;
import java.util.ArrayList;
import java.util.Iterator;

public final class x extends i {
    MMActivity gKS;
    private boolean hId = false;
    private View hIe;
    private View hIf;
    private ImageView hIg;
    private TextView hIh;
    private TextView hIi;
    private ImageView hIj;
    View hIk;
    private LinearLayout hIl;
    private OnClickListener hIm = new 1(this);

    public final void initView() {
        this.hIe = findViewById(d.share_users_info_header_layout);
        this.hIf = findViewById(d.share_users_top_layout);
        this.hIg = (ImageView) findViewById(d.share_user_avatar);
        this.hIh = (TextView) findViewById(d.share_user_name);
        this.hIi = (TextView) findViewById(d.share_user_tips);
        this.hIj = (ImageView) findViewById(d.share_user_select_arrowhead);
        this.hIe.setVisibility(8);
        this.hIk = findViewById(d.share_users_bottom_layout);
        this.hIl = (LinearLayout) findViewById(d.share_users_container_layout);
        this.hIk.setVisibility(8);
        this.gKS = this.hHF.ayx();
    }

    public final void update() {
        b ayu = this.hHF.ayu();
        ArrayList xv = com.tencent.mm.plugin.card.sharecard.a.b.xv(ayu.awr());
        g ayz = this.hHF.ayz();
        String str;
        if (ayz.azr()) {
            this.hIe.setVisibility(0);
            if (com.tencent.mm.plugin.card.sharecard.a.b.xu(ayu.awr()) > 1) {
                this.hIf.setOnClickListener(this.hHF.ayy());
            } else {
                this.hIj.setVisibility(8);
                this.hIk.setVisibility(8);
                this.hIl.removeAllViews();
                this.hHF.ayw();
            }
            b ayu2 = this.hHF.ayu();
            if (this.hHF.ayv()) {
                this.hIg.setVisibility(8);
                this.hIh.setVisibility(8);
                this.hIi.setVisibility(0);
                this.hIj.setImageResource(c.card_select_arrow_up);
                this.hIi.setText(this.gKS.getString(a$g.card_share_card_select_tips));
            } else {
                this.hIg.setVisibility(0);
                this.hIh.setVisibility(0);
                this.hIi.setVisibility(8);
                if (com.tencent.mm.plugin.card.sharecard.a.b.xu(ayu2.awr()) <= 1) {
                    this.hIj.setVisibility(8);
                } else {
                    this.hIj.setVisibility(0);
                    this.hIj.setImageResource(c.card_select_arrow_down);
                }
                String str2 = "";
                if (xv != null && xv.size() > 0) {
                    for (int i = 0; i < xv.size(); i++) {
                        r rVar = (r) xv.get(i);
                        if (rVar.hyI) {
                            str = rVar.hyG;
                            break;
                        }
                    }
                }
                str = str2;
                if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(ayu2.aws())) {
                    str = ayu2.aws();
                }
                if (!TextUtils.isEmpty(str)) {
                    a.b.a(this.hIg, str);
                    this.hIh.setText(j.d(this.gKS, this.gKS.getString(a$g.card_share_card_users, new Object[]{l.xY(str)}), this.gKS.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
                }
            }
            if (this.hHF.ayv()) {
                this.hIk.setVisibility(0);
                r rVar2;
                ImageView imageView;
                if (this.hIl.getChildCount() != 0 || xv == null) {
                    for (int i2 = 0; i2 < this.hIl.getChildCount(); i2++) {
                        View childAt = this.hIl.getChildAt(i2);
                        rVar2 = (xv == null || xv.size() < this.hIl.getChildCount()) ? null : (r) xv.get(i2);
                        ImageView imageView2 = (ImageView) childAt.findViewById(d.user_avatar_select);
                        imageView = (ImageView) childAt.findViewById(d.user_avatar_mask);
                        if (rVar2 == null || !rVar2.hyI) {
                            imageView2.setVisibility(8);
                            imageView.setVisibility(8);
                        } else {
                            imageView2.setVisibility(0);
                            imageView.setVisibility(0);
                        }
                    }
                    this.hIl.invalidate();
                } else {
                    LayoutInflater layoutInflater = (LayoutInflater) this.gKS.getSystemService("layout_inflater");
                    Iterator it = xv.iterator();
                    while (it.hasNext()) {
                        rVar2 = (r) it.next();
                        View inflate = layoutInflater.inflate(a$e.share_user_info_item, this.hIl, false);
                        ImageView imageView3 = (ImageView) inflate.findViewById(d.user_avatar_img);
                        TextView textView = (TextView) inflate.findViewById(d.user_name);
                        TextView textView2 = (TextView) inflate.findViewById(d.share_count);
                        if (!TextUtils.isEmpty(rVar2.hyG)) {
                            a.b.a(imageView3, rVar2.hyG);
                            CharSequence xY = l.xY(rVar2.hyG);
                            if (TextUtils.isEmpty(xY)) {
                                textView.setText("");
                            } else {
                                textView.setText(j.d(this.gKS, xY, this.gKS.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.SmallestTextSize)));
                            }
                        }
                        textView2.setText("x " + rVar2.share_count);
                        inflate.setTag(rVar2);
                        inflate.setOnClickListener(this.hIm);
                        imageView = (ImageView) inflate.findViewById(d.user_avatar_select);
                        imageView3 = (ImageView) inflate.findViewById(d.user_avatar_mask);
                        if (rVar2.hyI) {
                            imageView.setVisibility(0);
                            imageView3.setVisibility(0);
                        } else {
                            imageView.setVisibility(8);
                            imageView3.setVisibility(8);
                        }
                        this.hIl.addView(inflate);
                    }
                    this.hIl.invalidate();
                }
            } else {
                this.hIk.setVisibility(8);
                this.hIl.removeAllViews();
            }
            this.hId = true;
        } else if (!ayz.azr()) {
            this.hIe.setVisibility(0);
            this.hIg.setVisibility(0);
            this.hIh.setVisibility(0);
            this.hIi.setVisibility(8);
            this.hIj.setVisibility(8);
            str = "";
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(ayu.aws())) {
                str = ayu.aws();
            }
            if (!TextUtils.isEmpty(str)) {
                a.b.a(this.hIg, str);
                this.hIh.setText(j.d(this.gKS, this.gKS.getString(a$g.card_share_card_users, new Object[]{l.xY(str)}), this.gKS.getResources().getDimensionPixelOffset(com.tencent.mm.plugin.card.a.b.NormalTextSize)));
            }
            this.hId = true;
        }
    }

    public final void azI() {
        this.hIe.setVisibility(8);
    }
}
