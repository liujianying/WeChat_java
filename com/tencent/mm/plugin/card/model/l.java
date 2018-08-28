package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;

public final class l extends i<k> {
    public static final String[] diD = new String[]{i.a(k.dhO, "CardQrCodeDataInfo")};
    public e diF;

    public l(e eVar) {
        super(eVar, k.dhO, "CardQrCodeDataInfo", k.ciG);
        this.diF = eVar;
    }

    public final List<k> xo(String str) {
        List<k> arrayList = new ArrayList();
        Cursor rawQuery = this.diF.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{str});
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                k kVar = new k();
                kVar.d(rawQuery);
                arrayList.add(kVar);
            } catch (Exception e) {
                x.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return arrayList;
    }

    public final k xp(String str) {
        k kVar;
        Exception e;
        Cursor rawQuery = this.diF.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    kVar = new k();
                    try {
                        kVar.d(rawQuery);
                        x.i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", new Object[]{str, kVar.field_code_id});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[]{e.getMessage()});
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return kVar;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    }
                    return kVar;
                }
            } catch (Exception e3) {
                e = e3;
                kVar = null;
                x.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[]{e.getMessage()});
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return kVar;
            }
        }
        x.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", new Object[]{str});
        kVar = null;
        if (rawQuery != null) {
            rawQuery.close();
        }
        return kVar;
    }

    public final k xq(String str) {
        k kVar;
        Exception e;
        Cursor rawQuery = this.diF.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=1  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    kVar = new k();
                    try {
                        kVar.d(rawQuery);
                        x.i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", new Object[]{str, kVar.field_code_id});
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e2) {
                        e = e2;
                        try {
                            x.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[]{e.getMessage()});
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return kVar;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    }
                    return kVar;
                }
            } catch (Exception e3) {
                e = e3;
                kVar = null;
                x.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[]{e.getMessage()});
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return kVar;
            }
        }
        x.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", new Object[]{str});
        kVar = null;
        if (rawQuery != null) {
            rawQuery.close();
        }
        return kVar;
    }

    public final boolean ca(String str, String str2) {
        k kVar = new k();
        kVar.field_card_id = str;
        kVar.field_code_id = str2;
        boolean a = a(kVar, new String[]{"card_id", "code_id"});
        if (a) {
            x.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", new Object[]{kVar.field_card_id, kVar.field_code_id});
        } else {
            x.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", new Object[]{kVar.field_card_id, kVar.field_code_id});
        }
        return a;
    }

    public final boolean jy(String str) {
        k kVar = new k();
        kVar.field_card_id = str;
        boolean a = a(kVar, new String[]{"card_id"});
        if (a) {
            x.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", new Object[]{str});
        } else {
            x.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", new Object[]{str});
        }
        return a;
    }
}
