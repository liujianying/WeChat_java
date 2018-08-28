package com.tencent.mm.compatible.e;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public final class l {
    private static l deu = null;
    private boolean det = false;
    private String filePath = "";
    private Map<Integer, Object> values;

    public static synchronized l zh() {
        l lVar;
        synchronized (l.class) {
            if (deu == null) {
                deu = new l(e.duN + "CompatibleInfo.cfg");
            }
            lVar = deu;
        }
        return lVar;
    }

    private l(String str) {
        Throwable e;
        this.filePath = str;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            File file = new File(this.filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            if (file.length() == 0) {
                this.values = new HashMap();
            } else {
                fileInputStream = new FileInputStream(file);
                try {
                    objectInputStream = new ObjectInputStream(fileInputStream);
                    try {
                        this.values = (Map) objectInputStream.readObject();
                        objectInputStream.close();
                        fileInputStream.close();
                        try {
                            fileInputStream.close();
                        } catch (Throwable e2) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2, "", new Object[0]);
                        }
                        try {
                            objectInputStream.close();
                        } catch (Throwable e22) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        try {
                            this.values = new HashMap();
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e222) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222, "", new Object[0]);
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e2222) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                                }
                            }
                            this.det = false;
                        } catch (Throwable th) {
                            e2222 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e4) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e4, "", new Object[0]);
                                }
                            }
                            if (objectInputStream != null) {
                                try {
                                    objectInputStream.close();
                                } catch (Throwable e5) {
                                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e5, "", new Object[0]);
                                }
                            }
                            throw e2222;
                        }
                    }
                } catch (Exception e6) {
                    e2222 = e6;
                    objectInputStream = null;
                    this.values = new HashMap();
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22222) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22222, "", new Object[0]);
                        }
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e222222) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222222, "", new Object[0]);
                        }
                    }
                    this.det = false;
                } catch (Throwable th2) {
                    e222222 = th2;
                    objectInputStream = null;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e42) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e42, "", new Object[0]);
                        }
                    }
                    if (objectInputStream != null) {
                        try {
                            objectInputStream.close();
                        } catch (Throwable e52) {
                            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e52, "", new Object[0]);
                        }
                    }
                    throw e222222;
                }
            }
        } catch (Exception e7) {
            e222222 = e7;
            objectInputStream = null;
            fileInputStream = null;
            this.values = new HashMap();
            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222222, "", new Object[0]);
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222222, "", new Object[0]);
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Throwable e22222222) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22222222, "", new Object[0]);
                }
            }
            this.det = false;
        } catch (Throwable th3) {
            e22222222 = th3;
            objectInputStream = null;
            fileInputStream = null;
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e422, "", new Object[0]);
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (Throwable e522) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e522, "", new Object[0]);
                }
            }
            throw e22222222;
        }
        this.det = false;
    }

    public final synchronized void set(int i, Object obj) {
        this.values.put(Integer.valueOf(i), obj);
        if (!this.det) {
            zi();
        }
    }

    public final Object get(int i) {
        return this.values.get(Integer.valueOf(i));
    }

    public final Object fM(int i) {
        Object obj = this.values.get(Integer.valueOf(i));
        if (obj == null) {
            return null;
        }
        return obj;
    }

    private synchronized void zi() {
        Throwable e;
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
                try {
                    objectOutputStream.writeObject(this.values);
                    objectOutputStream.close();
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2, "", new Object[0]);
                    }
                    try {
                        objectOutputStream.close();
                    } catch (Throwable e22) {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                    }
                } catch (IOException e3) {
                    e22 = e3;
                    try {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22, "", new Object[0]);
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e222) {
                                x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222, "", new Object[0]);
                            }
                        }
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Throwable e2222) {
                                x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                            }
                        }
                        return;
                    } catch (Throwable th) {
                        e2222 = th;
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e4, "", new Object[0]);
                            }
                        }
                        if (objectOutputStream != null) {
                            try {
                                objectOutputStream.close();
                            } catch (Throwable e5) {
                                x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e5, "", new Object[0]);
                            }
                        }
                        throw e2222;
                    }
                }
            } catch (IOException e6) {
                e2222 = e6;
                objectOutputStream = null;
                x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222, "", new Object[0]);
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e22222) {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22222, "", new Object[0]);
                    }
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable e222222) {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222222, "", new Object[0]);
                    }
                }
                return;
            } catch (Throwable th2) {
                e222222 = th2;
                objectOutputStream = null;
                if (fileOutputStream != null) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable e42) {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e42, "", new Object[0]);
                    }
                }
                if (objectOutputStream != null) {
                    try {
                        objectOutputStream.close();
                    } catch (Throwable e52) {
                        x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e52, "", new Object[0]);
                    }
                }
                throw e222222;
            }
        } catch (IOException e7) {
            e222222 = e7;
            objectOutputStream = null;
            fileOutputStream = null;
            x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e222222, "", new Object[0]);
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e2222222) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e2222222, "", new Object[0]);
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Throwable e22222222) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e22222222, "", new Object[0]);
                }
            }
            return;
        } catch (Throwable th3) {
            e22222222 = th3;
            objectOutputStream = null;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (Throwable e422) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e422, "", new Object[0]);
                }
            }
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (Throwable e522) {
                    x.printErrStackTrace("MicroMsg.CompatibleFileStorage", e522, "", new Object[0]);
                }
            }
            throw e22222222;
        }
        return;
    }
}
