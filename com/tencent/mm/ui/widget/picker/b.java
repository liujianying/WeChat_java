package com.tencent.mm.ui.widget.picker;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.c;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.Button;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mm.bw.a$f;
import com.tencent.mm.bw.a.g;
import com.tencent.mm.ui.ap;
import java.util.ArrayList;
import java.util.List;

public final class b implements OnGlobalLayoutListener {
    private Button eGn;
    private Button haQ;
    private View ilW;
    private Context mContext;
    private c tYZ;
    private int tZa;
    private BottomSheetBehavior tZb;
    private String[] uLg;
    private ArrayList<List<String>> uLh = null;
    private int uLi;
    private OptionPicker uLj;
    private OptionPicker uLk;
    public a uLl;

    public interface a<T> {
        void h(boolean z, T t);
    }

    static /* synthetic */ void a(b bVar, boolean z, Object obj) {
        if (bVar.uLl != null) {
            bVar.uLl.h(z, obj);
        }
    }

    public b(Context context, String[] strArr) {
        this.mContext = context;
        this.uLg = strArr;
        initView();
    }

    public b(Context context, ArrayList<String> arrayList) {
        this.mContext = context;
        if (arrayList != null) {
            this.uLg = (String[]) arrayList.toArray(new String[arrayList.size()]);
        }
        initView();
    }

    public final void onGlobalLayout() {
    }

    private void initView() {
        this.tYZ = new c(this.mContext);
        this.ilW = View.inflate(this.mContext, g.option_picker_panel, null);
        this.uLj = (OptionPicker) this.ilW.findViewById(a$f.option_picker);
        this.uLj.setOptionsArray(this.uLg);
        this.uLk = (OptionPicker) this.ilW.findViewById(a$f.option_second_picker);
        if (this.uLh != null) {
            this.uLk.setVisibility(0);
            this.uLk.setOptionsArray(GD(this.uLj.getValue()));
            this.uLj.setOnValueChangedListener(new 1(this));
        } else {
            this.uLk.setVisibility(8);
        }
        this.uLi = ap.fromDPToPix(this.mContext, 288);
        this.eGn = (Button) this.ilW.findViewById(a$f.ok_btn);
        this.eGn.setOnClickListener(new 2(this));
        this.haQ = (Button) this.ilW.findViewById(a$f.cancel_btn);
        this.haQ.setOnClickListener(new 3(this));
        this.tYZ.setContentView(this.ilW);
        this.tZa = ap.fromDPToPix(this.mContext, 350);
        this.tZb = BottomSheetBehavior.h((View) this.ilW.getParent());
        if (this.tZb != null) {
            this.tZb.q(this.tZa);
            this.tZb.cv = false;
        }
        this.tYZ.setOnDismissListener(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                b.this.tYZ = null;
            }
        });
    }

    public final void GB(int i) {
        if (i != 0) {
            this.uLi = i;
        }
        LayoutParams layoutParams = (LayoutParams) this.ilW.getLayoutParams();
        layoutParams.height = this.uLi;
        this.ilW.setLayoutParams(layoutParams);
        this.ilW.invalidate();
    }

    public final void show() {
        if (this.tYZ != null) {
            this.tYZ.show();
        }
    }

    public final void hide() {
        if (this.tYZ != null) {
            this.tYZ.dismiss();
        }
    }

    public final int cAP() {
        if (this.uLj != null) {
            return this.uLj.getValue();
        }
        return 0;
    }

    public final void GC(int i) {
        if (this.uLj != null) {
            this.uLj.setValue(i);
        }
    }

    private String[] GD(int i) {
        if (this.uLh != null) {
            ArrayList arrayList = (ArrayList) this.uLh.get(i);
            if (arrayList != null) {
                return (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
        }
        return null;
    }
}
