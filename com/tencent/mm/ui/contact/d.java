package com.tencent.mm.ui.contact;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.applet.b;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.f;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.r;
import java.util.List;

public final class d extends r<ab> {
    protected MMActivity bGc;
    b eKg = null;
    private b.b eKh = null;
    protected List<String> gRN = null;
    protected g hkN;
    protected c hkO;
    protected com.tencent.mm.ui.base.MMSlideDelView.d hkQ = MMSlideDelView.getItemStatusCallBack();
    protected f lCE;
    com.tencent.mm.pluginsdk.ui.d qJh;
    protected String ugF = null;

    protected static class a {
        public TextView eMf;
        public MaskLayout hPe;
        public TextView kuR;
        public ViewGroup uir;
    }

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        au.HU();
        Object Yb = com.tencent.mm.model.c.FR().Yb(ab.o(cursor));
        if (Yb != null) {
            return Yb;
        }
        ab abVar = new ab();
        abVar.d(cursor);
        au.HU();
        com.tencent.mm.model.c.FR().Q(abVar);
        return abVar;
    }

    public d(Context context, String str) {
        super(context, new ab());
        this.bGc = (MMActivity) context;
        this.ugF = str;
        this.eKg = new b(new 1(this));
    }

    public final void setPerformItemClickListener(g gVar) {
        this.hkN = gVar;
    }

    public final void a(f fVar) {
        this.lCE = fVar;
    }

    public final void setGetViewPositionCallback(c cVar) {
        this.hkO = cVar;
    }

    public final int getCount() {
        return getCursor().getCount();
    }

    protected final void WS() {
        WT();
    }

    public final synchronized void WT() {
        au.HU();
        Cursor c = com.tencent.mm.model.c.FR().c(this.ugF, "", this.gRN);
        aYc();
        setCursor(c);
        notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (this.eKh == null) {
            this.eKh = new 2(this);
        }
        if (this.eKg != null) {
            this.eKg.a(i, this.eKh);
        }
        if (view == null) {
            view = View.inflate(this.bGc, R.i.chatroom_address_list_item, null);
            a aVar2 = new a();
            aVar2.kuR = (TextView) view.findViewById(R.h.contactitem_catalog);
            aVar2.hPe = (MaskLayout) view.findViewById(R.h.contactitem_avatar);
            aVar2.eMf = (TextView) view.findViewById(R.h.contactitem_nick);
            aVar2.uir = (ViewGroup) view.findViewById(R.h.contactitem_layout);
            LayoutParams layoutParams = aVar2.uir.getLayoutParams();
            layoutParams.height = (int) (((float) com.tencent.mm.bp.a.ae(this.bGc, R.f.ContactListHeight)) * com.tencent.mm.bp.a.fh(this.bGc));
            aVar2.uir.setLayoutParams(layoutParams);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        ab abVar = (ab) getItem(i - 1);
        int i2 = abVar == null ? -1 : abVar.field_showHead;
        abVar = (ab) getItem(i);
        if (i == 0) {
            CharSequence Z = Z(abVar);
            if (ai.oW(Z)) {
                x.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[]{abVar.field_username, Integer.valueOf(i)});
                aVar.kuR.setVisibility(8);
            } else {
                aVar.kuR.setVisibility(0);
                aVar.kuR.setText(Z);
                aVar.kuR.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            }
            if (getItem(i + 1) == null) {
                aVar.uir.setBackgroundResource(0);
            }
        } else if (i <= 0 || abVar.field_showHead == i2) {
            aVar.kuR.setVisibility(8);
            a(aVar, i, i2);
        } else {
            CharSequence Z2 = Z(abVar);
            aVar.uir.setBackgroundResource(R.g.comm_list_item_selector);
            if (ai.oW(Z2)) {
                x.w("MicroMsg.ChatroomContactAdapter", "get display show head return null, user[%s] pos[%d]", new Object[]{abVar.field_username, Integer.valueOf(i)});
                aVar.kuR.setVisibility(8);
            } else {
                aVar.kuR.setVisibility(0);
                aVar.kuR.setText(Z2);
                if (abVar.field_showHead == 32) {
                    aVar.kuR.setCompoundDrawablesWithIntrinsicBounds(R.g.mm_contact_star, 0, 0, 0);
                    aVar.kuR.setCompoundDrawablePadding(2);
                } else {
                    aVar.kuR.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                }
            }
            a(aVar, i, i2);
        }
        aVar.eMf.setTextColor(com.tencent.mm.bp.a.ac(this.bGc, !s.hO(abVar.field_username) ? R.e.mm_list_textcolor_one : R.e.mm_list_textcolor_spuser));
        ImageView imageView = (ImageView) aVar.hPe.getContentView();
        com.tencent.mm.pluginsdk.ui.a.b.a(imageView, abVar.field_username);
        com.tencent.mm.pluginsdk.ui.a aVar3 = (com.tencent.mm.pluginsdk.ui.a) imageView.getDrawable();
        if (this.qJh != null) {
            this.qJh.a(aVar3);
        }
        aVar.hPe.setMaskDrawable(null);
        try {
            aVar.eMf.setText(j.a(this.bGc, com.tencent.mm.model.r.gT(abVar.field_username), (int) aVar.eMf.getTextSize()));
        } catch (Exception e) {
            aVar.eMf.setText("");
        }
        return view;
    }

    private void a(a aVar, int i, int i2) {
        ab abVar = (ab) getItem(i + 1);
        if (abVar == null || !(abVar.field_showHead == i2 || ai.oW(Z(abVar)))) {
            aVar.uir.setBackgroundResource(0);
        }
    }

    private String Z(ab abVar) {
        if (abVar.field_showHead == 31) {
            return "";
        }
        if (abVar.field_showHead == 43) {
            return this.bGc.getString(R.l.room_head_name);
        }
        return String.valueOf((char) abVar.field_showHead);
    }
}
