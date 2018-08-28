package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.f.b.a.d;
import com.tencent.mm.plugin.exdevice.ui.e.a;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b extends BaseAdapter {
    private String gtX = q.GF();
    List<e> iEH;
    Map<String, String> iEI;
    String iEJ;
    d iEK;
    private String iEL;
    private boolean iEM = false;
    private a iEN = new a();
    private OnClickListener iEO = new 2(this);
    private OnClickListener iEP = new 3(this);
    private OnClickListener iEQ = new 4(this);
    private Context mContext;

    public b(Context context, String str) {
        this.mContext = context;
        this.iEL = str;
    }

    private static void c(LinkedList<c> linkedList, String str) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                x.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[]{((c) it.next()).toString()});
                it.remove();
            }
        }
    }

    private static boolean d(LinkedList<c> linkedList, String str) {
        try {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                if (((c) it.next()).field_username.equalsIgnoreCase(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            x.d("MicroMsg.ExdeviceRankAdapter", e.toString());
            return false;
        }
    }

    private List<e> a(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        a aVar;
        LinkedList linkedList = new LinkedList(arrayList);
        List arrayList3 = new ArrayList();
        d f = f(this.gtX, arrayList2);
        if (f != null) {
            a aVar2 = this.iEN;
            aVar2.iHF = f;
            aVar2.iHG = 3;
            if (f.field_score == 0) {
                ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).d((Activity) this.mContext, this.gtX);
            }
        } else {
            aVar = this.iEN;
            aVar.iHF = null;
            aVar.iEL = this.iEL;
            aVar.username = this.gtX;
            aVar.iHG = 7;
        }
        if (z) {
            this.iEN.Xe = 2;
        } else {
            this.iEN.Xe = 1;
        }
        arrayList3.add(this.iEN.aIq());
        aVar = this.iEN;
        aVar.Xe = 0;
        arrayList3.add(aVar.aIq());
        c(linkedList, this.gtX);
        Collection arrayList4 = new ArrayList();
        x.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[]{Integer.valueOf(linkedList.size()), linkedList.toString()});
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            f = (d) it.next();
            a aVar3 = this.iEN;
            aVar3.iHF = f;
            aVar3.Xe = 1;
            aVar3.iHG = 4;
            arrayList4.add(aVar3.aIq());
            if (linkedList.size() > 0 && d(linkedList, f.field_username)) {
                aVar3 = this.iEN;
                aVar3.iHF = f;
                aVar3.Xe = 1;
                aVar3.iHG = 2;
                arrayList3.add(aVar3.aIq());
                c(linkedList, f.field_username);
            }
        }
        if (linkedList.size() > 0) {
            it = linkedList.iterator();
            while (it.hasNext()) {
                c cVar = (c) it.next();
                a aVar4 = this.iEN;
                aVar4.username = cVar.field_username;
                aVar4.iEL = this.iEL;
                aVar4.iHF = null;
                aVar4.Xe = 1;
                aVar4.iHG = 6;
                arrayList3.add(aVar4.aIq());
            }
        }
        if (arrayList3.size() > 2) {
            ((e) arrayList3.get(arrayList3.size() - 1)).iHG = (((e) arrayList3.get(arrayList3.size() - 1)).iHG | 2) | 1;
            aVar = this.iEN;
            aVar.Xe = 0;
            aVar.iHF = null;
            arrayList3.add(aVar.aIq());
        }
        if (arrayList4.size() > 1) {
            ((e) arrayList4.get(arrayList4.size() - 1)).iHG = 5;
        }
        arrayList3.addAll(arrayList4);
        x.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[]{Integer.valueOf(arrayList2.size()), arrayList2.toString()});
        x.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[]{Integer.valueOf(arrayList3.size()), arrayList3.toString()});
        return arrayList3;
    }

    public final List<e> b(ArrayList<c> arrayList, ArrayList<d> arrayList2, boolean z) {
        ArrayList arrayList3;
        ArrayList arrayList22;
        if (arrayList3 == null) {
            try {
                arrayList3 = new ArrayList();
            } catch (Exception e) {
                x.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
                return new ArrayList();
            }
        }
        if (arrayList22 == null) {
            arrayList22 = new ArrayList();
        }
        return a(arrayList3, arrayList22, z);
    }

    public static d f(String str, ArrayList<d> arrayList) {
        if (arrayList == null) {
            return null;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (str.equalsIgnoreCase(dVar.field_username)) {
                return dVar;
            }
        }
        return null;
    }

    public final int getViewTypeCount() {
        return 3;
    }

    public final boolean isEnabled(int i) {
        return false;
    }

    public final int getCount() {
        return this.iEH == null ? 0 : this.iEH.size();
    }

    /* renamed from: pl */
    public final e getItem(int i) {
        return (e) this.iEH.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        return getItem(i).Xe;
    }

    public static void finish() {
        ((com.tencent.mm.plugin.sport.b.b) g.l(com.tencent.mm.plugin.sport.b.b.class)).bFx();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        d dVar = getItem(i).iHF;
        e pl = getItem(i);
        int itemViewType = getItemViewType(i);
        int i2 = pl.iHG;
        if (view != null) {
            switch (itemViewType) {
                case 1:
                case 2:
                    bVar = (b) view.getTag();
                    break;
                default:
                    bVar = null;
                    break;
            }
        }
        LayoutInflater from = LayoutInflater.from(this.mContext);
        switch (itemViewType) {
            case 0:
                view = from.inflate(R.i.exdevice_rank_info_item_other_divider, viewGroup, false);
                a aVar = new a();
                aVar.eCO = view.findViewById(R.h.dividerV);
                view.setTag(aVar);
                bVar = null;
                break;
            case 1:
                view = from.inflate(R.i.exdevice_rank_info_item_other, viewGroup, false);
                bVar = new b();
                bVar.iEV = (TextView) view.findViewById(R.h.exdevice_user_name_below_ranknum);
                break;
            case 2:
                view = from.inflate(R.i.exdevice_rank_profile_item, viewGroup, false);
                bVar = new b();
                break;
            default:
                bVar = null;
                break;
        }
        if (bVar != null) {
            bVar.ern = view.findViewById(R.h.container);
            bVar.hrk = view.findViewById(R.h.item_content);
            bVar.ivW = (TextView) view.findViewById(R.h.exdevice_rank_tv);
            bVar.iET = (ImageView) view.findViewById(R.h.exdevice_user_icon);
            bVar.iEU = (NoMeasuredTextView) view.findViewById(R.h.exdevice_user_name);
            bVar.iEW = (TextView) view.findViewById(R.h.ex_device_user_score);
            bVar.iEX = (ExdeviceLikeView) view.findViewById(R.h.exdevice_likeview);
            bVar.iEY = view.findViewById(R.h.dividerV);
            bVar.iFa = view.findViewById(R.h.exdevice_user_name_score_layout);
            bVar.iEZ = view.findViewById(R.h.exdevice_avatar_layout);
            bVar.iFb = (TextView) view.findViewById(R.h.share_step_tv);
            if (bVar.iEU != null) {
                bVar.iEU.setTextSize(0, this.mContext.getResources().getDimension(R.f.ExdeviceRankInfoUserName));
                bVar.iEU.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_user_name));
                bVar.iEU.setSingleLine(true);
                bVar.iEU.setShouldEllipsize(true);
            }
            view.setTag(bVar);
        }
        if (!(dVar == null || bVar == null)) {
            if (this.gtX.equalsIgnoreCase(dVar.field_username)) {
                this.iEM = true;
            } else {
                this.iEM = false;
            }
            if (itemViewType == 2) {
                bVar.ivW.setText(String.valueOf(dVar.field_ranknum));
                bVar.iEW.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.n(bVar.iET, dVar.field_username);
                bVar.ern.setOnClickListener(this.iEP);
                bVar.iFb.setOnClickListener(this.iEQ);
            } else {
                if (bVar.iEV != null) {
                    if ((i2 & 4) != 4) {
                        bVar.iEV.setVisibility(0);
                        bVar.iEV.setText(this.mContext.getResources().getString(R.l.exdevice_rank_my_ranking, new Object[]{Integer.valueOf(dVar.field_ranknum)}));
                    } else {
                        bVar.iEV.setVisibility(8);
                    }
                }
                if ((i2 & 2) == 2 || !dVar.field_username.equalsIgnoreCase(this.iEJ) || this.gtX.equalsIgnoreCase(this.iEJ)) {
                    bVar.hrk.setBackgroundColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_info_bg));
                } else {
                    bVar.hrk.setBackgroundColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_info_hight_user_bg));
                }
                if ((i2 & 1) == 1) {
                    bVar.iEY.setVisibility(8);
                } else {
                    bVar.iEY.setVisibility(0);
                }
                if (dVar.field_ranknum >= 100) {
                    bVar.ivW.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.ExdeviceRankNumberOverFontSize));
                } else {
                    bVar.ivW.setTextSize(0, (float) this.mContext.getResources().getDimensionPixelSize(R.f.ExdeviceRankNumberFontSize));
                }
                if ((i2 & 2) == 2) {
                    bVar.ivW.setText("");
                } else {
                    bVar.ivW.setText(dVar.field_ranknum);
                }
                if (dVar.field_score >= 10000) {
                    bVar.iEW.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_up_step));
                } else {
                    bVar.iEW.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_step));
                }
                bVar.iEW.setText(String.valueOf(dVar.field_score));
                com.tencent.mm.pluginsdk.ui.a.b.n(bVar.iET, dVar.field_username);
                if (!this.iEM) {
                    au.HU();
                    if (!(com.tencent.mm.model.c.FR().Yc(dVar.field_username) || this.iEI == null || bi.oW((String) this.iEI.get(dVar.field_username)))) {
                        bVar.iEU.setText(j.a(this.mContext, (CharSequence) this.iEI.get(dVar.field_username), bVar.iEU.getTextSize()));
                        bVar.iEX.setLikeNum(dVar.field_likecount);
                        if (this.iEM) {
                            bVar.iEX.setSelfLikeState(dVar.field_selfLikeState);
                        } else if (dVar.field_likecount != 0) {
                            bVar.iEX.setSelfLikeState(1);
                        } else {
                            bVar.iEX.setSelfLikeState(0);
                        }
                        if (dVar.field_score <= 0 || this.iEM) {
                            bVar.iEX.setClickable(true);
                            bVar.iEX.setOnLikeViewClickListener(new 1(this, dVar));
                        } else {
                            bVar.iEX.setClickable(false);
                        }
                        bVar.iEZ.setTag(Integer.valueOf(i));
                        bVar.iEZ.setOnClickListener(this.iEO);
                        bVar.iFa.setTag(Integer.valueOf(i));
                        bVar.iFa.setOnClickListener(this.iEO);
                    }
                }
                bVar.iEU.setText(j.a(this.mContext, r.gT(dVar.field_username), bVar.iEU.getTextSize()));
                bVar.iEX.setLikeNum(dVar.field_likecount);
                if (this.iEM) {
                    bVar.iEX.setSelfLikeState(dVar.field_selfLikeState);
                } else if (dVar.field_likecount != 0) {
                    bVar.iEX.setSelfLikeState(1);
                } else {
                    bVar.iEX.setSelfLikeState(0);
                }
                if (dVar.field_score <= 0) {
                }
                bVar.iEX.setClickable(true);
                bVar.iEX.setOnLikeViewClickListener(new 1(this, dVar));
                bVar.iEZ.setTag(Integer.valueOf(i));
                bVar.iEZ.setOnClickListener(this.iEO);
                bVar.iFa.setTag(Integer.valueOf(i));
                bVar.iFa.setOnClickListener(this.iEO);
            }
        }
        return view;
    }
}
