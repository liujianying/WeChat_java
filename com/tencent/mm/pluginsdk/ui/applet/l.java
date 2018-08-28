package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.b.a;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class l extends BaseAdapter {
    private List<String> eCA;
    private Context mContext;
    private List<String> qJG;

    public l(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.eCA = list2;
        this.qJG = list;
    }

    public final int getCount() {
        return this.eCA.size();
    }

    public final Object getItem(int i) {
        return this.eCA.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a dj;
        if (view == null) {
            view = View.inflate(this.mContext, R.i.chatroom_avatar_item, null);
            dj = dj(view);
        } else {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                dj = dj(view);
            } else {
                dj = aVar;
            }
        }
        int size = this.eCA.size() % 4;
        if (i >= 0 && i < this.eCA.size() && i < this.qJG.size()) {
            dj.eCl.setVisibility(0);
            dj.eMe.setVisibility(0);
            b.a(dj.eCl, (String) this.qJG.get(i));
            dj.eMe.setText((CharSequence) this.eCA.get(i));
            dj.eMe.setText(((a) g.l(a.class)).a((CharSequence) this.eCA.get(i), dj.eMe.getTextSize()));
            if (this.eCA.size() <= 12 || i < this.eCA.size() - size) {
                dj.eMe.setPadding(0, 0, 0, 0);
            } else {
                dj.eMe.setPadding(0, 0, 0, com.tencent.mm.bp.a.ad(this.mContext, R.f.DialogAvatarLinePadding));
            }
        }
        return view;
    }

    private static a dj(View view) {
        a aVar = new a((byte) 0);
        aVar.eCl = (ImageView) view.findViewById(R.h.chatroom_member_avatar);
        aVar.eMe = (TextView) view.findViewById(R.h.chatroom_member_name);
        view.setTag(aVar);
        return aVar;
    }
}
