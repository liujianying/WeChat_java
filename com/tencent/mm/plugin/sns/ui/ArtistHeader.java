package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.plugin.sns.i.k;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.protocal.c.ate;
import com.tencent.mm.protocal.c.dx;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.av;
import com.tencent.mm.ui.base.i;

public class ArtistHeader extends LinearLayout implements b {
    private Context context = null;
    private View gFD;
    private i jhc = null;
    private dx nKZ = null;
    private b nLd;
    private ImageView nLe;
    private ProgressBar nLf;

    public ArtistHeader(Context context) {
        super(context);
        init(context);
    }

    public ArtistHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        View inflate = LayoutInflater.from(context).inflate(g.sns_artist_header, this, true);
        this.context = context;
        this.nLd = new b(this);
        this.nLd.eBM = (ImageView) inflate.findViewById(f.artist_avatar);
        this.nLd.fAK = (TextView) inflate.findViewById(f.a_desc);
        this.nLd.nLi = (TextView) inflate.findViewById(f.a_username);
        this.nLd.nLj = (TextView) inflate.findViewById(f.a_sign);
        this.nLd.eBO = (TextView) inflate.findViewById(f.a_title);
        this.nLd.eBM.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if ((ArtistHeader.this.jhc == null || !ArtistHeader.this.jhc.isShowing()) && ArtistHeader.this.nKZ != null) {
                    View inflate = LayoutInflater.from(ArtistHeader.this.getContext()).inflate(g.view_get_hd_avatar_dialogview, null);
                    ArtistHeader.this.jhc = new i(ArtistHeader.this.getContext(), k.mmAvatarDialog);
                    inflate.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            ArtistHeader.this.jhc.dismiss();
                        }
                    });
                    ArtistHeader.this.jhc.setCanceledOnTouchOutside(true);
                    ArtistHeader.this.jhc.setContentView(inflate);
                    ArtistHeader.this.jhc.show();
                    ArtistHeader.this.nLe = (ImageView) inflate.findViewById(f.hd_avatar_iv);
                    ArtistHeader.this.nLf = (ProgressBar) inflate.findViewById(f.hd_avatar_laoding_pb);
                    ArtistHeader.this.gFD = inflate.findViewById(f.hd_avatar_mask_view);
                }
            }
        });
    }

    public void setUserName(dx dxVar) {
        if (dxVar == null) {
            x.e("MicroMsg.ArtistHeader", "userName or selfName is null ");
            return;
        }
        this.nKZ = dxVar;
        af.byl().b(dxVar.rek.rel, this.nLd.eBM, this.context.hashCode(), av.tbu);
        this.nLd.nLi.setText(dxVar.jPe);
        this.nLd.fAK.setText(dxVar.rej);
        this.nLd.eBO.setText(dxVar.bHD);
        this.nLd.nLj.setText(dxVar.rei);
    }

    public void setBackClickListener(a aVar) {
    }

    public final void LR(String str) {
    }

    public final void aS(String str, boolean z) {
        if (this.nKZ != null && this.jhc != null && this.jhc.isShowing() && !z) {
            ate ate = this.nKZ.rek.rel;
            if (ate.ksA != null && ate.ksA.equals(str)) {
                Toast.makeText(this.context, this.context.getString(j.sns_down_error), 0).show();
            }
        }
    }

    public final void aT(String str, boolean z) {
    }

    public final void bxb() {
    }
}
