package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.plugin.game.d.af;
import com.tencent.mm.plugin.game.d.k;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.f$d;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class f extends LinearLayout implements OnClickListener {
    private LayoutInflater Bc = ((LayoutInflater) this.mContext.getSystemService("layout_inflater"));
    private int jNv;
    private String mAppId;
    private Context mContext;

    public f(Context context) {
        super(context);
        this.mContext = context;
        setOrientation(0);
    }

    public final void a(af afVar, String str, int i, int i2) {
        if (afVar == null || bi.cX(afVar.jQF)) {
            setVisibility(8);
            return;
        }
        if (afVar.jQF.size() == 1) {
            afVar.jQF.add(null);
            afVar.jQF.add(null);
        } else if (afVar.jQF.size() == 2) {
            afVar.jQF.add(null);
        }
        this.mAppId = str;
        this.jNv = i2;
        Iterator it = afVar.jQF.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            LinearLayout linearLayout = (LinearLayout) this.Bc.inflate(com.tencent.mm.plugin.game.f.f.game_center_4_block_entrance_item, this, false);
            addView(linearLayout, new LayoutParams(-2, -2, 1.0f));
            ImageView imageView = (ImageView) linearLayout.findViewById(e.entrance_icon);
            TextView textView = (TextView) linearLayout.findViewById(e.entrance_title);
            TextView textView2 = (TextView) linearLayout.findViewById(e.entrance_desc);
            if (kVar == null) {
                imageView.setImageResource(f$d.game_wait_unlock);
                textView.setText(i.game_wait_unlock);
                textView.setTextColor(this.mContext.getResources().getColor(b.game_title_hint));
            } else {
                linearLayout.setOnClickListener(this);
                com.tencent.mm.plugin.game.e.e.aVj().g(imageView, kVar.jPG);
                textView.setText(kVar.bHD);
                if (bi.oW(kVar.jOS)) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(kVar.jOS);
                    textView2.setVisibility(0);
                }
                linearLayout.setTag(kVar);
                if (i == 2) {
                    an.a(this.mContext, 10, 1002, kVar.jPC, str, i2, an.Dx(kVar.jPA));
                }
            }
        }
    }

    public final void onClick(View view) {
        if (view.getTag() == null || !(view.getTag() instanceof k)) {
            x.w("MicroMsg.GameBlockEntranceView", "getTag is null");
            return;
        }
        k kVar = (k) view.getTag();
        if (bi.oW(kVar.jOU)) {
            x.w("MicroMsg.GameBlockEntranceView", "jumpUrl is null");
            return;
        }
        an.a(this.mContext, 10, 1002, kVar.jPC, c.r(this.mContext, kVar.jOU, "game_center_mygame_comm"), this.mAppId, this.jNv, an.Dx(kVar.jPA));
    }
}
