package com.tencent.mm.plugin.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.chatroom.ui.DelChatroomMemberUI.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class DelChatroomMemberUI$a extends BaseAdapter {
    final /* synthetic */ DelChatroomMemberUI hMA;
    List<ab> hMB = new LinkedList();

    DelChatroomMemberUI$a(DelChatroomMemberUI delChatroomMemberUI) {
        this.hMA = delChatroomMemberUI;
    }

    public final void aF(List<String> list) {
        Object obj;
        Object obj2 = null;
        Iterator it = list.iterator();
        while (true) {
            obj = obj2;
            if (!it.hasNext()) {
                break;
            }
            String str = (String) it.next();
            for (Object obj3 : this.hMB) {
                if (obj3.field_username.equals(str)) {
                    break;
                }
            }
            Object obj32 = null;
            if (obj32 != null) {
                obj2 = 1;
                this.hMB.remove(obj32);
            } else {
                obj2 = obj;
            }
        }
        if (obj != null) {
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        return this.hMB.size();
    }

    public final Object getItem(int i) {
        return this.hMB.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.hMA, R.i.chatroom_delete_contact_item, null);
            bVar = new b(this.hMA);
            bVar.eCl = (ImageView) view.findViewById(R.h.chatroom_contact_item_avatar);
            bVar.eTm = (TextView) view.findViewById(R.h.chatroom_contact_nick_tv);
            bVar.hMF = (TextView) view.findViewById(R.h.chatroom_contact_delect_tv);
            bVar.hMF.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    ab abVar = (ab) DelChatroomMemberUI$a.this.getItem(((Integer) view.getTag()).intValue());
                    h.a(DelChatroomMemberUI$a.this.hMA, DelChatroomMemberUI$a.this.hMA.getString(R.l.room_delete_member_alert, new Object[]{DelChatroomMemberUI$a.this.c(abVar)}), null, DelChatroomMemberUI$a.this.hMA.getString(R.l.room_delete_member_remove_it), DelChatroomMemberUI$a.this.hMA.getString(R.l.app_cancel), true, new 1(this, abVar), new 2(this));
                }
            });
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        bVar.hMF.setTag(Integer.valueOf(i));
        ab abVar = (ab) getItem(i);
        CharSequence c = c(abVar);
        bVar.eTm.setText(c);
        j.a(this.hMA, c, bVar.eTm.getTextSize());
        a.b.a(bVar.eCl, abVar.field_username);
        return view;
    }

    public final String c(ab abVar) {
        String b;
        if (bi.oW(abVar.field_conRemark)) {
            b = DelChatroomMemberUI.b(this.hMA, abVar.field_username);
        } else {
            b = abVar.field_conRemark;
        }
        if (bi.oW(b)) {
            b = abVar.field_conRemark;
        }
        if (bi.oW(b)) {
            return abVar.BK();
        }
        return b;
    }
}
