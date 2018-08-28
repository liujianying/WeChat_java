package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.tencent.mm.R;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] ksM = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#"};
    private static final String[] ksN = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    private boolean ksL = false;
    private Map<Integer, DialNumberButton> ksO = new HashMap();
    private Map<String, DialNumberButton> ksP = new HashMap();
    private Map<Integer, View> ksQ = new HashMap();
    private a ksR;

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setDialButtonClickListener(a aVar) {
        this.ksR = aVar;
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.i.dial_pad, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.f.ip_call_dial_button_number_textsize);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(R.f.ip_call_dial_button_special_number_textsize2);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(R.f.ip_call_dial_button_special_number_textsize);
        a(R.h.dial_number_button_one, ksM[0], ksN[0], dimensionPixelSize);
        a(R.h.dial_number_button_two, ksM[1], ksN[1], dimensionPixelSize);
        a(R.h.dial_number_button_three, ksM[2], ksN[2], dimensionPixelSize);
        a(R.h.dial_number_button_four, ksM[3], ksN[3], dimensionPixelSize);
        a(R.h.dial_number_button_five, ksM[4], ksN[4], dimensionPixelSize);
        a(R.h.dial_number_button_six, ksM[5], ksN[5], dimensionPixelSize);
        a(R.h.dial_number_button_seven, ksM[6], ksN[6], dimensionPixelSize);
        a(R.h.dial_number_button_eight, ksM[7], ksN[7], dimensionPixelSize);
        a(R.h.dial_number_button_night, ksM[8], ksN[8], dimensionPixelSize);
        a(R.h.dial_number_button_star, ksM[9], ksN[9], dimensionPixelSize3);
        a(R.h.dial_number_button_zero, ksM[10], ksN[10], dimensionPixelSize);
        a(R.h.dial_number_button_sharp, ksM[11], ksN[11], dimensionPixelSize2);
        this.ksQ.put(Integer.valueOf(R.h.divider_one), findViewById(R.h.divider_one));
        this.ksQ.put(Integer.valueOf(R.h.divider_two), findViewById(R.h.divider_two));
        this.ksQ.put(Integer.valueOf(R.h.divider_three), findViewById(R.h.divider_three));
        this.ksQ.put(Integer.valueOf(R.h.divider_four), findViewById(R.h.divider_four));
        this.ksQ.put(Integer.valueOf(R.h.divider_five), findViewById(R.h.divider_five));
        for (View view : this.ksQ.values()) {
            if (this.ksL) {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.talk_ui_divider_color));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.dial_ui_divider_color));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
    }

    private void a(int i, String str, String str2, float f) {
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        if (!bi.oW(str) && str.length() == 1) {
            dialNumberButton.ksJ.setText(str);
        }
        if (!bi.oW(str2) || "1".equals(str)) {
            dialNumberButton.ksK.setText(str2);
            dialNumberButton.ksK.setVisibility(0);
        } else {
            dialNumberButton.ksK.setVisibility(8);
        }
        dialNumberButton.ksJ.setTextSize(0, f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.setInTalkUIMode(this.ksL);
        this.ksO.put(Integer.valueOf(i), dialNumberButton);
        this.ksP.put(str, dialNumberButton);
    }

    public void setTalkUIMode(boolean z) {
        this.ksL = z;
        for (DialNumberButton inTalkUIMode : this.ksO.values()) {
            inTalkUIMode.setInTalkUIMode(z);
        }
        for (View view : this.ksQ.values()) {
            if (this.ksL) {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.talk_ui_divider_color));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.e.dial_ui_divider_color));
            }
        }
    }

    public void onClick(View view) {
        if (this.ksO.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.ksO.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            d aXA = i.aXA();
            int OL = d.OL(numberText);
            if (OL != -1 && d.bMf()) {
                AudioManager audioManager = au.HV().daT;
                if (audioManager == null) {
                    audioManager = (AudioManager) d.mContext.getSystemService("audio");
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (aXA.oTH) {
                        if (aXA.oTI == null) {
                        } else {
                            aXA.oTI.startTone(OL, 250);
                        }
                    }
                }
            }
            if (this.ksR != null) {
                String str;
                a aVar = this.ksR;
                if (bi.oW(numberText)) {
                    str = otherText;
                } else {
                    str = numberText;
                }
                aVar.EU(str);
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!this.ksO.containsKey(Integer.valueOf(view.getId()))) {
            return false;
        }
        DialNumberButton dialNumberButton = (DialNumberButton) this.ksO.get(Integer.valueOf(view.getId()));
        String numberText = dialNumberButton.getNumberText();
        String otherText = dialNumberButton.getOtherText();
        if (this.ksR != null) {
            a aVar = this.ksR;
            if (!bi.oW(numberText)) {
                otherText = numberText;
            }
            aVar.EV(otherText);
        }
        return true;
    }

    public void onViewAdded(View view) {
        x.i("MicroMsg.DialPad", "onViewAdded, class: %s", new Object[]{view.getClass().getSimpleName()});
    }

    public void onViewRemoved(View view) {
        x.i("MicroMsg.DialPad", "onViewRemoved, class: %s", new Object[]{view.getClass().getSimpleName()});
    }
}
