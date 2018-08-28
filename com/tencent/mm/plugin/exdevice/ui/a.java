package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.exdevice.f.a.e;
import com.tencent.mm.plugin.exdevice.f.b.a.c;
import com.tencent.mm.plugin.exdevice.model.f;
import com.tencent.mm.plugin.sport.b.d;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.protocal.c.kc;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.List;

final class a extends BaseAdapter {
    String gtX;
    ArrayList<c> iDA;
    List<kc> iDB;
    private View iDC;
    c iDv;
    private boolean iDw;
    boolean iDx;
    int iDy;
    int iDz;
    private String mAppName;
    private Context mContext;

    public a(Context context, String str, boolean z, String str2) {
        this.mContext = context;
        this.gtX = str2;
        this.iDw = z;
        this.mAppName = str;
    }

    public final int getCount() {
        if (this.iDw) {
            return (this.iDy + 5) + this.iDz;
        }
        return 2;
    }

    public final int getViewTypeCount() {
        return 8;
    }

    public final Object getItem(int i) {
        return Integer.valueOf(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final int getItemViewType(int i) {
        if (this.iDw) {
            if (i == 0) {
                return 0;
            }
            if (i == 1) {
                return 6;
            }
            if (i > 1 && i <= this.iDy + 1) {
                return 1;
            }
            if (i == this.iDy + 2) {
                return 2;
            }
            if (i == this.iDy + 3) {
                return 5;
            }
            if (i <= this.iDy + 3 || i > (this.iDy + 3) + this.iDz) {
                return i == (this.iDy + this.iDz) + 4 ? 7 : 5;
            } else {
                return 3;
            }
        } else if (i == 0) {
            return 0;
        } else {
            return 4;
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        b bVar2;
        c cVar;
        a aVar;
        d dVar;
        e eVar;
        f fVar;
        int itemViewType = getItemViewType(i);
        if (view != null) {
            switch (itemViewType) {
                case 0:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = (f) view.getTag();
                    break;
                case 1:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = (e) view.getTag();
                    fVar = null;
                    break;
                case 2:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = (a) view.getTag();
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 3:
                    bVar = null;
                    bVar2 = null;
                    cVar = (c) view.getTag();
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 4:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = (d) view.getTag();
                    eVar = null;
                    fVar = null;
                    break;
                case 5:
                    view.getTag();
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 6:
                    bVar = null;
                    bVar2 = (b) view.getTag();
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                case 7:
                    bVar = (b) view.getTag();
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
                default:
                    bVar = null;
                    bVar2 = null;
                    cVar = null;
                    aVar = null;
                    dVar = null;
                    eVar = null;
                    fVar = null;
                    break;
            }
        }
        switch (itemViewType) {
            case 0:
                if (this.iDC == null) {
                    this.iDC = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_item, viewGroup, false);
                }
                view = this.iDC;
                fVar = new f(this);
                fVar.hVP = (ImageView) view.findViewById(R.h.exdevice_my_avatar);
                view.setTag(fVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                break;
            case 1:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_followers_view, viewGroup, false);
                eVar = new e(this);
                eVar.iDJ = (NoMeasuredTextView) view.findViewById(R.h.exdevice_profile_followers_user_name);
                eVar.iDK = (TextView) view.findViewById(R.h.exdevice_profile_followers_user_score);
                eVar.hVP = (ImageView) view.findViewById(R.h.exdevice_profile_followers_avatar);
                eVar.iDF = view.findViewById(R.h.exdevice_profile_followers_item_content);
                eVar.iDJ.setTextSize(0, this.mContext.getResources().getDimension(R.f.ExdeviceRankInfoUserName));
                eVar.iDJ.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_user_name));
                eVar.iDJ.setSingleLine(true);
                eVar.iDJ.setShouldEllipsize(true);
                view.setTag(eVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                fVar = null;
                break;
            case 2:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_add_donate_item, viewGroup, false);
                aVar = new a(this);
                aVar.iDE = (TextView) view.findViewById(R.h.exdevice_profile_add_donate_title);
                aVar.iDF = view.findViewById(R.h.exdevice_profile_add_donate_item_content);
                aVar.iAC = (ImageView) view.findViewById(R.h.exdevice_profile_add_donate_logo);
                view.setTag(aVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 3:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_add_donate_item, viewGroup, false);
                cVar = new c(this);
                cVar.iDE = (TextView) view.findViewById(R.h.exdevice_profile_add_donate_title);
                cVar.iDF = view.findViewById(R.h.exdevice_profile_add_donate_item_content);
                cVar.iAC = (ImageView) view.findViewById(R.h.exdevice_profile_add_donate_logo);
                cVar.iDH = view.findViewById(R.h.exdevice_profile_add_donate_dividerV);
                view.setTag(cVar);
                bVar = null;
                bVar2 = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 4:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_follow_btn, viewGroup, false);
                dVar = new d(this);
                dVar.iDI = (Button) view.findViewById(R.h.exdevice_profile_follow_btn);
                view.setTag(dVar);
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                eVar = null;
                fVar = null;
                break;
            case 5:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_divider_item, viewGroup, false);
                view.setTag(new b(this));
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 6:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_divider_item, viewGroup, false);
                bVar2 = new b(this);
                bVar2.iDE = (TextView) view.findViewById(R.h.exdevice_profile_divider_title);
                view.setTag(bVar2);
                bVar = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            case 7:
                view = LayoutInflater.from(this.mContext).inflate(R.i.exdevice_profile_divider_item, viewGroup, false);
                b bVar3 = new b(this);
                bVar3.iDG = view.findViewById(R.h.exdevice_profile_divider_size);
                view.setTag(bVar3);
                bVar = bVar3;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
            default:
                bVar = null;
                bVar2 = null;
                cVar = null;
                aVar = null;
                dVar = null;
                eVar = null;
                fVar = null;
                break;
        }
        String str;
        switch (itemViewType) {
            case 0:
                b.o(fVar.hVP, this.gtX);
                fVar.hVP.setOnClickListener(new 1(this));
                break;
            case 1:
                if (i - 2 >= 0 && !bi.cX(this.iDA)) {
                    c cVar2 = (c) this.iDA.get(i - 2);
                    if (cVar2 != null) {
                        int i2 = cVar2.field_step;
                        str = cVar2.field_username;
                        if (cVar2.field_step >= 10000) {
                            eVar.iDK.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_up_step));
                        } else {
                            eVar.iDK.setTextColor(this.mContext.getResources().getColor(R.e.exdevice_step_rank_step));
                        }
                        eVar.iDJ.setText(j.a(this.mContext, r.gT(str), eVar.iDJ.getTextSize()));
                        eVar.iDK.setText(String.valueOf(i2));
                        b.n(eVar.hVP, str);
                        eVar.iDF.setOnClickListener(new 2(this, str));
                        break;
                    }
                }
                break;
            case 2:
                aVar.iDE.setText(this.mContext.getResources().getText(R.l.exdevice_profile_add));
                aVar.iAC.setImageResource(R.k.device_profile_ui_add_followers_logo);
                aVar.iDF.setOnClickListener(new 3(this));
                break;
            case 3:
                if ((i - this.iDy) - 4 >= 0 && !bi.cX(this.iDB)) {
                    kc kcVar = (kc) this.iDB.get((i - this.iDy) - 4);
                    if (kcVar != null) {
                        CharSequence charSequence = kcVar.title;
                        str = kcVar.bWP;
                        final String str2 = kcVar.url;
                        cVar.iDE.setText(charSequence);
                        if ((i - this.iDy) - 4 != this.iDz - 1) {
                            cVar.iDH.setVisibility(0);
                        }
                        e.a(this.mContext, cVar.iAC, str, R.e.darkgrey);
                        cVar.iDF.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                d.kB(8);
                                f.ae(a.this.mContext, str2);
                            }
                        });
                        break;
                    }
                }
                break;
            case 4:
                if (!this.iDx) {
                    au.HU();
                    if (com.tencent.mm.model.c.FR().Yc(this.gtX)) {
                        dVar.iDI.setVisibility(0);
                        dVar.iDI.setOnClickListener(new 5(this));
                        break;
                    }
                }
                dVar.iDI.setVisibility(4);
                break;
            case 6:
                bVar2.iDE.setText(this.mContext.getString(R.l.exdevice_profile_followers));
                break;
            case 7:
                bVar.iDG.setVisibility(0);
                break;
        }
        return view;
    }
}
