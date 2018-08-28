package com.tencent.mm.ui.appbrand;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.modelappbrand.b.b$h;
import com.tencent.mm.plugin.appbrand.q.k;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.ak;
import com.tencent.mm.ui.base.o;

public final class c implements b$h {
    private ImageView bRk = null;
    private ProgressBar bRm = null;
    private Bitmap bitmap = null;
    private View contentView = null;
    private Context context;
    private View kHl;
    private View nHH;
    private TextView oan = null;
    private TextView oao = null;
    o qMQ;
    public boolean qMR = true;
    private long trh = 10000;
    private ImageView tri = null;
    private String trj = null;
    private boolean trk = false;
    private boolean trl = false;
    public a trm;
    ag trn = null;

    public interface a {
        void cra();
    }

    static /* synthetic */ void a(c cVar) {
        if (cVar.bRk == null || cVar.qMQ == null || cVar.nHH == null || cVar.kHl == null) {
            x.e("MicroMsg.AppBrandServiceImageBubble", "these references include null reference");
            return;
        }
        int i;
        if (cVar.bitmap != null) {
            x.d("MicroMsg.AppBrandServiceImageBubble", "bitmap is null,return");
            i = 1;
        } else {
            boolean i2 = false;
        }
        if (i2 == 0) {
            cVar.Kc();
        } else {
            cVar.n(cVar.bitmap);
        }
        i2 = cVar.qMR ? 83 : 85;
        int i3 = cVar.qMR ? 0 : 10;
        int fA = j.fA(cVar.context);
        int height = cVar.kHl.getHeight();
        if (cVar.trl && height < fA) {
            height += fA;
        }
        if (VERSION.SDK_INT >= 21) {
            Rect cqU = ak.cqU();
            i3 = cVar.qMR ? 0 : i3 + cqU.right;
            height += cqU.bottom;
            x.i("MicroMsg.AppBrandServiceImageBubble", "bubble navbar height %s %s", new Object[]{Integer.valueOf(cqU.right), Integer.valueOf(cqU.bottom)});
        }
        cVar.qMQ.showAtLocation(cVar.nHH, i2, i3, height);
        if (cVar.trh > 0) {
            al alVar = new al(new 3(cVar), false);
            long j = cVar.trh;
            alVar.J(j, j);
        }
    }

    public final void Kc() {
        x.d("MicroMsg.AppBrandServiceImageBubble", "beforeLoadBitmap");
        this.bRm.setVisibility(0);
        this.bRk.setVisibility(8);
        this.tri.setVisibility(8);
    }

    public final void n(Bitmap bitmap) {
        x.d("MicroMsg.AppBrandServiceImageBubble", "onBitmapLoaded");
        if (bitmap == null) {
            x.w("MicroMsg.AppBrandServiceImageBubble", "bitmap is null");
            return;
        }
        this.bitmap = bitmap;
        this.bRm.setVisibility(8);
        if (bitmap == null || bitmap.isRecycled()) {
            this.tri.setVisibility(0);
            this.bRk.setVisibility(8);
            return;
        }
        this.bRk.setVisibility(0);
        this.bRk.setImageBitmap(bitmap);
        this.tri.setVisibility(8);
    }

    public final void Kd() {
        x.i("MicroMsg.AppBrandServiceImageBubble", "onLoadFailed");
        this.tri.setVisibility(0);
        this.bRm.setVisibility(8);
        this.bRk.setVisibility(8);
    }

    public final String Ke() {
        return k.bq(this);
    }

    public c(Context context, View view, View view2, boolean z) {
        this.context = context;
        this.nHH = view;
        this.kHl = view2;
        this.trl = z;
        this.contentView = View.inflate(this.context, R.i.chatting_footer_app_brand_image_bubble, null);
        this.oan = (TextView) this.contentView.findViewById(R.h.image_tv_1);
        this.oao = (TextView) this.contentView.findViewById(R.h.image_tv_2);
        this.bRk = (ImageView) this.contentView.findViewById(R.h.image_iv);
        this.tri = (ImageView) this.contentView.findViewById(R.h.error_iv);
        this.bRm = (ProgressBar) this.contentView.findViewById(R.h.image_pb);
        this.qMQ = new o(this.contentView, -2, -2, true);
        this.qMQ.setBackgroundDrawable(new ColorDrawable(0));
        this.qMQ.setOutsideTouchable(true);
        this.qMQ.setFocusable(false);
        this.contentView.setOnClickListener(new 1(this));
        this.trn = new 2(this, this.context.getMainLooper());
    }
}
