package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.text.SpannableString;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.af;
import com.tencent.mm.plugin.game.model.af.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;

public final class i extends BaseAdapter {
    int Ba;
    int jNv;
    private af jVU;
    private Context mContext;

    public i(Context context) {
        this.mContext = context;
    }

    public final void a(af afVar) {
        this.jVU = afVar;
        ah.A(new 1(this));
    }

    public final int getCount() {
        return this.jVU == null ? 0 : this.jVU.jNG.size();
    }

    public final Object getItem(int i) {
        return this.jVU.jNG.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(this.Ba, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.jVW = (TextView) inflate.findViewById(e.game_detail_rank_item_num);
            aVar.eKk = (ImageView) inflate.findViewById(e.game_detail_rank_item_avatar);
            aVar.gwk = (TextView) inflate.findViewById(e.game_detail_rank_item_name);
            aVar.jVX = (TextView) inflate.findViewById(e.game_detail_rank_item_tag);
            aVar.jVY = (TextView) inflate.findViewById(e.game_detail_rank_item_score);
            aVar.jVZ = (GameDetailRankLikeView) inflate.findViewById(e.game_detail_rank_item_like);
            aVar.jVZ.setSourceScene(this.jNv);
            i((ViewGroup) inflate);
            inflate.setTag(aVar);
            view = inflate;
        } else {
            aVar = (a) view.getTag();
        }
        a aVar2 = (a) getItem(i);
        aVar.jVW.setText(aVar2.jNH);
        b.a(aVar.eKk, aVar2.bWJ, 0.5f, false);
        ab Yg = ((com.tencent.mm.plugin.messenger.foundation.a.i) g.l(com.tencent.mm.plugin.messenger.foundation.a.i.class)).FR().Yg(aVar2.bWJ);
        if (Yg != null) {
            aVar.gwk.setText(new SpannableString(j.a(this.mContext, Yg.BL(), aVar.gwk.getTextSize())));
        } else {
            aVar.gwk.setText("");
        }
        if (bi.oW(aVar2.tag)) {
            aVar.jVX.setVisibility(8);
        } else {
            aVar.jVX.setVisibility(0);
            aVar.jVX.setText(aVar2.tag);
        }
        if (bi.oW(aVar2.jNK)) {
            aVar.jVY.setText(aVar2.jsz);
            GameDetailRankLikeView gameDetailRankLikeView = aVar.jVZ;
            af afVar = this.jVU;
            gameDetailRankLikeView.jWa = afVar;
            gameDetailRankLikeView.mAppId = afVar.mAppId;
            gameDetailRankLikeView.jWb = (a) afVar.jNG.get(i);
            gameDetailRankLikeView.aUT();
            aVar.jVZ.setVisibility(0);
        } else {
            aVar.jVY.setText(aVar2.jNK);
            aVar.jVZ.setVisibility(8);
        }
        return view;
    }

    private void i(ViewGroup viewGroup) {
        viewGroup.setClipChildren(false);
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                ((ViewGroup) childAt).setClipChildren(false);
                i((ViewGroup) childAt);
            }
        }
    }
}
