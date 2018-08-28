package com.tencent.mm.plugin.label.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.bt.d;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.AddressView;
import com.tencent.mm.ui.contact.f;
import com.tencent.mm.ui.r;
import java.util.List;

public final class a extends r<f> {
    public static final ColorStateList kBs = com.tencent.mm.bp.a.ac(ad.getContext(), R.e.mm_list_textcolor_one);
    public static final ColorStateList kBt = com.tencent.mm.bp.a.ac(ad.getContext(), R.e.hint_text_color);
    List<String> kBu;

    protected static class a {
        public AddressView kBx;

        public a(View view) {
            this.kBx = (AddressView) view.findViewById(R.h.myview);
        }
    }

    public a(Context context) {
        super(context, new f());
    }

    public final int getCount() {
        return super.getCount();
    }

    /* renamed from: rN */
    public final f getItem(int i) {
        if (qY(i)) {
            return (f) aVa();
        }
        f fVar;
        if (this.tlF != null) {
            fVar = (f) this.tlF.get(Integer.valueOf(i));
            if (fVar != null) {
                return fVar;
            }
        }
        if (i < 0 || !getCursor().moveToPosition(i)) {
            return null;
        }
        fVar = a(null, getCursor());
        if (this.tlF == null) {
            lB(true);
        }
        if (this.tlF == null) {
            return fVar;
        }
        this.tlF.put(Integer.valueOf(i), fVar);
        return fVar;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        String gY;
        CharSequence charSequence = null;
        ab abVar = getItem(i).guS;
        if (view == null || view.getTag() == null) {
            view = View.inflate(this.context, R.i.contact_label_member_list_item, null);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        b.a(aVar.kBx, abVar.field_username);
        if (abVar.field_verifyFlag != 0) {
            gY = com.tencent.mm.model.am.a.dBt.gY(abVar.field_verifyFlag);
            if (gY != null) {
                aVar.kBx.setMaskBitmap(m.kU(gY));
            } else {
                aVar.kBx.setMaskBitmap(null);
            }
        } else {
            aVar.kBx.setMaskBitmap(null);
        }
        if (abVar.field_deleteFlag == 1) {
            aVar.kBx.setNickNameTextColor(kBt);
        } else {
            aVar.kBx.setNickNameTextColor(kBs);
        }
        aVar.kBx.updateTextColors();
        CharSequence charSequence2 = abVar.sNQ;
        if (charSequence2 == null) {
            try {
                Context context = this.context;
                gY = abVar.field_username;
                charSequence2 = com.tencent.mm.model.r.gT(abVar.field_username);
                String str = "";
                if (str.length() > 0 && !str.equals(charSequence2)) {
                    StringBuilder stringBuilder = new StringBuilder(32);
                    stringBuilder.append(charSequence2);
                    stringBuilder.append("(");
                    stringBuilder.append(str);
                    stringBuilder.append(")");
                    charSequence2 = stringBuilder.toString();
                }
                charSequence = j.a(context, charSequence2, aVar.kBx.getNickNameSize());
            } catch (Exception e) {
            }
            if (charSequence == null) {
                charSequence = "";
            }
            aVar.kBx.setName(charSequence);
            abVar.sNQ = charSequence;
        } else {
            aVar.kBx.setName(charSequence2);
        }
        aVar.kBx.updatePositionFlag();
        return view;
    }

    public final synchronized void WT() {
        Cursor cnR;
        Object obj = Looper.myLooper() == Looper.getMainLooper() ? 1 : null;
        if (this.kBu == null || this.kBu.size() <= 0) {
            cnR = d.cnR();
        } else {
            au.HU();
            cnR = c.FR().dh(this.kBu);
        }
        if (obj != null) {
            l(cnR);
        } else {
            ah.A(new 1(this, cnR));
        }
    }

    protected final void WS() {
        WT();
    }

    private static f a(f fVar, Cursor cursor) {
        if (fVar == null) {
            fVar = new f();
        }
        au.HU();
        ab Yb = c.FR().Yb(ab.o(cursor));
        if (Yb == null) {
            fVar.guS.d(cursor);
            au.HU();
            c.FR().Q(fVar.guS);
        } else {
            fVar.guS = Yb;
        }
        return fVar;
    }

    public final void l(Cursor cursor) {
        aYc();
        setCursor(cursor);
        notifyDataSetChanged();
    }
}
