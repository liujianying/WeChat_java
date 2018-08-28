package com.tencent.mm.wallet_core.ui;

import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMVerticalTextView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;

public final class c {
    public o eZB;
    private ImageView eZC;
    private View eZD;
    private OnClickListener eZF;
    private MMActivity gKS;
    public boolean hCn;
    private Bitmap hGf;
    private View hGi;
    private ImageView hGj;
    private MMVerticalTextView hGk;
    private ArrayList<Bitmap> hGm;
    private String lJi;
    private String lLI;
    public Bitmap lLl;
    public Bitmap lLm;
    ViewGroup uYK;
    private boolean uYL;

    public c(MMActivity mMActivity, boolean z) {
        this.lLl = null;
        this.lLm = null;
        this.hGf = null;
        this.lLI = "";
        this.lJi = "";
        this.hCn = true;
        this.hGm = new ArrayList();
        this.eZB = null;
        this.uYL = false;
        this.eZF = new OnClickListener() {
            public final void onClick(View view) {
                if ((view.getId() == f.popupwd_qrcode_iv || view.getId() == f.popupwd_barcode_iv) && c.this.eZB != null && c.this.eZB.isShowing()) {
                    c.this.eZB.dismiss();
                }
            }
        };
        this.gKS = mMActivity;
        this.uYL = z;
    }

    public c(MMActivity mMActivity) {
        this(mMActivity, false);
    }

    public final void gn(String str, String str2) {
        this.lLI = str;
        this.lJi = str2;
    }

    public final void init() {
        if (this.eZB == null) {
            View view;
            if (this.uYL) {
                View inflate = View.inflate(this.gKS, g.wallet_offline_new_popupwindow_layout, null);
                MMVerticalTextView mMVerticalTextView = (MMVerticalTextView) inflate.findViewById(f.mask_i_know_btn);
                this.uYK = (ViewGroup) inflate.findViewById(f.popupwd_mask_layout);
                mMVerticalTextView.setOnClickListener(new 2(this));
                inflate.findViewById(f.popupwd_content_layout).setOnClickListener(new 3(this));
                view = inflate;
            } else {
                View inflate2 = View.inflate(this.gKS, g.wallet_offline_popup_window, null);
                inflate2.setOnClickListener(new 4(this));
                view = inflate2;
            }
            this.eZD = view.findViewById(f.popupwd_qrcode_layout);
            this.eZC = (ImageView) view.findViewById(f.popupwd_qrcode_iv);
            this.hGi = view.findViewById(f.popupwd_barcode_layout);
            this.hGj = (ImageView) view.findViewById(f.popupwd_barcode_iv);
            this.hGk = (MMVerticalTextView) view.findViewById(f.vertical_barcode_text);
            this.eZB = new o(view, -1, -1, true);
            this.eZB.setClippingEnabled(false);
            this.eZB.update();
            this.eZB.setBackgroundDrawable(new ColorDrawable(16777215));
            this.eZB.setOnDismissListener(new 5(this));
        }
    }

    public final void release() {
        if (this.eZB != null && this.eZB.isShowing()) {
            this.eZB.dismiss();
        }
        e.x(this.hGf);
        e.ai(this.hGm);
        this.hGm.clear();
        this.gKS = null;
    }

    public final void v(View view, boolean z) {
        this.hCn = z;
        if (this.eZB != null && !this.eZB.isShowing()) {
            this.eZB.showAtLocation(view.getRootView(), 17, 0, 0);
            this.eZB.setFocusable(true);
            this.eZB.setTouchable(true);
            this.eZB.setBackgroundDrawable(new ColorDrawable(16777215));
            this.eZB.setOutsideTouchable(true);
            if (this.hCn) {
                cDF();
            }
            cDG();
        }
    }

    public final void cDE() {
        if (this.eZB != null && this.eZB.isShowing()) {
            cDG();
        }
    }

    public final void cDF() {
        if (this.uYK != null) {
            this.uYK.setVisibility(0);
        }
    }

    private void cDG() {
        if (this.hCn) {
            this.hGj.setOnClickListener(this.eZF);
            Bitmap bitmap = this.hGf;
            if (this.lLm != null) {
                this.hGf = e.w(this.lLm);
                x.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp != null");
            } else {
                this.hGf = null;
                x.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mRoateBmp == null");
            }
            this.hGj.setImageBitmap(this.hGf);
            this.hGm.add(0, bitmap);
            if (this.hGm.size() >= 2) {
                int size = this.hGm.size() - 1;
                while (true) {
                    int i = size;
                    if (i <= 1) {
                        break;
                    }
                    e.x((Bitmap) this.hGm.remove(i));
                    size = i - 1;
                }
            }
            this.eZD.setVisibility(8);
            this.hGi.setVisibility(0);
            this.hGk.setText(e.ace(this.lJi));
        } else {
            this.eZC.setOnClickListener(this.eZF);
            this.eZC.setImageBitmap(this.lLl);
            if (this.lLl != null) {
                x.e("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp != null");
            } else {
                x.i("MicroMsg.OfflinePopupWindow", "updatePopWindowContent mQRCodeBmp == null");
            }
            this.eZD.setVisibility(0);
            this.hGi.setVisibility(8);
        }
        this.eZB.update();
    }

    public final void dismiss() {
        if (this.eZB != null && this.eZB.isShowing()) {
            this.eZB.dismiss();
        }
    }
}
