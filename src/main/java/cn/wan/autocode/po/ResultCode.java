package cn.wan.autocode.po;

/**
 * Created by 万洪基 on 2016/12/24.
 */
public class ResultCode {
    String corecode;
    int page;

    public ResultCode(String corecode, int page) {
        this.corecode = corecode;
        this.page = page;
    }

//    setter and getter

    public String getCorecode() {
        return corecode;
    }

    public void setCorecode(String corecode) {
        this.corecode = corecode;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
