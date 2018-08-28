package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.comm.a.c;
import com.tencent.mm.plugin.comm.a.e;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.ui.applet.k.3;
import com.tencent.mm.pluginsdk.ui.applet.k.4;
import com.tencent.mm.pluginsdk.ui.applet.k.b;
import com.tencent.mm.pluginsdk.ui.d;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.base.preference.Preference;
import java.util.ArrayList;
import java.util.List;

public class ContactListExpandPreference extends Preference {
    public i qJA;
    public k qJB;
    private int qJz = -1;

    public interface a {
        void aAK();

        void of(int i);

        void og(int i);

        void oh(int i);
    }

    public ContactListExpandPreference(Context context, int i) {
        super(context);
        if (i == 0) {
            cdT();
        } else if (i == 1) {
            this.qJz = 1;
            this.qJB = new k();
        }
        setLayoutResource(f.mm_preference_contact_list_row);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        cdT();
        setLayoutResource(f.mm_preference_contact_list_row);
    }

    public ContactListExpandPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        cdT();
        setLayoutResource(f.mm_preference_contact_list_row);
    }

    private void cdT() {
        this.qJz = 0;
        this.qJA = new i(this.mContext);
    }

    public final void onBindView(View view) {
        if (this.qJz == 1) {
            k kVar = this.qJB;
            ViewGroup viewGroup = view.getId() == e.contact_list_content_layout ? (ViewGroup) view : (ViewGroup) view.findViewById(e.contact_list_content_layout);
            if (kVar.row == 0) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(c.ListPadding), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(c.MiddlePadding));
            } else if (kVar.row == (kVar.qIM.getCount() / j.qIW) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(c.ListPadding));
            } else {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getResources().getDimensionPixelSize(c.MiddlePadding), viewGroup.getPaddingRight(), viewGroup.getResources().getDimensionPixelSize(c.MiddlePadding));
            }
            if ((kVar.qIM.qJg % j.qIW == j.qIW - 1 || kVar.qIM.qJg % j.qIW == 0) && kVar.hLy && kVar.row == (kVar.qIM.getCount() / j.qIW) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), 0);
            } else if (!kVar.hLy && kVar.qIM.qJg % j.qIW == 0 && kVar.row == (kVar.qIM.getCount() / j.qIW) - 1) {
                viewGroup.setPadding(viewGroup.getPaddingLeft(), viewGroup.getPaddingTop(), viewGroup.getPaddingRight(), (int) viewGroup.getContext().getResources().getDimension(c.SmallPadding));
            }
            if (kVar.qIM != null) {
                int i;
                viewGroup.setOnClickListener(kVar.mtE);
                if (viewGroup.getChildCount() > j.qIW) {
                    int childCount = viewGroup.getChildCount();
                    for (i = 0; i < childCount - j.qIW; i++) {
                        viewGroup.removeViewAt(i);
                    }
                    viewGroup.requestLayout();
                }
                for (i = 0; i < kVar.qJC; i++) {
                    View inflate;
                    int dimensionPixelSize;
                    if (viewGroup.getChildAt(i) == null) {
                        inflate = View.inflate(viewGroup.getContext(), f.roominfo_contact, null);
                        viewGroup.addView(inflate);
                    } else {
                        inflate = viewGroup.getChildAt(i);
                    }
                    LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (j.qIW == 4) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.NormalPadding);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    } else {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.MiddlePadding);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    if (!kVar.qIM.cdR() && kVar.qIM.qJg == 1) {
                        dimensionPixelSize = viewGroup.getResources().getDimensionPixelSize(c.BiggerPadding);
                        layoutParams.setMargins(dimensionPixelSize, 0, dimensionPixelSize, 0);
                    }
                    inflate.setLayoutParams(layoutParams);
                    int i2 = (kVar.row * kVar.qJC) + i;
                    kVar.qIM.getView(i2, inflate, viewGroup);
                    if (kVar.qIS != null) {
                        inflate.setOnClickListener(new 3(kVar, viewGroup, i2));
                    }
                    if (kVar.qJD != null) {
                        inflate.setOnLongClickListener(new 4(kVar, viewGroup, i2));
                    }
                }
                if (kVar.qIM.cdR() || kVar.qIM.qJg > 1) {
                    ((LinearLayout) viewGroup).setGravity(17);
                } else {
                    ((LinearLayout) viewGroup).setGravity(19);
                }
            }
        }
        super.onBindView(view);
    }

    public final void a(com.tencent.mm.ui.base.preference.f fVar, String str) {
        if (this.qJA != null) {
            i iVar = this.qJA;
            if (fVar != null && str != null) {
                iVar.eOE = fVar;
                iVar.qII = str;
                fVar.bw(str, true);
            }
        }
    }

    public final void a(d dVar) {
        if (this.qJA != null) {
            this.qJA.qIM.qJh = dVar;
        }
    }

    public final void notifyChanged() {
        if (this.qJA != null) {
            this.qJA.bpx();
        }
    }

    public final void p(String str, List<String> list) {
        if (this.qJA != null) {
            List list2;
            i iVar = this.qJA;
            iVar.username = str;
            if (list2 == null) {
                list2 = new ArrayList(0);
            }
            iVar.qIM.co(list2);
            iVar.FX(str);
        }
    }

    public final void aa(ArrayList<ab> arrayList) {
        if (this.qJA != null) {
            i iVar = this.qJA;
            iVar.qIM.Z(arrayList);
            iVar.FX(null);
        }
    }

    public final void cdU() {
        if (this.qJA != null) {
            this.qJA.qIM.qJt = false;
        }
    }

    public final void TL(String str) {
        if (this.qJA != null) {
            this.qJA.qIM.qJo = str;
        }
    }

    public final boolean Cb(int i) {
        if (this.qJA != null) {
            return this.qJA.qIM.Cb(i);
        }
        return false;
    }

    public final Object getItem(int i) {
        if (this.qJA == null || !this.qJA.qIM.Cb(i)) {
            return null;
        }
        return this.qJA.qIM.getItem(i);
    }

    public final String Cc(int i) {
        if (this.qJA == null || !this.qJA.qIM.Cb(i)) {
            return "";
        }
        return ((ab) this.qJA.qIM.getItem(i)).field_username;
    }

    public final String Cd(int i) {
        if (this.qJA == null || !this.qJA.qIM.Cb(i)) {
            return "";
        }
        return ((ab) this.qJA.qIM.getItem(i)).field_nickname;
    }

    public final String Ce(int i) {
        if (this.qJA == null || !this.qJA.qIM.Cb(i)) {
            return "";
        }
        return ((ab) this.qJA.qIM.getItem(i)).field_conRemark;
    }

    public final void cdV() {
        if (this.qJA != null) {
            j jVar = this.qJA.qIM;
            jVar.hNA = false;
            jVar.notifyChanged();
        }
    }

    public final ContactListExpandPreference kG(boolean z) {
        if (this.qJA != null) {
            this.qJA.qIM.qJj = z;
        }
        return this;
    }

    public final ContactListExpandPreference kH(boolean z) {
        if (this.qJA != null) {
            this.qJA.qIM.qJi = z;
        }
        return this;
    }

    public final ContactListExpandPreference cdW() {
        if (this.qJA != null) {
            this.qJA.qIM.qJk = false;
        }
        return this;
    }

    public final void cdX() {
        boolean z = false;
        if (this.qJA != null) {
            i iVar = this.qJA;
            iVar.qIK = false;
            if (iVar.qIK) {
                z = true;
            }
            iVar.qIL = z;
        }
    }

    public final void refresh() {
        if (this.qJA != null) {
            this.qJA.qIM.notifyChanged();
        }
    }

    public final void bt(List<String> list) {
        if (this.qJA != null) {
            j jVar = this.qJA.qIM;
            jVar.co(list);
            jVar.notifyChanged();
        }
    }

    public final void a(b bVar) {
        if (this.qJA != null) {
            this.qJA.qIN = bVar;
        }
    }

    public final void a(a aVar) {
        if (this.qJA != null) {
            this.qJA.opw = aVar;
        }
    }
}
