package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.a$f;
import com.tencent.mm.plugin.account.a$g;
import com.tencent.mm.plugin.account.a.e;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.bind.ui.b.a;
import com.tencent.mm.plugin.account.bind.ui.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;

public final class c extends b {
    private int[] eIr;
    private String eIs;
    private a eIt;
    private b eIu = new 1(this);

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        com.tencent.mm.plugin.account.friend.a.a aVar = (com.tencent.mm.plugin.account.friend.a.a) obj;
        if (aVar == null) {
            aVar = new com.tencent.mm.plugin.account.friend.a.a();
        }
        aVar.d(cursor);
        return aVar;
    }

    public final void a(a aVar) {
        this.eIt = aVar;
    }

    public c(Context context, r.a aVar) {
        super(context, new com.tencent.mm.plugin.account.friend.a.a());
        this.tlG = aVar;
        this.context = context;
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
        Cursor b = (str == null || str.equals("")) ? bVar.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0" + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0) : bVar.dCZ.b("select addr_upload2.id,addr_upload2.md5,addr_upload2.peopleid,addr_upload2.uploadtime,addr_upload2.realname,addr_upload2.realnamepyinitial,addr_upload2.realnamequanpin,addr_upload2.username,addr_upload2.nickname,addr_upload2.nicknamepyinitial,addr_upload2.nicknamequanpin,addr_upload2.type,addr_upload2.moblie,addr_upload2.email,addr_upload2.status,addr_upload2.reserved1,addr_upload2.reserved2,addr_upload2.reserved3,addr_upload2.reserved4,addr_upload2.lvbuf,addr_upload2.showhead from addr_upload2  where type = 0 and moblie <> " + str + stringBuilder.toString() + " order by  case when status = 1 then 0  when status = 65536 then 1  when status = 2 then 2 else 3 end  , realnamepyinitial", null, 0);
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
            view = View.inflate(this.context, a$g.mobile_friend_item, null);
            aVar = new a(this, view);
            aVar.eIz = (TextView) view.findViewById(a$f.mobile_friend_name);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.eIy = i;
        aVar.bKg = aVar2.Xh();
        aVar.status = aVar2.status;
        aVar.eIz.setText(aVar2.Xj());
        switch (aVar2.status) {
            case 0:
                if (aVar2.dHO != 2) {
                    aVar.eIA.setClickable(true);
                    aVar.eIA.setBackgroundResource(e.btn_solid_green);
                    aVar.eBR.setText(j.friend_invite);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.a.c.white));
                    break;
                }
                aVar.eIA.setClickable(false);
                aVar.eIA.setBackgroundDrawable(null);
                aVar.eBR.setText(j.friend_invited);
                aVar.eBR.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                break;
            case 1:
            case 2:
                x.d("MicroMsg.MobileFriendAdapter", "username:%s", new Object[]{aVar2.getUsername()});
                if (!((i) g.l(i.class)).FR().Yc(aVar2.getUsername()) && !q.GF().equals(aVar2.getUsername())) {
                    if (aVar2.dHO != 2) {
                        aVar.eIA.setClickable(true);
                        aVar.eIA.setBackgroundResource(e.btn_solid_green);
                        aVar.eBR.setText(j.friend_add);
                        aVar.eBR.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.a.c.white));
                        break;
                    }
                    aVar.eIA.setClickable(false);
                    aVar.eIA.setBackgroundDrawable(null);
                    aVar.eBR.setText(j.friend_waiting_ask);
                    aVar.eBR.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                    break;
                }
                aVar.eIA.setClickable(false);
                aVar.eIA.setBackgroundDrawable(null);
                aVar.eBR.setText(j.friend_added);
                aVar.eBR.setTextColor(this.context.getResources().getColor(com.tencent.mm.plugin.account.a.c.lightgrey));
                break;
                break;
        }
        switch (aVar2.dHO) {
            case 0:
            case 2:
                aVar.eBR.setVisibility(0);
                aVar.eIB.setVisibility(4);
                break;
            case 1:
                aVar.eBR.setVisibility(4);
                aVar.eIB.setVisibility(0);
                break;
        }
        return view;
    }
}
