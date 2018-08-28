package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mm.ar.a;
import com.tencent.mm.ar.m;
import com.tencent.mm.ar.n;
import com.tencent.mm.plugin.setting.a.e;
import com.tencent.mm.plugin.setting.a.f;
import com.tencent.mm.plugin.setting.a.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.c;
import com.tencent.mm.ui.r;

class SettingsSelectBgUI$a extends r<m> {
    private Context context;
    private int hJO;
    final /* synthetic */ SettingsSelectBgUI mTS;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        m mVar = (m) obj;
        if (mVar == null) {
            mVar = new m();
        }
        mVar.d(cursor);
        return mVar;
    }

    public SettingsSelectBgUI$a(SettingsSelectBgUI settingsSelectBgUI, Context context, int i) {
        this.mTS = settingsSelectBgUI;
        super(context, new m());
        this.context = context;
        this.hJO = i;
    }

    public final int getCount() {
        return getCursor().getCount() + 2;
    }

    protected final void WS() {
        WT();
    }

    public final void WT() {
        setCursor(com.tencent.mm.ar.r.Qp().dCZ.b("select packageinfo2.localId,packageinfo2.id,packageinfo2.version,packageinfo2.name,packageinfo2.size,packageinfo2.packname,packageinfo2.status,packageinfo2.type,packageinfo2.reserved1,packageinfo2.reserved2,packageinfo2.reserved3,packageinfo2.reserved4 from packageinfo2   where packageinfo2.type=1", null, 0));
        super.notifyDataSetChanged();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = View.inflate(this.context, g.settings_select_bg_view, null);
            view.setLayoutParams(new LayoutParams(this.hJO, this.hJO));
            b bVar2 = new b();
            bVar2.mVy = (LinearLayout) view.findViewById(f.select_bg_downloading_ll);
            bVar2.mVz = (LinearLayout) view.findViewById(f.select_bg_downloaded_ll);
            bVar2.mVA = (LinearLayout) view.findViewById(f.select_bg_undownloaded_ll);
            bVar2.mVB = (LinearLayout) view.findViewById(f.select_bg_using_ll);
            bVar2.mVC = (LinearLayout) view.findViewById(f.select_bg_canceling_ll);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        int a = bi.a((Integer) com.tencent.mm.kernel.g.Ei().DT().get(12311, null), -2);
        a mw = com.tencent.mm.ar.r.Qq().mw(SettingsSelectBgUI.f(this.mTS));
        if (i != 0) {
            if (i != 1) {
                Bitmap Wb;
                m mVar = (m) getItem(i - 2);
                com.tencent.mm.ar.r.Qp();
                if (com.tencent.mm.kernel.g.Ei().isSDCardAvailable()) {
                    Wb = c.Wb(n.Qm() + n.bj(mVar.id, mVar.bPh));
                } else {
                    Wb = BitmapFactory.decodeResource(this.mTS.getResources(), e.nosdcard_chatting_bg_thumb);
                }
                if (Wb != null) {
                    ((ImageView) view.findViewById(f.select_bg_pkg_iv)).setImageBitmap(c.a(Wb, true, 10.0f));
                    switch (mVar.status) {
                        case 1:
                            if (!SettingsSelectBgUI.c(this.mTS) && mw != null && mw.ecv != mVar.id) {
                                bVar.La("downloaded");
                                break;
                            }
                            bVar.La("using");
                            break;
                        case 2:
                            if (!SettingsSelectBgUI.c(this.mTS) && mw != null && mw.ecv == mVar.id) {
                                bVar.La("using");
                                break;
                            }
                            bVar.La("downloaded");
                            break;
                        case 3:
                            bVar.La("downloading");
                            break;
                        case 4:
                            bVar.La("canceling");
                            break;
                        case 5:
                            bVar.La("undownloaded");
                            break;
                    }
                }
            }
            if (!(SettingsSelectBgUI.c(this.mTS) && a == 0) && (!(!SettingsSelectBgUI.c(this.mTS) && a == 0 && mw == null) && (mw == null || mw.ecv != 0))) {
                bVar.La("downloaded");
            } else {
                bVar.La("using");
            }
            ((ImageView) view.findViewById(f.select_bg_pkg_iv)).setImageBitmap(c.a(BitmapFactory.decodeResource(this.context.getResources(), e.chatting_bg_default_thumb), true, 10.0f));
        } else {
            if (!(SettingsSelectBgUI.c(this.mTS) && a == -2) && (!(!SettingsSelectBgUI.c(this.mTS) && a == -2 && mw == null) && (mw == null || mw.ecv != -2))) {
                bVar.La("downloaded");
            } else {
                bVar.La("using");
            }
            ((ImageView) view.findViewById(f.select_bg_pkg_iv)).setImageBitmap(c.a(BitmapFactory.decodeResource(this.context.getResources(), e.chatting_bg_purecolor_thumb), true, 10.0f));
        }
        return view;
    }
}
