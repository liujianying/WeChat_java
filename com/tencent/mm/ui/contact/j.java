package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.ac.m;
import com.tencent.mm.bg.d;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;

public final class j extends LinearLayout {
    private Context context;
    private String dKF;

    public j(Context context, String str) {
        super(context);
        this.context = context;
        this.dKF = str;
        View inflate = View.inflate(getContext(), R.i.enterprise_biz_item_in_addressui_header, this);
        View findViewById = findViewById(R.h.enterprise_biz_item_ll);
        inflate.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("enterprise_from_scene", 2);
                intent.putExtra("enterprise_biz_name", j.this.dKF);
                d.b(view.getContext(), "brandservice", ".ui.EnterpriseBizContactListUI", intent);
            }
        });
        findViewById.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (j.this.context instanceof MMActivity) {
                    ((MMActivity) j.this.context).YC();
                }
                return false;
            }
        });
        au.HU();
        ab Ye = c.FR().Ye(this.dKF);
        if (Ye == null || ((int) Ye.dhP) <= 0) {
            x.e("MicroMsg.EnterpriseBizViewItem", "contact is null, %s", new Object[]{this.dKF});
            return;
        }
        MaskLayout maskLayout = (MaskLayout) findViewById.findViewById(R.h.biz_contact_entrance_avatar_iv);
        b.a((ImageView) maskLayout.getContentView(), this.dKF);
        if (Ye.field_verifyFlag == 0) {
            maskLayout.setMaskBitmap(null);
        } else if (a.dBt != null) {
            String gY = a.dBt.gY(Ye.field_verifyFlag);
            if (gY != null) {
                maskLayout.f(m.kU(gY), MaskLayout.a.tzk);
            } else {
                maskLayout.setMaskBitmap(null);
            }
        } else {
            maskLayout.setMaskBitmap(null);
        }
        ((TextView) findViewById(R.h.enterprise_biz_title)).setText(Ye.BK());
    }
}
