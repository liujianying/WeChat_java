package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a.c;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends b {
    private int[] eIr;
    private String eIs;
    private com.tencent.mm.plugin.account.bind.ui.b.a eIt;
    private b eIu = new 1(this);

    class a {
        String account;
        ImageView eBM;
        TextView eBR;
        View eIA;
        TextView eIG;
        TextView eIH;
        TextView eII;
        ProgressBar eIJ;
        int eIy;
        int status;

        public a(View view) {
            this.eIG = (TextView) view.findViewById(f.friend_item_catalog);
            this.eBM = (ImageView) view.findViewById(f.friend_item_avatar_iv);
            this.eIH = (TextView) view.findViewById(f.friend_item_nickname);
            this.eII = (TextView) view.findViewById(f.friend_item_wx_nickname);
            this.eIA = view.findViewById(f.friend_item_action_view);
            this.eBR = (TextView) view.findViewById(f.friend_item_status_tv);
            this.eIJ = (ProgressBar) view.findViewById(f.friend_item_status_pb);
            this.eIA.setOnClickListener(new 1(this, d.this));
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.account.friend.a.a();
        }
        aVar.d(cursor);
        return aVar;
    }

    public final void a(com.tencent.mm.plugin.account.bind.ui.b.a aVar) {
        this.eIt = aVar;
    }

    public d(Context context, com.tencent.mm.ui.r.a aVar) {
        super(context, new com.tencent.mm.plugin.account.friend.a.a());
        this.tlG = aVar;
        this.context = context;
        lB(true);
    }

    public final void pi(String str) {
        this.eIs = bi.oU(str.trim());
        aYc();
        WT();
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        aYc();
        com.tencent.mm.plugin.account.friend.a.b bVar = (com.tencent.mm.plugin.account.friend.a.b) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg();
        String str = this.eIs;
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null && str.length() > 0) {
            stringBuilder.append(" and ( ");
            stringBuilder.append("addr_upload2.realname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.realnamequanpin like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.username like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nickname like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamepyinitial like '%" + str + "%' or ");
            stringBuilder.append("addr_upload2.nicknamequanpin like '%" + str + "%' )");
        }
        stringBuilder.append(" and (");
        stringBuilder.append("addr_upload2.status=1");
        stringBuilder.append(" or ");
        stringBuilder.append("addr_upload2.status=2");
        stringBuilder.append(")");
        str = (String) g.Ei().DT().get(6, null);
        Cursor b = (str == null || str.equals("")) ? bVar.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by showhead", null, 0) : bVar.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by showhead", null, 0);
        setCursor(b);
        this.eIr = new int[getCount()];
        if (!(this.eIt == null || this.eIs == null)) {
            this.eIt.ja(getCursor().getCount());
        }
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        com.tencent.mm.plugin.account.friend.a.a aVar2 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i);
        if (view == null) {
            view = View.inflate(this.context, com.tencent.mm.plugin.account.a.g.friend_list_item, null);
            a aVar3 = new a(view);
            view.setTag(aVar3);
            aVar = aVar3;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eIy = i;
        aVar.account = aVar2.Xh();
        aVar.status = aVar2.status;
        aVar.eIH.setText(aVar2.Xj());
        aVar.eII.setText(this.context.getString(j.friend_weixin) + aVar2.Xm());
        com.tencent.mm.pluginsdk.ui.a.b.a(aVar.eBM, aVar2.getUsername());
        switch (aVar2.status) {
            case 0:
                if (aVar2.dHO != 2) {
                    aVar.eIA.setClickable(true);
                    aVar.eIA.setBackgroundResource(e.btn_solid_green);
                    aVar.eBR.setText(j.friend_invite);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(c.white));
                    break;
                }
                aVar.eIA.setClickable(false);
                aVar.eIA.setBackgroundDrawable(null);
                aVar.eBR.setText(j.friend_invited);
                aVar.eBR.setTextColor(this.context.getResources().getColor(c.lightgrey));
                break;
            case 1:
            case 2:
                if (!((i) g.l(i.class)).FR().Yc(aVar2.getUsername()) && !q.GF().equals(aVar2.getUsername())) {
                    if (aVar2.dHO != 2) {
                        aVar.eIA.setClickable(true);
                        aVar.eIA.setBackgroundResource(e.btn_solid_green);
                        aVar.eBR.setText(j.friend_add);
                        aVar.eBR.setTextColor(this.context.getResources().getColor(c.white));
                        break;
                    }
                    aVar.eIA.setClickable(false);
                    aVar.eIA.setBackgroundDrawable(null);
                    aVar.eBR.setText(j.friend_waiting_ask);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(c.lightgrey));
                    break;
                }
                aVar.eIA.setClickable(false);
                aVar.eIA.setBackgroundDrawable(null);
                aVar.eBR.setText(j.friend_added);
                aVar.eBR.setTextColor(this.context.getResources().getColor(c.lightgrey));
                break;
                break;
        }
        switch (aVar2.dHO) {
            case 0:
            case 2:
                aVar.eBR.setVisibility(0);
                aVar.eIJ.setVisibility(4);
                break;
            case 1:
                aVar.eBR.setVisibility(4);
                aVar.eIJ.setVisibility(0);
                break;
        }
        com.tencent.mm.plugin.account.friend.a.a aVar4 = (com.tencent.mm.plugin.account.friend.a.a) getItem(i - 1);
        int i2 = aVar4 == null ? -1 : aVar4.eJF;
        if (i == 0) {
            CharSequence a = a(aVar2);
            if (bi.oW(a)) {
                x.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[]{aVar2.getUsername(), Integer.valueOf(i)});
                aVar.eIG.setVisibility(8);
            } else {
                aVar.eIG.setVisibility(0);
                aVar.eIG.setText(a);
                aVar.eIG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        } else {
            boolean z;
            if (aVar2.eJF != i2) {
                z = true;
            } else {
                z = false;
            }
            CharSequence a2 = a(aVar2);
            if (bi.oW(a2) || !z) {
                x.w("MicroMsg.MobileFriendAdapter", "get display show head return null, user[%s] pos[%d]", new Object[]{aVar2.getUsername(), Integer.valueOf(i)});
                aVar.eIG.setVisibility(8);
            } else {
                aVar.eIG.setVisibility(0);
                aVar.eIG.setText(a2);
                aVar.eIG.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
        }
        return view;
    }

    private static String a(com.tencent.mm.plugin.account.friend.a.a aVar) {
        if (aVar.eJF == 123) {
            return "#";
        }
        return String.valueOf((char) aVar.eJF);
    }
}
