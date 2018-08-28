package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ai;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ay;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.chatting.AtSomeoneUI.b;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.List;

class AtSomeoneUI$a extends r<ab> {
    String dBm;
    private List<String> gRN;
    private u hLB;
    private String[] tDY;
    private Bitmap tDZ;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        au.HU();
        Object Yb = c.FR().Yb(ab.o(cursor));
        if (Yb != null) {
            return Yb;
        }
        ab abVar = new ab();
        abVar.d(cursor);
        au.HU();
        c.FR().Q(abVar);
        return abVar;
    }

    protected final /* bridge */ /* synthetic */ Object aVa() {
        return null;
    }

    public AtSomeoneUI$a(Context context, ab abVar, u uVar, String[] strArr, List<String> list) {
        super(context, abVar);
        this.hLB = uVar;
        this.tDY = strArr;
        this.gRN = list;
        this.tDZ = com.tencent.mm.sdk.platformtools.c.s(context.getResources().getDrawable(R.k.at_all_avater));
    }

    protected final int aUZ() {
        return AtSomeoneUI.access$100() ? 1 : 0;
    }

    public final boolean qY(int i) {
        return false;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View inflate;
        b bVar;
        if (view == null) {
            inflate = View.inflate(this.context, R.i.at_someone_item, null);
            bVar = new b((byte) 0);
            bVar.hPe = (MaskLayout) inflate.findViewById(R.h.at_someone_item_avatar);
            bVar.eMf = (TextView) inflate.findViewById(R.h.at_someone_item_nick);
            bVar.tEa = (ImageView) inflate.findViewById(R.h.content);
            inflate.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
            inflate = view;
        }
        if (i == 0 && AtSomeoneUI.access$100()) {
            bVar.tEa.setImageBitmap(this.tDZ);
            bVar.eMf.setText(this.context.getResources().getString(R.l.at_all, new Object[]{"@"}));
            return inflate;
        }
        CharSequence a;
        ab abVar = (ab) getItem(i - (AtSomeoneUI.access$100() ? 1 : 0));
        bVar.eMf.setTextColor(a.ac(this.context, !s.hO(abVar.field_username) ? R.e.mm_list_textcolor_one : R.e.mm_list_textcolor_spuser));
        com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) bVar.hPe.getContentView(), abVar.field_username);
        if (abVar.field_verifyFlag == 0) {
            bVar.hPe.setMaskDrawable(null);
        } else if (am.a.dBt != null) {
            String gY = am.a.dBt.gY(abVar.field_verifyFlag);
            if (gY != null) {
                bVar.hPe.f(m.kU(gY), MaskLayout.a.tzk);
            } else {
                bVar.hPe.setMaskDrawable(null);
            }
        } else {
            bVar.hPe.setMaskDrawable(null);
        }
        if (ai.oW(abVar.field_conRemark)) {
            a = AtSomeoneUI.a(this.hLB, abVar.field_username);
        } else {
            a = abVar.field_conRemark;
        }
        if (ai.oW(a)) {
            a = abVar.BK();
        }
        bVar.eMf.setText(j.a(this.context, a, bVar.eMf.getTextSize()));
        return inflate;
    }

    public final void WT() {
        List list;
        au.HU();
        ay FR = c.FR();
        String[] strArr = this.tDY;
        String str = "@all.chatroom";
        String str2 = this.dBm;
        CharSequence charSequence = this.dBm;
        if (this.hLB == null || charSequence == null || this.tDY == null) {
            list = null;
        } else {
            list = new ArrayList();
            for (String str3 : this.tDY) {
                String gT = this.hLB.gT(str3);
                if (gT != null && gT.contains(charSequence)) {
                    list.add(str3);
                }
            }
        }
        setCursor(FR.a(strArr, str, str2, list, this.gRN));
        super.notifyDataSetChanged();
    }

    protected final void WS() {
        aYc();
        WT();
    }
}
