package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.fts.ui.n.b;
import com.tencent.mm.protocal.c.bhr;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.LinkedList;
import java.util.List;

public class FTSLocalPageRelevantView extends LinearLayout implements OnClickListener {
    public String bWm = null;
    public String fuu = null;
    public RecyclerView gxh;
    private c jzF = null;
    public List<bhr> jzG = null;
    public b jzH;

    public interface c {
        void a(bhr bhr, String str, int i);
    }

    static /* synthetic */ void a(FTSLocalPageRelevantView fTSLocalPageRelevantView) {
        int dimensionPixelSize;
        fTSLocalPageRelevantView.setOrientation(1);
        fTSLocalPageRelevantView.setGravity(16);
        fTSLocalPageRelevantView.setVisibility(8);
        try {
            dimensionPixelSize = fTSLocalPageRelevantView.getResources().getDimensionPixelSize(b.FTSSmallListHeight);
        } catch (Exception e) {
            dimensionPixelSize = a.fromDPToPix(fTSLocalPageRelevantView.getContext(), 48);
        }
        fTSLocalPageRelevantView.setMinimumHeight(dimensionPixelSize);
        LayoutParams layoutParams = (LayoutParams) fTSLocalPageRelevantView.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -2;
        fTSLocalPageRelevantView.setLayoutParams(layoutParams);
    }

    public FTSLocalPageRelevantView(Context context) {
        super(context);
        post(new 1(this));
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FTSLocalPageRelevantView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setOnRelevantClickListener(c cVar) {
        this.jzF = cVar;
    }

    public void onClick(View view) {
        if (this.jzF != null && view.getTag() != null && (view.getTag() instanceof a)) {
            a aVar = (a) view.getTag();
            this.jzF.a(aVar.jzJ, this.fuu, aVar.position);
        }
    }

    public static List<bhr> bm(List<bhr> list) {
        List<bhr> linkedList = new LinkedList();
        for (bhr bhr : list) {
            if (!bi.oW(bhr.siy)) {
                linkedList.add(bhr);
            }
        }
        return linkedList;
    }

    public String getSearchId() {
        return this.fuu != null ? this.fuu : "";
    }

    public String getWordList() {
        StringBuilder stringBuilder = new StringBuilder("");
        if (this.jzG != null) {
            for (bhr bhr : this.jzG) {
                if (stringBuilder.length() > 0) {
                    stringBuilder.append("|");
                }
                stringBuilder.append(bhr.siy);
            }
        }
        return stringBuilder.toString();
    }

    public String getQuery() {
        return this.bWm != null ? this.bWm : "";
    }
}
