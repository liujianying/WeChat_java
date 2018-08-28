package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ak.a.a.c.a;
import com.tencent.mm.ak.o;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.preference.Preference;

public class DeviceProfileHeaderPreference extends Preference {
    private String fNv;
    protected MMActivity fcq;
    String iAa;
    private String iAb;
    private boolean iAc;
    private ImageView izS;
    private TextView izT;
    private TextView izU;
    private TextView izV;
    private View izW;
    TextView izX;
    private boolean[] izY;
    private OnClickListener[] izZ;
    private CharSequence sT;

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.izY = new boolean[6];
        this.izZ = new OnClickListener[6];
        this.iAc = false;
        this.fcq = (MMActivity) context;
        this.iAc = false;
    }

    public DeviceProfileHeaderPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.izY = new boolean[6];
        this.izZ = new OnClickListener[6];
        this.iAc = false;
        this.fcq = (MMActivity) context;
        this.iAc = false;
    }

    public final void onBindView(View view) {
        x.d("MicroMsg.DeviceProfileHeaderPreference", "onBindView");
        this.izS = (ImageView) view.findViewById(R.h.avatarIV);
        this.izT = (TextView) view.findViewById(R.h.nameTV);
        this.izU = (TextView) view.findViewById(R.h.editRemarkTV);
        this.izV = (TextView) view.findViewById(R.h.deviceNameTV);
        this.izW = view.findViewById(R.h.editTV);
        this.izX = (TextView) view.findViewById(R.h.deviceDescTV);
        x(this.izS, 0);
        x(this.izT, 2);
        x(this.izU, 1);
        x(this.izV, 3);
        x(this.izW, 4);
        x(this.izX, 5);
        this.iAc = true;
        if (this.iAc) {
            this.izT.setText(this.sT);
            this.izV.setText(this.fNv);
            this.izX.setText(this.iAa);
            setIconUrl(this.iAb);
        } else {
            x.w("MicroMsg.DeviceProfileHeaderPreference", "initView : bindView = " + this.iAc);
        }
        super.onBindView(view);
    }

    private void x(View view, int i) {
        view.setVisibility(this.izY[i] ? 8 : 0);
        view.setOnClickListener(this.izZ[i]);
    }

    public final void H(int i, boolean z) {
        View view;
        boolean z2;
        int i2 = 0;
        switch (i) {
            case 0:
                view = this.izS;
                break;
            case 1:
                view = this.izU;
                break;
            case 2:
                view = this.izT;
                break;
            case 3:
                view = this.izV;
                break;
            case 4:
                view = this.izW;
                break;
            case 5:
                view = this.izX;
                break;
            default:
                return;
        }
        boolean[] zArr = this.izY;
        if (z) {
            z2 = false;
        } else {
            z2 = true;
        }
        zArr[i] = z2;
        if (view != null) {
            if (!z) {
                i2 = 8;
            }
            view.setVisibility(i2);
        }
    }

    public final void a(int i, OnClickListener onClickListener) {
        View view;
        switch (i) {
            case 0:
                view = this.izS;
                break;
            case 1:
                view = this.izU;
                break;
            case 2:
                view = this.izT;
                break;
            case 3:
                view = this.izV;
                break;
            case 4:
                view = this.izW;
                break;
            case 5:
                view = this.izX;
                break;
            default:
                return;
        }
        this.izZ[i] = onClickListener;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public final void setName(CharSequence charSequence) {
        this.sT = charSequence;
        if (this.izT != null) {
            this.izT.setText(charSequence);
        }
    }

    public final void Ao(String str) {
        this.fNv = str;
        if (this.izV != null) {
            this.izV.setText(str);
        }
    }

    public final void setIconUrl(String str) {
        this.iAb = str;
        if (this.izS != null) {
            a aVar = new a();
            Bitmap CV = c.CV(R.g.exdevice_my_device_default_icon);
            if (!(CV == null || CV.isRecycled())) {
                CV = c.a(CV, true, 0.5f * ((float) CV.getWidth()));
                if (!(CV == null || CV.isRecycled())) {
                    aVar.dXO = new BitmapDrawable(CV);
                }
            }
            if (CV == null || CV.isRecycled()) {
                aVar.dXN = R.g.exdevice_my_device_default_icon;
            }
            aVar.dXW = true;
            o.Pj().a(this.iAb, this.izS, aVar.Pt());
        }
    }
}
