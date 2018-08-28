package com.tencent.mm.storage;

import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class w {
    private boolean det = false;
    private String filePath = "";
    public boolean sOk = false;
    public boolean sOl = false;
    private Map<Integer, Object> values;

    public w(String str) {
        if (!new File(str).exists()) {
            x.e("MicroMsg.ConfigFileStorage", "ConfigFileStorage not exit path[%s]", str);
        }
        this.filePath = str;
        ckS();
        this.det = false;
    }

    public final synchronized void set(int i, Object obj) {
        this.values.put(Integer.valueOf(i), obj);
        if (!this.det) {
            zi();
        }
    }

    public final synchronized Object get(int i) {
        return this.values.get(Integer.valueOf(i));
    }

    public final synchronized Object get(int i, Object obj) {
        Object obj2 = this.values.get(Integer.valueOf(i));
        if (obj2 != null) {
            obj = obj2;
        }
        return obj;
    }

    public final synchronized void chA() {
        this.det = true;
    }

    public final synchronized void ckR() {
        this.det = false;
        zi();
    }

    private synchronized void ckS() {
        Throwable e;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                boolean createNewFile = file.createNewFile();
                x.w("MicroMsg.ConfigFileStorage", "ConfigFileStorage openCfg not exit path[%s], created[%b]", this.filePath, Boolean.valueOf(createNewFile));
            }
            if (file.length() == 0) {
                this.values = new HashMap();
                x.w("MicroMsg.ConfigFileStorage", "ConfigFileStorage openCfg file len == 0 path[%s]", this.filePath);
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        this.values = (Map) objectInputStream.readObject();
                        x.i("MicroMsg.ConfigFileStorage", "openCfg end, keys count:%d", Integer.valueOf(this.values.size()));
                        this.sOk = false;
                        try {
                            objectInputStream.close();
                            fileInputStream.close();
                        } catch (Exception e2) {
                        }
                    } catch (Exception e3) {
                        e = e3;
                        try {
                            this.values = new HashMap();
                            x.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                            this.sOk = true;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Exception e4) {
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            return;
                        } catch (Throwable th) {
                            e = th;
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Exception e5) {
                                    throw e;
                                }
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            throw e;
                        }
                    }
                } catch (Exception e6) {
                    e = e6;
                    objectInputStream = null;
                    this.values = new HashMap();
                    x.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
                    this.sOk = true;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e42) {
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return;
                } catch (Throwable th2) {
                    e = th2;
                    objectInputStream = null;
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Exception e52) {
                            throw e;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e;
                }
            }
        } catch (Exception e7) {
            e = e7;
            objectInputStream = null;
            fileInputStream = null;
            this.values = new HashMap();
            x.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "openCfg Exception!", new Object[0]);
            this.sOk = true;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception e422) {
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return;
        } catch (Throwable th3) {
            e = th3;
            objectInputStream = null;
            fileInputStream = null;
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Exception e522) {
                    throw e;
                }
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e;
        }
        return;
    }

    private synchronized void zi() {
        ObjectOutputStream objectOutputStream;
        Throwable e;
        FileOutputStream fileOutputStream;
        try {
            long VF = bi.VF();
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            } catch (IOException e2) {
                e = e2;
                objectOutputStream = null;
                try {
                    x.e("MicroMsg.ConfigFileStorage", "exception:%s", bi.i(e));
                    x.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                    this.sOl = true;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    return;
                } catch (Throwable th) {
                    e = th;
                    if (objectOutputStream != null) {
                        try {
                            objectOutputStream.close();
                        } catch (Exception e4) {
                            throw e;
                        }
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e;
                }
            } catch (Throwable th2) {
                e = th2;
                objectOutputStream = null;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e42) {
                        throw e;
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e;
            }
            try {
                objectOutputStream.writeObject(this.values);
                fileOutputStream.flush();
                this.sOl = false;
                x.d("MicroMsg.ConfigFileStorage", "writeCfg end, keys count:%d time:%d", Integer.valueOf(this.values.keySet().toArray().length), Long.valueOf(bi.bH(VF)));
                try {
                    objectOutputStream.close();
                    fileOutputStream.close();
                } catch (Exception e5) {
                }
            } catch (IOException e6) {
                e = e6;
                x.e("MicroMsg.ConfigFileStorage", "exception:%s", bi.i(e));
                x.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
                this.sOl = true;
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Exception e32) {
                    }
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                return;
            }
        } catch (IOException e7) {
            e = e7;
            objectOutputStream = null;
            fileOutputStream = null;
            x.e("MicroMsg.ConfigFileStorage", "exception:%s", bi.i(e));
            x.printErrStackTrace("MicroMsg.ConfigFileStorage", e, "writeCfg", new Object[0]);
            this.sOl = true;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e322) {
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            return;
        } catch (Throwable th3) {
            e = th3;
            objectOutputStream = null;
            fileOutputStream = null;
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Exception e422) {
                    throw e;
                }
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e;
        }
        return;
    }

    public final synchronized void reset() {
        x.i("MicroMsg.ConfigFileStorage", "ConfigFileStorage reset ");
        File file = new File(this.filePath);
        if (file.exists()) {
            file.delete();
        }
        this.values = new HashMap();
    }

    public final synchronized void setInt(int i, int i2) {
        set(i, Integer.valueOf(i2));
    }

    public final synchronized int Di(int i) {
        Integer num;
        num = (Integer) get(i);
        return num == null ? 0 : num.intValue();
    }

    public final synchronized void setLong(int i, long j) {
        set(i, Long.valueOf(j));
    }

    public synchronized long getLong(int i, long j) {
        Long l = (Long) get(i);
        if (l != null) {
            j = l.longValue();
        }
        return j;
    }
}
