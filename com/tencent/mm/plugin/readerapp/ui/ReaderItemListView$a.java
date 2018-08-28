package com.tencent.mm.plugin.readerapp.ui;

import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.model.bi;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.readerapp.a.c;
import com.tencent.mm.plugin.readerapp.a.d;
import com.tencent.mm.plugin.readerapp.a.e;
import com.tencent.mm.plugin.readerapp.a.g;
import com.tencent.mm.pluginsdk.model.q;
import junit.framework.Assert;

class ReaderItemListView$a extends BaseAdapter {
    final /* synthetic */ ReaderItemListView moo;

    ReaderItemListView$a(ReaderItemListView readerItemListView) {
        this.moo = readerItemListView;
    }

    public final int getCount() {
        return ReaderItemListView.a(this.moo).size();
    }

    public final Object getItem(int i) {
        return ReaderItemListView.a(this.moo).get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final int getItemViewType(int i) {
        if (((bi) ReaderItemListView.a(this.moo).get(i)).type == 20) {
            if (i != 0) {
                return 1;
            }
            String Iz = ((bi) ReaderItemListView.a(this.moo).get(i)).Iz();
            String IA = ((bi) ReaderItemListView.a(this.moo).get(i)).IA();
            if (com.tencent.mm.sdk.platformtools.bi.oW(Iz)) {
                if (com.tencent.mm.sdk.platformtools.bi.oW(IA)) {
                    return 1;
                }
                return 2;
            } else if (com.tencent.mm.sdk.platformtools.bi.oW(IA)) {
                return 3;
            } else {
                return 0;
            }
        } else if (i == 0) {
            if (getCount() == 1) {
                return 8;
            }
            return 6;
        } else if (i == getCount() - 1) {
            return 7;
        } else {
            return 5;
        }
    }

    public final int getViewTypeCount() {
        return 9;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        boolean z;
        Bitmap a;
        boolean z2 = true;
        ViewGroup viewGroup2 = null;
        int itemViewType = getItemViewType(i);
        if (view == null) {
            switch (itemViewType) {
                case 0:
                case 3:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_first_item_c, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.hro = (ImageView) view.findViewById(d.reader_first_item_cover_iv);
                    aVar.eVR = (ProgressBar) view.findViewById(d.reader_first_item_cover_pb);
                    view.setTag(aVar);
                    break;
                case 1:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_item, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_item_title_tv);
                    view.setTag(aVar);
                    break;
                case 2:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_first_item_d, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.hrN = (TextView) view.findViewById(d.reader_first_item_digest_tv);
                    view.setTag(aVar);
                    break;
                case 4:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_weibo_first_item_c, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.hro = (ImageView) view.findViewById(d.reader_first_item_cover_iv);
                    aVar.eVR = (ProgressBar) view.findViewById(d.reader_first_item_cover_pb);
                    aVar.gwk = (TextView) view.findViewById(d.reader_first_item_name_tv);
                    aVar.gwj = (ImageView) view.findViewById(d.reader_first_item_icon_iv);
                    aVar.mor = (ProgressBar) view.findViewById(d.reader_first_item_icon_pb);
                    aVar.moc = view.findViewById(d.reader_app_weibo_item_layout);
                    aVar.moc.setBackgroundResource(c.chatting_item_multi_top);
                    view.setTag(aVar);
                    break;
                case 5:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_weibo_item, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.gwk = (TextView) view.findViewById(d.reader_first_item_name_tv);
                    aVar.gwj = (ImageView) view.findViewById(d.reader_first_item_icon_iv);
                    aVar.mor = (ProgressBar) view.findViewById(d.reader_first_item_icon_pb);
                    aVar.moc = view.findViewById(d.reader_app_weibo_item_layout);
                    aVar.moc.setBackgroundResource(c.chatting_item_multi_middle);
                    view.setTag(aVar);
                    break;
                case 6:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_weibo_item_top, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.gwk = (TextView) view.findViewById(d.reader_first_item_name_tv);
                    aVar.gwj = (ImageView) view.findViewById(d.reader_first_item_icon_iv);
                    aVar.mor = (ProgressBar) view.findViewById(d.reader_first_item_icon_pb);
                    aVar.moc = view.findViewById(d.reader_app_weibo_item_layout);
                    aVar.moc.setBackgroundResource(c.chatting_item_multi_top);
                    view.setTag(aVar);
                    break;
                case 7:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_weibo_item_last, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.gwk = (TextView) view.findViewById(d.reader_first_item_name_tv);
                    aVar.gwj = (ImageView) view.findViewById(d.reader_first_item_icon_iv);
                    aVar.mor = (ProgressBar) view.findViewById(d.reader_first_item_icon_pb);
                    aVar.moc = view.findViewById(d.reader_app_weibo_item_layout);
                    aVar.moc.setBackgroundResource(c.chatting_item_multi_bottom);
                    view.setTag(aVar);
                    viewGroup2 = aVar;
                    break;
                case 8:
                    aVar = new a(this);
                    view = ReaderItemListView.b(this.moo).inflate(e.reader_app_weibo_item, null);
                    aVar.eGX = (TextView) view.findViewById(d.reader_first_item_title_tv);
                    aVar.gwk = (TextView) view.findViewById(d.reader_first_item_name_tv);
                    aVar.gwj = (ImageView) view.findViewById(d.reader_first_item_icon_iv);
                    aVar.mor = (ProgressBar) view.findViewById(d.reader_first_item_icon_pb);
                    aVar.moc = view.findViewById(d.reader_app_weibo_item_layout);
                    aVar.moc.setBackgroundResource(c.chatting_item_one_item);
                    view.setTag(aVar);
                    break;
            }
            aVar = viewGroup2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        if (aVar.eGX == null) {
            z2 = false;
        }
        Assert.assertTrue(z2);
        aVar.eGX.setText(((bi) ReaderItemListView.a(this.moo).get(i)).getTitle().trim());
        if (aVar.hrN != null) {
            aVar.hrN.setText(((bi) ReaderItemListView.a(this.moo).get(i)).IA().trim());
        }
        if (aVar.gwk != null) {
            aVar.gwk.setText(((bi) ReaderItemListView.a(this.moo).get(i)).Ix().trim() + this.moo.getContext().getString(g.readerapp_share));
        }
        if (aVar.gwj != null) {
            a = y.a(new q(((bi) ReaderItemListView.a(this.moo).get(i)).Iy(), ((bi) ReaderItemListView.a(this.moo).get(i)).type, "@S"));
            if (a != null) {
                aVar.gwj.setImageBitmap(a);
                aVar.gwj.setVisibility(0);
                aVar.mor.setVisibility(8);
            } else {
                aVar.mor.setVisibility(0);
                aVar.gwj.setVisibility(8);
            }
        }
        if (aVar.hro != null) {
            a = y.a(new q(((bi) ReaderItemListView.a(this.moo).get(i)).Iz(), ((bi) ReaderItemListView.a(this.moo).get(i)).type, "@T"));
            if (a != null) {
                aVar.hro.setImageBitmap(a);
                aVar.hro.setVisibility(0);
                aVar.eVR.setVisibility(8);
            } else {
                aVar.eVR.setVisibility(0);
                aVar.hro.setVisibility(8);
            }
        }
        if (!(aVar.moc == null || ReaderItemListView.c(this.moo) == null)) {
            aVar.moc.setTag(Integer.valueOf(ReaderItemListView.d(this.moo)));
            aVar.moc.setOnLongClickListener(new 1(this));
            aVar.moc.setOnClickListener(new 2(this, i));
        }
        return view;
    }
}
