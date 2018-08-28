package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.e.f;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.c.cch;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.h;
import java.util.List;

class IPCallPackageUI$a extends BaseAdapter {
    List<cch> jWl = null;
    private IPCallPackageUI kwY = null;

    public IPCallPackageUI$a(IPCallPackageUI iPCallPackageUI) {
        this.kwY = iPCallPackageUI;
    }

    public final int getCount() {
        return this.jWl == null ? 0 : this.jWl.size();
    }

    public final Object getItem(int i) {
        if (this.jWl != null) {
            return this.jWl.get(i);
        }
        return null;
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = ((LayoutInflater) this.kwY.getSystemService("layout_inflater")).inflate(R.i.ipcall_package_item, viewGroup, false);
            aVar = new a(this, (byte) 0);
            aVar.kxc = (CdnImageView) view.findViewById(R.h.package_image_iv);
            aVar.eHU = (TextView) view.findViewById(R.h.package_name_tv);
            aVar.kxd = (TextView) view.findViewById(R.h.package_price_tv);
            aVar.kxe = (TextView) view.findViewById(R.h.package_count_tv);
            aVar.fAK = (TextView) view.findViewById(R.h.package_desc_tv);
            aVar.kxf = (Button) view.findViewById(R.h.package_buy_btn);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        cch cch = (cch) getItem(i);
        if (cch != null) {
            aVar.eHU.setText(cch.bHD);
            aVar.kxd.setText(cch.sdK);
            aVar.fAK.setText(cch.jOS);
            aVar.kxe.setText(cch.ksB);
            aVar.kxc.setVisibility(0);
            aVar.kxc.setUrl(cch.sym);
            if (cch.rbZ == 0) {
                aVar.kxf.setEnabled(true);
            } else {
                aVar.kxf.setEnabled(false);
            }
            aVar.kxf.setTag(Integer.valueOf(i));
            aVar.kxf.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    final cch cch = (cch) IPCallPackageUI$a.this.getItem(((Integer) view.getTag()).intValue());
                    if (cch == null || bi.oW(cch.rem)) {
                        x.e("MicroMsg.IPCallPackageUI", "buyBtnClick: proToBuy is null");
                        return;
                    }
                    IPCallPackageUI.b(IPCallPackageUI$a.this.kwY).start();
                    f b = IPCallPackageUI.b(IPCallPackageUI$a.this.kwY);
                    b.krS++;
                    IPCallPackageUI.b(IPCallPackageUI$a.this.kwY).krW = cch.rem;
                    h.a(IPCallPackageUI$a.this.kwY, IPCallPackageUI$a.this.kwY.getString(R.l.ipcall_purchase_confirm_desc, new Object[]{cch.sdK, cch.bHD}), IPCallPackageUI$a.this.kwY.getString(R.l.ipcall_purchase_confirm_title), IPCallPackageUI$a.this.kwY.getString(R.l.ipcall_purchase), IPCallPackageUI$a.this.kwY.getString(R.l.ipcall_purchase_cancel), false, new DialogInterface.OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            f b = IPCallPackageUI.b(IPCallPackageUI$a.this.kwY);
                            b.krT++;
                            IPCallPackageUI.a(IPCallPackageUI$a.this.kwY, cch.rem);
                        }
                    }, new 2(this));
                }
            });
        }
        return view;
    }
}
