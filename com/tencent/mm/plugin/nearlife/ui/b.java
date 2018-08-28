package com.tencent.mm.plugin.nearlife.ui;

import android.content.Context;
import android.text.Spannable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.nearlife.b.a;
import com.tencent.mm.protocal.c.aqq;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.HashMap;

public final class b extends a {
    a lDJ;
    private a lDK;
    String lDL;
    private HashMap<String, Integer> lDM;

    public b(Context context, OnClickListener onClickListener, String str, boolean z) {
        super(context, onClickListener, str, z);
        this.lDM = new HashMap();
        this.lDK = new a("", new aqq());
        this.lDK.lCG = "NotCheckIn";
        this.lDK.bHD = context.getString(R.l.near_life_no_display);
        this.lDM.put(this.lDK.lCG, Integer.valueOf(2));
        if (!z) {
            a(this.lDK, 0);
            notifyDataSetChanged();
        }
    }

    public final a dW(String str, String str2) {
        if (this.lDJ == null) {
            this.lDJ = new a("", new aqq());
            this.lDJ.lCG = "City";
            this.lDM.put(this.lDJ.lCG, Integer.valueOf(1));
            a(this.lDJ, 1);
        }
        this.lDJ.bHD = str;
        this.lDJ.kJG = str2;
        notifyDataSetChanged();
        return this.lDJ;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        int intValue;
        if (view == null) {
            aVar = new a(this);
            view = View.inflate(this.mContext, R.i.near_life_item, null);
            aVar.eBO = (TextView) view.findViewById(R.h.life_item_title);
            aVar.kxd = (TextView) view.findViewById(R.h.life_item_price);
            aVar.fAK = (TextView) view.findViewById(R.h.life_item_desc);
            aVar.lDO = (LinearLayout) view.findViewById(R.h.root_content);
            aVar.lDP = (ImageView) view.findViewById(R.h.select_iv);
            aVar.lDO.setOnClickListener(this.iZP);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        a tU = tU(i);
        if (this.lDM.containsKey(tU.lCG)) {
            intValue = ((Integer) this.lDM.get(tU.lCG)).intValue();
        } else {
            intValue = 0;
        }
        aVar.lDP.setVisibility(8);
        aVar.type = intValue;
        aVar.lDN = tU;
        if (!bi.oW(this.lDL) && this.lDL.equals(tU.lCG)) {
            aVar.lDP.setVisibility(0);
        }
        switch (intValue) {
            case 0:
                aVar.eBO.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.fAK.setVisibility(0);
                break;
            case 1:
                aVar.eBO.setTextColor(this.mContext.getResources().getColor(R.e.black));
                aVar.fAK.setVisibility(8);
                break;
            case 2:
                aVar.fAK.setVisibility(8);
                aVar.eBO.setTextColor(this.mContext.getResources().getColor(R.e.sns_link_color));
                if (bi.oW(this.lDL)) {
                    aVar.lDP.setVisibility(0);
                    break;
                }
                break;
        }
        aVar.position = i;
        aVar.lCG = tU.lCG;
        if (this.lCX) {
            aVar.eBO.setText(FY(tU.bHD));
            aVar.fAK.setText(FY(bC(tU.lCL)));
        } else {
            aVar.eBO.setText(tU.bHD);
            aVar.fAK.setText(bC(tU.lCL));
        }
        aVar.kxd.setVisibility(8);
        return view;
    }

    private Spannable FY(String str) {
        return f.a(str, this.lCT);
    }
}
