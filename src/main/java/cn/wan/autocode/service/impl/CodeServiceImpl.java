package cn.wan.autocode.service.impl;

import cn.wan.autocode.po.ResultCode;
import cn.wan.autocode.service.CodeService;
import cn.wan.myrep.Const;
import cn.wan.myrep.http.NiceClient;
import cn.wan.myrep.utils.NiceMatch;
import org.apache.http.Consts;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 万洪基 on 2016/12/24.
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {
    public ResultCode getCoreCode(String cookie, String url) throws Exception {
        NiceClient niceClient = new NiceClient();
//        test
        System.out.println("getCoreCode!!");


        niceClient.setCookie(cookie);
        niceClient.setHost("acm.sdut.edu.cn");
        niceClient.setReferer("http://acm.sdut.edu.cn/onlinejudge2/index.php/Home/Contest/problemlist/cid/1821");
        niceClient.setUser_agent("Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 10.0; WOW64; Trident/7.0; .NET4.0C; .NET4.0E)");

        int requestMaxTimes = 100;
        int page = 0;
        String result = "";
        while (requestMaxTimes != 0) {
            result = EntityUtils.toString(niceClient.sendRequest(url, Const.GET).getEntity());
            page++;
            requestMaxTimes--;
            url = getUrlNextOrTarget(result);
            if (url != null) {
                if (url.indexOf("code") != -1) {


                    result = NiceMatch.match(EntityUtils.toString(niceClient.//
                            sendRequest(url.substring(0, url.indexOf("，，")), Const.GET).getEntity(),Consts.UTF_8), "#include[\\s\\S]*\\*/");

//                    test
                    System.out.println(result);

                    break;
                }
            } else {
                page=0;
                break;
            }

        }
        return new ResultCode(result,page);
    }


    /*
         *用来寻找 下一页的url  和  viewcode的url  的方法
         * */
    private String getUrlNextOrTarget(String text) throws Exception {

//        将正则规则进行对象的封装
        Pattern pattern = Pattern.compile("/onlinejudge2/index\\.php/Home/Viewcode/view/sid/\\d*");
//        通过matcher方法和字符串关联。获取对字符串操作的匹配器对象Matcher
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {

            return "http://acm.sdut.edu.cn/" + matcher.group() + "，，";
        } else {
            pattern = Pattern.compile("/onlinejudge2/index\\.php/Contest/conteststatus/cid/\\d*/pid/\\d*/result/1/p/\\d*\\.html\">下一页");
            matcher = pattern.matcher(text);
            if (matcher.find()) {
                pattern = Pattern.compile("/onlinejudge2/index\\.php/Contest/conteststatus/cid/\\d*/pid/\\d*/result/1/p/\\d*\\.html");
                matcher = pattern.matcher(matcher.group());
                matcher.find();
                return "http://acm.sdut.edu.cn/" + matcher.group();

            } else {
//                最后一页的情况
                return null;
            }
        }

    }



//    public String getTreatedCode(String txt){
//
//    }
}
