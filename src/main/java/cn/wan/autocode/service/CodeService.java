package cn.wan.autocode.service;

import cn.wan.autocode.po.ResultCode;

/**
 * Created by 万洪基 on 2016/12/24.
 */
public interface CodeService {
    public ResultCode getCoreCode(String cookie, String url) throws Exception;
}
