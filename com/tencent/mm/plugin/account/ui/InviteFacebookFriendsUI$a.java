package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.ui.q.b;
import com.tencent.mm.plugin.account.ui.q.c;
import com.tencent.mm.plugin.account.ui.q.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public class InviteFacebookFriendsUI$a extends r<g> {
    private int[] eIr;
    String eIs;
    private boolean[] eMd;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        g gVar = (g) obj;
        if (gVar == null) {
            gVar = new g();
        }
        gVar.d(cursor);
        return gVar;
    }

    public InviteFacebookFriendsUI$a(Context context, a aVar) {
        super(context, new g());
        this.tlG = aVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        g gVar = (g) getItem(i);
        if (view == null) {
            a aVar2 = new a();
            view = View.inflate(this.context, c.facebook_invite_friend_item, null);
            aVar2.eBM = (ImageView) view.findViewById(b.contactitem_avatar_iv);
            aVar2.eIz = (TextView) view.findViewById(b.qq_friend_name);
            aVar2.eMh = (TextView) view.findViewById(b.invite_friends_open_already_state);
            aVar2.eMi = (CheckBox) view.findViewById(b.inviteqqfriends_send_cb);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eIz.setText(j.a(this.context, gVar.Xv(), aVar.eIz.getTextSize()));
        Bitmap jI = com.tencent.mm.aa.c.jI(gVar.csC);
        if (jI == null) {
            aVar.eBM.setImageDrawable(com.tencent.mm.bp.a.f(this.context, d.default_avatar));
        } else {
            aVar.eBM.setImageBitmap(jI);
        }
        aVar.eMi.setChecked(this.eMd[i]);
        if (com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().pz(Long.toString(gVar.csC))) {
            aVar.eMh.setVisibility(0);
        } else {
            aVar.eMh.setVisibility(8);
        }
        return view;
    }

    public final long[] Yx() {
        int i = 0;
        int i2 = 0;
        for (boolean z : this.eMd) {
            if (z) {
                i2++;
            }
        }
        long[] jArr = new long[i2];
        int i3 = 0;
        while (true) {
            int i4 = i;
            if (i4 >= getCount()) {
                return jArr;
            }
            if (this.eMd[i4]) {
                i = i3 + 1;
                jArr[i3] = ((g) getItem(i4)).csC;
                i2 = i;
            } else {
                i2 = i3;
            }
            i = i4 + 1;
            i3 = i2;
        }
    }

    public final void jh(int i) {
        if (i >= 0 && i < this.eMd.length) {
            this.eMd[i] = !this.eMd[i];
            super.notifyDataSetChanged();
        }
    }

    public final void WT() {
        h facebookFrdStg = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
        String str = this.eIs;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(" where facebookfriend.status = 102 ");
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(facebookFrdStg.dCZ.b("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
        this.eIr = new int[getCount()];
        this.eMd = new boolean[getCount()];
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        WT();
    }
}
