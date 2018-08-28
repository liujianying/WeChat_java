package com.tencent.mm.ui.chatting;

import android.content.Context;
import com.tencent.mm.R;
import com.tencent.mm.g.a.th;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.g.a;

public final class g {
    private static int tHF = 1;
    private static int tHG = 2;
    private static int tHH = 3;

    public static a e(a aVar) {
        String GF = q.GF();
        if (aVar.dyl == 2 || aVar.dyl == 3) {
            String[] split;
            if (!bi.cX(aVar.dyp)) {
                for (String split2 : aVar.dyp) {
                    split = split2.split(",");
                    if (split.length == 4 && split[0].equals(GF)) {
                        return new a(bi.getInt(split[1], -1), bi.getInt(split[2], -1), bi.getInt(split[3], -1));
                    }
                }
            }
            if (!bi.cX(aVar.dyr)) {
                for (String split22 : aVar.dyr) {
                    split = split22.split(",");
                    if (split.length == 3 && split[0].equals(GF)) {
                        return new a(bi.getInt(split[2], -1), bi.getLong(split[1], -1));
                    }
                }
            }
        }
        return new a();
    }

    public static int a(a aVar, boolean z) {
        a e = e(aVar);
        switch (aVar.dyl) {
            case 2:
            case 3:
                if (z || e.qYn == 1) {
                    if (e.tHI > 0 && e.tHJ >= 0 && e.tHK >= 0) {
                        switch (e.tHI) {
                            case 1:
                            case 2:
                                return R.k.c2c_aa_icon_default;
                            case 3:
                                return R.k.c2c_aa_icon_check;
                            case 4:
                                return R.k.c2c_aa_icon_close;
                        }
                    }
                } else if (e.qYn != 2) {
                    return R.k.c2c_aa_icon_check;
                } else {
                    if (e.tHI > 0 && e.tHL >= 0) {
                        switch (e.tHI) {
                            case 1:
                                return R.k.c2c_aa_icon_default;
                            case 2:
                            case 3:
                                return R.k.c2c_aa_icon_check;
                            case 4:
                                return R.k.c2c_aa_icon_close;
                        }
                    }
                }
                break;
        }
        return R.k.c2c_aa_icon_check;
    }

    public static String b(a aVar, boolean z) {
        try {
            String GF = q.GF();
            if (aVar.dyl > 0) {
                int i;
                Object obj = null;
                int i2 = -1;
                int i3 = -1;
                int i4 = -1;
                Object obj2 = null;
                long j = -1;
                String str = aVar.dyk;
                th thVar = new th();
                thVar.ceM.ceO = str;
                com.tencent.mm.sdk.b.a.sFg.m(thVar);
                if (aVar.dyl == 2 || aVar.dyl == 3) {
                    String[] split;
                    if (!bi.cX(aVar.dyp)) {
                        for (String str2 : aVar.dyp) {
                            split = str2.split(",");
                            if (split.length == 4 && split[0].equals(GF)) {
                                i2 = bi.getInt(split[1], -1);
                                i3 = bi.getInt(split[2], -1);
                                i4 = bi.getInt(split[3], -1);
                                obj = 1;
                                break;
                            }
                        }
                    }
                    if (!bi.cX(aVar.dyr)) {
                        for (String str22 : aVar.dyr) {
                            split = str22.split(",");
                            if (split.length == 3 && split[0].equals(GF)) {
                                j = bi.getLong(split[1], -1);
                                i = bi.getInt(split[2], -1);
                                obj2 = 1;
                                break;
                            }
                        }
                    }
                }
                i = -1;
                if (thVar.ceN.status == tHH) {
                    return ad.getContext().getString(R.l.aa_msg_receiver_stop_receive);
                }
                if (thVar.ceN.status == tHG) {
                    return ad.getContext().getString(R.l.aa_msg_expired);
                }
                switch (aVar.dyl) {
                    case 1:
                        return z ? aVar.dxX : aVar.dxY;
                    case 2:
                    case 3:
                        if (GF.equals(aVar.dyu) || z || obj != null) {
                            if (i2 > 0 && i3 >= 0 && i4 >= 0) {
                                switch (i2) {
                                    case 1:
                                        return ad.getContext().getString(R.l.aa_msg_receiver_wait_receive);
                                    case 2:
                                        return ad.getContext().getString(R.l.aa_msg_receiver_part_receive, new Object[]{Integer.valueOf(i3 - i4)});
                                    case 3:
                                        return ad.getContext().getString(R.l.aa_msg_receiver_all_receive);
                                    case 4:
                                        return ad.getContext().getString(R.l.aa_msg_receiver_stop_receive);
                                }
                            }
                        } else if (obj2 == null) {
                            return ad.getContext().getString(R.l.aa_msg_payer_not_need_pay);
                        } else {
                            if (i > 0 && j >= 0) {
                                switch (i) {
                                    case 1:
                                        return ad.getContext().getString(R.l.aa_msg_payer_need_pay, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 2:
                                        return ad.getContext().getString(R.l.aa_msg_payer_has_pay, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 3:
                                        return ad.getContext().getString(R.l.aa_msg_payer_refund, new Object[]{Float.valueOf(((float) j) / 100.0f)});
                                    case 4:
                                        return ad.getContext().getString(R.l.aa_msg_payer_not_need_pay);
                                }
                            }
                        }
                        break;
                }
                if (z) {
                    return aVar.dxX;
                }
                return aVar.dxY;
            } else if (z) {
                return aVar.dxX;
            } else {
                return aVar.dxY;
            }
        } catch (Exception e) {
            x.e("MicroMsg.C2CAppMsgUtil", "getC2CDescFromAppMsgContent, error: %s", new Object[]{e.getMessage()});
        }
    }

    public static String a(int i, int i2, boolean z, a aVar) {
        Context context = ad.getContext();
        if (i == 5) {
            return context.getString(R.l.lucky_money_chatting_expired);
        }
        return i == 4 ? z ? context.getString(R.l.lucky_money_chatting_all_received) : context.getString(R.l.lucky_money_chatting_received_receiver) : i == 3 ? i2 == 2 ? z ? aVar.dxX : context.getString(R.l.lucky_money_chatting_received_receiver) : z ? aVar.dxX : aVar.dxY : z ? aVar.dxX : aVar.dxY;
    }

    public static int s(int i, int i2, boolean z) {
        if (i != 5) {
            return i == 4 ? z ? R.g.c2c_chatto_done_bg : R.g.c2c_chatfrom_done_bg : i == 3 ? i2 == 2 ? z ? R.g.c2c_chatto_bg : R.g.c2c_chatfrom_done_bg : z ? R.g.c2c_chatto_bg : R.g.c2c_chatfrom_bg : z ? R.g.c2c_chatto_bg : R.g.c2c_chatfrom_bg;
        } else {
            if (z) {
                return R.g.c2c_chatto_done_bg;
            }
            return R.g.c2c_chatfrom_done_bg;
        }
    }

    public static int t(int i, int i2, boolean z) {
        if (i == 5) {
            return R.g.lucky_money_opened_icon;
        }
        if (i == 4) {
            return R.g.lucky_money_opened_icon;
        }
        if (i != 3) {
            return -1;
        }
        if (i2 == 2) {
            if (z) {
                return -1;
            }
            return R.g.lucky_money_opened_icon;
        } else if (z) {
            return -1;
        } else {
            return R.g.lucky_money_opened_icon;
        }
    }

    public static int c(a aVar, boolean z) {
        if (aVar != null) {
            String str = aVar.dyk;
            th thVar = new th();
            thVar.ceM.ceO = str;
            com.tencent.mm.sdk.b.a.sFg.m(thVar);
            if (thVar.ceN.status == tHH || thVar.ceN.status == tHG) {
                return z ? R.g.aa_chatto_done_bg : R.g.aa_chatfrom_done_bg;
            } else {
                a e = e(aVar);
                switch (aVar.dyl) {
                    case 2:
                    case 3:
                        if (z || e.qYn == 1) {
                            if (e.tHI > 0 && e.tHJ >= 0 && e.tHK >= 0) {
                                switch (e.tHI) {
                                    case 1:
                                    case 2:
                                        return z ? R.g.aa_chatto_bg : R.g.aa_chatfrom_bg;
                                    case 3:
                                    case 4:
                                        return z ? R.g.aa_chatto_done_bg : R.g.aa_chatfrom_done_bg;
                                }
                            }
                        } else if (e.qYn != 2) {
                            return z ? R.g.aa_chatto_bg : R.g.aa_chatfrom_bg;
                        } else {
                            if (e.tHI > 0 && e.tHL >= 0) {
                                switch (e.tHI) {
                                    case 1:
                                        return z ? R.g.aa_chatto_bg : R.g.aa_chatfrom_bg;
                                    case 2:
                                    case 3:
                                    case 4:
                                        return z ? R.g.aa_chatto_done_bg : R.g.aa_chatfrom_done_bg;
                                }
                            }
                        }
                        break;
                }
                if (z) {
                    return R.g.aa_chatto_bg;
                }
                return R.g.aa_chatfrom_bg;
            }
        } else if (z) {
            return R.g.aa_chatto_bg;
        } else {
            return R.g.aa_chatfrom_bg;
        }
    }

    public static int d(a aVar, boolean z) {
        if (aVar == null) {
            return -12479656;
        }
        String str = aVar.dyk;
        th thVar = new th();
        thVar.ceM.ceO = str;
        com.tencent.mm.sdk.b.a.sFg.m(thVar);
        if (thVar.ceN.status == tHH || thVar.ceN.status == tHG) {
            return -8868722;
        }
        a e = e(aVar);
        switch (aVar.dyl) {
            case 2:
            case 3:
                if (z || e.qYn == 1) {
                    if (e.tHI <= 0 || e.tHJ < 0 || e.tHK < 0) {
                        return -12479656;
                    }
                    switch (e.tHI) {
                        case 3:
                        case 4:
                            return -8868722;
                        default:
                            return -12479656;
                    }
                } else if (e.qYn != 2 || e.tHI <= 0 || e.tHL < 0) {
                    return -12479656;
                } else {
                    switch (e.tHI) {
                        case 2:
                        case 3:
                        case 4:
                            return -8868722;
                        default:
                            return -12479656;
                    }
                }
            default:
                return -12479656;
        }
    }
}
