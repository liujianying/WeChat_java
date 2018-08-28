package com.tencent.mm.plugin.talkroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.LinkedList;
import java.util.List;

class TalkRoomAvatarsFrame$a extends BaseAdapter {
    String kFP;
    private Context mContext;
    List<String> oxF = new LinkedList();

    public TalkRoomAvatarsFrame$a(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.oxF.size();
    }

    public final Object getItem(int i) {
        return this.oxF.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String str = (String) this.oxF.get(i);
        if (view == null) {
            view = View.inflate(this.mContext, R.i.talk_room_avatar_item, null);
            a aVar2 = new a(this);
            aVar2.eCl = (ImageView) view.findViewById(R.h.iv_avatar);
            aVar2.eTm = (TextView) view.findViewById(R.h.tv_nickname);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eCl.setBackgroundResource(str.equals(this.kFP) ? R.g.talk_room_avatar_item_frame : 0);
        aVar.eTm.setVisibility(8);
        b.p(aVar.eCl, str);
        return view;
    }
}
