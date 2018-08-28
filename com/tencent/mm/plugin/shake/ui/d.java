package com.tencent.mm.plugin.shake.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.shake.b.f;
import com.tencent.mm.plugin.shake.b.g;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.r;
import java.util.GregorianCalendar;

final class d extends r<f> {
    private LayoutInflater Bc;
    private Context mContext;
    int mZJ = 20;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        f fVar = (f) obj;
        if (fVar == null) {
            fVar = new f();
        }
        fVar.d(cursor);
        return fVar;
    }

    public d(Context context) {
        super(context, new f());
        this.mContext = context;
        this.Bc = LayoutInflater.from(context);
    }

    public final void vZ(int i) {
        aYc();
        this.mZJ = i;
        WT();
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        g buD = m.buD();
        setCursor(buD.diF.rawQuery("SELECT * FROM " + buD.getTableName() + " ORDER BY rowid DESC LIMIT " + this.mZJ, null));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.Bc.inflate(R.i.shake_msg_item, viewGroup, false);
            aVar = new a(this);
            aVar.mZK = (MMImageView) view.findViewById(R.h.shake_msg_item_thumb);
            aVar.gsY = (TextView) view.findViewById(R.h.shake_msg_item_title);
            aVar.hVS = (TextView) view.findViewById(R.h.shake_msg_item_desc);
            aVar.kLE = (TextView) view.findViewById(R.h.shake_msg_item_time);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        f fVar = (f) getItem(i);
        e.a(aVar.mZK, fVar.field_thumburl, R.k.app_attach_file_icon_webpage, false);
        if (bi.oW(fVar.field_title)) {
            aVar.gsY.setVisibility(8);
        } else {
            aVar.gsY.setText(j.a(this.mContext, fVar.field_title, aVar.gsY.getTextSize()));
            aVar.gsY.setVisibility(0);
        }
        if (bi.oW(fVar.field_desc)) {
            aVar.hVS.setVisibility(8);
        } else {
            aVar.hVS.setText(j.a(this.mContext, fVar.field_desc, aVar.hVS.getTextSize()));
            aVar.hVS.setVisibility(0);
        }
        TextView textView = aVar.kLE;
        Context context = this.mContext;
        long j = fVar.field_createtime * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            int i2;
            if ((timeInMillis - j) / 3600000 == 0) {
                i2 = (int) ((timeInMillis - j) / 60000);
                if (i2 <= 0) {
                    i2 = 1;
                }
                charSequence = context.getResources().getQuantityString(R.j.fmt_in60min, i2, new Object[]{Integer.valueOf(i2)});
            } else {
                GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
                long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
                if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                    timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                    if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                        i2 = (int) ((timeInMillis - j) / 86400000);
                        if (i2 <= 0) {
                            i2 = 1;
                        }
                        charSequence = context.getResources().getQuantityString(R.j.fmt_indayh, i2, new Object[]{Integer.valueOf(i2)});
                    } else {
                        charSequence = context.getString(R.l.fmt_pre_yesterday);
                    }
                } else {
                    i2 = (int) ((timeInMillis - j) / 3600000);
                    if (i2 <= 0) {
                        i2 = 1;
                    }
                    charSequence = context.getResources().getQuantityString(R.j.fmt_in24h, i2, new Object[]{Integer.valueOf(i2)});
                }
            }
        }
        textView.setText(charSequence);
        return view;
    }
}
