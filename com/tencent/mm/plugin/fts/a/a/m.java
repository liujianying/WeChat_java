package com.tencent.mm.plugin.fts.a.a;

import android.database.Cursor;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fts.a.c;
import com.tencent.mm.plugin.fts.a.c.a;
import com.tencent.mm.plugin.wxpay.a$k;
import com.tencent.mm.sdk.platformtools.bi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public final class m extends l {
    public final m i(Cursor cursor) {
        this.jsy = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.jru = cursor.getInt(2);
        this.jsA = cursor.getLong(3);
        this.jrv = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.talker = cursor.getString(6);
        return this;
    }

    public final m j(Cursor cursor) {
        this.jsy = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.jru = cursor.getInt(2);
        this.jsA = cursor.getLong(3);
        this.jrv = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        this.content = cursor.getString(6);
        this.jsC = cursor.getString(7);
        this.jsI = cursor.getLong(8);
        return this;
    }

    public final m k(Cursor cursor) {
        this.jsy = cursor.getLong(0);
        this.type = cursor.getInt(1);
        this.jru = cursor.getInt(2);
        this.jsA = cursor.getLong(3);
        this.jrv = cursor.getString(4);
        this.timestamp = cursor.getLong(5);
        if (cursor.getColumnCount() >= 7) {
            this.content = cursor.getString(6);
        }
        if (cursor.getColumnCount() >= 8) {
            this.jsC = cursor.getString(7);
        }
        return this;
    }

    private void a(Pattern pattern) {
        int i = 0;
        this.jsF = pattern.split(this.content);
        this.jsG = new int[this.jsF.length];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < this.jsG.length) {
                this.jsG[i2] = i3;
                i = (this.jsF[i2].length() + 1) + i3;
                i2++;
            } else {
                return;
            }
        }
    }

    public final void aQc() {
        if (!bi.oW(this.jsC)) {
            switch (this.type) {
                case 131072:
                case 131073:
                case 131074:
                case 131076:
                case 131081:
                case 262144:
                case 327680:
                    switch (this.jru) {
                        case 2:
                        case 3:
                        case 6:
                        case 7:
                            try {
                                String[] split = a.jqz.split(this.jsC);
                                a(a.jqD);
                                this.jsD = Arrays.binarySearch(this.jsG, new String(this.content.getBytes(), 0, Integer.valueOf(split[1]).intValue()).length());
                                if (this.jsD < 0) {
                                    this.jsD = (-this.jsD) - 2;
                                }
                                this.jsE = this.jsF[this.jsD];
                                return;
                            } catch (Exception e) {
                                this.jsD = Integer.MAX_VALUE;
                                this.jsE = "";
                                return;
                            }
                        case 11:
                        case a$k.AppCompatTheme_buttonBarButtonStyle /*51*/:
                            this.jsD = Integer.MAX_VALUE;
                            this.jsE = "";
                            return;
                        default:
                            try {
                                this.jsD = new String(this.content.getBytes(), 0, Integer.valueOf(a.jqz.split(this.jsC)[1]).intValue()).length();
                                this.jsE = this.content;
                                return;
                            } catch (Exception e2) {
                                this.jsD = Integer.MAX_VALUE;
                                this.jsE = "";
                                return;
                            }
                    }
                case 131075:
                    aQd();
                    return;
                default:
                    return;
            }
        }
    }

    private void aQd() {
        switch (this.jru) {
            case a$k.AppCompatTheme_actionModeWebSearchDrawable /*38*/:
                List arrayList = new ArrayList();
                a(a.jqA);
                String[] split = a.jqz.split(this.jsC);
                byte[] bytes = this.content.getBytes();
                for (int i = 0; i < split.length; i += 2) {
                    int intValue = Integer.valueOf(split[i]).intValue();
                    int length = new String(bytes, 0, Integer.valueOf(split[i + 1]).intValue()).length();
                    int binarySearch = Arrays.binarySearch(this.jsG, length);
                    if (binarySearch < 0) {
                        binarySearch = (-binarySearch) - 2;
                    }
                    String str = null;
                    String[] split2 = a.jqB.split(this.jsF[binarySearch]);
                    int i2 = length - this.jsG[binarySearch];
                    length = 0;
                    while (length < split2.length) {
                        i2 = (i2 - split2[length].length()) - 1;
                        if (i2 < 0) {
                            str = split2[length];
                            i2 = c.jqs[length];
                            if (i2 > 0) {
                                arrayList.add(new f(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                            }
                        } else {
                            length++;
                        }
                    }
                    i2 = -1;
                    if (i2 > 0) {
                        arrayList.add(new f(binarySearch, intValue, i2, str, split2[split2.length - 1]));
                    }
                }
                this.jsH = arrayList;
                return;
            default:
                return;
        }
    }

    public final void a(g gVar) {
        if (gVar.jrX.length > 1) {
            this.jsJ = 1;
        } else {
            this.jsJ = 0;
        }
        if (this.type == 131075) {
            if (System.currentTimeMillis() - this.timestamp < 1209600000) {
                this.jrT += 50;
                String GF = q.GF();
                if (this.jru == 38) {
                    HashSet hashSet = new HashSet();
                    if (this.jsH != null) {
                        for (f fVar : this.jsH) {
                            if (!GF.equals(fVar.cCR)) {
                                hashSet.add(Integer.valueOf(fVar.jrP));
                            }
                        }
                    }
                    if (((long) hashSet.size()) >= this.jsA - 1) {
                        this.jrT += 20;
                        this.jsK = true;
                    }
                    if (gVar.jrX.length > 1 && this.content.contains(gVar.jrV)) {
                        this.jsJ = 2;
                        this.jrT += 5;
                    }
                    if (this.jsA <= 15) {
                        this.jsM = 1;
                    }
                }
                if ((this.jru == 5 || this.jru == 1) && this.content.contains(gVar.jrV)) {
                    if (gVar.jrX.length > 1) {
                        this.jsJ = 2;
                    }
                    this.jrT += 10;
                }
            }
        } else if (this.type == 131072) {
            if (System.currentTimeMillis() - this.timestamp < 1105032704) {
                this.jrT += 50;
            }
            if ((this.jru == 5 || this.jru == 1) && this.content.contains(gVar.jrV)) {
                if (gVar.jrX.length > 1) {
                    this.jsJ = 2;
                }
                this.jrT += 10;
            }
        }
    }
}
