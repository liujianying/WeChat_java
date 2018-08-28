package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.aa.q;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class c extends r<com.tencent.mm.plugin.ipcall.a.g.c> implements com.tencent.mm.aa.f.c {
    static HashMap<String, com.tencent.mm.plugin.ipcall.a.g.c> ksx = null;
    private String eIQ;
    ap eVd = new ap();
    HashMap<String, Integer> hPz = new HashMap();
    boolean hoW = false;
    private HashSet<String> ktA = new HashSet();
    private boolean ktB = false;
    private OnClickListener ktC = new 1(this);
    private d kty;
    private HashMap<Long, com.tencent.mm.plugin.ipcall.a.g.c> ktz = new HashMap();
    private Context mContext;

    public c(Context context) {
        super(context, null);
        lB(true);
        this.mContext = context;
        this.kty = new d(context);
        q.Kp().a(this);
    }

    public final int getCount() {
        return super.getCount();
    }

    public final int aYb() {
        return super.getCount();
    }

    /* renamed from: rA */
    public final com.tencent.mm.plugin.ipcall.a.g.c getItem(int i) {
        return (com.tencent.mm.plugin.ipcall.a.g.c) super.getItem(i);
    }

    public final void pi(String str) {
        this.eIQ = str;
        if (bi.oW(this.eIQ)) {
            this.ktB = false;
        } else {
            this.ktB = true;
        }
        this.tlF.clear();
        WT();
        notifyDataSetChanged();
    }

    public final void WT() {
        Cursor ER;
        Object obj = null;
        if (this.ktB) {
            this.hoW = true;
            ER = i.aXv().ER(this.eIQ);
            this.hoW = false;
        } else {
            ER = i.aXv().diF.query("IPCallAddressItem", d.ksz, null, null, null, null, "upper(sortKey) asc");
        }
        if (ER != null) {
            ER.moveToFirst();
        }
        setCursor(ER);
        if (getCursor() != null) {
            Cursor cursor = getCursor();
            try {
                if (cursor.moveToFirst()) {
                    int i = 0;
                    while (!cursor.isAfterLast()) {
                        com.tencent.mm.plugin.ipcall.a.g.c cVar = new com.tencent.mm.plugin.ipcall.a.g.c();
                        cVar.d(cursor);
                        String EZ = EZ(cVar.field_sortKey);
                        if (i == 0) {
                            this.hPz.put(EZ, Integer.valueOf(i));
                        } else if (obj != null) {
                            if (!EZ.equals(obj)) {
                                this.hPz.put(EZ, Integer.valueOf(i));
                            }
                        }
                        i++;
                        cursor.moveToNext();
                        String obj2 = EZ;
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.IPCallAddressAdapter", "initSectionPosMap error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    public final void aYc() {
        super.aYc();
    }

    protected final void WS() {
        super.aYc();
        WT();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.ipcall_address_item, viewGroup, false);
            b bVar = new b(this, (byte) 0);
            bVar.ktO = view.findViewById(R.h.item_header);
            bVar.ktP = view.findViewById(R.h.divider_bottom);
            bVar.eBM = (ImageView) view.findViewById(R.h.avatar_iv);
            bVar.eIH = (TextView) view.findViewById(R.h.nickname_tv);
            bVar.ktG = (TextView) view.findViewById(R.h.phonenumber_tv);
            bVar.ktH = (LinearLayout) view.findViewById(R.h.recent_info_ll);
            bVar.ktI = (TextView) view.findViewById(R.h.recent_state_tv);
            bVar.ktJ = (TextView) view.findViewById(R.h.recent_time_tv);
            bVar.ktK = (TextView) view.findViewById(R.h.address_spell_category_tv);
            bVar.ktL = (TextView) view.findViewById(R.h.address_item_category_tv);
            bVar.ktM = (ImageView) view.findViewById(R.h.address_item_info);
            bVar.ktN = view.findViewById(R.h.item_info_ll);
            bVar.ktN.setClickable(true);
            bVar.ktQ = (ImageView) view.findViewById(R.h.divider);
            view.setTag(bVar);
        }
        b bVar2 = (b) view.getTag();
        bVar2.ktN.setClickable(true);
        bVar2.ktN.setTag(Integer.valueOf(i));
        bVar2.ktQ.setVisibility(8);
        if (qY(i)) {
            bVar2.eIH.setVisibility(8);
            bVar2.ktG.setVisibility(8);
            bVar2.ktH.setVisibility(8);
            bVar2.eBM.setVisibility(8);
            bVar2.eBM.setTag(null);
            bVar2.ktL.setVisibility(8);
            bVar2.ktK.setVisibility(8);
            bVar2.ktM.setVisibility(8);
        } else {
            com.tencent.mm.plugin.ipcall.a.g.c rA = getItem(i);
            if (rA != null) {
                CharSequence charSequence;
                if (bi.oW(rA.field_systemAddressBookUsername)) {
                    bVar2.eIH.setVisibility(8);
                    bVar2.ktG.setVisibility(8);
                } else {
                    bVar2.eIH.setVisibility(0);
                    LayoutParams layoutParams;
                    RelativeLayout.LayoutParams layoutParams2;
                    if (this.ktB) {
                        bVar2.ktG.setVisibility(0);
                        layoutParams = (LayoutParams) bVar2.ktO.getLayoutParams();
                        layoutParams.height = (int) bVar2.ktG.getContext().getResources().getDimension(R.f.address_item_height_with_num);
                        bVar2.ktO.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.eBM.getLayoutParams();
                        layoutParams2.height = (int) bVar2.eBM.getContext().getResources().getDimension(R.f.address_item_avatar_size);
                        layoutParams2.width = (int) bVar2.eBM.getContext().getResources().getDimension(R.f.address_item_avatar_size);
                        bVar2.eBM.setLayoutParams(layoutParams2);
                    } else {
                        bVar2.ktG.setVisibility(8);
                        layoutParams = (LayoutParams) bVar2.ktO.getLayoutParams();
                        layoutParams.height = (int) bVar2.ktG.getContext().getResources().getDimension(R.f.address_item_height);
                        bVar2.ktO.setLayoutParams(layoutParams);
                        layoutParams2 = (RelativeLayout.LayoutParams) bVar2.eBM.getLayoutParams();
                        layoutParams2.height = (int) bVar2.eBM.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal);
                        layoutParams2.width = (int) bVar2.eBM.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal);
                        bVar2.eBM.setLayoutParams(layoutParams2);
                    }
                    if (this.ktB && rA.ksy == null && ksx != null && ksx.containsKey(rA.field_contactId)) {
                        rA.ksy = ((com.tencent.mm.plugin.ipcall.a.g.c) ksx.get(rA.field_contactId)).ksy;
                    } else if (this.ktB && rA.ksy == null && (ksx == null || ksx.containsKey(rA.field_contactId))) {
                        rA.ksy = b.EO(rA.field_contactId);
                    }
                    if (!bi.oW(this.eIQ) && (bi.p(this.eIQ.charAt(0)) || this.eIQ.startsWith("+"))) {
                        bVar2.ktG.setText(f.a(a(rA, this.eIQ), ap.Wv(this.eIQ)));
                        bVar2.eIH.setText(f.a(rA.field_systemAddressBookUsername, this.eIQ));
                    } else if (!bi.oW(this.eIQ) && !bi.p(this.eIQ.charAt(0))) {
                        String charSequence2;
                        CharSequence charSequence3 = rA.field_systemAddressBookUsername;
                        String str = rA.field_systemAddressBookUsername;
                        CharSequence charSequence4 = this.eIQ;
                        if (bi.oW(charSequence4) || bi.oW(str)) {
                            charSequence2 = "";
                        } else {
                            if (!bi.WC(charSequence4) && bi.WD(charSequence4)) {
                                int i2;
                                int i3;
                                List arrayList = new ArrayList();
                                for (i2 = 0; i2 < str.length(); i2++) {
                                    String substring = str.substring(i2, i2 + 1);
                                    arrayList.add(new a(this, h.oI(substring), substring));
                                }
                                for (i2 = 2; i2 <= str.length(); i2++) {
                                    for (i3 = 0; i3 <= str.length() - i2; i3++) {
                                        String substring2 = str.substring(i3, i3 + i2);
                                        arrayList.add(new a(this, h.oI(substring2), substring2));
                                    }
                                }
                                i2 = 0;
                                while (true) {
                                    i3 = i2;
                                    if (i3 >= arrayList.size()) {
                                        break;
                                    }
                                    a aVar = (a) arrayList.get(i3);
                                    if (aVar.ktE.contains(charSequence4)) {
                                        charSequence2 = aVar.ktF;
                                        break;
                                    }
                                    i2 = i3 + 1;
                                }
                            }
                            charSequence2 = charSequence4;
                        }
                        bVar2.eIH.setText(f.a(charSequence3, charSequence2));
                        bVar2.ktG.setText(a(rA, this.eIQ));
                    } else if (bi.oW(this.eIQ)) {
                        bVar2.eIH.setText(rA.field_systemAddressBookUsername);
                    }
                }
                ImageView imageView = bVar2.eBM;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.ipcall_default_avatar);
                    if (rA != null) {
                        if (!bi.oW(rA.field_contactId) && !bi.oW(rA.field_wechatUsername)) {
                            this.kty.a(rA.field_contactId, rA.field_wechatUsername, imageView);
                        } else if (!bi.oW(rA.field_contactId)) {
                            this.kty.b(rA.field_contactId, imageView);
                        } else if (!bi.oW(rA.field_wechatUsername)) {
                            this.kty.c(rA.field_wechatUsername, imageView);
                        }
                        if (!bi.oW(rA.field_wechatUsername)) {
                            this.ktA.add(rA.field_wechatUsername);
                        }
                    }
                }
                bVar2.ktH.setVisibility(8);
                charSequence2 = EZ(rA.field_sortKey);
                if (i == 0) {
                    bVar2.ktK.setVisibility(0);
                    bVar2.ktK.setText(charSequence2);
                    bVar2.ktL.setVisibility(8);
                } else if (EZ(getItem(i - 1).field_sortKey).equals(charSequence2)) {
                    bVar2.ktK.setVisibility(8);
                    bVar2.ktK.setText("");
                    bVar2.ktL.setVisibility(8);
                } else {
                    bVar2.ktK.setVisibility(0);
                    bVar2.ktK.setText(charSequence2);
                    bVar2.ktL.setVisibility(8);
                }
            }
            bVar2.ktN.setVisibility(8);
            bVar2.ktM.setVisibility(8);
            bVar2.ktM.setOnClickListener(this.ktC);
        }
        Object obj = 1;
        if (!(getItem(i + 1) == null || getItem(i) == null || EZ(getItem(i + 1).field_sortKey).equals(EZ(getItem(i).field_sortKey)))) {
            obj = null;
        }
        if (i + 1 == getCount() || obj == null) {
            bVar2.ktP.setVisibility(8);
        } else {
            bVar2.ktP.setVisibility(0);
        }
        return view;
    }

    private static String a(com.tencent.mm.plugin.ipcall.a.g.c cVar, String str) {
        if (!(cVar == null || cVar.ksy == null)) {
            Iterator it = cVar.ksy.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (str2.contains(str)) {
                    return str2;
                }
            }
        }
        return null;
    }

    private static String EZ(String str) {
        if (bi.oW(str)) {
            return "";
        }
        if (str.startsWith(b.hPy)) {
            return "#";
        }
        return str.toUpperCase().substring(0, 1);
    }

    public final int getItemViewType(int i) {
        return super.getItemViewType(i);
    }

    public final int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    public final void jX(String str) {
        if (this.ktA.contains(str)) {
            ah.A(new 2(this));
        }
    }

    public final void notifyDataSetChanged() {
        this.ktz.clear();
        super.notifyDataSetChanged();
    }
}
