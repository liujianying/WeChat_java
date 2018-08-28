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
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.f.f;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ab;
import java.util.LinkedList;
import java.util.List;

class GameDetailRankLikedUI$a extends BaseAdapter {
    List<dj> jWl = new LinkedList();
    private Context mContext;

    public GameDetailRankLikedUI$a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.jWl.size();
    }

    private dj qV(int i) {
        return (dj) this.jWl.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(f.game_detail2_rank_liked_item, viewGroup, false);
            aVar = new a((byte) 0);
            aVar.eKk = (ImageView) view.findViewById(e.game_detail_rank_liked_item_avatar);
            aVar.gwk = (TextView) view.findViewById(e.game_detail_rank_liked_item_name);
            aVar.jWm = (TextView) view.findViewById(e.game_detail_rank_liked_item_time);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        dj qV = qV(i);
        b.a(aVar.eKk, qV.jTv, 0.5f, false);
        ab Yg = ((i) g.l(i.class)).FR().Yg(qV.jTv);
        if (Yg != null) {
            aVar.gwk.setText(new SpannableString(j.a(this.mContext, Yg.BL(), aVar.gwk.getTextSize())));
        } else {
            aVar.gwk.setText("");
        }
        aVar.jWm.setText(qV.jTw);
        return view;
    }
}
