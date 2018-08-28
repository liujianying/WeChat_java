package com.tencent.mm.r;

import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.by;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public final class c {
    private volatile boolean diA = false;
    public List<Map<String, String>> diB = new CopyOnWriteArrayList();
    volatile boolean diz = false;

    public final synchronized boolean BX() {
        boolean z;
        if (this.diB.size() <= 0) {
            x.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, all process finished");
            z = false;
        } else if (this.diA) {
            x.i("MicroMsg.FunctionMsgFetcher", "processNextNewXml, processing new xml");
            z = false;
        } else {
            this.diA = true;
            Map map = (Map) this.diB.remove(0);
            String str = (String) map.get(".sysmsg.functionmsg.cgi");
            int i = bi.getInt((String) map.get(".sysmsg.functionmsg.cmdid"), 0);
            String str2 = (String) map.get(".sysmsg.functionmsg.functionmsgid");
            long j = bi.getLong((String) map.get(".sysmsg.functionmsg.version"), 0);
            int i2 = bi.getInt((String) map.get(".sysmsg.functionmsg.op"), 0);
            String str3 = (String) map.get(".sysmsg.functionmsg.custombuff");
            x.d("MicroMsg.FunctionMsgFetcher", "processNextNewXml, cgi: %s, cmdId: %s, functionMsgId: %s, version: %s, op: %s, retryInterval: %s, reportId: %s, successKey: %s, failKey: %s, finalKey: %s, customBuff: %s", new Object[]{str, Integer.valueOf(i), str2, Long.valueOf(j), Integer.valueOf(i2), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.retryinterval"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.reportid"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.successkey"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.failkey"), 0)), Integer.valueOf(bi.getInt((String) map.get(".sysmsg.functionmsg.finalfailkey"), 0)), str3});
            d dVar = new d();
            if (!bi.oW(str)) {
                dVar.field_cgi = str;
            }
            dVar.field_cmdid = i;
            if (!bi.oW(str2)) {
                dVar.field_functionmsgid = str2;
            }
            dVar.field_version = j;
            dVar.field_retryinterval = r10;
            dVar.field_reportid = r11;
            dVar.field_successkey = r12;
            dVar.field_failkey = r13;
            dVar.field_finalfailkey = r14;
            if (!bi.oW(str3)) {
                dVar.field_custombuff = str3;
            }
            dVar.field_status = -1;
            dVar.b(null);
            int intValue = Integer.valueOf((String) map.get("FUNCTION_MSG_ADD_MSG_CREATE_TIME_KEY")).intValue();
            d fw = i.Cg().fw(dVar.field_functionmsgid);
            if (fw != null) {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem.status: %s, version: %s, preVersion: %s", new Object[]{Integer.valueOf(fw.field_status), Long.valueOf(fw.field_version), Long.valueOf(fw.field_preVersion)});
            }
            x.d("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgItem: %s", new Object[]{fw});
            String str4;
            Object[] objArr;
            if (i2 == 0) {
                dVar.field_needShow = true;
                if (fw == null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, insert a new one", new Object[]{dVar.field_functionmsgid});
                    i.Cg().b(dVar);
                } else if (fw.field_version < dVar.field_version) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update, update the exist one", new Object[]{dVar.field_functionmsgid});
                    fw.field_preVersion = fw.field_version;
                    dVar.field_preVersion = fw.field_version;
                    i.Cg().a(fw.field_functionmsgid, dVar);
                }
                BZ();
            } else if (i2 == 1) {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, op delete");
                if (fw != null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, newFunctionMsgItem.version: %s, functionMsgItem.version: %s", new Object[]{fw.field_functionmsgid, Long.valueOf(dVar.field_version), Long.valueOf(fw.field_version)});
                    if (dVar.field_version == fw.field_version || dVar.field_version == 0) {
                        if (fw != null) {
                            try {
                                by a = a(fw.field_addMsg);
                                str3 = "MicroMsg.FunctionMsgFetcher";
                                str4 = "callbackToDelete, msgContent==null: %s";
                                objArr = new Object[1];
                                objArr[0] = Boolean.valueOf(a == null);
                                x.d(str3, str4, objArr);
                                if (a != null) {
                                    Map singletonMap = Collections.singletonMap(fw.field_functionmsgid, fw.field_addMsg);
                                    List<f> list = (List) i.Cf().diQ.get(Integer.valueOf(a.jQd));
                                    if (list != null) {
                                        for (f a2 : list) {
                                            a2.a(1, singletonMap, false);
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                x.e("MicroMsg.FunctionMsgFetcher", "callbackToDelete error: %s", new Object[]{e.getMessage()});
                            }
                        }
                        i.Cg().a(fw, new String[0]);
                    }
                } else {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op delete, the origin one not exist", new Object[]{dVar.field_functionmsgid});
                }
                Ca();
            } else if (i2 == 2) {
                dVar.field_needShow = false;
                if (fw == null) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, insert a new one", new Object[]{dVar.field_functionmsgid});
                    i.Cg().b(dVar);
                } else if (fw.field_version < dVar.field_version) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op update but no show, update the exist one, preVersion: %s", new Object[]{dVar.field_functionmsgid, Long.valueOf(fw.field_preVersion)});
                    fw.field_preVersion = fw.field_version;
                    dVar.field_preVersion = fw.field_version;
                    i.Cg().a(fw.field_functionmsgid, dVar);
                }
                BZ();
            } else {
                if (i2 == 3) {
                    x.i("MicroMsg.FunctionMsgFetcher", "fetchInternal, functionMsgId: %s, op show, functionMsgItem: %s", new Object[]{dVar.field_functionmsgid, fw});
                    dVar.field_needShow = true;
                    if (fw != null) {
                        str3 = "MicroMsg.FunctionMsgFetcher";
                        str4 = "fetchInternal, op show, newFunctionMsgItem.version: %s, functionMsgItem.version: %s, functionMsgItem.msgContent == null: %s";
                        objArr = new Object[3];
                        objArr[0] = Long.valueOf(dVar.field_version);
                        objArr[1] = Long.valueOf(fw.field_version);
                        objArr[2] = Boolean.valueOf(fw.field_addMsg == null);
                        x.i(str3, str4, objArr);
                        if (fw.field_version >= dVar.field_version || dVar.field_version == 0) {
                            fw.field_needShow = true;
                            if (fw.field_addMsg != null) {
                                x.i("MicroMsg.FunctionMsgFetcher", "show, update create time to: %s", new Object[]{Integer.valueOf(intValue)});
                                fw.field_addMsg.lOH = intValue;
                            }
                            i.Cg().a(fw.field_functionmsgid, fw);
                            if (fw.field_addMsg != null) {
                                b(Collections.singletonList(fw), true);
                            }
                        }
                    }
                }
                Ca();
            }
            z = true;
        }
        return z;
    }

    private static by a(by byVar) {
        boolean z = true;
        if (byVar == null) {
            return null;
        }
        String str = "MicroMsg.FunctionMsgFetcher";
        String str2 = "processAddMsg, fromUser: %s, msgType: %s, content==null: %s";
        Object[] objArr = new Object[3];
        objArr[0] = byVar.rcj;
        objArr[1] = Integer.valueOf(byVar.jQd);
        if (byVar.rcl != null) {
            z = false;
        }
        objArr[2] = Boolean.valueOf(z);
        x.i(str, str2, objArr);
        String oV = bi.oV(ab.a(byVar.rcj));
        if ("readerapp".equals(oV)) {
            byVar.rcj = ab.oT("newsapp");
            byVar.jQd = 12399999;
        }
        if (!"blogapp".equals(oV) && !"newsapp".equals(oV)) {
            return byVar;
        }
        byVar.jQd = 12399999;
        return byVar;
    }

    public final synchronized boolean BY() {
        return this.diz;
    }

    public final synchronized void BZ() {
        if (this.diz) {
            x.l("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, isFetching, ignore this", new Object[0]);
            Ca();
        } else if (ao.isNetworkConnected(ad.getContext())) {
            this.diz = true;
            List Cb = i.Cg().Cb();
            x.d("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItems: %s", new Object[]{Cb});
            if (Cb == null || Cb.size() <= 0) {
                this.diz = false;
                Ca();
            } else {
                x.i("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed, fetchItem.size: %s", new Object[]{Integer.valueOf(Cb.size())});
                new b(Cb, new 1(this)).start();
            }
        } else {
            x.l("MicroMsg.FunctionMsgFetcher", "fetchAllIfNeed network not connected, ignore this", new Object[0]);
            Ca();
        }
    }

    final void Ca() {
        x.l("MicroMsg.FunctionMsgFetcher", "loopToNextNewXml", new Object[0]);
        this.diA = false;
        BX();
    }

    static void b(List<d> list, boolean z) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    Collection arrayList = new ArrayList();
                    for (d dVar : list) {
                        if (dVar.field_needShow) {
                            dVar.b(a(dVar.field_addMsg));
                            arrayList.add(dVar);
                        }
                    }
                    x.d("MicroMsg.FunctionMsgFetcher", "callbackToUpdate, msgList.size: %s, isShow: %s", new Object[]{Integer.valueOf(arrayList.size()), Boolean.valueOf(z)});
                    Map c = c(arrayList);
                    for (Integer intValue : c.keySet()) {
                        int intValue2 = intValue.intValue();
                        List<d> list2 = (List) c.get(Integer.valueOf(intValue2));
                        Map hashMap = new HashMap();
                        for (d dVar2 : list2) {
                            hashMap.put(dVar2.field_functionmsgid, dVar2.field_addMsg);
                        }
                        List<f> list3 = (List) i.Cf().diQ.get(Integer.valueOf(intValue2));
                        if (list3 != null) {
                            for (f a : list3) {
                                a.a(0, hashMap, z);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                x.e("MicroMsg.FunctionMsgFetcher", "callbackToUpdate error: %s", new Object[]{e.getMessage()});
            }
        }
    }

    private static Map<Integer, List<d>> c(Collection<d> collection) {
        Map<Integer, List<d>> hashMap = new HashMap();
        for (d dVar : collection) {
            if (dVar.field_addMsg != null) {
                List list = (List) hashMap.get(Integer.valueOf(dVar.field_addMsg.jQd));
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(dVar);
                hashMap.put(Integer.valueOf(dVar.field_addMsg.jQd), list);
            }
        }
        return hashMap;
    }
}
