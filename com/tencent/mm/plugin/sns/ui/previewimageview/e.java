package com.tencent.mm.plugin.sns.ui.previewimageview;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.i$f;
import com.tencent.mm.plugin.sns.i$i;
import com.tencent.mm.plugin.sns.i.d;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.s;
import com.tencent.mm.plugin.sns.ui.w;
import com.tencent.mm.plugin.sns.ui.w.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class e implements w {
    private Context context;
    TextView nNC;
    private ImageView nZa;
    a olA;
    float olB;
    View olC;
    ImageView olD;
    private View olE;
    private View olF;
    private int olG;
    Rect olH;
    private boolean olx;
    c oly;
    DynamicGridView olz;

    static /* synthetic */ void a(e eVar) {
        eVar.olE.setVisibility(8);
        ad.chZ().edit().putBoolean("key_show_tips", false).commit();
    }

    static /* synthetic */ void b(e eVar) {
        eVar.olC.setBackgroundColor(Color.parseColor("#e64340"));
        eVar.olD.setImageResource(i$i.sns_img_delete);
        eVar.nNC.setText("拖动到此处删除");
    }

    public e(View view, View view2, View view3, Context context, List<String> list, DynamicGridView dynamicGridView, a aVar, c.a aVar2, boolean z) {
        this.olx = z;
        this.context = context;
        this.olA = aVar;
        this.olC = view2;
        this.olE = view3;
        this.olz = dynamicGridView;
        this.olD = (ImageView) view2.findViewById(i$f.del_img);
        this.nNC = (TextView) view2.findViewById(i$f.del_tv);
        this.olF = view;
        dynamicGridView.setWobbleInEditMode(false);
        af.byd();
        this.olG = ((s.getScreenWidth() - (context.getResources().getDimensionPixelSize(d.sns_upload_previewimg_view_margin) * 4)) - (context.getResources().getDimensionPixelSize(d.LargerPadding) * 2)) / 3;
        dynamicGridView.setColumnWidth(this.olG + (context.getResources().getDimensionPixelSize(d.sns_upload_previewimg_view_margin) * 2));
        dynamicGridView.setNumColumns(3);
        dynamicGridView.setOverScrollMode(2);
        dynamicGridView.setStretchMode(0);
        dynamicGridView.setClipChildren(false);
        dynamicGridView.setClipToPadding(false);
        dynamicGridView.setSelector(new ColorDrawable(0));
        this.oly = new c(context, list, z, aVar2);
        bEL();
        dynamicGridView.setAdapter(this.oly);
        dynamicGridView.setOnDragListener(new 1(this, dynamicGridView));
        dynamicGridView.setOnItemLongClickListener(new 2(this));
        dynamicGridView.setOnItemClickListener(new 3(this));
        dynamicGridView.setOnDropListener(new 4(this, dynamicGridView, view));
        dynamicGridView.getViewTreeObserver().addOnPreDrawListener(new 5(this, dynamicGridView, list));
        af.byd();
        if (s.getScreenWidth() == 0) {
            new ag().postDelayed(new 6(this, list), 50);
        }
    }

    public final void xH(int i) {
        int i2 = 3;
        af.byd();
        this.olG = ((s.getScreenWidth() - (this.context.getResources().getDimensionPixelSize(d.sns_upload_previewimg_view_margin) * 4)) - (this.context.getResources().getDimensionPixelSize(d.LargerPadding) * 2)) / 3;
        this.olz.setColumnWidth(this.olG + (this.context.getResources().getDimensionPixelSize(d.sns_upload_previewimg_view_margin) * 2));
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.olz.getLayoutParams();
        Object[] objArr = new Object[1];
        af.byd();
        objArr[0] = Integer.valueOf(s.getScreenWidth());
        x.i("DynamicGrid", "setGridViewMargins margin: screenWith:%d", objArr);
        int i3 = (i + 3) / 3;
        if (i3 <= 3) {
            i2 = i3;
        }
        marginLayoutParams.setMargins(marginLayoutParams.leftMargin, (this.olF.getHeight() - this.olG) - (this.context.getResources().getDimensionPixelSize(d.sns_upload_previewimg_view_margin) * 2), marginLayoutParams.rightMargin, (int) (((float) (4 - i2)) * (c.chu().density * 32.0f)));
        this.olz.setLayoutParams(marginLayoutParams);
    }

    private void bEL() {
        if (!ad.chZ().getBoolean("key_show_tips", true) || this.oly.bEK() <= 1) {
            this.olE.setVisibility(8);
            return;
        }
        this.olE.setVisibility(0);
        this.nZa = (ImageView) this.olE.findViewById(i$f.sns_img_close_iv);
        this.nZa.setOnClickListener(new 7(this));
    }

    public final void setIsShowAddImage(boolean z) {
        this.olx = z;
    }

    public final void setImageClick(a aVar) {
        this.olA = aVar;
    }

    public final View getView() {
        return this.olz;
    }

    public final void setList$22875ea3(List<String> list) {
        if (this.oly != null) {
            this.oly.cu(list);
            bEL();
        }
    }

    public final void clean() {
        if (this.olz != null && this.olz.getAdapter() == null) {
            ((c) this.olz.getAdapter()).nQt = true;
        }
    }
}
