package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.aa.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$c;
import com.tencent.mm.plugin.account.a$e;
import com.tencent.mm.plugin.account.a.f;
import com.tencent.mm.plugin.account.a.i;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.r;

public final class a extends r<n> {
    private String eEW;
    a eHS;
    private Context mContext;
    private String mFilter;
    private LayoutInflater mLayoutInflater = LayoutInflater.from(this.mContext);

    class b {
        ImageView eBM;
        TextView eBR;
        String eHT;
        TextView eHU;
        TextView eHV;
        View eHW;
        ProgressBar eHX;
        int position;

        public b(View view) {
            this.eBM = (ImageView) view.findViewById(f.gcontact_avatar_iv);
            this.eHU = (TextView) view.findViewById(f.gcontact_name_tv);
            this.eHW = view.findViewById(f.gcontact_operation_view);
            this.eBR = (TextView) view.findViewById(f.gcontact_status_tv);
            this.eHX = (ProgressBar) view.findViewById(f.gcontact_invita_pb);
            this.eHV = (TextView) view.findViewById(f.gcontact_email_tv);
            this.eHW.setOnClickListener(new 1(this, a.this));
        }
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        n nVar = (n) obj;
        if (nVar == null) {
            nVar = new n();
        }
        nVar.d(cursor);
        return nVar;
    }

    public a(Context context, String str) {
        super(context, new n());
        this.eEW = str;
        this.mContext = context;
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        o oVar = (o) ((com.tencent.mm.plugin.account.a.a.a) g.n(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage();
        String str = this.mFilter;
        String str2 = this.eEW;
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(str)) {
            stringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
        } else {
            stringBuilder.append(" WHERE ( ");
            stringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
            stringBuilder.append("GoogleFriend.googlename LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str + "%' OR ");
            stringBuilder.append("GoogleFriend.nickname LIKE '%" + str + "%' ) ");
        }
        stringBuilder.append(" GROUP BY googleid,contecttype");
        stringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
        setCursor(oVar.diF.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + stringBuilder.toString(), null));
        super.notifyDataSetChanged();
    }

    public final void pi(String str) {
        this.mFilter = bi.oU(str);
        aYc();
        WT();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null || view.getTag() == null) {
            view = this.mLayoutInflater.inflate(com.tencent.mm.plugin.account.a.g.gcontact_friend_list_item, null);
            b bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        n nVar = (n) getItem(i);
        if (nVar != null) {
            bVar.position = i;
            bVar.eHT = nVar.field_googlegmail;
            Bitmap a;
            switch (nVar.field_status) {
                case 0:
                case 2:
                    if (nVar.field_small_url != null) {
                        a = c.a(nVar.field_username, false, -1);
                    } else {
                        a = null;
                    }
                    if (a != null) {
                        bVar.eBM.setImageBitmap(a);
                        break;
                    }
                    bVar.eBM.setImageDrawable(com.tencent.mm.bp.a.f(this.mContext, i.default_avatar));
                    break;
                case 1:
                    a = c.jF(nVar.field_googleid);
                    if (a != null) {
                        bVar.eBM.setImageBitmap(a);
                        break;
                    }
                    bVar.eBM.setImageDrawable(com.tencent.mm.bp.a.f(this.mContext, i.default_avatar));
                    break;
            }
            if (TextUtils.isEmpty(nVar.field_googlename)) {
                bVar.eHU.setText(bi.Xe(nVar.field_googlegmail));
            } else {
                bVar.eHU.setText(nVar.field_googlename);
            }
            switch (nVar.field_status) {
                case 0:
                    bVar.eHW.setClickable(true);
                    bVar.eHW.setBackgroundResource(a$e.btn_solid_green);
                    bVar.eBR.setText(j.gcontact_add);
                    bVar.eBR.setTextColor(this.mContext.getResources().getColor(a$c.white));
                    break;
                case 1:
                    bVar.eHW.setClickable(true);
                    bVar.eHW.setBackgroundResource(a$e.btn_solid_grey);
                    bVar.eBR.setText(j.gcontact_invite);
                    bVar.eBR.setTextColor(this.mContext.getResources().getColor(a$c.lightgrey));
                    break;
                case 2:
                    bVar.eHW.setClickable(false);
                    bVar.eHW.setBackgroundDrawable(null);
                    bVar.eBR.setText(j.gcontact_added);
                    bVar.eBR.setTextColor(this.mContext.getResources().getColor(a$c.lightgrey));
                    break;
            }
            switch (nVar.field_googlecgistatus) {
                case 0:
                    bVar.eBR.setVisibility(4);
                    bVar.eHX.setVisibility(0);
                    break;
                case 1:
                    bVar.eHW.setClickable(false);
                    bVar.eHW.setBackgroundDrawable(null);
                    bVar.eBR.setVisibility(0);
                    bVar.eHX.setVisibility(8);
                    bVar.eBR.setTextColor(this.mContext.getResources().getColor(a$c.lightgrey));
                    switch (nVar.field_status) {
                        case 0:
                            bVar.eBR.setText(j.gcontact_add_done);
                            break;
                        case 1:
                            bVar.eBR.setText(j.gcontact_invite_done);
                            break;
                    }
                    break;
                case 2:
                    bVar.eBR.setVisibility(0);
                    bVar.eHX.setVisibility(8);
                    switch (nVar.field_status) {
                        case 0:
                            bVar.eBR.setText(j.gcontact_add);
                            bVar.eBR.setTextColor(this.mContext.getResources().getColor(a$c.white));
                            break;
                        case 1:
                            bVar.eBR.setText(j.gcontact_invite);
                            bVar.eBR.setTextColor(this.mContext.getResources().getColor(a$c.lightgrey));
                            break;
                    }
                    break;
            }
            bVar.eHV.setText(nVar.field_googlegmail);
        }
        return view;
    }
}
