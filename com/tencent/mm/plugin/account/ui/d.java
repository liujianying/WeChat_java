package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.appbrand.s$l;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

@Deprecated
final class d extends r<g> {
    private int[] eIr;
    private String eIs;
    a eQh;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        g gVar = (g) obj;
        if (gVar == null) {
            gVar = new g();
        }
        gVar.d(cursor);
        return gVar;
    }

    public d(Context context, a aVar) {
        super(context, new g());
        this.tlG = aVar;
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        h facebookFrdStg = b.getFacebookFrdStg();
        String str = this.eIs;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" where ( ");
            stringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
            stringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
        }
        setCursor(facebookFrdStg.dCZ.b("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + stringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
        this.eIr = new int[getCount()];
        if (!(this.eQh == null || this.eIs == null)) {
            this.eQh.ja(getCursor().getCount());
        }
        super.notifyDataSetChanged();
    }

    public final void pi(String str) {
        this.eIs = bi.oU(str.trim());
        aYc();
        WT();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        g gVar = (g) getItem(i);
        if (view == null) {
            bVar = new b();
            view = View.inflate(this.context, com.tencent.mm.plugin.account.a.g.facebook_friend_item, null);
            bVar.eBM = (ImageView) view.findViewById(f.contactitem_avatar_iv);
            bVar.eIz = (TextView) view.findViewById(f.qq_friend_name);
            bVar.eKl = (TextView) view.findViewById(f.qq_friend_add_state);
            bVar.eQi = (TextView) view.findViewById(f.qq_friend_add_tv);
            bVar.eQj = (TextView) view.findViewById(f.qq_friend_invite_tv);
            bVar.eQk = (ImageView) view.findViewById(f.qq_friend_submenu);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.eIz.setText(j.a(this.context, gVar.Xv(), bVar.eIz.getTextSize()));
        bVar.eQj.setVisibility(8);
        bVar.eQk.setVisibility(0);
        switch (this.eIr[i]) {
            case 0:
                if (gVar.status == s$l.AppCompatTheme_checkboxStyle || ((i) com.tencent.mm.kernel.g.l(i.class)).FR().Yc(gVar.getUsername())) {
                    if (gVar.status != s$l.AppCompatTheme_checkboxStyle) {
                        bVar.eKl.setVisibility(0);
                        bVar.eKl.setText(com.tencent.mm.plugin.account.a.j.friend_added);
                        bVar.eKl.setTextColor(this.context.getResources().getColor(c.add_state_color_added));
                        bVar.eQi.setVisibility(8);
                        break;
                    }
                    bVar.eKl.setVisibility(8);
                    bVar.eQi.setVisibility(8);
                    bVar.eQk.setVisibility(8);
                    break;
                }
                bVar.eKl.setVisibility(8);
                bVar.eQi.setVisibility(0);
                break;
                break;
            case 2:
                bVar.eQi.setVisibility(8);
                bVar.eKl.setVisibility(0);
                bVar.eKl.setText(com.tencent.mm.plugin.account.a.j.friend_waiting);
                bVar.eKl.setTextColor(this.context.getResources().getColor(c.add_state_color_waiting));
                break;
        }
        Bitmap jI = com.tencent.mm.aa.c.jI(gVar.csC);
        if (jI == null) {
            bVar.eBM.setImageDrawable(com.tencent.mm.bp.a.f(this.context, com.tencent.mm.plugin.account.a.i.default_avatar));
        } else {
            bVar.eBM.setImageBitmap(jI);
        }
        return view;
    }
}
