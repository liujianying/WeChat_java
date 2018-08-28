package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.model.am;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.c;
import com.tencent.mm.plugin.nearby.ui.NearbyFriendsUI.d;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.aqp;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.applet.b;
import java.util.LinkedList;

class NearbyFriendsUI$b extends BaseAdapter {
    private final Context context;
    b eKg = new b(new 1(this));
    private b.b eKh = null;
    final /* synthetic */ NearbyFriendsUI lCf;

    public NearbyFriendsUI$b(NearbyFriendsUI nearbyFriendsUI, Context context) {
        this.lCf = nearbyFriendsUI;
        this.context = context;
    }

    public final int getCount() {
        return NearbyFriendsUI.r(this.lCf).size();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        d dVar;
        if (this.eKh == null) {
            this.eKh = new 2(this);
        }
        if (this.eKg != null) {
            this.eKg.a(i, this.eKh);
        }
        if (view == null) {
            d dVar2 = new d();
            view = View.inflate(this.context, R.i.nearby_friend_item, null);
            dVar2.eIz = (TextView) view.findViewById(R.h.nearby_friend_name);
            dVar2.lCm = (TextView) view.findViewById(R.h.nearby_friend_sign);
            dVar2.lCl = (TextView) view.findViewById(R.h.nearby_friend_distance);
            dVar2.eKk = (ImageView) view.findViewById(R.h.nearby_friend_avatar_iv);
            dVar2.eKl = (TextView) view.findViewById(R.h.nearby_friend_is_friend);
            dVar2.lCn = (ImageView) view.findViewById(R.h.nearby_friend_vuserinfo);
            dVar2.lCo = (ImageView) view.findViewById(R.h.nearby_friend_sns);
            dVar2.lCq = (ImageView) view.findViewById(R.h.nearby_friend_ad_icon_1);
            dVar2.lCr = (ImageView) view.findViewById(R.h.nearby_friend_ad_icon_2);
            dVar2.lCs = (ImageView) view.findViewById(R.h.nearby_friend_ad_icon_3);
            LayoutParams layoutParams = dVar2.lCo.getLayoutParams();
            layoutParams.height = a.ad(this.context, R.f.NormalPadding);
            layoutParams.width = a.ad(this.context, R.f.NormalPadding);
            dVar2.lCo.setLayoutParams(layoutParams);
            dVar2.lCp = (ImageView) view.findViewById(R.h.nearby_friend_sex);
            view.setTag(dVar2);
            dVar = dVar2;
        } else {
            dVar = (d) view.getTag();
        }
        aqp aqp = (aqp) NearbyFriendsUI.r(this.lCf).get(i);
        dVar.eIz.setText(j.a(this.context, aqp.hcS, dVar.eIz.getTextSize()));
        if (NearbyFriendsUI.h(this.lCf) == 1) {
            switch (aqp.eJH) {
                case 1:
                    dVar.lCp.setVisibility(0);
                    dVar.lCp.setImageResource(R.k.ic_sex_male);
                    dVar.lCp.setContentDescription(this.context.getString(R.l.male_Imgbtn));
                    break;
                case 2:
                    dVar.lCp.setVisibility(0);
                    dVar.lCp.setImageResource(R.k.ic_sex_female);
                    dVar.lCp.setContentDescription(this.context.getString(R.l.female_Imgbtn));
                    break;
                default:
                    dVar.lCp.setVisibility(8);
                    break;
            }
        }
        dVar.lCp.setVisibility(8);
        if (aqp.rTe != 0) {
            dVar.lCn.setVisibility(0);
            dVar.lCn.setImageBitmap(BackwardSupportUtil.b.e(am.a.dBt.gX(aqp.rTe), 2.0f));
            dVar.lCp.setVisibility(8);
        } else {
            dVar.lCn.setVisibility(8);
        }
        dVar.lCl.setText(aqp.rTd);
        dVar.lCq.setVisibility(8);
        dVar.lCr.setVisibility(8);
        dVar.lCs.setVisibility(8);
        if (aqp instanceof com.tencent.mm.plugin.nearby.a.a) {
            LinkedList linkedList = ((com.tencent.mm.plugin.nearby.a.a) aqp).lBk;
            if (linkedList != null && linkedList.size() == 1) {
                dVar.lCq.setVisibility(0);
                NearbyFriendsUI.k(dVar.lCq, (String) linkedList.get(0));
            } else if (linkedList != null && linkedList.size() == 2) {
                dVar.lCq.setVisibility(0);
                dVar.lCr.setVisibility(0);
                NearbyFriendsUI.k(dVar.lCq, (String) linkedList.get(0));
                NearbyFriendsUI.k(dVar.lCr, (String) linkedList.get(1));
            } else if (linkedList != null && linkedList.size() >= 3) {
                dVar.lCq.setVisibility(0);
                dVar.lCr.setVisibility(0);
                dVar.lCs.setVisibility(0);
                NearbyFriendsUI.k(dVar.lCq, (String) linkedList.get(0));
                NearbyFriendsUI.k(dVar.lCr, (String) linkedList.get(1));
                NearbyFriendsUI.k(dVar.lCs, (String) linkedList.get(2));
            }
        }
        if (aqp.eJK == null || aqp.eJK.trim().equals("")) {
            dVar.lCm.setVisibility(8);
        } else {
            dVar.lCm.setVisibility(0);
            dVar.lCm.setText(j.a(this.context, aqp.eJK, dVar.lCm.getTextSize()));
        }
        if (aqp.rTk == null || (aqp.rTk.eJS & 1) <= 0) {
            dVar.lCo.setVisibility(8);
        } else {
            dVar.lCo.setVisibility(0);
        }
        if (c.tR(aqp.eJH)) {
            dVar.eKk.setImageBitmap(null);
            com.tencent.mm.ak.a.a.c.a aVar = new com.tencent.mm.ak.a.a.c.a();
            au.HU();
            aVar.dXB = com.tencent.mm.model.c.Gb();
            aVar.dXy = true;
            aVar.dXV = true;
            o.Pj().a(aqp.hbL, dVar.eKk, aVar.Pt());
            if (!bi.oW(aqp.eJM)) {
                dVar.eKl.setText(aqp.eJM);
                dVar.eKl.setVisibility(0);
            }
            dVar.eKl.setVisibility(8);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.a(dVar.eKk, aqp.hbL);
            au.HU();
            if (com.tencent.mm.model.c.FR().Yc(aqp.hbL)) {
                dVar.eKl.setVisibility(0);
                if (ab.Dk(aqp.rTe)) {
                    dVar.eKl.setText(this.lCf.getString(R.l.nearby_friend_followed));
                } else {
                    au.HU();
                    ab Ye = com.tencent.mm.model.c.FR().Ye(aqp.hbL);
                    if (Ye != null) {
                        dVar.eIz.setText(j.a(this.context, bi.oW(Ye.BL()) ? aqp.hcS : Ye.BL(), dVar.eIz.getTextSize()));
                    }
                    dVar.eKl.setText(this.lCf.getString(R.l.nearby_friend_is_contact));
                }
            }
            dVar.eKl.setVisibility(8);
        }
        return view;
    }

    /* renamed from: tQ */
    public final aqp getItem(int i) {
        return (aqp) NearbyFriendsUI.r(this.lCf).get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }
}
