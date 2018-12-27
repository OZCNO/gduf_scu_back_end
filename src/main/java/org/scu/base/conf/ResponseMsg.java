package org.scu.base.conf;

/**
 * Created by Lamm on 2018/12/19
 */
public class ResponseMsg {

    public static final String SUCCESS = "执行成功";

    public static final String ERROR = "服务器繁忙，请重试";

    public static final String FAIL = "执行失败";

    public static final String NOT_FOUND = "找不到指定的数据";

    public static final String FORBIDDEN = "无权进行此操作";

    public static class Query {

        public static final String SUCCESS = "查询成功";
    }

    public static class Delete {

        public static final String SUCCESS = "删除成功";
    }

    public static class Update {

        public static final String SUCCESS = "更新成功";
    }

    public static class Add {

        public static final String SUCCESS = "添加成功";
    }
}
