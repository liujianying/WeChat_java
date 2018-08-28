package com.tencent.mm.plugin.exdevice.model;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.e;
import com.tencent.mm.ac.z;
import com.tencent.mm.an.c;
import com.tencent.mm.bp.a;
import com.tencent.mm.g.a.ot;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.base.h;
import java.io.File;
import java.io.IOException;
import java.util.List;

public final class ac {
    private Context context;
    boolean dJO;
    private View ivV;
    private TextView ivW;
    private TextView ivX;
    private TextView ivY;
    private TextView ivZ;
    private View iwa;
    boolean iwb;
    Dialog iwc;
    private int width;

    public static final String dc(Context context) {
        return new File(context.getCacheDir(), "sport_share_bitmap.jpg").getAbsolutePath();
    }

    public final void a(Context context, String str, String str2, String str3, a aVar) {
        if (!this.iwb) {
            this.iwb = true;
            this.dJO = false;
            if (this.iwc == null && !bi.oW(str3)) {
                context.getString(R.l.app_tip);
                this.iwc = h.a(context, context.getString(R.l.exdevice_sport_downloading_cover), true, new 1(this));
                this.iwc.show();
            }
            this.context = context;
            this.width = 1280;
            if (this.width > a.fk(context)) {
                this.width = a.fk(context);
            }
            this.ivV = LayoutInflater.from(context).inflate(R.i.exdevice_share_view, null);
            this.ivW = (TextView) this.ivV.findViewById(R.h.exdevice_rank_tv);
            this.ivX = (TextView) this.ivV.findViewById(R.h.exdevice_rank_info_tv);
            this.ivY = (TextView) this.ivV.findViewById(R.h.exdevice_user_score_tv);
            this.ivZ = (TextView) this.ivV.findViewById(R.h.exdevice_user_score_info_tv);
            this.iwa = this.ivV.findViewById(R.h.bg_mask);
            this.ivW.setText(str);
            this.ivY.setText(str2);
            b.a((ImageView) this.ivV.findViewById(R.h.avatarIV), q.GF(), 0.5f, false);
            ImageView imageView = (ImageView) this.ivV.findViewById(R.h.bgIV);
            this.ivV.setLayoutParams(new LayoutParams(-1, -1));
            this.ivV.measure(MeasureSpec.makeMeasureSpec(this.width, 1073741824), MeasureSpec.makeMeasureSpec(this.width, 1073741824));
            this.ivV.layout(0, 0, this.width, this.width);
            if (bi.oW(str3)) {
                imageView.setImageResource(R.e.darkgrey);
                aVar.zZ(y(null));
                this.iwb = false;
                return;
            }
            ad.aHh().a(str3, imageView, new 2(this, aVar));
        }
    }

    final String y(Bitmap bitmap) {
        int[] s;
        if (bitmap != null) {
            s = c.s(bitmap);
        } else {
            s = new int[]{-1, -16777216};
        }
        3 3 = new 3(this, s);
        Drawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(3);
        this.iwa.setBackgroundDrawable(paintDrawable);
        this.ivW.setTextColor(s[1]);
        this.ivX.setTextColor(s[1]);
        this.ivY.setTextColor(s[1]);
        this.ivZ.setTextColor(s[1]);
        Bitmap createBitmap = Bitmap.createBitmap(this.width, this.width, Config.ARGB_8888);
        this.ivV.draw(new Canvas(createBitmap));
        File file = new File(dc(this.context));
        if (file.exists()) {
            file.delete();
        }
        try {
            com.tencent.mm.sdk.platformtools.c.a(createBitmap, 100, CompressFormat.JPEG, file.getAbsolutePath(), true);
        } catch (IOException e) {
        }
        return file.getAbsolutePath();
    }

    public static boolean a(Context context, String str, String str2, String str3, String str4) {
        z.MY();
        List MG = e.MG();
        String str5 = MG.size() > 0 ? (String) MG.get(0) : null;
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(str2);
        String gT = r.gT(str5);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.title = gT;
        wXMediaMessage.description = str4;
        wXMediaMessage.setThumbImage(com.tencent.mm.sdk.platformtools.c.decodeFile(str2, null));
        ot otVar = new ot();
        otVar.bZE.bSg = wXMediaMessage;
        otVar.bZE.appId = "wx7fa037cc7dfabad5";
        otVar.bZE.appName = context.getString(R.l.exdevice_wechat_sport);
        otVar.bZE.toUser = str;
        otVar.bZE.bZF = 2;
        if (bi.oW(str5)) {
            otVar.bZE.bZI = null;
        } else {
            otVar.bZE.bZG = str5;
            otVar.bZE.bZH = gT;
        }
        boolean m = com.tencent.mm.sdk.b.a.sFg.m(otVar);
        if (!bi.oW(str3)) {
            ow owVar = new ow();
            owVar.bZQ.bZR = str;
            owVar.bZQ.content = str3;
            owVar.bZQ.type = s.hQ(str);
            owVar.bZQ.flags = 0;
            com.tencent.mm.sdk.b.a.sFg.m(owVar);
        }
        return m;
    }
}
