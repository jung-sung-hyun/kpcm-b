package kp.cmsc.cmsc01.svc;

import java.util.Map;

import kp.cmsc.cmsc01.vo.Cmsc01020000Vo;

public interface Cmsc01020000Svc {
    public Map<String, Object> select00(Cmsc01020000Vo vo) throws Exception;
    public Map<String, Object> delete00(Cmsc01020000Vo vo) throws Exception;

}