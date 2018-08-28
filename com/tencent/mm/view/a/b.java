package com.tencent.mm.view.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import com.tencent.mm.br.e;
import com.tencent.mm.plugin.n.a.d;
import com.tencent.mm.plugin.n.a.f;
import com.tencent.mm.plugin.n.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.y;
import com.tencent.mm.view.f.a;

public class b extends a {
    public b(Context context, a aVar) {
        super(context, aVar);
    }

    public int getCount() {
        return this.uTG;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final int GR(int i) {
        return ((this.uTG - 1) * this.uTH) + i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = y.gq(this.mContext).inflate(f.smiley_grid_item_s, null);
            view.setLayoutParams(new LayoutParams(-1, -1));
            aVar = new a(this, view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (i == getCount() - 1) {
            aVar.gmn.setImageResource(d.del_btn);
            aVar.gmn.setContentDescription(this.mContext.getString(h.delete_btn));
        } else {
            int GR = GR(i);
            if (GR > this.hou - 1) {
                aVar.gmn.setImageDrawable(null);
                aVar.gmn.setContentDescription("");
                x.i("MicroMsg.emoji.DefaultSmileyAdapter", "real position is bigger real count.");
            } else {
                Drawable mg = e.cjH().mg(GR);
                aVar.gmn.setImageDrawable(mg);
                CharSequence text = e.cjH().getText(GR);
                if (bi.oW(text)) {
                    text = view.getResources().getString(h.emoji_store_title);
                }
                aVar.gmn.setContentDescription(text);
                if (mg == null) {
                    x.i("MicroMsg.emoji.DefaultSmileyAdapter", "drawable is null. realPosition:%d description:%s", new Object[]{Integer.valueOf(GR), text});
                }
            }
        }
        return view;
    }
}
