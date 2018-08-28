package com.tencent.mm.bi;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.tencent.mm.bd.a.d;
import com.tencent.mm.bd.a.e;
import com.tencent.mm.bd.a.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.view.footer.SelectColorBar;
import com.tencent.mm.x.a;

class a$a implements a {
    final /* synthetic */ a qVu;
    View qVx = this.qVu.qVl.getRubbishView();
    TextView qVy = ((TextView) this.qVx.findViewById(e.rubbish_tip));
    ImageView qVz = ((ImageView) this.qVx.findViewById(e.rubbish_icon));

    a$a(a aVar) {
        this.qVu = aVar;
    }

    public final void W(float f) {
        x.i("MicroMsg.DrawingPresenter", "[onReach] distance:%s", new Object[]{Float.valueOf(f)});
        this.qVy.setText(this.qVu.qVl.getContext().getString(h.rubbish_reached_tip));
        this.qVz.setImageResource(d.rubbish_red);
    }

    public final void Fj() {
        x.i("MicroMsg.DrawingPresenter", "[onUnReach]");
        this.qVz.setImageResource(d.rubbish_normal);
        this.qVy.setText(this.qVu.qVl.getContext().getString(h.rubbish_unreached_tip));
    }

    public final void onShow() {
        a.a(this.qVu, true);
    }

    public final void onHide() {
        a.a(this.qVu, false);
    }

    public final void a(com.tencent.mm.t.e eVar) {
        EditText editText = (EditText) this.qVu.qVl.getTextEditView().findViewById(e.text_edit);
        editText.setText(eVar.doj);
        Switch switchR = (Switch) this.qVu.qVl.findViewById(e.bg_switch);
        SelectColorBar selectColorBar = (SelectColorBar) this.qVu.qVl.findViewById(e.select_color_bar);
        switchR.setChecked(eVar.doi != 0);
        if (switchR.isChecked()) {
            selectColorBar.setSelectColor(eVar.doi);
        } else {
            selectColorBar.setSelectColor(eVar.pN);
        }
        editText.setTextColor(eVar.pN);
        editText.setTag(eVar);
        this.qVu.kW(true);
    }
}
