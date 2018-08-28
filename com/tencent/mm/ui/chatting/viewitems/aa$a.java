package com.tencent.mm.ui.chatting.viewitems;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.R;
import com.tencent.mm.ac.f;
import com.tencent.mm.bg.d;
import com.tencent.mm.g.a.dj;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.chatting.ChattingSendDataToDeviceUI;
import com.tencent.mm.ui.chatting.c.a;
import com.tencent.mm.ui.chatting.k;
import java.util.LinkedList;
import java.util.List;

public class aa$a extends b {
    private a tKy;
    protected aa$c udp;

    public final boolean bba() {
        return false;
    }

    public final boolean aq(int i, boolean z) {
        if (z || i != 48) {
            return false;
        }
        return true;
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null) {
            return view;
        }
        r rVar = new r(layoutInflater, R.i.chatting_item_from_location);
        rVar.setTag(new aa$d().q(rVar, true));
        return rVar;
    }

    public final void a(b.a aVar, int i, a aVar2, bd bdVar, String str) {
        this.tKy = aVar2;
        aa$d aa_d = (aa$d) aVar;
        if (this.udp == null) {
            this.udp = new aa$c(aVar2);
        }
        aa$d.a(aa_d, bdVar, true, i, aVar2, this.udp, c(aVar2));
    }

    public final boolean a(ContextMenu contextMenu, View view, bd bdVar) {
        if (bdVar.getType() == 48) {
            int i = ((au) view.getTag()).position;
            contextMenu.add(i, 127, 0, view.getContext().getString(R.l.retransmit));
            if (f.MK() && !this.tKy.cws()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(R.l.chatting_long_click_brand_service));
            }
            if (d.QS("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(R.l.plugin_favorite_opt));
            }
            dj djVar = new dj();
            djVar.bLf.bJC = bdVar.field_msgId;
            com.tencent.mm.sdk.b.a.sFg.m(djVar);
            if (djVar.bLg.bKE || g.U(this.tKy.tTq.getContext(), bdVar.getType())) {
                contextMenu.add(i, 129, 0, view.getContext().getString(R.l.chatting_long_click_menu_open));
            }
            if (!this.tKy.cws()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(R.l.chatting_long_click_menu_delete_msg));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, bd bdVar) {
        switch (menuItem.getItemId()) {
            case 127:
                if (!bdVar.aQo()) {
                    return true;
                }
                List linkedList = new LinkedList();
                linkedList.add(bdVar);
                k.a(aVar.tTq.getContext(), linkedList, aVar.cwr(), aVar.oLT.field_username, null);
                return true;
            case 129:
                Intent intent = new Intent(aVar.tTq.getContext(), ChattingSendDataToDeviceUI.class);
                intent.putExtra("exdevice_open_scene_type", 1);
                intent.putExtra("Retr_Msg_Id", bdVar.field_msgId);
                aVar.tTq.getContext().startActivity(intent);
                return true;
            default:
                return false;
        }
    }

    public final boolean b(View view, a aVar, bd bdVar) {
        return false;
    }
}
