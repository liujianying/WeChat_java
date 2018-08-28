package com.tencent.mm.ui.base;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.tencent.mm.bp.a;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;

class VoiceSearchEditText$1 implements OnTouchListener {
    final /* synthetic */ VoiceSearchEditText tBv;

    VoiceSearchEditText$1(VoiceSearchEditText voiceSearchEditText) {
        this.tBv = voiceSearchEditText;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        VoiceSearchEditText voiceSearchEditText = this.tBv;
        if (voiceSearchEditText.getCompoundDrawables()[2] == null) {
            return false;
        }
        if (motionEvent.getAction() != 1) {
            return true;
        }
        VoiceSearchEditText.a(this.tBv, true);
        if (VoiceSearchEditText.a(this.tBv) && VoiceSearchEditText.b(this.tBv) && voiceSearchEditText.getText().toString().equals("")) {
            if (motionEvent.getX() <= ((float) (((voiceSearchEditText.getWidth() - voiceSearchEditText.getPaddingRight()) - this.tBv.tBo.getIntrinsicWidth()) - a.fromDPToPix(VoiceSearchEditText.c(voiceSearchEditText), 25)))) {
                voiceSearchEditText.requestFocus();
                if (this.tBv.getContext() instanceof Activity) {
                    MMActivity.showVKB((Activity) this.tBv.getContext());
                }
                if (VoiceSearchEditText.d(this.tBv) != null) {
                    VoiceSearchEditText.d(this.tBv).onClick(null);
                }
            } else if (VoiceSearchEditText.d(this.tBv) != null) {
                x.i("MicroMsg.VoiceSearchEditText", "user clicked voice button");
                if (this.tBv.getContext() instanceof MMActivity) {
                    ((MMActivity) this.tBv.getContext()).hideVKB(voiceSearchEditText);
                }
                VoiceSearchEditText.d(this.tBv).onClick(this.tBv);
                return true;
            }
        } else if (voiceSearchEditText.getText().toString().length() > 0) {
            if (motionEvent.getX() > ((float) (((voiceSearchEditText.getWidth() - voiceSearchEditText.getPaddingRight()) - this.tBv.tBq.getIntrinsicWidth()) - a.fromDPToPix(VoiceSearchEditText.c(voiceSearchEditText), 25)))) {
                voiceSearchEditText.setText("");
                VoiceSearchEditText.e(this.tBv);
            } else if (!voiceSearchEditText.isFocused()) {
                voiceSearchEditText.requestFocus();
                if (this.tBv.getContext() instanceof Activity) {
                    MMActivity.showVKB((Activity) this.tBv.getContext());
                }
            }
        } else if (VoiceSearchEditText.d(this.tBv) != null) {
            VoiceSearchEditText.d(this.tBv).onClick(null);
        }
        return false;
    }
}
