package com.tencent.mm.plugin.sns.ui;

import android.text.TextPaint;
import java.util.ArrayList;
import java.util.HashMap;

class QTextView$a {
    private static HashMap<String, Integer> nQL = new HashMap();
    private String aAL = "";
    private int nQF = 0;
    boolean nQG = false;
    ArrayList<int[]> nQH = new ArrayList();
    float nQI;
    float nQJ;
    float nQK;

    public final int a(String str, String str2, String str3, int i, int i2, TextPaint textPaint) {
        String str4 = str + str2 + str3 + i + i2;
        if (str4.equals(this.aAL)) {
            return this.nQF;
        }
        this.aAL = str4;
        this.nQH.clear();
        this.nQG = false;
        this.nQI = 0.0f;
        this.nQJ = 0.0f;
        this.nQK = 0.0f;
        if (i2 == -1) {
            this.nQH.add(new int[]{null, str.length()});
            this.nQF = (int) (textPaint.measureText(str) + 0.5f);
            return this.nQF;
        }
        if (str2 != null) {
            this.nQJ = textPaint.measureText(str2);
        }
        if (str3 != null) {
            this.nQK = textPaint.measureText(str3);
        }
        int i3 = -1;
        float f = 0.0f;
        Object obj = 1;
        int i4 = 0;
        while (i4 < str.length()) {
            if (i3 == -1) {
                i3 = i4;
            }
            if (this.nQH.size() == i) {
                this.nQG = true;
                break;
            }
            float measureText = textPaint.measureText(str.charAt(i4));
            Object obj2 = null;
            if (str.charAt(i4) == 10) {
                obj2 = 1;
                this.nQH.add(new int[]{i3, i4 - 1});
            } else if (f + measureText >= ((float) i2)) {
                obj2 = 1;
                if (str.charAt(i4) == ' ' || obj == null) {
                    i4--;
                    this.nQH.add(new int[]{i3, i4});
                } else {
                    while (str.charAt(i4) != ' ') {
                        i4--;
                        if (i4 == 0) {
                            break;
                        }
                    }
                    this.nQH.add(new int[]{i3, i4});
                }
            }
            if (obj2 != null) {
                i3 = -1;
                f = 0.0f;
                if (this.nQH.size() == i - 1) {
                    i2 = (int) (((float) i2) - (this.nQJ + this.nQK));
                    obj = null;
                }
            } else {
                f += measureText;
                if (i4 == str.length() - 1) {
                    this.nQH.add(new int[]{i3, i4});
                }
            }
            i4++;
        }
        if (this.nQG) {
            int[] iArr = (int[]) this.nQH.get(this.nQH.size() - 1);
            this.nQI = textPaint.measureText(str.substring(iArr[0], iArr[1] + 1));
        }
        if (this.nQH.size() == 0) {
            this.nQF = 0;
            return this.nQF;
        } else if (this.nQH.size() == 1) {
            this.nQF = (int) (textPaint.measureText(str) + 0.5f);
            return this.nQF;
        } else {
            this.nQF = i2;
            return this.nQF;
        }
    }
}
