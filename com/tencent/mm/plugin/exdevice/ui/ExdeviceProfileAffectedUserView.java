package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.ui.base.MMHorList;
import java.util.ArrayList;

public class ExdeviceProfileAffectedUserView extends LinearLayout {
    private String gtX;
    private TextView iDL;
    private MMHorList iDM;
    private a iDN = new a(this, (byte) 0);
    private ArrayList<String> iDO;

    public ExdeviceProfileAffectedUserView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.i.exdevice_profile_affected_user_view, this, true);
        this.iDL = (TextView) inflate.findViewById(R.h.profile_affected_tv);
        this.iDM = (MMHorList) inflate.findViewById(R.h.profile_affected_lv);
        this.iDM.setCenterInParent(true);
        int fromDPToPix = a.fromDPToPix(context, 44);
        this.iDM.setOverScrollEnabled(true);
        this.iDM.setItemWidth(fromDPToPix);
        this.iDM.setCenterInParent(true);
        this.iDM.setAdapter(this.iDN);
        this.iDM.setOnItemClickListener(new 1(this, context));
        this.iDL.setOnClickListener(new 2(this));
        setOnClickListener(new 3(this));
        setVisibility(8);
    }

    public void setUsername(String str) {
        this.gtX = str;
    }

    public void setAffectedUserInfo(ArrayList<String> arrayList) {
        this.iDO = arrayList;
        if (this.iDO == null || this.iDO.size() == 0) {
            this.iDL.setText("");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iDL.setText(getResources().getString(R.l.exdevice_profile_affect_wording, new Object[]{Integer.valueOf(this.iDO.size())}));
        this.iDN.notifyDataSetChanged();
    }
}
