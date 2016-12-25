package test;

import cn.wan.autocode.po.ResultCode;
import cn.wan.autocode.service.CodeService;
import cn.wan.autocode.service.impl.CodeServiceImpl;
import org.junit.Test;

/**
 * Created by 万洪基 on 2016/12/24.
 */
public class TestAll {

    @Test
    public void testlq() throws Exception {
        CodeService codeService=new CodeServiceImpl();
        ResultCode resultCode=codeService.getCoreCode("Hm_lvt_ffc0a3cbaca7823cf2e81a8611a92d93=1482310978,1482477388,1482557292,1482576434; Hm_lpvt_ffc0a3cbaca7823cf2e81a8611a92d93=1482576434; _ga=GA1.3.1078717816.1482557293; _gat=1; PHPSESSID=60obckr62a5mbkcr9v3ve21kg3; refer=http%3A%2F%2Facm.sdut.edu.cn%2Fonlinejudge2%2Findex.php%2FHome%2FContest%2Fproblemlist%2Fcid%2F1817",
                "http://acm.sdut.edu.cn/onlinejudge2/index.php/Home/Contest/conteststatus/cid/1817/pid/2668/result/1");
        System.out.println(resultCode.getCorecode()+"\n"+resultCode.getPage());
    }

}
