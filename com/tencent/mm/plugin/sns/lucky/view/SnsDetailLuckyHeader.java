package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.i.e;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.lucky.a.m;
import com.tencent.mm.plugin.sns.model.aj;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.SnsCommentDetailUI;
import com.tencent.mm.plugin.sns.ui.TouchImageView;
import com.tencent.mm.protocal.c.bou;
import com.tencent.mm.protocal.c.boy;
import com.tencent.mm.protocal.c.bpn;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public class SnsDetailLuckyHeader extends LinearLayout {
    private View ilW = null;
    private TextView nmi;
    private LinearLayout nmj;
    private LinearLayout nmk;

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public SnsDetailLuckyHeader(Context context) {
        super(context);
        init();
    }

    public SnsDetailLuckyHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    private void init() {
        View inflate = View.inflate(getContext(), g.lucky_sns_detail_header, this);
        this.ilW = inflate.findViewById(f.album_list_hb_fatherview);
        this.nmi = (TextView) inflate.findViewById(f.album_hb_reward_tip);
        this.nmj = (LinearLayout) inflate.findViewById(f.album_hb_reward_users);
        this.nmk = getLinearSeparator();
    }

    public LinearLayout getLinearSeparator() {
        b.b(getContext(), 2.0f);
        LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 1);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundResource(e.sns_divider_line);
        linearLayout.setLayoutParams(layoutParams);
        return linearLayout;
    }

    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.ilW != null) {
            this.ilW.setVisibility(i);
        }
    }

    public final void a(n nVar, com.tencent.mm.plugin.sns.ui.b.b bVar) {
        boy n = aj.n(nVar);
        bpn bpn = n.smZ;
        if (bpn == null || bpn.snC.size() == 0) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        double b = ((double) m.b(nVar, n)) * 1.0d;
        this.nmi.setText(getContext().getString(j.sns_lucky_reward_tip_info, new Object[]{Integer.valueOf(n.smZ.snB), bi.A(b / 100.0d)}));
        this.ilW.setTag(nVar);
        this.ilW.setOnClickListener(bVar.okH);
        LinkedList linkedList = bpn.snC;
        boolean isEmpty = bpn.snC.isEmpty();
        int b2 = b.b(getContext(), 32.0f);
        int b3 = b.b(getContext(), 6.0f);
        int b4 = b.b(getContext(), 10.0f);
        int b5 = b.b(getContext(), 17.0f);
        if (this.nmj != null) {
            int i;
            LinearLayout linearLayout;
            x.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d %f", Integer.valueOf(((WindowManager) getContext().getSystemService("window")).getDefaultDisplay().getWidth()), Float.valueOf(getResources().getDimension(d.NormalPadding)));
            float f = ((float) i) - (f * 2.0f);
            if (linkedList.size() <= 0) {
                if (this.nmj.getParent() != null) {
                    this.nmj.setVisibility(8);
                }
                this.nmj.removeAllViews();
                this.nmj.setVisibility(8);
                linearLayout = this.nmj;
                i = 8;
            } else {
                this.nmj.getParent();
                this.nmj.removeAllViews();
                this.nmj.setVisibility(0);
                this.nmj.setPadding(0, b3, 0, b3);
                View imageView = new ImageView(getContext());
                imageView.setImageResource(i.friendactivity_luckymoney_icon);
                imageView.setPadding(b4, b5, b4, 0);
                LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.gravity = 49;
                imageView.setLayoutParams(layoutParams);
                imageView.setClickable(false);
                imageView.setFocusable(false);
                this.nmj.addView(imageView);
                b4 = a.fromDPToPix(getContext(), SnsCommentDetailUI.nUo);
                i = ((int) (f - ((float) b4))) / (b3 + b2);
                if (((int) (f - ((float) b4))) % (b3 + b2) > b2) {
                    i++;
                }
                x.d("MicroMsg.SnsDetailLuckyHeader", "guess size %d", Integer.valueOf(i));
                com.tencent.mm.plugin.sns.ui.i iVar = new com.tencent.mm.plugin.sns.ui.i(getContext());
                iVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                iVar.setLineMaxCounte(i);
                i = 0;
                while (true) {
                    b4 = i;
                    if (b4 >= linkedList.size()) {
                        break;
                    }
                    bou bou = (bou) linkedList.get(b4);
                    TouchImageView touchImageView = new TouchImageView(getContext());
                    touchImageView.setScaleType(ScaleType.FIT_XY);
                    touchImageView.setImageResource(e.friendactivity_personalportrait);
                    LayoutParams layoutParams2 = new LinearLayout.LayoutParams(b2, b2);
                    layoutParams2.setMargins(0, b3, b3, 0);
                    touchImageView.setLayoutParams(layoutParams2);
                    touchImageView.setTag(bou.rdS);
                    com.tencent.mm.pluginsdk.ui.a.b.p(touchImageView, bou.rdS);
                    touchImageView.setOnClickListener(bVar.okw);
                    iVar.addView(touchImageView);
                    i = b4 + 1;
                }
                this.nmj.addView(iVar);
                linearLayout = this.nmk;
                i = isEmpty ? 8 : 0;
            }
            linearLayout.setVisibility(i);
        }
    }
}
