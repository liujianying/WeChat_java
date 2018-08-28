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
import com.tencent.mm.aa.f;
import com.tencent.mm.aa.q;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.k;
import com.tencent.mm.plugin.ipcall.a.g.m;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public final class h extends r<c> implements f.c {
    private static HashMap<String, c> ksx = null;
    private boolean hoW = false;
    private HashSet<String> ktA = new HashSet();
    private boolean ktB = false;
    private d kty;
    private HashMap<Long, c> ktz = new HashMap();
    ArrayList<k> kxg;
    private OnClickListener kxh = new 1(this);

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        c cVar = (c) obj;
        if (cVar == null) {
            cVar = new c();
        }
        cVar.d(cursor);
        return cVar;
    }

    public h(Context context) {
        super(context, null);
        lB(true);
        this.kty = new d(context);
        q.Kp().a(this);
    }

    protected final void WS() {
        this.kxg = m.aXY();
    }

    public final void WT() {
        this.kxg = m.aXY();
    }

    public final int getCount() {
        if (this.kxg == null) {
            this.kxg = m.aXY();
        }
        if (this.kxg != null) {
            return this.kxg.size();
        }
        return 0;
    }

    public final k rG(int i) {
        return (k) this.kxg.get(i);
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.context).inflate(R.i.ipcall_address_item, viewGroup, false);
            a aVar = new a(this, (byte) 0);
            aVar.ktO = view.findViewById(R.h.item_header);
            aVar.ktP = view.findViewById(R.h.divider_bottom);
            aVar.eBM = (ImageView) view.findViewById(R.h.avatar_iv);
            aVar.eIH = (TextView) view.findViewById(R.h.nickname_tv);
            aVar.ktG = (TextView) view.findViewById(R.h.phonenumber_tv);
            aVar.ktH = (LinearLayout) view.findViewById(R.h.recent_info_ll);
            aVar.ktI = (TextView) view.findViewById(R.h.recent_state_tv);
            aVar.ktJ = (TextView) view.findViewById(R.h.recent_time_tv);
            aVar.ktK = (TextView) view.findViewById(R.h.address_spell_category_tv);
            aVar.ktL = (TextView) view.findViewById(R.h.address_item_category_tv);
            aVar.ktM = (ImageView) view.findViewById(R.h.address_item_info);
            aVar.ktN = view.findViewById(R.h.item_info_ll);
            aVar.ktN.setClickable(true);
            aVar.ktQ = (ImageView) view.findViewById(R.h.divider);
            view.setTag(aVar);
        }
        a aVar2 = (a) view.getTag();
        aVar2.ktN.setClickable(true);
        aVar2.ktN.setTag(Integer.valueOf(i));
        aVar2.ktQ.setVisibility(8);
        if (qY(i)) {
            aVar2.eIH.setVisibility(8);
            aVar2.ktG.setVisibility(8);
            aVar2.ktH.setVisibility(8);
            aVar2.eBM.setVisibility(8);
            aVar2.eBM.setTag(null);
            aVar2.ktL.setVisibility(8);
            aVar2.ktK.setVisibility(8);
            aVar2.ktM.setVisibility(8);
        } else {
            k rG = rG(i);
            if (rG != null) {
                c dN;
                if (i == 0) {
                    aVar2.ktL.setVisibility(0);
                    aVar2.ktK.setVisibility(8);
                    aVar2.ktL.setText(this.context.getString(R.l.ip_call_recently_contact));
                } else {
                    aVar2.ktL.setVisibility(8);
                    aVar2.ktK.setVisibility(8);
                }
                aVar2.ktQ.setVisibility(0);
                aVar2.eIH.setVisibility(0);
                LayoutParams layoutParams = (LayoutParams) aVar2.ktO.getLayoutParams();
                layoutParams.height = (int) aVar2.ktG.getContext().getResources().getDimension(R.f.address_item_height);
                aVar2.ktO.setLayoutParams(layoutParams);
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) aVar2.eBM.getLayoutParams();
                layoutParams2.height = (int) aVar2.eBM.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal);
                layoutParams2.width = (int) aVar2.eBM.getContext().getResources().getDimension(R.f.address_item_avatar_size_normal);
                aVar2.eBM.setLayoutParams(layoutParams2);
                if (rG.field_addressId > 0) {
                    dN = this.ktz.containsKey(Long.valueOf(rG.field_addressId)) ? (c) this.ktz.get(Long.valueOf(rG.field_addressId)) : i.aXv().dN(rG.field_addressId);
                    if (dN != null) {
                        this.ktz.put(Long.valueOf(rG.field_addressId), dN);
                        aVar2.eIH.setText(dN.field_systemAddressBookUsername);
                    }
                } else {
                    aVar2.eIH.setText(a.Ft(rG.field_phonenumber));
                    dN = null;
                }
                aVar2.ktG.setVisibility(8);
                aVar2.ktH.setVisibility(0);
                aVar2.ktJ.setText(com.tencent.mm.plugin.ipcall.b.c.dR(rG.field_calltime));
                if (rG.field_duration > 0) {
                    aVar2.ktI.setText(com.tencent.mm.plugin.ipcall.b.c.dT(rG.field_duration));
                } else {
                    aVar2.ktI.setText(com.tencent.mm.plugin.ipcall.b.c.rL(rG.field_status));
                }
                ImageView imageView = aVar2.eBM;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    imageView.setTag(null);
                    imageView.setImageResource(R.g.ipcall_default_avatar);
                    if (dN != null) {
                        if (!bi.oW(dN.field_contactId) && !bi.oW(dN.field_wechatUsername)) {
                            this.kty.a(dN.field_contactId, dN.field_wechatUsername, imageView);
                        } else if (!bi.oW(dN.field_contactId)) {
                            this.kty.b(dN.field_contactId, imageView);
                        } else if (!bi.oW(dN.field_wechatUsername)) {
                            this.kty.c(dN.field_wechatUsername, imageView);
                        }
                        if (!bi.oW(dN.field_wechatUsername)) {
                            this.ktA.add(dN.field_wechatUsername);
                        }
                    }
                }
            }
            aVar2.ktN.setVisibility(0);
            aVar2.ktM.setVisibility(0);
            aVar2.ktN.setOnClickListener(this.kxh);
        }
        return view;
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
        this.kxg = m.aXY();
        this.ktz.clear();
        super.notifyDataSetChanged();
    }
}
