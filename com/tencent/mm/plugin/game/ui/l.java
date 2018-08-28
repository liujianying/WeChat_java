package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.ui.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class l extends m {
    public l(Context context) {
        super(context);
        this.jZR = f.game_list_item;
    }

    protected final void a(d dVar, b bVar, int i) {
        bVar.kac.setText(dVar.position);
        bVar.kac.setVisibility(this.jZT ? 0 : 8);
        Bitmap DI = DI(dVar.field_appId);
        if (DI == null || DI.isRecycled()) {
            bVar.kad.setImageResource(com.tencent.mm.plugin.game.f.d.game_default_icon);
        } else {
            bVar.kad.setImageBitmap(DI);
        }
        bVar.jZe.setText(dVar.field_appName);
        if (bi.oW(dVar.jLb)) {
            bVar.kaf.setVisibility(8);
        } else {
            bVar.kaf.setVisibility(0);
            bVar.kaf.setText(dVar.jLb);
        }
        if (bi.oW(dVar.jLc)) {
            bVar.kag.setVisibility(8);
        } else {
            bVar.kag.setVisibility(0);
            bVar.kag.setText(dVar.jLc);
        }
        if (bi.cX(dVar.jLm)) {
            if (!bi.oW(dVar.jLp)) {
                bVar.kae.setVisibility(0);
                bVar.kae.setText(dVar.jLp);
                try {
                    bVar.kae.setBackgroundDrawable(com.tencent.mm.plugin.game.model.f.cm(Color.parseColor(dVar.jLq), a.fromDPToPix(this.mContext, 10)));
                } catch (IllegalArgumentException e) {
                    x.e("MicroMsg.GameLibraryListAdapter", e.getMessage());
                } catch (Exception e2) {
                    x.e("MicroMsg.GameLibraryListAdapter", e2.getMessage());
                }
            }
            bVar.kae.setVisibility(8);
        } else {
            bVar.kae.setVisibility(0);
            bVar.kae.setText((CharSequence) dVar.jLm.get(0));
        }
        bVar.kai.setTextSize(this.jWv);
        bVar.kah.setOnClickListener(this.jXl);
        bVar.kai.setOnClickListener(this.jXl);
        bVar.kah.setTag(dVar);
        bVar.kai.setTag(dVar);
        this.jWA.a(bVar.kai, bVar.kah, dVar, (n) this.jZW.get(dVar.field_appId));
        bVar.kaj.setData(dVar.jLk);
        bVar.kak.removeAllViews();
        View view = (View) this.jZX.get(i);
        if (view != null) {
            if (view.getParent() instanceof ViewGroup) {
                ((ViewGroup) view.getParent()).removeAllViews();
            }
            bVar.kak.addView(view);
        }
    }

    protected final void a(d dVar, b bVar) {
        bVar.kal.removeAllViews();
        if (!bi.oW(dVar.jLf)) {
            View inflate = View.inflate(this.mContext, f.game_hotad_item, null);
            ImageView imageView = (ImageView) inflate.findViewById(e.game_hotad);
            com.tencent.mm.ak.a.a Pj = o.Pj();
            String str = dVar.jLf;
            c.a aVar = new c.a();
            aVar.dXx = true;
            Pj.a(str, imageView, aVar.Pt());
            bVar.kal.addView(inflate, new LayoutParams(-1, a.fromDPToPix(this.mContext, 100)));
        }
    }
}
