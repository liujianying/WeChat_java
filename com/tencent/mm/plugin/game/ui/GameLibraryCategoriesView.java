package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.ak.a.a.c;
import com.tencent.mm.ak.o;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.f.b;
import com.tencent.mm.plugin.game.f.e;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView extends LinearLayout implements OnClickListener {
    private int jNv;
    private int jZs;
    private int jZt;
    private LinearLayout jeZ;
    private Context mContext;

    public GameLibraryCategoriesView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        this.jeZ = (LinearLayout) findViewById(e.game_library_categories_container);
        int width = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
        this.jZs = (width * 100) / 750;
        this.jZt = (width - (this.jZs * 6)) / 14;
        this.jeZ.setPadding(this.jZt, a.fromDPToPix(this.mContext, 12), this.jZt, a.fromDPToPix(this.mContext, 12));
    }

    public void setSourceScene(int i) {
        this.jNv = i;
    }

    public void setData(LinkedList<a> linkedList) {
        if (linkedList == null || linkedList.size() == 0) {
            x.e("MicroMsg.GameLibraryCategoriesView", "No categories");
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jeZ.removeAllViews();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            View linearLayout = new LinearLayout(this.mContext);
            linearLayout.setOrientation(1);
            View imageView = new ImageView(this.mContext);
            ScaleType scaleType = ScaleType.MATRIX;
            imageView.setScaleType(ScaleType.FIT_XY);
            com.tencent.mm.ak.a.a Pj = o.Pj();
            String str = aVar.fmD;
            c.a aVar2 = new c.a();
            aVar2.dXx = true;
            Pj.a(str, imageView, aVar2.Pt());
            linearLayout.addView(imageView, this.jZs, this.jZs);
            imageView = new TextView(this.mContext);
            imageView.setText(aVar.jZv);
            imageView.setTextSize(1, 14.0f);
            imageView.setTextColor(getResources().getColor(b.hint_text_color));
            imageView.setSingleLine(true);
            imageView.setEllipsize(TruncateAt.END);
            imageView.setGravity(17);
            imageView.setLayoutParams(new LayoutParams(-1, -2));
            imageView.setPadding(0, a.fromDPToPix(this.mContext, 6), 0, 0);
            linearLayout.addView(imageView);
            linearLayout.setTag(aVar);
            linearLayout.setOnClickListener(this);
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(this.jZt, 0, this.jZt, 0);
            this.jeZ.addView(linearLayout, layoutParams);
        }
    }

    public void onClick(View view) {
        if (view.getTag() instanceof a) {
            a aVar = (a) view.getTag();
            int i = 7;
            if (bi.oW(aVar.jZw)) {
                Intent intent = new Intent(this.mContext, GameCategoryUI.class);
                intent.putExtra("extra_type", 1);
                intent.putExtra("extra_category_id", aVar.jZu);
                intent.putExtra("extra_category_name", aVar.jZv);
                intent.putExtra("game_report_from_scene", aVar.jZu + 100);
                this.mContext.startActivity(intent);
                i = 6;
            } else {
                com.tencent.mm.plugin.game.e.c.an(this.mContext, aVar.jZw);
            }
            an.a(this.mContext, 11, aVar.jZu + 100, aVar.position, i, this.jNv, null);
        }
    }
}
