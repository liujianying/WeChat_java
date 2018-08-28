package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.plugin.game.model.n;
import com.tencent.mm.plugin.game.ui.m.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class g extends m {
    public final /* bridge */ /* synthetic */ void DJ(String str) {
        super.DJ(str);
    }

    public final /* bridge */ /* synthetic */ void DK(String str) {
        super.DK(str);
    }

    public final /* bridge */ /* synthetic */ void DL(String str) {
        super.DL(str);
    }

    public final /* bridge */ /* synthetic */ void O(LinkedList linkedList) {
        super.O(linkedList);
    }

    public final /* bridge */ /* synthetic */ void P(LinkedList linkedList) {
        super.P(linkedList);
    }

    public final /* bridge */ /* synthetic */ void a(m$a m_a) {
        super.a(m_a);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ void d(SparseArray sparseArray) {
        super.d(sparseArray);
    }

    public final /* bridge */ /* synthetic */ int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return super.getView(i, view, viewGroup);
    }

    public final /* bridge */ /* synthetic */ int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final /* bridge */ /* synthetic */ void qT(int i) {
        super.qT(i);
    }

    public final /* bridge */ /* synthetic */ void refresh() {
        super.refresh();
    }

    public final /* bridge */ /* synthetic */ void setSourceScene(int i) {
        super.setSourceScene(i);
    }

    public final /* bridge */ /* synthetic */ void y(View view, int i) {
        super.y(view, i);
    }

    public g(Context context) {
        super(context);
        this.jZR = f.game_center_list_item;
    }

    protected final void a(d dVar, b bVar, int i) {
        bVar.kac.setText(dVar.position);
        Bitmap DI = DI(dVar.field_appId);
        if (DI == null || DI.isRecycled()) {
            bVar.kad.setImageResource(com.tencent.mm.plugin.game.f.d.game_default_icon);
        } else {
            bVar.kad.setImageBitmap(DI);
        }
        bVar.jZe.setText(dVar.field_appName);
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
                    x.e("MicroMsg.GameCenterListAdapter", e.getMessage());
                } catch (Exception e2) {
                    x.e("MicroMsg.GameCenterListAdapter", e2.getMessage());
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
    }

    protected final void a(d dVar, b bVar) {
    }
}
