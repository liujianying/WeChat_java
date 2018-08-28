package com.tencent.mm.view.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import com.tencent.mm.ipcinvoker.h.b;
import com.tencent.mm.plugin.n.a$h;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.emotion.u;
import com.tencent.mm.ui.y;
import java.util.List;

public final class e extends a {
    private List<u> uTR;

    class a {
        ImageView gmn;

        public a(View view) {
            this.gmn = (ImageView) view.findViewById(com.tencent.mm.plugin.n.a.e.art_emoji_icon_iv);
        }
    }

    public e(Context context, com.tencent.mm.view.f.a aVar) {
        super(context, aVar);
    }

    public final void update() {
        this.uTR = this.uSM.uWI;
        notifyDataSetChanged();
    }

    public final int getCount() {
        if (this.uTR == null) {
            return 0;
        }
        int i = this.uTJ * this.jZk;
        if (i > this.uTR.size()) {
            return this.uTR.size();
        }
        return i;
    }

    public final Object getItem(int i) {
        return (this.uTR == null || i >= this.uTR.size() || i < 0) ? null : (u) this.uTR.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = y.gq(this.mContext).inflate(f.smiley_grid_item_s, null);
            view.setLayoutParams(new LayoutParams(-1, -1));
            a aVar2 = new a(view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (this.uTR != null && i >= 0 && i < this.uTR.size()) {
            i = ((u) this.uTR.get(i)).position;
        }
        Drawable mg = com.tencent.mm.br.e.cjH().mg(i);
        aVar.gmn.setImageDrawable(mg);
        CharSequence text = com.tencent.mm.br.e.cjH().getText(i);
        if (bi.oW(text)) {
            text = view.getResources().getString(a$h.emoji_store_title);
        }
        aVar.gmn.setContentDescription(text);
        if (mg == null) {
            b.i("RecentSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[]{Integer.valueOf(i), text});
        }
        return view;
    }
}
